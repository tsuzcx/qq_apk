package com.google.c.b.b;

import com.google.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class c
  extends b
{
  private static Class dHY;
  private final Object dHZ;
  private final Field dIa;
  
  c()
  {
    AppMethodBeat.i(107924);
    this.dHZ = Zx();
    this.dIa = Zy();
    AppMethodBeat.o(107924);
  }
  
  private static Object Zx()
  {
    AppMethodBeat.i(107927);
    try
    {
      Object localObject = Class.forName("sun.misc.Unsafe");
      dHY = (Class)localObject;
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
  
  private static Field Zy()
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
  
  private boolean b(AccessibleObject paramAccessibleObject)
  {
    AppMethodBeat.i(107926);
    if ((this.dHZ != null) && (this.dIa != null)) {
      try
      {
        long l = ((Long)dHY.getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(this.dHZ, new Object[] { this.dIa })).longValue();
        dHY.getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE }).invoke(this.dHZ, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.TRUE });
        AppMethodBeat.o(107926);
        return true;
      }
      catch (Exception paramAccessibleObject) {}
    }
    AppMethodBeat.o(107926);
    return false;
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
        paramAccessibleObject = new j("Gson couldn't modify fields for " + paramAccessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", localSecurityException);
        AppMethodBeat.o(107925);
        throw paramAccessibleObject;
      }
    }
    AppMethodBeat.o(107925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.c.b.b.c
 * JD-Core Version:    0.7.0.1
 */