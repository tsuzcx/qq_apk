package com.tencent.mm.plugin.emoji.ui.v3.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/banner/EmojiStoreV3BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "itemView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "bannerImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "getBannerImg", "()Lcom/tencent/mm/plugin/gif/MMAnimateView;", "bannerTitle", "Landroid/widget/TextView;", "getBannerTitle", "()Landroid/widget/TextView;", "bannerTitleBg", "Landroid/widget/LinearLayout;", "getBannerTitleBg", "()Landroid/widget/LinearLayout;", "bgRadius", "", "bgShape", "Landroid/graphics/drawable/Drawable;", "normBgColor", "", "pressBgColor", "root", "getRoot", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends RecyclerView.v
{
  final LinearLayout ybr;
  final MMAnimateView ybs;
  final TextView ybt;
  private final LinearLayout ybu;
  private final int ybv;
  private final int ybw;
  private final float ybx;
  private final Drawable yby;
  
  public d(Context paramContext, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(270563);
    this.ybr = ((LinearLayout)paramView.findViewById(h.e.emoji_store_banner_item_root));
    this.ybs = ((MMAnimateView)paramView.findViewById(h.e.emoji_bar_view));
    this.ybt = ((TextView)paramView.findViewById(h.e.emoji_bar_title));
    this.ybu = ((LinearLayout)paramView.findViewById(h.e.emoji_bar_title_bg));
    this.ybv = com.tencent.mm.cd.a.w(paramContext, h.b.BW_100);
    this.ybw = com.tencent.mm.cd.a.w(paramContext, h.b.BW_0_Alpha_0_0_5);
    this.ybx = com.tencent.mm.view.d.e(paramContext, 8.0F);
    com.tencent.mm.plugin.emoji.g.a locala = com.tencent.mm.plugin.emoji.g.a.ydF;
    this.yby = com.tencent.mm.plugin.emoji.g.a.a(this.ybv, this.ybw, this.ybx, this.ybx, this.ybx, this.ybx);
    paramView.setClickable(true);
    paramView.setBackground(this.yby);
    paramView = new LinearLayout.LayoutParams(com.tencent.mm.view.d.e(paramContext, 264.0F), com.tencent.mm.view.d.e(paramContext, 176.0F));
    this.ybr.setLayoutParams((ViewGroup.LayoutParams)paramView);
    this.ybr.setOutlineProvider((ViewOutlineProvider)new d.1(paramContext));
    this.ybr.setClipToOutline(true);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.view.d.e(paramContext, 140.0F));
    this.ybs.setLayoutParams((ViewGroup.LayoutParams)paramView);
    this.ybs.setDefaultImageResource(0);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.view.d.e(paramContext, 36.0F));
    paramView.setMargins(com.tencent.mm.view.d.e(paramContext, 12.0F), 0, 0, 0);
    this.ybt.setLayoutParams((ViewGroup.LayoutParams)paramView);
    AppMethodBeat.o(270563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.banner.d
 * JD-Core Version:    0.7.0.1
 */