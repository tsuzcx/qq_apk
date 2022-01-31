package com.tencent.mm.model;

import com.tencent.mm.compatible.util.k;

@Deprecated
public class bu
{
  static
  {
    k.b("txmapengine", bu.class.getClassLoader());
  }
  
  public static ar iR(String paramString)
  {
    paramString = p.gR(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.Gg();
  }
  
  public final boolean a(String paramString, ar paramar)
  {
    try
    {
      p localp2 = p.gR(paramString);
      p localp1 = localp2;
      if (localp2 == null) {
        localp1 = p.a(paramString, new p(paramar.getClass()));
      }
      localp1.a(paramar);
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.bu
 * JD-Core Version:    0.7.0.1
 */