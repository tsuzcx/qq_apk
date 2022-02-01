package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "contentViewConfigureAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridContentViewConfigureAction;", "Lkotlin/ExtensionFunctionType;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "anchorView$delegate", "Lkotlin/Lazy;", "containerDialog", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "isLandscape", "", "()Z", "isLandscapeWhenShow", "isShowing", "value", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "listener", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "rotatedFromShow", "getRotatedFromShow", "rotation", "", "getRotation", "()I", "rotationWhenShow", "titleView", "getTitleView", "setTitleView", "(Landroid/view/View;)V", "treeObserver", "Landroid/view/ViewTreeObserver;", "isHide", "(Landroid/view/View;)Z", "dead", "hide", "onGlobalLayout", "show", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener, com.tencent.mm.plugin.appbrand.openmaterial.ui.a
{
  private final Context context;
  private View tss;
  private com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a tst;
  private final b tsu;
  private final j tsv;
  private ViewTreeObserver tsw;
  private boolean tsx;
  private int tsy;
  
  public a(Context paramContext, kotlin.g.a.b<? super OpenMaterialWebView, ah> paramb)
  {
    AppMethodBeat.i(323765);
    this.context = paramContext;
    this.tsu = new b(this.context);
    this.tsv = k.a(o.aiuH, (kotlin.g.a.a)new a(this));
    paramContext = this.tsu.tsA;
    OpenMaterialWebView localOpenMaterialWebView = new OpenMaterialWebView(this.context);
    paramb.invoke(localOpenMaterialWebView);
    paramContext.setContentView((MMWebView)localOpenMaterialWebView);
    this.tsu.setOnDismissListener(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(323765);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(323802);
    s.u(parama, "this$0");
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "onDismiss");
    paramDialogInterface = parama.tsw;
    if (paramDialogInterface != null)
    {
      if (paramDialogInterface.isAlive()) {
        break label86;
      }
      paramDialogInterface = parama.cDz();
      if (paramDialogInterface != null) {
        break label78;
      }
      paramDialogInterface = null;
      parama.tsw = paramDialogInterface;
      paramDialogInterface = parama.tsw;
    }
    label78:
    label86:
    for (;;)
    {
      if (paramDialogInterface != null) {
        paramDialogInterface.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)parama);
      }
      parama.tsw = null;
      AppMethodBeat.o(323802);
      return;
      paramDialogInterface = paramDialogInterface.getViewTreeObserver();
      break;
    }
  }
  
  private final View cDz()
  {
    AppMethodBeat.i(323775);
    View localView = (View)this.tsv.getValue();
    AppMethodBeat.o(323775);
    return localView;
  }
  
  private final int getRotation()
  {
    AppMethodBeat.i(323790);
    if ((this.context instanceof Activity))
    {
      int i = ((Activity)this.context).getWindowManager().getDefaultDisplay().getRotation();
      AppMethodBeat.o(323790);
      return i;
    }
    AppMethodBeat.o(323790);
    return 0;
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(323782);
    if (2 == this.context.getResources().getConfiguration().orientation)
    {
      AppMethodBeat.o(323782);
      return true;
    }
    AppMethodBeat.o(323782);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a parama)
  {
    this.tsu.tst = parama;
    this.tst = parama;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(323841);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "dead");
    this.tsu.tsA.dead();
    AppMethodBeat.o(323841);
  }
  
  public final Dialog getDialog()
  {
    return (Dialog)this.tsu;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(323837);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "hide");
    if (((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
      ((Activity)this.context).isDestroyed();
    }
    this.tsu.dismiss();
    AppMethodBeat.o(323837);
  }
  
  public final void onGlobalLayout()
  {
    int j = 0;
    AppMethodBeat.i(323846);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "onGlobalLayout");
    boolean bool = this.tsu.isShowing();
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", s.X("isShowing, ", Boolean.valueOf(bool)));
    if (bool)
    {
      View localView = cDz();
      if ((localView != null) && ((localView.isShown()) || (localView.getVisibility() == 0))) {
        break label117;
      }
    }
    label117:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (this.tsx == isLandscape())
        {
          i = j;
          if (this.tsy == getRotation()) {}
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
      AppMethodBeat.o(323846);
      return;
    }
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(323822);
    if (paramView != null) {
      this.tsu.tsA.setTitleView(paramView);
    }
    this.tss = paramView;
    AppMethodBeat.o(323822);
  }
  
  public final void show()
  {
    AppMethodBeat.i(323832);
    Log.d("MicroMsg.AppBrand.HybridOpenMaterialBottomSheet", "show");
    this.tsx = isLandscape();
    this.tsy = getRotation();
    Object localObject = cDz();
    if (localObject != null) {
      if (this.tsw != null) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      this.tsw = ((View)localObject).getViewTreeObserver();
      if (i != 0)
      {
        localObject = this.tsw;
        if (localObject != null) {
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }
      }
      if (((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {
        ((Activity)this.context).isDestroyed();
      }
      this.tsu.show();
      AppMethodBeat.o(323832);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<View>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a
 * JD-Core Version:    0.7.0.1
 */