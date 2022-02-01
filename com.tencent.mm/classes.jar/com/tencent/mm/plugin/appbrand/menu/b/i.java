package com.tencent.mm.plugin.appbrand.menu.b;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "TAG", "", "attachOnRootView", "", "activity", "Landroid/app/Activity;", "bitmap", "Landroid/graphics/Bitmap;", "getTitle", "context", "Landroid/content/Context;", "pageView", "appId", "makeBitmapImage", "Landroid/view/View;", "performItemClick", "removeFromRootView", "shouldShow", "", "plugin-appbrand-integration_release"})
public final class i
  implements com.tencent.mm.plugin.appbrand.menu.a.b<ad>
{
  private static final String TAG = "MicroMsg.GameGlyphBitmap";
  public static final i lYs;
  
  static
  {
    AppMethodBeat.i(223808);
    lYs = new i();
    TAG = "MicroMsg.GameGlyphBitmap";
    AppMethodBeat.o(223808);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap$attachOnRootView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(Activity paramActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223804);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap$attachOnRootView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = i.lYs;
      i.C(this.lYt);
      a.a(this, "com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap$attachOnRootView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(223804);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.i
 * JD-Core Version:    0.7.0.1
 */