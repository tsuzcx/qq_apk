package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;

public class CollectRadioBtnView
  extends LinearLayout
{
  private TextView haW;
  private ImageView iMf;
  
  public CollectRadioBtnView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public CollectRadioBtnView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    paramContext = y.gt(paramContext).inflate(a.g.collect_bill_radio_btn, this);
    this.iMf = ((ImageView)paramContext.findViewById(a.f.radio_iv));
    this.haW = ((TextView)paramContext.findViewById(a.f.title_tv));
  }
  
  public void setRadioSrc(int paramInt)
  {
    this.iMf.setImageResource(paramInt);
  }
  
  public void setTitleText(String paramString)
  {
    this.haW.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectRadioBtnView
 * JD-Core Version:    0.7.0.1
 */