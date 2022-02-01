package com.tencent.mm.plugin.messenger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.ix;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.e.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.u;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements i, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.c
{
  private com.tencent.mm.openim.b.q ETV;
  a ETW;
  private com.tencent.mm.plugin.messenger.e.a ETX;
  private com.tencent.mm.plugin.messenger.e.d ETY;
  private e.c ETZ;
  private e.c EUa;
  private e.c EUb;
  private e.a EUc;
  private e.a EUd;
  private e.a EUe;
  private e.a EUf;
  private e.a EUg;
  private e.a EUh;
  private e.a EUi;
  private e.a EUj;
  private e.a EUk;
  private e.c EUl;
  private e.c EUm;
  private e.c EUn;
  private e.b EUo;
  private ProgressDialog iXX;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(90721);
    this.iXX = null;
    this.ETW = new a();
    this.ETX = new com.tencent.mm.plugin.messenger.e.a();
    this.ETY = new com.tencent.mm.plugin.messenger.e.d();
    this.ETZ = new e.c() {};
    this.EUa = new e.c() {};
    this.EUb = new e.c() {};
    this.EUc = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90715);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90715);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".plain"));
        AppMethodBeat.o(90715);
        return paramAnonymousMap;
      }
    };
    this.EUd = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90716);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90716);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90716);
        return paramAnonymousMap;
      }
    };
    this.EUe = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90717);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90717);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90717);
        return paramAnonymousMap;
      }
    };
    this.EUf = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90718);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90718);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90718);
        return paramAnonymousMap;
      }
    };
    this.EUg = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90719);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90719);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90719);
        return paramAnonymousMap;
      }
    };
    this.EUh = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90720);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str = Util.nullAs((String)paramAnonymousMap.get(paramAnonymousString + ".separator"), "、");
        int i = 0;
        StringBuilder localStringBuilder2 = new StringBuilder().append(paramAnonymousString).append(".memberlist.member");
        Object localObject;
        if (i != 0)
        {
          localObject = Integer.valueOf(i);
          label79:
          localObject = localObject;
          if (paramAnonymousMap.get(localObject) == null) {
            break label185;
          }
          if (i != 0) {
            localStringBuilder1.append(str);
          }
          localObject = (String)paramAnonymousMap.get((String)localObject + ".nickname");
          if (!Util.isNullOrNil((String)localObject)) {
            break label174;
          }
          Log.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = "";
          break label79;
          label174:
          localStringBuilder1.append((String)localObject);
        }
        label185:
        paramAnonymousMap = localStringBuilder1.toString();
        AppMethodBeat.o(90720);
        return paramAnonymousMap;
      }
    };
    this.EUi = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(212869);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(212869);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(212869);
        return paramAnonymousMap;
      }
    };
    this.EUj = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(213413);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(213413);
          return null;
        }
        if (paramAnonymousMap.containsKey(paramAnonymousString + ".redpacketinfo"))
        {
          AppMethodBeat.o(213413);
          return "";
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(213413);
        return paramAnonymousMap;
      }
    };
    this.EUk = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(213433);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(213433);
          return null;
        }
        Log.d("MicroMsg.PluginMessenger", "mHandleNewLinkHistoryDigestListener %s", new Object[] { Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title")) });
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(213433);
        return paramAnonymousMap;
      }
    };
    this.EUl = new e.c() {};
    this.EUm = new e.c() {};
    this.EUn = new e.c()
    {
      public final CharSequence a(final Map<String, String> paramAnonymousMap, String paramAnonymousString, Bundle paramAnonymousBundle, final WeakReference<Context> paramAnonymousWeakReference, WeakReference<NeatTextView> paramAnonymousWeakReference1)
      {
        AppMethodBeat.i(213458);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(213458);
          return null;
        }
        if (paramAnonymousMap.containsKey(paramAnonymousString + ".redpacketinfo"))
        {
          AppMethodBeat.o(213458);
          return "";
        }
        paramAnonymousBundle = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        paramAnonymousMap = (String)paramAnonymousMap.get(paramAnonymousString + ".url");
        paramAnonymousString = new SpannableString(paramAnonymousBundle);
        if (!TextUtils.isEmpty(paramAnonymousMap)) {
          paramAnonymousString.setSpan(new com.tencent.mm.plugin.messenger.a.a(paramAnonymousWeakReference, paramAnonymousMap)
          {
            public final void onClickImp(View paramAnonymous2View)
            {
              AppMethodBeat.i(213379);
              paramAnonymous2View = (Context)paramAnonymousWeakReference.get();
              if (paramAnonymous2View != null)
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", paramAnonymousMap);
                com.tencent.mm.by.c.b(paramAnonymous2View, "webview", ".ui.tools.WebViewUI", localIntent);
              }
              AppMethodBeat.o(213379);
            }
          }, 0, paramAnonymousBundle.length(), 33);
        }
        AppMethodBeat.o(213458);
        return paramAnonymousString;
      }
    };
    this.EUo = new e.b()
    {
      public final Boolean al(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(213466);
        boolean bool = paramAnonymousMap.containsKey(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo");
        AppMethodBeat.o(213466);
        return Boolean.valueOf(bool);
      }
      
      public final CharSequence m(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(213469);
        long l1 = com.tencent.mm.ae.d.Nb(Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "objectid")));
        long l2 = com.tencent.mm.ae.d.Nb(Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "liveid")));
        String str1 = Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "objectnonceid"));
        String str3 = Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "findernickname"));
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.redpacketinfo." + "redpacketsendid"));
        String str2 = MMApplicationContext.getContext().getResources().getString(b.d.finder_live_red_packet_name);
        str3 = MMApplicationContext.getContext().getResources().getString(b.d.finder_live_red_packet_tips, new Object[] { str3, str2 });
        int i = str3.indexOf(str2);
        if ((i != -1) && (str2.length() + i <= str3.length()))
        {
          paramAnonymousString = l.c(MMApplicationContext.getContext(), str3);
          int j = MMApplicationContext.getContext().getResources().getIdentifier("systemmessages_hongbaoicon", "drawable", MMApplicationContext.getContext().getPackageName());
          Object localObject = MMApplicationContext.getContext().getDrawable(j);
          if (localObject != null)
          {
            j = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(b.a.RedPacketWidth);
            ((Drawable)localObject).setBounds(0, 0, j, j);
            localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
            j = str3.indexOf(' ');
            if ((j >= 0) && (j < str3.length() - 1)) {
              paramAnonymousString.setSpan(localObject, j, j + 1, 18);
            }
          }
          paramAnonymousString.setSpan(new PluginMessenger.8.1(this, Long.valueOf(l1), Long.valueOf(l2), str1, paramAnonymousMap), i, str2.length() + i, 33);
          AppMethodBeat.o(213469);
          return paramAnonymousString;
        }
        AppMethodBeat.o(213469);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(90721);
  }
  
  private CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(90730);
    SpannableString localSpannableString = new SpannableString("");
    if (paramArrayList == null)
    {
      AppMethodBeat.o(90730);
      return localSpannableString;
    }
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(90730);
    return paramArrayList;
  }
  
  public static String getAccSelectRecordPath()
  {
    AppMethodBeat.i(213242);
    if (!u.agG("wcf://selectrecord/")) {
      u.bBD("wcf://selectrecord/");
    }
    AppMethodBeat.o(213242);
    return "wcf://selectrecord/";
  }
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90734);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90734);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90737);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, "");
    paramString1 = "switch_contact_prefs_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90737);
    return paramString1;
  }
  
  private boolean isSwitchContact(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90739);
    boolean bool = MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(paramString1, paramString2), false);
    AppMethodBeat.o(90739);
    return bool;
  }
  
  private CharSequence nullAsNil(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(90729);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(90729);
      return paramCharSequence;
    }
    AppMethodBeat.o(90729);
    return paramCharSequence;
  }
  
  private void resolvedSucceedContactText(Map<String, String> paramMap, String paramString1, Bundle paramBundle, WeakReference<Context> paramWeakReference, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(90722);
    String str2;
    int j;
    String str3;
    Object localObject2;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    Object localObject3;
    ArrayList localArrayList;
    c.a locala;
    try
    {
      str2 = Util.nullAs(paramBundle.getString("local_session"), "");
      if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.$type");
      j = Util.safeParseInt((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
      if (!"tmpl_type_succeed_contact_window".equals(paramBundle)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.template");
      str3 = (String)paramMap.get(paramString1 + ".window_template.tp_username");
      localObject1 = (String)paramMap.get(paramString1 + ".window_template.headimgurl");
      if ((!Util.isNullOrNil((String)localObject1)) && (com.tencent.mm.am.q.bhP().TS(str3) == null))
      {
        localObject2 = new j();
        ((j)localObject2).username = str3;
        ((j)localObject2).lBd = ((String)localObject1);
        ((j)localObject2).hDc = 3;
        ((j)localObject2).gg(false);
        com.tencent.mm.am.q.bhP().b((j)localObject2);
      }
      if ((paramBoolean) && (isSwitchContact(str3, paramString2)))
      {
        startChattingUI(str3);
        AppMethodBeat.o(90722);
        return;
      }
      str4 = (String)paramMap.get(paramString1 + ".window_template.ticket");
      str5 = (String)paramMap.get(paramString1 + ".window_template.antispam_ticket");
      str6 = (String)paramMap.get(paramString1 + ".window_template.title");
      str7 = (String)paramMap.get(paramString1 + ".window_template.cancel_wording");
      str8 = (String)paramMap.get(paramString1 + ".window_template.confirm_wording");
      localObject2 = "";
      localObject3 = "";
      paramBundle = com.tencent.mm.plugin.messenger.e.c.aPn(paramBundle);
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label1163;
      }
      localArrayList = new ArrayList();
      Iterator localIterator = paramBundle.iterator();
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label902;
          }
          locala = (c.a)localIterator.next();
          if ((locala != null) && (locala.content != null))
          {
            if (locala.type != 0) {
              break;
            }
            localArrayList.add(new SpannableString(l.c(MMApplicationContext.getContext(), locala.content)));
          }
        }
      } while (locala.type != 1);
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(90722);
      return;
    }
    int i = 0;
    Object localObject1 = localObject2;
    paramBundle = (Bundle)localObject3;
    for (;;)
    {
      String str1 = paramString1 + ".window_template.link_list.link";
      if (i != 0) {
        str1 = str1 + i;
      }
      for (;;)
      {
        localObject3 = paramBundle;
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)paramMap.get(str1))) {
          break;
        }
        localObject3 = (String)paramMap.get(str1 + ".$name");
        String str9 = (String)paramMap.get(str1 + ".$type");
        if ((locala.content.equals(localObject3)) && ("link_plain".equals(str9))) {
          localArrayList.add(nullAsNil((CharSequence)paramMap.get(str1 + ".plain")));
        }
        localObject2 = localObject1;
        if ("company".equals(localObject3))
        {
          localObject2 = localObject1;
          if ("link_userdescid".equals(str9)) {
            localObject2 = nullAsNil((CharSequence)paramMap.get(str1 + ".userdesc")).toString();
          }
        }
        if (("nickname".equals(localObject3)) && ("link_plain".equals(str9)))
        {
          paramBundle = nullAsNil((CharSequence)paramMap.get(str1 + ".plain")).toString();
          break label1176;
          label902:
          if (paramBoolean)
          {
            if (j == 1)
            {
              paramMap = new ix();
              paramMap.zT(str2);
              paramMap.zU(paramString2);
              paramMap.gKs = 1L;
              paramMap.gKt = 1L;
              paramMap.gKu = 3L;
              paramMap.bpa();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
              AppMethodBeat.o(90722);
              return;
              if (j == 0)
              {
                paramMap = new ix();
                paramMap.zT(str2);
                paramMap.zU(paramString2);
                paramMap.gKs = 1L;
                paramMap.gKt = 1L;
                paramMap.gKu = 2L;
                paramMap.bpa();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new ix();
            paramMap.zT(str2);
            paramMap.zU(paramString2);
            paramMap.gKs = 1L;
            paramMap.gKt = 1L;
            paramMap.gKu = 1L;
            paramMap.bpa();
            showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
          }
          label1163:
          AppMethodBeat.o(90722);
          return;
        }
        break label1176;
      }
      label1176:
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  private void saveSwitchContact(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90738);
    MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(paramString1, paramString2), true).commit();
    AppMethodBeat.o(90738);
  }
  
  private void startChattingUI(String paramString)
  {
    AppMethodBeat.i(90732);
    Log.i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    com.tencent.mm.by.c.f(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(90732);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(90725);
    if (paramg.aIE())
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.messenger.a.b.class, this.ETW);
      com.tencent.mm.kernel.h.b(e.class, this.ETX);
      ab.aE("selectrecord", "selectrecord", 1);
    }
    AppMethodBeat.o(90725);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(90724);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(90724);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(90726);
    if (paramg.aIE()) {
      pin(com.tencent.mm.plugin.ah.a.fzH());
    }
    AppMethodBeat.o(90726);
  }
  
  public void installed()
  {
    AppMethodBeat.i(90723);
    alias(com.tencent.mm.plugin.messenger.a.c.class);
    AppMethodBeat.o(90723);
  }
  
  public boolean isFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90736);
    boolean bool = MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), true);
    AppMethodBeat.o(90736);
    return bool;
  }
  
  public void markFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90735);
    MMApplicationContext.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), false).commit();
    AppMethodBeat.o(90735);
  }
  
  public void onAccountInitialized(com.tencent.mm.kernel.f.c paramc)
  {
    AppMethodBeat.i(90727);
    paramc = this.ETX;
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.EWk);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_plain", this.ETZ);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_succeed_contact", this.EUa);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_jump_chat", this.EUb);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_live", this.EUl);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("comment_link_profile", this.EUm);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_url", this.EUn);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_plain", this.EUc);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_succeed_contact", this.EUd);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_jump_chat", this.EUe);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_revoke", this.EUf);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_revoke_qrcode", this.EUg);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_profile", this.EUh);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("new_link_succeed_contact", this.EUi);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_revoke_unbindapp", this.EUg);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_url", this.EUj);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a("link_history", this.EUk);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).a(this.EUo);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("secmsg", com.tencent.mm.plugin.messenger.c.a.EVW);
    com.tencent.mm.kernel.h.aGY().a(853, this);
    paramc = this.ETY;
    paramc.EWr = new com.tencent.mm.plugin.messenger.f.a();
    paramc.EWs = new com.tencent.mm.plugin.messenger.f.c();
    paramc.EWt = new com.tencent.mm.plugin.messenger.f.b();
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212976);
        int i = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbN().eSk();
        int j = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbN().eSl();
        com.tencent.mm.plugin.report.service.h.IzE.a(20460, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(212976);
      }
    }, 60000L);
    AppMethodBeat.o(90727);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90728);
    Object localObject = this.ETX;
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("sysmsgtemplate", ((com.tencent.mm.plugin.messenger.e.a)localObject).EWk);
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOe("link_plain");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOe("link_succeed_contact");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOe("link_jump_chat");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOe("link_live");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOe("comment_link_profile");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOe("link_url");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_plain");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_succeed_contact");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_jump_chat");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_revoke");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_revoke_qrcode");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_profile");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("new_link_succeed_contact");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_revoke_unbindapp");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_url");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).aOf("link_history");
    ((e)com.tencent.mm.kernel.h.ae(e.class)).b(this.EUo);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("secmsg", com.tencent.mm.plugin.messenger.c.a.EVW);
    com.tencent.mm.kernel.h.aGY().b(853, this);
    localObject = this.ETY;
    if (((com.tencent.mm.plugin.messenger.e.d)localObject).EWr != null) {
      ((com.tencent.mm.plugin.messenger.e.d)localObject).EWr.release();
    }
    if (((com.tencent.mm.plugin.messenger.e.d)localObject).EWs != null) {
      ((com.tencent.mm.plugin.messenger.e.d)localObject).EWs.release();
    }
    if (((com.tencent.mm.plugin.messenger.e.d)localObject).EWt != null) {
      ((com.tencent.mm.plugin.messenger.e.d)localObject).EWt.release();
    }
    AppMethodBeat.o(90728);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(90731);
    try
    {
      if (CrashReportFactory.hasDebuger()) {
        w.makeText(MMApplicationContext.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramq.getType() == 853)
      {
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        if (paramq.equals(this.ETV))
        {
          paramString = (com.tencent.mm.openim.b.q)paramq;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.myd, paramString.myn);
            startChattingUI(paramString.myd);
          }
          Log.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.myd + " ticket: " + paramString.mym + " talkerUsername: " + paramString.myn);
        }
      }
      AppMethodBeat.o(90731);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(90731);
    }
  }
  
  public void showSwitchContactDialog(final Context paramContext, final String paramString1, String paramString2, final String paramString3, final String paramString4, final String paramString5, String paramString6, String paramString7, final String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(90733);
    f.a locala = new f.a(paramContext);
    SwitchContactDialogCustomView localSwitchContactDialogCustomView = new SwitchContactDialogCustomView(paramContext);
    if (Util.isNullOrNil(paramString9)) {
      localSwitchContactDialogCustomView.setTilte(paramContext.getString(b.d.openim_switch_user_title));
    }
    for (;;)
    {
      localSwitchContactDialogCustomView.setContent(paramString2);
      localSwitchContactDialogCustomView.setDesc(paramString6);
      localSwitchContactDialogCustomView.setSubDesc("@".concat(String.valueOf(paramString7)));
      localSwitchContactDialogCustomView.setPhoto(paramString3);
      localSwitchContactDialogCustomView.setOnPhotoOnClick(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213450);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramString3);
          paramAnonymousView.putExtra(f.d.VRW, paramString5);
          com.tencent.mm.by.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213450);
        }
      });
      paramString2 = paramString10;
      if (Util.isNullOrNil(paramString10)) {
        paramString2 = paramContext.getString(b.d.openim_not_do);
      }
      paramString5 = paramString11;
      if (Util.isNullOrNil(paramString11)) {
        paramString5 = paramContext.getString(b.d.openim_switch_user);
      }
      locala.iK(localSwitchContactDialogCustomView).bBp(paramString5).bBq(paramString2).a(new com.tencent.mm.ui.widget.a.f.c()new com.tencent.mm.ui.widget.a.f.c
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(213532);
          paramAnonymousString = new ix();
          paramAnonymousString.zT(paramString1);
          paramAnonymousString.zU(paramString8);
          paramAnonymousString.gKs = 1L;
          paramAnonymousString.gKt = 1L;
          paramAnonymousString.gKv = 1L;
          paramAnonymousString.bpa();
          AppMethodBeat.o(213532);
        }
      }, new com.tencent.mm.ui.widget.a.f.c()
      {
        public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(212870);
          if ((paramAnonymousBoolean) && (as.bvK(paramString3)))
          {
            paramAnonymousString = new ix();
            paramAnonymousString.zT(paramString1);
            paramAnonymousString.gKs = 1L;
            paramAnonymousString.zU(paramString8);
            paramAnonymousString.gKt = 1L;
            paramAnonymousString.gKv = 2L;
            paramAnonymousString.bpa();
            PluginMessenger.access$202(PluginMessenger.this, new com.tencent.mm.openim.b.q(paramString3, paramString4, 0));
            PluginMessenger.this.ETV.myn = paramString8;
            com.tencent.mm.kernel.h.aGY().a(PluginMessenger.this.ETV, 0);
            paramAnonymousString = PluginMessenger.this;
            Context localContext = paramContext;
            paramContext.getString(b.d.app_tip);
            PluginMessenger.access$302(paramAnonymousString, com.tencent.mm.ui.base.h.a(localContext, paramContext.getString(b.d.openim_switch_user_verify), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(213338);
                com.tencent.mm.kernel.h.aGY().a(PluginMessenger.this.ETV);
                AppMethodBeat.o(213338);
              }
            }));
          }
          AppMethodBeat.o(212870);
        }
      }).show();
      AppMethodBeat.o(90733);
      return;
      localSwitchContactDialogCustomView.setTilte(paramString9);
    }
  }
  
  public String toString()
  {
    return "plugin-messenger";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger
 * JD-Core Version:    0.7.0.1
 */