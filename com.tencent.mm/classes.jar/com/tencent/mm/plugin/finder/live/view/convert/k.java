package com.tencent.mm.plugin.finder.live.view.convert;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.j;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/IFinderLivePromoteData;", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "data", "(Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;)V", "button_wording", "", "getButton_wording", "()Ljava/lang/String;", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "setData", "exclusiveInfo", "Lcom/tencent/mm/protocal/protobuf/ExclusiveInfo;", "getExclusiveInfo", "()Lcom/tencent/mm/protocal/protobuf/ExclusiveInfo;", "setExclusiveInfo", "(Lcom/tencent/mm/protocal/protobuf/ExclusiveInfo;)V", "extBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getExtBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setExtBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "extra_data", "getExtra_data", "full_page", "Lcom/tencent/mm/protocal/protobuf/DetailPage;", "getFull_page", "()Lcom/tencent/mm/protocal/protobuf/DetailPage;", "half_page", "getHalf_page", "img_urls", "Ljava/util/LinkedList;", "kotlin.jvm.PlatformType", "getImg_urls", "()Ljava/util/LinkedList;", "is_promoting", "", "()I", "set_promoting", "(I)V", "jumpId", "getJumpId", "setJumpId", "(Ljava/lang/String;)V", "list_id", "getList_id", "mPromoteId", "", "getMPromoteId", "()J", "setMPromoteId", "(J)V", "market_price", "getMarket_price", "needJump", "", "getNeedJump", "()Z", "setNeedJump", "(Z)V", "origin_price", "getOrigin_price", "platform_id", "getPlatform_id", "platform_name", "getPlatform_name", "productIcon", "getProductIcon", "product_id", "getProduct_id", "selling_price", "getSelling_price", "status", "getStatus", "stock", "getStock", "title", "getTitle", "availableExclusiveInfo", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "equals", "other", "", "getExBuf", "getItemId", "getItemType", "getPromoteData", "getPromoteId", "hashCode", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements cc, j<bzc>
{
  public static final a DVi;
  public long DUI;
  public b DUJ;
  public String DUN;
  public final String DUT;
  public bzc DVj;
  public final long DVk;
  public final LinkedList<String> DVl;
  public final int DVm;
  public final int DVn;
  public final int DVo;
  public final aka DVp;
  public final aka DVq;
  public int DVr;
  public final int DVs;
  public final int DVt;
  public final String DVu;
  private final int DVv;
  private aoj DVw;
  public final String DVx;
  public boolean hPp;
  private final int status;
  public final String title;
  public final String wul;
  
  static
  {
    AppMethodBeat.i(358225);
    DVi = new a((byte)0);
    AppMethodBeat.o(358225);
  }
  
  public k(bzc parambzc)
  {
    AppMethodBeat.i(358221);
    this.DVj = parambzc;
    this.DVk = this.DVj.DVk;
    this.title = this.DVj.title;
    this.DVl = this.DVj.DVl;
    this.DVm = this.DVj.DVm;
    this.DVn = this.DVj.DVn;
    this.DVo = this.DVj.DVo;
    this.status = this.DVj.status;
    this.DUT = this.DVj.DUT;
    this.DVp = this.DVj.DVp;
    this.DVq = this.DVj.DVq;
    this.DVr = this.DVj.DVr;
    this.DVs = this.DVj.DVs;
    this.DVt = this.DVj.DVt;
    this.DVu = this.DVj.DVu;
    this.wul = this.DVj.wul;
    this.DVv = -1;
    this.DVw = this.DVj.aaih;
    this.DVx = this.DVj.aaii;
    this.DUN = "";
    AppMethodBeat.o(358221);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
  {
    AppMethodBeat.i(358255);
    s.u(paramk, "obj");
    if (((paramk instanceof k)) && (((k)paramk).DVk == this.DVk))
    {
      AppMethodBeat.o(358255);
      return 0;
    }
    AppMethodBeat.o(358255);
    return -1;
  }
  
  public final void ayc(String paramString)
  {
    AppMethodBeat.i(358229);
    s.u(paramString, "<set-?>");
    this.DUN = paramString;
    AppMethodBeat.o(358229);
  }
  
  public final b bUA()
  {
    return this.DUJ;
  }
  
  public final long bUz()
  {
    return this.DUI;
  }
  
  public final long bZA()
  {
    return this.DVk;
  }
  
  public final int bZB()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(358260);
    if (this == paramObject)
    {
      AppMethodBeat.o(358260);
      return true;
    }
    Class localClass = getClass();
    if (paramObject == null) {}
    for (Object localObject = null; !s.p(localClass, localObject); localObject = paramObject.getClass())
    {
      AppMethodBeat.o(358260);
      return false;
    }
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.convert.ShopWindowShelfProductItem");
      AppMethodBeat.o(358260);
      throw paramObject;
    }
    if (this.DVk != ((k)paramObject).DVk)
    {
      AppMethodBeat.o(358260);
      return false;
    }
    AppMethodBeat.o(358260);
    return true;
  }
  
  public final aoj ewd()
  {
    AppMethodBeat.i(358245);
    Object localObject;
    if (this.DVw != null)
    {
      aoj localaoj = this.DVw;
      localObject = localaoj;
      if (localaoj == null) {
        localObject = "";
      }
      Log.i("MicroMsg.ShopWindowShelfProductItem", s.X("availableExclusiveInfo ", f.dg(localObject)));
    }
    if (((c)h.ax(c.class)).a(c.a.yHu, false))
    {
      AppMethodBeat.o(358245);
      return null;
    }
    if (this.DVw != null)
    {
      localObject = this.DVw;
      if ((localObject != null) && (((aoj)localObject).ZvO == true)) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject = this.DVw;
        AppMethodBeat.o(358245);
        return localObject;
      }
    }
    AppMethodBeat.o(358245);
    return null;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(358267);
    int i = q.a..ExternalSyntheticBackport0.m(this.DVk);
    AppMethodBeat.o(358267);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(358273);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ShopWindowShelfProductItem(product_id=").append(this.DVk).append(", title=").append(this.title).append(", stock=").append(this.DVm).append(", market_price=").append(this.DVn).append(", selling_price=").append(this.DVo).append(", status=").append(this.status).append(", is_promoting=").append(this.DVr).append(", platform_id=").append(this.DVs).append(", list_id=").append(this.DVt).append(", extra_data=").append(this.DVu).append(", button_wording=").append(this.wul).append(", origin_price=");
    ((StringBuilder)localObject).append(this.DVv).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(358273);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.k
 * JD-Core Version:    0.7.0.1
 */