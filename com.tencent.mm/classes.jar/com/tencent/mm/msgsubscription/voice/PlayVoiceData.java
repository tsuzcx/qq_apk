package com.tencent.mm.msgsubscription.voice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "url", "", "action", "", "(JLjava/lang/String;I)V", "getAction", "()I", "getId", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "wxbiz-msgsubscription-sdk_release"})
public final class PlayVoiceData
  implements Parcelable
{
  public static final a CREATOR;
  final int action;
  final long id;
  final String url;
  
  static
  {
    AppMethodBeat.i(263508);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(263508);
  }
  
  public PlayVoiceData(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(263506);
    this.id = paramLong;
    this.url = paramString;
    this.action = paramInt;
    AppMethodBeat.o(263506);
  }
  
  public PlayVoiceData(Parcel paramParcel)
  {
    this(l, str, paramParcel.readInt());
    AppMethodBeat.i(263507);
    AppMethodBeat.o(263507);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(263511);
    if (this != paramObject)
    {
      if ((paramObject instanceof PlayVoiceData))
      {
        paramObject = (PlayVoiceData)paramObject;
        if ((this.id != paramObject.id) || (!p.h(this.url, paramObject.url)) || (this.action != paramObject.action)) {}
      }
    }
    else
    {
      AppMethodBeat.o(263511);
      return true;
    }
    AppMethodBeat.o(263511);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(263510);
    long l = this.id;
    int j = (int)(l ^ l >>> 32);
    String str = this.url;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int k = this.action;
      AppMethodBeat.o(263510);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(263509);
    String str = "PlayVoiceData(id=" + this.id + ", url=" + this.url + ", action=" + this.action + ")";
    AppMethodBeat.o(263509);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(263504);
    p.k(paramParcel, "parcel");
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.action);
    AppMethodBeat.o(263504);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData;", "()V", "ACTION_PLAY", "", "ACTION_STOP", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mm/msgsubscription/voice/PlayVoiceData;", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
    implements Parcelable.Creator<PlayVoiceData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.voice.PlayVoiceData
 * JD-Core Version:    0.7.0.1
 */