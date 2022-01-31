package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.b;
import android.support.v4.e.a;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzak
{
  private SharedPreferences zzcz;
  private final zzn zzda;
  private final Map<String, zzo> zzdb;
  private Context zzk;
  
  public zzak(Context paramContext)
  {
    this(paramContext, new zzn());
    AppMethodBeat.i(57549);
    AppMethodBeat.o(57549);
  }
  
  @VisibleForTesting
  private zzak(Context paramContext, zzn paramzzn)
  {
    AppMethodBeat.i(57550);
    this.zzdb = new a();
    this.zzk = paramContext;
    this.zzcz = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    this.zzda = paramzzn;
    paramContext = new File(b.P(this.zzk), "com.google.android.gms.appid-no-backup");
    if (!paramContext.exists()) {
      try
      {
        if ((paramContext.createNewFile()) && (!isEmpty())) {
          InstanceIDListenerService.zzd(this.zzk, this);
        }
        AppMethodBeat.o(57550);
        return;
      }
      catch (IOException paramContext)
      {
        if (Log.isLoggable("InstanceID/Store", 3))
        {
          paramContext = String.valueOf(paramContext.getMessage());
          if (paramContext.length() != 0)
          {
            "Error creating file in no backup dir: ".concat(paramContext);
            AppMethodBeat.o(57550);
            return;
          }
          new String("Error creating file in no backup dir: ");
        }
      }
    }
    AppMethodBeat.o(57550);
  }
  
  private static String zzd(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(57552);
    paramString1 = String.valueOf(paramString1).length() + 4 + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + "|T|" + paramString2 + "|" + paramString3;
    AppMethodBeat.o(57552);
    return paramString1;
  }
  
  static String zzh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57561);
    paramString1 = String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length() + paramString1 + "|S|" + paramString2;
    AppMethodBeat.o(57561);
    return paramString1;
  }
  
  final String get(String paramString)
  {
    try
    {
      AppMethodBeat.i(57553);
      paramString = this.zzcz.getString(paramString, null);
      AppMethodBeat.o(57553);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(57551);
    boolean bool = this.zzcz.getAll().isEmpty();
    AppMethodBeat.o(57551);
    return bool;
  }
  
  public final void zzd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      AppMethodBeat.i(57557);
      paramString1 = zzd(paramString1, paramString2, paramString3);
      paramString2 = this.zzcz.edit();
      paramString2.putString(paramString1, paramString4);
      paramString2.putString("appVersion", paramString5);
      paramString2.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
      paramString2.commit();
      AppMethodBeat.o(57557);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final String zze(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(57556);
      paramString1 = zzd(paramString1, paramString2, paramString3);
      paramString1 = this.zzcz.getString(paramString1, null);
      AppMethodBeat.o(57556);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void zzf(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(57558);
      paramString1 = zzd(paramString1, paramString2, paramString3);
      paramString2 = this.zzcz.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      AppMethodBeat.o(57558);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void zzi(String paramString)
  {
    try
    {
      AppMethodBeat.i(57554);
      SharedPreferences.Editor localEditor = this.zzcz.edit();
      Iterator localIterator = this.zzcz.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
    }
    finally {}
    AppMethodBeat.o(57554);
  }
  
  /* Error */
  public final zzo zzj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 229
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 44	com/google/android/gms/iid/zzak:zzdb	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 232 2 0
    //   17: checkcast 234	com/google/android/gms/iid/zzo
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +12 -> 34
    //   25: ldc 229
    //   27: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: aload_0
    //   35: getfield 58	com/google/android/gms/iid/zzak:zzda	Lcom/google/android/gms/iid/zzn;
    //   38: aload_0
    //   39: getfield 46	com/google/android/gms/iid/zzak:zzk	Landroid/content/Context;
    //   42: aload_1
    //   43: invokevirtual 237	com/google/android/gms/iid/zzn:zze	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   46: astore_2
    //   47: aload_0
    //   48: getfield 44	com/google/android/gms/iid/zzak:zzdb	Ljava/util/Map;
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 241 3 0
    //   58: pop
    //   59: ldc 229
    //   61: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -34 -> 30
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 46	com/google/android/gms/iid/zzak:zzk	Landroid/content/Context;
    //   77: aload_0
    //   78: invokestatic 87	com/google/android/gms/iid/InstanceIDListenerService:zzd	(Landroid/content/Context;Lcom/google/android/gms/iid/zzak;)V
    //   81: aload_0
    //   82: getfield 58	com/google/android/gms/iid/zzak:zzda	Lcom/google/android/gms/iid/zzn;
    //   85: aload_0
    //   86: getfield 46	com/google/android/gms/iid/zzak:zzk	Landroid/content/Context;
    //   89: aload_1
    //   90: invokevirtual 243	com/google/android/gms/iid/zzn:zzf	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   93: astore_2
    //   94: goto -47 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	zzak
    //   0	97	1	paramString	String
    //   20	33	2	localzzo1	zzo
    //   72	1	2	localzzp	zzp
    //   93	1	2	localzzo2	zzo
    // Exception table:
    //   from	to	target	type
    //   2	21	67	finally
    //   25	30	67	finally
    //   34	47	67	finally
    //   47	64	67	finally
    //   73	94	67	finally
    //   34	47	72	com/google/android/gms/iid/zzp
  }
  
  final void zzk(String paramString)
  {
    AppMethodBeat.i(57560);
    try
    {
      this.zzdb.remove(paramString);
      zzn.zzg(this.zzk, paramString);
      zzi(String.valueOf(paramString).concat("|"));
      AppMethodBeat.o(57560);
      return;
    }
    finally
    {
      AppMethodBeat.o(57560);
    }
  }
  
  public final void zzx()
  {
    try
    {
      AppMethodBeat.i(57555);
      this.zzdb.clear();
      zzn.zzi(this.zzk);
      this.zzcz.edit().clear().commit();
      AppMethodBeat.o(57555);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.iid.zzak
 * JD-Core Version:    0.7.0.1
 */