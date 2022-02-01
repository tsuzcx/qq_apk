package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.b;
import androidx.core.graphics.drawable.d;
import com.tencent.luggage.m.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public final class as
{
  private static volatile WeakReference<Bitmap> oqj;
  
  public static Drawable cLN()
  {
    AppMethodBeat.i(177515);
    if (oqj != null)
    {
      localObject = (Bitmap)oqj.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      oqj = new WeakReference(BitmapFactory.decodeResource(MMApplicationContext.getResources(), a.c.miniprogram_default_avatar));
    }
    Object localObject = d.a(MMApplicationContext.getResources(), (Bitmap)oqj.get());
    ((b)localObject).DL();
    AppMethodBeat.o(177515);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.as
 * JD-Core Version:    0.7.0.1
 */