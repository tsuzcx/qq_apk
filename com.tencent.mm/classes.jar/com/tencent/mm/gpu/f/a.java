package com.tencent.mm.gpu.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.reflect.Field;

public final class a
{
  private int[] gwO;
  
  public a()
  {
    AppMethodBeat.i(209676);
    this.gwO = null;
    Object localObject = (ActivityManager)ak.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(209676);
      return;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(209676);
      return;
    }
    localObject = localObject[0];
    if (localObject == null)
    {
      AppMethodBeat.o(209676);
      return;
    }
    this.gwO = b((Debug.MemoryInfo)localObject);
    AppMethodBeat.o(209676);
  }
  
  private static int[] b(Debug.MemoryInfo paramMemoryInfo)
  {
    AppMethodBeat.i(209680);
    try
    {
      Field localField = Class.forName("android.os.Debug$MemoryInfo").getDeclaredField("otherStats");
      localField.setAccessible(true);
      paramMemoryInfo = (int[])localField.get(paramMemoryInfo);
      AppMethodBeat.o(209680);
      return paramMemoryInfo;
    }
    catch (Exception paramMemoryInfo)
    {
      ae.e("Gpu.GpuMemoryGetter", "getOtherStatsByReflect fail");
      AppMethodBeat.o(209680);
    }
    return null;
  }
  
  private static int f(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(209681);
    int i = h(paramArrayOfInt, paramInt);
    paramInt = g(paramArrayOfInt, paramInt);
    AppMethodBeat.o(209681);
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
  
  public final int ahi()
  {
    AppMethodBeat.i(209677);
    if (this.gwO == null)
    {
      ae.e("Gpu.GpuMemoryGetter", "getGfx fail, because otherStats == null");
      AppMethodBeat.o(209677);
      return 0;
    }
    try
    {
      int i = f(this.gwO, 4);
      AppMethodBeat.o(209677);
      return i;
    }
    catch (Exception localException)
    {
      ae.e("Gpu.GpuMemoryGetter", "getGfx fail, because getOtherPrivate fail");
      AppMethodBeat.o(209677);
    }
    return 0;
  }
  
  public final int ahj()
  {
    AppMethodBeat.i(209678);
    if (this.gwO == null)
    {
      ae.e("Gpu.GpuMemoryGetter", "getEGL fail, because otherStats == null");
      AppMethodBeat.o(209678);
      return 0;
    }
    try
    {
      int i = f(this.gwO, 14);
      AppMethodBeat.o(209678);
      return i;
    }
    catch (Exception localException)
    {
      ae.e("Gpu.GpuMemoryGetter", "getEGL fail, because getOtherPrivate fail");
      AppMethodBeat.o(209678);
    }
    return 0;
  }
  
  public final int ahk()
  {
    AppMethodBeat.i(209679);
    if (this.gwO == null)
    {
      ae.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(209679);
      return 0;
    }
    try
    {
      int i = f(this.gwO, 15);
      AppMethodBeat.o(209679);
      return i;
    }
    catch (Exception localException)
    {
      ae.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(209679);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.f.a
 * JD-Core Version:    0.7.0.1
 */