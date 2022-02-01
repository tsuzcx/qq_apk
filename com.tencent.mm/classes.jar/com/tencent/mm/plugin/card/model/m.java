package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class m
  implements s
{
  public static final String ntl;
  public static final String ntm;
  private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
  private String mPicUrl = null;
  
  static
  {
    AppMethodBeat.i(112795);
    ntl = b.aih() + "card";
    ntm = ntl + "/video";
    AppMethodBeat.o(112795);
  }
  
  public m(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public static String Qy(String paramString)
  {
    AppMethodBeat.i(112792);
    paramString = String.format("%s/%s", new Object[] { ntl, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(112792);
    return paramString;
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(112794);
    if (s.a.hUk == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
      ad.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(112794);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new e(aGy());
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ad.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
        }
        catch (IOException paramString)
        {
          ad.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", paramString, "", new Object[0]);
          ad.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final String aGA()
  {
    return this.mPicUrl;
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
    AppMethodBeat.i(112793);
    ad.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
    AppMethodBeat.o(112793);
    return null;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(112791);
    String str = String.format("%s/%s", new Object[] { ntl, g.getMessageDigest(this.mPicUrl.getBytes()) });
    AppMethodBeat.o(112791);
    return str;
  }
  
  public final String aGz()
  {
    return this.mPicUrl;
  }
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.m
 * JD-Core Version:    0.7.0.1
 */