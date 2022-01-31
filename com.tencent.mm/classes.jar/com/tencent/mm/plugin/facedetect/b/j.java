package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bk;

public final class j
{
  public static final class a
    extends k.d
    implements k.b
  {
    public bkc jMI = new bkc();
    
    public final byte[] HG()
    {
      this.spM = y.cph();
      this.jMI.sBt = new bmk().bs(bk.crT());
      this.jMI.tEX = k.a(this);
      this.spL = this.jMI.sBt.tFM.toByteArray();
      return this.jMI.toByteArray();
    }
    
    public final int HH()
    {
      return 931;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public bkd jMJ = new bkd();
    
    public final int A(byte[] paramArrayOfByte)
    {
      this.jMJ = ((bkd)new bkd().aH(paramArrayOfByte));
      k.a(this, this.jMJ.tFx);
      return this.jMJ.tFx.sze;
    }
    
    public final int getCmdId()
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j
 * JD-Core Version:    0.7.0.1
 */