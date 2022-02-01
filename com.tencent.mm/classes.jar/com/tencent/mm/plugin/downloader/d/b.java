package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public final class b
{
  public static String H(q paramq)
  {
    AppMethodBeat.i(177457);
    try
    {
      Log.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
      Object localObject = g.asT(paramq.bOF());
      if (localObject == null)
      {
        AppMethodBeat.o(177457);
        return null;
      }
      c localc = new c();
      localc.ad((byte[])localObject);
      localObject = localc.ugB.getProperty("channelId");
      AppMethodBeat.o(177457);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", new Object[] { paramq.bOF() });
      AppMethodBeat.o(177457);
    }
    return null;
  }
  
  public static String I(q paramq)
  {
    AppMethodBeat.i(177458);
    Log.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
    if ((!paramq.ifE()) || (!paramq.ifH())) {
      paramq = null;
    }
    while (paramq == null)
    {
      AppMethodBeat.o(177458);
      return null;
      if ((!paramq.ifE()) || (!paramq.ifH())) {
        paramq = null;
      }
      for (;;)
      {
        if (paramq == null) {
          break label130;
        }
        localObject = paramq.array();
        int i = paramq.arrayOffset();
        int j = paramq.position();
        int k = paramq.arrayOffset();
        paramq = Arrays.copyOfRange((byte[])localObject, i + j, paramq.limit() + k);
        break;
        paramq = d.J(paramq);
        if (paramq != null) {
          paramq = (ByteBuffer)paramq.get(Integer.valueOf(1903261812));
        } else {
          paramq = null;
        }
      }
      label130:
      paramq = null;
    }
    Object localObject = new c();
    ((c)localObject).ad(paramq);
    paramq = ((c)localObject).ugB.getProperty("channelId");
    AppMethodBeat.o(177458);
    return paramq;
  }
  
  public static boolean asS(String paramString)
  {
    AppMethodBeat.i(88860);
    try
    {
      boolean bool = a.asR(paramString);
      AppMethodBeat.o(88860);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(88860);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.b
 * JD-Core Version:    0.7.0.1
 */