package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.live.ui.dialog.LiveVisitorGuideView;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.civ;
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
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.f.c;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"})
public final class p
  implements com.tencent.mm.live.api.a
{
  private static final String TAG = "MicroMsg.LiveEntranceJumper";
  public static final p hHC;
  
  static
  {
    AppMethodBeat.i(207649);
    hHC = new p();
    TAG = "MicroMsg.LiveEntranceJumper";
    AppMethodBeat.o(207649);
  }
  
  private static void e(Context paramContext, LiveConfig paramLiveConfig)
  {
    int j = 1;
    AppMethodBeat.i(207646);
    Object localObject1;
    Object localObject2;
    if (WeChatEnvironment.hasDebugger())
    {
      localObject1 = o.f.hGW;
      localObject1 = MultiProcessMMKV.getSingleMMKV(o.f.aFC());
      localObject2 = o.h.hHd;
      if (((MultiProcessMMKV)localObject1).getBoolean(o.h.aFI(), false))
      {
        i = 1;
        localObject1 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).azQ().get(6);
        if (localObject1 != null) {
          break label237;
        }
        localObject1 = null;
        label77:
        if (i == 0) {
          break label247;
        }
        if (paramLiveConfig != null) {
          LiveConfig.eu(false);
        }
        label89:
        localObject1 = x.hJf;
        if (!x.aGF().hJi) {
          break label328;
        }
        localObject1 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
        if (((e)localObject1).azQ().getInt(ar.a.OnS, 1) != 1) {
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
      localObject1 = new com.tencent.mm.ui.widget.a.g(paramContext, 0, 0);
      ((com.tencent.mm.ui.widget.a.g)localObject1).setHeight(au.az(paramContext).y * 3 / 4);
      localObject2 = new LiveVisitorGuideView(paramContext);
      ((LiveVisitorGuideView)localObject2).setOnHideListener((kotlin.g.a.a)new p.b((com.tencent.mm.ui.widget.a.g)localObject1));
      ((LiveVisitorGuideView)localObject2).setOnOkListener((kotlin.g.a.a)new p.c((com.tencent.mm.ui.widget.a.g)localObject1, paramContext, paramLiveConfig));
      ((com.tencent.mm.ui.widget.a.g)localObject1).setCustomView((View)localObject2);
      ((com.tencent.mm.ui.widget.a.g)localObject1).dGm();
      AppMethodBeat.o(207646);
      return;
      i = 0;
      break;
      label237:
      localObject1 = (String)localObject1;
      break label77;
      label247:
      localObject2 = x.hJf;
      if (x.aGF().hJh)
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
          LiveConfig.eu(true);
          break;
        }
      }
      if (paramLiveConfig == null) {
        break label89;
      }
      LiveConfig.eu(false);
      break label89;
    }
    label317:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(207646);
    return;
    label328:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(207646);
  }
  
  private static void f(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207647);
    if (paramLiveConfig != null) {
      c.getLiveTipsBarStorage().w(paramLiveConfig.aBD(), paramLiveConfig.getLiveId());
    }
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(207647);
  }
  
  private static void g(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207648);
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(207648);
  }
  
  public final boolean a(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207642);
    kotlin.g.b.p.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    AppMethodBeat.o(207642);
    return bool;
  }
  
  public final boolean b(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207643);
    kotlin.g.b.p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        a locala = a.hHD;
        kotlin.g.b.p.h(paramContext, "context");
        z.f localf = new z.f();
        localObject = paramContext.getResources();
        if (localObject == null) {
          continue;
        }
        localObject = ((Resources)localObject).getString(2131762351);
        localf.SYG = localObject;
        localObject = new z.f();
        String str = paramContext.getResources().getString(2131755873);
        kotlin.g.b.p.g(str, "context.resources.getString(R.string.app_i_know)");
        ((z.f)localObject).SYG = str;
        locala = locala.m((kotlin.g.a.a)new p.a.f(paramContext, (z.f)localObject));
        if (locala != null)
        {
          locala = locala.l((kotlin.g.a.a)new p.a.g(paramContext, (z.f)localObject));
          if (locala != null)
          {
            locala = locala.n((kotlin.g.a.a)new p.a.h(paramContext, (z.f)localObject));
            if ((locala != null) && (locala.a(paramLiveConfig, (kotlin.g.a.a)new p.a.i(paramContext, (z.f)localObject, paramLiveConfig, localf)) != null))
            {
              localObject = com.tencent.mm.live.core.core.a.b.hyv;
              if (!com.tencent.mm.live.core.core.a.b.a.aDp()) {
                continue;
              }
              localObject = com.tencent.mm.live.core.core.a.b.hyv;
              com.tencent.mm.live.core.core.a.b.a.aDo();
              if (paramLiveConfig != null)
              {
                long l = paramLiveConfig.getLiveId();
                localObject = x.hJf;
                if (l == x.aGr().hyH) {}
              }
              else
              {
                localObject = x.hJf;
                x.and();
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
      AppMethodBeat.o(207643);
      return bool;
      localObject = null;
      continue;
      localObject = com.tencent.mm.live.core.core.d.b.hCo;
      if (com.tencent.mm.live.core.core.d.b.a.aDp())
      {
        localObject = com.tencent.mm.live.core.core.d.b.hCo;
        com.tencent.mm.live.core.core.d.b.a.aEf();
      }
    }
  }
  
  public final boolean c(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207645);
    kotlin.g.b.p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        Object localObject2 = a.hHD;
        kotlin.g.b.p.h(paramContext, "context");
        localObject1 = new z.f();
        Object localObject3 = paramContext.getResources().getString(2131755873);
        kotlin.g.b.p.g(localObject3, "context.resources.getString(R.string.app_i_know)");
        ((z.f)localObject1).SYG = localObject3;
        localObject2 = ((a)localObject2).m((kotlin.g.a.a)new p.a.a(paramContext, (z.f)localObject1));
        if (localObject2 != null)
        {
          localObject2 = ((a)localObject2).l((kotlin.g.a.a)new p.a.b(paramContext, (z.f)localObject1));
          if (localObject2 != null)
          {
            localObject2 = ((a)localObject2).n((kotlin.g.a.a)new p.a.c(paramContext, (z.f)localObject1));
            if (localObject2 != null)
            {
              localObject1 = ((a)localObject2).a(paramLiveConfig, (kotlin.g.a.a)new p.a.d(paramContext, (z.f)localObject1, paramLiveConfig));
              if (localObject1 != null)
              {
                localObject2 = (kotlin.g.a.b)new p.a.e(paramContext, paramLiveConfig);
                localObject3 = com.tencent.mm.live.b.c.a.hLc;
                localObject3 = com.tencent.mm.live.b.c.a.aHm();
                if ((paramLiveConfig == null) || (paramLiveConfig.getScene() != LiveConfig.hvS) || (((cip)localObject3).hyH == 0L)) {
                  continue;
                }
                ((kotlin.g.a.b)localObject2).invoke(localObject3);
                localObject1 = null;
                if (localObject1 != null)
                {
                  localObject1 = com.tencent.mm.live.core.core.a.b.hyv;
                  if (!com.tencent.mm.live.core.core.a.b.a.aDp()) {
                    continue;
                  }
                  localObject1 = com.tencent.mm.live.core.core.a.b.hyv;
                  com.tencent.mm.live.core.core.a.b.a.aDo();
                  if (paramLiveConfig != null)
                  {
                    long l = paramLiveConfig.getLiveId();
                    localObject1 = x.hJf;
                    if (l == x.aGr().hyH) {}
                  }
                  else
                  {
                    localObject1 = x.hJf;
                    x.and();
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
      AppMethodBeat.o(207645);
      return bool;
      continue;
      localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
      if (com.tencent.mm.live.core.core.d.b.a.aDp())
      {
        localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
        com.tencent.mm.live.core.core.d.b.a.aEf();
      }
    }
  }
  
  public final boolean d(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(207644);
    kotlin.g.b.p.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUID"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtra("FROM_SENCE", 1);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.axQ(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    AppMethodBeat.o(207644);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkAnchorLiving", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "errorCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "Lkotlin/ParameterName;", "name", "liveAnchorInfo", "", "checkIsUsePhone", "Lkotlin/Function0;", "checkLiveInfo", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"})
  public static final class a
  {
    public static final a hHD;
    
    static
    {
      AppMethodBeat.i(207639);
      hHD = new a();
      AppMethodBeat.o(207639);
    }
    
    final a a(LiveConfig paramLiveConfig, kotlin.g.a.a<kotlin.x> parama)
    {
      AppMethodBeat.i(207635);
      Object localObject1 = x.hJf;
      int i;
      if (x.aGr().hyH != 0L)
      {
        localObject1 = p.hHC;
        String str = p.aFX();
        localObject1 = new StringBuilder("curLiveId:");
        Object localObject2 = x.hJf;
        localObject2 = ((StringBuilder)localObject1).append(x.aGr().hyH).append(" newLiveId:");
        if (paramLiveConfig != null)
        {
          localObject1 = Long.valueOf(paramLiveConfig.getLiveId());
          Log.i(str, localObject1);
          localObject1 = x.hJf;
          if (!x.aGD().hJp)
          {
            localObject1 = x.hJf;
            if (!x.aGD().hJn) {
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
        AppMethodBeat.o(207635);
        return null;
        localObject1 = null;
        break;
        label147:
        if ((paramLiveConfig != null) && (paramLiveConfig.getLiveId() == 0L))
        {
          localObject1 = x.hJf;
          localObject1 = (CharSequence)x.aGm();
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              localObject1 = x.hJf;
              if (!Util.isEqual(x.aGm(), paramLiveConfig.aBD())) {}
            }
            else
            {
              if (paramLiveConfig.getScene() != LiveConfig.hvS) {
                break label259;
              }
            }
            i = 0;
            break;
          }
        }
        localObject1 = x.hJf;
        long l = x.aGr().hyH;
        if ((paramLiveConfig != null) && (l == paramLiveConfig.getLiveId())) {
          label259:
          i = 1;
        } else {
          i = 0;
        }
      }
      label269:
      AppMethodBeat.o(207635);
      return this;
    }
    
    final a l(kotlin.g.a.a<kotlin.x> parama)
    {
      AppMethodBeat.i(207636);
      int i;
      try
      {
        Object localObject1 = MMApplicationContext.getContext().getSystemService("phone");
        if (localObject1 != null) {
          break label86;
        }
        localObject1 = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(207636);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      p localp = p.hHC;
      Log.e(p.aFX(), "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
      for (;;)
      {
        if (i != 0)
        {
          parama.invoke();
          AppMethodBeat.o(207636);
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
                localObject2 = p.hHC;
                Log.i(p.aFX(), "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
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
          AppMethodBeat.o(207636);
          return this;
        }
        i = 0;
      }
    }
    
    final a m(kotlin.g.a.a<kotlin.x> parama)
    {
      AppMethodBeat.i(207637);
      if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
      {
        parama.invoke();
        AppMethodBeat.o(207637);
        return null;
      }
      AppMethodBeat.o(207637);
      return this;
    }
    
    final a n(kotlin.g.a.a<kotlin.x> parama)
    {
      AppMethodBeat.i(207638);
      xq localxq = new xq();
      localxq.edR.edT = true;
      EventCenter.instance.publish((IEvent)localxq);
      if (!Util.isNullOrNil(localxq.edS.edV))
      {
        parama.invoke();
        AppMethodBeat.o(207638);
        return null;
      }
      AppMethodBeat.o(207638);
      return this;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      d(Context paramContext, z.f paramf, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "liveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "invoke"})
    static final class e
      extends q
      implements kotlin.g.a.b<cip, kotlin.x>
    {
      e(Context paramContext, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class i
      extends q
      implements kotlin.g.a.a<kotlin.x>
    {
      i(Context paramContext, z.f paramf1, LiveConfig paramLiveConfig, z.f paramf2)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.p
 * JD-Core Version:    0.7.0.1
 */