package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
  implements e
{
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77081);
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    AppMethodBeat.o(77081);
    return paramConfig;
  }
  
  public final Bitmap g(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77082);
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    AppMethodBeat.o(77082);
    return paramConfig;
  }
  
  public void g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77080);
    paramBitmap.recycle();
    AppMethodBeat.o(77080);
  }
  
  public final void oZ() {}
  
  public final void trimMemory(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.a.f
 * JD-Core Version:    0.7.0.1
 */