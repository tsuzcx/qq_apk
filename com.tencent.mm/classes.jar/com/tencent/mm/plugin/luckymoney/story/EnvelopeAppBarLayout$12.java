package com.tencent.mm.plugin.luckymoney.story;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.scaledLayout.a;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.c;

final class EnvelopeAppBarLayout$12
  implements RecyclerHorizontalViewPager.c
{
  EnvelopeAppBarLayout$12(EnvelopeAppBarLayout paramEnvelopeAppBarLayout, a parama, HorizontalLayoutManager paramHorizontalLayoutManager) {}
  
  public final boolean b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(163589);
    if (paramMotionEvent.getAction() == 0) {
      this.vtg.vqW = a.h(this.vth);
    }
    AppMethodBeat.o(163589);
    return paramBoolean;
  }
  
  public final void k(MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout.12
 * JD-Core Version:    0.7.0.1
 */