package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import java.io.IOException;

public final class m
  implements s
{
  public static final String oGh;
  public static final String oGi;
  private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
  private String mPicUrl = null;
  
  static
  {
    AppMethodBeat.i(112795);
    oGh = b.asj() + "card";
    oGi = oGh + "/video";
    AppMethodBeat.o(112795);
  }
  
  public m(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public static String Zk(String paramString)
  {
    AppMethodBeat.i(112792);
    paramString = String.format("%s/%s", new Object[] { oGh, g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(112792);
    return paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(112794);
    if (s.a.iQl == parama) {}
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
      ae.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      AppMethodBeat.o(112794);
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new k(aQV());
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ae.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
          h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
        }
        catch (IOException paramString)
        {
          ae.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", paramString, "", new Object[0]);
          ae.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final s.b aQU()
  {
    return null;
  }
  
  public final String aQV()
  {
    AppMethodBeat.i(112791);
    String str = String.format("%s/%s", new Object[] { oGh, g.getMessageDigest(this.mPicUrl.getBytes()) });
    AppMethodBeat.o(112791);
    return str;
  }
  
  public final String aQW()
  {
    return this.mPicUrl;
  }
  
  public final String aQX()
  {
    return this.mPicUrl;
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
    AppMethodBeat.i(112793);
    ae.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
    AppMethodBeat.o(112793);
    return null;
  }
  
  public final void aRb() {}
  
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