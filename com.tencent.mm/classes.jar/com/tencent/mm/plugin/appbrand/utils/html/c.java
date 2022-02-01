package com.tencent.mm.plugin.appbrand.utils.html;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static CharSequence a(CharSequence paramCharSequence, a parama, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(147730);
    if ((paramCharSequence instanceof Spannable))
    {
      int j = paramCharSequence.length();
      Spannable localSpannable = (Spannable)paramCharSequence;
      URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannable.getSpans(0, j, URLSpan.class);
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      j = arrayOfURLSpan.length;
      while (i < j)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i];
        paramCharSequence.removeSpan(localURLSpan);
        paramCharSequence.setSpan(new CustomURLSpan(localURLSpan.getURL(), parama, paramBoolean), localSpannable.getSpanStart(localURLSpan), localSpannable.getSpanEnd(localURLSpan), 34);
        i += 1;
      }
      AppMethodBeat.o(147730);
      return paramCharSequence;
    }
    AppMethodBeat.o(147730);
    return paramCharSequence;
  }
  
  public static CharSequence a(String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(147731);
    paramString = a(Html.fromHtml(paramString, new a(), new b(parama, paramBoolean)), parama, paramBoolean);
    AppMethodBeat.o(147731);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void Ho(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.html.c
 * JD-Core Version:    0.7.0.1
 */