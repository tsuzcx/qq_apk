package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzzi
{
  private static volatile boolean zzbrm;
  private static final Class<?> zzbrn;
  static final zzzi zzbro;
  private final Map<Object, Object> zzbrp;
  
  static
  {
    AppMethodBeat.i(40358);
    zzbrm = false;
    zzbrn = zztd();
    zzbro = new zzzi(true);
    AppMethodBeat.o(40358);
  }
  
  zzzi()
  {
    AppMethodBeat.i(40356);
    this.zzbrp = new HashMap();
    AppMethodBeat.o(40356);
  }
  
  private zzzi(boolean paramBoolean)
  {
    AppMethodBeat.i(40357);
    this.zzbrp = Collections.emptyMap();
    AppMethodBeat.o(40357);
  }
  
  private static Class<?> zztd()
  {
    AppMethodBeat.i(40354);
    try
    {
      Class localClass = Class.forName("com.google.d.ap");
      AppMethodBeat.o(40354);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(40354);
    }
    return null;
  }
  
  public static zzzi zzte()
  {
    AppMethodBeat.i(40355);
    zzzi localzzzi = zzzh.zztc();
    AppMethodBeat.o(40355);
    return localzzzi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzi
 * JD-Core Version:    0.7.0.1
 */