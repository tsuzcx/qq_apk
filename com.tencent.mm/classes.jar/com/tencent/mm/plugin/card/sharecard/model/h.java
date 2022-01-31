package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.protocal.protobuf.cbx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

public final class h
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public h()
  {
    AppMethodBeat.i(88036);
    b.a locala = new b.a();
    locala.fsX = new cbw();
    locala.fsY = new cbx();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 906;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((cbw)this.rr.fsV.fta).xMw = ((Long)g.RL().Ru().get(ac.a.yzc, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(88036);
  }
  
  private static boolean b(cbv paramcbv)
  {
    AppMethodBeat.i(88039);
    if (paramcbv == null)
    {
      ab.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(88039);
      return false;
    }
    ab.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramcbv.cHn, Long.valueOf(paramcbv.xyE) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        ab.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramcbv.kpN) });
        switch (paramcbv.kpN)
        {
        case 0: 
          ab.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramcbv.kpN) });
          AppMethodBeat.o(88039);
          return false;
        }
      }
      catch (Exception paramcbv)
      {
        ab.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramcbv.getMessage() });
        AppMethodBeat.o(88039);
        return false;
      }
      am.bck().a(paramcbv);
      if ((paramcbv.kpN != 0) && (paramcbv.kpN != 5))
      {
        localObject = (String)g.RL().Ru().get(ac.a.yzk, "");
        bool = ((Boolean)g.RL().Ru().get(ac.a.yzl, Boolean.FALSE)).booleanValue();
        if ((bool) && (!bo.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramcbv.cHn)))
        {
          ab.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.bbS();
        }
      }
      else
      {
        AppMethodBeat.o(88039);
        return true;
        localObject = am.bck();
        if (paramcbv == null)
        {
          ab.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.bcl().HZ(paramcbv.cHn);
        am.bcl().HY(paramcbv.cHn);
        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramcbv.cHn);
        if (localShareCardInfo != null) {
          com.tencent.mm.plugin.card.sharecard.a.b.a(ah.getContext(), localShareCardInfo);
        }
        for (;;)
        {
          ((a)localObject).onChange();
          break;
          ab.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
        }
      }
      if (bool) {
        ab.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
      } else {
        ab.i("MicroMsg.NetSceneShareCardSync", "need check is false");
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(88037);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88037);
    return i;
  }
  
  public final int getType()
  {
    return 906;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q arg5, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88038);
    ab.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(88038);
      return;
    }
    paramArrayOfByte = (cbx)this.rr.fsW.fta;
    if (paramArrayOfByte.fjy == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
      paramInt1 = 0;
      label130:
      ab.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.xMx), Long.valueOf(paramArrayOfByte.xyE) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label197:
      if (!???.hasNext()) {
        break label251;
      }
      if (b((cbv)???.next())) {
        break label474;
      }
      paramInt1 += 1;
    }
    label474:
    for (;;)
    {
      break label197;
      ??? = paramArrayOfByte.fjy;
      break;
      label240:
      paramInt1 = ???.size();
      break label130;
      label251:
      ab.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.bck().bbq();
      for (;;)
      {
        g.RL().Ru().set(ac.a.yzc, Long.valueOf(paramArrayOfByte.xyE));
        am.bck().kpF = paramArrayOfByte.kpF;
        if (paramArrayOfByte.xMx > 0)
        {
          ab.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.xMx) });
          ??? = am.bck();
          ???.mHandler.post(new a.2(???));
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(88038);
        return;
        label382:
        ab.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
        a locala = am.bck();
        ab.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        synchronized (locala.eKs)
        {
          locala.pendingList.addAll(locala.kkT);
          locala.kkT.clear();
          locala.bbq();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */