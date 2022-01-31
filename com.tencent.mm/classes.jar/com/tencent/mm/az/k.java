package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

@Deprecated
public final class k
  extends j.b
{
  private beq fLU;
  
  public k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(59999);
    this.fLU = new beq();
    this.fLU.xug = 2048;
    this.fLU.wOT = new bwc().aoF(bo.nullAsNil(paramString1));
    this.fLU.xmi = new bwc().aoF(bo.nullAsNil(paramString2));
    this.fLU.wmq = 0;
    this.fLU.xuh = new bwc().aoF(bo.nullAsNil(paramString3));
    this.fLU.xui = new bwc().aoF(bo.nullAsNil(paramString4));
    this.fLU.jJS = 0;
    paramString2 = e.i(bo.nullAsNil(paramString5), 0, -1);
    paramString3 = this.fLU;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.xue = new b(paramString1);
      paramString1 = this.fLU;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.xud = i;
      this.fLU.gwP = 0;
      this.fLU.gwT = 0;
      this.fLU.gwS = bo.nullAsNil(paramString6);
      this.fLU.gwR = bo.nullAsNil(paramString7);
      this.fLU.gwQ = bo.nullAsNil(paramString8);
      this.fLU.wmt = paramInt;
      this.fLU.xpg = bo.nullAsNil(paramString9);
      this.fLU.xun = 0;
      this.fLU.gwU = bo.nullAsNil(paramString10);
      this.fLU.xpi = 0;
      this.fLU.xph = "";
      this.oDZ = this.fLU;
      AppMethodBeat.o(59999);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.az.k
 * JD-Core Version:    0.7.0.1
 */