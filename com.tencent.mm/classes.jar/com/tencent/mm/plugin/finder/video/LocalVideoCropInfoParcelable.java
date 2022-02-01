package com.tencent.mm.plugin.finder.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmm;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "getCropInfo", "()Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "setCropInfo", "(Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "describeContents", "", "readParcel", "", "src", "writeToParcel", "dest", "flags", "CREATOR", "plugin-finder_release"})
public final class LocalVideoCropInfoParcelable
  implements Parcelable
{
  public static final a CREATOR;
  public bmm qDR;
  
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
    k.h(paramParcel, "src");
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    paramParcel = new bmm();
    paramParcel.parseFrom(arrayOfByte);
    this.qDR = paramParcel;
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
      if (this.qDR != null)
      {
        Object localObject = this.qDR;
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((bmm)localObject).toByteArray();
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray((byte[])localObject);
      }
      AppMethodBeat.o(168209);
      return;
    }
    AppMethodBeat.o(168209);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/video/LocalVideoCropInfoParcelable;", "plugin-finder_release"})
  public static final class a
    implements Parcelable.Creator<LocalVideoCropInfoParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable
 * JD-Core Version:    0.7.0.1
 */