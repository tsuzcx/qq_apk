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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.a.f.b;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ak.g, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.d
{
  private ProgressDialog fts;
  private f.b uFA;
  private f.b uFB;
  private com.tencent.mm.plugin.messenger.a.f.a uFC;
  private com.tencent.mm.plugin.messenger.a.f.a uFD;
  private com.tencent.mm.plugin.messenger.a.f.a uFE;
  private com.tencent.mm.plugin.messenger.a.f.a uFF;
  private com.tencent.mm.plugin.messenger.a.f.a uFG;
  private com.tencent.mm.plugin.messenger.a.f.a uFH;
  private com.tencent.mm.plugin.messenger.a.f.a uFI;
  private com.tencent.mm.plugin.messenger.foundation.a.p uFJ;
  private f.b uFK;
  private f.b uFL;
  private com.tencent.mm.openim.b.q uFu;
  private com.tencent.mm.plugin.messenger.a.i uFv;
  a uFw;
  private com.tencent.mm.plugin.messenger.d.a uFx;
  private com.tencent.mm.plugin.messenger.d.d uFy;
  private f.b uFz;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(90721);
    this.fts = null;
    this.uFv = new com.tencent.mm.plugin.messenger.a.i();
    this.uFw = new a();
    this.uFx = new com.tencent.mm.plugin.messenger.d.a();
    this.uFy = new com.tencent.mm.plugin.messenger.d.d();
    this.uFz = new PluginMessenger.1(this);
    this.uFA = new f.b() {};
    this.uFB = new PluginMessenger.10(this);
    this.uFC = new PluginMessenger.11(this);
    this.uFD = new PluginMessenger.12(this);
    this.uFE = new PluginMessenger.13(this);
    this.uFF = new PluginMessenger.14(this);
    this.uFG = new PluginMessenger.15(this);
    this.uFH = new PluginMessenger.16(this);
    this.uFI = new PluginMessenger.2(this);
    this.uFJ = new com.tencent.mm.plugin.messenger.foundation.a.p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, com.tencent.mm.ak.f.a paramAnonymousa)
      {
        AppMethodBeat.i(198558);
        if ("secmsg".equals(paramAnonymousString))
        {
          paramAnonymousa = bs.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.session"));
          paramAnonymousString = bs.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.newmsgid"));
          int i = bs.aLy((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
          String str1 = bs.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
          int j = bs.aLy((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
          String str2 = bs.nullAsNil((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
          int k = bs.aLy((String)paramAnonymousMap.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
          ac.i("MicroMsg.PluginMessenger", "[%d],[%s],[%d],[%s],[%d]", new Object[] { Integer.valueOf(i), str1, Integer.valueOf(j), str2, Integer.valueOf(k) });
          paramAnonymousMap = new HashMap();
          paramAnonymousMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(i));
          paramAnonymousMap.put(".msgsource.sec_msg_node.show-h5", str1);
          paramAnonymousMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(j));
          paramAnonymousMap.put(".msgsource.sec_msg_node.share-tip-url", str2);
          paramAnonymousMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(k));
          if (!bs.T(new String[] { paramAnonymousa, paramAnonymousString }))
          {
            paramAnonymousa = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().aF(paramAnonymousa, bs.aLz(paramAnonymousString));
            if ((!bs.isNullOrNil(paramAnonymousa.field_talker)) && (paramAnonymousa.field_msgSvrId > 0L))
            {
              bk.a(paramAnonymousa, bk.q(paramAnonymousMap));
              AppMethodBeat.o(198558);
              return;
            }
            ac.i("MicroMsg.PluginMessenger", "msg %s not found!", new Object[] { paramAnonymousString });
            bk.d(bs.aLz(paramAnonymousString), bk.q(paramAnonymousMap));
          }
        }
        AppMethodBeat.o(198558);
      }
    };
    this.uFK = new PluginMessenger.4(this);
    this.uFL = new PluginMessenger.5(this);
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
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90734);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90737);
    String str = (String)com.tencent.mm.kernel.g.agR().agA().get(2, "");
    paramString1 = "switch_contact_prefs_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90737);
    return paramString1;
  }
  
  private boolean isSwitchContact(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90739);
    boolean bool = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(paramString1, paramString2), false);
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
      str2 = bs.bG(paramBundle.getString("local_session"), "");
      if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.$type");
      j = bs.aLy((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
      if (!"tmpl_type_succeed_contact_window".equals(paramBundle)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.template");
      str3 = (String)paramMap.get(paramString1 + ".window_template.tp_username");
      localObject1 = (String)paramMap.get(paramString1 + ".window_template.headimgurl");
      if ((!bs.isNullOrNil((String)localObject1)) && (com.tencent.mm.aj.p.aBw().Ak(str3) == null))
      {
        localObject2 = new com.tencent.mm.aj.i();
        ((com.tencent.mm.aj.i)localObject2).username = str3;
        ((com.tencent.mm.aj.i)localObject2).huE = ((String)localObject1);
        ((com.tencent.mm.aj.i)localObject2).exK = 3;
        ((com.tencent.mm.aj.i)localObject2).ez(false);
        com.tencent.mm.aj.p.aBw().b((com.tencent.mm.aj.i)localObject2);
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
      paramBundle = com.tencent.mm.plugin.messenger.d.c.alO(paramBundle);
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
            localArrayList.add(new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.c(com.tencent.mm.sdk.platformtools.ai.getContext(), locala.content)));
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
        if (bs.isNullOrNil((String)paramMap.get(str1))) {
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
              paramMap = new cv();
              paramMap.kR(str2);
              paramMap.kS(paramString2);
              paramMap.dRm = 1L;
              paramMap.dRn = 1L;
              paramMap.dRo = 3L;
              paramMap.aHZ();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
              AppMethodBeat.o(90722);
              return;
              if (j == 0)
              {
                paramMap = new cv();
                paramMap.kR(str2);
                paramMap.kS(paramString2);
                paramMap.dRm = 1L;
                paramMap.dRn = 1L;
                paramMap.dRo = 2L;
                paramMap.aHZ();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new cv();
            paramMap.kR(str2);
            paramMap.kS(paramString2);
            paramMap.dRm = 1L;
            paramMap.dRn = 1L;
            paramMap.dRo = 1L;
            paramMap.aHZ();
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
    com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(paramString1, paramString2), true).commit();
    AppMethodBeat.o(90738);
  }
  
  private void startChattingUI(String paramString)
  {
    AppMethodBeat.i(90732);
    ac.i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    com.tencent.mm.br.d.e(com.tencent.mm.sdk.platformtools.ai.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(90732);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90725);
    if (paramg.ahL())
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.b.class, this.uFw);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.f.class, this.uFx);
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
    if (paramg.ahL()) {
      pin(com.tencent.mm.plugin.w.a.dxh());
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
    boolean bool = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), true);
    AppMethodBeat.o(90736);
    return bool;
  }
  
  public void markFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90735);
    com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), false).commit();
    AppMethodBeat.o(90735);
  }
  
  public void onAccountInitialized(com.tencent.mm.kernel.e.c paramc)
  {
    AppMethodBeat.i(90727);
    paramc = this.uFx;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.uHx);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_plain", this.uFz);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_succeed_contact", this.uFA);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_jump_chat", this.uFB);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_live", this.uFK);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("comment_link_profile", this.uFL);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_plain", this.uFC);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_succeed_contact", this.uFD);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_jump_chat", this.uFE);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_revoke", this.uFF);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_revoke_qrcode", this.uFG);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("link_profile", this.uFH);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).a("new_link_succeed_contact", this.uFI);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.c.class, this.uFv);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("secmsg", this.uFJ);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("pat", this.uFv.uGg);
    com.tencent.mm.kernel.g.agi().a(853, this);
    com.tencent.mm.kernel.g.agi().a(849, this.uFv);
    this.uFy.uHE = new com.tencent.mm.plugin.messenger.e.a();
    AppMethodBeat.o(90727);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90728);
    Object localObject = this.uFx;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("sysmsgtemplate", ((com.tencent.mm.plugin.messenger.d.a)localObject).uHx);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akI("link_plain");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akI("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akI("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akI("link_live");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akI("comment_link_profile");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akJ("link_plain");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akJ("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akJ("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akJ("link_revoke");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akJ("link_revoke_qrcode");
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akJ("link_profile");
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.messenger.a.c.class);
    ((com.tencent.mm.plugin.messenger.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.f.class)).akJ("new_link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("secmsg", this.uFJ);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("pat", this.uFv.uGg);
    com.tencent.mm.kernel.g.agi().b(853, this);
    com.tencent.mm.kernel.g.agi().b(849, this.uFv);
    localObject = this.uFy;
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).uHE != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).uHE.release();
    }
    AppMethodBeat.o(90728);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(90731);
    try
    {
      if (com.tencent.mm.sdk.a.b.eUk()) {
        t.makeText(com.tencent.mm.sdk.platformtools.ai.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramn.getType() == 853)
      {
        if (this.fts != null)
        {
          this.fts.dismiss();
          this.fts = null;
        }
        if (paramn.equals(this.uFu))
        {
          paramString = (com.tencent.mm.openim.b.q)paramn;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.iod, paramString.ion);
            startChattingUI(paramString.iod);
          }
          ac.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.iod + " ticket: " + paramString.iom + " talkerUsername: " + paramString.ion);
        }
      }
      AppMethodBeat.o(90731);
      return;
    }
    catch (Throwable paramString)
    {
      ac.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(90731);
    }
  }
  
  public void showSwitchContactDialog(final Context paramContext, final String paramString1, String paramString2, final String paramString3, final String paramString4, final String paramString5, String paramString6, String paramString7, final String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(90733);
    com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(paramContext);
    SwitchContactDialogCustomView localSwitchContactDialogCustomView = new SwitchContactDialogCustomView(paramContext);
    if (bs.isNullOrNil(paramString9)) {
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
          AppMethodBeat.i(198562);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramString3);
          paramAnonymousView.putExtra(com.tencent.mm.ui.e.c.HgZ, paramString5);
          com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
          AppMethodBeat.o(198562);
        }
      });
      paramString2 = paramString10;
      if (bs.isNullOrNil(paramString10)) {
        paramString2 = paramContext.getString(2131761816);
      }
      paramString5 = paramString11;
      if (bs.isNullOrNil(paramString11)) {
        paramString5 = paramContext.getString(2131761818);
      }
      locala.gK(localSwitchContactDialogCustomView).aRU(paramString5).aRV(paramString2).a(new f.c()new f.c
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(198563);
          paramAnonymousString = new cv();
          paramAnonymousString.kR(paramString1);
          paramAnonymousString.kS(paramString8);
          paramAnonymousString.dRm = 1L;
          paramAnonymousString.dRn = 1L;
          paramAnonymousString.dRp = 1L;
          paramAnonymousString.aHZ();
          AppMethodBeat.o(198563);
        }
      }, new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(198565);
          if ((paramAnonymousBoolean) && (com.tencent.mm.storage.ai.aNc(paramString3)))
          {
            paramAnonymousString = new cv();
            paramAnonymousString.kR(paramString1);
            paramAnonymousString.dRm = 1L;
            paramAnonymousString.kS(paramString8);
            paramAnonymousString.dRn = 1L;
            paramAnonymousString.dRp = 2L;
            paramAnonymousString.aHZ();
            PluginMessenger.access$202(PluginMessenger.this, new com.tencent.mm.openim.b.q(paramString3, paramString4));
            PluginMessenger.this.uFu.ion = paramString8;
            com.tencent.mm.kernel.g.agi().a(PluginMessenger.this.uFu, 0);
            paramAnonymousString = PluginMessenger.this;
            Context localContext = paramContext;
            paramContext.getString(2131755906);
            PluginMessenger.access$302(paramAnonymousString, com.tencent.mm.ui.base.h.b(localContext, paramContext.getString(2131761820), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(198564);
                com.tencent.mm.kernel.g.agi().a(PluginMessenger.this.uFu);
                AppMethodBeat.o(198564);
              }
            }));
          }
          AppMethodBeat.o(198565);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger
 * JD-Core Version:    0.7.0.1
 */