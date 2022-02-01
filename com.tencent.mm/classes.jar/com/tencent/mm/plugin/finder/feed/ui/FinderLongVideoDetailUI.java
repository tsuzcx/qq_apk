package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(48)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "()V", "onNewIntent", "", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderLongVideoDetailUI
  extends FinderLongVideoTimelineUI
{
  public static final a ubM;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(245414);
    ubM = new a((byte)0);
    AppMethodBeat.o(245414);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245416);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245416);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245415);
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
    AppMethodBeat.o(245415);
    return localView1;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(245413);
    super.onNewIntent(paramIntent);
    Log.i("FinderLongVideoDetailUI", "onNewIntent: recreate for new mega video float ball click hash = ".concat(String.valueOf(this)));
    paramIntent = new Intent(paramIntent);
    paramIntent.setFlags(0);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.vUU;
    com.tencent.mm.plugin.finder.utils.a.d((Context)this, paramIntent, true);
    d.a(500L, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(245413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(FinderLongVideoDetailUI paramFinderLongVideoDetailUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoDetailUI
 * JD-Core Version:    0.7.0.1
 */