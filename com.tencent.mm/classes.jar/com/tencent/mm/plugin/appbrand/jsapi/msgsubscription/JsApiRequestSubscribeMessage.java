package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.util.CompatProcessTask;
import com.tencent.mm.msgsubscription.util.CompatProcessTask.a;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.aa;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "SubscribeMsgTask", "luggage-wechat-full-sdk_release"})
public final class JsApiRequestSubscribeMessage
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.luggage.sdk.b.a.c.c>
{
  public static final int CTRL_INDEX = 640;
  public static final String NAME = "requestSubscribeMessage";
  public static final a jZS;
  
  static
  {
    AppMethodBeat.i(50620);
    jZS = new a((byte)0);
    AppMethodBeat.o(50620);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "username", "", "appid", "appType", "", "tmplIds", "", "type", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callbackId", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;I)V", "Ljava/lang/Integer;", "getSubscribeMsgListExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "getGetSubscribeMsgListExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "setGetSubscribeMsgListExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;)V", "isCgiRequestSuccess", "", "()Z", "setCgiRequestSuccess", "(Z)V", "requestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "getRequestResult", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "setRequestResult", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;)V", "subscribeMsgExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "getSubscribeMsgExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "setSubscribeMsgExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;)V", "callbackJsApi", "", "status", "retMap", "", "", "errorCode", "createGetSubscribeMsgListListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "createSubscribeMsgListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "describeContents", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "result", "parseFromParcel", "p", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "Companion", "luggage-wechat-full-sdk_release"})
  static final class SubscribeMsgTask
    extends CompatProcessTask
    implements b.c
  {
    public static final Parcelable.Creator<SubscribeMsgTask> CREATOR;
    public static final JsApiRequestSubscribeMessage.SubscribeMsgTask.a kaa;
    SubscribeMsgRequestResult jZT;
    private com.tencent.luggage.sdk.b.a.c.c jZU;
    private Integer jZV;
    private JsApiRequestSubscribeMessage jZW;
    private GetSubscribeMsgListExecutor jZX;
    SubscribeMsgExecutor jZY;
    private boolean jZZ;
    private int type;
    private String username;
    
    static
    {
      AppMethodBeat.i(50617);
      kaa = new JsApiRequestSubscribeMessage.SubscribeMsgTask.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50617);
    }
    
    public SubscribeMsgTask(Parcel paramParcel)
    {
      this(str1, paramParcel.readInt());
      AppMethodBeat.i(50616);
      this.jZT = ((SubscribeMsgRequestResult)paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader()));
      this.jZX = ((GetSubscribeMsgListExecutor)paramParcel.readParcelable(GetSubscribeMsgListExecutor.class.getClassLoader()));
      this.jZY = ((SubscribeMsgExecutor)paramParcel.readParcelable(SubscribeMsgExecutor.class.getClassLoader()));
      paramParcel = this.jZX;
      if (paramParcel == null) {
        d.g.b.k.fvU();
      }
      if (this.jZX == null) {
        d.g.b.k.fvU();
      }
      paramParcel.jZI = baV();
      paramParcel = this.jZY;
      if (paramParcel == null) {
        d.g.b.k.fvU();
      }
      paramParcel.kac = baU();
      AppMethodBeat.o(50616);
    }
    
    private SubscribeMsgTask(String paramString, int paramInt)
    {
      AppMethodBeat.i(50614);
      this.username = paramString;
      this.type = paramInt;
      this.jZZ = true;
      AppMethodBeat.o(50614);
    }
    
    public SubscribeMsgTask(String paramString1, String paramString2, int paramInt1, List<String> paramList, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, com.tencent.luggage.sdk.b.a.c.c paramc, int paramInt2)
    {
      this(paramString1, 0);
      AppMethodBeat.i(50615);
      this.jZW = paramJsApiRequestSubscribeMessage;
      this.jZU = paramc;
      this.jZV = Integer.valueOf(paramInt2);
      paramJsApiRequestSubscribeMessage = a.jZG;
      a.cW(paramString1, paramString2);
      paramString2 = new GetSubscribeMsgListExecutor(paramString1, paramList, baV(), paramString2, paramInt1);
      paramList = (a.a)a.jZG;
      d.g.b.k.h(paramList, "<set-?>");
      paramString2.jZH = paramList;
      this.jZX = paramString2;
      paramString1 = new SubscribeMsgExecutor(paramString1, baU());
      paramString2 = (a.a)a.jZG;
      d.g.b.k.h(paramString2, "<set-?>");
      paramString1.jZH = paramString2;
      this.jZY = paramString1;
      AppMethodBeat.o(50615);
    }
    
    private final void a(String paramString, Map<String, ? extends Object> paramMap, int paramInt)
    {
      AppMethodBeat.i(50607);
      Object localObject = JsApiRequestSubscribeMessage.jZS;
      localObject = this.jZU;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      JsApiRequestSubscribeMessage localJsApiRequestSubscribeMessage = this.jZW;
      if (localJsApiRequestSubscribeMessage == null) {
        d.g.b.k.fvU();
      }
      Integer localInteger = this.jZV;
      if (localInteger == null) {
        d.g.b.k.fvU();
      }
      JsApiRequestSubscribeMessage.a.a((com.tencent.luggage.sdk.b.a.c.c)localObject, localJsApiRequestSubscribeMessage, localInteger.intValue(), paramString, paramMap, paramInt);
      AppMethodBeat.o(50607);
    }
    
    private final SubscribeMsgExecutor.c baU()
    {
      AppMethodBeat.i(50605);
      SubscribeMsgExecutor.c localc = (SubscribeMsgExecutor.c)new d(this);
      AppMethodBeat.o(50605);
      return localc;
    }
    
    private final GetSubscribeMsgListExecutor.c baV()
    {
      AppMethodBeat.i(50606);
      GetSubscribeMsgListExecutor.c localc = (GetSubscribeMsgListExecutor.c)new c(this);
      AppMethodBeat.o(50606);
      return localc;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(50609);
      d.g.b.k.h(paramString, "errMsg");
      ad.i("JsApiRequestSubscribeMessage", "onNetSceneEndCallback errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " result" + paramSubscribeMsgRequestResult);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.jZZ = bool;
        this.jZT = paramSubscribeMsgRequestResult;
        h.Iye.f((Runnable)new CompatProcessTask.a(this), "CompatProcessTask_" + aEB());
        AppMethodBeat.o(50609);
        return;
      }
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(50611);
      Object localObject4;
      Object localObject5;
      try
      {
        if ((!this.jZZ) || (this.jZT == null))
        {
          if (this.type == 0)
          {
            a(this, "fail:Request list fail", 10002, 2);
            return;
          }
          a(this, "fail:Request subscribe fail", 10003, 2);
          return;
        }
        if (this.type == 0)
        {
          localObject1 = this.jZT;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          if (((SubscribeMsgRequestResult)localObject1).hGp != 0)
          {
            localObject1 = new StringBuilder("fail:");
            localObject4 = this.jZT;
            if (localObject4 == null) {
              d.g.b.k.fvU();
            }
            localObject1 = ((SubscribeMsgRequestResult)localObject4).hGq;
            localObject4 = this.jZT;
            if (localObject4 == null) {
              d.g.b.k.fvU();
            }
            a(this, (String)localObject1, ((SubscribeMsgRequestResult)localObject4).hGp, 2);
            return;
          }
        }
        if (this.type != 0) {
          break label234;
        }
        Object localObject1 = this.jZX;
        if (localObject1 != null)
        {
          localObject4 = this.jZU;
          if (localObject4 == null) {
            d.g.b.k.fvU();
          }
          localObject4 = ((com.tencent.luggage.sdk.b.a.c.c)localObject4).getContext();
          d.g.b.k.g(localObject4, "service!!.context");
          localObject5 = this.jZT;
          if (localObject5 == null) {
            d.g.b.k.fvU();
          }
          ((GetSubscribeMsgListExecutor)localObject1).a((Context)localObject4, (SubscribeMsgRequestResult)localObject5);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(50611);
      }
      AppMethodBeat.o(50611);
      return;
      label234:
      Object localObject3 = this.jZY;
      if (localObject3 != null)
      {
        localObject4 = this.jZU;
        if (localObject4 == null) {
          d.g.b.k.fvU();
        }
        localObject5 = ((com.tencent.luggage.sdk.b.a.c.c)localObject4).getContext();
        d.g.b.k.g(localObject5, "service!!.context");
        localObject4 = this.jZT;
        if (localObject4 == null) {
          d.g.b.k.fvU();
        }
        d.g.b.k.h(localObject5, "context");
        d.g.b.k.h(localObject4, "result");
        localObject3 = ((SubscribeMsgExecutor)localObject3).kac;
        if (localObject3 != null)
        {
          ((SubscribeMsgExecutor.c)localObject3).b((SubscribeMsgRequestResult)localObject4);
          AppMethodBeat.o(50611);
          return;
        }
        AppMethodBeat.o(50611);
        return;
      }
      AppMethodBeat.o(50611);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(50610);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (this.type == 0)
      {
        localObject1 = this.jZX;
        if (localObject1 != null)
        {
          localObject2 = b.a.hHa;
          localObject2 = ((GetSubscribeMsgListExecutor)localObject1).username;
          localObject3 = ((GetSubscribeMsgListExecutor)localObject1).jZK;
          localObject4 = (b.c)localObject1;
          d.g.b.k.h(localObject2, "username");
          d.g.b.k.h(localObject3, "templateIds");
          localObject2 = new com.tencent.mm.msgsubscription.a.b((String)localObject2, 2);
          com.tencent.mm.msgsubscription.a.b.a((com.tencent.mm.msgsubscription.a.b)localObject2, (b.c)localObject4);
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            localObject5 = com.tencent.mm.msgsubscription.a.b.a((com.tencent.mm.msgsubscription.a.b)localObject2);
            czv localczv = new czv();
            localczv.DKS = ((String)localObject4);
            ((List)localObject5).add(localczv);
          }
          ((com.tencent.mm.msgsubscription.a.b)localObject2).a(((GetSubscribeMsgListExecutor)localObject1).jZH);
          AppMethodBeat.o(50610);
          return;
        }
        AppMethodBeat.o(50610);
        return;
      }
      Object localObject2 = this.jZY;
      if (localObject2 != null)
      {
        if (((SubscribeMsgExecutor)localObject2).hGX != null) {}
        for (int i = 1; (aa.JfW) && (i == 0); i = 0)
        {
          localObject1 = (Throwable)new AssertionError("Assertion failed");
          AppMethodBeat.o(50610);
          throw ((Throwable)localObject1);
        }
        localObject1 = b.a.hHa;
        localObject3 = ((SubscribeMsgExecutor)localObject2).username;
        localObject4 = ((SubscribeMsgExecutor)localObject2).kae;
        localObject5 = (b.c)localObject2;
        localObject1 = ((SubscribeMsgExecutor)localObject2).kad;
        if (localObject1 != null) {
          break label288;
        }
        localObject1 = new byte[0];
      }
      label288:
      for (;;)
      {
        b.a.a.a((String)localObject3, (List)localObject4, (b.c)localObject5, (byte[])localObject1, ((SubscribeMsgExecutor)localObject2).hGX).a(((SubscribeMsgExecutor)localObject2).jZH);
        AppMethodBeat.o(50610);
        return;
        AppMethodBeat.o(50610);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50612);
      d.g.b.k.h(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.type);
      paramParcel.writeParcelable((Parcelable)this.jZT, paramInt);
      paramParcel.writeParcelable((Parcelable)this.jZX, paramInt);
      paramParcel.writeParcelable((Parcelable)this.jZY, paramInt);
      if (this.jZZ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(50612);
        return;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements Parcelable.Creator<JsApiRequestSubscribeMessage.SubscribeMsgTask>
    {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
    public static final class c
      implements GetSubscribeMsgListExecutor.c
    {
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50602);
        d.g.b.k.h(paramString, "errMsg");
        this.kab.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50602);
      }
      
      public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(50601);
        d.g.b.k.h(paramString, "username");
        d.g.b.k.h(paramList, "items");
        paramString = this.kab.jZY;
        if (paramString != null)
        {
          paramList = j.q((Collection)paramList);
          d.g.b.k.h(paramList, "value");
          paramString.kae.clear();
          paramString.kae.addAll((Collection)paramList);
        }
        paramList = this.kab.jZY;
        if (paramList != null)
        {
          paramString = this.kab.jZT;
          if (paramString == null) {
            break label137;
          }
        }
        label137:
        for (paramString = paramString.buffer;; paramString = null)
        {
          paramList.kad = paramString;
          paramString = this.kab.jZY;
          if (paramString != null) {
            paramString.hGX = paramSubscribeMsgRequestDialogUiData;
          }
          JsApiRequestSubscribeMessage.SubscribeMsgTask.b(this.kab);
          this.kab.aEC();
          AppMethodBeat.o(50601);
          return;
        }
      }
      
      public final void b(com.tencent.mm.plugin.appbrand.widget.dialog.k paramk)
      {
        AppMethodBeat.i(50600);
        d.g.b.k.h(paramk, "dialog");
        Object localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.kab);
        if (localObject != null)
        {
          localObject = ((com.tencent.luggage.sdk.b.a.c.c)localObject).getWindowAndroid();
          if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.s.a.c)localObject).aMO() == true)) {
            if ((paramk instanceof com.tencent.mm.msgsubscription.ui.b)) {
              break label143;
            }
          }
        }
        label143:
        for (localObject = null;; localObject = paramk)
        {
          localObject = (com.tencent.mm.msgsubscription.ui.b)localObject;
          if (localObject != null)
          {
            ((com.tencent.mm.msgsubscription.ui.b)localObject).hJH = 1;
            View localView = ((com.tencent.mm.msgsubscription.ui.b)localObject).hIZ.findViewById(2131299134);
            d.g.b.k.g(localView, "mRootView.findViewById<V…alog_view_root_container)");
            localView.setBackground(android.support.v4.content.b.l(((com.tencent.mm.msgsubscription.ui.b)localObject).context, 2131234282));
          }
          localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.kab);
          if (localObject != null)
          {
            localObject = ((com.tencent.luggage.sdk.b.a.c.c)localObject).Dl();
            if (localObject != null)
            {
              localObject = ((com.tencent.luggage.sdk.d.c)localObject).aLB();
              if (localObject != null)
              {
                ((m)localObject).b(paramk);
                AppMethodBeat.o(50600);
                return;
              }
            }
          }
          AppMethodBeat.o(50600);
          return;
        }
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createSubscribeMsgListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"})
    public static final class d
      implements SubscribeMsgExecutor.c
    {
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50604);
        d.g.b.k.h(paramString, "errMsg");
        this.kab.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50604);
      }
      
      public final void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50603);
        d.g.b.k.h(paramSubscribeMsgRequestResult, "result");
        if (paramSubscribeMsgRequestResult.hGr)
        {
          JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.kab, "cancel", 0, 6);
          AppMethodBeat.o(50603);
          return;
        }
        HashMap localHashMap = new HashMap();
        paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.hGg).iterator();
        while (paramSubscribeMsgRequestResult.hasNext())
        {
          SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
          ((Map)localHashMap).put(localSubscribeMsgTmpItem.gIj, localSubscribeMsgTmpItem.hGz);
        }
        JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.kab, "ok", (Map)localHashMap);
        AppMethodBeat.o(50603);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$Companion;", "", "()V", "CTRL_INDEX", "", "ErrorCode_InvalidTemplateID", "ErrorCode_ListRequestFail", "ErrorCode_OK", "ErrorCode_SubscribeInvalidTemplateId", "ErrorCode_SubscribeRequestFail", "ErrorMsg_InvalidTemplateID", "", "ErrorMsg_ListRequestFail", "ErrorMsg_SubscribeInvalidTemplateId", "ErrorMsg_SubscribeRequestFail", "NAME", "TAG", "callbackJsApi", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "callbackId", "status", "retMap", "", "errorCode", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static void a(com.tencent.luggage.sdk.b.a.c.c paramc, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, int paramInt1, String paramString, Map<String, ? extends Object> paramMap, int paramInt2)
    {
      AppMethodBeat.i(50598);
      d.g.b.k.h(paramc, "service");
      d.g.b.k.h(paramJsApiRequestSubscribeMessage, "jsapi");
      d.g.b.k.h(paramString, "status");
      Map localMap = (Map)new LinkedHashMap();
      if ((paramInt2 != -1) && (paramInt2 != 0)) {
        localMap.put("errCode", Integer.valueOf(paramInt2));
      }
      if (paramMap != null) {
        localMap.putAll(paramMap);
      }
      paramJsApiRequestSubscribeMessage = paramJsApiRequestSubscribeMessage.k(paramString, localMap);
      ad.i("JsApiRequestSubscribeMessage", "[callbackJsApi] return json:".concat(String.valueOf(paramJsApiRequestSubscribeMessage)));
      paramc.h(paramInt1, paramJsApiRequestSubscribeMessage);
      AppMethodBeat.o(50598);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.JsApiRequestSubscribeMessage
 * JD-Core Version:    0.7.0.1
 */