package com.tencent.mm.plugin.editor.model.nativenote.a;

import android.text.Html;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static String TAG;
  private static f<String, Spanned> usf;
  public static Spanned usg;
  
  static
  {
    AppMethodBeat.i(181693);
    TAG = "MicroMsg.ConvertHtmlToSpanned";
    usf = new com.tencent.mm.memory.a.c(30);
    usg = null;
    AppMethodBeat.o(181693);
  }
  
  public static Spanned atL(String paramString)
  {
    AppMethodBeat.i(181691);
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    paramString = Pattern.compile("\n", 2).matcher((CharSequence)localObject).replaceAll("<br/>");
    localObject = atM(paramString);
    usf.put(paramString, localObject);
    AppMethodBeat.o(181691);
    return localObject;
  }
  
  private static Spanned atM(String paramString)
  {
    AppMethodBeat.i(181692);
    String str = paramString;
    if (!paramString.startsWith("<html>")) {
      str = "<html>".concat(String.valueOf(paramString));
    }
    paramString = str;
    if (!str.endsWith("</html>")) {
      paramString = str + "</html>";
    }
    try
    {
      usg = null;
      paramString = Html.fromHtml(paramString, null, new c());
      if (paramString == null)
      {
        AppMethodBeat.o(181692);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (usg != null)
        {
          paramString = usg;
          continue;
          int i = paramString.toString().length();
          if ((i > 1) && (paramString.toString().endsWith("\n")))
          {
            if (paramString.getSpans(i, i, ParagraphStyle.class).length > 0)
            {
              paramString = (Spanned)paramString.subSequence(0, i - 1);
              AppMethodBeat.o(181692);
              return paramString;
            }
            AppMethodBeat.o(181692);
            return paramString;
          }
          AppMethodBeat.o(181692);
          return paramString;
        }
        else
        {
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.a.a
 * JD-Core Version:    0.7.0.1
 */