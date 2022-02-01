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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import java.io.IOException;

public final class ai
  implements s
{
  protected String mPicUrl;
  
  public ai(String paramString)
  {
    AppMethodBeat.i(41574);
    this.mPicUrl = paramString;
    paramString = new k(b.aso());
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    AppMethodBeat.o(41574);
  }
  
  public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
  {
    AppMethodBeat.i(41579);
    if (s.a.iQm == parama)
    {
      AppMethodBeat.o(41579);
      return paramBitmap;
    }
    try
    {
      h.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, aQV(), false);
      AppMethodBeat.o(41579);
      return paramBitmap;
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.GetGamePicStrategy", parama, "", new Object[0]);
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
    AppMethodBeat.i(41575);
    String str = b.aso() + g.getMessageDigest(this.mPicUrl.getBytes());
    AppMethodBeat.o(41575);
    return str;
  }
  
  public final String aQW()
  {
    return this.mPicUrl;
  }
  
  public final String aQX()
  {
    AppMethodBeat.i(41576);
    String str = this.mPicUrl.hashCode();
    AppMethodBeat.o(41576);
    return str;
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
    AppMethodBeat.i(41578);
    Bitmap localBitmap = BitmapFactory.decodeResource(ak.getContext().getResources(), 2131233476);
    AppMethodBeat.o(41578);
    return localBitmap;
  }
  
  public final void aRb() {}
  
  public final void aa(String paramString, boolean paramBoolean) {}
  
  public final String getCacheKey()
  {
    AppMethodBeat.i(41577);
    String str = this.mPicUrl.hashCode();
    AppMethodBeat.o(41577);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ai
 * JD-Core Version:    0.7.0.1
 */