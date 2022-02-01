package com.tencent.mm.ext.b;

import android.content.Context;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static Boolean ifHUAWEI = null;
  private static String systemName = null;
  
  public static boolean huaweihasCutOut(Context paramContext)
  {
    AppMethodBeat.i(235309);
    if (paramContext == null)
    {
      AppMethodBeat.o(235309);
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
      boolean bool = ((Boolean)paramContext.getMethod("hasNotchInScreen", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(235309);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      b.e("MicroMsg.Vendor.Huawei", "hasCutOut, ClassNotFoundException!!", new Object[0]);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      b.e("MicroMsg.Vendor.Huawei", "hasCutOut, NoSuchMethodException!!", new Object[0]);
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      b.e("MicroMsg.Vendor.Huawei", "hasCutOut, IllegalAccessException!!", new Object[0]);
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      b.e("MicroMsg.Vendor.Huawei", "hasCutOut, InvocationTargetException!!", new Object[0]);
      return false;
    }
    finally
    {
      b.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(235309);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.b.a
 * JD-Core Version:    0.7.0.1
 */