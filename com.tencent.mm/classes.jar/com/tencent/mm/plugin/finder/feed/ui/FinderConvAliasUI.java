package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.FinderConversationParentUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderConvAliasUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "getTitleResId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConvAliasUI
  extends FinderConversationParentUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final String eeH()
  {
    AppMethodBeat.i(365574);
    Object localObject = d.AwY;
    localObject = d.a.dUd().getNickname();
    localObject = MMApplicationContext.getContext().getString(e.h.finder_message_alias_holder, new Object[] { localObject });
    s.s(localObject, "getContext().getString(R…lder,finderAliasNickName)");
    AppMethodBeat.o(365574);
    return localObject;
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