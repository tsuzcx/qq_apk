package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GalleryItem$TimeMediaItem
  extends GalleryItem.MediaItem
{
  public static final Parcelable.Creator<GalleryItem.MediaItem> CREATOR;
  
  static
  {
    AppMethodBeat.i(289609);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(289609);
  }
  
  public final String bud()
  {
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public String toString()
  {
    AppMethodBeat.i(289616);
    String str = "TimeMediaItem{base=" + super.toString() + ", generateDate='" + this.HHK + '\'' + ", dateTag='" + this.HHL + '\'' + '}';
    AppMethodBeat.o(289616);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(289615);
    paramParcel.writeLong(this.HHK);
    paramParcel.writeString(this.HHL);
    AppMethodBeat.o(289615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.TimeMediaItem
 * JD-Core Version:    0.7.0.1
 */