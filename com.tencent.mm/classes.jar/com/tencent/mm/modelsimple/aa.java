package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.egm;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class aa
  extends q
  implements m
{
  private i callback;
  public final d rr;
  
  public aa(String paramString1, String paramString2, int paramInt, eae parameae)
  {
    AppMethodBeat.i(134202);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new egm();
    ((d.a)localObject).lBV = new egn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((d.a)localObject).funcId = 383;
    ((d.a)localObject).lBW = 180;
    ((d.a)localObject).respCmdId = 1000000180;
    this.rr = ((d.a)localObject).bgN();
    localObject = (egm)d.b.b(this.rr.lBR);
    ((egm)localObject).vhh = Util.getCutPasswordMD5(paramString1);
    ((egm)localObject).HlB = paramString2;
    ((egm)localObject).Ujg = paramInt;
    ((egm)localObject).RLV = parameae;
    Log.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Util.dumpHex(z.a(parameae)) });
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