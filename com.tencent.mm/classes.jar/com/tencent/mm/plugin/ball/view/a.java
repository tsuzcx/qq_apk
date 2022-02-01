package com.tencent.mm.plugin.ball.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.f;

public final class a
  implements b.h
{
  public static final a nij;
  
  static
  {
    AppMethodBeat.i(106375);
    nij = new a();
    AppMethodBeat.o(106375);
  }
  
  public final String Ap()
  {
    return "FloatBallIcon";
  }
  
  public final Bitmap F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(106374);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(106374);
      return paramBitmap;
    }
    paramBitmap = f.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    AppMethodBeat.o(106374);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.a
 * JD-Core Version:    0.7.0.1
 */