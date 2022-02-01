package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "", "plugin-finder_release"})
public final class a
  implements k
{
  private final String md5;
  public final String srn;
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
    this.md5 = aj.ej(paramString);
    this.srn = ("finder_avatar_" + this.md5);
    AppMethodBeat.o(166299);
  }
  
  public final String aeM()
  {
    return this.srn;
  }
  
  public final String all()
  {
    AppMethodBeat.i(203393);
    String str = bu.nullAsNil(this.url);
    p.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(203393);
    return str;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cEj()
  {
    return com.tencent.mm.plugin.finder.storage.r.sJv;
  }
  
  public final String cEk()
  {
    return "";
  }
  
  public final String cEl()
  {
    return "";
  }
  
  public final String cEm()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166298);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sYn;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166298);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(203392);
    String str = bu.nullAsNil(this.url);
    p.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(203392);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.a
 * JD-Core Version:    0.7.0.1
 */