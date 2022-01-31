package com.tencent.mm.plugin.downloader_app.e;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a
{
  private ad contact;
  Context context;
  private boolean enable;
  private CheckBoxPreference ldj;
  private CheckBoxPreference ldk;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(136323);
    if ("contact_info_go_to_downloader".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.bq.d.f(this.context, ".ui.chatting.ChattingUI", paramString);
      AppMethodBeat.o(136323);
      return true;
    }
    if ("contact_info_downloader_manager".equals(paramString))
    {
      ((com.tencent.mm.plugin.downloader_app.a.d)g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).a(this.context, null, null);
      AppMethodBeat.o(136323);
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
      paramString.putExtra("preChatTYPE", u.ah(this.contact.field_username, this.contact.field_username));
      paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
      paramString.putExtra("geta8key_username", this.contact.field_username);
      paramString.putExtra("from_scence", 1);
      com.tencent.mm.bq.d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(136323);
      return true;
    }
    if ("contact_info_top_downloader".equals(paramString))
    {
      if (this.ldj.isChecked()) {
        t.x(this.contact.field_username, true);
      }
      for (;;)
      {
        AppMethodBeat.o(136323);
        return true;
        t.y(this.contact.field_username, true);
      }
    }
    if ("contact_info_not_disturb".equals(paramString))
    {
      if (this.ldk.isChecked()) {
        t.o(this.contact);
      }
      for (;;)
      {
        AppMethodBeat.o(136323);
        return true;
        t.p(this.contact);
      }
    }
    if ("contact_info_clear_data".equals(paramString))
    {
      h.d(this.context, this.context.getString(2131298571), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.1(this), null);
      AppMethodBeat.o(136323);
      return true;
    }
    if ("contact_info_downloader_install".equals(paramString))
    {
      s(this.context, true);
      AppMethodBeat.o(136323);
      return true;
    }
    if ("contact_info_downloader_uninstall".equals(paramString))
    {
      if (((com.tencent.mm.plugin.downloader_app.a.d)g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).bjD()) {
        h.d(this.context, this.context.getString(2131299046), this.context.getString(2131299047), this.context.getString(2131299045), this.context.getString(2131299031), new a.2(this), new a.3(this));
      }
      for (;;)
      {
        AppMethodBeat.o(136323);
        return true;
        h.d(this.context, this.context.getString(2131303384), "", this.context.getString(2131296891), this.context.getString(2131296888), new a.4(this), null);
      }
    }
    AppMethodBeat.o(136323);
    return false;
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(136322);
    this.screen = paramf;
    this.contact = paramad;
    paramf.addPreferencesFromResource(2131165204);
    this.ldj = ((CheckBoxPreference)paramf.atx("contact_info_top_downloader"));
    this.ldk = ((CheckBoxPreference)paramf.atx("contact_info_not_disturb"));
    bkc();
    AppMethodBeat.o(136322);
    return true;
  }
  
  public final boolean bkb()
  {
    return true;
  }
  
  final void bkc()
  {
    AppMethodBeat.i(136324);
    Object localObject = (HelperHeaderPreference)this.screen.atx("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aB(this.contact.field_username, this.contact.Of(), this.context.getString(2131299025));
    this.enable = r.ZO();
    int i;
    boolean bool;
    if (this.enable)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).sb(i);
      this.screen.cl("contact_info_downloader_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label306;
      }
      bool = true;
      label97:
      ((f)localObject).cl("contact_info_downloader_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label311;
      }
      bool = true;
      label120:
      ((f)localObject).cl("contact_info_go_to_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label316;
      }
      bool = true;
      label143:
      ((f)localObject).cl("contact_info_downloader_manager", bool);
      this.screen.cl("contact_info_common_problem", true);
      localObject = this.screen;
      if (this.enable) {
        break label321;
      }
      bool = true;
      label178:
      ((f)localObject).cl("contact_info_top_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label326;
      }
      bool = true;
      label201:
      ((f)localObject).cl("contact_info_not_disturb", bool);
      localObject = this.screen;
      if (this.enable) {
        break label331;
      }
      bool = true;
      label224:
      ((f)localObject).cl("contact_info_clear_data", bool);
      if (!this.enable) {
        break label355;
      }
      if (!((j)g.E(j.class)).YF().arP(this.contact.field_username)) {
        break label336;
      }
    }
    label306:
    label311:
    label316:
    label321:
    label326:
    label331:
    label336:
    for (this.ldj.vxW = true;; this.ldj.vxW = false)
    {
      if (!this.contact.DP()) {
        break label347;
      }
      this.ldk.vxW = true;
      AppMethodBeat.o(136324);
      return;
      i = 0;
      break;
      bool = false;
      break label97;
      bool = false;
      break label120;
      bool = false;
      break label143;
      bool = false;
      break label178;
      bool = false;
      break label201;
      bool = false;
      break label224;
    }
    label347:
    this.ldk.vxW = false;
    label355:
    AppMethodBeat.o(136324);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void s(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(136325);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131303380);; localObject = paramContext.getString(2131303388))
    {
      paramContext.getString(2131297087);
      localObject = h.b(paramContext, (String)localObject, true, null);
      g.RO().ac(new a.5(this, paramBoolean, (ProgressDialog)localObject, paramContext));
      AppMethodBeat.o(136325);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.e.a
 * JD-Core Version:    0.7.0.1
 */