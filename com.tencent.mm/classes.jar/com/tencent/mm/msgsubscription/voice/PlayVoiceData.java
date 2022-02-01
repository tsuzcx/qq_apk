package com.tencent.mm.msgsubscription.voice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "url", "", "action", "", "(JLjava/lang/String;I)V", "getAction", "()I", "getId", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PlayVoiceData
  implements Parcelable
{
  public static final a CREATOR;
  final int action;
  final long id;
  final String url;
  
  static
  {
    AppMethodBeat.i(236478);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(236478);
  }
  
  public PlayVoiceData(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(236464);
    this.id = paramLong;
    this.url = paramString;
    this.action = paramInt;
    AppMethodBeat.o(236464);
  }
  
  public PlayVoiceData(Parcel paramParcel)
  {
    this(l, str, paramParcel.readInt());
    AppMethodBeat.i(236472);
    AppMethodBeat.o(236472);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(236497);
    if (this == paramObject)
    {
      AppMethodBeat.o(236497);
      return true;
    }
    if (!(paramObject instanceof PlayVoiceData))
    {
      AppMethodBeat.o(236497);
      return false;
    }
    paramObject = (PlayVoiceData)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(236497);
      return false;
    }
    if (!s.p(this.url, paramObject.url))
    {
      AppMethodBeat.o(236497);
      return false;
    }
    if (this.action != paramObject.action)
    {
      AppMethodBeat.o(236497);
      return false;
    }
    AppMethodBeat.o(236497);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(236494);
    int i = q.a..ExternalSyntheticBackport0.m(this.id);
    int j = this.url.hashCode();
    int k = this.action;
    AppMethodBeat.o(236494);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(236490);
    String str = "PlayVoiceData(id=" + this.id + ", url=" + this.url + ", action=" + this.action + ')';
    AppMethodBeat.o(236490);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(236483);
    s.u(paramParcel, "parcel");
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.action);
    AppMethodBeat.o(236483);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData;", "()V", "ACTION_PLAY", "", "ACTION_STOP", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<PlayVoiceData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.voice.PlayVoiceData
 * JD-Core Version:    0.7.0.1
 */