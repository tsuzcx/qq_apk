package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.j;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentView", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", "getContentView", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", "listener", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setAllowScroll2Hide", "allowScroll2Hide", "", "plugin-appbrand-integration_release"})
public final class b
  extends e
{
  a.a qnM;
  final HybridOpenMaterialView qnT;
  
  public b(Context paramContext)
  {
    super(paramContext, au.j.OpenMaterialBottomSheetDialog);
    AppMethodBeat.i(259686);
    this.qnT = new HybridOpenMaterialView(paramContext);
    bb();
    AppMethodBeat.o(259686);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(259685);
    this.qnT.hide();
    AppMethodBeat.o(259685);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(259684);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.addFlags(67108864);
      }
    }
    paramBundle = this.qnT.cdc();
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setLayout(paramBundle.width, paramBundle.height);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(au.j.OpenMaterialDialogNoAnimation);
    }
    this.qnT.setListener((HybridOpenMaterialView.a)new a(this));
    setContentView((View)this.qnT, new ViewGroup.LayoutParams(-1, -1));
    setOnShowListener((DialogInterface.OnShowListener)new b(this));
    setCancelable(true);
    AppMethodBeat.o(259684);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog$onCreate$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$ListenerAdapter;", "contentVisibleHeight", "", "Ljava/lang/Integer;", "onContentVisibleHeightChange", "", "height", "onHidden", "plugin-appbrand-integration_release"})
  public static final class a
    extends HybridOpenMaterialView.b
  {
    private Integer qnU;
    
    public final void Cm(int paramInt)
    {
      AppMethodBeat.i(282035);
      super.Cm(paramInt);
      Object localObject = this.qnU;
      if (localObject == null) {}
      for (;;)
      {
        localObject = this.qnV.qnM;
        if (localObject != null) {
          ((a.a)localObject).Cm(paramInt);
        }
        this.qnU = Integer.valueOf(paramInt);
        do
        {
          AppMethodBeat.o(282035);
          return;
        } while (paramInt == ((Integer)localObject).intValue());
      }
    }
    
    public final void ccP()
    {
      AppMethodBeat.i(282034);
      super.ccP();
      Log.d("MicroMsg.AppBrand.HybridOpenMaterialDialog", "dismiss");
      try
      {
        b.a(this.qnV);
        AppMethodBeat.o(282034);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.HybridOpenMaterialDialog", "super#dismiss, fail since ".concat(String.valueOf(localException)));
        AppMethodBeat.o(282034);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
  static final class b
    implements DialogInterface.OnShowListener
  {
    b(b paramb) {}
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(277548);
      this.qnV.qnT.show();
      AppMethodBeat.o(277548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.b
 * JD-Core Version:    0.7.0.1
 */