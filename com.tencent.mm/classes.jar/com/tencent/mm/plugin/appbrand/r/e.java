package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;

public class e
  extends q
  implements m
{
  private i heq;
  private a<e> nhz;
  public final d rr;
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, false);
    this.nhz = parama;
  }
  
  private e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(227220);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.rr = id(paramBoolean).aXF();
    ceu localceu = (ceu)this.rr.iLK.iLR;
    localceu.jfi = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      localceu.oTm = new b(paramString1);
      localceu.Mkp = paramString3;
      localceu.MjZ = paramInt1;
      localceu.MjY = paramInt3;
      localceu.Lqj = paramInt2;
      if (paramInt4 > 0)
      {
        localceu.Mka = new fdg();
        localceu.Mka.scene = paramInt4;
      }
      AppMethodBeat.o(227220);
      return;
    }
  }
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    this.nhz = parama;
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(47757);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene hash=%d, funcid=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rr.getType()) });
    this.heq = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(47757);
    return i;
  }
  
  public int getType()
  {
    return 1133;
  }
  
  protected d.a id(boolean paramBoolean)
  {
    AppMethodBeat.i(227221);
    d.a locala = f.id(paramBoolean);
    AppMethodBeat.o(227221);
    return locala;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(47756);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "onGYNetEnd, hash[%d] errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.nhz != null) {
      this.nhz.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(47756);
  }
  
  public final void yB(int paramInt)
  {
    AppMethodBeat.i(47755);
    ceu localceu = (ceu)this.rr.iLK.iLR;
    if (localceu.Mka == null) {
      localceu.Mka = new fdg();
    }
    localceu.Mka.NyS = paramInt;
    AppMethodBeat.o(47755);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.e
 * JD-Core Version:    0.7.0.1
 */