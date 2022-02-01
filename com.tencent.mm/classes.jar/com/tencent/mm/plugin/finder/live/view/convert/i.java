package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.j;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.cr;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/IFinderLivePromoteData;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "data", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;)V", "ad_id", "", "getAd_id", "()J", "ad_page", "Lcom/tencent/mm/protocal/protobuf/AdPage;", "getAd_page", "()Lcom/tencent/mm/protocal/protobuf/AdPage;", "button_text", "", "getButton_text", "()Ljava/lang/String;", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "setData", "desc", "getDesc", "extBuf", "Lcom/tencent/mm/protobuf/ByteString;", "getExtBuf", "()Lcom/tencent/mm/protobuf/ByteString;", "setExtBuf", "(Lcom/tencent/mm/protobuf/ByteString;)V", "img_url", "getImg_url", "jumpId", "getJumpId", "setJumpId", "(Ljava/lang/String;)V", "mPromoteId", "getMPromoteId", "setMPromoteId", "(J)V", "needJump", "", "getNeedJump", "()Z", "setNeedJump", "(Z)V", "platform_name", "getPlatform_name", "promoting", "", "getPromoting", "()I", "setPromoting", "(I)V", "title", "getTitle", "uxinfo", "getUxinfo", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getExBuf", "getItemId", "getItemType", "getPromoteData", "getPromoteId", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements cc, j<bmt>
{
  public int Caa;
  public long DUI;
  public b DUJ;
  public String DUN;
  public bmt DUO;
  public final long DUP;
  public final cr DUQ;
  public final String DUR;
  public final String DUS;
  public final String DUT;
  public final String desc;
  public boolean hPp;
  public final String mdG;
  public final String title;
  
  public i(bmt parambmt)
  {
    AppMethodBeat.i(358222);
    this.DUO = parambmt;
    this.DUP = this.DUO.DUP;
    this.DUQ = this.DUO.DUQ;
    this.title = this.DUO.title;
    this.DUR = this.DUO.DUR;
    this.desc = this.DUO.desc;
    this.DUS = this.DUO.DUS;
    this.DUT = this.DUO.DUT;
    this.Caa = this.DUO.Caa;
    String str = this.DUO.mdG;
    parambmt = str;
    if (str == null) {
      parambmt = "";
    }
    this.mdG = parambmt;
    this.DUN = "";
    AppMethodBeat.o(358222);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(358242);
    s.u(paramk, "obj");
    AppMethodBeat.o(358242);
    return 0;
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
    return this.DUO.DUP;
  }
  
  public final int bZB()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.i
 * JD-Core Version:    0.7.0.1
 */