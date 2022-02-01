package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class n
  implements j
{
  public static final a KTg;
  private bmd qCj;
  private h qCk;
  private String username;
  
  static
  {
    AppMethodBeat.i(198613);
    KTg = new a((byte)0);
    AppMethodBeat.o(198613);
  }
  
  private n(bmd parambmd, h paramh, String paramString)
  {
    AppMethodBeat.i(198611);
    String str = u.aqG();
    d.g.b.k.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.qCj = parambmd;
    this.qCk = paramh;
    this.username = paramString;
    if (parambmd.url == null) {
      b.e("FinderVideoCover", "mediaObj.url == null " + bt.eGN());
    }
    AppMethodBeat.o(198611);
  }
  
  public final String aaX()
  {
    AppMethodBeat.i(198610);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_cover_").append(this.qCk.detail).append('_');
    if (bt.isNullOrNil(this.qCj.mediaId)) {}
    for (String str = ai.du(bt.by(this.qCj.url, ""));; str = this.qCj.mediaId)
    {
      str = str;
      AppMethodBeat.o(198610);
      return str;
    }
  }
  
  public final h cmR()
  {
    return this.qCk;
  }
  
  public final String cmS()
  {
    String str2 = this.qCj.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cmT()
  {
    String str2 = this.qCj.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String fTN()
  {
    String str2 = this.qCj.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String fTO()
  {
    String str2 = this.qCj.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(198609);
    Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
    localObject = com.tencent.mm.plugin.finder.utils.k.a(this);
    AppMethodBeat.o(198609);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.qCj.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.n
 * JD-Core Version:    0.7.0.1
 */