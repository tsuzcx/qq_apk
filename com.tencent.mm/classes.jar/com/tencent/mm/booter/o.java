package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

public final class o
{
  static long dim = 0L;
  
  private static String e(String[] paramArrayOfString)
  {
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
    return str1;
  }
  
  private static void eq(String paramString)
  {
    paramString = ae.getContext().getSharedPreferences(paramString, 0);
    Object localObject = paramString.getString("startup_info", "").split("=");
    if ((localObject == null) || (localObject.length == 0)) {
      return;
    }
    o.a locala = new o.a();
    if (locala.es(localObject[(localObject.length - 1)]))
    {
      locala.dip = 2;
      localObject[(localObject.length - 1)] = locala.toString();
    }
    localObject = e((String[])localObject);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ProcessReport", "uerExit new info %s", new Object[] { localObject });
    paramString.edit().putString("startup_info", (String)localObject).commit();
  }
  
  public static void onCreate(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      s("mm_proc_startup", 2);
      return;
    }
    s("push_proc_startup", 1);
  }
  
  private static void s(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences(paramString, 0);
    paramString = localSharedPreferences.getString("startup_info", "").split("=");
    if ((paramString != null) && (paramString.length > 0))
    {
      localObject = new o.a();
      if (((o.a)localObject).es(paramString[(paramString.length - 1)]))
      {
        ((o.a)localObject).dit = Process.myPid();
        paramString[(paramString.length - 1)] = ((o.a)localObject).toString();
      }
    }
    Object localObject = new o.a();
    ((o.a)localObject).dio = paramInt;
    ((o.a)localObject).diq = Process.myPid();
    ((o.a)localObject).dis = ((int)bk.UX());
    String str = e(paramString);
    localObject = ((o.a)localObject).toString();
    paramString = (String)localObject;
    if (str.length() > 0) {
      paramString = str + "=" + (String)localObject;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ProcessReport", "startProc new info %s", new Object[] { paramString });
    localSharedPreferences.edit().putString("startup_info", paramString).commit();
  }
  
  public static void tq()
  {
    eq("mm_proc_startup");
    eq("push_proc_startup");
  }
  
  public static void wn()
  {
    if ((dim != 0L) && (bk.cp(dim) < 3600000L)) {
      return;
    }
    int i = ((Integer)au.Hv().get(37, Integer.valueOf(0))).intValue();
    if (d.spa != i)
    {
      au.Hv().set(37, Integer.valueOf(d.spa));
      new ah(Looper.getMainLooper()).post(new o.1(i));
    }
    dim = bk.UZ();
    new ah(Looper.getMainLooper()).post(new o.2());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.o
 * JD-Core Version:    0.7.0.1
 */