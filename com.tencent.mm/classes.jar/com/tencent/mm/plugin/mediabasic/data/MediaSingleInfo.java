package com.tencent.mm.plugin.mediabasic.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabasic/data/MediaSingleInfo;", "Landroid/os/Parcelable;", "type", "Lcom/tencent/mm/plugin/mediabasic/data/MediaBasicType;", "path", "", "durationInfo", "Lcom/tencent/mm/plugin/mediabasic/data/MediaDurationInfo;", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaBasicType;Ljava/lang/String;Lcom/tencent/mm/plugin/mediabasic/data/MediaDurationInfo;)V", "getDurationInfo", "()Lcom/tencent/mm/plugin/mediabasic/data/MediaDurationInfo;", "setDurationInfo", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaDurationInfo;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getType", "()Lcom/tencent/mm/plugin/mediabasic/data/MediaBasicType;", "setType", "(Lcom/tencent/mm/plugin/mediabasic/data/MediaBasicType;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-basic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MediaSingleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MediaSingleInfo> CREATOR;
  public static final MediaSingleInfo.a KOM;
  public a KON;
  public MediaDurationInfo KOO;
  public String path;
  
  static
  {
    AppMethodBeat.i(269623);
    KOM = new MediaSingleInfo.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(269623);
  }
  
  public MediaSingleInfo(a parama, String paramString, MediaDurationInfo paramMediaDurationInfo)
  {
    AppMethodBeat.i(269614);
    this.KON = parama;
    this.path = paramString;
    this.KOO = paramMediaDurationInfo;
    AppMethodBeat.o(269614);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(269641);
    if (this == paramObject)
    {
      AppMethodBeat.o(269641);
      return true;
    }
    if (!(paramObject instanceof MediaSingleInfo))
    {
      AppMethodBeat.o(269641);
      return false;
    }
    paramObject = (MediaSingleInfo)paramObject;
    if (this.KON != paramObject.KON)
    {
      AppMethodBeat.o(269641);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(269641);
      return false;
    }
    if (!s.p(this.KOO, paramObject.KOO))
    {
      AppMethodBeat.o(269641);
      return false;
    }
    AppMethodBeat.o(269641);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(269631);
    int i = this.KON.hashCode();
    int j = this.path.hashCode();
    int k = this.KOO.hashCode();
    AppMethodBeat.o(269631);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(269627);
    String str = "MediaSingleInfo(type=" + this.KON + ", path=" + this.path + ", durationInfo=" + this.KOO + ')';
    AppMethodBeat.o(269627);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269651);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.KON.name());
    paramParcel.writeString(this.path);
    this.KOO.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(269651);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<MediaSingleInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabasic.data.MediaSingleInfo
 * JD-Core Version:    0.7.0.1
 */