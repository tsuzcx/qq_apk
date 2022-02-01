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
    AppMethodBeat.i(242617);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(242617);
  }
  
  public final String aZe()
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
    AppMethodBeat.i(242616);
    String str = "TimeMediaItem{base=" + super.toString() + ", generateDate='" + this.BVm + '\'' + ", dateTag='" + this.BVn + '\'' + '}';
    AppMethodBeat.o(242616);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(242615);
    paramParcel.writeLong(this.BVm);
    paramParcel.writeString(this.BVn);
    AppMethodBeat.o(242615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.GalleryItem.TimeMediaItem
 * JD-Core Version:    0.7.0.1
 */