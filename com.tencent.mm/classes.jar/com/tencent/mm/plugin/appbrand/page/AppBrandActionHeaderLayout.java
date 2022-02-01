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
  private Context mContext;
  private LinearLayout mda;
  private HorizontalScrollView mdb;
  private AppBrandActionSingleHeaderView mdc;
  private AppBrandActionMultipleHeaderView mdd;
  private AppBrandActionMultipleHeaderView mde;
  private AppBrandActionMultipleHeaderView mdf;
  private AppBrandActionMultipleHeaderView mdg;
  private TextView mdh;
  private int mdi;
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(147431);
    this.mdi = -1;
    aN(paramContext);
    AppMethodBeat.o(147431);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(147432);
    this.mdi = -1;
    aN(paramContext);
    AppMethodBeat.o(147432);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(147436);
    this.mContext = paramContext;
    View.inflate(paramContext, 2131493089, this);
    this.mda = ((LinearLayout)findViewById(2131296881));
    this.mdb = ((HorizontalScrollView)findViewById(2131296879));
    this.mdc = ((AppBrandActionSingleHeaderView)findViewById(2131296891));
    this.mdd = ((AppBrandActionMultipleHeaderView)findViewById(2131296885));
    this.mde = ((AppBrandActionMultipleHeaderView)findViewById(2131296886));
    this.mdf = ((AppBrandActionMultipleHeaderView)findViewById(2131296887));
    this.mdg = ((AppBrandActionMultipleHeaderView)findViewById(2131296888));
    this.mdh = ((TextView)findViewById(2131296882));
    this.mdd.setVisibility(8);
    this.mde.setVisibility(8);
    this.mdf.setVisibility(8);
    this.mdg.setVisibility(8);
    this.mdh.setVisibility(8);
    AppMethodBeat.o(147436);
  }
  
  public TextView getStatusTextView()
  {
    return this.mdh;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(147435);
    super.onAttachedToWindow();
    if (this.mdi > 0) {
      setForceHeight(this.mdi);
    }
    AppMethodBeat.o(147435);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(147433);
    if (this.mdi > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mdi, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mdi > 0) && (getMeasuredHeight() > this.mdi)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.mdi);
    }
    AppMethodBeat.o(147433);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(147437);
    if (paramBoolean)
    {
      this.mdc.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.mdd.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.mde.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.mdf.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.mdg.setTextViewTextColor(this.mContext.getResources().getColor(2131101182));
      this.mdh.setTextColor(this.mContext.getResources().getColor(2131101182));
      AppMethodBeat.o(147437);
      return;
    }
    this.mdc.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.mdd.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.mde.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.mdf.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.mdg.setTextViewTextColor(this.mContext.getResources().getColor(2131100030));
    this.mdh.setTextColor(this.mContext.getResources().getColor(2131100030));
    AppMethodBeat.o(147437);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setForceHeight(int paramInt)
  {
    AppMethodBeat.i(169505);
    this.mdi = Math.max(paramInt, -1);
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.mdi > 0) {
        localViewGroup.setMinimumHeight(this.mdi);
      }
      requestLayout();
    }
    AppMethodBeat.o(169505);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(147438);
    this.mdh.setText(paramCharSequence);
    this.mdh.setVisibility(0);
    this.mda.setVisibility(8);
    this.mdb.setVisibility(8);
    AppMethodBeat.o(147438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */