package com.tencent.mm.plugin.datareport.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.a.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Map;
import org.apache.commons.c.i;

public final class c
  implements b
{
  public final void ad(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262872);
    Log.i("DefaultDynamicPublicParamsProvider", "[setDynamicPublicParams]");
    Context localContext = MMApplicationContext.getContext();
    int i;
    if (NetStatusUtil.isConnected(localContext)) {
      if (NetStatusUtil.isWifi(localContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      paramMap.put("network_type", Integer.valueOf(i));
      AppMethodBeat.o(262872);
      return;
      if (NetStatusUtil.is2G(localContext))
      {
        i = 2;
      }
      else if (NetStatusUtil.is3G(localContext))
      {
        i = 3;
      }
      else if (NetStatusUtil.is4G(localContext))
      {
        i = 4;
      }
      else
      {
        i = 0;
        continue;
        i = -1;
      }
    }
  }
  
  public final void amw(String paramString)
  {
    AppMethodBeat.i(262880);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(262880);
      return;
    }
    Log.i("DefaultDynamicPublicParamsProvider", "[setDynamicPublicEventParams] eventId : ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(262880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.c.c
 * JD-Core Version:    0.7.0.1
 */