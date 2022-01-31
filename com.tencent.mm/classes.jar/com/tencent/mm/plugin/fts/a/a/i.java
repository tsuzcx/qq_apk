package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.sdk.platformtools.ah;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class i
{
  private static final AtomicInteger kwW = new AtomicInteger(0);
  public String bVk = null;
  public ah handler = null;
  public final int id = kwW.incrementAndGet();
  public int kwX = 0;
  public String kwY = null;
  public String kwZ = null;
  public int[] kxa = null;
  public int[] kxb = null;
  public int kxc = 2147483647;
  public HashSet<String> kxd = new HashSet();
  public Comparator<l> kxe = null;
  public com.tencent.mm.plugin.fts.a.l kxf = null;
  public int scene = -1;
  public String talker = null;
  
  public static i a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, HashSet<String> paramHashSet, Comparator<l> paramComparator, com.tencent.mm.plugin.fts.a.l paraml, ah paramah)
  {
    i locali = new i();
    locali.bVk = paramString;
    locali.kwY = null;
    locali.kxa = paramArrayOfInt1;
    locali.kxb = paramArrayOfInt2;
    locali.kxc = paramInt;
    locali.kxd = paramHashSet;
    locali.kxe = paramComparator;
    locali.kxf = paraml;
    locali.handler = paramah;
    return locali;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (i)paramObject;
    } while (this.id == paramObject.id);
    return false;
  }
  
  public String toString()
  {
    return String.format("{id: %d, query: %s}", new Object[] { Integer.valueOf(this.id), this.bVk });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.i
 * JD-Core Version:    0.7.0.1
 */