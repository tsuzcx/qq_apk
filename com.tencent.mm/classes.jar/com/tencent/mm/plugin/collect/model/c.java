package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class c
  implements s
{
  private s.b nSZ;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63773);
    this.nSZ = new s.b()
    {
      public final Bitmap By(String paramAnonymousString)
      {
        AppMethodBeat.i(63772);
        paramAnonymousString = f.decodeFile(paramAnonymousString, null);
        AppMethodBeat.o(63772);
        return paramAnonymousString;
      }
    };
    this.url = paramString;
    AppMethodBeat.o(63773);
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(63775);
    if (s.a.hUk == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.akx(this.url), false);
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
  
  public final String aGA()
  {
    return this.url;
  }
  
  public final boolean aGB()
  {
    return true;
  }
  
  public final boolean aGC()
  {
    return false;
  }
  
  public final Bitmap aGD()
  {
    return null;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return this.nSZ;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(63774);
    String str = b.akx(this.url);
    AppMethodBeat.o(63774);
    return str;
  }
  
  public final String aGz()
  {
    return this.url;
  }
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.c
 * JD-Core Version:    0.7.0.1
 */