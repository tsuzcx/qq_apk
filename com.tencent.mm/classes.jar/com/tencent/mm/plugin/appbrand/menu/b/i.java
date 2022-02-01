package com.tencent.mm.plugin.appbrand.menu.b;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "()V", "TAG", "", "attachOnRootView", "", "activity", "Landroid/app/Activity;", "bitmap", "Landroid/graphics/Bitmap;", "getTitle", "context", "Landroid/content/Context;", "pageView", "appId", "makeBitmapImage", "Landroid/view/View;", "performItemClick", "removeFromRootView", "shouldShow", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements com.tencent.mm.plugin.appbrand.menu.a.b<ah>
{
  private static final String TAG;
  public static final i tlu;
  
  static
  {
    AppMethodBeat.i(323905);
    tlu = new i();
    TAG = "MicroMsg.GameGlyphBitmap";
    AppMethodBeat.o(323905);
  }
  
  private static final void a(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(323903);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramActivity);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramActivity, "$activity");
    Log.i(TAG, "dl: attachOnRootView");
    paramActivity = paramActivity.findViewById(16908290);
    if (paramActivity == null)
    {
      paramActivity = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(323903);
      throw paramActivity;
    }
    paramActivity = (FrameLayout)paramActivity;
    paramActivity.removeViewAt(paramActivity.getChildCount() - 1);
    paramActivity.removeViewAt(paramActivity.getChildCount() - 1);
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/menu/devtools/SecondaryMenuDelegate_GameGlyphBitmap", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(323903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.i
 * JD-Core Version:    0.7.0.1
 */