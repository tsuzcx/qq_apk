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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.IOException;

public final class ai
  implements s
{
  protected String mPicUrl;
  
  public ai(String paramString)
  {
    AppMethodBeat.i(41574);
    this.mPicUrl = paramString;
    paramString = new e(b.ail());
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(41574);
  }
  
  public final void Z(String paramString, boolean paramBoolean) {}
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(41579);
    if (s.a.hUl == parama)
    {
      AppMethodBeat.o(41579);
      return paramBitmap;
    }
    try
    {
      f.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aGy(), false);
      AppMethodBeat.o(41579);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.GetGamePicStrategy", parama, "", new Object[0]);
      }
    }
  }
  
  public final void a(s.a parama, String paramString) {}
  
  public final String aGA()
  {
    AppMethodBeat.i(41576);
    String str = this.mPicUrl.hashCode();
    AppMethodBeat.o(41576);
    return str;
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
    AppMethodBeat.i(41578);
    Bitmap localBitmap = BitmapFactory.decodeResource(aj.getContext().getResources(), 2131233476);
    AppMethodBeat.o(41578);
    return localBitmap;
  }
  
  public final void aGE() {}
  
  public final s.b aGx()
  {
    return null;
  }
  
  public final String aGy()
  {
    AppMethodBeat.i(41575);
    String str = b.ail() + g.getMessageDigest(this.mPicUrl.getBytes());
    AppMethodBeat.o(41575);
    return str;
  }
  
  public final String aGz()
  {
    return this.mPicUrl;
  }
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(41577);
    String str = this.mPicUrl.hashCode();
    AppMethodBeat.o(41577);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ai
 * JD-Core Version:    0.7.0.1
 */