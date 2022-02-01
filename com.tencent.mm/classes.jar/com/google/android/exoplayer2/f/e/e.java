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
  private final b buN;
  private final long[] buO;
  private final Map<String, d> buP;
  private final Map<String, c> buQ;
  
  public e(b paramb, Map<String, d> paramMap, Map<String, c> paramMap1)
  {
    AppMethodBeat.i(92862);
    this.buN = paramb;
    this.buQ = paramMap1;
    this.buP = Collections.unmodifiableMap(paramMap);
    this.buO = paramb.uW();
    AppMethodBeat.o(92862);
  }
  
  public final int am(long paramLong)
  {
    AppMethodBeat.i(92863);
    int i = x.a(this.buO, paramLong, false, false);
    if (i < this.buO.length)
    {
      AppMethodBeat.o(92863);
      return i;
    }
    AppMethodBeat.o(92863);
    return -1;
  }
  
  public final List<a> an(long paramLong)
  {
    AppMethodBeat.i(92864);
    Object localObject1 = this.buN;
    Object localObject3 = this.buP;
    Map localMap = this.buQ;
    Object localObject2 = new TreeMap();
    ((b)localObject1).a(paramLong, false, ((b)localObject1).bux, (Map)localObject2);
    ((b)localObject1).a((Map)localObject3, (Map)localObject2);
    localObject1 = new ArrayList();
    localObject2 = ((TreeMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      c localc = (c)localMap.get(((Map.Entry)localObject3).getKey());
      ((List)localObject1).add(new a(b.a((SpannableStringBuilder)((Map.Entry)localObject3).getValue()), null, localc.brG, localc.lineType, localc.brH, localc.brI, -2147483648, localc.width));
    }
    AppMethodBeat.o(92864);
    return localObject1;
  }
  
  public final long eR(int paramInt)
  {
    return this.buO[paramInt];
  }
  
  public final int uB()
  {
    return this.buO.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.e
 * JD-Core Version:    0.7.0.1
 */