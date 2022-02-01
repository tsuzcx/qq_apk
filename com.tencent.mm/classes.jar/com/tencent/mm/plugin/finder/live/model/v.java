package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.tencent.d.a.a.a.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.e.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.plugin.l;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker;", "", "()V", "TAG", "", "checkAppBrand", "errorCallback", "Lkotlin/Function0;", "", "checkFloatVideo", "gotoAnchor", "", "checkIsAudioUse", "checkIsEnableEnterLive", "checkIsUsePhone", "checkLiveAnchorCore", "context", "Landroid/content/Context;", "checkLiveInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAnchor", "checkLiveVisitorCore", "checkNetwork", "checkRoomLive", "checkVoip", "goAnchorUIWithCheck", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "contextId", "clickTabContextId", "intent", "Landroid/content/Intent;", "goVisitorUIWithCheck", "", "i", "needAnim", "onBeforeStart", "gotoAnchorLive", "gotoFinderReplayUI", "check", "gotoVisitLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v CGh;
  
  static
  {
    AppMethodBeat.i(359529);
    CGh = new v();
    AppMethodBeat.o(359529);
  }
  
  public static void N(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(359494);
    s.u(paramContext, "context");
    Object localObject = aj.CGT;
    aj.elI();
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    if (!(paramContext instanceof Activity))
    {
      paramIntent = (Intent)localObject;
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      paramIntent = com.tencent.mm.plugin.findersdk.e.a.HdV;
      ((Intent)localObject).setClass(paramContext, com.tencent.mm.plugin.findersdk.e.a.fsY());
      if (!(paramContext instanceof Activity)) {
        break label149;
      }
      com.tencent.mm.hellhoundlib.a.a.a((Activity)paramContext, c.a(1010, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoFinderReplayUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      label112:
      if (!(paramContext instanceof Activity)) {
        break label212;
      }
    }
    label149:
    label212:
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      if (paramContext != null)
      {
        int i = p.a.anim_not_change;
        paramContext.overridePendingTransition(i, i);
      }
      AppMethodBeat.o(359494);
      return;
      paramIntent = null;
      break;
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoFinderReplayUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoFinderReplayUI", "(Landroid/content/Context;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break label112;
    }
  }
  
  private static final void a(FinderLiveBundle paramFinderLiveBundle, Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(359516);
    label146:
    if ((paramFinderLiveBundle.CFc == 1) || (paramFinderLiveBundle.CFc == 0))
    {
      paramFinderLiveBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramIntent.setClass(paramContext, com.tencent.mm.plugin.finder.live.utils.a.gB(paramContext));
      paramFinderLiveBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramFinderLiveBundle.aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive$jump", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramFinderLiveBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive$jump", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (!(paramContext instanceof Activity)) {
        break label280;
      }
      paramFinderLiveBundle = (Activity)paramContext;
      label106:
      if (paramFinderLiveBundle != null)
      {
        paramIntent = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
        paramIntent = com.tencent.mm.plugin.finder.live.model.context.a.emY();
        if (paramIntent == null) {
          break label285;
        }
        paramIntent = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)paramIntent.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if ((paramIntent == null) || (paramIntent.isLiveStarted() != true)) {
          break label285;
        }
        i = 1;
        if (i == 0) {
          break label290;
        }
      }
    }
    label280:
    label285:
    label290:
    for (int i = p.a.anim_not_change;; i = p.a.sight_slide_bottom_in)
    {
      paramFinderLiveBundle.overridePendingTransition(i, p.a.anim_not_change);
      AppMethodBeat.o(359516);
      return;
      if (paramFinderLiveBundle.CFc == 2)
      {
        paramFinderLiveBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramIntent.setClass(paramContext, com.tencent.mm.plugin.finder.live.utils.a.gC(paramContext));
        paramIntent.addFlags(872415232);
        paramFinderLiveBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramFinderLiveBundle.aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive$jump", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramFinderLiveBundle.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive$jump", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
      }
      Log.i("Finder.LiveJumpChecker", s.X("config.secondaryDeviceFlag is not legal: ", Integer.valueOf(paramFinderLiveBundle.CFc)));
      break;
      paramFinderLiveBundle = null;
      break label106;
      i = 0;
      break label146;
    }
  }
  
  private static final void a(FinderLiveBundle paramFinderLiveBundle, LiveConfig paramLiveConfig, Intent paramIntent, Context paramContext, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(359526);
    s.u(paramFinderLiveBundle, "$config");
    s.u(paramLiveConfig, "$it");
    s.u(paramIntent, "$intent");
    s.u(paramContext, "$context");
    paramObject = com.tencent.mm.plugin.finder.storage.data.e.FMN;
    paramLiveConfig = e.a.jn(paramLiveConfig.mIH);
    if (paramLiveConfig == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      paramFinderLiveBundle.CFc = paramInt1;
      if (paramFinderLiveBundle.CFc == -1) {
        break;
      }
      a(paramFinderLiveBundle, paramIntent, paramContext);
      AppMethodBeat.o(359526);
      return;
      paramLiveConfig = paramLiveConfig.getLiveInfo();
      if (paramLiveConfig == null) {
        paramInt1 = -1;
      } else {
        paramInt1 = paramLiveConfig.ZRX;
      }
    }
    Log.i("Finder.LiveJumpChecker", "config.secondaryDeviceFlag is not legal: " + paramFinderLiveBundle.CFc + " after getCommentDatail");
    AppMethodBeat.o(359526);
  }
  
  public static void b(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(359476);
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramFinderLiveBundle);
    paramIntent = paramFinderLiveBundle.Bpo;
    if (paramIntent == null)
    {
      paramIntent = null;
      localIntent.putExtra("KEY_PARAMS_NOTICE", paramIntent);
      paramIntent = paramFinderLiveBundle.CFb;
      if (paramIntent != null) {
        break label406;
      }
      paramIntent = null;
      label84:
      localIntent.putExtra("KEY_PARAMS_LIVE_TASK_INFO", paramIntent);
      if (!Util.isNullOrNil(paramString1)) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(paramString1, localIntent);
      }
      paramString1 = paramFinderLiveBundle.CFd;
      if (paramString1 != null) {
        break label416;
      }
      paramString1 = null;
      label131:
      if (!(paramString1 instanceof Serializable)) {
        break label490;
      }
      paramString1 = (Serializable)paramString1;
      label143:
      localIntent.putExtra("KEY_PARAMS_TAGIFNOS", paramString1);
      paramString1 = paramFinderLiveBundle.CFe;
      if (paramString1 != null) {
        break label495;
      }
      paramString1 = null;
      label164:
      localIntent.putExtra("KEY_PARAMS_CHOSEN_TAG", paramString1);
      localIntent.putExtra("key_click_tab_context_id", paramString2);
      paramString1 = paramFinderLiveBundle.BpY;
      if (paramString1 != null) {
        break label503;
      }
      paramString1 = null;
      label195:
      if (!(paramString1 instanceof Serializable)) {
        break label571;
      }
    }
    int i;
    label406:
    label416:
    label571:
    for (paramString1 = (Serializable)paramString1;; paramString1 = null)
    {
      localIntent.putExtra("KEY_PARAMS_VISITOR_WHITE_LIST", paramString1);
      localIntent.putExtra("KEY_PARAMS_VISIBLE_ROOM_MAX_COUNT", paramFinderLiveBundle.CFg);
      localIntent.putExtra("KEY_PARAMS_VISIBLE_USER_MAX_COUNT", paramFinderLiveBundle.CFh);
      localIntent.putExtra("KEY_PARAMS_LUCKY_MONEY_CONFIG", paramFinderLiveBundle.CFi);
      i = localIntent.getIntExtra("KEY_PARAMS_SOURCE_TYPE", -1);
      Log.i("Finder.LiveJumpChecker", "[gotoAnchorLive] config.secondaryDeviceFlag" + paramFinderLiveBundle.CFc + ", sourceType:" + i);
      if (i != 5) {
        break label576;
      }
      paramFinderLiveBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localIntent.setClass(paramContext, com.tencent.mm.plugin.finder.live.utils.a.gC(paramContext));
      paramFinderLiveBundle = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramFinderLiveBundle.aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramFinderLiveBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoAnchorLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(359476);
      return;
      paramIntent = paramIntent.toByteArray();
      break;
      paramIntent = paramIntent.toByteArray();
      break label84;
      paramIntent = (Iterable)paramString1;
      paramString1 = (Collection)new ArrayList(p.a(paramIntent, 10));
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext()) {
        paramString1.add(((bno)paramIntent.next()).toByteArray());
      }
      paramString1 = (List)paramString1;
      break label131;
      label490:
      paramString1 = null;
      break label143;
      label495:
      paramString1 = paramString1.toByteArray();
      break label164;
      label503:
      paramString2 = (Iterable)paramString1;
      paramString1 = (Collection)new ArrayList(p.a(paramString2, 10));
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext()) {
        paramString1.add(((bfh)paramString2.next()).toByteArray());
      }
      paramString1 = (List)paramString1;
      break label195;
    }
    label576:
    paramString1 = (LiveConfig)paramFinderLiveBundle.CFa.get(0);
    if ((paramString1 != null) && (paramFinderLiveBundle.CFc == -1))
    {
      paramString2 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      paramString1 = e.a.jn(paramString1.mIH);
      if (paramString1 != null) {
        break label647;
      }
      i = -1;
    }
    for (;;)
    {
      paramFinderLiveBundle.CFc = i;
      if (paramFinderLiveBundle.CFc == -1) {
        break;
      }
      a(paramFinderLiveBundle, localIntent, paramContext);
      AppMethodBeat.o(359476);
      return;
      label647:
      paramString1 = paramString1.getLiveInfo();
      if (paramString1 == null) {
        i = -1;
      } else {
        i = paramString1.ZRX;
      }
    }
    paramString1 = (LiveConfig)paramFinderLiveBundle.CFa.get(0);
    if (paramString1 != null) {
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).tryGetFinderObject(paramString1.mIH, paramString1.nonceId, 0, false, true, new v..ExternalSyntheticLambda0(paramFinderLiveBundle, paramString1, localIntent, paramContext));
    }
    AppMethodBeat.o(359476);
  }
  
  public static void b(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(359448);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    boolean bool1;
    label32:
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (paramIntent != null) {
        break label605;
      }
      bool1 = false;
      aj localaj = aj.CGT;
      boolean bool2 = aj.isFinished();
      if (localObject == null) {
        break label625;
      }
      long l = ((f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).business(f.class)).liveInfo.liveId;
      localObject = (LiveConfig)p.ae((List)paramFinderLiveBundle.CFa, paramFinderLiveBundle.CEY);
      if ((localObject == null) || (l != ((LiveConfig)localObject).liveId)) {
        break label619;
      }
      i = 1;
      label104:
      if ((i != 0) || ((!bool1) && (bool2))) {
        break label625;
      }
      localObject = aj.CGT;
      aj.elI();
      label127:
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = new Intent();
      }
      ((Intent)localObject).addFlags(335544320);
      bool1 = ((l)com.tencent.mm.kernel.h.ax(l.class)).ep(paramContext);
      Log.printInfoStack("Finder.LiveJumpChecker", "gotoVisitLive: isFinderTaskForeground = " + bool1 + " uiFinished:" + bool2, new Object[0]);
      if (!bool1)
      {
        if (!(paramContext instanceof Activity)) {
          break label648;
        }
        paramIntent = (Activity)paramContext;
        label227:
        if (paramIntent == null) {
          break label654;
        }
        paramIntent = paramIntent.getIntent();
        if ((paramIntent == null) || (paramIntent.getBooleanExtra("KEY_IS_FROM_FINDER_TASK", false) != true)) {
          break label654;
        }
        i = 1;
        label260:
        if (i == 0) {}
      }
      else
      {
        ((Intent)localObject).putExtra("KEY_IS_FROM_FINDER_TASK", true);
      }
      ((Intent)localObject).putExtra("KEY_PARAMS_CONFIG", (Parcelable)paramFinderLiveBundle);
      paramIntent = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(paramIntent, "service(IFinderCommonService::class.java)");
      h.a.a((com.tencent.mm.plugin.h)paramIntent, paramContext, (Intent)localObject, 11, 64);
      if (!Util.isNullOrNil(paramString1)) {
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(paramString1, (Intent)localObject);
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label660;
      }
      i = 1;
      label365:
      if (i == 0) {
        ((Intent)localObject).putExtra("key_click_tab_context_id", paramString2);
      }
      if (paramFinderLiveBundle.AJo != 0) {
        ((Intent)localObject).putExtra("key_from_comment_scene", paramFinderLiveBundle.AJo);
      }
      paramFinderLiveBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramFinderLiveBundle = com.tencent.mm.plugin.finder.live.utils.a.gD(paramContext);
      paramString1 = aj.CGT;
      paramString1 = aj.elk();
      if ((paramString1 != null) && (!s.p(paramString1.getContext().getClass(), paramFinderLiveBundle)))
      {
        paramString1 = aj.CGT;
        aj.elI();
      }
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveVideoDefinitionStorage().euc();
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().etU();
      ((Intent)localObject).setClass(paramContext, paramFinderLiveBundle);
      paramFinderLiveBundle = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramFinderLiveBundle.aYi(), "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramFinderLiveBundle.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/live/model/FinderLiveJumpChecker", "gotoVisitLive", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (!paramBoolean) {
        if (!(paramContext instanceof Activity)) {
          break label666;
        }
      }
    }
    label648:
    label654:
    label660:
    label666:
    for (paramContext = (Activity)paramContext;; paramContext = null)
    {
      if (paramContext != null)
      {
        i = p.a.anim_not_change;
        paramContext.overridePendingTransition(i, i);
      }
      AppMethodBeat.o(359448);
      return;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      break;
      label605:
      bool1 = paramIntent.getBooleanExtra("KEY_PARAMS_NOT_KEEP_CUR_LIVE", false);
      break label32;
      label619:
      i = 0;
      break label104;
      label625:
      localObject = aj.CGT;
      localObject = aj.getLiveCore();
      if (localObject == null) {
        break label127;
      }
      ((com.tencent.mm.live.core.core.trtc.a)localObject).beY();
      break label127;
      paramIntent = null;
      break label227;
      i = 0;
      break label260;
      i = 0;
      break label365;
    }
  }
  
  private static void ekV()
  {
    AppMethodBeat.i(359503);
    aj localaj = aj.CGT;
    if (aj.elL() != null)
    {
      localaj = aj.CGT;
      aj.elI();
    }
    AppMethodBeat.o(359503);
  }
  
  private static void ekW()
  {
    AppMethodBeat.i(359509);
    Object localObject = com.tencent.mm.live.core.core.a.b.mMo;
    if (!b.a.bek())
    {
      localObject = com.tencent.mm.live.core.core.e.a.mRf;
      if (!a.a.bek()) {}
    }
    else
    {
      localObject = aj.CGT;
      aj.elI();
    }
    AppMethodBeat.o(359509);
  }
  
  public final v a(Context paramContext, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(359550);
    if ((com.tencent.mm.n.a.p(paramContext, false)) || (com.tencent.mm.n.a.s(null, false)) || (com.tencent.mm.n.a.aTe()))
    {
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(359550);
      return null;
    }
    AppMethodBeat.o(359550);
    return this;
  }
  
  public final v b(boolean paramBoolean, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(359574);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    int i;
    label61:
    String str;
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (((f)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).business(f.class)).liveInfo.liveId == 0L) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).eyA())) {
        break label118;
      }
      i = 1;
      if (i == 0) {
        break label133;
      }
      str = z.bAW();
      if (localObject != null) {
        break label123;
      }
    }
    label118:
    label123:
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject).mIC)
    {
      paramb.invoke(Boolean.valueOf(Util.isEqual(str, (String)localObject)));
      AppMethodBeat.o(359574);
      return null;
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      break;
      i = 0;
      break label61;
    }
    label133:
    if (paramBoolean) {
      ekV();
    }
    for (;;)
    {
      AppMethodBeat.o(359574);
      return this;
      ekW();
    }
  }
  
  public final v bb(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(359544);
    if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(359544);
      return null;
    }
    AppMethodBeat.o(359544);
    return this;
  }
  
  public final v bc(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(359555);
    if (com.tencent.mm.n.a.aTg())
    {
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(359555);
      return null;
    }
    AppMethodBeat.o(359555);
    return this;
  }
  
  public final v bd(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(359560);
    if ((com.tencent.mm.n.a.aTh()) || (com.tencent.mm.n.a.aTi()))
    {
      if (parama != null) {
        parama.invoke();
      }
      AppMethodBeat.o(359560);
      return null;
    }
    AppMethodBeat.o(359560);
    return this;
  }
  
  public final v be(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(359582);
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("phone");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(359582);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException1)
    {
      int i = 0;
      Log.e("Finder.LiveJumpChecker", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
      if (i != 0)
      {
        if (parama != null) {
          parama.invoke();
        }
        AppMethodBeat.o(359582);
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
            Log.i("Finder.LiveJumpChecker", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(j) });
          }
          catch (Exception localException2) {}
          break;
          i = 0;
          continue;
          i = 1;
        }
      }
      AppMethodBeat.o(359582);
    }
    return this;
  }
  
  public final v c(boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(359565);
    if (com.tencent.mm.n.a.v(null, false))
    {
      if (parama != null) {
        parama.invoke();
      }
      if (paramBoolean)
      {
        AppMethodBeat.o(359565);
        return null;
      }
    }
    AppMethodBeat.o(359565);
    return this;
  }
  
  public final boolean ekX()
  {
    AppMethodBeat.i(359587);
    if ((!ekY()) && (c(false, (kotlin.g.a.a)v.d.CGl) != null) && (bc((kotlin.g.a.a)v.e.CGm) != null) && (bb((kotlin.g.a.a)v.f.CGn) != null))
    {
      AppMethodBeat.o(359587);
      return true;
    }
    AppMethodBeat.o(359587);
    return false;
  }
  
  public final boolean ekY()
  {
    AppMethodBeat.i(359594);
    v localv = be((kotlin.g.a.a)v.a.CGi);
    if (localv == null) {
      localv = null;
    }
    while (localv == null)
    {
      AppMethodBeat.o(359594);
      return true;
      localv = localv.bd((kotlin.g.a.a)v.b.CGj);
      if (localv == null)
      {
        localv = null;
      }
      else
      {
        Context localContext = MMApplicationContext.getContext().getApplicationContext();
        s.s(localContext, "getContext().applicationContext");
        localv = localv.a(localContext, (kotlin.g.a.a)v.c.CGk);
      }
    }
    AppMethodBeat.o(359594);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isAnchor", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    public j(FinderLiveBundle paramFinderLiveBundle, Context paramContext, ah.f<String> paramf, Intent paramIntent)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isAnchor", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class r
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    public r(FinderLiveBundle paramFinderLiveBundle, Context paramContext, ah.f<String> paramf, Intent paramIntent, boolean paramBoolean, ah.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.v
 * JD-Core Version:    0.7.0.1
 */