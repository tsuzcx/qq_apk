package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> fqk;
  
  public static Drawable acC()
  {
    AppMethodBeat.i(93748);
    if (fqk != null)
    {
      localObject = (Bitmap)fqk.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      fqk = new WeakReference(com.tencent.mm.compatible.g.a.decodeResource(ah.getResources(), 2131231647));
    }
    Object localObject = d.a(ah.getResources(), (Bitmap)fqk.get());
    ((b)localObject).cS();
    AppMethodBeat.o(93748);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */