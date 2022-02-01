package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(48)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "()V", "onNewIntent", "", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLongVideoDetailUI
  extends FinderLongVideoTimelineUI
{
  public static final a Bqd;
  
  static
  {
    AppMethodBeat.i(365755);
    Bqd = new a((byte)0);
    AppMethodBeat.o(365755);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(365766);
    super.onNewIntent(paramIntent);
    Log.i("FinderLongVideoDetailUI", s.X("onNewIntent: recreate for new mega video float ball click hash = ", this));
    paramIntent = new Intent(paramIntent);
    paramIntent.setFlags(0);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.g((Context)this, paramIntent, true);
    d.a(500L, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(365766);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
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