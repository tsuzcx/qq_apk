package com.tencent.mm.plugin.finder.video.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/util/FinderRecordLayoutUtil;", "", "()V", "TAG", "", "reLayoutPluginOnce", "", "Lcom/tencent/mm/plugin/finder/video/FinderRecordPluginLayout;", "w", "", "h", "plugin-finder_release"})
public final class a
{
  public static final a ATI;
  
  static
  {
    AppMethodBeat.i(282131);
    ATI = new a();
    AppMethodBeat.o(282131);
  }
  
  public static void a(FinderRecordPluginLayout paramFinderRecordPluginLayout, final int paramInt)
  {
    AppMethodBeat.i(282130);
    p.k(paramFinderRecordPluginLayout, "$this$reLayoutPluginOnce");
    final View localView1 = paramFinderRecordPluginLayout.findViewById(b.f.finder_record_layout);
    final View localView2 = paramFinderRecordPluginLayout.findViewById(b.f.record_type_view);
    final View localView3 = paramFinderRecordPluginLayout.findViewById(b.f.finder_record_header);
    final View localView4 = paramFinderRecordPluginLayout.findViewById(b.f.finder_preview_plugin);
    final View localView5 = paramFinderRecordPluginLayout.findViewById(b.f.record_plugin);
    final int i = ax.aB(paramFinderRecordPluginLayout.getContext());
    if ((paramFinderRecordPluginLayout.getContext() instanceof Activity))
    {
      localObject1 = paramFinderRecordPluginLayout.getContext();
      if (localObject1 == null)
      {
        paramFinderRecordPluginLayout = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(282130);
        throw paramFinderRecordPluginLayout;
      }
    }
    for (Object localObject1 = ar.br((Activity)localObject1);; localObject1 = new Rect())
    {
      p.j(localView1, "buttonParentView");
      localObject2 = localView1.getLayoutParams();
      if (localObject2 != null) {
        break;
      }
      paramFinderRecordPluginLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(282130);
      throw paramFinderRecordPluginLayout;
    }
    Object localObject2 = (RelativeLayout.LayoutParams)localObject2;
    p.j(localView3, "headerParentView");
    Object localObject3 = localView3.getLayoutParams();
    if (localObject3 == null)
    {
      paramFinderRecordPluginLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(282130);
      throw paramFinderRecordPluginLayout;
    }
    localObject3 = (RelativeLayout.LayoutParams)localObject3;
    p.j(localView2, "recordTypeParentView");
    Object localObject4 = localView2.getLayoutParams();
    if (localObject4 == null)
    {
      paramFinderRecordPluginLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(282130);
      throw paramFinderRecordPluginLayout;
    }
    localObject4 = (RelativeLayout.LayoutParams)localObject4;
    p.j(localView4, "previewView");
    localView4.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a(paramFinderRecordPluginLayout, localView4, paramInt, i, (RelativeLayout.LayoutParams)localObject2, (RelativeLayout.LayoutParams)localObject4, (RelativeLayout.LayoutParams)localObject3, localView3, (Rect)localObject1, localView2, localView1, localView5));
    AppMethodBeat.o(282130);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/util/FinderRecordLayoutUtil$reLayoutPluginOnce$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    a(FinderRecordPluginLayout paramFinderRecordPluginLayout, View paramView1, int paramInt1, int paramInt2, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, RelativeLayout.LayoutParams paramLayoutParams3, View paramView2, Rect paramRect, View paramView3, View paramView4, View paramView5) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(286580);
      Object localObject = localView4;
      p.j(localObject, "previewView");
      ((View)localObject).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i = paramInt;
      localObject = localView4;
      p.j(localObject, "previewView");
      i = (i - ((View)localObject).getHeight()) / 2;
      Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight ".concat(String.valueOf(i)));
      if (i < com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_3A))
      {
        Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight <3A");
        if (i <= 0) {}
      }
      for (;;)
      {
        localObject = localView3;
        p.j(localObject, "headerParentView");
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)this.ATP);
        localObject = localView1;
        p.j(localObject, "buttonParentView");
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)this.ATN);
        localObject = localView2;
        p.j(localObject, "recordTypeParentView");
        ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)this.ATO);
        localObject = localView5;
        p.j(localObject, "visibleContainerLayout");
        ((View)localObject).setVisibility(0);
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(300L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        localView5.startAnimation((Animation)localObject);
        AppMethodBeat.o(286580);
        return;
        if (i < com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_6A))
        {
          Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight 3A - 6A");
          this.ATN.bottomMargin = com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_2A);
          this.ATO.bottomMargin = (i - i + com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_0_5_A));
          this.ATP.topMargin = i;
        }
        else
        {
          Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight  >6A");
          int j = com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_1_5_A);
          localObject = localView3;
          p.j(localObject, "headerParentView");
          j = i - j - ((View)localObject).getHeight();
          if (j - this.ATR.top > 0) {}
          for (this.ATP.topMargin = j;; this.ATP.topMargin = (com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_1_5_A) + i))
          {
            if (i - i < com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_6A)) {
              break label465;
            }
            this.ATN.bottomMargin = com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_5A);
            localObject = this.ATO;
            View localView = localView2;
            p.j(localView, "recordTypeParentView");
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = (i - localView.getHeight() - i);
            break;
          }
          label465:
          this.ATN.bottomMargin = com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_2A);
          this.ATO.bottomMargin = (i - i + com.tencent.mm.ci.a.aY(this.ATJ.getContext(), b.d.Edge_0_5_A));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.util.a
 * JD-Core Version:    0.7.0.1
 */