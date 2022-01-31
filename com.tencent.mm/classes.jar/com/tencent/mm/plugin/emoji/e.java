package com.tencent.mm.plugin.emoji;

import com.tencent.mm.ar.a;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends p
  implements b
{
  private static e iUl;
  
  private e()
  {
    super(a.class);
  }
  
  public static String aGA()
  {
    return g.DP().dKt + "emoji/";
  }
  
  public static e aGz()
  {
    try
    {
      if (iUl == null) {
        iUl = new e();
      }
      e locale = iUl;
      return locale;
    }
    finally {}
  }
  
  public final List<String> collectStoragePaths()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "emoji/" });
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e
 * JD-Core Version:    0.7.0.1
 */