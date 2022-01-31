package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.c.brk;
import com.tencent.mm.protocal.c.brl;
import com.tencent.mm.protocal.c.brm;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

public final class h
  extends m
  implements com.tencent.mm.network.k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public h()
  {
    b.a locala = new b.a();
    locala.ecH = new brl();
    locala.ecI = new brm();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.ecG = 906;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((brl)this.dmK.ecE.ecN).tIi = ((Long)g.DP().Dz().get(ac.a.upg, Long.valueOf(0L))).longValue();
  }
  
  private static boolean a(brk parambrk)
  {
    if (parambrk == null)
    {
      y.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      return false;
    }
    y.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { parambrk.bZc, Long.valueOf(parambrk.tIh) });
    for (;;)
    {
      boolean bool;
      try
      {
        y.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(parambrk.ioG) });
        switch (parambrk.ioG)
        {
        case 0: 
          y.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(parambrk.ioG) });
          return false;
        }
      }
      catch (Exception parambrk)
      {
        y.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { parambrk.getMessage() });
        return false;
      }
      Object localObject1 = am.aAz();
      if (parambrk == null)
      {
        y.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
        if ((parambrk.ioG == 0) || (parambrk.ioG == 5)) {
          break;
        }
        localObject1 = (String)g.DP().Dz().get(ac.a.upo, "");
        bool = ((Boolean)g.DP().Dz().get(ac.a.upp, Boolean.valueOf(false))).booleanValue();
        if ((bool) && (!bk.bl((String)localObject1)) && (((String)localObject1).equals(parambrk.bZc)))
        {
          y.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.aAg();
          break;
        }
      }
      else
      {
        ??? = am.aAA().yy(parambrk.bZc);
        Object localObject3 = parambrk.bZc;
        long l;
        if (??? == null)
        {
          l = 0L;
          y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d", new Object[] { localObject3, Long.valueOf(l), Long.valueOf(parambrk.tIh) });
          if ((??? != null) && (((ShareCardInfo)???).field_updateSeq == parambrk.tIh)) {
            y.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
          }
        }
        else
        {
          l = ((ShareCardInfo)???).field_updateSeq;
          continue;
        }
        localObject3 = n.b(parambrk);
        synchronized (((a)localObject1).dMQ)
        {
          if (!((a)localObject1).ijT.contains(localObject3)) {}
        }
        if (((a)localObject1).ijU.contains(localObject3)) {
          continue;
        }
        ((a)localObject1).ijT.add(localObject3);
        y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[] { Boolean.valueOf(am.aAB().b((c)localObject3)) });
        continue;
        localObject1 = am.aAz();
        if (parambrk == null)
        {
          y.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ??? = am.aAA().yy(parambrk.bZc);
        am.aAA().yx(parambrk.bZc);
        y.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + parambrk.bZc);
        if (??? != null) {
          com.tencent.mm.plugin.card.sharecard.a.b.a(ae.getContext(), (com.tencent.mm.plugin.card.base.b)???);
        }
        for (;;)
        {
          ((a)localObject1).axs();
          break;
          y.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
        }
      }
      if (bool)
      {
        y.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
        break;
      }
      y.i("MicroMsg.NetSceneShareCardSync", "need check is false");
      break;
    }
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q arg5, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(906), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte = (brm)this.dmK.ecF.ecN;
    if (paramArrayOfByte.dTx == null)
    {
      ??? = null;
      if (??? != null) {
        break label227;
      }
      paramInt1 = 0;
      label117:
      y.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.tIj), Long.valueOf(paramArrayOfByte.tIh) });
      if ((??? == null) || (???.size() <= 0)) {
        break label363;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label184:
      if (!???.hasNext()) {
        break label238;
      }
      if (a((brk)???.next())) {
        break label450;
      }
      paramInt1 += 1;
    }
    label450:
    for (;;)
    {
      break label184;
      ??? = paramArrayOfByte.dTx;
      break;
      label227:
      paramInt1 = ???.size();
      break label117;
      label238:
      y.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.aAz().azK();
      for (;;)
      {
        g.DP().Dz().c(ac.a.upg, Long.valueOf(paramArrayOfByte.tIh));
        am.aAz().ioy = paramArrayOfByte.ioy;
        if (paramArrayOfByte.tIj > 0)
        {
          y.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.tIj) });
          ??? = am.aAz();
          ???.mHandler.post(new a.2(???));
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        label363:
        y.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
        a locala = am.aAz();
        y.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.valueOf(true) });
        synchronized (locala.dMQ)
        {
          locala.ijT.addAll(locala.ijU);
          locala.ijU.clear();
          locala.azK();
        }
      }
    }
  }
  
  public final int getType()
  {
    return 906;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */