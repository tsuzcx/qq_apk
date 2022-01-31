package com.tencent.mm.ce;

import android.content.Context;
import java.util.HashMap;

public final class b
{
  private final a<?>[] umK;
  private final HashMap<String, a<?>> umL;
  
  public b(Context paramContext)
  {
    paramContext = new c(paramContext);
    this.umK = new a[] { paramContext.umM, paramContext.umN };
    this.umL = new HashMap();
  }
  
  public static abstract interface a<T>
  {
    public abstract T get();
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.b
 * JD-Core Version:    0.7.0.1
 */