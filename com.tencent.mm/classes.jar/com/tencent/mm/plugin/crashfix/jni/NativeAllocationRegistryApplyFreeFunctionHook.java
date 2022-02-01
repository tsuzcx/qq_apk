package com.tencent.mm.plugin.crashfix.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public class NativeAllocationRegistryApplyFreeFunctionHook
{
  private static long xfk = 0L;
  private static long xfl = 0L;
  
  public static native long getTestMethodAddr();
  
  public static native void hook(Method paramMethod1, Method paramMethod2);
  
  public static boolean isNeedRelease(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(145627);
    if ((paramLong1 == 0L) && (paramLong2 == 0L))
    {
      AppMethodBeat.o(145627);
      return true;
    }
    if ((xfk == paramLong1) && (xfl == paramLong2))
    {
      Log.e("NativeAllocationRegistryApplyFreeFunctionHook", "protect succ");
      h.OAn.idkeyStat(1113L, 7L, 1L, false);
      AppMethodBeat.o(145627);
      return false;
    }
    xfk = paramLong1;
    xfl = paramLong2;
    AppMethodBeat.o(145627);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.jni.NativeAllocationRegistryApplyFreeFunctionHook
 * JD-Core Version:    0.7.0.1
 */