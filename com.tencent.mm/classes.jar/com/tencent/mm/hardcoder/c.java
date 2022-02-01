package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static class c
  {
    public long mwI;
    public int mwY;
    public int mwZ;
    public int mxa;
    public int[] mxb;
    public int scene;
    
    public c(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(62457);
      this.scene = paramInt1;
      this.mwI = paramLong;
      this.mwY = paramInt2;
      this.mwZ = paramInt3;
      this.mxa = paramInt4;
      this.mxb = ((int[])paramArrayOfInt.clone());
      AppMethodBeat.o(62457);
    }
    
    public String toString()
    {
      AppMethodBeat.i(62458);
      String str = "[RequestStatus, scene:" + this.scene + ", action:" + this.mwI + ", cpulevel:" + this.mwY + ", gpulevel:" + this.mwZ + ", iolevel:" + this.mxa + ", bindtids size:" + this.mxb.length + "]";
      AppMethodBeat.o(62458);
      return str;
    }
  }
  
  public static abstract interface d
  {
    public abstract void sceneReport(int paramInt, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.c
 * JD-Core Version:    0.7.0.1
 */