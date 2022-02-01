package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ConnectionInfoCreator")
public class ConnectionInfo
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ConnectionInfo> CREATOR;
  @SafeParcelable.Field(id=1)
  private Bundle zzsf;
  @SafeParcelable.Field(id=2)
  private Feature[] zzsg;
  
  static
  {
    AppMethodBeat.i(4608);
    CREATOR = new ConnectionInfoCreator();
    AppMethodBeat.o(4608);
  }
  
  public ConnectionInfo() {}
  
  @SafeParcelable.Constructor
  ConnectionInfo(@SafeParcelable.Param(id=1) Bundle paramBundle, @SafeParcelable.Param(id=2) Feature[] paramArrayOfFeature)
  {
    this.zzsf = paramBundle;
    this.zzsg = paramArrayOfFeature;
  }
  
  public Feature[] getAvailableFeatures()
  {
    return this.zzsg;
  }
  
  public Bundle getResolutionBundle()
  {
    return this.zzsf;
  }
  
  public ConnectionInfo setAvailableFeatures(Feature[] paramArrayOfFeature)
  {
    this.zzsg = paramArrayOfFeature;
    return this;
  }
  
  public ConnectionInfo setResolutionBundle(Bundle paramBundle)
  {
    this.zzsf = paramBundle;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4607);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 1, this.zzsf, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zzsg, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(4607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.ConnectionInfo
 * JD-Core Version:    0.7.0.1
 */