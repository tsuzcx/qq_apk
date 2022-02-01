package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ab.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class b$5
  extends ab.a
{
  private byte[] gDA;
  
  public b$5(b paramb) {}
  
  public final int O(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132051);
    aa.b localb = new aa.b();
    try
    {
      localb.fromProtoBuf(paramArrayOfByte);
      long l = localb.FHg;
      int i = (int)l;
      AppMethodBeat.o(132051);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bu.o(paramArrayOfByte) });
      AppMethodBeat.o(132051);
    }
    return 0;
  }
  
  public final byte[] ajl()
  {
    AppMethodBeat.i(132050);
    if (!g.ajM())
    {
      AppMethodBeat.o(132050);
      return null;
    }
    aa.a locala = new aa.a();
    g.ajS();
    g.ajP();
    locala.setUin(a.getUin());
    g.ajS();
    locala.ihP = bu.aSx((String)g.ajR().ajA().get(8195, null));
    locala.netType = com.tencent.mm.protocal.a.getNetType(ak.getContext());
    locala.FGv = com.tencent.mm.protocal.a.fjP();
    try
    {
      byte[] arrayOfByte = locala.toProtoBuf();
      this.gDA = locala.gDA;
      AppMethodBeat.o(132050);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ae.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bu.o(localException) });
      AppMethodBeat.o(132050);
    }
    return null;
  }
  
  public final byte[] ajm()
  {
    return this.gDA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.5
 * JD-Core Version:    0.7.0.1
 */