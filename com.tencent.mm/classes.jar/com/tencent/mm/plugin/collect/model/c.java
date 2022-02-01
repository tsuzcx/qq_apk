package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import java.io.IOException;

public final class c
  implements s
{
  private s.b oZP;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63773);
    this.oZP = new s.b()
    {
      public final Bitmap IR(String paramAnonymousString)
      {
        AppMethodBeat.i(63772);
        paramAnonymousString = g.decodeFile(paramAnonymousString, null);
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
    if (s.a.iNr == parama) {}
    try
    {
      g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.auC(this.url), false);
      AppMethodBeat.o(63775);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WalletGetPicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final boolean aQA()
  {
    return false;
  }
  
  public final Bitmap aQB()
  {
    return null;
  }
  
  public final void aQC() {}
  
  public final s.b aQv()
  {
    return this.oZP;
  }
  
  public final String aQw()
  {
    AppMethodBeat.i(63774);
    String str = b.auC(this.url);
    AppMethodBeat.o(63774);
    return str;
  }
  
  public final String aQx()
  {
    return this.url;
  }
  
  public final String aQy()
  {
    return this.url;
  }
  
  public final boolean aQz()
  {
    return true;
  }
  
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