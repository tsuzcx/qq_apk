package com.google.android.gms.signin.internal;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator="CheckServerAuthResultCreator")
public class CheckServerAuthResult
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CheckServerAuthResult> CREATOR;
  @SafeParcelable.Field(id=2)
  private final boolean zzadp;
  @SafeParcelable.Field(id=3)
  private final List<Scope> zzadq;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  
  static
  {
    AppMethodBeat.i(12152);
    CREATOR = new CheckServerAuthResultCreator();
    AppMethodBeat.o(12152);
  }
  
  @SafeParcelable.Constructor
  CheckServerAuthResult(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) boolean paramBoolean, @SafeParcelable.Param(id=3) List<Scope> paramList)
  {
    this.zzal = paramInt;
    this.zzadp = paramBoolean;
    this.zzadq = paramList;
  }
  
  public CheckServerAuthResult(boolean paramBoolean, Set<Scope> paramSet) {}
  
  public Set<Scope> getAdditionalScopes()
  {
    AppMethodBeat.i(12150);
    HashSet localHashSet = new HashSet(this.zzadq);
    AppMethodBeat.o(12150);
    return localHashSet;
  }
  
  public boolean isNewAuthCodeRequired()
  {
    return this.zzadp;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(12151);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzadp);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzadq, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(12151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.signin.internal.CheckServerAuthResult
 * JD-Core Version:    0.7.0.1
 */