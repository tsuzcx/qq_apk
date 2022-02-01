package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFloatBallUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "enterFromMvMainUI", "", "isBackPressed", "needHideFloatBall", "markNotNeedHideFloatBall", "", "markResumeFloatBall", "onBackBtnClick", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderProfileFloatBallUIC
  extends UIComponent
{
  public static final a vbg;
  private boolean Rcc;
  public boolean UpW;
  boolean vbf;
  
  static
  {
    AppMethodBeat.i(250252);
    vbg = new a((byte)0);
    AppMethodBeat.o(250252);
  }
  
  public FinderProfileFloatBallUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250251);
    AppMethodBeat.o(250251);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(250249);
    this.vbf = true;
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(250249);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(258543);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("key_from_profile_share_scene", -1) == 19) {}
    for (boolean bool = true;; bool = false)
    {
      this.Rcc = bool;
      this.UpW = getIntent().getBooleanExtra("key_hide_float_ball", false);
      AppMethodBeat.o(258543);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(258545);
    super.onPause();
    if ((this.Rcc) && (getIntent().getBooleanExtra("key_hide_float_ball", false))) {
      ((b)g.af(b.class)).jS(false);
    }
    AppMethodBeat.o(258545);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(258544);
    super.onResume();
    this.vbf = false;
    if (this.UpW)
    {
      ((b)g.af(b.class)).jS(true);
      f.cjk();
    }
    AppMethodBeat.o(258544);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFloatBallUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileFloatBallUIC
 * JD-Core Version:    0.7.0.1
 */