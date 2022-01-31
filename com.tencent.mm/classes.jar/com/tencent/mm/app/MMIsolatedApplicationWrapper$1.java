package com.tencent.mm.app;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sandbox.SandboxListener;

final class MMIsolatedApplicationWrapper$1
  implements SandboxListener
{
  MMIsolatedApplicationWrapper$1(MMIsolatedApplicationWrapper paramMMIsolatedApplicationWrapper) {}
  
  public final void setCrashRecordFileDescriptor(ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2)
  {
    AppMethodBeat.i(154200);
    n.a(paramParcelFileDescriptor1, paramParcelFileDescriptor2, MMIsolatedApplicationWrapper.access$000(this.bYC));
    AppMethodBeat.o(154200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.MMIsolatedApplicationWrapper.1
 * JD-Core Version:    0.7.0.1
 */