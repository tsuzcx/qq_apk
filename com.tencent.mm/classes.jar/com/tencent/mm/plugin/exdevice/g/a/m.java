package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  public int hYl;
  public String nSt;
  private c rr;
  public String yuk;
  
  public m(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23534);
    this.callback = null;
    this.rr = null;
    this.yuk = paramString3;
    this.nSt = paramString2;
    this.hYl = paramInt;
    this.yuk = paramString3;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dht();
    ((c.a)localObject).otF = new dhu();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/addlike";
    ((c.a)localObject).funcId = 1041;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dht)c.b.b(this.rr.otB);
    ((dht)localObject).appusername = paramString2;
    ((dht)localObject).username = paramString1;
    ((dht)localObject).hYl = paramInt;
    ((dht)localObject).nRL = paramString3;
    AppMethodBeat.o(23534);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23535);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23535);
    return i;
  }
  
  public final int getType()
  {
    return 1041;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23536);
    Log.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.m
 * JD-Core Version:    0.7.0.1
 */