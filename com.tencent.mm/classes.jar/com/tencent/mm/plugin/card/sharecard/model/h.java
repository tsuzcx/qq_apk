package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.List;

public final class h
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public h()
  {
    AppMethodBeat.i(112975);
    d.a locala = new d.a();
    locala.iLN = new dxi();
    locala.iLO = new dxj();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 1121;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((dxi)this.rr.iLK.iLR).MXl = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUc, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(112975);
  }
  
  private static boolean b(dxh paramdxh)
  {
    AppMethodBeat.i(112978);
    if (paramdxh == null)
    {
      Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(112978);
      return false;
    }
    Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramdxh.eaO, Long.valueOf(paramdxh.seq) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramdxh.pVR) });
        switch (paramdxh.pVR)
        {
        case 0: 
          Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramdxh.pVR) });
          AppMethodBeat.o(112978);
          return false;
        }
      }
      catch (Exception paramdxh)
      {
        Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramdxh.getMessage() });
        AppMethodBeat.o(112978);
        return false;
      }
      am.ctX().a(paramdxh);
      if ((paramdxh.pVR != 0) && (paramdxh.pVR != 5))
      {
        localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUk, "");
        bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NUl, Boolean.FALSE)).booleanValue();
        if ((bool) && (!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramdxh.eaO)))
        {
          Log.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.ctF();
        }
      }
      else
      {
        AppMethodBeat.o(112978);
        return true;
        localObject = am.ctX();
        if (paramdxh == null)
        {
          Log.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.ctY().ajA(paramdxh.eaO);
        am.ctY().ajz(paramdxh.eaO);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramdxh.eaO);
        if (localShareCardInfo != null) {
          b.a(MMApplicationContext.getContext(), localShareCardInfo);
        }
        for (;;)
        {
          ((a)localObject).onChange();
          break;
          Log.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
        }
      }
      if (bool) {
        Log.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
      } else {
        Log.i("MicroMsg.NetSceneShareCardSync", "need check is false");
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112976);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112976);
    return i;
  }
  
  public final int getType()
  {
    return 1121;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s arg5, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112977);
    Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112977);
      return;
    }
    paramArrayOfByte = (dxj)this.rr.iLL.iLR;
    if (paramArrayOfByte.iAd == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
      paramInt1 = 0;
      label130:
      Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.MXm), Long.valueOf(paramArrayOfByte.seq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label197:
      if (!???.hasNext()) {
        break label251;
      }
      if (b((dxh)???.next())) {
        break label474;
      }
      paramInt1 += 1;
    }
    label474:
    for (;;)
    {
      break label197;
      ??? = paramArrayOfByte.iAd;
      break;
      label240:
      paramInt1 = ???.size();
      break label130;
      label251:
      Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.ctX().ctd();
      for (;;)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NUc, Long.valueOf(paramArrayOfByte.seq));
        am.ctX().pVJ = paramArrayOfByte.pVJ;
        if (paramArrayOfByte.MXm > 0)
        {
          Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.MXm) });
          ??? = am.ctX();
          ???.mHandler.post(new a.2(???));
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(112977);
        return;
        label382:
        Log.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
        a locala = am.ctX();
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        synchronized (locala.lock)
        {
          locala.pendingList.addAll(locala.pQE);
          locala.pQE.clear();
          locala.ctd();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */