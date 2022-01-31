package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.m;

final class b$1
  extends AnimatorListenerAdapter
{
  b$1(b paramb, g paramg) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(126290);
    this.hEM.BS(this.hLj.j("ok", null));
    AppMethodBeat.o(126290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.b.1
 * JD-Core Version:    0.7.0.1
 */