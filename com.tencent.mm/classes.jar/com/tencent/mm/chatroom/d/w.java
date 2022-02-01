package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.emu;
import com.tencent.mm.protocal.protobuf.emv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class w
  extends q
  implements m
{
  private i callback;
  public String dOe;
  private String errMsg;
  public emv gsu;
  private final d rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(194032);
    Log.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", new Object[] { Util.nullAs(paramString1, "") });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
    ((d.a)localObject).funcId = 3927;
    ((d.a)localObject).iLN = new emu();
    ((d.a)localObject).iLO = new emv();
    this.rr = ((d.a)localObject).aXF();
    this.dOe = paramString1;
    localObject = (emu)this.rr.iLK.iLR;
    ((emu)localObject).dOe = paramString1;
    ((emu)localObject).dHx = paramString2;
    ((emu)localObject).scene = paramInt;
    AppMethodBeat.o(194032);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(182095);
    this.callback = parami;
    this.gsu = ((emv)this.rr.iLL.iLR);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(182095);
    return i;
  }
  
  public final int getType()
  {
    return 3927;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(182096);
    Log.d("MicroMsg.NetSceneUpgradeAssociateChatRoom", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(182096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.w
 * JD-Core Version:    0.7.0.1
 */