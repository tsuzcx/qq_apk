package com.tencent.mm.plugin.finder.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FlowTextMixView;
import com.tencent.mm.plugin.finder.view.SimpleTouchableLayout;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryUILogic;", "", "()V", "bindDarkModeImageUI", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "bindDarkModeVideoUI", "bindGalleryTimelineUI", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n Bvk;
  
  static
  {
    AppMethodBeat.i(334315);
    Bvk = new n();
    AppMethodBeat.o(334315);
  }
  
  public static void x(j paramj)
  {
    AppMethodBeat.i(334286);
    s.u(paramj, "holder");
    Object localObject1 = (FlowTextMixView)paramj.caK.findViewById(e.e.flow_text_mix_view);
    Object localObject2 = paramj.context;
    if (localObject2 == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(334286);
      throw paramj;
    }
    ((FlowTextMixView)localObject1).setMaxWidth(((Activity)localObject2).getBaseContext().getResources().getDisplayMetrics().widthPixels);
    int i = paramj.context.getResources().getColor(e.b.BW_100_Alpha_0_5);
    localObject1 = (ViewGroup)paramj.UH(e.e.finder_seek_bar_footer_layout);
    localObject2 = paramj.UH(e.e.footer_op_layout);
    if (localObject2 != null)
    {
      ((View)localObject2).findViewById(e.e.share_icon_container).setVisibility(8);
      ((View)localObject2).findViewById(e.e.comment_icon_container).setVisibility(8);
      View localView = ((View)localObject2).findViewById(e.e.star_icon_container);
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = ((View)localObject2).findViewById(e.e.star_icon_container_first);
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = ((View)localObject2).findViewById(e.e.awesome_icon_container);
      localView.setEnabled(false);
      Object localObject3 = localView.getLayoutParams();
      if (localObject3 == null)
      {
        paramj = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(334286);
        throw paramj;
      }
      localObject3 = (ViewGroup.MarginLayoutParams)localObject3;
      ((ViewGroup.MarginLayoutParams)localObject3).bottomMargin = ((int)paramj.context.getResources().getDimension(e.c.Edge_10_5_A));
      ((ViewGroup.MarginLayoutParams)localObject3).setMarginEnd(0);
      ((ViewGroup.MarginLayoutParams)localObject3).rightMargin = 0;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((TextView)((View)localObject2).findViewById(e.e.like_count_tv)).setTextColor(i);
      ((WeImageView)((View)localObject2).findViewById(e.e.icon_feed_like)).setIconColor(i);
      localObject2 = paramj.UH(e.e.avatar_iv);
      ((View)localObject2).setEnabled(false);
      ((View)localObject2).setClickable(false);
      localObject2 = (TextView)paramj.UH(e.e.nickname);
      ((TextView)localObject2).setEnabled(false);
      ((TextView)localObject2).setClickable(false);
      ((TextView)localObject2).setTextColor(i);
      if (localObject1 != null) {
        break label593;
      }
    }
    label593:
    for (localObject1 = null;; localObject1 = ((ViewGroup)localObject1).findViewById(e.e.awesome_ground_layout))
    {
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(4);
      }
      localObject1 = paramj.UH(e.e.full_seek_bar_layout);
      if ((localObject1 != null) && ((localObject1 instanceof FinderFullSeekBarLayout))) {
        ((FinderFullSeekBarLayout)localObject1).setHidePrivateLike(true);
      }
      localObject1 = (TextView)paramj.UH(e.e.little_follow_tv);
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = (TextView)paramj.UH(e.e.full_friend_follow_count);
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramj.UH(e.e.follow_btn);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = paramj.UH(e.e.real_name_recommend_layout);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = paramj.caK.findViewById(e.e.follow_btn);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = (NeatTextView)paramj.UH(e.e.text_content);
      ((NeatTextView)localObject1).setMaxLines(1);
      ((NeatTextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((NeatTextView)localObject1).setTextColor(i);
      float f = paramj.context.getResources().getDimension(e.c.Edge_A);
      ((NeatTextView)localObject1).setPadding(((NeatTextView)localObject1).getPaddingLeft(), (int)f, ((NeatTextView)localObject1).getPaddingRight(), (int)f);
      localObject1 = paramj.UH(e.e.feed_header_content);
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 != null) {
        break;
      }
      paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(334286);
      throw paramj;
    }
    localObject2 = (FrameLayout.LayoutParams)localObject2;
    ((FrameLayout.LayoutParams)localObject2).bottomMargin = ((int)paramj.context.getResources().getDimension(e.c.Edge_10_5_A));
    ((FrameLayout.LayoutParams)localObject2).rightMargin = ((int)paramj.context.getResources().getDimension(e.c.Edge_5A));
    ((FrameLayout.LayoutParams)localObject2).setMarginEnd((int)paramj.context.getResources().getDimension(e.c.Edge_5A));
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = paramj.caK;
    if ((localObject1 instanceof SimpleTouchableLayout)) {}
    for (localObject1 = (SimpleTouchableLayout)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((SimpleTouchableLayout)localObject1).setOnDoubleClickListener(null);
        ((SimpleTouchableLayout)localObject1).setOnLongClickListener(null);
      }
      paramj = (FinderMediaBanner)paramj.UH(e.e.media_banner);
      if (paramj != null)
      {
        paramj.setOnDoubleClickListener(null);
        paramj.setOnLongClickListener(null);
      }
      AppMethodBeat.o(334286);
      return;
    }
  }
  
  public static void y(j paramj)
  {
    AppMethodBeat.i(334296);
    s.u(paramj, "holder");
    int i = paramj.context.getResources().getColor(e.b.Dark_2);
    int j = paramj.context.getResources().getColor(e.b.BW_100_Alpha_0_8);
    int k = paramj.context.getResources().getColor(e.b.White);
    Object localObject = paramj.UH(e.e.finder_media_bottom);
    if (localObject != null) {
      ((View)localObject).setBackgroundColor(i);
    }
    localObject = (TextView)paramj.UH(e.e.finder_nickname);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(j);
    }
    paramj = (TextView)paramj.UH(e.e.finder_desc);
    if (paramj != null) {
      paramj.setTextColor(k);
    }
    AppMethodBeat.o(334296);
  }
  
  public static void z(j paramj)
  {
    AppMethodBeat.i(334306);
    s.u(paramj, "holder");
    int i = paramj.context.getResources().getColor(e.b.Dark_2);
    int j = paramj.context.getResources().getColor(e.b.BW_100_Alpha_0_8);
    int k = paramj.context.getResources().getColor(e.b.White);
    Object localObject = paramj.UH(e.e.finder_media_bottom);
    if (localObject != null) {
      ((View)localObject).setBackgroundColor(i);
    }
    localObject = (TextView)paramj.UH(e.e.finder_nickname);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(j);
    }
    localObject = (TextView)paramj.UH(e.e.finder_desc);
    if (localObject != null) {
      ((TextView)localObject).setTextColor(k);
    }
    localObject = (ImageIndicatorView)paramj.UH(e.e.image_indicator);
    if (localObject != null) {
      ((ImageIndicatorView)localObject).setBackgroundColor(paramj.context.getResources().getColor(e.b.Dark_2));
    }
    AppMethodBeat.o(334306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.n
 * JD-Core Version:    0.7.0.1
 */