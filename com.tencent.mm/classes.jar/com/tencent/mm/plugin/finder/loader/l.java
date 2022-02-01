package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "toString", "plugin-finder_release"})
public final class l
  implements j
{
  final int KTf;
  private String qCd;
  public final bmd qCj;
  public final h qCk;
  private final String username;
  
  private l(bmd parambmd, h paramh, int paramInt, String paramString)
  {
    AppMethodBeat.i(198607);
    this.qCj = parambmd;
    this.qCk = paramh;
    this.KTf = paramInt;
    this.username = paramString;
    AppMethodBeat.o(198607);
  }
  
  public final String aaX()
  {
    AppMethodBeat.i(166334);
    String str2 = this.qCd;
    String str1 = str2;
    l locall;
    StringBuilder localStringBuilder;
    if (str2 == null)
    {
      locall = (l)this;
      localStringBuilder = new StringBuilder("finder_video_").append(locall.qCk.detail).append('_');
      if (!bt.isNullOrNil(locall.qCj.mediaId)) {
        break label104;
      }
      str2 = locall.qCj.url;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    label104:
    for (str1 = ai.du(str1);; str1 = locall.qCj.mediaId)
    {
      str1 = str1;
      locall.qCd = str1;
      AppMethodBeat.o(166334);
      return str1;
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
    AppMethodBeat.i(166336);
    String str2 = this.qCj.thumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(166336);
    return str1;
  }
  
  public final String fTN()
  {
    String str2 = this.qCj.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String fTO()
  {
    String str2 = this.qCj.thumb_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166333);
    Object localObject = k.qTp;
    localObject = k.b(this);
    AppMethodBeat.o(166333);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166335);
    String str2 = this.qCj.url;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(166335);
    return str1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166337);
    String str = this.qCj.mediaId + " url=" + this.qCj.url;
    AppMethodBeat.o(166337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.l
 * JD-Core Version:    0.7.0.1
 */