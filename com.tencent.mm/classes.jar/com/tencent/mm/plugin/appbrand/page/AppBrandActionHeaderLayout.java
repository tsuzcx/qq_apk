package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.m.a.a;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandActionHeaderLayout
  extends LinearLayout
{
  private int ehF;
  private Context mContext;
  private LinearLayout ttD;
  private HorizontalScrollView ttE;
  private AppBrandActionSingleHeaderView ttF;
  private AppBrandActionMultipleHeaderView ttG;
  private AppBrandActionMultipleHeaderView ttH;
  private AppBrandActionMultipleHeaderView ttI;
  private AppBrandActionMultipleHeaderView ttJ;
  private TextView ttK;
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(147431);
    this.ehF = -1;
    ci(paramContext);
    AppMethodBeat.o(147431);
  }
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(147432);
    this.ehF = -1;
    ci(paramContext);
    AppMethodBeat.o(147432);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(147436);
    this.mContext = paramContext;
    View.inflate(paramContext, a.e.appbrand_action_game_header_layout, this);
    this.ttD = ((LinearLayout)findViewById(a.d.appbrand_action_header_single_layout));
    this.ttE = ((HorizontalScrollView)findViewById(a.d.appbrand_action_header_hscrollview));
    this.ttF = ((AppBrandActionSingleHeaderView)findViewById(a.d.appbrand_action_single_header_view));
    this.ttG = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view1));
    this.ttH = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view2));
    this.ttI = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view3));
    this.ttJ = ((AppBrandActionMultipleHeaderView)findViewById(a.d.appbrand_action_multiple_header_view4));
    this.ttK = ((TextView)findViewById(a.d.appbrand_action_header_status));
    this.ttG.setVisibility(8);
    this.ttH.setVisibility(8);
    this.ttI.setVisibility(8);
    this.ttJ.setVisibility(8);
    this.ttK.setVisibility(8);
    AppMethodBeat.o(147436);
  }
  
  public TextView getStatusTextView()
  {
    return this.ttK;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(147435);
    super.onAttachedToWindow();
    if (this.ehF > 0) {
      setForceHeight(this.ehF);
    }
    AppMethodBeat.o(147435);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147433);
    if (this.ehF > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.ehF, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.ehF > 0) && (getMeasuredHeight() > this.ehF)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.ehF);
    }
    AppMethodBeat.o(147433);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(147437);
    if (paramBoolean)
    {
      this.ttF.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.ttG.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.ttH.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.ttI.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.ttJ.setTextViewTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      this.ttK.setTextColor(this.mContext.getResources().getColor(a.a.white_text_color));
      AppMethodBeat.o(147437);
      return;
    }
    this.ttF.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.ttG.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.ttH.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.ttI.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.ttJ.setTextViewTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    this.ttK.setTextColor(this.mContext.getResources().getColor(a.a.bottom_sheet_text_color));
    AppMethodBeat.o(147437);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(169505);
    this.ehF = Math.max(paramInt, -1);
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.ehF > 0) {
        localViewGroup.setMinimumHeight(this.ehF);
      }
      requestLayout();
    }
    AppMethodBeat.o(169505);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147438);
    this.ttK.setText(paramCharSequence);
    this.ttK.setVisibility(0);
    this.ttD.setVisibility(8);
    this.ttE.setVisibility(8);
    AppMethodBeat.o(147438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */