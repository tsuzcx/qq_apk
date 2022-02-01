package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.app.Application;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.ui.b.a.a;
import com.tencent.mm.msgsubscription.ui.b.b;
import com.tencent.mm.msgsubscription.ui.b.d;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.a.j;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "tmplIds", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "appid", "appType", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;)V", "subscribeMsgRequestDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "getSubscribeMsgRequestDialog", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "setSubscribeMsgRequestDialog", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getTmplIds", "()Ljava/util/List;", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "itemsToReportList", "", "", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "items", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "report", "templateItems", "alwaysKeepSelected", "", "userOpType", "indexStr", "clickCountStr", "requestCgi", "toReportMap", "isCheck", "Lkotlin/Function1;", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"})
public final class GetSubscribeMsgListExecutor
  implements ISubscribeMsgCGIExecutor
{
  public static final Parcelable.Creator<GetSubscribeMsgListExecutor> CREATOR;
  public static final a kWG;
  private final int appType;
  private final String duW;
  a.a kWC;
  c kWD;
  public com.tencent.mm.msgsubscription.ui.b kWE;
  final List<String> kWF;
  final String username;
  
  static
  {
    AppMethodBeat.i(50595);
    kWG = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(50595);
  }
  
  public GetSubscribeMsgListExecutor(Parcel paramParcel) {}
  
  public GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, c paramc, String paramString2, int paramInt)
  {
    this(paramString1, paramList, paramString2, paramInt);
    AppMethodBeat.i(50594);
    this.kWD = paramc;
    AppMethodBeat.o(50594);
  }
  
  private GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, String paramString2, int paramInt)
  {
    AppMethodBeat.i(169633);
    this.username = paramString1;
    this.kWF = paramList;
    this.duW = paramString2;
    this.appType = paramInt;
    this.kWC = ((a.a)a.kWB);
    AppMethodBeat.o(169633);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50591);
    p.h(paramString, "errMsg");
    c localc = this.kWD;
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
    if (paramSubscribeMsgRequestResult.iAc.size() == 0)
    {
      paramContext = this.kWD;
      if (paramContext != null)
      {
        paramContext.a(this.username, (List)paramSubscribeMsgRequestResult.iAc, null);
        AppMethodBeat.o(50590);
        return;
      }
      AppMethodBeat.o(50590);
      return;
    }
    final List localList = (List)new ArrayList();
    Iterator localIterator = paramSubscribeMsgRequestResult.iAc.iterator();
    if (localIterator.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator.next();
      if (localSubscribeMsgTmpItem.izV == 1) {}
      for (bool = true;; bool = false)
      {
        localList.add(new b.b(bool, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.iAr, localSubscribeMsgTmpItem.hAT));
        break;
      }
    }
    if (paramSubscribeMsgRequestResult.iAh == 1) {}
    for (final boolean bool = true;; bool = false)
    {
      if (bool) {
        ((b.b)localList.get(0)).iDC = true;
      }
      final int i = ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.iAc.get(0)).iAq;
      aq.f((Runnable)new d(this, paramSubscribeMsgRequestResult, paramContext, localList, (Map)new LinkedHashMap(), bool, i));
      AppMethodBeat.o(50590);
      return;
    }
  }
  
  public final com.tencent.mm.msgsubscription.ui.b bls()
  {
    AppMethodBeat.i(50589);
    com.tencent.mm.msgsubscription.ui.b localb = this.kWE;
    if (localb == null) {
      p.bcb("subscribeMsgRequestDialog");
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
      paramParcel.writeStringList(this.kWF);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.duW);
    }
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.appType);
      AppMethodBeat.o(50592);
      return;
    }
    AppMethodBeat.o(50592);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "TAG", "", "luggage-wechat-full-sdk_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "luggage-wechat-full-sdk_release"})
  public static final class b
    implements Parcelable.Creator<GetSubscribeMsgListExecutor>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData);
    
    public abstract void b(k paramk);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Context paramContext, List paramList, Map paramMap, boolean paramBoolean, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(183058);
      Object localObject2 = (d.g.a.q)new a(this);
      if ((paramContext instanceof Application))
      {
        ((d.g.a.q)localObject2).d(Integer.valueOf(2), localList, Boolean.FALSE);
        ad.w("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
        AppMethodBeat.o(183058);
        return;
      }
      Object localObject1 = this.kWH;
      localObject2 = new com.tencent.mm.msgsubscription.ui.b(n.bq(paramContext), localList, (b.d)new b.d()
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
            paramAnonymousList = j.l((Iterable)this.kWL.kWI.keySet());
            localList = (List)new ArrayList();
            localObject1 = paramAnonymousList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              int i = ((Number)((Iterator)localObject1).next()).intValue();
              localObject2 = (Integer)this.kWL.kWI.get(Integer.valueOf(i));
              if (localObject2 != null) {
                localList.add(Integer.valueOf(((Number)localObject2).intValue()));
              }
            }
            this.kWM.d(Integer.valueOf(paramAnonymousInt), localList, Boolean.valueOf(this.kWL.kWH.bls().iDe.isChecked()));
          }
          Object localObject1 = this.kWL.kWH;
          Object localObject2 = (List)new ArrayList();
          ((List)localObject2).addAll((Collection)this.kWL.iBE.iAc);
          localObject2 = GetSubscribeMsgListExecutor.h((List)localObject2, this.kWL.iDA);
          boolean bool = this.kWL.kWH.bls().iDe.isChecked();
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
      ((GetSubscribeMsgListExecutor)localObject1).kWE = ((com.tencent.mm.msgsubscription.ui.b)localObject2);
      label190:
      Object localObject3;
      if (i == 3)
      {
        if (bool) {
          this.kWH.bls().Im(((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.iAc.get(0)).iAp);
        }
      }
      else
      {
        if (i != 2) {
          break label541;
        }
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).setDesc(((WordingInfo)localObject2).iAE);
        this.kWH.bls().Ii(paramSubscribeMsgRequestResult.appName);
        localObject3 = this.kWH.bls();
        localObject1 = paramSubscribeMsgRequestResult.iAe;
        if (localObject1 != null)
        {
          localObject2 = ((WordingInfo)localObject1).iAC;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        p.h(localObject1, "<set-?>");
        ((com.tencent.mm.msgsubscription.ui.b)localObject3).iDl = ((String)localObject1);
        this.kWH.bls().setIconUrl(paramSubscribeMsgRequestResult.iAa);
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).Ij(((WordingInfo)localObject2).iAy);
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).Ik(((WordingInfo)localObject2).iAz);
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).Il(((WordingInfo)localObject2).iAA);
        this.kWH.bls().iDu = 2131233241;
        if (i != 2) {
          break label651;
        }
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        localObject2 = ((WordingInfo)localObject2).iAB;
        p.h(localObject2, "value");
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDm = ((String)localObject2);
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDd.setVisibility(0);
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDb.setText((CharSequence)((com.tencent.mm.msgsubscription.ui.b)localObject1).iDm);
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDc.setVisibility(8);
      }
      for (;;)
      {
        this.kWH.bls().iDk = ((b.a.a)new b.a.a()
        {
          public final void ax(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(183057);
            p.h(paramAnonymousString, "templateId");
            Iterator localIterator = ((Iterable)this.kWL.iBE.iAc).iterator();
            Object localObject;
            for (;;)
            {
              if (localIterator.hasNext())
              {
                localObject = localIterator.next();
                if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).hAT, (CharSequence)paramAnonymousString))
                {
                  paramAnonymousString = (String)localObject;
                  if ((SubscribeMsgTmpItem)paramAnonymousString != null)
                  {
                    paramAnonymousString = this.kWL.kWI;
                    localObject = (Integer)this.kWL.kWI.get(Integer.valueOf(paramAnonymousInt));
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
        localObject1 = this.kWH.kWD;
        if (localObject1 == null) {
          break label724;
        }
        ((GetSubscribeMsgListExecutor.c)localObject1).b((k)this.kWH.bls());
        AppMethodBeat.o(183058);
        return;
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).Im(((WordingInfo)localObject2).iAH);
        break;
        label541:
        if (bool)
        {
          localObject1 = this.kWH.bls();
          localObject2 = new StringBuilder();
          localObject3 = paramSubscribeMsgRequestResult.iAe;
          if (localObject3 == null) {
            p.gfZ();
          }
          ((com.tencent.mm.msgsubscription.ui.b)localObject1).setDesc(((WordingInfo)localObject3).iAF + ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.iAc.get(0)).title);
          break label190;
        }
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).setDesc(((WordingInfo)localObject2).iAI);
        break label190;
        label651:
        localObject1 = this.kWH.bls();
        localObject2 = paramSubscribeMsgRequestResult.iAe;
        if (localObject2 == null) {
          p.gfZ();
        }
        localObject2 = ((WordingInfo)localObject2).iAD;
        p.h(localObject2, "value");
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDo = ((String)localObject2);
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDc.setVisibility(0);
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDc.setText((CharSequence)((com.tencent.mm.msgsubscription.ui.b)localObject1).iDo);
        ((com.tencent.mm.msgsubscription.ui.b)localObject1).iDd.setVisibility(8);
      }
      label724:
      AppMethodBeat.o(183058);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "", "event", "", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "alwaysKeepSelected", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.q<Integer, List<b.b>, Boolean, z>
    {
      a(GetSubscribeMsgListExecutor.d paramd)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<SubscribeMsgTmpItem, Boolean>
  {
    e(List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor
 * JD-Core Version:    0.7.0.1
 */