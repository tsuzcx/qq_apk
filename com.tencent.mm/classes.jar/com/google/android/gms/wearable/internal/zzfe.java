package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.wearable.MessageEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfe
  extends AbstractSafeParcelable
  implements MessageEvent
{
  public static final Parcelable.Creator<zzfe> CREATOR;
  private final byte[] data;
  private final String zzcl;
  private final int zzeh;
  private final String zzek;
  
  static
  {
    AppMethodBeat.i(101295);
    CREATOR = new zzff();
    AppMethodBeat.o(101295);
  }
  
  public zzfe(int paramInt, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.zzeh = paramInt;
    this.zzcl = paramString1;
    this.data = paramArrayOfByte;
    this.zzek = paramString2;
  }
  
  public final byte[] getData()
  {
    return this.data;
  }
  
  public final String getPath()
  {
    return this.zzcl;
  }
  
  public final int getRequestId()
  {
    return this.zzeh;
  }
  
  public final String getSourceNodeId()
  {
    return this.zzek;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101294);
    int i = this.zzeh;
    String str = this.zzcl;
    if (this.data == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.data.length))
    {
      localObject = String.valueOf(localObject);
      localObject = String.valueOf(str).length() + 43 + String.valueOf(localObject).length() + "MessageEventParcelable[" + i + "," + str + ", size=" + (String)localObject + "]";
      AppMethodBeat.o(101294);
      return localObject;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101293);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, getRequestId());
    SafeParcelWriter.writeString(paramParcel, 3, getPath(), false);
    SafeParcelWriter.writeByteArray(paramParcel, 4, getData(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getSourceNodeId(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(101293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfe
 * JD-Core Version:    0.7.0.1
 */