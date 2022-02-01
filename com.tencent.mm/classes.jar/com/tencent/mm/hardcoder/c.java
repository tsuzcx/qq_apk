package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static abstract interface a
  {
    public abstract void dt(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onFuncRet(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte);
  }
  
  public static final class c
  {
    public int fXK;
    public int fXL;
    public int fXM;
    public int[] fXN;
    public long fXu;
    public int scene;
    
    public c(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(62457);
      this.scene = paramInt1;
      this.fXu = paramLong;
      this.fXK = paramInt2;
      this.fXL = paramInt3;
      this.fXM = paramInt4;
      this.fXN = ((int[])paramArrayOfInt.clone());
      AppMethodBeat.o(62457);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(62458);
      String str = "[RequestStatus, scene:" + this.scene + ", action:" + this.fXu + ", cpulevel:" + this.fXK + ", gpulevel:" + this.fXL + ", iolevel:" + this.fXM + ", bindtids size:" + this.fXN.length + "]";
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