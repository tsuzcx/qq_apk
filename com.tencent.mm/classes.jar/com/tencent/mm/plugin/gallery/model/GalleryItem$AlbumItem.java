package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class GalleryItem$AlbumItem
  implements Parcelable, Comparable<AlbumItem>
{
  public static final Parcelable.Creator<AlbumItem> CREATOR;
  String Odm;
  public GalleryItem.MediaItem Odn;
  public boolean Odo;
  public boolean Odp;
  public String bVF;
  public int dqU;
  public String tGK;
  public int tGM;
  
  static
  {
    AppMethodBeat.i(111314);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111314);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111311);
    this.tGM = 0;
    this.Odo = false;
    this.Odp = false;
    this.tGK = paramParcel.readString();
    this.dqU = paramParcel.readInt();
    this.Odn = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(111311);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(111310);
    this.tGM = 0;
    this.Odo = false;
    this.Odp = false;
    this.tGK = bt.nullAsNil(paramString);
    this.dqU = paramInt;
    this.bVF = this.tGK;
    AppMethodBeat.o(111310);
  }
  
  public String axA()
  {
    AppMethodBeat.i(111312);
    if (this.Odn == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
      AppMethodBeat.o(111312);
      return null;
    }
    String str = this.Odn.axA();
    AppMethodBeat.o(111312);
    return str;
  }
  
  public final void b(GalleryItem.MediaItem paramMediaItem)
  {
    this.Odn = paramMediaItem;
  }
  
  public String cVj()
  {
    AppMethodBeat.i(173734);
    if (this.Odn == null)
    {
      ad.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
      AppMethodBeat.o(173734);
      return null;
    }
    String str = this.Odn.tGS;
    AppMethodBeat.o(173734);
    return str;
  }
  
  public long cVk()
  {
    AppMethodBeat.i(173735);
    if (this.Odn == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
      AppMethodBeat.o(173735);
      return -1L;
    }
    long l = this.Odn.tGV;
    AppMethodBeat.o(173735);
    return l;
  }
  
  public int cVl()
  {
    AppMethodBeat.i(173736);
    if (this.Odn == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
      AppMethodBeat.o(173736);
      return -1;
    }
    int i = this.Odn.getType();
    AppMethodBeat.o(173736);
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final GalleryItem.MediaItem fsN()
  {
    return this.Odn;
  }
  
  public final long fsO()
  {
    AppMethodBeat.i(179454);
    if (this.Odn == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
      AppMethodBeat.o(179454);
      return -1L;
    }
    long l = this.Odn.tGW;
    AppMethodBeat.o(179454);
    return l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111313);
    paramParcel.writeString(this.tGK);
    paramParcel.writeInt(this.dqU);
    paramParcel.writeParcelable(this.Odn, paramInt);
    AppMethodBeat.o(111313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */