package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.plugin.appbrand.d.a.a;
import com.tencent.mm.plugin.appbrand.d.a.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b
  implements a
{
  private final List<a.a> bic = new LinkedList();
  
  public b()
  {
    a(new c());
  }
  
  public final Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Iterator localIterator = this.bic.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      if (locala.match(paramString)) {
        return locala.b(paramString, paramRect, paramb);
      }
    }
    return null;
  }
  
  public void a(final ImageView paramImageView, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramImageView == null)) {}
    do
    {
      return;
      paramString = a(paramString, null, new a.b()
      {
        public final void i(Bitmap paramAnonymousBitmap)
        {
          if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled())) {
            return;
          }
          paramImageView.setImageBitmap(paramAnonymousBitmap);
        }
      });
    } while ((paramString == null) || (paramString.isRecycled()));
    paramImageView.setImageBitmap(paramString);
  }
  
  public final void a(a.a parama)
  {
    if (this.bic.contains(parama)) {
      this.bic.remove(parama);
    }
    this.bic.add(parama);
  }
  
  public final Bitmap ba(String paramString)
  {
    return a(paramString, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.b
 * JD-Core Version:    0.7.0.1
 */