package com.tencent.mm.performance.wxperformancetool;

import android.app.AlertDialog;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class MemoryLeakActivity$1
  extends ak
{
  MemoryLeakActivity$1(MemoryLeakActivity paramMemoryLeakActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76882);
    if (((WeakReference)a.giF.get(MemoryLeakActivity.a(this.giD))).get() == null)
    {
      this.giD.finish();
      AppMethodBeat.o(76882);
      return;
    }
    MemoryLeakActivity.b(this.giD).show();
    AppMethodBeat.o(76882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.1
 * JD-Core Version:    0.7.0.1
 */