package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class SampleTask1
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask1> CREATOR;
  public String rvN;
  public String rvO;
  
  static
  {
    AppMethodBeat.i(134864);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134864);
  }
  
  public SampleTask1(Parcel paramParcel)
  {
    AppMethodBeat.i(134859);
    h(paramParcel);
    AppMethodBeat.o(134859);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(134860);
    Log.e("SampleTask", this.rvN);
    this.rvO = "String from Main Process";
    cpA();
    AppMethodBeat.o(134860);
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(134861);
    Log.e("SampleTask", this.rvO);
    AppMethodBeat.o(134861);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(134862);
    this.rvN = paramParcel.readString();
    this.rvO = paramParcel.readString();
    AppMethodBeat.o(134862);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134863);
    paramParcel.writeString(this.rvN);
    paramParcel.writeString(this.rvO);
    AppMethodBeat.o(134863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask1
 * JD-Core Version:    0.7.0.1
 */