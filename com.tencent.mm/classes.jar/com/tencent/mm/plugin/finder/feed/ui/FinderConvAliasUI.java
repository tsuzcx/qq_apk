package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.ui.FinderConversationParentUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderConvAliasUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "getLayoutId", "", "getTitleResId", "", "plugin-finder_release"})
public final class FinderConvAliasUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(267956);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(267956);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(267955);
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
    AppMethodBeat.o(267955);
    return localView1;
  }
  
  public final String duZ()
  {
    AppMethodBeat.i(267953);
    Object localObject = d.wZQ;
    localObject = d.a.dnj().getNickname();
    localObject = MMApplicationContext.getContext().getString(b.j.finder_message_alias_holder, new Object[] { localObject });
    p.j(localObject, "MMApplicationContext.get…lder,finderAliasNickName)");
    AppMethodBeat.o(267953);
    return localObject;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_conversation_ui;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderConvAliasUI
 * JD-Core Version:    0.7.0.1
 */