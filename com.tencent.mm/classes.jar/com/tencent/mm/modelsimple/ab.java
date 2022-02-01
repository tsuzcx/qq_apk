package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.protocal.protobuf.fai;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ab
  extends p
  implements m
{
  private h callback;
  public final c rr;
  
  public ab(String paramString1, String paramString2, int paramInt, gol paramgol)
  {
    AppMethodBeat.i(134202);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fah();
    ((c.a)localObject).otF = new fai();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((c.a)localObject).funcId = 383;
    ((c.a)localObject).otG = 180;
    ((c.a)localObject).respCmdId = 1000000180;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fah)c.b.b(this.rr.otB);
    ((fah)localObject).ytj = Util.getCutPasswordMD5(paramString1);
    ((fah)localObject).Njp = paramString2;
    ((fah)localObject).aajL = paramInt;
    ((fah)localObject).YJj = paramgol;
    Log.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Util.dumpHex(w.a(paramgol)) });
    AppMethodBeat.o(134202);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(134203);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ab
 * JD-Core Version:    0.7.0.1
 */