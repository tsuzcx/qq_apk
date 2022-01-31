package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.b;
import android.support.v4.a.a.d;
import com.tencent.mm.plugin.appbrand.compat.c.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> eac;
  
  public static Drawable JC()
  {
    if (eac != null)
    {
      localObject = (Bitmap)eac.get();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {}
    }
    else
    {
      eac = new WeakReference(com.tencent.mm.compatible.g.a.decodeResource(ae.getResources(), c.c.miniprogram_default_avatar));
    }
    Object localObject = d.a(ae.getResources(), (Bitmap)eac.get());
    ((b)localObject).cp();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.a
 * JD-Core Version:    0.7.0.1
 */