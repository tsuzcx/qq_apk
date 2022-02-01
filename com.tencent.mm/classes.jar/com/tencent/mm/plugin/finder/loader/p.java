package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder_release"})
public class p
  implements o
{
  final String md5;
  private final x uJn;
  private final String url;
  
  public p(String paramString, x paramx)
  {
    AppMethodBeat.i(166332);
    this.url = paramString;
    this.uJn = paramx;
    paramx = this.url;
    paramString = paramx;
    if (paramx == null) {
      paramString = "";
    }
    this.md5 = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(166332);
  }
  
  public final String aBE()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String auA()
  {
    AppMethodBeat.i(166331);
    String str = this.uJn.detail + "_finder_" + this.md5;
    AppMethodBeat.o(166331);
    return str;
  }
  
  public final x djU()
  {
    return this.uJn;
  }
  
  public final String djV()
  {
    return "";
  }
  
  public final String djW()
  {
    return "";
  }
  
  public final String djX()
  {
    return "";
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166330);
    Object localObject = al.waC;
    localObject = al.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.p
 * JD-Core Version:    0.7.0.1
 */