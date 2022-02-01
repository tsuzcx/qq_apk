package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderWxMsgUIC;
import com.tencent.mm.ui.component.UIComponent;
import d.a.ak;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderWxMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"})
public final class FinderWxMsgUI
  extends MMFinderUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  
  public FinderWxMsgUI()
  {
    AppMethodBeat.i(167688);
    this.TAG = "Finder.FinderWxMsgUI";
    AppMethodBeat.o(167688);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204873);
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
    AppMethodBeat.o(204873);
    return localView1;
  }
  
  public final int cCL()
  {
    return 5;
  }
  
  public final Set<Class<? extends UIComponent>> cEg()
  {
    AppMethodBeat.i(204872);
    Set localSet = ak.setOf(FinderWxMsgUIC.class);
    AppMethodBeat.o(204872);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderWxMsgUI
 * JD-Core Version:    0.7.0.1
 */