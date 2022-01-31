package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import org.json.JSONObject;

public final class b$1
  implements a
{
  public b$1(b paramb, String paramString, b.a parama) {}
  
  public final void DO(String paramString)
  {
    AppMethodBeat.i(108132);
    this.isE.isA.remove(paramString);
    AppMethodBeat.o(108132);
  }
  
  public final void H(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108130);
    ab.e("MicroMsg.AppBrandNetworkDownload", "download error! errorMessage:%s, filename %s, url %s", new Object[] { paramString3, paramString1, paramString2 });
    b.a(this.isE, this.hwk);
    paramString1 = this.isD;
    int i = b.FAILED;
    paramString1.BE(paramString3);
    AppMethodBeat.o(108130);
  }
  
  public final void a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108129);
    this.isD.g(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(108129);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(108127);
    b.a(this.isE, this.hwk);
    this.isD.c(b.SUCCESS, paramString2, paramString1, paramInt);
    ab.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", new Object[] { paramString1, paramString3 });
    AppMethodBeat.o(108127);
  }
  
  public final void cM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108131);
    ab.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(108131);
  }
  
  public final void v(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(108128);
    this.isD.v(paramJSONObject);
    AppMethodBeat.o(108128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.b.1
 * JD-Core Version:    0.7.0.1
 */