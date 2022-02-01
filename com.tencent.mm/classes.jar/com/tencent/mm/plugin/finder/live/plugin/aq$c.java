package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class aq$c
  implements w.b
{
  public static final c ypa;
  
  static
  {
    AppMethodBeat.i(270046);
    ypa = new c();
    AppMethodBeat.o(270046);
  }
  
  public final void eu(View paramView)
  {
    AppMethodBeat.i(270043);
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
        paramView.setImageResource(b.i.icons_filled_done);
        AppMethodBeat.o(270043);
        return;
      }
    }
    AppMethodBeat.o(270043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.aq.c
 * JD-Core Version:    0.7.0.1
 */