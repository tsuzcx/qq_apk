package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class SampleTask1
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask1> CREATOR;
  public String kqa;
  public String kqb;
  
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
  
  public final void aOA()
  {
    AppMethodBeat.i(134860);
    ad.e("SampleTask", this.kqa);
    this.kqb = "String from Main Process";
    bhX();
    AppMethodBeat.o(134860);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(134861);
    ad.e("SampleTask", this.kqb);
    AppMethodBeat.o(134861);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(134862);
    this.kqa = paramParcel.readString();
    this.kqb = paramParcel.readString();
    AppMethodBeat.o(134862);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134863);
    paramParcel.writeString(this.kqa);
    paramParcel.writeString(this.kqb);
    AppMethodBeat.o(134863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask1
 * JD-Core Version:    0.7.0.1
 */