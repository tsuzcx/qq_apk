package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import d.a.ak;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onNewIntent", "", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderHomeUI
  extends MMFinderUI
{
  public static final FinderHomeUI.a rHP;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(203217);
    rHP = new FinderHomeUI.a((byte)0);
    AppMethodBeat.o(203217);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203218);
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
    AppMethodBeat.o(203218);
    return localView1;
  }
  
  public final int cuI()
  {
    AppMethodBeat.i(203214);
    Object localObject = b.rCU;
    if (!b.czT())
    {
      localObject = d.rxr;
      i = d.DW(0);
      AppMethodBeat.o(203214);
      return i;
    }
    localObject = d.rxr;
    localObject = a.IrY;
    int i = d.DW(((FinderHomeUIC)a.q((MMActivity)this).get(FinderHomeUIC.class)).cFV());
    AppMethodBeat.o(203214);
    return i;
  }
  
  public final int cvJ()
  {
    AppMethodBeat.i(203215);
    b localb = b.rCU;
    if (!b.czT())
    {
      AppMethodBeat.o(203215);
      return 2;
    }
    AppMethodBeat.o(203215);
    return 1;
  }
  
  public final Set<Class<? extends UIComponent>> cwg()
  {
    AppMethodBeat.i(203213);
    Object localObject = b.rCU;
    if (!b.czT())
    {
      localObject = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderTouchMediaPreviewUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class });
      AppMethodBeat.o(203213);
      return localObject;
    }
    localObject = ak.setOf(new Class[] { FinderHomeUIC.class, FinderHomeActionBarUIC.class, FinderTouchMediaPreviewUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class });
    AppMethodBeat.o(203213);
    return localObject;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(203216);
    super.onNewIntent(paramIntent);
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
    }
    paramIntent = getIntent();
    if (paramIntent != null) {
      paramIntent.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", bool);
    }
    if (bool)
    {
      paramIntent = a.IrY;
      paramIntent = a.q((MMActivity)this).get(FinderHomeUIC.class);
      k.g(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
      ((FinderHomeUIC)paramIntent).Fb(3);
    }
    AppMethodBeat.o(203216);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeUI
 * JD-Core Version:    0.7.0.1
 */