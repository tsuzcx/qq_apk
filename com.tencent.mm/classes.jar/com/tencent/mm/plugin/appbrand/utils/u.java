package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class u
{
  public static boolean Fv()
  {
    AppMethodBeat.i(217136);
    Class localClass = Class.forName("com.huawei.android.os.SystemPropertiesEx");
    boolean bool = ((Boolean)localClass.getMethod("getBoolean", new Class[] { String.class, Boolean.TYPE }).invoke(localClass.newInstance(), new Object[] { "ro.config.hw_magic_window_enable", Boolean.FALSE })).booleanValue();
    AppMethodBeat.o(217136);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.u
 * JD-Core Version:    0.7.0.1
 */