package com.tencent.mm.plugin.finder.video.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.c;
import com.tencent.mm.plugin.finder.record.FinderRecordTemplatePluginLayout;
import com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "reLayoutPluginOnce", "", "Lcom/tencent/mm/plugin/finder/record/FinderRecordTemplatePluginLayout;", "w", "", "h", "Lcom/tencent/mm/plugin/finder/video/FinderRecordPluginLayout;", "plugin-finder-publish_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/util/FinderRecordLayoutUtilKt$reLayoutPluginOnce$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public a(View paramView1, int paramInt1, FinderRecordPluginLayout paramFinderRecordPluginLayout, int paramInt2, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, RelativeLayout.LayoutParams paramLayoutParams3, View paramView2, Rect paramRect, View paramView3, View paramView4, View paramView5) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(335039);
      this.Gwc.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i = (this.Gwd - this.Gwc.getHeight()) / 2;
      Log.i("MicroMsg.FinderRecordLayoutUtil", s.X("blackHeight ", Integer.valueOf(i)));
      if (i < com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_3A))
      {
        Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight <3A");
        if (this.Gwf <= 0) {}
      }
      for (;;)
      {
        this.Gwj.setLayoutParams((ViewGroup.LayoutParams)this.Gwi);
        this.Gwm.setLayoutParams((ViewGroup.LayoutParams)this.Gwg);
        this.Gwl.setLayoutParams((ViewGroup.LayoutParams)this.Gwh);
        this.Gwn.setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        localAlphaAnimation.setFillAfter(true);
        this.Gwn.startAnimation((Animation)localAlphaAnimation);
        AppMethodBeat.o(335039);
        return;
        if (i < com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_6A))
        {
          Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight 3A - 6A");
          this.Gwg.bottomMargin = com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_2A);
          this.Gwh.bottomMargin = (i - this.Gwf + com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_0_5_A));
          this.Gwi.topMargin = i;
        }
        else
        {
          Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight  >6A");
          int j = i - com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_1_5_A) - this.Gwj.getHeight();
          if (j - this.Gwk.top > 0) {}
          for (this.Gwi.topMargin = j;; this.Gwi.topMargin = (com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_1_5_A) + i))
          {
            if (i - this.Gwf < com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_6A)) {
              break label392;
            }
            this.Gwg.bottomMargin = com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_5A);
            this.Gwh.bottomMargin = (i - this.Gwl.getHeight() - this.Gwf);
            break;
          }
          label392:
          this.Gwg.bottomMargin = com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_2A);
          this.Gwh.bottomMargin = (i - this.Gwf + com.tencent.mm.cd.a.br(this.Gwe.getContext(), l.c.Edge_0_5_A));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/util/FinderRecordLayoutUtilKt$reLayoutPluginOnce$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public b(View paramView1, int paramInt1, FinderRecordTemplatePluginLayout paramFinderRecordTemplatePluginLayout, int paramInt2, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, RelativeLayout.LayoutParams paramLayoutParams3, View paramView2, Rect paramRect, View paramView3, View paramView4, View paramView5) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(335044);
      this.Gwc.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i = (this.Gwd - this.Gwc.getHeight()) / 2;
      Log.i("MicroMsg.FinderRecordLayoutUtil", s.X("blackHeight ", Integer.valueOf(i)));
      if (i < com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_3A))
      {
        Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight <3A");
        if (this.Gwf <= 0) {}
      }
      for (;;)
      {
        this.Gwj.setLayoutParams((ViewGroup.LayoutParams)this.Gwi);
        this.Gwm.setLayoutParams((ViewGroup.LayoutParams)this.Gwg);
        this.Gwl.setLayoutParams((ViewGroup.LayoutParams)this.Gwh);
        this.Gwn.setVisibility(0);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        localAlphaAnimation.setFillAfter(true);
        this.Gwn.startAnimation((Animation)localAlphaAnimation);
        AppMethodBeat.o(335044);
        return;
        if (i < com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_6A))
        {
          Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight 3A - 6A");
          this.Gwg.bottomMargin = com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_2A);
          this.Gwh.bottomMargin = (i - this.Gwf + com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_0_5_A));
          this.Gwi.topMargin = i;
        }
        else
        {
          Log.i("MicroMsg.FinderRecordLayoutUtil", "blackHeight  >6A");
          int j = i - com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_1_5_A) - this.Gwj.getHeight();
          if (j - this.Gwk.top > 0) {}
          for (this.Gwi.topMargin = j;; this.Gwi.topMargin = (com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_1_5_A) + i))
          {
            if (i - this.Gwf < com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_6A)) {
              break label392;
            }
            this.Gwg.bottomMargin = com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_5A);
            this.Gwh.bottomMargin = (i - this.Gwl.getHeight() - this.Gwf);
            break;
          }
          label392:
          this.Gwg.bottomMargin = com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_2A);
          this.Gwh.bottomMargin = (i - this.Gwf + com.tencent.mm.cd.a.br(this.Gwo.getContext(), l.c.Edge_0_5_A));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.util.a
 * JD-Core Version:    0.7.0.1
 */