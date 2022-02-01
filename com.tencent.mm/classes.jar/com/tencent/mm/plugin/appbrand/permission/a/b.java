package com.tencent.mm.plugin.appbrand.permission.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "iconUrl", "getIconUrl", "setIconUrl", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "getLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "setExplainOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "showExplainIv", "show", "", "Factory", "FactoryInterface", "Listener", "ResultCodeEnum", "luggage-wechat-full-sdk_release"})
public abstract interface b
  extends h
{
  public static final b.d mnL = b.d.mnO;
  
  public abstract MotionEvent getLastPointerDownTouchEvent();
  
  public abstract void hb(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setApplyWording(String paramString);
  
  public abstract void setExplainOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonText(String paramString);
  
  public abstract void setFunctionButtonTextColor(int paramInt);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setItemCheckedListener(o.b paramb);
  
  public abstract void setNegativeButtonText(String paramString);
  
  public abstract void setOnListItemLongClickListener(o.c paramc);
  
  public abstract void setPositiveButtonText(String paramString);
  
  public abstract void setRequestDesc(String paramString);
  
  public abstract void setScope(String paramString);
  
  public abstract void setSelectListItem(List<o.a> paramList);
  
  public abstract void setSimpleDetailDesc(String paramString);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    private static final a mnM;
    public static final a mnN;
    
    static
    {
      AppMethodBeat.i(220987);
      mnN = new a();
      mnM = new a();
      AppMethodBeat.o(220987);
    }
    
    public static final b a(d paramd, b.c paramc)
    {
      AppMethodBeat.i(220986);
      p.h(paramd, "component");
      p.h(paramc, "listener");
      b.b localb = (b.b)paramd.K(b.b.class);
      if (localb != null)
      {
        paramd = localb.a(paramd, paramc);
        AppMethodBeat.o(220986);
        return paramd;
      }
      paramd = mnM.a(paramd, paramc);
      AppMethodBeat.o(220986);
      return paramd;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements b.b
    {
      public final b a(d paramd, b.c paramc)
      {
        AppMethodBeat.i(220985);
        p.h(paramd, "component");
        p.h(paramc, "listener");
        Object localObject = paramd.getRuntime();
        if (localObject != null)
        {
          localObject = ((AppBrandRuntime)localObject).getWindowAndroid();
          if (localObject != null) {}
        }
        else
        {
          localObject = paramd.getWindowAndroid();
        }
        for (;;)
        {
          if (localObject == null) {
            p.gkB();
          }
          p.g(localObject, "(component.runtime?.wind…omponent.windowAndroid)!!");
          boolean bool = ((c)localObject).EX();
          Context localContext = paramd.getContext();
          paramd = localContext;
          if (localContext == null)
          {
            paramd = ak.getContext();
            p.g(paramd, "MMApplicationContext.getContext()");
          }
          paramd = new i(paramd, paramc, bool);
          if ((!bool) && (((c)localObject).aXi())) {
            paramd.setPosition(1);
          }
          paramd = (b)paramd;
          AppMethodBeat.o(220985);
          return paramd;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract b a(d paramd, b.c paramc);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2);
    
    @l(gjZ={1, 1, 16})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.b
 * JD-Core Version:    0.7.0.1
 */