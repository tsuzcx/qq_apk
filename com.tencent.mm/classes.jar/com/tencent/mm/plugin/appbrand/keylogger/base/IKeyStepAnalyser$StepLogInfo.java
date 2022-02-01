package com.tencent.mm.plugin.appbrand.keylogger.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IKeyStepAnalyser$StepLogInfo
  implements Parcelable
{
  public static final Parcelable.Creator<StepLogInfo> CREATOR;
  public long cCv;
  public String errMsg;
  public String mPw;
  public boolean mPx;
  public String mPy;
  public String sessionId;
  public long time;
  
  static
  {
    AppMethodBeat.i(221325);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(221325);
  }
  
  public IKeyStepAnalyser$StepLogInfo()
  {
    this.cCv = -1L;
  }
  
  public IKeyStepAnalyser$StepLogInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(221322);
    this.cCv = -1L;
    this.time = paramParcel.readLong();
    this.sessionId = paramParcel.readString();
    this.mPw = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mPx = bool;
      this.errMsg = paramParcel.readString();
      this.mPy = paramParcel.readString();
      this.cCv = paramParcel.readLong();
      AppMethodBeat.o(221322);
      return;
    }
  }
  
  public final boolean bMX()
  {
    AppMethodBeat.i(221323);
    boolean bool = "END".equals(this.mPw);
    AppMethodBeat.o(221323);
    return bool;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(221324);
    paramParcel.writeLong(this.time);
    paramParcel.writeString(this.sessionId);
    paramParcel.writeString(this.mPw);
    if (this.mPx) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.errMsg);
      paramParcel.writeString(this.mPy);
      paramParcel.writeLong(this.cCv);
      AppMethodBeat.o(221324);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo
 * JD-Core Version:    0.7.0.1
 */