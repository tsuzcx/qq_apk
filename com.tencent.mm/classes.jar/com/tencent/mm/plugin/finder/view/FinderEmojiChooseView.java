package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderEmojiChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "onFinishInflate", "", "toggleToDefault", "toggleToFilled", "title", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEmojiChooseView
  extends RelativeLayout
{
  public WeImageView Bqk;
  public TextView descTv;
  
  public FinderEmojiChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344941);
    af.mU(getContext()).inflate(e.f.finder_choose_emoji_layout, (ViewGroup)this, true);
    AppMethodBeat.o(344941);
  }
  
  public FinderEmojiChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344950);
    af.mU(getContext()).inflate(e.f.finder_choose_emoji_layout, (ViewGroup)this, true);
    AppMethodBeat.o(344950);
  }
  
  public final void aCD(String paramString)
  {
    AppMethodBeat.i(344990);
    String str = getResources().getString(e.h.finder_post_emoji_choose);
    s.s(str, "resources.getString(R.st…finder_post_emoji_choose)");
    getIconIv().setIconColor(getContext().getResources().getColor(e.b.Orange));
    getDescTv().setText((CharSequence)(str + 65306 + paramString));
    getDescTv().setTextColor(getContext().getResources().getColor(e.b.Orange));
    AppMethodBeat.o(344990);
  }
  
  public final void fkv()
  {
    AppMethodBeat.i(344984);
    getIconIv().setVisibility(0);
    getIconIv().setIconColor(getContext().getResources().getColor(e.b.FG_0));
    getDescTv().setText((CharSequence)getResources().getString(e.h.finder_post_emoji_choose));
    getDescTv().setTextColor(getContext().getResources().getColor(e.b.normal_text_color));
    AppMethodBeat.o(344984);
  }
  
  public final TextView getDescTv()
  {
    AppMethodBeat.i(344966);
    TextView localTextView = this.descTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(344966);
      return localTextView;
    }
    s.bIx("descTv");
    AppMethodBeat.o(344966);
    return null;
  }
  
  public final WeImageView getIconIv()
  {
    AppMethodBeat.i(344957);
    WeImageView localWeImageView = this.Bqk;
    if (localWeImageView != null)
    {
      AppMethodBeat.o(344957);
      return localWeImageView;
    }
    s.bIx("iconIv");
    AppMethodBeat.o(344957);
    return null;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(344979);
    super.onFinishInflate();
    View localView = findViewById(e.e.wiv_choose_emoji);
    s.s(localView, "findViewById(R.id.wiv_choose_emoji)");
    setIconIv((WeImageView)localView);
    localView = findViewById(e.e.tv_choose_emoji);
    s.s(localView, "findViewById(R.id.tv_choose_emoji)");
    setDescTv((TextView)localView);
    AppMethodBeat.o(344979);
  }
  
  public final void setDescTv(TextView paramTextView)
  {
    AppMethodBeat.i(344974);
    s.u(paramTextView, "<set-?>");
    this.descTv = paramTextView;
    AppMethodBeat.o(344974);
  }
  
  public final void setIconIv(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(344959);
    s.u(paramWeImageView, "<set-?>");
    this.Bqk = paramWeImageView;
    AppMethodBeat.o(344959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderEmojiChooseView
 * JD-Core Version:    0.7.0.1
 */