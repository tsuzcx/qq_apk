package com.tencent.mm.openglapihook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a
{
  public int[] jGI;
  public int jGJ;
  private String jGK;
  private long jGL;
  
  public a(int paramInt)
  {
    this.jGJ = paramInt;
  }
  
  public a(int[] paramArrayOfInt)
  {
    this.jGI = paramArrayOfInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187622);
    String str = "OpenGLInfo{ids=" + Arrays.toString(this.jGI) + ", error=" + this.jGJ + ", javaStack='" + this.jGK + '\'' + ", nativeStack=" + this.jGL + '}';
    AppMethodBeat.o(187622);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openglapihook.a
 * JD-Core Version:    0.7.0.1
 */