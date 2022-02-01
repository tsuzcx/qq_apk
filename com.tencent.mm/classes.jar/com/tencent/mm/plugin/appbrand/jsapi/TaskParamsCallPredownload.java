package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "path", "scene", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getPath", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class TaskParamsCallPredownload
  implements Parcelable
{
  public static final Parcelable.Creator<TaskParamsCallPredownload> CREATOR;
  public static final a kaJ;
  final String path;
  final int scene;
  final String username;
  
  static
  {
    AppMethodBeat.i(50426);
    kaJ = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(50426);
  }
  
  public TaskParamsCallPredownload(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt());
    AppMethodBeat.i(50425);
    AppMethodBeat.o(50425);
  }
  
  public TaskParamsCallPredownload(String paramString1, String paramString2, int paramInt)
  {
    this.username = paramString1;
    this.path = paramString2;
    this.scene = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(50429);
    if (this != paramObject)
    {
      if ((paramObject instanceof TaskParamsCallPredownload))
      {
        paramObject = (TaskParamsCallPredownload)paramObject;
        if ((!k.g(this.username, paramObject.username)) || (!k.g(this.path, paramObject.path)) || (this.scene != paramObject.scene)) {}
      }
    }
    else
    {
      AppMethodBeat.o(50429);
      return true;
    }
    AppMethodBeat.o(50429);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(50428);
    String str = this.username;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.path;
      if (str != null) {
        j = str.hashCode();
      }
      int k = this.scene;
      AppMethodBeat.o(50428);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50427);
    String str = "TaskParamsCallPredownload(username=" + this.username + ", path=" + this.path + ", scene=" + this.scene + ")";
    AppMethodBeat.o(50427);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50424);
    k.h(paramParcel, "dest");
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.path);
    paramParcel.writeInt(this.scene);
    AppMethodBeat.o(50424);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "plugin-appbrand-integration_release"})
  public static final class b
    implements Parcelable.Creator<TaskParamsCallPredownload>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.TaskParamsCallPredownload
 * JD-Core Version:    0.7.0.1
 */