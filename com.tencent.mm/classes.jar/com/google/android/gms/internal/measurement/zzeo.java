package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzeo
  extends zzhh
{
  private long zzafm;
  private String zzafn;
  private Boolean zzafo;
  
  zzeo(zzgl paramzzgl)
  {
    super(paramzzgl);
  }
  
  public final boolean zzf(Context paramContext)
  {
    AppMethodBeat.i(68701);
    if (this.zzafo == null) {
      this.zzafo = Boolean.FALSE;
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      if (paramContext != null)
      {
        paramContext.getPackageInfo("com.google.android.gms", 128);
        this.zzafo = Boolean.TRUE;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label45:
      boolean bool;
      break label45;
    }
    bool = this.zzafo.booleanValue();
    AppMethodBeat.o(68701);
    return bool;
  }
  
  protected final boolean zzhf()
  {
    AppMethodBeat.i(68698);
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = TimeUnit.MINUTES;
    int i = ((Calendar)localObject1).get(15);
    this.zzafm = ((TimeUnit)localObject2).convert(((Calendar)localObject1).get(16) + i, TimeUnit.MILLISECONDS);
    localObject2 = Locale.getDefault();
    localObject1 = ((Locale)localObject2).getLanguage().toLowerCase(Locale.ENGLISH);
    localObject2 = ((Locale)localObject2).getCountry().toLowerCase(Locale.ENGLISH);
    this.zzafn = (String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + "-" + (String)localObject2);
    AppMethodBeat.o(68698);
    return false;
  }
  
  public final long zzic()
  {
    AppMethodBeat.i(68699);
    zzch();
    long l = this.zzafm;
    AppMethodBeat.o(68699);
    return l;
  }
  
  public final String zzid()
  {
    AppMethodBeat.i(68700);
    zzch();
    String str = this.zzafn;
    AppMethodBeat.o(68700);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzeo
 * JD-Core Version:    0.7.0.1
 */