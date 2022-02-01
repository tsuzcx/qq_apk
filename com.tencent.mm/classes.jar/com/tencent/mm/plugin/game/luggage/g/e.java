package com.tencent.mm.plugin.game.luggage.g;

import android.app.Activity;
import com.tencent.luggage.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b.a;
import com.tencent.mm.plugin.webview.luggage.v;

public final class e
  extends v
{
  public boolean xxO;
  public a xxP;
  
  public e(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(83126);
    this.xxO = false;
    this.ctk = h.class;
    this.ctn.E(a.dTr());
    AppMethodBeat.o(83126);
  }
  
  public final void Lu()
  {
    AppMethodBeat.i(186933);
    super.Lu();
    this.xxO = true;
    if (this.xxP != null) {
      this.xxP.dTp();
    }
    AppMethodBeat.o(186933);
  }
  
  public final void Lv()
  {
    AppMethodBeat.i(186934);
    super.Lv();
    this.xxO = false;
    if (this.xxP != null) {
      this.xxP.dTq();
    }
    AppMethodBeat.o(186934);
  }
  
  public final boolean Lw()
  {
    AppMethodBeat.i(186935);
    if (this.xxP != null)
    {
      bool = this.xxP.Lw();
      AppMethodBeat.o(186935);
      return bool;
    }
    boolean bool = super.Lw();
    AppMethodBeat.o(186935);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean Lw();
    
    public abstract void dTp();
    
    public abstract void dTq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.e
 * JD-Core Version:    0.7.0.1
 */