package com.tencent.mm.plugin.k;

import com.tencent.mm.az.r;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends p
  implements b
{
  private static a iNZ;
  
  private a()
  {
    super(r.class);
  }
  
  public static String FN()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    g.DQ();
    return g.DP().dKt + "package/";
  }
  
  public static a aFH()
  {
    try
    {
      if (iNZ == null) {
        iNZ = new a();
      }
      a locala = iNZ;
      return locala;
    }
    finally {}
  }
  
  public final List<String> collectStoragePaths()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "package/" });
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.k.a
 * JD-Core Version:    0.7.0.1
 */