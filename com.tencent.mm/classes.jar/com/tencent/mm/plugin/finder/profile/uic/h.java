package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFloatBallUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "enterFromMvMainUI", "", "isBackPressed", "needHideFloatBall", "markNotNeedHideFloatBall", "", "markResumeFloatBall", "onBackBtnClick", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class h
  extends UIComponent
{
  public static final a zRn;
  boolean zRk;
  private boolean zRl;
  public boolean zRm;
  
  static
  {
    AppMethodBeat.i(288770);
    zRn = new a((byte)0);
    AppMethodBeat.o(288770);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(288769);
    AppMethodBeat.o(288769);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(288767);
    this.zRk = true;
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(288767);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288765);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("key_from_profile_share_scene", -1) == 19) {}
    for (boolean bool = true;; bool = false)
    {
      this.zRl = bool;
      this.zRm = getIntent().getBooleanExtra("key_hide_float_ball", false);
      AppMethodBeat.o(288765);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(288768);
    super.onPause();
    if ((this.zRl) && (getIntent().getBooleanExtra("key_hide_float_ball", false))) {
      ((b)com.tencent.mm.kernel.h.ae(b.class)).ld(false);
    }
    AppMethodBeat.o(288768);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(288766);
    super.onResume();
    this.zRk = false;
    if (this.zRm)
    {
      ((b)com.tencent.mm.kernel.h.ae(b.class)).ld(true);
      f.cvI();
    }
    AppMethodBeat.o(288766);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFloatBallUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.h
 * JD-Core Version:    0.7.0.1
 */