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
  public LinearLayout lyV;
  public HorizontalScrollView lyW;
  public AppBrandActionSingleHeaderView lyX;
  private AppBrandActionMultipleHeaderView lyY;
  private AppBrandActionMultipleHeaderView lyZ;
  private AppBrandActionMultipleHeaderView lza;
  private AppBrandActionMultipleHeaderView lzb;
  private TextView lzc;
  private int lzd;
  private Context mContext;
  
  public AppBrandActionHeaderLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147430);
    this.lzd = -1;
    aM(paramContext);
    AppMethodBeat.o(147430);
  }
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(147431);
    this.lzd = -1;
    aM(paramContext);
    AppMethodBeat.o(147431);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(147432);
    this.lzd = -1;
    aM(paramContext);
    AppMethodBeat.o(147432);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(147436);
    this.mContext = paramContext;
    View.inflate(paramContext, 2131493089, this);
    this.lyV = ((LinearLayout)findViewById(2131296881));
    this.lyW = ((HorizontalScrollView)findViewById(2131296879));
    this.lyX = ((AppBrandActionSingleHeaderView)findViewById(2131296891));
    this.lyY = ((AppBrandActionMultipleHeaderView)findViewById(2131296885));
    this.lyZ = ((AppBrandActionMultipleHeaderView)findViewById(2131296886));
    this.lza = ((AppBrandActionMultipleHeaderView)findViewById(2131296887));
    this.lzb = ((AppBrandActionMultipleHeaderView)findViewById(2131296888));
    this.lzc = ((TextView)findViewById(2131296882));
    this.lyY.setVisibility(8);
    this.lyZ.setVisibility(8);
    this.lza.setVisibility(8);
    this.lzb.setVisibility(8);
    this.lzc.setVisibility(8);
    AppMethodBeat.o(147436);
  }
  
  public TextView getStatusTextView()
  {
    return this.lzc;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(147435);
    super.onAttachedToWindow();
    if (this.lzd > 0) {
      setForceHeight(this.lzd);
    }
    AppMethodBeat.o(147435);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147433);
    if (this.lzd > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.lzd, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.lzd > 0) && (getMeasuredHeight() > this.lzd)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.lzd);
    }
    AppMethodBeat.o(147433);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(147437);
    if (paramBoolean)
    {
      this.lyX.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lyY.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lyZ.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lza.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lzb.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.lzc.setTextColor(this.mContext.getResources().getColor(2131101182));
      AppMethodBeat.o(147437);
      return;
    }
    this.lyX.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lyY.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lyZ.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lza.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lzb.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.lzc.setTextColor(this.mContext.getResources().getColor(2131100030));
    AppMethodBeat.o(147437);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(169505);
    this.lzd = Math.max(paramInt, -1);
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.lzd > 0) {
        localViewGroup.setMinimumHeight(this.lzd);
      }
      requestLayout();
    }
    AppMethodBeat.o(169505);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147438);
    this.lzc.setText(paramCharSequence);
    this.lzc.setVisibility(0);
    this.lyV.setVisibility(8);
    this.lyW.setVisibility(8);
    AppMethodBeat.o(147438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */