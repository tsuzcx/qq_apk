package com.tencent.mm.plugin.messenger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.lh;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.openim.model.t;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.f.c.a;
import com.tencent.mm.plugin.messenger.f.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.y;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.am.h, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.c
{
  private t KOT;
  a KOU;
  private com.tencent.mm.plugin.messenger.f.a KOV;
  private d KOW;
  private e.c KOX;
  private e.c KOY;
  private e.c KOZ;
  private e.a KPa;
  private e.a KPb;
  private e.a KPc;
  private e.a KPd;
  private e.a KPe;
  private e.a KPf;
  private e.a KPg;
  private e.a KPh;
  private e.a KPi;
  private e.c KPj;
  private e.c KPk;
  private e.c KPl;
  private e.b KPm;
  private ProgressDialog lzP;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(90721);
    this.lzP = null;
    this.KOU = new a();
    this.KOV = new com.tencent.mm.plugin.messenger.f.a();
    this.KOW = new d();
    this.KOX = new e.c() {};
    this.KOY = new e.c() {};
    this.KOZ = new e.c() {};
    this.KPa = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
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
    this.KPb = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
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
    this.KPc = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
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
    this.KPd = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
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
    this.KPe = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
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
    this.KPf = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
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
    this.KPg = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(288622);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(288622);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(288622);
        return paramAnonymousMap;
      }
    };
    this.KPh = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(288630);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(288630);
          return null;
        }
        if (paramAnonymousMap.containsKey(paramAnonymousString + ".redpacketinfo"))
        {
          AppMethodBeat.o(288630);
          return "";
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(288630);
        return paramAnonymousMap;
      }
    };
    this.KPi = new e.a()
    {
      public final String h(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(288553);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(288553);
          return null;
        }
        Log.d("MicroMsg.PluginMessenger", "mHandleNewLinkHistoryDigestListener %s", new Object[] { Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title")) });
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(288553);
        return paramAnonymousMap;
      }
    };
    this.KPj = new e.c() {};
    this.KPk = new e.c() {};
    this.KPl = new e.c()
    {
      public final CharSequence a(final Map<String, String> paramAnonymousMap, String paramAnonymousString, Bundle paramAnonymousBundle, final WeakReference<Context> paramAnonymousWeakReference, WeakReference<NeatTextView> paramAnonymousWeakReference1)
      {
        AppMethodBeat.i(288566);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(288566);
          return null;
        }
        if (paramAnonymousMap.containsKey(paramAnonymousString + ".redpacketinfo"))
        {
          AppMethodBeat.o(288566);
          return "";
        }
        paramAnonymousBundle = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        paramAnonymousMap = (String)paramAnonymousMap.get(paramAnonymousString + ".url");
        paramAnonymousString = new SpannableString(paramAnonymousBundle);
        if (!TextUtils.isEmpty(paramAnonymousMap)) {
          paramAnonymousString.setSpan(new com.tencent.mm.plugin.messenger.a.a(paramAnonymousWeakReference)
          {
            public final void onClickImp(View paramAnonymous2View)
            {
              AppMethodBeat.i(288537);
              paramAnonymous2View = (Context)paramAnonymousWeakReference.get();
              if (paramAnonymous2View != null)
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", paramAnonymousMap);
                com.tencent.mm.br.c.b(paramAnonymous2View, "webview", ".ui.tools.WebViewUI", localIntent);
              }
              AppMethodBeat.o(288537);
            }
          }, 0, paramAnonymousBundle.length(), 33);
        }
        AppMethodBeat.o(288566);
        return paramAnonymousString;
      }
    };
    this.KPm = new PluginMessenger.8(this);
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
    AppMethodBeat.i(288599);
    if (!y.ZC("wcf://selectrecord/")) {
      y.bDX("wcf://selectrecord/");
    }
    AppMethodBeat.o(288599);
    return "wcf://selectrecord/";
  }
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90734);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90734);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90737);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(2, "");
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
      if ((!Util.isNullOrNil((String)localObject1)) && (q.bFE().LS(str3) == null))
      {
        localObject2 = new j();
        ((j)localObject2).username = str3;
        ((j)localObject2).osM = ((String)localObject1);
        ((j)localObject2).jZY = 3;
        ((j)localObject2).gX(false);
        q.bFE().b((j)localObject2);
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
      paramBundle = com.tencent.mm.plugin.messenger.f.c.aMm(paramBundle);
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
            localArrayList.add(new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), locala.content)));
          }
        }
      } while (locala.type != 1);
    }
    finally
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
              paramMap = new lh();
              paramMap.ue(str2);
              paramMap.uf(paramString2);
              paramMap.iZI = 1L;
              paramMap.iZJ = 1L;
              paramMap.iZK = 3L;
              paramMap.bMH();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
              AppMethodBeat.o(90722);
              return;
              if (j == 0)
              {
                paramMap = new lh();
                paramMap.ue(str2);
                paramMap.uf(paramString2);
                paramMap.iZI = 1L;
                paramMap.iZJ = 1L;
                paramMap.iZK = 2L;
                paramMap.bMH();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new lh();
            paramMap.ue(str2);
            paramMap.uf(paramString2);
            paramMap.iZI = 1L;
            paramMap.iZJ = 1L;
            paramMap.iZK = 1L;
            paramMap.bMH();
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
    com.tencent.mm.br.c.g(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(90732);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(90725);
    if (paramg.bbA())
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.messenger.a.b.class, this.KOU);
      com.tencent.mm.kernel.h.b(e.class, this.KOV);
      af.aR("selectrecord", "selectrecord", 1);
    }
    AppMethodBeat.o(90725);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(90724);
    dependsOn(com.tencent.mm.plugin.comm.a.b.class);
    AppMethodBeat.o(90724);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(90726);
    if (paramg.bbA()) {
      pin(com.tencent.mm.plugin.ah.a.gLt());
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
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(90727);
    paramc = this.KOV;
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.KRU);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_plain", this.KOX);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_succeed_contact", this.KOY);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_jump_chat", this.KOZ);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_live", this.KPj);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("comment_link_profile", this.KPk);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_url", this.KPl);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_plain", this.KPa);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_succeed_contact", this.KPb);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_jump_chat", this.KPc);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_revoke", this.KPd);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_revoke_qrcode", this.KPe);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_profile", this.KPf);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("new_link_succeed_contact", this.KPg);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_revoke_unbindapp", this.KPe);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_url", this.KPh);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a("link_history", this.KPi);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).a(this.KPm);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("secmsg", com.tencent.mm.plugin.messenger.d.b.KRG);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("PushLoginUrlAutoLoginSwitchUpdate", com.tencent.mm.plugin.messenger.b.c.KQk);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("PushLoginUrlAutoLogin", com.tencent.mm.plugin.messenger.b.b.KQi);
    com.tencent.mm.kernel.h.aZW().a(853, this);
    paramc = this.KOW;
    paramc.KSb = new com.tencent.mm.plugin.messenger.g.a();
    paramc.KSc = new com.tencent.mm.plugin.messenger.g.c();
    paramc.KSd = new com.tencent.mm.plugin.messenger.g.b();
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288567);
        int i = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzC().gbf();
        int j = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzC().gbg();
        com.tencent.mm.plugin.report.service.h.OAn.b(20460, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(288567);
      }
    }, 60000L);
    MMFragmentActivity.addInterceptor(com.tencent.mm.plugin.messenger.d.a.KRw);
    AppMethodBeat.o(90727);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90728);
    Object localObject = this.KOV;
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("sysmsgtemplate", ((com.tencent.mm.plugin.messenger.f.a)localObject).KRU);
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLc("link_plain");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLc("link_succeed_contact");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLc("link_jump_chat");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLc("link_live");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLc("comment_link_profile");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLc("link_url");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_plain");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_succeed_contact");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_jump_chat");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_revoke");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_revoke_qrcode");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_profile");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("new_link_succeed_contact");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_revoke_unbindapp");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_url");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).aLd("link_history");
    ((e)com.tencent.mm.kernel.h.ax(e.class)).b(this.KPm);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("secmsg", com.tencent.mm.plugin.messenger.d.b.KRG);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("PushLoginUrlAutoLoginSwitchUpdate", com.tencent.mm.plugin.messenger.b.c.KQk);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("PushLoginUrlAutoLogin", com.tencent.mm.plugin.messenger.b.b.KQi);
    com.tencent.mm.kernel.h.aZW().b(853, this);
    localObject = this.KOW;
    if (((d)localObject).KSb != null) {
      ((d)localObject).KSb.release();
    }
    if (((d)localObject).KSc != null) {
      ((d)localObject).KSc.release();
    }
    if (((d)localObject).KSd != null) {
      ((d)localObject).KSd.release();
    }
    AppMethodBeat.o(90728);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(90731);
    try
    {
      if (CrashReportFactory.hasDebuger()) {
        aa.makeText(MMApplicationContext.getContext(), String.format("just debug errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramp.getType() == 853)
      {
        if (this.lzP != null)
        {
          this.lzP.dismiss();
          this.lzP = null;
        }
        if (paramp.equals(this.KOT))
        {
          paramString = (t)paramp;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.psp, paramString.psF);
            startChattingUI(paramString.psp);
          }
          Log.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.psp + " ticket: " + paramString.psE + " talkerUsername: " + paramString.psF);
        }
      }
      AppMethodBeat.o(90731);
      return;
    }
    finally
    {
      Log.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(90731);
    }
  }
  
  public void showSwitchContactDialog(final Context paramContext, final String paramString1, String paramString2, final String paramString3, final String paramString4, final String paramString5, String paramString6, String paramString7, final String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(90733);
    g.a locala = new g.a(paramContext);
    SwitchContactDialogCustomView localSwitchContactDialogCustomView = new SwitchContactDialogCustomView(paramContext);
    if (Util.isNullOrNil(paramString9)) {
      localSwitchContactDialogCustomView.setTilte(paramContext.getString(b.e.openim_switch_user_title));
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
          AppMethodBeat.i(288523);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramString3);
          paramAnonymousView.putExtra(f.e.adwe, paramString5);
          com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(288523);
        }
      });
      paramString2 = paramString10;
      if (Util.isNullOrNil(paramString10)) {
        paramString2 = paramContext.getString(b.e.openim_not_do);
      }
      paramString5 = paramString11;
      if (Util.isNullOrNil(paramString11)) {
        paramString5 = paramContext.getString(b.e.openim_switch_user);
      }
      locala.mg(localSwitchContactDialogCustomView).bDI(paramString5).bDJ(paramString2).a(new g.c()new g.c
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(288515);
          paramAnonymousString = new lh();
          paramAnonymousString.ue(paramString1);
          paramAnonymousString.uf(paramString8);
          paramAnonymousString.iZI = 1L;
          paramAnonymousString.iZJ = 1L;
          paramAnonymousString.iZL = 1L;
          paramAnonymousString.bMH();
          AppMethodBeat.o(288515);
        }
      }, new g.c()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(288521);
          if ((paramAnonymousBoolean) && (au.bwO(paramString3)))
          {
            paramAnonymousString = new lh();
            paramAnonymousString.ue(paramString1);
            paramAnonymousString.iZI = 1L;
            paramAnonymousString.uf(paramString8);
            paramAnonymousString.iZJ = 1L;
            paramAnonymousString.iZL = 2L;
            paramAnonymousString.bMH();
            PluginMessenger.access$202(PluginMessenger.this, new t(paramString3, paramString4, 0));
            PluginMessenger.this.KOT.psF = paramString8;
            com.tencent.mm.kernel.h.aZW().a(PluginMessenger.this.KOT, 0);
            paramAnonymousString = PluginMessenger.this;
            Context localContext = paramContext;
            paramContext.getString(b.e.app_tip);
            PluginMessenger.access$302(paramAnonymousString, com.tencent.mm.ui.base.k.a(localContext, paramContext.getString(b.e.openim_switch_user_verify), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(288534);
                com.tencent.mm.kernel.h.aZW().a(PluginMessenger.this.KOT);
                AppMethodBeat.o(288534);
              }
            }));
          }
          AppMethodBeat.o(288521);
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