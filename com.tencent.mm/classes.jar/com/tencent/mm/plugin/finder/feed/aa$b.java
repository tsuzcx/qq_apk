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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.recyclerview.e;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "activity", "Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10;", "isSelfFlag", "", "username", "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI10;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFromScene", "()I", "()Z", "getRequestAtScene", "tipDialog", "Landroid/app/Dialog;", "getUsername", "()Ljava/lang/String;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealMenuClick", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "index", "getCreateSecondMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class aa$b
  extends v.a
{
  private final int fromScene;
  private final boolean tFN;
  private final int tLA;
  private final com.tencent.mm.plugin.finder.feed.model.d tLy;
  final OccupyFinderUI10 tPr;
  Dialog tipDialog;
  private final bbn ttO;
  private final String username;
  
  public aa$b(OccupyFinderUI10 paramOccupyFinderUI10, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, bbn parambbn)
  {
    super((MMActivity)paramOccupyFinderUI10);
    AppMethodBeat.i(244049);
    this.tPr = paramOccupyFinderUI10;
    this.tFN = paramBoolean;
    this.username = paramString;
    this.tLA = paramInt1;
    this.fromScene = paramInt2;
    this.ttO = parambbn;
    this.dLS = -2147483648;
    paramOccupyFinderUI10 = a.PRN;
    this.tLy = ((FinderCommentPreloaderUIC)a.b((AppCompatActivity)this.gte).get(FinderCommentPreloaderUIC.class)).tLy;
    AppMethodBeat.o(244049);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
  {
    AppMethodBeat.i(244044);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.tLy.a(this.tLA, this.tCE, (b)new d(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
        AppMethodBeat.o(244044);
        return;
      }
    }
    AppMethodBeat.o(244044);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(244046);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramMenuItem, "menuItem");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
    if ((paramMenuItem.getItemId() == this.tLI) && (paramBaseFinderFeed.feedObject.isPostFinish()))
    {
      if (((Collection)paramBaseFinderFeed.feedObject.getLongVideoMediaList()).isEmpty()) {
        break label106;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label111;
      }
    }
    label106:
    label111:
    for (paramInt = 2131759606;; paramInt = 2131760453)
    {
      h.a((Context)this.gte, paramInt, 0, (DialogInterface.OnClickListener)new b(this, paramBaseFinderFeed), null);
      AppMethodBeat.o(244046);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public final void boE()
  {
    AppMethodBeat.i(244043);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(244043);
      return;
    }
    AppMethodBeat.o(244043);
  }
  
  public final com.tencent.mm.view.recyclerview.f dce()
  {
    AppMethodBeat.i(244048);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(244048);
    return localf;
  }
  
  public final o.f i(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(244045);
    p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (o.f)new c(this, paramBaseFinderFeed);
    AppMethodBeat.o(244045);
    return paramBaseFinderFeed;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(244047);
    this.tLy.onDetach();
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    super.onDetach();
    AppMethodBeat.o(244047);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(244042);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(244042);
      return;
    }
    AppMethodBeat.o(244042);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(244036);
      switch (paramInt)
      {
      case 3: 
      default: 
        locale = (e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(244036);
        return locale;
      case 4: 
        if (this.tPs.tPr.udT)
        {
          locale = (e)new com.tencent.mm.plugin.finder.convert.t(this.tPs.tCD, (i)this.tPs, this.tPs.dcG(), -2147483648);
          AppMethodBeat.o(244036);
          return locale;
        }
        locale = (e)new ak(this.tPs.tCD, (i)this.tPs, this.tPs.dcG(), 2147483647);
        AppMethodBeat.o(244036);
        return locale;
      }
      if (this.tPs.tPr.udT)
      {
        locale = (e)new com.tencent.mm.plugin.finder.convert.q((i)this.tPs, this.tPs.dcG(), -2147483648);
        AppMethodBeat.o(244036);
        return locale;
      }
      e locale = (e)new com.tencent.mm.plugin.finder.convert.u((i)this.tPs, this.tPs.dcG(), 2147483647);
      AppMethodBeat.o(244036);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(aa.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(244039);
      paramDialogInterface = z.aUg();
      p.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new av(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
      Object localObject = this.tPs.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        g.azz().a(paramDialogInterface.getType(), (com.tencent.mm.ak.i)new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(244038);
            if (((paramAnonymousq instanceof av)) && (((av)paramAnonymousq).hFK == paramDialogInterface.hFK)) {
              g.azz().b(paramDialogInterface.getType(), (com.tencent.mm.ak.i)this);
            }
            paramAnonymousString = this.tPu.tPs.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              this.tPu.tPs.tPr.finish();
              AppMethodBeat.o(244038);
              return;
            }
            com.tencent.mm.ui.base.u.makeText((Context)this.tPu.tPs.gte, 2131760456, 0).show();
            AppMethodBeat.o(244038);
          }
        });
        g.azz().b((com.tencent.mm.ak.q)paramDialogInterface);
        AppMethodBeat.o(244039);
        return;
        localObject = this.tPs;
        Context localContext = (Context)((b.a)localObject).gte;
        ((b.a)localObject).gte.getString(2131755998);
        ((aa.b)localObject).tipDialog = ((Dialog)h.a(localContext, ((b.a)localObject).gte.getString(2131756029), false, (DialogInterface.OnCancelListener)a.tPt));
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a tPt;
      
      static
      {
        AppMethodBeat.i(244037);
        tPt = new a();
        AppMethodBeat.o(244037);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements o.f
  {
    c(aa.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      boolean bool = false;
      AppMethodBeat.i(244040);
      int i;
      if (this.tPs.tPr.udT)
      {
        localObject = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        if (com.tencent.mm.plugin.finder.upload.action.c.dBq().k(paramBaseFinderFeed.feedObject.getFeedObject())) {
          break label262;
        }
        i = 1;
        if (i == 0) {
          break label267;
        }
        paramm.b(this.tPs.tLK, (CharSequence)this.tPs.gte.getString(2131759168), 2131691821);
      }
      for (;;)
      {
        localObject = y.vXH;
        if (y.C(paramBaseFinderFeed.feedObject))
        {
          i = this.tPs.tLJ;
          localObject = y.vXH;
          localObject = (CharSequence)y.x(paramBaseFinderFeed);
          if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed())) {
            bool = true;
          }
          paramm.a(i, (CharSequence)localObject, 2131690227, bool);
        }
        localObject = y.vXH;
        if (y.h(paramBaseFinderFeed)) {
          break label299;
        }
        if ((this.tPs.dLS != 3) && (this.tPs.dLS != 1)) {
          paramm.b(this.tPs.tLD, (CharSequence)this.tPs.gte.getString(2131763162), 2131690233);
        }
        paramm.b(this.tPs.pMa, (CharSequence)this.tPs.gte.getString(2131763159), 2131690898);
        AppMethodBeat.o(244040);
        return;
        label262:
        i = 0;
        break;
        label267:
        paramm.b(this.tPs.tLL, (CharSequence)this.tPs.gte.getString(2131759570), 2131691822);
      }
      label299:
      Object localObject = y.vXH;
      if (!y.w(paramBaseFinderFeed))
      {
        paramm.aS(this.tPs.tLI, 2131755778, 2131690780);
        if (!paramBaseFinderFeed.feedObject.isCommentClose()) {
          break label453;
        }
        paramm.b(this.tPs.tLH, (CharSequence)this.tPs.gte.getString(2131759749), 2131690775);
      }
      for (;;)
      {
        if (!this.tPs.tPr.udT)
        {
          localObject = y.vXH;
          if ((y.isAnyEnableFullScreenEnjoy()) && ((paramBaseFinderFeed.cxn() == 4) || (paramBaseFinderFeed.cxn() == 2))) {
            paramm.b(this.tPs.tLM, (CharSequence)this.tPs.gte.getString(2131759752), 2131690257);
          }
        }
        AppMethodBeat.o(244040);
        return;
        label453:
        paramm.b(this.tPs.tLG, (CharSequence)this.tPs.gte.getString(2131759714), 2131690232);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<Integer, bo>
  {
    d(aa.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.b
 * JD-Core Version:    0.7.0.1
 */