package com.tencent.mm.cf;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  private final a<?>[] ywq;
  private final HashMap<String, a<?>> ywr;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(58949);
    paramContext = new c(paramContext);
    this.ywq = new a[] { paramContext.yws, paramContext.ywt };
    this.ywr = new HashMap();
    AppMethodBeat.o(58949);
  }
  
  public static abstract interface a<T>
  {
    public abstract T get();
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.b
 * JD-Core Version:    0.7.0.1
 */