package com.tencent.mm.al;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.HashSet;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/modelbiz/MpDataLimiter;", "", "duration", "", "(I)V", "getDuration", "()I", "setDuration", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "clear", "contains", "", "slotId", "plugin-biz_release"})
public final class q
{
  public int duration;
  public final Long[] hyn;
  public final HashSet<String>[] hyo;
  
  private q(int paramInt)
  {
    AppMethodBeat.i(124707);
    this.duration = paramInt;
    int j = r.aCO();
    Object localObject = new Long[j];
    paramInt = 0;
    while (paramInt < j)
    {
      localObject[paramInt] = Long.valueOf(0L);
      paramInt += 1;
    }
    this.hyn = ((Long[])localObject);
    j = r.aCO();
    localObject = new HashSet[j];
    paramInt = i;
    while (paramInt < j)
    {
      localObject[paramInt] = new HashSet();
      paramInt += 1;
    }
    this.hyo = ((HashSet[])localObject);
    AppMethodBeat.o(124707);
  }
  
  public final void Bk(String paramString)
  {
    AppMethodBeat.i(124705);
    k.h(paramString, "key");
    long l = aCN();
    int i = (int)(l % r.aCO());
    if (this.hyn[i].longValue() != l)
    {
      this.hyo[i].clear();
      this.hyn[i] = Long.valueOf(l);
    }
    this.hyo[i].add(paramString);
    AppMethodBeat.o(124705);
  }
  
  public final long aCN()
  {
    AppMethodBeat.i(124706);
    long l = Math.abs(SystemClock.elapsedRealtime() / this.duration);
    AppMethodBeat.o(124706);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.q
 * JD-Core Version:    0.7.0.1
 */