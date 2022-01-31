package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppBrandLocalVideoObject
  extends AppBrandLocalMediaObject
{
  public static final Parcelable.Creator<AppBrandLocalVideoObject> CREATOR;
  public int duration;
  public int height;
  public int size;
  public int width;
  
  static
  {
    AppMethodBeat.i(105364);
    CREATOR = new AppBrandLocalVideoObject.1();
    AppMethodBeat.o(105364);
  }
  
  public AppBrandLocalVideoObject() {}
  
  private AppBrandLocalVideoObject(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(105362);
    this.duration = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    AppMethodBeat.o(105362);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(105363);
    String str = "AppBrandLocalVideoObject{duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
    AppMethodBeat.o(105363);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105361);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(105361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject
 * JD-Core Version:    0.7.0.1
 */