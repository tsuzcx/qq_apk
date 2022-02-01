package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.util.CompatProcessTask;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.z;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "SubscribeMsgTask", "luggage-wechat-full-sdk_release"})
public final class JsApiRequestSubscribeMessage
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.luggage.sdk.b.a.c.d>
{
  public static final int CTRL_INDEX = 640;
  public static final String NAME = "requestSubscribeMessage";
  public static final a pdO;
  
  static
  {
    AppMethodBeat.i(50620);
    pdO = new a((byte)0);
    AppMethodBeat.o(50620);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "username", "", "appid", "appType", "", "tmplIds", "", "type", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callbackId", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;I)V", "Ljava/lang/Integer;", "getSubscribeMsgListExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "getGetSubscribeMsgListExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "setGetSubscribeMsgListExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;)V", "isCgiRequestSuccess", "", "()Z", "setCgiRequestSuccess", "(Z)V", "requestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "getRequestResult", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "setRequestResult", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;)V", "subscribeMsgExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "getSubscribeMsgExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "setSubscribeMsgExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;)V", "callbackJsApi", "", "status", "retMap", "", "", "errorCode", "createGetSubscribeMsgListListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "createSubscribeMsgListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "describeContents", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "result", "parseFromParcel", "p", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "Companion", "luggage-wechat-full-sdk_release"})
  static final class SubscribeMsgTask
    extends CompatProcessTask
    implements b.c
  {
    public static final Parcelable.Creator<SubscribeMsgTask> CREATOR;
    public static final JsApiRequestSubscribeMessage.SubscribeMsgTask.a pdW;
    SubscribeMsgRequestResult pdP;
    private com.tencent.luggage.sdk.b.a.c.d pdQ;
    private Integer pdR;
    private JsApiRequestSubscribeMessage pdS;
    private GetSubscribeMsgListExecutor pdT;
    SubscribeMsgExecutor pdU;
    private boolean pdV;
    private int type;
    private String username;
    
    static
    {
      AppMethodBeat.i(50617);
      pdW = new JsApiRequestSubscribeMessage.SubscribeMsgTask.a((byte)0);
      CREATOR = (Parcelable.Creator)new JsApiRequestSubscribeMessage.SubscribeMsgTask.b();
      AppMethodBeat.o(50617);
    }
    
    public SubscribeMsgTask(Parcel paramParcel)
    {
      this(str1, paramParcel.readInt());
      AppMethodBeat.i(50616);
      this.pdP = ((SubscribeMsgRequestResult)paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader()));
      this.pdT = ((GetSubscribeMsgListExecutor)paramParcel.readParcelable(GetSubscribeMsgListExecutor.class.getClassLoader()));
      this.pdU = ((SubscribeMsgExecutor)paramParcel.readParcelable(SubscribeMsgExecutor.class.getClassLoader()));
      paramParcel = this.pdT;
      if (paramParcel == null) {
        p.iCn();
      }
      if (this.pdT == null) {
        p.iCn();
      }
      paramParcel.pdE = bTj();
      paramParcel = this.pdU;
      if (paramParcel == null) {
        p.iCn();
      }
      paramParcel.pdY = bTi();
      AppMethodBeat.o(50616);
    }
    
    private SubscribeMsgTask(String paramString, int paramInt)
    {
      AppMethodBeat.i(50614);
      this.username = paramString;
      this.type = paramInt;
      this.pdV = true;
      AppMethodBeat.o(50614);
    }
    
    public SubscribeMsgTask(String paramString1, String paramString2, int paramInt1, List<String> paramList, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, com.tencent.luggage.sdk.b.a.c.d paramd, int paramInt2)
    {
      this(paramString1, 0);
      AppMethodBeat.i(50615);
      this.pdS = paramJsApiRequestSubscribeMessage;
      this.pdQ = paramd;
      this.pdR = Integer.valueOf(paramInt2);
      paramJsApiRequestSubscribeMessage = a.pdC;
      a.dM(paramString1, paramString2);
      paramString2 = new GetSubscribeMsgListExecutor(paramString1, paramList, bTj(), paramString2, paramInt1);
      paramList = (a.a)a.pdC;
      p.k(paramList, "<set-?>");
      paramString2.pdD = paramList;
      this.pdT = paramString2;
      paramString1 = new SubscribeMsgExecutor(paramString1, bTi());
      paramString2 = (a.a)a.pdC;
      p.k(paramString2, "<set-?>");
      paramString1.pdD = paramString2;
      this.pdU = paramString1;
      AppMethodBeat.o(50615);
    }
    
    private final void a(String paramString, Map<String, ? extends Object> paramMap, int paramInt)
    {
      AppMethodBeat.i(50607);
      Object localObject = JsApiRequestSubscribeMessage.pdO;
      localObject = this.pdQ;
      if (localObject == null) {
        p.iCn();
      }
      JsApiRequestSubscribeMessage localJsApiRequestSubscribeMessage = this.pdS;
      if (localJsApiRequestSubscribeMessage == null) {
        p.iCn();
      }
      Integer localInteger = this.pdR;
      if (localInteger == null) {
        p.iCn();
      }
      JsApiRequestSubscribeMessage.a.a((com.tencent.luggage.sdk.b.a.c.d)localObject, localJsApiRequestSubscribeMessage, localInteger.intValue(), paramString, paramMap, paramInt);
      AppMethodBeat.o(50607);
    }
    
    private final SubscribeMsgExecutor.c bTi()
    {
      AppMethodBeat.i(50605);
      SubscribeMsgExecutor.c localc = (SubscribeMsgExecutor.c)new d(this);
      AppMethodBeat.o(50605);
      return localc;
    }
    
    private final GetSubscribeMsgListExecutor.c bTj()
    {
      AppMethodBeat.i(50606);
      GetSubscribeMsgListExecutor.c localc = (GetSubscribeMsgListExecutor.c)new c(this);
      AppMethodBeat.o(50606);
      return localc;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(50610);
      Object localObject1;
      Object localObject2;
      Object localObject4;
      List localList;
      Object localObject5;
      if (this.type == 0)
      {
        localObject1 = this.pdT;
        if (localObject1 != null)
        {
          localObject2 = b.a.mpa;
          localObject2 = ((GetSubscribeMsgListExecutor)localObject1).username;
          localObject3 = ((GetSubscribeMsgListExecutor)localObject1).pdG;
          localObject4 = (b.c)localObject1;
          p.k(localObject2, "username");
          p.k(localObject3, "templateIds");
          localObject2 = new b((String)localObject2, 2);
          b.a((b)localObject2, (b.c)localObject4);
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            localList = b.a((b)localObject2);
            localObject5 = new epd();
            ((epd)localObject5).TBB = ((String)localObject4);
            localList.add(localObject5);
          }
          ((b)localObject2).a(((GetSubscribeMsgListExecutor)localObject1).pdD);
          AppMethodBeat.o(50610);
          return;
        }
        AppMethodBeat.o(50610);
        return;
      }
      Object localObject3 = this.pdU;
      if (localObject3 != null)
      {
        if (((SubscribeMsgExecutor)localObject3).moW != null) {}
        for (int i = 1; (z.aazO) && (i == 0); i = 0)
        {
          localObject1 = (Throwable)new AssertionError("Assertion failed");
          AppMethodBeat.o(50610);
          throw ((Throwable)localObject1);
        }
        localObject1 = b.a.mpa;
        localObject4 = ((SubscribeMsgExecutor)localObject3).username;
        localList = ((SubscribeMsgExecutor)localObject3).pea;
        localObject5 = (b.c)localObject3;
        localObject2 = ((SubscribeMsgExecutor)localObject3).pdZ;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new byte[0];
        }
        localObject2 = ((SubscribeMsgExecutor)localObject3).moW;
        p.k(localObject4, "username");
        p.k(localList, "templates");
        p.k(localObject1, "byteArray");
        b.a.a.a((String)localObject4, "", localList, "", (b.c)localObject5, true, (byte[])localObject1, (SubscribeMsgRequestDialogUiData)localObject2).a(((SubscribeMsgExecutor)localObject3).pdD);
        AppMethodBeat.o(50610);
        return;
      }
      AppMethodBeat.o(50610);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(50609);
      p.k(paramString, "errMsg");
      Log.i("JsApiRequestSubscribeMessage", "onNetSceneEndCallback errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " result" + paramSubscribeMsgRequestResult);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.pdV = bool;
        this.pdP = paramSubscribeMsgRequestResult;
        callback();
        AppMethodBeat.o(50609);
        return;
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(50611);
      Object localObject4;
      Object localObject5;
      try
      {
        if ((!this.pdV) || (this.pdP == null))
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
          localObject1 = this.pdP;
          if (localObject1 == null) {
            p.iCn();
          }
          if (((SubscribeMsgRequestResult)localObject1).mnY != 0)
          {
            localObject1 = new StringBuilder("fail:");
            localObject4 = this.pdP;
            if (localObject4 == null) {
              p.iCn();
            }
            localObject1 = ((SubscribeMsgRequestResult)localObject4).mnZ;
            localObject4 = this.pdP;
            if (localObject4 == null) {
              p.iCn();
            }
            a(this, (String)localObject1, ((SubscribeMsgRequestResult)localObject4).mnY, 2);
            return;
          }
        }
        if (this.type != 0) {
          break label234;
        }
        Object localObject1 = this.pdT;
        if (localObject1 != null)
        {
          localObject4 = this.pdQ;
          if (localObject4 == null) {
            p.iCn();
          }
          localObject4 = ((com.tencent.luggage.sdk.b.a.c.d)localObject4).getContext();
          p.j(localObject4, "service!!.context");
          localObject5 = this.pdP;
          if (localObject5 == null) {
            p.iCn();
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
      Object localObject3 = this.pdU;
      if (localObject3 != null)
      {
        localObject4 = this.pdQ;
        if (localObject4 == null) {
          p.iCn();
        }
        localObject5 = ((com.tencent.luggage.sdk.b.a.c.d)localObject4).getContext();
        p.j(localObject5, "service!!.context");
        localObject4 = this.pdP;
        if (localObject4 == null) {
          p.iCn();
        }
        p.k(localObject5, "context");
        p.k(localObject4, "result");
        localObject3 = ((SubscribeMsgExecutor)localObject3).pdY;
        if (localObject3 != null)
        {
          ((SubscribeMsgExecutor.c)localObject3).c((SubscribeMsgRequestResult)localObject4);
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
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.type);
      paramParcel.writeParcelable((Parcelable)this.pdP, paramInt);
      paramParcel.writeParcelable((Parcelable)this.pdT, paramInt);
      paramParcel.writeParcelable((Parcelable)this.pdU, paramInt);
      if (this.pdV) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(50612);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
    public static final class c
      implements GetSubscribeMsgListExecutor.c
    {
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50602);
        p.k(paramString, "errMsg");
        this.pdX.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50602);
      }
      
      public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.j paramj)
      {
        AppMethodBeat.i(50600);
        p.k(paramj, "dialog");
        Object localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.pdX);
        if (localObject != null)
        {
          localObject = ((com.tencent.luggage.sdk.b.a.c.d)localObject).getWindowAndroid();
          if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.platform.window.c)localObject).Sd() == true)) {
            if ((paramj instanceof com.tencent.mm.msgsubscription.ui.c)) {
              break label114;
            }
          }
        }
        label114:
        for (localObject = null;; localObject = paramj)
        {
          localObject = (com.tencent.mm.msgsubscription.ui.c)localObject;
          if (localObject != null) {
            ((com.tencent.mm.msgsubscription.ui.c)localObject).setPosition(1);
          }
          localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.pdX);
          if (localObject != null)
          {
            localObject = ((com.tencent.luggage.sdk.b.a.c.d)localObject).QM();
            if (localObject != null)
            {
              localObject = ((com.tencent.luggage.sdk.e.d)localObject).bCd();
              if (localObject != null)
              {
                ((com.tencent.mm.plugin.appbrand.widget.dialog.l)localObject).a(paramj);
                AppMethodBeat.o(50600);
                return;
              }
            }
          }
          AppMethodBeat.o(50600);
          return;
        }
      }
      
      public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(50601);
        p.k(paramString, "username");
        p.k(paramList, "items");
        paramString = this.pdX.pdU;
        if (paramString != null)
        {
          paramList = kotlin.a.j.t((Collection)paramList);
          p.k(paramList, "value");
          paramString.pea.clear();
          paramString.pea.addAll((Collection)paramList);
        }
        paramList = this.pdX.pdU;
        if (paramList != null)
        {
          paramString = this.pdX.pdP;
          if (paramString == null) {
            break label137;
          }
        }
        label137:
        for (paramString = paramString.buffer;; paramString = null)
        {
          paramList.pdZ = paramString;
          paramString = this.pdX.pdU;
          if (paramString != null) {
            paramString.moW = paramSubscribeMsgRequestDialogUiData;
          }
          JsApiRequestSubscribeMessage.SubscribeMsgTask.b(this.pdX);
          this.pdX.bsM();
          AppMethodBeat.o(50601);
          return;
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createSubscribeMsgListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"})
    public static final class d
      implements SubscribeMsgExecutor.c
    {
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50604);
        p.k(paramString, "errMsg");
        this.pdX.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50604);
      }
      
      public final void c(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50603);
        p.k(paramSubscribeMsgRequestResult, "result");
        if (paramSubscribeMsgRequestResult.moa)
        {
          JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.pdX, "cancel", 0, 6);
          AppMethodBeat.o(50603);
          return;
        }
        HashMap localHashMap = new HashMap();
        paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.mnO).iterator();
        while (paramSubscribeMsgRequestResult.hasNext())
        {
          SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
          ((Map)localHashMap).put(localSubscribeMsgTmpItem.lnb, localSubscribeMsgTmpItem.moi);
        }
        JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.pdX, "ok", (Map)localHashMap);
        AppMethodBeat.o(50603);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$Companion;", "", "()V", "CTRL_INDEX", "", "ErrorCode_InvalidTemplateID", "ErrorCode_ListRequestFail", "ErrorCode_OK", "ErrorCode_SubscribeInvalidTemplateId", "ErrorCode_SubscribeRequestFail", "ErrorMsg_InvalidTemplateID", "", "ErrorMsg_ListRequestFail", "ErrorMsg_SubscribeInvalidTemplateId", "ErrorMsg_SubscribeRequestFail", "NAME", "TAG", "callbackJsApi", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "callbackId", "status", "retMap", "", "errorCode", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static void a(com.tencent.luggage.sdk.b.a.c.d paramd, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, int paramInt1, String paramString, Map<String, ? extends Object> paramMap, int paramInt2)
    {
      AppMethodBeat.i(50598);
      p.k(paramd, "service");
      p.k(paramJsApiRequestSubscribeMessage, "jsapi");
      p.k(paramString, "status");
      Map localMap = (Map)new LinkedHashMap();
      if ((paramInt2 != -1) && (paramInt2 != 0)) {
        localMap.put("errCode", Integer.valueOf(paramInt2));
      }
      if (paramMap != null) {
        localMap.putAll(paramMap);
      }
      paramJsApiRequestSubscribeMessage = paramJsApiRequestSubscribeMessage.m(paramString, localMap);
      Log.i("JsApiRequestSubscribeMessage", "[callbackJsApi] return json:".concat(String.valueOf(paramJsApiRequestSubscribeMessage)));
      paramd.j(paramInt1, paramJsApiRequestSubscribeMessage);
      AppMethodBeat.o(50598);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.JsApiRequestSubscribeMessage
 * JD-Core Version:    0.7.0.1
 */