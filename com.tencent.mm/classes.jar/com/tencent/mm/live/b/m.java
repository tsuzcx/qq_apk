package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.core.core.a.b.b;
import com.tencent.mm.live.core.core.c.c.a;
import com.tencent.mm.live.ui.dialog.LiveVisitorGuideView;
import com.tencent.mm.protocal.protobuf.crl;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"})
public final class m
  implements com.tencent.mm.live.api.a
{
  private static final String TAG = "MicroMsg.LiveEntranceJumper";
  public static final m kuW;
  
  static
  {
    AppMethodBeat.i(195177);
    kuW = new m();
    TAG = "MicroMsg.LiveEntranceJumper";
    AppMethodBeat.o(195177);
  }
  
  private static void e(final Context paramContext, final LiveConfig paramLiveConfig)
  {
    int j = 1;
    AppMethodBeat.i(195161);
    Object localObject1;
    Object localObject2;
    if (WeChatEnvironment.hasDebugger())
    {
      localObject1 = l.e.kuB;
      localObject1 = MultiProcessMMKV.getSingleMMKV(l.e.aNJ());
      localObject2 = l.g.kuI;
      if (((MultiProcessMMKV)localObject1).getBoolean(l.g.aNP(), false))
      {
        i = 1;
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        localObject1 = ((f)localObject1).aHp().get(6);
        if (localObject1 != null) {
          break label237;
        }
        localObject1 = null;
        label77:
        if (i == 0) {
          break label247;
        }
        if (paramLiveConfig != null) {
          LiveConfig.eS(false);
        }
        label89:
        localObject1 = u.kwz;
        if (!u.aOF().kwC) {
          break label328;
        }
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        if (((f)localObject1).aHp().getInt(ar.a.VDi, 1) != 1) {
          break label312;
        }
      }
    }
    label296:
    label301:
    label312:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label317;
      }
      localObject1 = new g(paramContext, 0, 0);
      ((g)localObject1).setHeight(ax.au(paramContext).y * 3 / 4);
      localObject2 = new LiveVisitorGuideView(paramContext);
      ((LiveVisitorGuideView)localObject2).setOnHideListener((kotlin.g.a.a)new m.b((g)localObject1));
      ((LiveVisitorGuideView)localObject2).setOnOkListener((kotlin.g.a.a)new c((g)localObject1, paramContext, paramLiveConfig));
      ((g)localObject1).setCustomView((View)localObject2);
      ((g)localObject1).eik();
      AppMethodBeat.o(195161);
      return;
      i = 0;
      break;
      label237:
      localObject1 = (String)localObject1;
      break label77;
      label247:
      localObject2 = u.kwz;
      if (u.aOF().kwB)
      {
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() != 0) {
            break label296;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label301;
          }
          if (paramLiveConfig == null) {
            break;
          }
          LiveConfig.eS(true);
          break;
        }
      }
      if (paramLiveConfig == null) {
        break label89;
      }
      LiveConfig.eS(false);
      break label89;
    }
    label317:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(195161);
    return;
    label328:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(195161);
  }
  
  private static void f(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(195165);
    if (paramLiveConfig != null) {
      com.tencent.mm.live.b.c.c.getLiveTipsBarStorage().t(paramLiveConfig.aJg(), paramLiveConfig.getLiveId());
    }
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aFh(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(195165);
  }
  
  private static void g(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(195171);
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aFh(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(195171);
  }
  
  public final boolean a(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(195133);
    p.k(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aFh(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(195133);
    return bool;
  }
  
  public final boolean b(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(195141);
    p.k(paramContext, "context");
    for (;;)
    {
      try
      {
        a locala = a.kuX;
        p.k(paramContext, "context");
        aa.f localf = new aa.f();
        localObject = paramContext.getResources();
        if (localObject == null) {
          continue;
        }
        localObject = ((Resources)localObject).getString(b.h.live_open_new_tip_busy);
        localf.aaBC = localObject;
        localObject = new aa.f();
        String str = paramContext.getResources().getString(b.h.app_i_know);
        p.j(str, "context.resources.getString(R.string.app_i_know)");
        ((aa.f)localObject).aaBC = str;
        locala = locala.l((kotlin.g.a.a)new m.a.f(paramContext, (aa.f)localObject));
        if (locala != null)
        {
          locala = locala.k((kotlin.g.a.a)new m.a.g(paramContext, (aa.f)localObject));
          if (locala != null)
          {
            locala = locala.m((kotlin.g.a.a)new m.a.h(paramContext, (aa.f)localObject));
            if ((locala != null) && (locala.a(paramLiveConfig, (kotlin.g.a.a)new m.a.i(paramContext, (aa.f)localObject, paramLiveConfig, localf)) != null))
            {
              localObject = com.tencent.mm.live.core.core.a.b.klq;
              if (!b.b.aLi()) {
                continue;
              }
              localObject = com.tencent.mm.live.core.core.a.b.klq;
              b.b.aLh();
              if (paramLiveConfig != null)
              {
                long l = paramLiveConfig.getLiveId();
                localObject = u.kwz;
                if (l == u.aOr().klE) {}
              }
              else
              {
                localObject = u.kwz;
                u.ate();
              }
              e(paramContext, paramLiveConfig);
            }
          }
        }
        bool = true;
      }
      catch (ClassNotFoundException paramContext)
      {
        Object localObject;
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(195141);
      return bool;
      localObject = null;
      continue;
      localObject = com.tencent.mm.live.core.core.c.c.kqq;
      if (c.a.aLi())
      {
        localObject = com.tencent.mm.live.core.core.c.c.kqq;
        c.a.aMm();
      }
    }
  }
  
  public final boolean c(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(195159);
    p.k(paramContext, "context");
    for (;;)
    {
      try
      {
        Object localObject2 = a.kuX;
        p.k(paramContext, "context");
        localObject1 = new aa.f();
        Object localObject3 = paramContext.getResources().getString(b.h.app_i_know);
        p.j(localObject3, "context.resources.getString(R.string.app_i_know)");
        ((aa.f)localObject1).aaBC = localObject3;
        localObject2 = ((a)localObject2).l((kotlin.g.a.a)new m.a.a(paramContext, (aa.f)localObject1));
        if (localObject2 != null)
        {
          localObject2 = ((a)localObject2).k((kotlin.g.a.a)new m.a.b(paramContext, (aa.f)localObject1));
          if (localObject2 != null)
          {
            localObject2 = ((a)localObject2).m((kotlin.g.a.a)new m.a.c(paramContext, (aa.f)localObject1));
            if (localObject2 != null)
            {
              localObject1 = ((a)localObject2).a(paramLiveConfig, (kotlin.g.a.a)new m.a.d(paramContext, (aa.f)localObject1, paramLiveConfig));
              if (localObject1 != null)
              {
                localObject2 = (kotlin.g.a.b)new m.a.e(paramContext, paramLiveConfig);
                localObject3 = com.tencent.mm.live.b.c.a.kyw;
                localObject3 = com.tencent.mm.live.b.c.a.aPm();
                if ((paramLiveConfig == null) || (paramLiveConfig.getScene() != LiveConfig.khV) || (((crl)localObject3).klE == 0L)) {
                  continue;
                }
                ((kotlin.g.a.b)localObject2).invoke(localObject3);
                localObject1 = null;
                if (localObject1 != null)
                {
                  localObject1 = com.tencent.mm.live.core.core.a.b.klq;
                  if (!b.b.aLi()) {
                    continue;
                  }
                  localObject1 = com.tencent.mm.live.core.core.a.b.klq;
                  b.b.aLh();
                  if (paramLiveConfig != null)
                  {
                    long l = paramLiveConfig.getLiveId();
                    localObject1 = u.kwz;
                    if (l == u.aOr().klE) {}
                  }
                  else
                  {
                    localObject1 = u.kwz;
                    u.ate();
                  }
                  g(paramContext, paramLiveConfig);
                }
              }
            }
          }
        }
        bool = true;
      }
      catch (ClassNotFoundException paramContext)
      {
        Object localObject1;
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToAnchorUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(195159);
      return bool;
      continue;
      localObject1 = com.tencent.mm.live.core.core.c.c.kqq;
      if (c.a.aLi())
      {
        localObject1 = com.tencent.mm.live.core.core.c.c.kqq;
        c.a.aMm();
      }
    }
  }
  
  public final boolean d(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(195150);
    p.k(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUID"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtra("FROM_SENCE", 1);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aFh(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToReplayUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(195150);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkAnchorLiving", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "errorCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "Lkotlin/ParameterName;", "name", "liveAnchorInfo", "", "checkIsUsePhone", "Lkotlin/Function0;", "checkLiveInfo", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"})
  public static final class a
  {
    public static final a kuX;
    
    static
    {
      AppMethodBeat.i(200399);
      kuX = new a();
      AppMethodBeat.o(200399);
    }
    
    final a a(LiveConfig paramLiveConfig, kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(200387);
      Object localObject1 = u.kwz;
      int i;
      if (u.aOr().klE != 0L)
      {
        localObject1 = m.kuW;
        String str = m.aNX();
        localObject1 = new StringBuilder("curLiveId:");
        Object localObject2 = u.kwz;
        localObject2 = ((StringBuilder)localObject1).append(u.aOr().klE).append(" newLiveId:");
        if (paramLiveConfig != null)
        {
          localObject1 = Long.valueOf(paramLiveConfig.getLiveId());
          Log.i(str, localObject1);
          localObject1 = u.kwz;
          if (!u.aOD().kwJ)
          {
            localObject1 = u.kwz;
            if (!u.aOD().kwH) {
              break label147;
            }
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label269;
        }
        parama.invoke();
        AppMethodBeat.o(200387);
        return null;
        localObject1 = null;
        break;
        label147:
        if ((paramLiveConfig != null) && (paramLiveConfig.getLiveId() == 0L))
        {
          localObject1 = u.kwz;
          localObject1 = (CharSequence)u.aOm();
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              localObject1 = u.kwz;
              if (!Util.isEqual(u.aOm(), paramLiveConfig.aJg())) {}
            }
            else
            {
              if (paramLiveConfig.getScene() != LiveConfig.khV) {
                break label259;
              }
            }
            i = 0;
            break;
          }
        }
        localObject1 = u.kwz;
        long l = u.aOr().klE;
        if ((paramLiveConfig != null) && (l == paramLiveConfig.getLiveId())) {
          label259:
          i = 1;
        } else {
          i = 0;
        }
      }
      label269:
      AppMethodBeat.o(200387);
      return this;
    }
    
    final a k(kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(200395);
      int i;
      try
      {
        Object localObject1 = MMApplicationContext.getContext().getSystemService("phone");
        if (localObject1 != null) {
          break label86;
        }
        localObject1 = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(200395);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      m localm = m.kuW;
      Log.e(m.aNX(), "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
      for (;;)
      {
        if (i != 0)
        {
          parama.invoke();
          AppMethodBeat.o(200395);
          return null;
          label86:
          Object localObject2 = (TelephonyManager)localException1;
          if (localObject2 != null)
          {
            int j = ((TelephonyManager)localObject2).getCallState();
            switch (j)
            {
            default: 
              i = 0;
            }
            for (;;)
            {
              try
              {
                localObject2 = m.kuW;
                Log.i(m.aNX(), "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
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
          AppMethodBeat.o(200395);
          return this;
        }
        i = 0;
      }
    }
    
    final a l(kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(200396);
      if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
      {
        parama.invoke();
        AppMethodBeat.o(200396);
        return null;
      }
      AppMethodBeat.o(200396);
      return this;
    }
    
    final a m(kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(200398);
      yx localyx = new yx();
      localyx.fYg.fYi = true;
      EventCenter.instance.publish((IEvent)localyx);
      if (!Util.isNullOrNil(localyx.fYh.fYk))
      {
        parama.invoke();
        AppMethodBeat.o(200398);
        return null;
      }
      AppMethodBeat.o(200398);
      return this;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(Context paramContext, aa.f paramf, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "liveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.b<crl, x>
    {
      e(Context paramContext, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class i
      extends q
      implements kotlin.g.a.a<x>
    {
      i(Context paramContext, aa.f paramf1, LiveConfig paramLiveConfig, aa.f paramf2)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(g paramg, Context paramContext, LiveConfig paramLiveConfig)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.m
 * JD-Core Version:    0.7.0.1
 */