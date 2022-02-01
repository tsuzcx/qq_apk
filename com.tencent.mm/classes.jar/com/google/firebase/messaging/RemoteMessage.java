package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

@SafeParcelable.Class(creator="RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RemoteMessage> CREATOR;
  @SafeParcelable.Field(id=2)
  public Bundle bCp;
  public Map<String, String> bCq;
  
  static
  {
    AppMethodBeat.i(116787);
    CREATOR = new e();
    AppMethodBeat.o(116787);
  }
  
  @SafeParcelable.Constructor
  public RemoteMessage(@SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.bCp = paramBundle;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(116786);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, this.bCp, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(116786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.messaging.RemoteMessage
 * JD-Core Version:    0.7.0.1
 */