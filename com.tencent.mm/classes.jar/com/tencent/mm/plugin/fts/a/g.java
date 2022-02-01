package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class g
{
  public static HashMap<String, String> iuR;
  public static final a sxc;
  public static final a sxd;
  public static final a sxe;
  public static final a sxf;
  public static final a sxg;
  public static final a sxh;
  public static final a sxi;
  public static final a sxj;
  public static final a sxk;
  public static final a sxl;
  public static final a sxm;
  public static final a sxn;
  public static final a sxo;
  public static final a sxp;
  public static final a sxq;
  public static final a sxr;
  public static final a sxs;
  public static final a sxt;
  public static final a sxu;
  public static b sxv;
  public static HashMap<String, String[]> sxw;
  
  static
  {
    AppMethodBeat.i(131669);
    sxc = new a(19968, 40869);
    sxd = new a(40870, 40907);
    sxe = new a(13312, 19893);
    sxf = new a(131072, 173782);
    sxg = new a(173824, 177972);
    sxh = new a(177984, 178205);
    sxi = new a(12032, 12245);
    sxj = new a(63744, 64217);
    sxk = new a(194560, 195101);
    sxl = new a(59413, 59503);
    sxm = new a(58368, 58856);
    sxn = new a(58880, 59087);
    sxo = new a(12736, 12771);
    sxp = new a(12272, 12283);
    sxq = new a(12549, 12576);
    sxr = new a(12704, 12730);
    sxs = new a(65, 90);
    sxt = new a(97, 122);
    sxu = new a(48, 57);
    sxv = new b();
    iuR = new HashMap();
    sxw = new HashMap();
    AppMethodBeat.o(131669);
  }
  
  public static boolean A(char paramChar)
  {
    AppMethodBeat.i(131667);
    boolean bool = sxu.FA(paramChar);
    AppMethodBeat.o(131667);
    return bool;
  }
  
  public static final String afW(String paramString)
  {
    AppMethodBeat.i(131668);
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      char c = paramString[i];
      if (y(c))
      {
        String str = (String)iuR.get(String.valueOf(c));
        if (!bs.isNullOrNil(str)) {
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
  
  public static boolean y(char paramChar)
  {
    AppMethodBeat.i(131665);
    if ((sxc.FA(paramChar)) || (sxd.FA(paramChar)) || (sxe.FA(paramChar)) || (sxf.FA(paramChar)) || (sxg.FA(paramChar)) || (sxh.FA(paramChar)))
    {
      AppMethodBeat.o(131665);
      return true;
    }
    AppMethodBeat.o(131665);
    return false;
  }
  
  public static boolean z(char paramChar)
  {
    AppMethodBeat.i(131666);
    if ((sxs.FA(paramChar)) || (sxt.FA(paramChar)))
    {
      AppMethodBeat.o(131666);
      return true;
    }
    AppMethodBeat.o(131666);
    return false;
  }
  
  public static final class a
  {
    int bottom;
    int sxx;
    
    public a(int paramInt1, int paramInt2)
    {
      this.bottom = paramInt1;
      this.sxx = paramInt2;
    }
    
    public final boolean FA(int paramInt)
    {
      return (paramInt >= this.bottom) && (paramInt <= this.sxx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */