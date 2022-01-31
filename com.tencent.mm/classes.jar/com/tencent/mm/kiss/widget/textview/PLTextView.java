package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class PLTextView
  extends StaticTextView
{
  private static long dNG = 0L;
  private static int dNH = 0;
  private static long dNI = -2147483648L;
  private static long dNJ = 0L;
  private static int dNK = 0;
  private static long dNL = -2147483648L;
  private static long dNM = 0L;
  private static int dNN = 0;
  private static long dNO = -2147483648L;
  private static boolean dNP = false;
  
  public PLTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PLTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void o(CharSequence paramCharSequence)
  {
    super.setText(paramCharSequence, false);
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
    long l = 0L;
    if (dNP) {
      l = System.currentTimeMillis();
    }
    super.onDraw(paramCanvas);
    if (dNP)
    {
      l = System.currentTimeMillis() - l;
      dNM += l;
      dNN += 1;
      if (l > dNO) {
        dNO = l;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (dNP) {
      l = System.currentTimeMillis();
    }
    super.onMeasure(paramInt1, paramInt2);
    if (dNP)
    {
      l = System.currentTimeMillis() - l;
      dNJ += l;
      dNK += 1;
      if (l > dNL) {
        dNL = l;
      }
    }
  }
  
  public void p(CharSequence paramCharSequence) {}
  
  public void setText(CharSequence paramCharSequence)
  {
    long l2 = 0L;
    if (bk.L(paramCharSequence))
    {
      if (h.DEBUG) {
        y.d("MicroMsg.PLTextView", "set null text");
      }
      return;
    }
    if (h.DEBUG) {}
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      if ((getLayoutWrapper() != null) && (getLayoutWrapper().dOg)) {
        c.dNE.a(getConfig(), getLayoutWrapper());
      }
      f localf = c.dNE.a(getConfig(), paramCharSequence);
      if (localf != null)
      {
        p(paramCharSequence);
        setTextLayout(localf);
      }
      for (boolean bool = true;; bool = false)
      {
        if (h.DEBUG)
        {
          l2 = System.currentTimeMillis();
          y.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[] { Double.valueOf((l2 - l1) / 1000000.0D), Boolean.valueOf(bool), Integer.valueOf(hashCode()), paramCharSequence, Boolean.valueOf(bool) });
        }
        if (!dNP) {
          break;
        }
        l1 = l2 - l1;
        dNG += l1;
        dNH += 1;
        if (l1 <= dNI) {
          break;
        }
        dNI = l1;
        return;
        o(paramCharSequence);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kiss.widget.textview.PLTextView
 * JD-Core Version:    0.7.0.1
 */