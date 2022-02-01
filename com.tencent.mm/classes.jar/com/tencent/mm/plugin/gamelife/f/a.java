package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getUrl", "getPath", "isLegal", "", "uniqueValue", "plugin-gamelife_release"})
public final class a
  implements c
{
  private final String md5;
  final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(212139);
    this.url = paramString;
    String str = this.url;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.md5 = aj.ej(paramString);
    AppMethodBeat.o(212139);
  }
  
  public final String aeM()
  {
    AppMethodBeat.i(212137);
    String str = "gamelife_avatar_" + this.md5;
    AppMethodBeat.o(212137);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(212138);
    String str = ((PluginGameLife)g.ad(PluginGameLife.class)).getAvatarPath() + aeM();
    AppMethodBeat.o(212138);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.a
 * JD-Core Version:    0.7.0.1
 */