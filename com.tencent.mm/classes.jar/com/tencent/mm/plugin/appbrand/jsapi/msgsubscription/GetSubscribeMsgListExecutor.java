package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.app.Application;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.CheckBox;
import com.tencent.luggage.m.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.ui.d;
import com.tencent.mm.msgsubscription.ui.d.a;
import com.tencent.mm.msgsubscription.ui.f;
import com.tencent.mm.msgsubscription.ui.f.a.a;
import com.tencent.mm.msgsubscription.ui.f.c;
import com.tencent.mm.msgsubscription.ui.f.e;
import com.tencent.mm.msgsubscription.ui.f.f;
import com.tencent.mm.msgsubscription.ui.f.g;
import com.tencent.mm.msgsubscription.ui.f.g.a.a;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "tmplIds", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "appid", "appType", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;)V", "subscribeMsgRequestDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "getSubscribeMsgRequestDialog", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "setSubscribeMsgRequestDialog", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getTmplIds", "()Ljava/util/List;", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "itemsToReportList", "", "", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "items", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "report", "templateItems", "alwaysKeepSelected", "", "userOpType", "indexStr", "clickCountStr", "requestCgi", "toReportMap", "isCheck", "Lkotlin/Function1;", "tryShowForceNotifyGuideBottomSheet", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GetSubscribeMsgListExecutor
  implements ISubscribeMsgCGIExecutor
{
  public static final Parcelable.Creator<GetSubscribeMsgListExecutor> CREATOR;
  public static final GetSubscribeMsgListExecutor.a siT;
  private final int appType;
  private final String appid;
  final List<String> siU;
  a.a siV;
  c siW;
  public f siX;
  final String username;
  
  static
  {
    AppMethodBeat.i(50595);
    siT = new GetSubscribeMsgListExecutor.a((byte)0);
    CREATOR = (Parcelable.Creator)new GetSubscribeMsgListExecutor.b();
    AppMethodBeat.o(50595);
  }
  
  public GetSubscribeMsgListExecutor(Parcel paramParcel) {}
  
  public GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, c paramc, String paramString2, int paramInt)
  {
    this(paramString1, paramList, paramString2, paramInt);
    AppMethodBeat.i(50594);
    this.siW = paramc;
    AppMethodBeat.o(50594);
  }
  
  private GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, String paramString2, int paramInt)
  {
    AppMethodBeat.i(169633);
    this.username = paramString1;
    this.siU = paramList;
    this.appid = paramString2;
    this.appType = paramInt;
    this.siV = ((a.a)a.siO);
    AppMethodBeat.o(169633);
  }
  
  private static final void a(final Context paramContext, final List paramList, final GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, boolean paramBoolean1, boolean paramBoolean2, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult, int paramInt, final Map paramMap)
  {
    AppMethodBeat.i(326330);
    s.u(paramContext, "$context");
    s.u(paramList, "$items");
    s.u(paramGetSubscribeMsgListExecutor, "this$0");
    s.u(paramSubscribeMsgRequestResult, "$result");
    s.u(paramMap, "$detailInfoClickStatic");
    Object localObject = (q)new f(paramGetSubscribeMsgListExecutor, paramSubscribeMsgRequestResult);
    if ((paramContext instanceof Application))
    {
      ((q)localObject).invoke(Integer.valueOf(2), paramList, Boolean.FALSE);
      Log.w("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
      AppMethodBeat.o(326330);
      return;
    }
    paramContext = new f(t.fw(paramContext), paramList, (f.g)new d(paramBoolean2, (q)localObject, paramGetSubscribeMsgListExecutor, paramMap, paramList, paramSubscribeMsgRequestResult, paramContext), paramBoolean1, paramBoolean2);
    s.u(paramContext, "<set-?>");
    paramGetSubscribeMsgListExecutor.siX = paramContext;
    localObject = paramGetSubscribeMsgListExecutor.ctn();
    paramList = paramSubscribeMsgRequestResult.phK;
    paramContext = paramList;
    if (paramList == null) {
      paramContext = "";
    }
    ((f)localObject).setDesc(paramContext);
    localObject = paramGetSubscribeMsgListExecutor.ctn();
    paramList = paramSubscribeMsgRequestResult.phL;
    paramContext = paramList;
    if (paramList == null) {
      paramContext = "";
    }
    ((f)localObject).Rn(paramContext);
    paramGetSubscribeMsgListExecutor.ctn().Rg(paramSubscribeMsgRequestResult.appName);
    localObject = paramGetSubscribeMsgListExecutor.ctn();
    paramContext = paramSubscribeMsgRequestResult.phF;
    if (paramContext == null)
    {
      paramContext = "";
      ((f)localObject).Rh(paramContext);
      paramGetSubscribeMsgListExecutor.ctn().setIconUrl(paramSubscribeMsgRequestResult.phA);
      paramContext = paramGetSubscribeMsgListExecutor.ctn();
      paramList = paramSubscribeMsgRequestResult.phF;
      s.checkNotNull(paramList);
      paramContext.Rk(paramList.pie);
      paramContext = paramGetSubscribeMsgListExecutor.ctn();
      paramList = paramSubscribeMsgRequestResult.phF;
      s.checkNotNull(paramList);
      paramContext.Rl(paramList.pif);
      paramContext = paramGetSubscribeMsgListExecutor.ctn();
      paramList = paramSubscribeMsgRequestResult.phF;
      s.checkNotNull(paramList);
      paramContext.Rm(paramList.pig);
      paramGetSubscribeMsgListExecutor.ctn().plS = a.c.miniprogram_default_avatar;
      if (paramInt != 2) {
        break label427;
      }
      paramContext = paramGetSubscribeMsgListExecutor.ctn();
      paramList = paramSubscribeMsgRequestResult.phF;
      s.checkNotNull(paramList);
      paramContext.Ri(paramList.pih);
    }
    for (;;)
    {
      if (paramBoolean2) {
        paramGetSubscribeMsgListExecutor.ctn().hz(false);
      }
      paramGetSubscribeMsgListExecutor.ctn().plI = ((f.a.a)new e(paramSubscribeMsgRequestResult, paramMap));
      paramContext = paramGetSubscribeMsgListExecutor.siW;
      if (paramContext != null) {
        paramContext.b((n)paramGetSubscribeMsgListExecutor.ctn());
      }
      AppMethodBeat.o(326330);
      return;
      paramList = paramContext.pii;
      paramContext = paramList;
      if (paramList != null) {
        break;
      }
      paramContext = "";
      break;
      label427:
      if (!paramBoolean2)
      {
        paramContext = paramGetSubscribeMsgListExecutor.ctn();
        paramList = paramSubscribeMsgRequestResult.phF;
        s.checkNotNull(paramList);
        paramContext.Rj(paramList.pij);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50591);
    s.u(paramString, "errMsg");
    c localc = this.siW;
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
    }
    AppMethodBeat.o(50591);
  }
  
  public final void a(Context paramContext, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50590);
    s.u(paramContext, "context");
    s.u(paramSubscribeMsgRequestResult, "result");
    if (paramSubscribeMsgRequestResult.phC.size() == 0)
    {
      paramContext = this.siW;
      if (paramContext != null) {
        paramContext.a(this.username, (List)paramSubscribeMsgRequestResult.phC, null);
      }
      AppMethodBeat.o(50590);
      return;
    }
    List localList = (List)new ArrayList();
    Iterator localIterator = paramSubscribeMsgRequestResult.phC.iterator();
    boolean bool1;
    if (localIterator.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator.next();
      if (localSubscribeMsgTmpItem.phY)
      {
        if (localSubscribeMsgTmpItem.pht == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          localList.add(new f.f(bool1, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.phS, localSubscribeMsgTmpItem.nSg, localSubscribeMsgTmpItem.phZ));
          break;
        }
      }
      if (localSubscribeMsgTmpItem.pia)
      {
        if (localSubscribeMsgTmpItem.pht == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          localList.add(new f.e(bool1, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.phS, localSubscribeMsgTmpItem.nSg, localSubscribeMsgTmpItem.pib));
          break;
        }
      }
      if (localSubscribeMsgTmpItem.pht == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        localList.add(new f.c(bool1, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.phS, localSubscribeMsgTmpItem.nSg));
        break;
      }
    }
    if (paramSubscribeMsgRequestResult.phI == 1)
    {
      bool1 = true;
      if (bool1) {
        ((f.c)localList.get(0)).plZ = true;
      }
      if ((localList.size() != 1) || (!(localList.get(0) instanceof f.f))) {
        break label394;
      }
    }
    label394:
    for (boolean bool2 = true;; bool2 = false)
    {
      MMHandlerThread.postToMainThread(new GetSubscribeMsgListExecutor..ExternalSyntheticLambda0(paramContext, localList, this, bool1, bool2, paramSubscribeMsgRequestResult, ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.phC.get(0)).phR, (Map)new LinkedHashMap()));
      AppMethodBeat.o(50590);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final f ctn()
  {
    AppMethodBeat.i(50589);
    f localf = this.siX;
    if (localf != null)
    {
      AppMethodBeat.o(50589);
      return localf;
    }
    s.bIx("subscribeMsgRequestDialog");
    AppMethodBeat.o(50589);
    return null;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50592);
    if (paramParcel != null) {
      paramParcel.writeString(this.username);
    }
    if (paramParcel != null) {
      paramParcel.writeStringList(this.siU);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.appid);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.appType);
    }
    AppMethodBeat.o(50592);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "", "dismissDialog", "", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialogDismissStateListener;", "onNetSceneEndCallback", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void a(n paramn, o paramo);
    
    public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData);
    
    public abstract void b(n paramn);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$dealWithCgiResult$1$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onSwitchChanged", "switch", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener$Companion$SwitchType;", "isOn", "", "item", "userAction", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements f.g
  {
    d(boolean paramBoolean, q<? super Integer, ? super List<f.c>, ? super Boolean, ah> paramq, GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, Map<Integer, Integer> paramMap, List<f.c> paramList, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Context paramContext) {}
    
    public final void a(f.g.a.a parama, boolean paramBoolean1, f.c paramc, boolean paramBoolean2)
    {
      AppMethodBeat.i(326303);
      s.u(parama, "switch");
      s.u(paramc, "item");
      if ((parama == f.g.a.a.pmn) && (paramBoolean1) && (paramBoolean2)) {
        GetSubscribeMsgListExecutor.a(paramGetSubscribeMsgListExecutor, paramContext, paramGetSubscribeMsgListExecutor.ctn());
      }
      AppMethodBeat.o(326303);
    }
    
    public final void r(int paramInt, List<? extends f.c> paramList)
    {
      AppMethodBeat.i(183056);
      s.u(paramList, "resultData");
      List localList = (List)new ArrayList();
      localList.addAll((Collection)paramList);
      switch (paramInt)
      {
      }
      for (;;)
      {
        paramList = p.p((Iterable)paramMap.keySet());
        localList = (List)new ArrayList();
        localObject1 = paramList.iterator();
        int i;
        while (((Iterator)localObject1).hasNext())
        {
          i = ((Number)((Iterator)localObject1).next()).intValue();
          localObject2 = (Integer)paramMap.get(Integer.valueOf(i));
          if (localObject2 != null) {
            localList.add(Integer.valueOf(((Number)localObject2).intValue()));
          }
        }
        if (this.siY)
        {
          if (paramInt == 2) {}
          for (i = 3;; i = paramInt)
          {
            this.siZ.invoke(Integer.valueOf(i), localList, Boolean.valueOf(paramGetSubscribeMsgListExecutor.ctn().plA.isChecked()));
            break;
          }
        }
        this.siZ.invoke(Integer.valueOf(paramInt), localList, Boolean.valueOf(paramGetSubscribeMsgListExecutor.ctn().plA.isChecked()));
      }
      Object localObject1 = paramGetSubscribeMsgListExecutor;
      Object localObject2 = (List)new ArrayList();
      ((List)localObject2).addAll((Collection)paramSubscribeMsgRequestResult.phC);
      ah localah = ah.aiuX;
      localObject2 = GetSubscribeMsgListExecutor.o((List)localObject2, paramList);
      boolean bool = paramGetSubscribeMsgListExecutor.ctn().plA.isChecked();
      switch (paramInt)
      {
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        GetSubscribeMsgListExecutor.a((GetSubscribeMsgListExecutor)localObject1, (List)localObject2, bool, paramInt, p.a((Iterable)paramList, (CharSequence)"#", null, null, 0, null, null, 62), p.a((Iterable)localList, (CharSequence)"#", null, null, 0, null, null, 62));
        AppMethodBeat.o(183056);
        return;
        paramInt = 3;
        continue;
        paramInt = 2;
        continue;
        paramInt = 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$dealWithCgiResult$1$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", "index", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements f.a.a
  {
    e(SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Map<Integer, Integer> paramMap) {}
    
    public final void bj(String paramString, int paramInt)
    {
      AppMethodBeat.i(183057);
      s.u(paramString, "templateId");
      Iterator localIterator = ((Iterable)this.pju.phC).iterator();
      Object localObject;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).nSg, (CharSequence)paramString))
          {
            paramString = (String)localObject;
            if ((SubscribeMsgTmpItem)paramString != null)
            {
              paramString = paramMap;
              localObject = (Integer)paramString.get(Integer.valueOf(paramInt));
              if (localObject != null) {
                break label133;
              }
            }
          }
        }
      }
      label133:
      for (int i = 0;; i = ((Integer)localObject).intValue())
      {
        paramString.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
        AppMethodBeat.o(183057);
        return;
        paramString = null;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "event", "", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "alwaysKeepSelected", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements q<Integer, List<f.c>, Boolean, ah>
  {
    f(GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$tryShowForceNotifyGuideBottomSheet$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialogDismissStateListener;", "onDismiss", "", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements o
  {
    h(GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, d paramd) {}
    
    public final void a(n paramn)
    {
      AppMethodBeat.i(326300);
      paramn = this.sja.siW;
      if (paramn != null) {
        paramn.b((n)this.sjc);
      }
      AppMethodBeat.o(326300);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$tryShowForceNotifyGuideBottomSheet$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgForceNotifyGuideBottomDialog$OnDismissListener;", "onDismiss", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements d.a
  {
    i(GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, f paramf) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(326296);
      GetSubscribeMsgListExecutor.c localc = this.sja.siW;
      if (localc != null) {
        localc.b((n)this.sjd);
      }
      AppMethodBeat.o(326296);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor
 * JD-Core Version:    0.7.0.1
 */