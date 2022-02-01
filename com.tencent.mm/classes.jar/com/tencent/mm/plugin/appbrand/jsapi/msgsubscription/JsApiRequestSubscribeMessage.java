package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.b.a;
import com.tencent.mm.msgsubscription.a.b.a.a;
import com.tencent.mm.msgsubscription.a.b.c;
import com.tencent.mm.msgsubscription.ui.f;
import com.tencent.mm.msgsubscription.util.CompatProcessTask;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.fkc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "SubscribeMsgTask", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiRequestSubscribeMessage
  extends com.tencent.mm.plugin.appbrand.jsapi.c<d>
{
  public static final int CTRL_INDEX = 640;
  public static final String NAME = "requestSubscribeMessage";
  public static final a sje;
  
  static
  {
    AppMethodBeat.i(50620);
    sje = new a((byte)0);
    AppMethodBeat.o(50620);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "username", "", "appid", "appType", "", "tmplIds", "", "type", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callbackId", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;I)V", "Ljava/lang/Integer;", "getSubscribeMsgListExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "getGetSubscribeMsgListExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "setGetSubscribeMsgListExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;)V", "isCgiRequestSuccess", "", "()Z", "setCgiRequestSuccess", "(Z)V", "requestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "getRequestResult", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "setRequestResult", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;)V", "subscribeMsgExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "getSubscribeMsgExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "setSubscribeMsgExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;)V", "callbackJsApi", "", "status", "retMap", "", "", "errorCode", "createGetSubscribeMsgListListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "createSubscribeMsgListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "describeContents", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "result", "parseFromParcel", "p", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class SubscribeMsgTask
    extends CompatProcessTask
    implements b.c
  {
    public static final Parcelable.Creator<SubscribeMsgTask> CREATOR;
    public static final JsApiRequestSubscribeMessage.SubscribeMsgTask.a sjf;
    SubscribeMsgRequestResult sjg;
    private d sjh;
    private Integer sji;
    private JsApiRequestSubscribeMessage sjj;
    private GetSubscribeMsgListExecutor sjk;
    SubscribeMsgExecutor sjl;
    private boolean sjm;
    private int type;
    private String username;
    
    static
    {
      AppMethodBeat.i(50617);
      sjf = new JsApiRequestSubscribeMessage.SubscribeMsgTask.a((byte)0);
      CREATOR = (Parcelable.Creator)new b();
      AppMethodBeat.o(50617);
    }
    
    public SubscribeMsgTask(Parcel paramParcel)
    {
      this(str1, paramParcel.readInt());
      AppMethodBeat.i(50616);
      this.sjg = ((SubscribeMsgRequestResult)paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader()));
      this.sjk = ((GetSubscribeMsgListExecutor)paramParcel.readParcelable(GetSubscribeMsgListExecutor.class.getClassLoader()));
      this.sjl = ((SubscribeMsgExecutor)paramParcel.readParcelable(SubscribeMsgExecutor.class.getClassLoader()));
      paramParcel = this.sjk;
      s.checkNotNull(paramParcel);
      s.checkNotNull(this.sjk);
      paramParcel.siW = ctp();
      paramParcel = this.sjl;
      s.checkNotNull(paramParcel);
      paramParcel.sjq = cto();
      AppMethodBeat.o(50616);
    }
    
    private SubscribeMsgTask(String paramString, int paramInt)
    {
      AppMethodBeat.i(50614);
      this.username = paramString;
      this.type = paramInt;
      this.sjm = true;
      AppMethodBeat.o(50614);
    }
    
    public SubscribeMsgTask(String paramString1, String paramString2, int paramInt1, List<String> paramList, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, d paramd, int paramInt2)
    {
      this(paramString1, 0);
      AppMethodBeat.i(50615);
      this.sjj = paramJsApiRequestSubscribeMessage;
      this.sjh = paramd;
      this.sji = Integer.valueOf(paramInt2);
      paramJsApiRequestSubscribeMessage = a.siO;
      a.ef(paramString1, paramString2);
      paramString2 = new GetSubscribeMsgListExecutor(paramString1, paramList, ctp(), paramString2, paramInt1);
      paramList = (a.a)a.siO;
      s.u(paramList, "<set-?>");
      paramString2.siV = paramList;
      paramList = ah.aiuX;
      this.sjk = paramString2;
      paramString1 = new SubscribeMsgExecutor(paramString1, cto());
      paramString2 = (a.a)a.siO;
      s.u(paramString2, "<set-?>");
      paramString1.siV = paramString2;
      paramString2 = ah.aiuX;
      this.sjl = paramString1;
      AppMethodBeat.o(50615);
    }
    
    private final void a(String paramString, Map<String, ? extends Object> paramMap, int paramInt)
    {
      AppMethodBeat.i(50607);
      Object localObject = JsApiRequestSubscribeMessage.sje;
      localObject = this.sjh;
      s.checkNotNull(localObject);
      JsApiRequestSubscribeMessage localJsApiRequestSubscribeMessage = this.sjj;
      s.checkNotNull(localJsApiRequestSubscribeMessage);
      Integer localInteger = this.sji;
      s.checkNotNull(localInteger);
      JsApiRequestSubscribeMessage.a.a((d)localObject, localJsApiRequestSubscribeMessage, localInteger.intValue(), paramString, paramMap, paramInt);
      AppMethodBeat.o(50607);
    }
    
    private final SubscribeMsgExecutor.c cto()
    {
      AppMethodBeat.i(50605);
      SubscribeMsgExecutor.c localc = (SubscribeMsgExecutor.c)new d(this);
      AppMethodBeat.o(50605);
      return localc;
    }
    
    private final GetSubscribeMsgListExecutor.c ctp()
    {
      AppMethodBeat.i(50606);
      GetSubscribeMsgListExecutor.c localc = (GetSubscribeMsgListExecutor.c)new c(this);
      AppMethodBeat.o(50606);
      return localc;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(50609);
      s.u(paramString, "errMsg");
      Log.i("JsApiRequestSubscribeMessage", "onNetSceneEndCallback errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " result" + paramSubscribeMsgRequestResult);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.sjm = bool;
        this.sjg = paramSubscribeMsgRequestResult;
        callback();
        AppMethodBeat.o(50609);
        return;
      }
    }
    
    public final void asn()
    {
      AppMethodBeat.i(50610);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject6;
      Object localObject5;
      if (this.type == 0)
      {
        localObject1 = this.sjk;
        if (localObject1 != null)
        {
          localObject2 = b.a.piO;
          localObject2 = ((GetSubscribeMsgListExecutor)localObject1).username;
          localObject3 = ((GetSubscribeMsgListExecutor)localObject1).siU;
          localObject4 = (b.c)localObject1;
          s.u(localObject2, "username");
          s.u(localObject3, "templateIds");
          localObject2 = new b((String)localObject2, 2);
          b.a((b)localObject2, (b.c)localObject4);
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject6 = (String)((Iterator)localObject3).next();
            localObject4 = b.a((b)localObject2);
            localObject5 = new fkc();
            ((fkc)localObject5).aaQP = ((String)localObject6);
            localObject6 = ah.aiuX;
            ((List)localObject4).add(localObject5);
          }
          ((b)localObject2).a(((GetSubscribeMsgListExecutor)localObject1).siV);
          AppMethodBeat.o(50610);
        }
      }
      else
      {
        localObject3 = this.sjl;
        if (localObject3 != null)
        {
          localObject1 = b.a.piO;
          localObject4 = ((SubscribeMsgExecutor)localObject3).username;
          localObject5 = ((SubscribeMsgExecutor)localObject3).sjs;
          localObject6 = (b.c)localObject3;
          localObject2 = ((SubscribeMsgExecutor)localObject3).sjr;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new byte[0];
          }
          localObject2 = ((SubscribeMsgExecutor)localObject3).piL;
          s.u(localObject4, "username");
          s.u(localObject5, "templates");
          s.u(localObject1, "byteArray");
          b.a.a.a((String)localObject4, "", (List)localObject5, "", (b.c)localObject6, true, (byte[])localObject1, (SubscribeMsgRequestDialogUiData)localObject2).a(((SubscribeMsgExecutor)localObject3).siV);
        }
      }
      AppMethodBeat.o(50610);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(50611);
      Object localObject4;
      Object localObject5;
      try
      {
        if ((!this.sjm) || (this.sjg == null))
        {
          if (this.type == 0)
          {
            a(this, "fail:Request list fail", 10002, 2);
            return;
          }
          a(this, "fail:Request subscribe fail", 10003, 2);
          return;
        }
        Object localObject1;
        if (this.type == 0)
        {
          localObject1 = this.sjg;
          s.checkNotNull(localObject1);
          if (((SubscribeMsgRequestResult)localObject1).phM != 0)
          {
            localObject1 = this.sjg;
            s.checkNotNull(localObject1);
            localObject1 = s.X("fail:", ((SubscribeMsgRequestResult)localObject1).phN);
            localObject4 = this.sjg;
            s.checkNotNull(localObject4);
            a(this, (String)localObject1, ((SubscribeMsgRequestResult)localObject4).phM, 2);
            return;
          }
        }
        if (this.type == 0)
        {
          localObject1 = this.sjk;
          if (localObject1 == null) {
            break label269;
          }
          localObject4 = this.sjh;
          s.checkNotNull(localObject4);
          localObject4 = ((d)localObject4).getContext();
          s.s(localObject4, "service!!.context");
          localObject5 = this.sjg;
          s.checkNotNull(localObject5);
          ((GetSubscribeMsgListExecutor)localObject1).a((Context)localObject4, (SubscribeMsgRequestResult)localObject5);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(50611);
      }
      Object localObject3 = this.sjl;
      if (localObject3 != null)
      {
        localObject4 = this.sjh;
        s.checkNotNull(localObject4);
        localObject5 = ((d)localObject4).getContext();
        s.s(localObject5, "service!!.context");
        localObject4 = this.sjg;
        s.checkNotNull(localObject4);
        s.u(localObject5, "context");
        s.u(localObject4, "result");
        localObject3 = ((SubscribeMsgExecutor)localObject3).sjq;
        if (localObject3 != null) {
          ((SubscribeMsgExecutor.c)localObject3).c((SubscribeMsgRequestResult)localObject4);
        }
      }
      label269:
      AppMethodBeat.o(50611);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50612);
      s.u(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.type);
      paramParcel.writeParcelable((Parcelable)this.sjg, paramInt);
      paramParcel.writeParcelable((Parcelable)this.sjk, paramInt);
      paramParcel.writeParcelable((Parcelable)this.sjl, paramInt);
      if (this.sjm) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(50612);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Parcelable.Creator<JsApiRequestSubscribeMessage.SubscribeMsgTask>
    {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "dismissDialog", "", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "listener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialogDismissStateListener;", "onNetSceneEndCallback", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements GetSubscribeMsgListExecutor.c
    {
      c(JsApiRequestSubscribeMessage.SubscribeMsgTask paramSubscribeMsgTask) {}
      
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50602);
        s.u(paramString, "errMsg");
        this.sjn.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50602);
      }
      
      public final void a(n paramn, final o paramo)
      {
        AppMethodBeat.i(326299);
        s.u(paramn, "dialog");
        s.u(paramo, "listener");
        Object localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.sjn);
        if (localObject != null)
        {
          localObject = ((d)localObject).aqZ();
          if (localObject != null)
          {
            localObject = ((AppBrandRuntime)localObject).qsn;
            if (localObject != null) {
              ((r)localObject).a((o)new a(this.sjn, paramo));
            }
          }
        }
        paramo = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.sjn);
        if (paramo != null)
        {
          paramo = paramo.aqZ();
          if (paramo != null)
          {
            paramo = paramo.qsn;
            if (paramo != null) {
              paramo.c(paramn);
            }
          }
        }
        AppMethodBeat.o(326299);
      }
      
      public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(50601);
        s.u(paramString, "username");
        s.u(paramList, "items");
        paramString = this.sjn.sjl;
        if (paramString != null)
        {
          paramList = p.J((Collection)paramList);
          s.u(paramList, "value");
          paramString.sjs.clear();
          paramString.sjs.addAll((Collection)paramList);
        }
        paramList = this.sjn.sjl;
        if (paramList != null)
        {
          paramString = this.sjn.sjg;
          if (paramString != null) {
            break label134;
          }
        }
        label134:
        for (paramString = null;; paramString = paramString.buffer)
        {
          paramList.sjr = paramString;
          paramString = this.sjn.sjl;
          if (paramString != null) {
            paramString.piL = paramSubscribeMsgRequestDialogUiData;
          }
          JsApiRequestSubscribeMessage.SubscribeMsgTask.b(this.sjn);
          this.sjn.bQt();
          AppMethodBeat.o(50601);
          return;
        }
      }
      
      public final void b(n paramn)
      {
        AppMethodBeat.i(50600);
        s.u(paramn, "dialog");
        Object localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.sjn);
        int i;
        if (localObject != null)
        {
          localObject = ((y)localObject).qwF;
          if ((localObject != null) && (((com.tencent.mm.plugin.appbrand.platform.window.c)localObject).asu() == true))
          {
            i = 1;
            if (i != 0) {
              if (!(paramn instanceof f)) {
                break label117;
              }
            }
          }
        }
        label117:
        for (localObject = (f)paramn;; localObject = null)
        {
          if (localObject != null) {
            ((f)localObject).setPosition(1);
          }
          localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.sjn);
          if (localObject != null)
          {
            localObject = ((d)localObject).aqZ();
            if (localObject != null)
            {
              localObject = ((AppBrandRuntime)localObject).qsn;
              if (localObject != null) {
                ((r)localObject).b(paramn);
              }
            }
          }
          AppMethodBeat.o(50600);
          return;
          i = 0;
          break;
        }
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1$dismissDialog$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialogDismissStateListener;", "onDismiss", "", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements o
      {
        a(JsApiRequestSubscribeMessage.SubscribeMsgTask paramSubscribeMsgTask, o paramo) {}
        
        public final void a(n paramn)
        {
          AppMethodBeat.i(326297);
          Object localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.sjn);
          if (localObject != null)
          {
            localObject = ((d)localObject).aqZ();
            if (localObject != null)
            {
              localObject = ((AppBrandRuntime)localObject).qsn;
              if (localObject != null) {
                ((r)localObject).b((o)this);
              }
            }
          }
          paramo.a(paramn);
          AppMethodBeat.o(326297);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createSubscribeMsgListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      implements SubscribeMsgExecutor.c
    {
      d(JsApiRequestSubscribeMessage.SubscribeMsgTask paramSubscribeMsgTask) {}
      
      public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50604);
        s.u(paramString, "errMsg");
        this.sjn.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
        AppMethodBeat.o(50604);
      }
      
      public final void c(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
      {
        AppMethodBeat.i(50603);
        s.u(paramSubscribeMsgRequestResult, "result");
        if (paramSubscribeMsgRequestResult.phO)
        {
          JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.sjn, "cancel", 0, 6);
          AppMethodBeat.o(50603);
          return;
        }
        HashMap localHashMap = new HashMap();
        paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.phC).iterator();
        while (paramSubscribeMsgRequestResult.hasNext())
        {
          SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
          ((Map)localHashMap).put(localSubscribeMsgTmpItem.nSg, localSubscribeMsgTmpItem.phW);
        }
        JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.sjn, "ok", (Map)localHashMap);
        AppMethodBeat.o(50603);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$Companion;", "", "()V", "CTRL_INDEX", "", "ErrorCode_InvalidTemplateID", "ErrorCode_ListRequestFail", "ErrorCode_OK", "ErrorCode_SubscribeInvalidTemplateId", "ErrorCode_SubscribeRequestFail", "ErrorMsg_InvalidTemplateID", "", "ErrorMsg_ListRequestFail", "ErrorMsg_SubscribeInvalidTemplateId", "ErrorMsg_SubscribeRequestFail", "NAME", "TAG", "callbackJsApi", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "callbackId", "status", "retMap", "", "errorCode", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(d paramd, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, int paramInt1, String paramString, Map<String, ? extends Object> paramMap, int paramInt2)
    {
      AppMethodBeat.i(50598);
      s.u(paramd, "service");
      s.u(paramJsApiRequestSubscribeMessage, "jsapi");
      s.u(paramString, "status");
      Map localMap = (Map)new LinkedHashMap();
      if ((paramInt2 != -1) && (paramInt2 != 0)) {
        localMap.put("errCode", Integer.valueOf(paramInt2));
      }
      if (paramMap != null) {
        localMap.putAll(paramMap);
      }
      paramJsApiRequestSubscribeMessage = paramJsApiRequestSubscribeMessage.m(paramString, localMap);
      Log.i("JsApiRequestSubscribeMessage", s.X("[callbackJsApi] return json:", paramJsApiRequestSubscribeMessage));
      paramString = ah.aiuX;
      paramd.callback(paramInt1, paramJsApiRequestSubscribeMessage);
      AppMethodBeat.o(50598);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.JsApiRequestSubscribeMessage
 * JD-Core Version:    0.7.0.1
 */