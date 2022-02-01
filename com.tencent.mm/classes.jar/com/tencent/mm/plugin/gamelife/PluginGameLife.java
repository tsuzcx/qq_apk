package com.tencent.mm.plugin.gamelife;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fq;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.af.a;
import com.tencent.mm.model.af.b;
import com.tencent.mm.plugin.gamelife.a.b.a;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.l.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.u;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/PluginGameLife;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appMessageInterceptor", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "getAppMessageInterceptor", "()Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "appMessageInterceptor$delegate", "Lkotlin/Lazy;", "appMessageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "avatarPath", "", "getAvatarPath", "()Ljava/lang/String;", "setAvatarPath", "(Ljava/lang/String;)V", "cacheDBPath", "contactService", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "getContactService", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "contactService$delegate", "contactStorage", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "getConversationUpdateCallback", "()Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "conversationUpdateCallback$delegate", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "gameChatUnreadState", "", "Ljava/lang/Boolean;", "getContactInterceptor", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getContactInterceptor$delegate", "lock", "", "messageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkSessionIdAndContact", "", "selfUsername", "talker", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sessionId", "clearDB", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dealBlackList", "context", "Landroid/content/Context;", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "isAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "dependency", "enterChattingUI", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "outerUserName", "enterSendGift", "execute", "getAppMessageStorage", "getContactStorage", "getConversationStorage", "getDB", "getMessageStorage", "getSessionInfoStorage", "initDB", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "jumpToGameLifeSingleChatInfoUIReport", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "reportChattingDetail", "pos", "actionId", "", "selfUserName", "actionStatus", "reportGameChatUnreadState", "reportSingleChatInfoUIDetail", "dealWaGameAccountTogether", "accountType", "associate", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "resetDB", "showGameLifeDialog", "userName", "sessionInfo", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "testEnterChattingUI", "Companion", "plugin-gamelife_release"})
public final class PluginGameLife
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, c
{
  private static final String DeS = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String DeT = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  public static final PluginGameLife.a DeU;
  private String CrS;
  private final MStorage.IOnStorageChange Dbi;
  private final kotlin.f DeJ;
  private final kotlin.f DeK;
  private final kotlin.f DeL;
  private com.tencent.mm.plugin.gamelife.d.c DeM;
  private com.tencent.mm.plugin.gamelife.j.c DeN;
  private com.tencent.mm.plugin.gamelife.e.e DeO;
  private com.tencent.mm.plugin.gamelife.g.d DeP;
  private com.tencent.mm.plugin.gamelife.g.c DeQ;
  private Boolean DeR;
  private com.tencent.mm.storagebase.h kcF;
  private final byte[] lock;
  public String wQa;
  private final kotlin.f wVB;
  
  static
  {
    AppMethodBeat.i(203752);
    DeU = new PluginGameLife.a((byte)0);
    DeS = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    DeT = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    AppMethodBeat.o(203752);
  }
  
  public PluginGameLife()
  {
    AppMethodBeat.i(203750);
    this.lock = new byte[0];
    this.DeJ = kotlin.g.ar((kotlin.g.a.a)PluginGameLife.l.Dfg);
    this.DeK = kotlin.g.ar((kotlin.g.a.a)PluginGameLife.k.Dff);
    this.wVB = kotlin.g.ar((kotlin.g.a.a)PluginGameLife.p.Dfp);
    this.DeL = kotlin.g.ar((kotlin.g.a.a)PluginGameLife.b.DeV);
    this.Dbi = ((MStorage.IOnStorageChange)new z(this));
    AppMethodBeat.o(203750);
  }
  
  private final void checkSessionIdAndContact(String paramString1, String paramString2, int paramInt, com.tencent.mm.cd.b paramb, kotlin.g.a.b<? super String, x> paramb1)
  {
    AppMethodBeat.i(203710);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    LinkedList localLinkedList = new LinkedList();
    Runnable localRunnable = (Runnable)new PluginGameLife.e(localAtomicInteger, localLinkedList, paramb1);
    ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).a(paramString1, paramString2, paramInt, paramb, (f.a)new PluginGameLife.c(localAtomicInteger, paramb1, localLinkedList, localRunnable));
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.listOf(new String[] { paramString1, paramString2 }), (b.c)new PluginGameLife.d(paramString1, paramString2, localRunnable, localAtomicInteger, paramb1));
    AppMethodBeat.o(203710);
  }
  
  private final com.tencent.mm.plugin.gamelife.g.b getAppMessageInterceptor()
  {
    AppMethodBeat.i(203684);
    com.tencent.mm.plugin.gamelife.g.b localb = (com.tencent.mm.plugin.gamelife.g.b)this.DeL.getValue();
    AppMethodBeat.o(203684);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.b getContactService()
  {
    AppMethodBeat.i(203680);
    com.tencent.mm.plugin.gamelife.d.b localb = (com.tencent.mm.plugin.gamelife.d.b)this.DeK.getValue();
    AppMethodBeat.o(203680);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.e.g getConversationUpdateCallback()
  {
    AppMethodBeat.i(203679);
    com.tencent.mm.plugin.gamelife.e.g localg = (com.tencent.mm.plugin.gamelife.e.g)this.DeJ.getValue();
    AppMethodBeat.o(203679);
    return localg;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(203698);
    com.tencent.mm.storagebase.h localh = this.kcF;
    if (localh == null) {
      p.iCn();
    }
    AppMethodBeat.o(203698);
    return localh;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.d getGetContactInterceptor()
  {
    AppMethodBeat.i(203682);
    com.tencent.mm.plugin.gamelife.d.d locald = (com.tencent.mm.plugin.gamelife.d.d)this.wVB.getValue();
    AppMethodBeat.o(203682);
    return locald;
  }
  
  private final void initDB()
  {
    AppMethodBeat.i(203691);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    this.CrS = (((com.tencent.mm.kernel.f)localObject2).aHl() + "GameLife.db");
    localObject2 = this.kcF;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (PluginGameLife)this;
      localObject1 = new com.tencent.mm.storagebase.h();
      String str = ((PluginGameLife)localObject2).CrS;
      if (str == null) {
        p.bGy("cacheDBPath");
      }
      if (!((com.tencent.mm.storagebase.h)localObject1).a(str, ((PluginGameLife)localObject2).collectDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("GameLife db init failed");
        AppMethodBeat.o(203691);
        throw ((Throwable)localObject1);
      }
    }
    this.kcF = ((com.tencent.mm.storagebase.h)localObject1);
    AppMethodBeat.o(203691);
  }
  
  private final void reportChattingDetail(final int paramInt, final long paramLong, String paramString1, final String paramString2, final String paramString3, String paramString4)
  {
    AppMethodBeat.i(203742);
    com.tencent.mm.cw.g.ijP().i((com.tencent.mm.vending.c.a)new s(paramString1, paramString2, paramString3, paramInt, paramLong, paramString4)).ieF();
    AppMethodBeat.o(203742);
  }
  
  private final void reportGameChatUnreadState()
  {
    try
    {
      AppMethodBeat.i(203749);
      if (this.DeR != null) {
        break label67;
      }
      Object localObject1 = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgD, Boolean.FALSE);
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(203749);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    this.DeR = ((Boolean)localObject2);
    label67:
    Object localObject3 = this.DeR;
    boolean bool;
    int i;
    if (localObject3 != null)
    {
      bool = ((Boolean)localObject3).booleanValue();
      localObject3 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class);
      p.j(localObject3, "MMKernel.service(IGameLi…ationService::class.java)");
      i = ((com.tencent.mm.plugin.gamelife.a.c)localObject3).eAi();
      if (i <= 0) {
        break label176;
      }
      if (!bool) {
        break label184;
      }
    }
    for (;;)
    {
      Log.i("GameLife.PluginGameLife", "the state of game chat has changed, gameChatUnreadState:%b", new Object[] { Boolean.valueOf(bool) });
      localObject3 = com.tencent.mm.game.report.d.a.jUr;
      com.tencent.mm.game.report.d.a.eI(bool);
      localObject3 = Boolean.valueOf(bool);
      label149:
      this.DeR = ((Boolean)localObject3);
      AppMethodBeat.o(203749);
      return;
      label176:
      label184:
      do
      {
        bool = false;
        break;
        localObject3 = null;
        break label149;
        do
        {
          break;
        } while ((i != 0) || (!bool));
      } while (i <= 0);
      bool = true;
    }
  }
  
  private final void reportSingleChatInfoUIDetail(final int paramInt, final long paramLong, String paramString1, String paramString2, final String paramString3, final Boolean paramBoolean1, final Integer paramInteger, final Boolean paramBoolean2)
  {
    AppMethodBeat.i(203737);
    com.tencent.mm.cw.g.ijP().i((com.tencent.mm.vending.c.a)new t(paramString2, paramString3, paramInteger, paramBoolean2, paramBoolean1, paramInt, paramLong, paramString1)).ieF();
    AppMethodBeat.o(203737);
  }
  
  private final void resetDB()
  {
    AppMethodBeat.i(203697);
    com.tencent.mm.storagebase.h localh = this.kcF;
    if (localh != null) {
      localh.closeDB();
    }
    this.kcF = null;
    this.DeM = null;
    this.DeN = null;
    this.DeO = null;
    this.DeQ = null;
    this.DeP = null;
    AppMethodBeat.o(203697);
  }
  
  private final void showGameLifeDialog(final Context paramContext, final String paramString, final int paramInt, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami2, final c.b paramb, final com.tencent.mm.plugin.gamelife.a.e parame)
  {
    AppMethodBeat.i(203735);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(paramContext, 1, 2, false);
    localg.ayv(d.d.Dgd);
    Object localObject = localg.oFW.findViewById(d.c.DfO);
    p.j(localObject, "dialog.rootView.findView…blacklist_notifymsg_text)");
    TextView localTextView1 = (TextView)localObject;
    localObject = localg.oFW.findViewById(d.c.DfP);
    p.j(localObject, "dialog.rootView.findView…agame_blacklist_checkbox)");
    CheckBox localCheckBox = (CheckBox)localObject;
    localObject = localg.oFW.findViewById(d.c.DfQ);
    p.j(localObject, "dialog.rootView.findView…fe_wagame_blacklist_text)");
    TextView localTextView2 = (TextView)localObject;
    final com.tencent.mm.plugin.appbrand.ac.i locali = new com.tencent.mm.plugin.appbrand.ac.i();
    locali.value = Boolean.TRUE;
    localCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new u(locali));
    if (parami1 != null) {}
    for (localObject = (Boolean)parami1.value; localObject == null; localObject = null)
    {
      Log.e("GameLife.PluginGameLife", "showGameLifeDialog isBlackList null");
      AppMethodBeat.o(203735);
      return;
    }
    localObject = parami1.value;
    p.j(localObject, "isBlackList.value");
    if (((Boolean)localObject).booleanValue())
    {
      if (paramInt == 2)
      {
        localTextView1.setText(d.f.Dgu);
        localTextView2.setVisibility(8);
        localCheckBox.setVisibility(8);
      }
      for (;;)
      {
        localg.a((g.a)new v(this, paramb, parami1, localg, parami2, locali, parame, paramInt), (g.a)new w(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, parame, paramInt));
        localg.d((CharSequence)paramContext.getResources().getString(d.f.app_cancel), (CharSequence)paramContext.getResources().getString(d.f.Dgr));
        localg.aT((CharSequence)paramContext.getResources().getString(d.f.Dgs));
        localg.eik();
        paramContext = parame.getSessionId();
        p.j(paramContext, "sessionInfo.sessionId");
        paramString = parame.getSelfUsername();
        p.j(paramString, "sessionInfo.selfUsername");
        parami1 = parame.apJ();
        p.j(parami1, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 7, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
        AppMethodBeat.o(203735);
        return;
        if (paramInt == 1)
        {
          localTextView1.setText(d.f.Dgt);
          if (parami2 != null)
          {
            localObject = parami2.value;
            p.j(localObject, "isAssociateWithWAGame.value");
            if (((Boolean)localObject).booleanValue())
            {
              localTextView2.setText(d.f.Dgv);
            }
            else
            {
              localCheckBox.setVisibility(8);
              localTextView2.setVisibility(8);
            }
          }
        }
      }
    }
    if (paramInt == 2)
    {
      localTextView1.setText(d.f.Dgo);
      localCheckBox.setVisibility(8);
    }
    for (;;)
    {
      localg.a((g.a)new x(this, localg, paramb, parami1, parami2, locali, parame, paramInt), (g.a)new y(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, parame, paramInt));
      localg.ays(paramContext.getResources().getColor(d.a.normal_text_color));
      localg.ayt(2);
      localg.d((CharSequence)paramContext.getResources().getString(d.f.app_cancel), (CharSequence)paramContext.getResources().getString(d.f.Dgq));
      localg.aT((CharSequence)paramContext.getResources().getString(d.f.Dgm));
      localg.eik();
      paramContext = parame.getSessionId();
      p.j(paramContext, "sessionInfo.sessionId");
      paramString = parame.getSelfUsername();
      p.j(paramString, "sessionInfo.selfUsername");
      parami1 = parame.apJ();
      p.j(parami1, "sessionInfo.talker");
      reportSingleChatInfoUIDetail$default(this, 6, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
      AppMethodBeat.o(203735);
      return;
      if (paramInt == 1)
      {
        localTextView1.setText(d.f.Dgn);
        if (parami2 != null)
        {
          localObject = parami2.value;
          p.j(localObject, "isAssociateWithWAGame.value");
          if (((Boolean)localObject).booleanValue())
          {
            localTextView2.setText(d.f.Dgp);
          }
          else
          {
            localCheckBox.setVisibility(8);
            localTextView2.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final void clearDB()
  {
    AppMethodBeat.i(203695);
    String str = this.CrS;
    if (str == null) {
      p.bGy("cacheDBPath");
    }
    u.deleteFile(str);
    resetDB();
    initDB();
    AppMethodBeat.o(203695);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(203744);
    HashMap localHashMap = ae.g(new o[] { kotlin.s.M(Integer.valueOf("GameLifeContact".hashCode()), PluginGameLife.f.Dfa), kotlin.s.M(Integer.valueOf("GameLifeSessionInfo".hashCode()), PluginGameLife.g.Dfb), kotlin.s.M(Integer.valueOf("GameLifeConversation".hashCode()), h.Dfc), kotlin.s.M(Integer.valueOf("gamelifemessage".hashCode()), PluginGameLife.i.Dfd), kotlin.s.M(Integer.valueOf("AppMessage".hashCode()), PluginGameLife.j.Dfe) });
    AppMethodBeat.o(203744);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(203689);
    ab.a("gamelife", "gamelife/avatar", 536870912L, 7776000000L, 1);
    AppMethodBeat.o(203689);
  }
  
  public final void dealBlackList(final Context paramContext, final String paramString, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami2, final c.b paramb)
  {
    AppMethodBeat.i(203727);
    p.k(parami1, "isBlackList");
    p.k(parami2, "isAssociateWithWAGame");
    p.k(paramb, "callback");
    if (paramContext == null)
    {
      AppMethodBeat.o(203727);
      return;
    }
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aKJ(paramString);
    p.j(paramString, "sessionInfo");
    Object localObject1 = paramString.apJ();
    Object localObject2 = paramString.getSelfUsername();
    String str = paramString.getSessionId();
    p.j(str, "sessionInfo.sessionId");
    p.j(localObject2, "selfUserName");
    p.j(localObject1, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 5, 2L, str, (String)localObject2, (String)localObject1, null, null, null, 224, null);
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE((String)localObject1);
    p.j(localObject1, "contact");
    final int i = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).eAh();
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
    if (i <= 0)
    {
      Toast.makeText(paramContext, d.f.Dgw, 0).show();
      AppMethodBeat.o(203727);
      return;
    }
    if (i == 2)
    {
      if ((parami1.value != null) && (parami2.value != null))
      {
        p.j(localObject1, "userName");
        showGameLifeDialog(paramContext, (String)localObject1, i, parami1, parami2, paramb, paramString);
        AppMethodBeat.o(203727);
      }
    }
    else if (i == 1)
    {
      localObject2 = (ProgressDialog)com.tencent.mm.ui.base.s.a(paramContext, (CharSequence)paramContext.getResources().getString(d.f.app_waiting), true, 3, null);
      if (localObject2 == null) {
        p.iCn();
      }
      ((ProgressDialog)localObject2).show();
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).a((String)localObject1, (b.a)new m(this, parami1, parami2, (String)localObject1, (ProgressDialog)localObject2, paramContext, i, paramb, paramString));
    }
    AppMethodBeat.o(203727);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(203748);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    AppMethodBeat.o(203748);
  }
  
  public final void enterChattingUI(Context paramContext, String paramString1, String paramString2, int paramInt, com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(203707);
    p.k(paramContext, "context");
    p.k(paramString1, "selfUsername");
    p.k(paramString2, "talker");
    aa.f localf = new aa.f();
    localf.aaBC = null;
    com.tencent.e.i.d locald = com.tencent.e.h.ZvG.n((Runnable)new PluginGameLife.o(localf, paramContext), 1000L);
    ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).eAl();
    checkSessionIdAndContact(paramString1, paramString2, paramInt, paramb, (kotlin.g.a.b)new PluginGameLife.n(locald, localf, paramString1, paramContext));
    AppMethodBeat.o(203707);
  }
  
  public final void enterExpose(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(203716);
    p.k(paramIntent, "intent");
    p.k(paramString, "sessionId");
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aKJ(paramString);
    p.j(locale, "sessionInfo");
    paramString = locale.apJ();
    Log.d("GameLife.PluginGameLife", "talkerName:%s", new Object[] { paramString });
    paramIntent.putExtra("k_username", paramString);
    Object localObject = af.aaBG;
    localObject = f.e.VRZ;
    p.j(localObject, "ConstantsUI.ExposeUI.KExposeGameLifeUrl");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(39) }, 1));
    p.j(localObject, "java.lang.String.format(format, *args)");
    paramIntent.putExtra("rawUrl", (String)localObject);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    paramContext = locale.getSelfUsername();
    paramIntent = locale.getSessionId();
    p.j(paramIntent, "sessionInfo.sessionId");
    p.j(paramContext, "selfUserName");
    p.j(paramString, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 8, 40L, paramIntent, paramContext, paramString, null, null, null, 224, null);
    AppMethodBeat.o(203716);
  }
  
  public final void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(203712);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203712);
      return;
    }
    if (paramInt == a.DeF) {
      if (as.bvR(paramString)) {
        reportChattingDetail(2, 7L, paramString, null, null, "1");
      }
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE(paramString);
      label107:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).eAg();
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label368;
        }
      }
      label368:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label373;
        }
        Log.e("GameLife.PluginGameLife", "userName:%s,jumpUrl null");
        AppMethodBeat.o(203712);
        return;
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aKJ(paramString);
        p.j(localObject1, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).apJ();
        p.j(paramString, "sessionInfo.talker");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSelfUsername();
        p.j(localObject2, "sessionInfo.selfUsername");
        reportChattingDetail(2, 7L, (String)localObject2, ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSessionId(), ((com.tencent.mm.plugin.gamelife.a.e)localObject1).apJ(), "2");
        break;
        if (paramInt != a.DeE) {
          break label431;
        }
        Object localObject3 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aKJ(paramString);
        p.j(localObject3, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).apJ();
        p.j(paramString, "sessionInfo.talker");
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSessionId();
        p.j(localObject1, "sessionInfo.sessionId");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
        p.j(localObject2, "sessionInfo.selfUsername");
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).apJ();
        p.j(localObject3, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 2, 7L, (String)localObject1, (String)localObject2, (String)localObject3, null, null, null, 224, null);
        break;
        localObject1 = "";
        break label107;
      }
      label373:
      Log.i("GameLife.PluginGameLife", "userName:%s,jumpUrl:%s", new Object[] { paramString, localObject1 });
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject1);
      com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(203712);
      return;
      label431:
      paramString = "";
    }
  }
  
  public final void enterSendGift(Context paramContext, String paramString)
  {
    AppMethodBeat.i(203726);
    p.k(paramContext, "context");
    p.k(paramString, "sessionId");
    Log.i("GameLife.PluginGameLife", "enterSendGift sessionId[%s]", new Object[] { paramString });
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aKJ(paramString);
    if (locale != null)
    {
      com.tencent.mm.plugin.gamelife.a.a locala = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE(locale.getSelfUsername());
      Object localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE(locale.apJ());
      long l1;
      long l2;
      if ((locala != null) && (localObject1 != null))
      {
        Object localObject2 = com.tencent.mm.game.report.c.jTf;
        l1 = locala.eAh();
        Object localObject3 = locala.getUsername();
        p.j(localObject3, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).eAh();
        String str = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        p.j(str, "talkerContact.username");
        p.k(paramString, "sessionId");
        p.k(localObject3, "fromUsername");
        p.k(str, "toUsername");
        localObject2 = com.tencent.mm.game.report.c.a.a(3L, 302L, 2L, 2L, 301L);
        ((fq)localObject2).vd(paramString);
        ((fq)localObject2).oD(l1);
        ((fq)localObject2).vb((String)localObject3);
        ((fq)localObject2).oE(l2);
        ((fq)localObject2).vc(str);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("ser_name", 4L);
        ((fq)localObject2).ve(URLEncoder.encode(((JSONObject)localObject3).toString()));
        ((fq)localObject2).bpa();
      }
      int i = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.c.class)).H(paramContext, locale.getSelfUsername(), locale.apJ());
      if ((locala != null) && (localObject1 != null))
      {
        if (i == 40)
        {
          paramContext = com.tencent.mm.game.report.c.jTf;
          l1 = locala.eAh();
          paramContext = locala.getUsername();
          p.j(paramContext, "selfContact.username");
          l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).eAh();
          localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
          p.j(localObject1, "talkerContact.username");
          com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 40L);
          AppMethodBeat.o(203726);
          return;
        }
        paramContext = com.tencent.mm.game.report.c.jTf;
        l1 = locala.eAh();
        paramContext = locala.getUsername();
        p.j(paramContext, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).eAh();
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        p.j(localObject1, "talkerContact.username");
        com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 71L);
      }
      AppMethodBeat.o(203726);
      return;
    }
    AppMethodBeat.o(203726);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(203686);
    p.k(paramg, "profile");
    if (paramg.aIE())
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.f.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.j.b());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.b.class, (com.tencent.mm.kernel.c.a)getContactService());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.c.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.e.d());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.gamelife.a.d.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.h.a());
    }
    AppMethodBeat.o(203686);
  }
  
  public final com.tencent.mm.plugin.gamelife.g.c getAppMessageStorage()
  {
    AppMethodBeat.i(203702);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.gamelife.g.c localc2 = this.DeQ;
    com.tencent.mm.plugin.gamelife.g.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.g.c((ISQLiteDatabase)getDB());
    }
    this.DeQ = localc1;
    localc1 = this.DeQ;
    if (localc1 == null) {
      p.iCn();
    }
    AppMethodBeat.o(203702);
    return localc1;
  }
  
  public final String getAvatarPath()
  {
    AppMethodBeat.i(203676);
    String str = this.wQa;
    if (str == null) {
      p.bGy("avatarPath");
    }
    AppMethodBeat.o(203676);
    return str;
  }
  
  public final com.tencent.mm.plugin.gamelife.d.c getContactStorage()
  {
    AppMethodBeat.i(203699);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.gamelife.d.c localc2 = this.DeM;
    com.tencent.mm.plugin.gamelife.d.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.d.c((ISQLiteDatabase)getDB());
    }
    this.DeM = localc1;
    localc1 = this.DeM;
    if (localc1 == null) {
      p.iCn();
    }
    AppMethodBeat.o(203699);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.gamelife.e.e getConversationStorage()
  {
    AppMethodBeat.i(203701);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.gamelife.e.e locale2 = this.DeO;
    com.tencent.mm.plugin.gamelife.e.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new com.tencent.mm.plugin.gamelife.e.e((ISQLiteDatabase)getDB());
    }
    this.DeO = locale1;
    locale1 = this.DeO;
    if (locale1 == null) {
      p.iCn();
    }
    AppMethodBeat.o(203701);
    return locale1;
  }
  
  public final com.tencent.mm.plugin.gamelife.g.d getMessageStorage()
  {
    AppMethodBeat.i(203703);
    Object localObject = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((n)localObject).eSe();
    com.tencent.mm.plugin.gamelife.g.d locald = this.DeP;
    localObject = locald;
    if (locald == null)
    {
      p.j(locali, "msgStg");
      localObject = new com.tencent.mm.plugin.gamelife.g.d(locali);
    }
    this.DeP = ((com.tencent.mm.plugin.gamelife.g.d)localObject);
    localObject = this.DeP;
    if (localObject == null) {
      p.iCn();
    }
    AppMethodBeat.o(203703);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.gamelife.j.c getSessionInfoStorage()
  {
    AppMethodBeat.i(203700);
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.gamelife.j.c localc2 = this.DeN;
    com.tencent.mm.plugin.gamelife.j.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.j.c((ISQLiteDatabase)getDB());
    }
    this.DeN = localc1;
    localc1 = this.DeN;
    if (localc1 == null) {
      p.iCn();
    }
    AppMethodBeat.o(203700);
    return localc1;
  }
  
  public final void initGameLifeSingleChatInfoUI(final Context paramContext, String paramString, final c.a parama)
  {
    AppMethodBeat.i(203721);
    if (paramContext == null)
    {
      AppMethodBeat.o(203721);
      return;
    }
    Object localObject = com.tencent.mm.game.report.c.jTf;
    com.tencent.mm.game.report.c.a.a(4L, 0L, 0L, 1L, 301L).bpa();
    localObject = com.tencent.mm.ui.base.s.a(paramContext, (CharSequence)paramContext.getResources().getString(d.f.app_waiting), true, 3, null);
    p.j(localObject, "MMProgressDialog.show(co…TLE_TRANSPARENT_BG, null)");
    localObject = (ProgressDialog)localObject;
    ((ProgressDialog)localObject).show();
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aED(paramString);
    paramString = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).aKE(paramString);
    p.j(paramString, "contact");
    String str = paramString.getUsername();
    if (paramString.eAh() <= 0)
    {
      Toast.makeText(paramContext, d.f.Dgw, 0).show();
      AppMethodBeat.o(203721);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).a(str, (b.a)new q((ProgressDialog)localObject, parama, paramContext));
    AppMethodBeat.o(203721);
  }
  
  public final void jumpToGameLifeSingleChatInfoUIReport(String paramString)
  {
    AppMethodBeat.i(203711);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.PluginGameLife", "jumpToGameLifeSingleChatInfoUI sessionId null!");
      AppMethodBeat.o(203711);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.f.class)).aKJ(paramString);
    p.j(localObject2, "sessionInfo");
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).apJ();
    localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).getSelfUsername();
    p.j(localObject2, "selfUserName");
    reportChattingDetail$default(this, 1, 6L, (String)localObject2, paramString, (String)localObject1, null, 32, null);
    AppMethodBeat.o(203711);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(203688);
    Log.i("GameLife.PluginGameLife", "Account Init");
    initDB();
    paramc = new StringBuilder();
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    this.wQa = (((com.tencent.mm.kernel.f)localObject).getAccPath() + "gamelife/avatar/");
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(3, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.gamelife.g.e());
    paramc = (n)com.tencent.mm.kernel.h.ae(n.class);
    paramc.eSe().a((com.tencent.mm.storage.e)getMessageStorage());
    paramc.bbR().a((com.tencent.mm.plugin.messenger.foundation.a.i)getConversationUpdateCallback());
    paramc.bbL().a((bv.a)getContactService().Dhl);
    paramc = a.b.hjf();
    if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      localObject = new com.tencent.mm.plugin.gamelife.f.d(((com.tencent.mm.pluginsdk.ui.b)paramc).hjg());
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelife", (j.a)localObject);
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelifesess", (j.a)localObject);
    }
    af.a.a((af.b)getGetContactInterceptor());
    com.tencent.mm.plugin.ab.a.fmA().a((l.b)getAppMessageInterceptor());
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.Dbi);
    com.tencent.e.h.ZvG.o((Runnable)new r(this), 1000L);
    AppMethodBeat.o(203688);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(203746);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(3);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(n.class);
    p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((n)locala).bbR().b((com.tencent.mm.plugin.messenger.foundation.a.i)getConversationUpdateCallback());
    locala = com.tencent.mm.kernel.h.ae(n.class);
    p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((n)locala).bbL().b((bv.a)getContactService().Dhl);
    af.a.b((af.b)getGetContactInterceptor());
    com.tencent.mm.plugin.ab.a.fmA().b((l.b)getAppMessageInterceptor());
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.Dbi);
    resetDB();
    AppMethodBeat.o(203746);
  }
  
  public final void setAvatarPath(String paramString)
  {
    AppMethodBeat.i(203678);
    p.k(paramString, "<set-?>");
    this.wQa = paramString;
    AppMethodBeat.o(203678);
  }
  
  public final void testEnterChattingUI()
  {
    AppMethodBeat.i(203696);
    PluginGameLife localPluginGameLife = (PluginGameLife)com.tencent.mm.kernel.h.ag(PluginGameLife.class);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    localPluginGameLife.enterChattingUI(localContext, DeS, DeT, 0, null);
    AppMethodBeat.o(203696);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class h
    implements h.b
  {
    public static final h Dfc;
    
    static
    {
      AppMethodBeat.i(203231);
      Dfc = new h();
      AppMethodBeat.o(203231);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(203229);
      Object localObject = com.tencent.mm.plugin.gamelife.e.e.DhH;
      localObject = com.tencent.mm.plugin.gamelife.e.e.dqy();
      AppMethodBeat.o(203229);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelife/PluginGameLife$dealBlackList$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static final class m
    implements b.a
  {
    m(com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, String paramString, ProgressDialog paramProgressDialog, Context paramContext, int paramInt, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame) {}
    
    public final void ac(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(203884);
      parami1.value = Boolean.valueOf(paramBoolean2);
      parami2.value = Boolean.valueOf(paramBoolean1);
      Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame userName:%s,isAssociate:%b,isOwnBlack:%b", new Object[] { this.mtC, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.Dfk != null) && (this.Dfk.isShowing()))
      {
        this.Dfk.dismiss();
        PluginGameLife localPluginGameLife = this.Dfh;
        Context localContext = paramContext;
        String str = this.mtC;
        p.j(str, "userName");
        int i = i;
        com.tencent.mm.plugin.appbrand.ac.i locali1 = parami1;
        com.tencent.mm.plugin.appbrand.ac.i locali2 = parami2;
        c.b localb = paramb;
        com.tencent.mm.plugin.gamelife.a.e locale = paramString;
        p.j(locale, "sessionInfo");
        PluginGameLife.access$showGameLifeDialog(localPluginGameLife, localContext, str, i, locali1, locali2, localb, locale);
      }
      AppMethodBeat.o(203884);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelife/PluginGameLife$initGameLifeSingleChatInfoUI$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static final class q
    implements b.a
  {
    q(ProgressDialog paramProgressDialog, c.a parama, Context paramContext) {}
    
    public final void ac(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(204004);
      Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame isAssociate:%b,isOwnBlack:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.Dfq != null) && (this.Dfq.isShowing())) {
        this.Dfq.dismiss();
      }
      c.a locala = parama;
      if (locala != null)
      {
        locala.ac(paramBoolean1, paramBoolean2);
        AppMethodBeat.o(204004);
        return;
      }
      AppMethodBeat.o(204004);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(PluginGameLife paramPluginGameLife) {}
    
    public final void run()
    {
      AppMethodBeat.i(204399);
      PluginGameLife.access$reportGameChatUnreadState(this.Dfh);
      AppMethodBeat.o(204399);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class s<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    s(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class t<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    t(String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, long paramLong, String paramString3) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class u
    implements CompoundButton.OnCheckedChangeListener
  {
    u(com.tencent.mm.plugin.appbrand.ac.i parami) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(204333);
      this.Dfy.value = Boolean.valueOf(paramBoolean);
      AppMethodBeat.o(204333);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class v
    implements g.a
  {
    v(PluginGameLife paramPluginGameLife, c.b paramb, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.ac.i parami2, com.tencent.mm.plugin.appbrand.ac.i parami3, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(203569);
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        p.j(localObject2, "isBlackList.value");
        ((c.b)localObject1).oa(((Boolean)localObject2).booleanValue());
      }
      localg.bYF();
      boolean bool;
      if (parami2 != null)
      {
        localObject1 = parami2.value;
        p.j(localObject1, "isAssociateWithWAGame.value");
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = locali.value;
          p.j(localObject1, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject1).booleanValue()) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.Dfh;
        localObject2 = parame.getSessionId();
        p.j(localObject2, "sessionInfo.sessionId");
        String str1 = parame.getSelfUsername();
        p.j(str1, "sessionInfo.selfUsername");
        String str2 = parame.apJ();
        p.j(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 7, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(203569);
        return;
        bool = false;
        continue;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class w
    implements g.a
  {
    w(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, String paramString, com.tencent.mm.plugin.appbrand.ac.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(203639);
      localg.bYF();
      final aa.a locala = new aa.a();
      locala.aaBx = false;
      Object localObject;
      boolean bool;
      if (parami2 != null)
      {
        localObject = parami2.value;
        p.j(localObject, "isAssociateWithWAGame.value");
        if (((Boolean)localObject).booleanValue())
        {
          localObject = locali.value;
          p.j(localObject, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject).booleanValue())
          {
            bool = true;
            locala.aaBx = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, false, locala.aaBx, (b.b)new b.b()
        {
          public final void oa(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(203288);
            Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b", new Object[] { this.Dfz.mtC, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.aaBx) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.Dfz.Dfi;
              if (!((Boolean)this.Dfz.Dfi.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.ac.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.Dfz.Dfm;
              Object localObject2 = this.Dfz.Dfi.value;
              p.j(localObject2, "isBlackList.value");
              ((c.b)localObject1).oa(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(203288);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.Dfz.$context, d.f.DgD, 0).show();
            }
          }
        });
        localObject = this.Dfh;
        String str1 = parame.getSessionId();
        p.j(str1, "sessionInfo.sessionId");
        String str2 = parame.getSelfUsername();
        p.j(str2, "sessionInfo.selfUsername");
        String str3 = parame.apJ();
        p.j(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 7, 64L, str1, str2, str3, Boolean.valueOf(locala.aaBx), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(203639);
        return;
        bool = false;
        break;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList isAssociateWithWAGame null");
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class x
    implements g.a
  {
    x(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, c.b paramb, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, com.tencent.mm.plugin.appbrand.ac.i parami3, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(202950);
      localg.bYF();
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        p.j(localObject2, "isBlackList.value");
        ((c.b)localObject1).oa(((Boolean)localObject2).booleanValue());
      }
      boolean bool;
      if (parami2 != null)
      {
        localObject1 = parami2.value;
        p.j(localObject1, "isAssociateWithWAGame.value");
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = locali.value;
          p.j(localObject1, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject1).booleanValue()) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.Dfh;
        localObject2 = parame.getSessionId();
        p.j(localObject2, "sessionInfo.sessionId");
        String str1 = parame.getSelfUsername();
        p.j(str1, "sessionInfo.selfUsername");
        String str2 = parame.apJ();
        p.j(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 6, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(202950);
        return;
        bool = false;
        continue;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class y
    implements g.a
  {
    y(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, String paramString, com.tencent.mm.plugin.appbrand.ac.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(202679);
      localg.bYF();
      final aa.a locala = new aa.a();
      locala.aaBx = false;
      Object localObject;
      boolean bool;
      if (parami2 != null)
      {
        localObject = parami2.value;
        p.j(localObject, "isAssociateWithWAGame.value");
        if (((Boolean)localObject).booleanValue())
        {
          localObject = locali.value;
          p.j(localObject, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject).booleanValue())
          {
            bool = true;
            locala.aaBx = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, true, locala.aaBx, (b.b)new b.b()
        {
          public final void oa(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(203890);
            Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b ", new Object[] { this.DfB.mtC, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.aaBx) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.DfB.Dfi;
              if (!((Boolean)this.DfB.Dfi.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.ac.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.DfB.Dfm;
              Object localObject2 = this.DfB.Dfi.value;
              p.j(localObject2, "isBlackList.value");
              ((c.b)localObject1).oa(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(203890);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.DfB.$context, d.f.Dgx, 0).show();
            }
          }
        });
        localObject = this.Dfh;
        String str1 = parame.getSessionId();
        p.j(str1, "sessionInfo.sessionId");
        String str2 = parame.getSelfUsername();
        p.j(str2, "sessionInfo.selfUsername");
        String str3 = parame.apJ();
        p.j(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 6, 65L, str1, str2, str3, Boolean.valueOf(locala.aaBx), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(202679);
        return;
        bool = false;
        break;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null");
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class z
    implements MStorage.IOnStorageChange
  {
    z(PluginGameLife paramPluginGameLife) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(204505);
      if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
        com.tencent.e.h.ZvG.d((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203505);
            PluginGameLife.access$reportGameChatUnreadState(this.DfC.Dfh);
            AppMethodBeat.o(203505);
          }
        }, "reportGameChatUnreadState");
      }
      AppMethodBeat.o(204505);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife
 * JD-Core Version:    0.7.0.1
 */