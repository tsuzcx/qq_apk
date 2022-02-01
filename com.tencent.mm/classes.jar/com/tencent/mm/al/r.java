package com.tencent.mm.al;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", "duration", "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"})
public final class r
{
  public int duration;
  private final Long[] iOM;
  private final HashSet<String>[] iON;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(124707);
    this.duration = paramInt;
    int j = s.aZZ();
    Object localObject = new Long[j];
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = Long.valueOf(0L);
      paramInt += 1;
    }
    this.iOM = ((Long[])localObject);
    j = s.aZZ();
    localObject = new HashSet[j];
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt] = new HashSet();
      paramInt += 1;
    }
    this.iON = ((HashSet[])localObject);
    AppMethodBeat.o(124707);
  }
  
  private final long aZY()
  {
    AppMethodBeat.i(124706);
    long l = Math.abs(SystemClock.elapsedRealtime() / this.duration);
    AppMethodBeat.o(124706);
    return l;
  }
  
  public final void add(String paramString)
  {
    AppMethodBeat.i(124705);
    p.h(paramString, "key");
    long l = aZY();
    int i = (int)(l % s.aZZ());
    if (this.iOM[i].longValue() != l)
    {
      this.iON[i].clear();
      this.iOM[i] = Long.valueOf(l);
    }
    this.iON[i].add(paramString);
    AppMethodBeat.o(124705);
  }
  
  public final boolean contains(String paramString)
  {
    AppMethodBeat.i(212433);
    p.h(paramString, "key");
    HashSet localHashSet = null;
    long l = aZY();
    int i = (int)(l % s.aZZ());
    if (l == this.iOM[i].longValue()) {
      localHashSet = this.iON[i];
    }
    while (localHashSet != null)
    {
      boolean bool = localHashSet.contains(paramString);
      AppMethodBeat.o(212433);
      return bool;
      i = Math.abs(i - 1) % s.aZZ();
      if (l == this.iOM[i].longValue()) {
        localHashSet = this.iON[i];
      }
    }
    AppMethodBeat.o(212433);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.r
 * JD-Core Version:    0.7.0.1
 */