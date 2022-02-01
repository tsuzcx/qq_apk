package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "", "plugin-finder_release"})
public final class a
  implements k
{
  private final String md5;
  public final String sis;
  private final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(166299);
    this.url = paramString;
    String str = this.url;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.md5 = ai.ee(paramString);
    this.sis = ("finder_avatar_" + this.md5);
    AppMethodBeat.o(166299);
  }
  
  public final String aeA()
  {
    return this.sis;
  }
  
  public final String akW()
  {
    AppMethodBeat.i(202914);
    String str = bt.nullAsNil(this.url);
    p.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(202914);
    return str;
  }
  
  public final String cCA()
  {
    return "";
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cCx()
  {
    return com.tencent.mm.plugin.finder.storage.r.syE;
  }
  
  public final String cCy()
  {
    return "";
  }
  
  public final String cCz()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166298);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sNc;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166298);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(202913);
    String str = bt.nullAsNil(this.url);
    p.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(202913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.a
 * JD-Core Version:    0.7.0.1
 */