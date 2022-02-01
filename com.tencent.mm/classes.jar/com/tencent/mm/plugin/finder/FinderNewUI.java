package com.tencent.mm.plugin.finder;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/FinderNewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderNewUI
  extends MMActivity
{
  private static final String TAG = "Finder.MMFinderUI";
  public static final a rNY;
  
  static
  {
    AppMethodBeat.i(162432);
    rNY = new a((byte)0);
    TAG = "Finder.MMFinderUI";
    AppMethodBeat.o(162432);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(162431);
    super.finish();
    ae.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162431);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(162429);
    super.onCreate(paramBundle);
    ae.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162429);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(162427);
    super.onDestroy();
    ae.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162427);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(162428);
    super.onPause();
    ae.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162428);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(162430);
    super.onResume();
    ae.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/FinderNewUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.FinderNewUI
 * JD-Core Version:    0.7.0.1
 */