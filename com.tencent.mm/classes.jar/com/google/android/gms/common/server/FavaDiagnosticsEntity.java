package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR;
  public static final String EXTRA_NAMESPACE = "namespace";
  public static final String EXTRA_TYPE_NUM = "typeNum";
  @SafeParcelable.Field(id=2)
  public final String namespace;
  @SafeParcelable.Field(id=3)
  public final int typeNum;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  
  static
  {
    AppMethodBeat.i(61437);
    CREATOR = new FavaDiagnosticsEntityCreator();
    AppMethodBeat.o(61437);
  }
  
  @SafeParcelable.Constructor
  public FavaDiagnosticsEntity(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt2)
  {
    this.zzal = paramInt1;
    this.namespace = paramString;
    this.typeNum = paramInt2;
  }
  
  public FavaDiagnosticsEntity(String paramString, int paramInt)
  {
    this.zzal = 1;
    this.namespace = paramString;
    this.typeNum = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61436);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeString(paramParcel, 2, this.namespace, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.typeNum);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(61436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.server.FavaDiagnosticsEntity
 * JD-Core Version:    0.7.0.1
 */