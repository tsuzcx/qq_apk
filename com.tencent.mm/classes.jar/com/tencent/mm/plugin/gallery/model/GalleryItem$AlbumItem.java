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
  String Lmi;
  public GalleryItem.MediaItem Lmj;
  public boolean Lmk;
  public boolean Lml;
  public String bNK;
  public int did;
  public String rBh;
  public int rBj;
  
  static
  {
    AppMethodBeat.i(111314);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111314);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111311);
    this.rBj = 0;
    this.Lmk = false;
    this.Lml = false;
    this.rBh = paramParcel.readString();
    this.did = paramParcel.readInt();
    this.Lmj = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(111311);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(111310);
    this.rBj = 0;
    this.Lmk = false;
    this.Lml = false;
    this.rBh = bt.nullAsNil(paramString);
    this.did = paramInt;
    this.bNK = this.rBh;
    AppMethodBeat.o(111310);
  }
  
  public String anX()
  {
    AppMethodBeat.i(111312);
    if (this.Lmj == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
      AppMethodBeat.o(111312);
      return null;
    }
    String str = this.Lmj.anX();
    AppMethodBeat.o(111312);
    return str;
  }
  
  public String czE()
  {
    AppMethodBeat.i(173734);
    if (this.Lmj == null)
    {
      ad.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
      AppMethodBeat.o(173734);
      return null;
    }
    String str = this.Lmj.rBp;
    AppMethodBeat.o(173734);
    return str;
  }
  
  public long czF()
  {
    AppMethodBeat.i(173735);
    if (this.Lmj == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
      AppMethodBeat.o(173735);
      return -1L;
    }
    long l = this.Lmj.rBs;
    AppMethodBeat.o(173735);
    return l;
  }
  
  public int czG()
  {
    AppMethodBeat.i(173736);
    if (this.Lmj == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
      AppMethodBeat.o(173736);
      return -1;
    }
    int i = this.Lmj.getType();
    AppMethodBeat.o(173736);
    return i;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final GalleryItem.MediaItem fXP()
  {
    return this.Lmj;
  }
  
  public final long fXQ()
  {
    AppMethodBeat.i(179454);
    if (this.Lmj == null)
    {
      ad.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
      AppMethodBeat.o(179454);
      return -1L;
    }
    long l = this.Lmj.rBt;
    AppMethodBeat.o(179454);
    return l;
  }
  
  public final void i(GalleryItem.MediaItem paramMediaItem)
  {
    this.Lmj = paramMediaItem;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111313);
    paramParcel.writeString(this.rBh);
    paramParcel.writeInt(this.did);
    paramParcel.writeParcelable(this.Lmj, paramInt);
    AppMethodBeat.o(111313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */