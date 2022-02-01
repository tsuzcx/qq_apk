package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawerUIC
  extends UIComponent
{
  public static final a taI;
  public e rTG;
  
  static
  {
    AppMethodBeat.i(205497);
    taI = new a((byte)0);
    AppMethodBeat.o(205497);
  }
  
  public FinderCommentDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205496);
    AppMethodBeat.o(205496);
  }
  
  public final e cAL()
  {
    AppMethodBeat.i(205490);
    e locale = this.rTG;
    if (locale == null) {
      p.bcb("drawer");
    }
    AppMethodBeat.o(205490);
    return locale;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(205492);
    e locale = this.rTG;
    if (locale == null) {
      p.bcb("drawer");
    }
    if (locale.cMZ())
    {
      locale = this.rTG;
      if (locale == null) {
        p.bcb("drawer");
      }
      locale.cMY();
      AppMethodBeat.o(205492);
      return true;
    }
    AppMethodBeat.o(205492);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205491);
    paramBundle = e.sSA;
    paramBundle = getActivity();
    Object localObject = getActivity().getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "activity.window.decorView");
    this.rTG = e.a.a(paramBundle, (View)localObject, 2, false);
    AppMethodBeat.o(205491);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205495);
    e locale = this.rTG;
    if (locale == null) {
      p.bcb("drawer");
    }
    locale.onDetach();
    AppMethodBeat.o(205495);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205494);
    super.onPause();
    if (this.rTG == null) {
      p.bcb("drawer");
    }
    AppMethodBeat.o(205494);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205493);
    super.onResume();
    e locale = this.rTG;
    if (locale == null) {
      p.bcb("drawer");
    }
    locale.onUIResume();
    AppMethodBeat.o(205493);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC
 * JD-Core Version:    0.7.0.1
 */