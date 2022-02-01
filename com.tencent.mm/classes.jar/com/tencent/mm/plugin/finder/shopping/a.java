package com.tencent.mm.plugin.finder.shopping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI30;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.as;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.view.adapter.ad;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.ba;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.fce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerPresenter;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getActivity", "()Landroid/app/Activity;", "enableSetRecommend", "", "getEnableSetRecommend", "()Z", "params", "Lcom/tencent/mm/protocal/protobuf/ShoppingManagerParams;", "getParams", "()Lcom/tencent/mm/protocal/protobuf/ShoppingManagerParams;", "setParams", "(Lcom/tencent/mm/protocal/protobuf/ShoppingManagerParams;)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getProductList", "()Ljava/util/LinkedList;", "viewCallback", "Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback;)V", "addProduct", "", "attach", "modifyShoppingContent", "allList", "", "", "delete", "onDestroy", "reportWhenAddProduct", "setProductRecommendWord", "productId", "wording", "updateProductList", "userBack", "source", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final boolean DSO;
  public final LinkedList<cc> Eib;
  public b FAe;
  public fce FAf;
  public final String TAG;
  public final Activity activity;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(330518);
    this.activity = paramActivity;
    this.TAG = "FinderLiveShoppingManagerPresenter";
    paramActivity = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jTu().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.DSO = bool;
      this.Eib = new LinkedList();
      AppMethodBeat.o(330518);
      return;
    }
  }
  
  private static final void a(a parama, final String paramString)
  {
    AppMethodBeat.i(330527);
    s.u(parama, "this$0");
    Log.i("FinderLiveShoppingManagerUI", s.X("onReceiveValue value", paramString));
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(330527);
      return;
    }
    paramString = new i(paramString);
    int i = paramString.optInt("scene");
    paramString.optString("appId");
    paramString.optString("path");
    paramString.optString("shopWindowId");
    paramString.optString("sceneNote");
    paramString.optInt("shareMode");
    paramString.optLong("productId");
    if (i == 0)
    {
      paramString = com.tencent.mm.ui.component.k.aeZF;
      parama = ((com.tencent.mm.plugin.finder.shopping.viewmodel.a)com.tencent.mm.ui.component.k.nq((Context)parama.activity).q(com.tencent.mm.plugin.finder.shopping.viewmodel.a.class)).FAj;
      if (parama != null)
      {
        paramString = aj.CGT;
        paramString = aj.elr();
        final fce localfce = parama.FAf;
        if ((paramString != null) && (localfce != null)) {
          kotlinx.coroutines.j.a(((OccupyFinderUI30)parama.activity).coroutineScope, null, null, (m)new b(parama, paramString, localfce, null), 3);
        }
      }
    }
    AppMethodBeat.o(330527);
  }
  
  public final void Tj(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(330553);
    Object localObject1 = this.FAe;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    Object localObject3;
    do
    {
      do
      {
        if (localObject1 == null) {
          Log.i(this.TAG, "userBack source:" + paramInt + " editAdapter is null!");
        }
        AppMethodBeat.o(330553);
        return;
        localObject3 = ((b)localObject1).FAk;
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject3 = ((ba)localObject3).Eut;
      localObject1 = localObject2;
    } while (localObject3 == null);
    Log.i(this.TAG, "userBack source:" + paramInt + ",productIdList:" + ((ad)localObject3).evR());
    if (((ad)localObject3).evR().isEmpty()) {
      m((List)((ad)localObject3).DSP, true);
    }
    for (;;)
    {
      localObject1 = ah.aiuX;
      break;
      m(((ad)localObject3).evR(), false);
    }
  }
  
  public final void esk()
  {
    AppMethodBeat.i(330549);
    Object localObject1 = com.tencent.mm.plugin.finder.live.k.Bxu;
    localObject1 = this.FAf;
    Object localObject2;
    label43:
    Object localObject3;
    long l1;
    label56:
    long l2;
    label69:
    label85:
    Object localObject4;
    label101:
    Object localObject5;
    label117:
    Object localObject6;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = this.FAf;
      if (localObject2 != null) {
        break label550;
      }
      localObject2 = "";
      localObject3 = this.FAf;
      if (localObject3 != null) {
        break label574;
      }
      l1 = 0L;
      localObject3 = this.FAf;
      if (localObject3 != null) {
        break label583;
      }
      l2 = 0L;
      localObject3 = this.FAf;
      if (localObject3 != null) {
        break label592;
      }
      localObject3 = "";
      localObject4 = this.FAf;
      if (localObject4 != null) {
        break label616;
      }
      localObject4 = "";
      localObject5 = this.FAf;
      if (localObject5 != null) {
        break label640;
      }
      localObject5 = "";
      localObject6 = this.FAf;
      if (localObject6 != null) {
        break label664;
      }
      localObject6 = "";
      label133:
      localObject1 = com.tencent.mm.plugin.finder.live.k.a((String)localObject1, (String)localObject2, l1, l2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, "post_live_add");
      localObject2 = com.tencent.mm.plugin.finder.live.k.Bxu;
      com.tencent.mm.plugin.finder.live.k.d((com.tencent.mm.plugin.appbrand.api.g)localObject1);
      localObject2 = aj.CGT;
      localObject2 = aj.elr();
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.finder.live.model.g.CEN;
        localObject3 = (Context)this.activity;
        localObject4 = new a..ExternalSyntheticLambda0(this);
        s.u(localObject3, "context");
        s.u(localObject2, "buContext");
        s.u(localObject1, "bundle");
        localObject5 = new StringBuilder("open fullscreen miniPro appId:").append(((com.tencent.mm.plugin.appbrand.api.g)localObject1).appId).append(",patch:").append(((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAF).append(",luanchFromApp:true,is test:");
        localObject6 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        Log.i("FinderLiveAssistant2", com.tencent.mm.plugin.finder.live.utils.a.bUq());
        if ((!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.api.g)localObject1).appId)) && (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.api.g)localObject1).qAF))) {
          break label688;
        }
      }
      label312:
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", q.as.Dzn.action);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((JSONObject)localObject2).put("sessionid", com.tencent.mm.plugin.finder.live.report.j.Doc.DpP);
      ((JSONObject)localObject2).put("shopwindowid", "");
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.Doc.Dqv = true;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 != null) {
        break label745;
      }
      localObject1 = null;
      label398:
      ((JSONObject)localObject2).put("appid", localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 != null) {
        break label779;
      }
      l1 = -1L;
      label428:
      if (l1 >= 0L) {
        break label832;
      }
      ((JSONObject)localObject2).put("liveid", "");
      label446:
      localObject1 = c.zGj;
      ((JSONObject)localObject2).put("clickid", c.dKp());
      localObject1 = c.zGj;
      c.a.arH("");
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 != null) {
        break label848;
      }
      localObject1 = "";
    }
    for (;;)
    {
      ((JSONObject)localObject2).put("productid", localObject1);
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drn, ((JSONObject)localObject2).toString());
      AppMethodBeat.o(330549);
      return;
      localObject2 = ((fce)localObject1).app_id;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label550:
      localObject3 = ((fce)localObject2).abBI;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label43;
      }
      localObject2 = "";
      break label43;
      label574:
      l1 = ((fce)localObject3).object_id;
      break label56;
      label583:
      l2 = ((fce)localObject3).mMJ;
      break label69;
      label592:
      localObject4 = ((fce)localObject3).abBJ;
      localObject3 = localObject4;
      if (localObject4 != null) {
        break label85;
      }
      localObject3 = "";
      break label85;
      label616:
      localObject5 = ((fce)localObject4).session_id;
      localObject4 = localObject5;
      if (localObject5 != null) {
        break label101;
      }
      localObject4 = "";
      break label101;
      label640:
      localObject6 = ((fce)localObject5).request_id;
      localObject5 = localObject6;
      if (localObject6 != null) {
        break label117;
      }
      localObject5 = "";
      break label117;
      label664:
      String str = ((fce)localObject6).Edn;
      localObject6 = str;
      if (str != null) {
        break label133;
      }
      localObject6 = "";
      break label133;
      label688:
      localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      localObject6 = ((com.tencent.mm.plugin.appbrand.api.g)localObject1).appId;
      s.s(localObject6, "bundle.appId");
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject5).ayx((String)localObject6);
      ((com.tencent.mm.plugin.appbrand.api.g)localObject1).epq = z.raX;
      com.tencent.mm.plugin.finder.live.model.g.a((Context)localObject3, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, (com.tencent.mm.plugin.appbrand.api.g)localObject1, (ValueCallback)localObject4);
      break label312;
      label745:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label398;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject1).Eii;
      break label398;
      label779:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        l1 = -1L;
        break label428;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        l1 = -1L;
        break label428;
      }
      l1 = ((bip)localObject1).liveId;
      break label428;
      label832:
      ((JSONObject)localObject2).put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(l1));
      break label446;
      label848:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject1).Eie;
        if (localObject1 == null) {
          localObject1 = "";
        } else {
          localObject1 = Long.valueOf(((cc)localObject1).bZA());
        }
      }
    }
  }
  
  public final void m(List<Long> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(330560);
    s.u(paramList, "allList");
    Intent localIntent = new Intent();
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(String.valueOf(((Number)((Iterator)localObject).next()).longValue()));
    }
    localIntent.putStringArrayListExtra("KEY_PRODUCTLIST", new ArrayList((Collection)paramList));
    localIntent.putExtra("KEY_DELETE", paramBoolean);
    this.activity.setResult(-1, localIntent);
    AppMethodBeat.o(330560);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTransferResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<b.a<bnu>, ah>
  {
    a(w paramw, a parama, long paramLong, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(a parama, com.tencent.mm.plugin.finder.live.model.context.a parama1, fce paramfce, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(330532);
      paramObject = (kotlin.d.d)new b(this.FAg, paramString, localfce, paramd);
      AppMethodBeat.o(330532);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(330523);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(330523);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = w.a((Context)this.FAg.activity, (CharSequence)this.FAg.activity.getString(p.h.app_waiting), false, 3, null);
        localObject1 = (kotlin.d.f)bg.kCi();
        localObject3 = (m)new a(this.FAg, paramString, localfce, null);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = l.a((kotlin.d.f)localObject1, (m)localObject3, locald);
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(330523);
          return localObject2;
        }
        break;
      case 1: 
        localObject2 = (w)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        localObject2 = (bih)localObject1;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramString.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eib;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = p.a((Iterable)localObject1, com.tencent.mm.plugin.finder.live.view.convert.k.class))
        {
          localObject3 = this.FAg;
          if ((localObject2 != null) && (localObject1 != null))
          {
            ((a)localObject3).Eib.clear();
            ((a)localObject3).Eib.addAll((Collection)localObject1);
            localObject1 = ((a)localObject3).FAe;
            if (localObject1 != null) {
              com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.c((b)localObject1));
            }
          }
          paramObject.dismiss();
          paramObject = ah.aiuX;
          AppMethodBeat.o(330523);
          return paramObject;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopShelfResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super bih>, Object>
    {
      int label;
      
      a(a parama, com.tencent.mm.plugin.finder.live.model.context.a parama1, fce paramfce, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(330546);
        paramObject = (kotlin.d.d)new a(this.FAg, this.FAh, this.FAi, paramd);
        AppMethodBeat.o(330546);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(330531);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(330531);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = com.tencent.mm.plugin.finder.live.model.g.CEN;
          MMActivity localMMActivity = (MMActivity)this.FAg.activity;
          com.tencent.mm.plugin.finder.live.model.context.a locala1 = this.FAh;
          long l1 = this.FAi.mMJ;
          long l2 = this.FAi.object_id;
          Object localObject1 = this.FAi.abBJ;
          paramObject = localObject1;
          if (localObject1 == null) {
            paramObject = "";
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)this.FAh.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
          Object localObject2;
          if (localObject1 == null)
          {
            localObject1 = null;
            localObject3 = this.FAi.request_id;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject3 = (e)this.FAh.business(e.class);
            if (localObject3 != null) {
              break label242;
            }
          }
          label242:
          for (Object localObject3 = null;; localObject3 = ((e)localObject3).EeF)
          {
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            localObject1 = com.tencent.mm.plugin.finder.live.model.g.a(localMMActivity, locala1, l1, l2, paramObject, (byte[])localObject1, (String)localObject2, (String)localObject3, locald);
            paramObject = localObject1;
            if (localObject1 != locala) {
              break label256;
            }
            AppMethodBeat.o(330531);
            return locala;
            localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).mZp;
            break;
          }
        }
        ResultKt.throwOnFailure(paramObject);
        label256:
        AppMethodBeat.o(330531);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shopping.a
 * JD-Core Version:    0.7.0.1
 */