package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.backup.bakoldlogic.b.j;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.sdk.platformtools.bo;
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
  implements g
{
  boolean cvo;
  boolean eUJ;
  boolean jAk;
  List<t> jHS;
  List<t> jHT;
  int jHU;
  public boolean jHV;
  long jHW;
  long jHX;
  int jHY;
  HashSet<String> jHr;
  e.d jHs;
  private com.tencent.mm.ai.f jHt;
  boolean jHu;
  int jHy;
  Object lock;
  
  public f()
  {
    AppMethodBeat.i(17868);
    this.lock = new Object();
    this.cvo = false;
    this.eUJ = false;
    this.jHr = new HashSet();
    this.jHu = false;
    this.jHU = 0;
    this.jHV = false;
    this.jAk = false;
    this.jHy = 0;
    AppMethodBeat.o(17868);
  }
  
  public static int aQ(List<t> paramList)
  {
    AppMethodBeat.i(17873);
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (t)paramList.next();
      try
      {
        localObject = com.tencent.mm.a.e.j(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aUR() + "backupItem/" + com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gi(((t)localObject).ID) + ((t)localObject).ID, 0, -1);
        int j = ((gy)new gy().parseFrom((byte[])localObject)).jJv.size();
        i = j + i;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.RecoverPCServer", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(17873);
    return i;
  }
  
  final int a(String arg1, HashMap<String, Integer> paramHashMap, com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c paramc, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(17875);
    long l2 = System.currentTimeMillis();
    byte[] arrayOfByte = com.tencent.mm.a.e.j(???, 0, -1);
    gy localgy;
    gx localgx;
    int i;
    try
    {
      localgy = (gy)new gy().parseFrom(arrayOfByte);
      Iterator localIterator = localgy.jJv.iterator();
      if (!localIterator.hasNext()) {
        break label978;
      }
      localgx = (gx)localIterator.next();
      if ((this.cvo) && (!this.eUJ)) {}
      try
      {
        str = (String)com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().Ru().get(2, null);
        localh = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().YC();
        localObject1 = localgx.woP.xJE;
        ??? = localgx.woQ.xJE;
        if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil(???))) {
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
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + ???.toString());
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.RecoverPCServer", ???, "", new Object[0]);
        }
        localObject2 = ((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).jGs;
        localbd = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs().YA();
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
          if (this.eUJ)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "backupImp canceled");
            AppMethodBeat.o(17875);
            return -1;
            paramHashMap = paramHashMap;
            if (arrayOfByte == null) {}
            for (i = 0;; i = arrayOfByte.length)
            {
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RecoverPCServer", "read mmPath errr %s, %s, len:%d", new Object[] { ???, paramHashMap, Integer.valueOf(i) });
              com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.RecoverPCServer", paramHashMap, "", new Object[0]);
              AppMethodBeat.o(17875);
              return 0;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.RecoverPCServer", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    String str;
    h localh;
    Object localObject1;
    Object localObject2;
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", new Object[] { localObject2, localObject1 });
    for (;;)
    {
      label317:
      this.jHy += 1;
      if (this.jHy % 100 == 0) {
        aVm();
      }
      com.tencent.mm.plugin.backup.c.e.ri(localgx.jKs);
      long l1 = bo.aoy();
      if (l1 - paramc.ePF <= 10000L) {
        break;
      }
      paramc.end();
      paramc.begin();
      paramc.ePF = l1;
      break;
      label385:
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", new Object[] { Integer.valueOf(localgx.jKs), localObject1, ??? });
      localObject2 = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aVr().aVs();
      if (((com.tencent.mm.plugin.backup.bakoldlogic.d.c)localObject2).uin == 0)
      {
        ??? = new com.tencent.mm.model.b();
        AppMethodBeat.o(17875);
        throw ???;
      }
      bd localbd;
      if (!str.equals(localObject1)) {
        break label1056;
      }
      break label1042;
      label534:
      if (localgx.wtu != 0L) {}
      for (l1 = localgx.wtu;; l1 = localgx.wtm * 1000L)
      {
        paramHashSet.add(localObject2);
        List localList = com.tencent.mm.plugin.backup.bakoldlogic.a.a.aSY();
        if ((!localList.contains(localObject1)) && (!localList.contains(???))) {
          break label639;
        }
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + (String)localObject1 + " " + ???);
        break;
      }
      label639:
      if ((localgx.pIG == 0L) && (localgx.pIE != 0)) {
        localgx.pIG = localgx.pIE;
      }
      if (localgx.pIG != 0L)
      {
        if (!str.equals(localObject1)) {
          break label1069;
        }
        label688:
        ??? = localh.ag(???, localgx.pIG);
        if (???.field_msgId != 0L) {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
        continue;
      }
      if (localgx.pIG != 0L) {
        ???.fP(localgx.pIG);
      }
      ???.fS(localgx.wtt);
      ???.fQ(l1);
      ???.hV(localgx.wtv);
      ???.setType(localgx.jKs);
      localObject1 = localbd.arw((String)localObject2);
      if ((localObject1 == null) || (bo.isNullOrNil(((aq)localObject1).field_username)) || (!((ad)localObject1).dwz())) {
        break label1075;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(localObject2)));
    }
    label843:
    ???.hL(j);
    ???.kj((String)localObject2);
    if (i != 0) {}
    for (int j = localgx.wtl;; j = 4)
    {
      ???.setStatus(j);
      if (paramHashMap.get(localObject2) == null) {
        paramHashMap.put(localObject2, Integer.valueOf(0));
      }
      if ((i == 0) && (localgx.wtl == 3)) {
        paramHashMap.put(localObject2, Integer.valueOf(bo.a((Integer)paramHashMap.get(localObject2), 0) + 1));
      }
      localObject1 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.aUT().rA(localgx.jKs);
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
        break label317;
      }
      ((j)localObject1).a(str, localgx, ???);
      break label317;
      label978:
      com.tencent.mm.plugin.backup.c.e.aTk();
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - l2));
      i = localgy.jJv.size();
      AppMethodBeat.o(17875);
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
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(17877);
    this.jHX += paramInt1;
    if (this.jHW == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.jHX * 100L / this.jHW))
    {
      if (paramInt1 > this.jHY)
      {
        this.jHY = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.jHY);
      }
      if ((this.cvo) || (this.eUJ) || (this.jHs == null) || (this.jHY < 0) || (this.jHY > 100)) {
        break;
      }
      this.jHs.rF(this.jHY);
      AppMethodBeat.o(17877);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", new Object[] { Integer.valueOf(this.jHY) });
    AppMethodBeat.o(17877);
  }
  
  final void aVl()
  {
    AppMethodBeat.i(17872);
    if ((!this.jHu) || (this.eUJ))
    {
      AppMethodBeat.o(17872);
      return;
    }
    synchronized (this.lock)
    {
      if (this.jHr.isEmpty())
      {
        if (this.eUJ)
        {
          AppMethodBeat.o(17872);
          return;
        }
        this.jHV = true;
        this.jHY = 0;
        a.aUU().aUV().jHK = 6;
        a.aUU().aUV().jHL = 5;
        if (this.jHs != null)
        {
          this.jHs.aVi();
          com.tencent.mm.plugin.backup.g.b.b(7, this.jHt);
          dG(0, 0);
          e.aVg();
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
        }
      }
      else
      {
        AppMethodBeat.o(17872);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
    }
  }
  
  public final void aVm()
  {
    AppMethodBeat.i(17876);
    System.gc();
    long l1 = Runtime.getRuntime().freeMemory() / 1000L;
    long l2 = Runtime.getRuntime().totalMemory() / 1000L;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l2 - l1), Integer.valueOf(this.jHy) });
    AppMethodBeat.o(17876);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(17871);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "cancel");
    this.eUJ = true;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      com.tencent.mm.plugin.backup.g.b.b(7, this.jHt);
      this.jHs = null;
      this.jHV = false;
      this.jAk = false;
      this.jHU = 0;
      this.jHY = 0;
      AppMethodBeat.o(17871);
      return;
    }
  }
  
  final void dG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(17874);
    if (paramInt1 == 0) {}
    int i;
    for (long l = 0L;; l = paramInt1 * 100L / paramInt2)
    {
      i = (int)l;
      if (((paramInt1 == 0) && (paramInt2 == 0)) || (i > this.jHU)) {
        break;
      }
      AppMethodBeat.o(17874);
      return;
    }
    this.jHU = i;
    if ((!this.cvo) && (!this.eUJ) && (this.jHs != null) && (this.jHU >= 0) && (this.jHU <= 100)) {
      this.jHs.rG(this.jHU);
    }
    com.tencent.mm.plugin.backup.i.ab localab = new com.tencent.mm.plugin.backup.i.ab();
    localab.jJg = 13;
    localab.jKH = 0;
    localab.jKI = this.jHU;
    try
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.plugin.backup.g.b.J(localab.toByteArray(), 3);
      AppMethodBeat.o(17874);
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.RecoverPCServer", localIOException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
      AppMethodBeat.o(17874);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(17869);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "pause");
    this.cvo = true;
    AppMethodBeat.o(17869);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(17870);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.RecoverPCServer", "resume");
    this.cvo = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(17870);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f
 * JD-Core Version:    0.7.0.1
 */