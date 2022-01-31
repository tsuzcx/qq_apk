package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

final class zzaax
{
  private static final Class<?> zzbtt;
  private static final zzabj<?, ?> zzbtu;
  private static final zzabj<?, ?> zzbtv;
  private static final zzabj<?, ?> zzbtw;
  
  static
  {
    AppMethodBeat.i(3365);
    zzbtt = zzuh();
    zzbtu = zzu(false);
    zzbtv = zzu(true);
    zzbtw = new zzabl();
    AppMethodBeat.o(3365);
  }
  
  public static void zzh(Class<?> paramClass)
  {
    AppMethodBeat.i(3361);
    if ((!zzzq.class.isAssignableFrom(paramClass)) && (zzbtt != null) && (!zzbtt.isAssignableFrom(paramClass)))
    {
      paramClass = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
      AppMethodBeat.o(3361);
      throw paramClass;
    }
    AppMethodBeat.o(3361);
  }
  
  private static zzabj<?, ?> zzu(boolean paramBoolean)
  {
    AppMethodBeat.i(3362);
    try
    {
      Object localObject = zzui();
      if (localObject == null)
      {
        AppMethodBeat.o(3362);
        return null;
      }
      localObject = (zzabj)((Class)localObject).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(3362);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(3362);
    }
    return null;
  }
  
  public static zzabj<?, ?> zzue()
  {
    return zzbtu;
  }
  
  public static zzabj<?, ?> zzuf()
  {
    return zzbtv;
  }
  
  public static zzabj<?, ?> zzug()
  {
    return zzbtw;
  }
  
  private static Class<?> zzuh()
  {
    AppMethodBeat.i(3363);
    try
    {
      Class localClass = Class.forName("com.google.protobuf.GeneratedMessage");
      AppMethodBeat.o(3363);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(3363);
    }
    return null;
  }
  
  private static Class<?> zzui()
  {
    AppMethodBeat.i(3364);
    try
    {
      Class localClass = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
      AppMethodBeat.o(3364);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(3364);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaax
 * JD-Core Version:    0.7.0.1
 */