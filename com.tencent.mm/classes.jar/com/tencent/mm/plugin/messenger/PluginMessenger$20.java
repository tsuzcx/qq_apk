package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

final class PluginMessenger$20
  implements e.a
{
  PluginMessenger$20(PluginMessenger paramPluginMessenger) {}
  
  public final String e(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(90720);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str = bt.bI((String)paramMap.get(paramString + ".separator"), "、");
    int i = 0;
    StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".memberlist.member");
    Object localObject;
    if (i != 0)
    {
      localObject = Integer.valueOf(i);
      label79:
      localObject = localObject;
      if (paramMap.get(localObject) == null) {
        break label185;
      }
      if (i != 0) {
        localStringBuilder1.append(str);
      }
      localObject = (String)paramMap.get((String)localObject + ".nickname");
      if (!bt.isNullOrNil((String)localObject)) {
        break label174;
      }
      ad.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
    }
    for (;;)
    {
      i += 1;
      break;
      localObject = "";
      break label79;
      label174:
      localStringBuilder1.append((String)localObject);
    }
    label185:
    paramMap = localStringBuilder1.toString();
    AppMethodBeat.o(90720);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.20
 * JD-Core Version:    0.7.0.1
 */