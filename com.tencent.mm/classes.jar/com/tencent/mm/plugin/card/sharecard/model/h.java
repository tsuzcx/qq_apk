package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.List;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private final com.tencent.mm.al.b rr;
  
  public h()
  {
    AppMethodBeat.i(112975);
    b.a locala = new b.a();
    locala.gUU = new cso();
    locala.gUV = new csp();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 1121;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((cso)this.rr.gUS.gUX).Eku = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhx, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(112975);
  }
  
  private static boolean b(csn paramcsn)
  {
    AppMethodBeat.i(112978);
    if (paramcsn == null)
    {
      ad.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(112978);
      return false;
    }
    ad.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramcsn.dyc, Long.valueOf(paramcsn.seq) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        ad.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramcsn.nvh) });
        switch (paramcsn.nvh)
        {
        case 0: 
          ad.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramcsn.nvh) });
          AppMethodBeat.o(112978);
          return false;
        }
      }
      catch (Exception paramcsn)
      {
        ad.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramcsn.getMessage() });
        AppMethodBeat.o(112978);
        return false;
      }
      am.bJc().a(paramcsn);
      if ((paramcsn.nvh != 0) && (paramcsn.nvh != 5))
      {
        localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FhF, "");
        bool = ((Boolean)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FhG, Boolean.FALSE)).booleanValue();
        if ((bool) && (!bt.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramcsn.dyc)))
        {
          ad.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.bIK();
        }
      }
      else
      {
        AppMethodBeat.o(112978);
        return true;
        localObject = am.bJc();
        if (paramcsn == null)
        {
          ad.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.bJd().QJ(paramcsn.dyc);
        am.bJd().QI(paramcsn.dyc);
        ad.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramcsn.dyc);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
    ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112977);
      return;
    }
    paramArrayOfByte = (csp)this.rr.gUT.gUX;
    if (paramArrayOfByte.gKs == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
      paramInt1 = 0;
      label130:
      ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.Ekv), Long.valueOf(paramArrayOfByte.seq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label197:
      if (!???.hasNext()) {
        break label251;
      }
      if (b((csn)???.next())) {
        break label474;
      }
      paramInt1 += 1;
    }
    label474:
    for (;;)
    {
      break label197;
      ??? = paramArrayOfByte.gKs;
      break;
      label240:
      paramInt1 = ???.size();
      break label130;
      label251:
      ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bJc().bIi();
      for (;;)
      {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhx, Long.valueOf(paramArrayOfByte.seq));
        am.bJc().nuZ = paramArrayOfByte.nuZ;
        if (paramArrayOfByte.Ekv > 0)
        {
          ad.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.Ekv) });
          ??? = am.bJc();
          ???.mHandler.post(new a.2(???));
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(112977);
        return;
        label382:
        ad.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
        a locala = am.bJc();
        ad.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        synchronized (locala.lock)
        {
          locala.pendingList.addAll(locala.npY);
          locala.npY.clear();
          locala.bIi();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */