package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;

public final class c
  implements s
{
  private s.b pgt;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63773);
    this.pgt = new s.b()
    {
      public final Bitmap Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(63772);
        paramAnonymousString = h.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(63772);
        return paramAnonymousString;
      }
    };
    this.url = paramString;
    AppMethodBeat.o(63773);
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(63775);
    if (s.a.iQl == parama) {}
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.avR(this.url), false);
      AppMethodBeat.o(63775);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletGetPicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aQU()
  {
    return this.pgt;
  }
  
  public final String aQV()
  {
    AppMethodBeat.i(63774);
    String str = b.avR(this.url);
    AppMethodBeat.o(63774);
    return str;
  }
  
  public final String aQW()
  {
    return this.url;
  }
  
  public final String aQX()
  {
    return this.url;
  }
  
  public final boolean aQY()
  {
    return true;
  }
  
  public final boolean aQZ()
  {
    return false;
  }
  
  public final Bitmap aRa()
  {
    return null;
  }
  
  public final void aRb() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.c
 * JD-Core Version:    0.7.0.1
 */