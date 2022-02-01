package com.tencent.mm.plugin.appbrand.keylogger.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IKeyStepAnalyser
{
  public static final class StepLogInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<StepLogInfo> CREATOR;
    public long cqc;
    public String errMsg;
    public String lHH;
    public boolean lHI;
    public String lHJ;
    public String sessionId;
    public long time;
    
    static
    {
      AppMethodBeat.i(201281);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(201281);
    }
    
    public StepLogInfo()
    {
      this.cqc = -1L;
    }
    
    public StepLogInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(201278);
      this.cqc = -1L;
      this.time = paramParcel.readLong();
      this.sessionId = paramParcel.readString();
      this.lHH = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lHI = bool;
        this.errMsg = paramParcel.readString();
        this.lHJ = paramParcel.readString();
        this.cqc = paramParcel.readLong();
        AppMethodBeat.o(201278);
        return;
      }
    }
    
    public final boolean brm()
    {
      AppMethodBeat.i(201279);
      boolean bool = "END".equals(this.lHH);
      AppMethodBeat.o(201279);
      return bool;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(201280);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.sessionId);
      paramParcel.writeString(this.lHH);
      if (this.lHI) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeString(this.lHJ);
        paramParcel.writeLong(this.cqc);
        AppMethodBeat.o(201280);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser
 * JD-Core Version:    0.7.0.1
 */