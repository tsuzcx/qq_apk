package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.he;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.report.w.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.view.recyclerview.b;
import d.g.a.a;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"})
public class j$a
  extends a.a
{
  private final boolean drv;
  public ArrayList<al> feedList;
  public final boolean rMJ;
  private final c rVJ;
  private final int scene;
  Dialog tipDialog;
  
  private j$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(201806);
    this.scene = paramInt;
    this.rMJ = paramBoolean1;
    this.drv = paramBoolean2;
    this.feedList = new ArrayList();
    this.rVJ = new c(this);
    AppMethodBeat.o(201806);
  }
  
  public final al Ew(int paramInt)
  {
    AppMethodBeat.i(201803);
    al localal = cBi();
    AppMethodBeat.o(201803);
    return localal;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(165714);
    p.h(paramb, "callback");
    super.a(paramb);
    this.rVJ.alive();
    AppMethodBeat.o(165714);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(201805);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramMenuItem, "menuItem");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
    if (paramMenuItem.getItemId() == this.rTy) {
      com.tencent.mm.ui.base.h.a((Context)this.fLP, 2131759309, 0, (DialogInterface.OnClickListener)new b(this, paramBaseFinderFeed), null);
    }
    AppMethodBeat.o(201805);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(201804);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paraml, "menu");
    super.a(paramBaseFinderFeed, paraml);
    if (this.drv)
    {
      paraml.aL(this.rTy, 2131755707, 2131690551);
      if (paramBaseFinderFeed.feedObject.isCommentClose())
      {
        paraml.a(this.rTx, (CharSequence)this.fLP.getString(2131759223), 2131690547);
        AppMethodBeat.o(201804);
        return;
      }
      paraml.a(this.rTw, (CharSequence)this.fLP.getString(2131759210), 2131690190);
    }
    AppMethodBeat.o(201804);
  }
  
  public final void aTt() {}
  
  public final void cAA()
  {
    AppMethodBeat.i(165708);
    a.b localb = this.rTz;
    if (localb != null)
    {
      localb.U(this.feedList);
      AppMethodBeat.o(165708);
      return;
    }
    AppMethodBeat.o(165708);
  }
  
  public final DataBuffer<al> cAB()
  {
    AppMethodBeat.i(201802);
    Object localObject = cBi();
    if (localObject != null)
    {
      localObject = new DataBuffer(localObject, null, 2, null);
      AppMethodBeat.o(201802);
      return localObject;
    }
    localObject = new DataBuffer(null, 1, null);
    AppMethodBeat.o(201802);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.c cAE()
  {
    AppMethodBeat.i(165713);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new a(this);
    AppMethodBeat.o(165713);
    return localc;
  }
  
  public final boolean cAz()
  {
    return this.drv;
  }
  
  public final ArrayList<al> cBg()
  {
    return this.feedList;
  }
  
  public final al cBi()
  {
    AppMethodBeat.i(201801);
    if (bt.hj((List)this.feedList))
    {
      AppMethodBeat.o(201801);
      return null;
    }
    al localal = (al)this.feedList.get(0);
    AppMethodBeat.o(201801);
    return localal;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165710);
    p.h(paramBaseFinderFeed, "feed");
    long l = paramBaseFinderFeed.lP();
    paramBaseFinderFeed = cBi();
    if ((paramBaseFinderFeed != null) && (l == paramBaseFinderFeed.lP()))
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
    this.rVJ.dead();
    AppMethodBeat.o(165716);
  }
  
  public final void requestRefresh() {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final b<?> AL(int paramInt)
    {
      AppMethodBeat.i(165706);
      switch (paramInt)
      {
      default: 
        localb = (b)new k((h)this.rVK, this.rVK.rMJ, this.rVK.rTD);
        AppMethodBeat.o(165706);
        return localb;
      case 4: 
      case 3002: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.w(this.rVK.rOe, (h)this.rVK, this.rVK.rMJ, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      case 2: 
      case 3001: 
        localb = (b)new k((h)this.rVK, this.rVK.rMJ, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 7: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.u((h)this.rVK, this.rVK.rMJ, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 8: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.n(this.rVK.rOe, (h)this.rVK, this.rVK.rMJ, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      }
      b localb = (b)new com.tencent.mm.plugin.finder.convert.q((h)this.rVK, this.rVK.rMJ, 0, 4);
      AppMethodBeat.o(165706);
      return localb;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(j.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(201798);
      paramDialogInterface = com.tencent.mm.model.u.aAu();
      p.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new aa(paramDialogInterface, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId());
      Object localObject = this.rVK.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        g.aiU().a(paramDialogInterface.getType(), (f)new f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(201797);
            if (((paramAnonymousn instanceof aa)) && (((aa)paramAnonymousn).rIZ == paramDialogInterface.rIZ)) {
              g.aiU().b(paramDialogInterface.getType(), (f)this);
            }
            paramAnonymousString = this.rVM.rVK.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              this.rVM.rVK.fLP.finish();
              AppMethodBeat.o(201797);
              return;
            }
            t.makeText((Context)this.rVM.rVK.fLP, 2131766485, 0).show();
            AppMethodBeat.o(201797);
          }
        });
        g.aiU().b((com.tencent.mm.al.n)paramDialogInterface);
        AppMethodBeat.o(201798);
        return;
        localObject = this.rVK;
        Context localContext = (Context)((a.a)localObject).fLP;
        ((a.a)localObject).fLP.getString(2131755906);
        ((j.a)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b(localContext, ((a.a)localObject).fLP.getString(2131755936), false, (DialogInterface.OnCancelListener)a.rVL));
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a rVL;
      
      static
      {
        AppMethodBeat.i(201796);
        rVL = new a();
        AppMethodBeat.o(201796);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<he>
  {
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements a<z>
    {
      a(j.a.c paramc, he paramhe)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(j.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165707);
      Object localObject = FinderReporterUIC.tcM;
      localObject = FinderReporterUIC.a.eY((Context)this.rVK.fLP);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          new com.tencent.mm.plugin.finder.report.w((com.tencent.mm.plugin.finder.event.base.c)localObject).cEB().Fc(0);
          AppMethodBeat.o(165707);
          return;
        }
      }
      AppMethodBeat.o(165707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.a
 * JD-Core Version:    0.7.0.1
 */