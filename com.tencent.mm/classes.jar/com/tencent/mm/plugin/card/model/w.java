package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.plugin.card.mgr.a;
import com.tencent.mm.plugin.card.mgr.k;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.List;

public final class w
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private byte[] oMc;
  private final c rr;
  private int wuH;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(112824);
    this.wuH = 0;
    Log.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new wq();
    ((c.a)localObject).otF = new wr();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((c.a)localObject).funcId = 1047;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = new dgx();
    ((dgx)localObject).wws = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJm, null));
    ((dgx)localObject).latitude = am.dkP().lsz;
    ((dgx)localObject).longitude = am.dkP().lsA;
    wq localwq = (wq)c.b.b(this.rr.otB);
    localwq.ZdC = 1;
    localwq.ZdE = ((dgx)localObject);
    localwq.ZdF = paramInt;
    this.wuH = paramInt;
    AppMethodBeat.o(112824);
  }
  
  private static boolean a(adw paramadw)
  {
    AppMethodBeat.i(112827);
    if (paramadw == null)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(112827);
      return false;
    }
    byte[] arrayOfByte = com.tencent.mm.platformtools.w.a(paramadw.Zmd);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(112827);
      return false;
    }
    Log.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramadw.Zmc) });
    try
    {
      switch (paramadw.Zmc)
      {
      case 1: 
        Log.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramadw.Zmc) });
        AppMethodBeat.o(112827);
        return false;
      }
    }
    catch (Exception paramadw)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramadw.getMessage() });
      AppMethodBeat.o(112827);
      return false;
    }
    paramadw = (wu)new wu().parseFrom(arrayOfByte);
    Log.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramadw.vhk) });
    switch (paramadw.vhk)
    {
    }
    for (;;)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramadw.ZeA) });
      AppMethodBeat.o(112827);
      return false;
      am.dkI().a(paramadw);
      AppMethodBeat.o(112827);
      return true;
      break;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(112825);
    this.callback = paramh;
    paramh = (wq)c.b.b(this.rr.otB);
    this.oMc = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(282880, null)));
    if ((this.oMc == null) || (this.oMc.length == 0)) {
      Log.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    paramh.ZdD = com.tencent.mm.platformtools.w.aN(this.oMc);
    if (this.oMc == null) {}
    for (int i = 0;; i = this.oMc.length)
    {
      Log.i("MicroMsg.NetSceneCardSync", "doScene, keyBuf.length = %d", new Object[] { Integer.valueOf(i) });
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(112825);
      return i;
    }
  }
  
  public final int getType()
  {
    return 1047;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s arg5, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112826);
    Log.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
    paramArrayOfByte = (wr)c.c.b(this.rr.otC);
    if (paramArrayOfByte.ZdH == 1) {
      Log.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.oMc = com.tencent.mm.platformtools.w.a(paramArrayOfByte.ZdD, new byte[0]);
    if (paramArrayOfByte.ZdG == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.oMc != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.YYp) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((adw)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.ZdG.vgO;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.oMc.length;
      break label161;
      label290:
      Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.dkI().djW();
      for (;;)
      {
        com.tencent.mm.kernel.h.baE().ban().B(282880, Util.encodeHexString(this.oMc));
        label421:
        a locala;
        if (paramArrayOfByte.YYp > 0)
        {
          Log.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.YYp) });
          paramInt1 = doScene(dispatcher(), this.callback);
          if (paramInt1 <= 0)
          {
            Log.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
            this.callback.onSceneEnd(3, -1, paramString, this);
          }
          AppMethodBeat.o(112826);
          return;
          Log.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          locala = am.dkI();
          Log.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        }
        synchronized (locala.lock)
        {
          locala.pendingList.addAll(locala.wre);
          locala.wre.clear();
          locala.djW();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.w
 * JD-Core Version:    0.7.0.1
 */