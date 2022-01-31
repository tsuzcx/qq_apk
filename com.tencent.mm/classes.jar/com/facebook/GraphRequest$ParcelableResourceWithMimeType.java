package com.facebook;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GraphRequest$ParcelableResourceWithMimeType<RESOURCE extends Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR;
  private final String mimeType;
  private final RESOURCE resource;
  
  static
  {
    AppMethodBeat.i(71651);
    CREATOR = new GraphRequest.ParcelableResourceWithMimeType.1();
    AppMethodBeat.o(71651);
  }
  
  private GraphRequest$ParcelableResourceWithMimeType(Parcel paramParcel)
  {
    AppMethodBeat.i(71650);
    this.mimeType = paramParcel.readString();
    this.resource = paramParcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
    AppMethodBeat.o(71650);
  }
  
  public GraphRequest$ParcelableResourceWithMimeType(RESOURCE paramRESOURCE, String paramString)
  {
    this.mimeType = paramString;
    this.resource = paramRESOURCE;
  }
  
  public int describeContents()
  {
    return 1;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public RESOURCE getResource()
  {
    return this.resource;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(71649);
    paramParcel.writeString(this.mimeType);
    paramParcel.writeParcelable(this.resource, paramInt);
    AppMethodBeat.o(71649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.GraphRequest.ParcelableResourceWithMimeType
 * JD-Core Version:    0.7.0.1
 */