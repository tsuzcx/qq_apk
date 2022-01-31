package com.tencent.mm.plugin.messenger;

import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class PluginMessenger$12
  implements e.a
{
  PluginMessenger$12(PluginMessenger paramPluginMessenger) {}
  
  public final String g(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str = bk.aM((String)paramMap.get(paramString + ".separator"), "、");
    int i = 0;
    StringBuilder localStringBuilder2 = new StringBuilder().append(paramString).append(".memberlist.member");
    Object localObject;
    if (i != 0)
    {
      localObject = Integer.valueOf(i);
      label74:
      localObject = localObject;
      if (paramMap.get(localObject) == null) {
        break label180;
      }
      if (i != 0) {
        localStringBuilder1.append(str);
      }
      localObject = (String)paramMap.get((String)localObject + ".nickname");
      if (!bk.bl((String)localObject)) {
        break label169;
      }
      y.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
    }
    for (;;)
    {
      i += 1;
      break;
      localObject = "";
      break label74;
      label169:
      localStringBuilder1.append((String)localObject);
    }
    label180:
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.12
 * JD-Core Version:    0.7.0.1
 */