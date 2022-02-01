package com.tencent.mm.plugin.finder.order.data;

import android.content.Context;
import com.tencent.d.a.a.a.b.a.j;
import com.tencent.d.a.a.a.b.a.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.protobuf.fcy;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/data/SpuFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "skuInfo", "Lcom/tencent/mm/protocal/protobuf/SkuInfo;", "orderId", "", "(Lcom/tencent/mm/protocal/protobuf/SkuInfo;Ljava/lang/String;)V", "count", "", "getCount", "()I", "desc", "getDesc", "()Ljava/lang/String;", "imgUrl", "getImgUrl", "name", "getName", "getOrderId", "price", "getPrice", "getSkuInfo", "()Lcom/tencent/mm/protocal/protobuf/SkuInfo;", "stateText", "getStateText", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "getSpuFeedInfo", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements cc
{
  public final String ADt;
  public final fcy ESA;
  public final String ESB;
  public final int count;
  public final String desc;
  public final String nSs;
  public final String name;
  public final String price;
  
  public f(fcy paramfcy, String paramString)
  {
    AppMethodBeat.i(332353);
    this.ESA = paramfcy;
    this.nSs = paramString;
    paramfcy = this.ESA.abCn;
    label67:
    label87:
    label107:
    int i;
    if (paramfcy == null)
    {
      paramString = localObject;
      paramfcy = paramString;
      if (paramString == null)
      {
        paramfcy = this.ESA.abCn;
        if (paramfcy != null) {
          break label224;
        }
        paramfcy = "";
      }
      this.ADt = paramfcy;
      paramfcy = this.ESA.abCn;
      if (paramfcy != null) {
        break label256;
      }
      paramfcy = "";
      this.name = paramfcy;
      paramfcy = this.ESA.abCn;
      if (paramfcy != null) {
        break label273;
      }
      paramfcy = "";
      this.desc = paramfcy;
      paramfcy = aw.Gjk;
      paramfcy = this.ESA.abCn;
      if (paramfcy != null) {
        break label290;
      }
      i = 0;
      label130:
      this.price = aw.Uu(i);
      paramfcy = this.ESA.abCn;
      if (paramfcy != null) {
        break label299;
      }
      i = j;
      label153:
      this.count = i;
      i = this.ESA.state;
      paramfcy = a.j.ahnM;
      if (i != a.j.a.jVJ()) {
        break label307;
      }
      paramfcy = MMApplicationContext.getContext().getString(p.h.CpZ);
    }
    for (;;)
    {
      s.s(paramfcy, "when (skuInfo.state) {\n …\n        else -> \"\"\n    }");
      this.ESB = paramfcy;
      AppMethodBeat.o(332353);
      return;
      paramfcy = paramfcy.abHN;
      paramString = localObject;
      if (paramfcy == null) {
        break;
      }
      paramString = paramfcy.mdZ;
      break;
      label224:
      paramfcy = paramfcy.abHN;
      if (paramfcy == null)
      {
        paramfcy = "";
        break label67;
      }
      paramString = paramfcy.url;
      paramfcy = paramString;
      if (paramString != null) {
        break label67;
      }
      paramfcy = "";
      break label67;
      label256:
      paramString = paramfcy.abHK;
      paramfcy = paramString;
      if (paramString != null) {
        break label87;
      }
      paramfcy = "";
      break label87;
      label273:
      paramString = paramfcy.abHL;
      paramfcy = paramString;
      if (paramString != null) {
        break label107;
      }
      paramfcy = "";
      break label107;
      label290:
      i = (int)paramfcy.abHO;
      break label130;
      label299:
      i = paramfcy.abHM;
      break label153;
      label307:
      paramfcy = a.j.ahnM;
      if (i == a.j.a.jVK())
      {
        paramfcy = MMApplicationContext.getContext().getString(p.h.Cqa);
      }
      else
      {
        paramfcy = a.j.ahnM;
        if (i == a.j.a.jVL())
        {
          paramfcy = MMApplicationContext.getContext().getString(p.h.Cqb);
        }
        else
        {
          paramfcy = a.j.ahnM;
          if (i == a.j.a.jVM())
          {
            paramfcy = MMApplicationContext.getContext().getString(p.h.Cqc);
          }
          else
          {
            paramfcy = a.j.ahnM;
            if (i == a.j.a.jVN())
            {
              paramfcy = MMApplicationContext.getContext().getString(p.h.Cqd);
            }
            else
            {
              paramfcy = a.j.ahnM;
              if (i == a.j.a.jVO()) {
                paramfcy = MMApplicationContext.getContext().getString(p.h.Cqe);
              } else {
                paramfcy = "";
              }
            }
          }
        }
      }
    }
  }
  
  public final int a(k paramk)
  {
    Object localObject = null;
    AppMethodBeat.i(332371);
    s.u(paramk, "obj");
    if ((paramk instanceof f))
    {
      paramk = ((f)paramk).ESA.abCn;
      fhd localfhd;
      if (paramk == null)
      {
        paramk = null;
        localfhd = this.ESA.abCn;
        if (localfhd != null) {
          break label75;
        }
      }
      for (;;)
      {
        if (!s.p(paramk, localObject)) {
          break label86;
        }
        AppMethodBeat.o(332371);
        return 0;
        paramk = Long.valueOf(paramk.abHI);
        break;
        label75:
        localObject = Long.valueOf(localfhd.abHI);
      }
    }
    label86:
    AppMethodBeat.o(332371);
    return -1;
  }
  
  public final long bZA()
  {
    fhd localfhd = this.ESA.abCn;
    if (localfhd == null) {
      return 0L;
    }
    return localfhd.abHI;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332366);
    int i = f.class.hashCode();
    AppMethodBeat.o(332366);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.data.f
 * JD-Core Version:    0.7.0.1
 */