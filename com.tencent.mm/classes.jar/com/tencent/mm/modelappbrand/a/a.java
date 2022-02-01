package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c.c.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> lyI;
  
  public static Drawable bhg()
  {
    AppMethodBeat.i(121064);
    if (lyI != null)
    {
      localObject = (Bitmap)lyI.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      lyI = new WeakReference(com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getResources(), c.d.miniprogram_default_avatar));
    }
    Object localObject = d.a(MMApplicationContext.getResources(), (Bitmap)lyI.get());
    ((b)localObject).gB();
    AppMethodBeat.o(121064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */