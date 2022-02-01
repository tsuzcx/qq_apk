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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/api/MaasAlbumTemplateRequestParams;", "Landroid/os/Parcelable;", "mediaList", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "mjTemplateSession", "Lcom/tencent/mm/mj_template/api/MJTemplateSession;", "(Ljava/util/List;Lcom/tencent/mm/mj_template/api/MJTemplateSession;)V", "getMediaList", "()Ljava/util/List;", "getMjTemplateSession", "()Lcom/tencent/mm/mj_template/api/MJTemplateSession;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-mj-template.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MaasAlbumTemplateRequestParams
  implements Parcelable
{
  public static final Parcelable.Creator<MaasAlbumTemplateRequestParams> CREATOR;
  public final List<GalleryItem.MediaItem> nZr;
  public final MJTemplateSession nZs;
  
  static
  {
    AppMethodBeat.i(240105);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(240105);
  }
  
  public MaasAlbumTemplateRequestParams(List<? extends GalleryItem.MediaItem> paramList, MJTemplateSession paramMJTemplateSession)
  {
    AppMethodBeat.i(240098);
    this.nZr = paramList;
    this.nZs = paramMJTemplateSession;
    AppMethodBeat.o(240098);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(240123);
    if (this == paramObject)
    {
      AppMethodBeat.o(240123);
      return true;
    }
    if (!(paramObject instanceof MaasAlbumTemplateRequestParams))
    {
      AppMethodBeat.o(240123);
      return false;
    }
    paramObject = (MaasAlbumTemplateRequestParams)paramObject;
    if (!s.p(this.nZr, paramObject.nZr))
    {
      AppMethodBeat.o(240123);
      return false;
    }
    if (!s.p(this.nZs, paramObject.nZs))
    {
      AppMethodBeat.o(240123);
      return false;
    }
    AppMethodBeat.o(240123);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(240118);
    int i = this.nZr.hashCode();
    int j = this.nZs.hashCode();
    AppMethodBeat.o(240118);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240113);
    String str = "MaasAlbumTemplateRequestParams(mediaList=" + this.nZr + ", mjTemplateSession=" + this.nZs + ')';
    AppMethodBeat.o(240113);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(240137);
    s.u(paramParcel, "out");
    Object localObject = this.nZr;
    paramParcel.writeInt(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParcel.writeParcelable((Parcelable)((Iterator)localObject).next(), paramInt);
    }
    this.nZs.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(240137);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MaasAlbumTemplateRequestParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.api.MaasAlbumTemplateRequestParams
 * JD-Core Version:    0.7.0.1
 */