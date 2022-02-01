package com.pay.tool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.midas.comm.APLog;

public class APCustomLayout
  extends LinearLayout
{
  private a a = null;
  
  public APCustomLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    APLog.i("APCustomLayout", "onSizeChanged");
    if (this.a != null)
    {
      APLog.i("APCustomLayout", "onSizeChanged mListener != null");
      this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    APLog.i("APCustomLayout", "onSizeChanged mListener = null");
  }
  
  public void setOnResizeListener(a parama)
  {
    this.a = parama;
    APLog.i("APCustomLayout", "setOnResizeListener set mListener");
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.tool.APCustomLayout
 * JD-Core Version:    0.7.0.1
 */