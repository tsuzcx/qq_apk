package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "isDrawerInit", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class j
  extends UIComponent
{
  public static final a BiD;
  public f xvK;
  
  static
  {
    AppMethodBeat.i(284561);
    BiD = new a((byte)0);
    AppMethodBeat.o(284561);
  }
  
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(284560);
    AppMethodBeat.o(284560);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(284556);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    f localf = this.xvK;
    if (localf != null)
    {
      localf.d(paramInt1, paramIntent);
      AppMethodBeat.o(284556);
      return;
    }
    AppMethodBeat.o(284556);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(284555);
    f localf = this.xvK;
    if ((localf != null) && (localf.eis() == true))
    {
      localf = this.xvK;
      if (localf != null) {
        localf.eir();
      }
      AppMethodBeat.o(284555);
      return true;
    }
    AppMethodBeat.o(284555);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(284554);
    paramBundle = getIntent().getStringExtra("finder_username");
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    boolean bool1;
    if (paramBundle != null)
    {
      bool1 = paramBundle.equals(z.bdh());
      if ((!bool1) || (!bool2)) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      paramBundle = f.AVu;
      paramBundle = getActivity();
      if (paramBundle != null) {
        break label90;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
      AppMethodBeat.o(284554);
      throw paramBundle;
      bool1 = false;
      break;
    }
    label90:
    paramBundle = (MMFragmentActivity)paramBundle;
    Object localObject = getActivity().getWindow();
    p.j(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "activity.window.decorView");
    if (i != 0) {}
    for (i = 1;; i = 2)
    {
      this.xvK = f.a.a(paramBundle, (View)localObject, i, false, 0, 24);
      AppMethodBeat.o(284554);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(284559);
    f localf = this.xvK;
    if (localf != null)
    {
      localf.onDetach();
      AppMethodBeat.o(284559);
      return;
    }
    AppMethodBeat.o(284559);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(284558);
    super.onPause();
    AppMethodBeat.o(284558);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(284557);
    super.onResume();
    f localf = this.xvK;
    if (localf != null)
    {
      localf.onUIResume();
      AppMethodBeat.o(284557);
      return;
    }
    AppMethodBeat.o(284557);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.j
 * JD-Core Version:    0.7.0.1
 */