package com.tencent.mm.gpu.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;

public final class a
{
  private int[] jVq;
  
  public a()
  {
    AppMethodBeat.i(210665);
    this.jVq = null;
    Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(210665);
      return;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(210665);
      return;
    }
    localObject = localObject[0];
    if (localObject == null)
    {
      AppMethodBeat.o(210665);
      return;
    }
    this.jVq = a((Debug.MemoryInfo)localObject);
    AppMethodBeat.o(210665);
  }
  
  private static int[] a(Debug.MemoryInfo paramMemoryInfo)
  {
    AppMethodBeat.i(210669);
    try
    {
      Field localField = Class.forName("android.os.Debug$MemoryInfo").getDeclaredField("otherStats");
      localField.setAccessible(true);
      paramMemoryInfo = (int[])localField.get(paramMemoryInfo);
      AppMethodBeat.o(210669);
      return paramMemoryInfo;
    }
    catch (Exception paramMemoryInfo)
    {
      Log.e("Gpu.GpuMemoryGetter", "getOtherStatsByReflect fail");
      AppMethodBeat.o(210669);
    }
    return null;
  }
  
  private static int f(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(210670);
    int i = h(paramArrayOfInt, paramInt);
    paramInt = g(paramArrayOfInt, paramInt);
    AppMethodBeat.o(210670);
    return i + paramInt;
  }
  
  private static int g(int[] paramArrayOfInt, int paramInt)
  {
    return paramArrayOfInt[(paramInt * 9 + 3)];
  }
  
  private static int h(int[] paramArrayOfInt, int paramInt)
  {
    return paramArrayOfInt[(paramInt * 9 + 5)];
  }
  
  public final int aEP()
  {
    AppMethodBeat.i(210666);
    if (this.jVq == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because otherStats == null");
      AppMethodBeat.o(210666);
      return 0;
    }
    try
    {
      int i = f(this.jVq, 4);
      AppMethodBeat.o(210666);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because getOtherPrivate fail");
      AppMethodBeat.o(210666);
    }
    return 0;
  }
  
  public final int aEQ()
  {
    AppMethodBeat.i(210667);
    if (this.jVq == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because otherStats == null");
      AppMethodBeat.o(210667);
      return 0;
    }
    try
    {
      int i = f(this.jVq, 14);
      AppMethodBeat.o(210667);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because getOtherPrivate fail");
      AppMethodBeat.o(210667);
    }
    return 0;
  }
  
  public final int aER()
  {
    AppMethodBeat.i(210668);
    if (this.jVq == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(210668);
      return 0;
    }
    try
    {
      int i = f(this.jVq, 15);
      AppMethodBeat.o(210668);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(210668);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.gpu.g.a
 * JD-Core Version:    0.7.0.1
 */