package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.c.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI13;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker;", "", "()V", "TAG", "", "checkAppBrand", "errorCallback", "Lkotlin/Function0;", "", "checkIsUsePhone", "checkLiveAnchorCore", "context", "Landroid/content/Context;", "checkLiveInfo", "gotoAnchor", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAnchor", "checkLiveVisitorCore", "checkNetwork", "checkRoomLive", "checkVoip", "goAnchorUIWithCheck", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "contextId", "clickTabContextId", "goVisitorUIWithCheck", "i", "Landroid/content/Intent;", "gotoAnchorLive", "gotoVisitLive", "plugin-finder_release"})
public final class h
{
  public static final h uiL;
  
  static
  {
    AppMethodBeat.i(246138);
    uiL = new h();
    AppMethodBeat.o(246138);
  }
  
  private static void a(Context paramContext, FinderLiveConfig paramFinderLiveConfig, String paramString1, String paramString2)
  {
    AppMethodBeat.i(246128);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramFinderLiveConfig);
    Object localObject1 = paramFinderLiveConfig.uiv;
    if (localObject1 != null) {}
    for (localObject1 = ((awt)localObject1).toByteArray();; localObject1 = null)
    {
      localIntent.putExtra("KEY_PARAMS_NOTICE", (byte[])localObject1);
      if (!Util.isNullOrNil(paramString1)) {
        ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).fillContextIdToIntent(paramString1, localIntent);
      }
      localObject1 = paramFinderLiveConfig.uiw;
      if (localObject1 == null) {
        break label313;
      }
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((axk)((Iterator)localObject2).next()).toByteArray());
      }
    }
    localObject1 = (List)localObject1;
    if (!(localObject1 instanceof Serializable)) {
      localObject1 = null;
    }
    for (;;)
    {
      localIntent.putExtra("KEY_PARAMS_TAGIFNOS", (Serializable)localObject1);
      localObject1 = paramFinderLiveConfig.uix;
      if (localObject1 != null) {}
      for (localObject1 = ((axk)localObject1).toByteArray();; localObject1 = null)
      {
        localIntent.putExtra("KEY_PARAMS_CHOSEN_TAG", (byte[])localObject1);
        localIntent.putExtra("key_click_tab_context_id", paramString2);
        paramString2 = paramFinderLiveConfig.ueu;
        if (paramString2 == null) {
          break label458;
        }
        localObject1 = (Iterable)paramString2;
        paramString2 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramString2.add(((avh)((Iterator)localObject1).next()).toByteArray());
        }
        label313:
        localObject1 = null;
        break;
      }
      paramString2 = (List)paramString2;
      if (!(paramString2 instanceof Serializable)) {
        paramString2 = null;
      }
      for (;;)
      {
        localIntent.putExtra("KEY_PARAMS_VISITOR_WHITE_LIST", (Serializable)paramString2);
        Log.i("Finder.LiveJumpChecker", "[gotoAnchorLive] config.sourceType" + paramFinderLiveConfig.sourceType);
        if (paramFinderLiveConfig.sourceType == 0)
        {
          localIntent.setClass(paramContext, FinderLiveAnchorWithoutAffinityUI.class);
          paramFinderLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramFinderLiveConfig.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramFinderLiveConfig.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(246128);
          return;
          label458:
          paramString2 = null;
          break;
        }
        if ((paramFinderLiveConfig.sourceType == 1) || (paramFinderLiveConfig.sourceType == 2))
        {
          localIntent.setClass(paramContext, OccupyFinderUI13.class);
          paramFinderLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramFinderLiveConfig.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramFinderLiveConfig.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(246128);
          return;
        }
        for (;;)
        {
          try
          {
            paramContext = (LiveConfig)paramFinderLiveConfig.uiu.get(0);
            if (paramContext == null) {
              break;
            }
            if (paramFinderLiveConfig.sourceType == -1)
            {
              paramString2 = e.vFX;
              p.g(paramContext, "it");
              paramString2 = e.a.Fy(paramContext.aBH());
              if (paramString2 != null)
              {
                paramString2 = paramString2.getLiveInfo();
                if (paramString2 != null)
                {
                  i = paramString2.LEg;
                  paramFinderLiveConfig.sourceType = i;
                }
              }
            }
            else
            {
              paramFinderLiveConfig = (aj)com.tencent.mm.kernel.g.ah(aj.class);
              paramString2 = MMApplicationContext.getContext();
              p.g(paramContext, "it");
              paramFinderLiveConfig.enterFinderLiveVisitorUI(paramString2, paramContext.aBH(), Long.valueOf(paramContext.getLiveId()), "", paramContext.aBI(), paramContext.getDesc(), paramString1, paramContext.getSessionBuffer());
              AppMethodBeat.o(246128);
              return;
            }
          }
          catch (NumberFormatException paramContext)
          {
            AppMethodBeat.o(246128);
            return;
          }
          int i = 0;
        }
        AppMethodBeat.o(246128);
        return;
      }
    }
  }
  
  public static void a(Context paramContext, FinderLiveConfig paramFinderLiveConfig, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(246125);
    Object localObject = o.ujN;
    localObject = o.dfZ();
    if (localObject != null)
    {
      long l = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo.liveId;
      localObject = (LiveConfig)j.L((List)paramFinderLiveConfig.uiu, paramFinderLiveConfig.uis);
      if ((localObject == null) || (l != ((LiveConfig)localObject).getLiveId())) {
        o.a(o.ujN);
      }
    }
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    ((Intent)localObject).addFlags(335544320);
    ((Intent)localObject).putExtra("key_click_tab_context_id", paramString2);
    ((Intent)localObject).putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramFinderLiveConfig);
    if (!Util.isNullOrNil(paramString1)) {
      ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).fillContextIdToIntent(paramString1, (Intent)localObject);
    }
    ((Intent)localObject).setClass(paramContext, FinderLiveVisitorWithoutAffinityUI.class);
    paramFinderLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramFinderLiveConfig.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramFinderLiveConfig.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(246125);
  }
  
  private static void dfG()
  {
    AppMethodBeat.i(246135);
    com.tencent.mm.live.core.core.d.b.a locala = com.tencent.mm.live.core.core.d.b.hCo;
    if (com.tencent.mm.live.core.core.d.b.a.aDp()) {
      o.a(o.ujN);
    }
    AppMethodBeat.o(246135);
  }
  
  private static void dfH()
  {
    AppMethodBeat.i(246136);
    Object localObject = com.tencent.mm.live.core.core.a.b.hyv;
    if (!com.tencent.mm.live.core.core.a.b.a.aDp())
    {
      localObject = com.tencent.mm.live.core.core.c.a.hAj;
      if (!a.a.aDp()) {}
    }
    else
    {
      o.a(o.ujN);
    }
    AppMethodBeat.o(246136);
  }
  
  public final h J(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(246130);
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      parama.invoke();
      AppMethodBeat.o(246130);
      return null;
    }
    AppMethodBeat.o(246130);
    return this;
  }
  
  public final h K(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(246132);
    if (com.tencent.mm.q.a.atu())
    {
      parama.invoke();
      AppMethodBeat.o(246132);
      return null;
    }
    AppMethodBeat.o(246132);
    return this;
  }
  
  public final h L(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(246133);
    if ((com.tencent.mm.q.a.atw()) || (com.tencent.mm.q.a.atx()))
    {
      parama.invoke();
      AppMethodBeat.o(246133);
      return null;
    }
    AppMethodBeat.o(246133);
    return this;
  }
  
  public final h M(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(246137);
    int i;
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("phone");
      if (localObject != null) {
        break label86;
      }
      localObject = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(246137);
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
        AppMethodBeat.o(246137);
        return null;
        label86:
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
        AppMethodBeat.o(246137);
        return this;
      }
      i = 0;
    }
  }
  
  public final h a(Context paramContext, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(246131);
    if ((com.tencent.mm.q.a.o(paramContext, false)) || (com.tencent.mm.q.a.atv()) || (com.tencent.mm.q.a.att()))
    {
      parama.invoke();
      AppMethodBeat.o(246131);
      return null;
    }
    AppMethodBeat.o(246131);
    return this;
  }
  
  public final h b(boolean paramBoolean, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(246134);
    Object localObject = o.ujN;
    localObject = o.dfZ();
    int i;
    String str;
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).liveInfo.liveId != 0L) && (!((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).djl()))
    {
      i = 1;
      if (i == 0) {
        break label101;
      }
      str = z.aUg();
      if (localObject == null) {
        break label95;
      }
    }
    label95:
    for (localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject).hwd;; localObject = null)
    {
      paramb.invoke(Boolean.valueOf(Util.isEqual(str, (String)localObject)));
      AppMethodBeat.o(246134);
      return null;
      i = 0;
      break;
    }
    label101:
    if (paramBoolean) {
      dfG();
    }
    for (;;)
    {
      AppMethodBeat.o(246134);
      return this;
      dfH();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(Context paramContext, z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isAnchor", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(FinderLiveConfig paramFinderLiveConfig, Context paramContext, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isAnchor", "", "invoke"})
  public static final class j
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    public j(FinderLiveConfig paramFinderLiveConfig, Context paramContext, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.h
 * JD-Core Version:    0.7.0.1
 */