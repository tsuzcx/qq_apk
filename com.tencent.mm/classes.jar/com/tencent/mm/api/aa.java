package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
{
  public static a cSH;
  
  public static z Lw()
  {
    AppMethodBeat.i(131335);
    z localz = cSH.Lx();
    AppMethodBeat.o(131335);
    return localz;
  }
  
  public static SmileyPanel bi(Context paramContext)
  {
    AppMethodBeat.i(131332);
    paramContext = cSH.bk(paramContext);
    AppMethodBeat.o(131332);
    return paramContext;
  }
  
  public static int bj(Context paramContext)
  {
    AppMethodBeat.i(131334);
    int i = cSH.bj(paramContext);
    AppMethodBeat.o(131334);
    return i;
  }
  
  public static SmileyPanel k(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(131333);
    paramContext = cSH.l(paramContext, paramBoolean);
    AppMethodBeat.o(131333);
    return paramContext;
  }
  
  public static abstract interface a
  {
    public abstract z Lx();
    
    public abstract int bj(Context paramContext);
    
    public abstract SmileyPanel bk(Context paramContext);
    
    public abstract SmileyPanel l(Context paramContext, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.aa
 * JD-Core Version:    0.7.0.1
 */