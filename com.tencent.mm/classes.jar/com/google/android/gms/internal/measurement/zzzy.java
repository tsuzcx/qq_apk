package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzzy
{
  private static final zzzi zzbsw;
  private zzyw zzbsx;
  private volatile zzaal zzbsy;
  private volatile zzyw zzbsz;
  
  static
  {
    AppMethodBeat.i(40392);
    zzbsw = zzzi.zzte();
    AppMethodBeat.o(40392);
  }
  
  /* Error */
  private final zzaal zzb(zzaal paramzzaal)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 41	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 41	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   22: areturn
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 41	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   28: aload_0
    //   29: getstatic 46	com/google/android/gms/internal/measurement/zzyw:zzbqx	Lcom/google/android/gms/internal/measurement/zzyw;
    //   32: putfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   35: aload_0
    //   36: monitorexit
    //   37: goto -19 -> 18
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: astore_2
    //   46: aload_0
    //   47: aload_1
    //   48: putfield 41	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   51: aload_0
    //   52: getstatic 46	com/google/android/gms/internal/measurement/zzyw:zzbqx	Lcom/google/android/gms/internal/measurement/zzyw;
    //   55: putfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   58: goto -23 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	zzzy
    //   0	61	1	paramzzaal	zzaal
    //   45	1	2	localzzzt	zzzt
    // Exception table:
    //   from	to	target	type
    //   9	18	40	finally
    //   23	35	40	finally
    //   35	37	40	finally
    //   46	58	40	finally
    //   23	35	45	com/google/android/gms/internal/measurement/zzzt
  }
  
  /* Error */
  private final zzyw zztp()
  {
    // Byte code:
    //   0: ldc 51
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   9: ifnull +15 -> 24
    //   12: aload_0
    //   13: getfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   16: astore_1
    //   17: ldc 51
    //   19: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   30: ifnull +17 -> 47
    //   33: aload_0
    //   34: getfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: ldc 51
    //   42: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_1
    //   46: areturn
    //   47: aload_0
    //   48: getfield 41	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   51: ifnonnull +24 -> 75
    //   54: aload_0
    //   55: getstatic 46	com/google/android/gms/internal/measurement/zzyw:zzbqx	Lcom/google/android/gms/internal/measurement/zzyw;
    //   58: putfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   61: aload_0
    //   62: getfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: ldc 51
    //   70: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_1
    //   74: areturn
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 41	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   80: invokeinterface 55 1 0
    //   85: putfield 48	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   88: goto -27 -> 61
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: ldc 51
    //   96: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zzzy
    //   16	58	1	localzzyw	zzyw
    //   91	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	40	91	finally
    //   47	61	91	finally
    //   61	68	91	finally
    //   75	88	91	finally
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40390);
    if (this == paramObject)
    {
      AppMethodBeat.o(40390);
      return true;
    }
    if (!(paramObject instanceof zzzy))
    {
      AppMethodBeat.o(40390);
      return false;
    }
    paramObject = (zzzy)paramObject;
    zzaal localzzaal1 = this.zzbsy;
    zzaal localzzaal2 = paramObject.zzbsy;
    if ((localzzaal1 == null) && (localzzaal2 == null))
    {
      bool = zztp().equals(paramObject.zztp());
      AppMethodBeat.o(40390);
      return bool;
    }
    if ((localzzaal1 != null) && (localzzaal2 != null))
    {
      bool = localzzaal1.equals(localzzaal2);
      AppMethodBeat.o(40390);
      return bool;
    }
    if (localzzaal1 != null)
    {
      bool = localzzaal1.equals(paramObject.zzb(localzzaal1.zztz()));
      AppMethodBeat.o(40390);
      return bool;
    }
    boolean bool = zzb(localzzaal2.zztz()).equals(localzzaal2);
    AppMethodBeat.o(40390);
    return bool;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final zzaal zzc(zzaal paramzzaal)
  {
    zzaal localzzaal = this.zzbsy;
    this.zzbsx = null;
    this.zzbsz = null;
    this.zzbsy = paramzzaal;
    return localzzaal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzy
 * JD-Core Version:    0.7.0.1
 */