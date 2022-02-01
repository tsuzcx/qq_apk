package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.live.ui.dialog.LiveVisitorGuideView;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"})
public final class h
  implements com.tencent.mm.live.api.a
{
  private static final String TAG = "MicroMsg.LiveEntranceJumper";
  public static final h gOD;
  
  static
  {
    AppMethodBeat.i(212120);
    gOD = new h();
    TAG = "MicroMsg.LiveEntranceJumper";
    AppMethodBeat.o(212120);
  }
  
  private static void e(final Context paramContext, final LiveConfig paramLiveConfig)
  {
    int j = 1;
    AppMethodBeat.i(212117);
    Object localObject1 = g.gOr;
    g.aok();
    Object localObject2;
    if (bu.flY())
    {
      localObject1 = f.e.gNl;
      localObject1 = ax.aQA(f.e.anb());
      localObject2 = f.g.gNr;
      if (((ax)localObject1).getBoolean(f.g.ang(), false))
      {
        i = 1;
        localObject1 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).ajl().get(6);
        if (localObject1 != null) {
          break label245;
        }
        localObject1 = null;
        label85:
        if (i == 0) {
          break label255;
        }
        if (paramLiveConfig != null) {
          LiveConfig.dD(false);
        }
        label97:
        localObject1 = g.gOr;
        if (!g.anI().gOu) {
          break label336;
        }
        localObject1 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject1, "MMKernel.storage()");
        if (((e)localObject1).ajl().getInt(al.a.IJF, 1) != 1) {
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
      ((com.tencent.mm.ui.widget.a.g)localObject1).setHeight(ar.ci(paramContext).y * 3 / 4);
      localObject2 = new LiveVisitorGuideView(paramContext);
      ((LiveVisitorGuideView)localObject2).setOnHideListener((d.g.a.a)new b((com.tencent.mm.ui.widget.a.g)localObject1));
      ((LiveVisitorGuideView)localObject2).setOnOkListener((d.g.a.a)new c((com.tencent.mm.ui.widget.a.g)localObject1, paramContext, paramLiveConfig));
      ((com.tencent.mm.ui.widget.a.g)localObject1).setCustomView((View)localObject2);
      ((com.tencent.mm.ui.widget.a.g)localObject1).cMW();
      AppMethodBeat.o(212117);
      return;
      i = 0;
      break;
      label245:
      localObject1 = (String)localObject1;
      break label85;
      label255:
      localObject2 = g.gOr;
      if (g.anI().gOt)
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
          LiveConfig.dD(true);
          break;
        }
      }
      if (paramLiveConfig == null) {
        break label97;
      }
      LiveConfig.dD(false);
      break label97;
    }
    label325:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(212117);
    return;
    label336:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(212117);
  }
  
  private static void f(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212118);
    if (paramLiveConfig != null) {
      c.getLiveTipsBarStorage().v(paramLiveConfig.akV(), paramLiveConfig.akX());
    }
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahp(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(212118);
  }
  
  private static void g(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212119);
    Object localObject = g.gOr;
    g.aok();
    localObject = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    ((Intent)localObject).putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    ((Intent)localObject).addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahp(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(212119);
  }
  
  public final boolean a(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212113);
    p.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahp(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(212113);
    return bool;
  }
  
  public final boolean b(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212114);
    p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        a locala = a.gOE;
        p.h(paramContext, "context");
        y.f localf = new y.f();
        localObject = paramContext.getResources();
        if (localObject == null) {
          continue;
        }
        localObject = ((Resources)localObject).getString(2131766655);
        localf.MLV = localObject;
        localObject = new y.f();
        ((y.f)localObject).MLV = paramContext.getResources().getString(2131755792);
        locala = locala.k((d.g.a.a)new h.a.f(paramContext, (y.f)localObject));
        if (locala != null)
        {
          locala = locala.j((d.g.a.a)new h.a.g(paramContext, (y.f)localObject));
          if (locala != null)
          {
            locala = locala.l((d.g.a.a)new h.a.h(paramContext, (y.f)localObject));
            if ((locala != null) && (locala.a(paramLiveConfig, (d.g.a.a)new h.a.i(paramContext, (y.f)localObject, paramLiveConfig, localf)) != null))
            {
              localObject = com.tencent.mm.live.core.core.a.b.gHl;
              if (!com.tencent.mm.live.core.core.a.b.a.alz()) {
                continue;
              }
              localObject = com.tencent.mm.live.core.core.a.b.gHl;
              com.tencent.mm.live.core.core.a.b.a.cq(paramContext);
              if (paramLiveConfig != null)
              {
                long l = paramLiveConfig.akX();
                localObject = g.gOr;
                if (l == g.ans().Fsa) {}
              }
              else
              {
                localObject = g.gOr;
                g.Zh();
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
        ad.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(212114);
      return bool;
      localObject = null;
      continue;
      localObject = com.tencent.mm.live.core.core.c.b.gKd;
      if (com.tencent.mm.live.core.core.c.b.a.alz())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gKd;
        com.tencent.mm.live.core.core.c.b.a.cr(paramContext);
      }
    }
  }
  
  public final boolean c(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212116);
    p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        Object localObject2 = a.gOE;
        p.h(paramContext, "context");
        localObject1 = new y.f();
        ((y.f)localObject1).MLV = paramContext.getResources().getString(2131755792);
        localObject2 = ((a)localObject2).k((d.g.a.a)new h.a.a(paramContext, (y.f)localObject1));
        if (localObject2 != null)
        {
          localObject2 = ((a)localObject2).j((d.g.a.a)new h.a.b(paramContext, (y.f)localObject1));
          if (localObject2 != null)
          {
            localObject2 = ((a)localObject2).l((d.g.a.a)new h.a.c(paramContext, (y.f)localObject1));
            if (localObject2 != null)
            {
              localObject1 = ((a)localObject2).a(paramLiveConfig, (d.g.a.a)new h.a.d(paramContext, (y.f)localObject1, paramLiveConfig));
              if (localObject1 != null)
              {
                localObject2 = (d.g.a.b)new h.a.e(paramContext, paramLiveConfig);
                Object localObject3 = com.tencent.mm.live.b.c.a.gRa;
                localObject3 = com.tencent.mm.live.b.c.a.aow();
                if ((paramLiveConfig == null) || (paramLiveConfig.getScene() != LiveConfig.gGq) || (((bun)localObject3).Fsa == 0L)) {
                  continue;
                }
                ((d.g.a.b)localObject2).invoke(localObject3);
                localObject1 = null;
                if (localObject1 != null)
                {
                  localObject1 = com.tencent.mm.live.core.core.a.b.gHl;
                  if (!com.tencent.mm.live.core.core.a.b.a.alz()) {
                    continue;
                  }
                  localObject1 = com.tencent.mm.live.core.core.a.b.gHl;
                  com.tencent.mm.live.core.core.a.b.a.cq(paramContext);
                  if (paramLiveConfig != null)
                  {
                    long l = paramLiveConfig.akX();
                    localObject1 = g.gOr;
                    if (l == g.ans().Fsa) {}
                  }
                  else
                  {
                    localObject1 = g.gOr;
                    g.Zh();
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
        ad.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToAnchorUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(212116);
      return bool;
      continue;
      localObject1 = com.tencent.mm.live.core.core.c.b.gKd;
      if (com.tencent.mm.live.core.core.c.b.a.alz())
      {
        localObject1 = com.tencent.mm.live.core.core.c.b.gKd;
        com.tencent.mm.live.core.core.c.b.a.cr(paramContext);
      }
    }
  }
  
  public final boolean d(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(212115);
    p.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUID"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtra("FROM_SENCE", 1);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahp(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToReplayUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(212115);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkAnchorLiving", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "errorCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "Lkotlin/ParameterName;", "name", "liveAnchorInfo", "", "checkIsUsePhone", "Lkotlin/Function0;", "checkLiveInfo", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"})
  public static final class a
  {
    public static final a gOE;
    
    static
    {
      AppMethodBeat.i(212110);
      gOE = new a();
      AppMethodBeat.o(212110);
    }
    
    final a a(LiveConfig paramLiveConfig, d.g.a.a<z> parama)
    {
      AppMethodBeat.i(212106);
      Object localObject1 = g.gOr;
      int i;
      if (g.ans().Fsa != 0L)
      {
        localObject1 = h.gOD;
        String str = h.aom();
        localObject1 = new StringBuilder("curLiveId:");
        Object localObject2 = g.gOr;
        localObject2 = ((StringBuilder)localObject1).append(g.ans().Fsa).append(" newLiveId:");
        if (paramLiveConfig != null)
        {
          localObject1 = Long.valueOf(paramLiveConfig.akX());
          ad.i(str, localObject1);
          localObject1 = g.gOr;
          if (!g.anG().gOB)
          {
            localObject1 = g.gOr;
            if (!g.anG().gOz) {
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
        AppMethodBeat.o(212106);
        return null;
        localObject1 = null;
        break;
        label147:
        if ((paramLiveConfig != null) && (paramLiveConfig.akX() == 0L))
        {
          localObject1 = g.gOr;
          localObject1 = (CharSequence)g.anm();
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              localObject1 = g.gOr;
              if (!bt.lQ(g.anm(), paramLiveConfig.akV())) {}
            }
            else
            {
              if (paramLiveConfig.getScene() != LiveConfig.gGq) {
                break label259;
              }
            }
            i = 0;
            break;
          }
        }
        localObject1 = g.gOr;
        long l = g.ans().Fsa;
        if ((paramLiveConfig != null) && (l == paramLiveConfig.akX())) {
          label259:
          i = 1;
        } else {
          i = 0;
        }
      }
      label269:
      AppMethodBeat.o(212106);
      return this;
    }
    
    final a j(d.g.a.a<z> parama)
    {
      AppMethodBeat.i(212107);
      int i;
      try
      {
        Object localObject1 = aj.getContext().getSystemService("phone");
        if (localObject1 != null) {
          break label86;
        }
        localObject1 = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(212107);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      h localh = h.gOD;
      ad.e(h.aom(), "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
      for (;;)
      {
        if (i != 0)
        {
          parama.invoke();
          AppMethodBeat.o(212107);
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
                localObject2 = h.gOD;
                ad.i(h.aom(), "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
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
          AppMethodBeat.o(212107);
          return this;
        }
        i = 0;
      }
    }
    
    final a k(d.g.a.a<z> parama)
    {
      AppMethodBeat.i(212108);
      if (!ay.isConnected(aj.getContext()))
      {
        parama.invoke();
        AppMethodBeat.o(212108);
        return null;
      }
      AppMethodBeat.o(212108);
      return this;
    }
    
    final a l(d.g.a.a<z> parama)
    {
      AppMethodBeat.i(212109);
      wm localwm = new wm();
      localwm.dKN.dKP = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localwm);
      if (!bt.isNullOrNil(localwm.dKO.dKR))
      {
        parama.invoke();
        AppMethodBeat.o(212109);
        return null;
      }
      AppMethodBeat.o(212109);
      return this;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(Context paramContext, y.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(Context paramContext, y.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<z>
    {
      c(Context paramContext, y.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(Context paramContext, y.f paramf, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "liveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "invoke"})
    static final class e
      extends q
      implements d.g.a.b<bun, z>
    {
      e(Context paramContext, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class f
      extends q
      implements d.g.a.a<z>
    {
      f(Context paramContext, y.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class g
      extends q
      implements d.g.a.a<z>
    {
      g(Context paramContext, y.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class h
      extends q
      implements d.g.a.a<z>
    {
      h(Context paramContext, y.f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class i
      extends q
      implements d.g.a.a<z>
    {
      i(Context paramContext, y.f paramf1, LiveConfig paramLiveConfig, y.f paramf2)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(com.tencent.mm.ui.widget.a.g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
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