package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T>
{
  public int height = 0;
  private WeakReference<T> hhI;
  private a hhJ = new a("");
  final int hhK;
  public int width = 0;
  
  public g(T paramT)
  {
    this.hhI = new WeakReference(paramT);
    if (paramT != null)
    {
      this.hhK = paramT.hashCode();
      return;
    }
    this.hhK = hashCode();
  }
  
  public final T get()
  {
    if (this.hhI == null) {
      return null;
    }
    return this.hhI.get();
  }
  
  public final View getView()
  {
    if (this.hhI != null)
    {
      Object localObject = this.hhI.get();
      if ((localObject != null) && ((localObject instanceof View))) {
        return (View)localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.g
 * JD-Core Version:    0.7.0.1
 */