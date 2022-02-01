package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class SampleTask1
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask1> CREATOR;
  public String jVM;
  public String jVN;
  
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
  
  public final void aLq()
  {
    AppMethodBeat.i(134860);
    ac.e("SampleTask", this.jVM);
    this.jVN = "String from Main Process";
    bet();
    AppMethodBeat.o(134860);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(134861);
    ac.e("SampleTask", this.jVN);
    AppMethodBeat.o(134861);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(134862);
    this.jVM = paramParcel.readString();
    this.jVN = paramParcel.readString();
    AppMethodBeat.o(134862);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134863);
    paramParcel.writeString(this.jVM);
    paramParcel.writeString(this.jVN);
    AppMethodBeat.o(134863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask1
 * JD-Core Version:    0.7.0.1
 */