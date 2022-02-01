package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.plugin.finder.live.view.convert.e;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveShopSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "anchorInitProduct", "", "getAnchorInitProduct", "()Z", "setAnchorInitProduct", "(Z)V", "anchorProductsOnSale", "getAnchorProductsOnSale", "setAnchorProductsOnSale", "value", "bindShop", "getBindShop", "setBindShop", "curAppId", "", "getCurAppId", "()Ljava/lang/String;", "setCurAppId", "(Ljava/lang/String;)V", "firstBugProductList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFirstBugProductList", "()Ljava/util/ArrayList;", "setFirstBugProductList", "(Ljava/util/ArrayList;)V", "preloadMiniProgram", "getPreloadMiniProgram", "setPreloadMiniProgram", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getProductList", "()Ljava/util/LinkedList;", "setProductList", "(Ljava/util/LinkedList;)V", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "productShelf", "getProductShelf", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "setProductShelf", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;)V", "promotingProduct", "getPromotingProduct", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setPromotingProduct", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "shoppingAvailable", "getShoppingAvailable", "setShoppingAvailable", "shoppingInMiniProgram", "getShoppingInMiniProgram", "setShoppingInMiniProgram", "info", "mergeProductShelf", "", "resp", "onCleared", "resetProductList", "Companion", "plugin-finder-base_release"})
public final class j
  extends a<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a ziP;
  public boolean yeB;
  public boolean ziF;
  public boolean ziG;
  public boolean ziH;
  public azy ziI;
  public LinkedList<bu> ziJ;
  public bu ziK;
  public ArrayList<Long> ziL;
  public boolean ziM;
  public String ziN;
  public boolean ziO;
  
  static
  {
    AppMethodBeat.i(258495);
    ziP = new a((byte)0);
    AppMethodBeat.o(258495);
  }
  
  public j(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(258494);
    this.ziL = new ArrayList();
    this.ziN = "";
    AppMethodBeat.o(258494);
  }
  
  private void c(azy paramazy)
  {
    AppMethodBeat.i(258485);
    StringBuilder localStringBuilder = new StringBuilder("FinderLiveGetShopShelfResponse:");
    if (paramazy == null) {}
    for (Object localObject = "";; localObject = paramazy)
    {
      Log.i("MMFinder.LiveShopSlice", g.bN(localObject));
      this.ziI = paramazy;
      AppMethodBeat.o(258485);
      return;
    }
  }
  
  public final void aDe(String paramString)
  {
    AppMethodBeat.i(258489);
    p.k(paramString, "<set-?>");
    this.ziN = paramString;
    AppMethodBeat.o(258489);
  }
  
  public final void d(bu parambu)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(258487);
    if ((parambu instanceof f))
    {
      Log.i("MMFinder.LiveShopSlice", "promotingProduct ShelfProductInfo:" + parambu.mf());
      bool2 = this.ziH;
      if (((f)parambu).zaV == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        this.ziH = (bool1 | bool2);
        this.ziK = parambu;
        AppMethodBeat.o(258487);
        return;
      }
    }
    if ((parambu instanceof e))
    {
      Log.i("MMFinder.LiveShopSlice", "promotingProduct ShopWindowAdItem:" + parambu.mf());
      bool2 = this.ziH;
      if (((e)parambu).promoting == 1) {}
      for (;;)
      {
        this.ziH = (bool2 | bool1);
        this.ziK = parambu;
        AppMethodBeat.o(258487);
        return;
        bool1 = false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("promotingProduct: invalid or null: ");
    if (parambu == null) {}
    for (;;)
    {
      Log.i("MMFinder.LiveShopSlice", bool2);
      this.ziH |= false;
      this.ziK = null;
      AppMethodBeat.o(258487);
      return;
      bool2 = false;
    }
  }
  
  public final void d(azy paramazy)
  {
    AppMethodBeat.i(258490);
    if (paramazy != null)
    {
      if (this.ziJ == null) {
        this.ziJ = new LinkedList();
      }
      Object localObject2;
      long l;
      Object localObject3;
      if (this.ziI == null)
      {
        c(paramazy);
        paramazy = paramazy.SiG;
        p.j(paramazy, "resp.item_list");
        paramazy = ((Iterable)paramazy).iterator();
        while (paramazy.hasNext())
        {
          localObject1 = (bcr)paramazy.next();
          localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
          p.j(localObject1, "remote");
          localObject1 = com.tencent.mm.plugin.finder.live.view.convert.a.a((bcr)localObject1);
          if (localObject1 != null)
          {
            localObject2 = this.ziJ;
            if (localObject2 != null) {
              ((LinkedList)localObject2).add(localObject1);
            }
            if ((localObject1 instanceof e))
            {
              localObject2 = (Map)((b)business(b.class)).zgK;
              l = ((e)localObject1).zaI;
              localObject3 = ((e)localObject1).jDL;
              p.j(localObject3, "item.uxinfo");
              ((Map)localObject2).put(Long.valueOf(l), localObject3);
              Log.i("MMFinder.LiveShopSlice", "uxinfo：add adItem uxInfo, id:" + ((e)localObject1).zaI + ", info:" + ((e)localObject1).jDL);
            }
          }
        }
        localObject1 = new StringBuilder("first mergeProductShelf, size:");
        paramazy = this.ziJ;
        if (paramazy != null)
        {
          paramazy = Integer.valueOf(paramazy.size());
          Log.i("MMFinder.LiveShopSlice", paramazy);
          paramazy = this.ziJ;
          if (paramazy == null) {
            break label1007;
          }
          if (((Collection)paramazy).isEmpty()) {
            break label1002;
          }
        }
      }
      label516:
      label566:
      label570:
      label603:
      label737:
      label1002:
      for (int i = 1;; i = 0)
      {
        if (i == 1)
        {
          this.ziG = true;
          Log.i("MMFinder.LiveShopSlice", "mergeProducts, anchorProductsOnSale!");
        }
        AppMethodBeat.o(258490);
        return;
        paramazy = null;
        break;
        localObject1 = this.ziI;
        if (localObject1 != null) {
          ((azy)localObject1).SLw = paramazy.SLw;
        }
        localObject1 = this.ziI;
        if (localObject1 != null) {
          ((azy)localObject1).SLx = paramazy.SLx;
        }
        localObject1 = this.ziI;
        if (localObject1 != null) {
          ((azy)localObject1).SLy = paramazy.SLy;
        }
        localObject1 = this.ziI;
        if (localObject1 != null) {
          ((azy)localObject1).SLz = paramazy.SLz;
        }
        localObject1 = new LinkedList();
        paramazy = paramazy.SiG;
        p.j(paramazy, "resp.item_list");
        localObject2 = ((Iterable)paramazy).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramazy = (bcr)((Iterator)localObject2).next();
          localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
          p.j(paramazy, "remote");
          localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.a(paramazy);
          Object localObject4;
          int j;
          if ((localObject3 instanceof f))
          {
            paramazy = this.ziJ;
            if (paramazy != null)
            {
              paramazy = (List)paramazy;
              i = 0;
              paramazy = paramazy.iterator();
              if (paramazy.hasNext())
              {
                localObject4 = (bu)paramazy.next();
                if (((localObject4 instanceof f)) && (((f)localObject4).zaO == ((f)localObject3).zaO))
                {
                  j = 1;
                  if (j == 0) {
                    break label603;
                  }
                }
              }
            }
            for (paramazy = Integer.valueOf(i);; paramazy = null)
            {
              if ((paramazy == null) || (paramazy.intValue() != -1)) {
                break label618;
              }
              ((LinkedList)localObject1).add(localObject3);
              break;
              j = 0;
              break label566;
              i += 1;
              break label516;
              i = -1;
              break label570;
            }
          }
          else
          {
            label618:
            if ((localObject3 instanceof e))
            {
              paramazy = this.ziJ;
              if (paramazy != null)
              {
                paramazy = (List)paramazy;
                i = 0;
                paramazy = paramazy.iterator();
                if (paramazy.hasNext())
                {
                  localObject4 = (bu)paramazy.next();
                  if (((localObject4 instanceof e)) && (((e)localObject4).zaI == ((e)localObject3).zaI))
                  {
                    j = 1;
                    if (j == 0) {
                      break label737;
                    }
                    paramazy = Integer.valueOf(i);
                    if (paramazy != null) {
                      break label754;
                    }
                  }
                }
              }
              label754:
              while (paramazy.intValue() != -1)
              {
                Log.i("MMFinder.LiveShopSlice", "add adItem, exist:".concat(String.valueOf(paramazy)));
                break;
                j = 0;
                break label701;
                i += 1;
                break label651;
                i = -1;
                break label705;
                paramazy = null;
                break label710;
              }
              ((LinkedList)localObject1).add(localObject3);
              paramazy = (Map)((b)business(b.class)).zgK;
              l = ((e)localObject3).zaI;
              localObject4 = ((e)localObject3).jDL;
              p.j(localObject4, "remoteItem.uxinfo");
              paramazy.put(Long.valueOf(l), localObject4);
              Log.i("MMFinder.LiveShopSlice", "uxinfo：add adItem uxInfo, id:" + ((e)localObject3).zaI + ", info:" + ((e)localObject3).jDL);
              paramazy = new StringBuilder("add adItem, index:");
              localObject3 = this.ziJ;
              if (localObject3 != null) {}
              for (i = ((LinkedList)localObject3).size();; i = 0)
              {
                Log.i("MMFinder.LiveShopSlice", i + ((LinkedList)localObject1).size() - 1);
                break;
              }
            }
          }
        }
        paramazy = this.ziJ;
        if (paramazy != null) {
          paramazy.addAll((Collection)localObject1);
        }
        localObject1 = new StringBuilder("continue mergeProductShelf, size:");
        paramazy = this.ziJ;
        if (paramazy != null) {}
        for (paramazy = Integer.valueOf(paramazy.size());; paramazy = null)
        {
          Log.i("MMFinder.LiveShopSlice", paramazy);
          break;
        }
      }
      label651:
      label701:
      label705:
      label710:
      label1007:
      AppMethodBeat.o(258490);
      return;
    }
    paramazy = (j)this;
    Object localObject1 = new StringBuilder("continue mergeProductShelf resp is empty,current size:");
    paramazy = paramazy.ziJ;
    if (paramazy != null) {}
    for (paramazy = Integer.valueOf(paramazy.size());; paramazy = null)
    {
      Log.i("MMFinder.LiveShopSlice", paramazy);
      AppMethodBeat.o(258490);
      return;
    }
  }
  
  public final void dHk()
  {
    AppMethodBeat.i(258491);
    LinkedList localLinkedList = this.ziJ;
    if (localLinkedList != null)
    {
      localLinkedList.clear();
      AppMethodBeat.o(258491);
      return;
    }
    AppMethodBeat.o(258491);
  }
  
  public final String info()
  {
    AppMethodBeat.i(258493);
    String str = "bindShop = " + this.yeB;
    AppMethodBeat.o(258493);
    return str;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(258492);
    pB(false);
    this.ziF = false;
    this.ziG = false;
    this.ziH = false;
    c(null);
    d(null);
    this.ziL.clear();
    this.ziM = false;
    this.ziN = "";
    AppMethodBeat.o(258492);
  }
  
  public final void pB(boolean paramBoolean)
  {
    AppMethodBeat.i(258484);
    Log.i("MMFinder.LiveShopSlice", "bindShop:".concat(String.valueOf(paramBoolean)));
    this.yeB = paramBoolean;
    AppMethodBeat.o(258484);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveShopSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.j
 * JD-Core Version:    0.7.0.1
 */