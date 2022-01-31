package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class j$4
  implements f.a<String, rd>
{
  j$4(j paramj) {}
  
  private static byte[] a(rd paramrd)
  {
    if (paramrd != null) {
      try
      {
        paramrd = paramrd.toByteArray();
        return paramrd;
      }
      catch (IOException paramrd)
      {
        y.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", paramrd, "hy: error when convert to byte array", new Object[0]);
      }
    }
    return new byte[0];
  }
  
  public final boolean aEl()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.4
 * JD-Core Version:    0.7.0.1
 */