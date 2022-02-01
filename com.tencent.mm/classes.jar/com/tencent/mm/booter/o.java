package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;

public final class o
{
  static long fnj = 0L;
  
  public static void Lp()
  {
    AppMethodBeat.i(19904);
    ru("mm_proc_startup");
    ru("push_proc_startup");
    AppMethodBeat.o(19904);
  }
  
  public static void UK()
  {
    AppMethodBeat.i(19903);
    Object localObject1 = ai.getContext().getSharedPreferences("mm_proc_startup", 0);
    aw localaw = aw.aKU("mm_proc_startup");
    aw.a((SharedPreferences)localObject1, localaw);
    localObject1 = localaw.getString("startup_info", "").split("=");
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject2 = new a();
      if (((a)localObject2).rw(localObject1[(localObject1.length - 1)]))
      {
        ((a)localObject2).fnp = Process.myPid();
        localObject1[(localObject1.length - 1)] = ((a)localObject2).toString();
      }
    }
    Object localObject2 = new a();
    ((a)localObject2).fnl = 2;
    ((a)localObject2).fnn = Process.myPid();
    ((a)localObject2).fno = ((int)bs.aNx());
    String str = g((String[])localObject1);
    localObject2 = ((a)localObject2).toString();
    localObject1 = localObject2;
    if (str.length() > 0) {
      localObject1 = str + "=" + (String)localObject2;
    }
    ac.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[] { localObject1 });
    localaw.edit().putString("startup_info", (String)localObject1).commit();
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
    if ((fnj != 0L) && (bs.aO(fnj) < 3600000L))
    {
      AppMethodBeat.o(19906);
      return;
    }
    int i = ((Integer)az.ayK().get(37, Integer.valueOf(0))).intValue();
    if (d.DIc != i)
    {
      az.ayK().set(37, Integer.valueOf(d.DIc));
      new ao(Looper.getMainLooper()).post(new o.1(i));
    }
    fnj = bs.Gn();
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(19900);
        o.rv("mm_proc_startup");
        o.rv("push_proc_startup");
        AppMethodBeat.o(19900);
      }
    });
    AppMethodBeat.o(19906);
  }
  
  private static void ru(String paramString)
  {
    AppMethodBeat.i(19905);
    Object localObject = ai.getContext().getSharedPreferences(paramString, 0);
    paramString = aw.aKU(paramString);
    aw.a((SharedPreferences)localObject, paramString);
    localObject = paramString.getString("startup_info", "").split("=");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(19905);
      return;
    }
    a locala = new a();
    if (locala.rw(localObject[(localObject.length - 1)]))
    {
      locala.fnm = 2;
      localObject[(localObject.length - 1)] = locala.toString();
    }
    localObject = g((String[])localObject);
    ac.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[] { localObject });
    paramString.edit().putString("startup_info", (String)localObject).commit();
    AppMethodBeat.o(19905);
  }
  
  static final class a
  {
    int fnl;
    int fnm = 1;
    int fnn;
    int fno;
    int fnp;
    
    public final boolean rw(String paramString)
    {
      AppMethodBeat.i(19901);
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length != 5))
      {
        ac.e("MicroMsg.ProcessReport", "error format");
        AppMethodBeat.o(19901);
        return false;
      }
      try
      {
        this.fnl = bs.getInt(paramString[0], 0);
        this.fnm = bs.getInt(paramString[1], 0);
        this.fnn = bs.getInt(paramString[2], 0);
        this.fno = bs.getInt(paramString[3], 0);
        this.fnp = bs.getInt(paramString[4], 0);
        AppMethodBeat.o(19901);
        return true;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
        ac.printErrStackTrace("MicroMsg.ProcessReport", paramString, "", new Object[0]);
        AppMethodBeat.o(19901);
      }
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(19902);
      String str = String.format("%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.fnl), Integer.valueOf(this.fnm), Integer.valueOf(this.fnn), Integer.valueOf(this.fno), Integer.valueOf(this.fnp) });
      AppMethodBeat.o(19902);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.o
 * JD-Core Version:    0.7.0.1
 */