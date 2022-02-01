package com.google.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  private static final Map<Class<?>, Class<?>> bEh;
  private static final Map<Class<?>, Class<?>> bEi;
  
  static
  {
    AppMethodBeat.i(107973);
    HashMap localHashMap1 = new HashMap(16);
    HashMap localHashMap2 = new HashMap(16);
    a(localHashMap1, localHashMap2, Boolean.TYPE, Boolean.class);
    a(localHashMap1, localHashMap2, Byte.TYPE, Byte.class);
    a(localHashMap1, localHashMap2, Character.TYPE, Character.class);
    a(localHashMap1, localHashMap2, Double.TYPE, Double.class);
    a(localHashMap1, localHashMap2, Float.TYPE, Float.class);
    a(localHashMap1, localHashMap2, Integer.TYPE, Integer.class);
    a(localHashMap1, localHashMap2, Long.TYPE, Long.class);
    a(localHashMap1, localHashMap2, Short.TYPE, Short.class);
    a(localHashMap1, localHashMap2, Void.TYPE, Void.class);
    bEh = Collections.unmodifiableMap(localHashMap1);
    bEi = Collections.unmodifiableMap(localHashMap2);
    AppMethodBeat.o(107973);
  }
  
  private static void a(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(107971);
    paramMap1.put(paramClass1, paramClass2);
    paramMap2.put(paramClass2, paramClass1);
    AppMethodBeat.o(107971);
  }
  
  public static boolean g(Type paramType)
  {
    AppMethodBeat.i(107972);
    boolean bool = bEh.containsKey(paramType);
    AppMethodBeat.o(107972);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.b.j
 * JD-Core Version:    0.7.0.1
 */