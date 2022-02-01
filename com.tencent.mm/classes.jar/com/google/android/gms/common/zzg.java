package com.google.android.gms.common;

import com.tencent.matrix.trace.core.AppMethodBeat;

class zzg
{
  private static final zzg zzbk;
  private final Throwable cause;
  final boolean zzbl;
  private final String zzbm;
  
  static
  {
    AppMethodBeat.i(5361);
    zzbk = new zzg(true, null, null);
    AppMethodBeat.o(5361);
  }
  
  zzg(boolean paramBoolean, String paramString, Throwable paramThrowable)
  {
    this.zzbl = paramBoolean;
    this.zzbm = paramString;
    this.cause = paramThrowable;
  }
  
  static zzg zza(String paramString, GoogleCertificates.CertData paramCertData, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(5356);
    paramString = new zzi(paramString, paramCertData, paramBoolean1, paramBoolean2, null);
    AppMethodBeat.o(5356);
    return paramString;
  }
  
  static zzg zza(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(5358);
    paramString = new zzg(false, paramString, paramThrowable);
    AppMethodBeat.o(5358);
    return paramString;
  }
  
  static zzg zze(String paramString)
  {
    AppMethodBeat.i(5357);
    paramString = new zzg(false, paramString, null);
    AppMethodBeat.o(5357);
    return paramString;
  }
  
  static zzg zzg()
  {
    return zzbk;
  }
  
  String getErrorMessage()
  {
    return this.zzbm;
  }
  
  final void zzh()
  {
    AppMethodBeat.i(5359);
    if (!this.zzbl)
    {
      Object localObject = String.valueOf("GoogleCertificatesRslt: ");
      String str = String.valueOf(getErrorMessage());
      if (str.length() != 0) {}
      for (localObject = ((String)localObject).concat(str); this.cause != null; localObject = new String((String)localObject))
      {
        localObject = new SecurityException((String)localObject, this.cause);
        AppMethodBeat.o(5359);
        throw ((Throwable)localObject);
      }
      localObject = new SecurityException((String)localObject);
      AppMethodBeat.o(5359);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(5359);
  }
  
  final void zzi()
  {
    AppMethodBeat.i(5360);
    if (!this.zzbl)
    {
      if (this.cause != null)
      {
        getErrorMessage();
        AppMethodBeat.o(5360);
        return;
      }
      getErrorMessage();
    }
    AppMethodBeat.o(5360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.zzg
 * JD-Core Version:    0.7.0.1
 */