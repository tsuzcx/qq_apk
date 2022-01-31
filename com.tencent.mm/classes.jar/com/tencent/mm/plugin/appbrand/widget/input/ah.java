package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spannable;
import android.widget.TextView;

final class ah
{
  static ah.a[] e(TextView paramTextView)
  {
    int i = 0;
    Spannable localSpannable = null;
    Object localObject = localSpannable;
    if (paramTextView != null)
    {
      localObject = localSpannable;
      if ((paramTextView.getText() instanceof Spannable))
      {
        localSpannable = (Spannable)paramTextView.getText();
        paramTextView = (ah.a[])localSpannable.getSpans(0, localSpannable.length(), ah.a.class);
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
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ah
 * JD-Core Version:    0.7.0.1
 */