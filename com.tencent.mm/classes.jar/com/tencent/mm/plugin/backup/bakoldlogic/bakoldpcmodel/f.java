package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements g
{
  boolean dtm;
  boolean hjP;
  Object lock;
  List<t> nBI;
  List<t> nBJ;
  int nBK;
  public boolean nBL;
  long nBM;
  long nBN;
  int nBO;
  HashSet<String> nBh;
  e.d nBi;
  private com.tencent.mm.al.f nBj;
  boolean nBk;
  int nBo;
  boolean nug;
  
  public f()
  {
    AppMethodBeat.i(21925);
    this.lock = new Object();
    this.dtm = false;
    this.hjP = false;
    this.nBh = new HashSet();
    this.nBk = false;
    this.nBK = 0;
    this.nBL = false;
    this.nug = false;
    this.nBo = 0;
    AppMethodBeat.o(21925);
  }
  
  public static int bK(List<t> paramList)
  {
    AppMethodBeat.i(21930);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = com.tencent.mm.vfs.i.aY(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bJf() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.We(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((ig)new ig().parseFrom((byte[])localObject)).nDj.size();
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
    byte[] arrayOfByte = com.tencent.mm.vfs.i.aY(???, 0, -1);
    ig localig;
    if localif;
    int i;
    try
    {
      localig = (ig)new ig().parseFrom(arrayOfByte);
      Iterator localIterator = localig.nDj.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localif = (if)localIterator.next();
      if ((this.dtm) && (!this.hjP)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().ajl().get(2, null);
        locali = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().azs();
        localObject1 = localif.Fvi.HoB;
        ??? = localif.Fvj.HoB;
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
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).nAj;
        localbp = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG().azp();
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
          if (this.hjP)
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
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali;
    Object localObject1;
    Object localObject2;
    ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", new Object[] { localObject2, localObject1 });
    for (;;)
    {
      label317:
      this.nBo += 1;
      if (this.nBo % 100 == 0) {
        bJA();
      }
      com.tencent.mm.plugin.backup.c.e.xs(localif.nEf);
      long l1 = bt.flT();
      if (l1 - paramc.hfU <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.hfU = l1;
      break;
      label385:
      ad.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localif.nEf), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bJF().bJG();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
      {
        ??? = new com.tencent.mm.model.b();
        AppMethodBeat.o(21932);
        throw ???;
      }
      bp localbp;
      if (!str.equals(localObject1)) {
        break label1056;
      }
      break label1042;
      label534:
      if (localif.FAS != 0L) {}
      for (l1 = localif.FAS;; l1 = localif.FAJ * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.bHo();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localif.xbt == 0L) && (localif.xbr != 0)) {
        localif.xbt = localif.xbr;
      }
      if (localif.xbt != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = locali.aI(???, localif.xbt);
        if (???.field_msgId != 0L) {
          ad.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localif.xbt != 0L) {
        ???.qz(localif.xbt);
      }
      ???.qC(localif.FAQ);
      ???.qA(l1);
      ???.setFlag(localif.FAT);
      ???.setType(localif.nEf);
      localObject1 = localbp.Bf((String)localObject2);
      if ((localObject1 == null) || (bt.isNullOrNil(((aw)localObject1).field_username)) || (!((am)localObject1).fqg())) {
        break label1075;
      }
      ad.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.kr(j);
    ???.tN((String)localObject2);
    if (i != 0) {}
    for (int j = localif.FAI;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localif.FAI == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(bt.a((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.bJh().xJ(localif.nEf);
      if (localObject1 == null)
      {
        ad.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((j)localObject1).a(str, localif, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.bHz();
      ad.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localig.nDj.size();
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
    this.nBN += paramInt1;
    if (this.nBM == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.nBN * 100L / this.nBM))
    {
      if (paramInt1 > this.nBO)
      {
        this.nBO = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.nBO);
      }
      if ((this.dtm) || (this.hjP) || (this.nBi == null) || (this.nBO < 0) || (this.nBO > 100)) {
        break;
      }
      this.nBi.xO(this.nBO);
      AppMethodBeat.o(21934);
      return;
    }
    ad.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.nBO) });
    AppMethodBeat.o(21934);
  }
  
  public final void bJA()
  {
    AppMethodBeat.i(21933);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    ad.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.nBo) });
    AppMethodBeat.o(21933);
  }
  
  final void bJz()
  {
    AppMethodBeat.i(21929);
    if ((!this.nBk) || (this.hjP))
    {
      AppMethodBeat.o(21929);
      return;
    }
    synchronized (this.lock)
    {
      if (this.nBh.isEmpty())
      {
        if (this.hjP)
        {
          AppMethodBeat.o(21929);
          return;
        }
        this.nBL = true;
        this.nBO = 0;
        a.bJi().bJj().nBA = 6;
        a.bJi().bJj().nBB = 5;
        if (this.nBi != null)
        {
          this.nBi.bJw();
          com.tencent.mm.plugin.backup.g.b.b(7, this.nBj);
          eG(0, 0);
          e.bJu();
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
  
  public final void cancel()
  {
    AppMethodBeat.i(21928);
    ad.i("MicroMsg.RecoverPCServer", "cancel");
    this.hjP = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.nBj);
      this.nBi = null;
      this.nBL = false;
      this.nug = false;
      this.nBK = 0;
      this.nBO = 0;
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
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.nBK)) {
        break;
      }
      AppMethodBeat.o(21931);
      return;
    }
    this.nBK = i;
    if ((!this.dtm) && (!this.hjP) && (this.nBi != null) && (this.nBK >= 0) && (this.nBK <= 100)) {
      this.nBi.xP(this.nBK);
    }
    ab localab = new ab();
    localab.nCU = 13;
    localab.nEu = 0;
    localab.nEv = this.nBK;
    try
    {
      ad.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.L(localab.toByteArray(), 3);
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
    this.dtm = true;
    AppMethodBeat.o(21926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21927);
    ad.i("MicroMsg.RecoverPCServer", "resume");
    this.dtm = false;
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