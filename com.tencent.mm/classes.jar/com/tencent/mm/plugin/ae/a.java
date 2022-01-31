package com.tencent.mm.plugin.ae;

import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a
  implements b, c
{
  private static a nuI;
  
  public static a bvQ()
  {
    try
    {
      if (nuI == null) {
        nuI = new a();
      }
      a locala = nuI;
      return locala;
    }
    finally {}
  }
  
  public static String bvR()
  {
    return g.DP().dKt + "remark/";
  }
  
  public final List<String> collectStoragePaths()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ae.a
 * JD-Core Version:    0.7.0.1
 */