package com.tencent.luggage.game.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public enum h
{
  static
  {
    AppMethodBeat.i(130532);
    cjB = new h("INST");
    cjC = new h[] { cjB };
    AppMethodBeat.o(130532);
  }
  
  private h() {}
  
  public static a CE()
  {
    AppMethodBeat.i(130531);
    a locala = new a();
    Object localObject = (ActivityManager)aj.getContext().getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
      if ((localObject == null) || (localObject.length <= 0)) {}
    }
    for (localObject = localObject[0]; localObject == null; localObject = null)
    {
      AppMethodBeat.o(130531);
      return locala;
    }
    locala.cjE = (((Debug.MemoryInfo)localObject).getTotalPss() / 1024);
    locala.cjF = (((Debug.MemoryInfo)localObject).nativePss / 1024);
    locala.cjG = (((Debug.MemoryInfo)localObject).dalvikPss / 1024);
    if (Build.VERSION.SDK_INT >= 23)
    {
      locala.cjH = (bt.aRe(((Debug.MemoryInfo)localObject).getMemoryStat("summary.graphics")) / 1024);
      locala.cjI = (bt.aRe(((Debug.MemoryInfo)localObject).getMemoryStat("summary.system")) / 1024);
      locala.cjJ = (bt.aRe(((Debug.MemoryInfo)localObject).getMemoryStat("summary.total-swap")) / 1024);
      locala.cjK = (bt.aRe(((Debug.MemoryInfo)localObject).getMemoryStat("summary.java-heap")) / 1024);
      locala.cjL = (bt.aRe(((Debug.MemoryInfo)localObject).getMemoryStat("summary.private-other")) / 1024);
      locala.cjM = (bt.aRe(((Debug.MemoryInfo)localObject).getMemoryStat("summary.code")) / 1024);
      locala.cjN = (bt.aRe(((Debug.MemoryInfo)localObject).getMemoryStat("summary.stack")) / 1024);
      StringBuilder localStringBuilder = new StringBuilder(100);
      localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str).append(":").append(bt.aRe((String)Objects.requireNonNull(((Map)localObject).get(str))) / 1024).append("m ").append(System.getProperty("line.separator"));
      }
      locala.cjO = localStringBuilder.toString();
    }
    AppMethodBeat.o(130531);
    return locala;
  }
  
  public static final class a
  {
    public int cjE;
    public int cjF;
    public int cjG;
    public int cjH;
    public int cjI;
    public int cjJ;
    public int cjK;
    public int cjL;
    public int cjM;
    public int cjN;
    public String cjO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.h
 * JD-Core Version:    0.7.0.1
 */