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
    public long cin;
    public String errMsg;
    public String kER;
    public boolean kES;
    public String kET;
    public String sessionId;
    public long time;
    
    static
    {
      AppMethodBeat.i(194887);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(194887);
    }
    
    public StepLogInfo()
    {
      this.cin = -1L;
    }
    
    public StepLogInfo(Parcel paramParcel)
    {
      AppMethodBeat.i(194884);
      this.cin = -1L;
      this.time = paramParcel.readLong();
      this.sessionId = paramParcel.readString();
      this.kER = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.kES = bool;
        this.errMsg = paramParcel.readString();
        this.kET = paramParcel.readString();
        this.cin = paramParcel.readLong();
        AppMethodBeat.o(194884);
        return;
      }
    }
    
    public final boolean bfX()
    {
      AppMethodBeat.i(194885);
      boolean bool = "END".equals(this.kER);
      AppMethodBeat.o(194885);
      return bool;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(194886);
      paramParcel.writeLong(this.time);
      paramParcel.writeString(this.sessionId);
      paramParcel.writeString(this.kER);
      if (this.kES) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.errMsg);
        paramParcel.writeString(this.kET);
        paramParcel.writeLong(this.cin);
        AppMethodBeat.o(194886);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void ac(List<IKeyStepAnalyser.b> paramList);
  }
  
  public static final class b
  {
    public ArrayList<IKeyStepAnalyser.StepLogInfo> kEP;
    public StringBuilder kEQ;
    
    public b()
    {
      AppMethodBeat.i(194882);
      this.kEP = new ArrayList();
      this.kEQ = new StringBuilder();
      AppMethodBeat.o(194882);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser
 * JD-Core Version:    0.7.0.1
 */