package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

public final class g
{
  public static HashMap<String, String> eSa = new HashMap();
  public static final g.a kvD = new g.a(19968, 40869);
  public static final g.a kvE = new g.a(40870, 40907);
  public static final g.a kvF = new g.a(13312, 19893);
  public static final g.a kvG = new g.a(131072, 173782);
  public static final g.a kvH = new g.a(173824, 177972);
  public static final g.a kvI = new g.a(177984, 178205);
  public static final g.a kvJ = new g.a(12032, 12245);
  public static final g.a kvK = new g.a(63744, 64217);
  public static final g.a kvL = new g.a(194560, 195101);
  public static final g.a kvM = new g.a(59413, 59503);
  public static final g.a kvN = new g.a(58368, 58856);
  public static final g.a kvO = new g.a(58880, 59087);
  public static final g.a kvP = new g.a(12736, 12771);
  public static final g.a kvQ = new g.a(12272, 12283);
  public static final g.a kvR = new g.a(12549, 12576);
  public static final g.a kvS = new g.a(12704, 12730);
  public static final g.a kvT = new g.a(65, 90);
  public static final g.a kvU = new g.a(97, 122);
  public static final g.a kvV = new g.a(48, 57);
  public static b kvW = new b();
  public static HashMap<String, String[]> kvX = new HashMap();
  
  public static final String DV(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      char c = paramString[i];
      if (g(c))
      {
        String str = (String)eSa.get(String.valueOf(c));
        if (!bk.bl(str)) {
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
    return localStringBuffer.toString();
  }
  
  public static boolean g(char paramChar)
  {
    return (kvD.j(paramChar)) || (kvE.j(paramChar)) || (kvF.j(paramChar)) || (kvG.j(paramChar)) || (kvH.j(paramChar)) || (kvI.j(paramChar));
  }
  
  public static boolean h(char paramChar)
  {
    return (kvT.j(paramChar)) || (kvU.j(paramChar));
  }
  
  public static boolean i(char paramChar)
  {
    return kvV.j(paramChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.g
 * JD-Core Version:    0.7.0.1
 */