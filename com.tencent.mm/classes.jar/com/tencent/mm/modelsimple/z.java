package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class z
  extends n
  implements k
{
  private g callback;
  public final b rr;
  
  public z(String paramString1, String paramString2, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(134202);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cxb();
    ((b.a)localObject).hvu = new cxc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((b.a)localObject).funcId = 383;
    ((b.a)localObject).reqCmdId = 180;
    ((b.a)localObject).respCmdId = 1000000180;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cxb)this.rr.hvr.hvw;
    ((cxb)localObject).pAu = bs.aLs(paramString1);
    ((cxb)localObject).Ewu = paramString2;
    ((cxb)localObject).FGS = paramInt;
    ((cxb)localObject).DTA = paramSKBuiltinBuffer_t;
    ac.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), bs.cu(com.tencent.mm.platformtools.z.a(paramSKBuiltinBuffer_t)) });
    AppMethodBeat.o(134202);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(134203);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(134204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.z
 * JD-Core Version:    0.7.0.1
 */