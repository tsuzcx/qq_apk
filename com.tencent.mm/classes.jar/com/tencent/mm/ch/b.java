package com.tencent.mm.ch;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class b
{
  private final a<?>[] acBI;
  private final HashMap<String, a<?>> acBJ;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(133216);
    paramContext = new c(paramContext);
    this.acBI = new a[] { paramContext.acBK, paramContext.acBL };
    this.acBJ = new HashMap();
    AppMethodBeat.o(133216);
  }
  
  public static abstract interface a<T>
  {
    public abstract T get();
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ch.b
 * JD-Core Version:    0.7.0.1
 */