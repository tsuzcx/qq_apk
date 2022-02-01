package com.tencent.mm.plugin.appbrand.keylogger.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract interface IKeyStepAnalyser
{
  public static final class StepLogInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<StepLogInfo> CREATOR;
    public long cCY;
    public String errMsg;
    public String pQp;
    public boolean pQq;
    public String pQr;
    public String sessionId;
    public long time;
    
    static
    {
      AppMethodBeat.i(209243);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(209243);
    }
    
    public StepLogInfo()
    {
      this.cCY = -1L;
    }
    
    public StepLogInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(209236);
      this.cCY = -1L;
      this.time = paramParcel.readLong();
      this.sessionId = paramParcel.readString();
      this.pQp = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.pQq = bool;
        this.errMsg = paramParcel.readString();
        this.pQr = paramParcel.readString();
        this.cCY = paramParcel.readLong();
        AppMethodBeat.o(209236);
        return;
      }
    }
    
    public final boolean bZo()
    {
      AppMethodBeat.i(209238);
      boolean bool = "END".equals(this.pQp);
      AppMethodBeat.o(209238);
      return bool;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(209241);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.sessionId);
      paramParcel.writeString(this.pQp);
      if (this.pQq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeString(this.pQr);
        paramParcel.writeLong(this.cCY);
        AppMethodBeat.o(209241);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bL(List<IKeyStepAnalyser.b> paramList);
  }
  
  public static final class b
  {
    public ArrayList<IKeyStepAnalyser.StepLogInfo> pQn;
    public StringBuilder pQo;
    
    public b()
    {
      AppMethodBeat.i(208204);
      this.pQn = new ArrayList();
      this.pQo = new StringBuilder();
      AppMethodBeat.o(208204);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser
 * JD-Core Version:    0.7.0.1
 */