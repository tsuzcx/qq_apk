package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class b
  implements Iterator<View>
{
  private final ViewGroup hpb;
  private int hpc = 0;
  
  public b(ViewGroup paramViewGroup)
  {
    this.hpb = paramViewGroup;
  }
  
  public final boolean hasNext()
  {
    return this.hpc < this.hpb.getChildCount();
  }
  
  public final void remove()
  {
    this.hpb.removeViewAt(this.hpc - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.b
 * JD-Core Version:    0.7.0.1
 */