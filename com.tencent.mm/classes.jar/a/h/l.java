package a.h;

import a.d.b.h;
import a.e.d;
import a.j;

public class l
  extends k
{
  public static final int Y(CharSequence paramCharSequence)
  {
    a.d.b.g.k(paramCharSequence, "$receiver");
    return paramCharSequence.length() - 1;
  }
  
  public static final a.g<Integer, Character> a(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    char c;
    if ((paramCharSequence instanceof String))
    {
      a.d.b.g.k(paramArrayOfChar, "$receiver");
      c = paramArrayOfChar[0];
      if (!paramBoolean) {}
      for (paramInt = ((String)paramCharSequence).indexOf(c, paramInt); paramInt < 0; paramInt = ((String)paramCharSequence).lastIndexOf(c, paramInt)) {
        return null;
      }
      return j.u(Integer.valueOf(paramInt), Character.valueOf(c));
    }
    int i;
    a.e.b localb;
    int j;
    int k;
    if (!paramBoolean)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      localb = (a.e.b)new d(i, e.Y(paramCharSequence));
      paramInt = localb.first;
      j = localb.xoz;
      k = localb.ghE;
      if (k <= 0) {
        break label196;
      }
      if (paramInt > j) {
        break label234;
      }
    }
    for (;;)
    {
      label129:
      c = paramCharSequence.charAt(paramInt);
      i = 0;
      label141:
      if (i <= 0) {
        if (!a.a(paramArrayOfChar[i], c, false)) {}
      }
      for (;;)
      {
        if (i < 0) {
          break label220;
        }
        return j.u(Integer.valueOf(paramInt), Character.valueOf(paramArrayOfChar[i]));
        localb = a.e.e.gt(a.e.e.gu(paramInt, e.Y(paramCharSequence)), 0);
        break;
        label196:
        if (paramInt < j) {
          break label234;
        }
        break label129;
        i += 1;
        break label141;
        i = -1;
      }
      label220:
      if (paramInt == j) {
        break label234;
      }
      paramInt += k;
    }
    label234:
    return null;
  }
  
  public static final boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a.d.b.g.k(paramCharSequence1, "$receiver");
    a.d.b.g.k(paramCharSequence2, "other");
    if ((paramInt1 < 0) || (paramCharSequence1.length() - paramInt2 < 0) || (paramInt1 > paramCharSequence2.length() - paramInt2)) {}
    for (;;)
    {
      return false;
      int i = paramInt2 - 1;
      if (i < 0) {
        break;
      }
      paramInt2 = 0;
      while (a.a(paramCharSequence1.charAt(paramInt2 + 0), paramCharSequence2.charAt(paramInt1 + paramInt2), paramBoolean))
      {
        if (paramInt2 == i) {
          break label92;
        }
        paramInt2 += 1;
      }
    }
    label92:
    return true;
  }
  
  public static final int b(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a.e.b localb;
    if (!paramBoolean)
    {
      i = paramInt1;
      if (paramInt1 < 0) {
        i = 0;
      }
      localb = (a.e.b)new d(i, a.e.e.gu(paramInt2, paramCharSequence1.length()));
      if ((!(paramCharSequence1 instanceof String)) || (!(paramCharSequence2 instanceof String))) {
        break label156;
      }
      paramInt1 = localb.first;
      paramInt2 = localb.xoz;
      i = localb.ghE;
      if (i <= 0) {
        break label135;
      }
      if (paramInt1 > paramInt2) {
        break label224;
      }
    }
    for (;;)
    {
      if (e.a((String)paramCharSequence2, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), false))
      {
        return paramInt1;
        i = a.e.e.gu(paramInt1, e.Y(paramCharSequence1));
        paramInt1 = paramInt2;
        if (paramInt2 < 0) {
          paramInt1 = 0;
        }
        localb = a.e.e.gt(i, paramInt1);
        break;
        label135:
        if (paramInt1 < paramInt2) {
          break label224;
        }
        continue;
      }
      if (paramInt1 == paramInt2) {
        break label224;
      }
      paramInt1 += i;
    }
    label156:
    paramInt1 = localb.first;
    paramInt2 = localb.xoz;
    int i = localb.ghE;
    if (i > 0)
    {
      if (paramInt1 > paramInt2) {}
    }
    else {
      for (;;)
      {
        if (e.a(paramCharSequence2, paramCharSequence1, paramInt1, paramCharSequence2.length(), false))
        {
          return paramInt1;
          if (paramInt1 < paramInt2) {
            break;
          }
        }
        else
        {
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += i;
        }
      }
    }
    label224:
    return -1;
  }
  
  public static final class b
    extends h
    implements a.d.a.b<d, String>
  {
    public b(CharSequence paramCharSequence)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.h.l
 * JD-Core Version:    0.7.0.1
 */