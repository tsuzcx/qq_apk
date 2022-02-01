package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public final class l
  implements k
{
  private final String md5;
  private final com.tencent.mm.plugin.finder.storage.r sjl;
  private final String url;
  
  public l(String paramString, com.tencent.mm.plugin.finder.storage.r paramr)
  {
    AppMethodBeat.i(166332);
    this.url = paramString;
    this.sjl = paramr;
    paramr = this.url;
    paramString = paramr;
    if (paramr == null) {
      paramString = "";
    }
    this.md5 = ai.ee(paramString);
    AppMethodBeat.o(166332);
  }
  
  public final String aeA()
  {
    AppMethodBeat.i(166331);
    String str = this.sjl.detail + "_finder_" + this.md5;
    AppMethodBeat.o(166331);
    return str;
  }
  
  public final String akW()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cCA()
  {
    return "";
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cCx()
  {
    return this.sjl;
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
    AppMethodBeat.i(166330);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sNc;
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