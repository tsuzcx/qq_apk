package com.tencent.mm.plugin.collect.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class c
  implements p
{
  private String url;
  private p.b wXZ;
  
  public c(String paramString)
  {
    AppMethodBeat.i(63773);
    this.wXZ = new p.b()
    {
      public final Bitmap Se(String paramAnonymousString)
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
  
  public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
  {
    AppMethodBeat.i(63775);
    if (p.a.pAS == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, b.aRP(this.url), false);
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
  
  public final void a(p.a parama) {}
  
  public final p.b bTB()
  {
    return this.wXZ;
  }
  
  public final String bTC()
  {
    AppMethodBeat.i(63774);
    String str = b.aRP(this.url);
    AppMethodBeat.o(63774);
    return str;
  }
  
  public final String bTD()
  {
    return this.url;
  }
  
  public final String bTE()
  {
    return this.url;
  }
  
  public final boolean bTF()
  {
    return true;
  }
  
  public final boolean bTG()
  {
    return false;
  }
  
  public final Bitmap bTH()
  {
    return null;
  }
  
  public final void bTI() {}
  
  public final void bTJ() {}
  
  public final String getCacheKey()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.c
 * JD-Core Version:    0.7.0.1
 */