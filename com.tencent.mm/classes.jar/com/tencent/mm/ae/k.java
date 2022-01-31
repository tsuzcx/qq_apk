package com.tencent.mm.ae;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public final class k
{
  public int dTA;
  public int dTz;
  
  public static final k gv(String paramString)
  {
    k localk = new k();
    paramString = g.a.M(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.dTl;
      if (paramString != null)
      {
        localk.dTz = bk.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localk.dTA = bk.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ae.k
 * JD-Core Version:    0.7.0.1
 */