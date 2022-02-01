package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.v;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class n
  implements k
{
  public static final a ssk;
  private bvz srx;
  private com.tencent.mm.plugin.finder.storage.r sry;
  private String username;
  
  static
  {
    AppMethodBeat.i(203404);
    ssk = new a((byte)0);
    AppMethodBeat.o(203404);
  }
  
  private n(bvz parambvz, com.tencent.mm.plugin.finder.storage.r paramr, String paramString)
  {
    AppMethodBeat.i(203402);
    String str = v.aAC();
    p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.srx = parambvz;
    this.sry = paramr;
    this.username = paramString;
    if (parambvz.url == null) {
      b.e("FinderVideoCover", "mediaObj.url == null " + bu.fpN());
    }
    AppMethodBeat.o(203402);
  }
  
  public final String aeM()
  {
    AppMethodBeat.i(203400);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_cover_").append(this.sry.detail).append('_');
    if (bu.isNullOrNil(this.srx.mediaId)) {}
    for (String str = aj.ej(bu.bI(this.srx.url, ""));; str = this.srx.mediaId)
    {
      str = str;
      AppMethodBeat.o(203400);
      return str;
    }
  }
  
  public final String all()
  {
    AppMethodBeat.i(203401);
    String str2 = this.srx.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    p.g(str1, "mediaObj.coverUrl ?: \"\"");
    AppMethodBeat.o(203401);
    return str1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cEj()
  {
    return this.sry;
  }
  
  public final String cEk()
  {
    String str2 = this.srx.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cEl()
  {
    String str2 = this.srx.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cEm()
  {
    String str2 = this.srx.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(203399);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sYn;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(203399);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.srx.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.n
 * JD-Core Version:    0.7.0.1
 */