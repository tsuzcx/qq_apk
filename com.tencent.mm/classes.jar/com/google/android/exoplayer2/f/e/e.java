package com.google.android.exoplayer2.f.e;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

final class e
  implements com.google.android.exoplayer2.f.d
{
  private final b aPq;
  private final long[] aPr;
  private final Map<String, d> aPs;
  private final Map<String, c> aPt;
  
  public e(b paramb, Map<String, d> paramMap, Map<String, c> paramMap1)
  {
    this.aPq = paramb;
    this.aPt = paramMap1;
    this.aPs = Collections.unmodifiableMap(paramMap);
    this.aPr = paramb.nE();
  }
  
  public final int S(long paramLong)
  {
    int i = t.a(this.aPr, paramLong);
    if (i < this.aPr.length) {
      return i;
    }
    return -1;
  }
  
  public final List<a> T(long paramLong)
  {
    Object localObject1 = this.aPq;
    Object localObject3 = this.aPs;
    Map localMap = this.aPt;
    Object localObject2 = new TreeMap();
    ((b)localObject1).a(paramLong, false, ((b)localObject1).aPb, (Map)localObject2);
    ((b)localObject1).b((Map)localObject3, (Map)localObject2);
    localObject1 = new ArrayList();
    localObject2 = ((TreeMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      c localc = (c)localMap.get(((Map.Entry)localObject3).getKey());
      ((List)localObject1).add(new a(b.a((SpannableStringBuilder)((Map.Entry)localObject3).getValue()), null, localc.aMj, localc.lineType, localc.aMk, localc.aMl, -2147483648, localc.width));
    }
    return localObject1;
  }
  
  public final long dn(int paramInt)
  {
    return this.aPr[paramInt];
  }
  
  public final int nk()
  {
    return this.aPr.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.e
 * JD-Core Version:    0.7.0.1
 */