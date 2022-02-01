package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveInvitedUI;", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "getLayoutId", "", "onClick", "", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderLiveInvitedUI
  extends MMActivity
  implements View.OnClickListener, i
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245371);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245371);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245370);
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
    AppMethodBeat.o(245370);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494407;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245369);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLiveInvitedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveInvitedUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245369);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveInvitedUI
 * JD-Core Version:    0.7.0.1
 */