package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class g
{
  public static HashMap<String, String> iQO;
  public static final a tEA;
  public static final a tEB;
  public static final a tEC;
  public static final a tED;
  public static final a tEE;
  public static final a tEF;
  public static final a tEG;
  public static final a tEH;
  public static final a tEI;
  public static final a tEJ;
  public static final a tEK;
  public static final a tEL;
  public static final a tEM;
  public static b tEN;
  public static HashMap<String, String[]> tEO;
  public static final a tEu;
  public static final a tEv;
  public static final a tEw;
  public static final a tEx;
  public static final a tEy;
  public static final a tEz;
  
  static
  {
    AppMethodBeat.i(131669);
    tEu = new a(19968, 40869);
    tEv = new a(40870, 40907);
    tEw = new a(13312, 19893);
    tEx = new a(131072, 173782);
    tEy = new a(173824, 177972);
    tEz = new a(177984, 178205);
    tEA = new a(12032, 12245);
    tEB = new a(63744, 64217);
    tEC = new a(194560, 195101);
    tED = new a(59413, 59503);
    tEE = new a(58368, 58856);
    tEF = new a(58880, 59087);
    tEG = new a(12736, 12771);
    tEH = new a(12272, 12283);
    tEI = new a(12549, 12576);
    tEJ = new a(12704, 12730);
    tEK = new a(65, 90);
    tEL = new a(97, 122);
    tEM = new a(48, 57);
    tEN = new b();
    iQO = new HashMap();
    tEO = new HashMap();
    AppMethodBeat.o(131669);
  }
  
  public static boolean A(char paramChar)
  {
    AppMethodBeat.i(131665);
    if ((tEu.Hm(paramChar)) || (tEv.Hm(paramChar)) || (tEw.Hm(paramChar)) || (tEx.Hm(paramChar)) || (tEy.Hm(paramChar)) || (tEz.Hm(paramChar)))
    {
      AppMethodBeat.o(131665);
      return true;
    }
    AppMethodBeat.o(131665);
    return false;
  }
  
  public static boolean B(char paramChar)
  {
    AppMethodBeat.i(131666);
    if ((tEK.Hm(paramChar)) || (tEL.Hm(paramChar)))
    {
      AppMethodBeat.o(131666);
      return true;
    }
    AppMethodBeat.o(131666);
    return false;
  }
  
  public static boolean C(char paramChar)
  {
    AppMethodBeat.i(131667);
    boolean bool = tEM.Hm(paramChar);
    AppMethodBeat.o(131667);
    return bool;
  }
  
  public static final String als(String paramString)
  {
    AppMethodBeat.i(131668);
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      char c = paramString[i];
      if (A(c))
      {
        String str = (String)iQO.get(String.valueOf(c));
        if (!bu.isNullOrNil(str)) {
          localStringBuffer.append(str);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c);
      }
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(131668);
    return paramString;
  }
  
  public static final class a
  {
    int bottom;
    int tEP;
    
    public a(int paramInt1, int paramInt2)
    {
      this.bottom = paramInt1;
      this.tEP = paramInt2;
    }
    
    public final boolean Hm(int paramInt)
    {
      return (paramInt >= this.bottom) && (paramInt <= this.tEP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */