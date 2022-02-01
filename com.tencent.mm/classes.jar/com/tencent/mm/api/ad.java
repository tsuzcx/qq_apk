package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
{
  public static a djd;
  
  public static ac VK()
  {
    AppMethodBeat.i(131335);
    ac localac = djd.VL();
    AppMethodBeat.o(131335);
    return localac;
  }
  
  public static SmileyPanel bC(Context paramContext)
  {
    AppMethodBeat.i(131332);
    paramContext = djd.bE(paramContext);
    AppMethodBeat.o(131332);
    return paramContext;
  }
  
  public static int bD(Context paramContext)
  {
    AppMethodBeat.i(131334);
    int i = djd.bD(paramContext);
    AppMethodBeat.o(131334);
    return i;
  }
  
  public static SmileyPanel l(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(131333);
    paramContext = djd.m(paramContext, paramBoolean);
    AppMethodBeat.o(131333);
    return paramContext;
  }
  
  public static abstract interface a
  {
    public abstract ac VL();
    
    public abstract int bD(Context paramContext);
    
    public abstract SmileyPanel bE(Context paramContext);
    
    public abstract SmileyPanel m(Context paramContext, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.api.ad
 * JD-Core Version:    0.7.0.1
 */