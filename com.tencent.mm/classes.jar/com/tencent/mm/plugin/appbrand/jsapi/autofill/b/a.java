package com.tencent.mm.plugin.appbrand.jsapi.autofill.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "phoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showPrivacyExplainEntry", "show", "", "Factory", "FactoryInterface", "luggage-wechat-full-sdk_release"})
public abstract interface a
  extends g
{
  public abstract void gr(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setOnAddPhoneNumber(d.g.a.a<z> parama);
  
  public abstract void setOnCancel(d.g.a.a<z> parama);
  
  public abstract void setOnDeny(d.g.a.a<z> parama);
  
  public abstract void setOnExplain(d.g.a.a<z> parama);
  
  public abstract void setOnManagePhoneNumber(d.g.a.a<z> parama);
  
  public abstract void setOnPhoneItemSelect(d.g.a.b<? super PhoneItem, z> paramb);
  
  public abstract void setPhoneItems(ArrayList<PhoneItem> paramArrayList);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    private static final a kBX;
    public static final a kBY;
    
    static
    {
      AppMethodBeat.i(192357);
      kBY = new a();
      kBX = new a();
      AppMethodBeat.o(192357);
    }
    
    public static final a e(d paramd)
    {
      AppMethodBeat.i(192356);
      p.h(paramd, "component");
      a.b localb = (a.b)paramd.K(a.b.class);
      if (localb != null)
      {
        paramd = localb.e(paramd);
        AppMethodBeat.o(192356);
        return paramd;
      }
      paramd = kBX.e(paramd);
      AppMethodBeat.o(192356);
      return paramd;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements a.b
    {
      public final a e(d paramd)
      {
        AppMethodBeat.i(192355);
        p.h(paramd, "component");
        Object localObject2 = paramd.getContext();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = aj.getContext();
          p.g(localObject1, "MMApplicationContext.getContext()");
        }
        localObject2 = paramd.getAppId();
        p.g(localObject2, "component.appId");
        v localv = new v((Context)localObject1, (String)localObject2);
        localObject1 = paramd.getRuntime();
        if (localObject1 != null)
        {
          localObject2 = ((AppBrandRuntime)localObject1).getWindowAndroid();
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = paramd.getWindowAndroid();
        }
        if (localObject1 == null) {
          p.gfZ();
        }
        if ((!((c)localObject1).aWN()) && (((c)localObject1).aWM())) {
          localv.setPosition(1);
        }
        paramd = (a)localv;
        AppMethodBeat.o(192355);
        return paramd;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract a e(d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
 * JD-Core Version:    0.7.0.1
 */