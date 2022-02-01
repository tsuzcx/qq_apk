package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites$DoFavoriteParams;", "Landroid/os/Parcelable;", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class JsApiAddVideoToFavorites$DoFavoriteParams
  implements Parcelable
{
  public static final Parcelable.Creator<DoFavoriteParams> CREATOR;
  final String thumbPath;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(325617);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(325617);
  }
  
  public JsApiAddVideoToFavorites$DoFavoriteParams(String paramString1, String paramString2)
  {
    AppMethodBeat.i(325616);
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    AppMethodBeat.o(325616);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(325625);
    if (this == paramObject)
    {
      AppMethodBeat.o(325625);
      return true;
    }
    if (!(paramObject instanceof DoFavoriteParams))
    {
      AppMethodBeat.o(325625);
      return false;
    }
    paramObject = (DoFavoriteParams)paramObject;
    if (!s.p(this.videoPath, paramObject.videoPath))
    {
      AppMethodBeat.o(325625);
      return false;
    }
    if (!s.p(this.thumbPath, paramObject.thumbPath))
    {
      AppMethodBeat.o(325625);
      return false;
    }
    AppMethodBeat.o(325625);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(325624);
    int j = this.videoPath.hashCode();
    if (this.thumbPath == null) {}
    for (int i = 0;; i = this.thumbPath.hashCode())
    {
      AppMethodBeat.o(325624);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(325619);
    String str = "DoFavoriteParams(videoPath=" + this.videoPath + ", thumbPath=" + this.thumbPath + ')';
    AppMethodBeat.o(325619);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325629);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    AppMethodBeat.o(325629);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<JsApiAddVideoToFavorites.DoFavoriteParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddVideoToFavorites.DoFavoriteParams
 * JD-Core Version:    0.7.0.1
 */