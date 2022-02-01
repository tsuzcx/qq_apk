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
import com.tencent.mm.msgsubscription.ui.b;
import com.tencent.mm.msgsubscription.ui.b.a.a;
import com.tencent.mm.msgsubscription.ui.b.b;
import com.tencent.mm.msgsubscription.ui.b.d;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.a.j;
import d.g.a.q;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "tmplIds", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "appid", "appType", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;)V", "subscribeMsgRequestDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "getSubscribeMsgRequestDialog", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "setSubscribeMsgRequestDialog", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getTmplIds", "()Ljava/util/List;", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "itemsToReportList", "", "", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "items", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "report", "templateItems", "alwaysKeepSelected", "", "userOpType", "indexStr", "clickCountStr", "requestCgi", "toReportMap", "isCheck", "Lkotlin/Function1;", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"})
public final class GetSubscribeMsgListExecutor
  implements ISubscribeMsgCGIExecutor
{
  public static final Parcelable.Creator<GetSubscribeMsgListExecutor> CREATOR;
  public static final GetSubscribeMsgListExecutor.a jZL;
  private final int appType;
  private final String dlB;
  a.a jZH;
  c jZI;
  public b jZJ;
  final List<String> jZK;
  final String username;
  
  static
  {
    AppMethodBeat.i(50595);
    jZL = new GetSubscribeMsgListExecutor.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(50595);
  }
  
  public GetSubscribeMsgListExecutor(Parcel paramParcel) {}
  
  public GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, c paramc, String paramString2, int paramInt)
  {
    this(paramString1, paramList, paramString2, paramInt);
    AppMethodBeat.i(50594);
    this.jZI = paramc;
    AppMethodBeat.o(50594);
  }
  
  private GetSubscribeMsgListExecutor(String paramString1, List<String> paramList, String paramString2, int paramInt)
  {
    AppMethodBeat.i(169633);
    this.username = paramString1;
    this.jZK = paramList;
    this.dlB = paramString2;
    this.appType = paramInt;
    this.jZH = ((a.a)a.jZG);
    AppMethodBeat.o(169633);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(50591);
    d.g.b.k.h(paramString, "errMsg");
    c localc = this.jZI;
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
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramSubscribeMsgRequestResult, "result");
    if (paramSubscribeMsgRequestResult.hGg.size() == 0)
    {
      paramContext = this.jZI;
      if (paramContext != null)
      {
        paramContext.a(this.username, (List)paramSubscribeMsgRequestResult.hGg, null);
        AppMethodBeat.o(50590);
        return;
      }
      AppMethodBeat.o(50590);
      return;
    }
    final List localList = (List)new ArrayList();
    Iterator localIterator = paramSubscribeMsgRequestResult.hGg.iterator();
    if (localIterator.hasNext())
    {
      SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)localIterator.next();
      if (localSubscribeMsgTmpItem.hFZ == 1) {}
      for (bool = true;; bool = false)
      {
        localList.add(new b.b(bool, localSubscribeMsgTmpItem.title, localSubscribeMsgTmpItem.hGv, localSubscribeMsgTmpItem.gIj));
        break;
      }
    }
    if (paramSubscribeMsgRequestResult.hGl == 1) {}
    for (final boolean bool = true;; bool = false)
    {
      if (bool) {
        ((b.b)localList.get(0)).hJN = true;
      }
      final int i = ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.hGg.get(0)).hGu;
      aq.f((Runnable)new d(this, paramSubscribeMsgRequestResult, paramContext, localList, (Map)new LinkedHashMap(), bool, i));
      AppMethodBeat.o(50590);
      return;
    }
  }
  
  public final b baT()
  {
    AppMethodBeat.i(50589);
    b localb = this.jZJ;
    if (localb == null) {
      d.g.b.k.aPZ("subscribeMsgRequestDialog");
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
      paramParcel.writeStringList(this.jZK);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.dlB);
    }
    if (paramParcel != null)
    {
      paramParcel.writeInt(this.appType);
      AppMethodBeat.o(50592);
      return;
    }
    AppMethodBeat.o(50592);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "luggage-wechat-full-sdk_release"})
  public static final class b
    implements Parcelable.Creator<GetSubscribeMsgListExecutor>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
    
    public abstract void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData);
    
    public abstract void b(com.tencent.mm.plugin.appbrand.widget.dialog.k paramk);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(GetSubscribeMsgListExecutor paramGetSubscribeMsgListExecutor, SubscribeMsgRequestResult paramSubscribeMsgRequestResult, Context paramContext, List paramList, Map paramMap, boolean paramBoolean, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(183058);
      Object localObject2 = (q)new a(this);
      if ((paramContext instanceof Application))
      {
        ((q)localObject2).d(Integer.valueOf(2), localList, Boolean.FALSE);
        ad.w("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
        AppMethodBeat.o(183058);
        return;
      }
      Object localObject1 = this.jZM;
      localObject2 = new b(n.kP(paramContext), localList, (b.d)new b.d()
      {
        public final void c(int paramAnonymousInt, List<b.b> paramAnonymousList)
        {
          AppMethodBeat.i(183056);
          d.g.b.k.h(paramAnonymousList, "resultData");
          List localList = (List)new ArrayList();
          localList.addAll((Collection)paramAnonymousList);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            paramAnonymousList = j.m((Iterable)this.jZQ.jZN.keySet());
            localList = (List)new ArrayList();
            localObject1 = paramAnonymousList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              int i = ((Number)((Iterator)localObject1).next()).intValue();
              localObject2 = (Integer)this.jZQ.jZN.get(Integer.valueOf(i));
              if (localObject2 != null) {
                localList.add(Integer.valueOf(((Number)localObject2).intValue()));
              }
            }
            this.jZR.d(Integer.valueOf(paramAnonymousInt), localList, Boolean.valueOf(this.jZQ.jZM.baT().hJp.isChecked()));
          }
          Object localObject1 = this.jZQ.jZM;
          Object localObject2 = (List)new ArrayList();
          ((List)localObject2).addAll((Collection)this.jZQ.hHI.hGg);
          localObject2 = GetSubscribeMsgListExecutor.h((List)localObject2, this.jZQ.hJL);
          boolean bool = this.jZQ.jZM.baT().hJp.isChecked();
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
      d.g.b.k.h(localObject2, "<set-?>");
      ((GetSubscribeMsgListExecutor)localObject1).jZJ = ((b)localObject2);
      label190:
      Object localObject3;
      if (i == 3)
      {
        if (bool) {
          this.jZM.baT().AT(((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.hGg.get(0)).hGt);
        }
      }
      else
      {
        if (i != 2) {
          break label541;
        }
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ((b)localObject1).setDesc(((WordingInfo)localObject2).hGI);
        this.jZM.baT().AP(paramSubscribeMsgRequestResult.appName);
        localObject3 = this.jZM.baT();
        localObject1 = paramSubscribeMsgRequestResult.hGi;
        if (localObject1 != null)
        {
          localObject2 = ((WordingInfo)localObject1).hGG;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        d.g.b.k.h(localObject1, "<set-?>");
        ((b)localObject3).hJw = ((String)localObject1);
        this.jZM.baT().nP(paramSubscribeMsgRequestResult.hGe);
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ((b)localObject1).AQ(((WordingInfo)localObject2).hGC);
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ((b)localObject1).AR(((WordingInfo)localObject2).hGD);
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ((b)localObject1).AS(((WordingInfo)localObject2).hGE);
        this.jZM.baT().hJF = 2131233241;
        if (i != 2) {
          break label651;
        }
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        localObject2 = ((WordingInfo)localObject2).hGF;
        d.g.b.k.h(localObject2, "value");
        ((b)localObject1).hJx = ((String)localObject2);
        ((b)localObject1).hJo.setVisibility(0);
        ((b)localObject1).hJm.setText((CharSequence)((b)localObject1).hJx);
        ((b)localObject1).hJn.setVisibility(8);
      }
      for (;;)
      {
        this.jZM.baT().hJv = ((b.a.a)new b.a.a()
        {
          public final void ar(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(183057);
            d.g.b.k.h(paramAnonymousString, "templateId");
            Iterator localIterator = ((Iterable)this.jZQ.hHI.hGg).iterator();
            Object localObject;
            for (;;)
            {
              if (localIterator.hasNext())
              {
                localObject = localIterator.next();
                if (TextUtils.equals((CharSequence)((SubscribeMsgTmpItem)localObject).gIj, (CharSequence)paramAnonymousString))
                {
                  paramAnonymousString = (String)localObject;
                  if ((SubscribeMsgTmpItem)paramAnonymousString != null)
                  {
                    paramAnonymousString = this.jZQ.jZN;
                    localObject = (Integer)this.jZQ.jZN.get(Integer.valueOf(paramAnonymousInt));
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
        localObject1 = this.jZM.jZI;
        if (localObject1 == null) {
          break label724;
        }
        ((GetSubscribeMsgListExecutor.c)localObject1).b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this.jZM.baT());
        AppMethodBeat.o(183058);
        return;
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ((b)localObject1).AT(((WordingInfo)localObject2).hGL);
        break;
        label541:
        if (bool)
        {
          localObject1 = this.jZM.baT();
          localObject2 = new StringBuilder();
          localObject3 = paramSubscribeMsgRequestResult.hGi;
          if (localObject3 == null) {
            d.g.b.k.fvU();
          }
          ((b)localObject1).setDesc(((WordingInfo)localObject3).hGJ + ((SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.hGg.get(0)).title);
          break label190;
        }
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        ((b)localObject1).setDesc(((WordingInfo)localObject2).hGM);
        break label190;
        label651:
        localObject1 = this.jZM.baT();
        localObject2 = paramSubscribeMsgRequestResult.hGi;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        localObject2 = ((WordingInfo)localObject2).hGH;
        d.g.b.k.h(localObject2, "value");
        ((b)localObject1).hJz = ((String)localObject2);
        ((b)localObject1).hJn.setVisibility(0);
        ((b)localObject1).hJn.setText((CharSequence)((b)localObject1).hJz);
        ((b)localObject1).hJo.setVisibility(8);
      }
      label724:
      AppMethodBeat.o(183058);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "event", "", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "alwaysKeepSelected", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements q<Integer, List<b.b>, Boolean, y>
    {
      a(GetSubscribeMsgListExecutor.d paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor
 * JD-Core Version:    0.7.0.1
 */