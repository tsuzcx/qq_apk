package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationTempUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "finish", "", "getReportTag", "", "getTitleResId", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConversationTempUI
  extends FinderConversationParentUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final String eeH()
  {
    AppMethodBeat.i(346632);
    String str = getString(e.h.finder_conversation_message_title);
    s.s(str, "this.getString(R.string.…nversation_message_title)");
    AppMethodBeat.o(346632);
    return str;
  }
  
  public final String efe()
  {
    return "FinderConversationTempUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(346638);
    super.finish();
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().AQv.dYZ();
    com.tencent.mm.plugin.finder.extension.reddot.b localb = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().AQv;
    localb.handler.removeMessages(9);
    localb.handler.sendEmptyMessage(9);
    AppMethodBeat.o(346638);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(346647);
    super.onResume();
    Object localObject = ((e)((FinderBaseConversationFragment)getFragment()).aNC()).Nd(3);
    String str;
    if (((List)localObject).isEmpty())
    {
      str = "";
      if (!((List)localObject).isEmpty()) {
        break label236;
      }
    }
    int i;
    com.tencent.mm.plugin.finder.conv.b localb;
    label236:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.finder.conv.b)((List)localObject).get(0)).field_updateTime)
    {
      Log.i("Finder.FinderConversationParentUI", s.X("[onResume] digest:", str));
      localObject = ((PluginFinder)h.az(PluginFinder.class)).getConversationStorage();
      i = ((g)localObject).eYJ();
      localb = ((g)localObject).aAz("finderaliassessionholder");
      if ((i <= 0) || (localb.systemRowid <= 0L) || ((s.p(str, localb.field_digest)) && (l == localb.field_updateTime))) {
        break label254;
      }
      localb.field_digest = str;
      localb.field_updateTime = l;
      if (!((g)localObject).update(localb.systemRowid, (IAutoDBItem)localb, false)) {
        break label295;
      }
      ((g)localObject).doNotify(localb.field_sessionId, 1, localb);
      AppMethodBeat.o(346647);
      return;
      str = ((com.tencent.mm.plugin.finder.conv.b)((List)localObject).get(0)).nickname + ':' + ((com.tencent.mm.plugin.finder.conv.b)((List)localObject).get(0)).field_digest;
      break;
    }
    label254:
    if ((localb.systemRowid > 0L) && (i == 0) && (((g)localObject).delete(localb.systemRowid))) {
      ((g)localObject).doNotify(localb.field_sessionId, 6, localb);
    }
    label295:
    AppMethodBeat.o(346647);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationTempUI
 * JD-Core Version:    0.7.0.1
 */