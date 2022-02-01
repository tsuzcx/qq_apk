package com.tencent.mm.plugin.finder.gallery.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/convert/MaskUILogic;", "", "()V", "refresh", "", "itemView", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "validType", "", "forceDark", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Bvm;
  
  static
  {
    AppMethodBeat.i(334280);
    Bvm = new b();
    AppMethodBeat.o(334280);
  }
  
  public static void a(View paramView, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(334240);
    s.u(paramView, "itemView");
    s.u(paramBaseFinderFeed, "item");
    View localView1 = paramView.findViewById(e.e.post_failed_layout);
    View localView2 = paramView.findViewById(e.e.post_progress_layout);
    View localView3 = paramView.findViewById(e.e.type_invalid_layout);
    if (localView1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof ViewGroup)) {
        break label230;
      }
      localObject1 = (ViewGroup)localObject1;
      label70:
      if (localView1 != null) {
        localView1.setVisibility(8);
      }
      if (localView2 != null) {
        localView2.setVisibility(8);
      }
      if (localView3 != null) {
        localView3.setVisibility(8);
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setBackgroundColor(paramView.getContext().getResources().getColor(e.b.finder_live_black_Alpha_60));
      }
      if (!paramBaseFinderFeed.feedObject.isPostFailed()) {
        break label271;
      }
      if (localView1 != null) {
        localView1.setVisibility(0);
      }
      if (localView1 != null) {
        break label236;
      }
    }
    label230:
    label236:
    for (Object localObject1 = localObject2;; localObject1 = (TextView)localView1.findViewById(e.e.failed_desc_tv))
    {
      if (localObject1 != null) {
        ((TextView)localObject1).setTextSize(0, com.tencent.mm.cd.a.fromDPToPix(paramView.getContext(), 14));
      }
      if (!paramBaseFinderFeed.feedObject.isPostFailedCanRetry()) {
        break label252;
      }
      if (localObject1 == null) {
        break label484;
      }
      ((TextView)localObject1).setText(e.h.finder_posting_failed_select_tips1);
      AppMethodBeat.o(334240);
      return;
      localObject1 = localView1.getParent();
      break;
      localObject1 = null;
      break label70;
    }
    label252:
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(e.h.finder_item_post_fail);
      AppMethodBeat.o(334240);
      return;
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        if (paramBoolean1)
        {
          if (localObject1 != null)
          {
            ((ViewGroup)localObject1).setVisibility(8);
            AppMethodBeat.o(334240);
          }
        }
        else
        {
          if (localView3 != null) {
            localView3.setVisibility(0);
          }
          if ((aw.isDarkMode()) || (paramBoolean2)) {
            if (localObject1 != null) {
              ((ViewGroup)localObject1).setBackgroundColor(paramView.getContext().getResources().getColor(e.b.BW_100_Alpha_0_0_5));
            }
          }
          while (localView3 != null)
          {
            localView3.setOnClickListener(new b..ExternalSyntheticLambda1(paramView));
            AppMethodBeat.o(334240);
            return;
            if (localObject1 != null) {
              ((ViewGroup)localObject1).setBackgroundColor(paramView.getContext().getResources().getColor(e.b.UN_BW_0_Alpha_0_1));
            }
          }
        }
      }
      else
      {
        if (localView2 != null) {
          localView2.setVisibility(0);
        }
        if (localView2 != null)
        {
          paramView = (FinderPostProgressView)localView2.findViewById(e.e.progress_view);
          if (paramView != null)
          {
            paramBaseFinderFeed = ValueAnimator.ofInt(new int[] { paramView.getProgress(), paramBaseFinderFeed.feedObject.getPostInfo().aaPw });
            paramBaseFinderFeed.addUpdateListener(new b..ExternalSyntheticLambda0(paramView));
            paramView = paramBaseFinderFeed.setDuration(400L);
            if (paramView != null) {
              paramView.start();
            }
          }
        }
      }
    }
    label271:
    label484:
    AppMethodBeat.o(334240);
  }
  
  private static final void d(FinderPostProgressView paramFinderPostProgressView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(334269);
    s.u(paramFinderPostProgressView, "$progress");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderPostProgressView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(334269);
      throw paramFinderPostProgressView;
    }
    paramFinderPostProgressView.setProgress(((Integer)paramValueAnimator).intValue());
    paramFinderPostProgressView.invalidate();
    AppMethodBeat.o(334269);
  }
  
  private static final void m(View paramView1, View paramView2)
  {
    AppMethodBeat.i(334257);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/gallery/convert/MaskUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$itemView");
    aa.dc(paramView1.getContext(), paramView1.getContext().getString(e.h.finder_media_type_invalid_tips));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/gallery/convert/MaskUILogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(334257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.convert.b
 * JD-Core Version:    0.7.0.1
 */