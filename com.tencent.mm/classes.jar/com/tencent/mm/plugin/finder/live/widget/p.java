package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "HEIGHT", "", "getHEIGHT", "()F", "WIDTH", "getWIDTH", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "setBasePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "mount", "", "setTextBold", "tv", "Landroid/widget/TextView;", "unMount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class p
  extends FrameLayout
{
  private com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final float EmA;
  private final float Emz;
  
  public p(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(362169);
    this.Emz = bf.bf(MMApplicationContext.getContext()).y;
    this.EmA = bf.bf(MMApplicationContext.getContext()).x;
    setOnClickListener(p..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(362169);
  }
  
  private static final void dg(View paramView)
  {
    AppMethodBeat.i(362177);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveBaseWidget", s.X("click:", Integer.valueOf(paramView.getId())));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362177);
  }
  
  public final void c(com.tencent.mm.plugin.finder.live.plugin.b paramb)
  {
    AppMethodBeat.i(362229);
    s.u(paramb, "basePlugin");
    this.CwG = paramb;
    AppMethodBeat.o(362229);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(362215);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(362215);
    return bool;
  }
  
  public final com.tencent.mm.plugin.finder.live.plugin.b getBasePlugin()
  {
    return this.CwG;
  }
  
  public final float getHEIGHT()
  {
    return this.Emz;
  }
  
  public final float getWIDTH()
  {
    return this.EmA;
  }
  
  public final void setBasePlugin(com.tencent.mm.plugin.finder.live.plugin.b paramb)
  {
    this.CwG = paramb;
  }
  
  public final void setTextBold(TextView paramTextView)
  {
    AppMethodBeat.i(362223);
    s.u(paramTextView, "tv");
    aw.a((Paint)paramTextView.getPaint(), 0.8F);
    AppMethodBeat.o(362223);
  }
  
  public void unMount()
  {
    this.CwG = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.p
 * JD-Core Version:    0.7.0.1
 */