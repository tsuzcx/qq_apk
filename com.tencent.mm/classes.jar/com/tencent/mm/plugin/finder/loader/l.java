package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "codingFormat", "", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;ILjava/lang/String;)V", "getCodingFormat", "()I", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "uniqueValue", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "toString", "plugin-finder_release"})
public final class l
  implements j
{
  public final int rtW;
  private String rtf;
  public final bqs rtl;
  public final m rtm;
  private final String username;
  
  private l(bqs parambqs, m paramm, int paramInt, String paramString)
  {
    AppMethodBeat.i(202532);
    this.rtl = parambqs;
    this.rtm = paramm;
    this.rtW = paramInt;
    this.username = paramString;
    AppMethodBeat.o(202532);
  }
  
  public final String abW()
  {
    AppMethodBeat.i(166334);
    String str2 = this.rtf;
    String str1 = str2;
    l locall;
    StringBuilder localStringBuilder;
    if (str2 == null)
    {
      locall = (l)this;
      localStringBuilder = new StringBuilder("finder_video_").append(locall.rtm.detail).append('_');
      if (!bs.isNullOrNil(locall.rtl.mediaId)) {
        break label104;
      }
      str2 = locall.rtl.url;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    label104:
    for (str1 = ah.dg(str1);; str1 = locall.rtl.mediaId)
    {
      str1 = str1;
      locall.rtf = str1;
      AppMethodBeat.o(166334);
      return str1;
    }
  }
  
  public final String aik()
  {
    AppMethodBeat.i(166336);
    String str2 = this.rtl.thumbUrl;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(166336);
    return str1;
  }
  
  public final m cwj()
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
    String str2 = this.rtl.url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String cwm()
  {
    String str2 = this.rtl.thumb_url_token;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166333);
    Object localObject = p.rQw;
    localObject = p.a(this);
    AppMethodBeat.o(166333);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166335);
    String str2 = this.rtl.url;
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
    String str = this.rtl.mediaId + " url=" + this.rtl.url;
    AppMethodBeat.o(166337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.l
 * JD-Core Version:    0.7.0.1
 */