package com.tencent.mm.plugin.downloader_app.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a
  implements com.tencent.mm.pluginsdk.b.a
{
  private am contact;
  Context context;
  private boolean enable;
  private CheckBoxPreference pru;
  private CheckBoxPreference prv;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final boolean a(f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(9093);
    this.screen = paramf;
    this.contact = paramam;
    paramf.addPreferencesFromResource(2131951638);
    this.pru = ((CheckBoxPreference)paramf.aVD("contact_info_top_downloader"));
    this.prv = ((CheckBoxPreference)paramf.aVD("contact_info_not_disturb"));
    cdo();
    AppMethodBeat.o(9093);
    return true;
  }
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(9094);
    if ("contact_info_go_to_downloader".equals(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("Chat_User", this.contact.field_username);
      paramString.putExtra("finish_direct", true);
      d.f(this.context, ".ui.chatting.ChattingUI", paramString);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_manager".equals(paramString))
    {
      ((c)g.ab(c.class)).a(this.context, null, null);
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
      paramString.putExtra("preChatTYPE", x.aG(this.contact.field_username, this.contact.field_username));
      paramString.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
      paramString.putExtra("geta8key_username", this.contact.field_username);
      paramString.putExtra("from_scence", 1);
      d.b(this.context, "webview", ".ui.tools.WebViewUI", paramString);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_top_downloader".equals(paramString))
    {
      if (this.pru.isChecked()) {
        w.D(this.contact.field_username, true);
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        w.E(this.contact.field_username, true);
      }
    }
    if ("contact_info_not_disturb".equals(paramString))
    {
      if (this.prv.isChecked()) {
        w.s(this.contact);
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        w.t(this.contact);
      }
    }
    if ("contact_info_clear_data".equals(paramString))
    {
      h.e(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(9087);
          bj.Bp("downloaderapp");
          AppMethodBeat.o(9087);
        }
      }, null);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_install".equals(paramString))
    {
      x(this.context, true);
      AppMethodBeat.o(9094);
      return true;
    }
    if ("contact_info_downloader_uninstall".equals(paramString))
    {
      if (((c)g.ab(c.class)).ccE()) {
        h.e(this.context, this.context.getString(2131758149), this.context.getString(2131758150), this.context.getString(2131758148), this.context.getString(2131758134), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9088);
            g.ab(c.class);
            a.this.x(a.this.context, false);
            AppMethodBeat.o(9088);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9089);
            ((c)g.ab(c.class)).a(a.this.context, null, null);
            AppMethodBeat.o(9089);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(9094);
        return true;
        h.e(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(9090);
            g.ab(c.class);
            a.this.x(a.this.context, false);
            AppMethodBeat.o(9090);
          }
        }, null);
      }
    }
    AppMethodBeat.o(9094);
    return false;
  }
  
  public final boolean cdn()
  {
    return true;
  }
  
  final void cdo()
  {
    AppMethodBeat.i(9095);
    Object localObject = (HelperHeaderPreference)this.screen.aVD("contact_info_header_helper");
    ((HelperHeaderPreference)localObject).aZ(this.contact.field_username, this.contact.adv(), this.context.getString(2131758128));
    this.enable = u.aAR();
    int i;
    boolean bool;
    if (this.enable)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cP("contact_info_downloader_install", this.enable);
      localObject = this.screen;
      if (this.enable) {
        break label316;
      }
      bool = true;
      label99:
      ((f)localObject).cP("contact_info_downloader_uninstall", bool);
      localObject = this.screen;
      if (this.enable) {
        break label321;
      }
      bool = true;
      label123:
      ((f)localObject).cP("contact_info_go_to_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label326;
      }
      bool = true;
      label147:
      ((f)localObject).cP("contact_info_downloader_manager", bool);
      this.screen.cP("contact_info_common_problem", true);
      localObject = this.screen;
      if (this.enable) {
        break label331;
      }
      bool = true;
      label184:
      ((f)localObject).cP("contact_info_top_downloader", bool);
      localObject = this.screen;
      if (this.enable) {
        break label336;
      }
      bool = true;
      label208:
      ((f)localObject).cP("contact_info_not_disturb", bool);
      localObject = this.screen;
      if (this.enable) {
        break label341;
      }
      bool = true;
      label232:
      ((f)localObject).cP("contact_info_clear_data", bool);
      if (!this.enable) {
        break label365;
      }
      if (!((l)g.ab(l.class)).azv().aTH(this.contact.field_username)) {
        break label346;
      }
    }
    label316:
    label321:
    label326:
    label331:
    label336:
    label341:
    label346:
    for (this.pru.oB = true;; this.pru.oB = false)
    {
      if (!this.contact.Pf()) {
        break label357;
      }
      this.prv.oB = true;
      AppMethodBeat.o(9095);
      return;
      i = 0;
      break;
      bool = false;
      break label99;
      bool = false;
      break label123;
      bool = false;
      break label147;
      bool = false;
      break label184;
      bool = false;
      break label208;
      bool = false;
      break label232;
    }
    label357:
    this.prv.oB = false;
    label365:
    AppMethodBeat.o(9095);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void x(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(9096);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      localObject = h.b(paramContext, (String)localObject, true, null);
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9092);
          boolean bool = paramBoolean;
          int i = u.aAy();
          cks localcks;
          if (bool)
          {
            i &= 0xF7FFFFFF;
            g.ajC().ajl().set(34, Integer.valueOf(i));
            localcks = new cks();
            localcks.Fsi = 134217728;
            if (!bool) {
              break label154;
            }
          }
          label154:
          for (i = 0;; i = 1)
          {
            localcks.Heh = i;
            ((l)g.ab(l.class)).azo().c(new k.a(39, localcks));
            if (!paramBoolean)
            {
              bj.Bp("downloaderapp");
              ((l)g.ab(l.class)).azv().aTx("downloaderapp");
            }
            aq.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(9091);
                a.this.cdo();
                a.5.this.pgO.dismiss();
                if (a.5.this.prx)
                {
                  ((c)g.ab(c.class)).ccF();
                  Bundle localBundle = ((Activity)a.5.this.val$context).getIntent().getBundleExtra("download_params");
                  if (localBundle != null) {
                    ((c)g.ab(c.class)).a(a.5.this.val$context, new Intent().putExtras(localBundle), null);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.d.a
 * JD-Core Version:    0.7.0.1
 */