package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public final class b
{
  public static String I(o paramo)
  {
    AppMethodBeat.i(177457);
    try
    {
      Log.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
      Object localObject = g.ala(aa.z(paramo.her()));
      if (localObject == null)
      {
        AppMethodBeat.o(177457);
        return null;
      }
      c localc = new c();
      localc.W((byte[])localObject);
      localObject = localc.qHA.getProperty("channelId");
      AppMethodBeat.o(177457);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", new Object[] { aa.z(paramo.her()) });
      AppMethodBeat.o(177457);
    }
    return null;
  }
  
  public static String J(o paramo)
  {
    AppMethodBeat.i(177458);
    Log.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
    if ((!paramo.exists()) || (!paramo.isFile())) {
      paramo = null;
    }
    while (paramo == null)
    {
      AppMethodBeat.o(177458);
      return null;
      if ((!paramo.exists()) || (!paramo.isFile())) {
        paramo = null;
      }
      for (;;)
      {
        if (paramo == null) {
          break label130;
        }
        localObject = paramo.array();
        int i = paramo.arrayOffset();
        int j = paramo.position();
        int k = paramo.arrayOffset();
        paramo = Arrays.copyOfRange((byte[])localObject, i + j, paramo.limit() + k);
        break;
        paramo = d.K(paramo);
        if (paramo != null) {
          paramo = (ByteBuffer)paramo.get(Integer.valueOf(1903261812));
        } else {
          paramo = null;
        }
      }
      label130:
      paramo = null;
    }
    Object localObject = new c();
    ((c)localObject).W(paramo);
    paramo = ((c)localObject).qHA.getProperty("channelId");
    AppMethodBeat.o(177458);
    return paramo;
  }
  
  public static boolean akZ(String paramString)
  {
    AppMethodBeat.i(88860);
    try
    {
      boolean bool = a.akY(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.b
 * JD-Core Version:    0.7.0.1
 */