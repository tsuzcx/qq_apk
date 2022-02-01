package com.tencent.mm.msgsubscription.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ShowInfo;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.api.c;
import com.tencent.mm.msgsubscription.ui.b.a.a;
import com.tencent.mm.msgsubscription.ui.b.b;
import com.tencent.mm.msgsubscription.ui.b.d;
import com.tencent.mm.msgsubscription.ui.b.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController;", "Lcom/tencent/mm/msgsubscription/model/biz_service/IBrandSubscribeMsgRequestController;", "()V", "TAG", "", "actionMachine", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSubscribeMsgList", "", "requestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "isGetAction", "", "action", "isSubscribeAction", "nextAction", "subscribeMsgList", "SubscribeMsgRequestCallback", "SubscribeMsgRequestTask", "plugin-comm_release"})
public final class a
{
  private static HashMap<Integer, Integer> jzP;
  public static final a jzQ;
  
  static
  {
    AppMethodBeat.i(223320);
    jzQ = new a();
    jzP = ae.g(new o[] { s.U(Integer.valueOf(1), Integer.valueOf(0)), s.U(Integer.valueOf(3), Integer.valueOf(2)), s.U(Integer.valueOf(2), Integer.valueOf(0)) });
    AppMethodBeat.o(223320);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(223318);
    p.h(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(223318);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(223319);
    p.h(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(223319);
  }
  
  public static final int un(int paramInt)
  {
    AppMethodBeat.i(223317);
    Integer localInteger = (Integer)jzP.get(Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      paramInt = localInteger.intValue();
      AppMethodBeat.o(223317);
      return paramInt;
    }
    AppMethodBeat.o(223317);
    return -1;
  }
  
  public static final boolean uo(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 1);
  }
  
  public static final boolean up(int paramInt)
  {
    return paramInt == 2;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"})
  public static abstract interface a
  {
    public abstract void a(k paramk, e parame);
    
    public abstract void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void biV();
    
    public abstract void biW();
    
    public abstract void i(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "", "context", "Landroid/content/Context;", "action", "", "bizAppId", "", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "extInfo", "requestCallback", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "(Landroid/content/Context;ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "bizUsername", "subscribeUrl", "content", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "buffer", "", "mAlertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "mBizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "mDialogContainerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mFromScene", "mSubscribeMsgDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "mSubscribeReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getSubscribeMsgTmpItems", "()Ljava/util/ArrayList;", "setSubscribeMsgTmpItems", "(Ljava/util/ArrayList;)V", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "applyUserAction", "", "event", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "dispatchSuccessResult", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "initReportInfo", "onGetSubscribeMsgListSuccess", "release", "reportSubscribeAuth", "showType", "timestamp", "", "run", "setFromScene", "fromScene", "showAlertDialog", "title", "okOnClickListener", "Landroid/content/DialogInterface$OnClickListener;", "showSettingPageAlert", "callback", "Lkotlin/Function0;", "showSubscribeRequestDialog", "showSuccessToast", "msg", "showToast", "Companion", "plugin-comm_release"})
  public static final class b
  {
    public static final a.b.a jAa;
    private int action;
    private byte[] buffer;
    private final String content;
    private final Context context;
    private String dVu;
    private final String extInfo;
    public int gwE;
    ArrayList<SubscribeMsgTmpItem> jzR;
    private ArrayList<String> jzS;
    public d jzT;
    public com.tencent.mm.msgsubscription.ui.b jzU;
    private e jzV;
    private com.tencent.mm.msgsubscription.b.a jzW;
    private com.tencent.mm.msgsubscription.c.a.a jzX;
    private final String jzY;
    private final a.a jzZ;
    private SubscribeMsgRequestDialogUiData jzc;
    private final String jzp;
    
    static
    {
      AppMethodBeat.i(223313);
      jAa = new a.b.a((byte)0);
      AppMethodBeat.o(223313);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a.a parama)
    {
      AppMethodBeat.i(223311);
      this.context = paramContext;
      this.action = paramInt;
      this.dVu = paramString1;
      this.jzY = paramString2;
      this.jzp = paramString3;
      this.content = paramString4;
      this.extInfo = paramString5;
      this.jzZ = parama;
      this.jzS = new ArrayList();
      paramContext = com.tencent.mm.msgsubscription.api.b.jza;
      this.jzW = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
      this.buffer = new byte[] { 0 };
      this.jzX = new com.tencent.mm.msgsubscription.c.a.a();
      AppMethodBeat.o(223311);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, ArrayList<String> paramArrayList, String paramString2, a.a parama)
    {
      this(paramContext, paramInt, "", paramString1, "", "", paramString2, parama);
      AppMethodBeat.i(223312);
      this.jzS.clear();
      this.jzS.addAll((Collection)paramArrayList);
      Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo initSubscribeMsgRequestTask templateId size: %s", new Object[] { Integer.valueOf(this.jzS.size()) });
      AppMethodBeat.o(223312);
    }
    
    private final void E(int paramInt, long paramLong)
    {
      AppMethodBeat.i(223310);
      if (this.gwE == 1)
      {
        com.tencent.mm.msgsubscription.c.a locala = com.tencent.mm.msgsubscription.c.a.jAr;
        com.tencent.mm.msgsubscription.c.a.a(this.dVu, paramInt, this.content, paramLong);
      }
      AppMethodBeat.o(223310);
    }
    
    private final void a(final Context paramContext, final int paramInt, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(223306);
      Object localObject1 = paramSubscribeMsgRequestResult.jyr;
      if (localObject1 != null) {}
      long l;
      final boolean bool;
      for (int i = ((ShowInfo)localObject1).dDG;; i = -1)
      {
        localObject1 = this.jzZ;
        if (localObject1 != null) {
          ((a.a)localObject1).biW();
        }
        l = System.currentTimeMillis() / 1000L;
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo dispatchSuccessResult showType: %s, action: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(paramSubscribeMsgRequestResult.jyu), paramSubscribeMsgRequestResult.jyv });
        if (!a.uo(paramInt)) {
          break label1774;
        }
        if (i != 0) {
          break label1356;
        }
        if (paramSubscribeMsgRequestResult.jyu != 0) {
          break label1318;
        }
        E(1, l);
        if (!paramSubscribeMsgRequestResult.jyk.isEmpty()) {
          break;
        }
        Log.w("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog list is empty and not show dialog");
        paramContext = this.jzZ;
        if (paramContext != null) {
          paramContext.i(this.action, 10002, "template list empty");
        }
        bool = false;
        paramContext = this.jzZ;
        if (paramContext == null) {
          break label1311;
        }
        paramContext.a(bool, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(223306);
        return;
      }
      Object localObject3 = (List)new ArrayList();
      localObject1 = ((Iterable)paramSubscribeMsgRequestResult.jyk).iterator();
      label289:
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubscribeMsgTmpItem)((Iterator)localObject1).next();
        Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog templateId: %s, chooseStatus: %d", new Object[] { ((SubscribeMsgTmpItem)localObject2).ixM, Integer.valueOf(((SubscribeMsgTmpItem)localObject2).jyd) });
        if (((SubscribeMsgTmpItem)localObject2).jyd == 1)
        {
          bool = true;
          ((List)localObject3).add(new b.b(bool, ((SubscribeMsgTmpItem)localObject2).title, ((SubscribeMsgTmpItem)localObject2).jyA, ((SubscribeMsgTmpItem)localObject2).ixM));
          this.jzX.jzS.add(((SubscribeMsgTmpItem)localObject2).ixM);
          localObject4 = this.jzX.jAs;
          if (((SubscribeMsgTmpItem)localObject2).jyd != 0) {
            break label375;
          }
        }
        label375:
        for (paramInt = 0;; paramInt = 1)
        {
          ((ArrayList)localObject4).add(Integer.valueOf(paramInt));
          break;
          bool = false;
          break label289;
        }
      }
      localObject1 = (SubscribeMsgTmpItem)j.kt((List)paramSubscribeMsgRequestResult.jyk);
      if (localObject1 != null)
      {
        paramInt = ((SubscribeMsgTmpItem)localObject1).jyz;
        label406:
        if ((((List)localObject3).size() != 1) || (paramSubscribeMsgRequestResult.jyq != 1)) {
          break label1211;
        }
        bool = true;
        label428:
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog size: %d, showStyle: %d, singleMode: %b, templateType: %d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(paramSubscribeMsgRequestResult.jyq), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        this.jzU = ((com.tencent.mm.msgsubscription.ui.b)new n(this, paramContext, (List)localObject3, paramSubscribeMsgRequestResult, bool, paramContext, (List)localObject3, (b.d)new o(this, paramSubscribeMsgRequestResult), bool));
        localObject1 = this.jzU;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).jCr = ((b.e)new p(this));
        }
        localObject4 = this.jzU;
        if (localObject4 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.jys;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject4).setDesc((String)localObject1);
        }
        localObject4 = this.jzU;
        if (localObject4 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.jyt;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject4).RK((String)localObject1);
        }
        if (bool) {
          ((b.b)j.ks((List)localObject3)).jCx = true;
        }
        localObject1 = this.jzU;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).RD(paramSubscribeMsgRequestResult.appName);
        }
        localObject1 = this.jzU;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).setIconUrl(paramSubscribeMsgRequestResult.jyi);
        }
        localObject1 = this.jzU;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.jyn;
          if (localObject2 == null) {
            p.hyc();
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).RH(((WordingInfo)localObject2).jyH);
        }
        localObject1 = this.jzU;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.jyn;
          if (localObject2 == null) {
            p.hyc();
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).RI(((WordingInfo)localObject2).jyI);
        }
        localObject1 = this.jzU;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.jyn;
          if (localObject2 == null) {
            p.hyc();
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).RJ(((WordingInfo)localObject2).jyJ);
        }
        localObject1 = this.jzU;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).jCq = 2131231957;
        }
        localObject4 = this.jzU;
        if (localObject4 != null)
        {
          localObject1 = paramSubscribeMsgRequestResult.jyn;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject2 = ((WordingInfo)localObject1).jyL;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject4).RE((String)localObject1);
        }
        localObject1 = this.jzU;
        if (localObject1 != null)
        {
          if (paramSubscribeMsgRequestResult.jyl) {
            break label1217;
          }
          bool = true;
          label871:
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).jCj = bool;
          localObject2 = ((com.tencent.mm.msgsubscription.ui.b)localObject1).jBZ;
          if (!((com.tencent.mm.msgsubscription.ui.b)localObject1).jCj) {
            break label1223;
          }
          paramInt = 0;
          label895:
          ((View)localObject2).setVisibility(paramInt);
        }
        localObject1 = this.jzU;
        if (localObject1 != null)
        {
          if (paramSubscribeMsgRequestResult.jym) {
            break label1229;
          }
          bool = true;
          label922:
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).jCl = bool;
          localObject2 = ((com.tencent.mm.msgsubscription.ui.b)localObject1).jBY;
          if (!((com.tencent.mm.msgsubscription.ui.b)localObject1).jCl) {
            break label1235;
          }
          paramInt = 0;
          label946:
          ((TextView)localObject2).setVisibility(paramInt);
        }
        localObject1 = this.jzU;
        if ((localObject1 == null) || (((com.tencent.mm.msgsubscription.ui.b)localObject1).jCj != true)) {
          break label1241;
        }
        localObject1 = this.jzU;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.jyn;
          if (localObject2 == null) {
            p.hyc();
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).RF(((WordingInfo)localObject2).jyK);
        }
        label1007:
        localObject1 = this.jzU;
        if (localObject1 == null) {
          break label1299;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.msgsubscription.ui.b)localObject1).jCj);
        label1028:
        localObject2 = this.jzU;
        if (localObject2 == null) {
          break label1305;
        }
      }
      label1299:
      label1305:
      for (Object localObject2 = Boolean.valueOf(((com.tencent.mm.msgsubscription.ui.b)localObject2).jCl);; localObject2 = null)
      {
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeMsgRequestDialog showAlways: %s, showReject: %s", new Object[] { localObject1, localObject2 });
        localObject1 = this.jzU;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).jCg = ((b.a.a)new q(this));
        }
        if (this.jzV == null)
        {
          this.jzV = new e(paramContext);
          if ((paramContext instanceof Activity))
          {
            localObject1 = new ViewGroup.LayoutParams(-1, -2);
            ((Activity)paramContext).addContentView((View)this.jzV, (ViewGroup.LayoutParams)localObject1);
          }
        }
        paramContext = this.jzU;
        if (paramContext != null) {
          paramContext.setPosition(2);
        }
        paramContext = this.jzV;
        if (paramContext != null) {
          paramContext.b((k)this.jzU);
        }
        paramContext = com.tencent.mm.msgsubscription.c.a.jAr;
        com.tencent.mm.msgsubscription.c.a.uq(((List)localObject3).size());
        bool = true;
        break;
        paramInt = 2;
        break label406;
        label1211:
        bool = false;
        break label428;
        label1217:
        bool = false;
        break label871;
        label1223:
        paramInt = 8;
        break label895;
        label1229:
        bool = false;
        break label922;
        label1235:
        paramInt = 8;
        break label946;
        label1241:
        localObject1 = this.jzU;
        if ((localObject1 == null) || (((com.tencent.mm.msgsubscription.ui.b)localObject1).jCl != true)) {
          break label1007;
        }
        localObject1 = this.jzU;
        if (localObject1 == null) {
          break label1007;
        }
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).RG(((WordingInfo)localObject2).jyM);
        break label1007;
        localObject1 = null;
        break label1028;
      }
      label1311:
      AppMethodBeat.o(223306);
      return;
      label1318:
      paramContext = this.jzZ;
      if (paramContext != null)
      {
        paramContext.i(paramInt, paramSubscribeMsgRequestResult.jyu, paramSubscribeMsgRequestResult.jyv);
        AppMethodBeat.o(223306);
        return;
      }
      AppMethodBeat.o(223306);
      return;
      label1356:
      if (i == 1)
      {
        E(2, l);
        localObject1 = paramSubscribeMsgRequestResult.jyr;
        if (localObject1 != null)
        {
          localObject1 = ((ShowInfo)localObject1).jxR;
          if (localObject1 != null) {
            break label2160;
          }
        }
        localObject1 = "";
      }
      label1714:
      label1720:
      label1774:
      label2160:
      for (;;)
      {
        localObject2 = paramSubscribeMsgRequestResult.jyr;
        if (localObject2 != null)
        {
          localObject2 = ((ShowInfo)localObject2).jxS;
          if (localObject2 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        for (;;)
        {
          a(paramContext, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)new b(this, paramSubscribeMsgRequestResult, paramInt));
          AppMethodBeat.o(223306);
          return;
          if (i == 2)
          {
            E(3, l);
            paramContext = paramSubscribeMsgRequestResult.jyr;
            if (paramContext != null)
            {
              paramContext = paramContext.jxS;
              if (paramContext != null) {
                break label2154;
              }
            }
            paramContext = "";
          }
          for (;;)
          {
            g(paramContext, (kotlin.g.a.a)new c(this, paramSubscribeMsgRequestResult, paramInt));
            AppMethodBeat.o(223306);
            return;
            if (i == 4)
            {
              E(5, l);
              paramContext = paramSubscribeMsgRequestResult.jyr;
              if (paramContext != null)
              {
                paramContext = paramContext.jxS;
                if (paramContext != null) {
                  break label2151;
                }
              }
              paramContext = "";
            }
            for (;;)
            {
              g(paramContext, (kotlin.g.a.a)new d(this, paramSubscribeMsgRequestResult, paramInt));
              AppMethodBeat.o(223306);
              return;
              if (i == 3)
              {
                E(4, l);
                localObject3 = (kotlin.g.a.a)new e(this, paramSubscribeMsgRequestResult, paramInt);
                localObject1 = paramSubscribeMsgRequestResult.jyr;
                if (localObject1 != null)
                {
                  localObject1 = ((ShowInfo)localObject1).jxS;
                  localObject2 = paramSubscribeMsgRequestResult.jyr;
                  if (localObject2 == null) {
                    break label1714;
                  }
                }
                for (localObject2 = ((ShowInfo)localObject2).jxR;; localObject2 = null)
                {
                  this.jzT = h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(2131766574), paramContext.getString(2131755761), false, (DialogInterface.OnClickListener)new l(this, (kotlin.g.a.a)localObject3, paramContext, paramSubscribeMsgRequestResult), (DialogInterface.OnClickListener)new a.b.m((kotlin.g.a.a)localObject3));
                  paramContext = this.jzT;
                  if (paramContext == null) {
                    break label1720;
                  }
                  paramContext.setCanceledOnTouchOutside(false);
                  AppMethodBeat.o(223306);
                  return;
                  localObject1 = null;
                  break;
                }
                AppMethodBeat.o(223306);
                return;
              }
              E(-1, l);
              paramContext = paramContext.getString(2131766576);
              p.g(paramContext, "context.getString(R.stri…ubscribe_msg_common_fail)");
              g(paramContext, (kotlin.g.a.a)new f(this, paramSubscribeMsgRequestResult, paramInt));
              AppMethodBeat.o(223306);
              return;
              if (a.up(paramInt))
              {
                if (i == 4)
                {
                  E(5, l);
                  paramContext = paramSubscribeMsgRequestResult.jyr;
                  if (paramContext != null)
                  {
                    localObject1 = paramContext.jxS;
                    paramContext = (Context)localObject1;
                    if (localObject1 != null) {}
                  }
                  else
                  {
                    paramContext = "";
                  }
                  paramSubscribeMsgRequestResult = (kotlin.g.a.a)new g(this, paramSubscribeMsgRequestResult, paramInt);
                  if (((CharSequence)paramContext).length() > 0) {}
                  for (paramInt = 1;; paramInt = 0)
                  {
                    if (paramInt != 0) {
                      u.cG(this.context, paramContext);
                    }
                    paramSubscribeMsgRequestResult.invoke();
                    AppMethodBeat.o(223306);
                    return;
                  }
                }
                if (i == 1)
                {
                  E(2, l);
                  localObject1 = paramSubscribeMsgRequestResult.jyr;
                  if (localObject1 != null)
                  {
                    localObject1 = ((ShowInfo)localObject1).jxR;
                    if (localObject1 != null) {
                      break label2148;
                    }
                  }
                  localObject1 = "";
                }
              }
              for (;;)
              {
                localObject2 = paramSubscribeMsgRequestResult.jyr;
                if (localObject2 != null)
                {
                  localObject2 = ((ShowInfo)localObject2).jxS;
                  if (localObject2 != null) {}
                }
                else
                {
                  localObject2 = "";
                }
                for (;;)
                {
                  a(paramContext, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)new h(this, paramSubscribeMsgRequestResult, paramInt));
                  AppMethodBeat.o(223306);
                  return;
                  if (i == 2)
                  {
                    E(3, l);
                    paramContext = paramSubscribeMsgRequestResult.jyr;
                    if (paramContext != null)
                    {
                      paramContext = paramContext.jxS;
                      if (paramContext != null) {
                        break label2142;
                      }
                    }
                    paramContext = "";
                  }
                  for (;;)
                  {
                    g(paramContext, (kotlin.g.a.a)new i(this, paramSubscribeMsgRequestResult, paramInt));
                    AppMethodBeat.o(223306);
                    return;
                    if (i == 0) {
                      i = 1;
                    }
                    for (;;)
                    {
                      E(i, l);
                      if (paramSubscribeMsgRequestResult.jyu != 0) {
                        break label2104;
                      }
                      paramContext = this.jzZ;
                      if (paramContext == null) {
                        break;
                      }
                      paramContext.b(paramSubscribeMsgRequestResult);
                      AppMethodBeat.o(223306);
                      return;
                      if (i == 3) {
                        i = 4;
                      } else {
                        i = -1;
                      }
                    }
                    AppMethodBeat.o(223306);
                    return;
                    paramContext = this.jzZ;
                    if (paramContext != null)
                    {
                      paramContext.i(paramInt, paramSubscribeMsgRequestResult.jyu, paramSubscribeMsgRequestResult.jyv);
                      AppMethodBeat.o(223306);
                      return;
                    }
                    AppMethodBeat.o(223306);
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    
    private static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(223307);
      int i;
      if (((CharSequence)paramString2).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label58;
        }
      }
      for (;;)
      {
        h.a(paramContext, paramString2, paramString1, paramContext.getResources().getString(2131755874), false, paramOnClickListener);
        AppMethodBeat.o(223307);
        return;
        i = 0;
        break;
        label58:
        paramString2 = paramContext.getString(2131766575);
        p.g(paramString2, "context.getString(R.stri…sg_alert_default_content)");
      }
    }
    
    private final void biX()
    {
      AppMethodBeat.i(223309);
      this.jzX.Rx(this.dVu);
      this.jzX.Ry(this.jzY);
      try
      {
        if (((CharSequence)this.extInfo).length() > 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          Object localObject = new JSONObject(this.extInfo);
          com.tencent.mm.msgsubscription.c.a.a locala = this.jzX;
          localObject = ((JSONObject)localObject).optString("sessionid");
          p.g(localObject, "data.optString(\"sessionid\")");
          locala.setSessionId((String)localObject);
          AppMethodBeat.o(223309);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(223309);
      }
    }
    
    private final void g(String paramString, kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(223308);
      if (((CharSequence)paramString).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          Toast.makeText(this.context, (CharSequence)paramString, 0).show();
        }
        parama.invoke();
        AppMethodBeat.o(223308);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(223305);
      switch (this.action)
      {
      }
      Object localObject1;
      label178:
      Object localObject2;
      label315:
      label320:
      do
      {
        AppMethodBeat.o(223305);
        return;
        int i;
        if (((CharSequence)this.jzp).length() == 0) {
          i = 1;
        }
        while ((i != 0) && (this.jzS.isEmpty()))
        {
          localObject1 = this.jzZ;
          if (localObject1 != null)
          {
            ((a.a)localObject1).i(this.action, 10001, "templateIdList empty");
            AppMethodBeat.o(223305);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(223305);
            return;
          }
        }
        if (((CharSequence)this.extInfo).length() > 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = new JSONObject(this.extInfo).optString("username");
            p.g(localObject1, "username");
            if (((CharSequence)localObject1).length() <= 0) {
              break label315;
            }
            i = 1;
            if (i != 0) {
              this.dVu = ((String)localObject1);
            }
          }
          Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList bizUsername: %s, bizAppId: %s, url: %s, templateIdList size: %s", new Object[] { this.dVu, this.jzY, this.jzp, Integer.valueOf(this.jzS.size()) });
          biX();
          localObject1 = new k(this);
          if (((CharSequence)this.dVu).length() <= 0) {
            break label320;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            localObject2 = this.jzW;
            if (localObject2 != null)
            {
              ((com.tencent.mm.msgsubscription.b.a)localObject2).a(this.dVu, this.jzp, (List)this.jzS, this.extInfo, (com.tencent.mm.msgsubscription.api.a)localObject1);
              AppMethodBeat.o(223305);
              return;
              i = 0;
              break;
              i = 0;
              break label178;
              i = 0;
              continue;
            }
            AppMethodBeat.o(223305);
            return;
          }
        }
        if (((CharSequence)this.jzY).length() > 0) {
          i = 1;
        }
        while (i != 0)
        {
          localObject2 = this.jzW;
          if (localObject2 != null)
          {
            ((com.tencent.mm.msgsubscription.b.a)localObject2).b(this.jzY, this.jzp, (List)this.jzS, this.extInfo, (com.tencent.mm.msgsubscription.api.a)localObject1);
            AppMethodBeat.o(223305);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(223305);
            return;
          }
        }
        localObject1 = this.jzZ;
        if (localObject1 != null)
        {
          ((a.a)localObject1).i(this.action, -1, "username or appId invalid");
          AppMethodBeat.o(223305);
          return;
        }
        AppMethodBeat.o(223305);
        return;
        localObject1 = this.dVu;
        localObject2 = this.jzY;
        ArrayList localArrayList = this.jzR;
        if (localArrayList == null) {
          p.hyc();
        }
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg bizUsername: %s, appId: %s, template size: %s", new Object[] { localObject1, localObject2, Integer.valueOf(localArrayList.size()) });
        localObject1 = new c();
        ((c)localObject1).jzd = true;
        ((c)localObject1).setUsername(this.dVu);
        ((c)localObject1).setAppId(this.jzY);
        localObject2 = ((c)localObject1).jyV;
        localArrayList = this.jzR;
        if (localArrayList == null) {
          p.hyc();
        }
        ((List)localObject2).addAll((Collection)localArrayList);
        ((c)localObject1).jzb = true;
        ((c)localObject1).setBuffer(this.buffer);
        ((c)localObject1).jzc = this.jzc;
        ((c)localObject1).Rv(this.extInfo);
        ((c)localObject1).jze = ((com.tencent.mm.msgsubscription.api.a)new j(this));
        localObject2 = this.jzW;
      } while (localObject2 == null);
      ((com.tencent.mm.msgsubscription.b.a)localObject2).a((c)localObject1);
      AppMethodBeat.o(223305);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(223287);
        if (paramSubscribeMsgRequestResult.jyu == 0)
        {
          paramDialogInterface = a.b.d(this.jAb);
          if (paramDialogInterface != null)
          {
            paramDialogInterface.a(false, paramSubscribeMsgRequestResult);
            AppMethodBeat.o(223287);
            return;
          }
          AppMethodBeat.o(223287);
          return;
        }
        paramDialogInterface = a.b.d(this.jAb);
        if (paramDialogInterface != null)
        {
          paramDialogInterface.i(paramInt, paramSubscribeMsgRequestResult.jyu, paramSubscribeMsgRequestResult.jyv);
          AppMethodBeat.o(223287);
          return;
        }
        AppMethodBeat.o(223287);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<x>
    {
      e(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class f
      extends q
      implements kotlin.g.a.a<x>
    {
      f(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class g
      extends q
      implements kotlin.g.a.a<x>
    {
      g(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class h
      implements DialogInterface.OnClickListener
    {
      h(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(223293);
        if (paramSubscribeMsgRequestResult.jyu == 0)
        {
          paramDialogInterface = a.b.d(this.jAb);
          if (paramDialogInterface != null)
          {
            paramDialogInterface.b(paramSubscribeMsgRequestResult);
            AppMethodBeat.o(223293);
            return;
          }
          AppMethodBeat.o(223293);
          return;
        }
        paramDialogInterface = a.b.d(this.jAb);
        if (paramDialogInterface != null)
        {
          paramDialogInterface.i(paramInt, paramSubscribeMsgRequestResult.jyu, paramSubscribeMsgRequestResult.jyv);
          AppMethodBeat.o(223293);
          return;
        }
        AppMethodBeat.o(223293);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class i
      extends q
      implements kotlin.g.a.a<x>
    {
      i(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class j
      implements com.tencent.mm.msgsubscription.api.a
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(223295);
        p.h(paramString, "bizUsername");
        p.h(paramSubscribeMsgRequestResult, "result");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg success bizUsername: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.jyk.size()) });
        a.b.a(this.jAb, a.b.e(this.jAb), a.b.c(this.jAb), paramSubscribeMsgRequestResult);
        AppMethodBeat.o(223295);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(223296);
        p.h(paramString, "errMsg");
        Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        a.a locala = a.b.d(this.jAb);
        if (locala != null)
        {
          paramInt2 = a.b.c(this.jAb);
          if (((CharSequence)paramString).length() > 0)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label103;
            }
          }
          for (;;)
          {
            locala.i(paramInt2, 10003, paramString);
            AppMethodBeat.o(223296);
            return;
            paramInt1 = 0;
            break;
            label103:
            paramString = "subscribe failed";
          }
        }
        AppMethodBeat.o(223296);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class k
      implements com.tencent.mm.msgsubscription.api.a
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(223297);
        p.h(paramString, "bizUsername");
        p.h(paramSubscribeMsgRequestResult, "result");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onSuccess bizUsername: %s, size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.jyk.size()) });
        a.b.a(this.jAb, a.b.c(this.jAb), paramSubscribeMsgRequestResult);
        AppMethodBeat.o(223297);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(223298);
        p.h(paramString, "errMsg");
        Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        a.a locala = a.b.d(this.jAb);
        if (locala != null)
        {
          paramInt2 = a.b.c(this.jAb);
          if (((CharSequence)paramString).length() > 0)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label103;
            }
          }
          for (;;)
          {
            locala.i(paramInt2, 10002, paramString);
            AppMethodBeat.o(223298);
            return;
            paramInt1 = 0;
            break;
            label103:
            paramString = "get subscribe msg list failed";
          }
        }
        AppMethodBeat.o(223298);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class l
      implements DialogInterface.OnClickListener
    {
      l(a.b paramb, kotlin.g.a.a parama, Context paramContext, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(223299);
        paramDialogInterface = a.b.f(this.jAb);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        this.ihE.invoke();
        paramDialogInterface = com.tencent.mm.msgsubscription.api.b.jza;
        paramDialogInterface = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(paramContext, 3, a.b.g(this.jAb), paramSubscribeMsgRequestResult.appName);
          AppMethodBeat.o(223299);
          return;
        }
        AppMethodBeat.o(223299);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "isCancelable", "", "plugin-comm_release"})
    public static final class n
      extends com.tencent.mm.msgsubscription.ui.b
    {
      n(Context paramContext1, List paramList1, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, boolean paramBoolean1, Context paramContext2, List paramList2, b.d paramd, boolean paramBoolean2)
      {
        super(paramd, paramBoolean2, bool);
      }
      
      public final boolean isCancelable()
      {
        return true;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$3", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "plugin-comm_release"})
    public static final class o
      implements b.d
    {
      o(SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void c(int paramInt, List<b.b> paramList)
      {
        int j = 0;
        AppMethodBeat.i(223301);
        p.h(paramList, "resultData");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog onEvent: %s, result size: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(223301);
          return;
        }
        a.b.e(paramList, (List)paramSubscribeMsgRequestResult.jyk);
        this.jAb.jzR = paramSubscribeMsgRequestResult.jyk;
        a.b.a(this.jAb, a.un(a.b.c(this.jAb)));
        a.b.a(this.jAb, paramSubscribeMsgRequestResult.buffer);
        Object localObject1 = this.jAb;
        Object localObject2 = SubscribeMsgRequestDialogUiData.jyc;
        paramList = j.v((Collection)paramList);
        localObject2 = a.b.h(this.jAb);
        boolean bool;
        label181:
        int i;
        if (localObject2 != null)
        {
          bool = ((com.tencent.mm.msgsubscription.ui.b)localObject2).jCa.isChecked();
          a.b.a((a.b)localObject1, SubscribeMsgRequestDialogUiData.a.a(paramInt, paramList, bool));
          paramList = a.jzQ;
          a.b(this.jAb);
          if (paramSubscribeMsgRequestResult.jyl) {
            break label316;
          }
          paramList = a.b.i(this.jAb);
          localObject1 = a.b.h(this.jAb);
          if ((localObject1 == null) || (((com.tencent.mm.msgsubscription.ui.b)localObject1).jCa.isChecked() != true)) {
            break label311;
          }
          i = 1;
          label250:
          paramList.jAt = i;
          switch (paramInt)
          {
          default: 
            label255:
            paramInt = j;
          }
        }
        for (;;)
        {
          paramList = com.tencent.mm.msgsubscription.c.a.jAr;
          com.tencent.mm.msgsubscription.c.a.a(paramInt, a.b.i(this.jAb));
          break;
          bool = false;
          break label181;
          label311:
          i = 0;
          break label250;
          label316:
          a.b.i(this.jAb).jAt = 2;
          break label255;
          paramInt = 2;
          continue;
          paramInt = 3;
          continue;
          paramInt = 4;
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$4", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "onDismiss", "", "onShow", "plugin-comm_release"})
    public static final class p
      implements b.e
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(223303);
        a.a locala = a.b.d(this.jAb);
        if (locala != null)
        {
          locala.biV();
          AppMethodBeat.o(223303);
          return;
        }
        AppMethodBeat.o(223303);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(223302);
        Object localObject = a.b.d(this.jAb);
        if (localObject != null) {
          ((a.a)localObject).a((k)a.b.h(this.jAb), a.b.j(this.jAb));
        }
        localObject = com.tencent.mm.msgsubscription.c.a.jAr;
        com.tencent.mm.msgsubscription.c.a.a(1, a.b.i(this.jAb));
        AppMethodBeat.o(223302);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$5", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", "index", "", "plugin-comm_release"})
    public static final class q
      implements b.a.a
    {
      public final void aC(String paramString, int paramInt)
      {
        AppMethodBeat.i(223304);
        p.h(paramString, "templateId");
        paramString = com.tencent.mm.msgsubscription.c.a.jAr;
        com.tencent.mm.msgsubscription.c.a.ur(paramInt);
        paramString = com.tencent.mm.msgsubscription.c.a.jAr;
        com.tencent.mm.msgsubscription.c.a.a(5, a.b.i(this.jAb));
        AppMethodBeat.o(223304);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.a
 * JD-Core Version:    0.7.0.1
 */