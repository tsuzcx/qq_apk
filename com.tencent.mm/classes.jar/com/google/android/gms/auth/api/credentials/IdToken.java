package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzuz;

public final class IdToken
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR = new zze();
  final int zzaiI;
  private final String zzajB;
  private final String zzaji;
  
  IdToken(int paramInt, String paramString1, String paramString2)
  {
    zzuz.zzct(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "id token string cannot be null or empty");
      this.zzaiI = paramInt;
      this.zzaji = paramString1;
      this.zzajB = paramString2;
      return;
    }
  }
  
  public IdToken(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
  }
  
  public final String getAccountType()
  {
    return this.zzaji;
  }
  
  public final String getIdToken()
  {
    return this.zzajB;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.IdToken
 * JD-Core Version:    0.7.0.1
 */