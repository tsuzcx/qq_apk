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
    private String lec;
    private String led;
    private String lee;
    private boolean lef;
    private String leg;
    
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
      this.lec = paramParcel.readString();
      this.led = paramParcel.readString();
      this.lee = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lef = bool;
        this.leg = paramParcel.readString();
        AppMethodBeat.o(46654);
        return;
      }
    }
    
    public IPCSetCurrentPaySpeechParam(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
    {
      this.lec = paramString1;
      this.led = paramString2;
      this.lee = paramString3;
      this.lef = paramBoolean;
      this.leg = paramString4;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46653);
      paramParcel.writeString(this.lec);
      paramParcel.writeString(this.led);
      paramParcel.writeString(this.lee);
      if (this.lef) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.leg);
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