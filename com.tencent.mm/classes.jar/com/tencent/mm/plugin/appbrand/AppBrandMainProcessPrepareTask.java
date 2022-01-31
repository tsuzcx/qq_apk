package com.tencent.mm.plugin.appbrand;

import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class AppBrandMainProcessPrepareTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandMainProcessPrepareTask> CREATOR;
  private final Runnable gPn;
  
  static
  {
    AppMethodBeat.i(128947);
    CREATOR = new AppBrandMainProcessPrepareTask.1();
    AppMethodBeat.o(128947);
  }
  
  AppBrandMainProcessPrepareTask()
  {
    AppMethodBeat.i(128944);
    this.gPn = null;
    aBj();
    AppMethodBeat.o(128944);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(128945);
    aBp();
    AppMethodBeat.o(128945);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(128946);
    if (this.gPn != null) {
      this.gPn.run();
    }
    aBk();
    AppMethodBeat.o(128946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandMainProcessPrepareTask
 * JD-Core Version:    0.7.0.1
 */