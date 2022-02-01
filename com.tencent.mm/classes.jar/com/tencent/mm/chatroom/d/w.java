package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exc;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class w
  extends q
  implements m
{
  private i callback;
  private String errMsg;
  public String fHp;
  public exd iWF;
  private final d rr;
  
  public w(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(186540);
    Log.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", new Object[] { Util.nullAs(paramString1, "") });
    Object localObject = new d.a();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
    ((d.a)localObject).funcId = 3927;
    ((d.a)localObject).lBU = new exc();
    ((d.a)localObject).lBV = new exd();
    this.rr = ((d.a)localObject).bgN();
    this.fHp = paramString1;
    localObject = (exc)d.b.b(this.rr.lBR);
    ((exc)localObject).fHp = paramString1;
    ((exc)localObject).fAo = paramString2;
    ((exc)localObject).scene = paramInt;
    AppMethodBeat.o(186540);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(182095);
    this.callback = parami;
    this.iWF = ((exd)d.c.b(this.rr.lBS));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.w
 * JD-Core Version:    0.7.0.1
 */