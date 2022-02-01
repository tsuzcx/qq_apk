package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, n.b
{
  private af contact;
  Context context;
  private Map<String, Preference> iqs;
  private f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(26378);
    this.iqs = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(26378);
  }
  
  private void bRv()
  {
    boolean bool2 = true;
    AppMethodBeat.i(26382);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.aKk("contact_info_masssend_header_helper");
    ((HelperHeaderPreference)localObject).aO(this.contact.field_username, this.contact.ZX(), this.context.getString(2131757722));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.cE("contact_info_masssend_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label168;
      }
      bool1 = true;
      label97:
      ((f)localObject).cE("contact_info_masssend_view", bool1);
      localObject = this.screen;
      if (bool3) {
        break label173;
      }
      bool1 = true;
      label121:
      ((f)localObject).cE("contact_info_masssend_clear_data", bool1);
      localObject = this.screen;
      if (bool3) {
        break label178;
      }
    }
    label168:
    label173:
    label178:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((f)localObject).cE("contact_info_masssend_uninstall", bool1);
      AppMethodBeat.o(26382);
      return;
      i = 0;
      break;
      bool1 = false;
      break label97;
      bool1 = false;
      break label121;
    }
  }
  
  public static void clearData()
  {
    AppMethodBeat.i(26384);
    b localb = com.tencent.mm.plugin.masssend.a.h.cNS();
    if (localb.gPa.execSQL("massendinfo", "delete from massendinfo")) {
      localb.doNotify();
    }
    az.arV();
    c.apR().aIl("masssendapp");
    AppMethodBeat.o(26384);
  }
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(26380);
    if ((u.aqS() & 0x10000) == 0)
    {
      AppMethodBeat.o(26380);
      return true;
    }
    AppMethodBeat.o(26380);
    return false;
  }
  
  public static void w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(26383);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131763362);; localObject = paramContext.getString(2131763370))
    {
      paramContext.getString(2131755906);
      paramContext = com.tencent.mm.ui.base.h.b(paramContext, (String)localObject, true, null);
      localObject = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(26376);
          int i = u.aqS();
          if (this.okp) {
            i &= 0xFFFEFFFF;
          }
          for (;;)
          {
            az.arV();
            c.afk().set(34, Integer.valueOf(i));
            az.arV();
            c.apL().c(new com.tencent.mm.bb.k("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.okp) {
              a.clearData();
            }
            if (this.tvY != null) {
              this.tvY.a(null, null);
            }
            AppMethodBeat.o(26376);
            return;
            i |= 0x10000;
          }
        }
      };
      new Timer().schedule(new TimerTask()
      {
        public final void run()
        {
          AppMethodBeat.i(26377);
          if (this.tvZ != null)
          {
            this.tvZ.dismiss();
            this.ssV.sendEmptyMessage(0);
          }
          AppMethodBeat.o(26377);
        }
      }, 1500L);
      AppMethodBeat.o(26383);
      return;
    }
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(26379);
    ad.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (bt.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(26379);
      return false;
    }
    if (paramString.equals("contact_info_masssend_view"))
    {
      Object localObject = new Intent(this.context, MassSendHistoryUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/masssend/ui/ContactWidgetMassSend", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/masssend/ui/ContactWidgetMassSend", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26379);
      return true;
    }
    if (paramString.equals("contact_info_masssend_clear_data"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131757630), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26374);
          a.clearData();
          AppMethodBeat.o(26374);
        }
      }, null);
      AppMethodBeat.o(26379);
      return true;
    }
    if (paramString.equals("contact_info_masssend_install"))
    {
      w(this.context, true);
      AppMethodBeat.o(26379);
      return true;
    }
    if (paramString.equals("contact_info_masssend_uninstall"))
    {
      com.tencent.mm.ui.base.h.d(this.context, this.context.getString(2131763366), "", this.context.getString(2131755694), this.context.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26375);
          a.w(a.this.context, false);
          AppMethodBeat.o(26375);
        }
      }, null);
      AppMethodBeat.o(26379);
      return true;
    }
    ad.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(26379);
    return false;
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(26386);
    int i = bt.i(paramObject, 0);
    ad.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    az.arV();
    if ((paramn != c.afk()) || (i <= 0))
    {
      ad.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(26386);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(26386);
      return;
    }
    bRv();
    AppMethodBeat.o(26386);
  }
  
  public final boolean a(f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(26381);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramaf != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(w.sN(paramaf.field_username));
      az.arV();
      c.afk().a(this);
      this.contact = paramaf;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951645);
      bRv();
      AppMethodBeat.o(26381);
      return true;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(26385);
    az.arV();
    c.afk().b(this);
    com.tencent.mm.plugin.masssend.a.hYu.Ll();
    AppMethodBeat.o(26385);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a
 * JD-Core Version:    0.7.0.1
 */