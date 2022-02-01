package com.tencent.mm.msgsubscription.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ShowInfo;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.a;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.api.b;
import com.tencent.mm.msgsubscription.api.c;
import com.tencent.mm.msgsubscription.ui.f;
import com.tencent.mm.msgsubscription.ui.f.a.a;
import com.tencent.mm.msgsubscription.ui.f.c;
import com.tencent.mm.msgsubscription.ui.f.g;
import com.tencent.mm.msgsubscription.ui.f.g.a.a;
import com.tencent.mm.msgsubscription.ui.f.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController;", "Lcom/tencent/mm/msgsubscription/model/biz_service/IBrandSubscribeMsgRequestController;", "()V", "TAG", "", "actionMachine", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSubscribeMsgList", "", "requestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "isGetAction", "", "action", "isSubscribeAction", "nextAction", "subscribeMsgList", "SubscribeMsgRequestCallback", "SubscribeMsgRequestTask", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a pji;
  private static HashMap<Integer, Integer> pjj;
  
  static
  {
    AppMethodBeat.i(236417);
    pji = new a();
    pjj = ak.g(new r[] { v.Y(Integer.valueOf(1), Integer.valueOf(0)), v.Y(Integer.valueOf(3), Integer.valueOf(2)), v.Y(Integer.valueOf(2), Integer.valueOf(0)) });
    AppMethodBeat.o(236417);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(236401);
    s.u(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(236401);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(236407);
    s.u(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(236407);
  }
  
  public static final int xn(int paramInt)
  {
    AppMethodBeat.i(236384);
    Integer localInteger = (Integer)pjj.get(Integer.valueOf(paramInt));
    if (localInteger == null)
    {
      AppMethodBeat.o(236384);
      return -1;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(236384);
    return paramInt;
  }
  
  public static final boolean xo(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 1);
  }
  
  public static final boolean xp(int paramInt)
  {
    return paramInt == 2;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(n paramn, g paramg);
    
    public abstract void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void bPZ();
    
    public abstract void bQa();
    
    public abstract void j(int paramInt1, int paramInt2, String paramString);
    
    public abstract void onCancel();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "", "context", "Landroid/content/Context;", "action", "", "bizAppId", "", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "extInfo", "requestCallback", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "(Landroid/content/Context;ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "bizUsername", "subscribeUrl", "content", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "buffer", "", "mAlertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "mBizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "mDialogContainerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mFromScene", "mSubscribeMsgDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "mSubscribeReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getSubscribeMsgTmpItems", "()Ljava/util/ArrayList;", "setSubscribeMsgTmpItems", "(Ljava/util/ArrayList;)V", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "applyUserAction", "", "event", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "dispatchSuccessResult", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "initReportInfo", "onGetSubscribeMsgListSuccess", "release", "reportSubscribeAuth", "showType", "timestamp", "", "run", "setFromScene", "fromScene", "showAlertDialog", "title", "okOnClickListener", "Landroid/content/DialogInterface$OnClickListener;", "showSettingPageAlert", "callback", "Lkotlin/Function0;", "showSubscribeRequestDialog", "showSuccessToast", "msg", "showToast", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final a.b.a pjk;
    private int action;
    private byte[] buffer;
    private final String content;
    private final Context context;
    private final String extInfo;
    private String hUQ;
    public int lCR;
    private final String piK;
    private SubscribeMsgRequestDialogUiData piz;
    private final String pjl;
    private final a.a pjm;
    ArrayList<SubscribeMsgTmpItem> pjn;
    private ArrayList<String> pjo;
    public e pjp;
    public f pjq;
    private g pjr;
    private com.tencent.mm.msgsubscription.b.a pjs;
    private com.tencent.mm.msgsubscription.c.a.a pjt;
    
    static
    {
      AppMethodBeat.i(236515);
      pjk = new a.b.a((byte)0);
      AppMethodBeat.o(236515);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a.a parama)
    {
      AppMethodBeat.i(236361);
      this.context = paramContext;
      this.action = paramInt;
      this.hUQ = paramString1;
      this.pjl = paramString2;
      this.piK = paramString3;
      this.content = paramString4;
      this.extInfo = paramString5;
      this.pjm = parama;
      this.pjo = new ArrayList();
      paramContext = b.piw;
      this.pjs = b.QW("name_biz");
      this.buffer = new byte[] { 0 };
      this.pjt = new com.tencent.mm.msgsubscription.c.a.a();
      AppMethodBeat.o(236361);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, ArrayList<String> paramArrayList, String paramString2, a.a parama)
    {
      this(paramContext, paramInt, "", paramString1, "", "", paramString2, parama);
      AppMethodBeat.i(236372);
      this.pjo.clear();
      this.pjo.addAll((Collection)paramArrayList);
      Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo initSubscribeMsgRequestTask templateId size: %s", new Object[] { Integer.valueOf(this.pjo.size()) });
      AppMethodBeat.o(236372);
    }
    
    private final void H(int paramInt, long paramLong)
    {
      AppMethodBeat.i(236433);
      if (this.lCR == 1)
      {
        com.tencent.mm.msgsubscription.c.a locala = com.tencent.mm.msgsubscription.c.a.pjH;
        com.tencent.mm.msgsubscription.c.a.a(this.hUQ, paramInt, this.content, paramLong);
      }
      AppMethodBeat.o(236433);
    }
    
    private final void a(Context paramContext, final int paramInt, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(236402);
      Object localObject1 = paramSubscribeMsgRequestResult.phJ;
      if (localObject1 == null) {}
      long l;
      for (int i = -1;; i = ((ShowInfo)localObject1).hAN)
      {
        localObject1 = this.pjm;
        if (localObject1 != null) {
          ((a.a)localObject1).bQa();
        }
        l = System.currentTimeMillis() / 1000L;
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo dispatchSuccessResult showType: %s, action: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(paramSubscribeMsgRequestResult.phM), paramSubscribeMsgRequestResult.phN });
        if (!a.xo(paramInt)) {
          break;
        }
        switch (i)
        {
        default: 
          H(-1, l);
          paramContext = paramContext.getString(c.h.subscribe_msg_common_fail);
          s.s(paramContext, "context.getString(R.stri…ubscribe_msg_common_fail)");
          l(paramContext, (kotlin.g.a.a)new e(paramSubscribeMsgRequestResult, this, paramInt));
          AppMethodBeat.o(236402);
          return;
        }
      }
      Object localObject3;
      Object localObject2;
      if (paramSubscribeMsgRequestResult.phM == 0)
      {
        H(1, l);
        final boolean bool;
        if (paramSubscribeMsgRequestResult.phC.isEmpty())
        {
          Log.w("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog list is empty and not show dialog");
          paramContext = this.pjm;
          if (paramContext != null) {
            paramContext.j(this.action, 10002, "template list empty");
          }
          bool = false;
          paramContext = this.pjm;
          if (paramContext != null)
          {
            paramContext.a(bool, paramSubscribeMsgRequestResult);
            AppMethodBeat.o(236402);
          }
        }
        else
        {
          localObject3 = (List)new ArrayList();
          localObject1 = ((Iterable)paramSubscribeMsgRequestResult.phC).iterator();
          label369:
          Object localObject4;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SubscribeMsgTmpItem)((Iterator)localObject1).next();
            Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog templateId: %s, chooseStatus: %d", new Object[] { ((SubscribeMsgTmpItem)localObject2).nSg, Integer.valueOf(((SubscribeMsgTmpItem)localObject2).pht) });
            if (((SubscribeMsgTmpItem)localObject2).pht == 1)
            {
              bool = true;
              ((List)localObject3).add(new f.c(bool, ((SubscribeMsgTmpItem)localObject2).title, ((SubscribeMsgTmpItem)localObject2).phS, ((SubscribeMsgTmpItem)localObject2).nSg));
              this.pjt.pjo.add(((SubscribeMsgTmpItem)localObject2).nSg);
              localObject4 = this.pjt.pjM;
              if (((SubscribeMsgTmpItem)localObject2).pht != 0) {
                break label455;
              }
            }
            label455:
            for (paramInt = 0;; paramInt = 1)
            {
              ((ArrayList)localObject4).add(Integer.valueOf(paramInt));
              break;
              bool = false;
              break label369;
            }
          }
          localObject1 = (SubscribeMsgTmpItem)p.oL((List)paramSubscribeMsgRequestResult.phC);
          if (localObject1 == null)
          {
            paramInt = 2;
            label482:
            if ((((List)localObject3).size() != 1) || (paramSubscribeMsgRequestResult.phI != 1)) {
              break label1235;
            }
            bool = true;
            label504:
            Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog size: %d, showStyle: %d, singleMode: %b, templateType: %d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(paramSubscribeMsgRequestResult.phI), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
            this.pjq = ((f)new j(paramContext, (List)localObject3, bool, new k(this, paramSubscribeMsgRequestResult)));
            localObject1 = this.pjq;
            if (localObject1 != null) {
              ((f)localObject1).plT = ((f.h)new l(this));
            }
            localObject4 = this.pjq;
            if (localObject4 != null)
            {
              localObject2 = paramSubscribeMsgRequestResult.phK;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              ((f)localObject4).setDesc((String)localObject1);
            }
            localObject4 = this.pjq;
            if (localObject4 != null)
            {
              localObject2 = paramSubscribeMsgRequestResult.phL;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              ((f)localObject4).Rn((String)localObject1);
            }
            if (bool) {
              ((f.c)p.oK((List)localObject3)).plZ = true;
            }
            localObject1 = this.pjq;
            if (localObject1 != null) {
              ((f)localObject1).Rg(paramSubscribeMsgRequestResult.appName);
            }
            localObject1 = this.pjq;
            if (localObject1 != null) {
              ((f)localObject1).setIconUrl(paramSubscribeMsgRequestResult.phA);
            }
            localObject1 = this.pjq;
            if (localObject1 != null)
            {
              localObject2 = paramSubscribeMsgRequestResult.phF;
              s.checkNotNull(localObject2);
              ((f)localObject1).Rk(((WordingInfo)localObject2).pie);
            }
            localObject1 = this.pjq;
            if (localObject1 != null)
            {
              localObject2 = paramSubscribeMsgRequestResult.phF;
              s.checkNotNull(localObject2);
              ((f)localObject1).Rl(((WordingInfo)localObject2).pif);
            }
            localObject1 = this.pjq;
            if (localObject1 != null)
            {
              localObject2 = paramSubscribeMsgRequestResult.phF;
              s.checkNotNull(localObject2);
              ((f)localObject1).Rm(((WordingInfo)localObject2).pig);
            }
            localObject1 = this.pjq;
            if (localObject1 != null) {
              ((f)localObject1).plS = c.d.default_avatar;
            }
            localObject4 = this.pjq;
            if (localObject4 != null)
            {
              localObject1 = paramSubscribeMsgRequestResult.phF;
              s.checkNotNull(localObject1);
              localObject2 = ((WordingInfo)localObject1).pii;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              ((f)localObject4).Rh((String)localObject1);
            }
            localObject1 = this.pjq;
            if (localObject1 != null)
            {
              if (paramSubscribeMsgRequestResult.phD) {
                break label1241;
              }
              bool = true;
              label925:
              ((f)localObject1).plL = bool;
              localObject2 = ((f)localObject1).plz;
              if (!((f)localObject1).plL) {
                break label1247;
              }
              paramInt = 0;
              label949:
              ((View)localObject2).setVisibility(paramInt);
            }
            localObject1 = this.pjq;
            if (localObject1 != null)
            {
              if (paramSubscribeMsgRequestResult.phE) {
                break label1253;
              }
              bool = true;
              label976:
              ((f)localObject1).hz(bool);
            }
            localObject1 = this.pjq;
            if ((localObject1 == null) || (((f)localObject1).plL != true)) {
              break label1259;
            }
            paramInt = 1;
            label1005:
            if (paramInt == 0) {
              break label1264;
            }
            localObject1 = this.pjq;
            if (localObject1 != null)
            {
              localObject2 = paramSubscribeMsgRequestResult.phF;
              s.checkNotNull(localObject2);
              ((f)localObject1).Ri(((WordingInfo)localObject2).pih);
            }
            localObject1 = this.pjq;
            if (localObject1 != null) {
              break label1330;
            }
            localObject1 = null;
            label1055:
            localObject2 = this.pjq;
            if (localObject2 != null) {
              break label1343;
            }
          }
          label1330:
          label1343:
          for (localObject2 = null;; localObject2 = Boolean.valueOf(((f)localObject2).plN))
          {
            Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeMsgRequestDialog showAlways: %s, showReject: %s", new Object[] { localObject1, localObject2 });
            localObject1 = this.pjq;
            if (localObject1 != null) {
              ((f)localObject1).plI = ((f.a.a)new m(this));
            }
            if (this.pjr == null)
            {
              this.pjr = new g(paramContext);
              if ((paramContext instanceof Activity))
              {
                localObject1 = new ViewGroup.LayoutParams(-1, -2);
                ((Activity)paramContext).addContentView((View)this.pjr, (ViewGroup.LayoutParams)localObject1);
              }
            }
            paramContext = this.pjq;
            if (paramContext != null) {
              paramContext.setPosition(2);
            }
            paramContext = this.pjr;
            if (paramContext != null) {
              paramContext.b((n)this.pjq);
            }
            paramContext = com.tencent.mm.msgsubscription.c.a.pjH;
            com.tencent.mm.msgsubscription.c.a.xr(((List)localObject3).size());
            bool = true;
            break;
            paramInt = ((SubscribeMsgTmpItem)localObject1).phR;
            break label482;
            label1235:
            bool = false;
            break label504;
            label1241:
            bool = false;
            break label925;
            label1247:
            paramInt = 8;
            break label949;
            label1253:
            bool = false;
            break label976;
            label1259:
            paramInt = 0;
            break label1005;
            label1264:
            localObject1 = this.pjq;
            if ((localObject1 != null) && (((f)localObject1).plN == true)) {}
            for (paramInt = 1; paramInt != 0; paramInt = 0)
            {
              localObject1 = this.pjq;
              if (localObject1 == null) {
                break;
              }
              localObject2 = paramSubscribeMsgRequestResult.phF;
              s.checkNotNull(localObject2);
              ((f)localObject1).Rj(((WordingInfo)localObject2).pij);
              break;
            }
            localObject1 = Boolean.valueOf(((f)localObject1).plL);
            break label1055;
          }
        }
      }
      else
      {
        paramContext = this.pjm;
        if (paramContext != null)
        {
          paramContext.j(paramInt, paramSubscribeMsgRequestResult.phM, paramSubscribeMsgRequestResult.phN);
          AppMethodBeat.o(236402);
          return;
          H(2, l);
          localObject1 = paramSubscribeMsgRequestResult.phJ;
          if (localObject1 == null)
          {
            localObject1 = "";
            localObject2 = paramSubscribeMsgRequestResult.phJ;
            if (localObject2 != null) {
              break label1472;
            }
            localObject2 = "";
          }
          for (;;)
          {
            a(paramContext, (String)localObject1, (String)localObject2, new a.b..ExternalSyntheticLambda1(paramSubscribeMsgRequestResult, this, paramInt));
            AppMethodBeat.o(236402);
            return;
            localObject2 = ((ShowInfo)localObject1).phh;
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
            localObject1 = "";
            break;
            label1472:
            localObject3 = ((ShowInfo)localObject2).phi;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
          }
          H(3, l);
          paramContext = paramSubscribeMsgRequestResult.phJ;
          if (paramContext == null) {
            paramContext = "";
          }
          for (;;)
          {
            l(paramContext, (kotlin.g.a.a)new b(paramSubscribeMsgRequestResult, this, paramInt));
            AppMethodBeat.o(236402);
            return;
            paramContext = paramContext.phi;
            if (paramContext == null) {
              paramContext = "";
            }
          }
          H(5, l);
          paramContext = paramSubscribeMsgRequestResult.phJ;
          if (paramContext == null) {
            paramContext = "";
          }
          for (;;)
          {
            l(paramContext, (kotlin.g.a.a)new c(paramSubscribeMsgRequestResult, this, paramInt));
            AppMethodBeat.o(236402);
            return;
            paramContext = paramContext.phi;
            if (paramContext == null) {
              paramContext = "";
            }
          }
          H(4, l);
          localObject3 = (kotlin.g.a.a)new d(paramSubscribeMsgRequestResult, this, paramInt);
          localObject1 = paramSubscribeMsgRequestResult.phJ;
          if (localObject1 == null)
          {
            localObject1 = null;
            localObject2 = paramSubscribeMsgRequestResult.phJ;
            if (localObject2 != null) {
              break label1748;
            }
          }
          label1748:
          for (localObject2 = null;; localObject2 = ((ShowInfo)localObject2).phh)
          {
            this.pjp = k.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(c.h.subscribe_msg_alert_action_go_to_setting_page), paramContext.getString(c.h.app_cancel), false, new a.b..ExternalSyntheticLambda2(this, (kotlin.g.a.a)localObject3, paramContext, paramSubscribeMsgRequestResult), new a.b..ExternalSyntheticLambda3((kotlin.g.a.a)localObject3));
            paramContext = this.pjp;
            if (paramContext != null) {
              paramContext.setCanceledOnTouchOutside(false);
            }
            AppMethodBeat.o(236402);
            return;
            localObject1 = ((ShowInfo)localObject1).phi;
            break;
          }
          if (a.xp(paramInt))
          {
            switch (i)
            {
            case 3: 
            default: 
              switch (i)
              {
              case 1: 
              case 2: 
              default: 
                i = -1;
              }
              break;
            }
            for (;;)
            {
              H(i, l);
              if (paramSubscribeMsgRequestResult.phM != 0) {
                break;
              }
              paramContext = this.pjm;
              if (paramContext == null) {
                break label2173;
              }
              paramContext.b(paramSubscribeMsgRequestResult);
              AppMethodBeat.o(236402);
              return;
              H(5, l);
              paramContext = paramSubscribeMsgRequestResult.phJ;
              if (paramContext == null)
              {
                paramContext = "";
                paramSubscribeMsgRequestResult = (kotlin.g.a.a)new f(paramSubscribeMsgRequestResult, this, paramInt);
                if (((CharSequence)paramContext).length() <= 0) {
                  break label1962;
                }
              }
              label1962:
              for (paramInt = 1;; paramInt = 0)
              {
                if (paramInt != 0) {
                  aa.db(this.context, paramContext);
                }
                paramSubscribeMsgRequestResult.invoke();
                AppMethodBeat.o(236402);
                return;
                localObject1 = paramContext.phi;
                paramContext = (Context)localObject1;
                if (localObject1 != null) {
                  break;
                }
                paramContext = "";
                break;
              }
              H(2, l);
              localObject1 = paramSubscribeMsgRequestResult.phJ;
              if (localObject1 == null)
              {
                localObject1 = "";
                localObject2 = paramSubscribeMsgRequestResult.phJ;
                if (localObject2 != null) {
                  break label2052;
                }
                localObject2 = "";
              }
              for (;;)
              {
                a(paramContext, (String)localObject1, (String)localObject2, new a.b..ExternalSyntheticLambda0(paramSubscribeMsgRequestResult, this, paramInt));
                AppMethodBeat.o(236402);
                return;
                localObject2 = ((ShowInfo)localObject1).phh;
                localObject1 = localObject2;
                if (localObject2 != null) {
                  break;
                }
                localObject1 = "";
                break;
                label2052:
                localObject3 = ((ShowInfo)localObject2).phi;
                localObject2 = localObject3;
                if (localObject3 == null) {
                  localObject2 = "";
                }
              }
              H(3, l);
              paramContext = paramSubscribeMsgRequestResult.phJ;
              if (paramContext == null) {
                paramContext = "";
              }
              for (;;)
              {
                l(paramContext, (kotlin.g.a.a)new g(paramSubscribeMsgRequestResult, this, paramInt));
                AppMethodBeat.o(236402);
                return;
                paramContext = paramContext.phi;
                if (paramContext == null) {
                  paramContext = "";
                }
              }
              i = 1;
              continue;
              i = 4;
            }
            paramContext = this.pjm;
            if (paramContext != null) {
              paramContext.j(paramInt, paramSubscribeMsgRequestResult.phM, paramSubscribeMsgRequestResult.phN);
            }
          }
        }
      }
      label2173:
      AppMethodBeat.o(236402);
    }
    
    private static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(236412);
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
        k.a(paramContext, paramString2, paramString1, paramContext.getResources().getString(c.h.app_i_known), false, paramOnClickListener);
        AppMethodBeat.o(236412);
        return;
        i = 0;
        break;
        label58:
        paramString2 = paramContext.getString(c.h.subscribe_msg_alert_default_content);
        s.s(paramString2, "{\n                contex…lt_content)\n            }");
      }
    }
    
    private static final void a(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, b paramb, int paramInt1, DialogInterface paramDialogInterface, int paramInt2)
    {
      AppMethodBeat.i(236438);
      s.u(paramSubscribeMsgRequestResult, "$result");
      s.u(paramb, "this$0");
      if (paramSubscribeMsgRequestResult.phM == 0)
      {
        paramb = paramb.pjm;
        if (paramb != null)
        {
          paramb.a(false, paramSubscribeMsgRequestResult);
          AppMethodBeat.o(236438);
        }
      }
      else
      {
        paramb = paramb.pjm;
        if (paramb != null) {
          paramb.j(paramInt1, paramSubscribeMsgRequestResult.phM, paramSubscribeMsgRequestResult.phN);
        }
      }
      AppMethodBeat.o(236438);
    }
    
    private static final void a(b paramb, kotlin.g.a.a parama, Context paramContext, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(236452);
      s.u(paramb, "this$0");
      s.u(parama, "$callback");
      s.u(paramContext, "$context");
      s.u(paramSubscribeMsgRequestResult, "$result");
      paramDialogInterface = paramb.pjp;
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      parama.invoke();
      parama = b.piw;
      parama = b.QW("name_biz");
      if (parama != null) {
        parama.a(paramContext, 3, paramb.hUQ, paramSubscribeMsgRequestResult.appName);
      }
      AppMethodBeat.o(236452);
    }
    
    private static final void a(kotlin.g.a.a parama, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(236461);
      s.u(parama, "$callback");
      parama.invoke();
      AppMethodBeat.o(236461);
    }
    
    private static final void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, b paramb, int paramInt1, DialogInterface paramDialogInterface, int paramInt2)
    {
      AppMethodBeat.i(236446);
      s.u(paramSubscribeMsgRequestResult, "$result");
      s.u(paramb, "this$0");
      if (paramSubscribeMsgRequestResult.phM == 0)
      {
        paramb = paramb.pjm;
        if (paramb != null)
        {
          paramb.b(paramSubscribeMsgRequestResult);
          AppMethodBeat.o(236446);
        }
      }
      else
      {
        paramb = paramb.pjm;
        if (paramb != null) {
          paramb.j(paramInt1, paramSubscribeMsgRequestResult.phM, paramSubscribeMsgRequestResult.phN);
        }
      }
      AppMethodBeat.o(236446);
    }
    
    private final void bQb()
    {
      AppMethodBeat.i(236427);
      this.pjt.QZ(this.hUQ);
      this.pjt.Ra(this.pjl);
      try
      {
        if (((CharSequence)this.extInfo).length() > 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          Object localObject = new JSONObject(this.extInfo);
          com.tencent.mm.msgsubscription.c.a.a locala = this.pjt;
          localObject = ((JSONObject)localObject).optString("sessionid");
          s.s(localObject, "data.optString(\"sessionid\")");
          locala.setSessionId((String)localObject);
          AppMethodBeat.o(236427);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(236427);
      }
    }
    
    private final void l(String paramString, kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(236419);
      if (((CharSequence)paramString).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          Toast.makeText(this.context, (CharSequence)paramString, 0).show();
        }
        parama.invoke();
        AppMethodBeat.o(236419);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(236543);
      switch (this.action)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(236543);
        return;
        if (((CharSequence)this.piK).length() == 0) {}
        for (int i = 1; (i != 0) && (this.pjo.isEmpty()); i = 0)
        {
          localObject1 = this.pjm;
          if (localObject1 != null) {
            ((a.a)localObject1).j(this.action, 10001, "templateIdList empty");
          }
          AppMethodBeat.o(236543);
          return;
        }
        if (((CharSequence)this.extInfo).length() > 0)
        {
          i = 1;
          label128:
          if (i != 0)
          {
            localObject1 = new JSONObject(this.extInfo).optString("username");
            s.s(localObject1, "username");
            if (((CharSequence)localObject1).length() <= 0) {
              break label308;
            }
            i = 1;
            label171:
            if (i != 0) {
              this.hUQ = ((String)localObject1);
            }
          }
          Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList bizUsername: %s, bizAppId: %s, url: %s, templateIdList size: %s", new Object[] { this.hUQ, this.pjl, this.piK, Integer.valueOf(this.pjo.size()) });
          bQb();
          localObject1 = new i(this);
          if (((CharSequence)this.hUQ).length() <= 0) {
            break label313;
          }
        }
        Object localObject2;
        label308:
        label313:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label318;
          }
          localObject2 = this.pjs;
          if (localObject2 == null) {
            break;
          }
          ((com.tencent.mm.msgsubscription.b.a)localObject2).a(this.hUQ, this.piK, (List)this.pjo, this.extInfo, (com.tencent.mm.msgsubscription.api.a)localObject1);
          AppMethodBeat.o(236543);
          return;
          i = 0;
          break label128;
          i = 0;
          break label171;
        }
        label318:
        if (((CharSequence)this.pjl).length() > 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label387;
          }
          localObject2 = this.pjs;
          if (localObject2 == null) {
            break;
          }
          ((com.tencent.mm.msgsubscription.b.a)localObject2).b(this.pjl, this.piK, (List)this.pjo, this.extInfo, (com.tencent.mm.msgsubscription.api.a)localObject1);
          AppMethodBeat.o(236543);
          return;
        }
        label387:
        Object localObject1 = this.pjm;
        if (localObject1 != null)
        {
          ((a.a)localObject1).j(this.action, -1, "username or appId invalid");
          AppMethodBeat.o(236543);
          return;
          localObject1 = this.hUQ;
          localObject2 = this.pjl;
          ArrayList localArrayList = this.pjn;
          s.checkNotNull(localArrayList);
          Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg bizUsername: %s, appId: %s, template size: %s", new Object[] { localObject1, localObject2, Integer.valueOf(localArrayList.size()) });
          localObject1 = new c();
          ((c)localObject1).piA = true;
          ((c)localObject1).setUsername(this.hUQ);
          ((c)localObject1).setAppId(this.pjl);
          localObject2 = ((c)localObject1).pis;
          localArrayList = this.pjn;
          s.checkNotNull(localArrayList);
          ((List)localObject2).addAll((Collection)localArrayList);
          ((c)localObject1).piy = true;
          ((c)localObject1).setBuffer(this.buffer);
          ((c)localObject1).piz = this.piz;
          ((c)localObject1).QX(this.extInfo);
          ((c)localObject1).piB = ((com.tencent.mm.msgsubscription.api.a)new h(this));
          localObject2 = this.pjs;
          if (localObject2 != null) {
            ((com.tencent.mm.msgsubscription.b.a)localObject2).a((c)localObject1);
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, a.b paramb, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, a.b paramb, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, a.b paramb, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends u
      implements kotlin.g.a.a<ah>
    {
      e(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, a.b paramb, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class f
      extends u
      implements kotlin.g.a.a<ah>
    {
      f(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, a.b paramb, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class g
      extends u
      implements kotlin.g.a.a<ah>
    {
      g(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, a.b paramb, int paramInt)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class h
      implements com.tencent.mm.msgsubscription.api.a
    {
      h(a.b paramb) {}
      
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(236360);
        s.u(paramString, "bizUsername");
        s.u(paramSubscribeMsgRequestResult, "result");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg success bizUsername: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.phC.size()) });
        a.b.a(this.pjv, a.b.e(this.pjv), a.b.c(this.pjv), paramSubscribeMsgRequestResult);
        AppMethodBeat.o(236360);
      }
      
      public final void j(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(236371);
        s.u(paramString, "errMsg");
        Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        a.a locala = a.b.d(this.pjv);
        if (locala != null)
        {
          paramInt2 = a.b.c(this.pjv);
          if (((CharSequence)paramString).length() <= 0) {
            break label98;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label103;
          }
        }
        for (;;)
        {
          locala.j(paramInt2, 10003, paramString);
          AppMethodBeat.o(236371);
          return;
          label98:
          paramInt1 = 0;
          break;
          label103:
          paramString = "subscribe failed";
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class i
      implements com.tencent.mm.msgsubscription.api.a
    {
      i(a.b paramb) {}
      
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(236359);
        s.u(paramString, "bizUsername");
        s.u(paramSubscribeMsgRequestResult, "result");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onSuccess bizUsername: %s, size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.phC.size()) });
        a.b.a(this.pjv, a.b.c(this.pjv), paramSubscribeMsgRequestResult);
        AppMethodBeat.o(236359);
      }
      
      public final void j(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(236368);
        s.u(paramString, "errMsg");
        Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        a.a locala = a.b.d(this.pjv);
        if (locala != null)
        {
          paramInt2 = a.b.c(this.pjv);
          if (((CharSequence)paramString).length() <= 0) {
            break label98;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break label103;
          }
        }
        for (;;)
        {
          locala.j(paramInt2, 10002, paramString);
          AppMethodBeat.o(236368);
          return;
          label98:
          paramInt1 = 0;
          break;
          label103:
          paramString = "get subscribe msg list failed";
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "isCancelable", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class j
      extends f
    {
      j(Context paramContext, List<f.c> paramList, boolean paramBoolean, a.b.k paramk)
      {
        super(paramList, (f.g)paramk, paramBoolean, false);
        AppMethodBeat.i(236362);
        AppMethodBeat.o(236362);
      }
      
      public final boolean isCancelable()
      {
        return true;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$3", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onSwitchChanged", "switch", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion$SwitchType;", "isOn", "", "item", "userAction", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class k
      implements f.g
    {
      k(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void a(f.g.a.a parama, boolean paramBoolean1, f.c paramc, boolean paramBoolean2)
      {
        AppMethodBeat.i(236378);
        s.u(parama, "switch");
        s.u(paramc, "item");
        AppMethodBeat.o(236378);
      }
      
      public final void r(int paramInt, List<? extends f.c> paramList)
      {
        int j = 0;
        AppMethodBeat.i(236369);
        s.u(paramList, "resultData");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog onEvent: %s, result size: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(236369);
          return;
        }
        Object localObject2;
        boolean bool;
        label176:
        label199:
        int i;
        if (a.b.k(paramList, (List)paramSubscribeMsgRequestResult.phC))
        {
          this.pjv.pjn = paramSubscribeMsgRequestResult.phC;
          a.b.a(this.pjv, a.xn(a.b.c(this.pjv)));
          a.b.a(this.pjv, paramSubscribeMsgRequestResult.buffer);
          Object localObject1 = this.pjv;
          localObject2 = SubscribeMsgRequestDialogUiData.phj;
          paramList = p.J((Collection)paramList);
          localObject2 = a.b.f(this.pjv);
          if (localObject2 == null)
          {
            bool = false;
            a.b.a((a.b)localObject1, SubscribeMsgRequestDialogUiData.a.o(paramInt, paramList, bool));
            paramList = a.pji;
            a.b(this.pjv);
            if (paramSubscribeMsgRequestResult.phD) {
              break label349;
            }
            paramList = a.b.g(this.pjv);
            localObject1 = a.b.f(this.pjv);
            if ((localObject1 == null) || (((f)localObject1).plA.isChecked() != true)) {
              break label339;
            }
            i = 1;
            label245:
            if (i == 0) {
              break label344;
            }
            i = 1;
            label251:
            paramList.pjN = i;
            switch (paramInt)
            {
            default: 
              label256:
              paramInt = j;
            }
          }
        }
        for (;;)
        {
          paramList = com.tencent.mm.msgsubscription.c.a.pjH;
          com.tencent.mm.msgsubscription.c.a.a(paramInt, a.b.g(this.pjv));
          break;
          bool = ((f)localObject2).plA.isChecked();
          break label176;
          paramList = a.b.d(this.pjv);
          if (paramList == null) {
            break label199;
          }
          paramList.onCancel();
          break label199;
          label339:
          i = 0;
          break label245;
          label344:
          i = 0;
          break label251;
          label349:
          a.b.g(this.pjv).pjN = 2;
          break label256;
          paramInt = 2;
          continue;
          paramInt = 3;
          continue;
          paramInt = 4;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$4", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "onDismiss", "", "onShow", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class l
      implements f.h
    {
      l(a.b paramb) {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(236380);
        a.a locala = a.b.d(this.pjv);
        if (locala != null) {
          locala.bPZ();
        }
        AppMethodBeat.o(236380);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(236370);
        Object localObject = a.b.d(this.pjv);
        if (localObject != null) {
          ((a.a)localObject).a((n)a.b.f(this.pjv), a.b.h(this.pjv));
        }
        localObject = com.tencent.mm.msgsubscription.c.a.pjH;
        com.tencent.mm.msgsubscription.c.a.a(1, a.b.g(this.pjv));
        AppMethodBeat.o(236370);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$5", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", "index", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class m
      implements f.a.a
    {
      m(a.b paramb) {}
      
      public final void bj(String paramString, int paramInt)
      {
        AppMethodBeat.i(236355);
        s.u(paramString, "templateId");
        paramString = com.tencent.mm.msgsubscription.c.a.pjH;
        com.tencent.mm.msgsubscription.c.a.xs(paramInt);
        paramString = com.tencent.mm.msgsubscription.c.a.pjH;
        com.tencent.mm.msgsubscription.c.a.a(5, a.b.g(this.pjv));
        AppMethodBeat.o(236355);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.a
 * JD-Core Version:    0.7.0.1
 */