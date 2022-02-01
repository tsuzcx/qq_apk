package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.f;
import com.tencent.mm.ce.f.a;
import com.tencent.mm.ce.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  implements a
{
  public final boolean M(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104529);
    boolean bool = g.gxZ().M(paramCharSequence);
    AppMethodBeat.o(104529);
    return bool;
  }
  
  public final boolean N(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104530);
    boolean bool = g.gxZ().N(paramCharSequence);
    AppMethodBeat.o(104530);
    return bool;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104526);
    paramContext = g.gxZ().a(paramContext, paramCharSequence, paramFloat);
    AppMethodBeat.o(104526);
    return paramContext;
  }
  
  public final String alW(String paramString)
  {
    AppMethodBeat.i(104531);
    com.tencent.mm.ce.b.gxI();
    paramString = com.tencent.mm.ce.b.alW(paramString);
    AppMethodBeat.o(104531);
    return paramString;
  }
  
  public final SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104527);
    paramContext = l.b(paramContext, paramCharSequence, paramFloat);
    AppMethodBeat.o(104527);
    return paramContext;
  }
  
  public final String fN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104528);
    g.gxZ();
    f localf = f.gxT();
    MMApplicationContext.getContext();
    int i = 0;
    int j = paramString1.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    while (i < j)
    {
      char c = paramString1.charAt(i);
      if ((c == '/') || (c == '['))
      {
        f.a locala = localf.big(paramString1.substring(i));
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
    AppMethodBeat.o(104528);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.b
 * JD-Core Version:    0.7.0.1
 */