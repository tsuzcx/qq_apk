package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class c$a
  extends TranslateAnimation
{
  private List<View> ogG;
  
  public c$a(c paramc, float paramFloat)
  {
    super(0.0F, 0.0F, 0.0F, paramFloat);
    AppMethodBeat.i(113614);
    this.ogG = new ArrayList();
    AppMethodBeat.o(113614);
  }
  
  public final a bMo()
  {
    AppMethodBeat.i(113615);
    setFillEnabled(true);
    setFillAfter(true);
    AppMethodBeat.o(113615);
    return this;
  }
  
  public final void bMp()
  {
    AppMethodBeat.i(113617);
    int i = 0;
    while (i < this.ogG.size())
    {
      ((View)this.ogG.get(i)).startAnimation(this);
      i += 1;
    }
    AppMethodBeat.o(113617);
  }
  
  public final a dq(View paramView)
  {
    AppMethodBeat.i(113616);
    this.ogG.add(paramView);
    AppMethodBeat.o(113616);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.a
 * JD-Core Version:    0.7.0.1
 */