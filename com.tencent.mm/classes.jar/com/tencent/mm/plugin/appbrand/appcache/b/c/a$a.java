package com.tencent.mm.plugin.appbrand.appcache.b.c;

import android.util.SparseIntArray;

public class a$a<_Key>
  extends SparseIntArray
{
  public final void d(_Key param_Key, int paramInt)
  {
    super.put(param_Key.hashCode(), paramInt);
  }
  
  public final int get(_Key param_Key)
  {
    if (param_Key == null) {
      return -1;
    }
    return super.get(param_Key.hashCode(), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c.a.a
 * JD-Core Version:    0.7.0.1
 */