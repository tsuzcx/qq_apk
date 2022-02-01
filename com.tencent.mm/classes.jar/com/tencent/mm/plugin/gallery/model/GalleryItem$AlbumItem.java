package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class GalleryItem$AlbumItem
  implements Parcelable, Comparable<AlbumItem>
{
  public static final Parcelable.Creator<AlbumItem> CREATOR;
  String DRn;
  public GalleryItem.MediaItem DRo;
  public boolean DRp;
  public boolean DRq;
  public String bVF;
  public int drZ;
  public String tRB;
  public int tRD;
  
  static
  {
    AppMethodBeat.i(111314);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(111314);
  }
  
  protected GalleryItem$AlbumItem(Parcel paramParcel)
  {
    AppMethodBeat.i(111311);
    this.tRD = 0;
    this.DRp = false;
    this.DRq = false;
    this.tRB = paramParcel.readString();
    this.drZ = paramParcel.readInt();
    this.DRo = ((GalleryItem.MediaItem)paramParcel.readParcelable(GalleryItem.MediaItem.class.getClassLoader()));
    AppMethodBeat.o(111311);
  }
  
  public GalleryItem$AlbumItem(String paramString, int paramInt)
  {
    AppMethodBeat.i(111310);
    this.tRD = 0;
    this.DRp = false;
    this.DRq = false;
    this.tRB = bu.nullAsNil(paramString);
    this.drZ = paramInt;
    this.bVF = this.tRB;
    AppMethodBeat.o(111310);
  }
  
  public String axP()
  {
    AppMethodBeat.i(111312);
    if (this.DRo == null)
    {
      ae.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
      AppMethodBeat.o(111312);
      return null;
    }
    String str = this.DRo.axP();
    AppMethodBeat.o(111312);
    return str;
  }
  
  public final void b(GalleryItem.MediaItem paramMediaItem)
  {
    this.DRo = paramMediaItem;
  }
  
  public String cXO()
  {
    AppMethodBeat.i(173734);
    if (this.DRo == null)
    {
      ae.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
      AppMethodBeat.o(173734);
      return null;
    }
    String str = this.DRo.tRJ;
    AppMethodBeat.o(173734);
    return str;
  }
  
  public long cXP()
  {
    AppMethodBeat.i(173735);
    if (this.DRo == null)
    {
      ae.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
      AppMethodBeat.o(173735);
      return -1L;
    }
    long l = this.DRo.tRM;
    AppMethodBeat.o(173735);
    return l;
  }
  
  public int cXQ()
  {
    AppMethodBeat.i(173736);
    if (this.DRo == null)
    {
      ae.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
      AppMethodBeat.o(173736);
      return -1;
    }
    int i = this.DRo.getType();
    AppMethodBeat.o(173736);
    return i;
  }
  
  public final long dWi()
  {
    AppMethodBeat.i(179454);
    if (this.DRo == null)
    {
      ae.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
      AppMethodBeat.o(179454);
      return -1L;
    }
    long l = this.DRo.tRN;
    AppMethodBeat.o(179454);
    return l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final GalleryItem.MediaItem dnF()
  {
    return this.DRo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(111313);
    paramParcel.writeString(this.tRB);
    paramParcel.writeInt(this.drZ);
    paramParcel.writeParcelable(this.DRo, paramInt);
    AppMethodBeat.o(111313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
 * JD-Core Version:    0.7.0.1
 */