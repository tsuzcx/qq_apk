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
    public long cfj;
    public String errMsg;
    public String lgk;
    public boolean lgl;
    public String lgm;
    public String sessionId;
    public long time;
    
    static
    {
      AppMethodBeat.i(201042);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(201042);
    }
    
    public StepLogInfo()
    {
      this.cfj = -1L;
    }
    
    public StepLogInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(201039);
      this.cfj = -1L;
      this.time = paramParcel.readLong();
      this.sessionId = paramParcel.readString();
      this.lgk = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lgl = bool;
        this.errMsg = paramParcel.readString();
        this.lgm = paramParcel.readString();
        this.cfj = paramParcel.readLong();
        AppMethodBeat.o(201039);
        return;
      }
    }
    
    public final boolean bmR()
    {
      AppMethodBeat.i(201040);
      boolean bool = "END".equals(this.lgk);
      AppMethodBeat.o(201040);
      return bool;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(201041);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.sessionId);
      paramParcel.writeString(this.lgk);
      if (this.lgl) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeString(this.lgm);
        paramParcel.writeLong(this.cfj);
        AppMethodBeat.o(201041);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bv(List<IKeyStepAnalyser.b> paramList);
  }
  
  public static final class b
  {
    public ArrayList<IKeyStepAnalyser.StepLogInfo> lgi;
    public StringBuilder lgj;
    
    public b()
    {
      AppMethodBeat.i(201037);
      this.lgi = new ArrayList();
      this.lgj = new StringBuilder();
      AppMethodBeat.o(201037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser
 * JD-Core Version:    0.7.0.1
 */