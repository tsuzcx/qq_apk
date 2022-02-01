package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class g
{
  public static HashMap<String, String> iNU;
  public static final a ttD;
  public static final a ttE;
  public static final a ttF;
  public static final a ttG;
  public static final a ttH;
  public static final a ttI;
  public static final a ttJ;
  public static final a ttK;
  public static final a ttL;
  public static final a ttM;
  public static final a ttN;
  public static final a ttO;
  public static final a ttP;
  public static final a ttQ;
  public static final a ttR;
  public static final a ttS;
  public static final a ttT;
  public static final a ttU;
  public static final a ttV;
  public static b ttW;
  public static HashMap<String, String[]> ttX;
  
  static
  {
    AppMethodBeat.i(131669);
    ttD = new a(19968, 40869);
    ttE = new a(40870, 40907);
    ttF = new a(13312, 19893);
    ttG = new a(131072, 173782);
    ttH = new a(173824, 177972);
    ttI = new a(177984, 178205);
    ttJ = new a(12032, 12245);
    ttK = new a(63744, 64217);
    ttL = new a(194560, 195101);
    ttM = new a(59413, 59503);
    ttN = new a(58368, 58856);
    ttO = new a(58880, 59087);
    ttP = new a(12736, 12771);
    ttQ = new a(12272, 12283);
    ttR = new a(12549, 12576);
    ttS = new a(12704, 12730);
    ttT = new a(65, 90);
    ttU = new a(97, 122);
    ttV = new a(48, 57);
    ttW = new b();
    iNU = new HashMap();
    ttX = new HashMap();
    AppMethodBeat.o(131669);
  }
  
  public static boolean A(char paramChar)
  {
    AppMethodBeat.i(131665);
    if ((ttD.GP(paramChar)) || (ttE.GP(paramChar)) || (ttF.GP(paramChar)) || (ttG.GP(paramChar)) || (ttH.GP(paramChar)) || (ttI.GP(paramChar)))
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
    if ((ttT.GP(paramChar)) || (ttU.GP(paramChar)))
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
    boolean bool = ttV.GP(paramChar);
    AppMethodBeat.o(131667);
    return bool;
  }
  
  public static final String aku(String paramString)
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
        String str = (String)iNU.get(String.valueOf(c));
        if (!bt.isNullOrNil(str)) {
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
    int ttY;
    
    public a(int paramInt1, int paramInt2)
    {
      this.bottom = paramInt1;
      this.ttY = paramInt2;
    }
    
    public final boolean GP(int paramInt)
    {
      return (paramInt >= this.bottom) && (paramInt <= this.ttY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */