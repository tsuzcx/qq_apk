package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class z
  extends m
  implements k
{
  private f callback;
  public final b rr;
  
  public z(String paramString1, String paramString2, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(123477);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cbc();
    ((b.a)localObject).fsY = new cbd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((b.a)localObject).funcId = 383;
    ((b.a)localObject).reqCmdId = 180;
    ((b.a)localObject).respCmdId = 1000000180;
    this.rr = ((b.a)localObject).ado();
    localObject = (cbc)this.rr.fsV.fta;
    ((cbc)localObject).lGy = bo.apO(paramString1);
    ((cbc)localObject).wQf = paramString2;
    ((cbc)localObject).xLW = paramInt;
    ((cbc)localObject).wrL = paramSKBuiltinBuffer_t;
    ab.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), bo.cd(aa.a(paramSKBuiltinBuffer_t)) });
    AppMethodBeat.o(123477);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(123478);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(123478);
    return i;
  }
  
  public final int getType()
  {
    return 383;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(123479);
    ab.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(123479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.z
 * JD-Core Version:    0.7.0.1
 */