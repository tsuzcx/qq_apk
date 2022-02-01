package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

@Deprecated
public final class k
  extends j.b
{
  private brj hoG;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(43058);
    this.hoG = new brj();
    this.hoG.DPj = 2048;
    this.hoG.Dby = new cmf().aEE(bt.nullAsNil(paramString1));
    this.hoG.DFJ = new cmf().aEE(bt.nullAsNil(paramString2));
    this.hoG.CuF = 0;
    this.hoG.DPk = new cmf().aEE(bt.nullAsNil(paramString3));
    this.hoG.DPl = new cmf().aEE(bt.nullAsNil(paramString4));
    this.hoG.mBi = 0;
    paramString2 = i.aR(bt.nullAsNil(paramString5), 0, -1);
    paramString3 = this.hoG;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.DPh = new b(paramString1);
      paramString1 = this.hoG;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.DPg = i;
      this.hoG.ijM = 0;
      this.hoG.ijQ = 0;
      this.hoG.ijP = bt.nullAsNil(paramString6);
      this.hoG.ijO = bt.nullAsNil(paramString7);
      this.hoG.ijN = bt.nullAsNil(paramString8);
      this.hoG.CuI = paramInt;
      this.hoG.DIX = bt.nullAsNil(paramString9);
      this.hoG.DPq = 0;
      this.hoG.ijR = bt.nullAsNil(paramString10);
      this.hoG.DIZ = 0;
      this.hoG.DIY = "";
      this.tyM = this.hoG;
      AppMethodBeat.o(43058);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bb.k
 * JD-Core Version:    0.7.0.1
 */