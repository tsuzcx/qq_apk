package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.smiley.w;

final class a$a
  implements com.tencent.magicbrush.a.a.a
{
  private static int a(String paramString, int paramInt, k<w> paramk)
  {
    AppMethodBeat.i(45101);
    if ((paramString == null) || (paramInt < 0) || (paramInt >= paramString.length()))
    {
      AppMethodBeat.o(45101);
      return 0;
    }
    int k = paramString.codePointAt(paramInt);
    EmojiHelper.iUM();
    w localw = EmojiHelper.ayo(k);
    if (localw != null)
    {
      if (paramk != null) {
        paramk.value = localw;
      }
      paramInt = Character.charCount(k);
      AppMethodBeat.o(45101);
      return paramInt;
    }
    int j = paramInt + Character.charCount(k);
    if (j < paramString.length()) {}
    for (int i = paramString.codePointAt(j);; i = 0)
    {
      EmojiHelper.iUM();
      paramString = EmojiHelper.nS(k, i);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(45101);
      return 0;
    }
    if (paramString.mdx.length >= 2) {}
    for (i = Character.charCount(i) + j;; i = j)
    {
      if (paramk != null) {
        paramk.value = paramString;
      }
      AppMethodBeat.o(45101);
      return i - paramInt;
    }
  }
  
  public final int I(String paramString, int paramInt)
  {
    AppMethodBeat.i(45099);
    paramInt = a(paramString, paramInt, null);
    AppMethodBeat.o(45099);
    return paramInt;
  }
  
  public final Drawable J(String paramString, int paramInt)
  {
    AppMethodBeat.i(45100);
    k localk = new k();
    a(paramString, paramInt, localk);
    EmojiHelper.iUM();
    paramString = EmojiHelper.b((w)localk.value);
    AppMethodBeat.o(45100);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.a.a
 * JD-Core Version:    0.7.0.1
 */