package com.tencent.mm.gpu.f;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Field;

public final class a
{
  private int[] guh;
  
  public a()
  {
    AppMethodBeat.i(219554);
    this.guh = null;
    Object localObject = (ActivityManager)aj.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(219554);
      return;
    }
    localObject = ((ActivityManager)localObject).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(219554);
      return;
    }
    localObject = localObject[0];
    if (localObject == null)
    {
      AppMethodBeat.o(219554);
      return;
    }
    this.guh = b((Debug.MemoryInfo)localObject);
    AppMethodBeat.o(219554);
  }
  
  private static int[] b(Debug.MemoryInfo paramMemoryInfo)
  {
    AppMethodBeat.i(219558);
    try
    {
      Field localField = Class.forName("android.os.Debug$MemoryInfo").getDeclaredField("otherStats");
      localField.setAccessible(true);
      paramMemoryInfo = (int[])localField.get(paramMemoryInfo);
      AppMethodBeat.o(219558);
      return paramMemoryInfo;
    }
    catch (Exception paramMemoryInfo)
    {
      ad.e("Gpu.GpuMemoryGetter", "getOtherStatsByReflect fail");
      AppMethodBeat.o(219558);
    }
    return null;
  }
  
  private static int f(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(219559);
    int i = h(paramArrayOfInt, paramInt);
    paramInt = g(paramArrayOfInt, paramInt);
    AppMethodBeat.o(219559);
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
  
  public final int agT()
  {
    AppMethodBeat.i(219555);
    if (this.guh == null)
    {
      ad.e("Gpu.GpuMemoryGetter", "getGfx fail, because otherStats == null");
      AppMethodBeat.o(219555);
      return 0;
    }
    try
    {
      int i = f(this.guh, 4);
      AppMethodBeat.o(219555);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("Gpu.GpuMemoryGetter", "getGfx fail, because getOtherPrivate fail");
      AppMethodBeat.o(219555);
    }
    return 0;
  }
  
  public final int agU()
  {
    AppMethodBeat.i(219556);
    if (this.guh == null)
    {
      ad.e("Gpu.GpuMemoryGetter", "getEGL fail, because otherStats == null");
      AppMethodBeat.o(219556);
      return 0;
    }
    try
    {
      int i = f(this.guh, 14);
      AppMethodBeat.o(219556);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("Gpu.GpuMemoryGetter", "getEGL fail, because getOtherPrivate fail");
      AppMethodBeat.o(219556);
    }
    return 0;
  }
  
  public final int agV()
  {
    AppMethodBeat.i(219557);
    if (this.guh == null)
    {
      ad.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(219557);
      return 0;
    }
    try
    {
      int i = f(this.guh, 15);
      AppMethodBeat.o(219557);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("Gpu.GpuMemoryGetter", "getGL fail, because getOtherStats == null");
      AppMethodBeat.o(219557);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.f.a
 * JD-Core Version:    0.7.0.1
 */