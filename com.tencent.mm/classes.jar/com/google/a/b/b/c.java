package com.google.a.b.b;

import com.google.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class c
  extends b
{
  private static Class bQv;
  private final Object bQw;
  private final Field bQx;
  
  c()
  {
    AppMethodBeat.i(107924);
    this.bQw = yU();
    this.bQx = yV();
    AppMethodBeat.o(107924);
  }
  
  private boolean b(AccessibleObject paramAccessibleObject)
  {
    AppMethodBeat.i(107926);
    if ((this.bQw != null) && (this.bQx != null)) {
      try
      {
        long l = ((Long)bQv.getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(this.bQw, new Object[] { this.bQx })).longValue();
        bQv.getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE }).invoke(this.bQw, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.TRUE });
        AppMethodBeat.o(107926);
        return true;
      }
      catch (Exception paramAccessibleObject) {}
    }
    AppMethodBeat.o(107926);
    return false;
  }
  
  private static Object yU()
  {
    AppMethodBeat.i(107927);
    try
    {
      Object localObject = Class.forName("sun.misc.Unsafe");
      bQv = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("theUnsafe");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      AppMethodBeat.o(107927);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(107927);
    }
    return null;
  }
  
  private static Field yV()
  {
    AppMethodBeat.i(107928);
    try
    {
      Field localField = AccessibleObject.class.getDeclaredField("override");
      AppMethodBeat.o(107928);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      AppMethodBeat.o(107928);
    }
    return null;
  }
  
  public final void a(AccessibleObject paramAccessibleObject)
  {
    AppMethodBeat.i(107925);
    if (!b(paramAccessibleObject)) {
      try
      {
        paramAccessibleObject.setAccessible(true);
        AppMethodBeat.o(107925);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        paramAccessibleObject = new l("Gson couldn't modify fields for " + paramAccessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", localSecurityException);
        AppMethodBeat.o(107925);
        throw paramAccessibleObject;
      }
    }
    AppMethodBeat.o(107925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */