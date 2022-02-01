package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderImage;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "username", "", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;Ljava/lang/String;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getDecodeKey", "getMediaType", "getPath", "getThumbUrl", "getThumbUrlToken", "getUrl", "getUrlToken", "getUsername", "uniqueValue", "Companion", "plugin-finder_release"})
public final class f
  implements j
{
  public static final a rtn;
  public bqs rtl;
  private m rtm;
  private String username;
  
  static
  {
    AppMethodBeat.i(178310);
    rtn = new a((byte)0);
    AppMethodBeat.o(178310);
  }
  
  private f(bqs parambqs, m paramm, String paramString)
  {
    AppMethodBeat.i(166318);
    String str = u.axw();
    k.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
    this.username = str;
    this.rtl = parambqs;
    this.rtm = paramm;
    this.username = paramString;
    if (parambqs.url == null) {
      b.e("FinderImage", "mediaObj.url == null " + bs.eWi());
    }
    AppMethodBeat.o(166318);
  }
  
  public final String abW()
  {
    AppMethodBeat.i(166316);
    Object localObject1 = new StringBuilder("finder_image_");
    Object localObject2 = this.rtm;
    if (localObject2 == null) {
      k.aVY("type");
    }
    localObject2 = ((StringBuilder)localObject1).append(((m)localObject2).detail).append('_');
    localObject1 = this.rtl;
    if (localObject1 == null) {
      k.aVY("mediaObj");
    }
    if (bs.isNullOrNil(((bqs)localObject1).mediaId))
    {
      localObject1 = this.rtl;
      if (localObject1 == null) {
        k.aVY("mediaObj");
      }
    }
    for (localObject1 = ah.dg(bs.bG(((bqs)localObject1).url, ""));; localObject1 = ((bqs)localObject1).mediaId)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(166316);
      return localObject1;
      localObject1 = this.rtl;
      if (localObject1 == null) {
        k.aVY("mediaObj");
      }
    }
  }
  
  public final String aik()
  {
    AppMethodBeat.i(178309);
    Object localObject = this.rtl;
    if (localObject == null) {
      k.aVY("mediaObj");
    }
    String str = ((bqs)localObject).thumbUrl;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(178309);
    return localObject;
  }
  
  public final m cwj()
  {
    AppMethodBeat.i(178308);
    m localm = this.rtm;
    if (localm == null) {
      k.aVY("type");
    }
    AppMethodBeat.o(178308);
    return localm;
  }
  
  public final String cwk()
  {
    AppMethodBeat.i(202529);
    Object localObject = this.rtl;
    if (localObject == null) {
      k.aVY("mediaObj");
    }
    String str = ((bqs)localObject).decodeKey;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(202529);
    return localObject;
  }
  
  public final String cwl()
  {
    AppMethodBeat.i(202530);
    Object localObject = this.rtl;
    if (localObject == null) {
      k.aVY("mediaObj");
    }
    String str = ((bqs)localObject).url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(202530);
    return localObject;
  }
  
  public final String cwm()
  {
    AppMethodBeat.i(202531);
    Object localObject = this.rtl;
    if (localObject == null) {
      k.aVY("mediaObj");
    }
    String str = ((bqs)localObject).thumb_url_token;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(202531);
    return localObject;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(166315);
    Object localObject = p.rQw;
    localObject = p.a(this);
    AppMethodBeat.o(166315);
    return localObject;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(166317);
    Object localObject = this.rtl;
    if (localObject == null) {
      k.aVY("mediaObj");
    }
    String str = ((bqs)localObject).url;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(166317);
    return localObject;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderImage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.f
 * JD-Core Version:    0.7.0.1
 */