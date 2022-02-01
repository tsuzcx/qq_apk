package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.j;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentView", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", "getContentView", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", "listener", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setAllowScroll2Hide", "allowScroll2Hide", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  final HybridOpenMaterialView tsA;
  a.a tst;
  
  public b(Context paramContext)
  {
    super(paramContext, ba.j.AppBrandBottomSheetDialog);
    AppMethodBeat.i(323751);
    this.tsA = new HybridOpenMaterialView(paramContext);
    bU();
    AppMethodBeat.o(323751);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(323767);
    s.u(paramb, "this$0");
    paramb = paramb.tsA;
    paramb.ttb = true;
    if (paramb.tsJ) {}
    for (float f = paramb.tsN;; f = paramb.tsO)
    {
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "show, from: %d, to: %d", new Object[] { Integer.valueOf(paramb.tsM), Integer.valueOf((int)f) });
      if (paramb.tsI != null)
      {
        paramDialogInterface = (FrameLayout.LayoutParams)paramb.tsI.getLayoutParams();
        if ((-1 != paramDialogInterface.width) || (-1 != paramDialogInterface.height))
        {
          paramDialogInterface.width = -1;
          paramDialogInterface.height = -1;
          paramb.tsI.setLayoutParams(paramDialogInterface);
        }
        paramb.tsI.setBackgroundColor(paramb.getResources().getColor(ba.c.BG_1));
      }
      paramb.tsF.setTranslationY(paramb.tsM);
      paramb.tsF.animate().translationY(f).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setUpdateListener(new HybridOpenMaterialView.8(paramb)).setListener(new HybridOpenMaterialView.7(paramb)).start();
      AppMethodBeat.o(323767);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(323805);
    this.tsA.hide();
    AppMethodBeat.o(323805);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(323795);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.addFlags(67108864);
      }
    }
    paramBundle = this.tsA;
    Object localObject;
    if (paramBundle.tsJ)
    {
      localObject = new Rect();
      paramBundle.getWindowVisibleDisplayFrame((Rect)localObject);
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialView", "generateMyLayoutParams, windowVisibleRect: ".concat(String.valueOf(localObject)));
    }
    for (paramBundle = new ViewGroup.LayoutParams((int)(((Rect)localObject).right * 1.0F / 2.0F), -1);; paramBundle = new ViewGroup.LayoutParams(-1, -1))
    {
      localObject = getWindow();
      if (localObject != null) {
        ((Window)localObject).setLayout(paramBundle.width, paramBundle.height);
      }
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.setWindowAnimations(ba.j.AppBrandDialogNoAnimation);
      }
      this.tsA.setListener((HybridOpenMaterialView.a)new a(this));
      setContentView((View)this.tsA, new ViewGroup.LayoutParams(-1, -1));
      setOnShowListener(new b..ExternalSyntheticLambda0(this));
      setCancelable(true);
      AppMethodBeat.o(323795);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog$onCreate$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$ListenerAdapter;", "contentVisibleHeight", "", "Ljava/lang/Integer;", "onContentVisibleHeightChange", "", "height", "onHidden", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends HybridOpenMaterialView.b
  {
    private Integer tsB;
    
    a(b paramb) {}
    
    public final void CB(int paramInt)
    {
      AppMethodBeat.i(323712);
      super.CB(paramInt);
      Object localObject = this.tsB;
      if (localObject == null) {}
      for (;;)
      {
        localObject = this.tsC.tst;
        if (localObject != null) {
          ((a.a)localObject).CB(paramInt);
        }
        this.tsB = Integer.valueOf(paramInt);
        do
        {
          AppMethodBeat.o(323712);
          return;
        } while (paramInt == ((Integer)localObject).intValue());
      }
    }
    
    public final void onHidden()
    {
      AppMethodBeat.i(323699);
      super.onHidden();
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialDialog", "dismiss");
      try
      {
        b.a(this.tsC);
        AppMethodBeat.o(323699);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.HybridOpenMaterialDialog", s.X("super#dismiss, fail since ", localException));
        AppMethodBeat.o(323699);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.b
 * JD-Core Version:    0.7.0.1
 */