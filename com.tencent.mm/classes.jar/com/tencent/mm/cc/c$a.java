package com.tencent.mm.cc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.g.a.a;
import com.tencent.mm.svg.a.a;

public final class c$a
  implements a.a
{
  a uba = new a();
  
  public final Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
  {
    if (this.uba.f(paramResources, paramInt))
    {
      float f = 0.0F;
      if (paramOptions != null) {
        f = paramOptions.inDensity / 160.0F;
      }
      return a.b(paramResources, paramInt, f);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.cc.c.a
 * JD-Core Version:    0.7.0.1
 */