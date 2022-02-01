package com.tencent.mm.plugin.downloader_app.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.plugin.downloader_app.e.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public final class a
  implements com.tencent.mm.pluginsdk.c.a
{
  private as contact;
  Context context;
  private boolean enable;
  private com.tencent.mm.ui.base.preference.f screen;
  private CheckBoxPreference uoE;
  private CheckBoxPreference uoF;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  final void D(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(9096);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(e.h.settings_plugins_installing);; localObject = paramContext.getString(e.h.settings_plugins_uninstalling))
    {
      paramContext.getString(e.h.app_tip);
      localObject = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9092);
          boolean bool = paramBoolean;
          int i = z.bdn();
          dlm localdlm;
          if (bool)
          {
            i &= 0xF7FFFFFF;
            com.tencent.mm.kernel.h.aHG().aHp().i(34, Integer.valueOf(i));
            localdlm = new dlm();
            localdlm.RFu = 134217728;
            if (!bool) {
              break label154;
            }
          }
          label154:
          for (i = 0;; i = 1)
          {
            localdlm.TSy = i;
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(39, localdlm));
            if (!paramBoolean)
            {
              bq.RQ("downloaderapp");
              ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv("downloaderapp");
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9091);
                a.this.cQY();
                a.5.this.ucb.dismiss();
                if (a.5.this.uoH)
                {
                  ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).cQu();
                  Bundle localBundle = ((Activity)a.5.this.val$context).getIntent().getBundleExtra("download_params");
                  if (localBundle != null) {
                    ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(a.5.this.val$context, new Intent().putExtras(localBundle), null);
                  }
                }
                AppMethodBeat.o(9091);
              }
            }, 1000L);
            AppMethodBeat.o(9092);
            return;
            i |= 0x8000000;
            break;
          }
        }
      });
      AppMethodBeat.o(9096);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(9093);
    this.screen = paramf;
    this.contact = paramas;
    paramf.auC(e.i.ulz);
    this.uoE = ((CheckBoxPreference)paramf.byG("contact_info_top_downloader"));
    this.uoF = ((CheckBoxPreference)paramf.byG("contact_info_not_disturb"));
    cQY();
    AppMethodBeat.o(9093);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(9094);
    if ("contact_info_go_to_downloader".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.by.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_manager".equals(paramString))
    {
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.context, null, null);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_common_problem".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("KPublisherId", "custom_menu");
      paramString.putExtra("pre_username", this.contact.field_username);
      paramString.putExtra("prePublishId", "custom_menu");
      paramString.putExtra("preUsername", this.contact.field_username);
      paramString.putExtra("preChatName", this.contact.field_username);
      paramString.putExtra("preChatTYPE", ac.aN(this.contact.field_username, this.contact.field_username));
      paramString.putExtra("rawUrl", "https://" + WeChatHosts.domainString(e.h.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
      paramString.putExtra("geta8key_username", this.contact.field_username);
      paramString.putExtra("from_scence", 1);
      com.tencent.mm.by.c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_top_downloader".equals(paramString))
    {
      if (this.uoE.isChecked()) {
        ab.G(this.contact.field_username, true);
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        ab.H(this.contact.field_username, true);
      }
    }
    if ("contact_info_not_disturb".equals(paramString))
    {
      if (this.uoF.isChecked()) {
        ab.F(this.contact);
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        ab.G(this.contact);
      }
    }
    if ("contact_info_clear_data".equals(paramString))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(e.h.contact_info_clear_data), "", this.context.getString(e.h.app_clear), this.context.getString(e.h.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(9087);
          bq.RQ("downloaderapp");
          AppMethodBeat.o(9087);
        }
      }, null);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_install".equals(paramString))
    {
      D(this.context, true);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_uninstall".equals(paramString))
    {
      if (((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).cQt()) {
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(e.h.ula), this.context.getString(e.h.ulb), this.context.getString(e.h.ukZ), this.context.getString(e.h.ukW), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9088);
            com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class);
            a.this.D(a.this.context, false);
            AppMethodBeat.o(9088);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9089);
            ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(a.this.context, null, null);
            AppMethodBeat.o(9089);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        com.tencent.mm.ui.base.h.c(this.context, this.context.getString(e.h.settings_plugins_uninstall_hint), "", this.context.getString(e.h.app_clear), this.context.getString(e.h.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9090);
            com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader_app.api.c.class);
            a.this.D(a.this.context, false);
            AppMethodBeat.o(9090);
          }
        }, null);
      }
    }
    AppMethodBeat.o(9094);
    return false;
  }
  
  public final boolean cQX()
  {
    return true;
  }
  
  final void cQY()
  {
    AppMethodBeat.i(9095);
    Object localObject = (HelperHeaderPreference)this.screen.byG("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bf(this.contact.field_username, this.contact.ays(), this.context.getString(e.h.ukV));
    this.enable = z.bdG();
    int i;
    boolean bool;
    if (this.enable)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.dz("contact_info_downloader_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label320;
      }
      bool = true;
      label102:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_downloader_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label325;
      }
      bool = true;
      label127:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_go_to_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label330;
      }
      bool = true;
      label151:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_downloader_manager", bool);
      this.screen.dz("contact_info_common_problem", true);
      localObject = this.screen;
      if (this.enable) {
        break label335;
      }
      bool = true;
      label188:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_top_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label340;
      }
      bool = true;
      label212:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_not_disturb", bool);
      localObject = this.screen;
      if (this.enable) {
        break label345;
      }
      bool = true;
      label236:
      ((com.tencent.mm.ui.base.preference.f)localObject).dz("contact_info_clear_data", bool);
      if (!this.enable) {
        break label369;
      }
      if (!((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(this.contact.field_username)) {
        break label350;
      }
      this.uoE.setChecked(true);
    }
    for (;;)
    {
      if (!this.contact.aeg()) {
        break label361;
      }
      this.uoF.setChecked(true);
      AppMethodBeat.o(9095);
      return;
      i = 0;
      break;
      label320:
      bool = false;
      break label102;
      label325:
      bool = false;
      break label127;
      label330:
      bool = false;
      break label151;
      label335:
      bool = false;
      break label188;
      label340:
      bool = false;
      break label212;
      label345:
      bool = false;
      break label236;
      label350:
      this.uoE.setChecked(false);
    }
    label361:
    this.uoF.setChecked(false);
    label369:
    AppMethodBeat.o(9095);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.a
 * JD-Core Version:    0.7.0.1
 */