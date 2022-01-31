package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.e.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Set;

@SafeParcelable.Class(creator="AuthenticatorTransferInfoCreator")
public class zzw
  extends zzbs
{
  public static final Parcelable.Creator<zzw> CREATOR;
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbk;
  @SafeParcelable.Indicator
  private final Set<Integer> zzbl;
  @SafeParcelable.Field(getter="getAccountType", id=2)
  private String zzbx;
  @SafeParcelable.Field(getter="getStatus", id=3)
  private int zzby;
  @SafeParcelable.Field(getter="getTransferBytes", id=4)
  private byte[] zzbz;
  @SafeParcelable.Field(getter="getPendingIntent", id=5)
  private PendingIntent zzca;
  @SafeParcelable.Field(getter="getDeviceMetaData", id=6)
  private DeviceMetaData zzcb;
  @SafeParcelable.VersionField(id=1)
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(77031);
    CREATOR = new zzx();
    HashMap localHashMap = new HashMap();
    zzbk = localHashMap;
    localHashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
    zzbk.put("status", FastJsonResponse.Field.forInteger("status", 3));
    zzbk.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    AppMethodBeat.o(77031);
  }
  
  public zzw()
  {
    AppMethodBeat.i(77024);
    this.zzbl = new b(3);
    this.zzy = 1;
    AppMethodBeat.o(77024);
  }
  
  @SafeParcelable.Constructor
  zzw(@SafeParcelable.Indicator Set<Integer> paramSet, @SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) byte[] paramArrayOfByte, @SafeParcelable.Param(id=5) PendingIntent paramPendingIntent, @SafeParcelable.Param(id=6) DeviceMetaData paramDeviceMetaData)
  {
    this.zzbl = paramSet;
    this.zzy = paramInt1;
    this.zzbx = paramString;
    this.zzby = paramInt2;
    this.zzbz = paramArrayOfByte;
    this.zzca = paramPendingIntent;
    this.zzcb = paramDeviceMetaData;
  }
  
  public Object getFieldValue(FastJsonResponse.Field paramField)
  {
    AppMethodBeat.i(77027);
    int i;
    switch (paramField.getSafeParcelableFieldId())
    {
    default: 
      i = paramField.getSafeParcelableFieldId();
      paramField = new IllegalStateException(37 + "Unknown SafeParcelable id=" + i);
      AppMethodBeat.o(77027);
      throw paramField;
    case 1: 
      i = this.zzy;
      AppMethodBeat.o(77027);
      return Integer.valueOf(i);
    case 2: 
      paramField = this.zzbx;
      AppMethodBeat.o(77027);
      return paramField;
    case 3: 
      i = this.zzby;
      AppMethodBeat.o(77027);
      return Integer.valueOf(i);
    }
    paramField = this.zzbz;
    AppMethodBeat.o(77027);
    return paramField;
  }
  
  public boolean isFieldSet(FastJsonResponse.Field paramField)
  {
    AppMethodBeat.i(77026);
    boolean bool = this.zzbl.contains(Integer.valueOf(paramField.getSafeParcelableFieldId()));
    AppMethodBeat.o(77026);
    return bool;
  }
  
  public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77030);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(59 + "Field with id=" + i + " is not known to be an byte array.");
      AppMethodBeat.o(77030);
      throw paramField;
    }
    this.zzbz = paramArrayOfByte;
    this.zzbl.add(Integer.valueOf(i));
    AppMethodBeat.o(77030);
  }
  
  public void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    AppMethodBeat.i(77029);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(52 + "Field with id=" + i + " is not known to be an int.");
      AppMethodBeat.o(77029);
      throw paramField;
    }
    this.zzby = paramInt;
    this.zzbl.add(Integer.valueOf(i));
    AppMethodBeat.o(77029);
  }
  
  public void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    AppMethodBeat.i(77028);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(77028);
      throw paramField;
    }
    this.zzbx = paramString2;
    this.zzbl.add(Integer.valueOf(i));
    AppMethodBeat.o(77028);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(77025);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    Set localSet = this.zzbl;
    if (localSet.contains(Integer.valueOf(1))) {
      SafeParcelWriter.writeInt(paramParcel, 1, this.zzy);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      SafeParcelWriter.writeString(paramParcel, 2, this.zzbx, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      SafeParcelWriter.writeInt(paramParcel, 3, this.zzby);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      SafeParcelWriter.writeByteArray(paramParcel, 4, this.zzbz, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      SafeParcelWriter.writeParcelable(paramParcel, 5, this.zzca, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      SafeParcelWriter.writeParcelable(paramParcel, 6, this.zzcb, paramInt, true);
    }
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(77025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzw
 * JD-Core Version:    0.7.0.1
 */