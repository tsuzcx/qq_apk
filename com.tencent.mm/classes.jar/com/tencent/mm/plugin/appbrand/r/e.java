package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;

public class e
  extends q
  implements m
{
  private i jQg;
  private a<e> qii;
  public final d rr;
  
  protected e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, int paramInt5, a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, false, paramString4, paramInt5);
    this.qii = parama;
  }
  
  private e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString4, int paramInt5)
  {
    AppMethodBeat.i(280652);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]  sessionId [%s]  avatarOpt [%d]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString4, Integer.valueOf(paramInt5) });
    this.rr = iX(paramBoolean).bgN();
    cno localcno = (cno)d.b.b(this.rr.lBR);
    localcno.lVG = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      localcno.rVk = new b(paramString1);
      localcno.Tvg = paramString3;
      localcno.TuP = paramInt1;
      localcno.TuO = paramInt3;
      localcno.SrG = paramInt2;
      localcno.Tvh = paramInt5;
      localcno.session_id = paramString4;
      if (paramInt4 > 0)
      {
        localcno.TuQ = new foh();
        localcno.TuQ.scene = paramInt4;
      }
      AppMethodBeat.o(280652);
      return;
    }
  }
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString4, int paramInt5, a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString4, paramInt5);
    this.qii = parama;
  }
  
  public final void Cb(int paramInt)
  {
    AppMethodBeat.i(47755);
    cno localcno = (cno)d.b.b(this.rr.lBR);
    if (localcno.TuQ == null) {
      localcno.TuQ = new foh();
    }
    localcno.TuQ.UMw = paramInt;
    AppMethodBeat.o(47755);
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(47757);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene hash=%d, funcid=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rr.getType()) });
    this.jQg = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(47757);
    return i;
  }
  
  public int getType()
  {
    return 1133;
  }
  
  protected d.a iX(boolean paramBoolean)
  {
    AppMethodBeat.i(280654);
    d.a locala = f.iX(paramBoolean);
    AppMethodBeat.o(280654);
    return locala;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(47756);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "onGYNetEnd, hash[%d] errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.qii != null) {
      this.qii.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(47756);
  }
  
  public static abstract interface a<T extends q>
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.e
 * JD-Core Version:    0.7.0.1
 */