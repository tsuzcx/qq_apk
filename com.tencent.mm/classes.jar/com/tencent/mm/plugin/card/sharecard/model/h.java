package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.protocal.protobuf.ehi;
import com.tencent.mm.protocal.protobuf.ehj;
import com.tencent.mm.protocal.protobuf.ehk;
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
    locala.lBU = new ehj();
    locala.lBV = new ehk();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 1121;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((ehj)d.b.b(this.rr.lBR)).UjG = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vic, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(112975);
  }
  
  private static boolean b(ehi paramehi)
  {
    AppMethodBeat.i(112978);
    if (paramehi == null)
    {
      Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(112978);
      return false;
    }
    Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramehi.fUL, Long.valueOf(paramehi.seq) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramehi.trS) });
        switch (paramehi.trS)
        {
        case 0: 
          Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramehi.trS) });
          AppMethodBeat.o(112978);
          return false;
        }
      }
      catch (Exception paramehi)
      {
        Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramehi.getMessage() });
        AppMethodBeat.o(112978);
        return false;
      }
      am.cHz().a(paramehi);
      if ((paramehi.trS != 0) && (paramehi.trS != 5))
      {
        localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vik, "");
        bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vil, Boolean.FALSE)).booleanValue();
        if ((bool) && (!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramehi.fUL)))
        {
          Log.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          com.tencent.mm.plugin.card.b.k.cHh();
        }
      }
      else
      {
        AppMethodBeat.o(112978);
        return true;
        localObject = am.cHz();
        if (paramehi == null)
        {
          Log.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.cHA().arn(paramehi.fUL);
        am.cHA().arm(paramehi.fUL);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramehi.fUL);
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
  
  public final int doScene(g paramg, i parami)
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
    paramArrayOfByte = (ehk)d.c.b(this.rr.lBS);
    if (paramArrayOfByte.lpz == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
    }
    label240:
    for (paramInt1 = 0;; paramInt1 = ???.size())
    {
      Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.UjH), Long.valueOf(paramArrayOfByte.seq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      while (???.hasNext())
      {
        if (b((ehi)???.next())) {
          break label474;
        }
        paramInt1 += 1;
      }
      ??? = paramArrayOfByte.lpz;
      break;
    }
    Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
    am.cHz().cGF();
    for (;;)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vic, Long.valueOf(paramArrayOfByte.seq));
      am.cHz().trK = paramArrayOfByte.trK;
      if (paramArrayOfByte.UjH > 0)
      {
        Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.UjH) });
        ??? = am.cHz();
        ???.mHandler.post(new a.2(???));
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112977);
      return;
      label382:
      Log.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
      a locala = am.cHz();
      Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
      label474:
      synchronized (locala.lock)
      {
        locala.pendingList.addAll(locala.tmE);
        locala.tmE.clear();
        locala.cGF();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */