package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class EventMessage
  implements Metadata.Entry
{
  public static final Parcelable.Creator<EventMessage> CREATOR;
  public final String aNO;
  public final long aNP;
  public final byte[] aNQ;
  private int axc;
  public final long id;
  public final String value;
  
  static
  {
    AppMethodBeat.i(95272);
    CREATOR = new EventMessage.1();
    AppMethodBeat.o(95272);
  }
  
  EventMessage(Parcel paramParcel)
  {
    AppMethodBeat.i(95268);
    this.aNO = paramParcel.readString();
    this.value = paramParcel.readString();
    this.aNP = paramParcel.readLong();
    this.id = paramParcel.readLong();
    this.aNQ = paramParcel.createByteArray();
    AppMethodBeat.o(95268);
  }
  
  public EventMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.aNO = paramString1;
    this.value = paramString2;
    this.aNP = paramLong1;
    this.id = paramLong2;
    this.aNQ = paramArrayOfByte;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95270);
    if (this == paramObject)
    {
      AppMethodBeat.o(95270);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95270);
      return false;
    }
    paramObject = (EventMessage)paramObject;
    if ((this.aNP == paramObject.aNP) && (this.id == paramObject.id) && (x.e(this.aNO, paramObject.aNO)) && (x.e(this.value, paramObject.value)) && (Arrays.equals(this.aNQ, paramObject.aNQ)))
    {
      AppMethodBeat.o(95270);
      return true;
    }
    AppMethodBeat.o(95270);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(95269);
    if (this.axc == 0) {
      if (this.aNO == null) {
        break label115;
      }
    }
    label115:
    for (int i = this.aNO.hashCode();; i = 0)
    {
      if (this.value != null) {
        j = this.value.hashCode();
      }
      this.axc = (((((i + 527) * 31 + j) * 31 + (int)(this.aNP ^ this.aNP >>> 32)) * 31 + (int)(this.id ^ this.id >>> 32)) * 31 + Arrays.hashCode(this.aNQ));
      i = this.axc;
      AppMethodBeat.o(95269);
      return i;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(95271);
    paramParcel.writeString(this.aNO);
    paramParcel.writeString(this.value);
    paramParcel.writeLong(this.aNP);
    paramParcel.writeLong(this.id);
    paramParcel.writeByteArray(this.aNQ);
    AppMethodBeat.o(95271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.EventMessage
 * JD-Core Version:    0.7.0.1
 */