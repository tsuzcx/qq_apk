package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.convert.p;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.q.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.view.recyclerview.b;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"})
public class i$a
  extends b.a
{
  private final boolean dfZ;
  public ArrayList<BaseFinderFeed> feedList;
  public final boolean ran;
  private final c rhD;
  private final int scene;
  Dialog tipDialog;
  
  private i$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201607);
    this.scene = paramInt;
    this.ran = paramBoolean1;
    this.dfZ = paramBoolean2;
    this.feedList = new ArrayList();
    this.rhD = new c(this);
    AppMethodBeat.o(201607);
  }
  
  private final BaseFinderFeed cuR()
  {
    AppMethodBeat.i(165709);
    if (bs.gY((List)this.feedList))
    {
      AppMethodBeat.o(165709);
      return null;
    }
    Object localObject = this.feedList;
    if (localObject == null) {
      k.fOy();
    }
    localObject = (BaseFinderFeed)((ArrayList)localObject).get(0);
    AppMethodBeat.o(165709);
    return localObject;
  }
  
  public final BaseFinderFeed DD(int paramInt)
  {
    AppMethodBeat.i(165712);
    BaseFinderFeed localBaseFinderFeed = cuR();
    AppMethodBeat.o(165712);
    return localBaseFinderFeed;
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(165714);
    k.h(paramb, "callback");
    super.a(paramb);
    this.rhD.alive();
    AppMethodBeat.o(165714);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(201606);
    k.h(paramBaseFinderFeed, "feed");
    k.h(paramMenuItem, "menuItem");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
    if (paramMenuItem.getItemId() == this.rfM) {
      h.a((Context)this.iMV, 2131759309, 0, (DialogInterface.OnClickListener)new b(this, paramBaseFinderFeed), null);
    }
    AppMethodBeat.o(201606);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(201605);
    k.h(paramBaseFinderFeed, "feed");
    k.h(paraml, "menu");
    super.a(paramBaseFinderFeed, paraml);
    if (this.dfZ)
    {
      paraml.aJ(this.rfM, 2131755707, 2131690551);
      if (paramBaseFinderFeed.feedObject.isCommentClose())
      {
        paraml.a(this.rfL, (CharSequence)this.iMV.getString(2131759223), 2131690547);
        AppMethodBeat.o(201605);
        return;
      }
      paraml.a(this.rfK, (CharSequence)this.iMV.getString(2131759210), 2131690190);
    }
    AppMethodBeat.o(201605);
  }
  
  public final void aQh() {}
  
  public final ArrayList<BaseFinderFeed> cuP()
  {
    return this.feedList;
  }
  
  public final boolean cuq()
  {
    return this.dfZ;
  }
  
  public final void cur()
  {
    AppMethodBeat.i(165708);
    b.b localb = this.rfN;
    if (localb != null)
    {
      localb.U(this.feedList);
      AppMethodBeat.o(165708);
      return;
    }
    AppMethodBeat.o(165708);
  }
  
  public final DataBuffer<BaseFinderFeed> cus()
  {
    AppMethodBeat.i(201604);
    Object localObject = cuR();
    if (localObject != null)
    {
      localObject = new DataBuffer(localObject, null, 2, null);
      AppMethodBeat.o(201604);
      return localObject;
    }
    localObject = new DataBuffer(null, 1, null);
    AppMethodBeat.o(201604);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.c cut()
  {
    AppMethodBeat.i(165713);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new a(this);
    AppMethodBeat.o(165713);
    return localc;
  }
  
  public final int f(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165710);
    k.h(paramBaseFinderFeed, "feed");
    long l = paramBaseFinderFeed.lx();
    paramBaseFinderFeed = cuR();
    if ((paramBaseFinderFeed != null) && (l == paramBaseFinderFeed.lx()))
    {
      AppMethodBeat.o(165710);
      return 0;
    }
    AppMethodBeat.o(165710);
    return -1;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165716);
    super.onDetach();
    this.rhD.dead();
    AppMethodBeat.o(165716);
  }
  
  public final void requestRefresh() {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(165706);
      switch (paramInt)
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localb = (b)new j((g)this.rhE, this.rhE.ran, this.rhE.rfR);
        AppMethodBeat.o(165706);
        return localb;
      case 4: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.v(this.rhE.rbo, (g)this.rhE, this.rhE.ran, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      case 2: 
        localb = (b)new j((g)this.rhE, this.rhE.ran, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 7: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.t((g)this.rhE, this.rhE.ran, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 8: 
        localb = (b)new m(this.rhE.rbo, (g)this.rhE, this.rhE.ran, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      }
      b localb = (b)new p((g)this.rhE, this.rhE.ran, 0, 4);
      AppMethodBeat.o(165706);
      return localb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(i.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(201601);
      paramDialogInterface = u.axE();
      k.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new com.tencent.mm.plugin.finder.cgi.v(paramDialogInterface, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId());
      Object localObject = this.rhE.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.agi().a(paramDialogInterface.getType(), (com.tencent.mm.ak.g)new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(201600);
            if (((paramAnonymousn instanceof com.tencent.mm.plugin.finder.cgi.v)) && (((com.tencent.mm.plugin.finder.cgi.v)paramAnonymousn).qXP == paramDialogInterface.qXP)) {
              com.tencent.mm.kernel.g.agi().b(paramDialogInterface.getType(), (com.tencent.mm.ak.g)this);
            }
            paramAnonymousString = this.rhG.rhE.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              this.rhG.rhE.iMV.finish();
              AppMethodBeat.o(201600);
              return;
            }
            com.tencent.mm.ui.base.t.makeText((Context)this.rhG.rhE.iMV, 2131766485, 0).show();
            AppMethodBeat.o(201600);
          }
        });
        com.tencent.mm.kernel.g.agi().b((n)paramDialogInterface);
        AppMethodBeat.o(201601);
        return;
        localObject = this.rhE;
        Context localContext = (Context)((b.a)localObject).iMV;
        ((b.a)localObject).iMV.getString(2131755906);
        ((i.a)localObject).tipDialog = ((Dialog)h.b(localContext, ((b.a)localObject).iMV.getString(2131755936), false, (DialogInterface.OnCancelListener)i.a.b.a.rhF));
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<ha>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(i.a.c paramc, ha paramha)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(i.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165707);
      Object localObject = FinderReporterUIC.seQ;
      localObject = FinderReporterUIC.a.eV((Context)this.rhE.iMV);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          new com.tencent.mm.plugin.finder.report.q((com.tencent.mm.plugin.finder.event.base.c)localObject).cxF().DY(0);
          AppMethodBeat.o(165707);
          return;
        }
      }
      AppMethodBeat.o(165707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i.a
 * JD-Core Version:    0.7.0.1
 */