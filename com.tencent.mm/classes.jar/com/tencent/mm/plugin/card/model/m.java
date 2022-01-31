package com.tencent.mm.plugin.card.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

public final class m
  implements v
{
  public static final String inc = e.bkH + "card";
  public static final String ind = inc + File.separator + "video";
  private final String TAG = "MicroMsg.CardSimpleGetPicStrategy";
  private String mPicUrl = null;
  
  public m(String paramString)
  {
    this.mPicUrl = paramString;
  }
  
  public static String yn(String paramString)
  {
    return String.format("%s/%s", new Object[] { inc, g.o(paramString.getBytes()) });
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    return String.format("%s/%s", new Object[] { inc, g.o(this.mPicUrl.getBytes()) });
  }
  
  public final String UP()
  {
    return this.mPicUrl;
  }
  
  public final String UQ()
  {
    return this.mPicUrl;
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
    y.d("MicroMsg.CardSimpleGetPicStrategy", "no sd card!");
    return null;
  }
  
  public final void UU() {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    if (v.a.eRD == parama) {}
    try
    {
      c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
      y.d("MicroMsg.CardSimpleGetPicStrategy", "get bitmap, from %s", new Object[] { parama.toString() });
      return paramBitmap;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = new File(UO());
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          y.w("MicroMsg.CardSimpleGetPicStrategy", " retry saving bitmap");
          c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
        }
        catch (IOException paramString)
        {
          y.printErrStackTrace("MicroMsg.CardSimpleGetPicStrategy", paramString, "", new Object[0]);
          y.w("MicroMsg.CardSimpleGetPicStrategy", "save bitmap fail");
        }
      }
    }
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.m
 * JD-Core Version:    0.7.0.1
 */