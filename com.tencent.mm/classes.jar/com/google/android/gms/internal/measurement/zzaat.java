package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzaat
{
  private static final zzaat zzbtq;
  private final zzaaw zzbtr;
  private final ConcurrentMap<Class<?>, zzaav<?>> zzbts;
  
  static
  {
    AppMethodBeat.i(3357);
    zzbtq = new zzaat();
    AppMethodBeat.o(3357);
  }
  
  private zzaat()
  {
    AppMethodBeat.i(3355);
    this.zzbts = new ConcurrentHashMap();
    Object localObject1 = null;
    int i = 0;
    while (i <= 0)
    {
      localObject2 = zzfl(new String[] { "com.google.protobuf.AndroidProto3SchemaFactory" }[0]);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      i += 1;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new zzaad();
    }
    this.zzbtr = ((zzaaw)localObject2);
    AppMethodBeat.o(3355);
  }
  
  private static zzaaw zzfl(String paramString)
  {
    AppMethodBeat.i(3356);
    try
    {
      paramString = (zzaaw)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(3356);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(3356);
    }
    return null;
  }
  
  public static zzaat zzud()
  {
    return zzbtq;
  }
  
  public final <T> zzaav<T> zzt(T paramT)
  {
    AppMethodBeat.i(3354);
    Class localClass = paramT.getClass();
    zzzr.zza(localClass, "messageType");
    zzaav localzzaav = (zzaav)this.zzbts.get(localClass);
    paramT = localzzaav;
    if (localzzaav == null)
    {
      paramT = this.zzbtr.zzg(localClass);
      zzzr.zza(localClass, "messageType");
      zzzr.zza(paramT, "schema");
      localzzaav = (zzaav)this.zzbts.putIfAbsent(localClass, paramT);
      if (localzzaav == null) {
        break label92;
      }
      paramT = localzzaav;
    }
    label92:
    for (;;)
    {
      AppMethodBeat.o(3354);
      return paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzaat
 * JD-Core Version:    0.7.0.1
 */