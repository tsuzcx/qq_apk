package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class e
  implements b.h
{
  private static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(176006);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(176006);
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(176006);
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      AppMethodBeat.o(176006);
      return localBitmap;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      AppMethodBeat.o(176006);
    }
    return null;
  }
  
  public String BN()
  {
    return "RoundedBitmap";
  }
  
  public Bitmap G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(176005);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(176005);
      return paramBitmap;
    }
    Object localObject = d.a(ak.getResources(), paramBitmap);
    ((b)localObject).ez();
    localObject = drawableToBitmap((Drawable)localObject);
    if (localObject != paramBitmap) {
      paramBitmap.recycle();
    }
    AppMethodBeat.o(176005);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.e
 * JD-Core Version:    0.7.0.1
 */