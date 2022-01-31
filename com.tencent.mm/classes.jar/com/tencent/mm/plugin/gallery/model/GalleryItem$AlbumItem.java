package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class GalleryItem$AlbumItem
  implements Parcelable
{
  public static final Parcelable.Creator<AlbumItem> CREATOR;
  public int cti;
  public String ndl;
  public GalleryItem.MediaItem ndm;
  
  static
  {
    AppMethodBeat.i(21287);
    CREATOR = new GalleryItem.AlbumItem.1();
    AppMethodBeat.o(21287);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(21284);
    this.ndl = paramParcel.readString();
    this.cti = paramParcel.readInt();
    this.ndm = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(21284);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(21283);
    this.ndl = bo.nullAsNil(paramString);
    this.cti = paramInt;
    AppMethodBeat.o(21283);
  }
  
  public final String Xi()
  {
    AppMethodBeat.i(21285);
    if (this.ndm == null)
    {
      AppMethodBeat.o(21285);
      return null;
    }
    String str = this.ndm.Xi();
    AppMethodBeat.o(21285);
    return str;
  }
  
  public final long dbW()
  {
    if (this.ndm == null) {
      return -1L;
    }
    return this.ndm.ndp;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(21286);
    paramParcel.writeString(this.ndl);
    paramParcel.writeInt(this.cti);
    paramParcel.writeParcelable(this.ndm, paramInt);
    AppMethodBeat.o(21286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */