package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentView", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", "getContentView", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView;", "listener", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "getListener", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "setListener", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;)V", "dismiss", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setAllowScroll2Hide", "allowScroll2Hide", "", "plugin-appbrand-integration_release"})
public final class b
  extends e
{
  public a.a nme;
  final HybridOpenMaterialView nml;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821233);
    AppMethodBeat.i(229221);
    this.nml = new HybridOpenMaterialView(paramContext);
    gR();
    AppMethodBeat.o(229221);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(229220);
    this.nml.hide();
    AppMethodBeat.o(229220);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(229219);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      if (paramBundle != null) {
        paramBundle.addFlags(67108864);
      }
    }
    paramBundle = this.nml.bQm();
    Window localWindow = getWindow();
    if (localWindow != null) {
      localWindow.setLayout(paramBundle.width, paramBundle.height);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(2131821234);
    }
    this.nml.setListener((HybridOpenMaterialView.a)new a(this));
    setContentView((View)this.nml, new ViewGroup.LayoutParams(-1, -1));
    setOnShowListener((DialogInterface.OnShowListener)new b(this));
    setCancelable(true);
    AppMethodBeat.o(229219);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialDialog$onCreate$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/HybridOpenMaterialView$ListenerAdapter;", "contentVisibleHeight", "", "Ljava/lang/Integer;", "onContentVisibleHeightChange", "", "height", "onHidden", "plugin-appbrand-integration_release"})
  public static final class a
    extends HybridOpenMaterialView.b
  {
    private Integer nmm;
    
    public final void bQd()
    {
      AppMethodBeat.i(229216);
      super.bQd();
      try
      {
        b.a(this.nmn);
        AppMethodBeat.o(229216);
        return;
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.AppBrand.HybridOpenMaterialDialog", "super#dismiss, fail since ".concat(String.valueOf(localException)));
        AppMethodBeat.o(229216);
      }
    }
    
    public final void yH(int paramInt)
    {
      AppMethodBeat.i(229217);
      super.yH(paramInt);
      Object localObject = this.nmm;
      if (localObject == null) {}
      for (;;)
      {
        localObject = this.nmn.nme;
        if (localObject != null) {
          ((a.a)localObject).yH(paramInt);
        }
        this.nmm = Integer.valueOf(paramInt);
        do
        {
          AppMethodBeat.o(229217);
          return;
        } while (paramInt == ((Integer)localObject).intValue());
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
  static final class b
    implements DialogInterface.OnShowListener
  {
    b(b paramb) {}
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(229218);
      this.nmn.nml.show();
      AppMethodBeat.o(229218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.b
 * JD-Core Version:    0.7.0.1
 */