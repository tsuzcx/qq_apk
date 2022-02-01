package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class m
  implements s
{
  public static final String pTN;
  public static final String pTO;
  private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
  private String mPicUrl = null;
  
  static
  {
    AppMethodBeat.i(112795);
    pTN = b.aKJ() + "card";
    pTO = pTN + "/video";
    AppMethodBeat.o(112795);
  }
  
  public m(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public static String ajp(String paramString)
  {
    AppMethodBeat.i(112792);
    paramString = String.format("%s/%s", new Object[] { pTN, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(112792);
    return paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(112794);
    if (s.a.jNh == parama) {}
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
      Log.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(112794);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new o(blA());
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          Log.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
          BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
        }
        catch (IOException paramString)
        {
          Log.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", paramString, "", new Object[0]);
          Log.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(112791);
    String str = String.format("%s/%s", new Object[] { pTN, g.getMessageDigest(this.mPicUrl.getBytes()) });
    AppMethodBeat.o(112791);
    return str;
  }
  
  public final String blB()
  {
    return this.mPicUrl;
  }
  
  public final String blC()
  {
    return this.mPicUrl;
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
    AppMethodBeat.i(112793);
    Log.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
    AppMethodBeat.o(112793);
    return null;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return null;
  }
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.m
 * JD-Core Version:    0.7.0.1
 */