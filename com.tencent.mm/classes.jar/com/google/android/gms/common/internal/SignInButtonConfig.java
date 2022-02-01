package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="SignInButtonConfigCreator")
public class SignInButtonConfig
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInButtonConfig> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @Deprecated
  @SafeParcelable.Field(getter="getScopes", id=4)
  private final Scope[] zzqw;
  @SafeParcelable.Field(getter="getButtonSize", id=2)
  private final int zzux;
  @SafeParcelable.Field(getter="getColorScheme", id=3)
  private final int zzuy;
  
  static
  {
    AppMethodBeat.i(11866);
    CREATOR = new SignInButtonConfigCreator();
    AppMethodBeat.o(11866);
  }
  
  @SafeParcelable.Constructor
  SignInButtonConfig(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) Scope[] paramArrayOfScope)
  {
    this.zzal = paramInt1;
    this.zzux = paramInt2;
    this.zzuy = paramInt3;
    this.zzqw = paramArrayOfScope;
  }
  
  public SignInButtonConfig(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    this(1, paramInt1, paramInt2, null);
  }
  
  public int getButtonSize()
  {
    return this.zzux;
  }
  
  public int getColorScheme()
  {
    return this.zzuy;
  }
  
  @Deprecated
  public Scope[] getScopes()
  {
    return this.zzqw;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11865);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeInt(paramParcel, 2, getButtonSize());
    SafeParcelWriter.writeInt(paramParcel, 3, getColorScheme());
    SafeParcelWriter.writeTypedArray(paramParcel, 4, getScopes(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(11865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonConfig
 * JD-Core Version:    0.7.0.1
 */