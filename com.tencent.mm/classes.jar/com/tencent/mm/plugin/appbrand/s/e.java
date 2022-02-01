package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;

public class e
  extends p
  implements m
{
  private h mAY;
  public final c rr;
  private e.a<e> tmU;
  
  protected e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, int paramInt5, boolean paramBoolean, e.a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, false, paramString4, paramInt5, paramBoolean);
    this.tmU = parama;
  }
  
  private e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString4, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(319852);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]  sessionId [%s]  avatarOpt [%d]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString4, Integer.valueOf(paramInt5) });
    this.rr = kf(paramBoolean1).bEF();
    deg localdeg = (deg)c.b.b(this.rr.otB);
    localdeg.oOI = paramString1;
    if (paramString2.getBytes() == null) {}
    for (paramString1 = new byte[0];; paramString1 = paramString2.getBytes())
    {
      localdeg.vgA = new b(paramString1);
      localdeg.aaJM = paramString3;
      localdeg.aaJu = paramInt1;
      localdeg.aaJt = paramInt3;
      localdeg.ZqK = paramInt2;
      localdeg.aaJN = paramInt5;
      localdeg.session_id = paramString4;
      localdeg.aaJw = paramBoolean2;
      if (paramInt4 > 0)
      {
        localdeg.aaJv = new glg();
        localdeg.aaJv.scene = paramInt4;
      }
      AppMethodBeat.o(319852);
      return;
    }
  }
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString4, int paramInt5, boolean paramBoolean2, e.a<e> parama)
  {
    this(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramString4, paramInt5, paramBoolean2);
    this.tmU = parama;
  }
  
  public final void Cq(int paramInt)
  {
    AppMethodBeat.i(47755);
    deg localdeg = (deg)c.b.b(this.rr.otB);
    if (localdeg.aaJv == null) {
      localdeg.aaJv = new glg();
    }
    localdeg.aaJv.acgQ = paramInt;
    AppMethodBeat.o(47755);
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(47757);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene hash=%d, funcid=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.rr.getType()) });
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(47757);
    return i;
  }
  
  public int getType()
  {
    return 1133;
  }
  
  protected c.a kf(boolean paramBoolean)
  {
    AppMethodBeat.i(319858);
    c.a locala = f.kf(paramBoolean);
    AppMethodBeat.o(319858);
    return locala;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(47756);
    Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "onGYNetEnd, hash[%d] errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.tmU != null) {
      this.tmU.onNetSceneEndCallback(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(47756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.e
 * JD-Core Version:    0.7.0.1
 */