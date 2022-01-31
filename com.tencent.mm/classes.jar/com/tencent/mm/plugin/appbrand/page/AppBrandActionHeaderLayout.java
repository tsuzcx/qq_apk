package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.ui.af;

public class AppBrandActionHeaderLayout
  extends LinearLayout
{
  private LinearLayout iuI;
  private HorizontalScrollView iuJ;
  private AppBrandActionSingleHeaderView iuK;
  private AppBrandActionMultipleHeaderView iuL;
  private AppBrandActionMultipleHeaderView iuM;
  private AppBrandActionMultipleHeaderView iuN;
  private AppBrandActionMultipleHeaderView iuO;
  private TextView iuP;
  private Context mContext;
  private int mMaxHeight;
  
  public AppBrandActionHeaderLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(132328);
    this.mMaxHeight = -1;
    aA(paramContext);
    AppMethodBeat.o(132328);
  }
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(132329);
    this.mMaxHeight = -1;
    aA(paramContext);
    AppMethodBeat.o(132329);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(132330);
    this.mMaxHeight = -1;
    aA(paramContext);
    AppMethodBeat.o(132330);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(132331);
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130968763, this);
    this.iuI = ((LinearLayout)findViewById(2131821500));
    this.iuJ = ((HorizontalScrollView)findViewById(2131821502));
    this.iuK = ((AppBrandActionSingleHeaderView)findViewById(2131821501));
    this.iuL = ((AppBrandActionMultipleHeaderView)findViewById(2131821504));
    this.iuM = ((AppBrandActionMultipleHeaderView)findViewById(2131821505));
    this.iuN = ((AppBrandActionMultipleHeaderView)findViewById(2131821506));
    this.iuO = ((AppBrandActionMultipleHeaderView)findViewById(2131821507));
    this.iuP = ((TextView)findViewById(2131821508));
    this.iuL.setVisibility(8);
    this.iuM.setVisibility(8);
    this.iuN.setVisibility(8);
    this.iuO.setVisibility(8);
    this.iuP.setVisibility(8);
    if (af.dDl()) {
      setMinimumHeight(a.fromDPToPix(paramContext, 234));
    }
    AppMethodBeat.o(132331);
  }
  
  private void aII()
  {
    AppMethodBeat.i(132333);
    this.iuI.setVisibility(0);
    this.iuJ.setVisibility(8);
    AppMethodBeat.o(132333);
  }
  
  public final void a(String paramString1, String paramString2, Drawable paramDrawable)
  {
    AppMethodBeat.i(140870);
    aII();
    this.iuK.setImageDrawable(paramDrawable);
    b.acD().a(this.iuK.getImageView(), paramString1, null, f.fqU);
    this.iuK.setTextViewText(paramString2);
    AppMethodBeat.o(140870);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(140869);
    super.onAttachedToWindow();
    if ((getParent() instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (this.mMaxHeight > 0) {
        localViewGroup.setMinimumHeight(0);
      }
      if (getMinimumHeight() > 0) {
        localViewGroup.setMinimumHeight(getMinimumHeight());
      }
    }
    AppMethodBeat.o(140869);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140867);
    if (this.mMaxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mMaxHeight > 0) && (getMeasuredHeight() > this.mMaxHeight)) {
      super.setMeasuredDimension(getMeasuredWidth(), this.mMaxHeight);
    }
    AppMethodBeat.o(140867);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(132334);
    if (paramBoolean)
    {
      this.iuK.setTextViewTextColor(this.mContext.getResources().getColor(2131690711));
      this.iuL.setTextViewTextColor(this.mContext.getResources().getColor(2131690711));
      this.iuM.setTextViewTextColor(this.mContext.getResources().getColor(2131690711));
      this.iuN.setTextViewTextColor(this.mContext.getResources().getColor(2131690711));
      this.iuO.setTextViewTextColor(this.mContext.getResources().getColor(2131690711));
      this.iuP.setTextColor(this.mContext.getResources().getColor(2131690711));
      AppMethodBeat.o(132334);
      return;
    }
    this.iuK.setTextViewTextColor(this.mContext.getResources().getColor(2131689774));
    this.iuL.setTextViewTextColor(this.mContext.getResources().getColor(2131689774));
    this.iuM.setTextViewTextColor(this.mContext.getResources().getColor(2131689774));
    this.iuN.setTextViewTextColor(this.mContext.getResources().getColor(2131689774));
    this.iuO.setTextViewTextColor(this.mContext.getResources().getColor(2131689774));
    this.iuP.setTextColor(this.mContext.getResources().getColor(2131689774));
    AppMethodBeat.o(132334);
  }
  
  @Deprecated
  public void setAppId(String paramString) {}
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(140868);
    this.mMaxHeight = Math.max(paramInt, -1);
    AppMethodBeat.o(140868);
  }
  
  public void setStatusDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(132335);
    this.iuP.setText(paramCharSequence);
    this.iuP.setVisibility(0);
    this.iuI.setVisibility(8);
    this.iuJ.setVisibility(8);
    AppMethodBeat.o(132335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */