package com.tencent.luggage.game.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
    cjD = new h("INST");
    cjE = new h[] { cjD };
    AppMethodBeat.o(130532);
  }
  
  private h() {}
  
  public static a CH()
  {
    AppMethodBeat.i(130531);
    a locala = new a();
    Object localObject = (ActivityManager)ak.getContext().getSystemService("activity");
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
    locala.cjG = (((Debug.MemoryInfo)localObject).getTotalPss() / 1024);
    locala.cjH = (((Debug.MemoryInfo)localObject).nativePss / 1024);
    locala.cjI = (((Debug.MemoryInfo)localObject).dalvikPss / 1024);
    if (Build.VERSION.SDK_INT >= 23)
    {
      locala.cjJ = (bu.aSB(((Debug.MemoryInfo)localObject).getMemoryStat("summary.graphics")) / 1024);
      locala.cjK = (bu.aSB(((Debug.MemoryInfo)localObject).getMemoryStat("summary.system")) / 1024);
      locala.cjL = (bu.aSB(((Debug.MemoryInfo)localObject).getMemoryStat("summary.total-swap")) / 1024);
      locala.cjM = (bu.aSB(((Debug.MemoryInfo)localObject).getMemoryStat("summary.java-heap")) / 1024);
      locala.cjN = (bu.aSB(((Debug.MemoryInfo)localObject).getMemoryStat("summary.private-other")) / 1024);
      locala.cjO = (bu.aSB(((Debug.MemoryInfo)localObject).getMemoryStat("summary.code")) / 1024);
      locala.cjP = (bu.aSB(((Debug.MemoryInfo)localObject).getMemoryStat("summary.stack")) / 1024);
      StringBuilder localStringBuilder = new StringBuilder(100);
      localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str).append(":").append(bu.aSB((String)Objects.requireNonNull(((Map)localObject).get(str))) / 1024).append("m ").append(System.getProperty("line.separator"));
      }
      locala.cjQ = localStringBuilder.toString();
    }
    AppMethodBeat.o(130531);
    return locala;
  }
  
  public static final class a
  {
    public int cjG;
    public int cjH;
    public int cjI;
    public int cjJ;
    public int cjK;
    public int cjL;
    public int cjM;
    public int cjN;
    public int cjO;
    public int cjP;
    public String cjQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.c.h
 * JD-Core Version:    0.7.0.1
 */