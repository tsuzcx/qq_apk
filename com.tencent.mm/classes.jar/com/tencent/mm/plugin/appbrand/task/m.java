package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends n
{
  Class<? extends Activity> nQi;
  private g nQj;
  
  m(Class<? extends Activity> paramClass1, Class paramClass2, Class paramClass3, Class paramClass4, Class paramClass5, Class paramClass6, Class<? extends Activity> paramClass7)
  {
    super(paramClass1, paramClass2, paramClass3, paramClass4, paramClass5, paramClass6);
    this.nQi = paramClass7;
  }
  
  public final Class<? extends Activity> bWm()
  {
    return this.nQi;
  }
  
  public final g bWn()
  {
    return this.nQj;
  }
  
  protected final boolean c(g paramg)
  {
    AppMethodBeat.i(227513);
    if (this.nQj != null)
    {
      if (this.nQj == paramg)
      {
        AppMethodBeat.o(227513);
        return true;
      }
      AppMethodBeat.o(227513);
      return false;
    }
    boolean bool = super.c(paramg);
    AppMethodBeat.o(227513);
    return bool;
  }
  
  public final void y(g paramg)
  {
    AppMethodBeat.i(227512);
    if (this.nQj != null)
    {
      paramg = new IllegalStateException("const field");
      AppMethodBeat.o(227512);
      throw paramg;
    }
    this.nQj = paramg;
    AppMethodBeat.o(227512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.m
 * JD-Core Version:    0.7.0.1
 */