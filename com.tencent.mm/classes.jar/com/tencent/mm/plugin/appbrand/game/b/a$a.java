package com.tencent.mm.plugin.appbrand.game.b;

import android.graphics.drawable.Drawable;
import com.tencent.magicbrush.a.b.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.cd.c;
import com.tencent.mm.plugin.appbrand.u.k;

public final class a$a
  implements b.a
{
  private static int a(String paramString, int paramInt, k<c> paramk)
  {
    if ((paramString == null) || (paramInt < 0) || (paramInt >= paramString.length())) {}
    int j;
    do
    {
      return 0;
      int k = paramString.codePointAt(paramInt);
      c localc = b.csC().Fi(k);
      if (localc != null)
      {
        if (paramk != null) {
          paramk.value = localc;
        }
        return Character.charCount(k);
      }
      j = paramInt + Character.charCount(k);
      if (j >= paramString.length()) {
        break;
      }
      i = paramString.codePointAt(j);
      paramString = b.csC().fg(k, i);
    } while (paramString == null);
    if (paramString.hxu != 0) {}
    for (int i = Character.charCount(i) + j;; i = j)
    {
      if (paramk != null) {
        paramk.value = paramString;
      }
      return i - paramInt;
      i = 0;
      break;
    }
  }
  
  public final int l(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null);
  }
  
  public final Drawable m(String paramString, int paramInt)
  {
    k localk = new k();
    a(paramString, paramInt, localk);
    return b.csC().a((c)localk.value, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */