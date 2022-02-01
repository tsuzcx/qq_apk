package com.tencent.mm.plugin.game.luggage.page;

import android.app.Activity;
import com.tencent.luggage.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.a;
import com.tencent.mm.plugin.webview.luggage.w;

public final class e
  extends w
{
  public boolean IvN;
  public a IvO;
  
  public e(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(83126);
    this.IvN = false;
    X(h.class);
    this.ejl.aZ(a.fEv());
    AppMethodBeat.o(83126);
  }
  
  public final void aos()
  {
    AppMethodBeat.i(277037);
    super.aos();
    this.IvN = true;
    if (this.IvO != null) {
      this.IvO.fEt();
    }
    AppMethodBeat.o(277037);
  }
  
  public final void aot()
  {
    AppMethodBeat.i(277041);
    super.aot();
    this.IvN = false;
    if (this.IvO != null) {
      this.IvO.fEu();
    }
    AppMethodBeat.o(277041);
  }
  
  public final boolean aou()
  {
    AppMethodBeat.i(277046);
    if (this.IvO != null)
    {
      bool = this.IvO.aou();
      AppMethodBeat.o(277046);
      return bool;
    }
    boolean bool = super.aou();
    AppMethodBeat.o(277046);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean aou();
    
    public abstract void fEt();
    
    public abstract void fEu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.e
 * JD-Core Version:    0.7.0.1
 */