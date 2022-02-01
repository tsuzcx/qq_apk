package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
{
  public static a faK;
  
  public static ac aaf()
  {
    AppMethodBeat.i(131335);
    ac localac = faK.aag();
    AppMethodBeat.o(131335);
    return localac;
  }
  
  public static SmileyPanel bB(Context paramContext)
  {
    AppMethodBeat.i(131332);
    paramContext = faK.bD(paramContext);
    AppMethodBeat.o(131332);
    return paramContext;
  }
  
  public static int bC(Context paramContext)
  {
    AppMethodBeat.i(131334);
    int i = faK.bC(paramContext);
    AppMethodBeat.o(131334);
    return i;
  }
  
  public static SmileyPanel m(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(131333);
    paramContext = faK.n(paramContext, paramBoolean);
    AppMethodBeat.o(131333);
    return paramContext;
  }
  
  public static abstract interface a
  {
    public abstract ac aag();
    
    public abstract int bC(Context paramContext);
    
    public abstract SmileyPanel bD(Context paramContext);
    
    public abstract SmileyPanel n(Context paramContext, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.ad
 * JD-Core Version:    0.7.0.1
 */