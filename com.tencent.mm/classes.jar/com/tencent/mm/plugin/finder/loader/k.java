package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.sdk.platformtools.ai;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public final class k
  implements j
{
  private final String md5;
  private final h qCQ;
  private final String url;
  
  public k(String paramString, h paramh)
  {
    AppMethodBeat.i(166332);
    this.url = paramString;
    this.qCQ = paramh;
    paramh = this.url;
    paramString = paramh;
    if (paramh == null) {
      paramString = "";
    }
    this.md5 = ai.du(paramString);
    AppMethodBeat.o(166332);
  }
  
  public final String aaX()
  {
    AppMethodBeat.i(166331);
    String str = this.qCQ.detail + "_finder_" + this.md5;
    AppMethodBeat.o(166331);
    return str;
  }
  
  public final h cmR()
  {
    return this.qCQ;
  }
  
  public final String cmS()
  {
    return "";
  }
  
  public final String cmT()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String fTN()
  {
    return "";
  }
  
  public final String fTO()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166330);
    Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
    localObject = com.tencent.mm.plugin.finder.utils.k.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.k
 * JD-Core Version:    0.7.0.1
 */