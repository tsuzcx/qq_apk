package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class SampleTask1
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask1> CREATOR;
  public String hwD;
  public String hwE;
  
  static
  {
    AppMethodBeat.i(86960);
    CREATOR = new SampleTask1.1();
    AppMethodBeat.o(86960);
  }
  
  public SampleTask1(Parcel paramParcel)
  {
    AppMethodBeat.i(86955);
    f(paramParcel);
    AppMethodBeat.o(86955);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(86956);
    ab.e("SampleTask", this.hwD);
    this.hwE = "String from Main Process";
    aBp();
    AppMethodBeat.o(86956);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(86957);
    ab.e("SampleTask", this.hwE);
    AppMethodBeat.o(86957);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(86958);
    this.hwD = paramParcel.readString();
    this.hwE = paramParcel.readString();
    AppMethodBeat.o(86958);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(86959);
    paramParcel.writeString(this.hwD);
    paramParcel.writeString(this.hwE);
    AppMethodBeat.o(86959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask1
 * JD-Core Version:    0.7.0.1
 */