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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.dq;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.u;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ak.f, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.c
{
  private ProgressDialog fOC;
  private com.tencent.mm.plugin.messenger.d.a vUA;
  private com.tencent.mm.plugin.messenger.d.d vUB;
  private e.b vUC;
  private e.b vUD;
  private e.b vUE;
  private com.tencent.mm.plugin.messenger.a.e.a vUF;
  private com.tencent.mm.plugin.messenger.a.e.a vUG;
  private com.tencent.mm.plugin.messenger.a.e.a vUH;
  private com.tencent.mm.plugin.messenger.a.e.a vUI;
  private com.tencent.mm.plugin.messenger.a.e.a vUJ;
  private com.tencent.mm.plugin.messenger.a.e.a vUK;
  private com.tencent.mm.plugin.messenger.a.e.a vUL;
  private com.tencent.mm.plugin.messenger.a.e.a vUM;
  private com.tencent.mm.plugin.messenger.a.e.a vUN;
  private com.tencent.mm.plugin.messenger.foundation.a.q vUO;
  private e.b vUP;
  private e.b vUQ;
  private e.b vUR;
  private com.tencent.mm.openim.b.q vUy;
  a vUz;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(90721);
    this.fOC = null;
    this.vUz = new a();
    this.vUA = new com.tencent.mm.plugin.messenger.d.a();
    this.vUB = new com.tencent.mm.plugin.messenger.d.d();
    this.vUC = new e.b() {};
    this.vUD = new e.b() {};
    this.vUE = new e.b() {};
    this.vUF = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90715);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90715);
          return null;
        }
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".plain"));
        AppMethodBeat.o(90715);
        return paramAnonymousMap;
      }
    };
    this.vUG = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90716);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90716);
          return null;
        }
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90716);
        return paramAnonymousMap;
      }
    };
    this.vUH = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90717);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90717);
          return null;
        }
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90717);
        return paramAnonymousMap;
      }
    };
    this.vUI = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90718);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90718);
          return null;
        }
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90718);
        return paramAnonymousMap;
      }
    };
    this.vUJ = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90719);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90719);
          return null;
        }
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90719);
        return paramAnonymousMap;
      }
    };
    this.vUK = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90720);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str = bu.bI((String)paramAnonymousMap.get(paramAnonymousString + ".separator"), "、");
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
          if (!bu.isNullOrNil((String)localObject)) {
            break label174;
          }
          ae.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
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
    this.vUL = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(218130);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(218130);
          return null;
        }
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(218130);
        return paramAnonymousMap;
      }
    };
    this.vUM = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(218131);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(218131);
          return null;
        }
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(218131);
        return paramAnonymousMap;
      }
    };
    this.vUN = new com.tencent.mm.plugin.messenger.a.e.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(218132);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(218132);
          return null;
        }
        ae.d("MicroMsg.PluginMessenger", "mHandleNewLinkHistoryDigestListener %s", new Object[] { bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title")) });
        paramAnonymousMap = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(218132);
        return paramAnonymousMap;
      }
    };
    this.vUO = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, com.tencent.mm.ak.e.a paramAnonymousa)
      {
        AppMethodBeat.i(218133);
        if ("secmsg".equals(paramAnonymousString))
        {
          paramAnonymousa = bu.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.session"));
          paramAnonymousString = bu.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.newmsgid"));
          int i = bu.aSB((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
          String str1 = bu.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
          int j = bu.aSB((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
          String str2 = bu.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
          int k = bu.aSB((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
          ae.i("MicroMsg.PluginMessenger", "[%d],[%s],[%d],[%s],[%d]", new Object[] { Integer.valueOf(i), str1, Integer.valueOf(j), str2, Integer.valueOf(k) });
          paramAnonymousMap = new HashMap();
          paramAnonymousMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(i));
          paramAnonymousMap.put(".msgsource.sec_msg_node.show-h5", str1);
          paramAnonymousMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(j));
          paramAnonymousMap.put(".msgsource.sec_msg_node.share-tip-url", str2);
          paramAnonymousMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(k));
          if (!bu.V(new String[] { paramAnonymousa, paramAnonymousString }))
          {
            paramAnonymousa = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(paramAnonymousa, bu.aSC(paramAnonymousString));
            if ((!bu.isNullOrNil(paramAnonymousa.field_talker)) && (paramAnonymousa.field_msgSvrId > 0L))
            {
              bn.a(paramAnonymousa, bn.y(paramAnonymousMap));
              AppMethodBeat.o(218133);
              return;
            }
            ae.i("MicroMsg.PluginMessenger", "msg %s not found!", new Object[] { paramAnonymousString });
            bn.d(bu.aSC(paramAnonymousString), bn.y(paramAnonymousMap));
          }
        }
        AppMethodBeat.o(218133);
      }
    };
    this.vUP = new e.b() {};
    this.vUQ = new e.b() {};
    this.vUR = new e.b()
    {
      public final CharSequence a(final Map<String, String> paramAnonymousMap, String paramAnonymousString, Bundle paramAnonymousBundle, final WeakReference<Context> paramAnonymousWeakReference, WeakReference<NeatTextView> paramAnonymousWeakReference1)
      {
        AppMethodBeat.i(218138);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(218138);
          return null;
        }
        paramAnonymousBundle = bu.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        paramAnonymousMap = (String)paramAnonymousMap.get(paramAnonymousString + ".url");
        paramAnonymousString = new SpannableString(paramAnonymousBundle);
        if (!TextUtils.isEmpty(paramAnonymousMap)) {
          paramAnonymousString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
          {
            public final void onClickImp(View paramAnonymous2View)
            {
              AppMethodBeat.i(218137);
              paramAnonymous2View = (Context)paramAnonymousWeakReference.get();
              if (paramAnonymous2View != null)
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("rawUrl", paramAnonymousMap);
                com.tencent.mm.br.d.b(paramAnonymous2View, "webview", ".ui.tools.WebViewUI", localIntent);
              }
              AppMethodBeat.o(218137);
            }
          }, 0, paramAnonymousBundle.length(), 33);
        }
        AppMethodBeat.o(218138);
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
    AppMethodBeat.i(218145);
    if (!o.fB("wcf://selectrecord/")) {
      o.aZI("wcf://selectrecord/");
    }
    AppMethodBeat.o(218145);
    return "wcf://selectrecord/";
  }
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90734);
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90734);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90737);
    String str = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, "");
    paramString1 = "switch_contact_prefs_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90737);
    return paramString1;
  }
  
  private boolean isSwitchContact(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90739);
    boolean bool = ak.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(paramString1, paramString2), false);
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
      str2 = bu.bI(paramBundle.getString("local_session"), "");
      if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.$type");
      j = bu.aSB((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
      if (!"tmpl_type_succeed_contact_window".equals(paramBundle)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.template");
      str3 = (String)paramMap.get(paramString1 + ".window_template.tp_username");
      localObject1 = (String)paramMap.get(paramString1 + ".window_template.headimgurl");
      if ((!bu.isNullOrNil((String)localObject1)) && (p.aEN().DL(str3) == null))
      {
        localObject2 = new com.tencent.mm.aj.i();
        ((com.tencent.mm.aj.i)localObject2).username = str3;
        ((com.tencent.mm.aj.i)localObject2).hPP = ((String)localObject1);
        ((com.tencent.mm.aj.i)localObject2).eQU = 3;
        ((com.tencent.mm.aj.i)localObject2).eD(false);
        p.aEN().b((com.tencent.mm.aj.i)localObject2);
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
      paramBundle = com.tencent.mm.plugin.messenger.d.c.arI(paramBundle);
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
            localArrayList.add(new SpannableString(k.c(ak.getContext(), locala.content)));
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
        if (bu.isNullOrNil((String)paramMap.get(str1))) {
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
              paramMap = new dq();
              paramMap.nn(str2);
              paramMap.no(paramString2);
              paramMap.eit = 1L;
              paramMap.eiu = 1L;
              paramMap.eiv = 3L;
              paramMap.aLH();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
              AppMethodBeat.o(90722);
              return;
              if (j == 0)
              {
                paramMap = new dq();
                paramMap.nn(str2);
                paramMap.no(paramString2);
                paramMap.eit = 1L;
                paramMap.eiu = 1L;
                paramMap.eiv = 2L;
                paramMap.aLH();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new dq();
            paramMap.nn(str2);
            paramMap.no(paramString2);
            paramMap.eit = 1L;
            paramMap.eiu = 1L;
            paramMap.eiv = 1L;
            paramMap.aLH();
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
    ak.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(paramString1, paramString2), true).commit();
    AppMethodBeat.o(90738);
  }
  
  private void startChattingUI(String paramString)
  {
    AppMethodBeat.i(90732);
    ae.i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    com.tencent.mm.br.d.f(ak.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(90732);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90725);
    if (paramg.akL())
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.b.class, this.vUz);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.e.class, this.vUA);
      u.ap("selectrecord", "selectrecord", 3);
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
    if (paramg.akL()) {
      pin(com.tencent.mm.plugin.x.a.dLQ());
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
    boolean bool = ak.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), true);
    AppMethodBeat.o(90736);
    return bool;
  }
  
  public void markFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90735);
    ak.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), false).commit();
    AppMethodBeat.o(90735);
  }
  
  public void onAccountInitialized(com.tencent.mm.kernel.e.c paramc)
  {
    AppMethodBeat.i(90727);
    paramc = this.vUA;
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.vWE);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.vUC);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.vUD);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.vUE);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_live", this.vUP);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("comment_link_profile", this.vUQ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.vUR);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.vUF);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.vUG);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.vUH);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke", this.vUI);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_qrcode", this.vUJ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_profile", this.vUK);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("new_link_succeed_contact", this.vUL);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", this.vUJ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.vUM);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_history", this.vUN);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("secmsg", this.vUO);
    com.tencent.mm.kernel.g.ajj().a(853, this);
    paramc = this.vUB;
    paramc.vWL = new com.tencent.mm.plugin.messenger.e.a();
    paramc.vWM = new com.tencent.mm.plugin.messenger.e.c();
    paramc.vWN = new com.tencent.mm.plugin.messenger.e.b();
    new aq().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218139);
        int i = ((l)com.tencent.mm.kernel.g.ab(l.class)).azH().doP();
        int j = ((l)com.tencent.mm.kernel.g.ab(l.class)).azH().doQ();
        com.tencent.mm.plugin.report.service.g.yxI.f(20460, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(218139);
      }
    }, 60000L);
    AppMethodBeat.o(90727);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90728);
    Object localObject = this.vUA;
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("sysmsgtemplate", ((com.tencent.mm.plugin.messenger.d.a)localObject).vWE);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqz("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqz("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqz("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqz("link_live");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqz("comment_link_profile");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqz("link_url");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_revoke");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_revoke_qrcode");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_profile");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("new_link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_revoke_unbindapp");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_url");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).aqA("link_history");
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("secmsg", this.vUO);
    com.tencent.mm.kernel.g.ajj().b(853, this);
    localObject = this.vUB;
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).vWL != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).vWL.release();
    }
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).vWM != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).vWM.release();
    }
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).vWN != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).vWN.release();
    }
    AppMethodBeat.o(90728);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(90731);
    try
    {
      if (com.tencent.mm.sdk.a.b.fnF()) {
        t.makeText(ak.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramn.getType() == 853)
      {
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
        }
        if (paramn.equals(this.vUy))
        {
          paramString = (com.tencent.mm.openim.b.q)paramn;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.iKt, paramString.iKD);
            startChattingUI(paramString.iKt);
          }
          ae.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.iKt + " ticket: " + paramString.iKC + " talkerUsername: " + paramString.iKD);
        }
      }
      AppMethodBeat.o(90731);
      return;
    }
    catch (Throwable paramString)
    {
      ae.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(90731);
    }
  }
  
  public void showSwitchContactDialog(final Context paramContext, final String paramString1, String paramString2, final String paramString3, final String paramString4, final String paramString5, String paramString6, String paramString7, final String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(90733);
    f.a locala = new f.a(paramContext);
    SwitchContactDialogCustomView localSwitchContactDialogCustomView = new SwitchContactDialogCustomView(paramContext);
    if (bu.isNullOrNil(paramString9)) {
      localSwitchContactDialogCustomView.setTilte(paramContext.getString(2131761819));
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
          AppMethodBeat.i(218140);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramString3);
          paramAnonymousView.putExtra(com.tencent.mm.ui.e.c.JoX, paramString5);
          com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218140);
        }
      });
      paramString2 = paramString10;
      if (bu.isNullOrNil(paramString10)) {
        paramString2 = paramContext.getString(2131761816);
      }
      paramString5 = paramString11;
      if (bu.isNullOrNil(paramString11)) {
        paramString5 = paramContext.getString(2131761818);
      }
      locala.hg(localSwitchContactDialogCustomView).aZu(paramString5).aZv(paramString2).a(new f.c()new f.c
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(218141);
          paramAnonymousString = new dq();
          paramAnonymousString.nn(paramString1);
          paramAnonymousString.no(paramString8);
          paramAnonymousString.eit = 1L;
          paramAnonymousString.eiu = 1L;
          paramAnonymousString.eiw = 1L;
          paramAnonymousString.aLH();
          AppMethodBeat.o(218141);
        }
      }, new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(218143);
          if ((paramAnonymousBoolean) && (an.aUq(paramString3)))
          {
            paramAnonymousString = new dq();
            paramAnonymousString.nn(paramString1);
            paramAnonymousString.eit = 1L;
            paramAnonymousString.no(paramString8);
            paramAnonymousString.eiu = 1L;
            paramAnonymousString.eiw = 2L;
            paramAnonymousString.aLH();
            PluginMessenger.access$202(PluginMessenger.this, new com.tencent.mm.openim.b.q(paramString3, paramString4, 0));
            PluginMessenger.this.vUy.iKD = paramString8;
            com.tencent.mm.kernel.g.ajj().a(PluginMessenger.this.vUy, 0);
            paramAnonymousString = PluginMessenger.this;
            Context localContext = paramContext;
            paramContext.getString(2131755906);
            PluginMessenger.access$302(paramAnonymousString, h.b(localContext, paramContext.getString(2131761820), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(90709);
                com.tencent.mm.kernel.g.ajj().a(PluginMessenger.this.vUy);
                AppMethodBeat.o(90709);
              }
            }));
          }
          AppMethodBeat.o(218143);
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