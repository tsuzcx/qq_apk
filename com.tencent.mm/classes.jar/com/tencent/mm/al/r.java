package com.tencent.mm.al;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.HashSet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", "duration", "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"})
public final class r
{
  public int duration;
  private final HashSet<String>[] hTA;
  private final Long[] hTz;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(124707);
    this.duration = paramInt;
    int j = s.aGh();
    Object localObject = new Long[j];
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = Long.valueOf(0L);
      paramInt += 1;
    }
    this.hTz = ((Long[])localObject);
    j = s.aGh();
    localObject = new HashSet[j];
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt] = new HashSet();
      paramInt += 1;
    }
    this.hTA = ((HashSet[])localObject);
    AppMethodBeat.o(124707);
  }
  
  private final long aGg()
  {
    AppMethodBeat.i(124706);
    long l = Math.abs(SystemClock.elapsedRealtime() / this.duration);
    AppMethodBeat.o(124706);
    return l;
  }
  
  public final void EL(String paramString)
  {
    AppMethodBeat.i(124705);
    p.h(paramString, "key");
    long l = aGg();
    int i = (int)(l % s.aGh());
    if (this.hTz[i].longValue() != l)
    {
      this.hTA[i].clear();
      this.hTz[i] = Long.valueOf(l);
    }
    this.hTA[i].add(paramString);
    AppMethodBeat.o(124705);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(188754);
    p.h(paramString, "key");
    HashSet localHashSet = null;
    long l = aGg();
    int i = (int)(l % s.aGh());
    if (l == this.hTz[i].longValue()) {
      localHashSet = this.hTA[i];
    }
    while (localHashSet != null)
    {
      boolean bool = localHashSet.contains(paramString);
      AppMethodBeat.o(188754);
      return bool;
      i = Math.abs(i - 1) % s.aGh();
      if (l == this.hTz[i].longValue()) {
        localHashSet = this.hTA[i];
      }
    }
    AppMethodBeat.o(188754);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.r
 * JD-Core Version:    0.7.0.1
 */