package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ab.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class b$5
  extends ab.a
{
  private byte[] gcD;
  
  public b$5(b paramb) {}
  
  public final int R(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132051);
    aa.b localb = new aa.b();
    try
    {
      localb.fromProtoBuf(paramArrayOfByte);
      long l = localb.Crj;
      int i = (int)l;
      AppMethodBeat.o(132051);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bt.m(paramArrayOfByte) });
      AppMethodBeat.o(132051);
    }
    return 0;
  }
  
  public final byte[] aeU()
  {
    AppMethodBeat.i(132050);
    if (!g.afw())
    {
      AppMethodBeat.o(132050);
      return null;
    }
    aa.a locala = new aa.a();
    g.afC();
    g.afz();
    locala.setUin(a.getUin());
    g.afC();
    locala.hlA = bt.aGd((String)g.afB().afk().get(8195, null));
    locala.netType = com.tencent.mm.protocal.a.getNetType(aj.getContext());
    locala.Cqy = com.tencent.mm.protocal.a.eBB();
    try
    {
      byte[] arrayOfByte = locala.toProtoBuf();
      this.gcD = locala.gcD;
      AppMethodBeat.o(132050);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { bt.m(localException) });
      AppMethodBeat.o(132050);
    }
    return null;
  }
  
  public final byte[] aeV()
  {
    return this.gcD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kernel.b.5
 * JD-Core Version:    0.7.0.1
 */