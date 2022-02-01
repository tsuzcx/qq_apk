package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.cgi.w;
import com.tencent.mm.plugin.finder.live.model.cgi.w.a;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bindLinkMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "getBindLinkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "setBindLinkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "setBottomSheet", "(Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;)V", "bottomSheetShowListener", "Lkotlin/Function1;", "", "", "isBottomSheetShowing", "lastContentRect", "Landroid/graphics/Rect;", "getLastContentRect", "()Landroid/graphics/Rect;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "linkMicUser", "buildBottomSheet", "goToFinderLive", "userName", "goToFinderProfile", "finderUsername", "hideLinkMicBottomBar", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "printBindMicUser", "showLinkMicBottomBar", "contentRect", "updateLinkMicBottomBar", "Companion", "plugin-finder_release"})
public abstract class ac
{
  public static final a zpS = new a((byte)0);
  private final String TAG;
  com.tencent.mm.ui.widget.a.e kCR;
  final ViewGroup kiF;
  final Rect lastContentRect;
  final com.tencent.mm.plugin.finder.live.plugin.d xYq;
  private final q.g ybB;
  private final FinderLiveShadeView yuT;
  public h zpP;
  private boolean zpQ;
  private final kotlin.g.a.b<Boolean, x> zpR;
  
  public ac(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.d paramd, FinderLiveShadeView paramFinderLiveShadeView)
  {
    this.kiF = paramViewGroup;
    this.xYq = paramd;
    this.yuT = paramFinderLiveShadeView;
    this.TAG = "Finder.FinderLiveMicStateWidget";
    this.lastContentRect = new Rect();
    this.zpR = ((kotlin.g.a.b)new b(this));
    this.ybB = ((q.g)new f(this));
  }
  
  public void a(o paramo)
  {
    p.k(paramo, "menu");
    h localh = this.zpP;
    if (localh != null)
    {
      localObject = a.yRm;
      if ((!a.dEy()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGF()) && (!com.tencent.mm.ae.d.dr(localh.zeH, 16)) && (!localh.zeF))
      {
        localObject = this.kiF.getContext();
        p.j(localObject, "root.context");
        localObject = ((Context)localObject).getResources().getString(b.j.finder_live_link_mic_gift_item);
        p.j(localObject, "root.context.resources.g…_live_link_mic_gift_item)");
        paramo.d(0, (CharSequence)localObject);
      }
      localObject = ((f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).business(f.class)).zhl;
      if (localObject == null) {
        break label244;
      }
    }
    label244:
    for (Object localObject = ((h)localObject).username;; localObject = null)
    {
      if (p.h(localObject, localh.username))
      {
        localObject = this.kiF.getContext();
        p.j(localObject, "root.context");
        localObject = ((Context)localObject).getResources().getString(b.j.finder_live_link_mic_live_item);
        p.j(localObject, "root.context.resources.g…_live_link_mic_live_item)");
        paramo.d(3, (CharSequence)localObject);
      }
      if (as.bvP(localh.username))
      {
        localObject = this.kiF.getContext();
        p.j(localObject, "root.context");
        localObject = ((Context)localObject).getResources().getString(b.j.finder_live_link_mic_finder_item);
        p.j(localObject, "root.context.resources.g…ive_link_mic_finder_item)");
        paramo.d(1, (CharSequence)localObject);
      }
      return;
    }
  }
  
  public final void aDh(String paramString)
  {
    Log.i(this.TAG, "goToFinderLive from:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig + " to:" + paramString);
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      new w(str, (w.a)new ac.e(this, paramString)).bhW();
      return;
    }
  }
  
  public void dCb()
  {
    com.tencent.mm.ui.widget.a.e locale = this.kCR;
    if (locale != null) {
      locale.bYF();
    }
  }
  
  public final void dIz()
  {
    Object localObject1;
    if (this.kCR == null)
    {
      this.kCR = new com.tencent.mm.ui.widget.a.e(this.kiF.getContext(), 1, true);
      localObject1 = this.kCR;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).icA();
      }
      localObject1 = this.kCR;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).icC();
      }
    }
    Object localObject2 = this.zpP;
    if (localObject2 != null)
    {
      localObject1 = ad.kS(this.kiF.getContext()).inflate(b.g.finder_live_link_mic_bottom_sheet_title, null);
      Object localObject3 = ((View)localObject1).findViewById(b.f.link_bottom_sheet_target_name);
      p.j(localObject3, "titleView.findViewById<T…bottom_sheet_target_name)");
      ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.kiF.getContext(), (CharSequence)((h)localObject2).nickname));
      Object localObject4;
      t localt;
      if (p.h(((h)localObject2).username, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig))
      {
        localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject3 = d.a.aAK(((h)localObject2).username);
        if (localObject3 != null)
        {
          localObject2 = t.ztT;
          localObject2 = t.dJh();
          localObject3 = new com.tencent.mm.plugin.finder.loader.e(((i)localObject3).Mm());
          localObject4 = ((View)localObject1).findViewById(b.f.link_bottom_sheet_target_avatar);
          p.j(localObject4, "titleView.findViewById<I…ttom_sheet_target_avatar)");
          localObject4 = (ImageView)localObject4;
          localt = t.ztT;
          ((com.tencent.mm.loader.d)localObject2).a(localObject3, (ImageView)localObject4, t.a(t.a.ztX));
        }
      }
      for (;;)
      {
        localObject2 = this.kCR;
        if (localObject2 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject2).setTitleView((View)localObject1);
        }
        localObject1 = this.kCR;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).rn(false);
        }
        localObject1 = this.kCR;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).icy();
        }
        localObject1 = this.kCR;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).HK(true);
        }
        localObject1 = this.kCR;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.f)new c(this));
        }
        localObject1 = this.kCR;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).a(this.ybB);
        }
        localObject1 = this.kCR;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new d(this));
        }
        localObject1 = this.kCR;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).eik();
        }
        this.zpR.invoke(Boolean.TRUE);
        return;
        if (as.bvP(((h)localObject2).username))
        {
          localObject3 = t.ztT;
          localObject3 = t.dJh();
          localObject2 = new com.tencent.mm.plugin.finder.loader.e(((h)localObject2).headUrl);
          localObject4 = ((View)localObject1).findViewById(b.f.link_bottom_sheet_target_avatar);
          p.j(localObject4, "titleView.findViewById<I…ttom_sheet_target_avatar)");
          localObject4 = (ImageView)localObject4;
          localt = t.ztT;
          ((com.tencent.mm.loader.d)localObject3).a(localObject2, (ImageView)localObject4, t.a(t.a.ztX));
        }
        else
        {
          localObject3 = t.ztT;
          localObject3 = t.dJi();
          localObject2 = new com.tencent.mm.plugin.finder.loader.e(((h)localObject2).headUrl);
          localObject4 = ((View)localObject1).findViewById(b.f.link_bottom_sheet_target_avatar);
          p.j(localObject4, "titleView.findViewById<I…ttom_sheet_target_avatar)");
          localObject4 = (ImageView)localObject4;
          localt = t.ztT;
          ((com.tencent.mm.loader.d)localObject3).a(localObject2, (ImageView)localObject4, t.a(t.a.ztZ));
        }
      }
    }
    Log.i(((ac)this).TAG, "[buildBottomSheet] bindLinkMicUser null");
  }
  
  public final void h(h paramh)
  {
    p.k(paramh, "linkMicUser");
    this.zpP = paramh;
  }
  
  public void r(Rect paramRect)
  {
    p.k(paramRect, "contentRect");
    this.lastContentRect.set(paramRect);
    if (this.zpQ) {
      this.yuT.setHighLightRect(paramRect);
    }
  }
  
  public void s(Rect paramRect)
  {
    p.k(paramRect, "contentRect");
    this.lastContentRect.set(paramRect);
    if (this.zpQ) {
      this.yuT.setHighLightRect(paramRect);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget$Companion;", "", "()V", "SHEET_MORE_EXPOSE", "", "SHEET_MORE_LIVE", "SHEET_MORE_PORFILE", "SHEET_MORE_REWARD", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isShow", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(ac paramac)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget$buildBottomSheet$1$2"})
  static final class c
    implements q.f
  {
    c(ac paramac) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(271989);
      Object localObject = this.zpT.kCR;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramo.clear();
      localObject = this.zpT;
      p.j(paramo, "menu");
      ((ac)localObject).a(paramo);
      AppMethodBeat.o(271989);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget$buildBottomSheet$1$3"})
  static final class d
    implements e.b
  {
    d(ac paramac) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(284365);
      this.zpT.kCR = null;
      ac.b(this.zpT).invoke(Boolean.FALSE);
      AppMethodBeat.o(284365);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class f
    implements q.g
  {
    f(ac paramac) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(287176);
      if (paramMenuItem != null)
      {
        paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
        if (paramMenuItem != null) {
          break label51;
        }
        label28:
        if (paramMenuItem != null) {
          break label235;
        }
        label32:
        if (paramMenuItem != null) {
          break label327;
        }
      }
      label51:
      label235:
      h localh;
      for (;;)
      {
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(287176);
          return;
          paramMenuItem = null;
          break;
          if (paramMenuItem.intValue() != 0) {
            break label28;
          }
          Log.i(ac.a(this.zpT), "SHEET_MORE_REWARD");
          localObject2 = new Bundle();
          paramMenuItem = this.zpT.zpP;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.username;
            paramMenuItem = (MenuItem)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramMenuItem = "";
          }
          ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_USERNAME", paramMenuItem);
          paramMenuItem = this.zpT.zpP;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.nickname;
            paramMenuItem = (MenuItem)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramMenuItem = "";
          }
          ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_NICKNAME", paramMenuItem);
          paramMenuItem = this.zpT.zpP;
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.headUrl;; paramMenuItem = null)
          {
            ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_AVATAR", paramMenuItem);
            this.zpT.xYq.yld.statusChange(b.c.kAa, (Bundle)localObject2);
            paramMenuItem = this.zpT.kCR;
            if (paramMenuItem != null) {
              paramMenuItem.bYF();
            }
            ac.b(this.zpT).invoke(Boolean.FALSE);
            AppMethodBeat.o(287176);
            return;
          }
          if (paramMenuItem.intValue() != 1) {
            break label32;
          }
          Log.i(ac.a(this.zpT), "SHEET_MORE_PORFILE");
          localObject2 = this.zpT;
          localh = this.zpT.zpP;
          paramMenuItem = (MenuItem)localObject1;
          if (localh != null) {
            paramMenuItem = localh.username;
          }
          ac.a((ac)localObject2, paramMenuItem);
          paramMenuItem = this.zpT.kCR;
          if (paramMenuItem != null) {
            paramMenuItem.bYF();
          }
          ac.b(this.zpT).invoke(Boolean.FALSE);
          AppMethodBeat.o(287176);
          return;
          label327:
          if (paramMenuItem.intValue() == 2)
          {
            Log.i(ac.a(this.zpT), "SHEET_MORE_EXPOSE");
            paramMenuItem = this.zpT.zpP;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.username;
              if (paramMenuItem != null)
              {
                localObject1 = com.tencent.mm.plugin.finder.live.plugin.d.getFinderLiveAssistant();
                if (localObject1 != null)
                {
                  localObject2 = this.zpT.kiF.getContext();
                  p.j(localObject2, "root.context");
                  ((an)localObject1).a((Context)localObject2, ((c)this.zpT.xYq.business(c.class)).liveInfo.liveId, paramMenuItem, Long.valueOf(0L));
                }
              }
            }
            paramMenuItem = this.zpT.kCR;
            if (paramMenuItem != null) {
              paramMenuItem.bYF();
            }
            ac.b(this.zpT).invoke(Boolean.FALSE);
            AppMethodBeat.o(287176);
            return;
          }
        }
      }
      if (paramMenuItem.intValue() == 3)
      {
        Log.i(ac.a(this.zpT), "SHEET_MORE_LIVE");
        localObject1 = this.zpT;
        localh = this.zpT.zpP;
        paramMenuItem = (MenuItem)localObject2;
        if (localh != null) {
          paramMenuItem = localh.username;
        }
        ((ac)localObject1).aDh(paramMenuItem);
        paramMenuItem = this.zpT.kCR;
        if (paramMenuItem != null) {
          paramMenuItem.bYF();
        }
        ac.b(this.zpT).invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(287176);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ac
 * JD-Core Version:    0.7.0.1
 */