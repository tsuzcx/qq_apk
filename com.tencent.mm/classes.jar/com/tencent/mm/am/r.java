package com.tencent.mm.am;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.HashSet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", "duration", "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"})
public final class r
{
  public int duration;
  private final Long[] hQH;
  private final HashSet<String>[] hQI;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(124707);
    this.duration = paramInt;
    int j = s.aFR();
    Object localObject = new Long[j];
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = Long.valueOf(0L);
      paramInt += 1;
    }
    this.hQH = ((Long[])localObject);
    j = s.aFR();
    localObject = new HashSet[j];
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt] = new HashSet();
      paramInt += 1;
    }
    this.hQI = ((HashSet[])localObject);
    AppMethodBeat.o(124707);
  }
  
  private final long aFQ()
  {
    AppMethodBeat.i(124706);
    long l = Math.abs(SystemClock.elapsedRealtime() / this.duration);
    AppMethodBeat.o(124706);
    return l;
  }
  
  public final void Ej(String paramString)
  {
    AppMethodBeat.i(124705);
    p.h(paramString, "key");
    long l = aFQ();
    int i = (int)(l % s.aFR());
    if (this.hQH[i].longValue() != l)
    {
      this.hQI[i].clear();
      this.hQH[i] = Long.valueOf(l);
    }
    this.hQI[i].add(paramString);
    AppMethodBeat.o(124705);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(207292);
    p.h(paramString, "key");
    HashSet localHashSet = null;
    long l = aFQ();
    int i = (int)(l % s.aFR());
    if (l == this.hQH[i].longValue()) {
      localHashSet = this.hQI[i];
    }
    while (localHashSet != null)
    {
      boolean bool = localHashSet.contains(paramString);
      AppMethodBeat.o(207292);
      return bool;
      i = Math.abs(i - 1) % s.aFR();
      if (l == this.hQH[i].longValue()) {
        localHashSet = this.hQI[i];
      }
    }
    AppMethodBeat.o(207292);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.r
 * JD-Core Version:    0.7.0.1
 */