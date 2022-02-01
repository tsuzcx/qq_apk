package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.app.Application;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.CheckBox;
import com.tencent.luggage.l.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.ui.c;
import com.tencent.mm.msgsubscription.ui.c.a.a;
import com.tencent.mm.msgsubscription.ui.c.c;
import com.tencent.mm.msgsubscription.ui.c.e;
import com.tencent.mm.msgsubscription.ui.c.f;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "tmplIds", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "appid", "appType", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;)V", "subscribeMsgRequestDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "getSubscribeMsgRequestDialog", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "setSubscribeMsgRequestDialog", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getTmplIds", "()Ljava/util/List;", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "itemsToReportList", "", "", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "items", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "report", "templateItems", "alwaysKeepSelected", "", "userOpType", "indexStr", "clickCountStr", "requestCgi", "toReportMap", "isCheck", "Lkotlin/Function1;", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"})
public final class GetSubscribeMsgListExecutor
  implements ISubscribeMsgCGIExecutor
{
  public static final Parcelable.Creator<GetSubscribeMsgListExecutor> CREATOR;
  public static final GetSubscribeMsgListExecutor.a pdH;
  private final int appType;
  private final String appid;
  a.a pdD;
  c pdE;
  public c pdF;
  final List<String> pdG;
  final String username;
  
  static
  {
    AppMethodBeat.i(50595);
    pdH = new GetSubscribeMsgListExecutor.a((byte)0);
    CREATOR = (Parcelable.Creator)new GetSubscribeMsgListExecutor.b();
    AppMethodBeat.o(50595);
  }
  
  public GetSubscribeMsgListExecutor(Parcel paramParcel) {}
  
  public GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, c paramc, String paramString2, int paramInt)
  {
    this(paramString1, paramList, paramString2, paramInt);
    AppMethodBeat.i(50594);
    this.pdE = paramc;
    AppMethodBeat.o(50594);
  }
  
  private GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, String paramString2, int paramInt)
  {
    AppMethodBeat.i(169633);
    this.username = paramString1;
    this.pdG = paramList;
    this.appid = paramString2;
    this.appType = paramInt;
    this.pdD = ((a.a)a.pdC);
    AppMethodBeat.o(169633);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50591);
    p.k(paramString, "errMsg");
    c localc = this.pdE;
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
    final boolean bool2 = true;
    AppMethodBeat.i(50590);
    p.k(paramContext, "context");
    p.k(paramSubscribeMsgRequestResult, "result");
    if (paramSubscribeMsgRequestResult.mnO.size() == 0)
    {
      paramContext = this.pdE;
      if (paramContext != null)
      {
        paramContext.a(this.username, (List)paramSubscribeMsgRequestResult.mnO, null);
        AppMethodBeat.o(50590);
        return;
      }
      AppMethodBeat.o(50590);
      return;
    }
    final List localList = (List)new ArrayList();
    Iterator localIterator = paramSubscribeMsgRequestResult.mnO.iterator();
    final boolean bool1;
    if (localIterator.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator.next();
      if (localSubscribeMsgTmpItem.mok)
      {
        if (localSubscribeMsgTmpItem.mnG == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          localList.add(new c.e(bool1, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.moe, localSubscribeMsgTmpItem.lnb, localSubscribeMsgTmpItem.mol));
          break;
        }
      }
      if (localSubscribeMsgTmpItem.mnG == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        localList.add(new c.c(bool1, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.moe, localSubscribeMsgTmpItem.lnb));
        break;
      }
    }
    if (paramSubscribeMsgRequestResult.mnU == 1)
    {
      bool1 = true;
      if (bool1) {
        ((c.c)localList.get(0)).msB = true;
      }
      if ((localList.size() != 1) || (!(localList.get(0) instanceof c.e))) {
        break label353;
      }
    }
    for (;;)
    {
      final int i = ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.mnO.get(0)).mod;
      MMHandlerThread.postToMainThread((Runnable)new d(this, paramSubscribeMsgRequestResult, paramContext, localList, (Map)new LinkedHashMap(), bool1, bool2, i));
      AppMethodBeat.o(50590);
      return;
      bool1 = false;
      break;
      label353:
      bool2 = false;
    }
  }
  
  public final c bTh()
  {
    AppMethodBeat.i(50589);
    c localc = this.pdF;
    if (localc == null) {
      p.bGy("subscribeMsgRequestDialog");
    }
    AppMethodBeat.o(50589);
    return localc;
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
      paramParcel.writeStringList(this.pdG);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.appid);
    }
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.appType);
      AppMethodBeat.o(50592);
      return;
    }
    AppMethodBeat.o(50592);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void a(com.tencent.mm.plugin.appbrand.widget.dialog.j paramj);
    
    public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Context paramContext, List paramList, Map paramMap, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(183058);
      Object localObject2 = (kotlin.g.a.q)new a(this);
      if ((paramContext instanceof Application))
      {
        ((kotlin.g.a.q)localObject2).c(Integer.valueOf(2), localList, Boolean.FALSE);
        Log.w("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
        AppMethodBeat.o(183058);
        return;
      }
      Object localObject1 = this.pdI;
      localObject2 = new c(m.eA(paramContext), localList, (c.f)new c.f()
      {
        public final void c(int paramAnonymousInt, List<? extends c.c> paramAnonymousList)
        {
          AppMethodBeat.i(183056);
          p.k(paramAnonymousList, "resultData");
          List localList = (List)new ArrayList();
          localList.addAll((Collection)paramAnonymousList);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            paramAnonymousList = kotlin.a.j.p((Iterable)this.pdM.pdJ.keySet());
            localList = (List)new ArrayList();
            localObject1 = paramAnonymousList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              int i = ((Number)((Iterator)localObject1).next()).intValue();
              localObject2 = (Integer)this.pdM.pdJ.get(Integer.valueOf(i));
              if (localObject2 != null) {
                localList.add(Integer.valueOf(((Number)localObject2).intValue()));
              }
            }
            this.pdN.c(Integer.valueOf(paramAnonymousInt), localList, Boolean.valueOf(this.pdM.pdI.bTh().mrV.isChecked()));
          }
          Object localObject1 = this.pdM.pdI;
          Object localObject2 = (List)new ArrayList();
          ((List)localObject2).addAll((Collection)this.pdM.mpI.mnO);
          localObject2 = GetSubscribeMsgListExecutor.k((List)localObject2, this.pdM.mpK);
          boolean bool = this.pdM.pdI.bTh().mrV.isChecked();
          switch (paramAnonymousInt)
          {
          default: 
            paramAnonymousInt = 0;
          }
          for (;;)
          {
            GetSubscribeMsgListExecutor.a((GetSubscribeMsgListExecutor)localObject1, (List)localObject2, bool, paramAnonymousInt, kotlin.a.j.a((Iterable)paramAnonymousList, (CharSequence)"#", null, null, 0, null, null, 62), kotlin.a.j.a((Iterable)localList, (CharSequence)"#", null, null, 0, null, null, 62));
            AppMethodBeat.o(183056);
            return;
            paramAnonymousInt = 3;
            continue;
            paramAnonymousInt = 2;
            continue;
            paramAnonymousInt = 1;
          }
        }
      }, bool1, bool2);
      p.k(localObject2, "<set-?>");
      ((GetSubscribeMsgListExecutor)localObject1).pdF = ((c)localObject2);
      c localc = this.pdI.bTh();
      localObject2 = paramSubscribeMsgRequestResult.mnW;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localc.setDesc((String)localObject1);
      localc = this.pdI.bTh();
      localObject2 = paramSubscribeMsgRequestResult.mnX;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localc.Zj((String)localObject1);
      this.pdI.bTh().Zc(paramSubscribeMsgRequestResult.appName);
      localc = this.pdI.bTh();
      localObject1 = paramSubscribeMsgRequestResult.mnR;
      if (localObject1 != null)
      {
        localObject2 = ((WordingInfo)localObject1).mor;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localc.Zd((String)localObject1);
      this.pdI.bTh().setIconUrl(paramSubscribeMsgRequestResult.mnM);
      localObject1 = this.pdI.bTh();
      localObject2 = paramSubscribeMsgRequestResult.mnR;
      if (localObject2 == null) {
        p.iCn();
      }
      ((c)localObject1).Zg(((WordingInfo)localObject2).mon);
      localObject1 = this.pdI.bTh();
      localObject2 = paramSubscribeMsgRequestResult.mnR;
      if (localObject2 == null) {
        p.iCn();
      }
      ((c)localObject1).Zh(((WordingInfo)localObject2).moo);
      localObject1 = this.pdI.bTh();
      localObject2 = paramSubscribeMsgRequestResult.mnR;
      if (localObject2 == null) {
        p.iCn();
      }
      ((c)localObject1).Zi(((WordingInfo)localObject2).mop);
      this.pdI.bTh().mso = a.c.miniprogram_default_avatar;
      if (i == 2)
      {
        localObject1 = this.pdI.bTh();
        localObject2 = paramSubscribeMsgRequestResult.mnR;
        if (localObject2 == null) {
          p.iCn();
        }
        ((c)localObject1).Ze(((WordingInfo)localObject2).moq);
      }
      for (;;)
      {
        this.pdI.bTh().msd = ((c.a.a)new c.a.a()
        {
          public final void aV(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(183057);
            p.k(paramAnonymousString, "templateId");
            Iterator localIterator = ((Iterable)this.pdM.mpI.mnO).iterator();
            Object localObject;
            for (;;)
            {
              if (localIterator.hasNext())
              {
                localObject = localIterator.next();
                if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).lnb, (CharSequence)paramAnonymousString))
                {
                  paramAnonymousString = (String)localObject;
                  if ((SubscribeMsgTmpItem)paramAnonymousString != null)
                  {
                    paramAnonymousString = this.pdM.pdJ;
                    localObject = (Integer)this.pdM.pdJ.get(Integer.valueOf(paramAnonymousInt));
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
        localObject1 = this.pdI.pdE;
        if (localObject1 == null) {
          break;
        }
        ((GetSubscribeMsgListExecutor.c)localObject1).a((com.tencent.mm.plugin.appbrand.widget.dialog.j)this.pdI.bTh());
        AppMethodBeat.o(183058);
        return;
        localObject1 = this.pdI.bTh();
        localObject2 = paramSubscribeMsgRequestResult.mnR;
        if (localObject2 == null) {
          p.iCn();
        }
        ((c)localObject1).Zf(((WordingInfo)localObject2).mos);
      }
      AppMethodBeat.o(183058);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "event", "", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "alwaysKeepSelected", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Integer, List<c.c>, Boolean, x>
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