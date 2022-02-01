package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fsv;
import com.tencent.mm.protocal.protobuf.fsw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class z
  extends p
  implements m
{
  private h callback;
  private String errMsg;
  public String hMM;
  public fsw lyJ;
  private final c rr;
  
  public z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(241439);
    Log.i("MicroMsg.NetSceneUpgradeAssociateChatRoom", "NetSceneUpgradeAssociateChatRoom roomname:%s", new Object[] { Util.nullAs(paramString1, "") });
    Object localObject = new c.a();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/upgradeassociatechatroom";
    ((c.a)localObject).funcId = 3927;
    ((c.a)localObject).otE = new fsv();
    ((c.a)localObject).otF = new fsw();
    this.rr = ((c.a)localObject).bEF();
    this.hMM = paramString1;
    localObject = (fsv)c.b.b(this.rr.otB);
    ((fsv)localObject).hMM = paramString1;
    ((fsv)localObject).hFb = paramString2;
    ((fsv)localObject).scene = paramInt;
    AppMethodBeat.o(241439);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(182095);
    this.callback = paramh;
    this.lyJ = ((fsw)c.c.b(this.rr.otC));
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
 * Qualified Name:     com.tencent.mm.chatroom.d.z
 * JD-Core Version:    0.7.0.1
 */