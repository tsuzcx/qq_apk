package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.pluginsdk.b.a, MStorageEx.IOnStorageChange
{
  private as contact;
  private Context context;
  private Map<String, Preference> kkJ;
  private f screen;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(26378);
    this.kkJ = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(26378);
  }
  
  public static void C(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(26383);
    if (paramBoolean) {}
    for (Object localObject = paramContext.getString(2131765544);; localObject = paramContext.getString(2131765552))
    {
      paramContext.getString(2131755998);
      paramContext = com.tencent.mm.ui.base.h.a(paramContext, (String)localObject, true, null);
      localObject = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(26376);
          if (this.qNu) {
            a.ehH();
          }
          int i = z.aUl();
          if (this.qNu) {
            i &= 0xFFFEFFFF;
          }
          for (;;)
          {
            bg.aVF();
            c.azQ().set(34, Integer.valueOf(i));
            bg.aVF();
            c.aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.qNu) {
              a.clearData();
            }
            if (this.znB != null) {
              this.znB.onNotifyChange(null, null);
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
          if (this.qDi != null)
          {
            this.qDi.dismiss();
            this.val$handler.sendEmptyMessage(0);
          }
          AppMethodBeat.o(26377);
        }
      }, 1500L);
      AppMethodBeat.o(26383);
      return;
    }
  }
  
  private void cCt()
  {
    boolean bool2 = true;
    AppMethodBeat.i(26382);
    boolean bool3 = isOpen();
    Object localObject = (HelperHeaderPreference)this.screen.bmg("contact_info_masssend_header_helper");
    ((HelperHeaderPreference)localObject).bk(this.contact.field_username, this.contact.arJ(), this.context.getString(2131757953));
    int i;
    if (bool3)
    {
      i = 1;
      ((HelperHeaderPreference)localObject).updateStatus(i);
      this.screen.jdMethod_do("contact_info_masssend_install", bool3);
      localObject = this.screen;
      if (bool3) {
        break label168;
      }
      bool1 = true;
      label97:
      ((f)localObject).jdMethod_do("contact_info_masssend_view", bool1);
      localObject = this.screen;
      if (bool3) {
        break label173;
      }
      bool1 = true;
      label121:
      ((f)localObject).jdMethod_do("contact_info_masssend_clear_data", bool1);
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
      ((f)localObject).jdMethod_do("contact_info_masssend_uninstall", bool1);
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
    b localb = com.tencent.mm.plugin.masssend.a.h.ehF();
    if (localb.iFy.execSQL("massendinfo", "delete from massendinfo")) {
      localb.doNotify();
    }
    bg.aVF();
    c.aST().bjW("masssendapp");
    AppMethodBeat.o(26384);
  }
  
  static void ehH() {}
  
  private static boolean isOpen()
  {
    AppMethodBeat.i(26380);
    if ((z.aUl() & 0x10000) == 0)
    {
      AppMethodBeat.o(26380);
      return true;
    }
    AppMethodBeat.o(26380);
    return false;
  }
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(26381);
    if (paramf != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Assert.assertTrue(paramBoolean);
      paramBoolean = bool;
      if (paramas != null) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ab.Jc(paramas.field_username));
      bg.aVF();
      c.azQ().add(this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2132017182);
      cCt();
      AppMethodBeat.o(26381);
      return true;
    }
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(26379);
    Log.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = ".concat(String.valueOf(paramString)));
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      AppMethodBeat.o(26379);
      return false;
    }
    if (paramString.equals("contact_info_masssend_view"))
    {
      Object localObject = new Intent(this.context, MassSendHistoryUI.class);
      paramString = this.context;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/masssend/ui/ContactWidgetMassSend", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/masssend/ui/ContactWidgetMassSend", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26379);
      return true;
    }
    if (paramString.equals("contact_info_masssend_clear_data"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131757858), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
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
      C(this.context, true);
      AppMethodBeat.o(26379);
      return true;
    }
    if (paramString.equals("contact_info_masssend_uninstall"))
    {
      com.tencent.mm.ui.base.h.c(this.context, this.context.getString(2131765548), "", this.context.getString(2131755764), this.context.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26375);
          a.C(a.a(a.this), false);
          AppMethodBeat.o(26375);
        }
      }, null);
      AppMethodBeat.o(26379);
      return true;
    }
    Log.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(26379);
    return false;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(26385);
    bg.aVF();
    c.azQ().remove(this);
    com.tencent.mm.plugin.masssend.a.jRu.WZ();
    AppMethodBeat.o(26385);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(26386);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    bg.aVF();
    if ((paramMStorageEx != c.azQ()) || (i <= 0))
    {
      Log.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(26386);
      return;
    }
    if ((i != 40) && (i != 34) && (i != 7))
    {
      AppMethodBeat.o(26386);
      return;
    }
    cCt();
    AppMethodBeat.o(26386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a
 * JD-Core Version:    0.7.0.1
 */