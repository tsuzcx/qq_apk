package com.tencent.mm.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aa
{
  public static a cJM;
  
  public static z Kf()
  {
    AppMethodBeat.i(131335);
    z localz = cJM.Kg();
    AppMethodBeat.o(131335);
    return localz;
  }
  
  public static SmileyPanel bg(Context paramContext)
  {
    AppMethodBeat.i(131332);
    paramContext = cJM.bi(paramContext);
    AppMethodBeat.o(131332);
    return paramContext;
  }
  
  public static int bh(Context paramContext)
  {
    AppMethodBeat.i(131334);
    int i = cJM.bh(paramContext);
    AppMethodBeat.o(131334);
    return i;
  }
  
  public static SmileyPanel k(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(131333);
    paramContext = cJM.l(paramContext, paramBoolean);
    AppMethodBeat.o(131333);
    return paramContext;
  }
  
  public static abstract interface a
  {
    public abstract z Kg();
    
    public abstract int bh(Context paramContext);
    
    public abstract SmileyPanel bi(Context paramContext);
    
    public abstract SmileyPanel l(Context paramContext, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.aa
 * JD-Core Version:    0.7.0.1
 */