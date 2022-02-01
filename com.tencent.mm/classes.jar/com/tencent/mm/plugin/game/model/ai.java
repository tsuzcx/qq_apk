package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class ai
  implements s
{
  protected String mPicUrl;
  
  public ai(String paramString)
  {
    AppMethodBeat.i(41574);
    this.mPicUrl = paramString;
    paramString = new o(b.aKO());
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(41574);
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(41579);
    if (s.a.jNi == parama)
    {
      AppMethodBeat.o(41579);
      return paramBitmap;
    }
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
      AppMethodBeat.o(41579);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.GetGamePicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final void ad(String paramString, boolean paramBoolean) {}
  
  public final String blA()
  {
    AppMethodBeat.i(41575);
    String str = b.aKO() + g.getMessageDigest(this.mPicUrl.getBytes());
    AppMethodBeat.o(41575);
    return str;
  }
  
  public final String blB()
  {
    return this.mPicUrl;
  }
  
  public final String blC()
  {
    AppMethodBeat.i(41576);
    String str = this.mPicUrl.hashCode();
    AppMethodBeat.o(41576);
    return str;
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
    AppMethodBeat.i(41578);
    Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
    AppMethodBeat.o(41578);
    return localBitmap;
  }
  
  public final void blG() {}
  
  public final s.b blz()
  {
    return null;
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(41577);
    String str = this.mPicUrl.hashCode();
    AppMethodBeat.o(41577);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ai
 * JD-Core Version:    0.7.0.1
 */