package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.b;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class ExdeviceDeviceProfileUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private String cPk;
  private p fSP;
  private String mDeviceType;
  private String qir;
  private String qis;
  private long qjA;
  private String qnW;
  private String qoB;
  private String qoC;
  private p qpG = null;
  private int qpz;
  private String qqC;
  private String qqD;
  private boolean qqE;
  private String qqF;
  private boolean qqG;
  private String qqH;
  private h.b qqI;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(24023);
    String str;
    if (bu.isNullOrNil(this.qoB))
    {
      str = this.qir;
      if (bu.isNullOrNil(this.qqD)) {
        break label98;
      }
      paramDeviceProfileHeaderPreference.setName(this.qqD);
      paramDeviceProfileHeaderPreference.adD(getString(2131758531, new Object[] { str }));
      paramDeviceProfileHeaderPreference.ac(3, true);
      paramDeviceProfileHeaderPreference.ac(4, true);
      paramDeviceProfileHeaderPreference.ac(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.uc(this.qnW);
      AppMethodBeat.o(24023);
      return;
      str = this.qoB;
      break;
      label98:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.adD("");
      paramDeviceProfileHeaderPreference.ac(3, false);
      paramDeviceProfileHeaderPreference.ac(4, false);
      paramDeviceProfileHeaderPreference.ac(1, this.qqE);
    }
  }
  
  private void cnq()
  {
    AppMethodBeat.i(24028);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24004);
        if ((ExdeviceDeviceProfileUI.g(ExdeviceDeviceProfileUI.this) != null) && (ExdeviceDeviceProfileUI.g(ExdeviceDeviceProfileUI.this).isShowing())) {
          ExdeviceDeviceProfileUI.g(ExdeviceDeviceProfileUI.this).dismiss();
        }
        if ((ExdeviceDeviceProfileUI.h(ExdeviceDeviceProfileUI.this) != null) && (ExdeviceDeviceProfileUI.h(ExdeviceDeviceProfileUI.this).isShowing())) {
          ExdeviceDeviceProfileUI.h(ExdeviceDeviceProfileUI.this).dismiss();
        }
        AppMethodBeat.o(24004);
      }
    });
    AppMethodBeat.o(24028);
  }
  
  private void cnw()
  {
    AppMethodBeat.i(24022);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.aXe("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758538), "", "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24014);
      }
    });
    ((DeviceProfileHeaderPreference)localObject).a(4, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24015);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758538), ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this), "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24015);
      }
    });
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).setIconUrl(this.qqF);
    localObject = (KeyValuePreference)localf.aXe("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.aXe("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.aXe("user_list");
    ((KeyValuePreference)localObject).xN(true);
    localKeyValuePreference1.xN(true);
    localKeyValuePreference2.xN(true);
    localf.cT("message_manage", true);
    localf.cT("connect_setting", true);
    localf.cT("user_list", true);
    if (this.qqG)
    {
      localf.cT("sub_device_desc", false);
      localf.aXe("sub_device_desc").setTitle(getResources().getString(2131758613, new Object[] { this.qqH }));
      localf.cT("bind_device", true);
      localf.cT("unbind_device", true);
      if (bu.isNullOrNil(this.qqC)) {
        localf.cT("open_device_panel", true);
      }
      AppMethodBeat.o(24022);
      return;
    }
    localf.cT("sub_device_desc", true);
    localf.cT("bind_device", this.qqE);
    if (!this.qqE) {}
    for (boolean bool = true;; bool = false)
    {
      localf.cT("unbind_device", bool);
      break;
    }
  }
  
  private void cnx()
  {
    AppMethodBeat.i(24029);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24005);
        h.c(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758479), ExdeviceDeviceProfileUI.this.getString(2131755906), true);
        AppMethodBeat.o(24005);
      }
    });
    AppMethodBeat.o(24029);
  }
  
  private void cny()
  {
    AppMethodBeat.i(24030);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24008);
        ExdeviceDeviceProfileUI localExdeviceDeviceProfileUI = ExdeviceDeviceProfileUI.this;
        ExdeviceDeviceProfileUI.this.getString(2131755906);
        new com.tencent.mm.sdk.platformtools.aw(new aw.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(24007);
            ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24006);
                ExdeviceDeviceProfileUI.4.1.this.qqK.dismiss();
                AppMethodBeat.o(24006);
              }
            });
            AppMethodBeat.o(24007);
            return true;
          }
        }, false).ay(1000L, 1000L);
        AppMethodBeat.o(24008);
      }
    });
    AppMethodBeat.o(24030);
  }
  
  private void f(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(24027);
    if (paramb != null)
    {
      this.qis = paramb.field_deviceID;
      this.mDeviceType = paramb.field_deviceType;
      this.qqD = bu.nullAsNil(paramb.fhy);
      this.qoB = bu.nullAsNil(paramb.fhz);
      this.qir = bu.nullAsNil(paramb.field_brandName);
      this.qnW = bu.nullAsNil(paramb.fhA);
      this.qqF = bu.nullAsNil(paramb.iconUrl);
      this.qqC = bu.nullAsNil(paramb.jumpUrl);
    }
    AppMethodBeat.o(24027);
  }
  
  private void h(final n paramn)
  {
    AppMethodBeat.i(24031);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24010);
        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, h.b(ExdeviceDeviceProfileUI.this.getContext(), ExdeviceDeviceProfileUI.this.getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(24009);
            bc.ajj().a(ExdeviceDeviceProfileUI.5.this.djA);
            AppMethodBeat.o(24009);
          }
        }));
        AppMethodBeat.o(24010);
      }
    });
    AppMethodBeat.o(24031);
  }
  
  public int getResourceId()
  {
    return 2131951670;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(24021);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(24003);
        ExdeviceDeviceProfileUI.this.finish();
        AppMethodBeat.o(24003);
        return false;
      }
    });
    setMMTitle(2131758487);
    setActionbarColor(getContext().getResources().getColor(2131101179));
    this.qqI = new h.b()
    {
      public final boolean onFinish(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(24013);
        ae.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[] { paramAnonymousCharSequence });
        String str = "";
        if (paramAnonymousCharSequence != null) {
          str = paramAnonymousCharSequence.toString();
        }
        if (ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this))
        {
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, str);
          ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(24012);
              ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aXe("device_profile_header"));
              AppMethodBeat.o(24012);
            }
          });
          paramAnonymousCharSequence = ad.cmJ().fI(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this));
          if (paramAnonymousCharSequence == null)
          {
            ae.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this) });
            AppMethodBeat.o(24013);
            return false;
          }
          paramAnonymousCharSequence.tl(ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this));
          ad.cmJ().update(paramAnonymousCharSequence, new String[0]);
        }
        for (;;)
        {
          AppMethodBeat.o(24013);
          return true;
          paramAnonymousCharSequence = new y(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this), str);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, paramAnonymousCharSequence);
          bc.ajj().a(1263, ExdeviceDeviceProfileUI.this);
          bc.ajj().a(paramAnonymousCharSequence, 0);
        }
      }
    };
    paramBundle = getIntent();
    this.cPk = paramBundle.getStringExtra("device_mac");
    this.qjA = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.qqC = paramBundle.getStringExtra("device_jump_url");
    this.qir = paramBundle.getStringExtra("device_brand_name");
    this.qis = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.qoC = paramBundle.getStringExtra("bind_ticket");
    this.qpz = paramBundle.getIntExtra("subscribe_flag", 0);
    this.qqE = paramBundle.getBooleanExtra("device_has_bound", false);
    this.qoB = paramBundle.getStringExtra("device_title");
    this.qqD = paramBundle.getStringExtra("device_alias");
    this.qnW = paramBundle.getStringExtra("device_desc");
    this.qqF = paramBundle.getStringExtra("device_icon_url");
    if ((bu.isNullOrNil(this.qis)) || (bu.isNullOrNil(this.mDeviceType))) {
      ae.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.qis, this.mDeviceType });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), 2131758546, 1).show();
      finish();
      AppMethodBeat.o(24021);
      return;
      paramBundle = ad.cmJ().fI(this.qis, this.mDeviceType);
      if (paramBundle != null)
      {
        this.qqE = true;
        if (bu.isNullOrNil(this.qqD)) {
          this.qqD = bu.nullAsNil(paramBundle.fhy);
        }
        if (bu.isNullOrNil(this.qoB)) {
          this.qoB = bu.nullAsNil(paramBundle.fhz);
        }
        if (bu.isNullOrNil(this.qir)) {
          this.qir = bu.nullAsNil(paramBundle.field_brandName);
        }
        if (bu.isNullOrNil(this.qnW)) {
          this.qnW = bu.nullAsNil(paramBundle.fhA);
        }
        if (bu.isNullOrNil(this.qqF)) {
          this.qqF = bu.nullAsNil(paramBundle.iconUrl);
        }
        if (bu.isNullOrNil(this.qqC)) {
          this.qqC = bu.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.fhC == 2)
        {
          this.qqG = true;
          this.qqH = this.qoB;
          paramBundle = ad.cmJ().cno().iterator();
          com.tencent.mm.plugin.exdevice.i.b localb;
          do
          {
            do
            {
              if (!paramBundle.hasNext()) {
                break;
              }
              localb = (com.tencent.mm.plugin.exdevice.i.b)paramBundle.next();
            } while (!localb.field_deviceType.equals(this.mDeviceType));
            localObject = localb.fhH;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.qis)) {
              if (!bu.isNullOrNil(localb.fhy)) {
                break label601;
              }
            }
          }
          label601:
          for (this.qqH = localb.fhz;; this.qqH = localb.fhy)
          {
            ae.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.qqH });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (bu.isNullOrNil(this.qoC)) {
          continue;
        }
      }
      i = 1;
    }
    cnw();
    AppMethodBeat.o(24021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24026);
    bc.ajj().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(24026);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24024);
    ae.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (bu.isNullOrNil(this.qoC))
      {
        ae.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new com.tencent.mm.plugin.exdevice.model.m(com.tencent.mm.plugin.exdevice.k.b.adP(this.cPk), this.qir, "3", this.qjA);
        h(paramf);
        bc.ajj().a(1262, this);
        bc.ajj().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(24024);
        return true;
        ae.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.qoC;
        int i = this.qpz;
        bc.ajj().a(536, this);
        paramPreference = new do();
        paramPreference.dps.dpu = paramf;
        paramPreference.dps.opType = 1;
        paramPreference.dps.dpv = i;
        com.tencent.mm.sdk.b.a.IvT.l(paramPreference);
        paramf = paramPreference.dpt.dpw;
        getString(2131755906);
        this.qpG = h.b(this, getString(2131758490), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(24016);
            bc.ajj().b(536, ExdeviceDeviceProfileUI.this);
            paramAnonymousDialogInterface = new do();
            paramAnonymousDialogInterface.dps.opType = 2;
            paramAnonymousDialogInterface.dps.dpw = paramf;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
            AppMethodBeat.o(24016);
          }
        });
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new bob();
          paramf.nIM = this.qis;
          paramf.FSh = this.mDeviceType;
          paramPreference = ad.cmJ().fI(this.qis, this.mDeviceType);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.fhH;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                ad.cmJ().fK(paramPreference[i], this.mDeviceType);
                i += 1;
              }
            }
          }
          paramf = new x(paramf, 2);
          h(paramf);
          bc.ajj().a(537, this);
          bc.ajj().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.ap(getContext(), this.qqC);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          bc.aCg();
          paramf = com.tencent.mm.model.c.azF().BH(this.qir);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.qis);
          paramPreference.putExtra("device_type", this.mDeviceType);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.qoC);
          if (paramf != null) {
            if ((com.tencent.mm.contact.c.lO(paramf.field_type)) && (paramf.fug()))
            {
              ag.aGp().Ef(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.qir);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.qgs.d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.qir);
              paramPreference.putExtra("force_get_contact", true);
              d.b(getContext(), "profile", ".ui.ContactInfoUI", paramPreference);
            }
          }
        }
      }
    } while (("message_manage".equals(paramPreference.mKey)) || ("connect_setting".equals(paramPreference.mKey)) || ("user_list".equals(paramPreference.mKey)));
    AppMethodBeat.o(24024);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(24025);
    ae.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ae.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
      AppMethodBeat.o(24025);
      return;
    }
    ae.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if ((paramn instanceof l))
    {
      cnq();
      bc.ajj().b(paramn.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        cnx();
        AppMethodBeat.o(24025);
        return;
      }
      cny();
      f(ad.cmJ().fI(this.qis, this.mDeviceType));
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24017);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, true);
          ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
          ExdeviceDeviceProfileUI.this.getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(24017);
        }
      });
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.exdevice.model.m))
    {
      cnq();
      bc.ajj().b(paramn.getType(), this);
      com.tencent.mm.plugin.exdevice.i.b localb = ad.cmJ().ve(com.tencent.mm.plugin.exdevice.k.b.adP(this.cPk));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        ae.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        cnx();
        AppMethodBeat.o(24025);
        return;
      }
      f(localb);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24018);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, true);
          ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
          ExdeviceDeviceProfileUI.this.getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(24018);
        }
      });
      cny();
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof y))
    {
      cnq();
      bc.ajj().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        Toast.makeText(getContext(), getString(2131758536), 1).show();
        AppMethodBeat.o(24025);
        return;
      }
      this.qqD = ((y)paramn).fhy;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24019);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aXe("device_profile_header"));
          AppMethodBeat.o(24019);
        }
      });
      paramString = ad.cmJ().fI(this.qis, this.mDeviceType);
      if (paramString == null)
      {
        ae.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.qis, this.mDeviceType });
        AppMethodBeat.o(24025);
        return;
      }
      paramString.tl(this.qqD);
      ad.cmJ().update(paramString, new String[0]);
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof x))
    {
      cnq();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24011);
            Toast.makeText(ExdeviceDeviceProfileUI.this.getContext(), 2131758616, 1).show();
            AppMethodBeat.o(24011);
          }
        });
        AppMethodBeat.o(24025);
        return;
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24020);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, null);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, false);
          ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
          ExdeviceDeviceProfileUI.this.getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(24020);
        }
      });
      finish();
    }
    AppMethodBeat.o(24025);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */