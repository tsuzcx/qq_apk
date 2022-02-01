package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebRenderingCacheDirectoryDescriptor
  implements Parcelable
{
  public static final Parcelable.Creator<WebRenderingCacheDirectoryDescriptor> CREATOR;
  public String mgQ;
  
  static
  {
    AppMethodBeat.i(47977);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47977);
  }
  
  public WebRenderingCacheDirectoryDescriptor() {}
  
  protected WebRenderingCacheDirectoryDescriptor(Parcel paramParcel)
  {
    AppMethodBeat.i(47976);
    this.mgQ = paramParcel.readString();
    AppMethodBeat.o(47976);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47975);
    paramParcel.writeString(this.mgQ);
    AppMethodBeat.o(47975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.WebRenderingCacheDirectoryDescriptor
 * JD-Core Version:    0.7.0.1
 */