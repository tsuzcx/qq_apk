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
    public long cost;
    public String errMsg;
    public String sUP;
    public boolean sUQ;
    public String sUR;
    public String sessionId;
    public long time;
    
    static
    {
      AppMethodBeat.i(319531);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(319531);
    }
    
    public StepLogInfo()
    {
      this.cost = -1L;
    }
    
    public StepLogInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(319525);
      this.cost = -1L;
      this.time = paramParcel.readLong();
      this.sessionId = paramParcel.readString();
      this.sUP = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.sUQ = bool;
        this.errMsg = paramParcel.readString();
        this.sUR = paramParcel.readString();
        this.cost = paramParcel.readLong();
        AppMethodBeat.o(319525);
        return;
      }
    }
    
    public final boolean czA()
    {
      AppMethodBeat.i(319535);
      boolean bool = "END".equals(this.sUP);
      AppMethodBeat.o(319535);
      return bool;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(319545);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.sessionId);
      paramParcel.writeString(this.sUP);
      if (this.sUQ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeString(this.sUR);
        paramParcel.writeLong(this.cost);
        AppMethodBeat.o(319545);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void dw(List<IKeyStepAnalyser.b> paramList);
  }
  
  public static final class b
  {
    public ArrayList<IKeyStepAnalyser.StepLogInfo> sUN;
    public StringBuilder sUO;
    
    public b()
    {
      AppMethodBeat.i(319503);
      this.sUN = new ArrayList();
      this.sUO = new StringBuilder();
      AppMethodBeat.o(319503);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser
 * JD-Core Version:    0.7.0.1
 */