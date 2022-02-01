package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d.c.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> oqj;
  
  public static Drawable bEX()
  {
    AppMethodBeat.i(121064);
    if (oqj != null)
    {
      localObject = (Bitmap)oqj.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      oqj = new WeakReference(com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getResources(), c.d.miniprogram_default_avatar));
    }
    Object localObject = d.a(MMApplicationContext.getResources(), (Bitmap)oqj.get());
    ((b)localObject).DL();
    AppMethodBeat.o(121064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */