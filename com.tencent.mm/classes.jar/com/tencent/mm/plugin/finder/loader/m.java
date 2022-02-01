package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoCover;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class m
  implements j
{
  public static final m.a rtX;
  private bqs rtl;
  private com.tencent.mm.plugin.finder.storage.m rtm;
  private String username;
  
  static
  {
    AppMethodBeat.i(202538);
    rtX = new m.a((byte)0);
    AppMethodBeat.o(202538);
  }
  
  private m(bqs parambqs, com.tencent.mm.plugin.finder.storage.m paramm, String paramString)
  {
    AppMethodBeat.i(202536);
    String str = u.axw();
    k.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.rtl = parambqs;
    this.rtm = paramm;
    this.username = paramString;
    if (parambqs.url == null) {
      b.e("FinderVideoCover", "mediaObj.url == null " + bs.eWi());
    }
    AppMethodBeat.o(202536);
  }
  
  public final String abW()
  {
    AppMethodBeat.i(202535);
    StringBuilder localStringBuilder = new StringBuilder("finder_video_cover_").append(this.rtm.detail).append('_');
    if (bs.isNullOrNil(this.rtl.mediaId)) {}
    for (String str = ah.dg(bs.bG(this.rtl.url, ""));; str = this.rtl.mediaId)
    {
      str = str;
      AppMethodBeat.o(202535);
      return str;
    }
  }
  
  public final String aik()
  {
    String str2 = this.rtl.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final com.tencent.mm.plugin.finder.storage.m cwj()
  {
    return this.rtm;
  }
  
  public final String cwk()
  {
    String str2 = this.rtl.decodeKey;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cwl()
  {
    String str2 = this.rtl.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cwm()
  {
    String str2 = this.rtl.cover_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(202534);
    Object localObject = p.rQw;
    localObject = p.a(this);
    AppMethodBeat.o(202534);
    return localObject;
  }
  
  public final String getUrl()
  {
    String str2 = this.rtl.coverUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.m
 * JD-Core Version:    0.7.0.1
 */