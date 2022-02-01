package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class SampleTask1
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask1> CREATOR;
  public String ktp;
  public String ktq;
  
  static
  {
    AppMethodBeat.i(134864);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134864);
  }
  
  public SampleTask1(Parcel paramParcel)
  {
    AppMethodBeat.i(134859);
    e(paramParcel);
    AppMethodBeat.o(134859);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(134860);
    ae.e("SampleTask", this.ktp);
    this.ktq = "String from Main Process";
    biG();
    AppMethodBeat.o(134860);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(134861);
    ae.e("SampleTask", this.ktq);
    AppMethodBeat.o(134861);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(134862);
    this.ktp = paramParcel.readString();
    this.ktq = paramParcel.readString();
    AppMethodBeat.o(134862);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134863);
    paramParcel.writeString(this.ktp);
    paramParcel.writeString(this.ktq);
    AppMethodBeat.o(134863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask1
 * JD-Core Version:    0.7.0.1
 */