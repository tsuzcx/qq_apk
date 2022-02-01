package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.convert.g;
import com.tencent.mm.plugin.finder.live.view.convert.h;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.view.convert.j;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveShopSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "anchorInitProduct", "", "getAnchorInitProduct", "()Z", "setAnchorInitProduct", "(Z)V", "anchorProductsOnSale", "getAnchorProductsOnSale", "setAnchorProductsOnSale", "value", "bindShop", "getBindShop", "setBindShop", "canUseCouponListCouponId", "", "getCanUseCouponListCouponId", "()Ljava/lang/String;", "setCanUseCouponListCouponId", "(Ljava/lang/String;)V", "canUseCouponProductList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowShelfProductItem;", "getCanUseCouponProductList", "()Ljava/util/LinkedList;", "couponLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getCouponLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCouponLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "couponList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getCouponList", "()Ljava/util/List;", "couponTotalCount", "", "getCouponTotalCount", "()I", "setCouponTotalCount", "(I)V", "curAppId", "getCurAppId", "setCurAppId", "extFlag", "", "getExtFlag", "()J", "setExtFlag", "(J)V", "firstBugProductList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFirstBugProductList", "()Ljava/util/ArrayList;", "setFirstBugProductList", "(Ljava/util/ArrayList;)V", "hasGoodsOrAdOrIssuingCoupon", "getHasGoodsOrAdOrIssuingCoupon", "hasMoreCoupon", "getHasMoreCoupon", "setHasMoreCoupon", "preloadMiniProgram", "getPreloadMiniProgram", "setPreloadMiniProgram", "productList", "getProductList", "setProductList", "(Ljava/util/LinkedList;)V", "Lcom/tencent/mm/protocal/protobuf/FinderReplayRecordSetting;", "productReplaySetting", "getProductReplaySetting", "()Lcom/tencent/mm/protocal/protobuf/FinderReplayRecordSetting;", "setProductReplaySetting", "(Lcom/tencent/mm/protocal/protobuf/FinderReplayRecordSetting;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "productShelf", "getProductShelf", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "setProductShelf", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;)V", "promotingInfoId", "getPromotingInfoId", "setPromotingInfoId", "promotingProduct", "getPromotingProduct", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setPromotingProduct", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "shoppingAvailable", "getShoppingAvailable", "setShoppingAvailable", "shoppingInMiniProgram", "getShoppingInMiniProgram", "setShoppingInMiniProgram", "findProduceItem", "productId", "haveShopOrAdItem", "info", "mergeProductShelf", "", "resp", "onCleared", "resetData", "saveRecordingProduct", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "updateCanUseCouponProduct", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a EhW;
  public boolean CEZ;
  public boolean EhX;
  private boolean EhY;
  public boolean EhZ;
  public bih Eia;
  public LinkedList<cc> Eib;
  public final LinkedList<k> Eic;
  public int Eid;
  public cc Eie;
  public long Eif;
  public ArrayList<Long> Eig;
  public boolean Eih;
  public String Eii;
  public boolean Eij;
  public boolean Eik;
  public com.tencent.mm.bx.b Eil;
  public String Eim;
  public buh Ein;
  public long Eio;
  
  static
  {
    AppMethodBeat.i(356645);
    EhW = new a((byte)0);
    AppMethodBeat.o(356645);
  }
  
  public q(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356618);
    this.Eic = new LinkedList();
    this.Eig = new ArrayList();
    this.Eii = "";
    AppMethodBeat.o(356618);
  }
  
  private void b(bih parambih)
  {
    AppMethodBeat.i(356624);
    if (parambih == null) {}
    for (Object localObject = "";; localObject = parambih)
    {
      Log.i("MMFinder.LiveShopSlice", s.X("FinderLiveGetShopShelfResponse:", com.tencent.mm.ae.f.dg(localObject)));
      this.Eia = parambih;
      AppMethodBeat.o(356624);
      return;
    }
  }
  
  private void gY(List<? extends bzc> paramList)
  {
    AppMethodBeat.i(356637);
    if (paramList == null) {
      paramList = null;
    }
    for (;;)
    {
      if (paramList == null) {
        ((p)((q)this).CBK.business(p.class)).c(null);
      }
      AppMethodBeat.o(356637);
      return;
      Iterator localIterator = ((Iterable)paramList).iterator();
      label50:
      int i;
      if (localIterator.hasNext())
      {
        paramList = localIterator.next();
        ehg localehg = ((bzc)paramList).aaij;
        if ((localehg != null) && (localehg.replay_status == 1000))
        {
          i = 1;
          label93:
          if (i == 0) {
            break label114;
          }
        }
      }
      for (;;)
      {
        paramList = (bzc)paramList;
        if (paramList != null) {
          break label121;
        }
        paramList = null;
        break;
        i = 0;
        break label93;
        label114:
        break label50;
        paramList = null;
      }
      label121:
      Log.i("MMFinder.LiveShopSlice", s.X("save recording product, id:", Long.valueOf(paramList.DVk)));
      ((p)this.CBK.business(p.class)).c(paramList);
      paramList = ah.aiuX;
    }
  }
  
  public final void a(buh parambuh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(356708);
    StringBuilder localStringBuilder = new StringBuilder("switch:");
    if (parambuh == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", type:");
      if (parambuh != null) {
        break label83;
      }
    }
    label83:
    for (Object localObject1 = localObject2;; localObject1 = Integer.valueOf(parambuh.ZTm))
    {
      Log.i("MMFinder.LiveShopSlice", localObject1);
      this.Ein = parambuh;
      AppMethodBeat.o(356708);
      return;
      localObject1 = Integer.valueOf(parambuh.ZTl);
      break;
    }
  }
  
  public final void aM(LinkedList<cc> paramLinkedList)
  {
    AppMethodBeat.i(356658);
    if (paramLinkedList == null) {}
    for (Object localObject1 = null;; localObject1 = (List)localObject1)
    {
      gY((List)localObject1);
      this.Eib = paramLinkedList;
      AppMethodBeat.o(356658);
      return;
      Object localObject2 = (Iterable)paramLinkedList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((cc)localObject3 instanceof k)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((k)((Iterator)localObject2).next()).DVj);
      }
    }
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(356746);
    this.Eik = false;
    this.Eil = null;
    this.Eid = 0;
    LinkedList localLinkedList = this.Eib;
    if (localLinkedList != null) {
      localLinkedList.clear();
    }
    AppMethodBeat.o(356746);
  }
  
  public final void ayx(String paramString)
  {
    AppMethodBeat.i(356698);
    s.u(paramString, "<set-?>");
    this.Eii = paramString;
    AppMethodBeat.o(356698);
  }
  
  public final void c(bih parambih)
  {
    AppMethodBeat.i(356731);
    if (parambih == null)
    {
      parambih = null;
      if (parambih == null)
      {
        parambih = ((q)this).Eib;
        if (parambih != null) {
          break label1262;
        }
      }
    }
    label293:
    label328:
    label335:
    label613:
    label744:
    label1262:
    for (parambih = null;; parambih = Integer.valueOf(parambih.size()))
    {
      Log.i("MMFinder.LiveShopSlice", s.X("continue mergeProductShelf resp is empty,current size:", parambih));
      AppMethodBeat.o(356731);
      return;
      if (this.Eib == null) {
        aM(new LinkedList());
      }
      Object localObject2;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      long l;
      int i;
      if (this.Eia == null)
      {
        b(parambih);
        parambih = parambih.ZgM;
        s.s(parambih, "resp.item_list");
        localObject2 = ((Iterable)parambih).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          parambih = (bmu)((Iterator)localObject2).next();
          localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          s.s(parambih, "remote");
          localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.a(parambih);
          if (localObject3 != null)
          {
            parambih = this.Eib;
            if (parambih != null) {
              parambih.add(localObject3);
            }
            if ((localObject3 instanceof i))
            {
              localObject4 = (Map)((e)business(e.class)).EeG;
              l = ((i)localObject3).DUP;
              localObject1 = ((i)localObject3).mdG;
              parambih = (bih)localObject1;
              if (localObject1 == null) {
                parambih = "";
              }
              ((Map)localObject4).put(Long.valueOf(l), parambih);
              Log.i("MMFinder.LiveShopSlice", "uxinfo：add adItem uxInfo, id:" + ((i)localObject3).DUP + ", info:" + ((i)localObject3).mdG);
            }
          }
        }
        parambih = this.Eib;
        if (parambih == null)
        {
          parambih = null;
          Log.i("MMFinder.LiveShopSlice", s.X("first mergeProductShelf, size:", parambih));
          parambih = this.Eib;
          if (parambih == null) {
            break label1109;
          }
          if (((Collection)parambih).isEmpty()) {
            break label1104;
          }
          i = 1;
          if (i != 1) {
            break label1109;
          }
          i = 1;
          if (i != 0)
          {
            this.EhY = true;
            Log.i("MMFinder.LiveShopSlice", "mergeProducts, anchorProductsOnSale!");
          }
          parambih = this.Eib;
          if (parambih != null) {
            break label1114;
          }
        }
      }
      for (parambih = null;; parambih = (List)parambih)
      {
        gY(parambih);
        parambih = ah.aiuX;
        break;
        parambih = Integer.valueOf(parambih.size());
        break label293;
        localObject1 = this.Eia;
        if (localObject1 != null) {
          ((bih)localObject1).ZRp = parambih.ZRp;
        }
        localObject1 = this.Eia;
        if (localObject1 != null) {
          ((bih)localObject1).ZRq = parambih.ZRq;
        }
        localObject1 = this.Eia;
        if (localObject1 != null) {
          ((bih)localObject1).ZRr = parambih.ZRr;
        }
        localObject1 = this.Eia;
        if (localObject1 != null) {
          ((bih)localObject1).ZRs = parambih.ZRs;
        }
        localObject1 = this.Eia;
        if (localObject1 != null) {
          ((bih)localObject1).ZRu = parambih.ZRu;
        }
        localObject2 = new LinkedList();
        parambih = parambih.ZgM;
        s.s(parambih, "resp.item_list");
        localObject3 = ((Iterable)parambih).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          parambih = (bmu)((Iterator)localObject3).next();
          localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
          s.s(parambih, "remote");
          localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.a(parambih);
          int j;
          if ((localObject4 instanceof k))
          {
            parambih = this.Eib;
            if (parambih == null)
            {
              parambih = null;
              if ((parambih != null) && (parambih.intValue() == -1)) {
                ((LinkedList)localObject2).add(localObject4);
              }
            }
            else
            {
              parambih = (List)parambih;
              i = 0;
              parambih = parambih.iterator();
              if (!parambih.hasNext()) {
                break label687;
              }
              localObject1 = (cc)parambih.next();
              if ((!(localObject1 instanceof k)) || (((k)localObject1).DVk != ((k)localObject4).DVk)) {
                break label675;
              }
              j = 1;
              if (j == 0) {
                break label680;
              }
            }
            for (;;)
            {
              parambih = Integer.valueOf(i);
              break label576;
              break;
              j = 0;
              break label663;
              i += 1;
              break label613;
              i = -1;
            }
          }
          else
          {
            if ((localObject4 instanceof i))
            {
              parambih = this.Eib;
              if (parambih == null)
              {
                parambih = null;
                if (parambih != null) {
                  break label823;
                }
              }
              while (parambih.intValue() != -1)
              {
                Log.i("MMFinder.LiveShopSlice", s.X("add adItem, exist:", parambih));
                break;
                parambih = (List)parambih;
                i = 0;
                parambih = parambih.iterator();
                if (parambih.hasNext())
                {
                  localObject1 = (cc)parambih.next();
                  if (((localObject1 instanceof i)) && (((i)localObject1).DUP == ((i)localObject4).DUP))
                  {
                    j = 1;
                    if (j == 0) {
                      break label811;
                    }
                  }
                }
                for (;;)
                {
                  parambih = Integer.valueOf(i);
                  break;
                  j = 0;
                  break label794;
                  i += 1;
                  break label744;
                  i = -1;
                }
              }
              ((LinkedList)localObject2).add(localObject4);
              Map localMap = (Map)((e)business(e.class)).EeG;
              l = ((i)localObject4).DUP;
              localObject1 = ((i)localObject4).mdG;
              parambih = (bih)localObject1;
              if (localObject1 == null) {
                parambih = "";
              }
              localMap.put(Long.valueOf(l), parambih);
              Log.i("MMFinder.LiveShopSlice", "uxinfo：add adItem uxInfo, id:" + ((i)localObject4).DUP + ", info:" + ((i)localObject4).mdG);
              parambih = this.Eib;
              if (parambih == null) {}
              for (i = 0;; i = parambih.size())
              {
                Log.i("MMFinder.LiveShopSlice", s.X("add adItem, index:", Integer.valueOf(i + ((LinkedList)localObject2).size() - 1)));
                break;
              }
            }
            if ((localObject4 instanceof j))
            {
              Log.i("MMFinder.LiveShopSlice", s.X("add couponItem: ", localObject4));
              ((LinkedList)localObject2).add(localObject4);
            }
          }
        }
        parambih = this.Eib;
        if (parambih != null) {
          kotlin.a.p.e((List)parambih, (kotlin.g.a.b)b.Eip);
        }
        parambih = this.Eib;
        if (parambih != null) {
          parambih.addAll((Collection)localObject2);
        }
        parambih = this.Eib;
        if (parambih == null) {}
        for (parambih = null;; parambih = Integer.valueOf(parambih.size()))
        {
          Log.i("MMFinder.LiveShopSlice", s.X("continue mergeProductShelf, size:", parambih));
          break;
        }
        i = 0;
        break label328;
        i = 0;
        break label335;
        localObject1 = (Iterable)parambih;
        parambih = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (((cc)localObject2 instanceof k)) {
            parambih.add(localObject2);
          }
        }
        localObject1 = (Iterable)parambih;
        parambih = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          parambih.add(((k)((Iterator)localObject1).next()).DVj);
        }
      }
    }
  }
  
  public final void d(cc paramcc)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(356690);
    if ((paramcc instanceof k))
    {
      Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct ShelfProductInfo:", Long.valueOf(((k)paramcc).DVk)));
      bool2 = this.EhZ;
      if (((k)paramcc).DVr == 1)
      {
        bool1 = true;
        this.EhZ = (bool1 | bool2);
        this.Eif = ((k)paramcc).DUI;
        this.Eie = paramcc;
      }
    }
    for (;;)
    {
      Log.i("MMFinder.LiveShopSlice", s.X("promotingInfoId has update to:", Long.valueOf(this.Eif)));
      AppMethodBeat.o(356690);
      return;
      bool1 = false;
      break;
      if ((paramcc instanceof i))
      {
        Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct ShopWindowAdItem:", Long.valueOf(((i)paramcc).DUO.DUP)));
        bool2 = this.EhZ;
        if (((i)paramcc).Caa == 1) {}
        for (;;)
        {
          this.EhZ = (bool2 | bool1);
          this.Eif = ((i)paramcc).DUI;
          this.Eie = paramcc;
          break;
          bool1 = false;
        }
      }
      if ((paramcc instanceof j))
      {
        Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct ShopCouponItem:", Long.valueOf(((j)paramcc).bZA())));
        this.Eif = ((j)paramcc).DUI;
        this.Eie = paramcc;
      }
      else if ((paramcc instanceof g))
      {
        Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct PromoteLiveWeComItem:", Long.valueOf(((g)paramcc).bZA())));
        this.Eif = ((g)paramcc).DUI;
        this.EhZ |= false;
        this.Eie = paramcc;
      }
      else if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.e))
      {
        Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct PromoteLiveMpArticleItem:", Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.e)paramcc).bZA())));
        this.EhZ |= false;
        this.Eif = ((com.tencent.mm.plugin.finder.live.view.convert.e)paramcc).DUI;
        this.Eie = paramcc;
      }
      else if ((paramcc instanceof com.tencent.mm.plugin.finder.live.view.convert.f))
      {
        Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct PromoteLiveNoticeItem:", Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.f)paramcc).bZA())));
        this.EhZ |= false;
        this.Eif = ((com.tencent.mm.plugin.finder.live.view.convert.f)paramcc).DUI;
        this.Eie = paramcc;
      }
      else
      {
        if (!(paramcc instanceof h)) {
          break label462;
        }
        Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct PromoteRedPacketItem:", Long.valueOf(((h)paramcc).bZA())));
        this.EhZ |= false;
        this.Eif = ((h)paramcc).DUI;
        this.Eie = paramcc;
      }
    }
    label462:
    if (paramcc == null) {}
    for (;;)
    {
      Log.i("MMFinder.LiveShopSlice", s.X("promotingProduct: invalid or null: ", Boolean.valueOf(bool2)));
      this.EhZ |= false;
      this.Eif = 0L;
      this.Eie = null;
      break;
      bool2 = false;
    }
  }
  
  public final void d(bih parambih)
  {
    AppMethodBeat.i(356740);
    this.Eic.clear();
    if (parambih == null)
    {
      AppMethodBeat.o(356740);
      return;
    }
    parambih = parambih.ZgM;
    s.s(parambih, "resp.item_list");
    parambih = ((Iterable)parambih).iterator();
    while (parambih.hasNext())
    {
      Object localObject = (bmu)parambih.next();
      com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      s.s(localObject, "remote");
      localObject = com.tencent.mm.plugin.finder.live.view.convert.a.a((bmu)localObject);
      if ((localObject != null) && ((localObject instanceof k))) {
        this.Eic.add(localObject);
      }
    }
    AppMethodBeat.o(356740);
  }
  
  public final List<cc> ezk()
  {
    AppMethodBeat.i(356668);
    Object localObject1 = this.Eib;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (List)localObject1)
    {
      localObject1 = (List)new LinkedList();
      AppMethodBeat.o(356668);
      return localObject1;
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof j)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
    }
    AppMethodBeat.o(356668);
    return localObject1;
  }
  
  public final boolean ezl()
  {
    AppMethodBeat.i(356676);
    Object localObject = this.Eib;
    if (localObject != null)
    {
      localObject = (Iterable)localObject;
      if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
      {
        localObject = ((Iterable)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          cc localcc = (cc)((Iterator)localObject).next();
          if (((localcc instanceof k)) || ((localcc instanceof i)) || (((localcc instanceof j)) && (((j)localcc).DVc)))
          {
            i = 1;
            label98:
            if (i == 0) {
              break label120;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label127;
        }
        AppMethodBeat.o(356676);
        return true;
        i = 0;
        break label98;
        label120:
        break;
      }
    }
    label127:
    AppMethodBeat.o(356676);
    return false;
  }
  
  public final String info()
  {
    AppMethodBeat.i(356760);
    String str = s.X("bindShop = ", Boolean.valueOf(this.CEZ));
    AppMethodBeat.o(356760);
    return str;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356754);
    aNm();
    sp(false);
    this.EhX = false;
    this.EhY = false;
    this.EhZ = false;
    b(null);
    d(null);
    this.Eig.clear();
    this.Eih = false;
    this.Eii = "";
    this.Eio = 0L;
    AppMethodBeat.o(356754);
  }
  
  public final void sp(boolean paramBoolean)
  {
    AppMethodBeat.i(356649);
    Log.i("MMFinder.LiveShopSlice", s.X("bindShop:", Boolean.valueOf(paramBoolean)));
    this.CEZ = paramBoolean;
    AppMethodBeat.o(356649);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveShopSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<cc, Boolean>
  {
    public static final b Eip;
    
    static
    {
      AppMethodBeat.i(356830);
      Eip = new b();
      AppMethodBeat.o(356830);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.q
 * JD-Core Version:    0.7.0.1
 */