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
    ccm = new h("INST");
    ccn = new h[] { ccm };
    AppMethodBeat.o(130532);
  }
  
  private h() {}
  
  public static a BB()
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
    locala.ccp = (((Debug.MemoryInfo)localObject).getTotalPss() / 1024);
    locala.ccq = (((Debug.MemoryInfo)localObject).nativePss / 1024);
    locala.ccr = (((Debug.MemoryInfo)localObject).dalvikPss / 1024);
    if (Build.VERSION.SDK_INT >= 23)
    {
      locala.ccs = (bt.aGh(((Debug.MemoryInfo)localObject).getMemoryStat("summary.graphics")) / 1024);
      locala.cct = (bt.aGh(((Debug.MemoryInfo)localObject).getMemoryStat("summary.system")) / 1024);
      locala.ccu = (bt.aGh(((Debug.MemoryInfo)localObject).getMemoryStat("summary.total-swap")) / 1024);
      locala.ccv = (bt.aGh(((Debug.MemoryInfo)localObject).getMemoryStat("summary.java-heap")) / 1024);
      locala.ccw = (bt.aGh(((Debug.MemoryInfo)localObject).getMemoryStat("summary.private-other")) / 1024);
      locala.ccx = (bt.aGh(((Debug.MemoryInfo)localObject).getMemoryStat("summary.code")) / 1024);
      locala.ccy = (bt.aGh(((Debug.MemoryInfo)localObject).getMemoryStat("summary.stack")) / 1024);
      StringBuilder localStringBuilder = new StringBuilder(100);
      localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str).append(":").append(bt.aGh((String)Objects.requireNonNull(((Map)localObject).get(str))) / 1024).append("m ").append(System.getProperty("line.separator"));
      }
      locala.ccz = localStringBuilder.toString();
    }
    AppMethodBeat.o(130531);
    return locala;
  }
  
  public static final class a
  {
    public int ccp;
    public int ccq;
    public int ccr;
    public int ccs;
    public int cct;
    public int ccu;
    public int ccv;
    public int ccw;
    public int ccx;
    public int ccy;
    public String ccz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.h
 * JD-Core Version:    0.7.0.1
 */