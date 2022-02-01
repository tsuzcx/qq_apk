package com.tencent.mm.plugin.finder.live.model;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
final class e$ah
  extends q
  implements a<x>
{
  e$ah(e parame, String paramString, int paramInt)
  {
    super(0);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize", "com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$showCenterCustomizeToast$1$1$1"})
  static final class a
    implements w.b
  {
    a(e.ah paramah) {}
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(272639);
      if (paramView != null)
      {
        TextView localTextView = (TextView)paramView.findViewById(b.f.toast_text);
        if (localTextView != null) {
          localTextView.setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(b.f.toast_img);
        if (paramView != null)
        {
          paramView.setImageResource(this.yeq.yep);
          AppMethodBeat.o(272639);
          return;
        }
      }
      AppMethodBeat.o(272639);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e.ah
 * JD-Core Version:    0.7.0.1
 */