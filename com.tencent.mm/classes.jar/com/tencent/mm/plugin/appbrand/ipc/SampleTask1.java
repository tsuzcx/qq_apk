package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class SampleTask1
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask1> CREATOR;
  public String orR;
  public String orS;
  
  static
  {
    AppMethodBeat.i(134864);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134864);
  }
  
  public SampleTask1(Parcel paramParcel)
  {
    AppMethodBeat.i(134859);
    f(paramParcel);
    AppMethodBeat.o(134859);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(134860);
    Log.e("SampleTask", this.orR);
    this.orS = "String from Main Process";
    bPt();
    AppMethodBeat.o(134860);
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(134861);
    Log.e("SampleTask", this.orS);
    AppMethodBeat.o(134861);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(134862);
    this.orR = paramParcel.readString();
    this.orS = paramParcel.readString();
    AppMethodBeat.o(134862);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134863);
    paramParcel.writeString(this.orR);
    paramParcel.writeString(this.orS);
    AppMethodBeat.o(134863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask1
 * JD-Core Version:    0.7.0.1
 */