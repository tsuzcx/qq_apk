package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderUrlImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "url", "", "mediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class s
  implements r
{
  private final v EyS;
  private final String md5;
  private final String url;
  
  public s(String paramString, v paramv)
  {
    AppMethodBeat.i(166332);
    this.url = paramString;
    this.EyS = paramv;
    paramv = this.url;
    paramString = paramv;
    if (paramv == null) {
      paramString = "";
    }
    this.md5 = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(166332);
  }
  
  public String aUt()
  {
    AppMethodBeat.i(166331);
    String str = this.EyS.detail + "_finder_" + this.md5;
    AppMethodBeat.o(166331);
    return str;
  }
  
  public final v eCd()
  {
    return this.EyS;
  }
  
  public final String eCe()
  {
    return "";
  }
  
  public final String eCf()
  {
    return "";
  }
  
  public final String eCg()
  {
    return "";
  }
  
  public final String eCi()
  {
    String str2 = this.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getMd5()
  {
    return this.md5;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166330);
    Object localObject = bm.GlZ;
    localObject = bm.a(this);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.s
 * JD-Core Version:    0.7.0.1
 */