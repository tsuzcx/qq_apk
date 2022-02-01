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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawerUIC
  extends UIComponent
{
  public static final FinderCommentDrawerUIC.a tlw;
  public e sck;
  
  static
  {
    AppMethodBeat.i(206107);
    tlw = new FinderCommentDrawerUIC.a((byte)0);
    AppMethodBeat.o(206107);
  }
  
  public FinderCommentDrawerUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206106);
    AppMethodBeat.o(206106);
  }
  
  public final e cCx()
  {
    AppMethodBeat.i(206100);
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    AppMethodBeat.o(206100);
    return locale;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(206102);
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    if (locale.cPI())
    {
      locale = this.sck;
      if (locale == null) {
        p.bdF("drawer");
      }
      locale.cPH();
      AppMethodBeat.o(206102);
      return true;
    }
    AppMethodBeat.o(206102);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206101);
    paramBundle = e.tdM;
    paramBundle = getActivity();
    Object localObject = getActivity().getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "activity.window.decorView");
    this.sck = e.a.a(paramBundle, (View)localObject, 2, false);
    AppMethodBeat.o(206101);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206105);
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    locale.onDetach();
    AppMethodBeat.o(206105);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206104);
    super.onPause();
    if (this.sck == null) {
      p.bdF("drawer");
    }
    AppMethodBeat.o(206104);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206103);
    super.onResume();
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    locale.onUIResume();
    AppMethodBeat.o(206103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC
 * JD-Core Version:    0.7.0.1
 */