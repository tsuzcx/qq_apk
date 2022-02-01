package com.tencent.mm.plugin.finder.report;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils;", "", "()V", "genMemoryInfoStr", "", "memoryInfo", "Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils$MemoryInfo;", "getMemoryInfo", "getMemoryInfoAsync", "", "memoryInfoCallback", "Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils$MemoryInfoCallback;", "MemoryInfo", "MemoryInfoCallback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final u FrJ;
  
  static
  {
    AppMethodBeat.i(331447);
    FrJ = new u();
    AppMethodBeat.o(331447);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(331433);
    h.ahAA.bm(new u..ExternalSyntheticLambda0(paramb));
    AppMethodBeat.o(331433);
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(331437);
    s.u(parama, "memoryInfo");
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(s.X("TotalPss:", Integer.valueOf(parama.FrK))).append(" | ");
    localStringBuilder.append(s.X("DalvikPss:", Integer.valueOf(parama.FrL))).append(" | ");
    localStringBuilder.append(s.X("NativePss:", Integer.valueOf(parama.FrM))).append("\n");
    parama = localStringBuilder.toString();
    s.s(parama, "memoryInfoStr.toString()");
    AppMethodBeat.o(331437);
    return parama;
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(331442);
    a locala = new a();
    Object localObject = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(331442);
      throw paramb;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject != null) && (localObject.length == 1))
    {
      localObject = localObject[0];
      locala.FrK = ((Debug.MemoryInfo)localObject).getTotalPss();
      locala.FrL = ((Debug.MemoryInfo)localObject).dalvikPss;
      locala.FrM = ((Debug.MemoryInfo)localObject).nativePss;
    }
    if (paramb != null) {
      paramb.a(locala);
    }
    AppMethodBeat.o(331442);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils$MemoryInfo;", "", "()V", "dalvikPss", "", "getDalvikPss", "()I", "setDalvikPss", "(I)V", "nativePss", "getNativePss", "setNativePss", "totalPss", "getTotalPss", "setTotalPss", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    int FrK;
    int FrL;
    int FrM;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils$MemoryInfoCallback;", "", "callback", "", "memoryInfo", "Lcom/tencent/mm/plugin/finder/report/FinderPerformanceUtils$MemoryInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(u.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.u
 * JD-Core Version:    0.7.0.1
 */