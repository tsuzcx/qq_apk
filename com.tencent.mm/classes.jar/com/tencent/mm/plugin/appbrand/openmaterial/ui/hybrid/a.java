package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "contentViewConfigureAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridContentViewConfigureAction;", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "anchorView$delegate", "Lkotlin/Lazy;", "containerDialog", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "isLandscape", "", "()Z", "isLandscapeWhenShow", "isShowing", "value", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "listener", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "rotatedFromShow", "getRotatedFromShow", "rotation", "", "getRotation", "()I", "rotationWhenShow", "titleView", "getTitleView", "setTitleView", "(Landroid/view/View;)V", "treeObserver", "Landroid/view/ViewTreeObserver;", "isHide", "(Landroid/view/View;)Z", "dead", "hide", "onGlobalLayout", "show", "plugin-appbrand-integration_release"})
public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener, com.tencent.mm.plugin.appbrand.openmaterial.ui.a
{
  private final Context context;
  private View qnL;
  private com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a qnM;
  private final b qnN;
  private final f qnO;
  private ViewTreeObserver qnP;
  private boolean qnQ;
  private int qnR;
  
  public a(Context paramContext, kotlin.g.a.b<? super OpenMaterialWebView, x> paramb)
  {
    AppMethodBeat.i(282123);
    this.context = paramContext;
    this.qnN = new b(this.context);
    this.qnO = g.a(k.aazD, (kotlin.g.a.a)new a(this));
    paramContext = this.qnN.qnT;
    OpenMaterialWebView localOpenMaterialWebView = new OpenMaterialWebView(this.context);
    paramb.invoke(localOpenMaterialWebView);
    paramContext.setContentView((MMWebView)localOpenMaterialWebView);
    this.qnN.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(277211);
        Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "onDismiss");
        paramAnonymousDialogInterface = a.b(this.qnS);
        if (paramAnonymousDialogInterface != null)
        {
          if (paramAnonymousDialogInterface.isAlive()) {
            break label100;
          }
          a locala = this.qnS;
          paramAnonymousDialogInterface = a.c(this.qnS);
          if (paramAnonymousDialogInterface == null) {
            break label95;
          }
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.getViewTreeObserver();
          a.a(locala, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = a.b(this.qnS);
        }
        label95:
        label100:
        for (;;)
        {
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.qnS);
          }
          a.a(this.qnS, null);
          AppMethodBeat.o(277211);
          return;
          paramAnonymousDialogInterface = null;
          break;
        }
      }
    });
    AppMethodBeat.o(282123);
  }
  
  private final View cdb()
  {
    AppMethodBeat.i(282115);
    View localView = (View)this.qnO.getValue();
    AppMethodBeat.o(282115);
    return localView;
  }
  
  private final int getRotation()
  {
    AppMethodBeat.i(282117);
    if ((this.context instanceof Activity))
    {
      Object localObject = ((Activity)this.context).getWindowManager();
      p.j(localObject, "context.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.j(localObject, "context.windowManager.defaultDisplay");
      int i = ((Display)localObject).getRotation();
      AppMethodBeat.o(282117);
      return i;
    }
    AppMethodBeat.o(282117);
    return 0;
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(282116);
    Resources localResources = this.context.getResources();
    p.j(localResources, "context.resources");
    if (2 == localResources.getConfiguration().orientation)
    {
      AppMethodBeat.o(282116);
      return true;
    }
    AppMethodBeat.o(282116);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a parama)
  {
    this.qnN.qnM = parama;
    this.qnM = parama;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(282121);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "dead");
    this.qnN.qnT.dead();
    AppMethodBeat.o(282121);
  }
  
  public final Dialog getDialog()
  {
    return (Dialog)this.qnN;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(282120);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "hide");
    if (((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
      ((Activity)this.context).isDestroyed();
    }
    this.qnN.dismiss();
    AppMethodBeat.o(282120);
  }
  
  public final void onGlobalLayout()
  {
    int j = 0;
    AppMethodBeat.i(282122);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "onGlobalLayout");
    boolean bool = this.qnN.isShowing();
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "isShowing, ".concat(String.valueOf(bool)));
    if (bool)
    {
      View localView = cdb();
      if ((localView != null) && ((localView.isShown()) || (localView.getVisibility() == 0))) {
        break label117;
      }
    }
    label117:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.qnQ == isLandscape())
        {
          i = j;
          if (this.qnR == getRotation()) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0) {}
      }
      else
      {
        hide();
      }
      AppMethodBeat.o(282122);
      return;
    }
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(282114);
    if (paramView != null) {
      this.qnN.qnT.setTitleView(paramView);
    }
    this.qnL = paramView;
    AppMethodBeat.o(282114);
  }
  
  public final void show()
  {
    AppMethodBeat.i(282119);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "show");
    this.qnQ = isLandscape();
    this.qnR = getRotation();
    Object localObject = cdb();
    if (localObject != null) {
      if (this.qnP != null) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      this.qnP = ((View)localObject).getViewTreeObserver();
      if (i != 0)
      {
        localObject = this.qnP;
        if (localObject != null) {
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
        ((Activity)this.context).isDestroyed();
      }
      this.qnN.show();
      AppMethodBeat.o(282119);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<View>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a
 * JD-Core Version:    0.7.0.1
 */