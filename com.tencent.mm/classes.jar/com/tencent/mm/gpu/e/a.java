package com.tencent.mm.gpu.e;

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
  private int[] mvl;
  
  public a()
  {
    AppMethodBeat.i(231748);
    this.mvl = null;
    Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(231748);
      return;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(231748);
      return;
    }
    localObject = localObject[0];
    if (localObject == null)
    {
      AppMethodBeat.o(231748);
      return;
    }
    this.mvl = a((Debug.MemoryInfo)localObject);
    AppMethodBeat.o(231748);
  }
  
  private static int[] a(Debug.MemoryInfo paramMemoryInfo)
  {
    AppMethodBeat.i(231753);
    try
    {
      Field localField = Class.forName("android.os.Debug$MemoryInfo").getDeclaredField("otherStats");
      localField.setAccessible(true);
      paramMemoryInfo = (int[])localField.get(paramMemoryInfo);
      AppMethodBeat.o(231753);
      return paramMemoryInfo;
    }
    catch (Exception paramMemoryInfo)
    {
      Log.e("Gpu.GpuMemoryGetter", "getOtherStatsByReflect fail");
      AppMethodBeat.o(231753);
    }
    return null;
  }
  
  private static int s(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(231756);
    int i = u(paramArrayOfInt, paramInt);
    paramInt = t(paramArrayOfInt, paramInt);
    AppMethodBeat.o(231756);
    return i + paramInt;
  }
  
  private static int t(int[] paramArrayOfInt, int paramInt)
  {
    return paramArrayOfInt[(paramInt * 9 + 3)];
  }
  
  private static int u(int[] paramArrayOfInt, int paramInt)
  {
    return paramArrayOfInt[(paramInt * 9 + 5)];
  }
  
  public final int aXQ()
  {
    AppMethodBeat.i(231768);
    if (this.mvl == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because otherStats == null");
      AppMethodBeat.o(231768);
      return 0;
    }
    try
    {
      int i = s(this.mvl, 4);
      AppMethodBeat.o(231768);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because getOtherPrivate fail");
      AppMethodBeat.o(231768);
    }
    return 0;
  }
  
  public final int aXR()
  {
    AppMethodBeat.i(231772);
    if (this.mvl == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because otherStats == null");
      AppMethodBeat.o(231772);
      return 0;
    }
    try
    {
      int i = s(this.mvl, 14);
      AppMethodBeat.o(231772);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because getOtherPrivate fail");
      AppMethodBeat.o(231772);
    }
    return 0;
  }
  
  public final int aXS()
  {
    AppMethodBeat.i(231776);
    if (this.mvl == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(231776);
      return 0;
    }
    try
    {
      int i = s(this.mvl, 15);
      AppMethodBeat.o(231776);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(231776);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.e.a
 * JD-Core Version:    0.7.0.1
 */