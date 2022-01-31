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
    AppMethodBeat.i(3602);
    zzbsw = zzzi.zzte();
    AppMethodBeat.o(3602);
  }
  
  /* Error */
  private final zzaal zzb(zzaal paramzzaal)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 40	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   13: ifnull +10 -> 23
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_0
    //   19: getfield 40	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   22: areturn
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 40	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   28: aload_0
    //   29: getstatic 45	com/google/android/gms/internal/measurement/zzyw:zzbqx	Lcom/google/android/gms/internal/measurement/zzyw;
    //   32: putfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
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
    //   48: putfield 40	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   51: aload_0
    //   52: getstatic 45	com/google/android/gms/internal/measurement/zzyw:zzbqx	Lcom/google/android/gms/internal/measurement/zzyw;
    //   55: putfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
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
    //   41	43	40	finally
    //   46	58	40	finally
    //   23	35	45	com/google/android/gms/internal/measurement/zzzt
  }
  
  /* Error */
  private final zzyw zztp()
  {
    // Byte code:
    //   0: sipush 3601
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: getfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   17: astore_1
    //   18: sipush 3601
    //   21: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   32: ifnull +18 -> 50
    //   35: aload_0
    //   36: getfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: sipush 3601
    //   45: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: areturn
    //   50: aload_0
    //   51: getfield 40	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   54: ifnonnull +25 -> 79
    //   57: aload_0
    //   58: getstatic 45	com/google/android/gms/internal/measurement/zzyw:zzbqx	Lcom/google/android/gms/internal/measurement/zzyw;
    //   61: putfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   64: aload_0
    //   65: getfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: sipush 3601
    //   74: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: areturn
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 40	com/google/android/gms/internal/measurement/zzzy:zzbsy	Lcom/google/android/gms/internal/measurement/zzaal;
    //   84: invokeinterface 53 1 0
    //   89: putfield 47	com/google/android/gms/internal/measurement/zzzy:zzbsz	Lcom/google/android/gms/internal/measurement/zzyw;
    //   92: goto -28 -> 64
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: sipush 3601
    //   101: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	zzzy
    //   17	61	1	localzzyw	zzyw
    //   95	10	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   28	42	95	finally
    //   50	64	95	finally
    //   64	71	95	finally
    //   79	92	95	finally
    //   96	98	95	finally
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(3600);
    if (this == paramObject)
    {
      AppMethodBeat.o(3600);
      return true;
    }
    if (!(paramObject instanceof zzzy))
    {
      AppMethodBeat.o(3600);
      return false;
    }
    paramObject = (zzzy)paramObject;
    zzaal localzzaal1 = this.zzbsy;
    zzaal localzzaal2 = paramObject.zzbsy;
    if ((localzzaal1 == null) && (localzzaal2 == null))
    {
      bool = zztp().equals(paramObject.zztp());
      AppMethodBeat.o(3600);
      return bool;
    }
    if ((localzzaal1 != null) && (localzzaal2 != null))
    {
      bool = localzzaal1.equals(localzzaal2);
      AppMethodBeat.o(3600);
      return bool;
    }
    if (localzzaal1 != null)
    {
      bool = localzzaal1.equals(paramObject.zzb(localzzaal1.zztz()));
      AppMethodBeat.o(3600);
      return bool;
    }
    boolean bool = zzb(localzzaal2.zztz()).equals(localzzaal2);
    AppMethodBeat.o(3600);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzy
 * JD-Core Version:    0.7.0.1
 */