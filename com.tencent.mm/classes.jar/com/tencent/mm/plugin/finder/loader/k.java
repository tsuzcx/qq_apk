package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.sdk.platformtools.ah;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public final class k
  implements j
{
  private final String md5;
  private final m rtV;
  private final String url;
  
  public k(String paramString, m paramm)
  {
    AppMethodBeat.i(166332);
    this.url = paramString;
    this.rtV = paramm;
    paramm = this.url;
    paramString = paramm;
    if (paramm == null) {
      paramString = "";
    }
    this.md5 = ah.dg(paramString);
    AppMethodBeat.o(166332);
  }
  
  public final String abW()
  {
    AppMethodBeat.i(166331);
    String str = this.rtV.detail + "_finder_" + this.md5;
    AppMethodBeat.o(166331);
    return str;
  }
  
  public final String aik()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final m cwj()
  {
    return this.rtV;
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
    AppMethodBeat.i(166330);
    Object localObject = p.rQw;
    localObject = p.a(this);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.k
 * JD-Core Version:    0.7.0.1
 */