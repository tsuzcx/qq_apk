package com.tencent.mm.ext.b;

import android.content.Context;
import com.tencent.liteapp.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class c
{
  public static boolean vivohasCutOut(Context paramContext)
  {
    AppMethodBeat.i(235310);
    if (paramContext == null)
    {
      AppMethodBeat.o(235310);
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(235310);
      return bool;
    }
    catch (ClassNotFoundException paramContext)
    {
      b.e("MicroMsg.Vendor.Vivo", "hasCutOut, ClassNotFoundException!!", new Object[0]);
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      b.e("MicroMsg.Vendor.Vivo", "hasCutOut, NoSuchMethodException!!", new Object[0]);
      return false;
    }
    catch (IllegalAccessException paramContext)
    {
      b.e("MicroMsg.Vendor.Vivo", "hasCutOut, IllegalAccessException!!", new Object[0]);
      return false;
    }
    catch (InvocationTargetException paramContext)
    {
      b.e("MicroMsg.Vendor.Vivo", "hasCutOut, InvocationTargetException!!", new Object[0]);
      return false;
    }
    finally
    {
      b.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(235310);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ext.b.c
 * JD-Core Version:    0.7.0.1
 */