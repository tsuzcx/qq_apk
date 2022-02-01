package com.tencent.mm.live.model;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.api.LiveConfig.a;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.f.d;
import com.tencent.mm.live.core.core.f.d.a;
import com.tencent.mm.live.model.c.c;
import com.tencent.mm.live.ui.dialog.LiveVisitorGuideView;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl;", "Lcom/tencent/mm/live/api/ILiveEntranceJumper;", "()V", "TAG", "", "gotoAnchorLive", "", "context", "Landroid/content/Context;", "configProvider", "Lcom/tencent/mm/live/api/LiveConfig;", "gotoVisitLive", "jumpToAnchorUI", "", "jumpToEntranceUI", "jumpToLiveUIA", "jumpToReplayUI", "jumpToVisitorUI", "LiveChecker", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements com.tencent.mm.live.api.a
{
  private static final String TAG;
  public static final m mYT;
  
  static
  {
    AppMethodBeat.i(246629);
    mYT = new m();
    TAG = "MicroMsg.LiveEntranceJumper";
    AppMethodBeat.o(246629);
  }
  
  private static void e(Context paramContext, LiveConfig paramLiveConfig)
  {
    int j = 1;
    AppMethodBeat.i(246579);
    Object localObject1;
    Object localObject2;
    if (WeChatEnvironment.hasDebugger())
    {
      localObject1 = l.e.mYs;
      localObject1 = MultiProcessMMKV.getSingleMMKV(l.e.bhu());
      localObject2 = l.g.mYB;
      if (((MultiProcessMMKV)localObject1).getBoolean(l.g.bhA(), false))
      {
        i = 1;
        localObject1 = h.baE().ban().d(6, null);
        if (localObject1 != null) {
          break label216;
        }
        localObject1 = null;
        label67:
        if (i == 0) {
          break label226;
        }
        if (paramLiveConfig != null) {
          LiveConfig.fC(false);
        }
        label79:
        localObject1 = u.mZl;
        if (!u.bis().nad) {
          break label307;
        }
        if (h.baE().ban().getInt(at.a.adgd, 1) != 1) {
          break label291;
        }
      }
    }
    label275:
    label280:
    label291:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label296;
      }
      localObject1 = new j(paramContext, 0, 0);
      ((j)localObject1).setHeight(bf.bf(paramContext).y * 3 / 4);
      localObject2 = new LiveVisitorGuideView(paramContext);
      ((LiveVisitorGuideView)localObject2).setOnHideListener((kotlin.g.a.a)new m.b((j)localObject1));
      ((LiveVisitorGuideView)localObject2).setOnOkListener((kotlin.g.a.a)new m.c((j)localObject1, paramContext, paramLiveConfig));
      ((j)localObject1).setCustomView((View)localObject2);
      ((j)localObject1).dDn();
      AppMethodBeat.o(246579);
      return;
      i = 0;
      break;
      label216:
      localObject1 = (String)localObject1;
      break label67;
      label226:
      localObject2 = u.mZl;
      if (u.bis().nac)
      {
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() != 0) {
            break label275;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label280;
          }
          if (paramLiveConfig == null) {
            break;
          }
          LiveConfig.fC(true);
          break;
        }
      }
      if (paramLiveConfig == null) {
        break label79;
      }
      LiveConfig.fC(false);
      break label79;
    }
    label296:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(246579);
    return;
    label307:
    f(paramContext, paramLiveConfig);
    AppMethodBeat.o(246579);
  }
  
  private static void f(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(246593);
    if (paramLiveConfig != null) {
      c.getLiveTipsBarStorage().u(paramLiveConfig.mIz, paramLiveConfig.liveId);
    }
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aYi(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToLiveUIA", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(246593);
  }
  
  private static void g(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(246604);
    Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIA"));
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
    localIntent.addFlags(268435456);
    paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aYi(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramLiveConfig.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/live/model/LiveEntranceJumperImpl", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(246604);
  }
  
  public final boolean a(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(246637);
    s.u(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUIF"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aYi(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToEntranceUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.sb(0));
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
    AppMethodBeat.o(246637);
    return bool;
  }
  
  public final boolean b(Context paramContext, LiveConfig paramLiveConfig)
  {
    Object localObject2 = null;
    AppMethodBeat.i(246650);
    s.u(paramContext, "context");
    for (;;)
    {
      try
      {
        a locala = a.mYU;
        s.u(paramContext, "context");
        ah.f localf1 = new ah.f();
        localObject1 = paramContext.getResources();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        localf1.aqH = localObject1;
        ah.f localf2 = new ah.f();
        localObject1 = paramContext.getResources().getString(b.h.app_i_know);
        s.s(localObject1, "context.resources.getString(R.string.app_i_know)");
        localf2.aqH = localObject1;
        locala = (a)locala;
        localObject1 = localObject2;
        if (WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(paramContext)) {
          localObject1 = locala;
        }
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((a)localObject1).N((kotlin.g.a.a)new m.a.f(paramContext, localf2));
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((a)localObject1).M((kotlin.g.a.a)new m.a.g(paramContext, localf2));
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((a)localObject1).O((kotlin.g.a.a)new m.a.h(paramContext, localf2));
        if ((localObject1 == null) || (((a)localObject1).a(paramLiveConfig, (kotlin.g.a.a)new m.a.i(paramContext, localf2, paramLiveConfig, localf1)) == null)) {
          continue;
        }
        localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
        if (!b.a.bek()) {
          continue;
        }
        localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
        b.a.bej();
        if (paramLiveConfig == null) {
          continue;
        }
        long l = paramLiveConfig.liveId;
        localObject1 = u.mZl;
        if (l != u.bie().mMJ) {
          continue;
        }
        i = 1;
      }
      catch (ClassNotFoundException paramContext)
      {
        Object localObject1;
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToEntranceUI failed!", new Object[0]);
        boolean bool = false;
        continue;
        int i = 0;
        continue;
      }
      if (i == 0)
      {
        localObject1 = u.mZl;
        u.aNm();
      }
      e(paramContext, paramLiveConfig);
      bool = true;
      AppMethodBeat.o(246650);
      return bool;
      localObject1 = ((Resources)localObject1).getString(b.h.live_open_new_tip_busy);
      continue;
      localObject1 = d.mUj;
      if (d.a.bek())
      {
        localObject1 = d.mUj;
        d.a.bfM();
      }
    }
  }
  
  public final boolean c(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(246671);
    s.u(paramContext, "context");
    for (;;)
    {
      try
      {
        localObject1 = a.mYU;
        s.u(paramContext, "context");
        Object localObject2 = new ah.f();
        Object localObject3 = paramContext.getResources().getString(b.h.app_i_know);
        s.s(localObject3, "context.resources.getString(R.string.app_i_know)");
        ((ah.f)localObject2).aqH = localObject3;
        localObject1 = (a)localObject1;
        if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(paramContext)) {
          continue;
        }
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((a)localObject1).N((kotlin.g.a.a)new m.a.a(paramContext, (ah.f)localObject2));
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((a)localObject1).M((kotlin.g.a.a)new m.a.b(paramContext, (ah.f)localObject2));
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((a)localObject1).O((kotlin.g.a.a)new m.a.c(paramContext, (ah.f)localObject2));
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((a)localObject1).a(paramLiveConfig, (kotlin.g.a.a)new m.a.d(paramContext, (ah.f)localObject2, paramLiveConfig));
        if (localObject1 == null) {
          continue;
        }
        localObject2 = (kotlin.g.a.b)new m.a.e(paramContext, paramLiveConfig);
        localObject3 = com.tencent.mm.live.model.c.a.nbR;
        localObject3 = com.tencent.mm.live.model.c.a.biZ();
        if ((paramLiveConfig == null) || (paramLiveConfig.scene != LiveConfig.mIr)) {
          continue;
        }
        i = 1;
        if ((i == 0) || (((dig)localObject3).mMJ == 0L)) {
          continue;
        }
        ((kotlin.g.a.b)localObject2).invoke(localObject3);
        localObject1 = null;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
        if (!b.a.bek()) {
          continue;
        }
        localObject1 = com.tencent.mm.live.core.core.a.b.mMo;
        b.a.bej();
        if (paramLiveConfig == null) {
          continue;
        }
        long l = paramLiveConfig.liveId;
        localObject1 = u.mZl;
        if (l != u.bie().mMJ) {
          continue;
        }
        i = 1;
      }
      catch (ClassNotFoundException paramContext)
      {
        Object localObject1;
        Log.printErrStackTrace(TAG, (Throwable)paramContext, "jumpToAnchorUI failed!", new Object[0]);
        boolean bool = false;
        continue;
        int i = 0;
        continue;
      }
      if (i == 0)
      {
        localObject1 = u.mZl;
        u.aNm();
      }
      g(paramContext, paramLiveConfig);
      bool = true;
      AppMethodBeat.o(246671);
      return bool;
      localObject1 = null;
      continue;
      i = 0;
      continue;
      continue;
      localObject1 = d.mUj;
      if (d.a.bek())
      {
        localObject1 = d.mUj;
        d.a.bfM();
      }
    }
  }
  
  public final boolean d(Context paramContext, LiveConfig paramLiveConfig)
  {
    AppMethodBeat.i(246659);
    s.u(paramContext, "context");
    try
    {
      Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.live.ui.LiveUID"));
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramLiveConfig);
      localIntent.addFlags(268435456);
      localIntent.putExtra("FROM_SENCE", 1);
      paramLiveConfig = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLiveConfig.aYi(), "com/tencent/mm/live/model/LiveEntranceJumperImpl", "jumpToReplayUI", "(Landroid/content/Context;Lcom/tencent/mm/live/api/LiveConfig;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLiveConfig.sb(0));
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
    AppMethodBeat.o(246659);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveEntranceJumperImpl$LiveChecker;", "", "()V", "checkAnchorLiving", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "errorCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;", "Lkotlin/ParameterName;", "name", "liveAnchorInfo", "", "checkIsUsePhone", "Lkotlin/Function0;", "checkLiveInfo", "checkNetwork", "checkTalkRoom", "goAnchorUIWithCheck", "context", "Landroid/content/Context;", "goVisitorUIWithCheck", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a mYU;
    
    static
    {
      AppMethodBeat.i(246772);
      mYU = new a();
      AppMethodBeat.o(246772);
    }
    
    final a M(kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(246794);
      try
      {
        Object localObject = MMApplicationContext.getContext().getSystemService("phone");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
          AppMethodBeat.o(246794);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException1)
      {
        int i = 0;
        Log.e(m.aUw(), "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        if (i != 0)
        {
          parama.invoke();
          AppMethodBeat.o(246794);
          return null;
          int j = ((TelephonyManager)localException1).getCallState();
          switch (j)
          {
          default: 
            i = 0;
          }
          for (;;)
          {
            try
            {
              Log.i(m.aUw(), "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
            }
            catch (Exception localException2) {}
            break;
            i = 0;
            continue;
            i = 1;
          }
        }
        AppMethodBeat.o(246794);
      }
      return this;
    }
    
    final a N(kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(246800);
      if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
      {
        parama.invoke();
        AppMethodBeat.o(246800);
        return null;
      }
      AppMethodBeat.o(246800);
      return this;
    }
    
    final a O(kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(246806);
      aaq localaaq = new aaq();
      localaaq.ieg.iei = true;
      localaaq.publish();
      if (!Util.isNullOrNil(localaaq.ieh.iek))
      {
        parama.invoke();
        AppMethodBeat.o(246806);
        return null;
      }
      AppMethodBeat.o(246806);
      return this;
    }
    
    final a a(LiveConfig paramLiveConfig, kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(246783);
      Object localObject1 = u.mZl;
      int i;
      if (u.bie().mMJ != 0L)
      {
        String str = m.aUw();
        localObject1 = new StringBuilder("curLiveId:");
        Object localObject2 = u.mZl;
        localObject2 = ((StringBuilder)localObject1).append(u.bie().mMJ).append(" newLiveId:");
        if (paramLiveConfig == null)
        {
          localObject1 = null;
          Log.i(str, localObject1);
          localObject1 = u.mZl;
          if (!u.biq().nak)
          {
            localObject1 = u.mZl;
            if (!u.biq().nai) {
              break label142;
            }
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label280;
        }
        parama.invoke();
        AppMethodBeat.o(246783);
        return null;
        localObject1 = Long.valueOf(paramLiveConfig.liveId);
        break;
        label142:
        if ((paramLiveConfig != null) && (paramLiveConfig.liveId == 0L))
        {
          i = 1;
          label157:
          if (i == 0) {
            break label238;
          }
          localObject1 = u.mZl;
          localObject1 = (CharSequence)u.bhZ();
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label233;
          }
        }
        label233:
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject1 = u.mZl;
            if (!Util.isEqual(u.bhZ(), paramLiveConfig.mIz)) {}
          }
          else
          {
            if (paramLiveConfig.scene != LiveConfig.mIr) {
              break label275;
            }
          }
          i = 0;
          break;
          i = 0;
          break label157;
        }
        label238:
        localObject1 = u.mZl;
        long l = u.bie().mMJ;
        if (paramLiveConfig == null) {
          i = 0;
        } else if (l != paramLiveConfig.liveId) {
          i = 0;
        } else {
          label275:
          i = 1;
        }
      }
      label280:
      AppMethodBeat.o(246783);
      return this;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      d(Context paramContext, ah.f<String> paramf, LiveConfig paramLiveConfig)
      {
        super();
      }
      
      private static final void a(Context paramContext, LiveConfig paramLiveConfig, boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(246477);
        s.u(paramContext, "$context");
        if (paramBoolean)
        {
          paramString = o.mZb;
          o.bhK();
          paramString = u.mZl;
          u.biV();
          paramString = m.mYT;
          m.i(paramContext, paramLiveConfig);
        }
        AppMethodBeat.o(246477);
      }
      
      private static final void k(boolean paramBoolean, String paramString) {}
      
      private static final void l(boolean paramBoolean, String paramString) {}
      
      private static final void m(boolean paramBoolean, String paramString) {}
      
      private static final void n(boolean paramBoolean, String paramString) {}
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "liveAnchorInfo", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.g.b.u
      implements kotlin.g.a.b<dig, ah>
    {
      e(Context paramContext, LiveConfig paramLiveConfig)
      {
        super();
      }
      
      private static final void a(dig paramdig, LiveConfig paramLiveConfig, Context paramContext, boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(246467);
        s.u(paramdig, "$liveAnchorInfo");
        s.u(paramContext, "$context");
        paramString = new LiveConfig.a();
        paramString.mIy = LiveConfig.mIs;
        paramString.mIz = paramdig.aaNe;
        paramString.liveId = paramdig.mMJ;
        paramString.mIA = paramdig.Zqd;
        paramString.mIC = paramdig.aaNf;
        paramdig = paramString.bcd();
        if (paramLiveConfig != null)
        {
          long l = paramLiveConfig.liveId;
          paramLiveConfig = u.mZl;
          if (l != u.bie().mMJ) {}
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            paramLiveConfig = u.mZl;
            u.aNm();
          }
          paramLiveConfig = m.mYT;
          m.i(paramContext, paramdig);
          AppMethodBeat.o(246467);
          return;
        }
      }
      
      private static final void l(boolean paramBoolean, String paramString) {}
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class i
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      i(Context paramContext, ah.f<String> paramf1, LiveConfig paramLiveConfig, ah.f<String> paramf2)
      {
        super();
      }
      
      private static final void a(Context paramContext, LiveConfig paramLiveConfig, boolean paramBoolean, String paramString)
      {
        AppMethodBeat.i(246501);
        s.u(paramContext, "$context");
        if (paramBoolean)
        {
          paramString = o.mZb;
          o.bhK();
          paramString = u.mZl;
          u.biV();
          paramString = m.mYT;
          m.j(paramContext, paramLiveConfig);
        }
        AppMethodBeat.o(246501);
      }
      
      private static final void k(boolean paramBoolean, String paramString) {}
      
      private static final void l(boolean paramBoolean, String paramString) {}
      
      private static final void m(boolean paramBoolean, String paramString) {}
      
      private static final void n(boolean paramBoolean, String paramString) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.m
 * JD-Core Version:    0.7.0.1
 */