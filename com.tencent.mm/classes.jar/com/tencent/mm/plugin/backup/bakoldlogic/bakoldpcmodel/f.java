package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.ah.g
{
  boolean bNW = false;
  boolean edT = false;
  boolean hGO = false;
  HashSet<String> hNP = new HashSet();
  e.d hNQ;
  private com.tencent.mm.ah.f hNR;
  boolean hNS = false;
  int hNW = 0;
  List<t> hOq;
  List<t> hOr;
  int hOs = 0;
  public boolean hOt = false;
  long hOu;
  long hOv;
  int hOw;
  Object lock = new Object();
  
  public static int aG(List<t> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = com.tencent.mm.a.e.d(com.tencent.mm.plugin.backup.bakoldlogic.a.a.avo() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.xq(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((fp)new fp().aH((byte[])localObject)).hPT.size();
        i = j + i;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.RecoverPCServer", localException, "", new Object[0]);
      }
    }
    return i;
  }
  
  final int a(String arg1, HashMap<String, Integer> paramHashMap, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c paramc, HashSet<String> paramHashSet)
  {
    long l2 = System.currentTimeMillis();
    byte[] arrayOfByte = com.tencent.mm.a.e.d(???, 0, -1);
    fp localfp;
    fo localfo;
    int i;
    try
    {
      localfp = (fp)new fp().aH(arrayOfByte);
      Iterator localIterator = localfp.hPT.iterator();
      if (!localIterator.hasNext()) {
        break label953;
      }
      localfo = (fo)localIterator.next();
      if ((this.bNW) && (!this.edT)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Dz().get(2, null);
        localg = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Fy();
        localObject1 = localfo.svF.tFO;
        ??? = localfo.svG.tFO;
        if ((!bk.bl((String)localObject1)) && (!bk.bl(???))) {
          break label361;
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label992;
        }
        localObject2 = "null";
      }
      catch (Exception ???)
      {
        for (;;)
        {
          y.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + ???.toString());
          y.printErrStackTrace("MicroMsg.RecoverPCServer", ???, "", new Object[0]);
        }
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).hMQ;
        localbd = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP().Fw();
        if (((com.tencent.mm.plugin.messenger.foundation.a.a.j)localObject2).has((String)localObject1)) {
          break label1007;
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
          if (this.edT)
          {
            y.i("MicroMsg.RecoverPCServer", "backupImp canceled");
            return -1;
            paramHashMap = paramHashMap;
            if (arrayOfByte == null) {}
            for (i = 0;; i = arrayOfByte.length)
            {
              y.e("MicroMsg.RecoverPCServer", "read mmPath errr %s, %s, len:%d", new Object[] { ???, paramHashMap, Integer.valueOf(i) });
              y.printErrStackTrace("MicroMsg.RecoverPCServer", paramHashMap, "", new Object[0]);
              return 0;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.RecoverPCServer", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    String str;
    com.tencent.mm.plugin.messenger.foundation.a.a.g localg;
    Object localObject1;
    Object localObject2;
    y.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", new Object[] { localObject2, localObject1 });
    for (;;)
    {
      label293:
      this.hNW += 1;
      if (this.hNW % 100 == 0) {
        avJ();
      }
      com.tencent.mm.plugin.backup.c.e.nw(localfo.hQR);
      long l1 = bk.UY();
      if (l1 - paramc.dXA <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.dXA = l1;
      break;
      label361:
      y.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localfo.hQR), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.avO().avP();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0) {
        throw new com.tencent.mm.model.b();
      }
      bd localbd;
      if (!str.equals(localObject1)) {
        break label1021;
      }
      break label1007;
      label502:
      if (localfo.szt != 0L) {}
      for (l1 = localfo.szt;; l1 = localfo.szl * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.atA();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label607;
        }
        y.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label607:
      if ((localfo.ndp == 0L) && (localfo.ndm != 0)) {
        localfo.ndp = localfo.ndm;
      }
      if (localfo.ndp != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1034;
        }
        label656:
        ??? = localg.O(???, localfo.ndp);
        if (???.field_msgId != 0L) {
          y.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        y.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localfo.ndp != 0L) {
        ???.bf(localfo.ndp);
      }
      ???.bi(localfo.szs);
      ???.bg(l1);
      ???.fJ(localfo.szu);
      ???.setType(localfo.hQR);
      localObject1 = localbd.abl((String)localObject2);
      if ((localObject1 == null) || (bk.bl(((ao)localObject1).field_username)) || (!((ad)localObject1).cua())) {
        break label1040;
      }
      y.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject2);
    }
    label818:
    ???.fA(j);
    ???.ec((String)localObject2);
    if (i != 0) {}
    for (int j = localfo.szk;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localfo.szk == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(bk.a((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.avq().nM(localfo.hQR);
      if (localObject1 == null)
      {
        y.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label293;
      }
      ((com.tencent.mm.plugin.backup.bakoldlogic.b.j)localObject1).a(str, localfo, ???);
      break label293;
      label953:
      com.tencent.mm.plugin.backup.c.e.atM();
      y.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      return localfp.hPT.size();
      label992:
      localObject1 = ???;
      if (??? != null) {
        break;
      }
      localObject1 = "null";
      break;
      label1007:
      label1021:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1027;
        }
        localObject2 = ???;
        break;
      }
      label1027:
      localObject2 = localObject1;
      break label502;
      label1034:
      ??? = (String)localObject1;
      break label656;
      label1040:
      if (i != 0)
      {
        j = 1;
        break label818;
      }
      j = 0;
      break label818;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    this.hOv += paramInt1;
    if (this.hOu == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.hOv * 100L / this.hOu))
    {
      if (paramInt1 > this.hOw)
      {
        this.hOw = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.hOw);
      }
      if ((this.bNW) || (this.edT) || (this.hNQ == null) || (this.hOw < 0) || (this.hOw > 100)) {
        break;
      }
      this.hNQ.nS(this.hOw);
      return;
    }
    y.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.hOw) });
  }
  
  final void avI()
  {
    if ((!this.hNS) || (this.edT)) {
      return;
    }
    synchronized (this.lock)
    {
      if (!this.hNP.isEmpty()) {
        break label120;
      }
      if (this.edT) {
        return;
      }
    }
    this.hOt = true;
    this.hOw = 0;
    a.avr().avs().hOi = 6;
    a.avr().avs().hOj = 5;
    if (this.hNQ != null) {
      this.hNQ.avF();
    }
    for (;;)
    {
      com.tencent.mm.plugin.backup.g.b.b(7, this.hNR);
      cq(0, 0);
      e.avD();
      y.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
      label120:
      return;
      y.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
    }
  }
  
  public final void avJ()
  {
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    y.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.hNW) });
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.RecoverPCServer", "cancel");
    this.edT = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.hNR);
      this.hNQ = null;
      this.hOt = false;
      this.hGO = false;
      this.hOs = 0;
      this.hOw = 0;
      return;
    }
  }
  
  final void cq(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.hOs)) {
        break;
      }
      return;
    }
    this.hOs = i;
    if ((!this.bNW) && (!this.edT) && (this.hNQ != null) && (this.hOs >= 0) && (this.hOs <= 100)) {
      this.hNQ.nT(this.hOs);
    }
    ab localab = new ab();
    localab.hPE = 13;
    localab.hRg = 0;
    localab.hRh = this.hOs;
    try
    {
      y.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.I(localab.toByteArray(), 3);
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.RecoverPCServer", localIOException, "", new Object[0]);
      y.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
    }
  }
  
  public final void pause()
  {
    y.i("MicroMsg.RecoverPCServer", "pause");
    this.bNW = true;
  }
  
  public final void resume()
  {
    y.i("MicroMsg.RecoverPCServer", "resume");
    this.bNW = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f
 * JD-Core Version:    0.7.0.1
 */