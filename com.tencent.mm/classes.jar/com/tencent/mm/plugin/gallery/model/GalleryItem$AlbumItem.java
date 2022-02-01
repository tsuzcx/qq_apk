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
  String UpY;
  public GalleryItem.MediaItem UpZ;
  public boolean Uqa;
  public boolean Uqb;
  public boolean Uqc;
  public String albumName;
  public int dJl;
  public String nickName;
  public int xiP;
  
  static
  {
    AppMethodBeat.i(111314);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111314);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111311);
    this.xiP = 0;
    this.Uqa = false;
    this.Uqb = false;
    this.Uqc = false;
    this.albumName = paramParcel.readString();
    this.dJl = paramParcel.readInt();
    this.UpZ = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(111311);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(111310);
    this.xiP = 0;
    this.Uqa = false;
    this.Uqb = false;
    this.Uqc = false;
    this.albumName = Util.nullAsNil(paramString);
    this.dJl = paramInt;
    this.nickName = this.albumName;
    AppMethodBeat.o(111310);
  }
  
  public String aQn()
  {
    AppMethodBeat.i(111312);
    if (this.UpZ == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
      AppMethodBeat.o(111312);
      return null;
    }
    String str = this.UpZ.aQn();
    AppMethodBeat.o(111312);
    return str;
  }
  
  public final void c(GalleryItem.MediaItem paramMediaItem)
  {
    this.UpZ = paramMediaItem;
  }
  
  public String dRh()
  {
    AppMethodBeat.i(173734);
    if (this.UpZ == null)
    {
      Log.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
      AppMethodBeat.o(173734);
      return null;
    }
    String str = this.UpZ.xiW;
    AppMethodBeat.o(173734);
    return str;
  }
  
  public long dRi()
  {
    AppMethodBeat.i(173735);
    if (this.UpZ == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
      AppMethodBeat.o(173735);
      return -1L;
    }
    long l = this.UpZ.xiZ;
    AppMethodBeat.o(173735);
    return l;
  }
  
  public int dRj()
  {
    AppMethodBeat.i(173736);
    if (this.UpZ == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
      AppMethodBeat.o(173736);
      return -1;
    }
    int i = this.UpZ.getType();
    AppMethodBeat.o(173736);
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final GalleryItem.MediaItem gEB()
  {
    return this.UpZ;
  }
  
  public final long gEV()
  {
    AppMethodBeat.i(179454);
    if (this.UpZ == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
      AppMethodBeat.o(179454);
      return -1L;
    }
    long l = this.UpZ.xja;
    AppMethodBeat.o(179454);
    return l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111313);
    paramParcel.writeString(this.albumName);
    paramParcel.writeInt(this.dJl);
    paramParcel.writeParcelable(this.UpZ, paramInt);
    AppMethodBeat.o(111313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */