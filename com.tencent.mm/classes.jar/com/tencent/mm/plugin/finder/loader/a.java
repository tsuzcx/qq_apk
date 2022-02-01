package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderAvatar;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "uniqueValue", "getDecodeKey", "getMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "isLegal", "", "plugin-finder_release"})
public final class a
  implements o
{
  private final String md5;
  public final String uId;
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
    this.md5 = MD5Util.getMD5String(paramString);
    this.uId = ("finder_avatar_" + this.md5);
    AppMethodBeat.o(166299);
  }
  
  public final String aBE()
  {
    AppMethodBeat.i(248207);
    String str = Util.nullAsNil(this.url);
    p.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(248207);
    return str;
  }
  
  public final String auA()
  {
    return this.uId;
  }
  
  public final x djU()
  {
    return x.vEo;
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
    AppMethodBeat.i(166298);
    Object localObject = al.waC;
    localObject = al.a(this);
    AppMethodBeat.o(166298);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(248206);
    String str = Util.nullAsNil(this.url);
    p.g(str, "Util.nullAsNil(url)");
    AppMethodBeat.o(248206);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.a
 * JD-Core Version:    0.7.0.1
 */