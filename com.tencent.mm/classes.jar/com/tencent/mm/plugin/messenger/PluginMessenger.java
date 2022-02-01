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
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.al.f, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.c
{
  private ProgressDialog fMu;
  private e.b vIA;
  private e.a vIB;
  private e.a vIC;
  private e.a vID;
  private e.a vIE;
  private e.a vIF;
  private e.a vIG;
  private e.a vIH;
  private e.a vII;
  private e.a vIJ;
  private com.tencent.mm.plugin.messenger.foundation.a.q vIK;
  private e.b vIL;
  private e.b vIM;
  private e.b vIN;
  private com.tencent.mm.openim.b.q vIu;
  a vIv;
  private com.tencent.mm.plugin.messenger.d.a vIw;
  private com.tencent.mm.plugin.messenger.d.d vIx;
  private e.b vIy;
  private e.b vIz;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(90721);
    this.fMu = null;
    this.vIv = new a();
    this.vIw = new com.tencent.mm.plugin.messenger.d.a();
    this.vIx = new com.tencent.mm.plugin.messenger.d.d();
    this.vIy = new PluginMessenger.1(this);
    this.vIz = new e.b() {};
    this.vIA = new PluginMessenger.14(this);
    this.vIB = new PluginMessenger.15(this);
    this.vIC = new PluginMessenger.16(this);
    this.vID = new PluginMessenger.17(this);
    this.vIE = new PluginMessenger.18(this);
    this.vIF = new PluginMessenger.19(this);
    this.vIG = new PluginMessenger.20(this);
    this.vIH = new PluginMessenger.2(this);
    this.vII = new PluginMessenger.3(this);
    this.vIJ = new PluginMessenger.4(this);
    this.vIK = new PluginMessenger.5(this);
    this.vIL = new PluginMessenger.6(this);
    this.vIM = new PluginMessenger.7(this);
    this.vIN = new PluginMessenger.8(this);
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
    AppMethodBeat.i(211836);
    if (!com.tencent.mm.vfs.i.fv("wcf://selectrecord/")) {
      com.tencent.mm.vfs.i.aYg("wcf://selectrecord/");
    }
    AppMethodBeat.o(211836);
    return "wcf://selectrecord/";
  }
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90734);
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(90734);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90737);
    String str = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, "");
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
      str2 = bt.bI(paramBundle.getString("local_session"), "");
      if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.$type");
      j = bt.aRe((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
      if (!"tmpl_type_succeed_contact_window".equals(paramBundle)) {
        break label1163;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.template");
      str3 = (String)paramMap.get(paramString1 + ".window_template.tp_username");
      localObject1 = (String)paramMap.get(paramString1 + ".window_template.headimgurl");
      if ((!bt.isNullOrNil((String)localObject1)) && (p.aEx().Dj(str3) == null))
      {
        localObject2 = new com.tencent.mm.ak.i();
        ((com.tencent.mm.ak.i)localObject2).username = str3;
        ((com.tencent.mm.ak.i)localObject2).hMW = ((String)localObject1);
        ((com.tencent.mm.ak.i)localObject2).ePj = 3;
        ((com.tencent.mm.ak.i)localObject2).eB(false);
        p.aEx().b((com.tencent.mm.ak.i)localObject2);
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
      paramBundle = com.tencent.mm.plugin.messenger.d.c.aqD(paramBundle);
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
            localArrayList.add(new SpannableString(k.c(aj.getContext(), locala.content)));
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
              paramMap = new do();
              paramMap.mU(str2);
              paramMap.mV(paramString2);
              paramMap.egJ = 1L;
              paramMap.egK = 1L;
              paramMap.egL = 3L;
              paramMap.aLk();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2, str6, str7, str8);
              AppMethodBeat.o(90722);
              return;
              if (j == 0)
              {
                paramMap = new do();
                paramMap.mU(str2);
                paramMap.mV(paramString2);
                paramMap.egJ = 1L;
                paramMap.egK = 1L;
                paramMap.egL = 2L;
                paramMap.aLk();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new do();
            paramMap.mU(str2);
            paramMap.mV(paramString2);
            paramMap.egJ = 1L;
            paramMap.egK = 1L;
            paramMap.egL = 1L;
            paramMap.aLk();
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
    com.tencent.mm.bs.d.f(aj.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(90732);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(90725);
    if (paramg.akw())
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.b.class, this.vIv);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.e.class, this.vIw);
      o.an("selectrecord", "selectrecord", 3);
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
    if (paramg.akw()) {
      pin(com.tencent.mm.plugin.x.a.dIz());
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
    paramc = this.vIw;
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.vKA);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.vIy);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.vIz);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.vIA);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_live", this.vIL);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("comment_link_profile", this.vIM);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.vIN);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.vIB);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.vIC);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.vID);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke", this.vIE);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_qrcode", this.vIF);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_profile", this.vIG);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("new_link_succeed_contact", this.vIH);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", this.vIF);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_url", this.vII);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_history", this.vIJ);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("secmsg", this.vIK);
    com.tencent.mm.kernel.g.aiU().a(853, this);
    paramc = this.vIx;
    paramc.vKH = new com.tencent.mm.plugin.messenger.e.a();
    paramc.vKI = new com.tencent.mm.plugin.messenger.e.c();
    paramc.vKJ = new com.tencent.mm.plugin.messenger.e.b();
    new ap().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211830);
        int i = ((l)com.tencent.mm.kernel.g.ab(l.class)).azr().dlQ();
        int j = ((l)com.tencent.mm.kernel.g.ab(l.class)).azr().dlR();
        com.tencent.mm.plugin.report.service.g.yhR.f(20460, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(211830);
      }
    }, 60000L);
    AppMethodBeat.o(90727);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(90728);
    Object localObject = this.vIw;
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("sysmsgtemplate", ((com.tencent.mm.plugin.messenger.d.a)localObject).vKA);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apu("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apu("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apu("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apu("link_live");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apu("comment_link_profile");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apu("link_url");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_revoke");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_revoke_qrcode");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_profile");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("new_link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_revoke_unbindapp");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_url");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.e.class)).apv("link_history");
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("secmsg", this.vIK);
    com.tencent.mm.kernel.g.aiU().b(853, this);
    localObject = this.vIx;
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).vKH != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).vKH.release();
    }
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).vKI != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).vKI.release();
    }
    if (((com.tencent.mm.plugin.messenger.d.d)localObject).vKJ != null) {
      ((com.tencent.mm.plugin.messenger.d.d)localObject).vKJ.release();
    }
    AppMethodBeat.o(90728);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(90731);
    try
    {
      if (com.tencent.mm.sdk.a.b.fjN()) {
        t.makeText(aj.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramn.getType() == 853)
      {
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
        }
        if (paramn.equals(this.vIu))
        {
          paramString = (com.tencent.mm.openim.b.q)paramn;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.iHA, paramString.iHK);
            startChattingUI(paramString.iHA);
          }
          ad.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.iHA + " ticket: " + paramString.iHJ + " talkerUsername: " + paramString.iHK);
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
  
  public void showSwitchContactDialog(final Context paramContext, final String paramString1, String paramString2, final String paramString3, final String paramString4, final String paramString5, String paramString6, String paramString7, final String paramString8, String paramString9, String paramString10, String paramString11)
  {
    AppMethodBeat.i(90733);
    f.a locala = new f.a(paramContext);
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
          AppMethodBeat.i(211831);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramString3);
          paramAnonymousView.putExtra(com.tencent.mm.ui.e.c.IUp, paramString5);
          com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", paramAnonymousView, 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/messenger/PluginMessenger$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(211831);
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
      locala.hb(localSwitchContactDialogCustomView).aXS(paramString5).aXT(paramString2).a(new f.c()new f.c
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(211832);
          paramAnonymousString = new do();
          paramAnonymousString.mU(paramString1);
          paramAnonymousString.mV(paramString8);
          paramAnonymousString.egJ = 1L;
          paramAnonymousString.egK = 1L;
          paramAnonymousString.egM = 1L;
          paramAnonymousString.aLk();
          AppMethodBeat.o(211832);
        }
      }, new f.c()
      {
        public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(211834);
          if ((paramAnonymousBoolean) && (am.aSQ(paramString3)))
          {
            paramAnonymousString = new do();
            paramAnonymousString.mU(paramString1);
            paramAnonymousString.egJ = 1L;
            paramAnonymousString.mV(paramString8);
            paramAnonymousString.egK = 1L;
            paramAnonymousString.egM = 2L;
            paramAnonymousString.aLk();
            PluginMessenger.access$202(PluginMessenger.this, new com.tencent.mm.openim.b.q(paramString3, paramString4, 0));
            PluginMessenger.this.vIu.iHK = paramString8;
            com.tencent.mm.kernel.g.aiU().a(PluginMessenger.this.vIu, 0);
            paramAnonymousString = PluginMessenger.this;
            Context localContext = paramContext;
            paramContext.getString(2131755906);
            PluginMessenger.access$302(paramAnonymousString, h.b(localContext, paramContext.getString(2131761820), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(90709);
                com.tencent.mm.kernel.g.aiU().a(PluginMessenger.this.vIu);
                AppMethodBeat.o(90709);
              }
            }));
          }
          AppMethodBeat.o(211834);
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