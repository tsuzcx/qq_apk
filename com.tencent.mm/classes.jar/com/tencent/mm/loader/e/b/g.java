package com.tencent.mm.loader.e.b;

import android.view.View;
import com.tencent.mm.loader.h.a.a;
import java.lang.ref.WeakReference;

public final class g<T>
{
  private WeakReference<T> eOP;
  private a eOQ = new a("");
  final int eOR;
  public int height = 0;
  public int width = 0;
  
  public g(T paramT)
  {
    this.eOP = new WeakReference(paramT);
    if (paramT != null)
    {
      this.eOR = paramT.hashCode();
      return;
    }
    this.eOR = hashCode();
  }
  
  public final View getView()
  {
    if (this.eOP != null)
    {
      Object localObject = this.eOP.get();
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