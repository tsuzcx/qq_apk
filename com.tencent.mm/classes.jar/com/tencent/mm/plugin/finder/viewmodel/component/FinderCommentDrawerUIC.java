package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "isDrawerInit", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderCommentDrawerUIC
  extends UIComponent
{
  public static final a wvo;
  public e tLT;
  
  static
  {
    AppMethodBeat.i(255446);
    wvo = new a((byte)0);
    AppMethodBeat.o(255446);
  }
  
  public FinderCommentDrawerUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255445);
    AppMethodBeat.o(255445);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255441);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e locale = this.tLT;
    if (locale != null)
    {
      locale.d(paramInt1, paramIntent);
      AppMethodBeat.o(255441);
      return;
    }
    AppMethodBeat.o(255441);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(255440);
    e locale = this.tLT;
    if ((locale != null) && (locale.dGs() == true))
    {
      locale = this.tLT;
      if (locale != null) {
        locale.dGr();
      }
      AppMethodBeat.o(255440);
      return true;
    }
    AppMethodBeat.o(255440);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255439);
    paramBundle = getIntent().getStringExtra("finder_username");
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    boolean bool1;
    if (paramBundle != null)
    {
      bool1 = paramBundle.equals(z.aUg());
      if ((!bool1) || (!bool2)) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      paramBundle = e.wky;
      paramBundle = getActivity();
      if (paramBundle != null) {
        break label90;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(255439);
      throw paramBundle;
      bool1 = false;
      break;
    }
    label90:
    paramBundle = (MMFragmentActivity)paramBundle;
    Object localObject = getActivity().getWindow();
    p.g(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "activity.window.decorView");
    if (i != 0) {}
    for (i = 1;; i = 2)
    {
      this.tLT = e.a.a(paramBundle, (View)localObject, i, false, 0, 24);
      AppMethodBeat.o(255439);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255444);
    e locale = this.tLT;
    if (locale != null)
    {
      locale.onDetach();
      AppMethodBeat.o(255444);
      return;
    }
    AppMethodBeat.o(255444);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255443);
    super.onPause();
    AppMethodBeat.o(255443);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255442);
    super.onResume();
    e locale = this.tLT;
    if (locale != null)
    {
      locale.onUIResume();
      AppMethodBeat.o(255442);
      return;
    }
    AppMethodBeat.o(255442);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC
 * JD-Core Version:    0.7.0.1
 */