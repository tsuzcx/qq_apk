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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.y;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;)V", "isDrawerInit", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends UIComponent
{
  public static final a GNl;
  public f ATy;
  
  static
  {
    AppMethodBeat.i(337796);
    GNl = new a((byte)0);
    AppMethodBeat.o(337796);
  }
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337791);
    AppMethodBeat.o(337791);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(337822);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    f localf = this.ATy;
    if (localf != null) {
      localf.g(paramInt1, paramIntent);
    }
    AppMethodBeat.o(337822);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(337814);
    f localf = this.ATy;
    if ((localf != null) && (localf.fkp() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localf = this.ATy;
      if (localf != null) {
        localf.fdh();
      }
      AppMethodBeat.o(337814);
      return true;
    }
    AppMethodBeat.o(337814);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(337808);
    paramBundle = getIntent().getStringExtra("finder_username");
    boolean bool2 = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
    boolean bool1;
    label44:
    View localView;
    if (paramBundle == null)
    {
      bool1 = false;
      if ((!bool1) || (!bool2)) {
        break label113;
      }
      i = 1;
      paramBundle = f.GxF;
      paramBundle = (MMFragmentActivity)getActivity();
      localView = getActivity().getWindow().getDecorView();
      s.s(localView, "activity.window.decorView");
      if (i == 0) {
        break label118;
      }
    }
    label113:
    label118:
    for (int i = 1;; i = 2)
    {
      this.ATy = f.a.a(paramBundle, localView, i, false, 0, 24);
      AppMethodBeat.o(337808);
      return;
      bool1 = paramBundle.equals(z.bAW());
      break;
      i = 0;
      break label44;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(337843);
    f localf = this.ATy;
    if (localf != null) {
      localf.onDetach();
    }
    AppMethodBeat.o(337843);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(337834);
    super.onPause();
    AppMethodBeat.o(337834);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337826);
    super.onResume();
    f localf = this.ATy;
    if (localf != null) {
      localf.onUIResume();
    }
    AppMethodBeat.o(337826);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.i
 * JD-Core Version:    0.7.0.1
 */