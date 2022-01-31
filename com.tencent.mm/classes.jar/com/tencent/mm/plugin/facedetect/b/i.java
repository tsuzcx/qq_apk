package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class i
{
  public static final class b
    extends k.e
    implements k.c
  {
    public ach jMH = new ach();
    
    public final int A(byte[] paramArrayOfByte)
    {
      this.jMH = ((ach)new ach().aH(paramArrayOfByte));
      k.a(this, this.jMH.tFx);
      return this.jMH.tFx.sze;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i
 * JD-Core Version:    0.7.0.1
 */