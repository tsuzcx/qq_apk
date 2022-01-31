package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.cd.f;
import com.tencent.mm.cd.f.a;
import com.tencent.mm.cd.g;
import com.tencent.mm.pluginsdk.ui.d.j;

public final class a
  implements com.tencent.mm.plugin.emoji.b.a
{
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    return j.a(paramContext, paramCharSequence, paramFloat);
  }
  
  public final SpannableString a(CharSequence paramCharSequence, float paramFloat)
  {
    return g.csM().a(paramCharSequence, paramFloat);
  }
  
  public final String cG(String paramString1, String paramString2)
  {
    g.csM();
    f localf = f.csI();
    int i = 0;
    int j = paramString1.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    while (i < j)
    {
      char c = paramString1.charAt(i);
      if ((c == '/') || (c == '['))
      {
        f.a locala = localf.aau(paramString1.substring(i));
        if (locala != null)
        {
          localStringBuilder.append(paramString2);
          i += locala.text.length();
          continue;
        }
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final boolean v(CharSequence paramCharSequence)
  {
    return g.csM().v(paramCharSequence);
  }
  
  public final boolean w(CharSequence paramCharSequence)
  {
    return g.csM().w(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a
 * JD-Core Version:    0.7.0.1
 */