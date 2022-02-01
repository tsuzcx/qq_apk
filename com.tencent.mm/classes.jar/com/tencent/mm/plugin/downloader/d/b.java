package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public final class b
{
  public static String E(e parame)
  {
    AppMethodBeat.i(177457);
    try
    {
      ad.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
      Object localObject = g.aac(q.B(parame.fOK()));
      if (localObject == null)
      {
        AppMethodBeat.o(177457);
        return null;
      }
      c localc = new c();
      localc.I((byte[])localObject);
      localObject = localc.plq.getProperty("channelId");
      AppMethodBeat.o(177457);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", new Object[] { q.B(parame.fOK()) });
      AppMethodBeat.o(177457);
    }
    return null;
  }
  
  public static String F(e parame)
  {
    AppMethodBeat.i(177458);
    ad.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
    if ((!parame.exists()) || (!parame.isFile())) {
      parame = null;
    }
    while (parame == null)
    {
      AppMethodBeat.o(177458);
      return null;
      if ((!parame.exists()) || (!parame.isFile())) {
        parame = null;
      }
      for (;;)
      {
        if (parame == null) {
          break label130;
        }
        localObject = parame.array();
        int i = parame.arrayOffset();
        int j = parame.position();
        int k = parame.arrayOffset();
        parame = Arrays.copyOfRange((byte[])localObject, i + j, parame.limit() + k);
        break;
        parame = d.G(parame);
        if (parame != null) {
          parame = (ByteBuffer)parame.get(Integer.valueOf(1903261812));
        } else {
          parame = null;
        }
      }
      label130:
      parame = null;
    }
    Object localObject = new c();
    ((c)localObject).I(parame);
    parame = ((c)localObject).plq.getProperty("channelId");
    AppMethodBeat.o(177458);
    return parame;
  }
  
  public static boolean aab(String paramString)
  {
    AppMethodBeat.i(88860);
    try
    {
      boolean bool = a.aaa(paramString);
      AppMethodBeat.o(88860);
      return bool;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(88860);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.b
 * JD-Core Version:    0.7.0.1
 */