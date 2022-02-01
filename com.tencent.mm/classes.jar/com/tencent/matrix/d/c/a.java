package com.tencent.matrix.d.c;

import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import com.tencent.matrix.g.c;
import java.lang.reflect.Method;

public final class a
{
  private static Method cWa = null;
  
  public static int a(Debug.MemoryInfo paramMemoryInfo)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return -1;
    }
    return paramMemoryInfo.dalvikPrivateDirty + paramMemoryInfo.nativePrivateDirty + paramMemoryInfo.otherPrivateDirty + paramMemoryInfo.getTotalPrivateClean();
  }
  
  public static int a(String paramString, Debug.MemoryInfo paramMemoryInfo)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return -1;
    }
    try
    {
      if (cWa == null) {
        cWa = Class.forName("android.os.Debug$MemoryInfo").getMethod("getMemoryStat", new Class[] { String.class });
      }
      int i = Integer.parseInt((String)cWa.invoke(paramMemoryInfo, new Object[] { paramString }));
      return i;
    }
    catch (Exception paramString)
    {
      c.e("Matrix.DebugMemoryInfoUtil", paramString.toString(), new Object[0]);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.d.c.a
 * JD-Core Version:    0.7.0.1
 */