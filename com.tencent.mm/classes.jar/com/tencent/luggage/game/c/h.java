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
  private static String[] ctQ;
  
  static
  {
    AppMethodBeat.i(130532);
    ctP = new h("INST");
    ctR = new h[] { ctP };
    ctQ = new String[] { "summary.native-heap", "summary.graphics" };
    AppMethodBeat.o(130532);
  }
  
  private h() {}
  
  public static a OV()
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
      locala.ctT = (((Debug.MemoryInfo)localObject).getTotalPss() / 1024);
      locala.ctU = (((Debug.MemoryInfo)localObject).nativePss / 1024);
      locala.ctV = (((Debug.MemoryInfo)localObject).dalvikPss / 1024);
      if (Build.VERSION.SDK_INT >= 23)
      {
        locala.ctW = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.graphics")) / 1024);
        locala.ctX = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.system")) / 1024);
        locala.ctY = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.total-swap")) / 1024);
        locala.ctZ = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.java-heap")) / 1024);
        locala.cua = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.private-other")) / 1024);
        locala.cub = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.code")) / 1024);
        locala.cuc = (Util.safeParseInt(((Debug.MemoryInfo)localObject).getMemoryStat("summary.stack")) / 1024);
        StringBuilder localStringBuilder = new StringBuilder(100);
        localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
        Iterator localIterator = ((Map)localObject).keySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((!Util.isNullOrNil(str)) && (com.tencent.mm.compatible.loader.a.contains(ctQ, str)))
            {
              localStringBuilder.append(str).append(":").append(Util.safeParseInt((String)Objects.requireNonNull(((Map)localObject).get(str))) / 1024).append("m ").append(System.getProperty("line.separator"));
              continue;
              localObject = null;
              break;
            }
          }
        }
        locala.cud = localStringBuilder.toString();
      }
    }
    AppMethodBeat.o(130531);
    return locala;
  }
  
  public static final class a
  {
    public int ctT;
    public int ctU;
    public int ctV;
    public int ctW;
    public int ctX;
    public int ctY;
    public int ctZ;
    public int cua;
    public int cub;
    public int cuc;
    public String cud;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.c.h
 * JD-Core Version:    0.7.0.1
 */