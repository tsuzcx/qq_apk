package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFloatBallUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "enterFromMvMainUI", "", "isBackPressed", "needHideFloatBall", "markNotNeedHideFloatBall", "", "markResumeFloatBall", "onBackBtnClick", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  public static final a FdG;
  boolean FdH;
  private boolean FdI;
  boolean FdJ;
  
  static
  {
    AppMethodBeat.i(348829);
    FdG = new a((byte)0);
    AppMethodBeat.o(348829);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348824);
    AppMethodBeat.o(348824);
  }
  
  public final void eJf()
  {
    AppMethodBeat.i(348862);
    this.FdJ = false;
    ((b)h.ax(b.class)).mq(false);
    AppMethodBeat.o(348862);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(348852);
    this.FdH = true;
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(348852);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(348834);
    super.onCreate(paramBundle);
    if (getIntent().getIntExtra("key_from_profile_share_scene", -1) == 19) {}
    for (boolean bool = true;; bool = false)
    {
      this.FdI = bool;
      this.FdJ = getIntent().getBooleanExtra("key_hide_float_ball", false);
      AppMethodBeat.o(348834);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(348871);
    super.onPause();
    if ((this.FdI) && (getIntent().getBooleanExtra("key_hide_float_ball", false))) {
      ((b)h.ax(b.class)).mq(false);
    }
    AppMethodBeat.o(348871);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(348844);
    super.onResume();
    this.FdH = false;
    if (this.FdJ)
    {
      ((b)h.ax(b.class)).mq(true);
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    AppMethodBeat.o(348844);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFloatBallUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.f
 * JD-Core Version:    0.7.0.1
 */