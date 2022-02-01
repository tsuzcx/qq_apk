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
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public t(String paramString)
  {
    AppMethodBeat.i(124313);
    d.a locala = new d.a();
    locala.iLN = new bnk();
    locala.iLO = new bnl();
    locala.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
    locala.funcId = 1367;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bnk)this.rr.iLK.iLR).KTt = paramString;
    AppMethodBeat.o(124313);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124315);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124315);
    return i;
  }
  
  public final int getType()
  {
    return 1367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124314);
    Log.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.t
 * JD-Core Version:    0.7.0.1
 */