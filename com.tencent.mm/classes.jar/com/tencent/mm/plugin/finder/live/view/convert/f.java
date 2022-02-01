package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.blm;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;)V", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "extra_data", "", "getExtra_data", "()Ljava/lang/String;", "full_page", "Lcom/tencent/mm/protocal/protobuf/DetailPage;", "getFull_page", "()Lcom/tencent/mm/protocal/protobuf/DetailPage;", "half_page", "getHalf_page", "img_urls", "Ljava/util/LinkedList;", "kotlin.jvm.PlatformType", "getImg_urls", "()Ljava/util/LinkedList;", "is_promoting", "", "()I", "list_id", "getList_id", "market_price", "getMarket_price", "platform_id", "getPlatform_id", "platform_name", "getPlatform_name", "product_id", "", "getProduct_id", "()J", "selling_price", "getSelling_price", "status", "getStatus", "stock", "getStock", "title", "getTitle", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder-base_release"})
public final class f
  implements bu
{
  private final int status;
  public final String title;
  public final int yiH;
  public final String zaM;
  public final long zaO;
  public final LinkedList<String> zaP;
  public final int zaQ;
  public final int zaR;
  public final int zaS;
  public final ahj zaT;
  public final ahj zaU;
  public final int zaV;
  public final int zaW;
  public final String zaX;
  public final blm zaY;
  
  public f(blm paramblm)
  {
    AppMethodBeat.i(263579);
    this.zaY = paramblm;
    this.zaO = this.zaY.zaO;
    this.title = this.zaY.title;
    this.zaP = this.zaY.zaP;
    this.zaQ = this.zaY.zaQ;
    this.zaR = this.zaY.zaR;
    this.zaS = this.zaY.zaS;
    this.status = this.zaY.status;
    this.zaM = this.zaY.zaM;
    this.zaT = this.zaY.zaT;
    this.zaU = this.zaY.zaU;
    this.zaV = this.zaY.zaV;
    this.yiH = this.zaY.yiH;
    this.zaW = this.zaY.zaW;
    this.zaX = this.zaY.zaX;
    AppMethodBeat.o(263579);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(263577);
    p.k(paramk, "obj");
    if (((paramk instanceof f)) && (((f)paramk).zaO == this.zaO))
    {
      AppMethodBeat.o(263577);
      return 0;
    }
    AppMethodBeat.o(263577);
    return -1;
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final long mf()
  {
    return this.zaO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.f
 * JD-Core Version:    0.7.0.1
 */