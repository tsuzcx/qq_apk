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
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.af.a;
import com.tencent.mm.model.af.b;
import com.tencent.mm.plugin.gamelife.a.b.a;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f.a;
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
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.y;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.g.b.z.f;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/PluginGameLife;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appMessageInterceptor", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "getAppMessageInterceptor", "()Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "appMessageInterceptor$delegate", "Lkotlin/Lazy;", "appMessageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "avatarPath", "", "getAvatarPath", "()Ljava/lang/String;", "setAvatarPath", "(Ljava/lang/String;)V", "cacheDBPath", "contactService", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "getContactService", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "contactService$delegate", "contactStorage", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "getConversationUpdateCallback", "()Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "conversationUpdateCallback$delegate", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "gameChatUnreadState", "", "Ljava/lang/Boolean;", "getContactInterceptor", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getContactInterceptor$delegate", "lock", "", "messageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "storageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "checkSessionIdAndContact", "", "selfUsername", "talker", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sessionId", "clearDB", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dealBlackList", "context", "Landroid/content/Context;", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "isAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "dependency", "enterChattingUI", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "outerUserName", "enterSendGift", "execute", "getAppMessageStorage", "getContactStorage", "getConversationStorage", "getDB", "getMessageStorage", "getSessionInfoStorage", "initDB", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "jumpToGameLifeSingleChatInfoUIReport", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "reportChattingDetail", "pos", "actionId", "", "selfUserName", "actionStatus", "reportGameChatUnreadState", "reportSingleChatInfoUIDetail", "dealWaGameAccountTogether", "accountType", "associate", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "resetDB", "showGameLifeDialog", "userName", "sessionInfo", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "testEnterChattingUI", "Companion", "plugin-gamelife_release"})
public final class PluginGameLife
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, c
{
  private static final String yam = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String yan = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  public static final PluginGameLife.a yao;
  private com.tencent.mm.storagebase.h hqK;
  private final byte[] lock;
  public String tjJ;
  private final kotlin.f toD;
  private final MStorage.IOnStorageChange xWT;
  private String yac;
  private final kotlin.f yad;
  private final kotlin.f yae;
  private final kotlin.f yaf;
  private com.tencent.mm.plugin.gamelife.d.c yag;
  private com.tencent.mm.plugin.gamelife.j.c yah;
  private com.tencent.mm.plugin.gamelife.e.e yai;
  private com.tencent.mm.plugin.gamelife.g.d yaj;
  private com.tencent.mm.plugin.gamelife.g.c yak;
  private Boolean yal;
  
  static
  {
    AppMethodBeat.i(241267);
    yao = new PluginGameLife.a((byte)0);
    yam = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    yan = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    AppMethodBeat.o(241267);
  }
  
  public PluginGameLife()
  {
    AppMethodBeat.i(241266);
    this.lock = new byte[0];
    this.yad = kotlin.g.ah((kotlin.g.a.a)l.yaB);
    this.yae = kotlin.g.ah((kotlin.g.a.a)k.yaA);
    this.toD = kotlin.g.ah((kotlin.g.a.a)p.yaK);
    this.yaf = kotlin.g.ah((kotlin.g.a.a)b.yap);
    this.xWT = ((MStorage.IOnStorageChange)new z(this));
    AppMethodBeat.o(241266);
  }
  
  private final void checkSessionIdAndContact(String paramString1, final String paramString2, int paramInt, com.tencent.mm.bw.b paramb, final kotlin.g.a.b<? super String, x> paramb1)
  {
    AppMethodBeat.i(241250);
    final AtomicInteger localAtomicInteger = new AtomicInteger(0);
    final LinkedList localLinkedList = new LinkedList();
    final Runnable localRunnable = (Runnable)new e(localAtomicInteger, localLinkedList, paramb1);
    ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).a(paramString1, paramString2, paramInt, paramb, (f.a)new c(localAtomicInteger, paramb1, localLinkedList, localRunnable));
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.listOf(new String[] { paramString1, paramString2 }), (b.c)new d(paramString1, paramString2, localRunnable, localAtomicInteger, paramb1));
    AppMethodBeat.o(241250);
  }
  
  private final com.tencent.mm.plugin.gamelife.g.b getAppMessageInterceptor()
  {
    AppMethodBeat.i(241235);
    com.tencent.mm.plugin.gamelife.g.b localb = (com.tencent.mm.plugin.gamelife.g.b)this.yaf.getValue();
    AppMethodBeat.o(241235);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.b getContactService()
  {
    AppMethodBeat.i(241233);
    com.tencent.mm.plugin.gamelife.d.b localb = (com.tencent.mm.plugin.gamelife.d.b)this.yae.getValue();
    AppMethodBeat.o(241233);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.e.g getConversationUpdateCallback()
  {
    AppMethodBeat.i(241232);
    com.tencent.mm.plugin.gamelife.e.g localg = (com.tencent.mm.plugin.gamelife.e.g)this.yad.getValue();
    AppMethodBeat.o(241232);
    return localg;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(241243);
    com.tencent.mm.storagebase.h localh = this.hqK;
    if (localh == null) {
      p.hyc();
    }
    AppMethodBeat.o(241243);
    return localh;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.d getGetContactInterceptor()
  {
    AppMethodBeat.i(241234);
    com.tencent.mm.plugin.gamelife.d.d locald = (com.tencent.mm.plugin.gamelife.d.d)this.toD.getValue();
    AppMethodBeat.o(241234);
    return locald;
  }
  
  private final void initDB()
  {
    AppMethodBeat.i(241239);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    this.yac = (((com.tencent.mm.kernel.e)localObject2).azM() + "GameLife.db");
    localObject2 = this.hqK;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (PluginGameLife)this;
      localObject1 = new com.tencent.mm.storagebase.h();
      String str = ((PluginGameLife)localObject2).yac;
      if (str == null) {
        p.btv("cacheDBPath");
      }
      if (!((com.tencent.mm.storagebase.h)localObject1).a(str, ((PluginGameLife)localObject2).collectDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("GameLife db init failed");
        AppMethodBeat.o(241239);
        throw ((Throwable)localObject1);
      }
    }
    this.hqK = ((com.tencent.mm.storagebase.h)localObject1);
    AppMethodBeat.o(241239);
  }
  
  private final void reportChattingDetail(final int paramInt, final long paramLong, String paramString1, final String paramString2, final String paramString3, String paramString4)
  {
    AppMethodBeat.i(241260);
    com.tencent.mm.co.g.hio().i((com.tencent.mm.vending.c.a)new s(paramString1, paramString2, paramString3, paramInt, paramLong, paramString4)).hdy();
    AppMethodBeat.o(241260);
  }
  
  private final void reportGameChatUnreadState()
  {
    try
    {
      AppMethodBeat.i(241265);
      if (this.yal != null) {
        break label67;
      }
      Object localObject1 = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSF, Boolean.FALSE);
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(241265);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    this.yal = ((Boolean)localObject2);
    label67:
    Object localObject3 = this.yal;
    boolean bool;
    int i;
    if (localObject3 != null)
    {
      bool = ((Boolean)localObject3).booleanValue();
      localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class);
      p.g(localObject3, "MMKernel.service(IGameLi…ationService::class.java)");
      i = ((com.tencent.mm.plugin.gamelife.a.c)localObject3).dWZ();
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
      localObject3 = com.tencent.mm.game.report.d.a.hit;
      com.tencent.mm.game.report.d.a.ek(bool);
      localObject3 = Boolean.valueOf(bool);
      label149:
      this.yal = ((Boolean)localObject3);
      AppMethodBeat.o(241265);
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
    AppMethodBeat.i(241258);
    com.tencent.mm.co.g.hio().i((com.tencent.mm.vending.c.a)new t(paramString2, paramString3, paramInteger, paramBoolean2, paramBoolean1, paramInt, paramLong, paramString1)).hdy();
    AppMethodBeat.o(241258);
  }
  
  private final void resetDB()
  {
    AppMethodBeat.i(241242);
    com.tencent.mm.storagebase.h localh = this.hqK;
    if (localh != null) {
      localh.closeDB();
    }
    this.hqK = null;
    this.yag = null;
    this.yah = null;
    this.yai = null;
    this.yak = null;
    this.yaj = null;
    AppMethodBeat.o(241242);
  }
  
  private final void showGameLifeDialog(final Context paramContext, final String paramString, final int paramInt, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami2, final c.b paramb, final com.tencent.mm.plugin.gamelife.a.e parame)
  {
    AppMethodBeat.i(241257);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(paramContext, 1, 2, false);
    localg.apf(2131494973);
    Object localObject = localg.lJI.findViewById(2131302103);
    p.g(localObject, "dialog.rootView.findView…blacklist_notifymsg_text)");
    TextView localTextView1 = (TextView)localObject;
    localObject = localg.lJI.findViewById(2131302104);
    p.g(localObject, "dialog.rootView.findView…agame_blacklist_checkbox)");
    CheckBox localCheckBox = (CheckBox)localObject;
    localObject = localg.lJI.findViewById(2131302105);
    p.g(localObject, "dialog.rootView.findView…fe_wagame_blacklist_text)");
    TextView localTextView2 = (TextView)localObject;
    final com.tencent.mm.plugin.appbrand.ac.i locali = new com.tencent.mm.plugin.appbrand.ac.i();
    locali.value = Boolean.TRUE;
    localCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new u(locali));
    if (parami1 != null) {}
    for (localObject = (Boolean)parami1.value; localObject == null; localObject = null)
    {
      Log.e("GameLife.PluginGameLife", "showGameLifeDialog isBlackList null");
      AppMethodBeat.o(241257);
      return;
    }
    localObject = parami1.value;
    p.g(localObject, "isBlackList.value");
    if (((Boolean)localObject).booleanValue())
    {
      if (paramInt == 2)
      {
        localTextView1.setText(2131761246);
        localTextView2.setVisibility(8);
        localCheckBox.setVisibility(8);
      }
      for (;;)
      {
        localg.a((g.a)new v(this, paramb, parami1, localg, parami2, locali, parame, paramInt), (g.a)new w(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, parame, paramInt));
        localg.b((CharSequence)paramContext.getResources().getString(2131755761), (CharSequence)paramContext.getResources().getString(2131761243));
        localg.aE((CharSequence)paramContext.getResources().getString(2131761244));
        localg.dGm();
        paramContext = parame.getSessionId();
        p.g(paramContext, "sessionInfo.sessionId");
        paramString = parame.getSelfUsername();
        p.g(paramString, "sessionInfo.selfUsername");
        parami1 = parame.ajO();
        p.g(parami1, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 7, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
        AppMethodBeat.o(241257);
        return;
        if (paramInt == 1)
        {
          localTextView1.setText(2131761245);
          if (parami2 != null)
          {
            localObject = parami2.value;
            p.g(localObject, "isAssociateWithWAGame.value");
            if (((Boolean)localObject).booleanValue())
            {
              localTextView2.setText(2131761247);
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
      localTextView1.setText(2131761240);
      localCheckBox.setVisibility(8);
    }
    for (;;)
    {
      localg.a((g.a)new x(this, localg, paramb, parami1, parami2, locali, parame, paramInt), (g.a)new y(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, parame, paramInt));
      localg.apd(paramContext.getResources().getColor(2131100904));
      localg.hbw();
      localg.b((CharSequence)paramContext.getResources().getString(2131755761), (CharSequence)paramContext.getResources().getString(2131761242));
      localg.aE((CharSequence)paramContext.getResources().getString(2131761238));
      localg.dGm();
      paramContext = parame.getSessionId();
      p.g(paramContext, "sessionInfo.sessionId");
      paramString = parame.getSelfUsername();
      p.g(paramString, "sessionInfo.selfUsername");
      parami1 = parame.ajO();
      p.g(parami1, "sessionInfo.talker");
      reportSingleChatInfoUIDetail$default(this, 6, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
      AppMethodBeat.o(241257);
      return;
      if (paramInt == 1)
      {
        localTextView1.setText(2131761239);
        if (parami2 != null)
        {
          localObject = parami2.value;
          p.g(localObject, "isAssociateWithWAGame.value");
          if (((Boolean)localObject).booleanValue())
          {
            localTextView2.setText(2131761241);
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
    AppMethodBeat.i(241240);
    String str = this.yac;
    if (str == null) {
      p.btv("cacheDBPath");
    }
    com.tencent.mm.vfs.s.deleteFile(str);
    resetDB();
    initDB();
    AppMethodBeat.o(241240);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(241262);
    HashMap localHashMap = kotlin.a.ae.g(new o[] { kotlin.s.U(Integer.valueOf("GameLifeContact".hashCode()), f.yau), kotlin.s.U(Integer.valueOf("GameLifeSessionInfo".hashCode()), PluginGameLife.g.yav), kotlin.s.U(Integer.valueOf("GameLifeConversation".hashCode()), h.yax), kotlin.s.U(Integer.valueOf("gamelifemessage".hashCode()), PluginGameLife.i.yay), kotlin.s.U(Integer.valueOf("AppMessage".hashCode()), PluginGameLife.j.yaz) });
    AppMethodBeat.o(241262);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(241238);
    y.a("gamelife", "gamelife/avatar", 536870912L, 3);
    AppMethodBeat.o(241238);
  }
  
  public final void dealBlackList(final Context paramContext, final String paramString, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.ac.i<Boolean> parami2, final c.b paramb)
  {
    AppMethodBeat.i(241256);
    p.h(parami1, "isBlackList");
    p.h(parami2, "isAssociateWithWAGame");
    p.h(paramb, "callback");
    if (paramContext == null)
    {
      AppMethodBeat.o(241256);
      return;
    }
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(paramString);
    p.g(paramString, "sessionInfo");
    Object localObject1 = paramString.ajO();
    Object localObject2 = paramString.getSelfUsername();
    String str = paramString.getSessionId();
    p.g(str, "sessionInfo.sessionId");
    p.g(localObject2, "selfUserName");
    p.g(localObject1, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 5, 2L, str, (String)localObject2, (String)localObject1, null, null, null, 224, null);
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR((String)localObject1);
    p.g(localObject1, "contact");
    final int i = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).dWY();
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
    if (i <= 0)
    {
      Toast.makeText(paramContext, 2131761377, 0).show();
      AppMethodBeat.o(241256);
      return;
    }
    if (i == 2)
    {
      if ((parami1.value != null) && (parami2.value != null))
      {
        p.g(localObject1, "userName");
        showGameLifeDialog(paramContext, (String)localObject1, i, parami1, parami2, paramb, paramString);
        AppMethodBeat.o(241256);
      }
    }
    else if (i == 1)
    {
      localObject2 = (ProgressDialog)com.tencent.mm.ui.base.q.a(paramContext, (CharSequence)paramContext.getResources().getString(2131756029), true, 3, null);
      if (localObject2 == null) {
        p.hyc();
      }
      ((ProgressDialog)localObject2).show();
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a((String)localObject1, (b.a)new m(this, parami1, parami2, (String)localObject1, (ProgressDialog)localObject2, paramContext, i, paramb, paramString));
    }
    AppMethodBeat.o(241256);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(241264);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    AppMethodBeat.o(241264);
  }
  
  public final void enterChattingUI(Context paramContext, String paramString1, String paramString2, int paramInt, com.tencent.mm.bw.b paramb)
  {
    AppMethodBeat.i(241249);
    p.h(paramContext, "context");
    p.h(paramString1, "selfUsername");
    p.h(paramString2, "talker");
    z.f localf = new z.f();
    localf.SYG = null;
    checkSessionIdAndContact(paramString1, paramString2, paramInt, paramb, (kotlin.g.a.b)new PluginGameLife.n(com.tencent.f.h.RTc.n((Runnable)new PluginGameLife.o(localf, paramContext), 1000L), localf, paramString1, paramContext));
    AppMethodBeat.o(241249);
  }
  
  public final void enterExpose(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(241253);
    p.h(paramIntent, "intent");
    p.h(paramString, "sessionId");
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(paramString);
    p.g(locale, "sessionInfo");
    paramString = locale.ajO();
    Log.d("GameLife.PluginGameLife", "talkerName:%s", new Object[] { paramString });
    paramIntent.putExtra("k_username", paramString);
    Object localObject = kotlin.g.b.ae.SYK;
    localObject = e.e.OyW;
    p.g(localObject, "ConstantsUI.ExposeUI.KExposeGameLifeUrl");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(39) }, 1));
    p.g(localObject, "java.lang.String.format(format, *args)");
    paramIntent.putExtra("rawUrl", (String)localObject);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    paramContext = locale.getSelfUsername();
    paramIntent = locale.getSessionId();
    p.g(paramIntent, "sessionInfo.sessionId");
    p.g(paramContext, "selfUserName");
    p.g(paramString, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 8, 40L, paramIntent, paramContext, paramString, null, null, null, 224, null);
    AppMethodBeat.o(241253);
  }
  
  public final void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(241252);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(241252);
      return;
    }
    if (paramInt == a.xZY) {
      if (as.bjv(paramString)) {
        reportChattingDetail(2, 7L, paramString, null, null, "1");
      }
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(paramString);
      label107:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).dWX();
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
        AppMethodBeat.o(241252);
        return;
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(paramString);
        p.g(localObject1, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).ajO();
        p.g(paramString, "sessionInfo.talker");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSelfUsername();
        p.g(localObject2, "sessionInfo.selfUsername");
        reportChattingDetail(2, 7L, (String)localObject2, ((com.tencent.mm.plugin.gamelife.a.e)localObject1).getSessionId(), ((com.tencent.mm.plugin.gamelife.a.e)localObject1).ajO(), "2");
        break;
        if (paramInt != a.xZX) {
          break label431;
        }
        Object localObject3 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(paramString);
        p.g(localObject3, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).ajO();
        p.g(paramString, "sessionInfo.talker");
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSessionId();
        p.g(localObject1, "sessionInfo.sessionId");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).getSelfUsername();
        p.g(localObject2, "sessionInfo.selfUsername");
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.e)localObject3).ajO();
        p.g(localObject3, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 2, 7L, (String)localObject1, (String)localObject2, (String)localObject3, null, null, null, 224, null);
        break;
        localObject1 = "";
        break label107;
      }
      label373:
      Log.i("GameLife.PluginGameLife", "userName:%s,jumpUrl:%s", new Object[] { paramString, localObject1 });
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject1);
      com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(241252);
      return;
      label431:
      paramString = "";
    }
  }
  
  public final void enterSendGift(Context paramContext, String paramString)
  {
    AppMethodBeat.i(241255);
    p.h(paramContext, "context");
    p.h(paramString, "sessionId");
    Log.i("GameLife.PluginGameLife", "enterSendGift sessionId[%s]", new Object[] { paramString });
    com.tencent.mm.plugin.gamelife.a.e locale = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(paramString);
    if (locale != null)
    {
      com.tencent.mm.plugin.gamelife.a.a locala = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(locale.getSelfUsername());
      Object localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(locale.ajO());
      long l1;
      long l2;
      if ((locala != null) && (localObject1 != null))
      {
        Object localObject2 = com.tencent.mm.game.report.c.hhl;
        l1 = locala.dWY();
        Object localObject3 = locala.getUsername();
        p.g(localObject3, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).dWY();
        String str = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        p.g(str, "talkerContact.username");
        p.h(paramString, "sessionId");
        p.h(localObject3, "fromUsername");
        p.h(str, "toUsername");
        localObject2 = com.tencent.mm.game.report.c.a.a(3L, 302L, 2L, 2L, 301L);
        ((eq)localObject2).rP(paramString);
        ((eq)localObject2).mX(l1);
        ((eq)localObject2).rN((String)localObject3);
        ((eq)localObject2).mY(l2);
        ((eq)localObject2).rO(str);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("ser_name", 4L);
        ((eq)localObject2).rQ(URLEncoder.encode(((JSONObject)localObject3).toString()));
        ((eq)localObject2).bfK();
      }
      int i = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.c.class)).C(paramContext, locale.getSelfUsername(), locale.ajO());
      if ((locala != null) && (localObject1 != null))
      {
        if (i == 40)
        {
          paramContext = com.tencent.mm.game.report.c.hhl;
          l1 = locala.dWY();
          paramContext = locala.getUsername();
          p.g(paramContext, "selfContact.username");
          l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).dWY();
          localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
          p.g(localObject1, "talkerContact.username");
          com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 40L);
          AppMethodBeat.o(241255);
          return;
        }
        paramContext = com.tencent.mm.game.report.c.hhl;
        l1 = locala.dWY();
        paramContext = locala.getUsername();
        p.g(paramContext, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).dWY();
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        p.g(localObject1, "talkerContact.username");
        com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 71L);
      }
      AppMethodBeat.o(241255);
      return;
    }
    AppMethodBeat.o(241255);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(241236);
    p.h(paramg, "profile");
    if (paramg.aBb())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.f.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.j.b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.b.class, (com.tencent.mm.kernel.c.a)getContactService());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.c.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.e.d());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.d.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.h.a());
    }
    AppMethodBeat.o(241236);
  }
  
  public final com.tencent.mm.plugin.gamelife.g.c getAppMessageStorage()
  {
    AppMethodBeat.i(241247);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.gamelife.g.c localc2 = this.yak;
    com.tencent.mm.plugin.gamelife.g.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.g.c((ISQLiteDatabase)getDB());
    }
    this.yak = localc1;
    localc1 = this.yak;
    if (localc1 == null) {
      p.hyc();
    }
    AppMethodBeat.o(241247);
    return localc1;
  }
  
  public final String getAvatarPath()
  {
    AppMethodBeat.i(241230);
    String str = this.tjJ;
    if (str == null) {
      p.btv("avatarPath");
    }
    AppMethodBeat.o(241230);
    return str;
  }
  
  public final com.tencent.mm.plugin.gamelife.d.c getContactStorage()
  {
    AppMethodBeat.i(241244);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.gamelife.d.c localc2 = this.yag;
    com.tencent.mm.plugin.gamelife.d.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.d.c((ISQLiteDatabase)getDB());
    }
    this.yag = localc1;
    localc1 = this.yag;
    if (localc1 == null) {
      p.hyc();
    }
    AppMethodBeat.o(241244);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.gamelife.e.e getConversationStorage()
  {
    AppMethodBeat.i(241246);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.gamelife.e.e locale2 = this.yai;
    com.tencent.mm.plugin.gamelife.e.e locale1 = locale2;
    if (locale2 == null) {
      locale1 = new com.tencent.mm.plugin.gamelife.e.e((ISQLiteDatabase)getDB());
    }
    this.yai = locale1;
    locale1 = this.yai;
    if (locale1 == null) {
      p.hyc();
    }
    AppMethodBeat.o(241246);
    return locale1;
  }
  
  public final com.tencent.mm.plugin.gamelife.g.d getMessageStorage()
  {
    AppMethodBeat.i(241248);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiy();
    com.tencent.mm.plugin.gamelife.g.d locald = this.yaj;
    localObject = locald;
    if (locald == null)
    {
      p.g(locali, "msgStg");
      localObject = new com.tencent.mm.plugin.gamelife.g.d(locali);
    }
    this.yaj = ((com.tencent.mm.plugin.gamelife.g.d)localObject);
    localObject = this.yaj;
    if (localObject == null) {
      p.hyc();
    }
    AppMethodBeat.o(241248);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.gamelife.j.c getSessionInfoStorage()
  {
    AppMethodBeat.i(241245);
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.gamelife.j.c localc2 = this.yah;
    com.tencent.mm.plugin.gamelife.j.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.j.c((ISQLiteDatabase)getDB());
    }
    this.yah = localc1;
    localc1 = this.yah;
    if (localc1 == null) {
      p.hyc();
    }
    AppMethodBeat.o(241245);
    return localc1;
  }
  
  public final void initGameLifeSingleChatInfoUI(final Context paramContext, String paramString, final c.a parama)
  {
    AppMethodBeat.i(241254);
    if (paramContext == null)
    {
      AppMethodBeat.o(241254);
      return;
    }
    Object localObject = com.tencent.mm.game.report.c.hhl;
    com.tencent.mm.game.report.c.a.a(4L, 0L, 0L, 1L, 301L).bfK();
    localObject = com.tencent.mm.ui.base.q.a(paramContext, (CharSequence)paramContext.getResources().getString(2131756029), true, 3, null);
    p.g(localObject, "MMProgressDialog.show(co…TLE_TRANSPARENT_BG, null)");
    localObject = (ProgressDialog)localObject;
    ((ProgressDialog)localObject).show();
    paramString = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).avi(paramString);
    paramString = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).aAR(paramString);
    p.g(paramString, "contact");
    String str = paramString.getUsername();
    if (paramString.dWY() <= 0)
    {
      Toast.makeText(paramContext, 2131761377, 0).show();
      AppMethodBeat.o(241254);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(str, (b.a)new q((ProgressDialog)localObject, parama, paramContext));
    AppMethodBeat.o(241254);
  }
  
  public final void jumpToGameLifeSingleChatInfoUIReport(String paramString)
  {
    AppMethodBeat.i(241251);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("GameLife.PluginGameLife", "jumpToGameLifeSingleChatInfoUI sessionId null!");
      AppMethodBeat.o(241251);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.gamelife.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.f.class)).aAW(paramString);
    p.g(localObject2, "sessionInfo");
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).ajO();
    localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)localObject2).getSelfUsername();
    p.g(localObject2, "selfUserName");
    reportChattingDetail$default(this, 1, 6L, (String)localObject2, paramString, (String)localObject1, null, 32, null);
    AppMethodBeat.o(241251);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(241237);
    Log.i("GameLife.PluginGameLife", "Account Init");
    initDB();
    paramc = new StringBuilder();
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    this.tjJ = (((com.tencent.mm.kernel.e)localObject).getAccPath() + "gamelife/avatar/");
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(3, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.gamelife.g.e());
    paramc = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    paramc.eiy().a((com.tencent.mm.storage.e)getMessageStorage());
    paramc.aST().a((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdateCallback());
    paramc.aSN().a((bv.a)getContactService().ybG);
    paramc = a.b.gov();
    if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      localObject = new com.tencent.mm.plugin.gamelife.f.d(((com.tencent.mm.pluginsdk.ui.b)paramc).gow());
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelife", (j.a)localObject);
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelifesess", (j.a)localObject);
    }
    af.a.a((af.b)getGetContactInterceptor());
    com.tencent.mm.plugin.r.a.eAT().a((l.b)getAppMessageInterceptor());
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class)).m(this.xWT);
    com.tencent.f.h.RTc.o((Runnable)new r(this), 1000L);
    AppMethodBeat.o(241237);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(241263);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(3);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aST().b((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdateCallback());
    locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().b((bv.a)getContactService().ybG);
    af.a.b((af.b)getGetContactInterceptor());
    com.tencent.mm.plugin.r.a.eAT().b((l.b)getAppMessageInterceptor());
    ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.xWT);
    resetDB();
    AppMethodBeat.o(241263);
  }
  
  public final void setAvatarPath(String paramString)
  {
    AppMethodBeat.i(241231);
    p.h(paramString, "<set-?>");
    this.tjJ = paramString;
    AppMethodBeat.o(241231);
  }
  
  public final void testEnterChattingUI()
  {
    AppMethodBeat.i(241241);
    PluginGameLife localPluginGameLife = (PluginGameLife)com.tencent.mm.kernel.g.ah(PluginGameLife.class);
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localPluginGameLife.enterChattingUI(localContext, yam, yan, 0, null);
    AppMethodBeat.o(241241);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.g.b>
  {
    public static final b yap;
    
    static
    {
      AppMethodBeat.i(241193);
      yap = new b();
      AppMethodBeat.o(241193);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onDone"})
  static final class c
    implements f.a
  {
    c(AtomicInteger paramAtomicInteger, kotlin.g.a.b paramb, LinkedList paramLinkedList, Runnable paramRunnable) {}
    
    public final void onDone(String paramString)
    {
      AppMethodBeat.i(241194);
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (this.yaq.getAndSet(-1) < 0) {
          break label87;
        }
        Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get session failed");
        paramb1.invoke(null);
        AppMethodBeat.o(241194);
        return;
      }
      localLinkedList.add(paramString);
      localRunnable.run();
      label87:
      AppMethodBeat.o(241194);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class d
    implements b.c
  {
    d(String paramString1, String paramString2, Runnable paramRunnable, AtomicInteger paramAtomicInteger, kotlin.g.a.b paramb) {}
    
    public final void aj(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
    {
      AppMethodBeat.i(241195);
      com.tencent.mm.plugin.gamelife.a.a locala = (com.tencent.mm.plugin.gamelife.a.a)paramMap.get(this.yat);
      if ((locala != null) && (locala.isValid() == true))
      {
        paramMap = (com.tencent.mm.plugin.gamelife.a.a)paramMap.get(paramString2);
        if ((paramMap != null) && (paramMap.isValid() == true))
        {
          localRunnable.run();
          AppMethodBeat.o(241195);
          return;
        }
      }
      if (localAtomicInteger.getAndSet(-1) >= 0)
      {
        Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get contact failed");
        paramb1.invoke(null);
      }
      AppMethodBeat.o(241195);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(AtomicInteger paramAtomicInteger, LinkedList paramLinkedList, kotlin.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(241196);
      if (this.yaq.incrementAndGet() == 2)
      {
        Log.i("GameLife.PluginGameLife", "checkSessionIdAndContact success: " + (String)localLinkedList.get(0));
        paramb1.invoke(localLinkedList.get(0));
      }
      AppMethodBeat.o(241196);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class f
    implements h.b
  {
    public static final f yau;
    
    static
    {
      AppMethodBeat.i(241198);
      yau = new f();
      AppMethodBeat.o(241198);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(241197);
      Object localObject = com.tencent.mm.plugin.gamelife.d.c.ybR;
      localObject = com.tencent.mm.plugin.gamelife.d.c.dax();
      AppMethodBeat.o(241197);
      return localObject;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class h
    implements h.b
  {
    public static final h yax;
    
    static
    {
      AppMethodBeat.i(241202);
      yax = new h();
      AppMethodBeat.o(241202);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(241201);
      Object localObject = com.tencent.mm.plugin.gamelife.e.e.ycb;
      localObject = com.tencent.mm.plugin.gamelife.e.e.dax();
      AppMethodBeat.o(241201);
      return localObject;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.d.b>
  {
    public static final k yaA;
    
    static
    {
      AppMethodBeat.i(241208);
      yaA = new k();
      AppMethodBeat.o(241208);
    }
    
    k()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.e.g>
  {
    public static final l yaB;
    
    static
    {
      AppMethodBeat.i(241210);
      yaB = new l();
      AppMethodBeat.o(241210);
    }
    
    l()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gamelife/PluginGameLife$dealBlackList$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static final class m
    implements b.a
  {
    m(com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, String paramString, ProgressDialog paramProgressDialog, Context paramContext, int paramInt, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame) {}
    
    public final void U(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(241211);
      parami1.value = Boolean.valueOf(paramBoolean2);
      parami2.value = Boolean.valueOf(paramBoolean1);
      Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame userName:%s,isAssociate:%b,isOwnBlack:%b", new Object[] { this.jDi, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.yaF != null) && (this.yaF.isShowing()))
      {
        this.yaF.dismiss();
        PluginGameLife localPluginGameLife = this.yaC;
        Context localContext = paramContext;
        String str = this.jDi;
        p.g(str, "userName");
        int i = i;
        com.tencent.mm.plugin.appbrand.ac.i locali1 = parami1;
        com.tencent.mm.plugin.appbrand.ac.i locali2 = parami2;
        c.b localb = paramb;
        com.tencent.mm.plugin.gamelife.a.e locale = paramString;
        p.g(locale, "sessionInfo");
        PluginGameLife.access$showGameLifeDialog(localPluginGameLife, localContext, str, i, locali1, locali2, localb, locale);
      }
      AppMethodBeat.o(241211);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.gamelife.d.d>
  {
    public static final p yaK;
    
    static
    {
      AppMethodBeat.i(241216);
      yaK = new p();
      AppMethodBeat.o(241216);
    }
    
    p()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gamelife/PluginGameLife$initGameLifeSingleChatInfoUI$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static final class q
    implements b.a
  {
    q(ProgressDialog paramProgressDialog, c.a parama, Context paramContext) {}
    
    public final void U(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(241217);
      Log.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame isAssociate:%b,isOwnBlack:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.yaL != null) && (this.yaL.isShowing())) {
        this.yaL.dismiss();
      }
      c.a locala = parama;
      if (locala != null)
      {
        locala.U(paramBoolean1, paramBoolean2);
        AppMethodBeat.o(241217);
        return;
      }
      AppMethodBeat.o(241217);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(PluginGameLife paramPluginGameLife) {}
    
    public final void run()
    {
      AppMethodBeat.i(241218);
      PluginGameLife.access$reportGameChatUnreadState(this.yaC);
      AppMethodBeat.o(241218);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class s<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    s(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class t<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    t(String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, long paramLong, String paramString3) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class u
    implements CompoundButton.OnCheckedChangeListener
  {
    u(com.tencent.mm.plugin.appbrand.ac.i parami) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(241221);
      this.yaT.value = Boolean.valueOf(paramBoolean);
      AppMethodBeat.o(241221);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class v
    implements g.a
  {
    v(PluginGameLife paramPluginGameLife, c.b paramb, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.ac.i parami2, com.tencent.mm.plugin.appbrand.ac.i parami3, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(241222);
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        p.g(localObject2, "isBlackList.value");
        ((c.b)localObject1).mM(((Boolean)localObject2).booleanValue());
      }
      localg.bMo();
      boolean bool;
      if (parami2 != null)
      {
        localObject1 = parami2.value;
        p.g(localObject1, "isAssociateWithWAGame.value");
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = locali.value;
          p.g(localObject1, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject1).booleanValue()) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.yaC;
        localObject2 = parame.getSessionId();
        p.g(localObject2, "sessionInfo.sessionId");
        String str1 = parame.getSelfUsername();
        p.g(str1, "sessionInfo.selfUsername");
        String str2 = parame.ajO();
        p.g(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 7, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(241222);
        return;
        bool = false;
        continue;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class w
    implements g.a
  {
    w(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, String paramString, com.tencent.mm.plugin.appbrand.ac.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(241224);
      localg.bMo();
      final z.a locala = new z.a();
      locala.SYB = false;
      Object localObject;
      boolean bool;
      if (parami2 != null)
      {
        localObject = parami2.value;
        p.g(localObject, "isAssociateWithWAGame.value");
        if (((Boolean)localObject).booleanValue())
        {
          localObject = locali.value;
          p.g(localObject, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject).booleanValue())
          {
            bool = true;
            locala.SYB = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, false, locala.SYB, (b.b)new b.b()
        {
          public final void mM(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(241223);
            Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b", new Object[] { this.yaU.jDi, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.SYB) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.yaU.yaD;
              if (!((Boolean)this.yaU.yaD.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.ac.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.yaU.yaH;
              Object localObject2 = this.yaU.yaD.value;
              p.g(localObject2, "isBlackList.value");
              ((c.b)localObject1).mM(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(241223);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.yaU.$context, 2131761389, 0).show();
            }
          }
        });
        localObject = this.yaC;
        String str1 = parame.getSessionId();
        p.g(str1, "sessionInfo.sessionId");
        String str2 = parame.getSelfUsername();
        p.g(str2, "sessionInfo.selfUsername");
        String str3 = parame.ajO();
        p.g(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 7, 64L, str1, str2, str3, Boolean.valueOf(locala.SYB), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(241224);
        return;
        bool = false;
        break;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList isAssociateWithWAGame null");
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class x
    implements g.a
  {
    x(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, c.b paramb, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, com.tencent.mm.plugin.appbrand.ac.i parami3, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(241225);
      localg.bMo();
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        p.g(localObject2, "isBlackList.value");
        ((c.b)localObject1).mM(((Boolean)localObject2).booleanValue());
      }
      boolean bool;
      if (parami2 != null)
      {
        localObject1 = parami2.value;
        p.g(localObject1, "isAssociateWithWAGame.value");
        if (((Boolean)localObject1).booleanValue())
        {
          localObject1 = locali.value;
          p.g(localObject1, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject1).booleanValue()) {
            bool = true;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.yaC;
        localObject2 = parame.getSessionId();
        p.g(localObject2, "sessionInfo.sessionId");
        String str1 = parame.getSelfUsername();
        p.g(str1, "sessionInfo.selfUsername");
        String str2 = parame.ajO();
        p.g(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 6, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(241225);
        return;
        bool = false;
        continue;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class y
    implements g.a
  {
    y(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.ac.i parami1, com.tencent.mm.plugin.appbrand.ac.i parami2, String paramString, com.tencent.mm.plugin.appbrand.ac.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.e parame, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(241227);
      localg.bMo();
      final z.a locala = new z.a();
      locala.SYB = false;
      Object localObject;
      boolean bool;
      if (parami2 != null)
      {
        localObject = parami2.value;
        p.g(localObject, "isAssociateWithWAGame.value");
        if (((Boolean)localObject).booleanValue())
        {
          localObject = locali.value;
          p.g(localObject, "dealWaGameAccountTogetherCheckBox.value");
          if (((Boolean)localObject).booleanValue())
          {
            bool = true;
            locala.SYB = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, true, locala.SYB, (b.b)new b.b()
        {
          public final void mM(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(241226);
            Log.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b ", new Object[] { this.yaW.jDi, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.SYB) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.yaW.yaD;
              if (!((Boolean)this.yaW.yaD.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.ac.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.yaW.yaH;
              Object localObject2 = this.yaW.yaD.value;
              p.g(localObject2, "isBlackList.value");
              ((c.b)localObject1).mM(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(241226);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.yaW.$context, 2131761378, 0).show();
            }
          }
        });
        localObject = this.yaC;
        String str1 = parame.getSessionId();
        p.g(str1, "sessionInfo.sessionId");
        String str2 = parame.getSelfUsername();
        p.g(str2, "sessionInfo.selfUsername");
        String str3 = parame.ajO();
        p.g(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 6, 65L, str1, str2, str3, Boolean.valueOf(locala.SYB), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(241227);
        return;
        bool = false;
        break;
        Log.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null");
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class z
    implements MStorage.IOnStorageChange
  {
    z(PluginGameLife paramPluginGameLife) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(241229);
      if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) {
        com.tencent.f.h.RTc.b((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241228);
            PluginGameLife.access$reportGameChatUnreadState(this.yaX.yaC);
            AppMethodBeat.o(241228);
          }
        }, "reportGameChatUnreadState");
      }
      AppMethodBeat.o(241229);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife
 * JD-Core Version:    0.7.0.1
 */