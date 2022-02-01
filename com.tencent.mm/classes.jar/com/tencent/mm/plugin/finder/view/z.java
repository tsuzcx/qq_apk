package com.tencent.mm.plugin.finder.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.ui.widget.a.h.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamCoinNoteBottomPage;", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog$CustomBottomSheetPage;", "()V", "getView", "Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends h.b
{
  private static final void a(z paramz, View paramView)
  {
    AppMethodBeat.i(344343);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramz);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/GameTeamCoinNoteBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramz, "this$0");
    paramz.jHR();
    a.a(new Object(), "com/tencent/mm/plugin/finder/view/GameTeamCoinNoteBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344343);
  }
  
  public final View E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(344353);
    s.u(paramViewGroup, "root");
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(p.f.CcG, paramViewGroup, false);
    ((WeImageView)paramViewGroup.findViewById(p.e.finder_live_back_btn)).setOnClickListener(new z..ExternalSyntheticLambda0(this));
    s.s(paramViewGroup, "rootView");
    AppMethodBeat.o(344353);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.z
 * JD-Core Version:    0.7.0.1
 */