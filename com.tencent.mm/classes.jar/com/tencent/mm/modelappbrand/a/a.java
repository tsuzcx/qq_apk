package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> hKH;
  
  public static Drawable aDU()
  {
    AppMethodBeat.i(121064);
    if (hKH != null)
    {
      localObject = (Bitmap)hKH.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      hKH = new WeakReference(com.tencent.mm.compatible.e.a.decodeResource(aj.getResources(), 2131690805));
    }
    Object localObject = d.a(aj.getResources(), (Bitmap)hKH.get());
    ((b)localObject).ez();
    AppMethodBeat.o(121064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */