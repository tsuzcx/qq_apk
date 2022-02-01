package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.permission.h.a;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.widget.dialog.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAuthorizeUserAgreementComponent;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "onAccept", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "userAgreementChecked", "", "getOnAccept", "()Lkotlin/jvm/functions/Function1;", "setOnAccept", "(Lkotlin/jvm/functions/Function1;)V", "onAddPhoneNumber", "Lkotlin/Function0;", "getOnAddPhoneNumber", "()Lkotlin/jvm/functions/Function0;", "setOnAddPhoneNumber", "(Lkotlin/jvm/functions/Function0;)V", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "setOnPhoneItemSelect", "phoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "setDialogApplyWording", "wording", "setDialogRequestDesc", "setDialogSubDesc", "desc", "showPrivacyExplainEntry", "show", "Factory", "FactoryInterface", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends h, q
{
  public abstract void jc(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setDialogApplyWording(String paramString);
  
  public abstract void setDialogRequestDesc(String paramString);
  
  public abstract void setDialogSubDesc(String paramString);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setOnAccept(kotlin.g.a.b<? super Boolean, ah> paramb);
  
  public abstract void setOnAddPhoneNumber(kotlin.g.a.a<ah> parama);
  
  public abstract void setOnCancel(kotlin.g.a.a<ah> parama);
  
  public abstract void setOnDeny(kotlin.g.a.a<ah> parama);
  
  public abstract void setOnExplain(kotlin.g.a.a<ah> parama);
  
  public abstract void setOnManagePhoneNumber(kotlin.g.a.a<ah> parama);
  
  public abstract void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, ah> paramb);
  
  public abstract void setPhoneItems(ArrayList<PhoneItem> paramArrayList);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static r a(a parama, g paramg)
    {
      AppMethodBeat.i(326624);
      s.u(parama, "this");
      s.u(paramg, "receiver");
      parama = h.a.a((h)parama, paramg);
      AppMethodBeat.o(326624);
      return parama;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b rJb;
    private static final a.b.a rJc;
    
    static
    {
      AppMethodBeat.i(326627);
      rJb = new b();
      rJc = new a.b.a();
      AppMethodBeat.o(326627);
    }
    
    public static final a e(g paramg)
    {
      AppMethodBeat.i(326626);
      s.u(paramg, "component");
      Object localObject = (a.c)paramg.T(a.c.class);
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((a.c)localObject).e(paramg))
      {
        paramg = rJc.e(paramg);
        s.checkNotNull(paramg);
        AppMethodBeat.o(326626);
        return paramg;
      }
      AppMethodBeat.o(326626);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
    extends com.tencent.luggage.a.b
  {
    public abstract a e(g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
 * JD-Core Version:    0.7.0.1
 */