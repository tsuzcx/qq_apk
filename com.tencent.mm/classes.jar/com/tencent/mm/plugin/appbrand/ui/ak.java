package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public final class ak
{
  private static volatile WeakReference<Bitmap> iIF;
  
  public static Drawable bXP()
  {
    AppMethodBeat.i(177515);
    if (iIF != null)
    {
      localObject = (Bitmap)iIF.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      iIF = new WeakReference(BitmapFactory.decodeResource(MMApplicationContext.getResources(), 2131233911));
    }
    Object localObject = d.a(MMApplicationContext.getResources(), (Bitmap)iIF.get());
    ((b)localObject).eD();
    AppMethodBeat.o(177515);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ak
 * JD-Core Version:    0.7.0.1
 */