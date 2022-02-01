package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public final class ae
{
  private static volatile WeakReference<Bitmap> hNA;
  
  public static Drawable bAK()
  {
    AppMethodBeat.i(177515);
    if (hNA != null)
    {
      localObject = (Bitmap)hNA.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      hNA = new WeakReference(BitmapFactory.decodeResource(ak.getResources(), 2131233241));
    }
    Object localObject = d.a(ak.getResources(), (Bitmap)hNA.get());
    ((b)localObject).ez();
    AppMethodBeat.o(177515);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ae
 * JD-Core Version:    0.7.0.1
 */