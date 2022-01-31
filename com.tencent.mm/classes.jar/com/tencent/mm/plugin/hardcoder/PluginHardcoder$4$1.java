package com.tencent.mm.plugin.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginHardcoder$4$1
  implements Runnable
{
  PluginHardcoder$4$1(PluginHardcoder.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(60254);
    long l = Thread.currentThread().getId();
    String str = Thread.currentThread().getName();
    boolean bool;
    if ((WXHardCoderJNI.isCheckEnv()) && (WXHardCoderJNI.isRunning() > 0))
    {
      bool = true;
      ab.i("MicroMsg.PluginHardcoder", "reportHardCoder tid[%d, %s], running[%b]", new Object[] { Long.valueOf(l), str, Boolean.valueOf(bool) });
      WXHardCoderJNI.reportIDKey(true, 0, 1, false);
      WXHardCoderJNI.readServerAddr(true);
      if ((!WXHardCoderJNI.isCheckEnv()) || (WXHardCoderJNI.isRunning() <= 0)) {
        break label127;
      }
      i = 4;
      label92:
      WXHardCoderJNI.reportIDKey(true, i, 1, false);
      if (!WXHardCoderJNI.isHCEnable()) {
        break label132;
      }
    }
    label132:
    for (int i = 6;; i = 7)
    {
      WXHardCoderJNI.reportIDKey(true, i, 1, false);
      AppMethodBeat.o(60254);
      return;
      bool = false;
      break;
      label127:
      i = 5;
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder.4.1
 * JD-Core Version:    0.7.0.1
 */