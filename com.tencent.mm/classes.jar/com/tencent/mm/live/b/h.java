package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.c.c;
import com.tencent.mm.live.ui.dialog.LiveVisitorGuideView;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"})
public final class h
  implements com.tencent.mm.live.api.a
{
  private static final String TAG = "MicroMsg.LiveEntranceJumper";
  public static final h gRl;
  
  static
  {
    AppMethodBeat.i(215739);
    gRl = new h();
    TAG = "MicroMsg.LiveEntranceJumper";
    AppMethodBeat.o(215739);
  }
  
  private static void e(final Context paramContext, final LiveConfig paramLiveConfig)
  {
    int j = 1;
    AppMethodBeat.i(215736);
    Object localObject1 = g.gQZ;
    g.aoz();
    Object localObject2;
    if (bv.fpT())
    {
      localObject1 = f.e.gPU;
      localObject1 = ay.aRX(f.e.anq());
      localObject2 = f.g.gQa;
      if (((ay)localObject1).getBoolean(f.g.anw(), false))
      {
        i = 1;
        localObject1 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).ajA().get(6);
        if (localObject1 != null) {
          break label245;
        }
        localObject1 = null;
        label85:
        if (i == 0) {
          break label255;
        }
        if (paramLiveConfig != null) {
          LiveConfig.dE(false);
        }
        label97:
        localObject1 = g.gQZ;
        if (!g.anX().gRc) {
          break label336;
        }
        localObject1 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject1, "MMKernel.storage()");
        if (((e)localObject1).ajA().getInt(am.a.Jel, 1) != 1) {
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
      ((com.tencent.mm.ui.widget.a.g)localObject1).setHeight(ar.ck(paramContext).y * 3 / 4);
      localObject2 = new LiveVisitorGuideView(paramContext);
      ((LiveVisitorGuideView)localObject2).setOnHideListener((d.g.a.a)new b((com.tencent.mm.ui.widget.a.g)localObject1));
      ((LiveVisitorGuideView)localObject2).setOnOkListener((d.g.a.a)new c((com.tencent.mm.ui.widget.a.g)localObject1, paramContext, paramLiveConfig));
      ((com.tencent.mm.ui.widget.a.g)localObject1).setCustomView((View)localObject2);
      ((com.tencent.mm.ui.widget.a.g)localObject1).cPF();
      AppMethodBeat.o(215736);
      return;
      i = 0;
      break;
      label245:
      localObject1 = (String)localObject1;
      break label85;
      label255:
      localObject2 = g.gQZ;
      if (g.anX().gRb)
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
          LiveConfig.dE(true);
          break;
        }
      }
      if (paramLiveConfig == null) {
        break label97;
      }
      LiveConfig.dE(false);
      break label97;
    }
    label325:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(215736);
    return;
    label336:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(215736);
  }
  
  private static void f(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215737);
    if (paramLiveConfig != null) {
      c.getLiveTipsBarStorage().v(paramLiveConfig.alk(), paramLiveConfig.alm());
    }
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahE(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(215737);
  }
  
  private static void g(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215738);
    Object localObject = g.gQZ;
    g.aoz();
    localObject = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    ((Intent)localObject).putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    ((Intent)localObject).addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahE(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(215738);
  }
  
  public final boolean a(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215732);
    p.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahE(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        ae.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(215732);
    return bool;
  }
  
  public final boolean b(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215733);
    p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        a locala = a.gRm;
        p.h(paramContext, "context");
        y.f localf = new y.f();
        localObject = paramContext.getResources();
        if (localObject == null) {
          continue;
        }
        localObject = ((Resources)localObject).getString(2131766655);
        localf.NiY = localObject;
        localObject = new y.f();
        ((y.f)localObject).NiY = paramContext.getResources().getString(2131755792);
        locala = locala.l((d.g.a.a)new h.a.f(paramContext, (y.f)localObject));
        if (locala != null)
        {
          locala = locala.k((d.g.a.a)new h.a.g(paramContext, (y.f)localObject));
          if (locala != null)
          {
            locala = locala.m((d.g.a.a)new h.a.h(paramContext, (y.f)localObject));
            if ((locala != null) && (locala.a(paramLiveConfig, (d.g.a.a)new h.a.i(paramContext, (y.f)localObject, paramLiveConfig, localf)) != null))
            {
              localObject = com.tencent.mm.live.core.core.a.b.gJU;
              if (!com.tencent.mm.live.core.core.a.b.a.alO()) {
                continue;
              }
              localObject = com.tencent.mm.live.core.core.a.b.gJU;
              com.tencent.mm.live.core.core.a.b.a.cs(paramContext);
              if (paramLiveConfig != null)
              {
                long l = paramLiveConfig.alm();
                localObject = g.gQZ;
                if (l == g.anH().FKy) {}
              }
              else
              {
                localObject = g.gQZ;
                g.Zq();
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
        ae.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(215733);
      return bool;
      localObject = null;
      continue;
      localObject = com.tencent.mm.live.core.core.c.b.gMM;
      if (com.tencent.mm.live.core.core.c.b.a.alO())
      {
        localObject = com.tencent.mm.live.core.core.c.b.gMM;
        com.tencent.mm.live.core.core.c.b.a.ct(paramContext);
      }
    }
  }
  
  public final boolean c(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215735);
    p.h(paramContext, "context");
    for (;;)
    {
      try
      {
        Object localObject2 = a.gRm;
        p.h(paramContext, "context");
        localObject1 = new y.f();
        ((y.f)localObject1).NiY = paramContext.getResources().getString(2131755792);
        localObject2 = ((a)localObject2).l((d.g.a.a)new h.a.a(paramContext, (y.f)localObject1));
        if (localObject2 != null)
        {
          localObject2 = ((a)localObject2).k((d.g.a.a)new h.a.b(paramContext, (y.f)localObject1));
          if (localObject2 != null)
          {
            localObject2 = ((a)localObject2).m((d.g.a.a)new h.a.c(paramContext, (y.f)localObject1));
            if (localObject2 != null)
            {
              localObject1 = ((a)localObject2).a(paramLiveConfig, (d.g.a.a)new h.a.d(paramContext, (y.f)localObject1, paramLiveConfig));
              if (localObject1 != null)
              {
                localObject2 = (d.g.a.b)new h.a.e(paramContext, paramLiveConfig);
                Object localObject3 = com.tencent.mm.live.b.c.a.gTI;
                localObject3 = com.tencent.mm.live.b.c.a.aoL();
                if ((paramLiveConfig == null) || (paramLiveConfig.getScene() != LiveConfig.gIZ) || (((bvh)localObject3).FKy == 0L)) {
                  continue;
                }
                ((d.g.a.b)localObject2).invoke(localObject3);
                localObject1 = null;
                if (localObject1 != null)
                {
                  localObject1 = com.tencent.mm.live.core.core.a.b.gJU;
                  if (!com.tencent.mm.live.core.core.a.b.a.alO()) {
                    continue;
                  }
                  localObject1 = com.tencent.mm.live.core.core.a.b.gJU;
                  com.tencent.mm.live.core.core.a.b.a.cs(paramContext);
                  if (paramLiveConfig != null)
                  {
                    long l = paramLiveConfig.alm();
                    localObject1 = g.gQZ;
                    if (l == g.anH().FKy) {}
                  }
                  else
                  {
                    localObject1 = g.gQZ;
                    g.Zq();
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
        ae.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToAnchorUI failed!", new Object[0]);
        boolean bool = false;
        continue;
      }
      AppMethodBeat.o(215735);
      return bool;
      continue;
      localObject1 = com.tencent.mm.live.core.core.c.b.gMM;
      if (com.tencent.mm.live.core.core.c.b.a.alO())
      {
        localObject1 = com.tencent.mm.live.core.core.c.b.gMM;
        com.tencent.mm.live.core.core.c.b.a.ct(paramContext);
      }
    }
  }
  
  public final boolean d(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(215734);
    p.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUID"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtra("FROM_SENCE", 1);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.ahE(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ae.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToReplayUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(215734);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkAnchorLiving", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "errorCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "Lkotlin/ParameterName;", "name", "liveAnchorInfo", "", "checkIsUsePhone", "Lkotlin/Function0;", "checkLiveInfo", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"})
  public static final class a
  {
    public static final a gRm;
    
    static
    {
      AppMethodBeat.i(215729);
      gRm = new a();
      AppMethodBeat.o(215729);
    }
    
    final a a(LiveConfig paramLiveConfig, d.g.a.a<z> parama)
    {
      AppMethodBeat.i(215725);
      Object localObject1 = g.gQZ;
      int i;
      if (g.anH().FKy != 0L)
      {
        localObject1 = h.gRl;
        String str = h.aoB();
        localObject1 = new StringBuilder("curLiveId:");
        Object localObject2 = g.gQZ;
        localObject2 = ((StringBuilder)localObject1).append(g.anH().FKy).append(" newLiveId:");
        if (paramLiveConfig != null)
        {
          localObject1 = Long.valueOf(paramLiveConfig.alm());
          ae.i(str, localObject1);
          localObject1 = g.gQZ;
          if (!g.anV().gRj)
          {
            localObject1 = g.gQZ;
            if (!g.anV().gRh) {
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
        AppMethodBeat.o(215725);
        return null;
        localObject1 = null;
        break;
        label147:
        if ((paramLiveConfig != null) && (paramLiveConfig.alm() == 0L))
        {
          localObject1 = g.gQZ;
          localObject1 = (CharSequence)g.anC();
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              localObject1 = g.gQZ;
              if (!bu.lX(g.anC(), paramLiveConfig.alk())) {}
            }
            else
            {
              if (paramLiveConfig.getScene() != LiveConfig.gIZ) {
                break label259;
              }
            }
            i = 0;
            break;
          }
        }
        localObject1 = g.gQZ;
        long l = g.anH().FKy;
        if ((paramLiveConfig != null) && (l == paramLiveConfig.alm())) {
          label259:
          i = 1;
        } else {
          i = 0;
        }
      }
      label269:
      AppMethodBeat.o(215725);
      return this;
    }
    
    final a k(d.g.a.a<z> parama)
    {
      AppMethodBeat.i(215726);
      int i;
      try
      {
        Object localObject1 = ak.getContext().getSystemService("phone");
        if (localObject1 != null) {
          break label86;
        }
        localObject1 = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(215726);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      h localh = h.gRl;
      ae.e(h.aoB(), "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
      for (;;)
      {
        if (i != 0)
        {
          parama.invoke();
          AppMethodBeat.o(215726);
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
                localObject2 = h.gRl;
                ae.i(h.aoB(), "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
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
          AppMethodBeat.o(215726);
          return this;
        }
        i = 0;
      }
    }
    
    final a l(d.g.a.a<z> parama)
    {
      AppMethodBeat.i(215727);
      if (!az.isConnected(ak.getContext()))
      {
        parama.invoke();
        AppMethodBeat.o(215727);
        return null;
      }
      AppMethodBeat.o(215727);
      return this;
    }
    
    final a m(d.g.a.a<z> parama)
    {
      AppMethodBeat.i(215728);
      wq localwq = new wq();
      localwq.dMc.dMe = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localwq);
      if (!bu.isNullOrNil(localwq.dMd.dMg))
      {
        parama.invoke();
        AppMethodBeat.o(215728);
        return null;
      }
      AppMethodBeat.o(215728);
      return this;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(Context paramContext, y.f paramf, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "liveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "invoke"})
    static final class e
      extends q
      implements d.g.a.b<bvh, z>
    {
      e(Context paramContext, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(com.tencent.mm.ui.widget.a.g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.b.h
 * JD-Core Version:    0.7.0.1
 */