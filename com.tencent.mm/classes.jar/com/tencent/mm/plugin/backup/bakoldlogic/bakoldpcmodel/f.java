package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.ak.h
{
  boolean dhO;
  boolean gRx;
  Object lock;
  boolean mTI;
  HashSet<String> naK;
  e.d naL;
  private g naM;
  boolean naN;
  int naR;
  List<t> nbl;
  List<t> nbm;
  int nbn;
  public boolean nbo;
  long nbp;
  long nbq;
  int nbr;
  
  public f()
  {
    AppMethodBeat.i(21925);
    this.lock = new Object();
    this.dhO = false;
    this.gRx = false;
    this.naK = new HashSet();
    this.naN = false;
    this.nbn = 0;
    this.nbo = false;
    this.mTI = false;
    this.naR = 0;
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
        localObject = com.tencent.mm.vfs.i.aU(com.tencent.mm.plugin.backup.bakoldlogic.a.a.bEW() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.SG(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((hz)new hz().parseFrom((byte[])localObject)).ncM.size();
        i = j + i;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.RecoverPCServer", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(21930);
    return i;
  }
  
  final int a(String arg1, HashMap<String, Integer> paramHashMap, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c paramc, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(21932);
    long l2 = System.currentTimeMillis();
    byte[] arrayOfByte = com.tencent.mm.vfs.i.aU(???, 0, -1);
    hz localhz;
    hy localhy;
    int i;
    try
    {
      localhz = (hz)new hz().parseFrom(arrayOfByte);
      Iterator localIterator = localhz.ncM.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localhy = (hy)localIterator.next();
      if ((this.dhO) && (!this.gRx)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().agA().get(2, null);
        localh = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().awD();
        localObject1 = localhy.DPT.FEm;
        ??? = localhy.DPU.FEm;
        if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(???))) {
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
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + ???.toString());
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.RecoverPCServer", ???, "", new Object[0]);
        }
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).mZM;
        localbj = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx().awB();
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
          if (this.gRx)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "backupImp canceled");
            AppMethodBeat.o(21932);
            return -1;
            paramHashMap = paramHashMap;
            if (arrayOfByte == null) {}
            for (i = 0;; i = arrayOfByte.length)
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RecoverPCServer", "read mmPath errr %s, %s, len:%d", new Object[] { ???, paramHashMap, Integer.valueOf(i) });
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.RecoverPCServer", paramHashMap, "", new Object[0]);
              AppMethodBeat.o(21932);
              return 0;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.RecoverPCServer", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    String str;
    com.tencent.mm.plugin.messenger.foundation.a.a.h localh;
    Object localObject1;
    Object localObject2;
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", new Object[] { localObject2, localObject1 });
    for (;;)
    {
      label317:
      this.naR += 1;
      if (this.naR % 100 == 0) {
        bFr();
      }
      com.tencent.mm.plugin.backup.c.e.wM(localhy.ndI);
      long l1 = bs.eWj();
      if (l1 - paramc.gLX <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.gLX = l1;
      break;
      label385:
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localhy.ndI), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.bFw().bFx();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
      {
        ??? = new com.tencent.mm.model.b();
        AppMethodBeat.o(21932);
        throw ???;
      }
      bj localbj;
      if (!str.equals(localObject1)) {
        break label1056;
      }
      break label1042;
      label534:
      if (localhy.DVw != 0L) {}
      for (l1 = localhy.DVw;; l1 = localhy.DVo * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.bDg();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localhy.vTQ == 0L) && (localhy.vTO != 0)) {
        localhy.vTQ = localhy.vTO;
      }
      if (localhy.vTQ != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = localh.aF(???, localhy.vTQ);
        if (???.field_msgId != 0L) {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localhy.vTQ != 0L) {
        ???.oz(localhy.vTQ);
      }
      ???.oC(localhy.DVv);
      ???.oA(l1);
      ???.setFlag(localhy.DVx);
      ???.setType(localhy.ndI);
      localObject1 = localbj.aNt((String)localObject2);
      if ((localObject1 == null) || (bs.isNullOrNil(((av)localObject1).field_username)) || (!((ai)localObject1).fad())) {
        break label1075;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.jT(j);
    ???.re((String)localObject2);
    if (i != 0) {}
    for (int j = localhy.DVn;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localhy.DVn == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(bs.a((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.bEY().xd(localhy.ndI);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((j)localObject1).a(str, localhy, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.bDr();
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localhz.ncM.size();
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
    this.nbq += paramInt1;
    if (this.nbp == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.nbq * 100L / this.nbp))
    {
      if (paramInt1 > this.nbr)
      {
        this.nbr = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.nbr);
      }
      if ((this.dhO) || (this.gRx) || (this.naL == null) || (this.nbr < 0) || (this.nbr > 100)) {
        break;
      }
      this.naL.xi(this.nbr);
      AppMethodBeat.o(21934);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.nbr) });
    AppMethodBeat.o(21934);
  }
  
  final void bFq()
  {
    AppMethodBeat.i(21929);
    if ((!this.naN) || (this.gRx))
    {
      AppMethodBeat.o(21929);
      return;
    }
    synchronized (this.lock)
    {
      if (this.naK.isEmpty())
      {
        if (this.gRx)
        {
          AppMethodBeat.o(21929);
          return;
        }
        this.nbo = true;
        this.nbr = 0;
        a.bEZ().bFa().nbd = 6;
        a.bEZ().bFa().nbe = 5;
        if (this.naL != null)
        {
          this.naL.bFn();
          com.tencent.mm.plugin.backup.g.b.b(7, this.naM);
          eD(0, 0);
          e.bFl();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
        }
      }
      else
      {
        AppMethodBeat.o(21929);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
    }
  }
  
  public final void bFr()
  {
    AppMethodBeat.i(21933);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.naR) });
    AppMethodBeat.o(21933);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(21928);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "cancel");
    this.gRx = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.naM);
      this.naL = null;
      this.nbo = false;
      this.mTI = false;
      this.nbn = 0;
      this.nbr = 0;
      AppMethodBeat.o(21928);
      return;
    }
  }
  
  final void eD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21931);
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.nbn)) {
        break;
      }
      AppMethodBeat.o(21931);
      return;
    }
    this.nbn = i;
    if ((!this.dhO) && (!this.gRx) && (this.naL != null) && (this.nbn >= 0) && (this.nbn <= 100)) {
      this.naL.xj(this.nbn);
    }
    ab localab = new ab();
    localab.ncx = 13;
    localab.ndX = 0;
    localab.ndY = this.nbn;
    try
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.L(localab.toByteArray(), 3);
      AppMethodBeat.o(21931);
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.RecoverPCServer", localIOException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
      AppMethodBeat.o(21931);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(21926);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "pause");
    this.dhO = true;
    AppMethodBeat.o(21926);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(21927);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.RecoverPCServer", "resume");
    this.dhO = false;
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