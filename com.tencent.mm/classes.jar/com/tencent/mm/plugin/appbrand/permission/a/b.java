package com.tencent.mm.plugin.appbrand.permission.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "iconUrl", "getIconUrl", "setIconUrl", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "getLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "setExplainOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "showExplainIv", "show", "", "Factory", "FactoryInterface", "Listener", "ResultCodeEnum", "luggage-wechat-full-sdk_release"})
public abstract interface b
  extends h
{
  public static final b.e qAJ = b.e.qAM;
  
  public abstract MotionEvent getLastPointerDownTouchEvent();
  
  public abstract void iU(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setApplyWording(String paramString);
  
  public abstract void setExplainOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonText(String paramString);
  
  public abstract void setFunctionButtonTextColor(int paramInt);
  
  public abstract void setFunctionButtonVisibility(int paramInt);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setItemCheckedListener(h.b paramb);
  
  public abstract void setNegativeButtonText(String paramString);
  
  public abstract void setOnListItemLongClickListener(h.d paramd);
  
  public abstract void setPositiveButtonText(String paramString);
  
  public abstract void setRequestDesc(String paramString);
  
  public abstract void setScope(String paramString);
  
  public abstract void setSelectListItem(List<com.tencent.mm.plugin.appbrand.widget.dialog.h.a> paramList);
  
  public abstract void setSimpleDetailDesc(String paramString);
  
  @kotlin.l(iBK={1, 1, 16})
  public static final class a
  {
    public static com.tencent.mm.plugin.appbrand.widget.dialog.l n(com.tencent.mm.plugin.appbrand.g paramg)
    {
      AppMethodBeat.i(237958);
      p.k(paramg, "$this$findPromptViewContainer");
      paramg = com.tencent.mm.plugin.appbrand.permission.h.a.m(paramg);
      AppMethodBeat.o(237958);
      return paramg;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    private static final a qAK;
    public static final b qAL;
    
    static
    {
      AppMethodBeat.i(250070);
      qAL = new b();
      qAK = new a();
      AppMethodBeat.o(250070);
    }
    
    public static final b a(com.tencent.mm.plugin.appbrand.g paramg, b.d paramd)
    {
      AppMethodBeat.i(250069);
      p.k(paramg, "component");
      p.k(paramd, "listener");
      b.c localc = (b.c)paramg.K(b.c.class);
      if (localc != null)
      {
        paramg = localc.a(paramg, paramd);
        AppMethodBeat.o(250069);
        return paramg;
      }
      paramg = qAK.a(paramg, paramd);
      AppMethodBeat.o(250069);
      return paramg;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements b.c
    {
      public final b a(com.tencent.mm.plugin.appbrand.g paramg, b.d paramd)
      {
        AppMethodBeat.i(246183);
        p.k(paramg, "component");
        p.k(paramd, "listener");
        Object localObject = paramg.getRuntime();
        if (localObject != null)
        {
          localObject = ((AppBrandRuntime)localObject).getWindowAndroid();
          if (localObject != null) {}
        }
        else
        {
          localObject = paramg.getWindowAndroid();
        }
        for (;;)
        {
          if (localObject == null) {
            p.iCn();
          }
          p.j(localObject, "(component.runtime?.wind…omponent.windowAndroid)!!");
          boolean bool = ((c)localObject).RZ();
          Context localContext = paramg.getContext();
          paramg = localContext;
          if (localContext == null)
          {
            paramg = MMApplicationContext.getContext();
            p.j(paramg, "MMApplicationContext.getContext()");
          }
          paramg = new com.tencent.mm.plugin.appbrand.widget.dialog.g(paramg, paramd, bool);
          if ((!bool) && (((c)localObject).Sd())) {
            paramg.setPosition(1);
          }
          paramg = (b)paramg;
          AppMethodBeat.o(246183);
          return paramg;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static abstract interface c
    extends com.tencent.luggage.a.b
  {
    public abstract b a(com.tencent.mm.plugin.appbrand.g paramg, b.d paramd);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "luggage-wechat-full-sdk_release"})
  public static abstract interface d
  {
    public abstract void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2);
    
    @kotlin.l(iBK={1, 1, 16})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.b
 * JD-Core Version:    0.7.0.1
 */