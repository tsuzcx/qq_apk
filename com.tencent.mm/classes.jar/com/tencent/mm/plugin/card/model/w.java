package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.List;

public final class w
  extends q
  implements m
{
  private i callback;
  private byte[] lTj;
  private final d rr;
  private int tqi;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(112824);
    this.tqi = 0;
    Log.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new uz();
    ((d.a)localObject).lBV = new va();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((d.a)localObject).funcId = 1047;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = new cqd();
    ((cqd)localObject).trU = ((String)h.aHG().aHp().get(ar.a.VhS, null));
    ((cqd)localObject).latitude = am.cHy().iQD;
    ((cqd)localObject).longitude = am.cHy().iQE;
    uz localuz = (uz)d.b.b(this.rr.lBR);
    localuz.SfH = 1;
    localuz.SfJ = ((cqd)localObject);
    localuz.SfK = paramInt;
    this.tqi = paramInt;
    AppMethodBeat.o(112824);
  }
  
  private static boolean a(abu paramabu)
  {
    AppMethodBeat.i(112827);
    if (paramabu == null)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(112827);
      return false;
    }
    byte[] arrayOfByte = z.a(paramabu.SnH);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(112827);
      return false;
    }
    Log.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramabu.SnG) });
    try
    {
      switch (paramabu.SnG)
      {
      case 1: 
        Log.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramabu.SnG) });
        AppMethodBeat.o(112827);
        return false;
      }
    }
    catch (Exception paramabu)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramabu.getMessage() });
      AppMethodBeat.o(112827);
      return false;
    }
    paramabu = (vd)new vd().parseFrom(arrayOfByte);
    Log.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramabu.rVU) });
    switch (paramabu.rVU)
    {
    }
    for (;;)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramabu.SgC) });
      AppMethodBeat.o(112827);
      return false;
      am.cHr().a(paramabu);
      AppMethodBeat.o(112827);
      return true;
      break;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112825);
    this.callback = parami;
    parami = (uz)d.b.b(this.rr.lBR);
    this.lTj = Util.decodeHexString(Util.nullAsNil((String)h.aHG().aHp().b(282880, null)));
    if ((this.lTj == null) || (this.lTj.length == 0)) {
      Log.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    parami.SfI = z.aN(this.lTj);
    if (this.lTj == null) {}
    for (int i = 0;; i = this.lTj.length)
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
    paramArrayOfByte = (va)d.c.b(this.rr.lBS);
    if (paramArrayOfByte.SfM == 1) {
      Log.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.lTj = z.a(paramArrayOfByte.SfI, new byte[0]);
    if (paramArrayOfByte.SfL == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.lTj != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.Saq) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((abu)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.SfL.rVy;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.lTj.length;
      break label161;
      label290:
      Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.cHr().cGF();
      for (;;)
      {
        h.aHG().aHp().i(282880, Util.encodeHexString(this.lTj));
        label421:
        b localb;
        if (paramArrayOfByte.Saq > 0)
        {
          Log.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.Saq) });
          paramInt1 = doScene(dispatcher(), this.callback);
          if (paramInt1 <= 0)
          {
            Log.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
            this.callback.onSceneEnd(3, -1, paramString, this);
          }
          AppMethodBeat.o(112826);
          return;
          Log.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          localb = am.cHr();
          Log.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
        }
        synchronized (localb.lock)
        {
          localb.pendingList.addAll(localb.tmE);
          localb.tmE.clear();
          localb.cGF();
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