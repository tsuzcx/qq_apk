package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.view.EllipsizedTextView;
import com.tencent.mm.plugin.finder.view.FadeOutLinearLayout;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFollowAnimUIC$Companion;", "", "()V", "DURATION", "", "TAG", "", "followBtnMargin", "", "getFollowBtnMargin", "()I", "followBtnMargin$delegate", "Lkotlin/Lazy;", "shrinkTextSizeThreshold", "getShrinkTextSizeThreshold", "shrinkTextSizeThreshold$delegate", "resetHeaderLayout", "", "feedHeaderBar", "Landroid/widget/FrameLayout;", "feedId", "plugin-finder_release"})
public final class u$a
{
  public static void a(FrameLayout paramFrameLayout, long paramLong)
  {
    AppMethodBeat.i(237494);
    p.k(paramFrameLayout, "feedHeaderBar");
    Object localObject = paramFrameLayout.findViewById(b.f.follow_btn_icon);
    p.j(localObject, "followIcon");
    if (((View)localObject).getVisibility() != 0)
    {
      ((View)localObject).setVisibility(0);
      localObject = (TextView)paramFrameLayout.findViewById(b.f.follow_btn_tv);
      ((TextView)localObject).setText(b.j.to_follow_tip);
      ((TextView)localObject).setTextColor(-1);
      localObject = paramFrameLayout.findViewById(b.f.follow_btn);
      p.j(localObject, "it");
      ((View)localObject).setBackground(paramFrameLayout.getContext().getDrawable(b.e.finder_feed_follow_btn_bg));
      ((View)localObject).setPadding(((View)localObject).getResources().getDimensionPixelOffset(b.d.Edge_A), ((View)localObject).getPaddingTop(), ((View)localObject).getResources().getDimensionPixelOffset(b.d.finder_1_25_A), ((View)localObject).getPaddingBottom());
    }
    localObject = paramFrameLayout.findViewById(b.f.follow_btn);
    p.j(localObject, "it");
    ((View)localObject).setVisibility(4);
    ((View)localObject).setOnClickListener(null);
    localObject = (EllipsizedTextView)paramFrameLayout.findViewById(b.f.nickname);
    Context localContext = paramFrameLayout.getContext();
    p.j(localContext, "feedHeaderBar.context");
    ((EllipsizedTextView)localObject).setTextSize(0, localContext.getResources().getDimension(b.d.GroupTitleTextSize));
    paramFrameLayout.getLayoutParams().width = -2;
    paramFrameLayout.requestLayout();
    paramFrameLayout = (FadeOutLinearLayout)paramFrameLayout.findViewById(b.f.content_layout);
    if (paramFrameLayout != null)
    {
      paramFrameLayout.ar(0, paramLong);
      AppMethodBeat.o(237494);
      return;
    }
    AppMethodBeat.o(237494);
  }
  
  public static int ekA()
  {
    AppMethodBeat.i(237490);
    f localf = u.eky();
    a locala = u.Bkh;
    int i = ((Number)localf.getValue()).intValue();
    AppMethodBeat.o(237490);
    return i;
  }
  
  public static int ekB()
  {
    AppMethodBeat.i(237492);
    f localf = u.ekz();
    a locala = u.Bkh;
    int i = ((Number)localf.getValue()).intValue();
    AppMethodBeat.o(237492);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.u.a
 * JD-Core Version:    0.7.0.1
 */