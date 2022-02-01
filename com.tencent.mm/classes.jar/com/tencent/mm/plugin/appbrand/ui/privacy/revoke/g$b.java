package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.ui.widget.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter$bindLongClickRevokeMenu$disableScrollPopupMenu$1", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "onDismiss", "", "show", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$b
  extends a
{
  g$b(View paramView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean cMz()
  {
    AppMethodBeat.i(322815);
    ViewParent localViewParent = this.uka.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
    this.uka.setBackgroundResource(ba.e.app_brand_user_info_item_selected_background);
    boolean bool = super.cMz();
    AppMethodBeat.o(322815);
    return bool;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(322819);
    ViewParent localViewParent = this.uka.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(false);
    }
    this.uka.setBackgroundResource(ba.c.transparent);
    super.onDismiss();
    AppMethodBeat.o(322819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.g.b
 * JD-Core Version:    0.7.0.1
 */