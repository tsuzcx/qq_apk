package com.tencent.mm.plugin.crashfix.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class GLConsumerHook
{
  public static native int hook();
  
  @Keep
  public static void report(long paramLong)
  {
    AppMethodBeat.i(145625);
    if (paramLong == -1L)
    {
      ac.i("MicroMsg.GLConsumerHook", "test succ");
      AppMethodBeat.o(145625);
      return;
    }
    if (paramLong == 0L)
    {
      ac.e("MicroMsg.GLConsumerHook", "null pointer");
      AppMethodBeat.o(145625);
      return;
    }
    ac.i("MicroMsg.GLConsumerHook", "pointer addr " + Long.toHexString(paramLong));
    AppMethodBeat.o(145625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.GLConsumerHook
 * JD-Core Version:    0.7.0.1
 */