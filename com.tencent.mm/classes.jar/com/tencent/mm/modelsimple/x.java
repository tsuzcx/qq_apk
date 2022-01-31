package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.protocal.c.bqp;
import com.tencent.mm.sdk.platformtools.y;

public final class x
  extends m
  implements k
{
  private f dmL;
  public final b esv;
  
  public x(int paramInt, bkj parambkj)
  {
    y.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[] { Integer.valueOf(paramInt), parambkj.tEd, Integer.valueOf(parambkj.jxx), Integer.valueOf(parambkj.hQR), Integer.valueOf(parambkj.tAu) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqo();
    ((b.a)localObject).ecI = new bqp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setmsgremind";
    ((b.a)localObject).ecG = 525;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.esv = ((b.a)localObject).Kt();
    localObject = (bqo)this.esv.ecE.ecN;
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    ((bqo)localObject).kTS = i;
    ((bqo)localObject).tHE = parambkj;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      y.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[] { ((bqp)this.esv.ecF.ecN).tEd });
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    }
  }
  
  public final int getType()
  {
    return 525;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelsimple.x
 * JD-Core Version:    0.7.0.1
 */