package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ab.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class b$5
  extends ab.a
{
  private byte[] hqn;
  
  public b$5(b paramb) {}
  
  public final int ac(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132051);
    aa.b localb = new aa.b();
    try
    {
      localb.fromProtoBuf(paramArrayOfByte);
      long l = localb.KAs;
      int i = (int)l;
      AppMethodBeat.o(132051);
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { Util.stackTraceToString(paramArrayOfByte) });
      AppMethodBeat.o(132051);
    }
    return 0;
  }
  
  public final byte[] azB()
  {
    AppMethodBeat.i(132050);
    if (!g.aAc())
    {
      AppMethodBeat.o(132050);
      return null;
    }
    aa.a locala = new aa.a();
    g.aAi();
    g.aAf();
    locala.setUin(a.getUin());
    g.aAi();
    locala.jcK = Util.decodeHexString((String)g.aAh().azQ().get(8195, null));
    locala.netType = com.tencent.mm.protocal.a.getNetType(MMApplicationContext.getContext());
    locala.KzG = com.tencent.mm.protocal.a.gtq();
    try
    {
      byte[] arrayOfByte = locala.toProtoBuf();
      this.hqn = locala.hqn;
      AppMethodBeat.o(132050);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MMKernel.CoreNetwork", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(132050);
    }
    return null;
  }
  
  public final byte[] azC()
  {
    return this.hqn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.b.5
 * JD-Core Version:    0.7.0.1
 */