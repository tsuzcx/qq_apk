package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.ccp;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class k$b
  extends k.e
  implements k.c
{
  public ccp jML = new ccp();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.jML = ((ccp)new ccp().aH(paramArrayOfByte));
    k.a(this, this.jML.tFx);
    return this.jML.tFx.sze;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.b
 * JD-Core Version:    0.7.0.1
 */