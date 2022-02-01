package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.al.h
{
  boolean dkt;
  boolean gqP;
  Object lock;
  boolean mrG;
  HashSet<String> myJ;
  e.d myK;
  private g myL;
  boolean myM;
  int myQ;
  List<t> mzk;
  List<t> mzl;
  int mzm;
  public boolean mzn;
  long mzo;
  long mzp;
  int mzq;
  
  public f()
  {
    AppMethodBeat.i(21925);
    this.lock = new Object();
    this.dkt = false;
    this.gqP = false;
    this.myJ = new HashSet();
    this.myM = false;
    this.mzm = 0;
    this.mzn = false;
    this.mrG = false;
    this.myQ = 0;
    AppMethodBeat.o(21925);
  }
  
  public static int bJ(List<t> paramList)
  {
    AppMethodBeat.i(21930);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = com.tencent.mm.vfs.i.aR(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bya() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.Ow(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((hv)new hv().parseFrom((byte[])localObject)).mAL.size();
        i = j + i;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.RecoverPCServer", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(21930);
    return i;
  }
  
  final int a(String arg1, HashMap<String, Integer> paramHashMap, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c paramc, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(21932);
    long l2 = System.currentTimeMillis();
    byte[] arrayOfByte = com.tencent.mm.vfs.i.aR(???, 0, -1);
    hv localhv;
    hu localhu;
    int i;
    try
    {
      localhv = (hv)new hv().parseFrom(arrayOfByte);
      Iterator localIterator = localhv.mAL.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localhu = (hu)localIterator.next();
      if ((this.dkt) && (!this.gqP)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().afk().get(2, null);
        localh = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().apO();
        localObject1 = localhu.Cxx.Ehn;
        ??? = localhu.Cxy.Ehn;
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(???))) {
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
          ad.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + ???.toString());
          ad.printErrStackTrace("MicroMsg.RecoverPCServer", ???, "", new Object[0]);
        }
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).mxL;
        localbg = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB().apM();
        if (((k)localObject2).has((String)localObject1)) {
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
          if (this.gqP)
          {
            ad.i("MicroMsg.RecoverPCServer", "backupImp canceled");
            AppMethodBeat.o(21932);
            return -1;
            paramHashMap = paramHashMap;
            if (arrayOfByte == null) {}
            for (i = 0;; i = arrayOfByte.length)
            {
              ad.e("MicroMsg.RecoverPCServer", "read mmPath errr %s, %s, len:%d", new Object[] { ???, paramHashMap, Integer.valueOf(i) });
              ad.printErrStackTrace("MicroMsg.RecoverPCServer", paramHashMap, "", new Object[0]);
              AppMethodBeat.o(21932);
              return 0;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.RecoverPCServer", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    String str;
    com.tencent.mm.plugin.messenger.foundation.a.a.h localh;
    Object localObject1;
    Object localObject2;
    ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", new Object[] { localObject2, localObject1 });
    for (;;)
    {
      label317:
      this.myQ += 1;
      if (this.myQ % 100 == 0) {
        byv();
      }
      com.tencent.mm.plugin.backup.c.e.vV(localhu.mBH);
      long l1 = bt.eGO();
      if (l1 - paramc.glk <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.glk = l1;
      break;
      label385:
      ad.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localhu.mBH), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.byA().byB();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
      {
        ??? = new com.tencent.mm.model.b();
        AppMethodBeat.o(21932);
        throw ???;
      }
      bg localbg;
      if (!str.equals(localObject1)) {
        break label1056;
      }
      break label1042;
      label534:
      if (localhu.CCZ != 0L) {}
      for (l1 = localhu.CCZ;; l1 = localhu.CCR * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.bwk();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localhu.uKZ == 0L) && (localhu.uKX != 0)) {
        localhu.uKZ = localhu.uKX;
      }
      if (localhu.uKZ != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = localh.aD(???, localhu.uKZ);
        if (???.field_msgId != 0L) {
          ad.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localhu.uKZ != 0L) {
        ???.kX(localhu.uKZ);
      }
      ???.la(localhu.CCY);
      ???.kY(l1);
      ???.setFlag(localhu.CDa);
      ???.setType(localhu.mBH);
      localObject1 = localbg.aHY((String)localObject2);
      if ((localObject1 == null) || (bt.isNullOrNil(((au)localObject1).field_username)) || (!((af)localObject1).eKB())) {
        break label1075;
      }
      ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.jV(j);
    ???.nY((String)localObject2);
    if (i != 0) {}
    for (int j = localhu.CCQ;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localhu.CCQ == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(bt.a((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.byc().wm(localhu.mBH);
      if (localObject1 == null)
      {
        ad.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((j)localObject1).a(str, localhu, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.bwv();
      ad.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localhv.mAL.size();
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
    this.mzp += paramInt1;
    if (this.mzo == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.mzp * 100L / this.mzo))
    {
      if (paramInt1 > this.mzq)
      {
        this.mzq = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.mzq);
      }
      if ((this.dkt) || (this.gqP) || (this.myK == null) || (this.mzq < 0) || (this.mzq > 100)) {
        break;
      }
      this.myK.wr(this.mzq);
      AppMethodBeat.o(21934);
      return;
    }
    ad.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.mzq) });
    AppMethodBeat.o(21934);
  }
  
  final void byu()
  {
    AppMethodBeat.i(21929);
    if ((!this.myM) || (this.gqP))
    {
      AppMethodBeat.o(21929);
      return;
    }
    synchronized (this.lock)
    {
      if (this.myJ.isEmpty())
      {
        if (this.gqP)
        {
          AppMethodBeat.o(21929);
          return;
        }
        this.mzn = true;
        this.mzq = 0;
        a.byd().bye().mzc = 6;
        a.byd().bye().mzd = 5;
        if (this.myK != null)
        {
          this.myK.byr();
          com.tencent.mm.plugin.backup.g.b.b(7, this.myL);
          eA(0, 0);
          e.byp();
          ad.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
        }
      }
      else
      {
        AppMethodBeat.o(21929);
        return;
      }
      ad.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
    }
  }
  
  public final void byv()
  {
    AppMethodBeat.i(21933);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    ad.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.myQ) });
    AppMethodBeat.o(21933);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21928);
    ad.i("MicroMsg.RecoverPCServer", "cancel");
    this.gqP = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.myL);
      this.myK = null;
      this.mzn = false;
      this.mrG = false;
      this.mzm = 0;
      this.mzq = 0;
      AppMethodBeat.o(21928);
      return;
    }
  }
  
  final void eA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21931);
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.mzm)) {
        break;
      }
      AppMethodBeat.o(21931);
      return;
    }
    this.mzm = i;
    if ((!this.dkt) && (!this.gqP) && (this.myK != null) && (this.mzm >= 0) && (this.mzm <= 100)) {
      this.myK.ws(this.mzm);
    }
    com.tencent.mm.plugin.backup.i.ab localab = new com.tencent.mm.plugin.backup.i.ab();
    localab.mAw = 13;
    localab.mBW = 0;
    localab.mBX = this.mzm;
    try
    {
      ad.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.N(localab.toByteArray(), 3);
      AppMethodBeat.o(21931);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.RecoverPCServer", localIOException, "", new Object[0]);
      ad.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
      AppMethodBeat.o(21931);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(21926);
    ad.i("MicroMsg.RecoverPCServer", "pause");
    this.dkt = true;
    AppMethodBeat.o(21926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21927);
    ad.i("MicroMsg.RecoverPCServer", "resume");
    this.dkt = false;
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