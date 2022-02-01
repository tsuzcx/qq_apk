package com.tencent.mm.plugin.finder.convert;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$container$1$1$1", "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$$special$$inlined$apply$lambda$1"})
final class h$ao
  implements View.OnTouchListener
{
  h$ao(h paramh, e parame) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(201780);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    p.g(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = (WeImageView)this.rUu.GD(2131308184);
      if (paramMotionEvent == null) {
        break label122;
      }
    }
    label122:
    for (paramView = paramMotionEvent.getTag();; paramView = null)
    {
      if (((paramView instanceof Integer)) && (p.i(paramMotionEvent.getTag(), Integer.valueOf(0)))) {
        h.b(this.rUu);
      }
      a.a(false, this, "com/tencent/mm/plugin/finder/convert/FinderFeedConvert$refreshProgress$$inlined$run$lambda$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(201780);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.ao
 * JD-Core Version:    0.7.0.1
 */