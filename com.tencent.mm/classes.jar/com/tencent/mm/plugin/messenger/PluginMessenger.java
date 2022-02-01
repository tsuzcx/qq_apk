package com.tencent.mm.plugin.messenger;

import android.app.ProgressDialog;
import android.content.Context;
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
import com.tencent.mm.ak.j;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.bi;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.a.f.b;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.al.g, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.d
{
  private f.b Lmt;
  private f.b Lmu;
  private ProgressDialog fpP;
  private com.tencent.mm.openim.b.q txc;
  private com.tencent.mm.plugin.messenger.a.i txd;
  a txe;
  private com.tencent.mm.plugin.messenger.d.a txf;
  private com.tencent.mm.plugin.messenger.d.d txg;
  private f.b txh;
  private f.b txi;
  private f.b txj;
  private com.tencent.mm.plugin.messenger.a.f.a txk;
  private com.tencent.mm.plugin.messenger.a.f.a txl;
  private com.tencent.mm.plugin.messenger.a.f.a txm;
  private com.tencent.mm.plugin.messenger.a.f.a txn;
  private com.tencent.mm.plugin.messenger.a.f.a txo;
  private com.tencent.mm.plugin.messenger.a.f.a txp;
  private com.tencent.mm.plugin.messenger.a.f.a txq;
  private com.tencent.mm.plugin.messenger.foundation.a.p txr;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(90721);
    this.fpP = null;
    this.txd = new com.tencent.mm.plugin.messenger.a.i();
    this.txe = new a();
    this.txf = new com.tencent.mm.plugin.messenger.d.a();
    this.txg = new com.tencent.mm.plugin.messenger.d.d();
    this.txh = new f.b() {};
    this.txi = new f.b() {};
    this.txj = new f.b() {};
    this.txk = new com.tencent.mm.plugin.messenger.a.f.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90715);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90715);
          return null;
        }
        paramAnonymousMap = bt.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".plain"));
        AppMethodBeat.o(90715);
        return paramAnonymousMap;
      }
    };
    this.txl = new com.tencent.mm.plugin.messenger.a.f.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90716);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90716);
          return null;
        }
        paramAnonymousMap = bt.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90716);
        return paramAnonymousMap;
      }
    };
    this.txm = new com.tencent.mm.plugin.messenger.a.f.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90717);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90717);
          return null;
        }
        paramAnonymousMap = bt.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90717);
        return paramAnonymousMap;
      }
    };
    this.txn = new com.tencent.mm.plugin.messenger.a.f.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90718);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90718);
          return null;
        }
        paramAnonymousMap = bt.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90718);
        return paramAnonymousMap;
      }
    };
    this.txo = new com.tencent.mm.plugin.messenger.a.f.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90719);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(90719);
          return null;
        }
        paramAnonymousMap = bt.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(90719);
        return paramAnonymousMap;
      }
    };
    this.txp = new com.tencent.mm.plugin.messenger.a.f.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(90720);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str = bt.by((String)paramAnonymousMap.get(paramAnonymousString + ".separator"), "、");
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
          if (!bt.isNullOrNil((String)localObject)) {
            break label174;
          }
          ad.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
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
    this.txq = new com.tencent.mm.plugin.messenger.a.f.a()
    {
      public final String e(Map<String, String> paramAnonymousMap, String paramAnonymousString)
      {
        AppMethodBeat.i(196677);
        if (paramAnonymousMap == null)
        {
          AppMethodBeat.o(196677);
          return null;
        }
        paramAnonymousMap = bt.nullAsNil((String)paramAnonymousMap.get(paramAnonymousString + ".title"));
        AppMethodBeat.o(196677);
        return paramAnonymousMap;
      }
    };
    this.txr = new com.tencent.mm.plugin.messenger.foundation.a.p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, com.tencent.mm.al.f.a paramAnonymousa)
      {
        AppMethodBeat.i(196678);
        if ("secmsg".equals(paramAnonymousString))
        {
          paramAnonymousa = bt.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.session"));
          paramAnonymousString = bt.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.newmsgid"));
          int i = bt.aGh((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
          String str1 = bt.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
          int j = bt.aGh((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
          String str2 = bt.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
          int k = bt.aGh((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
          ad.i("MicroMsg.PluginMessenger", "[%d],[%s],[%d],[%s],[%d]", new Object[] { Integer.valueOf(i), str1, Integer.valueOf(j), str2, Integer.valueOf(k) });
          paramAnonymousMap = new HashMap();
          paramAnonymousMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(i));
          paramAnonymousMap.put(".msgsource.sec_msg_node.show-h5", str1);
          paramAnonymousMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(j));
          paramAnonymousMap.put(".msgsource.sec_msg_node.share-tip-url", str2);
          paramAnonymousMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(k));
          if (!bt.T(new String[] { paramAnonymousa, paramAnonymousString }))
          {
            paramAnonymousa = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().aD(paramAnonymousa, bt.aGi(paramAnonymousString));
            if ((!bt.isNullOrNil(paramAnonymousa.field_talker)) && (paramAnonymousa.field_msgSvrId > 0L))
            {
              bk.a(paramAnonymousa, bk.r(paramAnonymousMap));
              AppMethodBeat.o(196678);
              return;
            }
            ad.i("MicroMsg.PluginMessenger", "msg %s not found!", new Object[] { paramAnonymousString });
            bk.d(bt.aGi(paramAnonymousString), bk.r(paramAnonymousMap));
          }
        }
        AppMethodBeat.o(196678);
      }
    };
    this.Lmt = new f.b() {};
    this.Lmu = new f.b() {};
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
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90734);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90734);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90737);
    String str = (String)com.tencent.mm.kernel.g.afB().afk().get(2, "");
    paramString1 = "switch_contact_prefs_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90737);
    return paramString1;
  }
  
  private boolean isSwitchContact(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90739);
    boolean bool = aj.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(paramString1, paramString2), false);
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
      str2 = bt.by(paramBundle.getString("local_session"), "");
      if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.$type");
      j = bt.aGh((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
      if (!"tmpl_type_succeed_contact_window".equals(paramBundle)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.template");
      str3 = (String)paramMap.get(paramString1 + ".window_template.tp_username");
      localObject1 = (String)paramMap.get(paramString1 + ".window_template.headimgurl");
      if ((!bt.isNullOrNil((String)localObject1)) && (com.tencent.mm.ak.p.auF().we(str3) == null))
      {
        localObject2 = new com.tencent.mm.ak.i();
        ((com.tencent.mm.ak.i)localObject2).username = str3;
        ((com.tencent.mm.ak.i)localObject2).gUf = ((String)localObject1);
        ((com.tencent.mm.ak.i)localObject2).evo = 3;
        ((com.tencent.mm.ak.i)localObject2).ee(false);
        com.tencent.mm.ak.p.auF().b((com.tencent.mm.ak.i)localObject2);
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
      paramBundle = com.tencent.mm.plugin.messenger.d.c.agU(paramBundle);
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
            localArrayList.add(new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.c(aj.getContext(), locala.content)));
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
        if (bt.isNullOrNil((String)paramMap.get(str1))) {
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
              paramMap = new bi();
              paramMap.ib(str2);
              paramMap.ic(paramString2);
              paramMap.dPx = 1L;
              paramMap.dPy = 1L;
              paramMap.dPz = 3L;
              paramMap.aBj();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
              AppMethodBeat.o(90722);
              return;
              if (j == 0)
              {
                paramMap = new bi();
                paramMap.ib(str2);
                paramMap.ic(paramString2);
                paramMap.dPx = 1L;
                paramMap.dPy = 1L;
                paramMap.dPz = 2L;
                paramMap.aBj();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new bi();
            paramMap.ib(str2);
            paramMap.ic(paramString2);
            paramMap.dPx = 1L;
            paramMap.dPy = 1L;
            paramMap.dPz = 1L;
            paramMap.aBj();
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
    aj.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(paramString1, paramString2), true).commit();
    AppMethodBeat.o(90738);
  }
  
  private void startChattingUI(String paramString)
  {
    AppMethodBeat.i(90732);
    ad.i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    com.tencent.mm.bs.d.e(aj.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(90732);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90725);
    if (paramg.agu())
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.b.class, this.txe);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.f.class, this.txf);
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
    if (paramg.agu()) {
      pin(com.tencent.mm.plugin.w.a.djh());
    }
    AppMethodBeat.o(90726);
  }
  
  public void installed()
  {
    AppMethodBeat.i(90723);
    alias(com.tencent.mm.plugin.messenger.a.d.class);
    AppMethodBeat.o(90723);
  }
  
  public boolean isFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90736);
    boolean bool = aj.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), true);
    AppMethodBeat.o(90736);
    return bool;
  }
  
  public void markFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90735);
    aj.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), false).commit();
    AppMethodBeat.o(90735);
  }
  
  public void onAccountInitialized(com.tencent.mm.kernel.e.c paramc)
  {
    AppMethodBeat.i(90727);
    paramc = this.txf;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.tza);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_plain", this.txh);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_succeed_contact", this.txi);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_jump_chat", this.txj);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_live", this.Lmt);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("comment_link_profile", this.Lmu);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_plain", this.txk);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_succeed_contact", this.txl);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_jump_chat", this.txm);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_revoke", this.txn);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_revoke_qrcode", this.txo);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_profile", this.txp);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("new_link_succeed_contact", this.txq);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.c.class, this.txd);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("secmsg", this.txr);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("pat", this.txd.txI);
    com.tencent.mm.kernel.g.aeS().a(853, this);
    com.tencent.mm.kernel.g.aeS().a(849, this.txd);
    this.txg.tzh = new com.tencent.mm.plugin.messenger.e.a();
    AppMethodBeat.o(90727);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90728);
    Object localObject = this.txf;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("sysmsgtemplate", ((com.tencent.mm.plugin.messenger.d.a)localObject).tza);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afO("link_plain");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afO("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afO("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afO("link_live");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afO("comment_link_profile");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("link_plain");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("link_revoke");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("link_revoke_qrcode");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("link_profile");
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.messenger.a.c.class);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).afP("new_link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("secmsg", this.txr);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("pat", this.txd.txI);
    com.tencent.mm.kernel.g.aeS().b(853, this);
    com.tencent.mm.kernel.g.aeS().b(849, this.txd);
    localObject = this.txg;
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).tzh != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).tzh.release();
    }
    AppMethodBeat.o(90728);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(90731);
    try
    {
      if (com.tencent.mm.sdk.a.b.eEQ()) {
        t.makeText(aj.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramn.getType() == 853)
      {
        if (this.fpP != null)
        {
          this.fpP.dismiss();
          this.fpP = null;
        }
        if (paramn.equals(this.txc))
        {
          paramString = (com.tencent.mm.openim.b.q)paramn;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.hNH, paramString.hNR);
            startChattingUI(paramString.hNH);
          }
          ad.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.hNH + " ticket: " + paramString.hNQ + " talkerUsername: " + paramString.hNR);
        }
      }
      AppMethodBeat.o(90731);
      return;
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(90731);
    }
  }
  
  public void showSwitchContactDialog(final Context paramContext, String paramString1, String paramString2, final String paramString3, String paramString4, final String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(90733);
    com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(paramContext);
    SwitchContactDialogCustomView localSwitchContactDialogCustomView = new SwitchContactDialogCustomView(paramContext);
    if (bt.isNullOrNil(paramString9)) {
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
          AppMethodBeat.i(203902);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramString3);
          paramAnonymousView.putExtra(com.tencent.mm.ui.e.c.FHR, paramString5);
          com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
          AppMethodBeat.o(203902);
        }
      });
      paramString2 = paramString10;
      if (bt.isNullOrNil(paramString10)) {
        paramString2 = paramContext.getString(2131761816);
      }
      paramString5 = paramString11;
      if (bt.isNullOrNil(paramString11)) {
        paramString5 = paramContext.getString(2131761818);
      }
      locala.gu(localSwitchContactDialogCustomView).aMs(paramString5).aMt(paramString2).a(new PluginMessenger.15(this, paramString1, paramString8), new PluginMessenger.16(this, paramString3, paramString1, paramString8, paramString4, paramContext)).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger
 * JD-Core Version:    0.7.0.1
 */