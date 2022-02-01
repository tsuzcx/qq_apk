package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.text.TextPaint;
import android.text.style.URLSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class URLSpanNoUnderline
  extends URLSpan
{
  public URLSpanNoUnderline(String paramString)
  {
    super(paramString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(229901);
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(229901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.URLSpanNoUnderline
 * JD-Core Version:    0.7.0.1
 */