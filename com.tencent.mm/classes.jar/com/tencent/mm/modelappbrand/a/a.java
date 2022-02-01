package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> hsp;
  
  public static Drawable aAR()
  {
    AppMethodBeat.i(121064);
    if (hsp != null)
    {
      localObject = (Bitmap)hsp.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      hsp = new WeakReference(com.tencent.mm.compatible.e.a.decodeResource(ai.getResources(), 2131690805));
    }
    Object localObject = d.a(ai.getResources(), (Bitmap)hsp.get());
    ((b)localObject).ei();
    AppMethodBeat.o(121064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */