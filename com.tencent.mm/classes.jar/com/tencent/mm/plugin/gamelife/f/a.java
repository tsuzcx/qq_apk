package com.tencent.mm.plugin.gamelife.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getUrl", "getPath", "isLegal", "", "uniqueValue", "plugin-gamelife_release"})
public final class a
  implements c
{
  private final String md5;
  final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(211368);
    this.url = paramString;
    String str = this.url;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.md5 = ai.ee(paramString);
    AppMethodBeat.o(211368);
  }
  
  public final String aeA()
  {
    AppMethodBeat.i(211366);
    String str = "gamelife_avatar_" + this.md5;
    AppMethodBeat.o(211366);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(211367);
    String str = ((PluginGameLife)g.ad(PluginGameLife.class)).getAvatarPath() + aeA();
    AppMethodBeat.o(211367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.a
 * JD-Core Version:    0.7.0.1
 */