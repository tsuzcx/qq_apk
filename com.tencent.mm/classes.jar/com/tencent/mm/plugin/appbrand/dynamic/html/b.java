package com.tencent.mm.plugin.appbrand.dynamic.html;

import android.text.Editable;
import android.text.Html.TagHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xml.sax.XMLReader;

public final class b
  implements Html.TagHandler
{
  public final void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    AppMethodBeat.i(10814);
    int i;
    int j;
    if ("a".equalsIgnoreCase(paramString))
    {
      if (paramBoolean)
      {
        i = paramEditable.length();
        paramEditable.setSpan(new CustomURLSpan(""), i, i, 17);
        AppMethodBeat.o(10814);
        return;
      }
      j = paramEditable.length();
      paramString = paramEditable.getSpans(0, paramEditable.length(), CustomURLSpan.class);
      if (paramString.length == 0) {
        break label199;
      }
      i = paramString.length;
      if (i <= 0) {
        break label199;
      }
      if (paramEditable.getSpanFlags(paramString[(i - 1)]) != 17) {
        break label190;
      }
    }
    label190:
    label199:
    for (paramString = paramString[(i - 1)];; paramString = null)
    {
      paramString = (CustomURLSpan)paramString;
      i = paramEditable.getSpanStart(paramString);
      paramXMLReader = paramEditable.subSequence(i, j).toString();
      paramEditable.removeSpan(paramString);
      if (i != j) {
        paramEditable.setSpan(new CustomURLSpan(paramXMLReader), i, j, 33);
      }
      AppMethodBeat.o(10814);
      return;
      i -= 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.html.b
 * JD-Core Version:    0.7.0.1
 */