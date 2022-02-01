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
  private final b dgB;
  private final long[] dgC;
  private final Map<String, d> dgD;
  private final Map<String, c> dgE;
  
  public e(b paramb, Map<String, d> paramMap, Map<String, c> paramMap1)
  {
    AppMethodBeat.i(92862);
    this.dgB = paramb;
    this.dgE = paramMap1;
    this.dgD = Collections.unmodifiableMap(paramMap);
    this.dgC = paramb.TX();
    AppMethodBeat.o(92862);
  }
  
  public final int TD()
  {
    return this.dgC.length;
  }
  
  public final List<a> cA(long paramLong)
  {
    AppMethodBeat.i(92864);
    Object localObject1 = this.dgB;
    Object localObject3 = this.dgD;
    Map localMap = this.dgE;
    Object localObject2 = new TreeMap();
    ((b)localObject1).a(paramLong, false, ((b)localObject1).dgo, (Map)localObject2);
    ((b)localObject1).a((Map)localObject3, (Map)localObject2);
    localObject1 = new ArrayList();
    localObject2 = ((TreeMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      c localc = (c)localMap.get(((Map.Entry)localObject3).getKey());
      ((List)localObject1).add(new a(b.a((SpannableStringBuilder)((Map.Entry)localObject3).getValue()), null, localc.ddx, localc.lineType, localc.ddy, localc.ddz, -2147483648, localc.width));
    }
    AppMethodBeat.o(92864);
    return localObject1;
  }
  
  public final int cz(long paramLong)
  {
    AppMethodBeat.i(92863);
    int i = x.a(this.dgC, paramLong, false, false);
    if (i < this.dgC.length)
    {
      AppMethodBeat.o(92863);
      return i;
    }
    AppMethodBeat.o(92863);
    return -1;
  }
  
  public final long in(int paramInt)
  {
    return this.dgC[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.e
 * JD-Core Version:    0.7.0.1
 */