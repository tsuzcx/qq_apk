package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.ak.j
{
  boolean dLD;
  boolean ifz;
  Object lock;
  boolean oKz;
  e.d oRA;
  private com.tencent.mm.ak.i oRB;
  boolean oRC;
  int oRG;
  HashSet<String> oRz;
  List<t> oSa;
  List<t> oSb;
  int oSc;
  public boolean oSd;
  long oSe;
  long oSf;
  int oSg;
  
  public f()
  {
    AppMethodBeat.i(21925);
    this.lock = new Object();
    this.dLD = false;
    this.ifz = false;
    this.oRz = new HashSet();
    this.oRC = false;
    this.oSc = 0;
    this.oSd = false;
    this.oKz = false;
    this.oRG = 0;
    AppMethodBeat.o(21925);
  }
  
  public static int ca(List<t> paramList)
  {
    AppMethodBeat.i(21930);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = s.aW(com.tencent.mm.plugin.backup.bakoldlogic.a.a.cgW() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.agK(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((it)new it().parseFrom((byte[])localObject)).oTA.size();
        i = j + i;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.RecoverPCServer", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(21930);
    return i;
  }
  
  final int a(String arg1, HashMap<String, Integer> paramHashMap, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c paramc, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(21932);
    long l2 = System.currentTimeMillis();
    byte[] arrayOfByte = s.aW(???, 0, -1);
    it localit;
    is localis;
    int i;
    try
    {
      localit = (it)new it().parseFrom(arrayOfByte);
      Iterator localIterator = localit.oTA.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localis = (is)localIterator.next();
      if ((this.dLD) && (!this.ifz)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().azQ().get(2, null);
        locali = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aSQ();
        localObject1 = localis.KHl.MTo;
        ??? = localis.KHm.MTo;
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(???))) {
          break label385;
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label1027;
        }
        localObject2 = "null";
      }
      catch (Exception ???)
      {
        for (;;)
        {
          Log.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + ???.toString());
          Log.printErrStackTrace("MicroMsg.RecoverPCServer", ???, "", new Object[0]);
        }
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).oQB;
        localbv = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aSN();
        if (((l)localObject2).has((String)localObject1)) {
          break label1042;
        }
      }
    }
    catch (Exception paramHashMap)
    {
      synchronized (this.lock)
      {
        try
        {
          this.lock.wait();
          if (this.ifz)
          {
            Log.i("MicroMsg.RecoverPCServer", "backupImp canceled");
            AppMethodBeat.o(21932);
            return -1;
            paramHashMap = paramHashMap;
            if (arrayOfByte == null) {}
            for (i = 0;; i = arrayOfByte.length)
            {
              Log.e("MicroMsg.RecoverPCServer", "read mmPath errr %s, %s, len:%d", new Object[] { ???, paramHashMap, Integer.valueOf(i) });
              Log.printErrStackTrace("MicroMsg.RecoverPCServer", paramHashMap, "", new Object[0]);
              AppMethodBeat.o(21932);
              return 0;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.RecoverPCServer", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    String str;
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali;
    Object localObject1;
    Object localObject2;
    Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", new Object[] { localObject2, localObject1 });
    for (;;)
    {
      label317:
      this.oRG += 1;
      if (this.oRG % 100 == 0) {
        chr();
      }
      com.tencent.mm.plugin.backup.c.e.Bd(localis.oUv);
      long l1 = Util.nowMilliSecond();
      if (l1 - paramc.hwQ <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.hwQ = l1;
      break;
      label385:
      Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localis.oUv), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
      {
        ??? = new com.tencent.mm.model.b();
        AppMethodBeat.o(21932);
        throw ???;
      }
      bv localbv;
      if (!str.equals(localObject1)) {
        break label1056;
      }
      break label1042;
      label534:
      if (localis.KMW != 0L) {}
      for (l1 = localis.KMW;; l1 = localis.KMO * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.cfd();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localis.Brn == 0L) && (localis.Brl != 0)) {
        localis.Brn = localis.Brl;
      }
      if (localis.Brn != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = locali.aJ(???, localis.Brn);
        if (???.field_msgId != 0L) {
          Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localis.Brn != 0L) {
        ???.yF(localis.Brn);
      }
      ???.yH(localis.KMV);
      ???.setCreateTime(l1);
      ???.setFlag(localis.KMX);
      ???.setType(localis.oUv);
      localObject1 = localbv.Kn((String)localObject2);
      if ((localObject1 == null) || (Util.isNullOrNil(((ax)localObject1).field_username)) || (!((as)localObject1).gBM())) {
        break label1075;
      }
      Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.nv(j);
    ???.Cy((String)localObject2);
    if (i != 0) {}
    for (int j = localis.KMN;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localis.KMN == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(Util.nullAs((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.cgY().Bt(localis.oUv);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((com.tencent.mm.plugin.backup.bakoldlogic.b.j)localObject1).a(str, localis, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.cfo();
      Log.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localit.oTA.size();
      AppMethodBeat.o(21932);
      return i;
      label1027:
      localObject1 = ???;
      if (??? != null) {
        break;
      }
      localObject1 = "null";
      break;
      label1042:
      label1056:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1062;
        }
        localObject2 = ???;
        break;
      }
      label1062:
      localObject2 = localObject1;
      break label534;
      label1069:
      ??? = (String)localObject1;
      break label688;
      label1075:
      if (i != 0)
      {
        j = 1;
        break label843;
      }
      j = 0;
      break label843;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, q paramq)
  {
    AppMethodBeat.i(21934);
    this.oSf += paramInt1;
    if (this.oSe == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.oSf * 100L / this.oSe))
    {
      if (paramInt1 > this.oSg)
      {
        this.oSg = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.oSg);
      }
      if ((this.dLD) || (this.ifz) || (this.oRA == null) || (this.oSg < 0) || (this.oSg > 100)) {
        break;
      }
      this.oRA.By(this.oSg);
      AppMethodBeat.o(21934);
      return;
    }
    Log.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.oSg) });
    AppMethodBeat.o(21934);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21928);
    Log.i("MicroMsg.RecoverPCServer", "cancel");
    this.ifz = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.oRB);
      this.oRA = null;
      this.oSd = false;
      this.oKz = false;
      this.oSc = 0;
      this.oSg = 0;
      AppMethodBeat.o(21928);
      return;
    }
  }
  
  final void chq()
  {
    AppMethodBeat.i(21929);
    if ((!this.oRC) || (this.ifz))
    {
      AppMethodBeat.o(21929);
      return;
    }
    synchronized (this.lock)
    {
      if (this.oRz.isEmpty())
      {
        if (this.ifz)
        {
          AppMethodBeat.o(21929);
          return;
        }
        this.oSd = true;
        this.oSg = 0;
        a.cgZ().cha().oRS = 6;
        a.cgZ().cha().oRT = 5;
        if (this.oRA != null)
        {
          this.oRA.chn();
          com.tencent.mm.plugin.backup.g.b.b(7, this.oRB);
          eT(0, 0);
          e.chl();
          Log.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
        }
      }
      else
      {
        AppMethodBeat.o(21929);
        return;
      }
      Log.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
    }
  }
  
  public final void chr()
  {
    AppMethodBeat.i(21933);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    Log.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.oRG) });
    AppMethodBeat.o(21933);
  }
  
  final void eT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21931);
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.oSc)) {
        break;
      }
      AppMethodBeat.o(21931);
      return;
    }
    this.oSc = i;
    if ((!this.dLD) && (!this.ifz) && (this.oRA != null) && (this.oSc >= 0) && (this.oSc <= 100)) {
      this.oRA.Bz(this.oSc);
    }
    ab localab = new ab();
    localab.oTl = 13;
    localab.oUK = 0;
    localab.oUL = this.oSc;
    try
    {
      Log.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.N(localab.toByteArray(), 3);
      AppMethodBeat.o(21931);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.RecoverPCServer", localIOException, "", new Object[0]);
      Log.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
      AppMethodBeat.o(21931);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(21926);
    Log.i("MicroMsg.RecoverPCServer", "pause");
    this.dLD = true;
    AppMethodBeat.o(21926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21927);
    Log.i("MicroMsg.RecoverPCServer", "resume");
    this.dLD = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(21927);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f
 * JD-Core Version:    0.7.0.1
 */