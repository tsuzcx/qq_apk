package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.ce.f;
import com.tencent.mm.ce.f.a;
import com.tencent.mm.ce.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  implements com.tencent.mm.plugin.emoji.b.a
{
  public final boolean I(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104529);
    boolean bool = g.fqZ().I(paramCharSequence);
    AppMethodBeat.o(104529);
    return bool;
  }
  
  public final boolean J(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(104530);
    boolean bool = g.fqZ().J(paramCharSequence);
    AppMethodBeat.o(104530);
    return bool;
  }
  
  public final SpannableString a(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104526);
    paramContext = g.fqZ().b(paramCharSequence, paramFloat);
    AppMethodBeat.o(104526);
    return paramContext;
  }
  
  public final String abU(String paramString)
  {
    AppMethodBeat.i(104531);
    b.fqL();
    paramString = b.abU(paramString);
    AppMethodBeat.o(104531);
    return paramString;
  }
  
  public final SpannableString b(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    AppMethodBeat.i(104527);
    paramContext = k.b(paramContext, paramCharSequence, paramFloat);
    AppMethodBeat.o(104527);
    return paramContext;
  }
  
  public final String fv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(104528);
    g.fqZ();
    f localf = f.fqV();
    ak.getContext();
    int i = 0;
    int j = paramString1.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    while (i < j)
    {
      char c = paramString1.charAt(i);
      if ((c == '/') || (c == '['))
      {
        f.a locala = localf.aTm(paramString1.substring(i));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a
 * JD-Core Version:    0.7.0.1
 */