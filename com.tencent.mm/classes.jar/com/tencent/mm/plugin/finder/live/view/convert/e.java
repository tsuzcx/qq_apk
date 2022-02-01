package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.ch;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;)V", "ad_id", "", "getAd_id", "()J", "ad_page", "Lcom/tencent/mm/protocal/protobuf/AdPage;", "kotlin.jvm.PlatformType", "getAd_page", "()Lcom/tencent/mm/protocal/protobuf/AdPage;", "button_text", "", "getButton_text", "()Ljava/lang/String;", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "desc", "getDesc", "img_url", "getImg_url", "platform_name", "getPlatform_name", "promoting", "", "getPromoting", "()I", "title", "getTitle", "uxinfo", "getUxinfo", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder-base_release"})
public final class e
  implements bu
{
  public final String desc;
  public final String jDL;
  public final int promoting;
  public final String title;
  public final long zaI;
  public final ch zaJ;
  public final String zaK;
  public final String zaL;
  public final String zaM;
  public final bcq zaN;
  
  public e(bcq parambcq)
  {
    AppMethodBeat.i(258064);
    this.zaN = parambcq;
    this.zaI = this.zaN.zaI;
    this.zaJ = this.zaN.zaJ;
    this.title = this.zaN.title;
    this.zaK = this.zaN.zaK;
    this.desc = this.zaN.desc;
    this.zaL = this.zaN.zaL;
    this.zaM = this.zaN.zaM;
    this.promoting = this.zaN.promoting;
    this.jDL = this.zaN.jDL;
    AppMethodBeat.o(258064);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(258062);
    p.k(paramk, "obj");
    AppMethodBeat.o(258062);
    return 0;
  }
  
  public final int bAQ()
  {
    return 1;
  }
  
  public final long mf()
  {
    return this.zaN.zaI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.e
 * JD-Core Version:    0.7.0.1
 */