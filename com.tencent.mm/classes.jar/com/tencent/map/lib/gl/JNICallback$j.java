package com.tencent.map.lib.gl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jj;
import java.util.Arrays;

public class JNICallback$j
{
  public float a;
  public int b;
  public int c;
  public int d;
  public boolean e;
  byte[] f;
  
  private JNICallback$j()
  {
    AppMethodBeat.i(147028);
    this.f = new byte[4];
    AppMethodBeat.o(147028);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(147029);
    Arrays.fill(this.f, (byte)0);
    System.arraycopy(paramArrayOfByte, 0, this.f, 0, 4);
    this.a = jj.c(this.f);
    System.arraycopy(paramArrayOfByte, 4, this.f, 0, 4);
    this.b = jj.a(this.f);
    System.arraycopy(paramArrayOfByte, 8, this.f, 0, 4);
    this.c = jj.a(this.f);
    System.arraycopy(paramArrayOfByte, 12, this.f, 0, 4);
    this.d = jj.a(this.f);
    System.arraycopy(paramArrayOfByte, 16, this.f, 0, 1);
    this.e = jj.b(this.f);
    AppMethodBeat.o(147029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.gl.JNICallback.j
 * JD-Core Version:    0.7.0.1
 */