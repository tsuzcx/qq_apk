package com.tencent.mm.cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.util.HashMap;

final class j
  extends g
{
  public static final HashMap<String, Character> agZt;
  
  static
  {
    AppMethodBeat.i(231619);
    HashMap localHashMap = new HashMap(8);
    agZt = localHashMap;
    localHashMap.put("amp", h.agZc);
    agZt.put("apos", h.agZd);
    agZt.put("gt", h.agZg);
    agZt.put("lt", h.agZh);
    agZt.put("quot", h.agZj);
    AppMethodBeat.o(231619);
  }
  
  public j(Reader paramReader)
  {
    super(paramReader);
  }
  
  private Object jQx()
  {
    AppMethodBeat.i(231615);
    Object localObject = new StringBuilder();
    char c;
    for (;;)
    {
      c = next();
      if ((!Character.isLetterOrDigit(c)) && (c != '#')) {
        break;
      }
      ((StringBuilder)localObject).append(Character.toLowerCase(c));
    }
    if (c != ';')
    {
      localObject = bFc("Missing ';' in XML entity: &".concat(String.valueOf(localObject)));
      AppMethodBeat.o(231615);
      throw ((Throwable)localObject);
    }
    localObject = ((StringBuilder)localObject).toString();
    if ((localObject == null) || (((String)localObject).isEmpty()))
    {
      AppMethodBeat.o(231615);
      return "";
    }
    if (((String)localObject).charAt(0) == '#')
    {
      if ((((String)localObject).charAt(1) == 'x') || (((String)localObject).charAt(1) == 'X')) {}
      for (int i = Integer.parseInt(((String)localObject).substring(2), 16);; i = Integer.parseInt(((String)localObject).substring(1)))
      {
        localObject = new String(new int[] { i }, 0, 1);
        AppMethodBeat.o(231615);
        return localObject;
      }
    }
    Character localCharacter = (Character)agZt.get(localObject);
    if (localCharacter == null)
    {
      localObject = "&" + (String)localObject + ';';
      AppMethodBeat.o(231615);
      return localObject;
    }
    localObject = localCharacter.toString();
    AppMethodBeat.o(231615);
    return localObject;
  }
  
  public final void bFe(String paramString)
  {
    AppMethodBeat.i(231638);
    int i1 = paramString.length();
    char[] arrayOfChar = new char[i1];
    int j = 0;
    int i;
    int k;
    for (;;)
    {
      if (j < i1)
      {
        i = next();
        if (i == 0)
        {
          AppMethodBeat.o(231638);
          return;
        }
        arrayOfChar[j] = i;
        j += 1;
        continue;
        arrayOfChar[j] = i;
        k = j + 1;
        j = k;
        if (k < i1) {
          break;
        }
      }
    }
    for (j = k - i1;; j = 0)
    {
      k = j;
      int m = 0;
      label84:
      if (m < i1) {
        if (arrayOfChar[k] == paramString.charAt(m)) {}
      }
      for (k = 0;; k = 1)
      {
        if (k != 0)
        {
          AppMethodBeat.o(231638);
          return;
          int n = k + 1;
          k = n;
          if (n >= i1) {
            k = n - i1;
          }
          m += 1;
          break label84;
        }
        i = next();
        if (i != 0) {
          break;
        }
        AppMethodBeat.o(231638);
        return;
      }
    }
  }
  
  public final Object jQw()
  {
    AppMethodBeat.i(231625);
    char c;
    do
    {
      c = next();
    } while (Character.isWhitespace(c));
    if (c == 0)
    {
      AppMethodBeat.o(231625);
      return null;
    }
    if (c == '<')
    {
      localObject = h.agZh;
      AppMethodBeat.o(231625);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (c == 0)
    {
      localObject = ((StringBuilder)localObject).toString().trim();
      AppMethodBeat.o(231625);
      return localObject;
    }
    if (c == '<')
    {
      cLO();
      localObject = ((StringBuilder)localObject).toString().trim();
      AppMethodBeat.o(231625);
      return localObject;
    }
    if (c == '&') {
      ((StringBuilder)localObject).append(jQx());
    }
    for (;;)
    {
      c = next();
      break;
      ((StringBuilder)localObject).append(c);
    }
  }
  
  public final Object jQy()
  {
    AppMethodBeat.i(231630);
    char c1;
    do
    {
      c1 = next();
    } while (Character.isWhitespace(c1));
    switch (c1)
    {
    }
    for (;;)
    {
      c1 = next();
      if (Character.isWhitespace(c1))
      {
        localObject = Boolean.TRUE;
        AppMethodBeat.o(231630);
        return localObject;
        localObject = bFc("Misshaped meta tag");
        AppMethodBeat.o(231630);
        throw ((Throwable)localObject);
        localObject = h.agZh;
        AppMethodBeat.o(231630);
        return localObject;
        localObject = h.agZg;
        AppMethodBeat.o(231630);
        return localObject;
        localObject = h.agZk;
        AppMethodBeat.o(231630);
        return localObject;
        localObject = h.agZf;
        AppMethodBeat.o(231630);
        return localObject;
        localObject = h.agZe;
        AppMethodBeat.o(231630);
        return localObject;
        localObject = h.agZi;
        AppMethodBeat.o(231630);
        return localObject;
        char c2;
        do
        {
          c2 = next();
          if (c2 == 0)
          {
            localObject = bFc("Unterminated string");
            AppMethodBeat.o(231630);
            throw ((Throwable)localObject);
          }
        } while (c2 != c1);
        localObject = Boolean.TRUE;
        AppMethodBeat.o(231630);
        return localObject;
      }
      switch (c1)
      {
      }
    }
    Object localObject = bFc("Unterminated string");
    AppMethodBeat.o(231630);
    throw ((Throwable)localObject);
    cLO();
    localObject = Boolean.TRUE;
    AppMethodBeat.o(231630);
    return localObject;
  }
  
  public final Object jQz()
  {
    AppMethodBeat.i(231634);
    char c1;
    do
    {
      c1 = next();
    } while (Character.isWhitespace(c1));
    switch (c1)
    {
    default: 
      localObject = new StringBuilder();
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(c1);
      c1 = next();
      if (Character.isWhitespace(c1))
      {
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(231634);
        return localObject;
        localObject = bFc("Misshaped element");
        AppMethodBeat.o(231634);
        throw ((Throwable)localObject);
        localObject = bFc("Misplaced '<'");
        AppMethodBeat.o(231634);
        throw ((Throwable)localObject);
        localObject = h.agZg;
        AppMethodBeat.o(231634);
        return localObject;
        localObject = h.agZk;
        AppMethodBeat.o(231634);
        return localObject;
        localObject = h.agZf;
        AppMethodBeat.o(231634);
        return localObject;
        localObject = h.agZe;
        AppMethodBeat.o(231634);
        return localObject;
        localObject = h.agZi;
        AppMethodBeat.o(231634);
        return localObject;
        localObject = new StringBuilder();
        for (;;)
        {
          char c2 = next();
          if (c2 == 0)
          {
            localObject = bFc("Unterminated string");
            AppMethodBeat.o(231634);
            throw ((Throwable)localObject);
          }
          if (c2 == c1)
          {
            localObject = ((StringBuilder)localObject).toString();
            AppMethodBeat.o(231634);
            return localObject;
          }
          if (c2 == '&') {
            ((StringBuilder)localObject).append(jQx());
          } else {
            ((StringBuilder)localObject).append(c2);
          }
        }
      }
      switch (c1)
      {
      }
    }
    Object localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(231634);
    return localObject;
    cLO();
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(231634);
    return localObject;
    localObject = bFc("Bad character in a name");
    AppMethodBeat.o(231634);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.cs.j
 * JD-Core Version:    0.7.0.1
 */