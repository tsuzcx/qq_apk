package com.tencent.mm.plugin.downloader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public final class b
{
  public static String J(u paramu)
  {
    AppMethodBeat.i(177457);
    try
    {
      Log.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
      Object localObject = g.amI(ah.v(paramu.jKT()));
      if (localObject == null)
      {
        AppMethodBeat.o(177457);
        return null;
      }
      c localc = new c();
      localc.ad((byte[])localObject);
      localObject = localc.xmI.getProperty("channelId");
      AppMethodBeat.o(177457);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", new Object[] { ah.v(paramu.jKT()) });
      AppMethodBeat.o(177457);
    }
    return null;
  }
  
  public static String K(u paramu)
  {
    AppMethodBeat.i(177458);
    Log.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
    if ((!paramu.jKS()) || (!paramu.jKV())) {
      paramu = null;
    }
    while (paramu == null)
    {
      AppMethodBeat.o(177458);
      return null;
      if ((!paramu.jKS()) || (!paramu.jKV())) {
        paramu = null;
      }
      for (;;)
      {
        if (paramu == null) {
          break label130;
        }
        localObject = paramu.array();
        int i = paramu.arrayOffset();
        int j = paramu.position();
        int k = paramu.arrayOffset();
        paramu = Arrays.copyOfRange((byte[])localObject, i + j, paramu.limit() + k);
        break;
        paramu = d.L(paramu);
        if (paramu != null) {
          paramu = (ByteBuffer)paramu.get(Integer.valueOf(1903261812));
        } else {
          paramu = null;
        }
      }
      label130:
      paramu = null;
    }
    Object localObject = new c();
    ((c)localObject).ad(paramu);
    paramu = ((c)localObject).xmI.getProperty("channelId");
    AppMethodBeat.o(177458);
    return paramu;
  }
  
  public static boolean amH(String paramString)
  {
    AppMethodBeat.i(88860);
    try
    {
      boolean bool = a.amG(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b
 * JD-Core Version:    0.7.0.1
 */