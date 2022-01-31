package com.tencent.mm.performance.wxperformancetool;

import android.app.AlertDialog;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class MemoryLeakActivity$1
  extends ah
{
  MemoryLeakActivity$1(MemoryLeakActivity paramMemoryLeakActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (((WeakReference)a.eQK.get(MemoryLeakActivity.a(this.eQI))).get() == null)
    {
      this.eQI.finish();
      return;
    }
    MemoryLeakActivity.b(this.eQI).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.1
 * JD-Core Version:    0.7.0.1
 */