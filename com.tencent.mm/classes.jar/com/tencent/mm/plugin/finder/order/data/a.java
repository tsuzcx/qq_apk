package com.tencent.mm.plugin.finder.order.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.etq;
import com.tencent.mm.protocal.protobuf.fcd;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.protocal.protobuf.fcr;
import com.tencent.mm.protocal.protobuf.fcy;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.protocal.protobuf.gjr;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/data/OrderFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "order", "Lcom/tencent/mm/protocal/protobuf/EcCustomerOrder;", "detailJson", "", "(Lcom/tencent/mm/protocal/protobuf/EcCustomerOrder;Ljava/lang/String;)V", "appid", "getAppid", "()Ljava/lang/String;", "avatarUrl", "getAvatarUrl", "dateText", "kotlin.jvm.PlatformType", "getDateText", "deliveryAppid", "getDeliveryAppid", "deliveryPath", "getDeliveryPath", "getDetailJson", "finderNickname", "getFinderNickname", "finderUsername", "getFinderUsername", "h5", "getH5", "isExpand", "", "()Z", "setExpand", "(Z)V", "getOrder", "()Lcom/tencent/mm/protocal/protobuf/EcCustomerOrder;", "path", "getPath", "platformName", "getPlatformName", "price", "getPrice", "shopName", "getShopName", "skuList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/SkuInfo;", "getSkuList", "()Ljava/util/LinkedList;", "state", "", "getState", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getDeliveryInfo", "Lkotlin/Pair;", "getItemId", "", "getItemType", "getStateInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements cc
{
  public static final a ESk;
  public final alr ESl;
  public final String ESm;
  public final String ESn;
  public final String ESo;
  public final String ESp;
  public final String ESq;
  public final String ESr;
  public final LinkedList<fcy> ESs;
  public final String ESt;
  public final String appid;
  public final String finderUsername;
  public final String mPd;
  public final String nVM;
  public final String path;
  public final String price;
  public boolean pvv;
  private final int state;
  
  static
  {
    AppMethodBeat.i(332339);
    ESk = new a((byte)0);
    AppMethodBeat.o(332339);
  }
  
  public a(alr paramalr, String paramString)
  {
    AppMethodBeat.i(332334);
    this.ESl = paramalr;
    this.ESm = paramString;
    paramalr = this.ESl.ZsM;
    int i;
    if (paramalr == null)
    {
      paramalr = null;
      paramalr = (CharSequence)paramalr;
      if ((paramalr != null) && (paramalr.length() != 0)) {
        break label370;
      }
      i = 1;
      label68:
      if (i == 0) {
        break label392;
      }
      paramalr = this.ESl.ZsM;
      if (paramalr != null) {
        break label375;
      }
      paramalr = "";
      label87:
      this.nVM = paramalr;
      paramalr = this.ESl.ZsM;
      if (paramalr != null) {
        break label415;
      }
      paramalr = "";
      label107:
      this.ESn = paramalr;
      paramalr = this.ESl.ZsM;
      if (paramalr != null) {
        break label432;
      }
      paramalr = "";
      label127:
      this.ESo = paramalr;
      this.state = this.ESl.ZsQ;
      paramalr = this.ESl.ZsM;
      if (paramalr != null) {
        break label449;
      }
      paramalr = "";
      label158:
      this.appid = paramalr;
      paramalr = this.ESl.ZsM;
      if (paramalr != null) {
        break label496;
      }
      paramalr = "";
      label178:
      this.path = paramalr;
      paramalr = this.ESl.ZsM;
      if (paramalr != null) {
        break label543;
      }
      paramalr = "";
      label198:
      this.ESp = paramalr;
      paramalr = this.ESl.ZsN;
      if (paramalr != null) {
        break label575;
      }
      paramalr = "";
      label218:
      this.ESq = paramalr;
      paramalr = this.ESl.ZsN;
      if (paramalr != null) {
        break label607;
      }
      paramalr = "";
      label238:
      this.ESr = paramalr;
      this.ESs = this.ESl.MRf;
      if (this.ESl.ZsR <= 0L) {
        break label639;
      }
      paramalr = new SimpleDateFormat("M/d HH:mm", Locale.getDefault()).format(Long.valueOf(this.ESl.ZsR));
      label292:
      this.ESt = paramalr;
      paramalr = aw.Gjk;
      this.price = aw.Uu((int)this.ESl.ZsO);
      paramalr = this.ESl.ZsP;
      if (paramalr != null) {
        break label645;
      }
      paramalr = "";
      label331:
      this.mPd = paramalr;
      paramalr = this.ESl.ZsP;
      if (paramalr != null) {
        break label662;
      }
      paramalr = "";
    }
    for (;;)
    {
      this.finderUsername = paramalr;
      AppMethodBeat.o(332334);
      return;
      paramalr = paramalr.abBF;
      break;
      label370:
      i = 0;
      break label68;
      label375:
      paramString = paramalr.abBG;
      paramalr = paramString;
      if (paramString != null) {
        break label87;
      }
      paramalr = "";
      break label87;
      label392:
      paramString = this.ESl.ZsM;
      paramalr = localObject;
      if (paramString == null) {
        break label87;
      }
      paramalr = paramString.abBF;
      break label87;
      label415:
      paramString = paramalr.DUT;
      paramalr = paramString;
      if (paramString != null) {
        break label107;
      }
      paramalr = "";
      break label107;
      label432:
      paramString = paramalr.Zem;
      paramalr = paramString;
      if (paramString != null) {
        break label127;
      }
      paramalr = "";
      break label127;
      label449:
      paramalr = paramalr.abBH;
      if (paramalr == null)
      {
        paramalr = "";
        break label158;
      }
      paramalr = paramalr.Zre;
      if (paramalr == null)
      {
        paramalr = "";
        break label158;
      }
      paramString = paramalr.YPU;
      paramalr = paramString;
      if (paramString != null) {
        break label158;
      }
      paramalr = "";
      break label158;
      label496:
      paramalr = paramalr.abBH;
      if (paramalr == null)
      {
        paramalr = "";
        break label178;
      }
      paramalr = paramalr.Zre;
      if (paramalr == null)
      {
        paramalr = "";
        break label178;
      }
      paramString = paramalr.YPV;
      paramalr = paramString;
      if (paramString != null) {
        break label178;
      }
      paramalr = "";
      break label178;
      label543:
      paramalr = paramalr.abBH;
      if (paramalr == null)
      {
        paramalr = "";
        break label198;
      }
      paramString = paramalr.ESp;
      paramalr = paramString;
      if (paramString != null) {
        break label198;
      }
      paramalr = "";
      break label198;
      label575:
      paramalr = paramalr.abCe;
      if (paramalr == null)
      {
        paramalr = "";
        break label218;
      }
      paramString = paramalr.YPU;
      paramalr = paramString;
      if (paramString != null) {
        break label218;
      }
      paramalr = "";
      break label218;
      label607:
      paramalr = paramalr.abCe;
      if (paramalr == null)
      {
        paramalr = "";
        break label238;
      }
      paramString = paramalr.YPV;
      paramalr = paramString;
      if (paramString != null) {
        break label238;
      }
      paramalr = "";
      break label238;
      label639:
      paramalr = "";
      break label292;
      label645:
      paramString = paramalr.abwW;
      paramalr = paramString;
      if (paramString != null) {
        break label331;
      }
      paramalr = "";
      break label331;
      label662:
      paramString = paramalr.YIZ;
      paramalr = paramString;
      if (paramString == null) {
        paramalr = "";
      }
    }
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332362);
    s.u(paramk, "obj");
    if (((paramk instanceof a)) && (s.p(((a)paramk).ESl.YBi, this.ESl.YBi)))
    {
      AppMethodBeat.o(332362);
      return 0;
    }
    AppMethodBeat.o(332362);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332347);
    String str2 = this.ESl.YBi;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    long l = str1.hashCode();
    AppMethodBeat.o(332347);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332356);
    int i = a.class.hashCode();
    AppMethodBeat.o(332356);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/data/OrderFeed$Companion;", "", "()V", "TAG", "", "getSkuInfo", "skuInfos", "", "Lcom/tencent/mm/protocal/protobuf/SkuInfo;", "printOrder", "", "order", "Lcom/tencent/mm/protocal/protobuf/EcCustomerOrder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String hj(List<? extends fcy> paramList)
    {
      AppMethodBeat.i(332354);
      StringBuilder localStringBuilder1 = new StringBuilder();
      if (paramList != null)
      {
        Iterator localIterator = ((Iterable)paramList).iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          paramList = localIterator.next();
          if (i < 0) {
            p.kkW();
          }
          fcy localfcy = (fcy)paramList;
          StringBuilder localStringBuilder2 = new StringBuilder("[index").append(i).append("(state:").append(localfcy.state).append("):");
          paramList = localfcy.abCn;
          if (paramList == null)
          {
            paramList = null;
            label103:
            localStringBuilder2 = localStringBuilder2.append(paramList).append('(');
            paramList = localfcy.abCn;
            if (paramList != null) {
              break label212;
            }
            paramList = null;
            label128:
            localStringBuilder2 = localStringBuilder2.append(paramList).append(" or ");
            paramList = localfcy.abCn;
            if (paramList != null) {
              break label223;
            }
            paramList = null;
            label153:
            localStringBuilder2 = localStringBuilder2.append(paramList).append(" * ");
            paramList = localfcy.abCn;
            if (paramList != null) {
              break label234;
            }
          }
          label212:
          label223:
          label234:
          for (paramList = null;; paramList = Integer.valueOf(paramList.abHM))
          {
            localStringBuilder1.append(paramList + ")]");
            i += 1;
            break;
            paramList = paramList.abHK;
            break label103;
            paramList = Long.valueOf(paramList.abHO);
            break label128;
            paramList = Long.valueOf(paramList.abHP);
            break label153;
          }
        }
      }
      paramList = localStringBuilder1.toString();
      s.s(paramList, "sb.toString()");
      AppMethodBeat.o(332354);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.data.a
 * JD-Core Version:    0.7.0.1
 */