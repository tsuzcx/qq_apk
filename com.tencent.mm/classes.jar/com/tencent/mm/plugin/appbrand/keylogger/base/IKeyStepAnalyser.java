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
    public long cpz;
    public String errMsg;
    public String lDi;
    public boolean lDj;
    public String lDk;
    public String sessionId;
    public long time;
    
    static
    {
      AppMethodBeat.i(187714);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(187714);
    }
    
    public StepLogInfo()
    {
      this.cpz = -1L;
    }
    
    public StepLogInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(187711);
      this.cpz = -1L;
      this.time = paramParcel.readLong();
      this.sessionId = paramParcel.readString();
      this.lDi = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lDj = bool;
        this.errMsg = paramParcel.readString();
        this.lDk = paramParcel.readString();
        this.cpz = paramParcel.readLong();
        AppMethodBeat.o(187711);
        return;
      }
    }
    
    public final boolean bqC()
    {
      AppMethodBeat.i(187712);
      boolean bool = "END".equals(this.lDi);
      AppMethodBeat.o(187712);
      return bool;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(187713);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.sessionId);
      paramParcel.writeString(this.lDi);
      if (this.lDj) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeString(this.lDk);
        paramParcel.writeLong(this.cpz);
        AppMethodBeat.o(187713);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bx(List<IKeyStepAnalyser.b> paramList);
  }
  
  public static final class b
  {
    public ArrayList<IKeyStepAnalyser.StepLogInfo> lDg;
    public StringBuilder lDh;
    
    public b()
    {
      AppMethodBeat.i(187709);
      this.lDg = new ArrayList();
      this.lDh = new StringBuilder();
      AppMethodBeat.o(187709);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser
 * JD-Core Version:    0.7.0.1
 */