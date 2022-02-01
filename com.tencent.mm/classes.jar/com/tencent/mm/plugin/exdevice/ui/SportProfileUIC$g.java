package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class SportProfileUIC$g
  implements View.OnClickListener
{
  SportProfileUIC$g(SportProfileUIC paramSportProfileUIC) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(230642);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if ((!Util.isNullOrNil(this.rMU.rCB)) && ((p.j("#", this.rMU.rCB) ^ true)))
    {
      Intent localIntent = new Intent((Context)this.rMU.getActivity(), ExdeviceLikeUI.class);
      localObject = this.rMU.appName;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localIntent.putExtra("app_username", paramView);
      localObject = this.rMU.rCB;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localIntent.putExtra("rank_id", paramView);
      localIntent.putExtra("key_is_like_read_only", true);
      paramView = this.rMU.getActivity();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC$updateItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(230642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.g
 * JD-Core Version:    0.7.0.1
 */