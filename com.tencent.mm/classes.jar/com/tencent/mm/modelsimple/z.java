package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class z
  extends n
  implements k
{
  private f callback;
  public final b rr;
  
  public z(String paramString1, String paramString2, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(134202);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dco();
    ((b.a)localObject).hNN = new dcp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((b.a)localObject).funcId = 383;
    ((b.a)localObject).hNO = 180;
    ((b.a)localObject).respCmdId = 1000000180;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dco)this.rr.hNK.hNQ;
    ((dco)localObject).qdZ = bt.aQY(paramString1);
    ((dco)localObject).xbo = paramString2;
    ((dco)localObject).HrA = paramInt;
    ((dco)localObject).FyU = paramSKBuiltinBuffer_t;
    ad.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), bt.cB(com.tencent.mm.platformtools.z.a(paramSKBuiltinBuffer_t)) });
    AppMethodBeat.o(134202);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(134203);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(134203);
    return i;
  }
  
  public final int getType()
  {
    return 383;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134204);
    ad.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.z
 * JD-Core Version:    0.7.0.1
 */