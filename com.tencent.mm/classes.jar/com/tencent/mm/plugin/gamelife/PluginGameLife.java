package com.tencent.mm.plugin.gamelife;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.hl;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.gamelife.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.pluginsdk.model.app.l.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.y;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/PluginGameLife;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appMessageInterceptor", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "getAppMessageInterceptor", "()Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "appMessageInterceptor$delegate", "Lkotlin/Lazy;", "appMessageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "avatarPath", "", "getAvatarPath", "()Ljava/lang/String;", "setAvatarPath", "(Ljava/lang/String;)V", "cacheDBPath", "contactService", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "getContactService", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "contactService$delegate", "contactStorage", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "gameChatUnreadState", "", "Ljava/lang/Boolean;", "lock", "", "messageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "privateMsgConfig", "Lcom/tencent/mm/plugin/gamelife/config/GameLifeMsgConfig;", "getPrivateMsgConfig", "()Lcom/tencent/mm/plugin/gamelife/config/GameLifeMsgConfig;", "privateMsgConfig$delegate", "sessionInfoStorage", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkSessionIdAndContact", "", "selfUsername", "talker", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sessionId", "clearDB", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dealBlackList", "context", "Landroid/content/Context;", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "isAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "dependency", "enterChattingUI", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "outerUserName", "enterSendGift", "execute", "getAppMessageStorage", "getContactStorage", "getConversationStorage", "getDB", "getMessageStorage", "getSessionInfoStorage", "initDB", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "jumpToGameLifeSingleChatInfoUIReport", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "reportChattingDetail", "pos", "actionId", "", "selfUserName", "actionStatus", "reportGameChatUnreadState", "reportSingleChatInfoUIDetail", "dealWaGameAccountTogether", "accountType", "associate", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "resetDB", "showGameLifeDialog", "userName", "sessionInfo", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "testEnterChattingUI", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginGameLife
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, c
{
  public static final PluginGameLife.a IZa;
  private static final String IZj;
  private static final String IZk;
  public String AmC;
  private final kotlin.j Asq;
  private final MStorage.IOnStorageChange IVw;
  private final kotlin.j IZb;
  private final kotlin.j IZc;
  private com.tencent.mm.plugin.gamelife.e.c IZd;
  private com.tencent.mm.plugin.gamelife.k.c IZe;
  private com.tencent.mm.plugin.gamelife.f.e IZf;
  private com.tencent.mm.plugin.gamelife.h.d IZg;
  private com.tencent.mm.plugin.gamelife.h.c IZh;
  private Boolean IZi;
  private String Iem;
  private final byte[] lock;
  private com.tencent.mm.storagebase.h mCN;
  
  static
  {
    AppMethodBeat.i(268043);
    IZa = new PluginGameLife.a((byte)0);
    IZj = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    IZk = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    AppMethodBeat.o(268043);
  }
  
  public PluginGameLife()
  {
    AppMethodBeat.i(267757);
    this.lock = new byte[0];
    this.IZb = kotlin.k.cm((kotlin.g.a.a)c.IZm);
    this.IZc = kotlin.k.cm((kotlin.g.a.a)PluginGameLife.b.IZl);
    this.Asq = kotlin.k.cm((kotlin.g.a.a)PluginGameLife.g.IZx);
    this.IVw = new PluginGameLife..ExternalSyntheticLambda6(this);
    AppMethodBeat.o(267757);
  }
  
  private final void checkSessionIdAndContact(String paramString1, String paramString2, int paramInt, com.tencent.mm.bx.b paramb, kotlin.g.a.b<? super String, ah> paramb1)
  {
    AppMethodBeat.i(267784);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    LinkedList localLinkedList = new LinkedList();
    PluginGameLife..ExternalSyntheticLambda20 localExternalSyntheticLambda20 = new PluginGameLife..ExternalSyntheticLambda20(localAtomicInteger, localLinkedList, paramb1);
    ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).a(paramString1, paramString2, paramInt, paramb, new PluginGameLife..ExternalSyntheticLambda5(localAtomicInteger, paramb1, localLinkedList, localExternalSyntheticLambda20));
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a(p.listOf(new String[] { paramString1, paramString2 }), new PluginGameLife..ExternalSyntheticLambda4(paramString1, paramString2, localExternalSyntheticLambda20, localAtomicInteger, paramb1));
    AppMethodBeat.o(267784);
  }
  
  private static final void checkSessionIdAndContact$lambda-6(AtomicInteger paramAtomicInteger, LinkedList paramLinkedList, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(267846);
    s.u(paramAtomicInteger, "$finishedTask");
    s.u(paramLinkedList, "$sessionId");
    s.u(paramb, "$callback");
    if (paramAtomicInteger.incrementAndGet() == 2)
    {
      Log.i("GameLife.PluginGameLife", s.X("checkSessionIdAndContact success: ", paramLinkedList.get(0)));
      paramb.invoke(paramLinkedList.get(0));
    }
    AppMethodBeat.o(267846);
  }
  
  private static final void checkSessionIdAndContact$lambda-7(AtomicInteger paramAtomicInteger, kotlin.g.a.b paramb, LinkedList paramLinkedList, Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(267856);
    s.u(paramAtomicInteger, "$finishedTask");
    s.u(paramb, "$callback");
    s.u(paramLinkedList, "$sessionId");
    s.u(paramRunnable, "$whenFinish");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (paramAtomicInteger.getAndSet(-1) < 0) {
        break label115;
      }
      Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get session failed");
      paramb.invoke(null);
      AppMethodBeat.o(267856);
      return;
    }
    paramLinkedList.add(paramString);
    paramRunnable.run();
    label115:
    AppMethodBeat.o(267856);
  }
  
  private static final void checkSessionIdAndContact$lambda-8(String paramString1, String paramString2, Runnable paramRunnable, AtomicInteger paramAtomicInteger, kotlin.g.a.b paramb, Map paramMap)
  {
    AppMethodBeat.i(267862);
    s.u(paramString1, "$selfUsername");
    s.u(paramString2, "$talker");
    s.u(paramRunnable, "$whenFinish");
    s.u(paramAtomicInteger, "$finishedTask");
    s.u(paramb, "$callback");
    paramString1 = (com.tencent.mm.plugin.gamelife.a.a)paramMap.get(paramString1);
    if ((paramString1 != null) && (paramString1.isValid() == true))
    {
      i = 1;
      if (i == 0) {
        break label135;
      }
      paramString1 = (com.tencent.mm.plugin.gamelife.a.a)paramMap.get(paramString2);
      if ((paramString1 == null) || (paramString1.isValid() != true)) {
        break label129;
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label135;
      }
      paramRunnable.run();
      AppMethodBeat.o(267862);
      return;
      i = 0;
      break;
    }
    label135:
    if (paramAtomicInteger.getAndSet(-1) >= 0)
    {
      Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get contact failed");
      paramb.invoke(null);
    }
    AppMethodBeat.o(267862);
  }
  
  private static final String[] collectDatabaseFactory$lambda-20()
  {
    AppMethodBeat.i(267971);
    Object localObject = com.tencent.mm.plugin.gamelife.e.c.Jbo;
    localObject = com.tencent.mm.plugin.gamelife.e.c.dZh();
    AppMethodBeat.o(267971);
    return localObject;
  }
  
  private static final String[] collectDatabaseFactory$lambda-21()
  {
    AppMethodBeat.i(267979);
    Object localObject = com.tencent.mm.plugin.gamelife.k.c.JbS;
    localObject = com.tencent.mm.plugin.gamelife.k.c.dZh();
    AppMethodBeat.o(267979);
    return localObject;
  }
  
  private static final String[] collectDatabaseFactory$lambda-22()
  {
    AppMethodBeat.i(267987);
    Object localObject = com.tencent.mm.plugin.gamelife.f.e.Jbw;
    localObject = com.tencent.mm.plugin.gamelife.f.e.dZh();
    AppMethodBeat.o(267987);
    return localObject;
  }
  
  private static final String[] collectDatabaseFactory$lambda-23()
  {
    AppMethodBeat.i(267993);
    Object localObject = com.tencent.mm.plugin.gamelife.h.d.JbI;
    localObject = com.tencent.mm.plugin.gamelife.h.d.dZh();
    AppMethodBeat.o(267993);
    return localObject;
  }
  
  private static final String[] collectDatabaseFactory$lambda-24()
  {
    AppMethodBeat.i(267999);
    Object localObject = com.tencent.mm.plugin.gamelife.h.c.JbH;
    localObject = com.tencent.mm.plugin.gamelife.h.c.dZh();
    AppMethodBeat.o(267999);
    return localObject;
  }
  
  private static final void enterChattingUI$lambda-5(ah.f paramf, Context paramContext)
  {
    AppMethodBeat.i(267842);
    s.u(paramf, "$loadingDialog");
    s.u(paramContext, "$context");
    paramf.aqH = w.a(paramContext, (CharSequence)paramContext.getResources().getString(d.f.app_waiting), false, 0, PluginGameLife..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(267842);
  }
  
  private static final void enterChattingUI$lambda-5$lambda-4(DialogInterface paramDialogInterface) {}
  
  private final com.tencent.mm.plugin.gamelife.h.b getAppMessageInterceptor()
  {
    AppMethodBeat.i(267761);
    com.tencent.mm.plugin.gamelife.h.b localb = (com.tencent.mm.plugin.gamelife.h.b)this.IZc.getValue();
    AppMethodBeat.o(267761);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.e.b getContactService()
  {
    AppMethodBeat.i(267759);
    com.tencent.mm.plugin.gamelife.e.b localb = (com.tencent.mm.plugin.gamelife.e.b)this.IZb.getValue();
    AppMethodBeat.o(267759);
    return localb;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(267778);
    com.tencent.mm.storagebase.h localh = this.mCN;
    s.checkNotNull(localh);
    AppMethodBeat.o(267778);
    return localh;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.a getPrivateMsgConfig()
  {
    AppMethodBeat.i(267765);
    com.tencent.mm.plugin.gamelife.d.a locala = (com.tencent.mm.plugin.gamelife.d.a)this.Asq.getValue();
    AppMethodBeat.o(267765);
    return locala;
  }
  
  private final void initDB()
  {
    AppMethodBeat.i(267769);
    this.Iem = s.X(com.tencent.mm.kernel.h.baE().cachePath, "GameLife.db");
    com.tencent.mm.storagebase.h localh = this.mCN;
    Object localObject = localh;
    if (localh == null)
    {
      PluginGameLife localPluginGameLife = (PluginGameLife)this;
      localh = new com.tencent.mm.storagebase.h();
      String str = localPluginGameLife.Iem;
      localObject = str;
      if (str == null)
      {
        s.bIx("cacheDBPath");
        localObject = null;
      }
      if (!localh.a((String)localObject, localPluginGameLife.collectDatabaseFactory(), true))
      {
        localObject = new SQLiteException("GameLife db init failed");
        AppMethodBeat.o(267769);
        throw ((Throwable)localObject);
      }
      localObject = localh;
    }
    this.mCN = ((com.tencent.mm.storagebase.h)localObject);
    AppMethodBeat.o(267769);
  }
  
  private static final void onAccountInitialized$lambda-1(PluginGameLife paramPluginGameLife)
  {
    AppMethodBeat.i(267833);
    s.u(paramPluginGameLife, "this$0");
    paramPluginGameLife.reportGameChatUnreadState();
    AppMethodBeat.o(267833);
  }
  
  private final void reportChattingDetail(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(267820);
    com.tencent.mm.cp.g.jPX().i(new PluginGameLife..ExternalSyntheticLambda17(paramString1, paramString2, paramString3, paramInt, paramLong, paramString4)).jJM();
    AppMethodBeat.o(267820);
  }
  
  private static final Void reportChattingDetail$lambda-19(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, Void paramVoid)
  {
    AppMethodBeat.i(267966);
    s.u(paramString1, "$selfUserName");
    paramVoid = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(paramString1);
    if ((paramString2 != null) && (paramString3 != null))
    {
      com.tencent.mm.plugin.gamelife.a.a locala = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(paramString3);
      if (locala != null)
      {
        com.tencent.mm.game.report.c.a locala1 = com.tencent.mm.game.report.c.mtx;
        com.tencent.mm.game.report.c.a.a(paramInt, paramLong, paramString2, paramVoid.fIh(), paramString1, locala.fIh(), paramString3, paramString4);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(267966);
      return null;
      paramString2 = com.tencent.mm.game.report.c.mtx;
      com.tencent.mm.game.report.c.a.a(paramInt, paramLong, "", paramVoid.fIh(), paramString1, 0L, "", paramString4);
    }
  }
  
  private final void reportGameChatUnreadState()
  {
    try
    {
      AppMethodBeat.i(267829);
      if (this.IZi != null) {
        break label73;
      }
      Object localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acHS, Boolean.FALSE);
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(267829);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    this.IZi = Boolean.valueOf(((Boolean)localObject2).booleanValue());
    label73:
    Object localObject3 = this.IZi;
    if (localObject3 == null)
    {
      localObject3 = null;
      this.IZi = ((Boolean)localObject3);
      AppMethodBeat.o(267829);
      return;
    }
    boolean bool = ((Boolean)localObject3).booleanValue();
    int i = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).fIi();
    if (i > 0) {
      if (!bool) {
        break label181;
      }
    }
    for (;;)
    {
      Log.i("GameLife.PluginGameLife", "the state of game chat has changed, gameChatUnreadState:%b", new Object[] { Boolean.valueOf(bool) });
      localObject3 = com.tencent.mm.game.report.d.a.muI;
      com.tencent.mm.game.report.d.a.fs(bool);
      localObject3 = Boolean.valueOf(bool);
      break;
      label181:
      do
      {
        bool = false;
        break;
        do
        {
          break;
        } while ((i != 0) || (!bool));
      } while (i <= 0);
      bool = true;
    }
  }
  
  private final void reportSingleChatInfoUIDetail(int paramInt, long paramLong, String paramString1, String paramString2, String paramString3, Boolean paramBoolean1, Integer paramInteger, Boolean paramBoolean2)
  {
    AppMethodBeat.i(267806);
    com.tencent.mm.cp.g.jPX().i(new PluginGameLife..ExternalSyntheticLambda16(paramString2, paramString3, paramInteger, paramBoolean2, paramBoolean1, paramInt, paramLong, paramString1)).jJM();
    AppMethodBeat.o(267806);
  }
  
  private static final Void reportSingleChatInfoUIDetail$lambda-17(String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, long paramLong, String paramString3, Void paramVoid)
  {
    AppMethodBeat.i(267959);
    s.u(paramString1, "$selfUserName");
    s.u(paramString2, "$talker");
    s.u(paramString3, "$sessionId");
    paramVoid = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(paramString1);
    com.tencent.mm.plugin.gamelife.a.a locala = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(paramString2);
    int i = 0;
    if (paramInteger == null)
    {
      if (paramInteger != null) {
        break label311;
      }
      paramInteger = "";
    }
    for (;;)
    {
      paramBoolean1 = com.tencent.mm.game.report.c.mtx;
      long l1 = paramVoid.fIh();
      long l2 = locala.fIh();
      paramBoolean1 = Integer.valueOf(i);
      s.u(paramString3, "sessionId");
      s.u(paramString1, "fromUsername");
      s.u(paramString2, "toUsername");
      paramBoolean2 = com.tencent.mm.game.report.c.a.a(4L, 401L, paramInt, paramLong, 401L);
      paramBoolean2.rz(paramString3);
      paramBoolean2.iOy = l1;
      paramBoolean2.rx(paramString1);
      paramBoolean2.iOA = l2;
      paramBoolean2.ry(paramString2);
      paramBoolean2.rw(paramInteger);
      if ((paramBoolean1 != null) && (paramBoolean1.intValue() != 0))
      {
        paramString1 = new JSONObject();
        paramString1.put("role", paramBoolean1.intValue());
        paramBoolean2.rA(URLEncoder.encode(paramString1.toString()));
      }
      paramBoolean2.bMH();
      AppMethodBeat.o(267959);
      return null;
      if (paramInteger.intValue() != 1) {
        break;
      }
      if (paramBoolean1 != null) {
        if (paramBoolean1.booleanValue())
        {
          if (paramBoolean2 != null)
          {
            if (paramBoolean2.booleanValue())
            {
              i = 3;
              paramInteger = "1";
              continue;
            }
            i = 1;
            paramInteger = "0";
          }
        }
        else
        {
          i = 1;
          paramInteger = "";
          continue;
          label311:
          if (paramInteger.intValue() == 2)
          {
            i = 2;
            paramInteger = "";
            continue;
          }
        }
      }
      paramInteger = "";
    }
  }
  
  private final void resetDB()
  {
    AppMethodBeat.i(267775);
    com.tencent.mm.storagebase.h localh = this.mCN;
    if (localh != null) {
      localh.closeDB();
    }
    this.mCN = null;
    this.IZd = null;
    this.IZe = null;
    this.IZf = null;
    this.IZh = null;
    this.IZg = null;
    AppMethodBeat.o(267775);
  }
  
  private final void showGameLifeDialog(Context paramContext, String paramString, int paramInt, com.tencent.mm.plugin.appbrand.af.k<Boolean> paramk1, com.tencent.mm.plugin.appbrand.af.k<Boolean> paramk2, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame)
  {
    AppMethodBeat.i(267804);
    com.tencent.mm.ui.widget.a.j localj = new com.tencent.mm.ui.widget.a.j(paramContext, 1, 2, false);
    localj.aFf(d.d.IZY);
    Object localObject = localj.rootView.findViewById(d.c.IZJ);
    s.s(localObject, "dialog.rootView.findView…blacklist_notifymsg_text)");
    TextView localTextView1 = (TextView)localObject;
    localObject = localj.rootView.findViewById(d.c.IZK);
    s.s(localObject, "dialog.rootView.findView…agame_blacklist_checkbox)");
    CheckBox localCheckBox = (CheckBox)localObject;
    localObject = localj.rootView.findViewById(d.c.IZL);
    s.s(localObject, "dialog.rootView.findView…fe_wagame_blacklist_text)");
    TextView localTextView2 = (TextView)localObject;
    com.tencent.mm.plugin.appbrand.af.k localk = new com.tencent.mm.plugin.appbrand.af.k();
    localk.value = Boolean.TRUE;
    localCheckBox.setOnCheckedChangeListener(new PluginGameLife..ExternalSyntheticLambda1(localk));
    if (paramk1 == null) {}
    for (localObject = null; localObject == null; localObject = (Boolean)paramk1.value)
    {
      Log.e("GameLife.PluginGameLife", "showGameLifeDialog isBlackList null");
      AppMethodBeat.o(267804);
      return;
    }
    localObject = paramk1.value;
    s.s(localObject, "isBlackList.value");
    if (((Boolean)localObject).booleanValue())
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        localj.a(new PluginGameLife..ExternalSyntheticLambda12(paramb, paramk1, localj, paramk2, localk, this, parame, paramInt), new PluginGameLife..ExternalSyntheticLambda14(localj, paramk2, localk, paramString, this, parame, paramInt, paramk1, paramContext, paramb));
        localj.d((CharSequence)paramContext.getResources().getString(d.f.app_cancel), (CharSequence)paramContext.getResources().getString(d.f.Jal));
        localj.bh((CharSequence)paramContext.getResources().getString(d.f.Jam));
        localj.dDn();
        paramContext = parame.getSessionId();
        s.s(paramContext, "sessionInfo.sessionId");
        paramString = parame.getSelfUsername();
        s.s(paramString, "sessionInfo.selfUsername");
        paramk1 = parame.aJK();
        s.s(paramk1, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 7, 1L, paramContext, paramString, paramk1, null, null, null, 224, null);
        AppMethodBeat.o(267804);
        return;
        localTextView1.setText(d.f.Jao);
        localTextView2.setVisibility(8);
        localCheckBox.setVisibility(8);
        continue;
        localTextView1.setText(d.f.Jan);
        if (paramk2 != null)
        {
          localObject = paramk2.value;
          s.s(localObject, "isAssociateWithWAGame.value");
          if (((Boolean)localObject).booleanValue())
          {
            localTextView2.setText(d.f.Jap);
          }
          else
          {
            localCheckBox.setVisibility(8);
            localTextView2.setVisibility(8);
          }
        }
      }
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      localj.a(new PluginGameLife..ExternalSyntheticLambda15(localj, paramb, paramk1, paramk2, localk, this, parame, paramInt), new PluginGameLife..ExternalSyntheticLambda13(localj, paramk2, localk, paramString, this, parame, paramInt, paramk1, paramContext, paramb));
      localj.aFb(paramContext.getResources().getColor(d.a.normal_text_color));
      localj.aFd(2);
      localj.d((CharSequence)paramContext.getResources().getString(d.f.app_cancel), (CharSequence)paramContext.getResources().getString(d.f.Jak));
      localj.bh((CharSequence)paramContext.getResources().getString(d.f.Jag));
      localj.dDn();
      paramContext = parame.getSessionId();
      s.s(paramContext, "sessionInfo.sessionId");
      paramString = parame.getSelfUsername();
      s.s(paramString, "sessionInfo.selfUsername");
      paramk1 = parame.aJK();
      s.s(paramk1, "sessionInfo.talker");
      reportSingleChatInfoUIDetail$default(this, 6, 1L, paramContext, paramString, paramk1, null, null, null, 224, null);
      AppMethodBeat.o(267804);
      return;
      localTextView1.setText(d.f.Jai);
      localCheckBox.setVisibility(8);
      continue;
      localTextView1.setText(d.f.Jah);
      if (paramk2 != null)
      {
        localObject = paramk2.value;
        s.s(localObject, "isAssociateWithWAGame.value");
        if (((Boolean)localObject).booleanValue())
        {
          localTextView2.setText(d.f.Jaj);
        }
        else
        {
          localCheckBox.setVisibility(8);
          localTextView2.setVisibility(8);
        }
      }
    }
  }
  
  private static final void showGameLifeDialog$lambda-10(com.tencent.mm.plugin.appbrand.af.k paramk, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(267866);
    s.u(paramk, "$dealWaGameAccountTogetherCheckBox");
    paramk.value = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(267866);
  }
  
  private static final void showGameLifeDialog$lambda-11(c.b paramb, com.tencent.mm.plugin.appbrand.af.k paramk1, com.tencent.mm.ui.widget.a.j paramj, com.tencent.mm.plugin.appbrand.af.k paramk2, com.tencent.mm.plugin.appbrand.af.k paramk3, PluginGameLife paramPluginGameLife, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt)
  {
    AppMethodBeat.i(267872);
    s.u(paramb, "$callback");
    s.u(paramk1, "$isBlackList");
    s.u(paramj, "$dialog");
    s.u(paramk2, "$isAssociateWithWAGame");
    s.u(paramk3, "$dealWaGameAccountTogetherCheckBox");
    s.u(paramPluginGameLife, "this$0");
    s.u(parame, "$sessionInfo");
    paramk1 = paramk1.value;
    s.s(paramk1, "isBlackList.value");
    paramb.onDone(((Boolean)paramk1).booleanValue());
    paramj.cyW();
    paramb = paramk2.value;
    s.s(paramb, "isAssociateWithWAGame.value");
    if (((Boolean)paramb).booleanValue())
    {
      paramb = paramk3.value;
      s.s(paramb, "dealWaGameAccountTogetherCheckBox.value");
      if (!((Boolean)paramb).booleanValue()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramb = parame.getSessionId();
      s.s(paramb, "sessionInfo.sessionId");
      paramk1 = parame.getSelfUsername();
      s.s(paramk1, "sessionInfo.selfUsername");
      paramj = parame.aJK();
      s.s(paramj, "sessionInfo.talker");
      paramPluginGameLife.reportSingleChatInfoUIDetail(7, 4L, paramb, paramk1, paramj, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)paramk2.value);
      AppMethodBeat.o(267872);
      return;
    }
  }
  
  private static final void showGameLifeDialog$lambda-13(com.tencent.mm.ui.widget.a.j paramj, com.tencent.mm.plugin.appbrand.af.k paramk1, com.tencent.mm.plugin.appbrand.af.k paramk2, String paramString, PluginGameLife paramPluginGameLife, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt, com.tencent.mm.plugin.appbrand.af.k paramk3, Context paramContext, c.b paramb)
  {
    AppMethodBeat.i(267895);
    s.u(paramj, "$dialog");
    s.u(paramk1, "$isAssociateWithWAGame");
    s.u(paramk2, "$dealWaGameAccountTogetherCheckBox");
    s.u(paramString, "$userName");
    s.u(paramPluginGameLife, "this$0");
    s.u(parame, "$sessionInfo");
    s.u(paramk3, "$isBlackList");
    s.u(paramContext, "$context");
    s.u(paramb, "$callback");
    paramj.cyW();
    paramj = new ah.a();
    Object localObject = paramk1.value;
    s.s(localObject, "isAssociateWithWAGame.value");
    if (((Boolean)localObject).booleanValue())
    {
      paramk2 = paramk2.value;
      s.s(paramk2, "dealWaGameAccountTogetherCheckBox.value");
      if (!((Boolean)paramk2).booleanValue()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramj.aiwY = bool;
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, false, paramj.aiwY, new PluginGameLife..ExternalSyntheticLambda3(paramString, paramj, paramk3, paramContext, paramb));
      paramk2 = parame.getSessionId();
      s.s(paramk2, "sessionInfo.sessionId");
      paramString = parame.getSelfUsername();
      s.s(paramString, "sessionInfo.selfUsername");
      parame = parame.aJK();
      s.s(parame, "sessionInfo.talker");
      paramPluginGameLife.reportSingleChatInfoUIDetail(7, 64L, paramk2, paramString, parame, Boolean.valueOf(paramj.aiwY), Integer.valueOf(paramInt), (Boolean)paramk1.value);
      AppMethodBeat.o(267895);
      return;
    }
  }
  
  private static final void showGameLifeDialog$lambda-13$lambda-12(String paramString, ah.a parama, com.tencent.mm.plugin.appbrand.af.k paramk, Context paramContext, c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(267882);
    s.u(paramString, "$userName");
    s.u(parama, "$dealWaGameTogether");
    s.u(paramk, "$isBlackList");
    s.u(paramContext, "$context");
    s.u(paramb, "$callback");
    Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(parama.aiwY) });
    if (paramBoolean) {
      if (!((Boolean)paramk.value).booleanValue())
      {
        paramBoolean = true;
        paramk.value = Boolean.valueOf(paramBoolean);
      }
    }
    for (;;)
    {
      paramString = paramk.value;
      s.s(paramString, "isBlackList.value");
      paramb.onDone(((Boolean)paramString).booleanValue());
      AppMethodBeat.o(267882);
      return;
      paramBoolean = false;
      break;
      Toast.makeText(paramContext, d.f.Jax, 0).show();
    }
  }
  
  private static final void showGameLifeDialog$lambda-14(com.tencent.mm.ui.widget.a.j paramj, c.b paramb, com.tencent.mm.plugin.appbrand.af.k paramk1, com.tencent.mm.plugin.appbrand.af.k paramk2, com.tencent.mm.plugin.appbrand.af.k paramk3, PluginGameLife paramPluginGameLife, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt)
  {
    AppMethodBeat.i(267920);
    s.u(paramj, "$dialog");
    s.u(paramb, "$callback");
    s.u(paramk1, "$isBlackList");
    s.u(paramk2, "$isAssociateWithWAGame");
    s.u(paramk3, "$dealWaGameAccountTogetherCheckBox");
    s.u(paramPluginGameLife, "this$0");
    s.u(parame, "$sessionInfo");
    paramj.cyW();
    paramj = paramk1.value;
    s.s(paramj, "isBlackList.value");
    paramb.onDone(((Boolean)paramj).booleanValue());
    paramj = paramk2.value;
    s.s(paramj, "isAssociateWithWAGame.value");
    if (((Boolean)paramj).booleanValue())
    {
      paramj = paramk3.value;
      s.s(paramj, "dealWaGameAccountTogetherCheckBox.value");
      if (!((Boolean)paramj).booleanValue()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramj = parame.getSessionId();
      s.s(paramj, "sessionInfo.sessionId");
      paramb = parame.getSelfUsername();
      s.s(paramb, "sessionInfo.selfUsername");
      paramk1 = parame.aJK();
      s.s(paramk1, "sessionInfo.talker");
      paramPluginGameLife.reportSingleChatInfoUIDetail(6, 4L, paramj, paramb, paramk1, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)paramk2.value);
      AppMethodBeat.o(267920);
      return;
    }
  }
  
  private static final void showGameLifeDialog$lambda-16(com.tencent.mm.ui.widget.a.j paramj, com.tencent.mm.plugin.appbrand.af.k paramk1, com.tencent.mm.plugin.appbrand.af.k paramk2, String paramString, PluginGameLife paramPluginGameLife, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt, com.tencent.mm.plugin.appbrand.af.k paramk3, Context paramContext, c.b paramb)
  {
    AppMethodBeat.i(267943);
    s.u(paramj, "$dialog");
    s.u(paramk1, "$isAssociateWithWAGame");
    s.u(paramk2, "$dealWaGameAccountTogetherCheckBox");
    s.u(paramString, "$userName");
    s.u(paramPluginGameLife, "this$0");
    s.u(parame, "$sessionInfo");
    s.u(paramk3, "$isBlackList");
    s.u(paramContext, "$context");
    s.u(paramb, "$callback");
    paramj.cyW();
    paramj = new ah.a();
    Object localObject = paramk1.value;
    s.s(localObject, "isAssociateWithWAGame.value");
    if (((Boolean)localObject).booleanValue())
    {
      paramk2 = paramk2.value;
      s.s(paramk2, "dealWaGameAccountTogetherCheckBox.value");
      if (!((Boolean)paramk2).booleanValue()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramj.aiwY = bool;
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, true, paramj.aiwY, new PluginGameLife..ExternalSyntheticLambda2(paramString, paramj, paramk3, paramContext, paramb));
      paramk2 = parame.getSessionId();
      s.s(paramk2, "sessionInfo.sessionId");
      paramString = parame.getSelfUsername();
      s.s(paramString, "sessionInfo.selfUsername");
      parame = parame.aJK();
      s.s(parame, "sessionInfo.talker");
      paramPluginGameLife.reportSingleChatInfoUIDetail(6, 65L, paramk2, paramString, parame, Boolean.valueOf(paramj.aiwY), Integer.valueOf(paramInt), (Boolean)paramk1.value);
      AppMethodBeat.o(267943);
      return;
    }
  }
  
  private static final void showGameLifeDialog$lambda-16$lambda-15(String paramString, ah.a parama, com.tencent.mm.plugin.appbrand.af.k paramk, Context paramContext, c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(267931);
    s.u(paramString, "$userName");
    s.u(parama, "$dealWaGameTogether");
    s.u(paramk, "$isBlackList");
    s.u(paramContext, "$context");
    s.u(paramb, "$callback");
    Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b ", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(parama.aiwY) });
    if (paramBoolean) {
      if (!((Boolean)paramk.value).booleanValue())
      {
        paramBoolean = true;
        paramk.value = Boolean.valueOf(paramBoolean);
      }
    }
    for (;;)
    {
      paramString = paramk.value;
      s.s(paramString, "isBlackList.value");
      paramb.onDone(((Boolean)paramString).booleanValue());
      AppMethodBeat.o(267931);
      return;
      paramBoolean = false;
      break;
      Toast.makeText(paramContext, d.f.Jar, 0).show();
    }
  }
  
  private static final void storageChange$lambda-26(PluginGameLife paramPluginGameLife, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(268015);
    s.u(paramPluginGameLife, "this$0");
    if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.f.a)) {
      com.tencent.threadpool.h.ahAA.g(new PluginGameLife..ExternalSyntheticLambda19(paramPluginGameLife), "reportGameChatUnreadState");
    }
    AppMethodBeat.o(268015);
  }
  
  private static final void storageChange$lambda-26$lambda-25(PluginGameLife paramPluginGameLife)
  {
    AppMethodBeat.i(268005);
    s.u(paramPluginGameLife, "this$0");
    paramPluginGameLife.reportGameChatUnreadState();
    AppMethodBeat.o(268005);
  }
  
  public final void clearDB()
  {
    AppMethodBeat.i(268252);
    String str2 = this.Iem;
    String str1 = str2;
    if (str2 == null)
    {
      s.bIx("cacheDBPath");
      str1 = null;
    }
    y.deleteFile(str1);
    resetDB();
    initDB();
    AppMethodBeat.o(268252);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(268328);
    HashMap localHashMap = ak.g(new r[] { v.Y(Integer.valueOf("GameLifeContact".hashCode()), PluginGameLife..ExternalSyntheticLambda11.INSTANCE), v.Y(Integer.valueOf("GameLifeSessionInfo".hashCode()), PluginGameLife..ExternalSyntheticLambda8.INSTANCE), v.Y(Integer.valueOf("GameLifeConversation".hashCode()), PluginGameLife..ExternalSyntheticLambda10.INSTANCE), v.Y(Integer.valueOf("gamelifemessage".hashCode()), PluginGameLife..ExternalSyntheticLambda9.INSTANCE), v.Y(Integer.valueOf("AppMessage".hashCode()), PluginGameLife..ExternalSyntheticLambda7.INSTANCE) });
    AppMethodBeat.o(268328);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(268249);
    af.b("gamelife", "gamelife/avatar", 536870912L, 7776000000L, 1);
    AppMethodBeat.o(268249);
  }
  
  public final void dealBlackList(final Context paramContext, final String paramString, com.tencent.mm.plugin.appbrand.af.k<Boolean> paramk1, final com.tencent.mm.plugin.appbrand.af.k<Boolean> paramk2, final c.b paramb)
  {
    AppMethodBeat.i(268323);
    s.u(paramk1, "isBlackList");
    s.u(paramk2, "isAssociateWithWAGame");
    s.u(paramb, "callback");
    if (paramContext == null)
    {
      AppMethodBeat.o(268323);
      return;
    }
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aHz(paramString);
    Object localObject1 = paramString.aJK();
    Object localObject2 = paramString.getSelfUsername();
    String str = paramString.getSessionId();
    s.s(str, "sessionInfo.sessionId");
    s.s(localObject2, "selfUserName");
    s.s(localObject1, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 5, 2L, str, (String)localObject2, (String)localObject1, null, null, null, 224, null);
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu((String)localObject1);
    final int i = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).fIh();
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
    if (i <= 0)
    {
      Toast.makeText(paramContext, d.f.Jaq, 0).show();
      AppMethodBeat.o(268323);
      return;
    }
    if (i == 2)
    {
      if ((paramk1.value != null) && (paramk2.value != null))
      {
        s.s(localObject1, "userName");
        s.s(paramString, "sessionInfo");
        showGameLifeDialog(paramContext, (String)localObject1, i, paramk1, paramk2, paramb, paramString);
        AppMethodBeat.o(268323);
      }
    }
    else if (i == 1)
    {
      localObject2 = (ProgressDialog)w.a(paramContext, (CharSequence)paramContext.getResources().getString(d.f.app_waiting), true, 3, null);
      s.checkNotNull(localObject2);
      ((ProgressDialog)localObject2).show();
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a((String)localObject1, (b.a)new d(paramk1, paramk2, (String)localObject1, (ProgressDialog)localObject2, this, paramContext, i, paramb, paramString));
    }
    AppMethodBeat.o(268323);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(268336);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    AppMethodBeat.o(268336);
  }
  
  public final void enterChattingUI(Context paramContext, String paramString1, String paramString2, int paramInt, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(268294);
    s.u(paramContext, "context");
    s.u(paramString1, "selfUsername");
    s.u(paramString2, "talker");
    ah.f localf = new ah.f();
    com.tencent.threadpool.i.d locald = com.tencent.threadpool.h.ahAA.o(new PluginGameLife..ExternalSyntheticLambda21(localf, paramContext), 1000L);
    ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).fIl();
    checkSessionIdAndContact(paramString1, paramString2, paramInt, paramb, (kotlin.g.a.b)new PluginGameLife.e(locald, localf, paramString1, paramContext));
    AppMethodBeat.o(268294);
  }
  
  public final void enterExpose(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(268307);
    s.u(paramIntent, "intent");
    s.u(paramString, "sessionId");
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aHz(paramString);
    paramString = locale.aJK();
    Log.d("GameLife.PluginGameLife", "talkerName:%s", new Object[] { paramString });
    paramIntent.putExtra("k_username", paramString);
    Object localObject = am.aixg;
    localObject = f.f.adwh;
    s.s(localObject, "KExposeGameLifeUrl");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(39) }, 1));
    s.s(localObject, "java.lang.String.format(format, *args)");
    paramIntent.putExtra("rawUrl", (String)localObject);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    paramContext = locale.getSelfUsername();
    paramIntent = locale.getSessionId();
    s.s(paramIntent, "sessionInfo.sessionId");
    s.s(paramContext, "selfUserName");
    s.s(paramString, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 8, 40L, paramIntent, paramContext, paramString, null, null, null, 224, null);
    AppMethodBeat.o(268307);
  }
  
  public final void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(268301);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(268301);
      return;
    }
    if (paramInt == a.IYW) {
      if (au.bwX(paramString)) {
        reportChattingDetail(2, 7L, paramString, null, null, "1");
      }
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(paramString);
      label107:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).fIg();
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label352;
        }
      }
      label352:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label357;
        }
        Log.e("GameLife.PluginGameLife", "userName:%s,jumpUrl null");
        AppMethodBeat.o(268301);
        return;
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aHz(paramString);
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).aJK();
        s.s(paramString, "sessionInfo.talker");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSelfUsername();
        s.s(localObject2, "sessionInfo.selfUsername");
        reportChattingDetail(2, 7L, (String)localObject2, ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSessionId(), ((com.tencent.mm.plugin.gamelife.a.e)localObject1).aJK(), "2");
        break;
        if (paramInt != a.IYV) {
          break label415;
        }
        Object localObject3 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aHz(paramString);
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).aJK();
        s.s(paramString, "sessionInfo.talker");
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSessionId();
        s.s(localObject1, "sessionInfo.sessionId");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
        s.s(localObject2, "sessionInfo.selfUsername");
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).aJK();
        s.s(localObject3, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 2, 7L, (String)localObject1, (String)localObject2, (String)localObject3, null, null, null, 224, null);
        break;
        localObject1 = "";
        break label107;
      }
      label357:
      Log.i("GameLife.PluginGameLife", "userName:%s,jumpUrl:%s", new Object[] { paramString, localObject1 });
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject1);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(268301);
      return;
      label415:
      paramString = "";
    }
  }
  
  public final void enterSendGift(Context paramContext, String paramString)
  {
    AppMethodBeat.i(268320);
    s.u(paramContext, "context");
    s.u(paramString, "sessionId");
    Log.i("GameLife.PluginGameLife", "enterSendGift sessionId[%s]", new Object[] { paramString });
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aHz(paramString);
    if (locale != null)
    {
      com.tencent.mm.plugin.gamelife.a.a locala = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(locale.getSelfUsername());
      Object localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(locale.aJK());
      long l1;
      long l2;
      if ((locala != null) && (localObject1 != null))
      {
        Object localObject2 = com.tencent.mm.game.report.c.mtx;
        l1 = locala.fIh();
        Object localObject3 = locala.getUsername();
        s.s(localObject3, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).fIh();
        String str = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        s.s(str, "talkerContact.username");
        s.u(paramString, "sessionId");
        s.u(localObject3, "fromUsername");
        s.u(str, "toUsername");
        localObject2 = com.tencent.mm.game.report.c.a.a(3L, 302L, 2L, 2L, 301L);
        ((hl)localObject2).rz(paramString);
        ((hl)localObject2).iOy = l1;
        ((hl)localObject2).rx((String)localObject3);
        ((hl)localObject2).iOA = l2;
        ((hl)localObject2).ry(str);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("ser_name", 4L);
        ((hl)localObject2).rA(URLEncoder.encode(((JSONObject)localObject3).toString()));
        ((hl)localObject2).bMH();
      }
      int i = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.c.class)).H(paramContext, locale.getSelfUsername(), locale.aJK());
      if ((locala != null) && (localObject1 != null))
      {
        if (i == 40)
        {
          paramContext = com.tencent.mm.game.report.c.mtx;
          l1 = locala.fIh();
          paramContext = locala.getUsername();
          s.s(paramContext, "selfContact.username");
          l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).fIh();
          localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
          s.s(localObject1, "talkerContact.username");
          com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 40L);
          AppMethodBeat.o(268320);
          return;
        }
        paramContext = com.tencent.mm.game.report.c.mtx;
        l1 = locala.fIh();
        paramContext = locala.getUsername();
        s.s(paramContext, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).fIh();
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        s.s(localObject1, "talkerContact.username");
        com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 71L);
      }
    }
    AppMethodBeat.o(268320);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(268240);
    s.u(paramg, "profile");
    if (paramg.bbA())
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.f.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.k.b());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.b.class, (com.tencent.mm.kernel.c.a)getContactService());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.c.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.f.d());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.d.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.i.a());
    }
    AppMethodBeat.o(268240);
  }
  
  public final com.tencent.mm.plugin.gamelife.h.c getAppMessageStorage()
  {
    AppMethodBeat.i(268270);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.gamelife.h.c localc2 = this.IZh;
    com.tencent.mm.plugin.gamelife.h.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.h.c((ISQLiteDatabase)getDB());
    }
    this.IZh = localc1;
    localc1 = this.IZh;
    s.checkNotNull(localc1);
    AppMethodBeat.o(268270);
    return localc1;
  }
  
  public final String getAvatarPath()
  {
    AppMethodBeat.i(268226);
    String str = this.AmC;
    if (str != null)
    {
      AppMethodBeat.o(268226);
      return str;
    }
    s.bIx("avatarPath");
    AppMethodBeat.o(268226);
    return null;
  }
  
  public final com.tencent.mm.plugin.gamelife.e.c getContactStorage()
  {
    AppMethodBeat.i(268261);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.gamelife.e.c localc2 = this.IZd;
    com.tencent.mm.plugin.gamelife.e.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.e.c((ISQLiteDatabase)getDB());
    }
    this.IZd = localc1;
    localc1 = this.IZd;
    s.checkNotNull(localc1);
    AppMethodBeat.o(268261);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.gamelife.f.e getConversationStorage()
  {
    AppMethodBeat.i(268267);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.gamelife.f.e locale2 = this.IZf;
    com.tencent.mm.plugin.gamelife.f.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new com.tencent.mm.plugin.gamelife.f.e((ISQLiteDatabase)getDB());
    }
    this.IZf = locale1;
    locale1 = this.IZf;
    s.checkNotNull(locale1);
    AppMethodBeat.o(268267);
    return locale1;
  }
  
  public final com.tencent.mm.plugin.gamelife.h.d getMessageStorage()
  {
    AppMethodBeat.i(268291);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ();
    com.tencent.mm.plugin.gamelife.h.d locald2 = this.IZg;
    com.tencent.mm.plugin.gamelife.h.d locald1 = locald2;
    if (locald2 == null)
    {
      s.s(locali, "msgStg");
      locald1 = new com.tencent.mm.plugin.gamelife.h.d(locali);
    }
    this.IZg = locald1;
    locald1 = this.IZg;
    s.checkNotNull(locald1);
    AppMethodBeat.o(268291);
    return locald1;
  }
  
  public final com.tencent.mm.plugin.gamelife.k.c getSessionInfoStorage()
  {
    AppMethodBeat.i(268264);
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.gamelife.k.c localc2 = this.IZe;
    com.tencent.mm.plugin.gamelife.k.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.k.c((ISQLiteDatabase)getDB());
    }
    this.IZe = localc1;
    localc1 = this.IZe;
    s.checkNotNull(localc1);
    AppMethodBeat.o(268264);
    return localc1;
  }
  
  public final void initGameLifeSingleChatInfoUI(Context paramContext, String paramString, c.a parama)
  {
    AppMethodBeat.i(268313);
    if (paramContext == null)
    {
      AppMethodBeat.o(268313);
      return;
    }
    Object localObject = com.tencent.mm.game.report.c.mtx;
    com.tencent.mm.game.report.c.a.a(4L, 0L, 0L, 1L, 301L).bMH();
    localObject = w.a(paramContext, (CharSequence)paramContext.getResources().getString(d.f.app_waiting), true, 3, null);
    s.s(localObject, "show(context, context.re…TLE_TRANSPARENT_BG, null)");
    localObject = (ProgressDialog)localObject;
    ((ProgressDialog)localObject).show();
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aAw(paramString);
    paramString = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).aHu(paramString);
    String str = paramString.getUsername();
    if (paramString.fIh() <= 0)
    {
      Toast.makeText(paramContext, d.f.Jaq, 0).show();
      AppMethodBeat.o(268313);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.b.class)).a(str, (b.a)new PluginGameLife.f((ProgressDialog)localObject, parama, paramContext));
    AppMethodBeat.o(268313);
  }
  
  public final void jumpToGameLifeSingleChatInfoUIReport(String paramString)
  {
    AppMethodBeat.i(268297);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.PluginGameLife", "jumpToGameLifeSingleChatInfoUI sessionId null!");
      AppMethodBeat.o(268297);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.f.class)).aHz(paramString);
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).aJK();
    localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).getSelfUsername();
    s.s(localObject2, "selfUserName");
    reportChattingDetail$default(this, 1, 6L, (String)localObject2, paramString, (String)localObject1, null, 32, null);
    AppMethodBeat.o(268297);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(268244);
    Log.i("GameLife.PluginGameLife", "Account Init");
    initDB();
    setAvatarPath(s.X(com.tencent.mm.kernel.h.baE().mCJ, "gamelife/avatar/"));
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a((com.tencent.mm.storage.e)getMessageStorage());
    paramc = com.tencent.mm.plugin.openapi.a.gxo();
    l.b localb = (l.b)getAppMessageInterceptor();
    if (localb != null) {
      paramc.XSx.XSy.put(localb, new Object());
    }
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.IVw);
    com.tencent.threadpool.h.ahAA.p(new PluginGameLife..ExternalSyntheticLambda18(this), 1000L);
    com.tencent.mm.plugin.byp.c.f.waY.a((com.tencent.mm.plugin.byp.c.e)getPrivateMsgConfig());
    AppMethodBeat.o(268244);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(268332);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(3);
    l locall = com.tencent.mm.plugin.openapi.a.gxo();
    l.b localb = (l.b)getAppMessageInterceptor();
    locall.XSx.XSy.remove(localb);
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.IVw);
    resetDB();
    AppMethodBeat.o(268332);
  }
  
  public final void setAvatarPath(String paramString)
  {
    AppMethodBeat.i(268235);
    s.u(paramString, "<set-?>");
    this.AmC = paramString;
    AppMethodBeat.o(268235);
  }
  
  public final void testEnterChattingUI()
  {
    AppMethodBeat.i(268256);
    PluginGameLife localPluginGameLife = (PluginGameLife)com.tencent.mm.kernel.h.az(PluginGameLife.class);
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    localPluginGameLife.enterChattingUI(localContext, IZj, IZk, 0, null);
    AppMethodBeat.o(268256);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.e.b>
  {
    public static final c IZm;
    
    static
    {
      AppMethodBeat.i(267698);
      IZm = new c();
      AppMethodBeat.o(267698);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelife/PluginGameLife$dealBlackList$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements b.a
  {
    d(com.tencent.mm.plugin.appbrand.af.k<Boolean> paramk1, com.tencent.mm.plugin.appbrand.af.k<Boolean> paramk2, String paramString, ProgressDialog paramProgressDialog, PluginGameLife paramPluginGameLife, Context paramContext, int paramInt, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame) {}
    
    public final void au(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(267708);
      this.IZn.value = Boolean.valueOf(paramBoolean2);
      paramk2.value = Boolean.valueOf(paramBoolean1);
      Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame userName:%s,isAssociate:%b,isOwnBlack:%b", new Object[] { this.pmW, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.IZp != null) && (this.IZp.isShowing()))
      {
        this.IZp.dismiss();
        PluginGameLife localPluginGameLife = jdField_this;
        Context localContext = paramContext;
        String str = this.pmW;
        s.s(str, "userName");
        int i = i;
        com.tencent.mm.plugin.appbrand.af.k localk1 = this.IZn;
        com.tencent.mm.plugin.appbrand.af.k localk2 = paramk2;
        c.b localb = paramb;
        com.tencent.mm.plugin.gamelife.a.e locale = paramString;
        s.s(locale, "sessionInfo");
        PluginGameLife.access$showGameLifeDialog(localPluginGameLife, localContext, str, i, localk1, localk2, localb, locale);
      }
      AppMethodBeat.o(267708);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife
 * JD-Core Version:    0.7.0.1
 */