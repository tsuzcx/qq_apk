package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
{
  public int[] iKc;
  public int iKd;
  private String iKe;
  private long iKf;
  
  public a(int paramInt)
  {
    this.iKd = paramInt;
  }
  
  public a(int[] paramArrayOfInt)
  {
    this.iKc = paramArrayOfInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193520);
    String str = "OpenGLInfo{ids=" + Arrays.toString(this.iKc) + ", error=" + this.iKd + ", javaStack='" + this.iKe + '\'' + ", nativeStack=" + this.iKf + '}';
    AppMethodBeat.o(193520);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openglapihook.a
 * JD-Core Version:    0.7.0.1
 */