package com.tencent.mm.am;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.HashSet;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", "duration", "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"})
public final class q
{
  public int duration;
  public final Long[] gXO;
  public final HashSet<String>[] gXP;
  
  private q(int paramInt)
  {
    AppMethodBeat.i(124707);
    this.duration = paramInt;
    int j = r.avW();
    Object localObject = new Long[j];
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = Long.valueOf(0L);
      paramInt += 1;
    }
    this.gXO = ((Long[])localObject);
    j = r.avW();
    localObject = new HashSet[j];
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt] = new HashSet();
      paramInt += 1;
    }
    this.gXP = ((HashSet[])localObject);
    AppMethodBeat.o(124707);
  }
  
  public final long avV()
  {
    AppMethodBeat.i(124706);
    long l = Math.abs(SystemClock.elapsedRealtime() / this.duration);
    AppMethodBeat.o(124706);
    return l;
  }
  
  public final void xe(String paramString)
  {
    AppMethodBeat.i(124705);
    k.h(paramString, "key");
    long l = avV();
    int i = (int)(l % r.avW());
    if (this.gXO[i].longValue() != l)
    {
      this.gXP[i].clear();
      this.gXO[i] = Long.valueOf(l);
    }
    this.gXP[i].add(paramString);
    AppMethodBeat.o(124705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.q
 * JD-Core Version:    0.7.0.1
 */