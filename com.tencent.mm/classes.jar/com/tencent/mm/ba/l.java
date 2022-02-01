package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

@Deprecated
public final class l
  extends j.b
{
  private bwa hPj;
  
  public l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    AppMethodBeat.i(43058);
    this.hPj = new bwa();
    this.hPj.FlA = 2048;
    this.hPj.EuE = new crm().aJV(bs.nullAsNil(paramString1));
    this.hPj.Fbd = new crm().aJV(bs.nullAsNil(paramString2));
    this.hPj.DNa = 0;
    this.hPj.FlB = new crm().aJV(bs.nullAsNil(paramString3));
    this.hPj.FlC = new crm().aJV(bs.nullAsNil(paramString4));
    this.hPj.ndj = 0;
    paramString2 = i.aU(bs.nullAsNil(paramString5), 0, -1);
    paramString3 = this.hPj;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.Fly = new b(paramString1);
      paramString1 = this.hPj;
      if (paramString2 != null) {
        break label315;
      }
    }
    label315:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.Flx = i;
      this.hPj.iJT = 0;
      this.hPj.iJX = 0;
      this.hPj.iJW = bs.nullAsNil(paramString6);
      this.hPj.iJV = bs.nullAsNil(paramString7);
      this.hPj.iJU = bs.nullAsNil(paramString8);
      this.hPj.DNd = paramInt;
      this.hPj.Fes = bs.nullAsNil(paramString9);
      this.hPj.FlH = 0;
      this.hPj.iJY = bs.nullAsNil(paramString10);
      this.hPj.Feu = 0;
      this.hPj.Fet = "";
      this.uHj = this.hPj;
      AppMethodBeat.o(43058);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.l
 * JD-Core Version:    0.7.0.1
 */