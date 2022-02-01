package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;

public final class ac
{
  private static volatile WeakReference<Bitmap> gRP;
  
  public static Drawable boO()
  {
    AppMethodBeat.i(177515);
    if (gRP != null)
    {
      localObject = (Bitmap)gRP.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      gRP = new WeakReference(BitmapFactory.decodeResource(aj.getResources(), 2131233241));
    }
    Object localObject = d.a(aj.getResources(), (Bitmap)gRP.get());
    ((b)localObject).dX();
    AppMethodBeat.o(177515);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ac
 * JD-Core Version:    0.7.0.1
 */