package com.tencent.mm.plugin.appbrand.permission.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.permission.t;
import com.tencent.mm.plugin.appbrand.permission.u;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.q;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAuthorizeUserAgreementComponent;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "iconUrl", "getIconUrl", "setIconUrl", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "getLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "setExplainOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "showExplainIv", "show", "", "Factory", "FactoryInterface", "Listener", "ResultCodeEnum", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends h, q
{
  public static final b.e tFL = b.e.tFU;
  
  public abstract MotionEvent getLastPointerDownTouchEvent();
  
  public abstract void kb(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setApplyWording(String paramString);
  
  public abstract void setExplainOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonText(String paramString);
  
  public abstract void setFunctionButtonTextColor(int paramInt);
  
  public abstract void setFunctionButtonVisibility(int paramInt);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setItemCheckedListener(k.b paramb);
  
  public abstract void setNegativeButtonText(String paramString);
  
  public abstract void setOnListItemLongClickListener(k.d paramd);
  
  public abstract void setPositiveButtonText(String paramString);
  
  public abstract void setRequestDesc(String paramString);
  
  public abstract void setScope(String paramString);
  
  public abstract void setSelectListItem(List<k.a> paramList);
  
  public abstract void setSimpleDetailDesc(String paramString);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "scopeList", "", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b tFM;
    private static final a tFN;
    
    static
    {
      AppMethodBeat.i(318788);
      tFM = new b();
      tFN = new a();
      AppMethodBeat.o(318788);
    }
    
    public static final b a(g paramg, b.d paramd, List<? extends eul> paramList)
    {
      AppMethodBeat.i(318782);
      s.u(paramg, "component");
      s.u(paramd, "listener");
      Object localObject = (b.c)paramg.T(b.c.class);
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = ((b.c)localObject).a(paramg, paramd, paramList))
      {
        paramg = tFN.a(paramg, paramd, paramList);
        s.checkNotNull(paramg);
        AppMethodBeat.o(318782);
        return paramg;
      }
      AppMethodBeat.o(318782);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "SCOPE_BLUETOOTH", "", "SCOPE_BLUETOOTH_BACKGROUND", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "scopeList", "", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "toBluetoothScopeProvider", "Lcom/tencent/mm/plugin/appbrand/permission/ScopeProvider;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b.c
    {
      private final String tFO = "scope.bluetooth";
      private final String tFP = "scope.bluetoothBackground";
      
      private final t dA(List<? extends eul> paramList)
      {
        final boolean bool = true;
        AppMethodBeat.i(318807);
        Object localObject2 = ((Iterable)paramList).iterator();
        Object localObject1;
        int i;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          eul localeul = (eul)localObject1;
          if (s.p(this.tFO, localeul.YVX))
          {
            if (localObject1 == null) {
              break label150;
            }
            i = 1;
            label66:
            localObject1 = ((Iterable)paramList).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              paramList = ((Iterator)localObject1).next();
              localObject2 = (eul)paramList;
              if (s.p(this.tFP, ((eul)localObject2).YVX)) {
                label116:
                if (paramList == null) {
                  break label160;
                }
              }
            }
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label165;
          }
          paramList = (t)new a(this, bool);
          AppMethodBeat.o(318807);
          return paramList;
          localObject1 = null;
          break;
          label150:
          i = 0;
          break label66;
          paramList = null;
          break label116;
          label160:
          bool = false;
        }
        label165:
        AppMethodBeat.o(318807);
        return null;
      }
      
      public final b a(g paramg, b.d paramd, List<? extends eul> paramList)
      {
        AppMethodBeat.i(318823);
        s.u(paramg, "component");
        s.u(paramd, "listener");
        Object localObject = paramg.getRuntime();
        label42:
        boolean bool;
        Context localContext;
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            break label164;
          }
          localObject = paramg.getWindowAndroid();
          s.checkNotNull(localObject);
          s.s(localObject, "component.runtime?.windo…omponent.windowAndroid)!!");
          bool = ((c)localObject).asq();
          localContext = paramg.getContext();
          if (localContext != null) {
            break label167;
          }
          localContext = MMApplicationContext.getContext();
          label79:
          if (paramList != null) {
            break label170;
          }
          paramList = null;
          label85:
          if (paramList != null) {
            break label209;
          }
          paramList = paramg.getContext();
          paramg = paramList;
          if (paramList == null) {
            paramg = MMApplicationContext.getContext();
          }
          s.s(paramg, "component.context ?: MMA…ationContext.getContext()");
        }
        label164:
        label167:
        label170:
        label209:
        for (paramg = new d(paramg, paramd, bool);; paramg = (d)paramList)
        {
          if ((!bool) && (((c)localObject).asu())) {
            paramg.setPosition(1);
          }
          paramg = (b)paramg;
          AppMethodBeat.o(318823);
          return paramg;
          localObject = ((AppBrandRuntime)localObject).getWindowAndroid();
          break;
          break label42;
          break label79;
          paramList = dA(paramList);
          if (paramList == null)
          {
            paramList = null;
            break label85;
          }
          s.s(localContext, "context");
          paramList = new u(localContext, paramd, bool, paramList);
          break label85;
        }
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1$toBluetoothScopeProvider$1", "Lcom/tencent/mm/plugin/appbrand/permission/ScopeProvider;", "bgScope", "", "getBgScope", "()Ljava/lang/String;", "fgScope", "getFgScope", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements t
      {
        private final String tFQ;
        private final String tFR;
        
        a(b.b.a parama, boolean paramBoolean)
        {
          AppMethodBeat.i(318805);
          this.tFQ = b.b.a.a(this.tFS);
          if (bool) {}
          for (parama = b.b.a.b(this.tFS);; parama = null)
          {
            this.tFR = parama;
            AppMethodBeat.o(318805);
            return;
          }
        }
        
        public final String cGV()
        {
          return this.tFQ;
        }
        
        public final String cGW()
        {
          return this.tFR;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "Lcom/tencent/luggage/base/ICustomize;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "scopeList", "", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
    extends com.tencent.luggage.a.b
  {
    public abstract b a(g paramg, b.d paramd, List<? extends eul> paramList);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "userAgreementChecked", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2, boolean paramBoolean);
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.b
 * JD-Core Version:    0.7.0.1
 */