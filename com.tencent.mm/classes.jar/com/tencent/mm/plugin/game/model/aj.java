package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.a;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

public final class aj
  implements v
{
  protected String mPicUrl;
  
  public aj(String paramString)
  {
    this.mPicUrl = paramString;
    paramString = new File(e.dzF);
    if (!paramString.exists()) {
      paramString.mkdir();
    }
  }
  
  public final void S(String paramString, boolean paramBoolean) {}
  
  public final v.b UN()
  {
    return null;
  }
  
  public final String UO()
  {
    return e.dzF + g.o(this.mPicUrl.getBytes());
  }
  
  public final String UP()
  {
    return this.mPicUrl;
  }
  
  public final String UQ()
  {
    return this.mPicUrl.hashCode();
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
    return BitmapFactory.decodeResource(ae.getContext().getResources(), g.d.nosdcard_chatting_bg);
  }
  
  public final void UU() {}
  
  public final Bitmap a(Bitmap paramBitmap, v.a parama, String paramString)
  {
    if (v.a.eRE == parama) {
      return paramBitmap;
    }
    try
    {
      c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, UO(), false);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      y.printErrStackTrace("MicroMsg.GetGamePicStrategy", parama, "", new Object[0]);
    }
    return paramBitmap;
  }
  
  public final void a(v.a parama, String paramString) {}
  
  public final String getCacheKey()
  {
    return this.mPicUrl.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aj
 * JD-Core Version:    0.7.0.1
 */