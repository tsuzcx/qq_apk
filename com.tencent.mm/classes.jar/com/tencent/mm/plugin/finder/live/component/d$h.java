package com.tencent.mm.plugin.finder.live.component;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
final class d$h
  implements w.b
{
  public static final h xYZ;
  
  static
  {
    AppMethodBeat.i(270777);
    xYZ = new h();
    AppMethodBeat.o(270777);
  }
  
  public final void eu(View paramView)
  {
    AppMethodBeat.i(270775);
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
        paramView.setImageResource(b.i.icons_filled_volume_up);
        AppMethodBeat.o(270775);
        return;
      }
    }
    AppMethodBeat.o(270775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.d.h
 * JD-Core Version:    0.7.0.1
 */