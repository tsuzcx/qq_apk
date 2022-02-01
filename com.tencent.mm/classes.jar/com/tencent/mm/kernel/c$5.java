package com.tencent.mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.a;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.aa.b;
import com.tencent.mm.protocal.ab.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class c$5
  extends ab.a
{
  private byte[] kci;
  
  public c$5(c paramc) {}
  
  public final byte[] aHa()
  {
    AppMethodBeat.i(132050);
    if (!h.aHB())
    {
      AppMethodBeat.o(132050);
      return null;
    }
    aa.a locala = new aa.a();
    h.aHH();
    h.aHE();
    locala.setUin(b.getUin());
    h.aHH();
    locala.lTj = Util.decodeHexString((String)h.aHG().aHp().b(8195, null));
    locala.netType = a.getNetType(MMApplicationContext.getContext());
    locala.RBw = a.hoC();
    try
    {
      byte[] arrayOfByte = locala.toProtoBuf();
      this.kci = locala.kci;
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
  
  public final byte[] aHb()
  {
    return this.kci;
  }
  
  public final int ak(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132051);
    aa.b localb = new aa.b();
    try
    {
      localb.fromProtoBuf(paramArrayOfByte);
      long l = localb.RCi;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.kernel.c.5
 * JD-Core Version:    0.7.0.1
 */