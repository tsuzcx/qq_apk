package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e$a
  implements e
{
  int jlY;
  boolean mInLayout;
  private View mView;
  
  public e$a(Context paramContext)
  {
    AppMethodBeat.i(123949);
    this.mView = new e.a.1(this, paramContext);
    AppMethodBeat.o(123949);
  }
  
  public final void aRK()
  {
    AppMethodBeat.i(123950);
    this.mView.setVisibility(0);
    AppMethodBeat.o(123950);
  }
  
  public final void aRL()
  {
    AppMethodBeat.i(123951);
    this.mView.setVisibility(4);
    AppMethodBeat.o(123951);
  }
  
  public final boolean aRd()
  {
    return true;
  }
  
  public final boolean aRh()
  {
    AppMethodBeat.i(123952);
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool = this.mView.isInLayout();
      AppMethodBeat.o(123952);
      return bool;
    }
    boolean bool = this.mInLayout;
    AppMethodBeat.o(123952);
    return bool;
  }
  
  public final View getPanelView()
  {
    return this.mView;
  }
  
  public final void onDestroy() {}
  
  public final boolean qu(int paramInt)
  {
    if ((paramInt > 0) && (this.jlY != paramInt))
    {
      this.jlY = paramInt;
      return true;
    }
    return false;
  }
  
  public final void setOnTextOperationListener(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.e.a
 * JD-Core Version:    0.7.0.1
 */