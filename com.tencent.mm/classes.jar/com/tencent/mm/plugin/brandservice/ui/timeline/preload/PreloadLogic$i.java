package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadLimiter;", "", "()V", "sets", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "[Ljava/util/HashSet;", "slots", "", "[Ljava/lang/Long;", "add", "", "key", "contians", "", "slotId", "plugin-brandservice_release"})
public final class PreloadLogic$i
{
  private final Long[] kbK;
  private final HashSet<String>[] kbL;
  
  public PreloadLogic$i()
  {
    AppMethodBeat.i(152683);
    Object localObject = new Long[3];
    int i = 0;
    while (i < 3)
    {
      localObject[i] = Long.valueOf(0L);
      i += 1;
    }
    this.kbK = ((Long[])localObject);
    localObject = new HashSet[3];
    i = j;
    while (i < 3)
    {
      localObject[i] = new HashSet();
      i += 1;
    }
    this.kbL = ((HashSet[])localObject);
    AppMethodBeat.o(152683);
  }
  
  private static long aXL()
  {
    AppMethodBeat.i(152682);
    long l = Math.abs(System.currentTimeMillis() / 300000L);
    AppMethodBeat.o(152682);
    return l;
  }
  
  public final boolean GY(String paramString)
  {
    AppMethodBeat.i(152680);
    j.q(paramString, "key");
    HashSet localHashSet = null;
    long l = aXL();
    int i = (int)(l % 3L);
    if (l == this.kbK[i].longValue()) {
      localHashSet = this.kbL[i];
    }
    while (localHashSet != null)
    {
      boolean bool = localHashSet.contains(paramString);
      AppMethodBeat.o(152680);
      return bool;
      i = Math.abs(i - 1) % 3;
      if (l == this.kbK[i].longValue()) {
        localHashSet = this.kbL[i];
      }
    }
    AppMethodBeat.o(152680);
    return false;
  }
  
  public final void xB(String paramString)
  {
    AppMethodBeat.i(152681);
    j.q(paramString, "key");
    long l = aXL();
    int i = (int)(l % 3L);
    if (this.kbK[i].longValue() != l)
    {
      this.kbL[i].clear();
      this.kbK[i] = Long.valueOf(l);
    }
    this.kbL[i].add(paramString);
    AppMethodBeat.o(152681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.i
 * JD-Core Version:    0.7.0.1
 */