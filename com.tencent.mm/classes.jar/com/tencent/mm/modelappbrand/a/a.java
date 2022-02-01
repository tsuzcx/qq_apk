package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> iIF;
  
  public static Drawable aXX()
  {
    AppMethodBeat.i(121064);
    if (iIF != null)
    {
      localObject = (Bitmap)iIF.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      iIF = new WeakReference(com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getResources(), 2131691091));
    }
    Object localObject = d.a(MMApplicationContext.getResources(), (Bitmap)iIF.get());
    ((b)localObject).eD();
    AppMethodBeat.o(121064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */