package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c$c
{
  public long jWO;
  public int jXe;
  public int jXf;
  public int jXg;
  public int[] jXh;
  public int scene;
  
  public c$c(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62457);
    this.scene = paramInt1;
    this.jWO = paramLong;
    this.jXe = paramInt2;
    this.jXf = paramInt3;
    this.jXg = paramInt4;
    this.jXh = ((int[])paramArrayOfInt.clone());
    AppMethodBeat.o(62457);
  }
  
  public String toString()
  {
    AppMethodBeat.i(62458);
    String str = "[RequestStatus, scene:" + this.scene + ", action:" + this.jWO + ", cpulevel:" + this.jXe + ", gpulevel:" + this.jXf + ", iolevel:" + this.jXg + ", bindtids size:" + this.jXh.length + "]";
    AppMethodBeat.o(62458);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.hardcoder.c.c
 * JD-Core Version:    0.7.0.1
 */