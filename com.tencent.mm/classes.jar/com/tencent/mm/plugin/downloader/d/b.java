package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public final class b
{
  public static String E(k paramk)
  {
    AppMethodBeat.i(177457);
    try
    {
      ae.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
      Object localObject = g.aaT(w.B(paramk.fTh()));
      if (localObject == null)
      {
        AppMethodBeat.o(177457);
        return null;
      }
      c localc = new c();
      localc.I((byte[])localObject);
      localObject = localc.prV.getProperty("channelId");
      AppMethodBeat.o(177457);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", new Object[] { w.B(paramk.fTh()) });
      AppMethodBeat.o(177457);
    }
    return null;
  }
  
  public static String F(k paramk)
  {
    AppMethodBeat.i(177458);
    ae.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
    if ((!paramk.exists()) || (!paramk.isFile())) {
      paramk = null;
    }
    while (paramk == null)
    {
      AppMethodBeat.o(177458);
      return null;
      if ((!paramk.exists()) || (!paramk.isFile())) {
        paramk = null;
      }
      for (;;)
      {
        if (paramk == null) {
          break label130;
        }
        localObject = paramk.array();
        int i = paramk.arrayOffset();
        int j = paramk.position();
        int k = paramk.arrayOffset();
        paramk = Arrays.copyOfRange((byte[])localObject, i + j, paramk.limit() + k);
        break;
        paramk = d.G(paramk);
        if (paramk != null) {
          paramk = (ByteBuffer)paramk.get(Integer.valueOf(1903261812));
        } else {
          paramk = null;
        }
      }
      label130:
      paramk = null;
    }
    Object localObject = new c();
    ((c)localObject).I(paramk);
    paramk = ((c)localObject).prV.getProperty("channelId");
    AppMethodBeat.o(177458);
    return paramk;
  }
  
  public static boolean aaS(String paramString)
  {
    AppMethodBeat.i(88860);
    try
    {
      boolean bool = a.aaR(paramString);
      AppMethodBeat.o(88860);
      return bool;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(88860);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.b
 * JD-Core Version:    0.7.0.1
 */