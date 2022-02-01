package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class g
{
  public static HashMap<String, String> jNI;
  public static final a wVA;
  public static final a wVB;
  public static final a wVC;
  public static final a wVD;
  public static final a wVE;
  public static final a wVF;
  public static final a wVG;
  public static final a wVH;
  public static final a wVI;
  public static final a wVJ;
  public static final a wVK;
  public static final a wVL;
  public static b wVM;
  public static HashMap<String, String[]> wVN;
  public static final a wVt;
  public static final a wVu;
  public static final a wVv;
  public static final a wVw;
  public static final a wVx;
  public static final a wVy;
  public static final a wVz;
  
  static
  {
    AppMethodBeat.i(131669);
    wVt = new a(19968, 40869);
    wVu = new a(40870, 40907);
    wVv = new a(13312, 19893);
    wVw = new a(131072, 173782);
    wVx = new a(173824, 177972);
    wVy = new a(177984, 178205);
    wVz = new a(12032, 12245);
    wVA = new a(63744, 64217);
    wVB = new a(194560, 195101);
    wVC = new a(59413, 59503);
    wVD = new a(58368, 58856);
    wVE = new a(58880, 59087);
    wVF = new a(12736, 12771);
    wVG = new a(12272, 12283);
    wVH = new a(12549, 12576);
    wVI = new a(12704, 12730);
    wVJ = new a(65, 90);
    wVK = new a(97, 122);
    wVL = new a(48, 57);
    wVM = new b();
    jNI = new HashMap();
    wVN = new HashMap();
    AppMethodBeat.o(131669);
  }
  
  public static boolean B(char paramChar)
  {
    AppMethodBeat.i(131665);
    if ((wVt.Nm(paramChar)) || (wVu.Nm(paramChar)) || (wVv.Nm(paramChar)) || (wVw.Nm(paramChar)) || (wVx.Nm(paramChar)) || (wVy.Nm(paramChar)))
    {
      AppMethodBeat.o(131665);
      return true;
    }
    AppMethodBeat.o(131665);
    return false;
  }
  
  public static boolean C(char paramChar)
  {
    AppMethodBeat.i(131666);
    if ((wVJ.Nm(paramChar)) || (wVK.Nm(paramChar)))
    {
      AppMethodBeat.o(131666);
      return true;
    }
    AppMethodBeat.o(131666);
    return false;
  }
  
  public static boolean D(char paramChar)
  {
    AppMethodBeat.i(131667);
    boolean bool = wVL.Nm(paramChar);
    AppMethodBeat.o(131667);
    return bool;
  }
  
  public static final String ayw(String paramString)
  {
    AppMethodBeat.i(131668);
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      char c = paramString[i];
      if (B(c))
      {
        String str = (String)jNI.get(String.valueOf(c));
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
    int wVO;
    
    public a(int paramInt1, int paramInt2)
    {
      this.bottom = paramInt1;
      this.wVO = paramInt2;
    }
    
    public final boolean Nm(int paramInt)
    {
      return (paramInt >= this.bottom) && (paramInt <= this.wVO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */