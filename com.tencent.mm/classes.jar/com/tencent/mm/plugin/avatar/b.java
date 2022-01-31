package com.tencent.mm.plugin.avatar;

import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends p
  implements com.tencent.mm.kernel.api.bucket.b
{
  private static b hFa;
  
  private b()
  {
    super(o.class);
  }
  
  public static b atf()
  {
    try
    {
      if (hFa == null) {
        hFa = new b();
      }
      b localb = hFa;
      return localb;
    }
    finally {}
  }
  
  public static String atg()
  {
    return g.DP().cachePath + "avatar/";
  }
  
  public final List<String> collectStoragePaths()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "avatar/" });
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.b
 * JD-Core Version:    0.7.0.1
 */