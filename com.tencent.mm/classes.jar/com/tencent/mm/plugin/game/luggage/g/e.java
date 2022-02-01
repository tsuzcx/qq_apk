package com.tencent.mm.plugin.game.luggage.g;

import android.app.Activity;
import com.tencent.luggage.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.a;
import com.tencent.mm.plugin.webview.luggage.v;

public final class e
  extends v
{
  public boolean CBY;
  public a CBZ;
  
  public e(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(83126);
    this.CBY = false;
    O(h.class);
    this.crt.B(a.ewB());
    AppMethodBeat.o(83126);
  }
  
  public final void Ok()
  {
    AppMethodBeat.i(231122);
    super.Ok();
    this.CBY = true;
    if (this.CBZ != null) {
      this.CBZ.ewz();
    }
    AppMethodBeat.o(231122);
  }
  
  public final void Ol()
  {
    AppMethodBeat.i(231124);
    super.Ol();
    this.CBY = false;
    if (this.CBZ != null) {
      this.CBZ.ewA();
    }
    AppMethodBeat.o(231124);
  }
  
  public final boolean Om()
  {
    AppMethodBeat.i(231125);
    if (this.CBZ != null)
    {
      bool = this.CBZ.Om();
      AppMethodBeat.o(231125);
      return bool;
    }
    boolean bool = super.Om();
    AppMethodBeat.o(231125);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean Om();
    
    public abstract void ewA();
    
    public abstract void ewz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.e
 * JD-Core Version:    0.7.0.1
 */