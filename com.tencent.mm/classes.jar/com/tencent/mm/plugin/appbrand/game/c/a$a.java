package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.cd.c;
import com.tencent.mm.plugin.appbrand.s.j;

final class a$a
  implements com.tencent.magicbrush.a.a.a
{
  private static int a(String paramString, int paramInt, j<c> paramj)
  {
    AppMethodBeat.i(143120);
    if ((paramString == null) || (paramInt < 0) || (paramInt >= paramString.length()))
    {
      AppMethodBeat.o(143120);
      return 0;
    }
    int k = paramString.codePointAt(paramInt);
    c localc = b.duW().Nn(k);
    if (localc != null)
    {
      if (paramj != null) {
        paramj.value = localc;
      }
      paramInt = Character.charCount(k);
      AppMethodBeat.o(143120);
      return paramInt;
    }
    int j = paramInt + Character.charCount(k);
    if (j < paramString.length()) {}
    for (int i = paramString.codePointAt(j);; i = 0)
    {
      paramString = b.duW().hn(k, i);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(143120);
      return 0;
    }
    if (paramString.jpE != 0) {}
    for (i = Character.charCount(i) + j;; i = j)
    {
      if (paramj != null) {
        paramj.value = paramString;
      }
      AppMethodBeat.o(143120);
      return i - paramInt;
    }
  }
  
  public final int n(String paramString, int paramInt)
  {
    AppMethodBeat.i(143118);
    paramInt = a(paramString, paramInt, null);
    AppMethodBeat.o(143118);
    return paramInt;
  }
  
  public final Drawable o(String paramString, int paramInt)
  {
    AppMethodBeat.i(143119);
    j localj = new j();
    a(paramString, paramInt, localj);
    paramString = b.duW().a((c)localj.value, true);
    AppMethodBeat.o(143119);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.a
 * JD-Core Version:    0.7.0.1
 */