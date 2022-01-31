package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfg
  extends zzhh
{
  private long zzadu;
  private char zzaim;
  private String zzain;
  private final zzfi zzaio;
  private final zzfi zzaip;
  private final zzfi zzaiq;
  private final zzfi zzair;
  private final zzfi zzais;
  private final zzfi zzait;
  private final zzfi zzaiu;
  private final zzfi zzaiv;
  private final zzfi zzaiw;
  
  zzfg(zzgl paramzzgl)
  {
    super(paramzzgl);
    AppMethodBeat.i(68870);
    this.zzaim = '\000';
    this.zzadu = -1L;
    this.zzaio = new zzfi(this, 6, false, false);
    this.zzaip = new zzfi(this, 6, true, false);
    this.zzaiq = new zzfi(this, 6, false, true);
    this.zzair = new zzfi(this, 5, false, false);
    this.zzais = new zzfi(this, 5, true, false);
    this.zzait = new zzfi(this, 5, false, true);
    this.zzaiu = new zzfi(this, 4, false, false);
    this.zzaiv = new zzfi(this, 3, false, false);
    this.zzaiw = new zzfi(this, 2, false, false);
    AppMethodBeat.o(68870);
  }
  
  @VisibleForTesting
  private static String zza(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(68877);
    if (paramObject == null)
    {
      AppMethodBeat.o(68877);
      return "";
    }
    if ((paramObject instanceof Integer)) {
      paramObject = Long.valueOf(((Integer)paramObject).intValue());
    }
    for (;;)
    {
      String str1;
      if ((paramObject instanceof Long))
      {
        if (!paramBoolean)
        {
          paramObject = String.valueOf(paramObject);
          AppMethodBeat.o(68877);
          return paramObject;
        }
        if (Math.abs(((Long)paramObject).longValue()) < 100L)
        {
          paramObject = String.valueOf(paramObject);
          AppMethodBeat.o(68877);
          return paramObject;
        }
        if (String.valueOf(paramObject).charAt(0) == '-') {}
        for (str1 = "-";; str1 = "")
        {
          paramObject = String.valueOf(Math.abs(((Long)paramObject).longValue()));
          long l1 = Math.round(Math.pow(10.0D, paramObject.length() - 1));
          long l2 = Math.round(Math.pow(10.0D, paramObject.length()) - 1.0D);
          paramObject = String.valueOf(str1).length() + 43 + String.valueOf(str1).length() + str1 + l1 + "..." + str1 + l2;
          AppMethodBeat.o(68877);
          return paramObject;
        }
      }
      if ((paramObject instanceof Boolean))
      {
        paramObject = String.valueOf(paramObject);
        AppMethodBeat.o(68877);
        return paramObject;
      }
      if ((paramObject instanceof Throwable))
      {
        Object localObject1 = (Throwable)paramObject;
        String str2;
        int j;
        int i;
        if (paramBoolean)
        {
          paramObject = localObject1.getClass().getName();
          paramObject = new StringBuilder(paramObject);
          str1 = zzbn(AppMeasurement.class.getCanonicalName());
          str2 = zzbn(zzgl.class.getCanonicalName());
          localObject1 = ((Throwable)localObject1).getStackTrace();
          j = localObject1.length;
          i = 0;
        }
        for (;;)
        {
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            if (!localObject2.isNativeMethod())
            {
              String str3 = localObject2.getClassName();
              if (str3 != null)
              {
                str3 = zzbn(str3);
                if ((str3.equals(str1)) || (str3.equals(str2)))
                {
                  paramObject.append(": ");
                  paramObject.append(localObject2);
                }
              }
            }
          }
          else
          {
            paramObject = paramObject.toString();
            AppMethodBeat.o(68877);
            return paramObject;
            paramObject = ((Throwable)localObject1).toString();
            break;
          }
          i += 1;
        }
      }
      if ((paramObject instanceof zzfj))
      {
        paramObject = zzfj.zza((zzfj)paramObject);
        AppMethodBeat.o(68877);
        return paramObject;
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(68877);
        return "-";
      }
      paramObject = String.valueOf(paramObject);
      AppMethodBeat.o(68877);
      return paramObject;
    }
  }
  
  static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(68876);
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zza(paramBoolean, paramObject1);
    paramObject2 = zza(paramBoolean, paramObject2);
    paramObject3 = zza(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = paramObject1;
    if (!TextUtils.isEmpty(paramObject2))
    {
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty(paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramObject3);
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(68876);
    return paramString;
  }
  
  protected static Object zzbm(String paramString)
  {
    AppMethodBeat.i(68871);
    if (paramString == null)
    {
      AppMethodBeat.o(68871);
      return null;
    }
    paramString = new zzfj(paramString);
    AppMethodBeat.o(68871);
    return paramString;
  }
  
  private static String zzbn(String paramString)
  {
    AppMethodBeat.i(68878);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(68878);
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i == -1)
    {
      AppMethodBeat.o(68878);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(68878);
    return paramString;
  }
  
  private final String zziu()
  {
    AppMethodBeat.i(68875);
    try
    {
      if (this.zzain == null) {
        this.zzain = ((String)zzew.zzagi.get());
      }
      String str = this.zzain;
      return str;
    }
    finally
    {
      AppMethodBeat.o(68875);
    }
  }
  
  @VisibleForTesting
  protected final boolean isLoggable(int paramInt)
  {
    AppMethodBeat.i(68873);
    boolean bool = Log.isLoggable(zziu(), paramInt);
    AppMethodBeat.o(68873);
    return bool;
  }
  
  @VisibleForTesting
  protected final void zza(int paramInt, String paramString)
  {
    AppMethodBeat.i(68874);
    Log.println(paramInt, zziu(), paramString);
    AppMethodBeat.o(68874);
  }
  
  protected final void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(68872);
    if ((!paramBoolean1) && (isLoggable(paramInt))) {
      zza(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3));
    }
    zzgg localzzgg;
    if ((!paramBoolean2) && (paramInt >= 5))
    {
      Preconditions.checkNotNull(paramString);
      localzzgg = this.zzacw.zzjq();
      if (localzzgg == null)
      {
        zza(6, "Scheduler not set. Not logging error/warn");
        AppMethodBeat.o(68872);
        return;
      }
      if (!localzzgg.isInitialized())
      {
        zza(6, "Scheduler not initialized. Not logging error/warn");
        AppMethodBeat.o(68872);
        return;
      }
      if (paramInt >= 0) {
        break label153;
      }
      paramInt = 0;
    }
    label153:
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= 9) {
        i = 8;
      }
      localzzgg.zzc(new zzfh(this, i, paramString, paramObject1, paramObject2, paramObject3));
      AppMethodBeat.o(68872);
      return;
    }
  }
  
  protected final boolean zzhf()
  {
    return false;
  }
  
  public final zzfi zzim()
  {
    return this.zzaio;
  }
  
  public final zzfi zzin()
  {
    return this.zzaip;
  }
  
  public final zzfi zzio()
  {
    return this.zzaiq;
  }
  
  public final zzfi zzip()
  {
    return this.zzair;
  }
  
  public final zzfi zziq()
  {
    return this.zzait;
  }
  
  public final zzfi zzir()
  {
    return this.zzaiu;
  }
  
  public final zzfi zzis()
  {
    return this.zzaiv;
  }
  
  public final zzfi zzit()
  {
    return this.zzaiw;
  }
  
  public final String zziv()
  {
    AppMethodBeat.i(68879);
    Object localObject = zzgf().zzajt.zzfi();
    if ((localObject == null) || (localObject == zzfr.zzajs))
    {
      AppMethodBeat.o(68879);
      return null;
    }
    String str = String.valueOf(((Pair)localObject).second);
    localObject = (String)((Pair)localObject).first;
    str = String.valueOf(str).length() + 1 + String.valueOf(localObject).length() + str + ":" + (String)localObject;
    AppMethodBeat.o(68879);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfg
 * JD-Core Version:    0.7.0.1
 */