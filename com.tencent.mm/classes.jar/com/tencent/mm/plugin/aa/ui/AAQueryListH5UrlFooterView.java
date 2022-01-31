package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;

public class AAQueryListH5UrlFooterView
  extends LinearLayout
{
  private TextView eXw;
  
  public AAQueryListH5UrlFooterView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AAQueryListH5UrlFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AAQueryListH5UrlFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.eXw = ((TextView)y.gt(paramContext).inflate(a.g.aa_record_list_h5url_footer, this, true).findViewById(a.f.aa_record_bottom_link_tv));
  }
  
  public TextView getBottomLinkTv()
  {
    return this.eXw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListH5UrlFooterView
 * JD-Core Version:    0.7.0.1
 */