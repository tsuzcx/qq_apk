package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzxc
{
  private final String zzbnr = null;
  private final Uri zzbns;
  private final String zzbnt;
  private final String zzbnu;
  private final boolean zzbnv;
  private final boolean zzbnw;
  
  public zzxc(Uri paramUri)
  {
    this(null, paramUri, "", "", false, false);
  }
  
  private zzxc(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzbns = paramUri;
    this.zzbnt = paramString2;
    this.zzbnu = paramString3;
    this.zzbnv = false;
    this.zzbnw = false;
  }
  
  public final zzws<Double> zzb(String paramString, double paramDouble)
  {
    AppMethodBeat.i(69774);
    paramString = zzws.zzb(this, paramString, paramDouble);
    AppMethodBeat.o(69774);
    return paramString;
  }
  
  public final zzws<Integer> zzd(String paramString, int paramInt)
  {
    AppMethodBeat.i(69773);
    paramString = zzws.zzb(this, paramString, paramInt);
    AppMethodBeat.o(69773);
    return paramString;
  }
  
  public final zzws<Long> zze(String paramString, long paramLong)
  {
    AppMethodBeat.i(69771);
    paramString = zzws.zzb(this, paramString, paramLong);
    AppMethodBeat.o(69771);
    return paramString;
  }
  
  public final zzws<Boolean> zzf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(69772);
    paramString = zzws.zzb(this, paramString, paramBoolean);
    AppMethodBeat.o(69772);
    return paramString;
  }
  
  public final zzws<String> zzv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(69775);
    paramString1 = zzws.zzb(this, paramString1, paramString2);
    AppMethodBeat.o(69775);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxc
 * JD-Core Version:    0.7.0.1
 */