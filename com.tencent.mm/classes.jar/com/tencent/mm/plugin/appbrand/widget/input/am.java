package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spannable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class am
{
  static am.a[] k(TextView paramTextView)
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
        paramTextView = (am.a[])localSpannable.getSpans(0, localSpannable.length(), am.a.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.am
 * JD-Core Version:    0.7.0.1
 */