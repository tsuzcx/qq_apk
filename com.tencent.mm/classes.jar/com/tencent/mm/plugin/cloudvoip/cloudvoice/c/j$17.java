package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class j$17
  implements f.a<rc, String>
{
  j$17(j paramj, a parama) {}
  
  private static rc ai(byte[] paramArrayOfByte)
  {
    rc localrc = new rc();
    try
    {
      localrc.aH(paramArrayOfByte);
      return localrc;
    }
    catch (IOException paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramArrayOfByte, "hy: unable to parse from data", new Object[0]);
    }
    return null;
  }
  
  public final boolean aEl()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.17
 * JD-Core Version:    0.7.0.1
 */