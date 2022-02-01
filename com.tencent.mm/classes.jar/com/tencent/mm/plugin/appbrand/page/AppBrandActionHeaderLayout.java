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
  private int crI;
  private Context mContext;
  private TextView nnA;
  private LinearLayout nnt;
  private HorizontalScrollView nnu;
  private AppBrandActionSingleHeaderView nnv;
  private AppBrandActionMultipleHeaderView nnw;
  private AppBrandActionMultipleHeaderView nnx;
  private AppBrandActionMultipleHeaderView nny;
  private AppBrandActionMultipleHeaderView nnz;
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(147431);
    this.crI = -1;
    bh(paramContext);
    AppMethodBeat.o(147431);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(147432);
    this.crI = -1;
    bh(paramContext);
    AppMethodBeat.o(147432);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(147436);
    this.mContext = paramContext;
    View.inflate(paramContext, 2131493131, this);
    this.nnt = ((LinearLayout)findViewById(2131296975));
    this.nnu = ((HorizontalScrollView)findViewById(2131296973));
    this.nnv = ((AppBrandActionSingleHeaderView)findViewById(2131296985));
    this.nnw = ((AppBrandActionMultipleHeaderView)findViewById(2131296979));
    this.nnx = ((AppBrandActionMultipleHeaderView)findViewById(2131296980));
    this.nny = ((AppBrandActionMultipleHeaderView)findViewById(2131296981));
    this.nnz = ((AppBrandActionMultipleHeaderView)findViewById(2131296982));
    this.nnA = ((TextView)findViewById(2131296976));
    this.nnw.setVisibility(8);
    this.nnx.setVisibility(8);
    this.nny.setVisibility(8);
    this.nnz.setVisibility(8);
    this.nnA.setVisibility(8);
    AppMethodBeat.o(147436);
  }
  
  public TextView getStatusTextView()
  {
    return this.nnA;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(147435);
    super.onAttachedToWindow();
    if (this.crI > 0) {
      setForceHeight(this.crI);
    }
    AppMethodBeat.o(147435);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147433);
    if (this.crI > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.crI, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.crI > 0) && (getMeasuredHeight() > this.crI)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.crI);
    }
    AppMethodBeat.o(147433);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(147437);
    if (paramBoolean)
    {
      this.nnv.setTextViewTextColor(this.mContext.getResources().getColor(2131101427));
      this.nnw.setTextViewTextColor(this.mContext.getResources().getColor(2131101427));
      this.nnx.setTextViewTextColor(this.mContext.getResources().getColor(2131101427));
      this.nny.setTextViewTextColor(this.mContext.getResources().getColor(2131101427));
      this.nnz.setTextViewTextColor(this.mContext.getResources().getColor(2131101427));
      this.nnA.setTextColor(this.mContext.getResources().getColor(2131101427));
      AppMethodBeat.o(147437);
      return;
    }
    this.nnv.setTextViewTextColor(this.mContext.getResources().getColor(2131100056));
    this.nnw.setTextViewTextColor(this.mContext.getResources().getColor(2131100056));
    this.nnx.setTextViewTextColor(this.mContext.getResources().getColor(2131100056));
    this.nny.setTextViewTextColor(this.mContext.getResources().getColor(2131100056));
    this.nnz.setTextViewTextColor(this.mContext.getResources().getColor(2131100056));
    this.nnA.setTextColor(this.mContext.getResources().getColor(2131100056));
    AppMethodBeat.o(147437);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(169505);
    this.crI = Math.max(paramInt, -1);
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.crI > 0) {
        localViewGroup.setMinimumHeight(this.crI);
      }
      requestLayout();
    }
    AppMethodBeat.o(169505);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147438);
    this.nnA.setText(paramCharSequence);
    this.nnA.setVisibility(0);
    this.nnt.setVisibility(8);
    this.nnu.setVisibility(8);
    AppMethodBeat.o(147438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */