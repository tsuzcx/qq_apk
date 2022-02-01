package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> hNA;
  
  public static Drawable aEk()
  {
    AppMethodBeat.i(121064);
    if (hNA != null)
    {
      localObject = (Bitmap)hNA.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      hNA = new WeakReference(com.tencent.mm.compatible.e.a.decodeResource(ak.getResources(), 2131690805));
    }
    Object localObject = d.a(ak.getResources(), (Bitmap)hNA.get());
    ((b)localObject).ez();
    AppMethodBeat.o(121064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */