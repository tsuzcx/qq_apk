package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.b;
import com.tencent.mm.cf.c;
import com.tencent.mm.plugin.appbrand.z.i;

final class a$a
  implements com.tencent.magicbrush.a.a.a
{
  private static int a(String paramString, int paramInt, i<c> parami)
  {
    AppMethodBeat.i(45101);
    if ((paramString == null) || (paramInt < 0) || (paramInt >= paramString.length()))
    {
      AppMethodBeat.o(45101);
      return 0;
    }
    int k = paramString.codePointAt(paramInt);
    c localc = b.fmR().aaC(k);
    if (localc != null)
    {
      if (parami != null) {
        parami.value = localc;
      }
      paramInt = Character.charCount(k);
      AppMethodBeat.o(45101);
      return paramInt;
    }
    int j = paramInt + Character.charCount(k);
    if (j < paramString.length()) {}
    for (int i = paramString.codePointAt(j);; i = 0)
    {
      paramString = b.fmR().jy(k, i);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(45101);
      return 0;
    }
    if (paramString.nhT != 0) {}
    for (i = Character.charCount(i) + j;; i = j)
    {
      if (parami != null) {
        parami.value = paramString;
      }
      AppMethodBeat.o(45101);
      return i - paramInt;
    }
  }
  
  public final int p(String paramString, int paramInt)
  {
    AppMethodBeat.i(45099);
    paramInt = a(paramString, paramInt, null);
    AppMethodBeat.o(45099);
    return paramInt;
  }
  
  public final Drawable q(String paramString, int paramInt)
  {
    AppMethodBeat.i(45100);
    i locali = new i();
    a(paramString, paramInt, locali);
    paramString = b.fmR().a((c)locali.value, true);
    AppMethodBeat.o(45100);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.a
 * JD-Core Version:    0.7.0.1
 */