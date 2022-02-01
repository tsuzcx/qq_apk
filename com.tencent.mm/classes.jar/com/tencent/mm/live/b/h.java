package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.live.ui.dialog.LiveVisitorGuideView;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
import d.g.b.v.f;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"})
public final class h
  implements com.tencent.mm.live.api.a
{
  private static final String TAG = "MicroMsg.LiveEntranceJumper";
  public static final h guS;
  
  static
  {
    AppMethodBeat.i(189834);
    guS = new h();
    TAG = "MicroMsg.LiveEntranceJumper";
    AppMethodBeat.o(189834);
  }
  
  private static void e(final Context paramContext, final LiveConfig paramLiveConfig)
  {
    int j = 1;
    AppMethodBeat.i(189831);
    Object localObject1 = g.guG;
    g.alx();
    Object localObject2;
    if (bt.eWo())
    {
      localObject1 = f.e.gtA;
      localObject1 = aw.aKU(f.e.akp());
      localObject2 = f.g.gtG;
      if (((aw)localObject1).getBoolean(f.g.aku(), false))
      {
        i = 1;
        localObject1 = com.tencent.mm.kernel.g.agR();
        k.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).agA().get(6);
        if (localObject1 != null) {
          break label245;
        }
        localObject1 = null;
        label85:
        if (i == 0) {
          break label255;
        }
        if (paramLiveConfig != null) {
          LiveConfig.dB(false);
        }
        label97:
        localObject1 = g.guG;
        if (!g.akV().guJ) {
          break label336;
        }
        localObject1 = com.tencent.mm.kernel.g.agR();
        k.g(localObject1, "MMKernel.storage()");
        if (((e)localObject1).agA().getInt(ah.a.GWE, 1) != 1) {
          break label320;
        }
      }
    }
    label304:
    label309:
    label320:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label325;
      }
      localObject1 = new com.tencent.mm.ui.widget.a.g(paramContext, 0, 0);
      ((com.tencent.mm.ui.widget.a.g)localObject1).setHeight(ap.cl(paramContext).y * 3 / 4);
      localObject2 = new LiveVisitorGuideView(paramContext);
      ((LiveVisitorGuideView)localObject2).setOnHideListener((d.g.a.a)new b((com.tencent.mm.ui.widget.a.g)localObject1));
      ((LiveVisitorGuideView)localObject2).setOnOkListener((d.g.a.a)new c((com.tencent.mm.ui.widget.a.g)localObject1, paramContext, paramLiveConfig));
      ((com.tencent.mm.ui.widget.a.g)localObject1).setCustomView((View)localObject2);
      ((com.tencent.mm.ui.widget.a.g)localObject1).cED();
      AppMethodBeat.o(189831);
      return;
      i = 0;
      break;
      label245:
      localObject1 = (String)localObject1;
      break label85;
      label255:
      localObject2 = g.guG;
      if (g.akV().guI)
      {
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() != 0) {
            break label304;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label309;
          }
          if (paramLiveConfig == null) {
            break;
          }
          LiveConfig.dB(true);
          break;
        }
      }
      if (paramLiveConfig == null) {
        break label97;
      }
      LiveConfig.dB(false);
      break label97;
    }
    label325:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(189831);
    return;
    label336:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(189831);
  }
  
  private static void f(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(189832);
    if (paramLiveConfig != null) {
      c.getLiveTipsBarStorage().t(paramLiveConfig.aij(), paramLiveConfig.ail());
    }
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.aeD(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(189832);
  }
  
  private static void g(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(189833);
    Object localObject = g.guG;
    g.alx();
    localObject = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    ((Intent)localObject).putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    ((Intent)localObject).addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.aeD(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(189833);
  }
  
  public final boolean a(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(189827);
    k.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.aeD(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        ac.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(189827);
    return bool;
  }
  
  public final boolean b(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(189828);
    k.h(paramContext, "context");
    for (;;)
    {
      try
      {
        a locala = a.guT;
        k.h(paramContext, "context");
        v.f localf = new v.f();
        localObject = paramContext.getResources();
        if (localObject == null) {
          continue;
        }
        localObject = ((Resources)localObject).getString(2131766655);
        localf.KUQ = localObject;
        localObject = new v.f();
        ((v.f)localObject).KUQ = paramContext.getResources().getString(2131755792);
        locala = locala.k((d.g.a.a)new h.a.f(paramContext, (v.f)localObject));
        if (locala != null)
        {
          locala = locala.j((d.g.a.a)new h.a.g(paramContext, (v.f)localObject));
          if (locala != null)
          {
            locala = locala.l((d.g.a.a)new h.a.h(paramContext, (v.f)localObject));
            if ((locala != null) && (locala.a(paramLiveConfig, (d.g.a.a)new h.a.i(paramContext, (v.f)localObject, paramLiveConfig, localf)) != null))
            {
              localObject = com.tencent.mm.live.core.core.a.b.gnC;
              if (!com.tencent.mm.live.core.core.a.b.a.aiN()) {
                continue;
              }
              localObject = com.tencent.mm.live.core.core.a.b.gnC;
              com.tencent.mm.live.core.core.a.b.a.ct(paramContext);
              if (paramLiveConfig != null)
              {
                long l = paramLiveConfig.ail();
                localObject = g.guG;
                if (l == g.akF().DMV) {}
              }
              else
              {
                localObject = g.guG;
                g.WN();
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
        ac.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(189828);
      return bool;
      localObject = null;
      continue;
      localObject = com.tencent.mm.live.core.core.c.b.gqt;
      if (com.tencent.mm.live.core.core.c.b.a.aiN())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gqt;
        com.tencent.mm.live.core.core.c.b.a.cu(paramContext);
      }
    }
  }
  
  public final boolean c(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(189830);
    k.h(paramContext, "context");
    for (;;)
    {
      try
      {
        Object localObject2 = a.guT;
        k.h(paramContext, "context");
        localObject1 = new v.f();
        ((v.f)localObject1).KUQ = paramContext.getResources().getString(2131755792);
        localObject2 = ((a)localObject2).k((d.g.a.a)new h.a.a(paramContext, (v.f)localObject1));
        if (localObject2 != null)
        {
          localObject2 = ((a)localObject2).j((d.g.a.a)new h.a.b(paramContext, (v.f)localObject1));
          if (localObject2 != null)
          {
            localObject2 = ((a)localObject2).l((d.g.a.a)new h.a.c(paramContext, (v.f)localObject1));
            if (localObject2 != null)
            {
              localObject1 = ((a)localObject2).a(paramLiveConfig, (d.g.a.a)new h.a.d(paramContext, (v.f)localObject1, paramLiveConfig));
              if (localObject1 != null)
              {
                localObject2 = (d.g.a.b)new h.a.e(paramContext, paramLiveConfig);
                Object localObject3 = com.tencent.mm.live.b.c.a.gxp;
                localObject3 = com.tencent.mm.live.b.c.a.alJ();
                if ((paramLiveConfig == null) || (paramLiveConfig.getScene() != LiveConfig.gmH) || (((bqa)localObject3).DMV == 0L)) {
                  continue;
                }
                ((d.g.a.b)localObject2).ay(localObject3);
                localObject1 = null;
                if (localObject1 != null)
                {
                  localObject1 = com.tencent.mm.live.core.core.a.b.gnC;
                  if (!com.tencent.mm.live.core.core.a.b.a.aiN()) {
                    continue;
                  }
                  localObject1 = com.tencent.mm.live.core.core.a.b.gnC;
                  com.tencent.mm.live.core.core.a.b.a.ct(paramContext);
                  if (paramLiveConfig != null)
                  {
                    long l = paramLiveConfig.ail();
                    localObject1 = g.guG;
                    if (l == g.akF().DMV) {}
                  }
                  else
                  {
                    localObject1 = g.guG;
                    g.WN();
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
        ac.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToAnchorUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(189830);
      return bool;
      continue;
      localObject1 = com.tencent.mm.live.core.core.c.b.gqt;
      if (com.tencent.mm.live.core.core.c.b.a.aiN())
      {
        localObject1 = com.tencent.mm.live.core.core.c.b.gqt;
        com.tencent.mm.live.core.core.c.b.a.cu(paramContext);
      }
    }
  }
  
  public final boolean d(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(189829);
    k.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUID"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtra("FROM_SENCE", 1);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.aeD(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ac.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToReplayUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(189829);
    return bool;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkAnchorLiving", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "errorCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "Lkotlin/ParameterName;", "name", "liveAnchorInfo", "", "checkIsUsePhone", "Lkotlin/Function0;", "checkLiveInfo", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"})
  public static final class a
  {
    public static final a guT;
    
    static
    {
      AppMethodBeat.i(189824);
      guT = new a();
      AppMethodBeat.o(189824);
    }
    
    final a a(LiveConfig paramLiveConfig, d.g.a.a<y> parama)
    {
      AppMethodBeat.i(189820);
      Object localObject1 = g.guG;
      int i;
      if (g.akF().DMV != 0L)
      {
        localObject1 = h.guS;
        String str = h.alz();
        localObject1 = new StringBuilder("curLiveId:");
        Object localObject2 = g.guG;
        localObject2 = ((StringBuilder)localObject1).append(g.akF().DMV).append(" newLiveId:");
        if (paramLiveConfig != null)
        {
          localObject1 = Long.valueOf(paramLiveConfig.ail());
          ac.i(str, localObject1);
          localObject1 = g.guG;
          if (!g.akT().guQ)
          {
            localObject1 = g.guG;
            if (!g.akT().guO) {
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
        AppMethodBeat.o(189820);
        return null;
        localObject1 = null;
        break;
        label147:
        if ((paramLiveConfig != null) && (paramLiveConfig.ail() == 0L))
        {
          localObject1 = g.guG;
          localObject1 = (CharSequence)g.akA();
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              localObject1 = g.guG;
              if (!bs.lr(g.akA(), paramLiveConfig.aij())) {}
            }
            else
            {
              if (paramLiveConfig.getScene() != LiveConfig.gmH) {
                break label259;
              }
            }
            i = 0;
            break;
          }
        }
        localObject1 = g.guG;
        long l = g.akF().DMV;
        if ((paramLiveConfig != null) && (l == paramLiveConfig.ail())) {
          label259:
          i = 1;
        } else {
          i = 0;
        }
      }
      label269:
      AppMethodBeat.o(189820);
      return this;
    }
    
    final a j(d.g.a.a<y> parama)
    {
      AppMethodBeat.i(189821);
      int i;
      try
      {
        Object localObject1 = ai.getContext().getSystemService("phone");
        if (localObject1 != null) {
          break label86;
        }
        localObject1 = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(189821);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      h localh = h.guS;
      ac.e(h.alz(), "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
      for (;;)
      {
        if (i != 0)
        {
          parama.invoke();
          AppMethodBeat.o(189821);
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
                localObject2 = h.guS;
                ac.i(h.alz(), "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
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
          AppMethodBeat.o(189821);
          return this;
        }
        i = 0;
      }
    }
    
    final a k(d.g.a.a<y> parama)
    {
      AppMethodBeat.i(189822);
      if (!ax.isConnected(ai.getContext()))
      {
        parama.invoke();
        AppMethodBeat.o(189822);
        return null;
      }
      AppMethodBeat.o(189822);
      return this;
    }
    
    final a l(d.g.a.a<y> parama)
    {
      AppMethodBeat.i(189823);
      vt localvt = new vt();
      localvt.dyB.dyD = true;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localvt);
      if (!bs.isNullOrNil(localvt.dyC.dyF))
      {
        parama.invoke();
        AppMethodBeat.o(189823);
        return null;
      }
      AppMethodBeat.o(189823);
      return this;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(Context paramContext, v.f paramf)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(Context paramContext, v.f paramf)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(Context paramContext, v.f paramf)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(Context paramContext, v.f paramf, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "liveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.b<bqa, y>
    {
      e(Context paramContext, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      f(Context paramContext, v.f paramf)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      g(Context paramContext, v.f paramf)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class h
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      h(Context paramContext, v.f paramf)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class i
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      i(Context paramContext, v.f paramf1, LiveConfig paramLiveConfig, v.f paramf2)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(com.tencent.mm.ui.widget.a.g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(com.tencent.mm.ui.widget.a.g paramg, Context paramContext, LiveConfig paramLiveConfig)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.h
 * JD-Core Version:    0.7.0.1
 */