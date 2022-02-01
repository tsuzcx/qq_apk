package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.g;
import com.tencent.mm.plugin.finder.convert.i;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.j.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.view.recyclerview.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"})
public class d$a
  extends a.a
{
  private final d.a.d KNn;
  private final boolean diE;
  public ArrayList<BaseFinderFeed> feedList;
  public final boolean qqF;
  private final int scene;
  Dialog tipDialog;
  
  private d$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(197710);
    this.scene = paramInt;
    this.qqF = paramBoolean1;
    this.diE = paramBoolean2;
    this.feedList = new ArrayList();
    this.KNn = new d.a.d(this);
    AppMethodBeat.o(197710);
  }
  
  private final BaseFinderFeed clX()
  {
    AppMethodBeat.i(165709);
    if (bt.gL((List)this.feedList))
    {
      AppMethodBeat.o(165709);
      return null;
    }
    Object localObject = this.feedList;
    if (localObject == null) {
      k.fvU();
    }
    localObject = (BaseFinderFeed)((ArrayList)localObject).get(0);
    AppMethodBeat.o(165709);
    return localObject;
  }
  
  public final BaseFinderFeed CB(int paramInt)
  {
    AppMethodBeat.i(165712);
    BaseFinderFeed localBaseFinderFeed = clX();
    AppMethodBeat.o(165712);
    return localBaseFinderFeed;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(165714);
    k.h(paramb, "callback");
    super.a(paramb);
    this.KNn.alive();
    AppMethodBeat.o(165714);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(197709);
    k.h(paramBaseFinderFeed, "feed");
    k.h(paramMenuItem, "menuItem");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
    if (paramMenuItem.getItemId() == this.KMM) {
      h.a((Context)this.imP, 2131759309, 0, (DialogInterface.OnClickListener)new d.a.c(this, paramBaseFinderFeed), null);
    }
    AppMethodBeat.o(197709);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(197708);
    k.h(paramBaseFinderFeed, "feed");
    k.h(paraml, "menu");
    super.a(paramBaseFinderFeed, paraml);
    if (this.diE)
    {
      paraml.aI(this.KMM, 2131755707, 2131690551);
      if (paramBaseFinderFeed.feedObject.isCommentClose())
      {
        paraml.a(this.qtY, (CharSequence)this.imP.getString(2131759223), 2131690547);
        AppMethodBeat.o(197708);
        return;
      }
      paraml.a(this.qtX, (CharSequence)this.imP.getString(2131759210), 2131690190);
    }
    AppMethodBeat.o(197708);
  }
  
  public final void aJq() {}
  
  public final boolean clH()
  {
    return this.diE;
  }
  
  public final void clJ()
  {
    AppMethodBeat.i(165708);
    a.b localb = this.qtZ;
    if (localb != null)
    {
      localb.N(this.feedList);
      AppMethodBeat.o(165708);
      return;
    }
    AppMethodBeat.o(165708);
  }
  
  public com.tencent.mm.view.recyclerview.c clL()
  {
    AppMethodBeat.i(165713);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new a(this);
    AppMethodBeat.o(165713);
    return localc;
  }
  
  public final ArrayList<BaseFinderFeed> clY()
  {
    return this.feedList;
  }
  
  public final int e(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165710);
    k.h(paramBaseFinderFeed, "feed");
    long l = paramBaseFinderFeed.bMs();
    paramBaseFinderFeed = clX();
    if ((paramBaseFinderFeed != null) && (l == paramBaseFinderFeed.bMs()))
    {
      AppMethodBeat.o(165710);
      return 0;
    }
    AppMethodBeat.o(165710);
    return -1;
  }
  
  public final DataBuffer<BaseFinderFeed> fSV()
  {
    AppMethodBeat.i(197707);
    Object localObject = clX();
    if (localObject != null)
    {
      localObject = new DataBuffer(localObject, null, 2, null);
      AppMethodBeat.o(197707);
      return localObject;
    }
    localObject = new DataBuffer(null, 1, null);
    AppMethodBeat.o(197707);
    return localObject;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165716);
    super.onDetach();
    this.KNn.dead();
    AppMethodBeat.o(165716);
  }
  
  public final void requestRefresh() {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final b<?> zm(int paramInt)
    {
      AppMethodBeat.i(165706);
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localb = (b)new g((c)this.qvn, this.qvn.qqF, this.qvn.qqE);
        AppMethodBeat.o(165706);
        return localb;
      case 4: 
        localb = (b)new r(this.qvn.qrq, (c)this.qvn, this.qvn.qqF, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      case 2: 
        localb = (b)new g((c)this.qvn, this.qvn.qqF, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 7: 
        localb = (b)new o((c)this.qvn, this.qvn.qqF, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 8: 
        localb = (b)new i(this.qvn.qrq, (c)this.qvn, this.qvn.qqF, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      }
      b localb = (b)new com.tencent.mm.plugin.finder.convert.l((c)this.qvn, this.qvn.qqF, 0, 4);
      AppMethodBeat.o(165706);
      return localb;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(d.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165707);
      Object localObject = FinderReporterUIC.Ljl;
      localObject = FinderReporterUIC.a.lB((Context)this.qvn.imP);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          new j((d)localObject).coj().CN(0);
          AppMethodBeat.o(165707);
          return;
        }
      }
      AppMethodBeat.o(165707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.d.a
 * JD-Core Version:    0.7.0.1
 */