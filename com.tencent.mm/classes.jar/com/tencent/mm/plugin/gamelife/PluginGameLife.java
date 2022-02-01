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
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ab.b;
import com.tencent.mm.plugin.gamelife.a.b.a;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f.a;
import com.tencent.mm.pluginsdk.model.app.l.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.widget.a.g.a;
import d.a.j;
import d.g.b.ad;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.f;
import d.v;
import d.z;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/PluginGameLife;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appMessageInterceptor", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "getAppMessageInterceptor", "()Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "appMessageInterceptor$delegate", "Lkotlin/Lazy;", "appMessageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "avatarPath", "", "getAvatarPath", "()Ljava/lang/String;", "setAvatarPath", "(Ljava/lang/String;)V", "cacheDBPath", "contactService", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "getContactService", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "contactService$delegate", "contactStorage", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "getConversationUpdateCallback", "()Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "conversationUpdateCallback$delegate", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "gameChatUnreadState", "", "Ljava/lang/Boolean;", "getContactInterceptor", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getContactInterceptor$delegate", "lock", "", "messageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkSessionIdAndContact", "", "selfUsername", "talker", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sessionId", "clearDB", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dealBlackList", "context", "Landroid/content/Context;", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "isAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "dependency", "enterChattingUI", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "outerUserName", "scene", "enterSendGift", "execute", "getAppMessageStorage", "getContactStorage", "getConversationStorage", "getDB", "getMessageStorage", "getSessionInfoStorage", "initDB", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "jumpToGameLifeSingleChatInfoUIReport", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "reportChattingDetail", "pos", "actionId", "", "selfUserName", "actionStatus", "reportGameChatUnreadState", "reportSingleChatInfoUIDetail", "dealWaGameAccountTogether", "accountType", "associate", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "resetDB", "showGameLifeDialog", "userName", "sessionInfo", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "testEnterChattingUI", "Companion", "plugin-gamelife_release"})
public final class PluginGameLife
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, c
{
  private static final String uIa = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String uIb = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  public static final PluginGameLife.a uIc;
  private com.tencent.mm.storagebase.h gDX;
  private final byte[] lock;
  public String rJY;
  private final d.f rOH;
  private final k.a uEW;
  private String uHQ;
  private final d.f uHR;
  private final d.f uHS;
  private final d.f uHT;
  private com.tencent.mm.plugin.gamelife.d.c uHU;
  private com.tencent.mm.plugin.gamelife.j.c uHV;
  private com.tencent.mm.plugin.gamelife.e.d uHW;
  private com.tencent.mm.plugin.gamelife.g.d uHX;
  private com.tencent.mm.plugin.gamelife.g.c uHY;
  private Boolean uHZ;
  
  static
  {
    AppMethodBeat.i(212027);
    uIc = new PluginGameLife.a((byte)0);
    uIa = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    uIb = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    AppMethodBeat.o(212027);
  }
  
  public PluginGameLife()
  {
    AppMethodBeat.i(212026);
    this.lock = new byte[0];
    this.uHR = d.g.O((d.g.a.a)PluginGameLife.l.uIo);
    this.uHS = d.g.O((d.g.a.a)PluginGameLife.k.uIn);
    this.rOH = d.g.O((d.g.a.a)p.uIx);
    this.uHT = d.g.O((d.g.a.a)PluginGameLife.b.uId);
    this.uEW = ((k.a)new z(this));
    AppMethodBeat.o(212026);
  }
  
  private final void checkSessionIdAndContact(String paramString1, String paramString2, d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(212010);
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    LinkedList localLinkedList = new LinkedList();
    Runnable localRunnable = (Runnable)new PluginGameLife.e(localAtomicInteger, localLinkedList, paramb);
    ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).a(paramString1, paramString2, (f.a)new PluginGameLife.c(localAtomicInteger, paramb, localLinkedList, localRunnable));
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.listOf(new String[] { paramString1, paramString2 }), (b.c)new PluginGameLife.d(paramString1, paramString2, localRunnable, localAtomicInteger, paramb));
    AppMethodBeat.o(212010);
  }
  
  private final com.tencent.mm.plugin.gamelife.g.b getAppMessageInterceptor()
  {
    AppMethodBeat.i(211995);
    com.tencent.mm.plugin.gamelife.g.b localb = (com.tencent.mm.plugin.gamelife.g.b)this.uHT.getValue();
    AppMethodBeat.o(211995);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.b getContactService()
  {
    AppMethodBeat.i(211993);
    com.tencent.mm.plugin.gamelife.d.b localb = (com.tencent.mm.plugin.gamelife.d.b)this.uHS.getValue();
    AppMethodBeat.o(211993);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.e.f getConversationUpdateCallback()
  {
    AppMethodBeat.i(211992);
    com.tencent.mm.plugin.gamelife.e.f localf = (com.tencent.mm.plugin.gamelife.e.f)this.uHR.getValue();
    AppMethodBeat.o(211992);
    return localf;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(212003);
    com.tencent.mm.storagebase.h localh = this.gDX;
    if (localh == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(212003);
    return localh;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.d getGetContactInterceptor()
  {
    AppMethodBeat.i(211994);
    com.tencent.mm.plugin.gamelife.d.d locald = (com.tencent.mm.plugin.gamelife.d.d)this.rOH.getValue();
    AppMethodBeat.o(211994);
    return locald;
  }
  
  private final void initDB()
  {
    AppMethodBeat.i(211999);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject2, "MMKernel.storage()");
    this.uHQ = (((com.tencent.mm.kernel.e)localObject2).ajw() + "GameLife.db");
    localObject2 = this.gDX;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (PluginGameLife)this;
      localObject1 = new com.tencent.mm.storagebase.h();
      String str = ((PluginGameLife)localObject2).uHQ;
      if (str == null) {
        d.g.b.p.bdF("cacheDBPath");
      }
      if (!((com.tencent.mm.storagebase.h)localObject1).b(str, ((PluginGameLife)localObject2).collectDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("GameLife db init failed");
        AppMethodBeat.o(211999);
        throw ((Throwable)localObject1);
      }
    }
    this.gDX = ((com.tencent.mm.storagebase.h)localObject1);
    AppMethodBeat.o(211999);
  }
  
  private final void reportChattingDetail(final int paramInt, final long paramLong, String paramString1, final String paramString2, final String paramString3, String paramString4)
  {
    AppMethodBeat.i(212020);
    com.tencent.mm.cm.g.fWL().i((com.tencent.mm.vending.c.a)new s(paramString1, paramString2, paramString3, paramInt, paramLong, paramString4)).fSw();
    AppMethodBeat.o(212020);
  }
  
  private final void reportGameChatUnreadState()
  {
    AppMethodBeat.i(212025);
    if (this.uHZ == null)
    {
      localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKH, Boolean.FALSE);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(212025);
        throw ((Throwable)localObject);
      }
      this.uHZ = ((Boolean)localObject);
    }
    Object localObject = this.uHZ;
    boolean bool;
    if (localObject != null)
    {
      bool = ((Boolean)localObject).booleanValue();
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class);
      d.g.b.p.g(localObject, "MMKernel.service(IGameLi…ationService::class.java)");
      int i = ((com.tencent.mm.plugin.gamelife.a.c)localObject).ddp();
      if (((i <= 0) || (bool)) && ((i != 0) || (!bool))) {
        break label175;
      }
      if (i > 0)
      {
        bool = true;
        com.tencent.mm.sdk.platformtools.ae.i("GameLife.PluginGameLife", "the state of game chat has changed, gameChatUnreadState:%b", new Object[] { Boolean.valueOf(bool) });
        localObject = com.tencent.mm.game.report.d.a.gvE;
        com.tencent.mm.game.report.d.a.du(bool);
      }
    }
    label175:
    for (;;)
    {
      for (localObject = Boolean.valueOf(bool);; localObject = null)
      {
        this.uHZ = ((Boolean)localObject);
        AppMethodBeat.o(212025);
        return;
        bool = false;
        break;
      }
    }
  }
  
  private final void reportSingleChatInfoUIDetail(final int paramInt, final long paramLong, String paramString1, String paramString2, final String paramString3, final Boolean paramBoolean1, final Integer paramInteger, final Boolean paramBoolean2)
  {
    AppMethodBeat.i(212018);
    com.tencent.mm.cm.g.fWL().i((com.tencent.mm.vending.c.a)new t(paramString2, paramString3, paramInteger, paramBoolean2, paramBoolean1, paramInt, paramLong, paramString1)).fSw();
    AppMethodBeat.o(212018);
  }
  
  private final void resetDB()
  {
    AppMethodBeat.i(212002);
    com.tencent.mm.storagebase.h localh = this.gDX;
    if (localh != null) {
      localh.closeDB();
    }
    this.gDX = null;
    this.uHU = null;
    this.uHV = null;
    this.uHW = null;
    this.uHY = null;
    this.uHX = null;
    AppMethodBeat.o(212002);
  }
  
  private final void showGameLifeDialog(final Context paramContext, final String paramString, final int paramInt, final com.tencent.mm.plugin.appbrand.y.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.y.i<Boolean> parami2, final c.b paramb, final com.tencent.mm.plugin.gamelife.a.e parame)
  {
    AppMethodBeat.i(212017);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(paramContext, (byte)0);
    localg.agc(2131496405);
    Object localObject = localg.kFh.findViewById(2131308124);
    d.g.b.p.g(localObject, "dialog.rootView.findView…blacklist_notifymsg_text)");
    TextView localTextView1 = (TextView)localObject;
    localObject = localg.kFh.findViewById(2131308127);
    d.g.b.p.g(localObject, "dialog.rootView.findView…agame_blacklist_checkbox)");
    CheckBox localCheckBox = (CheckBox)localObject;
    localObject = localg.kFh.findViewById(2131308128);
    d.g.b.p.g(localObject, "dialog.rootView.findView…fe_wagame_blacklist_text)");
    TextView localTextView2 = (TextView)localObject;
    final com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
    locali.value = Boolean.TRUE;
    localCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new u(locali));
    if (parami1 != null) {}
    for (localObject = (Boolean)parami1.value; localObject == null; localObject = null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("GameLife.PluginGameLife", "showGameLifeDialog isBlackList null");
      AppMethodBeat.o(212017);
      return;
    }
    localObject = parami1.value;
    d.g.b.p.g(localObject, "isBlackList.value");
    if (((Boolean)localObject).booleanValue())
    {
      if (paramInt == 2)
      {
        localTextView1.setText(2131766884);
        localTextView2.setVisibility(8);
        localCheckBox.setVisibility(8);
      }
      for (;;)
      {
        localg.a((g.a)new v(this, paramb, parami1, localg, parami2, locali, parame, paramInt), (g.a)new w(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, parame, paramInt));
        localg.c((CharSequence)paramContext.getResources().getString(2131755691), (CharSequence)paramContext.getResources().getString(2131766881));
        localg.ax((CharSequence)paramContext.getResources().getString(2131766882));
        localg.cPF();
        paramContext = parame.getSessionId();
        d.g.b.p.g(paramContext, "sessionInfo.sessionId");
        paramString = parame.getSelfUsername();
        d.g.b.p.g(paramString, "sessionInfo.selfUsername");
        parami1 = parame.Wa();
        d.g.b.p.g(parami1, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 7, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
        AppMethodBeat.o(212017);
        return;
        if (paramInt == 1)
        {
          localTextView1.setText(2131766883);
          if (parami2 != null)
          {
            localObject = parami2.value;
            d.g.b.p.g(localObject, "isAssociateWithWAGame.value");
            if (((Boolean)localObject).booleanValue())
            {
              localTextView2.setText(2131766885);
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
      localTextView1.setText(2131766878);
      localCheckBox.setVisibility(8);
    }
    for (;;)
    {
      localg.a((g.a)new x(this, localg, paramb, parami1, parami2, locali, parame, paramInt), (g.a)new y(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, parame, paramInt));
      localg.aga(paramContext.getResources().getColor(2131100711));
      localg.fQF();
      localg.c((CharSequence)paramContext.getResources().getString(2131755691), (CharSequence)paramContext.getResources().getString(2131766880));
      localg.ax((CharSequence)paramContext.getResources().getString(2131766876));
      localg.cPF();
      paramContext = parame.getSessionId();
      d.g.b.p.g(paramContext, "sessionInfo.sessionId");
      paramString = parame.getSelfUsername();
      d.g.b.p.g(paramString, "sessionInfo.selfUsername");
      parami1 = parame.Wa();
      d.g.b.p.g(parami1, "sessionInfo.talker");
      reportSingleChatInfoUIDetail$default(this, 6, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
      AppMethodBeat.o(212017);
      return;
      if (paramInt == 1)
      {
        localTextView1.setText(2131766877);
        if (parami2 != null)
        {
          localObject = parami2.value;
          d.g.b.p.g(localObject, "isAssociateWithWAGame.value");
          if (((Boolean)localObject).booleanValue())
          {
            localTextView2.setText(2131766879);
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
    AppMethodBeat.i(212000);
    String str = this.uHQ;
    if (str == null) {
      d.g.b.p.bdF("cacheDBPath");
    }
    com.tencent.mm.vfs.o.deleteFile(str);
    resetDB();
    initDB();
    AppMethodBeat.o(212000);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(212022);
    HashMap localHashMap = d.a.ae.c(new d.o[] { d.u.R(Integer.valueOf("GameLifeContact".hashCode()), PluginGameLife.f.uIi), d.u.R(Integer.valueOf("GameLifeSessionInfo".hashCode()), PluginGameLife.g.uIj), d.u.R(Integer.valueOf("GameLifeConversation".hashCode()), PluginGameLife.h.uIk), d.u.R(Integer.valueOf("gamelifemessage".hashCode()), PluginGameLife.i.uIl), d.u.R(Integer.valueOf("AppMessage".hashCode()), PluginGameLife.j.uIm) });
    AppMethodBeat.o(212022);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(211998);
    com.tencent.mm.vfs.u.a("gamelife", "gamelife/avatar", 536870912L, 3);
    AppMethodBeat.o(211998);
  }
  
  public final void dealBlackList(final Context paramContext, final String paramString, final com.tencent.mm.plugin.appbrand.y.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.y.i<Boolean> parami2, final c.b paramb)
  {
    AppMethodBeat.i(212016);
    d.g.b.p.h(parami1, "isBlackList");
    d.g.b.p.h(parami2, "isAssociateWithWAGame");
    d.g.b.p.h(paramb, "callback");
    if (paramContext == null)
    {
      AppMethodBeat.o(212016);
      return;
    }
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).anD(paramString);
    d.g.b.p.g(paramString, "sessionInfo");
    Object localObject1 = paramString.Wa();
    Object localObject2 = paramString.getSelfUsername();
    String str = paramString.getSessionId();
    d.g.b.p.g(str, "sessionInfo.sessionId");
    d.g.b.p.g(localObject2, "selfUserName");
    d.g.b.p.g(localObject1, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 5, 2L, str, (String)localObject2, (String)localObject1, null, null, null, 224, null);
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any((String)localObject1);
    d.g.b.p.g(localObject1, "contact");
    final int i = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).ddo();
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
    if (i <= 0)
    {
      Toast.makeText(paramContext, 2131766892, 0).show();
      AppMethodBeat.o(212016);
      return;
    }
    if (i == 2)
    {
      if ((parami1.value != null) && (parami2.value != null))
      {
        d.g.b.p.g(localObject1, "userName");
        showGameLifeDialog(paramContext, (String)localObject1, i, parami1, parami2, paramb, paramString);
        AppMethodBeat.o(212016);
      }
    }
    else if (i == 1)
    {
      localObject2 = (ProgressDialog)com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), true, 3, null);
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      ((ProgressDialog)localObject2).show();
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a((String)localObject1, (b.a)new m(this, parami1, parami2, (String)localObject1, (ProgressDialog)localObject2, paramContext, i, paramb, paramString));
    }
    AppMethodBeat.o(212016);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(212024);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    AppMethodBeat.o(212024);
  }
  
  public final void enterChattingUI(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(212009);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString1, "selfUsername");
    d.g.b.p.h(paramString2, "talker");
    y.f localf = new y.f();
    localf.NiY = null;
    checkSessionIdAndContact(paramString1, paramString2, (d.g.a.b)new PluginGameLife.n(com.tencent.e.h.MqF.q((Runnable)new PluginGameLife.o(localf, paramContext), 1000L), localf, paramString1, paramContext));
    AppMethodBeat.o(212009);
  }
  
  public final void enterExpose(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(212013);
    d.g.b.p.h(paramIntent, "intent");
    d.g.b.p.h(paramString, "sessionId");
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).anD(paramString);
    d.g.b.p.g(locale, "sessionInfo");
    paramString = locale.Wa();
    com.tencent.mm.sdk.platformtools.ae.d("GameLife.PluginGameLife", "talkerName:%s", new Object[] { paramString });
    paramIntent.putExtra("k_username", paramString);
    Object localObject = ad.Njc;
    localObject = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=60", Arrays.copyOf(new Object[] { Integer.valueOf(39) }, 1));
    d.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
    paramIntent.putExtra("rawUrl", (String)localObject);
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    paramContext = locale.getSelfUsername();
    paramIntent = locale.getSessionId();
    d.g.b.p.g(paramIntent, "sessionInfo.sessionId");
    d.g.b.p.g(paramContext, "selfUserName");
    d.g.b.p.g(paramString, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 8, 40L, paramIntent, paramContext, paramString, null, null, null, 224, null);
    AppMethodBeat.o(212013);
  }
  
  public final void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(212012);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(212012);
      return;
    }
    if (paramInt == a.uHM) {
      if (an.aUw(paramString)) {
        reportChattingDetail(2, 7L, paramString, null, null, "1");
      }
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any(paramString);
      label107:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).ddn();
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
        com.tencent.mm.sdk.platformtools.ae.e("GameLife.PluginGameLife", "userName:%s,jumpUrl null");
        AppMethodBeat.o(212012);
        return;
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).anD(paramString);
        d.g.b.p.g(localObject1, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).Wa();
        d.g.b.p.g(paramString, "sessionInfo.talker");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSelfUsername();
        d.g.b.p.g(localObject2, "sessionInfo.selfUsername");
        reportChattingDetail(2, 7L, (String)localObject2, ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSessionId(), ((com.tencent.mm.plugin.gamelife.a.e)localObject1).Wa(), "2");
        break;
        if (paramInt != a.uHL) {
          break label431;
        }
        Object localObject3 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).anD(paramString);
        d.g.b.p.g(localObject3, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).Wa();
        d.g.b.p.g(paramString, "sessionInfo.talker");
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSessionId();
        d.g.b.p.g(localObject1, "sessionInfo.sessionId");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
        d.g.b.p.g(localObject2, "sessionInfo.selfUsername");
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).Wa();
        d.g.b.p.g(localObject3, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 2, 7L, (String)localObject1, (String)localObject2, (String)localObject3, null, null, null, 224, null);
        break;
        localObject1 = "";
        break label107;
      }
      label373:
      com.tencent.mm.sdk.platformtools.ae.i("GameLife.PluginGameLife", "userName:%s,jumpUrl:%s", new Object[] { paramString, localObject1 });
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject1);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(212012);
      return;
      label431:
      paramString = "";
    }
  }
  
  public final void enterSendGift(Context paramContext, String paramString)
  {
    AppMethodBeat.i(212015);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString, "sessionId");
    com.tencent.mm.sdk.platformtools.ae.i("GameLife.PluginGameLife", "enterSendGift sessionId[%s]", new Object[] { paramString });
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).anD(paramString);
    if (locale != null)
    {
      com.tencent.mm.plugin.gamelife.a.a locala = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any(locale.getSelfUsername());
      Object localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any(locale.Wa());
      long l1;
      long l2;
      if ((locala != null) && (localObject1 != null))
      {
        Object localObject2 = com.tencent.mm.game.report.c.guw;
        l1 = locala.ddo();
        Object localObject3 = locala.getUsername();
        d.g.b.p.g(localObject3, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).ddo();
        String str = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        d.g.b.p.g(str, "talkerContact.username");
        d.g.b.p.h(paramString, "sessionId");
        d.g.b.p.h(localObject3, "fromUsername");
        d.g.b.p.h(str, "toUsername");
        localObject2 = com.tencent.mm.game.report.c.a.a(3L, 302L, 2L, 2L, 301L);
        ((cf)localObject2).lY(paramString);
        ((cf)localObject2).ib(l1);
        ((cf)localObject2).lW((String)localObject3);
        ((cf)localObject2).ic(l2);
        ((cf)localObject2).lX(str);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("ser_name", 4L);
        ((cf)localObject2).lZ(URLEncoder.encode(((JSONObject)localObject3).toString()));
        ((cf)localObject2).aLH();
      }
      int i = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.c.class)).A(paramContext, locale.getSelfUsername(), locale.Wa());
      if ((locala != null) && (localObject1 != null))
      {
        if (i == 40)
        {
          paramContext = com.tencent.mm.game.report.c.guw;
          l1 = locala.ddo();
          paramContext = locala.getUsername();
          d.g.b.p.g(paramContext, "selfContact.username");
          l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).ddo();
          localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
          d.g.b.p.g(localObject1, "talkerContact.username");
          com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 40L);
          AppMethodBeat.o(212015);
          return;
        }
        paramContext = com.tencent.mm.game.report.c.guw;
        l1 = locala.ddo();
        paramContext = locala.getUsername();
        d.g.b.p.g(paramContext, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).ddo();
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        d.g.b.p.g(localObject1, "talkerContact.username");
        com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 71L);
      }
      AppMethodBeat.o(212015);
      return;
    }
    AppMethodBeat.o(212015);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(211996);
    d.g.b.p.h(paramg, "profile");
    if (paramg.akL())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.f.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.j.b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.b.class, (com.tencent.mm.kernel.c.a)getContactService());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.c.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.e.c());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.d.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.h.a());
    }
    AppMethodBeat.o(211996);
  }
  
  public final com.tencent.mm.plugin.gamelife.g.c getAppMessageStorage()
  {
    AppMethodBeat.i(212007);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.gamelife.g.c localc2 = this.uHY;
    com.tencent.mm.plugin.gamelife.g.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.g.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uHY = localc1;
    localc1 = this.uHY;
    if (localc1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(212007);
    return localc1;
  }
  
  public final String getAvatarPath()
  {
    AppMethodBeat.i(211990);
    String str = this.rJY;
    if (str == null) {
      d.g.b.p.bdF("avatarPath");
    }
    AppMethodBeat.o(211990);
    return str;
  }
  
  public final com.tencent.mm.plugin.gamelife.d.c getContactStorage()
  {
    AppMethodBeat.i(212004);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.gamelife.d.c localc2 = this.uHU;
    com.tencent.mm.plugin.gamelife.d.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.d.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uHU = localc1;
    localc1 = this.uHU;
    if (localc1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(212004);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.gamelife.e.d getConversationStorage()
  {
    AppMethodBeat.i(212006);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.gamelife.e.d locald2 = this.uHW;
    com.tencent.mm.plugin.gamelife.e.d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new com.tencent.mm.plugin.gamelife.e.d((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uHW = locald1;
    locald1 = this.uHW;
    if (locald1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(212006);
    return locald1;
  }
  
  public final com.tencent.mm.plugin.gamelife.g.d getMessageStorage()
  {
    AppMethodBeat.i(212008);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).doJ();
    com.tencent.mm.plugin.gamelife.g.d locald = this.uHX;
    localObject = locald;
    if (locald == null)
    {
      d.g.b.p.g(locali, "msgStg");
      localObject = new com.tencent.mm.plugin.gamelife.g.d(locali);
    }
    this.uHX = ((com.tencent.mm.plugin.gamelife.g.d)localObject);
    localObject = this.uHX;
    if (localObject == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(212008);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.gamelife.j.c getSessionInfoStorage()
  {
    AppMethodBeat.i(212005);
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.gamelife.j.c localc2 = this.uHV;
    com.tencent.mm.plugin.gamelife.j.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.j.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uHV = localc1;
    localc1 = this.uHV;
    if (localc1 == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(212005);
    return localc1;
  }
  
  public final void initGameLifeSingleChatInfoUI(Context paramContext, String paramString, c.a parama)
  {
    AppMethodBeat.i(212014);
    if (paramContext == null)
    {
      AppMethodBeat.o(212014);
      return;
    }
    Object localObject = com.tencent.mm.game.report.c.guw;
    com.tencent.mm.game.report.c.a.a(4L, 0L, 0L, 1L, 301L).aLH();
    localObject = com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), true, 3, null);
    d.g.b.p.g(localObject, "MMProgressDialog.show(co…TLE_TRANSPARENT_BG, null)");
    localObject = (ProgressDialog)localObject;
    ((ProgressDialog)localObject).show();
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).ajf(paramString);
    paramString = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).any(paramString);
    d.g.b.p.g(paramString, "contact");
    String str = paramString.getUsername();
    if (paramString.ddo() <= 0)
    {
      Toast.makeText(paramContext, 2131766892, 0).show();
      AppMethodBeat.o(212014);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(str, (b.a)new PluginGameLife.q((ProgressDialog)localObject, parama, paramContext));
    AppMethodBeat.o(212014);
  }
  
  public final void jumpToGameLifeSingleChatInfoUIReport(String paramString)
  {
    AppMethodBeat.i(212011);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ae.e("GameLife.PluginGameLife", "jumpToGameLifeSingleChatInfoUI sessionId null!");
      AppMethodBeat.o(212011);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.f.class)).anD(paramString);
    d.g.b.p.g(localObject2, "sessionInfo");
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).Wa();
    localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).getSelfUsername();
    d.g.b.p.g(localObject2, "selfUserName");
    reportChattingDetail$default(this, 1, 6L, (String)localObject2, paramString, (String)localObject1, null, 32, null);
    AppMethodBeat.o(212011);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(211997);
    com.tencent.mm.sdk.platformtools.ae.i("GameLife.PluginGameLife", "Account Init");
    initDB();
    paramc = new StringBuilder();
    Object localObject = com.tencent.mm.kernel.g.ajR();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    this.rJY = (((com.tencent.mm.kernel.e)localObject).getAccPath() + "gamelife/avatar/");
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(3, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.gamelife.g.e());
    paramc = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    paramc.doJ().a((com.tencent.mm.storage.e)getMessageStorage());
    paramc.azL().a((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdateCallback());
    paramc.azF().a((bq.a)getContactService().uJp);
    paramc = a.b.ffl();
    if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      localObject = new com.tencent.mm.plugin.gamelife.f.d(((com.tencent.mm.pluginsdk.ui.b)paramc).ffm());
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelife", (j.a)localObject);
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelifesess", (j.a)localObject);
    }
    ab.a.a((ab.b)getGetContactInterceptor());
    com.tencent.mm.plugin.s.a.dBh().a((l.b)getAppMessageInterceptor());
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.uEW);
    com.tencent.e.h.MqF.q((Runnable)new r(this), 1000L);
    AppMethodBeat.o(211997);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(212023);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(3);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azL().b((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdateCallback());
    locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azF().b((bq.a)getContactService().uJp);
    ab.a.b((ab.b)getGetContactInterceptor());
    com.tencent.mm.plugin.s.a.dBh().b((l.b)getAppMessageInterceptor());
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.uEW);
    resetDB();
    AppMethodBeat.o(212023);
  }
  
  public final void setAvatarPath(String paramString)
  {
    AppMethodBeat.i(211991);
    d.g.b.p.h(paramString, "<set-?>");
    this.rJY = paramString;
    AppMethodBeat.o(211991);
  }
  
  public final void testEnterChattingUI()
  {
    AppMethodBeat.i(212001);
    PluginGameLife localPluginGameLife = (PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class);
    Context localContext = ak.getContext();
    d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    localPluginGameLife.enterChattingUI(localContext, uIa, uIb);
    AppMethodBeat.o(212001);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gamelife/PluginGameLife$dealBlackList$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static final class m
    implements b.a
  {
    m(com.tencent.mm.plugin.appbrand.y.i parami1, com.tencent.mm.plugin.appbrand.y.i parami2, String paramString, ProgressDialog paramProgressDialog, Context paramContext, int paramInt, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame) {}
    
    public final void R(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(211972);
      parami1.value = Boolean.valueOf(paramBoolean2);
      parami2.value = Boolean.valueOf(paramBoolean1);
      com.tencent.mm.sdk.platformtools.ae.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame userName:%s,isAssociate:%b,isOwnBlack:%b", new Object[] { this.iGZ, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.uIs != null) && (this.uIs.isShowing()))
      {
        this.uIs.dismiss();
        PluginGameLife localPluginGameLife = this.uIp;
        Context localContext = paramContext;
        String str = this.iGZ;
        d.g.b.p.g(str, "userName");
        int i = i;
        com.tencent.mm.plugin.appbrand.y.i locali1 = parami1;
        com.tencent.mm.plugin.appbrand.y.i locali2 = parami2;
        c.b localb = paramb;
        com.tencent.mm.plugin.gamelife.a.e locale = paramString;
        d.g.b.p.g(locale, "sessionInfo");
        PluginGameLife.access$showGameLifeDialog(localPluginGameLife, localContext, str, i, locali1, locali2, localb, locale);
      }
      AppMethodBeat.o(211972);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.gamelife.d.d>
  {
    public static final p uIx;
    
    static
    {
      AppMethodBeat.i(211977);
      uIx = new p();
      AppMethodBeat.o(211977);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(PluginGameLife paramPluginGameLife) {}
    
    public final void run()
    {
      AppMethodBeat.i(211979);
      PluginGameLife.access$reportGameChatUnreadState(this.uIp);
      AppMethodBeat.o(211979);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class s<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    s(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class t<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    t(String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, long paramLong, String paramString3) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class u
    implements CompoundButton.OnCheckedChangeListener
  {
    u(com.tencent.mm.plugin.appbrand.y.i parami) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(211982);
      this.uIG.value = Boolean.valueOf(paramBoolean);
      AppMethodBeat.o(211982);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onClick"})
  static final class v
    implements g.a
  {
    v(PluginGameLife paramPluginGameLife, c.b paramb, com.tencent.mm.plugin.appbrand.y.i parami1, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.y.i parami2, com.tencent.mm.plugin.appbrand.y.i parami3, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211983);
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        d.g.b.p.g(localObject2, "isBlackList.value");
        ((c.b)localObject1).nd(((Boolean)localObject2).booleanValue());
      }
      localg.bqD();
      boolean bool;
      if (parami2 != null)
      {
        localObject1 = parami2.value;
        d.g.b.p.g(localObject1, "isAssociateWithWAGame.value");
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = locali.value;
          d.g.b.p.g(localObject1, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject1).booleanValue()) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.uIp;
        localObject2 = parame.getSessionId();
        d.g.b.p.g(localObject2, "sessionInfo.sessionId");
        String str1 = parame.getSelfUsername();
        d.g.b.p.g(str1, "sessionInfo.selfUsername");
        String str2 = parame.Wa();
        d.g.b.p.g(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 7, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211983);
        return;
        bool = false;
        continue;
        com.tencent.mm.sdk.platformtools.ae.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onClick"})
  static final class w
    implements g.a
  {
    w(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.y.i parami1, com.tencent.mm.plugin.appbrand.y.i parami2, String paramString, com.tencent.mm.plugin.appbrand.y.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211985);
      localg.bqD();
      final y.a locala = new y.a();
      locala.NiT = false;
      Object localObject;
      boolean bool;
      if (parami2 != null)
      {
        localObject = parami2.value;
        d.g.b.p.g(localObject, "isAssociateWithWAGame.value");
        if (((Boolean)localObject).booleanValue())
        {
          localObject = locali.value;
          d.g.b.p.g(localObject, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject).booleanValue())
          {
            bool = true;
            locala.NiT = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, false, locala.NiT, (b.b)new b.b()
        {
          public final void nd(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(211984);
            com.tencent.mm.sdk.platformtools.ae.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b", new Object[] { this.uIH.iGZ, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.NiT) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.uIH.uIq;
              if (!((Boolean)this.uIH.uIq.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.y.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.uIH.uIu;
              Object localObject2 = this.uIH.uIq.value;
              d.g.b.p.g(localObject2, "isBlackList.value");
              ((c.b)localObject1).nd(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(211984);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.uIH.crf, 2131766900, 0).show();
            }
          }
        });
        localObject = this.uIp;
        String str1 = parame.getSessionId();
        d.g.b.p.g(str1, "sessionInfo.sessionId");
        String str2 = parame.getSelfUsername();
        d.g.b.p.g(str2, "sessionInfo.selfUsername");
        String str3 = parame.Wa();
        d.g.b.p.g(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 7, 64L, str1, str2, str3, Boolean.valueOf(locala.NiT), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211985);
        return;
        bool = false;
        break;
        com.tencent.mm.sdk.platformtools.ae.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList isAssociateWithWAGame null");
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onClick"})
  static final class x
    implements g.a
  {
    x(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, c.b paramb, com.tencent.mm.plugin.appbrand.y.i parami1, com.tencent.mm.plugin.appbrand.y.i parami2, com.tencent.mm.plugin.appbrand.y.i parami3, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211986);
      localg.bqD();
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        d.g.b.p.g(localObject2, "isBlackList.value");
        ((c.b)localObject1).nd(((Boolean)localObject2).booleanValue());
      }
      boolean bool;
      if (parami2 != null)
      {
        localObject1 = parami2.value;
        d.g.b.p.g(localObject1, "isAssociateWithWAGame.value");
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = locali.value;
          d.g.b.p.g(localObject1, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject1).booleanValue()) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.uIp;
        localObject2 = parame.getSessionId();
        d.g.b.p.g(localObject2, "sessionInfo.sessionId");
        String str1 = parame.getSelfUsername();
        d.g.b.p.g(str1, "sessionInfo.selfUsername");
        String str2 = parame.Wa();
        d.g.b.p.g(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 6, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211986);
        return;
        bool = false;
        continue;
        com.tencent.mm.sdk.platformtools.ae.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onClick"})
  static final class y
    implements g.a
  {
    y(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.y.i parami1, com.tencent.mm.plugin.appbrand.y.i parami2, String paramString, com.tencent.mm.plugin.appbrand.y.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211988);
      localg.bqD();
      final y.a locala = new y.a();
      locala.NiT = false;
      Object localObject;
      boolean bool;
      if (parami2 != null)
      {
        localObject = parami2.value;
        d.g.b.p.g(localObject, "isAssociateWithWAGame.value");
        if (((Boolean)localObject).booleanValue())
        {
          localObject = locali.value;
          d.g.b.p.g(localObject, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject).booleanValue())
          {
            bool = true;
            locala.NiT = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, true, locala.NiT, (b.b)new b.b()
        {
          public final void nd(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(211987);
            com.tencent.mm.sdk.platformtools.ae.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b ", new Object[] { this.uIJ.iGZ, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.NiT) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.uIJ.uIq;
              if (!((Boolean)this.uIJ.uIq.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.y.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.uIJ.uIu;
              Object localObject2 = this.uIJ.uIq.value;
              d.g.b.p.g(localObject2, "isBlackList.value");
              ((c.b)localObject1).nd(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(211987);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.uIJ.crf, 2131766893, 0).show();
            }
          }
        });
        localObject = this.uIp;
        String str1 = parame.getSessionId();
        d.g.b.p.g(str1, "sessionInfo.sessionId");
        String str2 = parame.getSelfUsername();
        d.g.b.p.g(str2, "sessionInfo.selfUsername");
        String str3 = parame.Wa();
        d.g.b.p.g(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 6, 65L, str1, str2, str3, Boolean.valueOf(locala.NiT), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211988);
        return;
        bool = false;
        break;
        com.tencent.mm.sdk.platformtools.ae.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null");
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class z
    implements k.a
  {
    z(PluginGameLife paramPluginGameLife) {}
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(211989);
      if ((paramm.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
        PluginGameLife.access$reportGameChatUnreadState(this.uIp);
      }
      AppMethodBeat.o(211989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife
 * JD-Core Version:    0.7.0.1
 */