package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class c
  implements v
{
  private v.b kMO;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(40923);
    this.kMO = new c.1(this);
    this.url = paramString;
    AppMethodBeat.o(40923);
  }
  
  public final void W(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    AppMethodBeat.i(40925);
    if (v.a.gjx == parama) {}
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.WX(this.url), false);
      AppMethodBeat.o(40925);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletGetPicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final v.b aom()
  {
    return this.kMO;
  }
  
  public final String aon()
  {
    AppMethodBeat.i(40924);
    String str = b.WX(this.url);
    AppMethodBeat.o(40924);
    return str;
  }
  
  public final String aoo()
  {
    return this.url;
  }
  
  public final String aop()
  {
    return this.url;
  }
  
  public final boolean aoq()
  {
    return true;
  }
  
  public final boolean aor()
  {
    return false;
  }
  
  public final Bitmap aos()
  {
    return null;
  }
  
  public final void aot() {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.c
 * JD-Core Version:    0.7.0.1
 */