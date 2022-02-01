package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class SampleTask2
  extends MainProcessTask
{
  public static final Parcelable.Creator<SampleTask2> CREATOR;
  
  static
  {
    AppMethodBeat.i(134867);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(134867);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(134866);
    ac.e("SampleTask2", "Run in Main Process");
    AppMethodBeat.o(134866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.SampleTask2
 * JD-Core Version:    0.7.0.1
 */