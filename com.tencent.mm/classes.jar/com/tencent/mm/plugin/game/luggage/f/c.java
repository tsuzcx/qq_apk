package com.tencent.mm.plugin.game.luggage.f;

import android.app.Activity;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.a;
import com.tencent.mm.plugin.webview.luggage.t;

public final class c
  extends t
{
  public boolean ufD;
  public a ufE;
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(83126);
    this.ufD = false;
    this.chq = f.class;
    this.cht.A(a.cee());
    AppMethodBeat.o(83126);
  }
  
  public final void Ce()
  {
    AppMethodBeat.i(193051);
    super.Ce();
    this.ufD = true;
    if (this.ufE != null) {
      this.ufE.cZL();
    }
    AppMethodBeat.o(193051);
  }
  
  public final void Cf()
  {
    AppMethodBeat.i(193052);
    super.Cf();
    this.ufD = false;
    if (this.ufE != null) {
      this.ufE.cZM();
    }
    AppMethodBeat.o(193052);
  }
  
  public final boolean aKK()
  {
    AppMethodBeat.i(224257);
    if (this.ufE != null)
    {
      bool = this.ufE.aKK();
      AppMethodBeat.o(224257);
      return bool;
    }
    boolean bool = super.aKK();
    AppMethodBeat.o(224257);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean aKK();
    
    public abstract void cZL();
    
    public abstract void cZM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.c
 * JD-Core Version:    0.7.0.1
 */