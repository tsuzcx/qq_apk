package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class PLSysTextView
  extends SysTextView
{
  public PLSysTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLSysTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (getLayoutWrapper() != null) {
      getLayoutWrapper().dOg = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onPreDraw()
  {
    return true;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (bk.L(paramCharSequence)) {
      if (h.DEBUG) {
        y.d("MicroMsg.PLSysTextView", "set null text");
      }
    }
    for (;;)
    {
      return;
      long l = 0L;
      if (h.DEBUG) {
        l = System.currentTimeMillis();
      }
      if ((getLayoutWrapper() != null) && (getLayoutWrapper().dOg)) {
        c.dNE.a(getConfig(), getLayoutWrapper());
      }
      paramBufferType = c.dNE.a(getConfig(), paramCharSequence);
      if (paramBufferType != null) {
        setTextLayout(paramBufferType);
      }
      for (boolean bool = true; h.DEBUG; bool = false)
      {
        y.d("MicroMsg.PLSysTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s", new Object[] { Double.valueOf((System.currentTimeMillis() - l) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence });
        return;
        super.setText$609c24db(paramCharSequence);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLSysTextView
 * JD-Core Version:    0.7.0.1
 */