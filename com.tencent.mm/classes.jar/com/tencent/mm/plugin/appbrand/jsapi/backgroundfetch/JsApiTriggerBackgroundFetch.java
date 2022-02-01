package com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.service.c;

public final class JsApiTriggerBackgroundFetch
  extends a<c>
{
  public static final int CTRL_INDEX = 685;
  public static final String NAME = "triggerBackgroundFetch";
  
  static class TriggerBackgroundFetchParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<TriggerBackgroundFetchParcel> CREATOR;
    String appId;
    String userName;
    
    static
    {
      AppMethodBeat.i(46135);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46135);
    }
    
    protected TriggerBackgroundFetchParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(46133);
      this.appId = paramParcel.readString();
      this.userName = paramParcel.readString();
      AppMethodBeat.o(46133);
    }
    
    public TriggerBackgroundFetchParcel(String paramString1, String paramString2)
    {
      this.appId = paramString1;
      this.userName = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46134);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.userName);
      AppMethodBeat.o(46134);
    }
  }
  
  static class a
    implements b<JsApiTriggerBackgroundFetch.TriggerBackgroundFetchParcel, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiTriggerBackgroundFetch
 * JD-Core Version:    0.7.0.1
 */