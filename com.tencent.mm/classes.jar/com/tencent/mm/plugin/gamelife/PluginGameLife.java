package com.tencent.mm.plugin.gamelife;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.model.aa.a;
import com.tencent.mm.model.aa.b;
import com.tencent.mm.plugin.gamelife.a.b.a;
import com.tencent.mm.plugin.gamelife.a.b.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.e.a;
import com.tencent.mm.pluginsdk.model.app.l.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bp.a;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.widget.a.g.a;
import d.a.ae;
import d.a.j;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.f;
import d.u;
import d.z;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/PluginGameLife;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "()V", "appMessageInterceptor", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "getAppMessageInterceptor", "()Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "appMessageInterceptor$delegate", "Lkotlin/Lazy;", "appMessageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "avatarPath", "", "getAvatarPath", "()Ljava/lang/String;", "setAvatarPath", "(Ljava/lang/String;)V", "cacheDBPath", "contactService", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "getContactService", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "contactService$delegate", "contactStorage", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactStorage;", "conversationStorage", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationStorage;", "conversationUpdateCallback", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "getConversationUpdateCallback", "()Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "conversationUpdateCallback$delegate", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getContactInterceptor", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getGetContactInterceptor", "()Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "getContactInterceptor$delegate", "lock", "", "messageStorage", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeMessageStorage;", "sessionInfoStorage", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "checkSessionIdAndContact", "", "selfUsername", "talker", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sessionId", "clearDB", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dealBlackList", "context", "Landroid/content/Context;", "isBlackList", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "", "isAssociateWithWAGame", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListSetCallback;", "dependency", "enterChattingUI", "enterExpose", "intent", "Landroid/content/Intent;", "enterGameLifeProfileUI", "outerUserName", "scene", "enterSendGift", "execute", "getAppMessageStorage", "getContactStorage", "getConversationStorage", "getDB", "getMessageStorage", "getSessionInfoStorage", "initDB", "initGameLifeSingleChatInfoUI", "Lcom/tencent/mm/plugin/gamelife/IPluginGameLife$BlackListAssociateCallback;", "jumpToGameLifeSingleChatInfoUIReport", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "reportChattingDetail", "pos", "actionId", "", "selfUserName", "actionStatus", "reportSingleChatInfoUIDetail", "dealWaGameAccountTogether", "accountType", "associate", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "resetDB", "showGameLifeDialog", "userName", "sessionInfo", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "testEnterChattingUI", "Companion", "plugin-gamelife_release"})
public final class PluginGameLife
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.c, c
{
  private static final String uwA = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
  private static final String uwB = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
  public static final a uwC;
  private com.tencent.mm.storagebase.h gBq;
  private final byte[] lock;
  public String rBN;
  private final d.f rGw;
  private String uwr;
  private final d.f uws;
  private final d.f uwt;
  private final d.f uwu;
  private com.tencent.mm.plugin.gamelife.d.c uwv;
  private com.tencent.mm.plugin.gamelife.i.c uww;
  private com.tencent.mm.plugin.gamelife.e.d uwx;
  private com.tencent.mm.plugin.gamelife.g.d uwy;
  private com.tencent.mm.plugin.gamelife.g.c uwz;
  
  static
  {
    AppMethodBeat.i(211261);
    uwC = new a((byte)0);
    uwA = "U1_BgAAHED13WDGBipLzICG_mkIR7gtkryaxyn7Ed4@gamelife";
    uwB = "U1_BgAAHED13WDGBipLsjCl-jj_DtzKiu7ntwVX5oE@gamelife";
    AppMethodBeat.o(211261);
  }
  
  public PluginGameLife()
  {
    AppMethodBeat.i(211260);
    this.lock = new byte[0];
    this.uws = d.g.O((d.g.a.a)l.uwO);
    this.uwt = d.g.O((d.g.a.a)k.uwN);
    this.rGw = d.g.O((d.g.a.a)p.uwX);
    this.uwu = d.g.O((d.g.a.a)b.uwD);
    AppMethodBeat.o(211260);
  }
  
  private final void checkSessionIdAndContact(String paramString1, final String paramString2, final d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(211245);
    final AtomicInteger localAtomicInteger = new AtomicInteger(0);
    final LinkedList localLinkedList = new LinkedList();
    final Runnable localRunnable = (Runnable)new e(localAtomicInteger, localLinkedList, paramb);
    ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).a(paramString1, paramString2, (e.a)new c(localAtomicInteger, paramb, localLinkedList, localRunnable));
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(j.listOf(new String[] { paramString1, paramString2 }), (b.c)new d(paramString1, paramString2, localRunnable, localAtomicInteger, paramb));
    AppMethodBeat.o(211245);
  }
  
  private final com.tencent.mm.plugin.gamelife.g.b getAppMessageInterceptor()
  {
    AppMethodBeat.i(211230);
    com.tencent.mm.plugin.gamelife.g.b localb = (com.tencent.mm.plugin.gamelife.g.b)this.uwu.getValue();
    AppMethodBeat.o(211230);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.b getContactService()
  {
    AppMethodBeat.i(211228);
    com.tencent.mm.plugin.gamelife.d.b localb = (com.tencent.mm.plugin.gamelife.d.b)this.uwt.getValue();
    AppMethodBeat.o(211228);
    return localb;
  }
  
  private final com.tencent.mm.plugin.gamelife.e.f getConversationUpdateCallback()
  {
    AppMethodBeat.i(211227);
    com.tencent.mm.plugin.gamelife.e.f localf = (com.tencent.mm.plugin.gamelife.e.f)this.uws.getValue();
    AppMethodBeat.o(211227);
    return localf;
  }
  
  private final com.tencent.mm.storagebase.h getDB()
  {
    AppMethodBeat.i(211238);
    com.tencent.mm.storagebase.h localh = this.gBq;
    if (localh == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(211238);
    return localh;
  }
  
  private final com.tencent.mm.plugin.gamelife.d.d getGetContactInterceptor()
  {
    AppMethodBeat.i(211229);
    com.tencent.mm.plugin.gamelife.d.d locald = (com.tencent.mm.plugin.gamelife.d.d)this.rGw.getValue();
    AppMethodBeat.o(211229);
    return locald;
  }
  
  private final void initDB()
  {
    AppMethodBeat.i(211234);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject2, "MMKernel.storage()");
    this.uwr = (((com.tencent.mm.kernel.e)localObject2).ajh() + "GameLife.db");
    localObject2 = this.gBq;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (PluginGameLife)this;
      localObject1 = new com.tencent.mm.storagebase.h();
      String str = ((PluginGameLife)localObject2).uwr;
      if (str == null) {
        d.g.b.p.bcb("cacheDBPath");
      }
      if (!((com.tencent.mm.storagebase.h)localObject1).b(str, ((PluginGameLife)localObject2).collectDatabaseFactory(), true))
      {
        localObject1 = (Throwable)new SQLiteException("GameLife db init failed");
        AppMethodBeat.o(211234);
        throw ((Throwable)localObject1);
      }
    }
    this.gBq = ((com.tencent.mm.storagebase.h)localObject1);
    AppMethodBeat.o(211234);
  }
  
  private final void reportChattingDetail(final int paramInt, final long paramLong, String paramString1, final String paramString2, final String paramString3, String paramString4)
  {
    AppMethodBeat.i(211255);
    com.tencent.mm.cn.g.fSm().i((com.tencent.mm.vending.c.a)new r(paramString1, paramString2, paramString3, paramInt, paramLong, paramString4)).fOb();
    AppMethodBeat.o(211255);
  }
  
  private final void reportSingleChatInfoUIDetail(final int paramInt, final long paramLong, String paramString1, String paramString2, final String paramString3, final Boolean paramBoolean1, final Integer paramInteger, final Boolean paramBoolean2)
  {
    AppMethodBeat.i(211253);
    com.tencent.mm.cn.g.fSm().i((com.tencent.mm.vending.c.a)new s(paramString2, paramString3, paramInteger, paramBoolean2, paramBoolean1, paramInt, paramLong, paramString1)).fOb();
    AppMethodBeat.o(211253);
  }
  
  private final void resetDB()
  {
    AppMethodBeat.i(211237);
    com.tencent.mm.storagebase.h localh = this.gBq;
    if (localh != null) {
      localh.closeDB();
    }
    this.gBq = null;
    this.uwv = null;
    this.uww = null;
    this.uwx = null;
    this.uwz = null;
    this.uwy = null;
    AppMethodBeat.o(211237);
  }
  
  private final void showGameLifeDialog(final Context paramContext, final String paramString, final int paramInt, final com.tencent.mm.plugin.appbrand.z.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.z.i<Boolean> parami2, final c.b paramb, final com.tencent.mm.plugin.gamelife.a.d paramd)
  {
    AppMethodBeat.i(211252);
    final com.tencent.mm.ui.widget.a.g localg = new com.tencent.mm.ui.widget.a.g(paramContext, (byte)0);
    localg.aft(2131496405);
    Object localObject = localg.kBS.findViewById(2131308124);
    d.g.b.p.g(localObject, "dialog.rootView.findView…blacklist_notifymsg_text)");
    TextView localTextView1 = (TextView)localObject;
    localObject = localg.kBS.findViewById(2131308127);
    d.g.b.p.g(localObject, "dialog.rootView.findView…agame_blacklist_checkbox)");
    CheckBox localCheckBox = (CheckBox)localObject;
    localObject = localg.kBS.findViewById(2131308128);
    d.g.b.p.g(localObject, "dialog.rootView.findView…fe_wagame_blacklist_text)");
    TextView localTextView2 = (TextView)localObject;
    final com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    locali.value = Boolean.TRUE;
    localCheckBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new t(locali));
    if (parami1 != null) {}
    for (localObject = (Boolean)parami1.value; localObject == null; localObject = null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "showGameLifeDialog isBlackList null");
      AppMethodBeat.o(211252);
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
        localg.a((g.a)new u(this, paramb, parami1, localg, parami2, locali, paramd, paramInt), (g.a)new v(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, paramd, paramInt));
        localg.c((CharSequence)paramContext.getResources().getString(2131755691), (CharSequence)paramContext.getResources().getString(2131766881));
        localg.ay((CharSequence)paramContext.getResources().getString(2131766882));
        localg.cMW();
        paramContext = paramd.getSessionId();
        d.g.b.p.g(paramContext, "sessionInfo.sessionId");
        paramString = paramd.getSelfUsername();
        d.g.b.p.g(paramString, "sessionInfo.selfUsername");
        parami1 = paramd.VS();
        d.g.b.p.g(parami1, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 7, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
        AppMethodBeat.o(211252);
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
      localg.a((g.a)new w(this, localg, paramb, parami1, parami2, locali, paramd, paramInt), (g.a)new x(this, localg, parami2, locali, paramString, parami1, paramContext, paramb, paramd, paramInt));
      localg.afr(paramContext.getResources().getColor(2131100711));
      localg.fMl();
      localg.c((CharSequence)paramContext.getResources().getString(2131755691), (CharSequence)paramContext.getResources().getString(2131766880));
      localg.ay((CharSequence)paramContext.getResources().getString(2131766876));
      localg.cMW();
      paramContext = paramd.getSessionId();
      d.g.b.p.g(paramContext, "sessionInfo.sessionId");
      paramString = paramd.getSelfUsername();
      d.g.b.p.g(paramString, "sessionInfo.selfUsername");
      parami1 = paramd.VS();
      d.g.b.p.g(parami1, "sessionInfo.talker");
      reportSingleChatInfoUIDetail$default(this, 6, 1L, paramContext, paramString, parami1, null, null, null, 224, null);
      AppMethodBeat.o(211252);
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
    AppMethodBeat.i(211235);
    String str = this.uwr;
    if (str == null) {
      d.g.b.p.bcb("cacheDBPath");
    }
    com.tencent.mm.vfs.i.deleteFile(str);
    resetDB();
    initDB();
    AppMethodBeat.o(211235);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(211257);
    HashMap localHashMap = ae.c(new d.o[] { u.S(Integer.valueOf("GameLifeContact".hashCode()), f.uwI), u.S(Integer.valueOf("GameLifeSessionInfo".hashCode()), g.uwJ), u.S(Integer.valueOf("GameLifeConversation".hashCode()), h.uwK), u.S(Integer.valueOf("gamelifemessage".hashCode()), i.uwL), u.S(Integer.valueOf("AppMessage".hashCode()), PluginGameLife.j.uwM) });
    AppMethodBeat.o(211257);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(211233);
    com.tencent.mm.vfs.o.a("gamelife", "gamelife/avatar", 536870912L, 3);
    AppMethodBeat.o(211233);
  }
  
  public final void dealBlackList(final Context paramContext, final String paramString, final com.tencent.mm.plugin.appbrand.z.i<Boolean> parami1, final com.tencent.mm.plugin.appbrand.z.i<Boolean> parami2, final c.b paramb)
  {
    AppMethodBeat.i(211251);
    d.g.b.p.h(parami1, "isBlackList");
    d.g.b.p.h(parami2, "isAssociateWithWAGame");
    d.g.b.p.h(paramb, "callback");
    if (paramContext == null)
    {
      AppMethodBeat.o(211251);
      return;
    }
    paramString = ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).amC(paramString);
    d.g.b.p.g(paramString, "sessionInfo");
    Object localObject1 = paramString.VS();
    Object localObject2 = paramString.getSelfUsername();
    String str = paramString.getSessionId();
    d.g.b.p.g(str, "sessionInfo.sessionId");
    d.g.b.p.g(localObject2, "selfUserName");
    d.g.b.p.g(localObject1, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 5, 2L, str, (String)localObject2, (String)localObject1, null, null, null, 224, null);
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).amA((String)localObject1);
    d.g.b.p.g(localObject1, "contact");
    final int i = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).daC();
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
    if (i <= 0)
    {
      Toast.makeText(paramContext, 2131766892, 0).show();
      AppMethodBeat.o(211251);
      return;
    }
    if (i == 2)
    {
      if ((parami1.value != null) && (parami2.value != null))
      {
        d.g.b.p.g(localObject1, "userName");
        showGameLifeDialog(paramContext, (String)localObject1, i, parami1, parami2, paramb, paramString);
        AppMethodBeat.o(211251);
      }
    }
    else if (i == 1)
    {
      localObject2 = (ProgressDialog)com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), true, 3, null);
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      ((ProgressDialog)localObject2).show();
      ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a((String)localObject1, (b.a)new m(this, parami1, parami2, (String)localObject1, (ProgressDialog)localObject2, paramContext, i, paramb, paramString));
    }
    AppMethodBeat.o(211251);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(211259);
    super.dependency();
    dependsOn(com.tencent.mm.plugin.byp.a.c.class);
    AppMethodBeat.o(211259);
  }
  
  public final void enterChattingUI(final Context paramContext, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(211244);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString1, "selfUsername");
    d.g.b.p.h(paramString2, "talker");
    final y.f localf = new y.f();
    localf.MLV = null;
    checkSessionIdAndContact(paramString1, paramString2, (d.g.a.b)new n(com.tencent.e.h.LTJ.q((Runnable)new o(localf, paramContext), 1000L), localf, paramString1, paramContext));
    AppMethodBeat.o(211244);
  }
  
  public final void enterExpose(Context paramContext, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(211248);
    d.g.b.p.h(paramIntent, "intent");
    d.g.b.p.h(paramString, "sessionId");
    com.tencent.mm.plugin.gamelife.a.d locald = ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).amC(paramString);
    d.g.b.p.g(locald, "sessionInfo");
    paramString = locald.VS();
    com.tencent.mm.sdk.platformtools.ad.d("GameLife.PluginGameLife", "talkerName:%s", new Object[] { paramString });
    paramIntent.putExtra("k_username", paramString);
    Object localObject = d.g.b.ad.MLZ;
    localObject = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=60", Arrays.copyOf(new Object[] { Integer.valueOf(39) }, 1));
    d.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
    paramIntent.putExtra("rawUrl", (String)localObject);
    com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramIntent);
    paramContext = locald.getSelfUsername();
    paramIntent = locald.getSessionId();
    d.g.b.p.g(paramIntent, "sessionInfo.sessionId");
    d.g.b.p.g(paramContext, "selfUserName");
    d.g.b.p.g(paramString, "talkerName");
    reportSingleChatInfoUIDetail$default(this, 8, 40L, paramIntent, paramContext, paramString, null, null, null, 224, null);
    AppMethodBeat.o(211248);
  }
  
  public final void enterGameLifeProfileUI(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(211247);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(211247);
      return;
    }
    if (paramInt == a.uwn) {
      if (am.aSW(paramString)) {
        reportChattingDetail(2, 7L, paramString, null, null, "1");
      }
    }
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).amA(paramString);
      label107:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).daB();
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
        com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "userName:%s,jumpUrl null");
        AppMethodBeat.o(211247);
        return;
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).amC(paramString);
        d.g.b.p.g(localObject1, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.d)localObject1).VS();
        d.g.b.p.g(paramString, "sessionInfo.talker");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.d)localObject1).getSelfUsername();
        d.g.b.p.g(localObject2, "sessionInfo.selfUsername");
        reportChattingDetail(2, 7L, (String)localObject2, ((com.tencent.mm.plugin.gamelife.a.d)localObject1).getSessionId(), ((com.tencent.mm.plugin.gamelife.a.d)localObject1).VS(), "2");
        break;
        if (paramInt != a.uwm) {
          break label431;
        }
        Object localObject3 = ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).amC(paramString);
        d.g.b.p.g(localObject3, "sessionInfo");
        paramString = ((com.tencent.mm.plugin.gamelife.a.d)localObject3).VS();
        d.g.b.p.g(paramString, "sessionInfo.talker");
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.d)localObject3).getSessionId();
        d.g.b.p.g(localObject1, "sessionInfo.sessionId");
        localObject2 = ((com.tencent.mm.plugin.gamelife.a.d)localObject3).getSelfUsername();
        d.g.b.p.g(localObject2, "sessionInfo.selfUsername");
        localObject3 = ((com.tencent.mm.plugin.gamelife.a.d)localObject3).VS();
        d.g.b.p.g(localObject3, "sessionInfo.talker");
        reportSingleChatInfoUIDetail$default(this, 2, 7L, (String)localObject1, (String)localObject2, (String)localObject3, null, null, null, 224, null);
        break;
        localObject1 = "";
        break label107;
      }
      label373:
      com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "userName:%s,jumpUrl:%s", new Object[] { paramString, localObject1 });
      paramString = new Intent();
      paramString.putExtra("rawUrl", (String)localObject1);
      com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(211247);
      return;
      label431:
      paramString = "";
    }
  }
  
  public final void enterSendGift(Context paramContext, String paramString)
  {
    AppMethodBeat.i(211250);
    d.g.b.p.h(paramContext, "context");
    d.g.b.p.h(paramString, "sessionId");
    com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "enterSendGift sessionId[%s]", new Object[] { paramString });
    com.tencent.mm.plugin.gamelife.a.d locald = ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).amC(paramString);
    if (locald != null)
    {
      com.tencent.mm.plugin.gamelife.a.a locala = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).amA(locald.getSelfUsername());
      Object localObject1 = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).amA(locald.VS());
      long l1;
      long l2;
      if ((locala != null) && (localObject1 != null))
      {
        Object localObject2 = com.tencent.mm.game.report.c.grV;
        l1 = locala.daC();
        Object localObject3 = locala.getUsername();
        d.g.b.p.g(localObject3, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).daC();
        String str = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        d.g.b.p.g(str, "talkerContact.username");
        d.g.b.p.h(paramString, "sessionId");
        d.g.b.p.h(localObject3, "fromUsername");
        d.g.b.p.h(str, "toUsername");
        localObject2 = com.tencent.mm.game.report.c.a.a(3L, 302L, 2L, 2L, 301L);
        ((cf)localObject2).lH(paramString);
        ((cf)localObject2).hW(l1);
        ((cf)localObject2).lF((String)localObject3);
        ((cf)localObject2).hX(l2);
        ((cf)localObject2).lG(str);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("ser_name", 4L);
        ((cf)localObject2).lI(URLEncoder.encode(((JSONObject)localObject3).toString()));
        ((cf)localObject2).aLk();
      }
      int i = ((com.tencent.mm.plugin.game.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.c.class)).A(paramContext, locald.getSelfUsername(), locald.VS());
      if ((locala != null) && (localObject1 != null))
      {
        if (i == 40)
        {
          paramContext = com.tencent.mm.game.report.c.grV;
          l1 = locala.daC();
          paramContext = locala.getUsername();
          d.g.b.p.g(paramContext, "selfContact.username");
          l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).daC();
          localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
          d.g.b.p.g(localObject1, "talkerContact.username");
          com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 40L);
          AppMethodBeat.o(211250);
          return;
        }
        paramContext = com.tencent.mm.game.report.c.grV;
        l1 = locala.daC();
        paramContext = locala.getUsername();
        d.g.b.p.g(paramContext, "selfContact.username");
        l2 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).daC();
        localObject1 = ((com.tencent.mm.plugin.gamelife.a.a)localObject1).getUsername();
        d.g.b.p.g(localObject1, "talkerContact.username");
        com.tencent.mm.game.report.c.a.a(paramString, l1, paramContext, l2, (String)localObject1, 71L);
      }
      AppMethodBeat.o(211250);
      return;
    }
    AppMethodBeat.o(211250);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(211231);
    d.g.b.p.h(paramg, "profile");
    if (paramg.akw())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.e.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.i.b());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.b.class, (com.tencent.mm.kernel.c.a)getContactService());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.gamelife.a.c.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.gamelife.e.c());
    }
    AppMethodBeat.o(211231);
  }
  
  public final com.tencent.mm.plugin.gamelife.g.c getAppMessageStorage()
  {
    AppMethodBeat.i(211242);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.gamelife.g.c localc2 = this.uwz;
    com.tencent.mm.plugin.gamelife.g.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.g.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uwz = localc1;
    localc1 = this.uwz;
    if (localc1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(211242);
    return localc1;
  }
  
  public final String getAvatarPath()
  {
    AppMethodBeat.i(211225);
    String str = this.rBN;
    if (str == null) {
      d.g.b.p.bcb("avatarPath");
    }
    AppMethodBeat.o(211225);
    return str;
  }
  
  public final com.tencent.mm.plugin.gamelife.d.c getContactStorage()
  {
    AppMethodBeat.i(211239);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.gamelife.d.c localc2 = this.uwv;
    com.tencent.mm.plugin.gamelife.d.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.d.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uwv = localc1;
    localc1 = this.uwv;
    if (localc1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(211239);
    return localc1;
  }
  
  public final com.tencent.mm.plugin.gamelife.e.d getConversationStorage()
  {
    AppMethodBeat.i(211241);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.gamelife.e.d locald2 = this.uwx;
    com.tencent.mm.plugin.gamelife.e.d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new com.tencent.mm.plugin.gamelife.e.d((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uwx = locald1;
    locald1 = this.uwx;
    if (locald1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(211241);
    return locald1;
  }
  
  public final com.tencent.mm.plugin.gamelife.g.d getMessageStorage()
  {
    AppMethodBeat.i(211243);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).dlK();
    com.tencent.mm.plugin.gamelife.g.d locald = this.uwy;
    localObject = locald;
    if (locald == null)
    {
      d.g.b.p.g(locali, "msgStg");
      localObject = new com.tencent.mm.plugin.gamelife.g.d(locali);
    }
    this.uwy = ((com.tencent.mm.plugin.gamelife.g.d)localObject);
    localObject = this.uwy;
    if (localObject == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(211243);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.gamelife.i.c getSessionInfoStorage()
  {
    AppMethodBeat.i(211240);
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.gamelife.i.c localc2 = this.uww;
    com.tencent.mm.plugin.gamelife.i.c localc1 = localc2;
    if (localc2 == null) {
      localc1 = new com.tencent.mm.plugin.gamelife.i.c((com.tencent.mm.sdk.e.e)getDB());
    }
    this.uww = localc1;
    localc1 = this.uww;
    if (localc1 == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(211240);
    return localc1;
  }
  
  public final void initGameLifeSingleChatInfoUI(final Context paramContext, String paramString, final c.a parama)
  {
    AppMethodBeat.i(211249);
    if (paramContext == null)
    {
      AppMethodBeat.o(211249);
      return;
    }
    Object localObject = com.tencent.mm.game.report.c.grV;
    com.tencent.mm.game.report.c.a.a(4L, 0L, 0L, 1L, 301L).aLk();
    localObject = com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), true, 3, null);
    d.g.b.p.g(localObject, "MMProgressDialog.show(co…TLE_TRANSPARENT_BG, null)");
    localObject = (ProgressDialog)localObject;
    ((ProgressDialog)localObject).show();
    paramString = ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).aii(paramString);
    paramString = ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).amA(paramString);
    d.g.b.p.g(paramString, "contact");
    String str = paramString.getUsername();
    if (paramString.daC() <= 0)
    {
      Toast.makeText(paramContext, 2131766892, 0).show();
      AppMethodBeat.o(211249);
      return;
    }
    ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(str, (b.a)new q((ProgressDialog)localObject, parama, paramContext));
    AppMethodBeat.o(211249);
  }
  
  public final void jumpToGameLifeSingleChatInfoUIReport(String paramString)
  {
    AppMethodBeat.i(211246);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "jumpToGameLifeSingleChatInfoUI sessionId null!");
      AppMethodBeat.o(211246);
      return;
    }
    Object localObject2 = ((com.tencent.mm.plugin.gamelife.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.e.class)).amC(paramString);
    d.g.b.p.g(localObject2, "sessionInfo");
    localObject1 = ((com.tencent.mm.plugin.gamelife.a.d)localObject2).VS();
    localObject2 = ((com.tencent.mm.plugin.gamelife.a.d)localObject2).getSelfUsername();
    d.g.b.p.g(localObject2, "selfUserName");
    reportChattingDetail$default(this, 1, 6L, (String)localObject2, paramString, (String)localObject1, null, 32, null);
    AppMethodBeat.o(211246);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(211232);
    com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "Account Init");
    initDB();
    paramc = new StringBuilder();
    Object localObject = com.tencent.mm.kernel.g.ajC();
    d.g.b.p.g(localObject, "MMKernel.storage()");
    this.rBN = (((com.tencent.mm.kernel.e)localObject).getAccPath() + "gamelife/avatar/");
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).addBypSyncHandler(3, (com.tencent.mm.plugin.byp.a.b)new com.tencent.mm.plugin.gamelife.g.e());
    paramc = (com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    paramc.dlK().a((com.tencent.mm.storage.e)getMessageStorage());
    paramc.azv().a((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdateCallback());
    paramc.azp().a((bp.a)getContactService().uxM);
    paramc = a.b.fbx();
    if ((paramc instanceof com.tencent.mm.pluginsdk.ui.b))
    {
      localObject = new com.tencent.mm.plugin.gamelife.f.d(((com.tencent.mm.pluginsdk.ui.b)paramc).fby());
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelife", (j.a)localObject);
      ((com.tencent.mm.pluginsdk.ui.b)paramc).a("@gamelifesess", (j.a)localObject);
    }
    aa.a.a((aa.b)getGetContactInterceptor());
    com.tencent.mm.plugin.s.a.dxR().a((l.b)getAppMessageInterceptor());
    AppMethodBeat.o(211232);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(211258);
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(3);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azv().b((com.tencent.mm.plugin.messenger.foundation.a.g)getConversationUpdateCallback());
    locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azp().b((bp.a)getContactService().uxM);
    aa.a.b((aa.b)getGetContactInterceptor());
    com.tencent.mm.plugin.s.a.dxR().b((l.b)getAppMessageInterceptor());
    resetDB();
    AppMethodBeat.o(211258);
  }
  
  public final void setAvatarPath(String paramString)
  {
    AppMethodBeat.i(211226);
    d.g.b.p.h(paramString, "<set-?>");
    this.rBN = paramString;
    AppMethodBeat.o(211226);
  }
  
  public final void testEnterChattingUI()
  {
    AppMethodBeat.i(211236);
    PluginGameLife localPluginGameLife = (PluginGameLife)com.tencent.mm.kernel.g.ad(PluginGameLife.class);
    Context localContext = aj.getContext();
    d.g.b.p.g(localContext, "MMApplicationContext.getContext()");
    localPluginGameLife.enterChattingUI(localContext, uwA, uwB);
    AppMethodBeat.o(211236);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/PluginGameLife$Companion;", "", "()V", "FROM_USERNAME", "", "getFROM_USERNAME", "()Ljava/lang/String;", "TAG", "TO_USERNAME", "getTO_USERNAME", "plugin-gamelife_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageInterceptor;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.gamelife.g.b>
  {
    public static final b uwD;
    
    static
    {
      AppMethodBeat.i(211191);
      uwD = new b();
      AppMethodBeat.o(211191);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onDone"})
  static final class c
    implements e.a
  {
    c(AtomicInteger paramAtomicInteger, d.g.a.b paramb, LinkedList paramLinkedList, Runnable paramRunnable) {}
    
    public final void onDone(String paramString)
    {
      AppMethodBeat.i(211192);
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (this.uwE.getAndSet(-1) < 0) {
          break label87;
        }
        com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "checkSessionIdAndContact get session failed");
        paramb.invoke(null);
        AppMethodBeat.o(211192);
        return;
      }
      localLinkedList.add(paramString);
      localRunnable.run();
      label87:
      AppMethodBeat.o(211192);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
  static final class d
    implements b.c
  {
    d(String paramString1, String paramString2, Runnable paramRunnable, AtomicInteger paramAtomicInteger, d.g.a.b paramb) {}
    
    public final void ab(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
    {
      AppMethodBeat.i(211193);
      com.tencent.mm.plugin.gamelife.a.a locala = (com.tencent.mm.plugin.gamelife.a.a)paramMap.get(this.uwH);
      if ((locala != null) && (locala.isValid() == true))
      {
        paramMap = (com.tencent.mm.plugin.gamelife.a.a)paramMap.get(paramString2);
        if ((paramMap != null) && (paramMap.isValid() == true))
        {
          localRunnable.run();
          AppMethodBeat.o(211193);
          return;
        }
      }
      if (localAtomicInteger.getAndSet(-1) >= 0)
      {
        com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "checkSessionIdAndContact get contact failed");
        paramb.invoke(null);
      }
      AppMethodBeat.o(211193);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(AtomicInteger paramAtomicInteger, LinkedList paramLinkedList, d.g.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(211194);
      if (this.uwE.incrementAndGet() == 2)
      {
        com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "checkSessionIdAndContact success: " + (String)localLinkedList.get(0));
        paramb.invoke(localLinkedList.get(0));
      }
      AppMethodBeat.o(211194);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class f
    implements h.b
  {
    public static final f uwI;
    
    static
    {
      AppMethodBeat.i(211196);
      uwI = new f();
      AppMethodBeat.o(211196);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(211195);
      Object localObject = com.tencent.mm.plugin.gamelife.d.c.uxX;
      localObject = com.tencent.mm.plugin.gamelife.d.c.czG();
      AppMethodBeat.o(211195);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class g
    implements h.b
  {
    public static final g uwJ;
    
    static
    {
      AppMethodBeat.i(211198);
      uwJ = new g();
      AppMethodBeat.o(211198);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(211197);
      Object localObject = com.tencent.mm.plugin.gamelife.i.c.uyz;
      localObject = com.tencent.mm.plugin.gamelife.i.c.czG();
      AppMethodBeat.o(211197);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class h
    implements h.b
  {
    public static final h uwK;
    
    static
    {
      AppMethodBeat.i(211200);
      uwK = new h();
      AppMethodBeat.o(211200);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(211199);
      Object localObject = com.tencent.mm.plugin.gamelife.e.d.uyh;
      localObject = com.tencent.mm.plugin.gamelife.e.d.czG();
      AppMethodBeat.o(211199);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class i
    implements h.b
  {
    public static final i uwL;
    
    static
    {
      AppMethodBeat.i(211202);
      uwL = new i();
      AppMethodBeat.o(211202);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(211201);
      Object localObject = com.tencent.mm.plugin.gamelife.g.d.uyq;
      localObject = com.tencent.mm.plugin.gamelife.g.d.czG();
      AppMethodBeat.o(211201);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContactService;", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.gamelife.d.b>
  {
    public static final k uwN;
    
    static
    {
      AppMethodBeat.i(211206);
      uwN = new k();
      AppMethodBeat.o(211206);
    }
    
    k()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationUpdateCallback;", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.gamelife.e.f>
  {
    public static final l uwO;
    
    static
    {
      AppMethodBeat.i(211208);
      uwO = new l();
      AppMethodBeat.o(211208);
    }
    
    l()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gamelife/PluginGameLife$dealBlackList$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static final class m
    implements b.a
  {
    m(com.tencent.mm.plugin.appbrand.z.i parami1, com.tencent.mm.plugin.appbrand.z.i parami2, String paramString, ProgressDialog paramProgressDialog, Context paramContext, int paramInt, c.b paramb, com.tencent.mm.plugin.gamelife.a.d paramd) {}
    
    public final void S(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(211209);
      parami1.value = Boolean.valueOf(paramBoolean2);
      parami2.value = Boolean.valueOf(paramBoolean1);
      com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame userName:%s,isAssociate:%b,isOwnBlack:%b", new Object[] { this.iEg, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.uwS != null) && (this.uwS.isShowing()))
      {
        this.uwS.dismiss();
        PluginGameLife localPluginGameLife = this.uwP;
        Context localContext = paramContext;
        String str = this.iEg;
        d.g.b.p.g(str, "userName");
        int i = i;
        com.tencent.mm.plugin.appbrand.z.i locali1 = parami1;
        com.tencent.mm.plugin.appbrand.z.i locali2 = parami2;
        c.b localb = paramb;
        com.tencent.mm.plugin.gamelife.a.d locald = paramString;
        d.g.b.p.g(locald, "sessionInfo");
        PluginGameLife.access$showGameLifeDialog(localPluginGameLife, localContext, str, i, locali1, locali2, localb, locald);
      }
      AppMethodBeat.o(211209);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.b<String, z>
  {
    n(com.tencent.e.i.d paramd, y.f paramf, String paramString, Context paramContext)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(y.f paramf, Context paramContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(211212);
      this.sKF.MLV = com.tencent.mm.ui.base.p.a(paramContext, (CharSequence)paramContext.getResources().getString(2131755936), false, 0, (DialogInterface.OnCancelListener)1.uwW);
      AppMethodBeat.o(211212);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.gamelife.d.d>
  {
    public static final p uwX;
    
    static
    {
      AppMethodBeat.i(211214);
      uwX = new p();
      AppMethodBeat.o(211214);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gamelife/PluginGameLife$initGameLifeSingleChatInfoUI$1", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContactService$BlackListAssociateCallback;", "onDone", "", "isAssociate", "", "isOwnBlack", "onFail", "plugin-gamelife_release"})
  public static final class q
    implements b.a
  {
    q(ProgressDialog paramProgressDialog, c.a parama, Context paramContext) {}
    
    public final void S(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(211215);
      com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "isBlackListAssociateWithWAGame isAssociate:%b,isOwnBlack:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      if ((this.uwY != null) && (this.uwY.isShowing())) {
        this.uwY.dismiss();
      }
      c.a locala = parama;
      if (locala != null)
      {
        locala.S(paramBoolean1, paramBoolean2);
        AppMethodBeat.o(211215);
        return;
      }
      AppMethodBeat.o(211215);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class r<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    r(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
  static final class s<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    s(String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, int paramInt, long paramLong, String paramString3) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class t
    implements CompoundButton.OnCheckedChangeListener
  {
    t(com.tencent.mm.plugin.appbrand.z.i parami) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(211218);
      this.uxg.value = Boolean.valueOf(paramBoolean);
      AppMethodBeat.o(211218);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClick"})
  static final class u
    implements g.a
  {
    u(PluginGameLife paramPluginGameLife, c.b paramb, com.tencent.mm.plugin.appbrand.z.i parami1, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.z.i parami2, com.tencent.mm.plugin.appbrand.z.i parami3, com.tencent.mm.plugin.gamelife.a.d paramd, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211219);
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        d.g.b.p.g(localObject2, "isBlackList.value");
        ((c.b)localObject1).mZ(((Boolean)localObject2).booleanValue());
      }
      localg.bpT();
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
        localObject1 = this.uwP;
        localObject2 = paramd.getSessionId();
        d.g.b.p.g(localObject2, "sessionInfo.sessionId");
        String str1 = paramd.getSelfUsername();
        d.g.b.p.g(str1, "sessionInfo.selfUsername");
        String str2 = paramd.VS();
        d.g.b.p.g(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 7, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211219);
        return;
        bool = false;
        continue;
        com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClick"})
  static final class v
    implements g.a
  {
    v(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.z.i parami1, com.tencent.mm.plugin.appbrand.z.i parami2, String paramString, com.tencent.mm.plugin.appbrand.z.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.d paramd, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211221);
      localg.bpT();
      final y.a locala = new y.a();
      locala.MLQ = false;
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
            locala.MLQ = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, false, locala.MLQ, (b.b)new b.b()
        {
          public final void mZ(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(211220);
            com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b", new Object[] { this.uxh.iEg, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.MLQ) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.uxh.uwQ;
              if (!((Boolean)this.uxh.uwQ.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.z.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.uxh.uwU;
              Object localObject2 = this.uxh.uwQ.value;
              d.g.b.p.g(localObject2, "isBlackList.value");
              ((c.b)localObject1).mZ(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(211220);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.uxh.cqB, 2131766900, 0).show();
            }
          }
        });
        localObject = this.uwP;
        String str1 = paramd.getSessionId();
        d.g.b.p.g(str1, "sessionInfo.sessionId");
        String str2 = paramd.getSelfUsername();
        d.g.b.p.g(str2, "sessionInfo.selfUsername");
        String str3 = paramd.VS();
        d.g.b.p.g(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 7, 64L, str1, str2, str3, Boolean.valueOf(locala.MLQ), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211221);
        return;
        bool = false;
        break;
        com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame removeBlackList isAssociateWithWAGame null");
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClick"})
  static final class w
    implements g.a
  {
    w(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, c.b paramb, com.tencent.mm.plugin.appbrand.z.i parami1, com.tencent.mm.plugin.appbrand.z.i parami2, com.tencent.mm.plugin.appbrand.z.i parami3, com.tencent.mm.plugin.gamelife.a.d paramd, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211222);
      localg.bpT();
      Object localObject1 = paramb;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = parami1.value;
        d.g.b.p.g(localObject2, "isBlackList.value");
        ((c.b)localObject1).mZ(((Boolean)localObject2).booleanValue());
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
        localObject1 = this.uwP;
        localObject2 = paramd.getSessionId();
        d.g.b.p.g(localObject2, "sessionInfo.sessionId");
        String str1 = paramd.getSelfUsername();
        d.g.b.p.g(str1, "sessionInfo.selfUsername");
        String str2 = paramd.VS();
        d.g.b.p.g(str2, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject1, 6, 4L, (String)localObject2, str1, str2, Boolean.valueOf(bool), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211222);
        return;
        bool = false;
        continue;
        com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null hideDialog");
        bool = false;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClick"})
  static final class x
    implements g.a
  {
    x(PluginGameLife paramPluginGameLife, com.tencent.mm.ui.widget.a.g paramg, com.tencent.mm.plugin.appbrand.z.i parami1, com.tencent.mm.plugin.appbrand.z.i parami2, String paramString, com.tencent.mm.plugin.appbrand.z.i parami3, Context paramContext, c.b paramb, com.tencent.mm.plugin.gamelife.a.d paramd, int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(211224);
      localg.bpT();
      final y.a locala = new y.a();
      locala.MLQ = false;
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
            locala.MLQ = bool;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.gamelife.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.b.class)).a(paramString, true, locala.MLQ, (b.b)new b.b()
        {
          public final void mZ(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(211223);
            com.tencent.mm.sdk.platformtools.ad.i("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList userName:%s isSuccess:%b, dealWaGameTogether:%b ", new Object[] { this.uxj.iEg, Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(locala.MLQ) });
            Object localObject1;
            if (paramAnonymousBoolean)
            {
              localObject1 = this.uxj.uwQ;
              if (!((Boolean)this.uxj.uwQ.value).booleanValue())
              {
                paramAnonymousBoolean = true;
                ((com.tencent.mm.plugin.appbrand.z.i)localObject1).value = Boolean.valueOf(paramAnonymousBoolean);
              }
            }
            for (;;)
            {
              localObject1 = this.uxj.uwU;
              Object localObject2 = this.uxj.uwQ.value;
              d.g.b.p.g(localObject2, "isBlackList.value");
              ((c.b)localObject1).mZ(((Boolean)localObject2).booleanValue());
              AppMethodBeat.o(211223);
              return;
              paramAnonymousBoolean = false;
              break;
              Toast.makeText(this.uxj.cqB, 2131766893, 0).show();
            }
          }
        });
        localObject = this.uwP;
        String str1 = paramd.getSessionId();
        d.g.b.p.g(str1, "sessionInfo.sessionId");
        String str2 = paramd.getSelfUsername();
        d.g.b.p.g(str2, "sessionInfo.selfUsername");
        String str3 = paramd.VS();
        d.g.b.p.g(str3, "sessionInfo.talker");
        PluginGameLife.access$reportSingleChatInfoUIDetail((PluginGameLife)localObject, 6, 65L, str1, str2, str3, Boolean.valueOf(locala.MLQ), Integer.valueOf(paramInt), (Boolean)parami2.value);
        AppMethodBeat.o(211224);
        return;
        bool = false;
        break;
        com.tencent.mm.sdk.platformtools.ad.e("GameLife.PluginGameLife", "setBlackListAssociateWithWAGame addBlackList isAssociateWithWAGame null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife
 * JD-Core Version:    0.7.0.1
 */