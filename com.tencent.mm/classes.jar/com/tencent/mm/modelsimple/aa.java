package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwm;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class aa
  extends q
  implements m
{
  private i callback;
  public final d rr;
  
  public aa(String paramString1, String paramString2, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(134202);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dwm();
    ((d.a)localObject).iLO = new dwn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((d.a)localObject).funcId = 383;
    ((d.a)localObject).iLP = 180;
    ((d.a)localObject).respCmdId = 1000000180;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dwm)this.rr.iLK.iLR;
    ((dwm)localObject).rBz = Util.getCutPasswordMD5(paramString1);
    ((dwm)localObject).Bri = paramString2;
    ((dwm)localObject).MWL = paramInt;
    ((dwm)localObject).KKZ = paramSKBuiltinBuffer_t;
    Log.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Util.dumpHex(z.a(paramSKBuiltinBuffer_t)) });
    AppMethodBeat.o(134202);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(134203);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(134203);
    return i;
  }
  
  public final int getType()
  {
    return 383;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134204);
    Log.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.aa
 * JD-Core Version:    0.7.0.1
 */