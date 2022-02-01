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
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.gs;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.plugin.messenger.d.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.y;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ak.i, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.c
{
  private ProgressDialog gtM;
  private com.tencent.mm.openim.b.q zoE;
  a zoF;
  private com.tencent.mm.plugin.messenger.d.a zoG;
  private d zoH;
  private e.b zoI;
  private e.b zoJ;
  private e.b zoK;
  private e.a zoL;
  private e.a zoM;
  private e.a zoN;
  private e.a zoO;
  private e.a zoP;
  private e.a zoQ;
  private e.a zoR;
  private e.a zoS;
  private e.a zoT;
  private com.tencent.mm.plugin.messenger.foundation.a.q zoU;
  private e.b zoV;
  private e.b zoW;
  private e.b zoX;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(90721);
    this.gtM = null;
    this.zoF = new a();
    this.zoG = new com.tencent.mm.plugin.messenger.d.a();
    this.zoH = new d();
    this.zoI = new e.b() {};
    this.zoJ = new e.b() {};
    this.zoK = new e.b() {};
    this.zoL = new e.a()
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
    this.zoM = new e.a()
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
    this.zoN = new e.a()
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
    this.zoO = new e.a()
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
    this.zoP = new e.a()
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
    this.zoQ = new e.a()
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
    this.zoR = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(194459);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(194459);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(194459);
        return paramAnonymousMap;
      }
    };
    this.zoS = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(194460);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(194460);
          return null;
        }
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(194460);
        return paramAnonymousMap;
      }
    };
    this.zoT = new e.a()
    {
      public final String f(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(194461);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(194461);
          return null;
        }
        Log.d("MicroMsg.PluginMessenger", "mHandleNewLinkHistoryDigestListener %s", new Object[] { Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title")) });
        paramAnonymousMap = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(194461);
        return paramAnonymousMap;
      }
    };
    this.zoU = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(194462);
        if ("secmsg".equals(paramAnonymousString))
        {
          paramAnonymousa = Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.session"));
          paramAnonymousString = Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.newmsgid"));
          int i = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
          String str1 = Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
          int j = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
          String str2 = Util.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
          int k = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
          int m = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.media-to-emoji"));
          int n = Util.safeParseInt((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.block-range"));
          Log.i("MicroMsg.PluginMessenger", "msgId:%s [%d],[%s],[%d],[%s],[%d],[%d],[%d]", new Object[] { Long.valueOf(Util.safeParseLong(paramAnonymousString)), Integer.valueOf(i), str1, Integer.valueOf(j), str2, Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
          paramAnonymousMap = new HashMap();
          paramAnonymousMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(i));
          paramAnonymousMap.put(".msgsource.sec_msg_node.show-h5", str1);
          paramAnonymousMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(j));
          paramAnonymousMap.put(".msgsource.sec_msg_node.share-tip-url", str2);
          paramAnonymousMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(k));
          paramAnonymousMap.put(".msgsource.sec_msg_node.media-to-emoji", String.valueOf(m));
          paramAnonymousMap.put(".msgsource.sec_msg_node.block-range", String.valueOf(n));
          if (!Util.isNullOrNil(new String[] { paramAnonymousa, paramAnonymousString }))
          {
            paramAnonymousa = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aJ(paramAnonymousa, Util.safeParseLong(paramAnonymousString));
            if ((!Util.isNullOrNil(paramAnonymousa.field_talker)) && (paramAnonymousa.field_msgSvrId > 0L))
            {
              br.a(paramAnonymousa, br.A(paramAnonymousMap));
              AppMethodBeat.o(194462);
              return;
            }
            Log.i("MicroMsg.PluginMessenger", "msg %s not found!", new Object[] { paramAnonymousString });
            br.d(Util.safeParseLong(paramAnonymousString), br.A(paramAnonymousMap));
          }
        }
        AppMethodBeat.o(194462);
      }
    };
    this.zoV = new e.b() {};
    this.zoW = new e.b() {};
    this.zoX = new e.b()
    {
      public final CharSequence a(final Map<String, String> paramAnonymousMap, String paramAnonymousString, Bundle paramAnonymousBundle, final WeakReference<Context> paramAnonymousWeakReference, WeakReference<NeatTextView> paramAnonymousWeakReference1)
      {
        AppMethodBeat.i(194467);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(194467);
          return null;
        }
        paramAnonymousBundle = Util.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        paramAnonymousMap = (String)paramAnonymousMap.get(paramAnonymousString + ".url");
        paramAnonymousString = new SpannableString(paramAnonymousBundle);
        if (!TextUtils.isEmpty(paramAnonymousMap)) {
          paramAnonymousString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
          {
            public final void onClickImp(View paramAnonymous2View)
            {
              AppMethodBeat.i(194466);
              paramAnonymous2View = (Context)paramAnonymousWeakReference.get();
              if (paramAnonymous2View != null)
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", paramAnonymousMap);
                com.tencent.mm.br.c.b(paramAnonymous2View, "webview", ".ui.tools.WebViewUI", localIntent);
              }
              AppMethodBeat.o(194466);
            }
          }, 0, paramAnonymousBundle.length(), 33);
        }
        AppMethodBeat.o(194467);
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
    AppMethodBeat.i(194474);
    if (!com.tencent.mm.vfs.s.YS("wcf://selectrecord/")) {
      com.tencent.mm.vfs.s.boN("wcf://selectrecord/");
    }
    AppMethodBeat.o(194474);
    return "wcf://selectrecord/";
  }
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90734);
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90734);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90737);
    String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
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
      if ((!Util.isNullOrNil((String)localObject1)) && (p.aYB().Mx(str3) == null))
      {
        localObject2 = new com.tencent.mm.aj.i();
        ((com.tencent.mm.aj.i)localObject2).username = str3;
        ((com.tencent.mm.aj.i)localObject2).iKW = ((String)localObject1);
        ((com.tencent.mm.aj.i)localObject2).fuz = 3;
        ((com.tencent.mm.aj.i)localObject2).fv(false);
        p.aYB().b((com.tencent.mm.aj.i)localObject2);
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
      paramBundle = com.tencent.mm.plugin.messenger.d.c.aFd(paramBundle);
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
            localArrayList.add(new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), locala.content)));
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
              paramMap = new gs();
              paramMap.uu(str2);
              paramMap.uv(paramString2);
              paramMap.eKO = 1L;
              paramMap.eKP = 1L;
              paramMap.eKQ = 3L;
              paramMap.bfK();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
              AppMethodBeat.o(90722);
              return;
              if (j == 0)
              {
                paramMap = new gs();
                paramMap.uu(str2);
                paramMap.uv(paramString2);
                paramMap.eKO = 1L;
                paramMap.eKP = 1L;
                paramMap.eKQ = 2L;
                paramMap.bfK();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new gs();
            paramMap.uu(str2);
            paramMap.uv(paramString2);
            paramMap.eKO = 1L;
            paramMap.eKP = 1L;
            paramMap.eKQ = 1L;
            paramMap.bfK();
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
    com.tencent.mm.br.c.f(MMApplicationContext.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(90732);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90725);
    if (paramg.aBb())
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.b.class, this.zoF);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.e.class, this.zoG);
      y.at("selectrecord", "selectrecord", 3);
    }
    AppMethodBeat.o(90725);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(90724);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(90724);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90726);
    if (paramg.aBb()) {
      pin(com.tencent.mm.plugin.w.a.eMS());
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
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(90727);
    paramc = this.zoG;
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.zqJ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.zoI);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.zoJ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.zoK);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_live", this.zoV);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("comment_link_profile", this.zoW);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.zoX);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.zoL);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.zoM);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.zoN);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke", this.zoO);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_qrcode", this.zoP);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_profile", this.zoQ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("new_link_succeed_contact", this.zoR);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", this.zoP);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.zoS);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_history", this.zoT);
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("secmsg", this.zoU);
    com.tencent.mm.kernel.g.azz().a(853, this);
    paramc = this.zoH;
    paramc.zqQ = new com.tencent.mm.plugin.messenger.e.a();
    paramc.zqR = new com.tencent.mm.plugin.messenger.e.c();
    paramc.zqS = new com.tencent.mm.plugin.messenger.e.b();
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194468);
        int i = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSP().eiE();
        int j = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSP().eiF();
        com.tencent.mm.plugin.report.service.h.CyF.a(20460, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(194468);
      }
    }, 60000L);
    AppMethodBeat.o(90727);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90728);
    Object localObject = this.zoG;
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("sysmsgtemplate", ((com.tencent.mm.plugin.messenger.d.a)localObject).zqJ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_live");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("comment_link_profile");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDU("link_url");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_revoke");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_revoke_qrcode");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_profile");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("new_link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_revoke_unbindapp");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_url");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.e.class)).aDV("link_history");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("secmsg", this.zoU);
    com.tencent.mm.kernel.g.azz().b(853, this);
    localObject = this.zoH;
    if (((d)localObject).zqQ != null) {
      ((d)localObject).zqQ.release();
    }
    if (((d)localObject).zqR != null) {
      ((d)localObject).zqR.release();
    }
    if (((d)localObject).zqS != null) {
      ((d)localObject).zqS.release();
    }
    AppMethodBeat.o(90728);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(90731);
    try
    {
      if (CrashReportFactory.hasDebuger()) {
        u.makeText(MMApplicationContext.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramq.getType() == 853)
      {
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        if (paramq.equals(this.zoE))
        {
          paramString = (com.tencent.mm.openim.b.q)paramq;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.jGZ, paramString.jHj);
            startChattingUI(paramString.jGZ);
          }
          Log.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.jGZ + " ticket: " + paramString.jHi + " talkerUsername: " + paramString.jHj);
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
      localSwitchContactDialogCustomView.setTilte(paramContext.getString(2131763795));
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
          AppMethodBeat.i(194469);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramString3);
          paramAnonymousView.putExtra(e.d.OyT, paramString5);
          com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194469);
        }
      });
      paramString2 = paramString10;
      if (Util.isNullOrNil(paramString10)) {
        paramString2 = paramContext.getString(2131763792);
      }
      paramString5 = paramString11;
      if (Util.isNullOrNil(paramString11)) {
        paramString5 = paramContext.getString(2131763794);
      }
      locala.hu(localSwitchContactDialogCustomView).boA(paramString5).boB(paramString2).a(new f.c()new f.c
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(194470);
          paramAnonymousString = new gs();
          paramAnonymousString.uu(paramString1);
          paramAnonymousString.uv(paramString8);
          paramAnonymousString.eKO = 1L;
          paramAnonymousString.eKP = 1L;
          paramAnonymousString.eKR = 1L;
          paramAnonymousString.bfK();
          AppMethodBeat.o(194470);
        }
      }, new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(194472);
          if ((paramAnonymousBoolean) && (as.bjp(paramString3)))
          {
            paramAnonymousString = new gs();
            paramAnonymousString.uu(paramString1);
            paramAnonymousString.eKO = 1L;
            paramAnonymousString.uv(paramString8);
            paramAnonymousString.eKP = 1L;
            paramAnonymousString.eKR = 2L;
            paramAnonymousString.bfK();
            PluginMessenger.access$202(PluginMessenger.this, new com.tencent.mm.openim.b.q(paramString3, paramString4, 0));
            PluginMessenger.this.zoE.jHj = paramString8;
            com.tencent.mm.kernel.g.azz().a(PluginMessenger.this.zoE, 0);
            paramAnonymousString = PluginMessenger.this;
            Context localContext = paramContext;
            paramContext.getString(2131755998);
            PluginMessenger.access$302(paramAnonymousString, com.tencent.mm.ui.base.h.a(localContext, paramContext.getString(2131763796), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(90709);
                com.tencent.mm.kernel.g.azz().a(PluginMessenger.this.zoE);
                AppMethodBeat.o(90709);
              }
            }));
          }
          AppMethodBeat.o(194472);
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