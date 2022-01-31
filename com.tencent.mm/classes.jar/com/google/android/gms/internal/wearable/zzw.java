package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzw
{
  private static final int zzhn = 11;
  private static final int zzho = 12;
  private static final int zzhp = 16;
  private static final int zzhq = 26;
  private static final int[] zzhr = new int[0];
  public static final long[] zzhs = new long[0];
  public static final float[] zzht = new float[0];
  private static final double[] zzhu = new double[0];
  private static final boolean[] zzhv = new boolean[0];
  public static final String[] zzhw = new String[0];
  private static final byte[][] zzhx = new byte[0][];
  public static final byte[] zzhy = new byte[0];
  
  public static final int zzb(zzk paramzzk, int paramInt)
  {
    AppMethodBeat.i(70784);
    int i = 1;
    int j = paramzzk.getPosition();
    paramzzk.zzd(paramInt);
    while (paramzzk.zzj() == paramInt)
    {
      paramzzk.zzd(paramInt);
      i += 1;
    }
    paramzzk.zzc(j, paramInt);
    AppMethodBeat.o(70784);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzw
 * JD-Core Version:    0.7.0.1
 */