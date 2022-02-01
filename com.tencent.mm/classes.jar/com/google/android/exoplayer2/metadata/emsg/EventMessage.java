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
  private int aHQ;
  public final String buo;
  public final long bup;
  public final byte[] buq;
  public final long id;
  public final String value;
  
  static
  {
    AppMethodBeat.i(92394);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92394);
  }
  
  EventMessage(Parcel paramParcel)
  {
    AppMethodBeat.i(92390);
    this.buo = paramParcel.readString();
    this.value = paramParcel.readString();
    this.bup = paramParcel.readLong();
    this.id = paramParcel.readLong();
    this.buq = paramParcel.createByteArray();
    AppMethodBeat.o(92390);
  }
  
  public EventMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.buo = paramString1;
    this.value = paramString2;
    this.bup = paramLong1;
    this.id = paramLong2;
    this.buq = paramArrayOfByte;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92392);
    if (this == paramObject)
    {
      AppMethodBeat.o(92392);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92392);
      return false;
    }
    paramObject = (EventMessage)paramObject;
    if ((this.bup == paramObject.bup) && (this.id == paramObject.id) && (x.i(this.buo, paramObject.buo)) && (x.i(this.value, paramObject.value)) && (Arrays.equals(this.buq, paramObject.buq)))
    {
      AppMethodBeat.o(92392);
      return true;
    }
    AppMethodBeat.o(92392);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(92391);
    if (this.aHQ == 0) {
      if (this.buo == null) {
        break label115;
      }
    }
    label115:
    for (int i = this.buo.hashCode();; i = 0)
    {
      if (this.value != null) {
        j = this.value.hashCode();
      }
      this.aHQ = (((((i + 527) * 31 + j) * 31 + (int)(this.bup ^ this.bup >>> 32)) * 31 + (int)(this.id ^ this.id >>> 32)) * 31 + Arrays.hashCode(this.buq));
      i = this.aHQ;
      AppMethodBeat.o(92391);
      return i;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92393);
    paramParcel.writeString(this.buo);
    paramParcel.writeString(this.value);
    paramParcel.writeLong(this.bup);
    paramParcel.writeLong(this.id);
    paramParcel.writeByteArray(this.buq);
    AppMethodBeat.o(92393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.EventMessage
 * JD-Core Version:    0.7.0.1
 */