package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;

public final class ad
{
  private static volatile WeakReference<Bitmap> hKH;
  
  public static Drawable bzP()
  {
    AppMethodBeat.i(177515);
    if (hKH != null)
    {
      localObject = (Bitmap)hKH.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      hKH = new WeakReference(BitmapFactory.decodeResource(aj.getResources(), 2131233241));
    }
    Object localObject = d.a(aj.getResources(), (Bitmap)hKH.get());
    ((b)localObject).ez();
    AppMethodBeat.o(177515);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ad
 * JD-Core Version:    0.7.0.1
 */