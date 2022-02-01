package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.plugin.finder.conv.g;
import com.tencent.mm.plugin.finder.extension.reddot.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationTempUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "finish", "", "getLayoutId", "", "getReportTag", "", "getTitleResId", "onResume", "plugin-finder_release"})
public final class FinderConversationTempUI
  extends FinderConversationParentUI
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(265101);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(265101);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(265100);
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
    AppMethodBeat.o(265100);
    return localView1;
  }
  
  public final String duZ()
  {
    AppMethodBeat.i(265095);
    String str = getString(b.j.finder_conversation_message_title);
    p.j(str, "this.getString(R.string.…nversation_message_title)");
    AppMethodBeat.o(265095);
    return str;
  }
  
  public final String dvl()
  {
    return "FinderConversationTempUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(265096);
    super.finish();
    Object localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().xsM.dqs();
    localObject = h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().xsM;
    ((a)localObject).handler.removeMessages(9);
    ((a)localObject).handler.sendEmptyMessage(9);
    AppMethodBeat.o(265096);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_conversation_ui;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(265098);
    super.onResume();
    Object localObject = dZQ().gy(this.AoM.syG.size(), 3);
    String str;
    if (((List)localObject).isEmpty())
    {
      str = "";
      if (!((List)localObject).isEmpty()) {
        break label242;
      }
    }
    int i;
    d locald;
    label242:
    for (long l = 0L;; l = ((d)((List)localObject).get(0)).field_updateTime)
    {
      Log.i("Finder.FinderConversationParentUI", "[onResume] digest:".concat(String.valueOf(str)));
      localObject = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
      i = ((com.tencent.mm.plugin.finder.storage.f)localObject).dYl();
      locald = ((com.tencent.mm.plugin.finder.storage.f)localObject).aEG("finderaliassessionholder");
      if ((i <= 0) || (locald.systemRowid <= 0L) || ((!(p.h(str, locald.field_digest) ^ true)) && (l == locald.field_updateTime))) {
        break label260;
      }
      locald.field_digest = str;
      locald.field_updateTime = l;
      if (!((com.tencent.mm.plugin.finder.storage.f)localObject).update(locald.systemRowid, (IAutoDBItem)locald, false)) {
        break label301;
      }
      ((com.tencent.mm.plugin.finder.storage.f)localObject).doNotify(locald.field_sessionId, 1, locald);
      AppMethodBeat.o(265098);
      return;
      str = ((d)((List)localObject).get(0)).nickname + ':' + ((d)((List)localObject).get(0)).field_digest;
      break;
    }
    label260:
    if ((locald.systemRowid > 0L) && (i == 0) && (((com.tencent.mm.plugin.finder.storage.f)localObject).delete(locald.systemRowid))) {
      ((com.tencent.mm.plugin.finder.storage.f)localObject).doNotify(locald.field_sessionId, 6, locald);
    }
    label301:
    AppMethodBeat.o(265098);
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