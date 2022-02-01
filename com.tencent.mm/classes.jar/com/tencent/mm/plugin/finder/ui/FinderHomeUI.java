package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onNewIntent", "", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderHomeUI
  extends MMFinderUI
{
  public static final a KYz;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(199247);
    KYz = new a((byte)0);
    AppMethodBeat.o(199247);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199248);
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
    AppMethodBeat.o(199248);
    return localView1;
  }
  
  public final int fTB()
  {
    AppMethodBeat.i(199245);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.fUw())
    {
      AppMethodBeat.o(199245);
      return 2;
    }
    AppMethodBeat.o(199245);
    return 1;
  }
  
  public final Set<Class<? extends UIComponent>> fTM()
  {
    AppMethodBeat.i(199243);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.fUw())
    {
      localObject = ak.setOf(new Class[] { FinderTimelineUIC.class, FinderTouchMediaPreviewUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class });
      AppMethodBeat.o(199243);
      return localObject;
    }
    localObject = ak.setOf(new Class[] { FinderHomeUIC.class, FinderHomeActionBarUIC.class, FinderTouchMediaPreviewUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class });
    AppMethodBeat.o(199243);
    return localObject;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(199244);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (!com.tencent.mm.plugin.finder.storage.b.fUw())
    {
      localObject = com.tencent.mm.plugin.finder.report.b.qFq;
      i = com.tencent.mm.plugin.finder.report.b.ahq(0);
      AppMethodBeat.o(199244);
      return i;
    }
    localObject = com.tencent.mm.plugin.finder.report.b.qFq;
    localObject = a.LCX;
    int i = com.tencent.mm.plugin.finder.report.b.ahq(((FinderHomeUIC)a.s((MMActivity)this).get(FinderHomeUIC.class)).fXm());
    AppMethodBeat.o(199244);
    return i;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(199246);
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
      paramIntent = a.LCX;
      paramIntent = a.s((MMActivity)this).get(FinderHomeUIC.class);
      k.g(paramIntent, "UICProvider.of(this).get…inderHomeUIC::class.java)");
      ((FinderHomeUIC)paramIntent).ahU(3);
    }
    AppMethodBeat.o(199246);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderHomeUI
 * JD-Core Version:    0.7.0.1
 */