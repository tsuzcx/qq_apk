package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.f.h;
import com.tencent.f.i;
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
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask;", "Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "username", "", "appid", "appType", "", "tmplIds", "", "type", "jsapi", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "callbackId", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage;Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;I)V", "Ljava/lang/Integer;", "getSubscribeMsgListExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "getGetSubscribeMsgListExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "setGetSubscribeMsgListExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;)V", "isCgiRequestSuccess", "", "()Z", "setCgiRequestSuccess", "(Z)V", "requestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "getRequestResult", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "setRequestResult", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;)V", "subscribeMsgExecutor", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "getSubscribeMsgExecutor", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "setSubscribeMsgExecutor", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;)V", "callbackJsApi", "", "status", "retMap", "", "", "errorCode", "createGetSubscribeMsgListListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "createSubscribeMsgListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "describeContents", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "result", "parseFromParcel", "p", "runInClientProcess", "runInMainProcess", "writeToParcel", "flags", "Companion", "luggage-wechat-full-sdk_release"})
final class JsApiRequestSubscribeMessage$SubscribeMsgTask
  extends CompatProcessTask
  implements b.c
{
  public static final Parcelable.Creator<SubscribeMsgTask> CREATOR;
  public static final JsApiRequestSubscribeMessage.SubscribeMsgTask.a mfP;
  SubscribeMsgRequestResult mfI;
  private com.tencent.luggage.sdk.b.a.c.d mfJ;
  private Integer mfK;
  private JsApiRequestSubscribeMessage mfL;
  private GetSubscribeMsgListExecutor mfM;
  SubscribeMsgExecutor mfN;
  private boolean mfO;
  private int type;
  private String username;
  
  static
  {
    AppMethodBeat.i(50617);
    mfP = new JsApiRequestSubscribeMessage.SubscribeMsgTask.a((byte)0);
    CREATOR = (Parcelable.Creator)new JsApiRequestSubscribeMessage.SubscribeMsgTask.b();
    AppMethodBeat.o(50617);
  }
  
  public JsApiRequestSubscribeMessage$SubscribeMsgTask(Parcel paramParcel)
  {
    this(str1, paramParcel.readInt());
    AppMethodBeat.i(50616);
    this.mfI = ((SubscribeMsgRequestResult)paramParcel.readParcelable(SubscribeMsgRequestResult.class.getClassLoader()));
    this.mfM = ((GetSubscribeMsgListExecutor)paramParcel.readParcelable(GetSubscribeMsgListExecutor.class.getClassLoader()));
    this.mfN = ((SubscribeMsgExecutor)paramParcel.readParcelable(SubscribeMsgExecutor.class.getClassLoader()));
    paramParcel = this.mfM;
    if (paramParcel == null) {
      p.hyc();
    }
    if (this.mfM == null) {
      p.hyc();
    }
    paramParcel.mfy = bHB();
    paramParcel = this.mfN;
    if (paramParcel == null) {
      p.hyc();
    }
    paramParcel.mfR = bHA();
    AppMethodBeat.o(50616);
  }
  
  private JsApiRequestSubscribeMessage$SubscribeMsgTask(String paramString, int paramInt)
  {
    AppMethodBeat.i(50614);
    this.username = paramString;
    this.type = paramInt;
    this.mfO = true;
    AppMethodBeat.o(50614);
  }
  
  public JsApiRequestSubscribeMessage$SubscribeMsgTask(String paramString1, String paramString2, int paramInt1, List<String> paramList, JsApiRequestSubscribeMessage paramJsApiRequestSubscribeMessage, com.tencent.luggage.sdk.b.a.c.d paramd, int paramInt2)
  {
    this(paramString1, 0);
    AppMethodBeat.i(50615);
    this.mfL = paramJsApiRequestSubscribeMessage;
    this.mfJ = paramd;
    this.mfK = Integer.valueOf(paramInt2);
    paramJsApiRequestSubscribeMessage = a.mfw;
    a.dB(paramString1, paramString2);
    paramString2 = new GetSubscribeMsgListExecutor(paramString1, paramList, bHB(), paramString2, paramInt1);
    paramList = (a.a)a.mfw;
    p.h(paramList, "<set-?>");
    paramString2.mfx = paramList;
    this.mfM = paramString2;
    paramString1 = new SubscribeMsgExecutor(paramString1, bHA());
    paramString2 = (a.a)a.mfw;
    p.h(paramString2, "<set-?>");
    paramString1.mfx = paramString2;
    this.mfN = paramString1;
    AppMethodBeat.o(50615);
  }
  
  private final void a(String paramString, Map<String, ? extends Object> paramMap, int paramInt)
  {
    AppMethodBeat.i(50607);
    Object localObject = JsApiRequestSubscribeMessage.mfH;
    localObject = this.mfJ;
    if (localObject == null) {
      p.hyc();
    }
    JsApiRequestSubscribeMessage localJsApiRequestSubscribeMessage = this.mfL;
    if (localJsApiRequestSubscribeMessage == null) {
      p.hyc();
    }
    Integer localInteger = this.mfK;
    if (localInteger == null) {
      p.hyc();
    }
    JsApiRequestSubscribeMessage.a.a((com.tencent.luggage.sdk.b.a.c.d)localObject, localJsApiRequestSubscribeMessage, localInteger.intValue(), paramString, paramMap, paramInt);
    AppMethodBeat.o(50607);
  }
  
  private final SubscribeMsgExecutor.c bHA()
  {
    AppMethodBeat.i(50605);
    SubscribeMsgExecutor.c localc = (SubscribeMsgExecutor.c)new d(this);
    AppMethodBeat.o(50605);
    return localc;
  }
  
  private final GetSubscribeMsgListExecutor.c bHB()
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
    Log.i("JsApiRequestSubscribeMessage", "onNetSceneEndCallback errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " result" + paramSubscribeMsgRequestResult);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mfO = bool;
      this.mfI = paramSubscribeMsgRequestResult;
      h.RTc.b((Runnable)new CompatProcessTask.a(this), "CompatProcessTask_" + bjl());
      AppMethodBeat.o(50609);
      return;
    }
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(50610);
    Object localObject1;
    Object localObject2;
    Object localObject4;
    List localList;
    Object localObject5;
    if (this.type == 0)
    {
      localObject1 = this.mfM;
      if (localObject1 != null)
      {
        localObject2 = b.a.jzu;
        localObject2 = ((GetSubscribeMsgListExecutor)localObject1).username;
        localObject3 = ((GetSubscribeMsgListExecutor)localObject1).mfA;
        localObject4 = (b.c)localObject1;
        p.h(localObject2, "username");
        p.h(localObject3, "templateIds");
        localObject2 = new com.tencent.mm.msgsubscription.a.b((String)localObject2, 2);
        com.tencent.mm.msgsubscription.a.b.a((com.tencent.mm.msgsubscription.a.b)localObject2, (b.c)localObject4);
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localList = com.tencent.mm.msgsubscription.a.b.a((com.tencent.mm.msgsubscription.a.b)localObject2);
          localObject5 = new efc();
          ((efc)localObject5).Mqy = ((String)localObject4);
          localList.add(localObject5);
        }
        ((com.tencent.mm.msgsubscription.a.b)localObject2).a(((GetSubscribeMsgListExecutor)localObject1).mfx);
        AppMethodBeat.o(50610);
        return;
      }
      AppMethodBeat.o(50610);
      return;
    }
    Object localObject3 = this.mfN;
    if (localObject3 != null)
    {
      if (((SubscribeMsgExecutor)localObject3).jzq != null) {}
      for (int i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        localObject1 = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50610);
        throw ((Throwable)localObject1);
      }
      localObject1 = b.a.jzu;
      localObject4 = ((SubscribeMsgExecutor)localObject3).username;
      localList = ((SubscribeMsgExecutor)localObject3).mfT;
      localObject5 = (b.c)localObject3;
      localObject2 = ((SubscribeMsgExecutor)localObject3).mfS;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      localObject2 = ((SubscribeMsgExecutor)localObject3).jzq;
      p.h(localObject4, "username");
      p.h(localList, "templates");
      p.h(localObject1, "byteArray");
      b.a.a.a((String)localObject4, "", localList, "", (b.c)localObject5, true, (byte[])localObject1, (SubscribeMsgRequestDialogUiData)localObject2).a(((SubscribeMsgExecutor)localObject3).mfx);
      AppMethodBeat.o(50610);
      return;
    }
    AppMethodBeat.o(50610);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(50611);
    Object localObject4;
    Object localObject5;
    try
    {
      if ((!this.mfO) || (this.mfI == null))
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
        localObject1 = this.mfI;
        if (localObject1 == null) {
          p.hyc();
        }
        if (((SubscribeMsgRequestResult)localObject1).jyu != 0)
        {
          localObject1 = new StringBuilder("fail:");
          localObject4 = this.mfI;
          if (localObject4 == null) {
            p.hyc();
          }
          localObject1 = ((SubscribeMsgRequestResult)localObject4).jyv;
          localObject4 = this.mfI;
          if (localObject4 == null) {
            p.hyc();
          }
          a(this, (String)localObject1, ((SubscribeMsgRequestResult)localObject4).jyu, 2);
          return;
        }
      }
      if (this.type != 0) {
        break label234;
      }
      Object localObject1 = this.mfM;
      if (localObject1 != null)
      {
        localObject4 = this.mfJ;
        if (localObject4 == null) {
          p.hyc();
        }
        localObject4 = ((com.tencent.luggage.sdk.b.a.c.d)localObject4).getContext();
        p.g(localObject4, "service!!.context");
        localObject5 = this.mfI;
        if (localObject5 == null) {
          p.hyc();
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
    Object localObject3 = this.mfN;
    if (localObject3 != null)
    {
      localObject4 = this.mfJ;
      if (localObject4 == null) {
        p.hyc();
      }
      localObject5 = ((com.tencent.luggage.sdk.b.a.c.d)localObject4).getContext();
      p.g(localObject5, "service!!.context");
      localObject4 = this.mfI;
      if (localObject4 == null) {
        p.hyc();
      }
      p.h(localObject5, "context");
      p.h(localObject4, "result");
      localObject3 = ((SubscribeMsgExecutor)localObject3).mfR;
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
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.type);
    paramParcel.writeParcelable((Parcelable)this.mfI, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mfM, paramInt);
    paramParcel.writeParcelable((Parcelable)this.mfN, paramInt);
    if (this.mfO) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(50612);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements GetSubscribeMsgListExecutor.c
  {
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(50602);
      p.h(paramString, "errMsg");
      this.mfQ.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
      AppMethodBeat.o(50602);
    }
    
    public final void a(String paramString, List<SubscribeMsgTmpItem> paramList, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
    {
      AppMethodBeat.i(50601);
      p.h(paramString, "username");
      p.h(paramList, "items");
      paramString = this.mfQ.mfN;
      if (paramString != null)
      {
        paramList = j.v((Collection)paramList);
        p.h(paramList, "value");
        paramString.mfT.clear();
        paramString.mfT.addAll((Collection)paramList);
      }
      paramList = this.mfQ.mfN;
      if (paramList != null)
      {
        paramString = this.mfQ.mfI;
        if (paramString == null) {
          break label137;
        }
      }
      label137:
      for (paramString = paramString.buffer;; paramString = null)
      {
        paramList.mfS = paramString;
        paramString = this.mfQ.mfN;
        if (paramString != null) {
          paramString.jzq = paramSubscribeMsgRequestDialogUiData;
        }
        JsApiRequestSubscribeMessage.SubscribeMsgTask.b(this.mfQ);
        this.mfQ.bjm();
        AppMethodBeat.o(50601);
        return;
      }
    }
    
    public final void b(k paramk)
    {
      AppMethodBeat.i(50600);
      p.h(paramk, "dialog");
      Object localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.mfQ);
      if (localObject != null)
      {
        localObject = ((com.tencent.luggage.sdk.b.a.c.d)localObject).getWindowAndroid();
        if ((localObject != null) && (((c)localObject).bsj() == true)) {
          if ((paramk instanceof com.tencent.mm.msgsubscription.ui.b)) {
            break label114;
          }
        }
      }
      label114:
      for (localObject = null;; localObject = paramk)
      {
        localObject = (com.tencent.mm.msgsubscription.ui.b)localObject;
        if (localObject != null) {
          ((com.tencent.mm.msgsubscription.ui.b)localObject).setPosition(1);
        }
        localObject = JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.mfQ);
        if (localObject != null)
        {
          localObject = ((com.tencent.luggage.sdk.b.a.c.d)localObject).NP();
          if (localObject != null)
          {
            localObject = ((com.tencent.luggage.sdk.d.d)localObject).brn();
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createSubscribeMsgListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"})
  public static final class d
    implements SubscribeMsgExecutor.c
  {
    public final void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(50604);
      p.h(paramString, "errMsg");
      this.mfQ.a(paramInt1, paramInt2, paramString, paramSubscribeMsgRequestResult);
      AppMethodBeat.o(50604);
    }
    
    public final void c(SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
    {
      AppMethodBeat.i(50603);
      p.h(paramSubscribeMsgRequestResult, "result");
      if (paramSubscribeMsgRequestResult.jyw)
      {
        JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.mfQ, "cancel", 0, 6);
        AppMethodBeat.o(50603);
        return;
      }
      HashMap localHashMap = new HashMap();
      paramSubscribeMsgRequestResult = ((Iterable)paramSubscribeMsgRequestResult.jyk).iterator();
      while (paramSubscribeMsgRequestResult.hasNext())
      {
        SubscribeMsgTmpItem localSubscribeMsgTmpItem = (SubscribeMsgTmpItem)paramSubscribeMsgRequestResult.next();
        ((Map)localHashMap).put(localSubscribeMsgTmpItem.ixM, localSubscribeMsgTmpItem.jyE);
      }
      JsApiRequestSubscribeMessage.SubscribeMsgTask.a(this.mfQ, "ok", (Map)localHashMap);
      AppMethodBeat.o(50603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.JsApiRequestSubscribeMessage.SubscribeMsgTask
 * JD-Core Version:    0.7.0.1
 */