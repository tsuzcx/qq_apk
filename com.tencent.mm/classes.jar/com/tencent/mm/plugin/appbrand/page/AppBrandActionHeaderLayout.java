package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.l.a.a;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandActionHeaderLayout
  extends LinearLayout
{
  private int cpO;
  private Context mContext;
  private LinearLayout qpa;
  private HorizontalScrollView qpb;
  private AppBrandActionSingleHeaderView qpc;
  private AppBrandActionMultipleHeaderView qpd;
  private AppBrandActionMultipleHeaderView qpe;
  private AppBrandActionMultipleHeaderView qpf;
  private AppBrandActionMultipleHeaderView qpg;
  private TextView qph;
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(147431);
    this.cpO = -1;
    bv(paramContext);
    AppMethodBeat.o(147431);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(147432);
    this.cpO = -1;
    bv(paramContext);
    AppMethodBeat.o(147432);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(147436);
    this.mContext = paramContext;
    View.inflate(paramContext, a.e.appbrand_action_game_header_layout, this);
    this.qpa = ((LinearLayout)findViewById(a.d.appbrand_action_header_single_layout));
    this.qpb = ((HorizontalScrollView)findViewById(a.d.appbrand_action_header_hscrollview));
    this.qpc = ((AppBrandActionSingleHeaderView)findViewById(a.d.appbrand_action_single_header_view));
    this.qpd = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view1));
    this.qpe = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view2));
    this.qpf = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view3));
    this.qpg = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view4));
    this.qph = ((TextView)findViewById(a.d.appbrand_action_header_status));
    this.qpd.setVisibility(8);
    this.qpe.setVisibility(8);
    this.qpf.setVisibility(8);
    this.qpg.setVisibility(8);
    this.qph.setVisibility(8);
    AppMethodBeat.o(147436);
  }
  
  public TextView getStatusTextView()
  {
    return this.qph;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(147435);
    super.onAttachedToWindow();
    if (this.cpO > 0) {
      setForceHeight(this.cpO);
    }
    AppMethodBeat.o(147435);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147433);
    if (this.cpO > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.cpO, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.cpO > 0) && (getMeasuredHeight() > this.cpO)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.cpO);
    }
    AppMethodBeat.o(147433);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(147437);
    if (paramBoolean)
    {
      this.qpc.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.qpd.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.qpe.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.qpf.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.qpg.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.qph.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      AppMethodBeat.o(147437);
      return;
    }
    this.qpc.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.qpd.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.qpe.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.qpf.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.qpg.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.qph.setTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    AppMethodBeat.o(147437);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(169505);
    this.cpO = Math.max(paramInt, -1);
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.cpO > 0) {
        localViewGroup.setMinimumHeight(this.cpO);
      }
      requestLayout();
    }
    AppMethodBeat.o(169505);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147438);
    this.qph.setText(paramCharSequence);
    this.qph.setVisibility(0);
    this.qpa.setVisibility(8);
    this.qpb.setVisibility(8);
    AppMethodBeat.o(147438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */