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
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandActionHeaderLayout
  extends LinearLayout
{
  private TextView lYA;
  private int lYB;
  public LinearLayout lYt;
  public HorizontalScrollView lYu;
  public AppBrandActionSingleHeaderView lYv;
  private AppBrandActionMultipleHeaderView lYw;
  private AppBrandActionMultipleHeaderView lYx;
  private AppBrandActionMultipleHeaderView lYy;
  private AppBrandActionMultipleHeaderView lYz;
  private Context mContext;
  
  public AppBrandActionHeaderLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147430);
    this.lYB = -1;
    aM(paramContext);
    AppMethodBeat.o(147430);
  }
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(147431);
    this.lYB = -1;
    aM(paramContext);
    AppMethodBeat.o(147431);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(147432);
    this.lYB = -1;
    aM(paramContext);
    AppMethodBeat.o(147432);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(147436);
    this.mContext = paramContext;
    View.inflate(paramContext, 2131493089, this);
    this.lYt = ((LinearLayout)findViewById(2131296881));
    this.lYu = ((HorizontalScrollView)findViewById(2131296879));
    this.lYv = ((AppBrandActionSingleHeaderView)findViewById(2131296891));
    this.lYw = ((AppBrandActionMultipleHeaderView)findViewById(2131296885));
    this.lYx = ((AppBrandActionMultipleHeaderView)findViewById(2131296886));
    this.lYy = ((AppBrandActionMultipleHeaderView)findViewById(2131296887));
    this.lYz = ((AppBrandActionMultipleHeaderView)findViewById(2131296888));
    this.lYA = ((TextView)findViewById(2131296882));
    this.lYw.setVisibility(8);
    this.lYx.setVisibility(8);
    this.lYy.setVisibility(8);
    this.lYz.setVisibility(8);
    this.lYA.setVisibility(8);
    AppMethodBeat.o(147436);
  }
  
  public TextView getStatusTextView()
  {
    return this.lYA;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(147435);
    super.onAttachedToWindow();
    if (this.lYB > 0) {
      setForceHeight(this.lYB);
    }
    AppMethodBeat.o(147435);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147433);
    if (this.lYB > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.lYB, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.lYB > 0) && (getMeasuredHeight() > this.lYB)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.lYB);
    }
    AppMethodBeat.o(147433);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(147437);
    if (paramBoolean)
    {
      this.lYv.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lYw.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lYx.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lYy.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lYz.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lYA.setTextColor(this.mContext.getResources().getColor(2131101182));
      AppMethodBeat.o(147437);
      return;
    }
    this.lYv.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lYw.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lYx.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lYy.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lYz.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lYA.setTextColor(this.mContext.getResources().getColor(2131100030));
    AppMethodBeat.o(147437);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(169505);
    this.lYB = Math.max(paramInt, -1);
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.lYB > 0) {
        localViewGroup.setMinimumHeight(this.lYB);
      }
      requestLayout();
    }
    AppMethodBeat.o(169505);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147438);
    this.lYA.setText(paramCharSequence);
    this.lYA.setVisibility(0);
    this.lYt.setVisibility(8);
    this.lYu.setVisibility(8);
    AppMethodBeat.o(147438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */