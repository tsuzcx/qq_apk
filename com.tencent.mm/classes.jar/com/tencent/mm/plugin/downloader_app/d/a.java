package com.tencent.mm.plugin.downloader_app.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a
{
  private as contact;
  Context context;
  private boolean enable;
  private CheckBoxPreference qNr;
  private CheckBoxPreference qNs;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  final void A(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(9096);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      localObject = h.a(paramContext, (String)localObject, true, null);
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9092);
          boolean bool = paramBoolean;
          int i = z.aUl();
          dbw localdbw;
          if (bool)
          {
            i &= 0xF7FFFFFF;
            g.aAh().azQ().set(34, Integer.valueOf(i));
            localdbw = new dbw();
            localdbw.KEc = 134217728;
            if (!bool) {
              break label154;
            }
          }
          label154:
          for (i = 0;; i = 1)
          {
            localdbw.MGK = i;
            ((l)g.af(l.class)).aSM().d(new k.a(39, localdbw));
            if (!paramBoolean)
            {
              bp.Kx("downloaderapp");
              ((l)g.af(l.class)).aST().bjW("downloaderapp");
            }
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9091);
                a.this.cCt();
                a.5.this.qDa.dismiss();
                if (a.5.this.qNu)
                {
                  ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).cBQ();
                  Bundle localBundle = ((Activity)a.5.this.val$context).getIntent().getBundleExtra("download_params");
                  if (localBundle != null) {
                    ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(a.5.this.val$context, new Intent().putExtras(localBundle), null);
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
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(9093);
    this.screen = paramf;
    this.contact = paramas;
    paramf.addPreferencesFromResource(2132017175);
    this.qNr = ((CheckBoxPreference)paramf.bmg("contact_info_top_downloader"));
    this.qNs = ((CheckBoxPreference)paramf.bmg("contact_info_not_disturb"));
    cCt();
    AppMethodBeat.o(9093);
    return true;
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(9094);
    if ("contact_info_go_to_downloader".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      com.tencent.mm.br.c.f(this.context, ".ui.chatting.ChattingUI", paramString);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_manager".equals(paramString))
    {
      ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.context, null, null);
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
      paramString.putExtra("preChatTYPE", ac.aJ(this.contact.field_username, this.contact.field_username));
      paramString.putExtra("rawUrl", "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
      paramString.putExtra("geta8key_username", this.contact.field_username);
      paramString.putExtra("from_scence", 1);
      com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_top_downloader".equals(paramString))
    {
      if (this.qNr.isChecked()) {
        ab.E(this.contact.field_username, true);
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        ab.F(this.contact.field_username, true);
      }
    }
    if ("contact_info_not_disturb".equals(paramString))
    {
      if (this.qNs.isChecked()) {
        ab.z(this.contact);
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        ab.A(this.contact);
      }
    }
    if ("contact_info_clear_data".equals(paramString))
    {
      h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(9087);
          bp.Kx("downloaderapp");
          AppMethodBeat.o(9087);
        }
      }, null);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_install".equals(paramString))
    {
      A(this.context, true);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_uninstall".equals(paramString))
    {
      if (((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).cBP()) {
        h.c(this.context, this.context.getString(2131758422), this.context.getString(2131758423), this.context.getString(2131758421), this.context.getString(2131758407), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9088);
            g.af(com.tencent.mm.plugin.downloader_app.api.c.class);
            a.this.A(a.this.context, false);
            AppMethodBeat.o(9088);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9089);
            ((com.tencent.mm.plugin.downloader_app.api.c)g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(a.this.context, null, null);
            AppMethodBeat.o(9089);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9090);
            g.af(com.tencent.mm.plugin.downloader_app.api.c.class);
            a.this.A(a.this.context, false);
            AppMethodBeat.o(9090);
          }
        }, null);
      }
    }
    AppMethodBeat.o(9094);
    return false;
  }
  
  public final boolean cCs()
  {
    return true;
  }
  
  final void cCt()
  {
    AppMethodBeat.i(9095);
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131758401));
    this.enable = z.aUE();
    int i;
    boolean bool;
    if (this.enable)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.jdMethod_do("contact_info_downloader_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label319;
      }
      bool = true;
      label101:
      ((f)localObject).jdMethod_do("contact_info_downloader_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label324;
      }
      bool = true;
      label126:
      ((f)localObject).jdMethod_do("contact_info_go_to_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label329;
      }
      bool = true;
      label150:
      ((f)localObject).jdMethod_do("contact_info_downloader_manager", bool);
      this.screen.jdMethod_do("contact_info_common_problem", true);
      localObject = this.screen;
      if (this.enable) {
        break label334;
      }
      bool = true;
      label187:
      ((f)localObject).jdMethod_do("contact_info_top_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label339;
      }
      bool = true;
      label211:
      ((f)localObject).jdMethod_do("contact_info_not_disturb", bool);
      localObject = this.screen;
      if (this.enable) {
        break label344;
      }
      bool = true;
      label235:
      ((f)localObject).jdMethod_do("contact_info_clear_data", bool);
      if (!this.enable) {
        break label368;
      }
      if (!((l)g.af(l.class)).aST().bkg(this.contact.field_username)) {
        break label349;
      }
      this.qNr.setChecked(true);
    }
    for (;;)
    {
      if (!this.contact.Zx()) {
        break label360;
      }
      this.qNs.setChecked(true);
      AppMethodBeat.o(9095);
      return;
      i = 0;
      break;
      label319:
      bool = false;
      break label101;
      label324:
      bool = false;
      break label126;
      label329:
      bool = false;
      break label150;
      label334:
      bool = false;
      break label187;
      label339:
      bool = false;
      break label211;
      label344:
      bool = false;
      break label235;
      label349:
      this.qNr.setChecked(false);
    }
    label360:
    this.qNs.setChecked(false);
    label368:
    AppMethodBeat.o(9095);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.a
 * JD-Core Version:    0.7.0.1
 */