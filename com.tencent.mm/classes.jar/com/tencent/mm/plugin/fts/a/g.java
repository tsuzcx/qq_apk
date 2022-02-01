package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class g
{
  public static final a HrU;
  public static final a HrV;
  public static final a HrW;
  public static final a HrX;
  public static final a HrY;
  public static final a HrZ;
  public static final a Hsa;
  public static final a Hsb;
  public static final a Hsc;
  public static final a Hsd;
  public static final a Hse;
  public static final a Hsf;
  public static final a Hsg;
  public static final a Hsh;
  public static final a Hsi;
  public static final a Hsj;
  public static final a Hsk;
  public static final a Hsl;
  public static final a Hsm;
  public static b Hsn;
  public static HashMap<String, String[]> Hso;
  public static HashMap<String, String> pBs;
  
  static
  {
    AppMethodBeat.i(131669);
    HrU = new a(19968, 40869);
    HrV = new a(40870, 40907);
    HrW = new a(13312, 19893);
    HrX = new a(131072, 173782);
    HrY = new a(173824, 177972);
    HrZ = new a(177984, 178205);
    Hsa = new a(12032, 12245);
    Hsb = new a(63744, 64217);
    Hsc = new a(194560, 195101);
    Hsd = new a(59413, 59503);
    Hse = new a(58368, 58856);
    Hsf = new a(58880, 59087);
    Hsg = new a(12736, 12771);
    Hsh = new a(12272, 12283);
    Hsi = new a(12549, 12576);
    Hsj = new a(12704, 12730);
    Hsk = new a(65, 90);
    Hsl = new a(97, 122);
    Hsm = new a(48, 57);
    Hsn = new b();
    pBs = new HashMap();
    Hso = new HashMap();
    AppMethodBeat.o(131669);
  }
  
  public static boolean C(char paramChar)
  {
    AppMethodBeat.i(131665);
    if ((HrU.Wh(paramChar)) || (HrV.Wh(paramChar)) || (HrW.Wh(paramChar)) || (HrX.Wh(paramChar)) || (HrY.Wh(paramChar)) || (HrZ.Wh(paramChar)))
    {
      AppMethodBeat.o(131665);
      return true;
    }
    AppMethodBeat.o(131665);
    return false;
  }
  
  public static boolean D(char paramChar)
  {
    AppMethodBeat.i(131666);
    if ((Hsk.Wh(paramChar)) || (Hsl.Wh(paramChar)))
    {
      AppMethodBeat.o(131666);
      return true;
    }
    AppMethodBeat.o(131666);
    return false;
  }
  
  public static boolean E(char paramChar)
  {
    AppMethodBeat.i(131667);
    boolean bool = Hsm.Wh(paramChar);
    AppMethodBeat.o(131667);
    return bool;
  }
  
  public static final String aEo(String paramString)
  {
    AppMethodBeat.i(131668);
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      char c = paramString[i];
      if (C(c))
      {
        String str = (String)pBs.get(String.valueOf(c));
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
    
    public final boolean Wh(int paramInt)
    {
      return (paramInt >= this.bottom) && (paramInt <= this.up);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */