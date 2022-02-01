package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "", "plugin-finder_release"})
public final class a
  implements j
{
  private final String md5;
  public final String qCd;
  private final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(166299);
    this.url = paramString;
    this.md5 = ai.du(this.url);
    this.qCd = ("finder_avatar_" + this.md5);
    AppMethodBeat.o(166299);
  }
  
  public final String aaX()
  {
    return this.qCd;
  }
  
  public final h cmR()
  {
    return h.qJZ;
  }
  
  public final String cmS()
  {
    return "";
  }
  
  public final String cmT()
  {
    AppMethodBeat.i(198604);
    String str = bt.nullAsNil(this.url);
    d.g.b.k.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(198604);
    return str;
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
    AppMethodBeat.i(166298);
    Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
    localObject = com.tencent.mm.plugin.finder.utils.k.a(this);
    AppMethodBeat.o(166298);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(198603);
    String str = bt.nullAsNil(this.url);
    d.g.b.k.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(198603);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.a
 * JD-Core Version:    0.7.0.1
 */