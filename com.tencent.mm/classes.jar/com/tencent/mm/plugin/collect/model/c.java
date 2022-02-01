package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class c
  implements s
{
  private s.b qvE;
  private String url;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63773);
    this.qvE = new s.b()
    {
      public final Bitmap So(String paramAnonymousString)
      {
        AppMethodBeat.i(63772);
        paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
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
    if (s.a.jNh == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.aKj(this.url), false);
      AppMethodBeat.o(63775);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletGetPicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(63774);
    String str = b.aKj(this.url);
    AppMethodBeat.o(63774);
    return str;
  }
  
  public final String blB()
  {
    return this.url;
  }
  
  public final String blC()
  {
    return this.url;
  }
  
  public final boolean blD()
  {
    return true;
  }
  
  public final boolean blE()
  {
    return false;
  }
  
  public final Bitmap blF()
  {
    return null;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return this.qvE;
  }
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.c
 * JD-Core Version:    0.7.0.1
 */