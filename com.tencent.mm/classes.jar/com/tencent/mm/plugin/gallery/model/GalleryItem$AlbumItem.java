package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class GalleryItem$AlbumItem
  implements Parcelable, Comparable<AlbumItem>
{
  public static final Parcelable.Creator<AlbumItem> CREATOR;
  public String bLs;
  public int dfy;
  public String sJZ;
  public int sKb;
  public GalleryItem.MediaItem xIb;
  public boolean xIc;
  public boolean xNm;
  String xiC;
  
  static
  {
    AppMethodBeat.i(111314);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111314);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111311);
    this.sKb = 0;
    this.xIc = false;
    this.xNm = false;
    this.sJZ = paramParcel.readString();
    this.dfy = paramParcel.readInt();
    this.xIb = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(111311);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(111310);
    this.sKb = 0;
    this.xIc = false;
    this.xNm = false;
    this.sJZ = bs.nullAsNil(paramString);
    this.dfy = paramInt;
    this.bLs = this.sJZ;
    AppMethodBeat.o(111310);
  }
  
  public String auN()
  {
    AppMethodBeat.i(111312);
    if (this.xIb == null)
    {
      ac.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
      AppMethodBeat.o(111312);
      return null;
    }
    String str = this.xIb.auN();
    AppMethodBeat.o(111312);
    return str;
  }
  
  public final void b(GalleryItem.MediaItem paramMediaItem)
  {
    this.xIb = paramMediaItem;
  }
  
  public String cMQ()
  {
    AppMethodBeat.i(173734);
    if (this.xIb == null)
    {
      ac.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
      AppMethodBeat.o(173734);
      return null;
    }
    String str = this.xIb.sKh;
    AppMethodBeat.o(173734);
    return str;
  }
  
  public long cMR()
  {
    AppMethodBeat.i(173735);
    if (this.xIb == null)
    {
      ac.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
      AppMethodBeat.o(173735);
      return -1L;
    }
    long l = this.xIb.sKk;
    AppMethodBeat.o(173735);
    return l;
  }
  
  public int cMS()
  {
    AppMethodBeat.i(173736);
    if (this.xIb == null)
    {
      ac.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
      AppMethodBeat.o(173736);
      return -1;
    }
    int i = this.xIb.getType();
    AppMethodBeat.o(173736);
    return i;
  }
  
  public final GalleryItem.MediaItem cWr()
  {
    return this.xIb;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final long dzx()
  {
    AppMethodBeat.i(179454);
    if (this.xIb == null)
    {
      ac.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
      AppMethodBeat.o(179454);
      return -1L;
    }
    long l = this.xIb.sKl;
    AppMethodBeat.o(179454);
    return l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111313);
    paramParcel.writeString(this.sJZ);
    paramParcel.writeInt(this.dfy);
    paramParcel.writeParcelable(this.xIb, paramInt);
    AppMethodBeat.o(111313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */