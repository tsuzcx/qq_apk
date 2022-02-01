package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.ah;
import com.tencent.mm.plugin.finder.report.ah.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"})
public class k$a
  extends b.a
{
  private final boolean dJM;
  public ArrayList<bo> feedList;
  private final int scene;
  public final boolean tAj;
  private final c tNW;
  Dialog tipDialog;
  
  private k$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(243814);
    this.scene = paramInt;
    this.tAj = paramBoolean1;
    this.dJM = paramBoolean2;
    this.feedList = new ArrayList();
    this.tNW = new c(this);
    AppMethodBeat.o(243814);
  }
  
  public final bo IE(int paramInt)
  {
    AppMethodBeat.i(243811);
    bo localbo = dcJ();
    AppMethodBeat.o(243811);
    return localbo;
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(165714);
    p.h(paramb, "callback");
    super.a(paramb);
    this.tNW.alive();
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((FinderFeedMegaVideoBtnAnimUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(paramb.tLS.getRecyclerView());
    AppMethodBeat.o(165714);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(243813);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramMenuItem, "menuItem");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
    if (paramMenuItem.getItemId() == this.tLI)
    {
      if (((Collection)paramBaseFinderFeed.feedObject.getLongVideoMediaList()).isEmpty()) {
        break label96;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label101;
      }
    }
    label96:
    label101:
    for (paramInt = 2131759606;; paramInt = 2131760453)
    {
      h.a((Context)this.gte, paramInt, 0, (DialogInterface.OnClickListener)new b(this, paramBaseFinderFeed), null);
      AppMethodBeat.o(243813);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, m paramm)
  {
    AppMethodBeat.i(243812);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramm, "menu");
    super.a(paramBaseFinderFeed, paramm);
    if (this.dJM)
    {
      paramm.aS(this.tLI, 2131755778, 2131690780);
      if (paramBaseFinderFeed.feedObject.isCommentClose())
      {
        paramm.b(this.tLH, (CharSequence)this.gte.getString(2131759749), 2131690775);
        AppMethodBeat.o(243812);
        return;
      }
      paramm.b(this.tLG, (CharSequence)this.gte.getString(2131759714), 2131690232);
    }
    AppMethodBeat.o(243812);
  }
  
  public final void boE() {}
  
  public final boolean dbZ()
  {
    return this.dJM;
  }
  
  public final ArrayList<bo> dcH()
  {
    return this.feedList;
  }
  
  public final bo dcJ()
  {
    AppMethodBeat.i(243809);
    if (Util.isNullOrNil((List)this.feedList))
    {
      AppMethodBeat.o(243809);
      return null;
    }
    bo localbo = (bo)this.feedList.get(0);
    AppMethodBeat.o(243809);
    return localbo;
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(165708);
    b.b localb = this.tLN;
    if (localb != null)
    {
      localb.ab(this.feedList);
      AppMethodBeat.o(165708);
      return;
    }
    AppMethodBeat.o(165708);
  }
  
  public final DataBuffer<bo> dcc()
  {
    AppMethodBeat.i(243810);
    Object localObject = dcJ();
    if (localObject != null)
    {
      localObject = new DataBuffer(localObject, null, 2, null);
      AppMethodBeat.o(243810);
      return localObject;
    }
    localObject = new DataBuffer(null, 1, null);
    AppMethodBeat.o(243810);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.f dce()
  {
    AppMethodBeat.i(165713);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(165713);
    return localf;
  }
  
  public final int l(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165710);
    p.h(paramBaseFinderFeed, "feed");
    long l = paramBaseFinderFeed.lT();
    paramBaseFinderFeed = dcJ();
    if ((paramBaseFinderFeed != null) && (l == paramBaseFinderFeed.lT()))
    {
      AppMethodBeat.o(165710);
      return 0;
    }
    AppMethodBeat.o(165710);
    return -1;
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(165716);
    super.onDetach();
    this.tNW.dead();
    AppMethodBeat.o(165716);
  }
  
  public final void requestRefresh() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(165706);
      switch (paramInt)
      {
      default: 
        localObject = y.vXH;
        y.dQ(this.tNX.getTAG(), paramInt);
        localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(165706);
        return localObject;
      case 4: 
      case 3002: 
        localObject = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy())
        {
          localObject = (e)new com.tencent.mm.plugin.finder.convert.t(this.tNX.tCD, (i)this.tNX, this.tNX.tAj, 0, 8);
          AppMethodBeat.o(165706);
          return localObject;
        }
        localObject = (e)new ak(this.tNX.tCD, (i)this.tNX, this.tNX.tAj, 0, 8);
        AppMethodBeat.o(165706);
        return localObject;
      }
      Object localObject = y.vXH;
      if (y.isOtherEnableFullScreenEnjoy())
      {
        localObject = (e)new com.tencent.mm.plugin.finder.convert.q((i)this.tNX, this.tNX.tAj, 0, 4);
        AppMethodBeat.o(165706);
        return localObject;
      }
      localObject = (e)new com.tencent.mm.plugin.finder.convert.u((i)this.tNX, this.tNX.tAj, 0, 4);
      AppMethodBeat.o(165706);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(k.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(243806);
      paramDialogInterface = z.aUg();
      p.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new av(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
      Object localObject = this.tNX.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        g.azz().a(paramDialogInterface.getType(), (com.tencent.mm.ak.i)new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(243805);
            if (((paramAnonymousq instanceof av)) && (((av)paramAnonymousq).hFK == paramDialogInterface.hFK)) {
              g.azz().b(paramDialogInterface.getType(), (com.tencent.mm.ak.i)this);
            }
            paramAnonymousString = this.tNZ.tNX.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              this.tNZ.tNX.gte.finish();
              AppMethodBeat.o(243805);
              return;
            }
            com.tencent.mm.ui.base.u.makeText((Context)this.tNZ.tNX.gte, 2131760456, 0).show();
            AppMethodBeat.o(243805);
          }
        });
        g.azz().b((com.tencent.mm.ak.q)paramDialogInterface);
        AppMethodBeat.o(243806);
        return;
        localObject = this.tNX;
        Context localContext = (Context)((b.a)localObject).gte;
        ((b.a)localObject).gte.getString(2131755998);
        ((k.a)localObject).tipDialog = ((Dialog)h.a(localContext, ((b.a)localObject).gte.getString(2131756029), false, (DialogInterface.OnCancelListener)a.tNY));
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a tNY;
      
      static
      {
        AppMethodBeat.i(243804);
        tNY = new a();
        AppMethodBeat.o(243804);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hn>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(k.a.c paramc, hn paramhn)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(k.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165707);
      Object localObject = FinderReporterUIC.wzC;
      localObject = FinderReporterUIC.a.fH((Context)this.tNX.gte);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          new ah((c)localObject).doW().KC(0);
          AppMethodBeat.o(165707);
          return;
        }
      }
      AppMethodBeat.o(165707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k.a
 * JD-Core Version:    0.7.0.1
 */