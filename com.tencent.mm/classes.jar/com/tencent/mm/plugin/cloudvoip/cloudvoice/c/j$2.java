package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.protocal.c.rg;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class j$2
  implements f.a<rg, String>
{
  j$2(j paramj) {}
  
  private static rg ah(byte[] paramArrayOfByte)
  {
    rg localrg = new rg();
    try
    {
      localrg.aH(paramArrayOfByte);
      return localrg;
    }
    catch (IOException paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
    }
    return null;
  }
  
  public final boolean aEl()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.2
 * JD-Core Version:    0.7.0.1
 */