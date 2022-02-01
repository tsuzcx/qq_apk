package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;

public final class o
{
  static long fjP = 0L;
  
  public static void Lr()
  {
    AppMethodBeat.i(19904);
    oo("mm_proc_startup");
    oo("push_proc_startup");
    AppMethodBeat.o(19904);
  }
  
  public static void TQ()
  {
    AppMethodBeat.i(19903);
    Object localObject1 = aj.getContext().getSharedPreferences("mm_proc_startup", 0);
    ax localax = ax.aFD("mm_proc_startup");
    ax.a((SharedPreferences)localObject1, localax);
    localObject1 = localax.getString("startup_info", "").split("=");
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject2 = new a();
      if (((a)localObject2).oq(localObject1[(localObject1.length - 1)]))
      {
        ((a)localObject2).fjV = Process.myPid();
        localObject1[(localObject1.length - 1)] = ((a)localObject2).toString();
      }
    }
    Object localObject2 = new a();
    ((a)localObject2).fjR = 2;
    ((a)localObject2).fjT = Process.myPid();
    ((a)localObject2).fjU = ((int)bt.aGK());
    String str = g((String[])localObject1);
    localObject2 = ((a)localObject2).toString();
    localObject1 = localObject2;
    if (str.length() > 0) {
      localObject1 = str + "=" + (String)localObject2;
    }
    ad.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[] { localObject1 });
    localax.edit().putString("startup_info", (String)localObject1).commit();
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
  
  private static void oo(String paramString)
  {
    AppMethodBeat.i(19905);
    Object localObject = aj.getContext().getSharedPreferences(paramString, 0);
    paramString = ax.aFD(paramString);
    ax.a((SharedPreferences)localObject, paramString);
    localObject = paramString.getString("startup_info", "").split("=");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(19905);
      return;
    }
    a locala = new a();
    if (locala.oq(localObject[(localObject.length - 1)]))
    {
      locala.fjS = 2;
      localObject[(localObject.length - 1)] = locala.toString();
    }
    localObject = g((String[])localObject);
    ad.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[] { localObject });
    paramString.edit().putString("startup_info", (String)localObject).commit();
    AppMethodBeat.o(19905);
  }
  
  public static void report()
  {
    AppMethodBeat.i(19906);
    if ((fjP != 0L) && (bt.aS(fjP) < 3600000L))
    {
      AppMethodBeat.o(19906);
      return;
    }
    int i = ((Integer)az.arT().get(37, Integer.valueOf(0))).intValue();
    if (d.CpK != i)
    {
      az.arT().set(37, Integer.valueOf(d.CpK));
      new ap(Looper.getMainLooper()).post(new o.1(i));
    }
    fjP = bt.GC();
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19900);
        o.op("mm_proc_startup");
        o.op("push_proc_startup");
        AppMethodBeat.o(19900);
      }
    });
    AppMethodBeat.o(19906);
  }
  
  static final class a
  {
    int fjR;
    int fjS = 1;
    int fjT;
    int fjU;
    int fjV;
    
    public final boolean oq(String paramString)
    {
      AppMethodBeat.i(19901);
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length != 5))
      {
        ad.e("MicroMsg.ProcessReport", "error format");
        AppMethodBeat.o(19901);
        return false;
      }
      try
      {
        this.fjR = bt.getInt(paramString[0], 0);
        this.fjS = bt.getInt(paramString[1], 0);
        this.fjT = bt.getInt(paramString[2], 0);
        this.fjU = bt.getInt(paramString[3], 0);
        this.fjV = bt.getInt(paramString[4], 0);
        AppMethodBeat.o(19901);
        return true;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
        ad.printErrStackTrace("MicroMsg.ProcessReport", paramString, "", new Object[0]);
        AppMethodBeat.o(19901);
      }
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(19902);
      String str = String.format("%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.fjR), Integer.valueOf(this.fjS), Integer.valueOf(this.fjT), Integer.valueOf(this.fjU), Integer.valueOf(this.fjV) });
      AppMethodBeat.o(19902);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.o
 * JD-Core Version:    0.7.0.1
 */