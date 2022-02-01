package com.tencent.mm.plugin.appbrand.permission.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "iconUrl", "getIconUrl", "setIconUrl", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ItemCheckedListener;)V", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "getLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "setExplainOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$Item;", "showExplainIv", "show", "", "Factory", "FactoryInterface", "Listener", "ResultCodeEnum", "luggage-wechat-full-sdk_release"})
public abstract interface b
  extends g
{
  public static final b.d miO = b.d.miR;
  
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    private static final a miP;
    public static final a miQ;
    
    static
    {
      AppMethodBeat.i(192374);
      miQ = new a();
      miP = new a();
      AppMethodBeat.o(192374);
    }
    
    public static final b a(d paramd, b.c paramc)
    {
      AppMethodBeat.i(192373);
      p.h(paramd, "component");
      p.h(paramc, "listener");
      b.b localb = (b.b)paramd.K(b.b.class);
      if (localb != null)
      {
        paramd = localb.a(paramd, paramc);
        AppMethodBeat.o(192373);
        return paramd;
      }
      paramd = miP.a(paramd, paramc);
      AppMethodBeat.o(192373);
      return paramd;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements b.b
    {
      public final b a(d paramd, b.c paramc)
      {
        AppMethodBeat.i(192372);
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
            p.gfZ();
          }
          boolean bool = ((c)localObject).aWN();
          Context localContext = paramd.getContext();
          paramd = localContext;
          if (localContext == null)
          {
            paramd = aj.getContext();
            p.g(paramd, "MMApplicationContext.getContext()");
          }
          paramd = new i(paramd, paramc, bool);
          if ((!bool) && (((c)localObject).aWM())) {
            paramd.setPosition(1);
          }
          paramd = (b)paramd;
          AppMethodBeat.o(192372);
          return paramd;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract b a(d paramd, b.c paramc);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2);
    
    @l(gfx={1, 1, 16})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.b
 * JD-Core Version:    0.7.0.1
 */