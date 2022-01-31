package com.tencent.mm.plugin.downloader_app.d;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a
{
  private boolean bIU;
  Context context;
  private f dnn;
  private ad dnp;
  private CheckBoxPreference iUg;
  private CheckBoxPreference iUh;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    this.dnn = paramf;
    this.dnp = paramad;
    paramf.addPreferencesFromResource(b.i.contact_info_pref_downloader);
    this.iUg = ((CheckBoxPreference)paramf.add("contact_info_top_downloader"));
    this.iUh = ((CheckBoxPreference)paramf.add("contact_info_not_disturb"));
    awY();
    return true;
  }
  
  final void awY()
  {
    Object localObject = (HelperHeaderPreference)this.dnn.add("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).al(this.dnp.field_username, this.dnp.Bq(), this.context.getString(b.h.downloader_contact_info_downloader_tips));
    this.bIU = q.GK();
    int i;
    boolean bool;
    if (this.bIU)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).ov(i);
      this.dnn.bJ("contact_info_downloader_install", this.bIU);
      localObject = this.dnn;
      if (this.bIU) {
        break label296;
      }
      bool = true;
      label93:
      ((f)localObject).bJ("contact_info_downloader_uninstall", bool);
      localObject = this.dnn;
      if (this.bIU) {
        break label301;
      }
      bool = true;
      label116:
      ((f)localObject).bJ("contact_info_go_to_downloader", bool);
      localObject = this.dnn;
      if (this.bIU) {
        break label306;
      }
      bool = true;
      label139:
      ((f)localObject).bJ("contact_info_downloader_manager", bool);
      this.dnn.bJ("contact_info_common_problem", true);
      localObject = this.dnn;
      if (this.bIU) {
        break label311;
      }
      bool = true;
      label174:
      ((f)localObject).bJ("contact_info_top_downloader", bool);
      localObject = this.dnn;
      if (this.bIU) {
        break label316;
      }
      bool = true;
      label197:
      ((f)localObject).bJ("contact_info_not_disturb", bool);
      localObject = this.dnn;
      if (this.bIU) {
        break label321;
      }
      bool = true;
      label220:
      ((f)localObject).bJ("contact_info_clear_data", bool);
      if (this.bIU) {
        if (!((j)g.r(j.class)).FB().abD(this.dnp.field_username)) {
          break label326;
        }
      }
    }
    label296:
    label301:
    label306:
    label311:
    label316:
    label321:
    label326:
    for (this.iUg.rHo = true;; this.iUg.rHo = false)
    {
      if (!this.dnp.Bj()) {
        break label337;
      }
      this.iUh.rHo = true;
      return;
      i = 0;
      break;
      bool = false;
      break label93;
      bool = false;
      break label116;
      bool = false;
      break label139;
      bool = false;
      break label174;
      bool = false;
      break label197;
      bool = false;
      break label220;
    }
    label337:
    this.iUh.rHo = false;
  }
  
  public final boolean awZ()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void p(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(b.h.settings_plugins_installing);; localObject = paramContext.getString(b.h.settings_plugins_uninstalling))
    {
      paramContext.getString(b.h.app_tip);
      localObject = h.b(paramContext, (String)localObject, true, null);
      g.DS().O(new a.5(this, paramBoolean, (ProgressDialog)localObject, paramContext));
      return;
    }
  }
  
  public final boolean xQ(String paramString)
  {
    if ("contact_info_go_to_downloader".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.dnp.field_username);
      paramString.putExtra("finish_direct", true);
      d.e(this.context, ".ui.chatting.ChattingUI", paramString);
      return true;
    }
    if ("contact_info_downloader_manager".equals(paramString))
    {
      ((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).a(this.context, null, null);
      return true;
    }
    if ("contact_info_common_problem".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("KPublisherId", "custom_menu");
      paramString.putExtra("pre_username", this.dnp.field_username);
      paramString.putExtra("prePublishId", "custom_menu");
      paramString.putExtra("preUsername", this.dnp.field_username);
      paramString.putExtra("preChatName", this.dnp.field_username);
      paramString.putExtra("preChatTYPE", t.R(this.dnp.field_username, this.dnp.field_username));
      paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
      paramString.putExtra("geta8key_username", this.dnp.field_username);
      paramString.putExtra("from_scence", 1);
      d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
      return true;
    }
    if ("contact_info_top_downloader".equals(paramString))
    {
      if (this.iUg.isChecked()) {
        s.t(this.dnp.field_username, true);
      }
      for (;;)
      {
        return true;
        s.u(this.dnp.field_username, true);
      }
    }
    if ("contact_info_not_disturb".equals(paramString))
    {
      if (this.iUh.isChecked()) {
        s.o(this.dnp);
      }
      for (;;)
      {
        return true;
        s.p(this.dnp);
      }
    }
    if ("contact_info_clear_data".equals(paramString))
    {
      h.a(this.context, this.context.getString(b.h.contact_info_clear_data), "", this.context.getString(b.h.app_clear), this.context.getString(b.h.app_cancel), new a.1(this), null);
      return true;
    }
    if ("contact_info_downloader_install".equals(paramString))
    {
      p(this.context, true);
      return true;
    }
    if ("contact_info_downloader_uninstall".equals(paramString))
    {
      if (((com.tencent.mm.plugin.downloader_app.a.a)g.r(com.tencent.mm.plugin.downloader_app.a.a.class)).aGb()) {
        h.a(this.context, this.context.getString(b.h.downloaderapp_stop_plugin_msg), this.context.getString(b.h.downloaderapp_stop_plugin_title), this.context.getString(b.h.downloaderapp_stop_plugin), this.context.getString(b.h.downloaderapp_check_download_task), new a.2(this), new a.3(this));
      }
      for (;;)
      {
        return true;
        h.a(this.context, this.context.getString(b.h.settings_plugins_uninstall_hint), "", this.context.getString(b.h.app_clear), this.context.getString(b.h.app_cancel), new a.4(this), null);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.a
 * JD-Core Version:    0.7.0.1
 */