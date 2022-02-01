package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;

public class IPCSetCurrentPaySpeech
  implements b<IPCSetCurrentPaySpeechParam, Bundle>
{
  public static final class IPCSetCurrentPaySpeechParam
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCSetCurrentPaySpeechParam> CREATOR;
    private String mjv;
    private String mjw;
    private String mjx;
    private boolean mjy;
    private String mjz;
    private String version;
    
    static
    {
      AppMethodBeat.i(46655);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46655);
    }
    
    public IPCSetCurrentPaySpeechParam() {}
    
    protected IPCSetCurrentPaySpeechParam(Parcel paramParcel)
    {
      AppMethodBeat.i(46654);
      this.mjv = paramParcel.readString();
      this.mjw = paramParcel.readString();
      this.mjx = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.mjy = bool;
        this.mjz = paramParcel.readString();
        this.version = paramParcel.readString();
        AppMethodBeat.o(46654);
        return;
      }
    }
    
    public IPCSetCurrentPaySpeechParam(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
    {
      this.mjv = paramString1;
      this.mjw = paramString2;
      this.mjx = paramString3;
      this.mjy = paramBoolean;
      this.mjz = paramString4;
      this.version = paramString5;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46653);
      paramParcel.writeString(this.mjv);
      paramParcel.writeString(this.mjw);
      paramParcel.writeString(this.mjx);
      if (this.mjy) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.mjz);
        paramParcel.writeString(this.version);
        AppMethodBeat.o(46653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech
 * JD-Core Version:    0.7.0.1
 */