package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawerUIC
  extends UIComponent
{
  public static final a LhE;
  public f KMN;
  
  static
  {
    AppMethodBeat.i(200353);
    LhE = new a((byte)0);
    AppMethodBeat.o(200353);
  }
  
  public FinderCommentDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200352);
    AppMethodBeat.o(200352);
  }
  
  public final f fSY()
  {
    AppMethodBeat.i(200347);
    f localf = this.KMN;
    if (localf == null) {
      k.aPZ("drawer");
    }
    AppMethodBeat.o(200347);
    return localf;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(200349);
    f localf = this.KMN;
    if (localf == null) {
      k.aPZ("drawer");
    }
    if (localf.fiQ())
    {
      localf = this.KMN;
      if (localf == null) {
        k.aPZ("drawer");
      }
      localf.csJ();
      AppMethodBeat.o(200349);
      return true;
    }
    AppMethodBeat.o(200349);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200348);
    paramBundle = f.LeE;
    paramBundle = getActivity();
    Object localObject = getActivity().getWindow();
    k.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    k.g(localObject, "activity.window.decorView");
    this.KMN = f.a.a(paramBundle, (View)localObject, 2, false);
    AppMethodBeat.o(200348);
  }
  
  public final void onDestroy() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(200351);
    super.onPause();
    if (this.KMN == null) {
      k.aPZ("drawer");
    }
    AppMethodBeat.o(200351);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200350);
    super.onResume();
    f localf = this.KMN;
    if (localf == null) {
      k.aPZ("drawer");
    }
    localf.onUIResume();
    AppMethodBeat.o(200350);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC
 * JD-Core Version:    0.7.0.1
 */