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
  private final b aWK;
  private final long[] aWL;
  private final Map<String, d> aWM;
  private final Map<String, c> aWN;
  
  public e(b paramb, Map<String, d> paramMap, Map<String, c> paramMap1)
  {
    AppMethodBeat.i(95694);
    this.aWK = paramb;
    this.aWN = paramMap1;
    this.aWM = Collections.unmodifiableMap(paramMap);
    this.aWL = paramb.qc();
    AppMethodBeat.o(95694);
  }
  
  public final int ab(long paramLong)
  {
    AppMethodBeat.i(95695);
    int i = x.a(this.aWL, paramLong, false, false);
    if (i < this.aWL.length)
    {
      AppMethodBeat.o(95695);
      return i;
    }
    AppMethodBeat.o(95695);
    return -1;
  }
  
  public final List<a> ac(long paramLong)
  {
    AppMethodBeat.i(95696);
    Object localObject1 = this.aWK;
    Object localObject3 = this.aWM;
    Map localMap = this.aWN;
    Object localObject2 = new TreeMap();
    ((b)localObject1).a(paramLong, false, ((b)localObject1).aWu, (Map)localObject2);
    ((b)localObject1).b((Map)localObject3, (Map)localObject2);
    localObject1 = new ArrayList();
    localObject2 = ((TreeMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      c localc = (c)localMap.get(((Map.Entry)localObject3).getKey());
      ((List)localObject1).add(new a(b.a((SpannableStringBuilder)((Map.Entry)localObject3).getValue()), null, localc.aTD, localc.lineType, localc.aTE, localc.aTF, -2147483648, localc.width));
    }
    AppMethodBeat.o(95696);
    return localObject1;
  }
  
  public final long dT(int paramInt)
  {
    return this.aWL[paramInt];
  }
  
  public final int pH()
  {
    return this.aWL.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.e
 * JD-Core Version:    0.7.0.1
 */