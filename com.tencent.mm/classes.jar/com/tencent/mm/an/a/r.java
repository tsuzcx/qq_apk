package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends p
  implements m
{
  private h callback;
  Object cpt;
  public c rr;
  
  public r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(124307);
    c.a locala = new c.a();
    locala.otE = new cfn();
    locala.otF = new cfo();
    locala.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
    locala.funcId = 1354;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((cfn)c.b.b(this.rr.otB)).YRQ = paramString;
    this.cpt = paramObject;
    AppMethodBeat.o(124307);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124309);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.a.r
 * JD-Core Version:    0.7.0.1
 */