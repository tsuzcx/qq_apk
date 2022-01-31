package com.tencent.mm.plugin.appbrand.j.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.bridge.impl.a.c;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.d.a.b;
import com.tencent.mm.plugin.appbrand.j.a.a;

public final class g
  extends c
{
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    if (!match(paramString)) {
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.JD().a(paramString, paramRect);
      if (localBitmap == null) {
        b.JD().a(new b.h()
        {
          public final void JG() {}
          
          public final void JH()
          {
            if (paramb == null) {
              return;
            }
            paramb.i(null);
          }
          
          public final void p(Bitmap paramAnonymousBitmap)
          {
            if (paramb == null) {
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.i(null);
              return;
            }
            paramb.i(paramAnonymousBitmap);
          }
          
          public final String pU()
          {
            return "WxaIcon";
          }
        }, paramString, null, paramRect);
      }
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
    } while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b.g
 * JD-Core Version:    0.7.0.1
 */