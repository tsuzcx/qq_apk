package com.tencent.mm.plugin.choosemsgfile.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.choosemsgfile.b.c.c;
import com.tencent.mm.plugin.choosemsgfile.b.c.f;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.bo;

final class ChooseMsgFileUI$2
  extends RecyclerView.m
{
  private Runnable kGn;
  
  ChooseMsgFileUI$2(ChooseMsgFileUI paramChooseMsgFileUI)
  {
    AppMethodBeat.i(54442);
    this.kGn = new ChooseMsgFileUI.2.1(this);
    AppMethodBeat.o(54442);
  }
  
  private void gh(boolean paramBoolean)
  {
    AppMethodBeat.i(54443);
    if (paramBoolean)
    {
      ChooseMsgFileUI.h(this.kGm).removeCallbacks(this.kGn);
      if (ChooseMsgFileUI.h(this.kGm).getVisibility() != 0)
      {
        ChooseMsgFileUI.h(this.kGm).clearAnimation();
        Animation localAnimation = AnimationUtils.loadAnimation(this.kGm.getContext(), 2131034181);
        ChooseMsgFileUI.h(this.kGm).setVisibility(0);
        ChooseMsgFileUI.h(this.kGm).startAnimation(localAnimation);
        AppMethodBeat.o(54443);
      }
    }
    else
    {
      ChooseMsgFileUI.h(this.kGm).removeCallbacks(this.kGn);
      ChooseMsgFileUI.h(this.kGm).postDelayed(this.kGn, 256L);
    }
    AppMethodBeat.o(54443);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54444);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = (LinearLayoutManager)ChooseMsgFileUI.g(this.kGm).bgA();
    paramRecyclerView = ChooseMsgFileUI.g(this.kGm).kFG.ty(paramRecyclerView.it());
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(54444);
      return;
    }
    paramRecyclerView = b.in(paramRecyclerView.getTimeStamp());
    ChooseMsgFileUI.h(this.kGm).setText(bo.bf(paramRecyclerView, ""));
    AppMethodBeat.o(54444);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(54445);
    if (1 == paramInt) {
      gh(true);
    }
    for (;;)
    {
      if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      {
        if ((((LinearLayoutManager)paramRecyclerView.getLayoutManager()).it() == 0) && (!ChooseMsgFileUI.i(this.kGm))) {
          ChooseMsgFileUI.g(this.kGm).b(false, ChooseMsgFileUI.e(this.kGm), ChooseMsgFileUI.f(this.kGm));
        }
        ChooseMsgFileUI.j(this.kGm);
        o.ahG().bX(paramInt);
      }
      AppMethodBeat.o(54445);
      return;
      if (paramInt == 0) {
        gh(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.2
 * JD-Core Version:    0.7.0.1
 */