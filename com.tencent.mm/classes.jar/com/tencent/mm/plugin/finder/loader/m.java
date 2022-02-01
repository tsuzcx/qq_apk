package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "toString", "plugin-finder_release"})
public final class m
  implements k
{
  public final bvf siC;
  public final com.tencent.mm.plugin.finder.storage.r siD;
  private String sis;
  public final int sjm;
  private final String username;
  
  private m(bvf parambvf, com.tencent.mm.plugin.finder.storage.r paramr, int paramInt, String paramString)
  {
    AppMethodBeat.i(202918);
    this.siC = parambvf;
    this.siD = paramr;
    this.sjm = paramInt;
    this.username = paramString;
    AppMethodBeat.o(202918);
  }
  
  public final String aeA()
  {
    AppMethodBeat.i(166334);
    String str2 = this.sis;
    String str1 = str2;
    m localm;
    StringBuilder localStringBuilder;
    if (str2 == null)
    {
      localm = (m)this;
      localStringBuilder = new StringBuilder("finder_video_").append(localm.siD.detail).append('_');
      if (!bt.isNullOrNil(localm.siC.mediaId)) {
        break label104;
      }
      str2 = localm.siC.url;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    label104:
    for (str1 = ai.ee(str1);; str1 = localm.siC.mediaId)
    {
      str1 = str1;
      localm.sis = str1;
      AppMethodBeat.o(166334);
      return str1;
    }
  }
  
  public final String akW()
  {
    AppMethodBeat.i(166336);
    String str2 = this.siC.thumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(166336);
    return str1;
  }
  
  public final String cCA()
  {
    String str2 = this.siC.thumb_url_token;
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
    String str2 = this.siC.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166333);
    Object localObject = com.tencent.mm.plugin.finder.utils.r.sNc;
    localObject = com.tencent.mm.plugin.finder.utils.r.a(this);
    AppMethodBeat.o(166333);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166335);
    String str2 = this.siC.url;
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
    String str = this.siC.mediaId + " url=" + this.siC.url;
    AppMethodBeat.o(166337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.m
 * JD-Core Version:    0.7.0.1
 */