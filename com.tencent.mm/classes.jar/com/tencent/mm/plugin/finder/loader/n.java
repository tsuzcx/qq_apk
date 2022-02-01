package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class n
  implements k
{
  public static final a sjn;
  private bvf siC;
  private com.tencent.mm.plugin.finder.storage.r siD;
  private String username;
  
  static
  {
    AppMethodBeat.i(202924);
    sjn = new a((byte)0);
    AppMethodBeat.o(202924);
  }
  
  private n(bvf parambvf, com.tencent.mm.plugin.finder.storage.r paramr, String paramString)
  {
    AppMethodBeat.i(202922);
    String str = u.aAm();
    p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.siC = parambvf;
    this.siD = paramr;
    this.username = paramString;
    if (parambvf.url == null) {
      b.e("FinderVideoCover", "mediaObj.url == null " + bt.flS());
    }
    AppMethodBeat.o(202922);
  }
  
  public final String aeA()
  {
    AppMethodBeat.i(202921);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_cover_").append(this.siD.detail).append('_');
    if (bt.isNullOrNil(this.siC.mediaId)) {}
    for (String str = ai.ee(bt.bI(this.siC.url, ""));; str = this.siC.mediaId)
    {
      str = str;
      AppMethodBeat.o(202921);
      return str;
    }
  }
  
  public final String akW()
  {
    String str2 = this.siC.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cCA()
  {
    String str2 = this.siC.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.r cCx()
  {
    return this.siD;
  }
  
  public final String cCy()
  {
    String str2 = this.siC.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cCz()
  {
    String str2 = this.siC.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(202920);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sNc;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(202920);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.siC.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.n
 * JD-Core Version:    0.7.0.1
 */