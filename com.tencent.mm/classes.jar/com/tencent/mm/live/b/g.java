package com.tencent.mm.live.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.ui.dialog.LiveVisitorGuideView;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
import d.g.b.v.e;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"})
public final class g
  implements com.tencent.mm.live.api.a
{
  private static final String TAG = "MicroMsg.LiveEntranceJumper";
  public static final g ssa;
  
  static
  {
    AppMethodBeat.i(202647);
    ssa = new g();
    TAG = "MicroMsg.LiveEntranceJumper";
    AppMethodBeat.o(202647);
  }
  
  private static void e(final Context paramContext, final LiveConfig paramLiveConfig)
  {
    int j = 1;
    AppMethodBeat.i(202644);
    Object localObject1 = f.rGw;
    f.fOC();
    Object localObject2;
    if (bu.eGT())
    {
      localObject1 = e.e.rBl;
      localObject1 = ax.aFD(e.e.equ());
      localObject2 = e.g.rFz;
      if (((ax)localObject1).getBoolean(e.g.eNd(), false))
      {
        i = 1;
        localObject1 = com.tencent.mm.kernel.g.afB();
        k.g(localObject1, "MMKernel.storage()");
        localObject1 = ((e)localObject1).afk().get(6);
        if (localObject1 != null) {
          break label227;
        }
        localObject1 = null;
        label85:
        if (i == 0) {
          break label237;
        }
        if (paramLiveConfig != null) {
          LiveConfig.hy(false);
        }
        label97:
        localObject1 = f.rGw;
        if (!f.fhI().rGz) {
          break label318;
        }
        localObject1 = com.tencent.mm.kernel.g.afB();
        k.g(localObject1, "MMKernel.storage()");
        if (((e)localObject1).afk().getInt(ae.a.LBJ, 1) != 1) {
          break label302;
        }
      }
    }
    label286:
    label291:
    label302:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label307;
      }
      localObject1 = new com.tencent.mm.live.ui.dialog.b(paramContext);
      localObject2 = new LiveVisitorGuideView(paramContext);
      ((LiveVisitorGuideView)localObject2).setOnHideListener((d.g.a.a)new b((com.tencent.mm.live.ui.dialog.b)localObject1));
      ((LiveVisitorGuideView)localObject2).setOnOkListener((d.g.a.a)new c((com.tencent.mm.live.ui.dialog.b)localObject1, paramContext, paramLiveConfig));
      ((com.tencent.mm.live.ui.dialog.b)localObject1).setContentView((View)localObject2);
      ((com.tencent.mm.live.ui.dialog.b)localObject1).show();
      AppMethodBeat.o(202644);
      return;
      i = 0;
      break;
      label227:
      localObject1 = (String)localObject1;
      break label85;
      label237:
      localObject2 = f.rGw;
      if (f.fhI().rGy)
      {
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() != 0) {
            break label286;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label291;
          }
          if (paramLiveConfig == null) {
            break;
          }
          LiveConfig.hy(true);
          break;
        }
      }
      if (paramLiveConfig == null) {
        break label97;
      }
      LiveConfig.hy(false);
      break label97;
    }
    label307:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(202644);
    return;
    label318:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(202644);
  }
  
  private static void f(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202645);
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.adn(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(202645);
  }
  
  private static void g(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202646);
    Object localObject = f.rGw;
    f.fOC();
    localObject = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    ((Intent)localObject).putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    ((Intent)localObject).addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.adn(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(202646);
  }
  
  public final boolean a(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202640);
    k.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.adn(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.lS(0));
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
    AppMethodBeat.o(202640);
    return bool;
  }
  
  public final boolean b(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202641);
    k.h(paramContext, "context");
    for (;;)
    {
      try
      {
        a locala = a.sAX;
        k.h(paramContext, "context");
        v.e locale = new v.e();
        localObject = paramContext.getResources();
        if (localObject == null) {
          continue;
        }
        localObject = ((Resources)localObject).getString(2131766620);
        locale.Jhw = localObject;
        localObject = new v.e();
        ((v.e)localObject).Jhw = paramContext.getResources().getString(2131755792);
        locala = locala.O((d.g.a.a)new g.a.e(paramContext, (v.e)localObject));
        if (locala != null)
        {
          locala = locala.N((d.g.a.a)new g.a.f(paramContext, (v.e)localObject));
          if (locala != null)
          {
            locala = locala.P((d.g.a.a)new g.a.g(paramContext, (v.e)localObject));
            if ((locala != null) && (locala.a(paramLiveConfig, (d.g.a.a)new g.a.h(paramContext, (v.e)localObject, paramLiveConfig, locale)) != null)) {
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
      AppMethodBeat.o(202641);
      return bool;
      localObject = null;
    }
  }
  
  public final boolean c(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202643);
    k.h(paramContext, "context");
    try
    {
      a locala = a.sAX;
      k.h(paramContext, "context");
      v.e locale = new v.e();
      locale.Jhw = paramContext.getResources().getString(2131755792);
      locala = locala.O((d.g.a.a)new g.a.a(paramContext, locale));
      if (locala != null)
      {
        locala = locala.N((d.g.a.a)new g.a.b(paramContext, locale));
        if (locala != null)
        {
          locala = locala.P((d.g.a.a)new g.a.c(paramContext, locale));
          if ((locala != null) && (locala.a(paramLiveConfig, (d.g.a.a)new g.a.d(paramContext, locale, paramLiveConfig)) != null)) {
            g(paramContext, paramLiveConfig);
          }
        }
      }
      bool = true;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToAnchorUI failed!", new Object[0]);
        boolean bool = false;
      }
    }
    AppMethodBeat.o(202643);
    return bool;
  }
  
  public final boolean d(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(202642);
    k.h(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUID"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtra("FROM_SENCE", 1);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLiveConfig.adn(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.lS(0));
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
    AppMethodBeat.o(202642);
    return bool;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkIsUsePhone", "errorCallback", "Lkotlin/Function0;", "", "checkLiveInfo", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"})
  public static final class a
  {
    public static final a sAX;
    
    static
    {
      AppMethodBeat.i(202637);
      sAX = new a();
      AppMethodBeat.o(202637);
    }
    
    final a N(d.g.a.a<y> parama)
    {
      AppMethodBeat.i(202634);
      int i;
      try
      {
        Object localObject1 = aj.getContext().getSystemService("phone");
        if (localObject1 != null) {
          break label86;
        }
        localObject1 = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(202634);
        throw ((Throwable)localObject1);
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      g localg = g.ssa;
      ad.e(g.fOD(), "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
      for (;;)
      {
        if (i != 0)
        {
          parama.invoke();
          AppMethodBeat.o(202634);
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
                localObject2 = g.ssa;
                ad.i(g.fOD(), "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
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
          AppMethodBeat.o(202634);
          return this;
        }
        i = 0;
      }
    }
    
    final a O(d.g.a.a<y> parama)
    {
      AppMethodBeat.i(202635);
      if (!ay.isConnected(aj.getContext()))
      {
        parama.invoke();
        AppMethodBeat.o(202635);
        return null;
      }
      AppMethodBeat.o(202635);
      return this;
    }
    
    final a P(d.g.a.a<y> parama)
    {
      AppMethodBeat.i(202636);
      vj localvj = new vj();
      localvj.dAP.dAR = true;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localvj);
      if (!bt.isNullOrNil(localvj.dAQ.dAT))
      {
        parama.invoke();
        AppMethodBeat.o(202636);
        return null;
      }
      AppMethodBeat.o(202636);
      return this;
    }
    
    final a a(LiveConfig paramLiveConfig, d.g.a.a<y> parama)
    {
      AppMethodBeat.i(202633);
      Object localObject1 = f.rGw;
      int i;
      if (f.eNG().LwA != 0L)
      {
        localObject1 = g.ssa;
        String str = g.fOD();
        localObject1 = new StringBuilder("curLiveId:");
        Object localObject2 = f.rGw;
        localObject2 = ((StringBuilder)localObject1).append(f.eNG().LwA).append(" newLiveId:");
        if (paramLiveConfig != null)
        {
          localObject1 = Long.valueOf(paramLiveConfig.ckB());
          ad.i(str, localObject1);
          if ((paramLiveConfig == null) || (paramLiveConfig.ckB() != 0L)) {
            break label199;
          }
          localObject1 = f.rGw;
          localObject1 = (CharSequence)f.eNB();
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label194;
          }
          i = 1;
          label136:
          if (i == 0)
          {
            localObject1 = f.rGw;
            if (!bt.kU(f.eNB(), paramLiveConfig.ckA())) {}
          }
          else
          {
            if (paramLiveConfig.getScene() != LiveConfig.qsG) {
              break label226;
            }
          }
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label236;
        }
        parama.invoke();
        AppMethodBeat.o(202633);
        return null;
        localObject1 = null;
        break;
        label194:
        i = 0;
        break label136;
        label199:
        localObject1 = f.rGw;
        long l = f.eNG().LwA;
        if ((paramLiveConfig != null) && (l == paramLiveConfig.ckB())) {
          label226:
          i = 1;
        } else {
          i = 0;
        }
      }
      label236:
      AppMethodBeat.o(202633);
      return this;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(Context paramContext, v.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(Context paramContext, v.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      c(Context paramContext, v.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(Context paramContext, v.e parame, LiveConfig paramLiveConfig)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class e
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      e(Context paramContext, v.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class f
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      f(Context paramContext, v.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class g
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      g(Context paramContext, v.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class h
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      h(Context paramContext, v.e parame1, LiveConfig paramLiveConfig, v.e parame2)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(com.tencent.mm.live.ui.dialog.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(com.tencent.mm.live.ui.dialog.b paramb, Context paramContext, LiveConfig paramLiveConfig)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.g
 * JD-Core Version:    0.7.0.1
 */