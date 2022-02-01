package com.tencent.mm.plugin.finder.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjx;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "getCropInfo", "()Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "setCropInfo", "(Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "describeContents", "", "readParcel", "", "src", "writeToParcel", "dest", "flags", "CREATOR", "plugin-finder_release"})
public final class LocalVideoCropInfoParcelable
  implements Parcelable
{
  public static final a CREATOR;
  public cjx uOR;
  
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
    p.h(paramParcel, "src");
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    paramParcel = new cjx();
    paramParcel.parseFrom(arrayOfByte);
    this.uOR = paramParcel;
    AppMethodBeat.o(168210);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(168209);
    if (paramParcel != null)
    {
      if (this.uOR != null)
      {
        Object localObject = this.uOR;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((cjx)localObject).toByteArray();
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray((byte[])localObject);
      }
      AppMethodBeat.o(168209);
      return;
    }
    AppMethodBeat.o(168209);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "plugin-finder_release"})
  public static final class a
    implements Parcelable.Creator<LocalVideoCropInfoParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable
 * JD-Core Version:    0.7.0.1
 */