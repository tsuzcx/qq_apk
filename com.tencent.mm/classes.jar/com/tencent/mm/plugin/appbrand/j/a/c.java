package com.tencent.mm.plugin.appbrand.j.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.plugin.appbrand.d.b;

public final class c
  implements e
{
  public final Bitmap a(d paramd, String paramString)
  {
    return a(paramd, paramString, null);
  }
  
  public final Bitmap a(d paramd, String paramString, Rect paramRect, e.a parama)
  {
    com.tencent.mm.plugin.appbrand.jsapi.c localc = paramd.fLx;
    String str = ((b)localc.i(b.class)).b(localc, paramString);
    return ((a)localc.i(a.class)).a(str, paramRect, new c.1(this, parama, paramd, paramString));
  }
  
  public final Bitmap a(d paramd, String paramString, e.a parama)
  {
    return a(paramd, paramString, null, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a.c
 * JD-Core Version:    0.7.0.1
 */