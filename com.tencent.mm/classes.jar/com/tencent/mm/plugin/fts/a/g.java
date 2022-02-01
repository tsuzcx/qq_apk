package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class g
{
  public static HashMap<String, String> hUN;
  public static final a roA;
  public static final a roB;
  public static b roC;
  public static HashMap<String, String[]> roD;
  public static final a roi;
  public static final a roj;
  public static final a rok;
  public static final a rol;
  public static final a rom;
  public static final a ron;
  public static final a roo;
  public static final a rop;
  public static final a roq;
  public static final a ror;
  public static final a ros;
  public static final a rot;
  public static final a rou;
  public static final a rov;
  public static final a rox;
  public static final a roy;
  public static final a roz;
  
  static
  {
    AppMethodBeat.i(131669);
    roi = new a(19968, 40869);
    roj = new a(40870, 40907);
    rok = new a(13312, 19893);
    rol = new a(131072, 173782);
    rom = new a(173824, 177972);
    ron = new a(177984, 178205);
    roo = new a(12032, 12245);
    rop = new a(63744, 64217);
    roq = new a(194560, 195101);
    ror = new a(59413, 59503);
    ros = new a(58368, 58856);
    rot = new a(58880, 59087);
    rou = new a(12736, 12771);
    rov = new a(12272, 12283);
    rox = new a(12549, 12576);
    roy = new a(12704, 12730);
    roz = new a(65, 90);
    roA = new a(97, 122);
    roB = new a(48, 57);
    roC = new b();
    hUN = new HashMap();
    roD = new HashMap();
    AppMethodBeat.o(131669);
  }
  
  public static boolean A(char paramChar)
  {
    AppMethodBeat.i(131665);
    if ((roi.DE(paramChar)) || (roj.DE(paramChar)) || (rok.DE(paramChar)) || (rol.DE(paramChar)) || (rom.DE(paramChar)) || (ron.DE(paramChar)))
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
    if ((roz.DE(paramChar)) || (roA.DE(paramChar)))
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
    boolean bool = roB.DE(paramChar);
    AppMethodBeat.o(131667);
    return bool;
  }
  
  public static final String abe(String paramString)
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
        String str = (String)hUN.get(String.valueOf(c));
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
    int roE;
    
    public a(int paramInt1, int paramInt2)
    {
      this.bottom = paramInt1;
      this.roE = paramInt2;
    }
    
    public final boolean DE(int paramInt)
    {
      return (paramInt >= this.bottom) && (paramInt <= this.roE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */