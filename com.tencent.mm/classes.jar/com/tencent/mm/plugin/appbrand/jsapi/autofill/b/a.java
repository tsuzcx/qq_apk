package com.tencent.mm.plugin.appbrand.jsapi.autofill.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.permission.h.a;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "phoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showPrivacyExplainEntry", "show", "", "Factory", "FactoryInterface", "luggage-wechat-full-sdk_release"})
public abstract interface a
  extends h
{
  public abstract void id(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setOnAddPhoneNumber(kotlin.g.a.a<x> parama);
  
  public abstract void setOnCancel(kotlin.g.a.a<x> parama);
  
  public abstract void setOnDeny(kotlin.g.a.a<x> parama);
  
  public abstract void setOnExplain(kotlin.g.a.a<x> parama);
  
  public abstract void setOnManagePhoneNumber(kotlin.g.a.a<x> parama);
  
  public abstract void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, x> paramb);
  
  public abstract void setPhoneItems(ArrayList<PhoneItem> paramArrayList);
  
  @kotlin.l(iBK={1, 1, 16})
  public static final class a
  {
    public static com.tencent.mm.plugin.appbrand.widget.dialog.l e(g paramg)
    {
      AppMethodBeat.i(245591);
      p.k(paramg, "$this$findPromptViewContainer");
      paramg = h.a.m(paramg);
      AppMethodBeat.o(245591);
      return paramg;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    private static final a oGc;
    public static final b oGd;
    
    static
    {
      AppMethodBeat.i(246100);
      oGd = new b();
      oGc = new a();
      AppMethodBeat.o(246100);
    }
    
    public static final a f(g paramg)
    {
      AppMethodBeat.i(246097);
      p.k(paramg, "component");
      a.c localc = (a.c)paramg.K(a.c.class);
      if (localc != null)
      {
        paramg = localc.f(paramg);
        AppMethodBeat.o(246097);
        return paramg;
      }
      paramg = oGc.f(paramg);
      AppMethodBeat.o(246097);
      return paramg;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements a.c
    {
      public final a f(g paramg)
      {
        AppMethodBeat.i(243239);
        p.k(paramg, "component");
        Object localObject2 = paramg.getContext();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = MMApplicationContext.getContext();
          p.j(localObject1, "MMApplicationContext.getContext()");
        }
        localObject2 = paramg.getAppId();
        p.j(localObject2, "component.appId");
        v localv = new v((Context)localObject1, (String)localObject2);
        localObject1 = paramg.getRuntime();
        if (localObject1 != null)
        {
          localObject2 = ((AppBrandRuntime)localObject1).getWindowAndroid();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = paramg.getWindowAndroid();
        }
        if (localObject1 == null) {
          p.iCn();
        }
        p.j(localObject1, "(component.runtime?.wind…omponent.windowAndroid)!!");
        if ((!((c)localObject1).RZ()) && (((c)localObject1).Sd())) {
          localv.setPosition(1);
        }
        paramg = (a)localv;
        AppMethodBeat.o(243239);
        return paramg;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
    extends com.tencent.luggage.a.b
  {
    public abstract a f(g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
 * JD-Core Version:    0.7.0.1
 */