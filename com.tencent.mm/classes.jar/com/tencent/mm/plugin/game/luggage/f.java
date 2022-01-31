package com.tencent.mm.plugin.game.luggage;

import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.a.b;
import java.util.HashSet;
import java.util.Set;

public final class f
{
  private static a.b kMG;
  private static Set<n> kMH = new HashSet();
  
  public static void a(n paramn)
  {
    kMH.add(paramn);
  }
  
  public static void aFI()
  {
    if (kMG == null) {
      kMG = new f.1();
    }
    a.a(kMG);
  }
  
  public static void aFJ()
  {
    a.b(kMG);
    kMG = null;
    kMH.clear();
  }
  
  public static Set<n> aYG()
  {
    return kMH;
  }
  
  public static void b(n paramn)
  {
    kMH.remove(paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f
 * JD-Core Version:    0.7.0.1
 */