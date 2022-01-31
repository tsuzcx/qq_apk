package com.tencent.mm.plugin.messenger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.b.b.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ai.f, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.c
{
  private ProgressDialog eeN;
  private e.b oCA;
  private e.b oCB;
  private e.b oCC;
  private com.tencent.mm.plugin.messenger.a.e.a oCD;
  private com.tencent.mm.plugin.messenger.a.e.a oCE;
  private com.tencent.mm.plugin.messenger.a.e.a oCF;
  private com.tencent.mm.plugin.messenger.a.e.a oCG;
  private com.tencent.mm.plugin.messenger.a.e.a oCH;
  private com.tencent.mm.plugin.messenger.a.e.a oCI;
  private com.tencent.mm.plugin.messenger.foundation.a.o oCJ;
  private q oCx;
  a oCy;
  private com.tencent.mm.plugin.messenger.b.a oCz;
  
  public PluginMessenger()
  {
    AppMethodBeat.i(136891);
    this.eeN = null;
    this.oCy = new a();
    this.oCz = new com.tencent.mm.plugin.messenger.b.a();
    this.oCA = new PluginMessenger.1(this);
    this.oCB = new PluginMessenger.6(this);
    this.oCC = new PluginMessenger.7(this);
    this.oCD = new PluginMessenger.8(this);
    this.oCE = new PluginMessenger.9(this);
    this.oCF = new PluginMessenger.10(this);
    this.oCG = new PluginMessenger.11(this);
    this.oCH = new PluginMessenger.12(this);
    this.oCI = new PluginMessenger.13(this);
    this.oCJ = new PluginMessenger.2(this);
    AppMethodBeat.o(136891);
  }
  
  private CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(136900);
    SpannableString localSpannableString = new SpannableString("");
    if (paramArrayList == null)
    {
      AppMethodBeat.o(136900);
      return localSpannableString;
    }
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(136900);
    return paramArrayList;
  }
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136904);
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, "");
    paramString1 = "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(136904);
    return paramString1;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136907);
    String str = (String)com.tencent.mm.kernel.g.RL().Ru().get(2, "");
    paramString1 = "switch_contact_prefs_" + paramString1 + "_" + paramString2 + "_" + str;
    AppMethodBeat.o(136907);
    return paramString1;
  }
  
  private boolean isSwitchContact(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136909);
    boolean bool = ah.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(paramString1, paramString2), false);
    AppMethodBeat.o(136909);
    return bool;
  }
  
  private CharSequence nullAsNil(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(136899);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(136899);
      return paramCharSequence;
    }
    AppMethodBeat.o(136899);
    return paramCharSequence;
  }
  
  private void resolvedSucceedContactText(Map<String, String> paramMap, String paramString1, Bundle paramBundle, WeakReference<Context> paramWeakReference, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(136892);
    String str2;
    int j;
    String str3;
    Object localObject2;
    String str4;
    String str5;
    Object localObject3;
    ArrayList localArrayList;
    b.a locala;
    try
    {
      str2 = bo.bf(paramBundle.getString("local_session"), "");
      if ((paramWeakReference == null) || (paramWeakReference.get() == null)) {
        break label1053;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.$type");
      j = bo.apV((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
      if (!"tmpl_type_succeed_contact_window".equals(paramBundle)) {
        break label1053;
      }
      paramBundle = (String)paramMap.get(paramString1 + ".window_template.template");
      str3 = (String)paramMap.get(paramString1 + ".window_template.tp_username");
      localObject1 = (String)paramMap.get(paramString1 + ".window_template.headimgurl");
      if ((!bo.isNullOrNil((String)localObject1)) && (com.tencent.mm.ah.o.adg().rj(str3) == null))
      {
        localObject2 = new h();
        ((h)localObject2).username = str3;
        ((h)localObject2).fsk = ((String)localObject1);
        ((h)localObject2).dqB = 3;
        ((h)localObject2).cM(false);
        com.tencent.mm.ah.o.adg().b((h)localObject2);
      }
      if ((paramBoolean) && (isSwitchContact(str3, paramString2)))
      {
        startChattingUI(str3);
        AppMethodBeat.o(136892);
        return;
      }
      str4 = (String)paramMap.get(paramString1 + ".window_template.ticket");
      str5 = (String)paramMap.get(paramString1 + ".window_template.antispam_ticket");
      localObject2 = "";
      localObject3 = "";
      paramBundle = com.tencent.mm.plugin.messenger.b.b.TQ(paramBundle);
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label1053;
      }
      localArrayList = new ArrayList();
      Iterator localIterator = paramBundle.iterator();
      do
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label805;
          }
          locala = (b.a)localIterator.next();
          if ((locala != null) && (locala.content != null))
          {
            if (locala.type != 0) {
              break;
            }
            localArrayList.add(new SpannableString(j.b(ah.getContext(), locala.content)));
          }
        }
      } while (locala.type != 1);
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(136892);
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
        if (bo.isNullOrNil((String)paramMap.get(str1))) {
          break;
        }
        localObject3 = (String)paramMap.get(str1 + ".$name");
        String str6 = (String)paramMap.get(str1 + ".$type");
        if ((locala.content.equals(localObject3)) && ("link_plain".equals(str6))) {
          localArrayList.add(nullAsNil((CharSequence)paramMap.get(str1 + ".plain")));
        }
        localObject2 = localObject1;
        if ("company".equals(localObject3))
        {
          localObject2 = localObject1;
          if ("link_userdescid".equals(str6)) {
            localObject2 = nullAsNil((CharSequence)paramMap.get(str1 + ".userdesc")).toString();
          }
        }
        if (("nickname".equals(localObject3)) && ("link_plain".equals(str6)))
        {
          paramBundle = nullAsNil((CharSequence)paramMap.get(str1 + ".plain")).toString();
          break label1065;
          label805:
          if (paramBoolean)
          {
            if (j == 1)
            {
              paramMap = new x();
              paramMap.fs(str2);
              paramMap.ft(paramString2);
              paramMap.cTL = 1L;
              paramMap.cTM = 1L;
              paramMap.cTN = 3L;
              paramMap.ake();
            }
            for (;;)
            {
              showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2);
              AppMethodBeat.o(136892);
              return;
              if (j == 0)
              {
                paramMap = new x();
                paramMap.fs(str2);
                paramMap.ft(paramString2);
                paramMap.cTL = 1L;
                paramMap.cTM = 1L;
                paramMap.cTN = 2L;
                paramMap.ake();
              }
            }
          }
          if (isFirstSwitchContactTips(str3, paramString2))
          {
            markFirstSwitchContactTips(str3, paramString2);
            paramMap = new x();
            paramMap.fs(str2);
            paramMap.ft(paramString2);
            paramMap.cTL = 1L;
            paramMap.cTM = 1L;
            paramMap.cTN = 1L;
            paramMap.ake();
            showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2);
          }
          label1053:
          AppMethodBeat.o(136892);
          return;
        }
        break label1065;
      }
      label1065:
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  private void saveSwitchContact(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136908);
    ah.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(paramString1, paramString2), true).commit();
    AppMethodBeat.o(136908);
  }
  
  private void startChattingUI(String paramString)
  {
    AppMethodBeat.i(136902);
    ab.i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(paramString)));
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    d.f(ah.getContext(), ".ui.chatting.ChattingUI", localIntent);
    AppMethodBeat.o(136902);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(136895);
    if (paramg.SD())
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.b.class, this.oCy);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.a.e.class, this.oCz);
    }
    AppMethodBeat.o(136895);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(136894);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(136894);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(136896);
    if (paramg.SD()) {
      pin(com.tencent.mm.plugin.v.a.cgF());
    }
    AppMethodBeat.o(136896);
  }
  
  public void installed()
  {
    AppMethodBeat.i(136893);
    alias(com.tencent.mm.plugin.messenger.a.c.class);
    AppMethodBeat.o(136893);
  }
  
  public boolean isFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136906);
    boolean bool = ah.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), true);
    AppMethodBeat.o(136906);
    return bool;
  }
  
  public void markFirstSwitchContactTips(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136905);
    ah.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), false).commit();
    AppMethodBeat.o(136905);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(136897);
    paramc = this.oCz;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.oEf);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.oCA);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.oCB);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.oCC);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.oCD);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.oCE);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.oCF);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke", this.oCG);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_qrcode", this.oCH);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).a("link_profile", this.oCI);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("secmsg", this.oCJ);
    com.tencent.mm.kernel.g.Rc().a(853, this);
    AppMethodBeat.o(136897);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.plugin.messenger.b.a locala = this.oCz;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("sysmsgtemplate", locala.oEf);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SM("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SM("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SM("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SN("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SN("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SN("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SN("link_revoke");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SN("link_revoke_qrcode");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.e.class)).SN("link_profile");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("secmsg", this.oCJ);
    com.tencent.mm.kernel.g.Rc().b(853, this);
    AppMethodBeat.o(136898);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(136901);
    try
    {
      if (com.tencent.mm.sdk.a.b.dsf()) {
        t.makeText(ah.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramm.getType() == 853)
      {
        if (this.eeN != null)
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        if (paramm.equals(this.oCx))
        {
          paramString = (q)paramm;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.gfL, paramString.gfV);
            startChattingUI(paramString.gfL);
          }
          ab.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.gfL + " ticket: " + paramString.gfU + " talkerUsername: " + paramString.gfV);
        }
      }
      AppMethodBeat.o(136901);
      return;
    }
    catch (Throwable paramString)
    {
      ab.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(136901);
    }
  }
  
  public void showSwitchContactDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(136903);
    com.tencent.mm.ui.widget.b.e.a locala = new com.tencent.mm.ui.widget.b.e.a(paramContext);
    SwitchContactDialogCustomView localSwitchContactDialogCustomView = new SwitchContactDialogCustomView(paramContext);
    localSwitchContactDialogCustomView.setTilte(paramContext.getString(2131302034));
    localSwitchContactDialogCustomView.setContent(paramString2);
    localSwitchContactDialogCustomView.setDesc(paramString6);
    localSwitchContactDialogCustomView.setSubDesc("@".concat(String.valueOf(paramString7)));
    localSwitchContactDialogCustomView.setPhoto(paramString3);
    localSwitchContactDialogCustomView.setOnPhotoOnClick(new PluginMessenger.3(this, paramString3, paramString5, paramContext));
    paramString2 = locala.fv(localSwitchContactDialogCustomView).Rm(2131302033);
    paramString2.AHt = paramContext.getString(2131302031);
    paramString2.a(new PluginMessenger.4(this, paramString1, paramString8), new PluginMessenger.5(this, paramString3, paramString1, paramString8, paramString4, paramContext)).show();
    AppMethodBeat.o(136903);
  }
  
  public String toString()
  {
    return "plugin-messenger";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger
 * JD-Core Version:    0.7.0.1
 */