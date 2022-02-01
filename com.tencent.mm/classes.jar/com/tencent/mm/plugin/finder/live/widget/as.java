package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ac;
import com.tencent.mm.plugin.finder.live.model.g;
import com.tencent.mm.plugin.finder.live.sidebar.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "bindLinkMicUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "getBindLinkMicUser", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;", "setBindLinkMicUser", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveLinkMicUser;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "setBottomSheet", "(Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;)V", "bottomSheetShowListener", "Lkotlin/Function1;", "", "", "isBottomSheetShowing", "lastContentRect", "Landroid/graphics/Rect;", "getLastContentRect", "()Landroid/graphics/Rect;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "linkMicUser", "buildBottomSheet", "getMicType", "", "()Ljava/lang/Integer;", "goToFinderLive", "userName", "goToFinderProfile", "finderUsername", "hideLinkMicBottomBar", "prepareMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "printBindMicUser", "requestDisallowInterceptTouchEvent", "disallow", "showLinkMicBottomBar", "contentRect", "showProfilePlugin", "updateLinkMicBottomBar", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class as
{
  public static final as.a Esx = new as.a((byte)0);
  final com.tencent.mm.plugin.finder.live.plugin.b CwG;
  private final FinderLiveShadeView Dfo;
  private final u.i Dgv;
  private boolean EsA;
  private final kotlin.g.a.b<Boolean, ah> EsB;
  public h Esy;
  final Rect Esz;
  private final String TAG;
  final ViewGroup mJe;
  private com.tencent.mm.ui.widget.a.f ngn;
  
  public as(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    this.mJe = paramViewGroup;
    this.CwG = paramb;
    this.Dfo = paramFinderLiveShadeView;
    this.TAG = "Finder.FinderLiveMicStateWidget";
    this.Esz = new Rect();
    this.EsB = ((kotlin.g.a.b)new b(this));
    this.Dgv = new as..ExternalSyntheticLambda0(this);
  }
  
  private static final void a(as paramas, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    s.u(paramas, "this$0");
    if (paramMenuItem == null)
    {
      paramMenuItem = null;
      if (paramMenuItem != null) {
        break label47;
      }
      label21:
      if (paramMenuItem != null) {
        break label217;
      }
      label25:
      if (paramMenuItem != null) {
        break label395;
      }
      label29:
      if (paramMenuItem != null) {
        break label515;
      }
    }
    label47:
    label104:
    while (paramMenuItem.intValue() != 3)
    {
      return;
      paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
      break;
      if (paramMenuItem.intValue() != 0) {
        break label21;
      }
      Log.i(paramas.TAG, "SHEET_MORE_REWARD");
      localObject2 = new Bundle();
      paramMenuItem = paramas.Esy;
      if (paramMenuItem == null)
      {
        paramMenuItem = "";
        ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_USERNAME", paramMenuItem);
        paramMenuItem = paramas.Esy;
        if (paramMenuItem != null) {
          break label192;
        }
        paramMenuItem = "";
        ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_NICKNAME", paramMenuItem);
        paramMenuItem = paramas.Esy;
        if (paramMenuItem != null) {
          break label209;
        }
      }
      for (paramMenuItem = null;; paramMenuItem = paramMenuItem.headUrl)
      {
        ((Bundle)localObject2).putString("PARAM_FINDER_LIVE_LINK_AVATAR", paramMenuItem);
        paramas.CwG.CTj.statusChange(b.c.ndq, (Bundle)localObject2);
        paramMenuItem = paramas.ngn;
        if (paramMenuItem != null) {
          paramMenuItem.cyW();
        }
        paramas.EsB.invoke(Boolean.FALSE);
        return;
        localObject1 = paramMenuItem.username;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramMenuItem = "";
        break;
        localObject1 = paramMenuItem.nickname;
        paramMenuItem = (MenuItem)localObject1;
        if (localObject1 != null) {
          break label104;
        }
        paramMenuItem = "";
        break label104;
      }
      if (paramMenuItem.intValue() != 1) {
        break label25;
      }
      Log.i(paramas.TAG, "SHEET_MORE_PORFILE");
      paramMenuItem = paramas.Esy;
      if (paramMenuItem == null)
      {
        paramMenuItem = (MenuItem)localObject1;
        localObject1 = (CharSequence)paramMenuItem;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label317;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label322;
        }
        Log.i(paramas.TAG, s.X("goToFinderProfile finderUsername:", paramMenuItem));
      }
      for (;;)
      {
        paramMenuItem = paramas.ngn;
        if (paramMenuItem != null) {
          paramMenuItem.cyW();
        }
        paramas.EsB.invoke(Boolean.FALSE);
        return;
        paramMenuItem = paramMenuItem.username;
        break;
        paramInt = 0;
        break label265;
        localObject1 = g.CEN;
        localObject1 = paramas.mJe.getContext();
        localObject2 = paramas.CwG.getBuContext();
        Object localObject3 = k.aeZF;
        localObject3 = paramas.mJe.getContext();
        s.s(localObject3, "root.context");
        g.a((Context)localObject1, (com.tencent.mm.plugin.finder.live.model.context.a)localObject2, false, paramMenuItem, ((bn)k.nq((Context)localObject3).cq(bn.class)).fou());
      }
      if (paramMenuItem.intValue() != 2) {
        break label29;
      }
      Log.i(paramas.TAG, "SHEET_MORE_EXPOSE");
      paramMenuItem = paramas.Esy;
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.username;
        if (paramMenuItem != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.live.plugin.b.getFinderLiveAssistant();
          if (localObject1 != null)
          {
            localObject2 = paramas.mJe.getContext();
            s.s(localObject2, "root.context");
            ((ap)localObject1).a((Context)localObject2, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramas.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, paramMenuItem, Long.valueOf(0L));
          }
        }
      }
      paramMenuItem = paramas.ngn;
      if (paramMenuItem != null) {
        paramMenuItem.cyW();
      }
      paramas.EsB.invoke(Boolean.FALSE);
      return;
    }
    label192:
    label209:
    label217:
    Log.i(paramas.TAG, "SHEET_MORE_LIVE");
    label265:
    label317:
    label322:
    paramMenuItem = paramas.Esy;
    label395:
    if (paramMenuItem == null) {}
    label515:
    for (paramMenuItem = (MenuItem)localObject2;; paramMenuItem = paramMenuItem.username)
    {
      paramas.ayB(paramMenuItem);
      paramMenuItem = paramas.ngn;
      if (paramMenuItem != null) {
        paramMenuItem.cyW();
      }
      paramas.EsB.invoke(Boolean.FALSE);
      return;
    }
  }
  
  public final void ayB(String paramString)
  {
    Log.i(this.TAG, "goToFinderLive from:" + ((e)this.CwG.business(e.class)).mIC + " to:" + paramString);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      paramString = new ac((String)localObject, (t)new c(paramString, this)).bFJ();
      if ((this.mJe.getContext() == null) || (!(this.mJe.getContext() instanceof MMActivity))) {
        return;
      }
      localObject = this.mJe.getContext();
      if (localObject != null) {
        break;
      }
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
    }
    paramString.a((com.tencent.mm.vending.e.b)localObject);
  }
  
  protected final com.tencent.mm.ui.widget.a.f cDi()
  {
    return this.ngn;
  }
  
  public final void eBh()
  {
    Object localObject2 = null;
    Object localObject1 = k.aeZF;
    localObject1 = this.mJe.getContext();
    s.s(localObject1, "root.context");
    if (((com.tencent.mm.plugin.finder.live.sidebar.d)k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
    {
      localObject1 = k.aeZF;
      localObject1 = this.mJe.getContext();
      s.s(localObject1, "root.context");
      localObject1 = ((com.tencent.mm.plugin.finder.live.sidebar.d)k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
      if (localObject1 != null) {
        ((c)localObject1).hide();
      }
      localObject1 = k.aeZF;
      localObject1 = this.mJe.getContext();
      s.s(localObject1, "root.context");
      ((com.tencent.mm.plugin.finder.live.sidebar.d)k.nq((Context)localObject1).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGH.DGN = 3;
      return;
    }
    Bundle localBundle = new Bundle();
    localObject1 = this.Esy;
    if (localObject1 == null)
    {
      localObject1 = null;
      localBundle.putByteArray("PARAM_MEMBERS_PROFILE_CONTACT", (byte[])localObject1);
      localBundle.putBoolean("PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE", false);
      localBundle.putInt("PARAM_MEMBERS_PROFILE_SOURCE_TYPE", 3);
      localObject1 = this.Esy;
      if (localObject1 != null) {
        break label272;
      }
      localObject1 = localObject2;
      label182:
      localBundle.putString("PARAM_MEMBERS_PROFILE_USERNAME", (String)localObject1);
      localObject1 = this.Esy;
      if (localObject1 != null) {
        break label280;
      }
      bool = false;
      label202:
      if (!bool)
      {
        localObject1 = this.Esy;
        if (localObject1 != null) {
          break label288;
        }
        bool = false;
        label217:
        if (!bool) {
          break label310;
        }
      }
    }
    label272:
    label280:
    label288:
    label310:
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("PARAM_MEMBERS_PROFILE_IS_OTHER_ROOM_USER", bool);
      this.CwG.CTj.statusChange(b.c.ncV, localBundle);
      return;
      localObject1 = ((h)localObject1).EbJ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bgh)localObject1).toByteArray();
      break;
      localObject1 = ((h)localObject1).username;
      break label182;
      bool = ((h)localObject1).EbD;
      break label202;
      localObject1 = ((h)localObject1).EbK;
      if (localObject1 == null)
      {
        bool = false;
        break label217;
      }
      bool = ((Boolean)localObject1).booleanValue();
      break label217;
    }
  }
  
  public final Integer eBi()
  {
    h localh = this.Esy;
    if (localh == null) {
      return null;
    }
    return Integer.valueOf(localh.mXM);
  }
  
  public void erb()
  {
    com.tencent.mm.ui.widget.a.f localf = this.ngn;
    if (localf != null) {
      localf.cyW();
    }
  }
  
  public final void i(h paramh)
  {
    s.u(paramh, "linkMicUser");
    this.Esy = paramh;
  }
  
  public abstract void requestDisallowInterceptTouchEvent(boolean paramBoolean);
  
  public void x(Rect paramRect)
  {
    s.u(paramRect, "contentRect");
    this.Esz.set(paramRect);
    if (this.EsA) {
      this.Dfo.setHighLightRect(paramRect);
    }
  }
  
  public void y(Rect paramRect)
  {
    s.u(paramRect, "contentRect");
    this.Esz.set(paramRect);
    if (this.EsA) {
      this.Dfo.setHighLightRect(paramRect);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(as paramas)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget$goToFinderLive$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements t
  {
    c(String paramString, as paramas) {}
    
    public final void a(int paramInt1, int paramInt2, azf paramazf)
    {
      Object localObject1 = null;
      AppMethodBeat.i(360977);
      s.u(paramazf, "resp");
      Object localObject2 = paramazf.ZIo;
      if (localObject2 != null)
      {
        paramazf = ((FinderObject)localObject2).contact;
        if (paramazf == null) {}
        for (paramazf = null; s.p(paramazf, this.pmW); paramazf = paramazf.username)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.pmW, jdField_this, (FinderObject)localObject2));
          AppMethodBeat.o(360977);
          return;
        }
      }
      String str = as.a(jdField_this);
      StringBuilder localStringBuilder = new StringBuilder("[LiveLogoAssistant]CgiFinderLiveGetLastObject invalid resp local username:").append(this.pmW).append(",remote username:");
      if (localObject2 == null) {
        paramazf = localObject1;
      }
      for (;;)
      {
        Log.i(str, paramazf);
        AppMethodBeat.o(360977);
        return;
        localObject2 = ((FinderObject)localObject2).contact;
        paramazf = localObject1;
        if (localObject2 != null) {
          paramazf = ((FinderContact)localObject2).username;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(String paramString, as paramas, FinderObject paramFinderObject)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.as
 * JD-Core Version:    0.7.0.1
 */