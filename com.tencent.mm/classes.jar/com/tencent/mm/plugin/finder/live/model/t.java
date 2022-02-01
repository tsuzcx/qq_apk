package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.b.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak.a;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker;", "", "()V", "TAG", "", "checkAppBrand", "errorCallback", "Lkotlin/Function0;", "", "checkFloatVideo", "gotoAnchor", "", "checkIsUsePhone", "checkLiveAnchorCore", "context", "Landroid/content/Context;", "checkLiveInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAnchor", "checkLiveVisitorCore", "checkNetwork", "checkRoomLive", "checkVoip", "goAnchorUIWithCheck", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "contextId", "clickTabContextId", "intent", "Landroid/content/Intent;", "goVisitorUIWithCheck", "", "i", "gotoAnchorLive", "gotoVisitLive", "plugin-finder_release"})
public final class t
{
  public static final t yga;
  
  static
  {
    AppMethodBeat.i(289659);
    yga = new t();
    AppMethodBeat.o(289659);
  }
  
  public static void a(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(289645);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject != null)
      {
        long l = ((c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).business(c.class)).liveInfo.liveId;
        localObject = (LiveConfig)j.M((List)paramFinderLiveBundle.yeC, paramFinderLiveBundle.yeA);
        if ((localObject == null) || (l != ((LiveConfig)localObject).getLiveId()))
        {
          localObject = ah.yhC;
          ah.dzx();
        }
      }
      if (paramIntent != null) {
        break label358;
      }
      paramIntent = new Intent();
    }
    label192:
    label355:
    label358:
    for (;;)
    {
      paramIntent.addFlags(335544320);
      paramIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramFinderLiveBundle);
      localObject = aj.Bnu;
      aj.a.a(paramContext, paramIntent, 0L, 11, false, 64);
      if (!Util.isNullOrNil(paramString1)) {
        ((PluginFinder)h.ag(PluginFinder.class)).fillContextIdToIntent(paramString1, paramIntent);
      }
      paramString1 = (CharSequence)paramString2;
      int i;
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        i = 1;
        if (i == 0) {
          paramIntent.putExtra("key_click_tab_context_id", paramString2);
        }
        if (paramFinderLiveBundle.xkX != 0) {
          paramIntent.putExtra("key_comment_scene", paramFinderLiveBundle.xkX);
        }
        paramFinderLiveBundle = com.tencent.mm.plugin.findersdk.e.a.Bxf;
        paramIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enD());
        paramFinderLiveBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramFinderLiveBundle.aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramFinderLiveBundle.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if ((paramContext instanceof Activity)) {
          break label355;
        }
        paramContext = null;
      }
      for (;;)
      {
        paramContext = (Activity)paramContext;
        if (paramContext != null)
        {
          i = b.a.anim_not_change;
          paramContext.overridePendingTransition(i, i);
          AppMethodBeat.o(289645);
          return;
          localObject = null;
          break;
          i = 0;
          break label192;
        }
        AppMethodBeat.o(289645);
        return;
      }
    }
  }
  
  private static void b(final Context paramContext, final FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(289648);
    final Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramFinderLiveBundle);
    paramIntent = paramFinderLiveBundle.xPy;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.toByteArray();
      localIntent.putExtra("KEY_PARAMS_NOTICE", paramIntent);
      paramIntent = paramFinderLiveBundle.yeD;
      if (paramIntent == null) {
        break label206;
      }
    }
    label206:
    for (paramIntent = paramIntent.toByteArray();; paramIntent = null)
    {
      localIntent.putExtra("KEY_PARAMS_LIVE_TASK_INFO", paramIntent);
      if (!Util.isNullOrNil(paramString1)) {
        ((PluginFinder)h.ag(PluginFinder.class)).fillContextIdToIntent(paramString1, localIntent);
      }
      paramString1 = paramFinderLiveBundle.yeF;
      if (paramString1 == null) {
        break label341;
      }
      paramIntent = (Iterable)paramString1;
      paramString1 = (Collection)new ArrayList(j.a(paramIntent, 10));
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext()) {
        paramString1.add(((bda)paramIntent.next()).toByteArray());
      }
      paramIntent = null;
      break;
    }
    paramString1 = (List)paramString1;
    if (!(paramString1 instanceof Serializable)) {
      paramString1 = null;
    }
    for (;;)
    {
      localIntent.putExtra("KEY_PARAMS_TAGIFNOS", (Serializable)paramString1);
      paramString1 = paramFinderLiveBundle.yeG;
      if (paramString1 != null) {}
      for (paramString1 = paramString1.toByteArray();; paramString1 = null)
      {
        localIntent.putExtra("KEY_PARAMS_CHOSEN_TAG", paramString1);
        localIntent.putExtra("key_click_tab_context_id", paramString2);
        paramString1 = paramFinderLiveBundle.xQn;
        if (paramString1 == null) {
          break label555;
        }
        paramString2 = (Iterable)paramString1;
        paramString1 = (Collection)new ArrayList(j.a(paramString2, 10));
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext()) {
          paramString1.add(((ayj)paramString2.next()).toByteArray());
        }
        label341:
        paramString1 = null;
        break;
      }
      paramString1 = (List)paramString1;
      if (!(paramString1 instanceof Serializable)) {
        paramString1 = null;
      }
      for (;;)
      {
        localIntent.putExtra("KEY_PARAMS_VISITOR_WHITE_LIST", (Serializable)paramString1);
        localIntent.putExtra("KEY_PARAMS_VISIBLE_ROOM_MAX_COUNT", paramFinderLiveBundle.yeI);
        localIntent.putExtra("KEY_PARAMS_VISIBLE_USER_MAX_COUNT", paramFinderLiveBundle.yeJ);
        localIntent.putExtra("KEY_PARAMS_LUCKY_MONEY_CONFIG", paramFinderLiveBundle.yeK);
        int i = localIntent.getIntExtra("KEY_PARAMS_SOURCE_TYPE", -1);
        Log.i("Finder.LiveJumpChecker", "[gotoAnchorLive] config.secondaryDeviceFlag" + paramFinderLiveBundle.yeE + ", sourceType:" + i);
        if (i == 5)
        {
          paramFinderLiveBundle = com.tencent.mm.plugin.findersdk.e.a.Bxf;
          localIntent.setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.enM());
          paramFinderLiveBundle = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramFinderLiveBundle.aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramFinderLiveBundle.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(289648);
          return;
          label555:
          paramString1 = null;
          break;
        }
        paramString1 = (LiveConfig)paramFinderLiveBundle.yeC.get(0);
        if ((paramString1 != null) && (paramFinderLiveBundle.yeE == -1))
        {
          paramString2 = e.AmW;
          p.j(paramString1, "it");
          paramString1 = e.a.MH(paramString1.aJn());
          if (paramString1 == null) {
            break label659;
          }
          paramString1 = paramString1.getLiveInfo();
          if (paramString1 == null) {
            break label659;
          }
        }
        label659:
        for (i = paramString1.SLU;; i = -1)
        {
          paramFinderLiveBundle.yeE = i;
          paramContext = new p(paramFinderLiveBundle, localIntent, paramContext);
          if (paramFinderLiveBundle.yeE == -1) {
            break;
          }
          paramContext.invoke();
          AppMethodBeat.o(289648);
          return;
        }
        paramString1 = (LiveConfig)paramFinderLiveBundle.yeC.get(0);
        if (paramString1 != null)
        {
          paramString2 = (PluginFinder)h.ag(PluginFinder.class);
          p.j(paramString1, "it");
          paramString2.tryGetFinderObject(paramString1.aJn(), paramString1.getNonceId(), 0, false, true, (ak.a)new o(paramString1, paramFinderLiveBundle, paramContext));
          AppMethodBeat.o(289648);
          return;
        }
        AppMethodBeat.o(289648);
        return;
      }
    }
  }
  
  private static void dyN()
  {
    AppMethodBeat.i(289656);
    ah localah = ah.yhC;
    if (ah.dzA() != null)
    {
      localah = ah.yhC;
      ah.dzx();
    }
    AppMethodBeat.o(289656);
  }
  
  private static void dyO()
  {
    AppMethodBeat.i(289657);
    Object localObject = com.tencent.mm.live.core.core.a.b.klq;
    if (!b.b.aLi())
    {
      localObject = com.tencent.mm.live.core.core.b.a.knj;
      if (!a.a.aLi()) {}
    }
    else
    {
      localObject = ah.yhC;
      ah.dzx();
    }
    AppMethodBeat.o(289657);
  }
  
  public final t I(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(289650);
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      parama.invoke();
      AppMethodBeat.o(289650);
      return null;
    }
    AppMethodBeat.o(289650);
    return this;
  }
  
  public final t J(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(289652);
    if (com.tencent.mm.q.a.aAl())
    {
      parama.invoke();
      AppMethodBeat.o(289652);
      return null;
    }
    AppMethodBeat.o(289652);
    return this;
  }
  
  public final t K(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(289653);
    if ((com.tencent.mm.q.a.aAm()) || (com.tencent.mm.q.a.aAn()))
    {
      parama.invoke();
      AppMethodBeat.o(289653);
      return null;
    }
    AppMethodBeat.o(289653);
    return this;
  }
  
  public final t L(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(289658);
    int i;
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("phone");
      if (localObject != null) {
        break label87;
      }
      localObject = new kotlin.t("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(289658);
      throw ((Throwable)localObject);
    }
    catch (Exception localException1)
    {
      i = 0;
    }
    Log.e("Finder.LiveJumpChecker", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
    for (;;)
    {
      if (i != 0)
      {
        parama.invoke();
        AppMethodBeat.o(289658);
        return null;
        label87:
        TelephonyManager localTelephonyManager = (TelephonyManager)localException1;
        if (localTelephonyManager != null)
        {
          int j = localTelephonyManager.getCallState();
          switch (j)
          {
          default: 
            i = 0;
          }
          for (;;)
          {
            try
            {
              Log.i("Finder.LiveJumpChecker", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
            }
            catch (Exception localException2) {}
            break;
            i = 0;
            continue;
            i = 1;
          }
        }
      }
      else
      {
        AppMethodBeat.o(289658);
        return this;
      }
      i = 0;
    }
  }
  
  public final t a(Context paramContext, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(289651);
    if ((com.tencent.mm.q.a.p(paramContext, false)) || (com.tencent.mm.q.a.r(null, false)) || (com.tencent.mm.q.a.aAj()))
    {
      parama.invoke();
      AppMethodBeat.o(289651);
      return null;
    }
    AppMethodBeat.o(289651);
    return this;
  }
  
  public final t b(boolean paramBoolean, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(289654);
    if (com.tencent.mm.q.a.u(null, false))
    {
      if (parama != null) {
        parama.invoke();
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(289654);
        return null;
      }
    }
    AppMethodBeat.o(289654);
    return this;
  }
  
  public final t b(boolean paramBoolean, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(289655);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    int i;
    label69:
    String str;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((localObject == null) || (((c)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).business(c.class)).liveInfo.liveId == 0L) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).dGN())) {
        break label121;
      }
      i = 1;
      if (i == 0) {
        break label132;
      }
      str = z.bdh();
      if (localObject == null) {
        break label126;
      }
    }
    label121:
    label126:
    for (localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).kig;; localObject = null)
    {
      paramb.invoke(Boolean.valueOf(Util.isEqual(str, (String)localObject)));
      AppMethodBeat.o(289655);
      return null;
      localObject = null;
      break;
      i = 0;
      break label69;
    }
    label132:
    if (paramBoolean) {
      dyN();
    }
    for (;;)
    {
      AppMethodBeat.o(289655);
      return this;
      dyO();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(Context paramContext, aa.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isAnchor", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(FinderLiveBundle paramFinderLiveBundle, Context paramContext, aa.f paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isAnchor", "", "invoke"})
  public static final class k
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public k(FinderLiveBundle paramFinderLiveBundle, Context paramContext, aa.f paramf, Intent paramIntent, aa.d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final n ygg;
    
    static
    {
      AppMethodBeat.i(225034);
      ygg = new n();
      AppMethodBeat.o(225034);
    }
    
    n()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "finderObject", "", "kotlin.jvm.PlatformType", "get", "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker$gotoAnchorLive$7$1"})
  static final class o
    implements ak.a
  {
    o(LiveConfig paramLiveConfig, FinderLiveBundle paramFinderLiveBundle, t.p paramp) {}
    
    public final void dh(Object paramObject)
    {
      AppMethodBeat.i(281507);
      paramObject = paramFinderLiveBundle;
      Object localObject = e.AmW;
      localObject = this.ygh;
      p.j(localObject, "it");
      localObject = e.a.MH(((LiveConfig)localObject).aJn());
      if (localObject != null)
      {
        localObject = ((FinderItem)localObject).getLiveInfo();
        if (localObject == null) {}
      }
      for (int i = ((bac)localObject).SLU;; i = -1)
      {
        paramObject.yeE = i;
        if (paramFinderLiveBundle.yeE == -1) {
          break;
        }
        paramContext.invoke();
        AppMethodBeat.o(281507);
        return;
      }
      Log.i("Finder.LiveJumpChecker", "config.secondaryDeviceFlag is not legal: " + paramFinderLiveBundle.yeE + " after getCommentDatail");
      AppMethodBeat.o(281507);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"jump", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(FinderLiveBundle paramFinderLiveBundle, Intent paramIntent, Context paramContext)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(266060);
      Object localObject1;
      Object localObject2;
      com.tencent.mm.plugin.findersdk.e.a locala;
      if ((this.ygc.yeE == 1) || (this.ygc.yeE == 0))
      {
        localObject1 = localIntent;
        localObject2 = paramContext;
        locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
        ((Intent)localObject1).setClass((Context)localObject2, com.tencent.mm.plugin.findersdk.e.a.enE());
        localObject1 = paramContext;
        localObject2 = localIntent;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker$gotoAnchorLive$6", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker$gotoAnchorLive$6", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject2 = paramContext;
        localObject1 = localObject2;
        if (!(localObject2 instanceof Activity)) {
          localObject1 = null;
        }
        localObject1 = (Activity)localObject1;
        if (localObject1 == null) {
          break label352;
        }
        localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
        localObject2 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
        if (localObject2 == null) {
          break label345;
        }
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject2).isLiveStarted() != true)) {
          break label345;
        }
      }
      label345:
      for (int i = b.a.anim_not_change;; i = b.a.sight_slide_bottom_in)
      {
        ((Activity)localObject1).overridePendingTransition(i, b.a.anim_not_change);
        AppMethodBeat.o(266060);
        return;
        if (this.ygc.yeE == 2)
        {
          localObject1 = localIntent;
          localObject2 = paramContext;
          locala = com.tencent.mm.plugin.findersdk.e.a.Bxf;
          ((Intent)localObject1).setClass((Context)localObject2, com.tencent.mm.plugin.findersdk.e.a.enM());
          localIntent.addFlags(872415232);
          localObject1 = paramContext;
          localObject2 = localIntent;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker$gotoAnchorLive$6", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker$gotoAnchorLive$6", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
        }
        Log.i("Finder.LiveJumpChecker", "config.secondaryDeviceFlag is not legal: " + this.ygc.yeE);
        break;
      }
      label352:
      AppMethodBeat.o(266060);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.t
 * JD-Core Version:    0.7.0.1
 */