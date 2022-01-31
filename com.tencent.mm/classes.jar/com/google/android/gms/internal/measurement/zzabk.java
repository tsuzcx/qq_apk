package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzabk
{
  private static final zzabk zzbuj;
  private int count = 0;
  private int zzbrz = -1;
  private int[] zzbuk;
  private Object[] zzbul;
  private boolean zzbum;
  
  static
  {
    AppMethodBeat.i(3414);
    zzbuj = new zzabk(0, new int[0], new Object[0], false);
    AppMethodBeat.o(3414);
  }
  
  private zzabk()
  {
    this(0, new int[8], new Object[8], true);
    AppMethodBeat.i(3413);
    AppMethodBeat.o(3413);
  }
  
  private zzabk(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.zzbuk = paramArrayOfInt;
    this.zzbul = paramArrayOfObject;
    this.zzbum = paramBoolean;
  }
  
  public static zzabk zzuq()
  {
    return zzbuj;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
    } while ((paramObject instanceof zzabk));
    return false;
  }
  
  public final int hashCode()
  {
    return 506991;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabk
 * JD-Core Version:    0.7.0.1
 */