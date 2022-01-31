package com.tencent.mm.plugin.game.commlib;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static LinkedList<String> kMe = new LinkedList();
  private static final String kMf = ae.getPackageName();
  private static final String kMg = ae.getPackageName() + ":tools";
  
  static
  {
    kMe.add(kMg);
  }
  
  public static void EA(String paramString)
  {
    if ((paramString.equals(kMf)) || (kMe.contains(paramString))) {
      a.aYj();
    }
  }
  
  public static void aYs()
  {
    Iterator localIterator = kMe.iterator();
    while (localIterator.hasNext()) {
      f.a((String)localIterator.next(), null, e.a.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.e
 * JD-Core Version:    0.7.0.1
 */