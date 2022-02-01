package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ab.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class b$5
  extends ab.a
{
  private byte[] gAT;
  
  public b$5(b paramb) {}
  
  public final int O(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132051);
    aa.b localb = new aa.b();
    try
    {
      localb.fromProtoBuf(paramArrayOfByte);
      long l = localb.FoI;
      int i = (int)l;
      AppMethodBeat.o(132051);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bt.n(paramArrayOfByte) });
      AppMethodBeat.o(132051);
    }
    return 0;
  }
  
  public final byte[] aiW()
  {
    AppMethodBeat.i(132050);
    if (!g.ajx())
    {
      AppMethodBeat.o(132050);
      return null;
    }
    aa.a locala = new aa.a();
    g.ajD();
    g.ajA();
    locala.setUin(a.getUin());
    g.ajD();
    locala.ieX = bt.aRa((String)g.ajC().ajl().get(8195, null));
    locala.netType = com.tencent.mm.protocal.a.getNetType(aj.getContext());
    locala.FnX = com.tencent.mm.protocal.a.ffZ();
    try
    {
      byte[] arrayOfByte = locala.toProtoBuf();
      this.gAT = locala.gAT;
      AppMethodBeat.o(132050);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bt.n(localException) });
      AppMethodBeat.o(132050);
    }
    return null;
  }
  
  public final byte[] aiX()
  {
    return this.gAT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.5
 * JD-Core Version:    0.7.0.1
 */