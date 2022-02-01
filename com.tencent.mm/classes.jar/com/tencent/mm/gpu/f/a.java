package com.tencent.mm.gpu.f;

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
  private int[] hjC;
  
  public a()
  {
    AppMethodBeat.i(186208);
    this.hjC = null;
    Object localObject = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(186208);
      return;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(186208);
      return;
    }
    localObject = localObject[0];
    if (localObject == null)
    {
      AppMethodBeat.o(186208);
      return;
    }
    this.hjC = b((Debug.MemoryInfo)localObject);
    AppMethodBeat.o(186208);
  }
  
  private static int[] b(Debug.MemoryInfo paramMemoryInfo)
  {
    AppMethodBeat.i(186212);
    try
    {
      Field localField = Class.forName("android.os.Debug$MemoryInfo").getDeclaredField("otherStats");
      localField.setAccessible(true);
      paramMemoryInfo = (int[])localField.get(paramMemoryInfo);
      AppMethodBeat.o(186212);
      return paramMemoryInfo;
    }
    catch (Exception paramMemoryInfo)
    {
      Log.e("Gpu.GpuMemoryGetter", "getOtherStatsByReflect fail");
      AppMethodBeat.o(186212);
    }
    return null;
  }
  
  private static int f(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(186213);
    int i = h(paramArrayOfInt, paramInt);
    paramInt = g(paramArrayOfInt, paramInt);
    AppMethodBeat.o(186213);
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
  
  public final int axu()
  {
    AppMethodBeat.i(186209);
    if (this.hjC == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because otherStats == null");
      AppMethodBeat.o(186209);
      return 0;
    }
    try
    {
      int i = f(this.hjC, 4);
      AppMethodBeat.o(186209);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGfx fail, because getOtherPrivate fail");
      AppMethodBeat.o(186209);
    }
    return 0;
  }
  
  public final int axv()
  {
    AppMethodBeat.i(186210);
    if (this.hjC == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because otherStats == null");
      AppMethodBeat.o(186210);
      return 0;
    }
    try
    {
      int i = f(this.hjC, 14);
      AppMethodBeat.o(186210);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getEGL fail, because getOtherPrivate fail");
      AppMethodBeat.o(186210);
    }
    return 0;
  }
  
  public final int axw()
  {
    AppMethodBeat.i(186211);
    if (this.hjC == null)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(186211);
      return 0;
    }
    try
    {
      int i = f(this.hjC, 15);
      AppMethodBeat.o(186211);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(186211);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.gpu.f.a
 * JD-Core Version:    0.7.0.1
 */