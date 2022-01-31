package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;

public final class k
{
  public static final String Sl()
  {
    return g.DP().dKt + "draft/";
  }
  
  public static final String nI(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return Sl() + paramString;
  }
  
  public static final String nJ(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return Sl() + paramString + ".thumb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.k
 * JD-Core Version:    0.7.0.1
 */