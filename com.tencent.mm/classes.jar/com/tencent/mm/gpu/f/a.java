package com.tencent.mm.gpu.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.reflect.Field;

public final class a
{
  private int[] gaH;
  
  public a()
  {
    AppMethodBeat.i(209440);
    this.gaH = null;
    Object localObject = (ActivityManager)ai.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(209440);
      return;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(209440);
      return;
    }
    localObject = localObject[0];
    if (localObject == null)
    {
      AppMethodBeat.o(209440);
      return;
    }
    this.gaH = b((Debug.MemoryInfo)localObject);
    AppMethodBeat.o(209440);
  }
  
  private static int[] b(Debug.MemoryInfo paramMemoryInfo)
  {
    AppMethodBeat.i(209444);
    try
    {
      Field localField = Class.forName("android.os.Debug$MemoryInfo").getDeclaredField("otherStats");
      localField.setAccessible(true);
      paramMemoryInfo = (int[])localField.get(paramMemoryInfo);
      AppMethodBeat.o(209444);
      return paramMemoryInfo;
    }
    catch (Exception paramMemoryInfo)
    {
      ac.e("Gpu.GpuMemoryGetter", "getOtherStatsByReflect fail");
      AppMethodBeat.o(209444);
    }
    return null;
  }
  
  private static int f(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(209445);
    int i = h(paramArrayOfInt, paramInt);
    paramInt = g(paramArrayOfInt, paramInt);
    AppMethodBeat.o(209445);
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
  
  public final int aem()
  {
    AppMethodBeat.i(209441);
    if (this.gaH == null)
    {
      ac.e("Gpu.GpuMemoryGetter", "getGfx fail, because otherStats == null");
      AppMethodBeat.o(209441);
      return 0;
    }
    try
    {
      int i = f(this.gaH, 4);
      AppMethodBeat.o(209441);
      return i;
    }
    catch (Exception localException)
    {
      ac.e("Gpu.GpuMemoryGetter", "getGfx fail, because getOtherPrivate fail");
      AppMethodBeat.o(209441);
    }
    return 0;
  }
  
  public final int aen()
  {
    AppMethodBeat.i(209442);
    if (this.gaH == null)
    {
      ac.e("Gpu.GpuMemoryGetter", "getEGL fail, because otherStats == null");
      AppMethodBeat.o(209442);
      return 0;
    }
    try
    {
      int i = f(this.gaH, 14);
      AppMethodBeat.o(209442);
      return i;
    }
    catch (Exception localException)
    {
      ac.e("Gpu.GpuMemoryGetter", "getEGL fail, because getOtherPrivate fail");
      AppMethodBeat.o(209442);
    }
    return 0;
  }
  
  public final int aeo()
  {
    AppMethodBeat.i(209443);
    if (this.gaH == null)
    {
      ac.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(209443);
      return 0;
    }
    try
    {
      int i = f(this.gaH, 15);
      AppMethodBeat.o(209443);
      return i;
    }
    catch (Exception localException)
    {
      ac.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(209443);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.f.a
 * JD-Core Version:    0.7.0.1
 */