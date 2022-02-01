package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.app.Application;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.ui.b;
import com.tencent.mm.msgsubscription.ui.b.a.a;
import com.tencent.mm.msgsubscription.ui.b.b;
import com.tencent.mm.msgsubscription.ui.b.d;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "tmplIds", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "appid", "appType", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;)V", "subscribeMsgRequestDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "getSubscribeMsgRequestDialog", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "setSubscribeMsgRequestDialog", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getTmplIds", "()Ljava/util/List;", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "itemsToReportList", "", "", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "items", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "report", "templateItems", "alwaysKeepSelected", "", "userOpType", "indexStr", "clickCountStr", "requestCgi", "toReportMap", "isCheck", "Lkotlin/Function1;", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"})
public final class GetSubscribeMsgListExecutor
  implements ISubscribeMsgCGIExecutor
{
  public static final Parcelable.Creator<GetSubscribeMsgListExecutor> CREATOR;
  public static final GetSubscribeMsgListExecutor.a mfB;
  private final int appType;
  private final String dNI;
  final List<String> mfA;
  a.a mfx;
  c mfy;
  public b mfz;
  final String username;
  
  static
  {
    AppMethodBeat.i(50595);
    mfB = new GetSubscribeMsgListExecutor.a((byte)0);
    CREATOR = (Parcelable.Creator)new GetSubscribeMsgListExecutor.b();
    AppMethodBeat.o(50595);
  }
  
  public GetSubscribeMsgListExecutor(Parcel paramParcel) {}
  
  public GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, c paramc, String paramString2, int paramInt)
  {
    this(paramString1, paramList, paramString2, paramInt);
    AppMethodBeat.i(50594);
    this.mfy = paramc;
    AppMethodBeat.o(50594);
  }
  
  private GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, String paramString2, int paramInt)
  {
    AppMethodBeat.i(169633);
    this.username = paramString1;
    this.mfA = paramList;
    this.dNI = paramString2;
    this.appType = paramInt;
    this.mfx = ((a.a)a.mfw);
    AppMethodBeat.o(169633);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50591);
    p.h(paramString, "errMsg");
    c localc = this.mfy;
    if (localc != null)
    {
      localc.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
      AppMethodBeat.o(50591);
      return;
    }
    AppMethodBeat.o(50591);
  }
  
  public final void a(final Context paramContext, final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50590);
    p.h(paramContext, "context");
    p.h(paramSubscribeMsgRequestResult, "result");
    if (paramSubscribeMsgRequestResult.jyk.size() == 0)
    {
      paramContext = this.mfy;
      if (paramContext != null)
      {
        paramContext.a(this.username, (List)paramSubscribeMsgRequestResult.jyk, null);
        AppMethodBeat.o(50590);
        return;
      }
      AppMethodBeat.o(50590);
      return;
    }
    final List localList = (List)new ArrayList();
    Iterator localIterator = paramSubscribeMsgRequestResult.jyk.iterator();
    if (localIterator.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator.next();
      if (localSubscribeMsgTmpItem.jyd == 1) {}
      for (bool = true;; bool = false)
      {
        localList.add(new b.b(bool, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.jyA, localSubscribeMsgTmpItem.ixM));
        break;
      }
    }
    if (paramSubscribeMsgRequestResult.jyq == 1) {}
    for (final boolean bool = true;; bool = false)
    {
      if (bool) {
        ((b.b)localList.get(0)).jCx = true;
      }
      final int i = ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.jyk.get(0)).jyz;
      MMHandlerThread.postToMainThread((Runnable)new d(this, paramSubscribeMsgRequestResult, paramContext, localList, (Map)new LinkedHashMap(), bool, i));
      AppMethodBeat.o(50590);
      return;
    }
  }
  
  public final b bHz()
  {
    AppMethodBeat.i(50589);
    b localb = this.mfz;
    if (localb == null) {
      p.btv("subscribeMsgRequestDialog");
    }
    AppMethodBeat.o(50589);
    return localb;
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
      paramParcel.writeStringList(this.mfA);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.dNI);
    }
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.appType);
      AppMethodBeat.o(50592);
      return;
    }
    AppMethodBeat.o(50592);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData);
    
    public abstract void b(k paramk);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Context paramContext, List paramList, Map paramMap, boolean paramBoolean, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(183058);
      Object localObject2 = (kotlin.g.a.q)new a(this);
      if ((paramContext instanceof Application))
      {
        ((kotlin.g.a.q)localObject2).d(Integer.valueOf(2), localList, Boolean.FALSE);
        Log.w("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
        AppMethodBeat.o(183058);
        return;
      }
      Object localObject1 = this.mfC;
      localObject2 = new b(n.eA(paramContext), localList, (b.d)new b.d()
      {
        public final void c(int paramAnonymousInt, List<b.b> paramAnonymousList)
        {
          AppMethodBeat.i(183056);
          p.h(paramAnonymousList, "resultData");
          List localList = (List)new ArrayList();
          localList.addAll((Collection)paramAnonymousList);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            paramAnonymousList = j.p((Iterable)this.mfF.mfD.keySet());
            localList = (List)new ArrayList();
            localObject1 = paramAnonymousList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              int i = ((Number)((Iterator)localObject1).next()).intValue();
              localObject2 = (Integer)this.mfF.mfD.get(Integer.valueOf(i));
              if (localObject2 != null) {
                localList.add(Integer.valueOf(((Number)localObject2).intValue()));
              }
            }
            this.mfG.d(Integer.valueOf(paramAnonymousInt), localList, Boolean.valueOf(this.mfF.mfC.bHz().jCa.isChecked()));
          }
          Object localObject1 = this.mfF.mfC;
          Object localObject2 = (List)new ArrayList();
          ((List)localObject2).addAll((Collection)this.mfF.jAc.jyk);
          localObject2 = GetSubscribeMsgListExecutor.i((List)localObject2, this.mfF.jAe);
          boolean bool = this.mfF.mfC.bHz().jCa.isChecked();
          switch (paramAnonymousInt)
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            GetSubscribeMsgListExecutor.a((GetSubscribeMsgListExecutor)localObject1, (List)localObject2, bool, paramAnonymousInt, j.a((Iterable)paramAnonymousList, (CharSequence)"#", null, null, 0, null, null, 62), j.a((Iterable)localList, (CharSequence)"#", null, null, 0, null, null, 62));
            AppMethodBeat.o(183056);
            return;
            paramAnonymousInt = 3;
            continue;
            paramAnonymousInt = 2;
            continue;
            paramAnonymousInt = 1;
          }
        }
      }, bool);
      p.h(localObject2, "<set-?>");
      ((GetSubscribeMsgListExecutor)localObject1).mfz = ((b)localObject2);
      label190:
      Object localObject3;
      if (i == 3)
      {
        if (bool) {
          this.mfC.bHz().RK(((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.jyk.get(0)).jyy);
        }
      }
      else
      {
        if (i != 2) {
          break label496;
        }
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).setDesc(((WordingInfo)localObject2).jyN);
        this.mfC.bHz().RD(paramSubscribeMsgRequestResult.appName);
        localObject3 = this.mfC.bHz();
        localObject1 = paramSubscribeMsgRequestResult.jyn;
        if (localObject1 != null)
        {
          localObject2 = ((WordingInfo)localObject1).jyL;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        ((b)localObject3).RE((String)localObject1);
        this.mfC.bHz().setIconUrl(paramSubscribeMsgRequestResult.jyi);
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).RH(((WordingInfo)localObject2).jyH);
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).RI(((WordingInfo)localObject2).jyI);
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).RJ(((WordingInfo)localObject2).jyJ);
        this.mfC.bHz().jCq = 2131233911;
        if (i != 2) {
          break label606;
        }
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).RF(((WordingInfo)localObject2).jyK);
      }
      for (;;)
      {
        this.mfC.bHz().jCg = ((b.a.a)new b.a.a()
        {
          public final void aC(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(183057);
            p.h(paramAnonymousString, "templateId");
            Iterator localIterator = ((Iterable)this.mfF.jAc.jyk).iterator();
            Object localObject;
            for (;;)
            {
              if (localIterator.hasNext())
              {
                localObject = localIterator.next();
                if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).ixM, (CharSequence)paramAnonymousString))
                {
                  paramAnonymousString = (String)localObject;
                  if ((SubscribeMsgTmpItem)paramAnonymousString != null)
                  {
                    paramAnonymousString = this.mfF.mfD;
                    localObject = (Integer)this.mfF.mfD.get(Integer.valueOf(paramAnonymousInt));
                    if (localObject == null) {
                      break label149;
                    }
                  }
                }
              }
            }
            label149:
            for (int i = ((Integer)localObject).intValue();; i = 0)
            {
              paramAnonymousString.put(Integer.valueOf(paramAnonymousInt), Integer.valueOf(i + 1));
              AppMethodBeat.o(183057);
              return;
              paramAnonymousString = null;
              break;
            }
          }
        });
        localObject1 = this.mfC.mfy;
        if (localObject1 == null) {
          break label640;
        }
        ((GetSubscribeMsgListExecutor.c)localObject1).b((k)this.mfC.bHz());
        AppMethodBeat.o(183058);
        return;
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).RK(((WordingInfo)localObject2).jyQ);
        break;
        label496:
        if (bool)
        {
          localObject1 = this.mfC.bHz();
          localObject2 = new StringBuilder();
          localObject3 = paramSubscribeMsgRequestResult.jyn;
          if (localObject3 == null) {
            p.hyc();
          }
          ((b)localObject1).setDesc(((WordingInfo)localObject3).jyO + ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.jyk.get(0)).title);
          break label190;
        }
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).setDesc(((WordingInfo)localObject2).jyR);
        break label190;
        label606:
        localObject1 = this.mfC.bHz();
        localObject2 = paramSubscribeMsgRequestResult.jyn;
        if (localObject2 == null) {
          p.hyc();
        }
        ((b)localObject1).RG(((WordingInfo)localObject2).jyM);
      }
      label640:
      AppMethodBeat.o(183058);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "event", "", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "alwaysKeepSelected", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Integer, List<b.b>, Boolean, x>
    {
      a(GetSubscribeMsgListExecutor.d paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor
 * JD-Core Version:    0.7.0.1
 */