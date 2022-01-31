package a.l;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, eaR=1)
public class t
  extends s
{
  public static final Integer azu(String paramString)
  {
    AppMethodBeat.i(56284);
    j.q(paramString, "receiver$0");
    paramString = m.fn(paramString, 10);
    AppMethodBeat.o(56284);
    return paramString;
  }
  
  public static final Long azv(String paramString)
  {
    AppMethodBeat.i(56286);
    j.q(paramString, "receiver$0");
    paramString = m.fo(paramString, 10);
    AppMethodBeat.o(56286);
    return paramString;
  }
  
  public static final Integer fn(String paramString, int paramInt)
  {
    int k = -2147483647;
    int m = 0;
    int n = 0;
    AppMethodBeat.i(56285);
    j.q(paramString, "receiver$0");
    a.We(paramInt);
    int i1 = paramString.length();
    if (i1 == 0)
    {
      AppMethodBeat.o(56285);
      return null;
    }
    int i = paramString.charAt(0);
    int j;
    int i2;
    if (i < 48)
    {
      if (i1 == 1)
      {
        AppMethodBeat.o(56285);
        return null;
      }
      if (i == 45)
      {
        k = -2147483648;
        i = 1;
        j = 1;
        i2 = k / paramInt;
        i1 -= 1;
        if (i > i1) {
          break label220;
        }
      }
    }
    for (m = n;; m = n)
    {
      n = Character.digit(paramString.charAt(i), paramInt);
      if (n < 0)
      {
        AppMethodBeat.o(56285);
        return null;
        if (i == 43)
        {
          i = 1;
          j = 0;
          break;
        }
        AppMethodBeat.o(56285);
        return null;
        i = 0;
        j = 0;
        break;
      }
      if (m < i2)
      {
        AppMethodBeat.o(56285);
        return null;
      }
      m *= paramInt;
      if (m < k + n)
      {
        AppMethodBeat.o(56285);
        return null;
      }
      n = m - n;
      m = n;
      if (i == i1) {
        break label220;
      }
      i += 1;
    }
    label220:
    if (j != 0)
    {
      AppMethodBeat.o(56285);
      return Integer.valueOf(m);
    }
    paramInt = -m;
    AppMethodBeat.o(56285);
    return Integer.valueOf(paramInt);
  }
  
  public static final Long fo(String paramString, int paramInt)
  {
    AppMethodBeat.i(56287);
    j.q(paramString, "receiver$0");
    a.We(paramInt);
    int k = paramString.length();
    if (k == 0)
    {
      AppMethodBeat.o(56287);
      return null;
    }
    int i = paramString.charAt(0);
    int j;
    long l4;
    long l3;
    long l2;
    if (i < 48)
    {
      if (k == 1)
      {
        AppMethodBeat.o(56287);
        return null;
      }
      j = 1;
      if (i == 45)
      {
        i = 1;
        l1 = -9223372036854775808L;
        l4 = l1 / paramInt;
        l3 = 0L;
        k -= 1;
        l2 = l3;
        if (j > k) {
          break label224;
        }
      }
    }
    for (;;)
    {
      int m = Character.digit(paramString.charAt(j), paramInt);
      if (m < 0)
      {
        AppMethodBeat.o(56287);
        return null;
        if (i == 43)
        {
          i = 0;
          l1 = -9223372036854775807L;
          break;
        }
        AppMethodBeat.o(56287);
        return null;
        j = 0;
        i = 0;
        l1 = -9223372036854775807L;
        break;
      }
      if (l3 < l4)
      {
        AppMethodBeat.o(56287);
        return null;
      }
      l2 = l3 * paramInt;
      if (l2 < m + l1)
      {
        AppMethodBeat.o(56287);
        return null;
      }
      l3 = l2 - m;
      l2 = l3;
      if (j == k) {
        break label224;
      }
      j += 1;
    }
    label224:
    if (i != 0)
    {
      AppMethodBeat.o(56287);
      return Long.valueOf(l2);
    }
    long l1 = -l2;
    AppMethodBeat.o(56287);
    return Long.valueOf(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.l.t
 * JD-Core Version:    0.7.0.1
 */