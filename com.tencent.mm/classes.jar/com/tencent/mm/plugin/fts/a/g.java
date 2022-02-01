package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class g
{
  public static final a BHA;
  public static final a BHB;
  public static final a BHC;
  public static final a BHD;
  public static final a BHE;
  public static final a BHF;
  public static final a BHG;
  public static final a BHH;
  public static b BHI;
  public static HashMap<String, String[]> BHJ;
  public static final a BHp;
  public static final a BHq;
  public static final a BHr;
  public static final a BHs;
  public static final a BHt;
  public static final a BHu;
  public static final a BHv;
  public static final a BHw;
  public static final a BHx;
  public static final a BHy;
  public static final a BHz;
  public static HashMap<String, String> mEQ;
  
  static
  {
    AppMethodBeat.i(131669);
    BHp = new a(19968, 40869);
    BHq = new a(40870, 40907);
    BHr = new a(13312, 19893);
    BHs = new a(131072, 173782);
    BHt = new a(173824, 177972);
    BHu = new a(177984, 178205);
    BHv = new a(12032, 12245);
    BHw = new a(63744, 64217);
    BHx = new a(194560, 195101);
    BHy = new a(59413, 59503);
    BHz = new a(58368, 58856);
    BHA = new a(58880, 59087);
    BHB = new a(12736, 12771);
    BHC = new a(12272, 12283);
    BHD = new a(12549, 12576);
    BHE = new a(12704, 12730);
    BHF = new a(65, 90);
    BHG = new a(97, 122);
    BHH = new a(48, 57);
    BHI = new b();
    mEQ = new HashMap();
    BHJ = new HashMap();
    AppMethodBeat.o(131669);
  }
  
  public static boolean J(char paramChar)
  {
    AppMethodBeat.i(131665);
    if ((BHp.SA(paramChar)) || (BHq.SA(paramChar)) || (BHr.SA(paramChar)) || (BHs.SA(paramChar)) || (BHt.SA(paramChar)) || (BHu.SA(paramChar)))
    {
      AppMethodBeat.o(131665);
      return true;
    }
    AppMethodBeat.o(131665);
    return false;
  }
  
  public static boolean K(char paramChar)
  {
    AppMethodBeat.i(131666);
    if ((BHF.SA(paramChar)) || (BHG.SA(paramChar)))
    {
      AppMethodBeat.o(131666);
      return true;
    }
    AppMethodBeat.o(131666);
    return false;
  }
  
  public static boolean L(char paramChar)
  {
    AppMethodBeat.i(131667);
    boolean bool = BHH.SA(paramChar);
    AppMethodBeat.o(131667);
    return bool;
  }
  
  public static final String aHQ(String paramString)
  {
    AppMethodBeat.i(131668);
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      char c = paramString[i];
      if (J(c))
      {
        String str = (String)mEQ.get(String.valueOf(c));
        if (!Util.isNullOrNil(str)) {
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
    int up;
    
    public a(int paramInt1, int paramInt2)
    {
      this.bottom = paramInt1;
      this.up = paramInt2;
    }
    
    public final boolean SA(int paramInt)
    {
      return (paramInt >= this.bottom) && (paramInt <= this.up);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */