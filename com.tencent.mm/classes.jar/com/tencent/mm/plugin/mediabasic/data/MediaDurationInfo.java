package com.tencent.mm.plugin.mediabasic.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaDurationInfo;", "Landroid/os/Parcelable;", "startMs", "", "endMs", "(JJ)V", "getEndMs", "()J", "setEndMs", "(J)V", "getStartMs", "setStartMs", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getDuration", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MediaDurationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaDurationInfo> CREATOR;
  public static final MediaDurationInfo.a KOE;
  public long endMs;
  public long startMs;
  
  static
  {
    AppMethodBeat.i(269647);
    KOE = new MediaDurationInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(269647);
  }
  
  public MediaDurationInfo(long paramLong1, long paramLong2)
  {
    this.startMs = paramLong1;
    this.endMs = paramLong2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MediaDurationInfo)) {
        return false;
      }
      paramObject = (MediaDurationInfo)paramObject;
      if (this.startMs != paramObject.startMs) {
        return false;
      }
    } while (this.endMs == paramObject.endMs);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269661);
    int i = q.a..ExternalSyntheticBackport0.m(this.startMs);
    int j = q.a..ExternalSyntheticBackport0.m(this.endMs);
    AppMethodBeat.o(269661);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269655);
    String str = "MediaDurationInfo(startMs=" + this.startMs + ", endMs=" + this.endMs + ')';
    AppMethodBeat.o(269655);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269678);
    s.u(paramParcel, "out");
    paramParcel.writeLong(this.startMs);
    paramParcel.writeLong(this.endMs);
    AppMethodBeat.o(269678);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<MediaDurationInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.MediaDurationInfo
 * JD-Core Version:    0.7.0.1
 */