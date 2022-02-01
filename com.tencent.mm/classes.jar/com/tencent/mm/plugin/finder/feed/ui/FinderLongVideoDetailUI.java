package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(48)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "()V", "onNewIntent", "", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderLongVideoDetailUI
  extends FinderLongVideoTimelineUI
{
  public static final a xQF;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(279286);
    xQF = new a((byte)0);
    AppMethodBeat.o(279286);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(279288);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(279288);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(279287);
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
    AppMethodBeat.o(279287);
    return localView1;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(279285);
    super.onNewIntent(paramIntent);
    Log.i("FinderLongVideoDetailUI", "onNewIntent: recreate for new mega video float ball click hash = ".concat(String.valueOf(this)));
    paramIntent = new Intent(paramIntent);
    paramIntent.setFlags(0);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
    com.tencent.mm.plugin.finder.utils.a.d((Context)this, paramIntent, true);
    d.a(500L, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(279285);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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