package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;

public final class ab
{
  private static volatile WeakReference<Bitmap> hsp;
  
  public static Drawable bvJ()
  {
    AppMethodBeat.i(177515);
    if (hsp != null)
    {
      localObject = (Bitmap)hsp.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      hsp = new WeakReference(BitmapFactory.decodeResource(ai.getResources(), 2131233241));
    }
    Object localObject = d.a(ai.getResources(), (Bitmap)hsp.get());
    ((b)localObject).ei();
    AppMethodBeat.o(177515);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ab
 * JD-Core Version:    0.7.0.1
 */