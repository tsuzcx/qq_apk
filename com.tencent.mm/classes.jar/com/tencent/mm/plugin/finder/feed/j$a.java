package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.report.x.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.view.recyclerview.b;
import d.g.a.a;
import d.g.b.p;
import d.z;
import java.util.ArrayList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"})
public class j$a
  extends a.a
{
  private final boolean dsB;
  public ArrayList<am> feedList;
  public final boolean rUX;
  private final int scene;
  private final c sep;
  Dialog tipDialog;
  
  private j$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(202265);
    this.scene = paramInt;
    this.rUX = paramBoolean1;
    this.dsB = paramBoolean2;
    this.feedList = new ArrayList();
    this.sep = new c(this);
    AppMethodBeat.o(202265);
  }
  
  public final am EJ(int paramInt)
  {
    AppMethodBeat.i(202262);
    am localam = cCU();
    AppMethodBeat.o(202262);
    return localam;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(165714);
    p.h(paramb, "callback");
    super.a(paramb);
    this.sep.alive();
    AppMethodBeat.o(165714);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(202264);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramMenuItem, "menuItem");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
    if (paramMenuItem.getItemId() == this.scc) {
      com.tencent.mm.ui.base.h.a((Context)this.fNT, 2131759309, 0, (DialogInterface.OnClickListener)new b(this, paramBaseFinderFeed), null);
    }
    AppMethodBeat.o(202264);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(202263);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paraml, "menu");
    super.a(paramBaseFinderFeed, paraml);
    if (this.dsB)
    {
      paraml.aM(this.scc, 2131755707, 2131690551);
      if (paramBaseFinderFeed.feedObject.isCommentClose())
      {
        paraml.a(this.scb, (CharSequence)this.fNT.getString(2131759223), 2131690547);
        AppMethodBeat.o(202263);
        return;
      }
      paraml.a(this.sca, (CharSequence)this.fNT.getString(2131759210), 2131690190);
    }
    AppMethodBeat.o(202263);
  }
  
  public final void aTS() {}
  
  public final ArrayList<am> cCS()
  {
    return this.feedList;
  }
  
  public final am cCU()
  {
    AppMethodBeat.i(202260);
    if (bu.ht((List)this.feedList))
    {
      AppMethodBeat.o(202260);
      return null;
    }
    am localam = (am)this.feedList.get(0);
    AppMethodBeat.o(202260);
    return localam;
  }
  
  public final boolean cCl()
  {
    return this.dsB;
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(165708);
    a.b localb = this.scd;
    if (localb != null)
    {
      localb.U(this.feedList);
      AppMethodBeat.o(165708);
      return;
    }
    AppMethodBeat.o(165708);
  }
  
  public final DataBuffer<am> cCn()
  {
    AppMethodBeat.i(202261);
    Object localObject = cCU();
    if (localObject != null)
    {
      localObject = new DataBuffer(localObject, null, 2, null);
      AppMethodBeat.o(202261);
      return localObject;
    }
    localObject = new DataBuffer(null, 1, null);
    AppMethodBeat.o(202261);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.c cCq()
  {
    AppMethodBeat.i(165713);
    com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new a(this);
    AppMethodBeat.o(165713);
    return localc;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165710);
    p.h(paramBaseFinderFeed, "feed");
    long l = paramBaseFinderFeed.lP();
    paramBaseFinderFeed = cCU();
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
    this.sep.dead();
    AppMethodBeat.o(165716);
  }
  
  public final void requestRefresh() {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final b<?> AX(int paramInt)
    {
      AppMethodBeat.i(165706);
      switch (paramInt)
      {
      default: 
        localb = (b)new k((h)this.ser, this.ser.rUX, this.ser.sch);
        AppMethodBeat.o(165706);
        return localb;
      case 4: 
      case 3002: 
        localb = (b)new w(this.ser.rWB, (h)this.ser, this.ser.rUX, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      case 2: 
      case 3001: 
        localb = (b)new k((h)this.ser, this.ser.rUX, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 7: 
        localb = (b)new u((h)this.ser, this.ser.rUX, 0, 4);
        AppMethodBeat.o(165706);
        return localb;
      case 8: 
        localb = (b)new com.tencent.mm.plugin.finder.convert.n(this.ser.rWB, (h)this.ser, this.ser.rUX, 0, 8);
        AppMethodBeat.o(165706);
        return localb;
      }
      b localb = (b)new com.tencent.mm.plugin.finder.convert.q((h)this.ser, this.ser.rUX, 0, 4);
      AppMethodBeat.o(165706);
      return localb;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(j.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(202257);
      paramDialogInterface = v.aAK();
      p.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new ab(paramDialogInterface, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId());
      Object localObject = this.ser.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        g.ajj().a(paramDialogInterface.getType(), (f)new f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(202256);
            if (((paramAnonymousn instanceof ab)) && (((ab)paramAnonymousn).rRn == paramDialogInterface.rRn)) {
              g.ajj().b(paramDialogInterface.getType(), (f)this);
            }
            paramAnonymousString = this.set.ser.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              this.set.ser.fNT.finish();
              AppMethodBeat.o(202256);
              return;
            }
            t.makeText((Context)this.set.ser.fNT, 2131766485, 0).show();
            AppMethodBeat.o(202256);
          }
        });
        g.ajj().b((com.tencent.mm.ak.n)paramDialogInterface);
        AppMethodBeat.o(202257);
        return;
        localObject = this.ser;
        Context localContext = (Context)((a.a)localObject).fNT;
        ((a.a)localObject).fNT.getString(2131755906);
        ((j.a)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b(localContext, ((a.a)localObject).fNT.getString(2131755936), false, (DialogInterface.OnCancelListener)j.a.b.a.ses));
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hf>
  {
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements a<z>
    {
      a(j.a.c paramc, hf paramhf)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(j.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165707);
      Object localObject = FinderReporterUIC.tnG;
      localObject = FinderReporterUIC.a.fc((Context)this.ser.fNT);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          new x((com.tencent.mm.plugin.finder.event.base.c)localObject).cGx().Fy(0);
          AppMethodBeat.o(165707);
          return;
        }
      }
      AppMethodBeat.o(165707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.a
 * JD-Core Version:    0.7.0.1
 */