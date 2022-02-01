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
    AppMethodBeat.i(134326);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134326);
  }
  
  public AppBrandLocalVideoObject() {}
  
  private AppBrandLocalVideoObject(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(134324);
    this.duration = paramParcel.readInt();
    this.size = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    AppMethodBeat.o(134324);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(134325);
    String str = "AppBrandLocalVideoObject{duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
    AppMethodBeat.o(134325);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134323);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.duration);
    paramParcel.writeInt(this.size);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    AppMethodBeat.o(134323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject
 * JD-Core Version:    0.7.0.1
 */