package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
{
  public int[] iHj;
  public int iHk;
  private String iHl;
  private long iHm;
  
  public a(int paramInt)
  {
    this.iHk = paramInt;
  }
  
  public a(int[] paramArrayOfInt)
  {
    this.iHj = paramArrayOfInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186984);
    String str = "OpenGLInfo{ids=" + Arrays.toString(this.iHj) + ", error=" + this.iHk + ", javaStack='" + this.iHl + '\'' + ", nativeStack=" + this.iHm + '}';
    AppMethodBeat.o(186984);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openglapihook.a
 * JD-Core Version:    0.7.0.1
 */