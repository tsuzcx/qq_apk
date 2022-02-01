package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.protocal.protobuf.dpn;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private final String dOe;
  private final d rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151212);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dpm();
    ((d.a)localObject).iLO = new dpn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
    ((d.a)localObject).funcId = 772;
    this.rr = ((d.a)localObject).aXF();
    this.dOe = paramString1;
    localObject = (dpm)this.rr.iLK.iLR;
    ((dpm)localObject).dOe = paramString1;
    ((dpm)localObject).dTx = paramString2;
    Log.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151212);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151214);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151214);
    return i;
  }
  
  public final int getType()
  {
    return 772;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151213);
    Log.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dOe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.m
 * JD-Core Version:    0.7.0.1
 */