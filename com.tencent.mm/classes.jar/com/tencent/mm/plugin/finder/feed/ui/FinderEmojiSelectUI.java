package com.tencent.mm.plugin.finder.feed.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.m;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderEmojiSelectUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEmojiSelectUI
  extends MMFinderUI
{
  private static final boolean a(FinderEmojiSelectUI paramFinderEmojiSelectUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364842);
    s.u(paramFinderEmojiSelectUI, "this$0");
    paramFinderEmojiSelectUI.finish();
    AppMethodBeat.o(364842);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getCommentScene()
  {
    return 129;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364857);
    Set localSet = ar.setOf(m.class);
    AppMethodBeat.o(364857);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364867);
    super.onCreate(paramBundle);
    setBackBtn(new FinderEmojiSelectUI..ExternalSyntheticLambda0(this));
    setMMTitle(getResources().getString(e.h.finder_post_emoji_choose_ui_title));
    AppMethodBeat.o(364867);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderEmojiSelectUI
 * JD-Core Version:    0.7.0.1
 */