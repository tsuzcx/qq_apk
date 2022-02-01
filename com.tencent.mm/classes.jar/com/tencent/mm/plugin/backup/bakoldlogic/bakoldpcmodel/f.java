package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.am.i
{
  boolean hJi;
  Object lock;
  List<t> nZr;
  boolean nzW;
  boolean uXC;
  HashSet<String> veO;
  e.d veP;
  private com.tencent.mm.am.h veQ;
  boolean veR;
  int veV;
  List<t> vfp;
  int vfq;
  public boolean vfr;
  long vfs;
  long vft;
  int vfu;
  
  public f()
  {
    AppMethodBeat.i(21925);
    this.lock = new Object();
    this.hJi = false;
    this.nzW = false;
    this.veO = new HashSet();
    this.veR = false;
    this.vfq = 0;
    this.vfr = false;
    this.uXC = false;
    this.veV = 0;
    AppMethodBeat.o(21925);
  }
  
  public static int dO(List<t> paramList)
  {
    AppMethodBeat.i(21930);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = y.bi(com.tencent.mm.plugin.backup.bakoldlogic.a.a.cWR() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.ahL(((t)localObject).vgy) + ((t)localObject).vgy, 0, -1);
        int j = ((je)new je().parseFrom((byte[])localObject)).vgO.size();
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
    byte[] arrayOfByte = y.bi(???, 0, -1);
    je localje;
    jd localjd;
    int i;
    try
    {
      localje = (je)new je().parseFrom(arrayOfByte);
      Iterator localIterator = localje.vgO.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localjd = (jd)localIterator.next();
      if ((this.hJi) && (!this.nzW)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().ban().d(2, null);
        locali = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().bzD();
        localObject1 = localjd.YFE.abwM;
        ??? = localjd.YFF.abwM;
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
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).vdN;
        localbx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs().bzA();
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
          if (this.nzW)
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
      this.veV += 1;
      if (this.veV % 100 == 0) {
        cXm();
      }
      com.tencent.mm.plugin.backup.c.e.Ff(localjd.vhJ);
      long l1 = Util.nowMilliSecond();
      if (l1 - paramc.mJI <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.mJI = l1;
      break;
      label385:
      Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localjd.vhJ), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cXr().cXs();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
      {
        ??? = new com.tencent.mm.model.b();
        AppMethodBeat.o(21932);
        throw ???;
      }
      bx localbx;
      if (!str.equals(localObject1)) {
        break label1056;
      }
      break label1042;
      label534:
      if (localjd.YLe != 0L) {}
      for (l1 = localjd.YLe;; l1 = localjd.YKW * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.cVa();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localjd.Njv == 0L) && (localjd.Njs != 0)) {
        localjd.Njv = localjd.Njs;
      }
      if (localjd.Njv != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = locali.aU(???, localjd.Njv);
        if (???.field_msgId != 0L) {
          Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localjd.Njv != 0L) {
        ???.gX(localjd.Njv);
      }
      ???.gZ(localjd.YLd);
      ???.setCreateTime(l1);
      ???.setFlag(localjd.YLf);
      ???.setType(localjd.vhJ);
      localObject1 = localbx.JE((String)localObject2);
      if ((localObject1 == null) || (Util.isNullOrNil(((az)localObject1).field_username)) || (!((au)localObject1).iZC())) {
        break label1075;
      }
      Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.pI(j);
    ???.BS((String)localObject2);
    if (i != 0) {}
    for (int j = localjd.YKV;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localjd.YKV == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(Util.nullAs((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.cWT().Fv(localjd.vhJ);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((j)localObject1).a(str, localjd, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.cVl();
      Log.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localje.vgO.size();
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
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(21934);
    this.vft += paramInt1;
    if (this.vfs == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.vft * 100L / this.vfs))
    {
      if (paramInt1 > this.vfu)
      {
        this.vfu = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.vfu);
      }
      if ((this.hJi) || (this.nzW) || (this.veP == null) || (this.vfu < 0) || (this.vfu > 100)) {
        break;
      }
      this.veP.FA(this.vfu);
      AppMethodBeat.o(21934);
      return;
    }
    Log.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.vfu) });
    AppMethodBeat.o(21934);
  }
  
  final void cXl()
  {
    AppMethodBeat.i(21929);
    if ((!this.veR) || (this.nzW))
    {
      AppMethodBeat.o(21929);
      return;
    }
    synchronized (this.lock)
    {
      if (this.veO.isEmpty())
      {
        if (this.nzW)
        {
          AppMethodBeat.o(21929);
          return;
        }
        this.vfr = true;
        this.vfu = 0;
        a.cWU().cWV().vfh = 6;
        a.cWU().cWV().vfi = 5;
        if (this.veP != null)
        {
          this.veP.cXi();
          com.tencent.mm.plugin.backup.g.b.b(7, this.veQ);
          gl(0, 0);
          e.cXg();
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
  
  public final void cXm()
  {
    AppMethodBeat.i(21933);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    Log.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.veV) });
    AppMethodBeat.o(21933);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21928);
    Log.i("MicroMsg.RecoverPCServer", "cancel");
    this.nzW = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.veQ);
      this.veP = null;
      this.vfr = false;
      this.uXC = false;
      this.vfq = 0;
      this.vfu = 0;
      AppMethodBeat.o(21928);
      return;
    }
  }
  
  final void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21931);
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.vfq)) {
        break;
      }
      AppMethodBeat.o(21931);
      return;
    }
    this.vfq = i;
    if ((!this.hJi) && (!this.nzW) && (this.veP != null) && (this.vfq >= 0) && (this.vfq <= 100)) {
      this.veP.FB(this.vfq);
    }
    ab localab = new ab();
    localab.vgz = 13;
    localab.vhY = 0;
    localab.vhZ = this.vfq;
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
    this.hJi = true;
    AppMethodBeat.o(21926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21927);
    Log.i("MicroMsg.RecoverPCServer", "resume");
    this.hJi = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(21927);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f
 * JD-Core Version:    0.7.0.1
 */