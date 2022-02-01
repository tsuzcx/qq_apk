package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.List;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b rr;
  
  public h()
  {
    AppMethodBeat.i(112975);
    b.a locala = new b.a();
    locala.hvt = new cxx();
    locala.hvu = new cxy();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 1121;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((cxx)this.rr.hvr.hvw).FHs = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFm, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(112975);
  }
  
  private static boolean b(cxw paramcxw)
  {
    AppMethodBeat.i(112978);
    if (paramcxw == null)
    {
      ac.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(112978);
      return false;
    }
    ac.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramcxw.dvO, Long.valueOf(paramcxw.seq) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        ac.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramcxw.nYh) });
        switch (paramcxw.nYh)
        {
        case 0: 
          ac.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramcxw.nYh) });
          AppMethodBeat.o(112978);
          return false;
        }
      }
      catch (Exception paramcxw)
      {
        ac.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramcxw.getMessage() });
        AppMethodBeat.o(112978);
        return false;
      }
      am.bQp().a(paramcxw);
      if ((paramcxw.nYh != 0) && (paramcxw.nYh != 5))
      {
        localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFu, "");
        bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFv, Boolean.FALSE)).booleanValue();
        if ((bool) && (!bs.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramcxw.dvO)))
        {
          ac.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.bPX();
        }
      }
      else
      {
        AppMethodBeat.o(112978);
        return true;
        localObject = am.bQp();
        if (paramcxw == null)
        {
          ac.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.bQq().UV(paramcxw.dvO);
        am.bQq().UU(paramcxw.dvO);
        ac.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramcxw.dvO);
        if (localShareCardInfo != null) {
          com.tencent.mm.plugin.card.sharecard.a.b.a(ai.getContext(), localShareCardInfo);
        }
        for (;;)
        {
          ((a)localObject).onChange();
          break;
          ac.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
        }
      }
      if (bool) {
        ac.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
      } else {
        ac.i("MicroMsg.NetSceneShareCardSync", "need check is false");
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(112976);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112977);
      return;
    }
    paramArrayOfByte = (cxy)this.rr.hvs.hvw;
    if (paramArrayOfByte.hkS == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
      paramInt1 = 0;
      label130:
      ac.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.FHt), Long.valueOf(paramArrayOfByte.seq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label197:
      if (!???.hasNext()) {
        break label251;
      }
      if (b((cxw)???.next())) {
        break label474;
      }
      paramInt1 += 1;
    }
    label474:
    for (;;)
    {
      break label197;
      ??? = paramArrayOfByte.hkS;
      break;
      label240:
      paramInt1 = ???.size();
      break label130;
      label251:
      ac.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bQp().bPv();
      for (;;)
      {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GFm, Long.valueOf(paramArrayOfByte.seq));
        am.bQp().nXZ = paramArrayOfByte.nXZ;
        if (paramArrayOfByte.FHt > 0)
        {
          ac.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.FHt) });
          ??? = am.bQp();
          ???.mHandler.post(new a.2(???));
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(112977);
        return;
        label382:
        ac.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
        a locala = am.bQp();
        ac.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        synchronized (locala.lock)
        {
          locala.pendingList.addAll(locala.nSY);
          locala.nSY.clear();
          locala.bPv();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */