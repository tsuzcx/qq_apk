package com.tencent.luggage.game.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public enum h
{
  private static String[] elK;
  
  static
  {
    AppMethodBeat.i(130532);
    elJ = new h("INST");
    elL = new h[] { elJ };
    elK = new String[] { "summary.native-heap", "summary.graphics" };
    AppMethodBeat.o(130532);
  }
  
  private h() {}
  
  public static a apd()
  {
    AppMethodBeat.i(130531);
    int i = Process.myPid();
    a locala = new a();
    Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { i });
      if ((localObject != null) && (localObject.length > 0)) {
        localObject = localObject[0];
      }
    }
    while (localObject != null)
    {
      locala.elN = (((Debug.MemoryInfo)localObject).getTotalPss() / 1024);
      locala.elO = (((Debug.MemoryInfo)localObject).nativePss / 1024);
      locala.elP = (((Debug.MemoryInfo)localObject).dalvikPss / 1024);
      if (Build.VERSION.SDK_INT >= 23)
      {
        locala.elQ = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.graphics")) / 1024);
        locala.elR = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.system")) / 1024);
        locala.elS = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.total-swap")) / 1024);
        locala.elT = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.java-heap")) / 1024);
        locala.elU = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.private-other")) / 1024);
        locala.elV = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.code")) / 1024);
        locala.elW = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.stack")) / 1024);
        StringBuilder localStringBuilder = new StringBuilder(100);
        localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
        Iterator localIterator = ((Map)localObject).keySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!Util.isNullOrNil(str)) && (com.tencent.mm.compatible.loader.a.contains(elK, str)))
            {
              localStringBuilder.append(str).append(":").append(Util.safeParseInt((String)Objects.requireNonNull((String)((Map)localObject).get(str))) / 1024).append("m ").append(System.getProperty("line.separator"));
              continue;
              localObject = null;
              break;
            }
          }
        }
        locala.elX = localStringBuilder.toString();
      }
    }
    AppMethodBeat.o(130531);
    return locala;
  }
  
  public static final class a
  {
    public int elN;
    public int elO;
    public int elP;
    public int elQ;
    public int elR;
    public int elS;
    public int elT;
    public int elU;
    public int elV;
    public int elW;
    public String elX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.c.h
 * JD-Core Version:    0.7.0.1
 */