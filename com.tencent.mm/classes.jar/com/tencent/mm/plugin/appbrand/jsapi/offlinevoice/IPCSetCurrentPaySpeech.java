package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;

public class IPCSetCurrentPaySpeech
  implements b<IPCSetCurrentPaySpeechParam, IPCBoolean>
{
  public static final class IPCSetCurrentPaySpeechParam
    implements Parcelable
  {
    public static final Parcelable.Creator<IPCSetCurrentPaySpeechParam> CREATOR;
    private String kEk;
    private String kEl;
    private String kEm;
    private boolean kEn;
    private String kEo;
    
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
      this.kEk = paramParcel.readString();
      this.kEl = paramParcel.readString();
      this.kEm = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.kEn = bool;
        this.kEo = paramParcel.readString();
        AppMethodBeat.o(46654);
        return;
      }
    }
    
    public IPCSetCurrentPaySpeechParam(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
    {
      this.kEk = paramString1;
      this.kEl = paramString2;
      this.kEm = paramString3;
      this.kEn = paramBoolean;
      this.kEo = paramString4;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46653);
      paramParcel.writeString(this.kEk);
      paramParcel.writeString(this.kEl);
      paramParcel.writeString(this.kEm);
      if (this.kEn) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.kEo);
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