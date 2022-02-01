package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@SafeParcelable.Class(creator="TokenDataCreator")
public class TokenData
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<TokenData> CREATOR;
  @SafeParcelable.Field(getter="getExpirationTimeSecs", id=3)
  private final Long zzaa;
  @SafeParcelable.Field(getter="isCached", id=4)
  private final boolean zzab;
  @SafeParcelable.Field(getter="isSnowballed", id=5)
  private final boolean zzac;
  @SafeParcelable.Field(getter="getGrantedScopes", id=6)
  private final List<String> zzad;
  @SafeParcelable.VersionField(id=1)
  private final int zzy;
  @SafeParcelable.Field(getter="getToken", id=2)
  private final String zzz;
  
  static
  {
    AppMethodBeat.i(10619);
    CREATOR = new zzn();
    AppMethodBeat.o(10619);
  }
  
  @SafeParcelable.Constructor
  TokenData(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) Long paramLong, @SafeParcelable.Param(id=4) boolean paramBoolean1, @SafeParcelable.Param(id=5) boolean paramBoolean2, @SafeParcelable.Param(id=6) List<String> paramList)
  {
    AppMethodBeat.i(10615);
    this.zzy = paramInt;
    this.zzz = Preconditions.checkNotEmpty(paramString);
    this.zzaa = paramLong;
    this.zzab = paramBoolean1;
    this.zzac = paramBoolean2;
    this.zzad = paramList;
    AppMethodBeat.o(10615);
  }
  
  public static TokenData zzd(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(10614);
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    paramBundle = paramBundle.getBundle(paramString);
    if (paramBundle == null)
    {
      AppMethodBeat.o(10614);
      return null;
    }
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    paramBundle = (TokenData)paramBundle.getParcelable("TokenData");
    AppMethodBeat.o(10614);
    return paramBundle;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10616);
    if (!(paramObject instanceof TokenData))
    {
      AppMethodBeat.o(10616);
      return false;
    }
    paramObject = (TokenData)paramObject;
    if ((TextUtils.equals(this.zzz, paramObject.zzz)) && (Objects.equal(this.zzaa, paramObject.zzaa)) && (this.zzab == paramObject.zzab) && (this.zzac == paramObject.zzac) && (Objects.equal(this.zzad, paramObject.zzad)))
    {
      AppMethodBeat.o(10616);
      return true;
    }
    AppMethodBeat.o(10616);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(10617);
    int i = Objects.hashCode(new Object[] { this.zzz, this.zzaa, Boolean.valueOf(this.zzab), Boolean.valueOf(this.zzac), this.zzad });
    AppMethodBeat.o(10617);
    return i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10618);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzz, false);
    SafeParcelWriter.writeLongObject(paramParcel, 3, this.zzaa, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzab);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzac);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzad, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(10618);
  }
  
  public final String zze()
  {
    return this.zzz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.TokenData
 * JD-Core Version:    0.7.0.1
 */