package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.j;
import com.tencent.mm.ui.MMActivity;

public final class c
  extends j
{
  public c(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void s(Drawable paramDrawable)
  {
    AppMethodBeat.i(42016);
    super.s(paramDrawable);
    AppMethodBeat.o(42016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */