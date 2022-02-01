package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private String lyn;
  c rr;
  
  public m(String paramString)
  {
    AppMethodBeat.i(241435);
    this.lyn = paramString;
    paramString = new c.a();
    paramString.otE = new ako();
    paramString.otF = new akp();
    paramString.uri = "/cgi-bin/micromsg-bin/dismisschatroom";
    paramString.funcId = 6217;
    this.rr = paramString.bEF();
    ((ako)c.b.b(this.rr.otB)).ZrP = this.lyn;
    AppMethodBeat.o(241435);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(241440);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(241440);
    return i;
  }
  
  public final int getType()
  {
    return 6217;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(241436);
    Log.d("MicroMsg.NetSceneExtFunctionSwitch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.i("MicroMsg.NetSceneExtFunctionSwitch", "return is 0.now we parse the json and resetList..");
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(241436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.m
 * JD-Core Version:    0.7.0.1
 */