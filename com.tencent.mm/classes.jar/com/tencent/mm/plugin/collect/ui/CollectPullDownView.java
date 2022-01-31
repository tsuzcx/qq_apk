package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.MMPullDownView;

public class CollectPullDownView
  extends MMPullDownView
{
  public CollectPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CollectPullDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void aFp()
  {
    View localView1 = inflate(this.context, a.g.collect_bill_list_loading_view, null);
    View localView2 = inflate(this.context, a.g.collect_bill_list_loading_view, null);
    addView(localView1, 0, new FrameLayout.LayoutParams(-1, a.fromDPToPix(this.context, 48)));
    addView(localView2, new FrameLayout.LayoutParams(-1, a.fromDPToPix(this.context, 48)));
  }
  
  public void setLoadDataEnd(boolean paramBoolean)
  {
    this.uWY = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectPullDownView
 * JD-Core Version:    0.7.0.1
 */