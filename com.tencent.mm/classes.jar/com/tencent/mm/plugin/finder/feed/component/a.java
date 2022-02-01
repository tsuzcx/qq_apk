package com.tencent.mm.plugin.finder.feed.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.f;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.bw;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "context", "Landroid/content/Context;", "maxTopCount", "", "getMaxTopCount", "()I", "setMaxTopCount", "(I)V", "addTopPlaceMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "handleTopPlace", "isSticky", "", "objectId", "", "makeFeedSticky", "sticky", "onAttach", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFeed", "Companion", "plugin-finder_release"})
public final class a
  implements i
{
  public static final a tUf;
  private Context context;
  public int tUe;
  
  static
  {
    AppMethodBeat.i(244523);
    tUf = new a((byte)0);
    AppMethodBeat.o(244523);
  }
  
  public static void a(final Context paramContext, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(244522);
    p.h(paramContext, "context");
    p.h(paramBaseFinderFeed, "feed");
    if (!((Collection)paramBaseFinderFeed.feedObject.getLongVideoMediaList()).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (int i = 2131759606;; i = 2131760453)
    {
      com.tencent.mm.ui.base.h.a(paramContext, i, 0, (DialogInterface.OnClickListener)new e(paramBaseFinderFeed, paramContext), null);
      AppMethodBeat.o(244522);
      return;
      i = 0;
      break;
    }
  }
  
  public static void a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, m paramm)
  {
    AppMethodBeat.i(244519);
    p.h(paramContext, "context");
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramm, "menu");
    if (paramBaseFinderFeed.feedObject.getStickyTime() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramm.b(5003, (CharSequence)paramContext.getString(2131759573), 2131690921);
      AppMethodBeat.o(244519);
      return;
    }
    paramm.b(5002, (CharSequence)paramContext.getString(2131760555), 2131690920);
    AppMethodBeat.o(244519);
  }
  
  public final void a(Context paramContext, boolean paramBoolean, BaseFinderFeed paramBaseFinderFeed)
  {
    Object localObject2 = null;
    AppMethodBeat.i(244520);
    p.h(paramContext, "context");
    p.h(paramBaseFinderFeed, "feed");
    this.context = paramContext;
    Object localObject1 = paramBaseFinderFeed.contact;
    long l2;
    long l1;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername();
      l2 = paramBaseFinderFeed.feedObject.getId();
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
      if (paramBaseFinderFeed == null) {
        break label177;
      }
      paramBaseFinderFeed = paramBaseFinderFeed.event;
      if (paramBaseFinderFeed == null) {
        break label177;
      }
      l1 = paramBaseFinderFeed.twd;
      label82:
      if (!paramBoolean) {
        break label183;
      }
    }
    label177:
    label183:
    for (int i = 3;; i = 4)
    {
      paramBaseFinderFeed = FinderReporterUIC.wzC;
      FinderReporterUIC localFinderReporterUIC = FinderReporterUIC.a.fH(paramContext);
      paramBaseFinderFeed = localObject2;
      if (localFinderReporterUIC != null) {
        paramBaseFinderFeed = localFinderReporterUIC.dIx();
      }
      paramBaseFinderFeed = new bw(i, Long.valueOf(l1), (String)localObject1, Long.valueOf(l2), paramBaseFinderFeed);
      paramBaseFinderFeed.d(paramContext, paramContext.getResources().getString(2131760677), 500L);
      com.tencent.mm.kernel.g.azz().b((q)paramBaseFinderFeed);
      AppMethodBeat.o(244520);
      return;
      localObject1 = null;
      break;
      l1 = 0L;
      break label82;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    paramInt1 = 1;
    int i = 0;
    AppMethodBeat.i(244521);
    switch (paramInt2)
    {
    default: 
      paramString = "";
    }
    for (;;)
    {
      label55:
      if (!Util.isNullOrNil(paramString)) {
        u.a(MMApplicationContext.getContext(), paramString, (u.b)d.tUi);
      }
      AppMethodBeat.o(244521);
      return;
      paramString = MMApplicationContext.getContext().getString(2131760602, new Object[] { Integer.valueOf(this.tUe) });
      p.g(paramString, "MMApplicationContext.get…imit_reason, maxTopCount)");
      continue;
      paramString = MMApplicationContext.getContext().getString(2131760603);
      p.g(paramString, "MMApplicationContext.get…ed_failed_private_reason)");
      continue;
      paramString = MMApplicationContext.getContext().getString(2131760604);
      p.g(paramString, "MMApplicationContext.get…icky_feed_failed_reason1)");
      continue;
      if ((!(paramq instanceof bw)) || ((((bw)paramq).scene != 3) && (((bw)paramq).scene != 4))) {
        break;
      }
      if (((bw)paramq).scene == 3)
      {
        label199:
        paramString = ((bw)paramq).tvJ;
        if (paramString == null) {
          break label335;
        }
      }
      label335:
      for (long l = paramString.longValue();; l = 0L)
      {
        paramInt2 = i;
        if (paramInt1 != 0) {
          paramInt2 = cl.aWB();
        }
        paramString = e.vFX;
        paramString = e.a.Fy(l);
        if (paramString != null) {
          paramString.setStickyTime(paramInt2);
        }
        paramString = new hm();
        paramString.dLV.type = 1001;
        paramString.dLV.id = l;
        paramString.dLV.stickyTime = paramInt2;
        EventCenter.instance.publish((IEvent)paramString);
        paramString = this.context;
        if (paramString == null) {
          break;
        }
        if (paramInt1 == 0) {
          break label341;
        }
        u.a(paramString, paramString.getString(2131760605), (u.b)b.tUg);
        paramString = "";
        break label55;
        paramInt1 = 0;
        break label199;
      }
      label341:
      u.a(paramString, paramString.getString(2131759574), (u.b)c.tUh);
      paramString = "";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$Companion;", "", "()V", "ACTIVITY_STICK_EVENT_TYPE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class b
    implements u.b
  {
    public static final b tUg;
    
    static
    {
      AppMethodBeat.i(244512);
      tUg = new b();
      AppMethodBeat.o(244512);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(244511);
      ((WeImageView)paramView.findViewById(2131309259)).setImageResource(2131690693);
      AppMethodBeat.o(244511);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class c
    implements u.b
  {
    public static final c tUh;
    
    static
    {
      AppMethodBeat.i(244514);
      tUh = new c();
      AppMethodBeat.o(244514);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(244513);
      ((WeImageView)paramView.findViewById(2131309259)).setImageResource(2131690694);
      AppMethodBeat.o(244513);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class d
    implements u.b
  {
    public static final d tUi;
    
    static
    {
      AppMethodBeat.i(244516);
      tUi = new d();
      AppMethodBeat.o(244516);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(244515);
      ((WeImageView)paramView.findViewById(2131309259)).setImageResource(2131690694);
      AppMethodBeat.o(244515);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(BaseFinderFeed paramBaseFinderFeed, Context paramContext) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      bbn localbbn = null;
      AppMethodBeat.i(244518);
      paramDialogInterface = this.tEM.contact;
      long l2;
      Object localObject;
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.getUsername();
        l2 = this.tEM.feedObject.getId();
        localObject = this.tEM.feedObject.getFeedObject().objectDesc;
        if (localObject == null) {
          break label191;
        }
        localObject = ((FinderObjectDesc)localObject).event;
        if (localObject == null) {
          break label191;
        }
      }
      label191:
      for (final long l1 = ((azs)localObject).twd;; l1 = 0L)
      {
        localObject = FinderReporterUIC.wzC;
        localObject = FinderReporterUIC.a.fH(paramContext);
        if (localObject != null) {
          localbbn = ((FinderReporterUIC)localObject).dIx();
        }
        paramDialogInterface = new bw(2, Long.valueOf(l1), paramDialogInterface, Long.valueOf(l2), localbbn);
        paramDialogInterface.d(paramContext, paramContext.getResources().getString(2131760677), 500L);
        com.tencent.mm.kernel.g.azz().a(paramDialogInterface.getType(), (i)new i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(244517);
            if ((paramAnonymousq instanceof bw))
            {
              com.tencent.mm.kernel.g.azz().b(paramDialogInterface.getType(), (i)this);
              if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
              {
                paramAnonymousString = new f();
                paramAnonymousString.dBS.id = this.tUj.tEM.feedObject.getId();
                paramAnonymousString.dBS.localId = this.tUj.tEM.feedObject.getLocalId();
                paramAnonymousString.dBS.dBT = l1;
                EventCenter.instance.publish((IEvent)paramAnonymousString);
                paramAnonymousq = new hn();
                paramAnonymousq.dLW.id = this.tUj.tEM.feedObject.getId();
                paramAnonymousq.dLW.dLY = 1;
                paramAnonymousq.dLW.type = 12;
                EventCenter.instance.publish((IEvent)paramAnonymousq);
                "NetSceneFinderModEvent onSceneEnd publish ActivityFeedRemoveEvent:".concat(String.valueOf(paramAnonymousString));
                com.tencent.e.f.h.hkS();
                AppMethodBeat.o(244517);
                return;
              }
              u.makeText(this.tUj.$context, 2131759517, 0).show();
            }
            AppMethodBeat.o(244517);
          }
        });
        com.tencent.mm.kernel.g.azz().b((q)paramDialogInterface);
        AppMethodBeat.o(244518);
        return;
        paramDialogInterface = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.a
 * JD-Core Version:    0.7.0.1
 */