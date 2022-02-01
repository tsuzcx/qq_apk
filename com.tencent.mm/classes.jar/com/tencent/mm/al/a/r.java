package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i callback;
  Object data;
  public d rr;
  
  public r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(124307);
    d.a locala = new d.a();
    locala.iLN = new bjn();
    locala.iLO = new bjo();
    locala.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
    locala.funcId = 1354;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bjn)this.rr.iLK.iLR).KTt = paramString;
    this.data = paramObject;
    AppMethodBeat.o(124307);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124309);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124309);
    return i;
  }
  
  public final int getType()
  {
    return 1354;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124308);
    Log.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.r
 * JD-Core Version:    0.7.0.1
 */