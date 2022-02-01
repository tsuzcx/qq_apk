package com.tencent.mm.ao;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", "duration", "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"})
public final class r
{
  public int duration;
  private final Long[] lFc;
  private final HashSet<String>[] lFd;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(124707);
    this.duration = paramInt;
    int j = s.bjo();
    Object localObject = new Long[j];
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = Long.valueOf(0L);
      paramInt += 1;
    }
    this.lFc = ((Long[])localObject);
    j = s.bjo();
    localObject = new HashSet[j];
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt] = new HashSet();
      paramInt += 1;
    }
    this.lFd = ((HashSet[])localObject);
    AppMethodBeat.o(124707);
  }
  
  private final long bjn()
  {
    AppMethodBeat.i(124706);
    long l = Math.abs(SystemClock.elapsedRealtime() / this.duration);
    AppMethodBeat.o(124706);
    return l;
  }
  
  public final void add(String paramString)
  {
    AppMethodBeat.i(124705);
    p.k(paramString, "key");
    long l = bjn();
    int i = (int)(l % s.bjo());
    if (this.lFc[i].longValue() != l)
    {
      this.lFd[i].clear();
      this.lFc[i] = Long.valueOf(l);
    }
    this.lFd[i].add(paramString);
    AppMethodBeat.o(124705);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(206589);
    p.k(paramString, "key");
    HashSet localHashSet = null;
    long l = bjn();
    int i = (int)(l % s.bjo());
    if (l == this.lFc[i].longValue()) {
      localHashSet = this.lFd[i];
    }
    while (localHashSet != null)
    {
      boolean bool = localHashSet.contains(paramString);
      AppMethodBeat.o(206589);
      return bool;
      i = Math.abs(i - 1) % s.bjo();
      if (l == this.lFc[i].longValue()) {
        localHashSet = this.lFd[i];
      }
    }
    AppMethodBeat.o(206589);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ao.r
 * JD-Core Version:    0.7.0.1
 */