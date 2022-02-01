package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.y;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.protocal.protobuf.fvl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "onNeedShowPrivacyInfo", "info", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "onAccept", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "userAgreementChecked", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends com.tencent.mm.plugin.appbrand.jsapi.c<ad>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final d.a rHE;
  
  static
  {
    AppMethodBeat.i(147931);
    rHE = new d.a((byte)0);
    NAME = "getPhoneNumber";
    CTRL_INDEX = 209;
    AppMethodBeat.o(147931);
  }
  
  private static final p.a a(final ad paramad, d paramd, j paramj, final com.tencent.mm.vending.j.c paramc)
  {
    AppMethodBeat.i(326669);
    s.u(paramad, "$env");
    s.u(paramd, "this$0");
    s.u(paramj, "$progressDialog");
    final com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a locala = a.b.e((com.tencent.mm.plugin.appbrand.g)paramad);
    Object localObject1 = z.tIm;
    Object localObject2 = paramad.getAppId();
    s.s(localObject2, "env.appId");
    y localy = ((z)localObject1).afD((String)localObject2);
    kotlin.g.a.b localb = (kotlin.g.a.b)new d.d(paramad);
    if (paramc == null)
    {
      localObject1 = null;
      if (paramc != null) {
        break label594;
      }
      paramc = null;
      label85:
      final com.tencent.mm.vending.g.b localb1 = com.tencent.mm.vending.g.g.jJV();
      if (paramad != null)
      {
        localObject2 = paramad.getDialogContainer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.appbrand.widget.dialog.r)localObject2).c((com.tencent.mm.plugin.appbrand.widget.dialog.n)paramj);
        }
      }
      localObject2 = ((com.tencent.mm.plugin.appbrand.config.n)paramad.aN(com.tencent.mm.plugin.appbrand.config.n.class)).hEy;
      paramj = (j)localObject2;
      if (localObject2 == null) {
        paramj = "";
      }
      locala.setAppBrandName(paramj);
      localObject2 = ((com.tencent.mm.plugin.appbrand.config.n)paramad.aN(com.tencent.mm.plugin.appbrand.config.n.class)).phA;
      paramj = (j)localObject2;
      if (localObject2 == null) {
        paramj = "";
      }
      locala.setIconUrl(paramj);
      if (paramc != null)
      {
        paramj = paramc.rHF;
        if (paramj != null)
        {
          paramj = paramj.abxn;
          if (paramj != null) {
            locala.setDialogSubDesc(paramj);
          }
        }
      }
      if (paramc != null)
      {
        paramj = paramc.rHF;
        if (paramj != null)
        {
          paramj = paramj.IGG;
          if (paramj != null) {
            locala.setDialogRequestDesc(paramj);
          }
        }
      }
      if (paramc != null) {
        locala.setDialogApplyWording(paramc.rgX);
      }
      locala.setOnDeny((kotlin.g.a.a)new g(localy, localb1));
      locala.setOnCancel((kotlin.g.a.a)new h(localy, localb1));
      locala.setOnAccept((kotlin.g.a.b)new d.i(localb));
      locala.setOnAddPhoneNumber((kotlin.g.a.a)new j(localy, paramad, locala));
      locala.setOnManagePhoneNumber((kotlin.g.a.a)new k(localy, paramad, locala));
      locala.setOnPhoneItemSelect((kotlin.g.a.b)new l(localy, paramad, paramc, localb1));
      if (!paramd.a(paramad, paramc)) {
        break label606;
      }
      locala.jc(true);
      locala.setOnExplain((kotlin.g.a.a)new f(localy, locala, paramad, paramc));
      label425:
      if (!(localObject1 instanceof ArrayList)) {
        break label617;
      }
      paramd = (ArrayList)localObject1;
      label439:
      paramj = paramd;
      if (paramd == null) {
        paramj = new ArrayList();
      }
      locala.setPhoneItems(paramj);
      if (paramc != null)
      {
        paramd = paramc.rHH;
        if ((paramd != null) && (paramd.rHj))
        {
          paramj = paramd.wording;
          s.s(paramj, "privacyProtectInfo.wording");
          if (kotlin.n.n.bp((CharSequence)paramj)) {
            break label622;
          }
        }
      }
    }
    label594:
    label606:
    label617:
    label622:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramd = paramd.wording;
        s.s(paramd, "privacyProtectInfo.wording");
        locala.setUserAgreementCheckBoxWording(paramd);
        locala.setIExternalToolsHelper((aj)paramad.T(aj.class));
      }
      locala.h((com.tencent.mm.plugin.appbrand.g)paramad);
      paramad = new p.a("ok", new Object[0]);
      AppMethodBeat.o(326669);
      return paramad;
      localObject1 = (List)paramc.get(0);
      break;
      paramc = (b)paramc.get(1);
      break label85;
      locala.jc(false);
      break label425;
      paramd = null;
      break label439;
    }
  }
  
  private static final com.tencent.mm.vending.j.c a(d paramd, final ad paramad, final String paramString, final boolean paramBoolean, com.tencent.mm.vending.j.c paramc)
  {
    AppMethodBeat.i(326659);
    s.u(paramd, "this$0");
    s.u(paramad, "$env");
    paramd = z.tIm;
    Object localObject = paramad.getAppId();
    s.s(localObject, "env.appId");
    localObject = paramd.afD((String)localObject);
    s.s(paramString, "apiName");
    int i;
    label104:
    final com.tencent.mm.vending.g.b localb;
    com.tencent.mm.plugin.appbrand.phonenumber.n localn;
    if (paramc == null)
    {
      paramd = null;
      if ((paramd != null) && (!paramd.isEmpty())) {
        paramd = paramd.iterator();
      }
      for (;;)
      {
        if (paramd.hasNext()) {
          if (((PhoneItem)paramd.next()).tGO)
          {
            i = 0;
            if (i != 0)
            {
              Log.e("MicroMsg.JsApiGetPhoneNumberNew", "phoneItems is null, tryToBindWechatPhoneNumber");
              if (localObject != null) {
                ((y)localObject).tHM = 1L;
              }
              localb = com.tencent.mm.vending.g.g.jJV();
              paramd = com.tencent.mm.plugin.appbrand.phonenumber.u.tHm;
              localn = com.tencent.mm.plugin.appbrand.phonenumber.u.cHB();
              if (paramad != null) {
                break label209;
              }
            }
          }
        }
      }
    }
    label209:
    for (paramd = null;; paramd = paramad.getContext())
    {
      s.s(paramd, "env?.context");
      localn.a(paramd, (kotlin.g.a.b)new e((y)localObject, paramad, paramString, paramBoolean, localb));
      AppMethodBeat.o(326659);
      return paramc;
      paramd = (List)paramc.get(0);
      break;
      i = 1;
      break label104;
    }
  }
  
  private static final com.tencent.mm.vending.j.c a(d paramd, ad paramad, String paramString, boolean paramBoolean, final List paramList)
  {
    AppMethodBeat.i(326652);
    s.u(paramd, "this$0");
    s.u(paramad, "$env");
    s.s(paramString, "apiName");
    paramd = z.tIm;
    Object localObject = paramad.getAppId();
    s.s(localObject, "env.appId");
    y localy = paramd.afD((String)localObject);
    localObject = com.tencent.mm.vending.g.g.jJV();
    if (localy != null) {
      if (localy != null) {
        break label128;
      }
    }
    label128:
    for (paramd = null;; paramd = Long.valueOf(localy.tHO))
    {
      s.checkNotNull(paramd);
      localy.tHO = (paramd.longValue() + 1L);
      paramd = paramad.getAppId();
      s.s(paramd, "env.appId");
      new com.tencent.mm.plugin.appbrand.phonenumber.d(paramd, paramString, paramBoolean).b((kotlin.g.a.r)new c((com.tencent.mm.vending.g.b)localObject, paramList));
      AppMethodBeat.o(326652);
      return null;
    }
  }
  
  private static final com.tencent.mm.vending.j.c a(com.tencent.mm.vending.j.c paramc)
  {
    AppMethodBeat.i(326664);
    Object localObject = com.tencent.mm.plugin.appbrand.phonenumber.r.tGQ;
    if (paramc == null) {}
    for (localObject = null;; localObject = (List)paramc.get(0))
    {
      com.tencent.mm.plugin.appbrand.phonenumber.r.dB((List)localObject);
      AppMethodBeat.o(326664);
      return paramc;
    }
  }
  
  private static final Object a(d paramd, j paramj, ad paramad, Void paramVoid)
  {
    AppMethodBeat.i(326638);
    s.u(paramd, "this$0");
    s.u(paramj, "$progressDialog");
    s.u(paramad, "$env");
    paramd = com.tencent.mm.vending.g.g.jJL();
    paramj.setMessage((CharSequence)paramad.getContext().getString(a.g.appbrand_phone_number_loading));
    paramj.setOnCancelListener(new d..ExternalSyntheticLambda0(paramd));
    paramd = paramad.getDialogContainer();
    if (paramd != null) {
      paramd.b((com.tencent.mm.plugin.appbrand.widget.dialog.n)paramj);
    }
    paramd = new Object();
    AppMethodBeat.o(326638);
    return paramd;
  }
  
  private static final List a(d paramd, Object paramObject)
  {
    AppMethodBeat.i(326642);
    s.u(paramd, "this$0");
    paramd = com.tencent.mm.plugin.appbrand.phonenumber.r.tGQ;
    paramd = com.tencent.mm.plugin.appbrand.phonenumber.r.cHA();
    AppMethodBeat.o(326642);
    return paramd;
  }
  
  private static final void a(ad paramad, int paramInt, d paramd, p.a parama)
  {
    AppMethodBeat.i(326676);
    s.u(paramad, "$env");
    s.u(paramd, "this$0");
    Object localObject = z.tIm;
    String str = paramad.getAppId();
    s.s(str, "env.appId");
    localObject = ((z)localObject).afD(str);
    if (localObject != null) {
      ((y)localObject).report();
    }
    localObject = z.tIm;
    str = paramad.getAppId();
    s.s(str, "env?.appId");
    ((z)localObject).afE(str);
    Log.i("MicroMsg.JsApiGetPhoneNumberNew", "callResult: " + parama.errMsg + ' ' + parama.values);
    if (parama == null)
    {
      Log.e("MicroMsg.JsApiGetPhoneNumberNew", "callResult is null, fail");
      paramad.callback(paramInt, paramd.ZP("fail"));
      AppMethodBeat.o(326676);
      return;
    }
    paramad.callback(paramInt, paramd.m(parama.errMsg, parama.values));
    AppMethodBeat.o(326676);
  }
  
  private static final void a(ad paramad, int paramInt, d paramd, Object paramObject)
  {
    AppMethodBeat.i(326680);
    s.u(paramad, "$env");
    s.u(paramd, "this$0");
    Object localObject = z.tIm;
    String str = paramad.getAppId();
    s.s(str, "env.appId");
    localObject = ((z)localObject).afD(str);
    if (localObject != null) {
      ((y)localObject).report();
    }
    localObject = z.tIm;
    str = paramad.getAppId();
    s.s(str, "env?.appId");
    ((z)localObject).afE(str);
    if ((paramObject instanceof String))
    {
      Log.e("MicroMsg.JsApiGetPhoneNumberNew", s.X("getphonenumber fail:", paramObject));
      paramad.callback(paramInt, paramd.ZP(s.X("fail:", paramObject)));
      AppMethodBeat.o(326680);
      return;
    }
    if ((paramObject instanceof Exception))
    {
      Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + paramObject + ".message}");
      paramad.callback(paramInt, paramd.ZP("fail:{" + paramObject + ".message}"));
      AppMethodBeat.o(326680);
      return;
    }
    Log.e("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
    paramad.callback(paramInt, paramd.ZP("fail"));
    AppMethodBeat.o(326680);
  }
  
  private static final void a(ad paramad, j paramj, Object paramObject)
  {
    AppMethodBeat.i(326686);
    s.u(paramad, "$env");
    s.u(paramj, "$progressDialog");
    paramad = paramad.getDialogContainer();
    if (paramad != null) {
      paramad.c((com.tencent.mm.plugin.appbrand.widget.dialog.n)paramj);
    }
    AppMethodBeat.o(326686);
  }
  
  private static final void a(com.tencent.mm.vending.g.b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(326691);
    paramb.gM("user cancel");
    AppMethodBeat.o(326691);
  }
  
  public boolean a(ad paramad, b paramb)
  {
    AppMethodBeat.i(326748);
    s.u(paramad, "env");
    if (paramb != null)
    {
      paramad = paramb.rHG;
      if ((paramad != null) && (paramad.YGH == true))
      {
        AppMethodBeat.o(326748);
        return true;
      }
    }
    AppMethodBeat.o(326748);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "", "scopeInfo", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "alertPrivacyInfo", "Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "applyWording", "", "privacyProtectInfo", "Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;)V", "getAlertPrivacyInfo", "()Lcom/tencent/mm/protocal/protobuf/AlertPrivacyInfo;", "getApplyWording", "()Ljava/lang/String;", "getPrivacyProtectInfo", "()Lcom/tencent/mm/protocal/protobuf/UserPrivacyProtectInfo;", "getScopeInfo", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final eul rHF;
    final eq rHG;
    final fvl rHH;
    final String rgX;
    
    public b(eul parameul, eq parameq, String paramString, fvl paramfvl)
    {
      AppMethodBeat.i(326671);
      this.rHF = parameul;
      this.rHG = parameq;
      this.rgX = paramString;
      this.rHH = paramfvl;
      AppMethodBeat.o(326671);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(147904);
      if (this == paramObject)
      {
        AppMethodBeat.o(147904);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(147904);
        return false;
      }
      paramObject = (b)paramObject;
      if (!s.p(this.rHF, paramObject.rHF))
      {
        AppMethodBeat.o(147904);
        return false;
      }
      if (!s.p(this.rHG, paramObject.rHG))
      {
        AppMethodBeat.o(147904);
        return false;
      }
      if (!s.p(this.rgX, paramObject.rgX))
      {
        AppMethodBeat.o(147904);
        return false;
      }
      if (!s.p(this.rHH, paramObject.rHH))
      {
        AppMethodBeat.o(147904);
        return false;
      }
      AppMethodBeat.o(147904);
      return true;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(147903);
      int i;
      int j;
      label25:
      int m;
      if (this.rHF == null)
      {
        i = 0;
        if (this.rHG != null) {
          break label75;
        }
        j = 0;
        m = this.rgX.hashCode();
        if (this.rHH != null) {
          break label86;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(147903);
        return ((j + i * 31) * 31 + m) * 31 + k;
        i = this.rHF.hashCode();
        break;
        label75:
        j = this.rHG.hashCode();
        break label25;
        label86:
        k = this.rHH.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(147902);
      String str = "Info(scopeInfo=" + this.rHF + ", alertPrivacyInfo=" + this.rHG + ", applyWording=" + this.rgX + ", privacyProtectInfo=" + this.rHH + ')';
      AppMethodBeat.o(147902);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errMsg", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.r<Boolean, String, List<? extends PhoneItem>, d.b, ah>
  {
    c(com.tencent.mm.vending.g.b paramb, List<PhoneItem> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, ah>
  {
    e(y paramy, ad paramad, String paramString, boolean paramBoolean, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(y paramy, com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a parama, ad paramad, d.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(y paramy, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    h(y paramy, com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    j(y paramy, ad paramad, com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    k(y paramy, ad paramad, com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<PhoneItem, ah>
  {
    l(y paramy, ad paramad, d.b paramb, com.tencent.mm.vending.g.b paramb1)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "isSuccess", "", "result", "", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements m<Boolean, Map<String, ? extends String>, ah>
    {
      a(PhoneItem paramPhoneItem, y paramy, ad paramad, com.tencent.mm.vending.g.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.d
 * JD-Core Version:    0.7.0.1
 */