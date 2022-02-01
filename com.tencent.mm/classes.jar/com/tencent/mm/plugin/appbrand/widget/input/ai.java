package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ai
{
  static a[] h(TextView paramTextView)
  {
    int i = 0;
    AppMethodBeat.i(131517);
    Spannable localSpannable = null;
    Object localObject = localSpannable;
    if (paramTextView != null)
    {
      localObject = localSpannable;
      if ((paramTextView.getText() instanceof Spannable))
      {
        localSpannable = (Spannable)paramTextView.getText();
        paramTextView = (a[])localSpannable.getSpans(0, localSpannable.length(), a.class);
        int j = paramTextView.length;
        for (;;)
        {
          localObject = paramTextView;
          if (i >= j) {
            break;
          }
          localSpannable.removeSpan(paramTextView[i]);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(131517);
    return localObject;
  }
  
  static class a
    implements NoCopySpan
  {
    public boolean awK;
    public float mX;
    public float mY;
    public int ovp;
    public int ovq;
    public boolean ovr;
    public boolean ovs;
    @Deprecated
    public boolean ovt;
    
    public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.mX = paramFloat1;
      this.mY = paramFloat2;
      this.ovp = paramInt1;
      this.ovq = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ai
 * JD-Core Version:    0.7.0.1
 */