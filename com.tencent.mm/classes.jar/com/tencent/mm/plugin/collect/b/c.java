package com.tencent.mm.plugin.collect.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class c
  implements v
{
  private v.b iGL = new c.1(this);
  private String url;
  
  public c(String paramString)
  {
    this.url = paramString;
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return this.iGL;
  }
  
  public final String UO()
  {
    return b.KR(this.url);
  }
  
  public final String UP()
  {
    return this.url;
  }
  
  public final String UQ()
  {
    return this.url;
  }
  
  public final boolean UR()
  {
    return true;
  }
  
  public final boolean US()
  {
    return false;
  }
  
  public final Bitmap UT()
  {
    return null;
  }
  
  public final void UU() {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    if (v.a.eRD == parama) {}
    try
    {
      com.tencent.mm.sdk.platformtools.c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.KR(this.url), false);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      y.printErrStackTrace("MicroMsg.WalletGetPicStrategy", parama, "", new Object[0]);
    }
    return paramBitmap;
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.c
 * JD-Core Version:    0.7.0.1
 */