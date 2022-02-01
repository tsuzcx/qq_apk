package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.b.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzbs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Set;

public class zzw
  extends zzbs
{
  public static final Parcelable.Creator<zzw> CREATOR;
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbk;
  private final Set<Integer> zzbl;
  private String zzbx;
  private int zzby;
  private byte[] zzbz;
  private PendingIntent zzca;
  private DeviceMetaData zzcb;
  private final int zzy;
  
  static
  {
    AppMethodBeat.i(10690);
    CREATOR = new zzx();
    HashMap localHashMap = new HashMap();
    zzbk = localHashMap;
    localHashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
    zzbk.put("status", FastJsonResponse.Field.forInteger("status", 3));
    zzbk.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    AppMethodBeat.o(10690);
  }
  
  public zzw()
  {
    AppMethodBeat.i(10683);
    this.zzbl = new b(3);
    this.zzy = 1;
    AppMethodBeat.o(10683);
  }
  
  zzw(Set<Integer> paramSet, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, PendingIntent paramPendingIntent, DeviceMetaData paramDeviceMetaData)
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
    AppMethodBeat.i(10686);
    int i;
    switch (paramField.getSafeParcelableFieldId())
    {
    default: 
      i = paramField.getSafeParcelableFieldId();
      paramField = new IllegalStateException(37 + "Unknown SafeParcelable id=" + i);
      AppMethodBeat.o(10686);
      throw paramField;
    case 1: 
      i = this.zzy;
      AppMethodBeat.o(10686);
      return Integer.valueOf(i);
    case 2: 
      paramField = this.zzbx;
      AppMethodBeat.o(10686);
      return paramField;
    case 3: 
      i = this.zzby;
      AppMethodBeat.o(10686);
      return Integer.valueOf(i);
    }
    paramField = this.zzbz;
    AppMethodBeat.o(10686);
    return paramField;
  }
  
  public boolean isFieldSet(FastJsonResponse.Field paramField)
  {
    AppMethodBeat.i(10685);
    boolean bool = this.zzbl.contains(Integer.valueOf(paramField.getSafeParcelableFieldId()));
    AppMethodBeat.o(10685);
    return bool;
  }
  
  public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10689);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(59 + "Field with id=" + i + " is not known to be an byte array.");
      AppMethodBeat.o(10689);
      throw paramField;
    }
    this.zzbz = paramArrayOfByte;
    this.zzbl.add(Integer.valueOf(i));
    AppMethodBeat.o(10689);
  }
  
  public void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    AppMethodBeat.i(10688);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(52 + "Field with id=" + i + " is not known to be an int.");
      AppMethodBeat.o(10688);
      throw paramField;
    }
    this.zzby = paramInt;
    this.zzbl.add(Integer.valueOf(i));
    AppMethodBeat.o(10688);
  }
  
  public void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    AppMethodBeat.i(10687);
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default: 
      paramField = new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(10687);
      throw paramField;
    }
    this.zzbx = paramString2;
    this.zzbl.add(Integer.valueOf(i));
    AppMethodBeat.o(10687);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10684);
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
    AppMethodBeat.o(10684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzw
 * JD-Core Version:    0.7.0.1
 */