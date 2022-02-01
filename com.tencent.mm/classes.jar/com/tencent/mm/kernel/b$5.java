package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ab.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class b$5
  extends ab.a
{
  private byte[] ghj;
  
  public b$5(b paramb) {}
  
  public final int P(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132051);
    aa.b localb = new aa.b();
    try
    {
      localb.fromProtoBuf(paramArrayOfByte);
      long l = localb.DJB;
      int i = (int)l;
      AppMethodBeat.o(132051);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bs.m(paramArrayOfByte) });
      AppMethodBeat.o(132051);
    }
    return 0;
  }
  
  public final byte[] agk()
  {
    AppMethodBeat.i(132050);
    if (!g.agM())
    {
      AppMethodBeat.o(132050);
      return null;
    }
    aa.a locala = new aa.a();
    g.agS();
    g.agP();
    locala.setUin(a.getUin());
    g.agS();
    locala.hMd = bs.aLu((String)g.agR().agA().get(8195, null));
    locala.netType = com.tencent.mm.protocal.a.getNetType(ai.getContext());
    locala.DIQ = com.tencent.mm.protocal.a.eQV();
    try
    {
      byte[] arrayOfByte = locala.toProtoBuf();
      this.ghj = locala.ghj;
      AppMethodBeat.o(132050);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(132050);
    }
    return null;
  }
  
  public final byte[] agl()
  {
    return this.ghj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.5
 * JD-Core Version:    0.7.0.1
 */