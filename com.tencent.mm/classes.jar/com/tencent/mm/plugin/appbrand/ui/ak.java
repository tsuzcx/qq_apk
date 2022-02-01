package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.tencent.luggage.l.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public final class ak
{
  private static volatile WeakReference<Bitmap> lyI;
  
  public static Drawable ckz()
  {
    AppMethodBeat.i(177515);
    if (lyI != null)
    {
      localObject = (Bitmap)lyI.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      lyI = new WeakReference(BitmapFactory.decodeResource(MMApplicationContext.getResources(), a.c.miniprogram_default_avatar));
    }
    Object localObject = d.a(MMApplicationContext.getResources(), (Bitmap)lyI.get());
    ((b)localObject).gB();
    AppMethodBeat.o(177515);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ak
 * JD-Core Version:    0.7.0.1
 */