package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.sdk.d.d;
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
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.ac;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "SubscribeMsgTask", "luggage-wechat-full-sdk_release"})
public final class JsApiRequestSubscribeMessage
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.luggage.sdk.b.a.c.c>
{
  public static final int CTRL_INDEX = 640;
  public static final String NAME = "requestSubscribeMessage";
  public static final a law;
  
  static
  {
    AppMethodBeat.i(50620);
    law = new a((byte)0);
    AppMethodBeat.o(50620);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "username", "", "appid", "appType", "", "tmplIds", "", "type", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callbackId", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;I)V", "Ljava/lang/Integer;", "getSubscribeMsgListExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "getGetSubscribeMsgListExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "setGetSubscribeMsgListExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;)V", "isCgiRequestSuccess", "", "()Z", "setCgiRequestSuccess", "(Z)V", "requestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "getRequestResult", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "setRequestResult", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;)V", "subscribeMsgExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "getSubscribeMsgExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "setSubscribeMsgExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;)V", "callbackJsApi", "", "status", "retMap", "", "", "errorCode", "createGetSubscribeMsgListListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "createSubscribeMsgListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "describeContents", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "result", "parseFromParcel", "p", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "Companion", "luggage-wechat-full-sdk_release"})
  static final class SubscribeMsgTask
    extends CompatProcessTask
    implements b.c
  {
    public static final Parcelable.Creator<SubscribeMsgTask> CREATOR;
    public static final a laE;
    private JsApiRequestSubscribeMessage laA;
    private GetSubscribeMsgListExecutor laB;
    SubscribeMsgExecutor laC;
    private boolean laD;
    SubscribeMsgRequestResult lax;
    private com.tencent.luggage.sdk.b.a.c.c lay;
    private Integer laz;
    private int type;
    private String username;
    
    static
    {
      AppMethodBeat.i(50617);
      laE = new a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50617);
    }
    
    public SubscribeMsgTask(Parcel paramParcel)
    {
      this(str1, paramParcel.readInt());
      AppMethodBeat.i(50616);
      this.lax = ((SubscribeMsgRequestResult)paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader()));
      this.laB = ((GetSubscribeMsgListExecutor)paramParcel.readParcelable(GetSubscribeMsgListExecutor.class.getClassLoader()));
      this.laC = ((SubscribeMsgExecutor)paramParcel.readParcelable(SubscribeMsgExecutor.class.getClassLoader()));
      paramParcel = this.laB;
      if (paramParcel == null) {
        p.gkB();
      }
      if (this.laB == null) {
        p.gkB();
      }
      paramParcel.lal = bmd();
      paramParcel = this.laC;
      if (paramParcel == null) {
        p.gkB();
      }
      paramParcel.laG = bmc();
      AppMethodBeat.o(50616);
    }
    
    private SubscribeMsgTask(String paramString, int paramInt)
    {
      AppMethodBeat.i(50614);
      this.username = paramString;
      this.type = paramInt;
      this.laD = true;
      AppMethodBeat.o(50614);
    }
    
    public SubscribeMsgTask(String paramString1, String paramString2, int paramInt1, List<String> paramList, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, com.tencent.luggage.sdk.b.a.c.c paramc, int paramInt2)
    {
      this(paramString1, 0);
      AppMethodBeat.i(50615);
      this.laA = paramJsApiRequestSubscribeMessage;
      this.lay = paramc;
      this.laz = Integer.valueOf(paramInt2);
      paramJsApiRequestSubscribeMessage = a.laj;
      a.dm(paramString1, paramString2);
      paramString2 = new GetSubscribeMsgListExecutor(paramString1, paramList, bmd(), paramString2, paramInt1);
      paramList = (a.a)a.laj;
      p.h(paramList, "<set-?>");
      paramString2.lak = paramList;
      this.laB = paramString2;
      paramString1 = new SubscribeMsgExecutor(paramString1, bmc());
      paramString2 = (a.a)a.laj;
      p.h(paramString2, "<set-?>");
      paramString1.lak = paramString2;
      this.laC = paramString1;
      AppMethodBeat.o(50615);
    }
    
    private final void a(String paramString, Map<String, ? extends Object> paramMap, int paramInt)
    {
      AppMethodBeat.i(50607);
      Object localObject = JsApiRequestSubscribeMessage.law;
      localObject = this.lay;
      if (localObject == null) {
        p.gkB();
      }
      JsApiRequestSubscribeMessage localJsApiRequestSubscribeMessage = this.laA;
      if (localJsApiRequestSubscribeMessage == null) {
        p.gkB();
      }
      Integer localInteger = this.laz;
      if (localInteger == null) {
        p.gkB();
      }
      JsApiRequestSubscribeMessage.a.a((com.tencent.luggage.sdk.b.a.c.c)localObject, localJsApiRequestSubscribeMessage, localInteger.intValue(), paramString, paramMap, paramInt);
      AppMethodBeat.o(50607);
    }
    
    private final SubscribeMsgExecutor.c bmc()
    {
      AppMethodBeat.i(50605);
      SubscribeMsgExecutor.c localc = (SubscribeMsgExecutor.c)new d(this);
      AppMethodBeat.o(50605);
      return localc;
    }
    
    private final GetSubscribeMsgListExecutor.c bmd()
    {
      AppMethodBeat.i(50606);
      GetSubscribeMsgListExecutor.c localc = (GetSubscribeMsgListExecutor.c)new c(this);
      AppMethodBeat.o(50606);
      return localc;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(50609);
      p.h(paramString, "errMsg");
      ae.i("JsApiRequestSubscribeMessage", "onNetSceneEndCallback errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " result" + paramSubscribeMsgRequestResult);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.laD = bool;
        this.lax = paramSubscribeMsgRequestResult;
        h.MqF.f((Runnable)new CompatProcessTask.a(this), "CompatProcessTask_" + aOZ());
        AppMethodBeat.o(50609);
        return;
      }
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(50610);
      Object localObject1;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      if (this.type == 0)
      {
        localObject1 = this.laB;
        if (localObject1 != null)
        {
          localObject2 = b.a.iDP;
          localObject2 = ((GetSubscribeMsgListExecutor)localObject1).username;
          localObject3 = ((GetSubscribeMsgListExecutor)localObject1).lan;
          localObject4 = (b.c)localObject1;
          p.h(localObject2, "username");
          p.h(localObject3, "templateIds");
          localObject2 = new com.tencent.mm.msgsubscription.a.b((String)localObject2, 2);
          com.tencent.mm.msgsubscription.a.b.a((com.tencent.mm.msgsubscription.a.b)localObject2, (b.c)localObject4);
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            localObject5 = com.tencent.mm.msgsubscription.a.b.a((com.tencent.mm.msgsubscription.a.b)localObject2);
            dlp localdlp = new dlp();
            localdlp.Hkk = ((String)localObject4);
            ((List)localObject5).add(localdlp);
          }
          ((com.tencent.mm.msgsubscription.a.b)localObject2).a(((GetSubscribeMsgListExecutor)localObject1).lak);
          AppMethodBeat.o(50610);
          return;
        }
        AppMethodBeat.o(50610);
        return;
      }
      Object localObject2 = this.laC;
      if (localObject2 != null)
      {
        if (((SubscribeMsgExecutor)localObject2).iDM != null) {}
        for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
        {
          localObject1 = (Throwable)new AssertionError("Assertion failed");
          AppMethodBeat.o(50610);
          throw ((Throwable)localObject1);
        }
        localObject1 = b.a.iDP;
        localObject3 = ((SubscribeMsgExecutor)localObject2).username;
        localObject4 = ((SubscribeMsgExecutor)localObject2).laI;
        localObject5 = (b.c)localObject2;
        localObject1 = ((SubscribeMsgExecutor)localObject2).laH;
        if (localObject1 != null) {
          break label288;
        }
        localObject1 = new byte[0];
      }
      label288:
      for (;;)
      {
        b.a.a.a((String)localObject3, (List)localObject4, (b.c)localObject5, (byte[])localObject1, ((SubscribeMsgExecutor)localObject2).iDM).a(((SubscribeMsgExecutor)localObject2).lak);
        AppMethodBeat.o(50610);
        return;
        AppMethodBeat.o(50610);
        return;
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(50611);
      Object localObject4;
      Object localObject5;
      try
      {
        if ((!this.laD) || (this.lax == null))
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
          localObject1 = this.lax;
          if (localObject1 == null) {
            p.gkB();
          }
          if (((SubscribeMsgRequestResult)localObject1).iDe != 0)
          {
            localObject1 = new StringBuilder("fail:");
            localObject4 = this.lax;
            if (localObject4 == null) {
              p.gkB();
            }
            localObject1 = ((SubscribeMsgRequestResult)localObject4).iDf;
            localObject4 = this.lax;
            if (localObject4 == null) {
              p.gkB();
            }
            a(this, (String)localObject1, ((SubscribeMsgRequestResult)localObject4).iDe, 2);
            return;
          }
        }
        if (this.type != 0) {
          break label234;
        }
        Object localObject1 = this.laB;
        if (localObject1 != null)
        {
          localObject4 = this.lay;
          if (localObject4 == null) {
            p.gkB();
          }
          localObject4 = ((com.tencent.luggage.sdk.b.a.c.c)localObject4).getContext();
          p.g(localObject4, "service!!.context");
          localObject5 = this.lax;
          if (localObject5 == null) {
            p.gkB();
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
      Object localObject3 = this.laC;
      if (localObject3 != null)
      {
        localObject4 = this.lay;
        if (localObject4 == null) {
          p.gkB();
        }
        localObject5 = ((com.tencent.luggage.sdk.b.a.c.c)localObject4).getContext();
        p.g(localObject5, "service!!.context");
        localObject4 = this.lax;
        if (localObject4 == null) {
          p.gkB();
        }
        p.h(localObject5, "context");
        p.h(localObject4, "result");
        localObject3 = ((SubscribeMsgExecutor)localObject3).laG;
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
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50612);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.type);
      paramParcel.writeParcelable((Parcelable)this.lax, paramInt);
      paramParcel.writeParcelable((Parcelable)this.laB, paramInt);
      paramParcel.writeParcelable((Parcelable)this.laC, paramInt);
      if (this.laD) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(50612);
        return;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$Companion;", "", "()V", "ACTION_SUBSCRIBE", "", "ACTION_USER_ACTION", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "luggage-wechat-full-sdk_release"})
    public static final class a {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements Parcelable.Creator<JsApiRequestSubscribeMessage.SubscribeMsgTask>
    {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
    public static final class c
      implements GetSubscribeMsgListExecutor.c
    {
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50602);
        p.h(paramString, "errMsg");
        this.laF.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50602);
      }
      
      public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(50601);
        p.h(paramString, "username");
        p.h(paramList, "items");
        paramString = this.laF.laC;
        if (paramString != null)
        {
          paramList = j.s((Collection)paramList);
          p.h(paramList, "value");
          paramString.laI.clear();
          paramString.laI.addAll((Collection)paramList);
        }
        paramList = this.laF.laC;
        if (paramList != null)
        {
          paramString = this.laF.lax;
          if (paramString == null) {
            break label137;
          }
        }
        label137:
        for (paramString = paramString.buffer;; paramString = null)
        {
          paramList.laH = paramString;
          paramString = this.laF.laC;
          if (paramString != null) {
            paramString.iDM = paramSubscribeMsgRequestDialogUiData;
          }
          JsApiRequestSubscribeMessage.SubscribeMsgTask.b(this.laF);
          this.laF.aPa();
          AppMethodBeat.o(50601);
          return;
        }
      }
      
      public final void b(k paramk)
      {
        AppMethodBeat.i(50600);
        p.h(paramk, "dialog");
        Object localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.laF);
        if (localObject != null)
        {
          localObject = ((com.tencent.luggage.sdk.b.a.c.c)localObject).getWindowAndroid();
          if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.platform.window.c)localObject).aXi() == true)) {
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
            ((com.tencent.mm.msgsubscription.ui.b)localObject).iGp = 1;
            View localView = ((com.tencent.mm.msgsubscription.ui.b)localObject).iFK.findViewById(2131299134);
            p.g(localView, "mRootView.findViewById<V…alog_view_root_container)");
            localView.setBackground(android.support.v4.content.b.l(((com.tencent.mm.msgsubscription.ui.b)localObject).context, 2131234282));
          }
          localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.laF);
          if (localObject != null)
          {
            localObject = ((com.tencent.luggage.sdk.b.a.c.c)localObject).Eq();
            if (localObject != null)
            {
              localObject = ((d)localObject).aWs();
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createSubscribeMsgListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"})
    public static final class d
      implements SubscribeMsgExecutor.c
    {
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50604);
        p.h(paramString, "errMsg");
        this.laF.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50604);
      }
      
      public final void b(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50603);
        p.h(paramSubscribeMsgRequestResult, "result");
        if (paramSubscribeMsgRequestResult.iDg)
        {
          JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.laF, "cancel", 0, 6);
          AppMethodBeat.o(50603);
          return;
        }
        HashMap localHashMap = new HashMap();
        paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.iCV).iterator();
        while (paramSubscribeMsgRequestResult.hasNext())
        {
          SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
          ((Map)localHashMap).put(localSubscribeMsgTmpItem.hDH, localSubscribeMsgTmpItem.iDo);
        }
        JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.laF, "ok", (Map)localHashMap);
        AppMethodBeat.o(50603);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$Companion;", "", "()V", "CTRL_INDEX", "", "ErrorCode_InvalidTemplateID", "ErrorCode_ListRequestFail", "ErrorCode_OK", "ErrorCode_SubscribeInvalidTemplateId", "ErrorCode_SubscribeRequestFail", "ErrorMsg_InvalidTemplateID", "", "ErrorMsg_ListRequestFail", "ErrorMsg_SubscribeInvalidTemplateId", "ErrorMsg_SubscribeRequestFail", "NAME", "TAG", "callbackJsApi", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "callbackId", "status", "retMap", "", "errorCode", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static void a(com.tencent.luggage.sdk.b.a.c.c paramc, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, int paramInt1, String paramString, Map<String, ? extends Object> paramMap, int paramInt2)
    {
      AppMethodBeat.i(50598);
      p.h(paramc, "service");
      p.h(paramJsApiRequestSubscribeMessage, "jsapi");
      p.h(paramString, "status");
      Map localMap = (Map)new LinkedHashMap();
      if ((paramInt2 != -1) && (paramInt2 != 0)) {
        localMap.put("errCode", Integer.valueOf(paramInt2));
      }
      if (paramMap != null) {
        localMap.putAll(paramMap);
      }
      paramJsApiRequestSubscribeMessage = paramJsApiRequestSubscribeMessage.n(paramString, localMap);
      ae.i("JsApiRequestSubscribeMessage", "[callbackJsApi] return json:".concat(String.valueOf(paramJsApiRequestSubscribeMessage)));
      paramc.h(paramInt1, paramJsApiRequestSubscribeMessage);
      AppMethodBeat.o(50598);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.JsApiRequestSubscribeMessage
 * JD-Core Version:    0.7.0.1
 */