package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;

public final class o
{
  static long fHv = 0L;
  
  public static void MS()
  {
    AppMethodBeat.i(19904);
    uB("mm_proc_startup");
    uB("push_proc_startup");
    AppMethodBeat.o(19904);
  }
  
  public static void Xj()
  {
    AppMethodBeat.i(19903);
    Object localObject1 = ak.getContext().getSharedPreferences("mm_proc_startup", 0);
    ay localay = ay.aRX("mm_proc_startup");
    ay.a((SharedPreferences)localObject1, localay);
    localObject1 = localay.getString("startup_info", "").split("=");
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject2 = new a();
      if (((a)localObject2).uD(localObject1[(localObject1.length - 1)]))
      {
        ((a)localObject2).fHB = Process.myPid();
        localObject1[(localObject1.length - 1)] = ((a)localObject2).toString();
      }
    }
    Object localObject2 = new a();
    ((a)localObject2).fHx = 2;
    ((a)localObject2).fHz = Process.myPid();
    ((a)localObject2).fHA = ((int)bu.aRi());
    String str = g((String[])localObject1);
    localObject2 = ((a)localObject2).toString();
    localObject1 = localObject2;
    if (str.length() > 0) {
      localObject1 = str + "=" + (String)localObject2;
    }
    ae.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[] { localObject1 });
    localay.edit().putString("startup_info", (String)localObject1).commit();
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
    if ((fHv != 0L) && (bu.aO(fHv) < 3600000L))
    {
      AppMethodBeat.o(19906);
      return;
    }
    int i = ((Integer)bc.aCe().get(37, Integer.valueOf(0))).intValue();
    if (d.FFH != i)
    {
      bc.aCe().set(37, Integer.valueOf(d.FFH));
      new aq(Looper.getMainLooper()).post(new o.1(i));
    }
    fHv = bu.HQ();
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19900);
        o.uC("mm_proc_startup");
        o.uC("push_proc_startup");
        AppMethodBeat.o(19900);
      }
    });
    AppMethodBeat.o(19906);
  }
  
  private static void uB(String paramString)
  {
    AppMethodBeat.i(19905);
    Object localObject = ak.getContext().getSharedPreferences(paramString, 0);
    paramString = ay.aRX(paramString);
    ay.a((SharedPreferences)localObject, paramString);
    localObject = paramString.getString("startup_info", "").split("=");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(19905);
      return;
    }
    a locala = new a();
    if (locala.uD(localObject[(localObject.length - 1)]))
    {
      locala.fHy = 2;
      localObject[(localObject.length - 1)] = locala.toString();
    }
    localObject = g((String[])localObject);
    ae.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[] { localObject });
    paramString.edit().putString("startup_info", (String)localObject).commit();
    AppMethodBeat.o(19905);
  }
  
  static final class a
  {
    int fHA;
    int fHB;
    int fHx;
    int fHy = 1;
    int fHz;
    
    public final String toString()
    {
      AppMethodBeat.i(19902);
      String str = String.format("%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.fHx), Integer.valueOf(this.fHy), Integer.valueOf(this.fHz), Integer.valueOf(this.fHA), Integer.valueOf(this.fHB) });
      AppMethodBeat.o(19902);
      return str;
    }
    
    public final boolean uD(String paramString)
    {
      AppMethodBeat.i(19901);
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length != 5))
      {
        ae.e("MicroMsg.ProcessReport", "error format");
        AppMethodBeat.o(19901);
        return false;
      }
      try
      {
        this.fHx = bu.getInt(paramString[0], 0);
        this.fHy = bu.getInt(paramString[1], 0);
        this.fHz = bu.getInt(paramString[2], 0);
        this.fHA = bu.getInt(paramString[3], 0);
        this.fHB = bu.getInt(paramString[4], 0);
        AppMethodBeat.o(19901);
        return true;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
        ae.printErrStackTrace("MicroMsg.ProcessReport", paramString, "", new Object[0]);
        AppMethodBeat.o(19901);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.o
 * JD-Core Version:    0.7.0.1
 */