package com.tencent.mm.as;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.e;

final class j
  implements e
{
  private f<String, Bitmap> eoL = new f(5);
  
  public final Object get(Object paramObject)
  {
    return this.eoL.get((String)paramObject);
  }
  
  public final void h(Object paramObject1, Object paramObject2)
  {
    this.eoL.f((String)paramObject1, (Bitmap)paramObject2);
  }
  
  public final Object remove(Object paramObject)
  {
    this.eoL.remove((String)paramObject);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.as.j
 * JD-Core Version:    0.7.0.1
 */