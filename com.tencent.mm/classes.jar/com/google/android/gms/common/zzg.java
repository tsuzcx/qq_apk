package com.google.android.gms.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzg
{
  private static final zzg zzbk;
  private final Throwable cause;
  final boolean zzbl;
  private final String zzbm;
  
  static
  {
    AppMethodBeat.i(90340);
    zzbk = new zzg(true, null, null);
    AppMethodBeat.o(90340);
  }
  
  zzg(boolean paramBoolean, @Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    this.zzbl = paramBoolean;
    this.zzbm = paramString;
    this.cause = paramThrowable;
  }
  
  static zzg zza(String paramString, GoogleCertificates.CertData paramCertData, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(90335);
    paramString = new zzi(paramString, paramCertData, paramBoolean1, paramBoolean2, null);
    AppMethodBeat.o(90335);
    return paramString;
  }
  
  static zzg zza(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(90337);
    paramString = new zzg(false, paramString, paramThrowable);
    AppMethodBeat.o(90337);
    return paramString;
  }
  
  static zzg zze(String paramString)
  {
    AppMethodBeat.i(90336);
    paramString = new zzg(false, paramString, null);
    AppMethodBeat.o(90336);
    return paramString;
  }
  
  static zzg zzg()
  {
    return zzbk;
  }
  
  @Nullable
  String getErrorMessage()
  {
    return this.zzbm;
  }
  
  final void zzh()
  {
    AppMethodBeat.i(90338);
    if (!this.zzbl)
    {
      Object localObject = String.valueOf("GoogleCertificatesRslt: ");
      String str = String.valueOf(getErrorMessage());
      if (str.length() != 0) {}
      for (localObject = ((String)localObject).concat(str); this.cause != null; localObject = new String((String)localObject))
      {
        localObject = new SecurityException((String)localObject, this.cause);
        AppMethodBeat.o(90338);
        throw ((Throwable)localObject);
      }
      localObject = new SecurityException((String)localObject);
      AppMethodBeat.o(90338);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(90338);
  }
  
  final void zzi()
  {
    AppMethodBeat.i(90339);
    if (!this.zzbl)
    {
      if (this.cause != null)
      {
        getErrorMessage();
        AppMethodBeat.o(90339);
        return;
      }
      getErrorMessage();
    }
    AppMethodBeat.o(90339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.zzg
 * JD-Core Version:    0.7.0.1
 */