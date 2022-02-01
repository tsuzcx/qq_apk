package com.google.android.exoplayer2.f.e;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private final b bDf;
  private final long[] bDg;
  private final Map<String, d> bDh;
  private final Map<String, c> bDi;
  
  public e(b paramb, Map<String, d> paramMap, Map<String, c> paramMap1)
  {
    AppMethodBeat.i(92862);
    this.bDf = paramb;
    this.bDi = paramMap1;
    this.bDh = Collections.unmodifiableMap(paramMap);
    this.bDg = paramb.wu();
    AppMethodBeat.o(92862);
  }
  
  public final int ai(long paramLong)
  {
    AppMethodBeat.i(92863);
    int i = x.a(this.bDg, paramLong, false, false);
    if (i < this.bDg.length)
    {
      AppMethodBeat.o(92863);
      return i;
    }
    AppMethodBeat.o(92863);
    return -1;
  }
  
  public final List<a> aj(long paramLong)
  {
    AppMethodBeat.i(92864);
    Object localObject1 = this.bDf;
    Object localObject3 = this.bDh;
    Map localMap = this.bDi;
    Object localObject2 = new TreeMap();
    ((b)localObject1).a(paramLong, false, ((b)localObject1).bCR, (Map)localObject2);
    ((b)localObject1).a((Map)localObject3, (Map)localObject2);
    localObject1 = new ArrayList();
    localObject2 = ((TreeMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      c localc = (c)localMap.get(((Map.Entry)localObject3).getKey());
      ((List)localObject1).add(new a(b.a((SpannableStringBuilder)((Map.Entry)localObject3).getValue()), null, localc.bAc, localc.lineType, localc.bAd, localc.bAe, -2147483648, localc.width));
    }
    AppMethodBeat.o(92864);
    return localObject1;
  }
  
  public final long eH(int paramInt)
  {
    return this.bDg[paramInt];
  }
  
  public final int wa()
  {
    return this.bDg.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.e
 * JD-Core Version:    0.7.0.1
 */