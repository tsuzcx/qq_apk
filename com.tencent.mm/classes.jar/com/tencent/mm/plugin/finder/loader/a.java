package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "", "plugin-finder_release"})
public final class a
  implements j
{
  private final String md5;
  public final String rtf;
  private final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(166299);
    this.url = paramString;
    this.md5 = ah.dg(this.url);
    this.rtf = ("finder_avatar_" + this.md5);
    AppMethodBeat.o(166299);
  }
  
  public final String abW()
  {
    return this.rtf;
  }
  
  public final String aik()
  {
    AppMethodBeat.i(202528);
    String str = bs.nullAsNil(this.url);
    k.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(202528);
    return str;
  }
  
  public final m cwj()
  {
    return m.rDR;
  }
  
  public final String cwk()
  {
    return "";
  }
  
  public final String cwl()
  {
    return "";
  }
  
  public final String cwm()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166298);
    Object localObject = p.rQw;
    localObject = p.a(this);
    AppMethodBeat.o(166298);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(202527);
    String str = bs.nullAsNil(this.url);
    k.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(202527);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.a
 * JD-Core Version:    0.7.0.1
 */