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
  private static volatile WeakReference<Bitmap> gRP;
  
  public static Drawable aua()
  {
    AppMethodBeat.i(121064);
    if (gRP != null)
    {
      localObject = (Bitmap)gRP.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      gRP = new WeakReference(com.tencent.mm.compatible.e.a.decodeResource(aj.getResources(), 2131690805));
    }
    Object localObject = d.a(aj.getResources(), (Bitmap)gRP.get());
    ((b)localObject).dX();
    AppMethodBeat.o(121064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */