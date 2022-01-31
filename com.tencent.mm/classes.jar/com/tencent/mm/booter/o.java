package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.y;

public final class o
{
  static long dZG = 0L;
  
  public static void BU()
  {
    AppMethodBeat.i(15868);
    kx("mm_proc_startup");
    kx("push_proc_startup");
    AppMethodBeat.o(15868);
  }
  
  public static void ID()
  {
    AppMethodBeat.i(15867);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("mm_proc_startup", 0);
    Object localObject1 = localSharedPreferences.getString("startup_info", "").split("=");
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject2 = new a();
      if (((a)localObject2).kz(localObject1[(localObject1.length - 1)]))
      {
        ((a)localObject2).dZM = Process.myPid();
        localObject1[(localObject1.length - 1)] = ((a)localObject2).toString();
      }
    }
    Object localObject2 = new a();
    ((a)localObject2).dZI = 2;
    ((a)localObject2).dZK = Process.myPid();
    ((a)localObject2).dZL = ((int)bo.aox());
    String str = e((String[])localObject1);
    localObject2 = ((a)localObject2).toString();
    localObject1 = localObject2;
    if (str.length() > 0) {
      localObject1 = str + "=" + (String)localObject2;
    }
    ab.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[] { localObject1 });
    localSharedPreferences.edit().putString("startup_info", (String)localObject1).commit();
    AppMethodBeat.o(15867);
  }
  
  public static void IE()
  {
    AppMethodBeat.i(15870);
    if ((dZG != 0L) && (bo.av(dZG) < 3600000L))
    {
      AppMethodBeat.o(15870);
      return;
    }
    int i = ((Integer)aw.aax().get(37, Integer.valueOf(0))).intValue();
    if (d.whH != i)
    {
      aw.aax().set(37, Integer.valueOf(d.whH));
      new ak(Looper.getMainLooper()).post(new o.1(i));
    }
    dZG = bo.yB();
    new ak(Looper.getMainLooper()).post(new o.2());
    AppMethodBeat.o(15870);
  }
  
  private static String e(String[] paramArrayOfString)
  {
    AppMethodBeat.i(15871);
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
    AppMethodBeat.o(15871);
    return str1;
  }
  
  private static void kx(String paramString)
  {
    AppMethodBeat.i(15869);
    paramString = ah.getContext().getSharedPreferences(paramString, 0);
    Object localObject = paramString.getString("startup_info", "").split("=");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(15869);
      return;
    }
    a locala = new a();
    if (locala.kz(localObject[(localObject.length - 1)]))
    {
      locala.dZJ = 2;
      localObject[(localObject.length - 1)] = locala.toString();
    }
    localObject = e((String[])localObject);
    ab.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[] { localObject });
    paramString.edit().putString("startup_info", (String)localObject).commit();
    AppMethodBeat.o(15869);
  }
  
  static final class a
  {
    int dZI;
    int dZJ = 1;
    int dZK;
    int dZL;
    int dZM;
    
    public final boolean kz(String paramString)
    {
      AppMethodBeat.i(15865);
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length != 5))
      {
        ab.e("MicroMsg.ProcessReport", "error format");
        AppMethodBeat.o(15865);
        return false;
      }
      try
      {
        this.dZI = bo.getInt(paramString[0], 0);
        this.dZJ = bo.getInt(paramString[1], 0);
        this.dZK = bo.getInt(paramString[2], 0);
        this.dZL = bo.getInt(paramString[3], 0);
        this.dZM = bo.getInt(paramString[4], 0);
        AppMethodBeat.o(15865);
        return true;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
        ab.printErrStackTrace("MicroMsg.ProcessReport", paramString, "", new Object[0]);
        AppMethodBeat.o(15865);
      }
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(15866);
      String str = String.format("%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.dZI), Integer.valueOf(this.dZJ), Integer.valueOf(this.dZK), Integer.valueOf(this.dZL), Integer.valueOf(this.dZM) });
      AppMethodBeat.o(15866);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.o
 * JD-Core Version:    0.7.0.1
 */