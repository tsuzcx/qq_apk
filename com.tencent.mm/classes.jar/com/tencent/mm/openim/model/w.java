package com.tencent.mm.openim.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.api.c;
import com.tencent.mm.openim.api.c.b;
import com.tencent.mm.openim.api.h.b;
import com.tencent.mm.openim.ui.e;
import com.tencent.mm.openim.ui.e.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.b;
import kotlin.d.d<-Lkotlin.r<Ljava.lang.Integer;Ljava.lang.String;>;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/model/OpenIMKefuConfirmController;", "Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "cancelled", "", "confirmPageListener", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel$ConfirmPageListener;", "confirmPageType", "", "getConfirmPageType", "()I", "confirmPageType$delegate", "Lkotlin/Lazy;", "confirmType", "contactInfo", "Lcom/tencent/mm/openim/api/IOpenIMKefuContact;", "errToast", "", "getErrToast", "()Ljava/lang/String;", "errToast$delegate", "getConfirmInfoListener", "com/tencent/mm/openim/model/OpenIMKefuConfirmController$getConfirmInfoListener$1", "Lcom/tencent/mm/openim/model/OpenIMKefuConfirmController$getConfirmInfoListener$1;", "getContactScene", "getGetContactScene", "getContactScene$delegate", "intent", "Landroid/content/Intent;", "isAddContactLoading", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "resultReceiver", "Landroid/os/ResultReceiver;", "getResultReceiver", "()Landroid/os/ResultReceiver;", "resultReceiver$delegate", "session", "", "getSession", "()J", "session$delegate", "showErrToast", "getShowErrToast", "()Z", "showErrToast$delegate", "startConversationRequest", "Lcom/tencent/mm/openim/api/OpenIMKefuStartConversationRequest;", "uiModel", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel;", "addKefuConversation", "", "cancel", "checkAppBrandBindState", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirm", "createUIModel", "dismissProgressDialog", "fetchConfirmInfo", "request", "finishUI", "resultCode", "errCode", "data", "errMsg", "finishWhenCancel", "finishWhenConfirmFailed", "getScene", "onConfirm", "onConfirmOpFailed", "onConfirmOpSuccess", "onCreate", "release", "requestCheckBindState", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setConfirmPageListener", "listener", "showErrDialog", "errType", "showProgressDialog", "start", "startKefuChatting", "contact", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  implements IOpenIMKefuConfirmController
{
  public static final w.a psG;
  private boolean cancelled;
  private final Activity hHU;
  public Intent intent;
  private int prq;
  private e psH;
  public e.a psI;
  public OpenIMKefuStartConversationRequest psJ;
  private com.tencent.mm.openim.api.a psK;
  private final kotlin.j psL;
  private final kotlin.j psM;
  private final kotlin.j psN;
  private final kotlin.j psO;
  private boolean psP;
  private final g psQ;
  private com.tencent.mm.ui.base.w psR;
  private final kotlin.j psS;
  private final kotlin.j psT;
  
  static
  {
    AppMethodBeat.i(235976);
    psG = new w.a((byte)0);
    AppMethodBeat.o(235976);
  }
  
  public w(Activity paramActivity)
  {
    AppMethodBeat.i(235837);
    this.hHU = paramActivity;
    this.prq = -1;
    this.psL = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.psM = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.psN = kotlin.k.cm((kotlin.g.a.a)new k(this));
    this.psO = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.psQ = new g(this);
    this.psS = kotlin.k.cm((kotlin.g.a.a)new l(this));
    this.psT = kotlin.k.cm((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(235837);
  }
  
  private final Object Q(kotlin.d.d<? super r<Integer, String>> paramd)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235859);
    Object localObject2;
    if ((paramd instanceof c))
    {
      localObject2 = (c)paramd;
      if ((((c)localObject2).label & 0x80000000) != 0) {
        ((c)localObject2).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super r<Integer, String>>)localObject2;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235859);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    for (;;)
    {
      try
      {
        localObject2 = this.psJ;
        if (localObject2 == null)
        {
          localObject2 = (CharSequence)localObject1;
          if (localObject2 == null) {
            break label484;
          }
          if (((CharSequence)localObject2).length() != 0) {
            break label489;
          }
          break label484;
          if (i != 0)
          {
            paramd = new r(Integer.valueOf(5), "request invalid");
            AppMethodBeat.o(235859);
            return paramd;
          }
        }
        else
        {
          localObject2 = ((OpenIMKefuStartConversationRequest)localObject2).prG;
          if (localObject2 == null) {
            continue;
          }
          localObject1 = ((Intent)localObject2).getStringExtra("key_appbrand_check_bind_info");
          continue;
        }
        Object localObject3 = new JSONObject((String)localObject1);
        paramd.label = 1;
        localObject1 = new kotlin.d.h(b.au(paramd));
        localObject2 = (kotlin.d.d)localObject1;
        Log.i("MicroMsg.OpenIMKefuConfirmController", s.X("checkAppBrandBindState data: ", localObject3));
        JSONObject localJSONObject = new JSONObject(((JSONObject)localObject3).optString("extInfo"));
        com.tencent.mm.am.c.a locala1 = new com.tencent.mm.am.c.a();
        locala1.funcId = 6803;
        locala1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/checkappcustomerservicebind";
        zq localzq = new zq();
        localzq.Zim = localJSONObject.optString("url");
        localzq.appid = ((JSONObject)localObject3).optString("appId");
        localzq.Zil = ((JSONObject)localObject3).optString("corpId");
        localObject3 = ah.aiuX;
        locala1.otE = ((com.tencent.mm.bx.a)localzq);
        locala1.otF = ((com.tencent.mm.bx.a)new zr());
        IPCRunCgi.a(locala1.bEF(), (IPCRunCgi.a)new w.i((kotlin.d.d)localObject2));
        localObject1 = ((kotlin.d.h)localObject1).kli();
        if (localObject1 == kotlin.d.a.a.aiwj) {
          s.u(paramd, "frame");
        }
        paramd = (kotlin.d.d<? super r<Integer, String>>)localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(235859);
          return locala;
          ResultKt.throwOnFailure(localObject2);
          paramd = (kotlin.d.d<? super r<Integer, String>>)localObject2;
        }
        AppMethodBeat.o(235859);
        return paramd;
      }
      catch (Exception paramd)
      {
        Log.printErrStackTrace("MicroMsg.OpenIMKefuConfirmController", (Throwable)paramd, "checkAppBrandBindState exception", new Object[0]);
        paramd = new r(Integer.valueOf(6), "check failed");
        AppMethodBeat.o(235859);
        return paramd;
      }
      label484:
      int i = 1;
      continue;
      label489:
      i = 0;
    }
  }
  
  private static final void a(w paramw)
  {
    AppMethodBeat.i(235879);
    s.u(paramw, "this$0");
    Object localObject = paramw.psK;
    if ((localObject == null) || (!((com.tencent.mm.openim.api.a)localObject).isValid()))
    {
      Log.e("MicroMsg.OpenIMKefuConfirmController", "alvinluo startKefuChatting contact invalid");
      paramw.aa(2, "get contact failed");
    }
    for (;;)
    {
      localObject = paramw.psH;
      if (localObject != null) {
        ((e)localObject).bSn();
      }
      localObject = paramw.bSk();
      paramw.bSj();
      z.c((ResultReceiver)localObject, true, 0, "");
      AppMethodBeat.o(235879);
      return;
      if (paramw.psJ == null)
      {
        Log.e("MicroMsg.OpenIMKefuConfirmController", "alvinluo startKefuChatting request invalid");
        paramw.aa(5, "request invalid");
      }
      else
      {
        Log.i("MicroMsg.OpenIMKefuConfirmController", s.X("alvinluo startKefuChatting username: ", ((com.tencent.mm.openim.api.a)localObject).getUsername()));
        OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = paramw.psJ;
        if (localOpenIMKefuStartConversationRequest != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_is_confirm_page_shown", h.b.xE(paramw.prq));
          ah localah = ah.aiuX;
          localOpenIMKefuStartConversationRequest.prF = localIntent;
          localOpenIMKefuStartConversationRequest.context = ((Context)paramw.hHU);
          if (localOpenIMKefuStartConversationRequest.pry == null) {
            localOpenIMKefuStartConversationRequest.pry = new du();
          }
          localOpenIMKefuStartConversationRequest.pry.username = ((com.tencent.mm.openim.api.a)localObject).getUsername();
        }
        localObject = (com.tencent.mm.openim.api.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.d.class);
        localOpenIMKefuStartConversationRequest = paramw.psJ;
        s.checkNotNull(localOpenIMKefuStartConversationRequest);
        ((com.tencent.mm.openim.api.d)localObject).b(localOpenIMKefuStartConversationRequest);
      }
    }
  }
  
  private static final void a(w paramw, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(235883);
    s.u(paramw, "this$0");
    paramw.cancel();
    AppMethodBeat.o(235883);
  }
  
  private static final void a(w paramw, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(235889);
    s.u(paramw, "this$0");
    paramDialogInterface = paramw.bSk();
    paramw.bSj();
    z.b(paramDialogInterface, false, 7, "contact is deleted");
    paramw.aa(7, "contact is deleted");
    AppMethodBeat.o(235889);
  }
  
  private final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(235863);
    Log.e("MicroMsg.OpenIMKefuConfirmController", "alvinluo finishUI errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_result_err_code", paramInt);
    localIntent.putExtra("key_result_err_msg", paramString);
    paramString = ah.aiuX;
    b(paramInt, localIntent);
    AppMethodBeat.o(235863);
  }
  
  private static final void b(w paramw)
  {
    AppMethodBeat.i(235891);
    s.u(paramw, "this$0");
    if (((CharSequence)paramw.bSm()).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Toast.makeText((Context)paramw.hHU, (CharSequence)paramw.bSm(), 0).show();
      AppMethodBeat.o(235891);
      return;
    }
    Toast.makeText((Context)paramw.hHU, (CharSequence)paramw.hHU.getString(c.h.open_im_kefu_confirm_error_default_tips), 0).show();
    AppMethodBeat.o(235891);
  }
  
  private static final void b(w paramw, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(235887);
    s.u(paramw, "this$0");
    paramw.cancel();
    AppMethodBeat.o(235887);
  }
  
  private final void bQa()
  {
    int i = 1;
    AppMethodBeat.i(235873);
    com.tencent.mm.ui.base.w localw = this.psR;
    if ((localw != null) && (localw.isShowing() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localw = this.psR;
        if (localw != null) {
          localw.dismiss();
        }
      }
      AppMethodBeat.o(235873);
      return;
      i = 0;
    }
  }
  
  private final long bSj()
  {
    AppMethodBeat.i(235840);
    long l = ((Number)this.psN.getValue()).longValue();
    AppMethodBeat.o(235840);
    return l;
  }
  
  private final ResultReceiver bSk()
  {
    AppMethodBeat.i(235843);
    ResultReceiver localResultReceiver = (ResultReceiver)this.psO.getValue();
    AppMethodBeat.o(235843);
    return localResultReceiver;
  }
  
  private final boolean bSl()
  {
    AppMethodBeat.i(235845);
    boolean bool = ((Boolean)this.psS.getValue()).booleanValue();
    AppMethodBeat.o(235845);
    return bool;
  }
  
  private final String bSm()
  {
    AppMethodBeat.i(235850);
    String str = (String)this.psT.getValue();
    AppMethodBeat.o(235850);
    return str;
  }
  
  private final void bSn()
  {
    AppMethodBeat.i(235868);
    this.psP = false;
    if (this.cancelled)
    {
      AppMethodBeat.o(235868);
      return;
    }
    bQa();
    com.tencent.threadpool.h.ahAA.bk(new w..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(235868);
  }
  
  private final void bSo()
  {
    AppMethodBeat.i(235876);
    if (!bSl())
    {
      AppMethodBeat.o(235876);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new w..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(235876);
  }
  
  private final void c(OpenIMKefuStartConversationRequest paramOpenIMKefuStartConversationRequest)
  {
    AppMethodBeat.i(235870);
    int i = paramOpenIMKefuStartConversationRequest.prw;
    Object localObject1 = paramOpenIMKefuStartConversationRequest.pry;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = paramOpenIMKefuStartConversationRequest.pry;
      if (localObject2 != null) {
        break label124;
      }
      localObject2 = "";
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.openim.api.i(i, (String)localObject1, (String)localObject2);
      ((com.tencent.mm.openim.api.i)localObject1).prl = false;
      ((com.tencent.mm.openim.api.i)localObject1).prn = paramOpenIMKefuStartConversationRequest.prE;
      ((com.tencent.mm.openim.api.i)localObject1).pro = true;
      ((c)com.tencent.mm.kernel.h.ax(c.class)).b((com.tencent.mm.openim.api.i)localObject1, (com.tencent.mm.openim.api.c.a)new f(this));
      AppMethodBeat.o(235870);
      return;
      localObject2 = ((du)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label124:
      String str = ((du)localObject2).url;
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
    }
  }
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(236023);
    Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo finishUI resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(-1), Boolean.FALSE });
    if ((paramInt != 0) && (paramInt != 3) && (paramInt != 7)) {
      bSo();
    }
    this.hHU.setResult(-1, paramIntent);
    this.hHU.finish();
    release();
    AppMethodBeat.o(236023);
  }
  
  public final boolean bSg()
  {
    AppMethodBeat.i(236044);
    if ((h.b.xE(this.prq)) && (this.psP)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo finishWhenCancel: %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(236044);
      return true;
    }
    AppMethodBeat.o(236044);
    return false;
  }
  
  public final boolean bSh()
  {
    OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = this.psJ;
    if ((localOpenIMKefuStartConversationRequest != null) && (localOpenIMKefuStartConversationRequest.prw == 1))
    {
      i = 1;
      if (i != 0) {
        break label58;
      }
      localOpenIMKefuStartConversationRequest = this.psJ;
      if ((localOpenIMKefuStartConversationRequest == null) || (localOpenIMKefuStartConversationRequest.prw != 2)) {
        break label53;
      }
    }
    label53:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label58;
      }
      return true;
      i = 0;
      break;
    }
    label58:
    return false;
  }
  
  public final int bSi()
  {
    AppMethodBeat.i(236005);
    int i = ((Number)this.psL.getValue()).intValue();
    AppMethodBeat.o(236005);
    return i;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(236017);
    Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo cancelConfirmPage confirmPageType: %s, confirmType: %s", new Object[] { Integer.valueOf(bSi()), Integer.valueOf(this.prq) });
    this.cancelled = true;
    Object localObject = bSk();
    bSj();
    z.a((ResultReceiver)localObject, "user cancel");
    if (this.psH == null)
    {
      aa(3, "user cancel");
      AppMethodBeat.o(236017);
      return;
    }
    localObject = this.psH;
    if (localObject != null) {
      ((e)localObject).bSv();
    }
    AppMethodBeat.o(236017);
  }
  
  public final int getScene()
  {
    OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = this.psJ;
    if (localOpenIMKefuStartConversationRequest == null) {
      return -1;
    }
    return localOpenIMKefuStartConversationRequest.prw;
  }
  
  public final void release()
  {
    AppMethodBeat.i(236011);
    bQa();
    e locale = this.psH;
    if (locale != null) {
      locale.release();
    }
    this.psH = null;
    AppMethodBeat.o(236011);
  }
  
  public final void start()
  {
    AppMethodBeat.i(236008);
    if (this.psJ == null)
    {
      this.psQ.ab(5, "request invalid");
      aa(5, "request invalid");
      AppMethodBeat.o(236008);
      return;
    }
    this.psR = com.tencent.mm.ui.base.k.a((Context)this.hHU, this.hHU.getString(c.h.app_loading), true, new w..ExternalSyntheticLambda1(this));
    final OpenIMKefuStartConversationRequest localOpenIMKefuStartConversationRequest = this.psJ;
    s.checkNotNull(localOpenIMKefuStartConversationRequest);
    if (((Number)this.psM.getValue()).intValue() == 8)
    {
      kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (m)new m(this, localOpenIMKefuStartConversationRequest, null), 3);
      AppMethodBeat.o(236008);
      return;
    }
    c(localOpenIMKefuStartConversationRequest);
    AppMethodBeat.o(236008);
  }
  
  public final void xH(int paramInt)
  {
    String str = null;
    AppMethodBeat.i(236036);
    Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo confirm confirmType: %s", new Object[] { Integer.valueOf(paramInt) });
    this.cancelled = false;
    Object localObject1 = this.psH;
    if (localObject1 != null) {
      ((e)localObject1).bSs();
    }
    label125:
    com.tencent.mm.openim.api.k localk;
    Bundle localBundle;
    if (h.b.xF(paramInt))
    {
      localObject1 = this.psR;
      if ((localObject1 != null) && (((com.tencent.mm.ui.base.w)localObject1).isShowing() == true))
      {
        paramInt = 1;
        if (paramInt == 0) {
          this.psR = com.tencent.mm.ui.base.k.a((Context)this.hHU, this.hHU.getString(c.h.app_waiting), true, new w..ExternalSyntheticLambda0(this));
        }
        localObject1 = this.psK;
        if (localObject1 != null) {
          break label391;
        }
        localObject1 = "";
        localk = new com.tencent.mm.openim.api.k((String)localObject1);
        localBundle = new Bundle();
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = this.psJ;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = this.psJ;
        if ((localObject1 == null) || (((OpenIMKefuStartConversationRequest)localObject1).prE != true)) {
          break label529;
        }
        paramInt = 1;
        if (paramInt == 0) {
          continue;
        }
        localObject1 = this.psK;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        localObject1 = (CharSequence)localObject1;
        if (localObject1 == null) {
          break label524;
        }
        if (((CharSequence)localObject1).length() != 0) {
          break label534;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        label391:
        Log.printErrStackTrace("MicroMsg.OpenIMKefuConfirmController", (Throwable)localException, "alvinluo addKefuConversation exception", new Object[0]);
        continue;
      }
      if (paramInt == 0)
      {
        localObject1 = this.psJ;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        localObject2 = this.psK;
        if (localObject2 != null) {
          continue;
        }
        localObject2 = null;
        Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo addKefuConversation updateTicket old: %s, new: %s", new Object[] { localObject1, localObject2 });
        localObject1 = this.psJ;
        if (localObject1 != null) {
          continue;
        }
        localObject2 = str;
        if (localObject2 != null)
        {
          localObject1 = this.psK;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = "";
          ((du)localObject2).YFW = ((String)localObject1);
        }
      }
      localObject1 = com.tencent.mm.openim.api.k.prs;
      localObject1 = com.tencent.mm.openim.api.k.bSa();
      localObject2 = this.psJ;
      s.checkNotNull(localObject2);
      localObject2 = ((OpenIMKefuStartConversationRequest)localObject2).pry;
      s.checkNotNull(localObject2);
      localBundle.putByteArray((String)localObject1, ((du)localObject2).toByteArray());
      localObject1 = ah.aiuX;
      localk.hPH = localBundle;
      localk.prt = ((c.b)new w.b(this));
      this.psP = true;
      ((c)com.tencent.mm.kernel.h.ax(c.class)).a(localk);
      AppMethodBeat.o(236036);
      return;
      paramInt = 0;
      break;
      localObject2 = ((com.tencent.mm.openim.api.a)localObject1).getUsername();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label125;
      }
      localObject1 = "";
      break label125;
      localObject1 = ((OpenIMKefuStartConversationRequest)localObject1).pry;
      continue;
      localObject1 = ((com.tencent.mm.openim.api.a)localObject1).bIQ();
      continue;
      localObject1 = ((OpenIMKefuStartConversationRequest)localObject1).pry;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((du)localObject1).YFW;
        continue;
        localObject2 = ((com.tencent.mm.openim.api.a)localObject2).bIQ();
        continue;
        localObject2 = ((OpenIMKefuStartConversationRequest)localObject1).pry;
        continue;
        str = ((com.tencent.mm.openim.api.a)localObject1).bIQ();
        localObject1 = str;
        if (str == null)
        {
          localObject1 = "";
          continue;
          bSn();
          AppMethodBeat.o(236036);
          return;
          label524:
          paramInt = 1;
          continue;
          label529:
          paramInt = 0;
          continue;
          label534:
          paramInt = 0;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    int label;
    
    c(w paramw, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235787);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = w.a(this.psU, (kotlin.d.d)this);
      AppMethodBeat.o(235787);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    d(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<String>
  {
    e(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/model/OpenIMKefuConfirmController$fetchConfirmInfo$1", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "onFinish", "", "result", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "onTryFetch", "username", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.openim.api.c.a
  {
    f(w paramw) {}
    
    public final void RF(String paramString)
    {
      AppMethodBeat.i(235799);
      Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo onTryFetch username: %s", new Object[] { paramString });
      AppMethodBeat.o(235799);
    }
    
    public final void a(com.tencent.mm.openim.api.j paramj)
    {
      Object localObject3 = null;
      AppMethodBeat.i(235797);
      Object localObject1;
      if (paramj == null)
      {
        localObject1 = null;
        StringBuilder localStringBuilder = new StringBuilder("alvinluo fetchConfirmInfo onFinish isValid: ");
        if (localObject1 != null) {
          break label193;
        }
        localObject2 = null;
        label32:
        localStringBuilder = localStringBuilder.append(localObject2).append(", cancelled: ").append(w.e(this.psU)).append(", confirmType: ");
        if (paramj != null) {
          break label207;
        }
        localObject2 = null;
        label68:
        localStringBuilder = localStringBuilder.append(localObject2).append(", confirmPageType: ");
        localObject2 = w.f(this.psU);
        if (localObject2 != null) {
          break label219;
        }
        localObject2 = null;
        label99:
        localStringBuilder = localStringBuilder.append(localObject2).append(", ");
        if (localObject1 != null) {
          break label232;
        }
        localObject2 = localObject3;
        label121:
        Log.i("MicroMsg.OpenIMKefuConfirmController", localObject2);
        w.a(this.psU, (com.tencent.mm.openim.api.a)localObject1);
        localObject2 = this.psU;
        if (paramj != null) {
          break label243;
        }
      }
      label193:
      label207:
      label219:
      label232:
      label243:
      for (int i = 3;; i = paramj.prq)
      {
        w.a((w)localObject2, i);
        if (!w.e(this.psU)) {
          break label251;
        }
        this.psU.release();
        AppMethodBeat.o(235797);
        return;
        localObject1 = paramj.prp;
        break;
        localObject2 = Boolean.valueOf(((com.tencent.mm.openim.api.a)localObject1).isValid());
        break label32;
        localObject2 = Integer.valueOf(paramj.prq);
        break label68;
        localObject2 = Integer.valueOf(((OpenIMKefuStartConversationRequest)localObject2).prx);
        break label99;
        localObject2 = ((com.tencent.mm.openim.api.a)localObject1).bRT();
        break label121;
      }
      label251:
      if ((localObject1 != null) && (((com.tencent.mm.openim.api.a)localObject1).isValid() == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        localObject1 = w.g(this.psU);
        s.u(paramj, "getContactResult");
        localObject2 = w.c(((w.g)localObject1).psU);
        w.d(((w.g)localObject1).psU);
        z.b((ResultReceiver)localObject2, true, 0, "");
        if (w.k(((w.g)localObject1).psU) != null)
        {
          localObject2 = w.psG;
          if (h.b.xE(w.l(((w.g)localObject1).psU))) {}
        }
        else
        {
          w.a(((w.g)localObject1).psU, w.a(((w.g)localObject1).psU, w.m(((w.g)localObject1).psU), w.l(((w.g)localObject1).psU)));
          localObject2 = w.k(((w.g)localObject1).psU);
          if (localObject2 != null) {
            ((e)localObject2).a((IOpenIMKefuConfirmController)((w.g)localObject1).psU);
          }
        }
        localObject2 = w.psG;
        if (h.b.xE(w.l(((w.g)localObject1).psU)))
        {
          w.n(((w.g)localObject1).psU);
          if (w.o(((w.g)localObject1).psU) != null) {
            w.l(((w.g)localObject1).psU);
          }
          localObject2 = w.c(((w.g)localObject1).psU);
          w.d(((w.g)localObject1).psU);
          z.a((ResultReceiver)localObject2);
        }
        localObject2 = w.k(((w.g)localObject1).psU);
        if (localObject2 != null) {
          ((e)localObject2).a(w.l(((w.g)localObject1).psU), w.m(((w.g)localObject1).psU), paramj);
        }
        AppMethodBeat.o(235797);
        return;
      }
      Object localObject2 = w.g(this.psU);
      if (paramj == null)
      {
        i = -1;
        if (paramj != null) {
          break label550;
        }
        paramj = "";
      }
      for (;;)
      {
        ((w.g)localObject2).ab(i, paramj);
        AppMethodBeat.o(235797);
        return;
        i = paramj.errCode;
        break;
        label550:
        localObject1 = paramj.errMsg;
        paramj = (com.tencent.mm.openim.api.j)localObject1;
        if (localObject1 == null) {
          paramj = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/model/OpenIMKefuConfirmController$getConfirmInfoListener$1", "Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController$OnGetConfirmInfoListener;", "onGetConfirmInfoError", "", "errType", "", "errCode", "errMsg", "", "onGetConfirmInfoSuccess", "getContactResult", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
  {
    g(w paramw) {}
    
    public final void ab(int paramInt, String paramString)
    {
      AppMethodBeat.i(235796);
      s.u(paramString, "errMsg");
      if (!w.b(this.psU, paramInt, paramString))
      {
        paramString = w.c(this.psU);
        w.d(this.psU);
        z.b(paramString, false, 2, "get contact failed");
        w.a(this.psU, 2, "get contact failed");
      }
      AppMethodBeat.o(235796);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Integer>
  {
    h(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/os/ResultReceiver;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ResultReceiver>
  {
    j(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<Long>
  {
    k(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    l(w paramw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    m(w paramw, OpenIMKefuStartConversationRequest paramOpenIMKefuStartConversationRequest, kotlin.d.d<? super m> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(235814);
      paramObject = (kotlin.d.d)new m(this.psU, localOpenIMKefuStartConversationRequest, paramd);
      AppMethodBeat.o(235814);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235812);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235812);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.psU;
        localObject = (kotlin.d.d)this;
        this.label = 1;
        localObject = w.a(paramObject, (kotlin.d.d)localObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(235812);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (r)paramObject;
      if (((Number)paramObject.bsC).intValue() == 0)
      {
        localObject = w.c(this.psU);
        w.d(this.psU);
        z.a((ResultReceiver)localObject, true, ((Number)paramObject.bsC).intValue(), (String)paramObject.bsD);
        w.a(this.psU, localOpenIMKefuStartConversationRequest);
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(235812);
        return paramObject;
        w.a(this.psU, ((Number)paramObject.bsC).intValue(), (String)paramObject.bsD);
        localObject = w.c(this.psU);
        w.d(this.psU);
        z.a((ResultReceiver)localObject, false, ((Number)paramObject.bsC).intValue(), (String)paramObject.bsD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.model.w
 * JD-Core Version:    0.7.0.1
 */