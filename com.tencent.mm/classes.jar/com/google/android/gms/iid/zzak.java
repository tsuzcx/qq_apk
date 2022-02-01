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
    AppMethodBeat.i(2503);
    AppMethodBeat.o(2503);
  }
  
  @VisibleForTesting
  private zzak(Context paramContext, zzn paramzzn)
  {
    AppMethodBeat.i(2504);
    this.zzdb = new a();
    this.zzk = paramContext;
    this.zzcz = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    this.zzda = paramzzn;
    paramContext = new File(b.T(this.zzk), "com.google.android.gms.appid-no-backup");
    if (!paramContext.exists()) {
      try
      {
        if ((paramContext.createNewFile()) && (!isEmpty())) {
          InstanceIDListenerService.zzd(this.zzk, this);
        }
        AppMethodBeat.o(2504);
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
            AppMethodBeat.o(2504);
            return;
          }
          new String("Error creating file in no backup dir: ");
        }
      }
    }
    AppMethodBeat.o(2504);
  }
  
  private static String zzd(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(2506);
    paramString1 = String.valueOf(paramString1).length() + 4 + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + "|T|" + paramString2 + "|" + paramString3;
    AppMethodBeat.o(2506);
    return paramString1;
  }
  
  static String zzh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2515);
    paramString1 = String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length() + paramString1 + "|S|" + paramString2;
    AppMethodBeat.o(2515);
    return paramString1;
  }
  
  final String get(String paramString)
  {
    try
    {
      AppMethodBeat.i(2507);
      paramString = this.zzcz.getString(paramString, null);
      AppMethodBeat.o(2507);
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
    AppMethodBeat.i(2505);
    boolean bool = this.zzcz.getAll().isEmpty();
    AppMethodBeat.o(2505);
    return bool;
  }
  
  public final void zzd(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      AppMethodBeat.i(2511);
      paramString1 = zzd(paramString1, paramString2, paramString3);
      paramString2 = this.zzcz.edit();
      paramString2.putString(paramString1, paramString4);
      paramString2.putString("appVersion", paramString5);
      paramString2.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
      paramString2.commit();
      AppMethodBeat.o(2511);
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
      AppMethodBeat.i(2510);
      paramString1 = zzd(paramString1, paramString2, paramString3);
      paramString1 = this.zzcz.getString(paramString1, null);
      AppMethodBeat.o(2510);
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
      AppMethodBeat.i(2512);
      paramString1 = zzd(paramString1, paramString2, paramString3);
      paramString2 = this.zzcz.edit();
      paramString2.remove(paramString1);
      paramString2.commit();
      AppMethodBeat.o(2512);
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
      AppMethodBeat.i(2508);
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
    AppMethodBeat.o(2508);
  }
  
  /* Error */
  public final zzo zzj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 2513
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 42	com/google/android/gms/iid/zzak:zzdb	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 221 2 0
    //   18: checkcast 223	com/google/android/gms/iid/zzo
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +13 -> 36
    //   26: sipush 2513
    //   29: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: getfield 56	com/google/android/gms/iid/zzak:zzda	Lcom/google/android/gms/iid/zzn;
    //   40: aload_0
    //   41: getfield 44	com/google/android/gms/iid/zzak:zzk	Landroid/content/Context;
    //   44: aload_1
    //   45: invokevirtual 226	com/google/android/gms/iid/zzn:zze	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 42	com/google/android/gms/iid/zzak:zzdb	Ljava/util/Map;
    //   53: aload_1
    //   54: aload_2
    //   55: invokeinterface 230 3 0
    //   60: pop
    //   61: sipush 2513
    //   64: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: goto -35 -> 32
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_2
    //   76: aload_0
    //   77: getfield 44	com/google/android/gms/iid/zzak:zzk	Landroid/content/Context;
    //   80: aload_0
    //   81: invokestatic 85	com/google/android/gms/iid/InstanceIDListenerService:zzd	(Landroid/content/Context;Lcom/google/android/gms/iid/zzak;)V
    //   84: aload_0
    //   85: getfield 56	com/google/android/gms/iid/zzak:zzda	Lcom/google/android/gms/iid/zzn;
    //   88: aload_0
    //   89: getfield 44	com/google/android/gms/iid/zzak:zzk	Landroid/content/Context;
    //   92: aload_1
    //   93: invokevirtual 232	com/google/android/gms/iid/zzn:zzf	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   96: astore_2
    //   97: goto -48 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	zzak
    //   0	100	1	paramString	String
    //   21	34	2	localzzo1	zzo
    //   75	1	2	localzzp	zzp
    //   96	1	2	localzzo2	zzo
    // Exception table:
    //   from	to	target	type
    //   2	22	70	finally
    //   26	32	70	finally
    //   36	49	70	finally
    //   49	67	70	finally
    //   76	97	70	finally
    //   36	49	75	com/google/android/gms/iid/zzp
  }
  
  final void zzk(String paramString)
  {
    AppMethodBeat.i(2514);
    try
    {
      this.zzdb.remove(paramString);
      zzn.zzg(this.zzk, paramString);
      zzi(String.valueOf(paramString).concat("|"));
      AppMethodBeat.o(2514);
      return;
    }
    finally
    {
      AppMethodBeat.o(2514);
    }
  }
  
  public final void zzx()
  {
    try
    {
      AppMethodBeat.i(2509);
      this.zzdb.clear();
      zzn.zzi(this.zzk);
      this.zzcz.edit().clear().commit();
      AppMethodBeat.o(2509);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.iid.zzak
 * JD-Core Version:    0.7.0.1
 */