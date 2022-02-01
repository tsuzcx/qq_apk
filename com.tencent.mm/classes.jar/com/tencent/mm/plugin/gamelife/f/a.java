package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getUrl", "getPath", "isLegal", "", "uniqueValue", "plugin-gamelife_release"})
public final class a
  implements c
{
  private final String md5;
  final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(241382);
    this.url = paramString;
    String str = this.url;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.md5 = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(241382);
  }
  
  public final String auA()
  {
    AppMethodBeat.i(241380);
    String str = "gamelife_avatar_" + this.md5;
    AppMethodBeat.o(241380);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(241381);
    String str = ((PluginGameLife)g.ah(PluginGameLife.class)).getAvatarPath() + auA();
    AppMethodBeat.o(241381);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.a
 * JD-Core Version:    0.7.0.1
 */