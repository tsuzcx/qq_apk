package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.List;

public final class h
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public h()
  {
    AppMethodBeat.i(112975);
    b.a locala = new b.a();
    locala.hQF = new dee();
    locala.hQG = new def();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 1121;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((dee)this.rr.hQD.hQJ).HLC = ((Long)g.ajR().ajA().get(am.a.IMa, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(112975);
  }
  
  private static boolean b(ded paramded)
  {
    AppMethodBeat.i(112978);
    if (paramded == null)
    {
      ae.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(112978);
      return false;
    }
    ae.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramded.dJb, Long.valueOf(paramded.seq) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        ae.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramded.oId) });
        switch (paramded.oId)
        {
        case 0: 
          ae.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramded.oId) });
          AppMethodBeat.o(112978);
          return false;
        }
      }
      catch (Exception paramded)
      {
        ae.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramded.getMessage() });
        AppMethodBeat.o(112978);
        return false;
      }
      am.bWj().a(paramded);
      if ((paramded.oId != 0) && (paramded.oId != 5))
      {
        localObject = (String)g.ajR().ajA().get(am.a.IMi, "");
        bool = ((Boolean)g.ajR().ajA().get(am.a.IMj, Boolean.FALSE)).booleanValue();
        if ((bool) && (!bu.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramded.dJb)))
        {
          ae.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.bVR();
        }
      }
      else
      {
        AppMethodBeat.o(112978);
        return true;
        localObject = am.bWj();
        if (paramded == null)
        {
          ae.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.bWk().Zv(paramded.dJb);
        am.bWk().Zu(paramded.dJb);
        ae.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramded.dJb);
        if (localShareCardInfo != null) {
          com.tencent.mm.plugin.card.sharecard.a.b.a(ak.getContext(), localShareCardInfo);
        }
        for (;;)
        {
          ((a)localObject).onChange();
          break;
          ae.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
        }
      }
      if (bool) {
        ae.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
      } else {
        ae.i("MicroMsg.NetSceneShareCardSync", "need check is false");
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
    ae.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112977);
      return;
    }
    paramArrayOfByte = (def)this.rr.hQE.hQJ;
    if (paramArrayOfByte.hFT == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
      paramInt1 = 0;
      label130:
      ae.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.HLD), Long.valueOf(paramArrayOfByte.seq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label197:
      if (!???.hasNext()) {
        break label251;
      }
      if (b((ded)???.next())) {
        break label474;
      }
      paramInt1 += 1;
    }
    label474:
    for (;;)
    {
      break label197;
      ??? = paramArrayOfByte.hFT;
      break;
      label240:
      paramInt1 = ???.size();
      break label130;
      label251:
      ae.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bWj().bVp();
      for (;;)
      {
        g.ajR().ajA().set(am.a.IMa, Long.valueOf(paramArrayOfByte.seq));
        am.bWj().oHV = paramArrayOfByte.oHV;
        if (paramArrayOfByte.HLD > 0)
        {
          ae.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.HLD) });
          ??? = am.bWj();
          ???.mHandler.post(new a.2(???));
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(112977);
        return;
        label382:
        ae.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
        a locala = am.bWj();
        ae.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        synchronized (locala.lock)
        {
          locala.pendingList.addAll(locala.oCV);
          locala.oCV.clear();
          locala.bVp();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */