package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;

public final class o
{
  static long gmG = 0L;
  
  private static void CR(String paramString)
  {
    AppMethodBeat.i(19905);
    Object localObject = MMApplicationContext.getContext().getSharedPreferences(paramString, 0);
    paramString = MultiProcessMMKV.getSingleMMKV(paramString);
    MultiProcessMMKV.transport2MMKV((SharedPreferences)localObject, paramString);
    localObject = paramString.getString("startup_info", "").split("=");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(19905);
      return;
    }
    a locala = new a();
    if (locala.CT(localObject[(localObject.length - 1)]))
    {
      locala.gmJ = 2;
      localObject[(localObject.length - 1)] = locala.toString();
    }
    localObject = g((String[])localObject);
    Log.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[] { localObject });
    paramString.edit().putString("startup_info", (String)localObject).commit();
    AppMethodBeat.o(19905);
  }
  
  public static void Xe()
  {
    AppMethodBeat.i(19904);
    CR("mm_proc_startup");
    CR("push_proc_startup");
    AppMethodBeat.o(19904);
  }
  
  public static void akW()
  {
    AppMethodBeat.i(19903);
    Object localObject1 = MMApplicationContext.getContext().getSharedPreferences("mm_proc_startup", 0);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("mm_proc_startup");
    MultiProcessMMKV.transport2MMKV((SharedPreferences)localObject1, localMultiProcessMMKV);
    localObject1 = localMultiProcessMMKV.getString("startup_info", "").split("=");
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject2 = new a();
      if (((a)localObject2).CT(localObject1[(localObject1.length - 1)]))
      {
        ((a)localObject2).gmM = Process.myPid();
        localObject1[(localObject1.length - 1)] = ((a)localObject2).toString();
      }
    }
    Object localObject2 = new a();
    ((a)localObject2).gmI = 2;
    ((a)localObject2).gmK = Process.myPid();
    ((a)localObject2).gmL = ((int)Util.nowSecond());
    String str = g((String[])localObject1);
    localObject2 = ((a)localObject2).toString();
    localObject1 = localObject2;
    if (str.length() > 0) {
      localObject1 = str + "=" + (String)localObject2;
    }
    Log.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[] { localObject1 });
    localMultiProcessMMKV.edit().putString("startup_info", (String)localObject1).commit();
    AppMethodBeat.o(19903);
  }
  
  private static String g(String[] paramArrayOfString)
  {
    AppMethodBeat.i(19907);
    String str1 = "";
    int j = 1;
    int k = paramArrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str2 = paramArrayOfString[i];
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        str1 = str1 + str2;
        i += 1;
        break;
        str1 = str1 + "=";
      }
    }
    AppMethodBeat.o(19907);
    return str1;
  }
  
  public static void report()
  {
    AppMethodBeat.i(19906);
    if ((gmG != 0L) && (Util.ticksToNow(gmG) < 3600000L))
    {
      AppMethodBeat.o(19906);
      return;
    }
    int i = ((Integer)bg.aVD().get(37, Integer.valueOf(0))).intValue();
    if (d.KyO != i)
    {
      bg.aVD().set(37, Integer.valueOf(d.KyO));
      new MMHandler(Looper.getMainLooper()).post(new o.1(i));
    }
    gmG = Util.currentTicks();
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19900);
        o.CS("mm_proc_startup");
        o.CS("push_proc_startup");
        AppMethodBeat.o(19900);
      }
    });
    AppMethodBeat.o(19906);
  }
  
  static final class a
  {
    int gmI;
    int gmJ = 1;
    int gmK;
    int gmL;
    int gmM;
    
    public final boolean CT(String paramString)
    {
      AppMethodBeat.i(19901);
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length != 5))
      {
        Log.e("MicroMsg.ProcessReport", "error format");
        AppMethodBeat.o(19901);
        return false;
      }
      try
      {
        this.gmI = Util.getInt(paramString[0], 0);
        this.gmJ = Util.getInt(paramString[1], 0);
        this.gmK = Util.getInt(paramString[2], 0);
        this.gmL = Util.getInt(paramString[3], 0);
        this.gmM = Util.getInt(paramString[4], 0);
        AppMethodBeat.o(19901);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
        Log.printErrStackTrace("MicroMsg.ProcessReport", paramString, "", new Object[0]);
        AppMethodBeat.o(19901);
      }
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(19902);
      String str = String.format("%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.gmI), Integer.valueOf(this.gmJ), Integer.valueOf(this.gmK), Integer.valueOf(this.gmL), Integer.valueOf(this.gmM) });
      AppMethodBeat.o(19902);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.o
 * JD-Core Version:    0.7.0.1
 */