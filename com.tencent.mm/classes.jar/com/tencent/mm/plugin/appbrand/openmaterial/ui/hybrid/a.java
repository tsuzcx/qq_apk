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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "contentViewConfigureAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridContentViewConfigureAction;", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "anchorView$delegate", "Lkotlin/Lazy;", "containerDialog", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "isLandscape", "", "()Z", "isLandscapeWhenShow", "isShowing", "value", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "listener", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "rotatedFromShow", "getRotatedFromShow", "rotation", "", "getRotation", "()I", "rotationWhenShow", "titleView", "getTitleView", "setTitleView", "(Landroid/view/View;)V", "treeObserver", "Landroid/view/ViewTreeObserver;", "isHide", "(Landroid/view/View;)Z", "dead", "hide", "onGlobalLayout", "show", "plugin-appbrand-integration_release"})
public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener, com.tencent.mm.plugin.appbrand.openmaterial.ui.a
{
  private final Context context;
  private View nmd;
  public com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a nme;
  public final b nmf;
  private final f nmg;
  private ViewTreeObserver nmh;
  private boolean nmi;
  private int nmj;
  
  public a(Context paramContext, kotlin.g.a.b<? super OpenMaterialWebView, x> paramb)
  {
    AppMethodBeat.i(229214);
    this.context = paramContext;
    this.nmf = new b(this.context);
    this.nmg = g.a(k.SWR, (kotlin.g.a.a)new a(this));
    paramContext = this.nmf.nml;
    OpenMaterialWebView localOpenMaterialWebView = new OpenMaterialWebView(this.context);
    paramb.invoke(localOpenMaterialWebView);
    paramContext.setContentView((MMWebView)localOpenMaterialWebView);
    this.nmf.setOnDismissListener((DialogInterface.OnDismissListener)new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(229204);
        paramAnonymousDialogInterface = a.b(this.nmk);
        if (paramAnonymousDialogInterface != null)
        {
          if (paramAnonymousDialogInterface.isAlive()) {
            break label93;
          }
          a locala = this.nmk;
          paramAnonymousDialogInterface = a.c(this.nmk);
          if (paramAnonymousDialogInterface == null) {
            break label88;
          }
          paramAnonymousDialogInterface = paramAnonymousDialogInterface.getViewTreeObserver();
          a.a(locala, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = a.b(this.nmk);
        }
        label88:
        label93:
        for (;;)
        {
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.nmk);
          }
          a.a(this.nmk, null);
          AppMethodBeat.o(229204);
          return;
          paramAnonymousDialogInterface = null;
          break;
        }
      }
    });
    AppMethodBeat.o(229214);
  }
  
  private final View getAnchorView()
  {
    AppMethodBeat.i(229207);
    View localView = (View)this.nmg.getValue();
    AppMethodBeat.o(229207);
    return localView;
  }
  
  private final int getRotation()
  {
    AppMethodBeat.i(229209);
    if ((this.context instanceof Activity))
    {
      Object localObject = ((Activity)this.context).getWindowManager();
      p.g(localObject, "context.windowManager");
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      p.g(localObject, "context.windowManager.defaultDisplay");
      int i = ((Display)localObject).getRotation();
      AppMethodBeat.o(229209);
      return i;
    }
    AppMethodBeat.o(229209);
    return 0;
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(229208);
    Resources localResources = this.context.getResources();
    p.g(localResources, "context.resources");
    if (2 == localResources.getConfiguration().orientation)
    {
      AppMethodBeat.o(229208);
      return true;
    }
    AppMethodBeat.o(229208);
    return false;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(229212);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "dead");
    this.nmf.nml.dead();
    AppMethodBeat.o(229212);
  }
  
  public final Dialog getDialog()
  {
    return (Dialog)this.nmf;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(229211);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "hide");
    if (((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
      ((Activity)this.context).isDestroyed();
    }
    this.nmf.dismiss();
    AppMethodBeat.o(229211);
  }
  
  public final void onGlobalLayout()
  {
    int j = 0;
    AppMethodBeat.i(229213);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "onGlobalLayout");
    boolean bool = this.nmf.isShowing();
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "isShowing, ".concat(String.valueOf(bool)));
    if (bool)
    {
      View localView = getAnchorView();
      if ((localView != null) && ((localView.isShown()) || (localView.getVisibility() == 0))) {
        break label117;
      }
    }
    label117:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.nmi == isLandscape())
        {
          i = j;
          if (this.nmj == getRotation()) {}
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
      AppMethodBeat.o(229213);
      return;
    }
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(229206);
    if (paramView != null) {
      this.nmf.nml.setTitleView(paramView);
    }
    this.nmd = paramView;
    AppMethodBeat.o(229206);
  }
  
  public final void show()
  {
    AppMethodBeat.i(229210);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "show");
    this.nmi = isLandscape();
    this.nmj = getRotation();
    Object localObject = getAnchorView();
    if (localObject != null) {
      if (this.nmh != null) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      this.nmh = ((View)localObject).getViewTreeObserver();
      if (i != 0)
      {
        localObject = this.nmh;
        if (localObject != null) {
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
        ((Activity)this.context).isDestroyed();
      }
      this.nmf.show();
      AppMethodBeat.o(229210);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a
 * JD-Core Version:    0.7.0.1
 */