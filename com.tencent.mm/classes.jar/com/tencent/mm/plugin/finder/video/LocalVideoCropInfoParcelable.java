package com.tencent.mm.plugin.finder.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dju;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "getCropInfo", "()Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "setCropInfo", "(Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "describeContents", "", "readParcel", "", "src", "writeToParcel", "dest", "flags", "CREATOR", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LocalVideoCropInfoParcelable
  implements Parcelable
{
  public static final a CREATOR;
  public dju EDC;
  
  static
  {
    AppMethodBeat.i(168211);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(168211);
  }
  
  public LocalVideoCropInfoParcelable() {}
  
  public LocalVideoCropInfoParcelable(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(168210);
    s.u(paramParcel, "src");
    Object localObject = new byte[paramParcel.readInt()];
    paramParcel.readByteArray((byte[])localObject);
    paramParcel = new dju();
    paramParcel.parseFrom((byte[])localObject);
    localObject = ah.aiuX;
    this.EDC = paramParcel;
    AppMethodBeat.o(168210);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(168209);
    if ((paramParcel != null) && (this.EDC != null))
    {
      Object localObject = this.EDC;
      s.checkNotNull(localObject);
      localObject = ((dju)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
    }
    AppMethodBeat.o(168209);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LocalVideoCropInfoParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable
 * JD-Core Version:    0.7.0.1
 */