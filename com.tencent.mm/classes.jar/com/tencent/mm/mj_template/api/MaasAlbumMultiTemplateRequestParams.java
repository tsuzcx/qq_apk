package com.tencent.mm.mj_template.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/api/MaasAlbumMultiTemplateRequestParams;", "Landroid/os/Parcelable;", "mediaList", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "(Ljava/util/List;)V", "getMediaList", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-mj-template.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaasAlbumMultiTemplateRequestParams
  implements Parcelable
{
  public static final Parcelable.Creator<MaasAlbumMultiTemplateRequestParams> CREATOR;
  public final List<GalleryItem.MediaItem> nZr;
  
  static
  {
    AppMethodBeat.i(240114);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(240114);
  }
  
  public MaasAlbumMultiTemplateRequestParams(List<? extends GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(240107);
    this.nZr = paramList;
    AppMethodBeat.o(240107);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(240129);
    if (this == paramObject)
    {
      AppMethodBeat.o(240129);
      return true;
    }
    if (!(paramObject instanceof MaasAlbumMultiTemplateRequestParams))
    {
      AppMethodBeat.o(240129);
      return false;
    }
    paramObject = (MaasAlbumMultiTemplateRequestParams)paramObject;
    if (!s.p(this.nZr, paramObject.nZr))
    {
      AppMethodBeat.o(240129);
      return false;
    }
    AppMethodBeat.o(240129);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(240124);
    int i = this.nZr.hashCode();
    AppMethodBeat.o(240124);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240119);
    String str = "MaasAlbumMultiTemplateRequestParams(mediaList=" + this.nZr + ')';
    AppMethodBeat.o(240119);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(240146);
    s.u(paramParcel, "out");
    Object localObject = this.nZr;
    paramParcel.writeInt(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Iterator)localObject).next(), paramInt);
    }
    AppMethodBeat.o(240146);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MaasAlbumMultiTemplateRequestParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.api.MaasAlbumMultiTemplateRequestParams
 * JD-Core Version:    0.7.0.1
 */