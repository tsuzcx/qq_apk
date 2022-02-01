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
    private boolean kdA;
    private String kdB;
    private String kdx;
    private String kdy;
    private String kdz;
    
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
      this.kdx = paramParcel.readString();
      this.kdy = paramParcel.readString();
      this.kdz = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.kdA = bool;
        this.kdB = paramParcel.readString();
        AppMethodBeat.o(46654);
        return;
      }
    }
    
    public IPCSetCurrentPaySpeechParam(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
    {
      this.kdx = paramString1;
      this.kdy = paramString2;
      this.kdz = paramString3;
      this.kdA = paramBoolean;
      this.kdB = paramString4;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46653);
      paramParcel.writeString(this.kdx);
      paramParcel.writeString(this.kdy);
      paramParcel.writeString(this.kdz);
      if (this.kdA) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeString(this.kdB);
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