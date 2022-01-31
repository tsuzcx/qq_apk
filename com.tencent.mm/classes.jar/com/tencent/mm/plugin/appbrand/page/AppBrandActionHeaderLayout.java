package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;

public class AppBrandActionHeaderLayout
  extends LinearLayout
{
  private LinearLayout gSi;
  private HorizontalScrollView gSj;
  private AppBrandActionSingleHeaderView gSk;
  private AppBrandActionMultipleHeaderView gSl;
  private AppBrandActionMultipleHeaderView gSm;
  private AppBrandActionMultipleHeaderView gSn;
  private AppBrandActionMultipleHeaderView gSo;
  private TextView gSp;
  private int gSq = 1;
  private int gSr = 2;
  private String mAppId;
  private Context mContext;
  
  public AppBrandActionHeaderLayout(Context paramContext)
  {
    super(paramContext);
    ca(paramContext);
  }
  
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ca(paramContext);
  }
  
  @TargetApi(11)
  public AppBrandActionHeaderLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ca(paramContext);
  }
  
  private void ca(Context paramContext)
  {
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(y.h.appbrand_action_game_header_layout, this);
    this.gSi = ((LinearLayout)findViewById(y.g.appbrand_action_header_single_layout));
    this.gSj = ((HorizontalScrollView)findViewById(y.g.appbrand_action_header_hscrollview));
    this.gSk = ((AppBrandActionSingleHeaderView)findViewById(y.g.appbrand_action_single_header_view));
    this.gSl = ((AppBrandActionMultipleHeaderView)findViewById(y.g.appbrand_action_multiple_header_view1));
    this.gSm = ((AppBrandActionMultipleHeaderView)findViewById(y.g.appbrand_action_multiple_header_view2));
    this.gSn = ((AppBrandActionMultipleHeaderView)findViewById(y.g.appbrand_action_multiple_header_view3));
    this.gSo = ((AppBrandActionMultipleHeaderView)findViewById(y.g.appbrand_action_multiple_header_view4));
    this.gSp = ((TextView)findViewById(y.g.appbrand_action_header_status));
    this.gSl.setVisibility(8);
    this.gSm.setVisibility(8);
    this.gSn.setVisibility(8);
    this.gSo.setVisibility(8);
    this.gSp.setVisibility(8);
  }
  
  public final void bX(String paramString1, String paramString2)
  {
    this.gSi.setVisibility(0);
    this.gSj.setVisibility(8);
    this.gSk.setImageDrawable(a.JC());
    b.JD().a(this.gSk.getImageView(), paramString1, null, f.eaL);
    this.gSk.setTextViewText(paramString2);
  }
  
  public void setActionHeaderStyle(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gSk.setTextViewTextColor(this.mContext.getResources().getColor(y.d.white_text_color));
      this.gSl.setTextViewTextColor(this.mContext.getResources().getColor(y.d.white_text_color));
      this.gSm.setTextViewTextColor(this.mContext.getResources().getColor(y.d.white_text_color));
      this.gSn.setTextViewTextColor(this.mContext.getResources().getColor(y.d.white_text_color));
      this.gSo.setTextViewTextColor(this.mContext.getResources().getColor(y.d.white_text_color));
      this.gSp.setTextColor(this.mContext.getResources().getColor(y.d.white_text_color));
      return;
    }
    this.gSk.setTextViewTextColor(this.mContext.getResources().getColor(y.d.bottom_sheet_text_color));
    this.gSl.setTextViewTextColor(this.mContext.getResources().getColor(y.d.bottom_sheet_text_color));
    this.gSm.setTextViewTextColor(this.mContext.getResources().getColor(y.d.bottom_sheet_text_color));
    this.gSn.setTextViewTextColor(this.mContext.getResources().getColor(y.d.bottom_sheet_text_color));
    this.gSo.setTextViewTextColor(this.mContext.getResources().getColor(y.d.bottom_sheet_text_color));
    this.gSp.setTextColor(this.mContext.getResources().getColor(y.d.bottom_sheet_text_color));
  }
  
  public void setAppId(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public void setStatusId(int paramInt)
  {
    this.gSp.setText(paramInt);
    this.gSp.setVisibility(0);
    this.gSi.setVisibility(8);
    this.gSj.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout
 * JD-Core Version:    0.7.0.1
 */