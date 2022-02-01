package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class m
  implements s
{
  public static final String ozF;
  public static final String ozG;
  private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
  private String mPicUrl = null;
  
  static
  {
    AppMethodBeat.i(112795);
    ozF = b.arU() + "card";
    ozG = ozF + "/video";
    AppMethodBeat.o(112795);
  }
  
  public m(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public static String Yt(String paramString)
  {
    AppMethodBeat.i(112792);
    paramString = String.format("%s/%s", new Object[] { ozF, com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()) });
    AppMethodBeat.o(112792);
    return paramString;
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(112794);
    if (s.a.iNr == parama) {}
    try
    {
      com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQw(), false);
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
          paramString = new e(aQw());
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ad.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
          com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQw(), false);
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
  
  public final boolean aQA()
  {
    return false;
  }
  
  public final Bitmap aQB()
  {
    AppMethodBeat.i(112793);
    ad.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
    AppMethodBeat.o(112793);
    return null;
  }
  
  public final void aQC() {}
  
  public final s.b aQv()
  {
    return null;
  }
  
  public final String aQw()
  {
    AppMethodBeat.i(112791);
    String str = String.format("%s/%s", new Object[] { ozF, com.tencent.mm.b.g.getMessageDigest(this.mPicUrl.getBytes()) });
    AppMethodBeat.o(112791);
    return str;
  }
  
  public final String aQx()
  {
    return this.mPicUrl;
  }
  
  public final String aQy()
  {
    return this.mPicUrl;
  }
  
  public final boolean aQz()
  {
    return true;
  }
  
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