package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements g
{
  boolean dus;
  boolean hmD;
  Object lock;
  HashSet<String> nGC;
  e.d nGD;
  private com.tencent.mm.ak.f nGE;
  boolean nGF;
  int nGJ;
  List<t> nHd;
  List<t> nHe;
  int nHf;
  public boolean nHg;
  long nHh;
  long nHi;
  int nHj;
  boolean nzB;
  
  public f()
  {
    AppMethodBeat.i(21925);
    this.lock = new Object();
    this.dus = false;
    this.hmD = false;
    this.nGC = new HashSet();
    this.nGF = false;
    this.nHf = 0;
    this.nHg = false;
    this.nzB = false;
    this.nGJ = 0;
    AppMethodBeat.o(21925);
  }
  
  public static int bM(List<t> paramList)
  {
    AppMethodBeat.i(21930);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = o.bb(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bKd() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.WQ(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((ig)new ig().parseFrom((byte[])localObject)).nIE.size();
        i = j + i;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.RecoverPCServer", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(21930);
    return i;
  }
  
  final int a(String arg1, HashMap<String, Integer> paramHashMap, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c paramc, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(21932);
    long l2 = System.currentTimeMillis();
    byte[] arrayOfByte = o.bb(???, 0, -1);
    ig localig;
    if localif;
    int i;
    try
    {
      localig = (ig)new ig().parseFrom(arrayOfByte);
      Iterator localIterator = localig.nIE.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localif = (if)localIterator.next();
      if ((this.dus) && (!this.hmD)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().ajA().get(2, null);
        locali = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().azI();
        localObject1 = localif.FNG.HId;
        ??? = localif.FNH.HId;
        if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(???))) {
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
          ae.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + ???.toString());
          ae.printErrStackTrace("MicroMsg.RecoverPCServer", ???, "", new Object[0]);
        }
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).nFE;
        localbq = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE().azF();
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
          if (this.hmD)
          {
            ae.i("MicroMsg.RecoverPCServer", "backupImp canceled");
            AppMethodBeat.o(21932);
            return -1;
            paramHashMap = paramHashMap;
            if (arrayOfByte == null) {}
            for (i = 0;; i = arrayOfByte.length)
            {
              ae.e("MicroMsg.RecoverPCServer", "read mmPath errr %s, %s, len:%d", new Object[] { ???, paramHashMap, Integer.valueOf(i) });
              ae.printErrStackTrace("MicroMsg.RecoverPCServer", paramHashMap, "", new Object[0]);
              AppMethodBeat.o(21932);
              return 0;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.RecoverPCServer", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    String str;
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali;
    Object localObject1;
    Object localObject2;
    ae.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", new Object[] { localObject2, localObject1 });
    for (;;)
    {
      label317:
      this.nGJ += 1;
      if (this.nGJ % 100 == 0) {
        bKy();
      }
      com.tencent.mm.plugin.backup.c.e.xx(localif.nJA);
      long l1 = bu.fpO();
      if (l1 - paramc.hiI <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.hiI = l1;
      break;
      label385:
      ae.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localif.nJA), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bKD().bKE();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
      {
        ??? = new com.tencent.mm.model.b();
        AppMethodBeat.o(21932);
        throw ???;
      }
      bq localbq;
      if (!str.equals(localObject1)) {
        break label1056;
      }
      break label1042;
      label534:
      if (localif.FTn != 0L) {}
      for (l1 = localif.FTn;; l1 = localif.FTf * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.bIm();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        ae.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localif.xrk == 0L) && (localif.xri != 0)) {
        localif.xrk = localif.xri;
      }
      if (localif.xrk != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = locali.aJ(???, localif.xrk);
        if (???.field_msgId != 0L) {
          ae.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        ae.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localif.xrk != 0L) {
        ???.qM(localif.xrk);
      }
      ???.qP(localif.FTm);
      ???.qN(l1);
      ???.setFlag(localif.FTo);
      ???.setType(localif.nJA);
      localObject1 = localbq.BH((String)localObject2);
      if ((localObject1 == null) || (bu.isNullOrNil(((aw)localObject1).field_username)) || (!((an)localObject1).fug())) {
        break label1075;
      }
      ae.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.kt(j);
    ???.ui((String)localObject2);
    if (i != 0) {}
    for (int j = localif.FTe;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localif.FTe == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(bu.a((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.bKf().xN(localif.nJA);
      if (localObject1 == null)
      {
        ae.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((j)localObject1).a(str, localif, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.bIx();
      ae.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localig.nIE.size();
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
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(21934);
    this.nHi += paramInt1;
    if (this.nHh == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.nHi * 100L / this.nHh))
    {
      if (paramInt1 > this.nHj)
      {
        this.nHj = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.nHj);
      }
      if ((this.dus) || (this.hmD) || (this.nGD == null) || (this.nHj < 0) || (this.nHj > 100)) {
        break;
      }
      this.nGD.xS(this.nHj);
      AppMethodBeat.o(21934);
      return;
    }
    ae.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.nHj) });
    AppMethodBeat.o(21934);
  }
  
  final void bKx()
  {
    AppMethodBeat.i(21929);
    if ((!this.nGF) || (this.hmD))
    {
      AppMethodBeat.o(21929);
      return;
    }
    synchronized (this.lock)
    {
      if (this.nGC.isEmpty())
      {
        if (this.hmD)
        {
          AppMethodBeat.o(21929);
          return;
        }
        this.nHg = true;
        this.nHj = 0;
        a.bKg().bKh().nGV = 6;
        a.bKg().bKh().nGW = 5;
        if (this.nGD != null)
        {
          this.nGD.bKu();
          com.tencent.mm.plugin.backup.g.b.b(7, this.nGE);
          eG(0, 0);
          e.bKs();
          ae.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
        }
      }
      else
      {
        AppMethodBeat.o(21929);
        return;
      }
      ae.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
    }
  }
  
  public final void bKy()
  {
    AppMethodBeat.i(21933);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    ae.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.nGJ) });
    AppMethodBeat.o(21933);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21928);
    ae.i("MicroMsg.RecoverPCServer", "cancel");
    this.hmD = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.nGE);
      this.nGD = null;
      this.nHg = false;
      this.nzB = false;
      this.nHf = 0;
      this.nHj = 0;
      AppMethodBeat.o(21928);
      return;
    }
  }
  
  final void eG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21931);
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.nHf)) {
        break;
      }
      AppMethodBeat.o(21931);
      return;
    }
    this.nHf = i;
    if ((!this.dus) && (!this.hmD) && (this.nGD != null) && (this.nHf >= 0) && (this.nHf <= 100)) {
      this.nGD.xT(this.nHf);
    }
    ab localab = new ab();
    localab.nIp = 13;
    localab.nJP = 0;
    localab.nJQ = this.nHf;
    try
    {
      ae.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.L(localab.toByteArray(), 3);
      AppMethodBeat.o(21931);
      return;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.RecoverPCServer", localIOException, "", new Object[0]);
      ae.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
      AppMethodBeat.o(21931);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(21926);
    ae.i("MicroMsg.RecoverPCServer", "pause");
    this.dus = true;
    AppMethodBeat.o(21926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21927);
    ae.i("MicroMsg.RecoverPCServer", "resume");
    this.dus = false;
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