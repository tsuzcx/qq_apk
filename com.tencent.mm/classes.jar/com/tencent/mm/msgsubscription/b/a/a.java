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
import com.tencent.mm.msgsubscription.api.b;
import com.tencent.mm.msgsubscription.ui.c.a.a;
import com.tencent.mm.msgsubscription.ui.c.c;
import com.tencent.mm.msgsubscription.ui.c.f;
import com.tencent.mm.msgsubscription.ui.c.g;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController;", "Lcom/tencent/mm/msgsubscription/model/biz_service/IBrandSubscribeMsgRequestController;", "()V", "TAG", "", "actionMachine", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSubscribeMsgList", "", "requestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "isGetAction", "", "action", "isSubscribeAction", "nextAction", "subscribeMsgList", "SubscribeMsgRequestCallback", "SubscribeMsgRequestTask", "plugin-comm_release"})
public final class a
{
  private static HashMap<Integer, Integer> mpv;
  public static final a mpw;
  
  static
  {
    AppMethodBeat.i(244081);
    mpw = new a();
    mpv = ae.g(new o[] { s.M(Integer.valueOf(1), Integer.valueOf(0)), s.M(Integer.valueOf(3), Integer.valueOf(2)), s.M(Integer.valueOf(2), Integer.valueOf(0)) });
    AppMethodBeat.o(244081);
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(244079);
    p.k(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(244079);
  }
  
  public static void b(b paramb)
  {
    AppMethodBeat.i(244080);
    p.k(paramb, "requestTask");
    paramb.run();
    AppMethodBeat.o(244080);
  }
  
  public static final int xn(int paramInt)
  {
    AppMethodBeat.i(244077);
    Integer localInteger = (Integer)mpv.get(Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      paramInt = localInteger.intValue();
      AppMethodBeat.o(244077);
      return paramInt;
    }
    AppMethodBeat.o(244077);
    return -1;
  }
  
  public static final boolean xo(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 1);
  }
  
  public static final boolean xp(int paramInt)
  {
    return paramInt == 2;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", "action", "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"})
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.widget.dialog.j paramj, com.tencent.mm.plugin.appbrand.widget.dialog.d paramd);
    
    public abstract void a(boolean paramBoolean, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void bst();
    
    public abstract void bsu();
    
    public abstract void i(int paramInt1, int paramInt2, String paramString);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "", "context", "Landroid/content/Context;", "action", "", "bizAppId", "", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "extInfo", "requestCallback", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "(Landroid/content/Context;ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "bizUsername", "subscribeUrl", "content", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "buffer", "", "mAlertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "mBizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "mDialogContainerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mFromScene", "mSubscribeMsgDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "mSubscribeReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getSubscribeMsgTmpItems", "()Ljava/util/ArrayList;", "setSubscribeMsgTmpItems", "(Ljava/util/ArrayList;)V", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "applyUserAction", "", "event", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "dispatchSuccessResult", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "initReportInfo", "onGetSubscribeMsgListSuccess", "release", "reportSubscribeAuth", "showType", "timestamp", "", "run", "setFromScene", "fromScene", "showAlertDialog", "title", "okOnClickListener", "Landroid/content/DialogInterface$OnClickListener;", "showSettingPageAlert", "callback", "Lkotlin/Function0;", "showSubscribeRequestDialog", "showSuccessToast", "msg", "showToast", "Companion", "plugin-comm_release"})
  public static final class b
  {
    public static final a.b.a mpG;
    private int action;
    private byte[] buffer;
    private final String content;
    private final Context context;
    private final String extInfo;
    private String fOX;
    public int jaR;
    private SubscribeMsgRequestDialogUiData moI;
    private final String moV;
    public com.tencent.mm.msgsubscription.ui.c mpA;
    private com.tencent.mm.plugin.appbrand.widget.dialog.d mpB;
    private com.tencent.mm.msgsubscription.b.a mpC;
    private com.tencent.mm.msgsubscription.c.a.a mpD;
    private final String mpE;
    private final a.a mpF;
    ArrayList<SubscribeMsgTmpItem> mpx;
    private ArrayList<String> mpy;
    public com.tencent.mm.ui.widget.a.d mpz;
    
    static
    {
      AppMethodBeat.i(222484);
      mpG = new a.b.a((byte)0);
      AppMethodBeat.o(222484);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, a.a parama)
    {
      AppMethodBeat.i(222477);
      this.context = paramContext;
      this.action = paramInt;
      this.fOX = paramString1;
      this.mpE = paramString2;
      this.moV = paramString3;
      this.content = paramString4;
      this.extInfo = paramString5;
      this.mpF = parama;
      this.mpy = new ArrayList();
      paramContext = b.moG;
      this.mpC = b.YR("name_biz");
      this.buffer = new byte[] { 0 };
      this.mpD = new com.tencent.mm.msgsubscription.c.a.a();
      AppMethodBeat.o(222477);
    }
    
    public b(Context paramContext, int paramInt, String paramString1, ArrayList<String> paramArrayList, String paramString2, a.a parama)
    {
      this(paramContext, paramInt, "", paramString1, "", "", paramString2, parama);
      AppMethodBeat.i(222482);
      this.mpy.clear();
      this.mpy.addAll((Collection)paramArrayList);
      Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo initSubscribeMsgRequestTask templateId size: %s", new Object[] { Integer.valueOf(this.mpy.size()) });
      AppMethodBeat.o(222482);
    }
    
    private final void E(int paramInt, long paramLong)
    {
      AppMethodBeat.i(222469);
      if (this.jaR == 1)
      {
        com.tencent.mm.msgsubscription.c.a locala = com.tencent.mm.msgsubscription.c.a.mpZ;
        com.tencent.mm.msgsubscription.c.a.a(this.fOX, paramInt, this.content, paramLong);
      }
      AppMethodBeat.o(222469);
    }
    
    private final void a(final Context paramContext, final int paramInt, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(222457);
      Object localObject1 = paramSubscribeMsgRequestResult.mnV;
      if (localObject1 != null) {}
      long l;
      final boolean bool;
      for (int i = ((ShowInfo)localObject1).fwp;; i = -1)
      {
        localObject1 = this.mpF;
        if (localObject1 != null) {
          ((a.a)localObject1).bsu();
        }
        l = System.currentTimeMillis() / 1000L;
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo dispatchSuccessResult showType: %s, action: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(paramSubscribeMsgRequestResult.mnY), paramSubscribeMsgRequestResult.mnZ });
        if (!a.xo(paramInt)) {
          break label1774;
        }
        if (i != 0) {
          break label1356;
        }
        if (paramSubscribeMsgRequestResult.mnY != 0) {
          break label1318;
        }
        E(1, l);
        if (!paramSubscribeMsgRequestResult.mnO.isEmpty()) {
          break;
        }
        Log.w("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog list is empty and not show dialog");
        paramContext = this.mpF;
        if (paramContext != null) {
          paramContext.i(this.action, 10002, "template list empty");
        }
        bool = false;
        paramContext = this.mpF;
        if (paramContext == null) {
          break label1311;
        }
        paramContext.a(bool, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(222457);
        return;
      }
      Object localObject3 = (List)new ArrayList();
      localObject1 = ((Iterable)paramSubscribeMsgRequestResult.mnO).iterator();
      label289:
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubscribeMsgTmpItem)((Iterator)localObject1).next();
        Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog templateId: %s, chooseStatus: %d", new Object[] { ((SubscribeMsgTmpItem)localObject2).lnb, Integer.valueOf(((SubscribeMsgTmpItem)localObject2).mnG) });
        if (((SubscribeMsgTmpItem)localObject2).mnG == 1)
        {
          bool = true;
          ((List)localObject3).add(new c.c(bool, ((SubscribeMsgTmpItem)localObject2).title, ((SubscribeMsgTmpItem)localObject2).moe, ((SubscribeMsgTmpItem)localObject2).lnb));
          this.mpD.mpy.add(((SubscribeMsgTmpItem)localObject2).lnb);
          localObject4 = this.mpD.mqa;
          if (((SubscribeMsgTmpItem)localObject2).mnG != 0) {
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
      localObject1 = (SubscribeMsgTmpItem)kotlin.a.j.lp((List)paramSubscribeMsgRequestResult.mnO);
      if (localObject1 != null)
      {
        paramInt = ((SubscribeMsgTmpItem)localObject1).mod;
        label406:
        if ((((List)localObject3).size() != 1) || (paramSubscribeMsgRequestResult.mnU != 1)) {
          break label1211;
        }
        bool = true;
        label428:
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog size: %d, showStyle: %d, singleMode: %b, templateType: %d", new Object[] { Integer.valueOf(((List)localObject3).size()), Integer.valueOf(paramSubscribeMsgRequestResult.mnU), Boolean.valueOf(bool), Integer.valueOf(paramInt) });
        this.mpA = ((com.tencent.mm.msgsubscription.ui.c)new n(this, paramContext, (List)localObject3, paramSubscribeMsgRequestResult, bool, paramContext, (List)localObject3, (c.f)new o(this, paramSubscribeMsgRequestResult), bool));
        localObject1 = this.mpA;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).msp = ((c.g)new p(this));
        }
        localObject4 = this.mpA;
        if (localObject4 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.mnW;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.msgsubscription.ui.c)localObject4).setDesc((String)localObject1);
        }
        localObject4 = this.mpA;
        if (localObject4 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.mnX;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.msgsubscription.ui.c)localObject4).Zj((String)localObject1);
        }
        if (bool) {
          ((c.c)kotlin.a.j.lo((List)localObject3)).msB = true;
        }
        localObject1 = this.mpA;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).Zc(paramSubscribeMsgRequestResult.appName);
        }
        localObject1 = this.mpA;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).setIconUrl(paramSubscribeMsgRequestResult.mnM);
        }
        localObject1 = this.mpA;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.mnR;
          if (localObject2 == null) {
            p.iCn();
          }
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).Zg(((WordingInfo)localObject2).mon);
        }
        localObject1 = this.mpA;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.mnR;
          if (localObject2 == null) {
            p.iCn();
          }
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).Zh(((WordingInfo)localObject2).moo);
        }
        localObject1 = this.mpA;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.mnR;
          if (localObject2 == null) {
            p.iCn();
          }
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).Zi(((WordingInfo)localObject2).mop);
        }
        localObject1 = this.mpA;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).mso = c.d.default_avatar;
        }
        localObject4 = this.mpA;
        if (localObject4 != null)
        {
          localObject1 = paramSubscribeMsgRequestResult.mnR;
          if (localObject1 == null) {
            p.iCn();
          }
          localObject2 = ((WordingInfo)localObject1).mor;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.msgsubscription.ui.c)localObject4).Zd((String)localObject1);
        }
        localObject1 = this.mpA;
        if (localObject1 != null)
        {
          if (paramSubscribeMsgRequestResult.mnP) {
            break label1217;
          }
          bool = true;
          label871:
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).msh = bool;
          localObject2 = ((com.tencent.mm.msgsubscription.ui.c)localObject1).mrU;
          if (!((com.tencent.mm.msgsubscription.ui.c)localObject1).msh) {
            break label1223;
          }
          paramInt = 0;
          label895:
          ((View)localObject2).setVisibility(paramInt);
        }
        localObject1 = this.mpA;
        if (localObject1 != null)
        {
          if (paramSubscribeMsgRequestResult.mnQ) {
            break label1229;
          }
          bool = true;
          label922:
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).msj = bool;
          localObject2 = ((com.tencent.mm.msgsubscription.ui.c)localObject1).mrT;
          if (!((com.tencent.mm.msgsubscription.ui.c)localObject1).msj) {
            break label1235;
          }
          paramInt = 0;
          label946:
          ((TextView)localObject2).setVisibility(paramInt);
        }
        localObject1 = this.mpA;
        if ((localObject1 == null) || (((com.tencent.mm.msgsubscription.ui.c)localObject1).msh != true)) {
          break label1241;
        }
        localObject1 = this.mpA;
        if (localObject1 != null)
        {
          localObject2 = paramSubscribeMsgRequestResult.mnR;
          if (localObject2 == null) {
            p.iCn();
          }
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).Ze(((WordingInfo)localObject2).moq);
        }
        label1007:
        localObject1 = this.mpA;
        if (localObject1 == null) {
          break label1299;
        }
        localObject1 = Boolean.valueOf(((com.tencent.mm.msgsubscription.ui.c)localObject1).msh);
        label1028:
        localObject2 = this.mpA;
        if (localObject2 == null) {
          break label1305;
        }
      }
      label1299:
      label1305:
      for (Object localObject2 = Boolean.valueOf(((com.tencent.mm.msgsubscription.ui.c)localObject2).msj);; localObject2 = null)
      {
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeMsgRequestDialog showAlways: %s, showReject: %s", new Object[] { localObject1, localObject2 });
        localObject1 = this.mpA;
        if (localObject1 != null) {
          ((com.tencent.mm.msgsubscription.ui.c)localObject1).msd = ((c.a.a)new q(this));
        }
        if (this.mpB == null)
        {
          this.mpB = new com.tencent.mm.plugin.appbrand.widget.dialog.d(paramContext);
          if ((paramContext instanceof Activity))
          {
            localObject1 = new ViewGroup.LayoutParams(-1, -2);
            ((Activity)paramContext).addContentView((View)this.mpB, (ViewGroup.LayoutParams)localObject1);
          }
        }
        paramContext = this.mpA;
        if (paramContext != null) {
          paramContext.setPosition(2);
        }
        paramContext = this.mpB;
        if (paramContext != null) {
          paramContext.a((com.tencent.mm.plugin.appbrand.widget.dialog.j)this.mpA);
        }
        paramContext = com.tencent.mm.msgsubscription.c.a.mpZ;
        com.tencent.mm.msgsubscription.c.a.xr(((List)localObject3).size());
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
        localObject1 = this.mpA;
        if ((localObject1 == null) || (((com.tencent.mm.msgsubscription.ui.c)localObject1).msj != true)) {
          break label1007;
        }
        localObject1 = this.mpA;
        if (localObject1 == null) {
          break label1007;
        }
        localObject2 = paramSubscribeMsgRequestResult.mnR;
        if (localObject2 == null) {
          p.iCn();
        }
        ((com.tencent.mm.msgsubscription.ui.c)localObject1).Zf(((WordingInfo)localObject2).mos);
        break label1007;
        localObject1 = null;
        break label1028;
      }
      label1311:
      AppMethodBeat.o(222457);
      return;
      label1318:
      paramContext = this.mpF;
      if (paramContext != null)
      {
        paramContext.i(paramInt, paramSubscribeMsgRequestResult.mnY, paramSubscribeMsgRequestResult.mnZ);
        AppMethodBeat.o(222457);
        return;
      }
      AppMethodBeat.o(222457);
      return;
      label1356:
      if (i == 1)
      {
        E(2, l);
        localObject1 = paramSubscribeMsgRequestResult.mnV;
        if (localObject1 != null)
        {
          localObject1 = ((ShowInfo)localObject1).mnu;
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
        localObject2 = paramSubscribeMsgRequestResult.mnV;
        if (localObject2 != null)
        {
          localObject2 = ((ShowInfo)localObject2).mnv;
          if (localObject2 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        for (;;)
        {
          a(paramContext, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)new b(this, paramSubscribeMsgRequestResult, paramInt));
          AppMethodBeat.o(222457);
          return;
          if (i == 2)
          {
            E(3, l);
            paramContext = paramSubscribeMsgRequestResult.mnV;
            if (paramContext != null)
            {
              paramContext = paramContext.mnv;
              if (paramContext != null) {
                break label2154;
              }
            }
            paramContext = "";
          }
          for (;;)
          {
            g(paramContext, (kotlin.g.a.a)new c(this, paramSubscribeMsgRequestResult, paramInt));
            AppMethodBeat.o(222457);
            return;
            if (i == 4)
            {
              E(5, l);
              paramContext = paramSubscribeMsgRequestResult.mnV;
              if (paramContext != null)
              {
                paramContext = paramContext.mnv;
                if (paramContext != null) {
                  break label2151;
                }
              }
              paramContext = "";
            }
            for (;;)
            {
              g(paramContext, (kotlin.g.a.a)new d(this, paramSubscribeMsgRequestResult, paramInt));
              AppMethodBeat.o(222457);
              return;
              if (i == 3)
              {
                E(4, l);
                localObject3 = (kotlin.g.a.a)new e(this, paramSubscribeMsgRequestResult, paramInt);
                localObject1 = paramSubscribeMsgRequestResult.mnV;
                if (localObject1 != null)
                {
                  localObject1 = ((ShowInfo)localObject1).mnv;
                  localObject2 = paramSubscribeMsgRequestResult.mnV;
                  if (localObject2 == null) {
                    break label1714;
                  }
                }
                for (localObject2 = ((ShowInfo)localObject2).mnu;; localObject2 = null)
                {
                  this.mpz = h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(c.h.subscribe_msg_alert_action_go_to_setting_page), paramContext.getString(c.h.app_cancel), false, (DialogInterface.OnClickListener)new l(this, (kotlin.g.a.a)localObject3, paramContext, paramSubscribeMsgRequestResult), (DialogInterface.OnClickListener)new a.b.m((kotlin.g.a.a)localObject3));
                  paramContext = this.mpz;
                  if (paramContext == null) {
                    break label1720;
                  }
                  paramContext.setCanceledOnTouchOutside(false);
                  AppMethodBeat.o(222457);
                  return;
                  localObject1 = null;
                  break;
                }
                AppMethodBeat.o(222457);
                return;
              }
              E(-1, l);
              paramContext = paramContext.getString(c.h.subscribe_msg_common_fail);
              p.j(paramContext, "context.getString(R.stri…ubscribe_msg_common_fail)");
              g(paramContext, (kotlin.g.a.a)new f(this, paramSubscribeMsgRequestResult, paramInt));
              AppMethodBeat.o(222457);
              return;
              if (a.xp(paramInt))
              {
                if (i == 4)
                {
                  E(5, l);
                  paramContext = paramSubscribeMsgRequestResult.mnV;
                  if (paramContext != null)
                  {
                    localObject1 = paramContext.mnv;
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
                      w.cR(this.context, paramContext);
                    }
                    paramSubscribeMsgRequestResult.invoke();
                    AppMethodBeat.o(222457);
                    return;
                  }
                }
                if (i == 1)
                {
                  E(2, l);
                  localObject1 = paramSubscribeMsgRequestResult.mnV;
                  if (localObject1 != null)
                  {
                    localObject1 = ((ShowInfo)localObject1).mnu;
                    if (localObject1 != null) {
                      break label2148;
                    }
                  }
                  localObject1 = "";
                }
              }
              for (;;)
              {
                localObject2 = paramSubscribeMsgRequestResult.mnV;
                if (localObject2 != null)
                {
                  localObject2 = ((ShowInfo)localObject2).mnv;
                  if (localObject2 != null) {}
                }
                else
                {
                  localObject2 = "";
                }
                for (;;)
                {
                  a(paramContext, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)new h(this, paramSubscribeMsgRequestResult, paramInt));
                  AppMethodBeat.o(222457);
                  return;
                  if (i == 2)
                  {
                    E(3, l);
                    paramContext = paramSubscribeMsgRequestResult.mnV;
                    if (paramContext != null)
                    {
                      paramContext = paramContext.mnv;
                      if (paramContext != null) {
                        break label2142;
                      }
                    }
                    paramContext = "";
                  }
                  for (;;)
                  {
                    g(paramContext, (kotlin.g.a.a)new i(this, paramSubscribeMsgRequestResult, paramInt));
                    AppMethodBeat.o(222457);
                    return;
                    if (i == 0) {
                      i = 1;
                    }
                    for (;;)
                    {
                      E(i, l);
                      if (paramSubscribeMsgRequestResult.mnY != 0) {
                        break label2104;
                      }
                      paramContext = this.mpF;
                      if (paramContext == null) {
                        break;
                      }
                      paramContext.b(paramSubscribeMsgRequestResult);
                      AppMethodBeat.o(222457);
                      return;
                      if (i == 3) {
                        i = 4;
                      } else {
                        i = -1;
                      }
                    }
                    AppMethodBeat.o(222457);
                    return;
                    paramContext = this.mpF;
                    if (paramContext != null)
                    {
                      paramContext.i(paramInt, paramSubscribeMsgRequestResult.mnY, paramSubscribeMsgRequestResult.mnZ);
                      AppMethodBeat.o(222457);
                      return;
                    }
                    AppMethodBeat.o(222457);
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
      AppMethodBeat.i(222459);
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
        h.a(paramContext, paramString2, paramString1, paramContext.getResources().getString(c.h.app_i_known), false, paramOnClickListener);
        AppMethodBeat.o(222459);
        return;
        i = 0;
        break;
        label58:
        paramString2 = paramContext.getString(c.h.subscribe_msg_alert_default_content);
        p.j(paramString2, "context.getString(R.stri…sg_alert_default_content)");
      }
    }
    
    private final void bsv()
    {
      AppMethodBeat.i(222466);
      this.mpD.YU(this.fOX);
      this.mpD.YV(this.mpE);
      try
      {
        if (((CharSequence)this.extInfo).length() > 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          Object localObject = new JSONObject(this.extInfo);
          com.tencent.mm.msgsubscription.c.a.a locala = this.mpD;
          localObject = ((JSONObject)localObject).optString("sessionid");
          p.j(localObject, "data.optString(\"sessionid\")");
          locala.setSessionId((String)localObject);
          AppMethodBeat.o(222466);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(222466);
      }
    }
    
    private final void g(String paramString, kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(222460);
      if (((CharSequence)paramString).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          Toast.makeText(this.context, (CharSequence)paramString, 0).show();
        }
        parama.invoke();
        AppMethodBeat.o(222460);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(222359);
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
        AppMethodBeat.o(222359);
        return;
        int i;
        if (((CharSequence)this.moV).length() == 0) {
          i = 1;
        }
        while ((i != 0) && (this.mpy.isEmpty()))
        {
          localObject1 = this.mpF;
          if (localObject1 != null)
          {
            ((a.a)localObject1).i(this.action, 10001, "templateIdList empty");
            AppMethodBeat.o(222359);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(222359);
            return;
          }
        }
        if (((CharSequence)this.extInfo).length() > 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = new JSONObject(this.extInfo).optString("username");
            p.j(localObject1, "username");
            if (((CharSequence)localObject1).length() <= 0) {
              break label315;
            }
            i = 1;
            if (i != 0) {
              this.fOX = ((String)localObject1);
            }
          }
          Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList bizUsername: %s, bizAppId: %s, url: %s, templateIdList size: %s", new Object[] { this.fOX, this.mpE, this.moV, Integer.valueOf(this.mpy.size()) });
          bsv();
          localObject1 = new k(this);
          if (((CharSequence)this.fOX).length() <= 0) {
            break label320;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            localObject2 = this.mpC;
            if (localObject2 != null)
            {
              ((com.tencent.mm.msgsubscription.b.a)localObject2).a(this.fOX, this.moV, (List)this.mpy, this.extInfo, (com.tencent.mm.msgsubscription.api.a)localObject1);
              AppMethodBeat.o(222359);
              return;
              i = 0;
              break;
              i = 0;
              break label178;
              i = 0;
              continue;
            }
            AppMethodBeat.o(222359);
            return;
          }
        }
        if (((CharSequence)this.mpE).length() > 0) {
          i = 1;
        }
        while (i != 0)
        {
          localObject2 = this.mpC;
          if (localObject2 != null)
          {
            ((com.tencent.mm.msgsubscription.b.a)localObject2).b(this.mpE, this.moV, (List)this.mpy, this.extInfo, (com.tencent.mm.msgsubscription.api.a)localObject1);
            AppMethodBeat.o(222359);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(222359);
            return;
          }
        }
        localObject1 = this.mpF;
        if (localObject1 != null)
        {
          ((a.a)localObject1).i(this.action, -1, "username or appId invalid");
          AppMethodBeat.o(222359);
          return;
        }
        AppMethodBeat.o(222359);
        return;
        localObject1 = this.fOX;
        localObject2 = this.mpE;
        ArrayList localArrayList = this.mpx;
        if (localArrayList == null) {
          p.iCn();
        }
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg bizUsername: %s, appId: %s, template size: %s", new Object[] { localObject1, localObject2, Integer.valueOf(localArrayList.size()) });
        localObject1 = new com.tencent.mm.msgsubscription.api.c();
        ((com.tencent.mm.msgsubscription.api.c)localObject1).moJ = true;
        ((com.tencent.mm.msgsubscription.api.c)localObject1).setUsername(this.fOX);
        ((com.tencent.mm.msgsubscription.api.c)localObject1).setAppId(this.mpE);
        localObject2 = ((com.tencent.mm.msgsubscription.api.c)localObject1).moB;
        localArrayList = this.mpx;
        if (localArrayList == null) {
          p.iCn();
        }
        ((List)localObject2).addAll((Collection)localArrayList);
        ((com.tencent.mm.msgsubscription.api.c)localObject1).moH = true;
        ((com.tencent.mm.msgsubscription.api.c)localObject1).setBuffer(this.buffer);
        ((com.tencent.mm.msgsubscription.api.c)localObject1).moI = this.moI;
        ((com.tencent.mm.msgsubscription.api.c)localObject1).YS(this.extInfo);
        ((com.tencent.mm.msgsubscription.api.c)localObject1).moK = ((com.tencent.mm.msgsubscription.api.a)new j(this));
        localObject2 = this.mpC;
      } while (localObject2 == null);
      ((com.tencent.mm.msgsubscription.b.a)localObject2).a((com.tencent.mm.msgsubscription.api.c)localObject1);
      AppMethodBeat.o(222359);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(221137);
        if (paramSubscribeMsgRequestResult.mnY == 0)
        {
          paramDialogInterface = a.b.d(this.mpH);
          if (paramDialogInterface != null)
          {
            paramDialogInterface.a(false, paramSubscribeMsgRequestResult);
            AppMethodBeat.o(221137);
            return;
          }
          AppMethodBeat.o(221137);
          return;
        }
        paramDialogInterface = a.b.d(this.mpH);
        if (paramDialogInterface != null)
        {
          paramDialogInterface.i(paramInt, paramSubscribeMsgRequestResult.mnY, paramSubscribeMsgRequestResult.mnZ);
          AppMethodBeat.o(221137);
          return;
        }
        AppMethodBeat.o(221137);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<x>
    {
      c(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.a<x>
    {
      e(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class f
      extends q
      implements kotlin.g.a.a<x>
    {
      f(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class g
      extends q
      implements kotlin.g.a.a<x>
    {
      g(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class h
      implements DialogInterface.OnClickListener
    {
      h(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(196077);
        if (paramSubscribeMsgRequestResult.mnY == 0)
        {
          paramDialogInterface = a.b.d(this.mpH);
          if (paramDialogInterface != null)
          {
            paramDialogInterface.b(paramSubscribeMsgRequestResult);
            AppMethodBeat.o(196077);
            return;
          }
          AppMethodBeat.o(196077);
          return;
        }
        paramDialogInterface = a.b.d(this.mpH);
        if (paramDialogInterface != null)
        {
          paramDialogInterface.i(paramInt, paramSubscribeMsgRequestResult.mnY, paramSubscribeMsgRequestResult.mnZ);
          AppMethodBeat.o(196077);
          return;
        }
        AppMethodBeat.o(196077);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class i
      extends q
      implements kotlin.g.a.a<x>
    {
      i(a.b paramb, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class j
      implements com.tencent.mm.msgsubscription.api.a
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(236528);
        p.k(paramString, "bizUsername");
        p.k(paramSubscribeMsgRequestResult, "result");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg success bizUsername: %s, template size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.mnO.size()) });
        a.b.a(this.mpH, a.b.e(this.mpH), a.b.c(this.mpH), paramSubscribeMsgRequestResult);
        AppMethodBeat.o(236528);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(236529);
        p.k(paramString, "errMsg");
        Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        a.a locala = a.b.d(this.mpH);
        if (locala != null)
        {
          paramInt2 = a.b.c(this.mpH);
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
            AppMethodBeat.o(236529);
            return;
            paramInt1 = 0;
            break;
            label103:
            paramString = "subscribe failed";
          }
        }
        AppMethodBeat.o(236529);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class k
      implements com.tencent.mm.msgsubscription.api.a
    {
      public final void a(String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(204588);
        p.k(paramString, "bizUsername");
        p.k(paramSubscribeMsgRequestResult, "result");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onSuccess bizUsername: %s, size: %d", new Object[] { paramString, Integer.valueOf(paramSubscribeMsgRequestResult.mnO.size()) });
        a.b.a(this.mpH, a.b.c(this.mpH), paramSubscribeMsgRequestResult);
        AppMethodBeat.o(204588);
      }
      
      public final void i(int paramInt1, int paramInt2, String paramString)
      {
        AppMethodBeat.i(204589);
        p.k(paramString, "errMsg");
        Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onError errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        a.a locala = a.b.d(this.mpH);
        if (locala != null)
        {
          paramInt2 = a.b.c(this.mpH);
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
            AppMethodBeat.o(204589);
            return;
            paramInt1 = 0;
            break;
            label103:
            paramString = "get subscribe msg list failed";
          }
        }
        AppMethodBeat.o(204589);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class l
      implements DialogInterface.OnClickListener
    {
      l(a.b paramb, kotlin.g.a.a parama, Context paramContext, SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(187440);
        paramDialogInterface = a.b.f(this.mpH);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        this.kWs.invoke();
        paramDialogInterface = b.moG;
        paramDialogInterface = b.YR("name_biz");
        if (paramDialogInterface != null)
        {
          paramDialogInterface.a(paramContext, 3, a.b.g(this.mpH), paramSubscribeMsgRequestResult.appName);
          AppMethodBeat.o(187440);
          return;
        }
        AppMethodBeat.o(187440);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "isCancelable", "", "plugin-comm_release"})
    public static final class n
      extends com.tencent.mm.msgsubscription.ui.c
    {
      n(Context paramContext1, List paramList1, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, boolean paramBoolean1, Context paramContext2, List paramList2, c.f paramf, boolean paramBoolean2)
      {
        super(paramf, paramBoolean2, bool, false);
      }
      
      public final boolean isCancelable()
      {
        return true;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$3", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "plugin-comm_release"})
    public static final class o
      implements c.f
    {
      o(SubscribeMsgRequestResult paramSubscribeMsgRequestResult) {}
      
      public final void c(int paramInt, List<? extends c.c> paramList)
      {
        int j = 0;
        AppMethodBeat.i(187658);
        p.k(paramList, "resultData");
        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog onEvent: %s, result size: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramList.size()) });
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187658);
          return;
        }
        a.b.f(paramList, (List)paramSubscribeMsgRequestResult.mnO);
        this.mpH.mpx = paramSubscribeMsgRequestResult.mnO;
        a.b.a(this.mpH, a.xn(a.b.c(this.mpH)));
        a.b.a(this.mpH, paramSubscribeMsgRequestResult.buffer);
        Object localObject1 = this.mpH;
        Object localObject2 = SubscribeMsgRequestDialogUiData.mnF;
        paramList = kotlin.a.j.t((Collection)paramList);
        localObject2 = a.b.h(this.mpH);
        boolean bool;
        label181:
        int i;
        if (localObject2 != null)
        {
          bool = ((com.tencent.mm.msgsubscription.ui.c)localObject2).mrV.isChecked();
          a.b.a((a.b)localObject1, SubscribeMsgRequestDialogUiData.a.a(paramInt, paramList, bool));
          paramList = a.mpw;
          a.b(this.mpH);
          if (paramSubscribeMsgRequestResult.mnP) {
            break label316;
          }
          paramList = a.b.i(this.mpH);
          localObject1 = a.b.h(this.mpH);
          if ((localObject1 == null) || (((com.tencent.mm.msgsubscription.ui.c)localObject1).mrV.isChecked() != true)) {
            break label311;
          }
          i = 1;
          label250:
          paramList.mqb = i;
          switch (paramInt)
          {
          default: 
            label255:
            paramInt = j;
          }
        }
        for (;;)
        {
          paramList = com.tencent.mm.msgsubscription.c.a.mpZ;
          com.tencent.mm.msgsubscription.c.a.a(paramInt, a.b.i(this.mpH));
          break;
          bool = false;
          break label181;
          label311:
          i = 0;
          break label250;
          label316:
          a.b.i(this.mpH).mqb = 2;
          break label255;
          paramInt = 2;
          continue;
          paramInt = 3;
          continue;
          paramInt = 4;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$4", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "onDismiss", "", "onShow", "plugin-comm_release"})
    public static final class p
      implements c.g
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(219801);
        a.a locala = a.b.d(this.mpH);
        if (locala != null)
        {
          locala.bst();
          AppMethodBeat.o(219801);
          return;
        }
        AppMethodBeat.o(219801);
      }
      
      public final void onShow()
      {
        AppMethodBeat.i(219799);
        Object localObject = a.b.d(this.mpH);
        if (localObject != null) {
          ((a.a)localObject).a((com.tencent.mm.plugin.appbrand.widget.dialog.j)a.b.h(this.mpH), a.b.j(this.mpH));
        }
        localObject = com.tencent.mm.msgsubscription.c.a.mpZ;
        com.tencent.mm.msgsubscription.c.a.a(1, a.b.i(this.mpH));
        AppMethodBeat.o(219799);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$5", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", "index", "", "plugin-comm_release"})
    public static final class q
      implements c.a.a
    {
      public final void aV(String paramString, int paramInt)
      {
        AppMethodBeat.i(197811);
        p.k(paramString, "templateId");
        paramString = com.tencent.mm.msgsubscription.c.a.mpZ;
        com.tencent.mm.msgsubscription.c.a.xs(paramInt);
        paramString = com.tencent.mm.msgsubscription.c.a.mpZ;
        com.tencent.mm.msgsubscription.c.a.a(5, a.b.i(this.mpH));
        AppMethodBeat.o(197811);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.b.a.a
 * JD-Core Version:    0.7.0.1
 */