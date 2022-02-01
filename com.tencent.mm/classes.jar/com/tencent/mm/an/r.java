package com.tencent.mm.an;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", "duration", "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public int duration;
  private final Long[] owI;
  private final HashSet<String>[] owJ;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(124707);
    this.duration = paramInt;
    int j = s.bGY();
    Object localObject = new Long[j];
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = Long.valueOf(0L);
      paramInt += 1;
    }
    this.owI = ((Long[])localObject);
    j = s.bGY();
    localObject = new HashSet[j];
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt] = new HashSet();
      paramInt += 1;
    }
    this.owJ = ((HashSet[])localObject);
    AppMethodBeat.o(124707);
  }
  
  private final long bGX()
  {
    AppMethodBeat.i(124706);
    long l = Math.abs(SystemClock.elapsedRealtime() / this.duration);
    AppMethodBeat.o(124706);
    return l;
  }
  
  public final void add(String paramString)
  {
    AppMethodBeat.i(124705);
    kotlin.g.b.s.u(paramString, "key");
    long l = bGX();
    int i = (int)(l % s.bGY());
    if (this.owI[i].longValue() != l)
    {
      this.owJ[i].clear();
      this.owI[i] = Long.valueOf(l);
    }
    this.owJ[i].add(paramString);
    AppMethodBeat.o(124705);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(239463);
    kotlin.g.b.s.u(paramString, "key");
    HashSet localHashSet = null;
    long l = bGX();
    int i = (int)(l % s.bGY());
    if (l == this.owI[i].longValue()) {
      localHashSet = this.owJ[i];
    }
    while (localHashSet == null)
    {
      AppMethodBeat.o(239463);
      return false;
      i = Math.abs(i - 1) % s.bGY();
      if (l == this.owI[i].longValue()) {
        localHashSet = this.owJ[i];
      }
    }
    boolean bool = localHashSet.contains(paramString);
    AppMethodBeat.o(239463);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.r
 * JD-Core Version:    0.7.0.1
 */