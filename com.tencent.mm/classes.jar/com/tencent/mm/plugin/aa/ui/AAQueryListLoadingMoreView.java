package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.y;

public class AAQueryListLoadingMoreView
  extends LinearLayout
{
  public AAQueryListLoadingMoreView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AAQueryListLoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public AAQueryListLoadingMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    y.gt(paramContext).inflate(a.g.aa_record_list_loading_more, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListLoadingMoreView
 * JD-Core Version:    0.7.0.1
 */