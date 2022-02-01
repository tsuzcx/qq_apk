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
    private String lau;
    private String lav;
    private String law;
    private boolean lax;
    private String lay;
    
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
      this.lau = paramParcel.readString();
      this.lav = paramParcel.readString();
      this.law = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lax = bool;
        this.lay = paramParcel.readString();
        AppMethodBeat.o(46654);
        return;
      }
    }
    
    public IPCSetCurrentPaySpeechParam(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
    {
      this.lau = paramString1;
      this.lav = paramString2;
      this.law = paramString3;
      this.lax = paramBoolean;
      this.lay = paramString4;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46653);
      paramParcel.writeString(this.lau);
      paramParcel.writeString(this.lav);
      paramParcel.writeString(this.law);
      if (this.lax) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.lay);
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