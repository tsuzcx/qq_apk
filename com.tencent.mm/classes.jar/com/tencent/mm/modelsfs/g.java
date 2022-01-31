package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumSet;

final class g
{
  private static int a(String paramString, int paramInt, char paramChar, EnumSet<a> paramEnumSet)
  {
    AppMethodBeat.i(93210);
    if (paramInt >= paramString.length())
    {
      AppMethodBeat.o(93210);
      return -1;
    }
    int i = paramString.charAt(paramInt);
    if ((i == 33) || (i == 94)) {}
    int i1;
    for (int k = 1;; k = 0)
    {
      i = paramInt;
      if (k != 0) {
        i = paramInt + 1;
      }
      i1 = paramChar;
      if (paramEnumSet.contains(a.fOx)) {
        i1 = Character.toLowerCase(paramChar);
      }
      paramInt = 0;
      if (i < paramString.length()) {
        break;
      }
      AppMethodBeat.o(93210);
      return -1;
    }
    int j = i + 1;
    paramChar = paramString.charAt(i);
    if (paramChar != ']')
    {
      if ((paramChar != '\\') || (paramEnumSet.contains(a.fOt))) {
        break label384;
      }
      i = j + 1;
      paramChar = paramString.charAt(j);
      j = i;
    }
    label384:
    for (;;)
    {
      if ((paramChar == '/') && (paramEnumSet.contains(a.fOu)))
      {
        AppMethodBeat.o(93210);
        return 0;
      }
      int m = paramChar;
      if (paramEnumSet.contains(a.fOx)) {
        m = Character.toLowerCase(paramChar);
      }
      if ((paramString.charAt(j) == '-') && (j + 1 < paramString.length()))
      {
        paramChar = paramString.charAt(j + 1);
        if (paramChar != ']')
        {
          j += 2;
          if ((paramChar != '\\') || (paramEnumSet.contains(a.fOt))) {
            break label381;
          }
          if (j >= paramString.length())
          {
            AppMethodBeat.o(93210);
            return -1;
          }
          i = j + 1;
          m = paramString.charAt(j);
          j = i;
        }
      }
      label381:
      for (;;)
      {
        if (paramEnumSet.contains(a.fOx)) {}
        for (int n = Character.toLowerCase(paramChar);; n = paramChar)
        {
          i = j;
          if (m > i1) {
            break;
          }
          i = j;
          if (i1 > n) {
            break;
          }
          paramInt = 1;
          i = j;
          break;
          i = j;
          if (m != i1) {
            break;
          }
          paramInt = 1;
          i = j;
          break;
          if (paramInt == k)
          {
            AppMethodBeat.o(93210);
            return 0;
          }
          AppMethodBeat.o(93210);
          return j;
        }
      }
    }
  }
  
  static boolean a(String paramString1, int paramInt1, String paramString2, int paramInt2, EnumSet<a> paramEnumSet)
  {
    AppMethodBeat.i(93208);
    int j;
    int i;
    for (;;)
    {
      if (paramInt1 >= paramString1.length())
      {
        if ((paramEnumSet.contains(a.fOw)) && (paramString2.charAt(paramInt2) == '/'))
        {
          AppMethodBeat.o(93208);
          return true;
        }
        if (paramInt2 == paramString2.length())
        {
          AppMethodBeat.o(93208);
          return true;
        }
        AppMethodBeat.o(93208);
        return false;
      }
      j = paramInt1 + 1;
      i = paramString1.charAt(paramInt1);
      switch (i)
      {
      default: 
        paramInt1 = j;
        if (paramInt2 < paramString2.length()) {
          break;
        }
        AppMethodBeat.o(93208);
        return false;
      case 63: 
        label120:
        label123:
        if (paramInt2 >= paramString2.length())
        {
          AppMethodBeat.o(93208);
          return false;
        }
        if ((paramString2.charAt(paramInt2) == '/') && (paramEnumSet.contains(a.fOu)))
        {
          AppMethodBeat.o(93208);
          return false;
        }
        if (a(paramString2, paramInt2, paramEnumSet))
        {
          AppMethodBeat.o(93208);
          return false;
        }
        paramInt2 += 1;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      int k;
      if (paramInt1 < paramString1.length())
      {
        j = paramString1.charAt(paramInt1);
        k = j;
        if (j == 42) {
          paramInt1 += 1;
        }
      }
      else
      {
        k = j;
      }
      if (a(paramString2, paramInt2, paramEnumSet))
      {
        AppMethodBeat.o(93208);
        return false;
      }
      if (paramInt1 == paramString1.length())
      {
        if (paramEnumSet.contains(a.fOu))
        {
          if ((paramEnumSet.contains(a.fOw)) || (paramString2.indexOf('/', paramInt2) == -1))
          {
            AppMethodBeat.o(93208);
            return true;
          }
          AppMethodBeat.o(93208);
          return false;
        }
        AppMethodBeat.o(93208);
        return true;
      }
      j = paramInt2;
      EnumSet<a> localEnumSet = paramEnumSet;
      if (k == 47)
      {
        j = paramInt2;
        localEnumSet = paramEnumSet;
        if (paramEnumSet.contains(a.fOu))
        {
          j = paramString2.indexOf('/', paramInt2);
          paramInt2 = j;
          if (j != -1) {
            break;
          }
          AppMethodBeat.o(93208);
          return false;
        }
      }
      while ((paramString2.charAt(j) != '/') || (!paramEnumSet.contains(a.fOu)))
      {
        j += 1;
        localEnumSet = paramEnumSet;
        if (j < paramString2.length())
        {
          paramEnumSet = localEnumSet;
          if (localEnumSet.contains(a.fOv))
          {
            paramEnumSet = EnumSet.copyOf(localEnumSet);
            paramEnumSet.remove(a.fOv);
          }
          if (a(paramString1, paramInt1, paramString2, j, paramEnumSet))
          {
            AppMethodBeat.o(93208);
            return true;
          }
        }
      }
      AppMethodBeat.o(93208);
      return false;
      if (paramInt2 >= paramString2.length())
      {
        AppMethodBeat.o(93208);
        return false;
      }
      if ((paramString2.charAt(paramInt2) == '/') && (paramEnumSet.contains(a.fOu)))
      {
        AppMethodBeat.o(93208);
        return false;
      }
      if (a(paramString2, paramInt2, paramEnumSet))
      {
        AppMethodBeat.o(93208);
        return false;
      }
      paramInt1 = a(paramString1, j, paramString2.charAt(paramInt2), paramEnumSet);
      if (paramInt1 == -1) {
        break label120;
      }
      if (paramInt1 == 0)
      {
        AppMethodBeat.o(93208);
        return false;
      }
      paramInt2 += 1;
      break;
      if (paramEnumSet.contains(a.fOt)) {
        break label120;
      }
      if (j >= paramString1.length())
      {
        i = 92;
        paramInt1 = j;
        break label123;
      }
      paramInt1 = j + 1;
      i = paramString1.charAt(j);
      break label123;
      if ((i != paramString2.charAt(paramInt2)) && ((!paramEnumSet.contains(a.fOx)) || (Character.toLowerCase(i) != Character.toLowerCase(paramString2.charAt(paramInt2)))))
      {
        AppMethodBeat.o(93208);
        return false;
      }
      paramInt2 += 1;
      break;
      paramInt1 = j;
      j = i;
    }
  }
  
  private static boolean a(String paramString, int paramInt, EnumSet<a> paramEnumSet)
  {
    AppMethodBeat.i(93209);
    if (paramInt > paramString.length() - 1)
    {
      AppMethodBeat.o(93209);
      return false;
    }
    if (((paramInt == 0) || ((paramEnumSet.contains(a.fOu)) && (paramString.charAt(paramInt - 1) == '/'))) && (paramString.charAt(paramInt) == '.') && (paramEnumSet.contains(a.fOv)))
    {
      AppMethodBeat.o(93209);
      return true;
    }
    AppMethodBeat.o(93209);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(93207);
      fOt = new a("NOESCAPE", 0);
      fOu = new a("PATHNAME", 1);
      fOv = new a("PERIOD", 2);
      fOw = new a("LEADING_DIR", 3);
      fOx = new a("CASEFOLD", 4);
      fOy = new a[] { fOt, fOu, fOv, fOw, fOx };
      AppMethodBeat.o(93207);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.g
 * JD-Core Version:    0.7.0.1
 */