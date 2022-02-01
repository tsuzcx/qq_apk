package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.protocal.protobuf.vb;
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
  private byte[] jcK;
  private int pUh;
  private final d rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(112824);
    this.pUh = 0;
    Log.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[] { Integer.valueOf(1) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ux();
    ((d.a)localObject).iLO = new uy();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/cardsync";
    ((d.a)localObject).funcId = 1047;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = new chh();
    ((chh)localObject).pVT = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTS, null));
    ((chh)localObject).latitude = am.ctW().gmu;
    ((chh)localObject).longitude = am.ctW().gmv;
    ux localux = (ux)this.rr.iLK.iLR;
    localux.Leu = 1;
    localux.Lew = ((chh)localObject);
    localux.Lex = paramInt;
    this.pUh = paramInt;
    AppMethodBeat.o(112824);
  }
  
  private static boolean a(abn paramabn)
  {
    AppMethodBeat.i(112827);
    if (paramabn == null)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
      AppMethodBeat.o(112827);
      return false;
    }
    byte[] arrayOfByte = z.a(paramabn.Lmt);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
      AppMethodBeat.o(112827);
      return false;
    }
    Log.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramabn.Lms) });
    try
    {
      switch (paramabn.Lms)
      {
      case 1: 
        Log.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[] { Integer.valueOf(paramabn.Lms) });
        AppMethodBeat.o(112827);
        return false;
      }
    }
    catch (Exception paramabn)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[] { paramabn.getMessage() });
      AppMethodBeat.o(112827);
      return false;
    }
    paramabn = (vb)new vb().parseFrom(arrayOfByte);
    Log.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[] { Integer.valueOf(paramabn.oTW) });
    switch (paramabn.oTW)
    {
    }
    for (;;)
    {
      Log.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[] { Integer.valueOf(paramabn.Lfo) });
      AppMethodBeat.o(112827);
      return false;
      am.ctP().a(paramabn);
      AppMethodBeat.o(112827);
      return true;
      break;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112825);
    this.callback = parami;
    parami = (ux)this.rr.iLK.iLR;
    this.jcK = Util.decodeHexString(Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(282880, null)));
    if ((this.jcK == null) || (this.jcK.length == 0)) {
      Log.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
    }
    parami.Lev = z.aC(this.jcK);
    if (this.jcK == null) {}
    for (int i = 0;; i = this.jcK.length)
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
    paramArrayOfByte = (uy)this.rr.iLL.iLR;
    if (paramArrayOfByte.Lez == 1) {
      Log.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
    }
    this.jcK = z.a(paramArrayOfByte.Lev, new byte[0]);
    if (paramArrayOfByte.Ley == null)
    {
      ??? = null;
      if (??? != null) {
        break label270;
      }
      paramInt1 = 0;
      label152:
      if (this.jcK != null) {
        break label281;
      }
      paramInt2 = 0;
      label161:
      Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.KZh) });
      if ((??? == null) || (???.size() <= 0)) {
        break label421;
      }
      paramInt1 = 0;
      ??? = ???.iterator();
      label224:
      if (!???.hasNext()) {
        break label290;
      }
      if (a((abn)???.next())) {
        break label535;
      }
      paramInt1 += 1;
    }
    label270:
    label535:
    for (;;)
    {
      break label224;
      ??? = paramArrayOfByte.Ley.oTA;
      break;
      paramInt1 = ???.size();
      break label152;
      label281:
      paramInt2 = this.jcK.length;
      break label161;
      label290:
      Log.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[] { Integer.valueOf(paramInt1) });
      am.ctP().ctd();
      for (;;)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(282880, Util.encodeHexString(this.jcK));
        if (paramArrayOfByte.KZh > 0)
        {
          Log.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[] { Integer.valueOf(paramArrayOfByte.KZh) });
          paramInt1 = doScene(dispatcher(), this.callback);
          if (paramInt1 <= 0)
          {
            Log.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[] { Integer.valueOf(paramInt1) });
            this.callback.onSceneEnd(3, -1, paramString, this);
          }
          AppMethodBeat.o(112826);
          return;
          label421:
          Log.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
          b localb = am.ctP();
          Log.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[] { Boolean.TRUE });
          synchronized (localb.lock)
          {
            localb.pendingList.addAll(localb.pQE);
            localb.pQE.clear();
            localb.ctd();
          }
        }
      }
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(112826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.w
 * JD-Core Version:    0.7.0.1
 */