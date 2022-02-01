package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerViewHolder$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$1
  extends ViewOutlineProvider
{
  d$1(Context paramContext) {}
  
  public final void getOutline(View paramView, Outline paramOutline)
  {
    AppMethodBeat.i(270549);
    s.u(paramView, "view");
    s.u(paramOutline, "outline");
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), d.e(this.$context, 8.0F));
    AppMethodBeat.o(270549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.d.1
 * JD-Core Version:    0.7.0.1
 */