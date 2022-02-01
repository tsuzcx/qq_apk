package com.tencent.mm.plugin.finder.conv;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Base64;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ui.FinderAppPushRouteProxyUI;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.aw;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.forcenotify.ui.b.a;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "finderSceneCount", "", "firstSkipTime", "", "getFirstSkipTime", "()J", "setFirstSkipTime", "(J)V", "historyNotificationList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$NotificationInfo;", "isInChattingUI", "", "isInPayScene", "kv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "onlyForLaunch", "getOnlyForLaunch", "()Z", "setOnlyForLaunch", "(Z)V", "pendingList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$ConsumeNewXmlData;", "pendingTask", "Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$PendingTask;", "worker", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "buildJson", "maps", "", "", "cancelAll", "", "checkCurrentSensitiveScene", "checkInFinder", "checkPendTaskToRun", "delayMs", "source", "Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$RunSource;", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "createActivityUIIntent", "Landroid/content/Intent;", "sessionId", "report_ext_info", "taskId", "feedId", "nonceId", "byPassInfo", "byPassType", "ctrlFlag", "demotionFlag", "failReturnTo", "showSource", "jumpTypeCode", "pushLevel", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "createCommonIntent", "createHotTabIntent", "createLiveUIIntent", "isNeedRelated", "returnTo", "dispatchNotify", "isModify", "doCancel", "fillHistoryNotificationList", "handleNewXml", "handleNotify", "feedIdStr", "jumpTo", "ticker", "title", "content", "largeIcon", "Landroid/graphics/Bitmap;", "isNeedSound", "isNeedShake", "authIconType", "alertDisplayTime", "hasExtStatusFlag", "flag", "insertNewXml", "newXml", "isEnableFinderAppPush", "isFinderClose", "isFinderLiveClose", "isFinderLiveFriendClose", "isShowFinderAppPushSetting", "jsonToMap", "json", "loadPendingList", "notifyForceNotice", "intent", "notificationId", "desc", "onChattingAction", "isExit", "parseFromLocal", "data", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderNewXmlData;", "parseToLocal", "preResolvePendingList", "", "list", "reduceLargeIconSize", "icon", "updateHistoryNotificationListRecord", "Companion", "ConsumeNewXmlData", "NotificationInfo", "PendingTask", "RunSource", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements com.tencent.mm.plugin.messenger.foundation.a.s
{
  public static final i.b AFY;
  final ConcurrentHashMap<String, i.d> AFZ;
  private int AGa;
  private final MultiProcessMMKV AGb;
  private boolean AGc;
  private final ConcurrentLinkedQueue<i.c> AGd;
  private final e AGe;
  private long AGf;
  private boolean AGg;
  boolean AGh;
  private final MMHandler hbN;
  
  static
  {
    AppMethodBeat.i(336405);
    AFY = new i.b((byte)0);
    AppMethodBeat.o(336405);
  }
  
  public i()
  {
    AppMethodBeat.i(336071);
    this.AFZ = new ConcurrentHashMap();
    this.AGb = MultiProcessMMKV.getSingleMMKV("FinderGlobalPushNewXmlConsumer");
    this.AGd = new ConcurrentLinkedQueue();
    this.hbN = new MMHandler("FinderGlobalPushNewXmlConsumerHandler");
    this.AGe = new e();
    this.AGf = -1L;
    this.hbN.post(new i..ExternalSyntheticLambda3(this));
    new FinderGlobalPushNewXmlConsumer.2(this, com.tencent.mm.app.f.hfK).alive();
    new FinderGlobalPushNewXmlConsumer.3(this, com.tencent.mm.app.f.hfK).alive();
    AppForegroundDelegate.heY.a((com.tencent.mm.app.q)new com.tencent.mm.app.q()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(336124);
        i.c(this.AGi).removeCallbacks((Runnable)i.d(this.AGi));
        AppMethodBeat.o(336124);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(336118);
        if (!((Collection)i.b(this.AGi)).isEmpty()) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            paramAnonymousString = this.AGi;
            com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
            i.a(paramAnonymousString, ((Number)com.tencent.mm.plugin.finder.storage.d.eXt().bmg()).intValue(), i.f.AGp);
          }
          long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.acZK, 0L);
          if (com.tencent.mm.model.cn.bDw() - l >= 86400000L) {
            com.tencent.mm.ae.d.B((kotlin.g.a.a)new i.1.a(this.AGi));
          }
          AppMethodBeat.o(336118);
          return;
        }
      }
    });
    Object localObject = MMApplicationContext.getContext().getApplicationContext();
    if ((localObject instanceof Application)) {}
    for (localObject = (Application)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new i.a(this));
      }
      AppMethodBeat.o(336071);
      return;
    }
  }
  
  private static Intent a(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, int paramInt1, long paramLong3, String paramString5, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(336226);
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.putExtra("Finder.GlobalPushNewXmlConsumer", true);
    localIntent.putExtra("KEY_SESSION_ID", paramString1);
    localIntent.putExtra("KEY_REPORT_EXT_INFO", paramString2);
    localIntent.putExtra("KEY_PUSH_CTRL_FLAG", paramLong2);
    localIntent.putExtra("KEY_PUSH_DEMOTION_FLAG", paramLong3);
    localIntent.putExtra("KEY_TASK_ID", paramString3);
    localIntent.putExtra("KEY_OBJECT_ID", paramLong1);
    localIntent.putExtra("KEY_OBJECT_NONCE_ID", paramString4);
    localIntent.putExtra("KEY_PUSH_RETURN_TO", paramInt1);
    localIntent.putExtra("KEY_UDF_KV", paramString5);
    localIntent.putExtra("KEY_JUMP_TYPE_CODE", paramInt2);
    localIntent.putExtra("KEY_PUSH_LEVEL", paramInt3);
    paramString1 = new JSONObject();
    paramString1.put("taskId", paramString3);
    localIntent.putExtra("key_extra_info", paramString1.toString());
    localIntent.setClass(MMApplicationContext.getContext(), FinderAppPushRouteProxyUI.class);
    AppMethodBeat.o(336226);
    return localIntent;
  }
  
  private static Intent a(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, String paramString5, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString6, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(336235);
    paramString1 = a(paramString1, paramString2, paramString3, paramLong1, paramString4, paramLong2, paramInt2, paramLong3, paramString6, paramInt3, paramInt4);
    paramString1.putExtra("KEY_ROUTE_TYPE", 0);
    ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(29, 2, 20, paramString1);
    paramString1.putExtra("KEY_BY_PASS_INFO_TYPE", paramInt1);
    paramString1.putExtra("KEY_BY_PASS_INFO", paramString5);
    paramString1.putExtra("KEY_OBJECT_ID", paramLong1);
    paramString1.putExtra("KEY_OBJECT_NONCE_ID", paramString4);
    paramString1.putExtra("KEY_TARGET_TAB_TYPE", 4);
    paramString1.putExtra("KEY_SOURCE_TYPE", 2);
    paramString1.putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", true);
    paramString1.putExtra("KEY_FINDER_IS_NEED_REFRESH_TAB", true);
    paramString1.putExtra("FROM_SCENE_KEY", 5);
    AppMethodBeat.o(336235);
    return paramString1;
  }
  
  private static Intent a(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, String paramString5, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString6, int paramInt3, int paramInt4, FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(336245);
    paramString2 = a(paramString1, paramString2, paramString3, paramLong1, paramString4, paramString5, paramInt1, paramLong2, paramLong3, paramInt2, paramString6, paramInt3, paramInt4);
    paramString2.putExtra("KEY_ROUTE_TYPE", 2);
    if (paramFinderJumpInfo == null) {}
    for (paramString1 = null;; paramString1 = paramFinderJumpInfo.toByteArray())
    {
      paramString2.putExtra("KEY_JUMP_INFO", paramString1);
      AppMethodBeat.o(336245);
      return paramString2;
    }
  }
  
  private final g.b a(String paramString1, Map<String, String> paramMap, g.a parama, String paramString2)
  {
    AppMethodBeat.i(336174);
    Object localObject1;
    i locali;
    int n;
    long l2;
    long l1;
    int i1;
    String str1;
    label149:
    boolean bool7;
    boolean bool8;
    boolean bool9;
    boolean bool10;
    Object localObject2;
    boolean bool2;
    label213:
    boolean bool3;
    label232:
    boolean bool4;
    label251:
    boolean bool6;
    label276:
    boolean bool1;
    try
    {
      localObject1 = Result.Companion;
      locali = (i)this;
      if (locali.AFZ.isEmpty()) {
        locali.dWV();
      }
      localObject1 = (String)paramMap.get(".sysmsg.content.task_id");
      if (localObject1 != null) {
        break label6082;
      }
      localObject1 = "";
      n = Util.safeParseInt((String)paramMap.get(".sysmsg.content.action_type"));
      l2 = Util.safeParseLong((String)paramMap.get(".sysmsg.content.ctrl_flag"));
      l1 = Util.safeParseLong((String)paramMap.get(".sysmsg.content.freq_limit"));
      i1 = Util.safeParseInt((String)paramMap.get(".sysmsg.content.jump_to"));
      str1 = (String)paramMap.get(".sysmsg.content.report_ext_info");
      if (str1 != null) {
        break label6085;
      }
      str1 = "";
      bool7 = AppForegroundDelegate.heY.eLx;
      bool8 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
      bool9 = dWW();
      bool10 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
      localObject2 = r.AHk;
      if ((r.dXj() & l2) == 0L) {
        break label6088;
      }
      bool2 = true;
      localObject2 = r.AHk;
      if ((r.dXk() & l2) == 0L) {
        break label6094;
      }
      bool3 = true;
      localObject2 = r.AHk;
      if ((l2 & r.dXi()) == 0L) {
        break label6100;
      }
      bool4 = true;
      bool6 = com.tencent.mm.n.a.q(MMApplicationContext.getContext(), false);
      if (locali.AGa > 0) {
        break label6029;
      }
      if (!bool6) {
        break label6106;
      }
    }
    finally
    {
      boolean bool13;
      parama = Result.Companion;
      paramString1 = Result.constructor-impl(ResultKt.createFailure(paramString1));
    }
    boolean bool5 = bool1;
    Object localObject3;
    label354:
    boolean bool11;
    if (bool1)
    {
      bool5 = bool1;
      if (!bool6)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
        bool5 = bool1;
        if (com.tencent.mm.plugin.finder.storage.d.eXD())
        {
          localObject2 = (com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
          localObject3 = (com.tencent.d.a.b.a.e)com.tencent.mm.kernel.h.az(com.tencent.d.a.b.a.e.class);
          if (((com.tencent.d.a.b.a.e)localObject3).isInNearby()) {
            break label6035;
          }
          if (!((com.tencent.d.a.b.a.e)localObject3).isInFinderLiveSquareFindPageUI()) {
            break label6112;
          }
          break label6035;
          bool6 = ((com.tencent.mm.plugin.l)localObject2).bUe();
          bool11 = ((com.tencent.mm.plugin.l)localObject2).bUS();
          if ((bool5) || (bool6)) {
            break label6041;
          }
          if (!bool11) {
            break label6118;
          }
          break label6041;
          label390:
          Log.i("Finder.GlobalPushNewXmlConsumer", "[checkInFinder] isInNearby=" + bool5 + ", isFinderForeground=" + bool6 + ", isHomeFromFinderTask=" + bool11 + ", finderSceneCount=" + locali.AGa);
          bool5 = bool1;
        }
      }
    }
    label469:
    int k;
    label488:
    int i;
    label705:
    int j;
    label734:
    String str2;
    label785:
    label920:
    label951:
    Object localObject4;
    label1570:
    label1615:
    int i2;
    int i3;
    label2067:
    label2160:
    int m;
    label2241:
    label2250:
    label5086:
    label5106:
    Object localObject7;
    label3077:
    label5140:
    label5153:
    label5180:
    label5204:
    label5228:
    ah.d locald;
    label5312:
    long l3;
    int i4;
    int i5;
    Object localObject5;
    label5447:
    Object localObject6;
    label5497:
    Object localObject8;
    if ((z.bAR() & 0x0) != 0L)
    {
      bool1 = true;
      localObject2 = t.AHw;
      if (i1 == t.dXs()) {
        break label6130;
      }
      k = 1;
      break label6047;
      localObject3 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      if (kotlin.g.b.s.p(paramString2, "4"))
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(23498, new Object[] { localObject1, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
        com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "handleNewXml", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(n), Integer.valueOf(i1) });
      }
      bool6 = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acZN, false);
      if (!bool6)
      {
        localObject3 = q.AHf;
        if (n == q.dXe())
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acZN, Boolean.TRUE);
          bool6 = true;
          localObject3 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
          if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
          {
            if ((z.bAR() & 0x0) == 0L) {
              break label6174;
            }
            j = 1;
            break label6063;
          }
          localObject3 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
          if ((com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) || (!((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().fgF())) {
            break label6186;
          }
          if ((z.bAR() & 0x0) == 0L) {
            break label6180;
          }
          j = 1;
          break label6071;
          localObject3 = com.tencent.mm.plugin.forcenotify.e.a.HpI;
          localObject3 = MMApplicationContext.getContext();
          kotlin.g.b.s.s(localObject3, "getContext()");
          bool11 = com.tencent.mm.plugin.forcenotify.e.a.hE((Context)localObject3);
          boolean bool12 = com.tencent.mm.k.h.aQG();
          bool13 = locali.dWS();
          if (locali.AFZ.containsKey(localObject1))
          {
            localObject3 = q.AHf;
            if (n == q.dXe())
            {
              locali.AFZ.remove(localObject1);
              Log.e("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("has same taskId=", localObject1));
            }
          }
          if ((!bool7) && (bool2) && (!bool3))
          {
            localObject3 = q.AHf;
            if (n == q.dXe()) {}
          }
          else
          {
            if (((Collection)locali.AGd).isEmpty()) {
              break label6192;
            }
            j = 1;
            if ((j == 0) && ((!bool13) || (locali.AFZ.containsKey(localObject1)))) {
              break label1615;
            }
          }
          if (bool7) {
            break label6198;
          }
          j = 1;
          localObject3 = new i.c(paramString1, paramMap, parama, j);
          locali.AGd.add(localObject3);
          paramString1 = l.AGV;
          str2 = aj(((i.c)localObject3).values);
          parama = (String)((i.c)localObject3).values.get(".sysmsg.content.task_id");
          paramString1 = parama;
          if (parama == null) {
            paramString1 = "";
          }
          localObject4 = new aw();
          ((aw)localObject4).field_localId = paramString1;
          parama = ((i.c)localObject3).AGj;
          paramString1 = parama;
          if (parama == null) {
            paramString1 = "";
          }
          ((aw)localObject4).field_subType = paramString1;
          ((aw)localObject4).field_valuesJSON = str2;
          ((aw)localObject4).field_pendingReason = ((i.c)localObject3).AGl;
          ((aw)localObject4).field_createTime = com.tencent.mm.model.cn.bDv();
          ((aw)localObject4).field_type = 1;
          l.a((aw)localObject4);
          if (bool13)
          {
            Log.w("Finder.GlobalPushNewXmlConsumer", "当前在敏感场景，延迟到退出该场景时弹出 size=" + locali.AGd.size() + " showSource=" + paramString2);
            parama = new JSONObject();
            parama.put("fail_reason", 21);
            paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
            l1 = System.currentTimeMillis();
            parama = parama.toString();
            kotlin.g.b.s.s(parama, "json.toString()");
            paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(100), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
            com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "21", Integer.valueOf(n), Integer.valueOf(i1) });
          }
          for (;;)
          {
            AppMethodBeat.o(336174);
            return null;
            parama = new JSONObject();
            parama.put("fail_reason", 20);
            paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
            l1 = System.currentTimeMillis();
            parama = parama.toString();
            kotlin.g.b.s.s(parama, "json.toString()");
            paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(100), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
            Log.w("Finder.GlobalPushNewXmlConsumer", "当前在后台，延迟到前台弹出 size=" + locali.AGd.size() + " showSource=" + paramString2);
            com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "20", Integer.valueOf(n), Integer.valueOf(i1) });
          }
          parama = Result.exceptionOrNull-impl(paramString1);
          if (parama != null)
          {
            paramString1 = (String)paramMap.get(".sysmsg.content.task_id");
            if (paramString1 == null)
            {
              paramString1 = "";
              e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "Finder.GlobalPushNewXmlConsumer", false, null, false, (kotlin.g.a.a)new i.k(paramString1, parama), 28);
              paramString1 = ah.aiuX;
              paramString1 = ah.aiuX;
            }
          }
          else
          {
            AppMethodBeat.o(336174);
            return null;
            l2 = com.tencent.mm.kernel.h.baE().ban().a(at.a.acZM, 0L);
            if (86400000L + l2 <= System.currentTimeMillis())
            {
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acZL, Integer.valueOf(0));
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acZM, Long.valueOf(System.currentTimeMillis()));
              Log.i("Finder.GlobalPushNewXmlConsumer", "over one day, reset show count.");
            }
            i2 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZL, 0);
            i3 = Util.safeParseInt((String)paramMap.get(".sysmsg.content.last_deliver_time"));
            com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "receive", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(n), Integer.valueOf(i1) });
            Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("values=", paramMap));
            paramString1 = new StringBuilder();
            paramString1.append("[consumeNewXml] isInFinder=").append(bool5).append(" isTeenMode=").append(bool10).append(" isEnableInApp=").append(bool2).append(" isEnableInOutApp=").append(bool3).append(" isShowFinderEntry=").append(bool8).append(" showSource=").append(paramString2).append(" isOpenPushNotify=").append(bool9).append(" isFinderClose=").append(bool1).append(" isEnableCloseFinderToNotify=").append(bool4).append(" actionType=").append(n).append(" taskId=").append((String)localObject1).append(" isAppForeground=");
            paramString1.append(bool7).append(" isShowFinderAppPushSetting=").append(bool6).append(" lastDeliverTime=").append(i3).append(" earlyShowTime=").append(l2).append(" showCount=").append(i2).append(" isPermissionGranted=").append(bool11).append("report_ext_info=").append(str1).append(" sessionId=").append((String)localObject2);
            Log.i("Finder.GlobalPushNewXmlConsumer", paramString1.toString());
            paramString1 = q.AHf;
            if (n == q.dXg())
            {
              paramString1 = (NotificationManager)MMApplicationContext.getContext().getSystemService("notification");
              parama = (i.d)locali.AFZ.get(localObject1);
              if (parama == null)
              {
                i = 0;
                break label6204;
                Log.i("Finder.GlobalPushNewXmlConsumer", "[cancel] taskId=" + (String)localObject1 + " notificationId=" + i + " isInnerPush=" + bool1);
                if (!bool1) {
                  break label2250;
                }
                paramString1 = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
                b.a.fwZ().aDU(kotlin.g.b.s.X("notification-", Integer.valueOf(i)));
              }
              for (;;)
              {
                locali.dWU();
                if (locali.AFZ.remove(localObject1) == null) {
                  break label6214;
                }
                bool1 = true;
                com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "cancel", Long.valueOf(System.currentTimeMillis()), kotlin.g.b.s.X("result=", Boolean.valueOf(bool1)), Integer.valueOf(n), Integer.valueOf(i1) });
                AppMethodBeat.o(336174);
                return null;
                i = parama.id;
                break label6204;
                bool1 = parama.AGm;
                break;
                if (paramString1 != null) {
                  paramString1.cancel(i);
                }
              }
            }
            if ((bool3) && (!bool12))
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 允许应用外弹，但系统关闭通知权限");
              parama = new JSONObject();
              parama.put("fail_reason", 19);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "19", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if ((bool2) && (!bool11))
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 允许应用内弹，但没有浮窗权限");
              parama = new JSONObject();
              parama.put("fail_reason", 14);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "14", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if ((!bool7) && (bool2) && (!bool3))
            {
              paramString1 = q.AHf;
              if (n == q.dXe())
              {
                Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 只允许在应用内弹，但当前在应用外收到");
                parama = new JSONObject();
                parama.put("fail_reason", 16);
                paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
                l1 = System.currentTimeMillis();
                parama = parama.toString();
                kotlin.g.b.s.s(parama, "json.toString()");
                paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
                com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "16", Integer.valueOf(n), Integer.valueOf(i1) });
                AppMethodBeat.o(336174);
                return null;
              }
            }
            if ((!bool7) || (!bool3) || (bool2)) {
              break label6220;
            }
            paramString1 = q.AHf;
            if (n != q.dXe()) {
              break label6220;
            }
            Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 只允许在应用外弹，但当前在应用内收到");
            parama = new JSONObject();
            parama.put("fail_reason", 17);
            paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
            l1 = System.currentTimeMillis();
            parama = parama.toString();
            kotlin.g.b.s.s(parama, "json.toString()");
            paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
            com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "17", Integer.valueOf(n), Integer.valueOf(i1) });
            AppMethodBeat.o(336174);
            return null;
            if (j != 0)
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 超过一天的限制频率(" + l1 + ") showCount=" + i2);
              parama = new JSONObject();
              parama.put("fail_reason", 2);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "2", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if ((i3 > 0) && (i3 < System.currentTimeMillis() / 1000L))
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 超过了展示push的时间(" + i3 + ").");
              parama = new JSONObject();
              parama.put("fail_reason", 3);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "3", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if ((bool1) && (!bool4))
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 发现页入口被用户关闭，且后台没有强制 emFinderGlobalPushCtrlFlag_ForceAlert");
              parama = new JSONObject();
              parama.put("fail_reason", 4);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "4", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if (!bool8)
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 没有视频号入口权限");
              parama = new JSONObject();
              parama.put("fail_reason", 5);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "5", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if (bool10)
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 处于青少年模式中");
              parama = new JSONObject();
              parama.put("fail_reason", 6);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "6", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if (!bool6)
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 新消息通知设置没有展示push开关权限");
              parama = new JSONObject();
              parama.put("fail_reason", 7);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "7", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if (bool5)
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 当前在视频号场景下，一定不弹");
              parama = new JSONObject();
              parama.put("fail_reason", 8);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "8", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            if (!bool9)
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 用户关闭push开关，一定不弹");
              parama = new JSONObject();
              parama.put("fail_reason", 10);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "10", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            paramString1 = t.AHw;
            if ((i1 == t.dXs()) && (m == 0))
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 当前推送的是直播push, 没有直播入口权限");
              parama = new JSONObject();
              parama.put("fail_reason", 11);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "11", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            paramString1 = q.AHf;
            if ((n == q.dXf()) && (!locali.AFZ.containsKey(localObject1)))
            {
              Log.w("Finder.GlobalPushNewXmlConsumer", "just return! 当前推送的是修改push，但本地已经没有这个taskid");
              parama = new JSONObject();
              parama.put("fail_reason", 18);
              paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
              l1 = System.currentTimeMillis();
              parama = parama.toString();
              kotlin.g.b.s.s(parama, "json.toString()");
              paramString1.b(23498, new Object[] { localObject1, Integer.valueOf(2), Long.valueOf(l1), n.bV(parama, ",", ";"), Integer.valueOf(k), Integer.valueOf(i), localObject2, str1 });
              com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "18", Integer.valueOf(n), Integer.valueOf(i1) });
              AppMethodBeat.o(336174);
              return null;
            }
            paramString1 = q.AHf;
            if (n == q.dXe())
            {
              j = 1;
              if (j != 0)
              {
                paramString1 = q.AHf;
                if (n != q.dXf()) {
                  break label6306;
                }
                bool1 = true;
                paramString1 = paramMap.get(".sysmsg.content.object_id");
                parama = (CharSequence)paramString1;
                if (parama == null) {
                  break label6254;
                }
                if (parama.length() != 0) {
                  break label6312;
                }
                break label6254;
                paramString1 = (String)paramString1;
                if (paramString1 != null) {
                  break label6329;
                }
                paramString1 = "";
                l1 = com.tencent.mm.ae.d.FK(paramString1);
                parama = (String)paramMap.get(".sysmsg.content.nonce_id");
                if (parama != null) {
                  break label6332;
                }
                parama = "";
                localObject3 = (String)paramMap.get(".sysmsg.content.title");
                if (localObject3 != null) {
                  break label6335;
                }
                localObject3 = "";
                str2 = (String)paramMap.get(".sysmsg.content.body");
                if (str2 != null) {
                  break label6338;
                }
                str2 = "";
                localObject7 = (String)paramMap.get(".sysmsg.content.image_url");
                locald = new ah.d();
                locald.aixb = Util.safeParseInt((String)paramMap.get(".sysmsg.content.jump_to"));
                m = Util.safeParseInt((String)paramMap.get(".sysmsg.content.fail_return_to"));
                localObject4 = (String)paramMap.get(".sysmsg.content.bypass_info");
                if (localObject4 != null) {
                  break label6341;
                }
                localObject4 = "";
                i2 = Util.safeParseInt((String)paramMap.get(".sysmsg.content.action_type"));
                l2 = Util.safeParseLong((String)paramMap.get(".sysmsg.content.demotion_flag"));
                l3 = Util.safeParseLong((String)paramMap.get(".sysmsg.content.ctrl_flag"));
                i3 = Util.safeParseInt((String)paramMap.get(".sysmsg.content.bypass_type"));
                paramMap.get(".sysmsg.content.push_type");
                i4 = Util.safeParseInt((String)paramMap.get(".sysmsg.content.auth_icon_type"));
                i5 = Util.safeParseInt((String)paramMap.get(".sysmsg.content.alert_display_time"));
                j = locald.aixb;
                localObject5 = t.AHw;
                if (j == t.dXs()) {
                  break label6344;
                }
                j = 1;
                localObject6 = (String)paramMap.get(".sysmsg.content.jump_info");
                localObject5 = localObject6;
                if (localObject6 == null) {
                  localObject5 = "";
                }
                localObject5 = Base64.decode((String)localObject5, 0);
                if (localObject5 == null) {
                  break label6273;
                }
                if (localObject5.length != 0) {
                  break label6350;
                }
                break label6273;
              }
            }
            for (;;)
            {
              if (((CharSequence)localObject3).length() == 0)
              {
                k = 1;
                label5513:
                if (k != 0)
                {
                  Log.e("Finder.GlobalPushNewXmlConsumer", "title is null.");
                  com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "return", Long.valueOf(System.currentTimeMillis()), "12", Integer.valueOf(i2), Integer.valueOf(locald.aixb) });
                  label5586:
                  com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "notify", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(n), Integer.valueOf(i1) });
                  paramString1 = Result.constructor-impl(ah.aiuX);
                  break;
                  paramString1 = q.AHf;
                  if (n != q.dXf()) {
                    break label6300;
                  }
                  j = 1;
                  break label5086;
                  label5670:
                  localObject6 = t.AHw;
                  locald.aixb = t.dXv();
                  localObject6 = new FinderJumpInfo();
                  ((FinderJumpInfo)localObject6).parseFrom((byte[])localObject5);
                  localObject5 = localObject6;
                  continue;
                }
                localObject6 = MMApplicationContext.getContext().getResources().getString(e.h.finder_title);
                kotlin.g.b.s.s(localObject6, "getContext().resources.g…ng(R.string.finder_title)");
                localObject8 = r.AHk;
                if ((r.dXh() & l3) == 0L) {
                  break label6380;
                }
                bool2 = true;
                label5748:
                localObject8 = r.AHk;
                if ((r.dXl() & l3) == 0L) {
                  break label6386;
                }
                bool3 = true;
                label5767:
                localObject8 = (CharSequence)localObject7;
                if (localObject8 == null) {
                  break label6374;
                }
                if (((CharSequence)localObject8).length() != 0) {
                  break label6392;
                }
                break label6374;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (k != 0)
      {
        locali.a(parama, paramString1, l1, locald.aixb, (String)localObject4, i3, (String)localObject1, (String)localObject6, (String)localObject3, str2, null, bool2, bool3, l2, l3, m, i4, i5, paramString2, j, i, bool1, (String)localObject2, str1, (FinderJumpInfo)localObject5);
        break label5586;
      }
      localObject8 = kotlinx.coroutines.a.k.a(2147483647, null, 6);
      Object localObject9 = p.ExI;
      localObject9 = p.eCl();
      localObject7 = new com.tencent.mm.plugin.finder.loader.s((String)localObject7, v.FKY);
      p localp = p.ExI;
      ((com.tencent.mm.loader.d)localObject9).a(localObject7, p.a(p.a.ExQ)).a(new i..ExternalSyntheticLambda2((kotlinx.coroutines.a.h)localObject8)).a(new i..ExternalSyntheticLambda0((kotlinx.coroutines.a.h)localObject8)).a(new i..ExternalSyntheticLambda1((kotlinx.coroutines.a.h)localObject8)).blg();
      kotlinx.coroutines.k.x((m)new i.j((kotlinx.coroutines.a.h)localObject8, locali, parama, paramString1, l1, locald, (String)localObject4, i3, (String)localObject1, (String)localObject6, (String)localObject3, str2, bool2, bool3, l2, l3, m, i4, i5, paramString2, j, i, bool1, (String)localObject2, str1, (FinderJumpInfo)localObject5, i2, null));
      break label5586;
      break label1570;
      break label705;
      label6029:
      bool1 = true;
      break label276;
      label6035:
      bool5 = true;
      break label354;
      label6041:
      bool1 = true;
      break label390;
      label6047:
      if ((bool2) && (bool3))
      {
        i = 3;
        break label488;
        label6063:
        if (j != 0) {
          break label734;
        }
      }
      for (;;)
      {
        label6071:
        if (j != 0) {
          break label6186;
        }
        m = 1;
        break label785;
        label6082:
        break;
        label6085:
        break label149;
        label6088:
        bool2 = false;
        break label213;
        label6094:
        bool3 = false;
        break label232;
        label6100:
        bool4 = false;
        break label251;
        label6106:
        bool1 = false;
        break label276;
        label6112:
        bool5 = false;
        break label354;
        label6118:
        bool1 = false;
        break label390;
        bool1 = false;
        break label469;
        label6130:
        k = 2;
        break label6047;
        if ((bool2) && (!bool3))
        {
          i = 2;
          break label488;
        }
        if ((!bool2) && (bool3))
        {
          i = 1;
          break label488;
        }
        i = 0;
        break label488;
        label6174:
        j = 0;
        break label6063;
        label6180:
        j = 0;
      }
      label6186:
      m = 0;
      break label785;
      label6192:
      j = 0;
      break label920;
      label6198:
      j = 2;
      break label951;
      label6204:
      if (parama != null) {
        break label2241;
      }
      bool1 = false;
      break label2067;
      label6214:
      bool1 = false;
      break label2160;
      label6220:
      if (1L <= l1)
      {
        if (l1 <= i2)
        {
          j = 1;
          break label3077;
        }
        j = 0;
        break label3077;
      }
      j = 0;
      break label3077;
      label6254:
      j = 1;
      label6257:
      if (j == 0)
      {
        j = 1;
        label6265:
        if (j == 0) {
          break label6324;
        }
        break label5140;
        k = 1;
        if (k != 0) {
          break label6356;
        }
        k = 1;
        if (k == 0) {
          break label6362;
        }
      }
      for (;;)
      {
        label6273:
        label6276:
        label6284:
        if (localObject5 != null) {
          break label6366;
        }
        localObject5 = null;
        break label5497;
        label6300:
        j = 0;
        break;
        label6306:
        bool1 = false;
        break label5106;
        label6312:
        j = 0;
        break label6257;
        j = 0;
        break label6265;
        label6324:
        paramString1 = null;
        break label5140;
        label6329:
        break label5153;
        label6332:
        break label5180;
        label6335:
        break label5204;
        label6338:
        break label5228;
        label6341:
        break label5312;
        label6344:
        j = 2;
        break label5447;
        label6350:
        k = 0;
        break label6276;
        label6356:
        k = 0;
        break label6284;
        label6362:
        localObject5 = null;
      }
      label6366:
      break label5670;
      k = 0;
      break label5513;
      label6374:
      k = 1;
      continue;
      label6380:
      bool2 = false;
      break label5748;
      label6386:
      bool3 = false;
      break label5767;
      label6392:
      k = 0;
    }
  }
  
  private final void a(long paramLong, f paramf)
  {
    AppMethodBeat.i(336091);
    long l1;
    Object localObject;
    int i;
    boolean bool;
    if ((this.AGh) && (paramf != f.AGt) && (paramf != f.AGo))
    {
      l1 = SystemClock.uptimeMillis();
      if (this.AGf == -1L) {
        this.AGf = l1;
      }
      long l2 = this.AGf;
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (l1 - l2 > 2L * ((Number)com.tencent.mm.plugin.finder.storage.d.eXt().bmg()).intValue())
      {
        i = 1;
        if (i == 0) {
          break label259;
        }
        this.AGh = false;
      }
    }
    else
    {
      l1 = System.currentTimeMillis();
      bool = dWS();
      if (!bool)
      {
        this.hbN.removeCallbacks((Runnable)this.AGe);
        localObject = this.AGe;
        kotlin.g.b.s.u(paramf, "<set-?>");
        ((e)localObject).AGn = paramf;
        if (paramLong <= 0L) {
          break label266;
        }
        this.hbN.postDelayed((Runnable)this.AGe, paramLong);
      }
    }
    for (;;)
    {
      Log.i("Finder.GlobalPushNewXmlConsumer", "[checkPendTaskToRun] Cost=" + (System.currentTimeMillis() - l1) + "ms source=" + paramf + " delayMs=" + paramLong + " isCurrentSensitiveScene=" + bool + '[' + this.AGg + ']');
      AppMethodBeat.o(336091);
      return;
      i = 0;
      break;
      label259:
      AppMethodBeat.o(336091);
      return;
      label266:
      this.hbN.post((Runnable)this.AGe);
    }
  }
  
  private static void a(Intent paramIntent, int paramInt1, String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    AppMethodBeat.i(336207);
    t localt = t.AHw;
    if (paramInt4 == t.dXs()) {}
    for (paramIntent = (com.tencent.mm.plugin.forcenotify.c.e)new j(kotlin.g.b.s.X("notification-", Integer.valueOf(paramInt1)), paramString1, paramString2, paramBitmap, paramInt2, paramInt3 * 1000L, paramBoolean1, paramBoolean2, paramIntent); paramBoolean3; paramIntent = (com.tencent.mm.plugin.forcenotify.c.e)new k(kotlin.g.b.s.X("notification-", Integer.valueOf(paramInt1)), paramString1, paramString2, paramBitmap, paramInt2, paramInt3 * 1000L, paramBoolean1, paramBoolean2, paramIntent))
    {
      paramString1 = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
      b.a.fwZ().e((com.tencent.mm.plugin.forcenotify.c.a)paramIntent);
      AppMethodBeat.o(336207);
      return;
    }
    paramString1 = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
    b.a.fwZ().c((com.tencent.mm.plugin.forcenotify.c.a)paramIntent);
    paramIntent = com.tencent.mm.plugin.forcenotify.ui.b.HoY;
    b.a.fwZ().show();
    AppMethodBeat.o(336207);
  }
  
  private static final void a(i parami)
  {
    AppMethodBeat.i(336285);
    kotlin.g.b.s.u(parami, "this$0");
    parami.dWV();
    AppMethodBeat.o(336285);
  }
  
  private static final void a(i parami, String paramString, Map paramMap, g.a parama)
  {
    AppMethodBeat.i(336291);
    kotlin.g.b.s.u(parami, "this$0");
    kotlin.g.b.s.u(paramMap, "$values");
    kotlin.g.b.s.u(parama, "$addMsgInfo");
    parami.a(paramString, paramMap, parama, "4");
    AppMethodBeat.o(336291);
  }
  
  private final void a(String paramString1, String paramString2, long paramLong1, int paramInt1, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, long paramLong3, int paramInt3, int paramInt4, int paramInt5, String paramString8, int paramInt6, int paramInt7, boolean paramBoolean3, String paramString9, String paramString10, FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(336198);
    Object localObject = ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification();
    int i;
    label42:
    boolean bool1;
    label63:
    label118:
    boolean bool2;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label638;
      }
      i = paramString4.hashCode();
      localObject = (com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT;
      if (i != paramString4.hashCode()) {
        break label648;
      }
      bool1 = true;
      e.a.a((com.tencent.mm.ae.e)localObject, "FinderGlobalPushNewXmlConsumer", bool1, null, false, null, 60);
      localObject = t.AHw;
      if (paramInt1 != t.dXr()) {
        break label654;
      }
      paramString1 = a(paramString9, paramString10, paramString4, paramLong1, paramString1, paramString3, paramInt2, paramLong3, paramLong2, paramInt3, paramString8, paramInt6, paramInt7);
      paramString3 = new StringBuilder();
      paramString3.append("[notification] taskId=").append(paramString4).append(" feedIdStr=").append(paramString2).append(" jumpTo=").append(paramInt1).append(" ticker=").append(paramString5).append(" title=").append(paramString6).append(" content=").append(paramString7).append(" isModify=").append(paramBoolean3).append(" isNeedSound=").append(paramBoolean1).append(" demotionFlag=").append(paramLong2).append(" authIconType=").append(paramInt4).append(" alertDisplayTime=").append(paramInt5).append(" hasTaskId=");
      paramString2 = paramString3.append(this.AFZ.containsKey(paramString4)).append("largeIcon=");
      if (paramBitmap != null) {
        break label756;
      }
      paramLong1 = 0L;
      label284:
      paramString2.append(Util.getSizeKB(paramLong1));
      Log.i("Finder.GlobalPushNewXmlConsumer", paramString3.toString());
      paramString3 = PendingIntent.getActivity(MMApplicationContext.getContext(), i, paramString1, 134217728);
      if (!paramBoolean1) {
        break label766;
      }
      paramString2 = com.tencent.mm.bq.a.aQB();
      label327:
      paramString2 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), paramString2).o((CharSequence)paramString5).bt(System.currentTimeMillis()).l((CharSequence)paramString6).aC(true).m((CharSequence)paramString7);
      paramString2.bor = paramString3;
      paramString2 = paramString2.i(aj(paramBitmap));
      paramString2.q(2, false);
      paramString3 = paramString2.eb(com.tencent.mm.bq.a.guX()).DA();
      kotlin.g.b.s.s(paramString3, "getNotificationBuilder(M…s())\n            .build()");
      paramString2 = r.AHk;
      if ((r.dXj() & paramLong3) == 0L) {
        break label773;
      }
      paramInt2 = 1;
      label429:
      paramString2 = r.AHk;
      if ((r.dXk() & paramLong3) == 0L) {
        break label779;
      }
      bool1 = true;
      label447:
      bool2 = AppForegroundDelegate.heY.eLx;
      paramString2 = new i.d(i);
      if (!paramBoolean3) {
        break label840;
      }
      paramString5 = (i.d)this.AFZ.get(paramString4);
      if (paramString5 == null) {
        break label1044;
      }
      if (!paramString5.AGm) {
        break label785;
      }
      paramString2.AGm = true;
      a(paramString1, i, paramString6, paramString7, paramBitmap, paramBoolean1, paramBoolean2, paramInt4, paramInt5, paramInt1, true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(23498, new Object[] { paramString4, Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString9, paramString10 });
      ((Map)this.AFZ).put(paramString4, paramString2);
      dWU();
      AppMethodBeat.o(336198);
      return;
      localObject = Integer.valueOf(((ay)localObject).Cw(paramString4));
      break;
      label638:
      i = ((Integer)localObject).intValue();
      break label42;
      label648:
      bool1 = false;
      break label63;
      label654:
      localObject = t.AHw;
      if (paramInt1 == t.dXs())
      {
        paramFinderJumpInfo = s.AHq;
        paramString1 = b(paramString9, paramString10, paramString4, paramLong1, paramString1, paramString3, paramInt2, paramLong3, paramLong2, paramInt3, paramString8, paramInt6, paramInt7);
        break label118;
      }
      localObject = t.AHw;
      if (paramInt1 == t.dXv())
      {
        paramString1 = a(paramString9, paramString10, paramString4, paramLong1, paramString1, paramString3, paramInt2, paramLong3, paramLong2, paramInt3, paramString8, paramInt6, paramInt7, paramFinderJumpInfo);
        break label118;
      }
      AppMethodBeat.o(336198);
      return;
      label756:
      paramLong1 = paramBitmap.getAllocationByteCount();
      break label284;
      label766:
      paramString2 = "reminder_channel_id";
      break label327;
      label773:
      paramInt2 = 0;
      break label429;
      label779:
      bool1 = false;
      break label447;
      label785:
      paramString2.AGm = false;
      paramString1 = ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification();
      if (paramString1 != null)
      {
        paramString1.c(paramString3);
        paramString1.a(i, paramString3, false);
        paramString1 = ah.aiuX;
        paramString1 = ah.aiuX;
      }
    }
    label840:
    if ((bool2) && (paramInt2 != 0))
    {
      paramString2.AGm = true;
      a(paramString1, i, paramString6, paramString7, paramBitmap, paramBoolean1, paramBoolean2, paramInt4, paramInt5, paramInt1, false);
    }
    for (;;)
    {
      paramString1 = new JSONObject();
      paramString1.put("client_trigger_scene", paramString8);
      paramString3 = com.tencent.mm.plugin.report.service.h.OAn;
      paramLong1 = System.currentTimeMillis();
      paramString1 = paramString1.toString();
      kotlin.g.b.s.s(paramString1, "json.toString()");
      paramString3.b(23498, new Object[] { paramString4, Integer.valueOf(0), Long.valueOf(paramLong1), n.bV(paramString1, ",", ";"), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), paramString9, paramString10 });
      paramInt1 = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZL, 0);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZL, Integer.valueOf(paramInt1 + 1));
      ((Map)this.AFZ).put(paramString4, paramString2);
      dWU();
      label1044:
      AppMethodBeat.o(336198);
      return;
      if ((!bool2) && (bool1))
      {
        paramString2.AGm = false;
        paramString1 = ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification();
        if (paramString1 != null)
        {
          paramString1.c(paramString3);
          paramString1.a(i, paramString3, false);
          paramString1 = ah.aiuX;
          paramString1 = ah.aiuX;
        }
      }
      else
      {
        Log.e("Finder.GlobalPushNewXmlConsumer", "isAppForeground=" + bool2 + " isEnableInOutApp=" + bool1);
      }
    }
  }
  
  private static final void a(kotlinx.coroutines.a.h paramh, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(336299);
    kotlin.g.b.s.u(paramh, "$channel");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i.g(paramh, paramBitmap));
    AppMethodBeat.o(336299);
  }
  
  private static final void a(kotlinx.coroutines.a.h paramh, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(336317);
    kotlin.g.b.s.u(paramh, "$channel");
    Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("loadLinkIcon path :", paramString));
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i.i(paramh));
    AppMethodBeat.o(336317);
  }
  
  private static final void a(kotlinx.coroutines.a.h paramh, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(336309);
    kotlin.g.b.s.u(paramh, "$channel");
    Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("loadLinkIcon success :", Boolean.valueOf(paramBoolean)));
    if (!paramBoolean) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i.h(paramh));
    }
    AppMethodBeat.o(336309);
  }
  
  private static Bitmap aj(Bitmap paramBitmap)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(336266);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(336266);
      return paramBitmap;
    }
    if (paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight() == 1.0F) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(336266);
      return paramBitmap;
    }
    i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
    if (paramBitmap.getHeight() > paramBitmap.getWidth()) {}
    for (float f1 = (paramBitmap.getHeight() - paramBitmap.getWidth()) / 2.0F;; f1 = 0.0F)
    {
      if (paramBitmap.getHeight() < paramBitmap.getWidth()) {
        f2 = (paramBitmap.getWidth() - paramBitmap.getHeight()) / 2.0F;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, f1, f2, null);
      AppMethodBeat.o(336266);
      return localBitmap;
    }
  }
  
  private static String aj(Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(336275);
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (Exception localException) {}
    }
    paramMap = localJSONObject.toString();
    kotlin.g.b.s.s(paramMap, "json.toString()");
    AppMethodBeat.o(336275);
    return paramMap;
  }
  
  private static Map<String, String> avj(String paramString)
  {
    AppMethodBeat.i(336281);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (Map)new LinkedHashMap();
      AppMethodBeat.o(336281);
      return paramString;
    }
    HashMap localHashMap;
    try
    {
      paramString = new JSONObject(paramString);
      localHashMap = new HashMap();
      Iterator localIterator = paramString.keys();
      kotlin.g.b.s.s(localIterator, "jsonObj.keys()");
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Map localMap = (Map)localHashMap;
        kotlin.g.b.s.s(str, "it");
        localMap.put(str, paramString.get(str).toString());
        continue;
        AppMethodBeat.o(336281);
      }
    }
    catch (Exception paramString)
    {
      paramString = (Map)new LinkedHashMap();
    }
    for (;;)
    {
      return paramString;
      paramString = (Map)localHashMap;
    }
  }
  
  private static Intent b(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, String paramString5, int paramInt1, long paramLong2, long paramLong3, int paramInt2, String paramString6, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(336252);
    Intent localIntent = a(paramString1, paramString2, paramString3, paramLong1, paramString4, paramLong2, paramInt2, paramLong3, paramString6, paramInt3, paramInt4);
    localIntent.putExtra("KEY_ROUTE_TYPE", 1);
    localIntent.putExtra("KEY_JUMP_HOT_INTENT", (Parcelable)a(paramString1, paramString2, paramString3, paramLong1, paramString4, paramString5, paramInt1, paramLong2, paramLong3, paramInt2, paramString6, paramInt3, paramInt4));
    localIntent.putExtra("key_enter_live_param_visitor_enter_scene", 3);
    localIntent.putExtra("key_enter_live_param_by_pass_type", paramInt1);
    localIntent.putExtra("key_enter_live_param_by_pass_info", paramString5);
    localIntent.putExtra("KEY_ENTER_LIVE_PARAM_APP_PUSH_TASK_ID", paramString3);
    AppMethodBeat.o(336252);
    return localIntent;
  }
  
  private final boolean dWS()
  {
    AppMethodBeat.i(336079);
    if ((com.tencent.mm.n.a.s(MMApplicationContext.getContext(), false)) || (com.tencent.mm.n.a.aTe()) || (this.AGg) || (this.AGc))
    {
      AppMethodBeat.o(336079);
      return true;
    }
    AppMethodBeat.o(336079);
    return false;
  }
  
  private final void dWV()
  {
    AppMethodBeat.i(336218);
    int i;
    boolean bool;
    label228:
    Object localObject2;
    try
    {
      Object localObject1 = Result.Companion;
      i locali = (i)this;
      Object localObject3 = locali.AGb.getString("HITORY_NOTIFICATION_RECORD", "");
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      localObject3 = ((Iterable)n.a((CharSequence)localObject1, new String[] { ";" })).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if (((CharSequence)str).length() > 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            Object localObject4 = n.a((CharSequence)str, new String[] { "=" });
            if (((List)localObject4).size() != 2) {
              continue;
            }
            str = (String)((List)localObject4).get(0);
            localObject4 = n.a((CharSequence)((List)localObject4).get(1), new String[] { "@" });
            if (((List)localObject4).size() != 2) {
              continue;
            }
            i = Util.safeParseInt((String)((List)localObject4).get(0));
            if (Util.safeParseInt((String)((List)localObject4).get(1)) != 1) {
              break label317;
            }
            bool = true;
            localObject4 = (Map)locali.AFZ;
            i.d locald = new i.d(i);
            locald.AGm = bool;
            ((Map)localObject4).put(str, locald);
            continue;
            localObject2 = Result.exceptionOrNull-impl(localObject2);
          }
        }
      }
    }
    finally
    {
      localObject3 = Result.Companion;
      localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
    }
    for (;;)
    {
      if (localObject2 != null) {
        Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("[fillHistoryNotificationList] ", localObject2));
      }
      AppMethodBeat.o(336218);
      return;
      i = 0;
      break;
      label317:
      bool = false;
      break label228;
      Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("[fillHistoryNotificationList] ", localObject2));
      localObject2 = Result.constructor-impl(ah.aiuX);
    }
  }
  
  private static boolean dWW()
  {
    AppMethodBeat.i(336259);
    if ((z.bAR() & 0x0) == 0L)
    {
      AppMethodBeat.o(336259);
      return true;
    }
    AppMethodBeat.o(336259);
    return false;
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(336448);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(parama, "addMsgInfo");
    this.hbN.post(new i..ExternalSyntheticLambda4(this, paramString, paramMap, parama));
    AppMethodBeat.o(336448);
    return null;
  }
  
  public final void dWT()
  {
    AppMethodBeat.i(336455);
    for (;;)
    {
      long l;
      int i;
      try
      {
        l = com.tencent.mm.model.cn.bDv();
        localObject1 = l.AGV;
        l.mT(l - 259200000L);
        localObject1 = l.AGV;
        localObject1 = l.dXc();
        this.AGd.clear();
        localObject3 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label398;
        }
        localObject4 = (aw)((Iterator)localObject3).next();
        localObject1 = (CharSequence)((aw)localObject4).field_subType;
        if (((CharSequence)localObject1).length() != 0) {
          break label333;
        }
        i = 1;
      }
      finally
      {
        Object localObject1;
        String str2;
        Object localObject3 = new StringWriter();
        str1.printStackTrace(new PrintWriter((Writer)localObject3));
        e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "finderGlobalPushError", false, null, false, (kotlin.g.a.a)new i.l((StringWriter)localObject3), 28);
        AppMethodBeat.o(336455);
        return;
      }
      localObject1 = (String)localObject1;
      str2 = ((aw)localObject4).field_valuesJSON;
      kotlin.g.b.s.s(str2, "data.field_valuesJSON");
      Object localObject4 = new i.c((String)localObject1, avj(str2), null, ((aw)localObject4).field_pendingReason);
      localObject1 = (String)((i.c)localObject4).values.get(".sysmsg.content.task_id");
      if (localObject1 == null)
      {
        localObject1 = "";
        i = Util.safeParseInt((String)((i.c)localObject4).values.get(".sysmsg.content.last_deliver_time"));
        l = com.tencent.mm.model.cn.bDw();
        if ((i != 0) && (l / 1000L > i))
        {
          Log.i("Finder.GlobalPushNewXmlConsumer", "drop item taskId = " + (String)localObject1 + " lastDeliverTime = " + i + " now = " + l);
          localObject4 = l.AGV;
          l.avk((String)localObject1);
          continue;
          label333:
          i = 0;
          break label466;
        }
      }
      else
      {
        continue;
      }
      Log.i("Finder.GlobalPushNewXmlConsumer", "add item taskId = " + str1 + " lastDeliverTime = " + i + " now = " + l);
      this.AGd.add(localObject4);
      continue;
      label398:
      Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("loadPendingList from disk, size = ", Integer.valueOf(this.AGd.size())));
      Object localObject2 = l.AGV;
      l.dXd();
      this.AGh = true;
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      a(((Number)com.tencent.mm.plugin.finder.storage.d.eXt().bmg()).intValue(), f.AGt);
      AppMethodBeat.o(336455);
      return;
      label466:
      if (i != 0) {
        localObject2 = null;
      }
    }
  }
  
  final void dWU()
  {
    AppMethodBeat.i(336461);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = ((Map)this.AFZ).entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder2 = localStringBuilder1.append((String)localEntry.getKey()).append("=").append(((i.d)localEntry.getValue()).id).append("@");
      if (((i.d)localEntry.getValue()).AGm) {}
      for (int i = 1;; i = 0)
      {
        localStringBuilder2.append(i).append(";");
        break;
      }
    }
    this.AGb.putString("HITORY_NOTIFICATION_RECORD", localStringBuilder1.toString());
    Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("[updateHistoryNotificationListRecord] ", localStringBuilder1));
    AppMethodBeat.o(336461);
  }
  
  public final void pM(boolean paramBoolean)
  {
    AppMethodBeat.i(336442);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.AGg = bool;
      if (paramBoolean) {
        a(this, f.AGq);
      }
      AppMethodBeat.o(336442);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$PendingTask;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer;)V", "source", "Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$RunSource;", "getSource", "()Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$RunSource;", "setSource", "(Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$RunSource;)V", "run", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    implements Runnable
  {
    i.f AGn;
    
    public e()
    {
      AppMethodBeat.i(336098);
      this.AGn = i.f.AGs;
      AppMethodBeat.o(336098);
    }
    
    public final void run()
    {
      AppMethodBeat.i(336108);
      this.AGi.AGh = false;
      Log.i("Finder.GlobalPushNewXmlConsumer", kotlin.g.b.s.X("[pendingTask] dispatch delay task. size=", Integer.valueOf(i.b(this.AGi).size())));
      Object localObject1 = new LinkedList((Collection)i.b(this.AGi));
      i.b(this.AGi).clear();
      Object localObject2 = l.AGV;
      l.dXd();
      localObject1 = (Iterable)i.fX((List)localObject1);
      localObject2 = this.AGi;
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        i.c localc = (i.c)localIterator.next();
        if ((this.AGn == i.f.AGp) && (localc.AGl == 1)) {
          localObject1 = "1";
        }
        for (;;)
        {
          i.a((i)localObject2, localc.AGj, localc.values, localc.AGk, (String)localObject1);
          break;
          if ((this.AGn == i.f.AGq) && (localc.AGl == 1)) {
            localObject1 = "2";
          } else if ((this.AGn == i.f.AGo) && (localc.AGl == 1)) {
            localObject1 = "3";
          } else if ((this.AGn == i.f.AGq) && (localc.AGl == 2)) {
            localObject1 = "5";
          } else {
            localObject1 = "0";
          }
        }
      }
      AppMethodBeat.o(336108);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderGlobalPushNewXmlConsumer$RunSource;", "", "(Ljava/lang/String;I)V", "TAB", "FG", "EXIT", "NORMAL", "DEF", "LAUNCH", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum f
  {
    static
    {
      AppMethodBeat.i(335959);
      AGo = new f("TAB", 0);
      AGp = new f("FG", 1);
      AGq = new f("EXIT", 2);
      AGr = new f("NORMAL", 3);
      AGs = new f("DEF", 4);
      AGt = new f("LAUNCH", 5);
      AGu = new f[] { AGo, AGp, AGq, AGr, AGs, AGt };
      AppMethodBeat.o(335959);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i
 * JD-Core Version:    0.7.0.1
 */