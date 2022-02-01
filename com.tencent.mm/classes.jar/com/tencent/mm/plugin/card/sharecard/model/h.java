package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.List;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public h()
  {
    AppMethodBeat.i(112975);
    b.a locala = new b.a();
    locala.hNM = new ddk();
    locala.hNN = new ddl();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 1121;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((ddk)this.rr.hNK.hNQ).Hsa = ((Long)g.ajC().ajl().get(al.a.IrE, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(112975);
  }
  
  private static boolean b(ddj paramddj)
  {
    AppMethodBeat.i(112978);
    if (paramddj == null)
    {
      ad.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(112978);
      return false;
    }
    ad.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramddj.dHX, Long.valueOf(paramddj.seq) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        ad.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramddj.oBB) });
        switch (paramddj.oBB)
        {
        case 0: 
          ad.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramddj.oBB) });
          AppMethodBeat.o(112978);
          return false;
        }
      }
      catch (Exception paramddj)
      {
        ad.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramddj.getMessage() });
        AppMethodBeat.o(112978);
        return false;
      }
      am.bUU().a(paramddj);
      if ((paramddj.oBB != 0) && (paramddj.oBB != 5))
      {
        localObject = (String)g.ajC().ajl().get(al.a.IrM, "");
        bool = ((Boolean)g.ajC().ajl().get(al.a.IrN, Boolean.FALSE)).booleanValue();
        if ((bool) && (!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramddj.dHX)))
        {
          ad.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.bUC();
        }
      }
      else
      {
        AppMethodBeat.o(112978);
        return true;
        localObject = am.bUU();
        if (paramddj == null)
        {
          ad.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.bUV().YE(paramddj.dHX);
        am.bUV().YD(paramddj.dHX);
        ad.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramddj.dHX);
        if (localShareCardInfo != null) {
          com.tencent.mm.plugin.card.sharecard.a.b.a(aj.getContext(), localShareCardInfo);
        }
        for (;;)
        {
          ((a)localObject).onChange();
          break;
          ad.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
        }
      }
      if (bool) {
        ad.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
      } else {
        ad.i("MicroMsg.NetSceneShareCardSync", "need check is false");
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(112976);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112976);
    return i;
  }
  
  public final int getType()
  {
    return 1121;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q arg5, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112977);
    ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112977);
      return;
    }
    paramArrayOfByte = (ddl)this.rr.hNL.hNQ;
    if (paramArrayOfByte.hDb == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
      paramInt1 = 0;
      label130:
      ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.Hsb), Long.valueOf(paramArrayOfByte.seq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label197:
      if (!???.hasNext()) {
        break label251;
      }
      if (b((ddj)???.next())) {
        break label474;
      }
      paramInt1 += 1;
    }
    label474:
    for (;;)
    {
      break label197;
      ??? = paramArrayOfByte.hDb;
      break;
      label240:
      paramInt1 = ???.size();
      break label130;
      label251:
      ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bUU().bUa();
      for (;;)
      {
        g.ajC().ajl().set(al.a.IrE, Long.valueOf(paramArrayOfByte.seq));
        am.bUU().oBt = paramArrayOfByte.oBt;
        if (paramArrayOfByte.Hsb > 0)
        {
          ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.Hsb) });
          ??? = am.bUU();
          ???.mHandler.post(new a.2(???));
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(112977);
        return;
        label382:
        ad.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
        a locala = am.bUU();
        ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        synchronized (locala.lock)
        {
          locala.pendingList.addAll(locala.owt);
          locala.owt.clear();
          locala.bUa();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */