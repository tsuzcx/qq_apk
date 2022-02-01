package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FavaDiagnosticsEntity
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR;
  public static final String EXTRA_NAMESPACE = "namespace";
  public static final String EXTRA_TYPE_NUM = "typeNum";
  public final String namespace;
  public final int typeNum;
  private final int zzal;
  
  static
  {
    AppMethodBeat.i(11929);
    CREATOR = new FavaDiagnosticsEntityCreator();
    AppMethodBeat.o(11929);
  }
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
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
    AppMethodBeat.i(11928);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeString(paramParcel, 2, this.namespace, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.typeNum);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(11928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.FavaDiagnosticsEntity
 * JD-Core Version:    0.7.0.1
 */