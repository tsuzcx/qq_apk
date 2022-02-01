package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.protocal.protobuf.ii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.an.j
{
  boolean fEs;
  boolean kUn;
  Object lock;
  boolean rMp;
  private com.tencent.mm.an.i rTA;
  boolean rTB;
  int rTF;
  List<t> rTZ;
  HashSet<String> rTy;
  e.d rTz;
  List<t> rUa;
  int rUb;
  public boolean rUc;
  long rUd;
  long rUe;
  int rUf;
  
  public f()
  {
    AppMethodBeat.i(21925);
    this.lock = new Object();
    this.fEs = false;
    this.kUn = false;
    this.rTy = new HashSet();
    this.rTB = false;
    this.rUb = 0;
    this.rUc = false;
    this.rMp = false;
    this.rTF = 0;
    AppMethodBeat.o(21925);
  }
  
  public static int bW(List<t> paramList)
  {
    AppMethodBeat.i(21930);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = u.aY(com.tencent.mm.plugin.backup.bakoldlogic.a.a.cuh() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.aoo(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((ii)new ii().parseFrom((byte[])localObject)).rVy.size();
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
    byte[] arrayOfByte = u.aY(???, 0, -1);
    ii localii;
    ih localih;
    int i;
    try
    {
      localii = (ii)new ii().parseFrom(arrayOfByte);
      Iterator localIterator = localii.rVy.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localih = (ih)localIterator.next();
      if ((this.fEs) && (!this.kUn)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().aHp().b(2, null);
        locali = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().bbO();
        localObject1 = localih.RID.Ufy;
        ??? = localih.RIE.Ufy;
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
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).rSy;
        localbv = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI().bbL();
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
          if (this.kUn)
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
      this.rTF += 1;
      if (this.rTF % 100 == 0) {
        cuC();
      }
      com.tencent.mm.plugin.backup.c.e.EE(localih.rWu);
      long l1 = Util.nowMilliSecond();
      if (l1 - paramc.kje <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.kje = l1;
      break;
      label385:
      Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localih.rWu), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.cuH().cuI();
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
      if (localih.RNQ != 0L) {}
      for (l1 = localih.RNQ;; l1 = localih.RNI * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.csq();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localih.HlH == 0L) && (localih.HlE != 0)) {
        localih.HlH = localih.HlE;
      }
      if (localih.HlH != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = locali.aL(???, localih.HlH);
        if (???.field_msgId != 0L) {
          Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localih.HlH != 0L) {
        ???.EG(localih.HlH);
      }
      ???.EI(localih.RNP);
      ???.setCreateTime(l1);
      ???.setFlag(localih.RNR);
      ???.setType(localih.rWu);
      localObject1 = localbv.RG((String)localObject2);
      if ((localObject1 == null) || (Util.isNullOrNil(((ax)localObject1).field_username)) || (!((as)localObject1).hxX())) {
        break label1075;
      }
      Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.pJ(j);
    ???.Jm((String)localObject2);
    if (i != 0) {}
    for (int j = localih.RNH;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localih.RNH == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(Util.nullAs((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.cuj().EU(localih.rWu);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((com.tencent.mm.plugin.backup.bakoldlogic.b.j)localObject1).a(str, localih, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.csB();
      Log.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localii.rVy.size();
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
    this.rUe += paramInt1;
    if (this.rUd == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.rUe * 100L / this.rUd))
    {
      if (paramInt1 > this.rUf)
      {
        this.rUf = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.rUf);
      }
      if ((this.fEs) || (this.kUn) || (this.rTz == null) || (this.rUf < 0) || (this.rUf > 100)) {
        break;
      }
      this.rTz.EZ(this.rUf);
      AppMethodBeat.o(21934);
      return;
    }
    Log.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.rUf) });
    AppMethodBeat.o(21934);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21928);
    Log.i("MicroMsg.RecoverPCServer", "cancel");
    this.kUn = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.rTA);
      this.rTz = null;
      this.rUc = false;
      this.rMp = false;
      this.rUb = 0;
      this.rUf = 0;
      AppMethodBeat.o(21928);
      return;
    }
  }
  
  final void cuB()
  {
    AppMethodBeat.i(21929);
    if ((!this.rTB) || (this.kUn))
    {
      AppMethodBeat.o(21929);
      return;
    }
    synchronized (this.lock)
    {
      if (this.rTy.isEmpty())
      {
        if (this.kUn)
        {
          AppMethodBeat.o(21929);
          return;
        }
        this.rUc = true;
        this.rUf = 0;
        a.cuk().cul().rTR = 6;
        a.cuk().cul().rTS = 5;
        if (this.rTz != null)
        {
          this.rTz.cuy();
          com.tencent.mm.plugin.backup.g.b.b(7, this.rTA);
          fs(0, 0);
          e.cuw();
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
  
  public final void cuC()
  {
    AppMethodBeat.i(21933);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    Log.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.rTF) });
    AppMethodBeat.o(21933);
  }
  
  final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21931);
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.rUb)) {
        break;
      }
      AppMethodBeat.o(21931);
      return;
    }
    this.rUb = i;
    if ((!this.fEs) && (!this.kUn) && (this.rTz != null) && (this.rUb >= 0) && (this.rUb <= 100)) {
      this.rTz.Fa(this.rUb);
    }
    ab localab = new ab();
    localab.rVj = 13;
    localab.rWJ = 0;
    localab.rWK = this.rUb;
    try
    {
      Log.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.O(localab.toByteArray(), 3);
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
    this.fEs = true;
    AppMethodBeat.o(21926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21927);
    Log.i("MicroMsg.RecoverPCServer", "resume");
    this.fEs = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(21927);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f
 * JD-Core Version:    0.7.0.1
 */