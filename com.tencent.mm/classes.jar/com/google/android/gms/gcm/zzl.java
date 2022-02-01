package com.google.android.gms.gcm;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzl
{
  public static final zzl zzao;
  private static final zzl zzap;
  private final int zzaq;
  private final int zzar;
  private final int zzas;
  
  static
  {
    AppMethodBeat.i(3712);
    zzao = new zzl(0, 30, 3600);
    zzap = new zzl(1, 30, 3600);
    AppMethodBeat.o(3712);
  }
  
  private zzl(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzaq = paramInt1;
    this.zzar = 30;
    this.zzas = 3600;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzl)) {
        return false;
      }
      paramObject = (zzl)paramObject;
    } while ((paramObject.zzaq == this.zzaq) && (paramObject.zzar == this.zzar) && (paramObject.zzas == this.zzas));
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.zzaq + 1 ^ 0xF4243) * 1000003 ^ this.zzar) * 1000003 ^ this.zzas;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(3711);
    int i = this.zzaq;
    int j = this.zzar;
    int k = this.zzas;
    String str = 74 + "policy=" + i + " initial_backoff=" + j + " maximum_backoff=" + k;
    AppMethodBeat.o(3711);
    return str;
  }
  
  public final Bundle zzf(Bundle paramBundle)
  {
    AppMethodBeat.i(3710);
    paramBundle.putInt("retry_policy", this.zzaq);
    paramBundle.putInt("initial_backoff_seconds", this.zzar);
    paramBundle.putInt("maximum_backoff_seconds", this.zzas);
    AppMethodBeat.o(3710);
    return paramBundle;
  }
  
  public final int zzh()
  {
    return this.zzaq;
  }
  
  public final int zzi()
  {
    return this.zzar;
  }
  
  public final int zzj()
  {
    return this.zzas;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.zzl
 * JD-Core Version:    0.7.0.1
 */