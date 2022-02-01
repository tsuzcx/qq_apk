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
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTencentVideoChooseView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "onFinishInflate", "", "toggleToFilled", "title", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTencentVideoChooseView
  extends RelativeLayout
{
  public WeImageView Bqk;
  public TextView descTv;
  
  public FinderTencentVideoChooseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344044);
    af.mU(getContext()).inflate(e.f.finder_choose_tencent_video_layout, (ViewGroup)this, true);
    AppMethodBeat.o(344044);
  }
  
  public FinderTencentVideoChooseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344053);
    af.mU(getContext()).inflate(e.f.finder_choose_tencent_video_layout, (ViewGroup)this, true);
    AppMethodBeat.o(344053);
  }
  
  public final void aCD(String paramString)
  {
    AppMethodBeat.i(344103);
    getIconIv().setIconColor(0);
    getDescTv().setText((CharSequence)String.valueOf(paramString));
    getDescTv().setTextColor(getContext().getResources().getColor(e.b.Orange));
    AppMethodBeat.o(344103);
  }
  
  public final TextView getDescTv()
  {
    AppMethodBeat.i(344078);
    TextView localTextView = this.descTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(344078);
      return localTextView;
    }
    s.bIx("descTv");
    AppMethodBeat.o(344078);
    return null;
  }
  
  public final WeImageView getIconIv()
  {
    AppMethodBeat.i(344060);
    WeImageView localWeImageView = this.Bqk;
    if (localWeImageView != null)
    {
      AppMethodBeat.o(344060);
      return localWeImageView;
    }
    s.bIx("iconIv");
    AppMethodBeat.o(344060);
    return null;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(344097);
    super.onFinishInflate();
    View localView = findViewById(e.e.wiv_choose_tencent_video);
    s.s(localView, "findViewById(R.id.wiv_choose_tencent_video)");
    setIconIv((WeImageView)localView);
    localView = findViewById(e.e.tv_choose_tencent_video);
    s.s(localView, "findViewById(R.id.tv_choose_tencent_video)");
    setDescTv((TextView)localView);
    AppMethodBeat.o(344097);
  }
  
  public final void setDescTv(TextView paramTextView)
  {
    AppMethodBeat.i(344084);
    s.u(paramTextView, "<set-?>");
    this.descTv = paramTextView;
    AppMethodBeat.o(344084);
  }
  
  public final void setIconIv(WeImageView paramWeImageView)
  {
    AppMethodBeat.i(344070);
    s.u(paramWeImageView, "<set-?>");
    this.Bqk = paramWeImageView;
    AppMethodBeat.o(344070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTencentVideoChooseView
 * JD-Core Version:    0.7.0.1
 */