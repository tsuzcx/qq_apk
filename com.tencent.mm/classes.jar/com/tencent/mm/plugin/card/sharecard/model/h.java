package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.mgr.j;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.protocal.protobuf.fbj;
import com.tencent.mm.protocal.protobuf.fbk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.List;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  public h()
  {
    AppMethodBeat.i(112975);
    c.a locala = new c.a();
    locala.otE = new fbj();
    locala.otF = new fbk();
    locala.uri = "/cgi-bin/micromsg-bin/sharecardsync";
    locala.funcId = 1121;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((fbj)c.b.b(this.rr.otB)).abBl = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJw, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(112975);
  }
  
  private static boolean b(fbi paramfbi)
  {
    AppMethodBeat.i(112978);
    if (paramfbi == null)
    {
      Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
      AppMethodBeat.o(112978);
      return false;
    }
    Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[] { paramfbi.iaI, Long.valueOf(paramfbi.seq) });
    for (;;)
    {
      Object localObject;
      boolean bool;
      try
      {
        Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[] { Integer.valueOf(paramfbi.wwq) });
        switch (paramfbi.wwq)
        {
        case 0: 
          Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramfbi.wwq) });
          AppMethodBeat.o(112978);
          return false;
        }
      }
      catch (Exception paramfbi)
      {
        Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[] { paramfbi.getMessage() });
        AppMethodBeat.o(112978);
        return false;
      }
      am.dkQ().a(paramfbi);
      if ((paramfbi.wwq != 0) && (paramfbi.wwq != 5))
      {
        localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJE, "");
        bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJF, Boolean.FALSE)).booleanValue();
        if ((bool) && (!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals(paramfbi.iaI)))
        {
          Log.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
          j.dky();
        }
      }
      else
      {
        AppMethodBeat.o(112978);
        return true;
        localObject = am.dkQ();
        if (paramfbi == null)
        {
          Log.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
          continue;
        }
        ShareCardInfo localShareCardInfo = am.dkR().akS(paramfbi.iaI);
        am.dkR().akR(paramfbi.iaI);
        Log.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + paramfbi.iaI);
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(112976);
    this.callback = paramh;
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
    paramArrayOfByte = (fbk)c.c.b(this.rr.otC);
    if (paramArrayOfByte.nUC == null)
    {
      ??? = null;
      if (??? != null) {
        break label240;
      }
    }
    label240:
    for (paramInt1 = 0;; paramInt1 = ???.size())
    {
      Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.abBm), Long.valueOf(paramArrayOfByte.seq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label382;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      while (???.hasNext())
      {
        if (b((fbi)???.next())) {
          break label474;
        }
        paramInt1 += 1;
      }
      ??? = paramArrayOfByte.nUC;
      break;
    }
    Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[] { Integer.valueOf(paramInt1) });
    am.dkQ().djW();
    for (;;)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acJw, Long.valueOf(paramArrayOfByte.seq));
      am.dkQ().wwi = paramArrayOfByte.wwi;
      if (paramArrayOfByte.abBm > 0)
      {
        Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.abBm) });
        ??? = am.dkQ();
        ???.mHandler.post(new a.2(???));
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112977);
      return;
      label382:
      Log.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
      a locala = am.dkQ();
      Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[] { Boolean.TRUE });
      label474:
      synchronized (locala.lock)
      {
        locala.pendingList.addAll(locala.wre);
        locala.wre.clear();
        locala.djW();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.h
 * JD-Core Version:    0.7.0.1
 */