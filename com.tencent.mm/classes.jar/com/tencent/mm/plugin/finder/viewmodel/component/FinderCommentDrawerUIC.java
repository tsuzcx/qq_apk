package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.finder.view.d.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawerUIC
  extends UIComponent
{
  public static final FinderCommentDrawerUIC.a sdh;
  public d rfU;
  
  static
  {
    AppMethodBeat.i(204478);
    sdh = new FinderCommentDrawerUIC.a((byte)0);
    AppMethodBeat.o(204478);
  }
  
  public FinderCommentDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204477);
    AppMethodBeat.o(204477);
  }
  
  public final d cuz()
  {
    AppMethodBeat.i(204472);
    d locald = this.rfU;
    if (locald == null) {
      k.aVY("drawer");
    }
    AppMethodBeat.o(204472);
    return locald;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(204474);
    d locald = this.rfU;
    if (locald == null) {
      k.aVY("drawer");
    }
    if (locald.cEG())
    {
      locald = this.rfU;
      if (locald == null) {
        k.aVY("drawer");
      }
      locald.cEF();
      AppMethodBeat.o(204474);
      return true;
    }
    AppMethodBeat.o(204474);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204473);
    paramBundle = d.rVR;
    paramBundle = getActivity();
    Object localObject = getActivity().getWindow();
    k.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    k.g(localObject, "activity.window.decorView");
    this.rfU = d.a.a(paramBundle, (View)localObject, 2, false);
    AppMethodBeat.o(204473);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(210214);
    d locald = this.rfU;
    if (locald == null) {
      k.aVY("drawer");
    }
    locald.onDetach();
    AppMethodBeat.o(210214);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204476);
    super.onPause();
    if (this.rfU == null) {
      k.aVY("drawer");
    }
    AppMethodBeat.o(204476);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204475);
    super.onResume();
    d locald = this.rfU;
    if (locald == null) {
      k.aVY("drawer");
    }
    locald.onUIResume();
    AppMethodBeat.o(204475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC
 * JD-Core Version:    0.7.0.1
 */