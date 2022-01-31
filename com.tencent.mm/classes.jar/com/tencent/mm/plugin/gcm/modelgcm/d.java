package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class d
{
  public static final class b
    extends k.e
    implements k.c
  {
    public cv lhv = new cv();
    
    public final int A(byte[] paramArrayOfByte)
    {
      this.lhv = ((cv)new cv().aH(paramArrayOfByte));
      k.a(this, this.lhv.tFx);
      return this.lhv.tFx.sze;
    }
    
    public final int getCmdId()
    {
      return 1000000241;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.d
 * JD-Core Version:    0.7.0.1
 */