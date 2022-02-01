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
  public LinearLayout kXl;
  public HorizontalScrollView kXm;
  public AppBrandActionSingleHeaderView kXn;
  private AppBrandActionMultipleHeaderView kXo;
  private AppBrandActionMultipleHeaderView kXp;
  private AppBrandActionMultipleHeaderView kXq;
  private AppBrandActionMultipleHeaderView kXr;
  private TextView kXs;
  private int kXt;
  private Context mContext;
  
  public AppBrandActionHeaderLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(147430);
    this.kXt = -1;
    aL(paramContext);
    AppMethodBeat.o(147430);
  }
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(147431);
    this.kXt = -1;
    aL(paramContext);
    AppMethodBeat.o(147431);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(147432);
    this.kXt = -1;
    aL(paramContext);
    AppMethodBeat.o(147432);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(147436);
    this.mContext = paramContext;
    View.inflate(paramContext, 2131493089, this);
    this.kXl = ((LinearLayout)findViewById(2131296881));
    this.kXm = ((HorizontalScrollView)findViewById(2131296879));
    this.kXn = ((AppBrandActionSingleHeaderView)findViewById(2131296891));
    this.kXo = ((AppBrandActionMultipleHeaderView)findViewById(2131296885));
    this.kXp = ((AppBrandActionMultipleHeaderView)findViewById(2131296886));
    this.kXq = ((AppBrandActionMultipleHeaderView)findViewById(2131296887));
    this.kXr = ((AppBrandActionMultipleHeaderView)findViewById(2131296888));
    this.kXs = ((TextView)findViewById(2131296882));
    this.kXo.setVisibility(8);
    this.kXp.setVisibility(8);
    this.kXq.setVisibility(8);
    this.kXr.setVisibility(8);
    this.kXs.setVisibility(8);
    AppMethodBeat.o(147436);
  }
  
  public TextView getStatusTextView()
  {
    return this.kXs;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(147435);
    super.onAttachedToWindow();
    if (this.kXt > 0) {
      setForceHeight(this.kXt);
    }
    AppMethodBeat.o(147435);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147433);
    if (this.kXt > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.kXt, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.kXt > 0) && (getMeasuredHeight() > this.kXt)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.kXt);
    }
    AppMethodBeat.o(147433);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(147437);
    if (paramBoolean)
    {
      this.kXn.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.kXo.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.kXp.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.kXq.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.kXr.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.kXs.setTextColor(this.mContext.getResources().getColor(2131101182));
      AppMethodBeat.o(147437);
      return;
    }
    this.kXn.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.kXo.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.kXp.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.kXq.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.kXr.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.kXs.setTextColor(this.mContext.getResources().getColor(2131100030));
    AppMethodBeat.o(147437);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(169505);
    this.kXt = Math.max(paramInt, -1);
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.kXt > 0) {
        localViewGroup.setMinimumHeight(this.kXt);
      }
      requestLayout();
    }
    AppMethodBeat.o(169505);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147438);
    this.kXs.setText(paramCharSequence);
    this.kXs.setVisibility(0);
    this.kXl.setVisibility(8);
    this.kXm.setVisibility(8);
    AppMethodBeat.o(147438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */