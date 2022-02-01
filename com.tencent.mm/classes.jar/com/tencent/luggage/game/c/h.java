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
  private static String[] cvA;
  
  static
  {
    AppMethodBeat.i(130532);
    cvz = new h("INST");
    cvB = new h[] { cvz };
    cvA = new String[] { "summary.native-heap", "summary.graphics" };
    AppMethodBeat.o(130532);
  }
  
  private h() {}
  
  public static a Md()
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
      locala.cvD = (((Debug.MemoryInfo)localObject).getTotalPss() / 1024);
      locala.cvE = (((Debug.MemoryInfo)localObject).nativePss / 1024);
      locala.cvF = (((Debug.MemoryInfo)localObject).dalvikPss / 1024);
      if (Build.VERSION.SDK_INT >= 23)
      {
        locala.cvG = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.graphics")) / 1024);
        locala.cvH = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.system")) / 1024);
        locala.cvI = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.total-swap")) / 1024);
        locala.cvJ = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.java-heap")) / 1024);
        locala.cvK = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.private-other")) / 1024);
        locala.cvL = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.code")) / 1024);
        locala.cvM = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.stack")) / 1024);
        StringBuilder localStringBuilder = new StringBuilder(100);
        localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
        Iterator localIterator = ((Map)localObject).keySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!Util.isNullOrNil(str)) && (com.tencent.mm.compatible.loader.a.contains(cvA, str)))
            {
              localStringBuilder.append(str).append(":").append(Util.safeParseInt((String)Objects.requireNonNull(((Map)localObject).get(str))) / 1024).append("m ").append(System.getProperty("line.separator"));
              continue;
              localObject = null;
              break;
            }
          }
        }
        locala.cvN = localStringBuilder.toString();
      }
    }
    AppMethodBeat.o(130531);
    return locala;
  }
  
  public static final class a
  {
    public int cvD;
    public int cvE;
    public int cvF;
    public int cvG;
    public int cvH;
    public int cvI;
    public int cvJ;
    public int cvK;
    public int cvL;
    public int cvM;
    public String cvN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.c.h
 * JD-Core Version:    0.7.0.1
 */