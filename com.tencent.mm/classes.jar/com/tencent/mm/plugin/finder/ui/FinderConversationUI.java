package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.f;
import com.tencent.mm.plugin.finder.conv.f.b;
import com.tencent.mm.plugin.finder.extension.reddot.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "getLayoutId", "", "getTitleResId", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onResume", "Companion", "plugin-finder_release"})
public final class FinderConversationUI
  extends FinderConversationParentUI
  implements f.b
{
  public static final a sBi;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(203939);
    sBi = new a((byte)0);
    AppMethodBeat.o(203939);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203940);
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
    AppMethodBeat.o(203940);
    return localView1;
  }
  
  public final int cJA()
  {
    return 2131766960;
  }
  
  public final int getLayoutId()
  {
    return 2131496390;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(203938);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == 1))
    {
      paramIntent = this.sAZ;
      p.h("findersayhisessionholder", "sessionId");
      com.tencent.mm.plugin.finder.conv.c localc = (com.tencent.mm.plugin.finder.conv.c)paramIntent.rLo.get("findersayhisessionholder");
      paramInt1 = j.a((List)paramIntent.nZa, localc);
      if ((paramInt1 >= 0) && (paramInt1 < paramIntent.nZa.size()))
      {
        paramIntent.nZa.remove(paramInt1);
        paramIntent.rLo.remove("findersayhisessionholder");
        paramIntent.cl(paramInt1);
      }
    }
    AppMethodBeat.o(203938);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203937);
    super.onDestroy();
    com.tencent.mm.kernel.b.a locala = g.ad(PluginFinder.class);
    p.g(locala, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)locala).getRedDotManager().rRV.czE();
    AppMethodBeat.o(203937);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203936);
    super.onResume();
    Object localObject1 = cJx();
    int i = this.sAZ.nZa.size();
    Object localObject2 = ((f)localObject1).rLz;
    int j = ((f)localObject1).scene;
    localObject2 = ((com.tencent.mm.plugin.finder.storage.d)localObject2).a(0, i, new int[] { 1 }, j);
    if (((List)localObject2).isEmpty())
    {
      localObject1 = "";
      if (!((List)localObject2).isEmpty()) {
        break label270;
      }
    }
    label270:
    for (long l = 0L;; l = ((com.tencent.mm.plugin.finder.conv.c)((List)localObject2).get(0)).field_updateTime)
    {
      ad.i("Finder.FinderConversationParentUI", "[onResume] digest:".concat(String.valueOf(localObject1)));
      localObject2 = ((PluginFinder)g.ad(PluginFinder.class)).getConversationStorage();
      i = ((com.tencent.mm.plugin.finder.storage.d)localObject2).Fm(2);
      com.tencent.mm.plugin.finder.conv.c localc = ((com.tencent.mm.plugin.finder.storage.d)localObject2).aiq("findersayhisessionholder");
      if ((i > 0) && (localc.systemRowid > 0L) && (((p.i(localObject1, localc.field_digest) ^ true)) || (l != localc.field_updateTime)))
      {
        localc.field_digest = ((String)localObject1);
        localc.field_updateTime = l;
        if (((com.tencent.mm.plugin.finder.storage.d)localObject2).update(localc.systemRowid, (com.tencent.mm.sdk.e.c)localc, false)) {
          ((com.tencent.mm.plugin.finder.storage.d)localObject2).doNotify(localc.field_sessionId, 1, localc);
        }
      }
      AppMethodBeat.o(203936);
      return;
      localObject1 = ((com.tencent.mm.plugin.finder.conv.c)((List)localObject2).get(0)).nickname + ':' + ((com.tencent.mm.plugin.finder.conv.c)((List)localObject2).get(0)).field_digest;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI$Companion;", "", "()V", "REQUEST_CODE_HI_BOX", "", "RESULT_CODE_REMOVE_HI_BOX", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationUI
 * JD-Core Version:    0.7.0.1
 */