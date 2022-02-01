package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T>
{
  private WeakReference<T> heU;
  private a heV = new a("");
  final int heW;
  public int height = 0;
  public int width = 0;
  
  public g(T paramT)
  {
    this.heU = new WeakReference(paramT);
    if (paramT != null)
    {
      this.heW = paramT.hashCode();
      return;
    }
    this.heW = hashCode();
  }
  
  public final T get()
  {
    if (this.heU == null) {
      return null;
    }
    return this.heU.get();
  }
  
  public final View getView()
  {
    if (this.heU != null)
    {
      Object localObject = this.heU.get();
      if ((localObject != null) && ((localObject instanceof View))) {
        return (View)localObject;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.b.g
 * JD-Core Version:    0.7.0.1
 */