package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public final class l
  implements k
{
  private final String md5;
  private final com.tencent.mm.plugin.finder.storage.r ssi;
  private final String url;
  
  public l(String paramString, com.tencent.mm.plugin.finder.storage.r paramr)
  {
    AppMethodBeat.i(166332);
    this.url = paramString;
    this.ssi = paramr;
    paramr = this.url;
    paramString = paramr;
    if (paramr == null) {
      paramString = "";
    }
    this.md5 = aj.ej(paramString);
    AppMethodBeat.o(166332);
  }
  
  public final String aeM()
  {
    AppMethodBeat.i(166331);
    String str = this.ssi.detail + "_finder_" + this.md5;
    AppMethodBeat.o(166331);
    return str;
  }
  
  public final String all()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cEj()
  {
    return this.ssi;
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
    AppMethodBeat.i(166330);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sYn;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166330);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.l
 * JD-Core Version:    0.7.0.1
 */