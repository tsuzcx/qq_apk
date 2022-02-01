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
  public int AXs;
  public GalleryItem.MediaItem HHB;
  String akit;
  public boolean akiu;
  public boolean akiv;
  public boolean akiw;
  public String albumName;
  public int hGP;
  public String nickName;
  
  static
  {
    AppMethodBeat.i(111314);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111314);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111311);
    this.AXs = 0;
    this.akiu = false;
    this.akiv = false;
    this.akiw = false;
    this.albumName = paramParcel.readString();
    this.hGP = paramParcel.readInt();
    this.HHB = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(111311);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(111310);
    this.AXs = 0;
    this.akiu = false;
    this.akiv = false;
    this.akiw = false;
    this.albumName = Util.nullAsNil(paramString);
    this.hGP = paramInt;
    this.nickName = this.albumName;
    AppMethodBeat.o(111310);
  }
  
  public String bud()
  {
    AppMethodBeat.i(111312);
    if (this.HHB == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
      AppMethodBeat.o(111312);
      return null;
    }
    String str = this.HHB.bud();
    AppMethodBeat.o(111312);
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String fAJ()
  {
    AppMethodBeat.i(173734);
    if (this.HHB == null)
    {
      Log.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
      AppMethodBeat.o(173734);
      return null;
    }
    String str = this.HHB.Gcc;
    AppMethodBeat.o(173734);
    return str;
  }
  
  public long fAK()
  {
    AppMethodBeat.i(173735);
    if (this.HHB == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
      AppMethodBeat.o(173735);
      return -1L;
    }
    long l = this.HHB.HHJ;
    AppMethodBeat.o(173735);
    return l;
  }
  
  public int fAL()
  {
    AppMethodBeat.i(173736);
    if (this.HHB == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
      AppMethodBeat.o(173736);
      return -1;
    }
    int i = this.HHB.getType();
    AppMethodBeat.o(173736);
    return i;
  }
  
  public final long kLG()
  {
    AppMethodBeat.i(179454);
    if (this.HHB == null)
    {
      Log.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
      AppMethodBeat.o(179454);
      return -1L;
    }
    long l = this.HHB.HHK;
    AppMethodBeat.o(179454);
    return l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111313);
    paramParcel.writeString(this.albumName);
    paramParcel.writeInt(this.hGP);
    paramParcel.writeParcelable(this.HHB, paramInt);
    AppMethodBeat.o(111313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */