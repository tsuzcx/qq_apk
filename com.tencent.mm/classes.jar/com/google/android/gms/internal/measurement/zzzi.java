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
    AppMethodBeat.i(3568);
    zzbrm = false;
    zzbrn = zztd();
    zzbro = new zzzi(true);
    AppMethodBeat.o(3568);
  }
  
  zzzi()
  {
    AppMethodBeat.i(3566);
    this.zzbrp = new HashMap();
    AppMethodBeat.o(3566);
  }
  
  private zzzi(boolean paramBoolean)
  {
    AppMethodBeat.i(3567);
    this.zzbrp = Collections.emptyMap();
    AppMethodBeat.o(3567);
  }
  
  private static Class<?> zztd()
  {
    AppMethodBeat.i(3564);
    try
    {
      Class localClass = Class.forName("com.google.protobuf.Extension");
      AppMethodBeat.o(3564);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(3564);
    }
    return null;
  }
  
  public static zzzi zzte()
  {
    AppMethodBeat.i(3565);
    zzzi localzzzi = zzzh.zztc();
    AppMethodBeat.o(3565);
    return localzzzi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzi
 * JD-Core Version:    0.7.0.1
 */