package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GalleryItem$AlbumItem
  implements Parcelable, Comparable<AlbumItem>
{
  public static final Parcelable.Creator<AlbumItem> CREATOR;
  public GalleryItem.MediaItem BVd;
  String MtW;
  public boolean MtX;
  public boolean NSW;
  public boolean NSX;
  public String albumName;
  public int fCa;
  public String nickName;
  public int xzT;
  
  static
  {
    AppMethodBeat.i(111314);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111314);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111311);
    this.xzT = 0;
    this.MtX = false;
    this.NSW = false;
    this.NSX = false;
    this.albumName = paramParcel.readString();
    this.fCa = paramParcel.readInt();
    this.BVd = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(111311);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(111310);
    this.xzT = 0;
    this.MtX = false;
    this.NSW = false;
    this.NSX = false;
    this.albumName = Util.nullAsNil(paramString);
    this.fCa = paramInt;
    this.nickName = this.albumName;
    AppMethodBeat.o(111310);
  }
  
  public String aZe()
  {
    AppMethodBeat.i(111312);
    if (this.BVd == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
      AppMethodBeat.o(111312);
      return null;
    }
    String str = this.BVd.aZe();
    AppMethodBeat.o(111312);
    return str;
  }
  
  public final void c(GalleryItem.MediaItem paramMediaItem)
  {
    this.BVd = paramMediaItem;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String etI()
  {
    AppMethodBeat.i(173734);
    if (this.BVd == null)
    {
      Log.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
      AppMethodBeat.o(173734);
      return null;
    }
    String str = this.BVd.AAz;
    AppMethodBeat.o(173734);
    return str;
  }
  
  public long etJ()
  {
    AppMethodBeat.i(173735);
    if (this.BVd == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
      AppMethodBeat.o(173735);
      return -1L;
    }
    long l = this.BVd.BVl;
    AppMethodBeat.o(173735);
    return l;
  }
  
  public int etK()
  {
    AppMethodBeat.i(173736);
    if (this.BVd == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
      AppMethodBeat.o(173736);
      return -1;
    }
    int i = this.BVd.getType();
    AppMethodBeat.o(173736);
    return i;
  }
  
  public final GalleryItem.MediaItem evX()
  {
    return this.BVd;
  }
  
  public final long exq()
  {
    AppMethodBeat.i(179454);
    if (this.BVd == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
      AppMethodBeat.o(179454);
      return -1L;
    }
    long l = this.BVd.BVm;
    AppMethodBeat.o(179454);
    return l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111313);
    paramParcel.writeString(this.albumName);
    paramParcel.writeInt(this.fCa);
    paramParcel.writeParcelable(this.BVd, paramInt);
    AppMethodBeat.o(111313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */