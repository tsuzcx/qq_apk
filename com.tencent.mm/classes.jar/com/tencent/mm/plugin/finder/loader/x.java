package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public class x
  implements w
{
  private final String md5;
  private final String url;
  private final u zuT;
  
  public x(String paramString, u paramu)
  {
    AppMethodBeat.i(166332);
    this.url = paramString;
    this.zuT = paramu;
    paramu = this.url;
    paramString = paramu;
    if (paramu == null) {
      paramString = "";
    }
    this.md5 = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(166332);
  }
  
  public String aBv()
  {
    AppMethodBeat.i(166331);
    String str = this.zuT.detail + "_finder_" + this.md5;
    AppMethodBeat.o(166331);
    return str;
  }
  
  public final String aJi()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final u dIX()
  {
    return this.zuT;
  }
  
  public final String dIY()
  {
    return "";
  }
  
  public final String dIZ()
  {
    return "";
  }
  
  public final String dJa()
  {
    return "";
  }
  
  public final String getMd5()
  {
    return this.md5;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166330);
    Object localObject = av.AJz;
    localObject = av.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.x
 * JD-Core Version:    0.7.0.1
 */