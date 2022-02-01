package com.google.android.gms.common.internal;

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

@SafeParcelable.Class(creator="ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
public class ClientIdentity
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ClientIdentity> CREATOR;
  @SafeParcelable.Field(defaultValueUnchecked="null", id=2)
  public final String packageName;
  @SafeParcelable.Field(defaultValueUnchecked="0", id=1)
  public final int uid;
  
  static
  {
    AppMethodBeat.i(11804);
    CREATOR = new ClientIdentityCreator();
    AppMethodBeat.o(11804);
  }
  
  @SafeParcelable.Constructor
  public ClientIdentity(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString)
  {
    this.uid = paramInt;
    this.packageName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(11801);
    if (paramObject == this)
    {
      AppMethodBeat.o(11801);
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof ClientIdentity)))
    {
      AppMethodBeat.o(11801);
      return false;
    }
    paramObject = (ClientIdentity)paramObject;
    if ((paramObject.uid == this.uid) && (Objects.equal(paramObject.packageName, this.packageName)))
    {
      AppMethodBeat.o(11801);
      return true;
    }
    AppMethodBeat.o(11801);
    return false;
  }
  
  public int hashCode()
  {
    return this.uid;
  }
  
  public String toString()
  {
    AppMethodBeat.i(11802);
    int i = this.uid;
    String str = this.packageName;
    str = String.valueOf(str).length() + 12 + i + ":" + str;
    AppMethodBeat.o(11802);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11803);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.uid);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(11803);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.ClientIdentity
 * JD-Core Version:    0.7.0.1
 */