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
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.b.b.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ah.f, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.messenger.a.c
{
  private ProgressDialog dnm = null;
  private com.tencent.mm.openim.b.p mbW;
  a mbX = new a();
  private com.tencent.mm.plugin.messenger.b.a mbY = new com.tencent.mm.plugin.messenger.b.a();
  private e.b mbZ = new PluginMessenger.1(this);
  private e.b mca = new PluginMessenger.5(this);
  private e.b mcb = new PluginMessenger.6(this);
  private com.tencent.mm.plugin.messenger.a.e.a mcc = new PluginMessenger.7(this);
  private com.tencent.mm.plugin.messenger.a.e.a mcd = new PluginMessenger.8(this);
  private com.tencent.mm.plugin.messenger.a.e.a mce = new PluginMessenger.9(this);
  private com.tencent.mm.plugin.messenger.a.e.a mcf = new PluginMessenger.10(this);
  private com.tencent.mm.plugin.messenger.a.e.a mcg = new PluginMessenger.11(this);
  private com.tencent.mm.plugin.messenger.a.e.a mch = new PluginMessenger.12(this);
  
  private CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    SpannableString localSpannableString = new SpannableString("");
    if (paramArrayList == null) {
      return localSpannableString;
    }
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    return paramArrayList;
  }
  
  private String getFirstSwitchContactTipsPrefsKey(String paramString1, String paramString2)
  {
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, "");
    return "FirstSwitchContactTips_" + paramString1 + "_" + paramString2 + "_" + str;
  }
  
  private String getSwitchContactPrefsKey(String paramString1, String paramString2)
  {
    String str = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, "");
    return "switch_contact_prefs_" + paramString1 + "_" + paramString2 + "_" + str;
  }
  
  private boolean isSwitchContact(String paramString1, String paramString2)
  {
    return ae.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(paramString1, paramString2), false);
  }
  
  private CharSequence nullAsNil(CharSequence paramCharSequence)
  {
    Object localObject;
    if (paramCharSequence != null)
    {
      localObject = paramCharSequence;
      if (paramCharSequence.length() != 0) {}
    }
    else
    {
      localObject = new SpannableString("");
    }
    return localObject;
  }
  
  private void resolvedSucceedContactText(Map<String, String> paramMap, String paramString1, Bundle paramBundle, WeakReference<Context> paramWeakReference, String paramString2, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        String str2 = bk.aM(paramBundle.getString("local_session"), "");
        if ((paramWeakReference != null) && (paramWeakReference.get() != null))
        {
          paramBundle = (String)paramMap.get(paramString1 + ".window_template.$type");
          int j = bk.ZR((String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
          if ("tmpl_type_succeed_contact_window".equals(paramBundle))
          {
            paramBundle = (String)paramMap.get(paramString1 + ".window_template.template");
            String str3 = (String)paramMap.get(paramString1 + ".window_template.tp_username");
            localObject1 = (String)paramMap.get(paramString1 + ".window_template.headimgurl");
            if ((!bk.bl((String)localObject1)) && (com.tencent.mm.ag.o.Kh().kp(str3) == null))
            {
              localObject2 = new h();
              ((h)localObject2).username = str3;
              ((h)localObject2).ebS = ((String)localObject1);
              ((h)localObject2).cCq = 3;
              ((h)localObject2).bK(false);
              com.tencent.mm.ag.o.Kh().a((h)localObject2);
            }
            if ((paramBoolean) && (isSwitchContact(str3, paramString2)))
            {
              startChattingUI(str3);
              return;
            }
            String str4 = (String)paramMap.get(paramString1 + ".window_template.ticket");
            String str5 = (String)paramMap.get(paramString1 + ".window_template.antispam_ticket");
            localObject2 = "";
            Object localObject3 = "";
            paramBundle = com.tencent.mm.plugin.messenger.b.b.Ig(paramBundle);
            if ((paramBundle != null) && (paramBundle.size() > 0))
            {
              ArrayList localArrayList = new ArrayList();
              Iterator localIterator = paramBundle.iterator();
              if (localIterator.hasNext())
              {
                b.a locala = (b.a)localIterator.next();
                if ((locala == null) || (locala.content == null)) {
                  continue;
                }
                if (locala.type == 0)
                {
                  localArrayList.add(new SpannableString(j.b(ae.getContext(), locala.content)));
                  continue;
                }
                if (locala.type != 1) {
                  continue;
                }
                i = 0;
                localObject1 = localObject2;
                paramBundle = (Bundle)localObject3;
                String str1 = paramString1 + ".window_template.link_list.link";
                if (i == 0) {
                  continue;
                }
                str1 = str1 + i;
                localObject3 = paramBundle;
                localObject2 = localObject1;
                if (bk.bl((String)paramMap.get(str1))) {
                  continue;
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
                  break label1032;
                }
              }
              else
              {
                if (paramBoolean)
                {
                  if (j == 1)
                  {
                    paramMap = new com.tencent.mm.h.b.a.o();
                    paramMap.cja = str2;
                    paramMap.cjb = paramString2;
                    paramMap.cjc = 1L;
                    paramMap.cjd = 1L;
                    paramMap.cje = 3L;
                    paramMap.QX();
                    showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2);
                    return;
                  }
                  if (j != 0) {
                    continue;
                  }
                  paramMap = new com.tencent.mm.h.b.a.o();
                  paramMap.cja = str2;
                  paramMap.cjb = paramString2;
                  paramMap.cjc = 1L;
                  paramMap.cjd = 1L;
                  paramMap.cje = 2L;
                  paramMap.QX();
                  continue;
                }
                if (!isFirstSwitchContactTips(str3, paramString2)) {
                  continue;
                }
                markFirstSwitchContactTips(str3, paramString2);
                paramMap = new com.tencent.mm.h.b.a.o();
                paramMap.cja = str2;
                paramMap.cjb = paramString2;
                paramMap.cjc = 1L;
                paramMap.cjd = 1L;
                paramMap.cje = 1L;
                paramMap.QX();
                showSwitchContactDialog((Context)paramWeakReference.get(), str2, concactSpannable(localArrayList).toString(), str3, str4, str5, (String)localObject3, (String)localObject2, paramString2);
                return;
              }
              break label1032;
              continue;
            }
          }
        }
        return;
      }
      catch (Throwable paramMap)
      {
        return;
      }
      label1032:
      i += 1;
      Object localObject1 = localObject2;
    }
  }
  
  private void saveSwitchContact(String paramString1, String paramString2)
  {
    ae.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(paramString1, paramString2), true).commit();
  }
  
  private void startChattingUI(String paramString)
  {
    y.i("MicroMsg.PluginMessenger", "startChattingUI userName: " + paramString);
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("Chat_Mode", 1);
    d.e(ae.getContext(), ".ui.chatting.ChattingUI", localIntent);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.a.b.class, this.mbX);
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.a.e.class, this.mbY);
    }
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      pin(com.tencent.mm.plugin.ae.a.bvQ());
    }
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.messenger.a.c.class);
  }
  
  public boolean isFirstSwitchContactTips(String paramString1, String paramString2)
  {
    return ae.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), true);
  }
  
  public void markFirstSwitchContactTips(String paramString1, String paramString2)
  {
    ae.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(paramString1, paramString2), false).commit();
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    paramc = this.mbY;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("sysmsgtemplate", paramc.mdJ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.mbZ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.mca);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.mcb);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.mcc);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.mcd);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.mce);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke", this.mcf);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_qrcode", this.mcg);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).a("link_profile", this.mch);
    com.tencent.mm.kernel.g.Dk().a(853, this);
  }
  
  public void onAccountRelease()
  {
    com.tencent.mm.plugin.messenger.b.a locala = this.mbY;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("sysmsgtemplate", locala.mdJ);
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hb("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hb("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hb("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hc("link_plain");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hc("link_succeed_contact");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hc("link_jump_chat");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hc("link_revoke");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hc("link_revoke_qrcode");
    ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.e.class)).Hc("link_profile");
    com.tencent.mm.kernel.g.Dk().b(853, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    try
    {
      if (com.tencent.mm.sdk.a.b.cqk()) {
        s.makeText(ae.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
      }
      if (paramm.getType() == 853)
      {
        if (this.dnm != null)
        {
          this.dnm.dismiss();
          this.dnm = null;
        }
        if (paramm.equals(this.mbW))
        {
          paramString = (com.tencent.mm.openim.b.p)paramm;
          if (paramInt2 == 0)
          {
            saveSwitchContact(paramString.ePQ, paramString.eQa);
            startChattingUI(paramString.ePQ);
          }
          y.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + paramInt2 + " errType: " + paramInt1 + " userName: " + paramString.ePQ + " ticket: " + paramString.ePZ + " talkerUsername: " + paramString.eQa);
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      y.e("MicroMsg.PluginMessenger", "onSceneEnd " + paramString);
    }
  }
  
  public void showSwitchContactDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    com.tencent.mm.ui.widget.a.e.a locala = new com.tencent.mm.ui.widget.a.e.a(paramContext);
    SwitchContactDialogCustomView localSwitchContactDialogCustomView = new SwitchContactDialogCustomView(paramContext);
    localSwitchContactDialogCustomView.setTilte(paramContext.getString(b.c.openim_switch_user_title));
    localSwitchContactDialogCustomView.setContent(paramString2);
    localSwitchContactDialogCustomView.setDesc(paramString6);
    localSwitchContactDialogCustomView.setSubDesc("@" + paramString7);
    localSwitchContactDialogCustomView.setPhoto(paramString3);
    localSwitchContactDialogCustomView.setOnPhotoOnClick(new PluginMessenger.2(this, paramString3, paramString5, paramContext));
    paramString2 = locala.ek(localSwitchContactDialogCustomView).Iu(b.c.openim_switch_user);
    paramString2.wnw = paramContext.getString(b.c.openim_not_do);
    paramString2.a(new PluginMessenger.3(this, paramString1, paramString8), new PluginMessenger.4(this, paramString3, paramString1, paramString8, paramString4, paramContext)).show();
  }
  
  public String toString()
  {
    return "plugin-messenger";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger
 * JD-Core Version:    0.7.0.1
 */