package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class m
  implements s
{
  public static final String nWl;
  public static final String nWm;
  private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
  private String mPicUrl = null;
  
  static
  {
    AppMethodBeat.i(112795);
    nWl = b.aph() + "card";
    nWm = nWl + "/video";
    AppMethodBeat.o(112795);
  }
  
  public m(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public static String UK(String paramString)
  {
    AppMethodBeat.i(112792);
    paramString = String.format("%s/%s", new Object[] { nWl, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(112792);
    return paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(112794);
    if (s.a.iuo == parama) {}
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
      ac.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(112794);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new e(aNl());
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ac.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
          f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aNl(), false);
        }
        catch (IOException paramString)
        {
          ac.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", paramString, "", new Object[0]);
          ac.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aNk()
  {
    return null;
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(112791);
    String str = String.format("%s/%s", new Object[] { nWl, g.getMessageDigest(this.mPicUrl.getBytes()) });
    AppMethodBeat.o(112791);
    return str;
  }
  
  public final String aNm()
  {
    return this.mPicUrl;
  }
  
  public final String aNn()
  {
    return this.mPicUrl;
  }
  
  public final boolean aNo()
  {
    return true;
  }
  
  public final boolean aNp()
  {
    return false;
  }
  
  public final Bitmap aNq()
  {
    AppMethodBeat.i(112793);
    ac.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
    AppMethodBeat.o(112793);
    return null;
  }
  
  public final void aNr() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.m
 * JD-Core Version:    0.7.0.1
 */