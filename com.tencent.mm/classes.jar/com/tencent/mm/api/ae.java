package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
{
  public static a hek;
  
  public static ad aBJ()
  {
    AppMethodBeat.i(131335);
    ad localad = hek.aBK();
    AppMethodBeat.o(131335);
    return localad;
  }
  
  public static SmileyPanel co(Context paramContext)
  {
    AppMethodBeat.i(131332);
    paramContext = hek.cq(paramContext);
    AppMethodBeat.o(131332);
    return paramContext;
  }
  
  public static int cp(Context paramContext)
  {
    AppMethodBeat.i(131334);
    int i = hek.cp(paramContext);
    AppMethodBeat.o(131334);
    return i;
  }
  
  public static SmileyPanel m(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(131333);
    paramContext = hek.n(paramContext, paramBoolean);
    AppMethodBeat.o(131333);
    return paramContext;
  }
  
  public static abstract interface a
  {
    public abstract ad aBK();
    
    public abstract int cp(Context paramContext);
    
    public abstract SmileyPanel cq(Context paramContext);
    
    public abstract SmileyPanel n(Context paramContext, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.ae
 * JD-Core Version:    0.7.0.1
 */