package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import java.util.List;

public class TokenData
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<TokenData> CREATOR = new zzf();
  final int zzaiI;
  private final String zzaiJ;
  private final Long zzaiK;
  private final boolean zzaiL;
  private final boolean zzaiM;
  private final List<String> zzaiN;
  
  TokenData(int paramInt, String paramString, Long paramLong, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList)
  {
    this.zzaiI = paramInt;
    this.zzaiJ = zzac.zzdr(paramString);
    this.zzaiK = paramLong;
    this.zzaiL = paramBoolean1;
    this.zzaiM = paramBoolean2;
    this.zzaiN = paramList;
  }
  
  public static TokenData zzd(Bundle paramBundle, String paramString)
  {
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    paramBundle = paramBundle.getBundle(paramString);
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    return (TokenData)paramBundle.getParcelable("TokenData");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TokenData)) {}
    do
    {
      return false;
      paramObject = (TokenData)paramObject;
    } while ((!TextUtils.equals(this.zzaiJ, paramObject.zzaiJ)) || (!zzaa.equal(this.zzaiK, paramObject.zzaiK)) || (this.zzaiL != paramObject.zzaiL) || (this.zzaiM != paramObject.zzaiM) || (!zzaa.equal(this.zzaiN, paramObject.zzaiN)));
    return true;
  }
  
  public String getToken()
  {
    return this.zzaiJ;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzaiJ, this.zzaiK, Boolean.valueOf(this.zzaiL), Boolean.valueOf(this.zzaiM), this.zzaiN });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public Long zzqO()
  {
    return this.zzaiK;
  }
  
  public boolean zzqP()
  {
    return this.zzaiL;
  }
  
  public boolean zzqQ()
  {
    return this.zzaiM;
  }
  
  public List<String> zzqR()
  {
    return this.zzaiN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.TokenData
 * JD-Core Version:    0.7.0.1
 */