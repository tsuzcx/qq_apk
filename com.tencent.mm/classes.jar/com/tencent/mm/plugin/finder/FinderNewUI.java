package com.tencent.mm.plugin.finder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/FinderNewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderNewUI
  extends MMActivity
{
  private static final String TAG = "Finder.MMFinderUI";
  public static final a wUI;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(162432);
    wUI = new a((byte)0);
    TAG = "Finder.MMFinderUI";
    AppMethodBeat.o(162432);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(288632);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(288632);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(288631);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(288631);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(162431);
    super.finish();
    Log.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
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
    Log.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162429);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(162427);
    super.onDestroy();
    Log.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162427);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(162428);
    super.onPause();
    Log.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162428);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(162430);
    super.onResume();
    Log.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ",  " + getTaskId());
    AppMethodBeat.o(162430);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/FinderNewUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.FinderNewUI
 * JD-Core Version:    0.7.0.1
 */