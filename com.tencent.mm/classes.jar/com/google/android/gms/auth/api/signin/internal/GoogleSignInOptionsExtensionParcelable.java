package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension.TypeId;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="GoogleSignInOptionsExtensionCreator")
public class GoogleSignInOptionsExtensionParcelable
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR;
  @SafeParcelable.Field(getter="getBundle", id=3)
  private Bundle mBundle;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(getter="getType", id=2)
  private int zzac;
  
  static
  {
    AppMethodBeat.i(60388);
    CREATOR = new GoogleSignInOptionsExtensionCreator();
    AppMethodBeat.o(60388);
  }
  
  @SafeParcelable.Constructor
  GoogleSignInOptionsExtensionParcelable(@SafeParcelable.Param(id=1) int paramInt1, @GoogleSignInOptionsExtension.TypeId @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) Bundle paramBundle)
  {
    this.versionCode = paramInt1;
    this.zzac = paramInt2;
    this.mBundle = paramBundle;
  }
  
  public GoogleSignInOptionsExtensionParcelable(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    this(1, paramGoogleSignInOptionsExtension.getExtensionType(), paramGoogleSignInOptionsExtension.toBundle());
    AppMethodBeat.i(60386);
    AppMethodBeat.o(60386);
  }
  
  public Bundle getBundle()
  {
    return this.mBundle;
  }
  
  @GoogleSignInOptionsExtension.TypeId
  public int getType()
  {
    return this.zzac;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(60387);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeInt(paramParcel, 2, getType());
    SafeParcelWriter.writeBundle(paramParcel, 3, getBundle(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(60387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable
 * JD-Core Version:    0.7.0.1
 */