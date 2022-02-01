package com.tencent.mm.plugin.appbrand.jsapi.address;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AppBrandHalfScreenAddressSelector;", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract;", "()V", "DEFAULT_INIT_VALUE", "", "addrMgr", "Lcom/tencent/mm/plugin/address/model/WalletAddrMgr;", "getAddrMgr", "()Lcom/tencent/mm/plugin/address/model/WalletAddrMgr;", "addrMgr$delegate", "Lkotlin/Lazy;", "makeResponse", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectResponse;", "request", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectRequest;", "selectedRcptItem", "Lcom/tencent/mm/plugin/address/model/RcptItem;", "preProcessForDefaultValue", "resolveAreaItem", "current", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "size", "", "startSelector", "", "context", "Landroid/content/Context;", "onSelect", "Lkotlin/Function1;", "onCancel", "Lkotlin/Function0;", "isDigits", "", "matchCode", "_code", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements AddressSelectorContract
{
  public static final a rBY;
  private static final kotlin.j rBZ;
  
  static
  {
    AppMethodBeat.i(326528);
    rBY = new a();
    rBZ = k.cm((kotlin.g.a.a)a.rCa);
    AppMethodBeat.o(326528);
  }
  
  private static String a(AddressSelectorContract.SelectRequest paramSelectRequest)
  {
    AppMethodBeat.i(326499);
    Object localObject = (Collection)paramSelectRequest.rBW;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(326499);
      return "北京市 北京市 东城区";
    }
    ArrayList localArrayList = new ArrayList(paramSelectRequest.rBV.size);
    localObject = paramSelectRequest.rBW;
    s.checkNotNull(localObject);
    RcptItem localRcptItem = d((ArrayList)localObject, paramSelectRequest.rBV.size);
    localObject = localRcptItem;
    if (localRcptItem == null)
    {
      AppMethodBeat.o(326499);
      return "北京市 北京市 东城区";
    }
    do
    {
      localArrayList.add(0, localObject);
      localRcptItem = cqa().yB(((RcptItem)localObject).qhR);
      localObject = localRcptItem;
    } while (localRcptItem != null);
    if (localArrayList.size() < Math.max(paramSelectRequest.rBV.size, 3))
    {
      localObject = (RcptItem)p.oM((List)localArrayList);
      localObject = cqa().TB(((RcptItem)localObject).code);
      if (localObject == null) {}
      for (localObject = null;; localObject = (RcptItem)p.oL((List)localObject))
      {
        if (localObject == null) {
          break label197;
        }
        localArrayList.add(localArrayList.size(), localObject);
        break;
      }
    }
    label197:
    paramSelectRequest = p.a((Iterable)localArrayList, (CharSequence)" ", null, null, 0, null, (b)a.b.rCb, 30);
    AppMethodBeat.o(326499);
    return paramSelectRequest;
  }
  
  private static final void a(ah.a parama, kotlin.g.a.a parama1, ah.f paramf, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(326522);
    s.u(parama, "$selected");
    s.u(parama1, "$onCancel");
    s.u(paramf, "$selectorDialog");
    if (!parama.aiwY) {
      parama1.invoke();
    }
    c.f((Dialog)paramf.aqH);
    AppMethodBeat.o(326522);
  }
  
  private static final void b(Context paramContext, AddressSelectorContract.SelectRequest paramSelectRequest, b paramb, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(326517);
    s.u(paramContext, "$context");
    s.u(paramSelectRequest, "$request");
    s.u(paramb, "$onSelect");
    s.u(parama, "$onCancel");
    rBY.a(paramContext, paramSelectRequest, paramb, parama);
    AppMethodBeat.o(326517);
  }
  
  private static com.tencent.mm.plugin.address.model.j cqa()
  {
    AppMethodBeat.i(326486);
    com.tencent.mm.plugin.address.model.j localj = (com.tencent.mm.plugin.address.model.j)rBZ.getValue();
    AppMethodBeat.o(326486);
    return localj;
  }
  
  private static RcptItem d(ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(326509);
    int i;
    Object localObject2;
    int j;
    Object localObject1;
    if (paramInt > 0)
    {
      i = 0;
      localObject2 = null;
      j = i + 1;
      Object localObject3 = (String)p.ae((List)paramArrayList, i);
      Object localObject5 = cqa();
      if (localObject2 == null)
      {
        localObject1 = "";
        localObject1 = ((com.tencent.mm.plugin.address.model.j)localObject5).TB((String)localObject1);
        localObject4 = (CharSequence)localObject3;
        if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
          break label117;
        }
      }
      label117:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label122;
        }
        AppMethodBeat.o(326509);
        return localObject2;
        localObject4 = ((RcptItem)localObject2).code;
        localObject1 = localObject4;
        if (localObject4 != null) {
          break;
        }
        localObject1 = "";
        break;
      }
      label122:
      Object localObject4 = (CharSequence)localObject3;
      i = 0;
      label158:
      label182:
      RcptItem localRcptItem;
      boolean bool;
      if (i < ((CharSequence)localObject4).length()) {
        if (!Character.isDigit(((CharSequence)localObject4).charAt(i)))
        {
          i = 0;
          if (i == 0) {
            break label375;
          }
          s.s(localObject1, "list");
          Iterator localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            break label369;
          }
          localObject5 = localIterator.next();
          localRcptItem = (RcptItem)localObject5;
          s.s(localRcptItem, "it");
          if (localRcptItem.code.length() >= ((String)localObject3).length()) {
            break label281;
          }
          bool = false;
          label235:
          if (!bool) {
            break label367;
          }
        }
      }
      label281:
      label367:
      label369:
      for (localObject1 = localObject5;; localObject1 = null)
      {
        localObject3 = (RcptItem)localObject1;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label406;
        }
        AppMethodBeat.o(326509);
        return localObject2;
        i += 1;
        break;
        i = 1;
        break label158;
        if (localRcptItem.code.length() > ((String)localObject3).length())
        {
          int k = localRcptItem.code.length();
          int m = ((String)localObject3).length();
          i = 0;
          localObject1 = localObject3;
          for (;;)
          {
            localObject4 = localObject1;
            if (i >= k - m) {
              break;
            }
            localObject1 = s.X((String)localObject1, "0");
            i += 1;
          }
        }
        localObject4 = localObject3;
        bool = s.p(localRcptItem.code, localObject4);
        break label235;
        break label182;
      }
      label375:
      cqa();
      localObject3 = com.tencent.mm.plugin.address.model.j.g((List)localObject1, (String)localObject3);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        AppMethodBeat.o(326509);
        return localObject2;
      }
      label406:
      if (j < paramInt) {}
    }
    for (;;)
    {
      AppMethodBeat.o(326509);
      return localObject1;
      i = j;
      localObject2 = localObject1;
      break;
      localObject1 = null;
    }
  }
  
  public final void a(Context paramContext, final AddressSelectorContract.SelectRequest paramSelectRequest, final b<? super AddressSelectorContract.SelectResponse, ah> paramb, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(326541);
    s.u(paramContext, "context");
    s.u(paramSelectRequest, "request");
    s.u(paramb, "onSelect");
    s.u(parama, "onCancel");
    if (!s.p(Looper.getMainLooper(), Looper.myLooper()))
    {
      h.ahAA.bk(new a..ExternalSyntheticLambda1(paramContext, paramSelectRequest, paramb, parama));
      AppMethodBeat.o(326541);
      return;
    }
    ah.a locala = new ah.a();
    final ah.f localf = new ah.f();
    String str2 = a(paramSelectRequest);
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localf.aqH = new com.tencent.mm.plugin.address.ui.a(paramContext, str1, (b)new c(locala, paramb, paramSelectRequest, localf), paramSelectRequest.rBV.size, cqa());
    ((com.tencent.mm.plugin.address.ui.a)localf.aqH).setOnDismissListener(new a..ExternalSyntheticLambda0(locala, parama, localf));
    ((com.tencent.mm.plugin.address.ui.a)localf.aqH).show();
    AppMethodBeat.o(326541);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/address/model/WalletAddrMgr;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.address.model.j>
  {
    public static final a rCa;
    
    static
    {
      AppMethodBeat.i(326490);
      rCa = new a();
      AppMethodBeat.o(326490);
    }
    
    a()
    {
      super();
    }
    
    private static com.tencent.mm.plugin.address.model.j cqb()
    {
      AppMethodBeat.i(326484);
      com.tencent.mm.plugin.address.model.j localj = new com.tencent.mm.plugin.address.model.j();
      localj.bZi();
      AppMethodBeat.o(326484);
      return localj;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "rcptItem", "Lcom/tencent/mm/plugin/address/model/RcptItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<RcptItem, ah>
  {
    c(ah.a parama, b<? super AddressSelectorContract.SelectResponse, ah> paramb, AddressSelectorContract.SelectRequest paramSelectRequest, ah.f<com.tencent.mm.plugin.address.ui.a> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.a
 * JD-Core Version:    0.7.0.1
 */