package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.e.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;

public final class zzgf
  extends zzjq
  implements zzeh
{
  @VisibleForTesting
  private static int zzalf = 65535;
  @VisibleForTesting
  private static int zzalg = 2;
  private final Map<String, Map<String, String>> zzalh;
  private final Map<String, Map<String, Boolean>> zzali;
  private final Map<String, Map<String, Boolean>> zzalj;
  private final Map<String, zzkk> zzalk;
  private final Map<String, Map<String, Integer>> zzall;
  private final Map<String, String> zzalm;
  
  zzgf(zzjr paramzzjr)
  {
    super(paramzzjr);
    AppMethodBeat.i(68986);
    this.zzalh = new a();
    this.zzali = new a();
    this.zzalj = new a();
    this.zzalk = new a();
    this.zzalm = new a();
    this.zzall = new a();
    AppMethodBeat.o(68986);
  }
  
  private final zzkk zza(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(68999);
    if (paramArrayOfByte == null)
    {
      paramString = new zzkk();
      AppMethodBeat.o(68999);
      return paramString;
    }
    paramArrayOfByte = zzabv.zza(paramArrayOfByte, 0, paramArrayOfByte.length);
    zzkk localzzkk = new zzkk();
    try
    {
      localzzkk.zzb(paramArrayOfByte);
      zzge().zzit().zze("Parsed config. version, gmp_app_id", localzzkk.zzasp, localzzkk.zzadm);
      AppMethodBeat.o(68999);
      return localzzkk;
    }
    catch (IOException paramArrayOfByte)
    {
      zzge().zzip().zze("Unable to merge remote config. appId", zzfg.zzbm(paramString), paramArrayOfByte);
      paramString = new zzkk();
      AppMethodBeat.o(68999);
    }
    return paramString;
  }
  
  private static Map<String, String> zza(zzkk paramzzkk)
  {
    AppMethodBeat.i(68993);
    a locala = new a();
    if ((paramzzkk != null) && (paramzzkk.zzasr != null))
    {
      paramzzkk = paramzzkk.zzasr;
      int j = paramzzkk.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramzzkk[i];
        if (localObject != null) {
          locala.put(localObject.zzny, localObject.value);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(68993);
    return locala;
  }
  
  private final void zza(String paramString, zzkk paramzzkk)
  {
    AppMethodBeat.i(68994);
    a locala1 = new a();
    a locala2 = new a();
    a locala3 = new a();
    if ((paramzzkk != null) && (paramzzkk.zzass != null))
    {
      paramzzkk = paramzzkk.zzass;
      int j = paramzzkk.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramzzkk[i];
        if (TextUtils.isEmpty(localObject.name)) {
          zzge().zzip().log("EventConfig contained null event name");
        }
        for (;;)
        {
          i += 1;
          break;
          String str = AppMeasurement.Event.zzak(localObject.name);
          if (!TextUtils.isEmpty(str)) {
            localObject.name = str;
          }
          locala1.put(localObject.name, localObject.zzasm);
          locala2.put(localObject.name, localObject.zzasn);
          if (localObject.zzaso != null) {
            if ((localObject.zzaso.intValue() < zzalg) || (localObject.zzaso.intValue() > zzalf)) {
              zzge().zzip().zze("Invalid sampling rate. Event name, sample rate", localObject.name, localObject.zzaso);
            } else {
              locala3.put(localObject.name, localObject.zzaso);
            }
          }
        }
      }
    }
    this.zzali.put(paramString, locala1);
    this.zzalj.put(paramString, locala2);
    this.zzall.put(paramString, locala3);
    AppMethodBeat.o(68994);
  }
  
  private final void zzbt(String paramString)
  {
    AppMethodBeat.i(68987);
    zzch();
    zzab();
    Preconditions.checkNotEmpty(paramString);
    if (this.zzalk.get(paramString) == null)
    {
      Object localObject = zzix().zzbe(paramString);
      if (localObject == null)
      {
        this.zzalh.put(paramString, null);
        this.zzali.put(paramString, null);
        this.zzalj.put(paramString, null);
        this.zzalk.put(paramString, null);
        this.zzalm.put(paramString, null);
        this.zzall.put(paramString, null);
        AppMethodBeat.o(68987);
        return;
      }
      localObject = zza(paramString, (byte[])localObject);
      this.zzalh.put(paramString, zza((zzkk)localObject));
      zza(paramString, (zzkk)localObject);
      this.zzalk.put(paramString, localObject);
      this.zzalm.put(paramString, null);
    }
    AppMethodBeat.o(68987);
  }
  
  protected final boolean zza(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(68995);
    zzch();
    zzab();
    Preconditions.checkNotEmpty(paramString1);
    localObject1 = zza(paramString1, paramArrayOfByte);
    if (localObject1 == null)
    {
      AppMethodBeat.o(68995);
      return false;
    }
    zza(paramString1, (zzkk)localObject1);
    this.zzalk.put(paramString1, localObject1);
    this.zzalm.put(paramString1, paramString2);
    this.zzalh.put(paramString1, zza((zzkk)localObject1));
    paramString2 = zziw();
    zzkd[] arrayOfzzkd = ((zzkk)localObject1).zzast;
    Preconditions.checkNotNull(arrayOfzzkd);
    int m = arrayOfzzkd.length;
    int i = 0;
    while (i < m)
    {
      Object localObject2 = arrayOfzzkd[i];
      zzke[] arrayOfzzke = ((zzkd)localObject2).zzarn;
      int n = arrayOfzzke.length;
      int j = 0;
      Object localObject3;
      while (j < n)
      {
        localObject3 = arrayOfzzke[j];
        String str1 = AppMeasurement.Event.zzak(((zzke)localObject3).zzarq);
        if (str1 != null) {
          ((zzke)localObject3).zzarq = str1;
        }
        localObject3 = ((zzke)localObject3).zzarr;
        int i1 = localObject3.length;
        k = 0;
        while (k < i1)
        {
          str1 = localObject3[k];
          String str2 = AppMeasurement.Param.zzak(str1.zzary);
          if (str2 != null) {
            str1.zzary = str2;
          }
          k += 1;
        }
        j += 1;
      }
      localObject2 = ((zzkd)localObject2).zzarm;
      int k = localObject2.length;
      j = 0;
      while (j < k)
      {
        arrayOfzzke = localObject2[j];
        localObject3 = AppMeasurement.UserProperty.zzak(arrayOfzzke.zzasf);
        if (localObject3 != null) {
          arrayOfzzke.zzasf = ((String)localObject3);
        }
        j += 1;
      }
      i += 1;
    }
    paramString2.zzix().zza(paramString1, arrayOfzzkd);
    try
    {
      ((zzkk)localObject1).zzast = null;
      paramString2 = new byte[((zzace)localObject1).zzvm()];
      ((zzace)localObject1).zza(zzabw.zzb(paramString2, 0, paramString2.length));
      paramArrayOfByte = paramString2;
    }
    catch (IOException paramString2)
    {
      try
      {
        if (paramString2.getWritableDatabase().update("apps", (ContentValues)localObject1, "app_id = ?", new String[] { paramString1 }) != 0L) {
          break label435;
        }
        paramString2.zzge().zzim().zzg("Failed to update remote config (got 0). appId", zzfg.zzbm(paramString1));
        AppMethodBeat.o(68995);
        return true;
        paramString2 = paramString2;
        zzge().zzip().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzfg.zzbm(paramString1), paramString2);
      }
      catch (SQLiteException paramArrayOfByte)
      {
        for (;;)
        {
          paramString2.zzge().zzim().zze("Error storing remote config. appId", zzfg.zzbm(paramString1), paramArrayOfByte);
        }
      }
    }
    paramString2 = zzix();
    Preconditions.checkNotEmpty(paramString1);
    paramString2.zzab();
    paramString2.zzch();
    localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("remote_config", paramArrayOfByte);
  }
  
  protected final zzkk zzbu(String paramString)
  {
    AppMethodBeat.i(68988);
    zzch();
    zzab();
    Preconditions.checkNotEmpty(paramString);
    zzbt(paramString);
    paramString = (zzkk)this.zzalk.get(paramString);
    AppMethodBeat.o(68988);
    return paramString;
  }
  
  protected final String zzbv(String paramString)
  {
    AppMethodBeat.i(68989);
    zzab();
    paramString = (String)this.zzalm.get(paramString);
    AppMethodBeat.o(68989);
    return paramString;
  }
  
  protected final void zzbw(String paramString)
  {
    AppMethodBeat.i(68990);
    zzab();
    this.zzalm.put(paramString, null);
    AppMethodBeat.o(68990);
  }
  
  final void zzbx(String paramString)
  {
    AppMethodBeat.i(68991);
    zzab();
    this.zzalk.remove(paramString);
    AppMethodBeat.o(68991);
  }
  
  final boolean zzby(String paramString)
  {
    AppMethodBeat.i(69000);
    boolean bool = "1".equals(zze(paramString, "measurement.upload.blacklist_internal"));
    AppMethodBeat.o(69000);
    return bool;
  }
  
  final boolean zzbz(String paramString)
  {
    AppMethodBeat.i(69001);
    boolean bool = "1".equals(zze(paramString, "measurement.upload.blacklist_public"));
    AppMethodBeat.o(69001);
    return bool;
  }
  
  public final String zze(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68992);
    zzab();
    zzbt(paramString1);
    paramString1 = (Map)this.zzalh.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (String)paramString1.get(paramString2);
      AppMethodBeat.o(68992);
      return paramString1;
    }
    AppMethodBeat.o(68992);
    return null;
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  final boolean zzn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68996);
    zzab();
    zzbt(paramString1);
    if ((zzby(paramString1)) && (zzka.zzci(paramString2)))
    {
      AppMethodBeat.o(68996);
      return true;
    }
    if ((zzbz(paramString1)) && (zzka.zzcc(paramString2)))
    {
      AppMethodBeat.o(68996);
      return true;
    }
    paramString1 = (Map)this.zzali.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null)
      {
        AppMethodBeat.o(68996);
        return false;
      }
      boolean bool = paramString1.booleanValue();
      AppMethodBeat.o(68996);
      return bool;
    }
    AppMethodBeat.o(68996);
    return false;
  }
  
  final boolean zzo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68997);
    zzab();
    zzbt(paramString1);
    if ("ecommerce_purchase".equals(paramString2))
    {
      AppMethodBeat.o(68997);
      return true;
    }
    paramString1 = (Map)this.zzalj.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null)
      {
        AppMethodBeat.o(68997);
        return false;
      }
      boolean bool = paramString1.booleanValue();
      AppMethodBeat.o(68997);
      return bool;
    }
    AppMethodBeat.o(68997);
    return false;
  }
  
  final int zzp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(68998);
    zzab();
    zzbt(paramString1);
    paramString1 = (Map)this.zzall.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Integer)paramString1.get(paramString2);
      if (paramString1 == null)
      {
        AppMethodBeat.o(68998);
        return 1;
      }
      int i = paramString1.intValue();
      AppMethodBeat.o(68998);
      return i;
    }
    AppMethodBeat.o(68998);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzgf
 * JD-Core Version:    0.7.0.1
 */