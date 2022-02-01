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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class TokenData
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<TokenData> CREATOR;
  private final Long zzaa;
  private final boolean zzab;
  private final boolean zzac;
  private final List<String> zzad;
  private final int zzy;
  private final String zzz;
  
  static
  {
    AppMethodBeat.i(10619);
    CREATOR = new zzn();
    AppMethodBeat.o(10619);
  }
  
  TokenData(int paramInt, String paramString, Long paramLong, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.TokenData
 * JD-Core Version:    0.7.0.1
 */