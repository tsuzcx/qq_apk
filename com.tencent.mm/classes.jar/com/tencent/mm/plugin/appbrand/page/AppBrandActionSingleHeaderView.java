package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;

public class AppBrandActionSingleHeaderView
  extends LinearLayout
{
  private ImageView bNu;
  private TextView flb;
  
  public AppBrandActionSingleHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public AppBrandActionSingleHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a.e.appbrand_action_single_header, this);
    this.bNu = ((ImageView)findViewById(a.d.appbrand_action_single_header_image));
    this.flb = ((TextView)findViewById(a.d.appbrand_action_single_header_text));
  }
  
  public ImageView getImageView()
  {
    return this.bNu;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.bNu.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    this.bNu.setImageResource(paramInt);
  }
  
  public void setTextViewText(String paramString)
  {
    this.flb.setText(paramString);
  }
  
  public void setTextViewTextColor(int paramInt)
  {
    this.flb.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView
 * JD-Core Version:    0.7.0.1
 */