package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.g.a.c;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getUrl", "getPath", "isLegal", "", "uniqueValue", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  private final String md5;
  final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(268153);
    this.url = paramString;
    String str = this.url;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.md5 = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(268153);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(268165);
    String str = s.X("gamelife_avatar_", this.md5);
    AppMethodBeat.o(268165);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(268175);
    String str = s.X(((PluginGameLife)h.az(PluginGameLife.class)).getAvatarPath(), aUt());
    AppMethodBeat.o(268175);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.a
 * JD-Core Version:    0.7.0.1
 */