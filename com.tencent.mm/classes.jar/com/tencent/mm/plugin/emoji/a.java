package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.f;
import com.tencent.mm.cd.f.a;
import com.tencent.mm.cd.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  implements com.tencent.mm.plugin.emoji.b.a
{
  public final boolean E(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(62303);
    boolean bool = g.dvk().E(paramCharSequence);
    AppMethodBeat.o(62303);
    return bool;
  }
  
  public final boolean F(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(62304);
    boolean bool = g.dvk().F(paramCharSequence);
    AppMethodBeat.o(62304);
    return bool;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(62300);
    paramContext = g.dvk().b(paramCharSequence, paramFloat);
    AppMethodBeat.o(62300);
    return paramContext;
  }
  
  public final SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(62301);
    paramContext = j.b(paramContext, paramCharSequence, paramFloat);
    AppMethodBeat.o(62301);
    return paramContext;
  }
  
  public final String dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62302);
    g.dvk();
    f localf = f.dvf();
    ah.getContext();
    int i = 0;
    int j = paramString1.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    while (i < j)
    {
      char c = paramString1.charAt(i);
      if ((c == '/') || (c == '['))
      {
        f.a locala = localf.aqE(paramString1.substring(i));
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
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(62302);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a
 * JD-Core Version:    0.7.0.1
 */