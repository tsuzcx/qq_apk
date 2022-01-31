package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class g
{
  public static HashMap<String, String> gjV;
  public static final g.a mRA;
  public static final g.a mRB;
  public static final g.a mRC;
  public static final g.a mRD;
  public static final g.a mRE;
  public static final g.a mRF;
  public static final g.a mRG;
  public static final g.a mRH;
  public static final g.a mRI;
  public static final g.a mRJ;
  public static b mRK;
  public static HashMap<String, String[]> mRL;
  public static final g.a mRr;
  public static final g.a mRs;
  public static final g.a mRt;
  public static final g.a mRu;
  public static final g.a mRv;
  public static final g.a mRw;
  public static final g.a mRx;
  public static final g.a mRy;
  public static final g.a mRz;
  
  static
  {
    AppMethodBeat.i(114234);
    mRr = new g.a(19968, 40869);
    mRs = new g.a(40870, 40907);
    mRt = new g.a(13312, 19893);
    mRu = new g.a(131072, 173782);
    mRv = new g.a(173824, 177972);
    mRw = new g.a(177984, 178205);
    mRx = new g.a(12032, 12245);
    mRy = new g.a(63744, 64217);
    mRz = new g.a(194560, 195101);
    mRA = new g.a(59413, 59503);
    mRB = new g.a(58368, 58856);
    mRC = new g.a(58880, 59087);
    mRD = new g.a(12736, 12771);
    mRE = new g.a(12272, 12283);
    mRF = new g.a(12549, 12576);
    mRG = new g.a(12704, 12730);
    mRH = new g.a(65, 90);
    mRI = new g.a(97, 122);
    mRJ = new g.a(48, 57);
    mRK = new b();
    gjV = new HashMap();
    mRL = new HashMap();
    AppMethodBeat.o(114234);
  }
  
  public static final String Pf(String paramString)
  {
    AppMethodBeat.i(114233);
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      char c = paramString[i];
      if (w(c))
      {
        String str = (String)gjV.get(String.valueOf(c));
        if (!bo.isNullOrNil(str)) {
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
    AppMethodBeat.o(114233);
    return paramString;
  }
  
  public static boolean w(char paramChar)
  {
    AppMethodBeat.i(114230);
    if ((mRr.ws(paramChar)) || (mRs.ws(paramChar)) || (mRt.ws(paramChar)) || (mRu.ws(paramChar)) || (mRv.ws(paramChar)) || (mRw.ws(paramChar)))
    {
      AppMethodBeat.o(114230);
      return true;
    }
    AppMethodBeat.o(114230);
    return false;
  }
  
  public static boolean x(char paramChar)
  {
    AppMethodBeat.i(114231);
    if ((mRH.ws(paramChar)) || (mRI.ws(paramChar)))
    {
      AppMethodBeat.o(114231);
      return true;
    }
    AppMethodBeat.o(114231);
    return false;
  }
  
  public static boolean y(char paramChar)
  {
    AppMethodBeat.i(114232);
    boolean bool = mRJ.ws(paramChar);
    AppMethodBeat.o(114232);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */