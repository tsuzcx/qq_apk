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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dk.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  implements g
{
  private String cDv;
  private p fxw;
  private String mDeviceType;
  private String pDM;
  private String pEr;
  private String pEs;
  private int pFp;
  private p pFw = null;
  private String pGs;
  private String pGt;
  private boolean pGu;
  private String pGv;
  private boolean pGw;
  private String pGx;
  private h.b pGy;
  private String pyh;
  private String pyi;
  private long pzq;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(24023);
    String str;
    if (bs.isNullOrNil(this.pEr))
    {
      str = this.pyh;
      if (bs.isNullOrNil(this.pGt)) {
        break label98;
      }
      paramDeviceProfileHeaderPreference.setName(this.pGt);
      paramDeviceProfileHeaderPreference.Zg(getString(2131758531, new Object[] { str }));
      paramDeviceProfileHeaderPreference.aa(3, true);
      paramDeviceProfileHeaderPreference.aa(4, true);
      paramDeviceProfileHeaderPreference.aa(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.qY(this.pDM);
      AppMethodBeat.o(24023);
      return;
      str = this.pEr;
      break;
      label98:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.Zg("");
      paramDeviceProfileHeaderPreference.aa(3, false);
      paramDeviceProfileHeaderPreference.aa(4, false);
      paramDeviceProfileHeaderPreference.aa(1, this.pGu);
    }
  }
  
  private void chC()
  {
    AppMethodBeat.i(24022);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.aPN("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24014);
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758538), "", "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        AppMethodBeat.o(24014);
      }
    });
    ((DeviceProfileHeaderPreference)localObject).a(4, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24015);
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758538), ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this), "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        AppMethodBeat.o(24015);
      }
    });
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).qV(this.pGv);
    localObject = (KeyValuePreference)localf.aPN("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.aPN("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.aPN("user_list");
    ((KeyValuePreference)localObject).wV(true);
    localKeyValuePreference1.wV(true);
    localKeyValuePreference2.wV(true);
    localf.cK("message_manage", true);
    localf.cK("connect_setting", true);
    localf.cK("user_list", true);
    if (this.pGw)
    {
      localf.cK("sub_device_desc", false);
      localf.aPN("sub_device_desc").setTitle(getResources().getString(2131758613, new Object[] { this.pGx }));
      localf.cK("bind_device", true);
      localf.cK("unbind_device", true);
      if (bs.isNullOrNil(this.pGs)) {
        localf.cK("open_device_panel", true);
      }
      AppMethodBeat.o(24022);
      return;
    }
    localf.cK("sub_device_desc", true);
    localf.cK("bind_device", this.pGu);
    if (!this.pGu) {}
    for (boolean bool = true;; bool = false)
    {
      localf.cK("unbind_device", bool);
      break;
    }
  }
  
  private void chD()
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
  
  private void chE()
  {
    AppMethodBeat.i(24030);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24008);
        ExdeviceDeviceProfileUI localExdeviceDeviceProfileUI = ExdeviceDeviceProfileUI.this;
        ExdeviceDeviceProfileUI.this.getString(2131755906);
        new au(new au.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(24007);
            ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24006);
                ExdeviceDeviceProfileUI.4.1.this.pGA.dismiss();
                AppMethodBeat.o(24006);
              }
            });
            AppMethodBeat.o(24007);
            return true;
          }
        }, false).au(1000L, 1000L);
        AppMethodBeat.o(24008);
      }
    });
    AppMethodBeat.o(24030);
  }
  
  private void chw()
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
  
  private void f(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(24027);
    if (paramb != null)
    {
      this.pyi = paramb.field_deviceID;
      this.mDeviceType = paramb.field_deviceType;
      this.pGt = bs.nullAsNil(paramb.eNf);
      this.pEr = bs.nullAsNil(paramb.eNg);
      this.pyh = bs.nullAsNil(paramb.field_brandName);
      this.pDM = bs.nullAsNil(paramb.eNh);
      this.pGv = bs.nullAsNil(paramb.iconUrl);
      this.pGs = bs.nullAsNil(paramb.jumpUrl);
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
            az.agi().a(ExdeviceDeviceProfileUI.5.this.cXh);
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
    this.pGy = new h.b()
    {
      public final boolean onFinish(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(24013);
        ac.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[] { paramAnonymousCharSequence });
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
              ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aPN("device_profile_header"));
              AppMethodBeat.o(24012);
            }
          });
          paramAnonymousCharSequence = ad.cgP().fu(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this));
          if (paramAnonymousCharSequence == null)
          {
            ac.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this) });
            AppMethodBeat.o(24013);
            return false;
          }
          paramAnonymousCharSequence.qg(ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this));
          ad.cgP().update(paramAnonymousCharSequence, new String[0]);
        }
        for (;;)
        {
          AppMethodBeat.o(24013);
          return true;
          paramAnonymousCharSequence = new y(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this), str);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, paramAnonymousCharSequence);
          az.agi().a(1263, ExdeviceDeviceProfileUI.this);
          az.agi().a(paramAnonymousCharSequence, 0);
        }
      }
    };
    paramBundle = getIntent();
    this.cDv = paramBundle.getStringExtra("device_mac");
    this.pzq = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.pGs = paramBundle.getStringExtra("device_jump_url");
    this.pyh = paramBundle.getStringExtra("device_brand_name");
    this.pyi = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.pEs = paramBundle.getStringExtra("bind_ticket");
    this.pFp = paramBundle.getIntExtra("subscribe_flag", 0);
    this.pGu = paramBundle.getBooleanExtra("device_has_bound", false);
    this.pEr = paramBundle.getStringExtra("device_title");
    this.pGt = paramBundle.getStringExtra("device_alias");
    this.pDM = paramBundle.getStringExtra("device_desc");
    this.pGv = paramBundle.getStringExtra("device_icon_url");
    if ((bs.isNullOrNil(this.pyi)) || (bs.isNullOrNil(this.mDeviceType))) {
      ac.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.pyi, this.mDeviceType });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), 2131758546, 1).show();
      finish();
      AppMethodBeat.o(24021);
      return;
      paramBundle = ad.cgP().fu(this.pyi, this.mDeviceType);
      if (paramBundle != null)
      {
        this.pGu = true;
        if (bs.isNullOrNil(this.pGt)) {
          this.pGt = bs.nullAsNil(paramBundle.eNf);
        }
        if (bs.isNullOrNil(this.pEr)) {
          this.pEr = bs.nullAsNil(paramBundle.eNg);
        }
        if (bs.isNullOrNil(this.pyh)) {
          this.pyh = bs.nullAsNil(paramBundle.field_brandName);
        }
        if (bs.isNullOrNil(this.pDM)) {
          this.pDM = bs.nullAsNil(paramBundle.eNh);
        }
        if (bs.isNullOrNil(this.pGv)) {
          this.pGv = bs.nullAsNil(paramBundle.iconUrl);
        }
        if (bs.isNullOrNil(this.pGs)) {
          this.pGs = bs.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.eNj == 2)
        {
          this.pGw = true;
          this.pGx = this.pEr;
          paramBundle = ad.cgP().chu().iterator();
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
            localObject = localb.eNo;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.pyi)) {
              if (!bs.isNullOrNil(localb.eNf)) {
                break label601;
              }
            }
          }
          label601:
          for (this.pGx = localb.eNg;; this.pGx = localb.eNf)
          {
            ac.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.pGx });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (bs.isNullOrNil(this.pEs)) {
          continue;
        }
      }
      i = 1;
    }
    chC();
    AppMethodBeat.o(24021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24026);
    az.agi().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(24026);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24024);
    ac.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (bs.isNullOrNil(this.pEs))
      {
        ac.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new m(com.tencent.mm.plugin.exdevice.k.b.Zs(this.cDv), this.pyh, "3", this.pzq);
        h(paramf);
        az.agi().a(1262, this);
        az.agi().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(24024);
        return true;
        ac.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.pEs;
        int i = this.pFp;
        az.agi().a(536, this);
        paramPreference = new dk();
        paramPreference.dcR.dcT = paramf;
        paramPreference.dcR.opType = 1;
        paramPreference.dcR.dcU = i;
        com.tencent.mm.sdk.b.a.GpY.l(paramPreference);
        paramf = paramPreference.dcS.dcV;
        getString(2131755906);
        this.pFw = h.b(this, getString(2131758490), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(24016);
            az.agi().b(536, ExdeviceDeviceProfileUI.this);
            paramAnonymousDialogInterface = new dk();
            paramAnonymousDialogInterface.dcR.opType = 2;
            paramAnonymousDialogInterface.dcR.dcV = paramf;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
            AppMethodBeat.o(24016);
          }
        });
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new bjb();
          paramf.ncU = this.pyi;
          paramf.DUp = this.mDeviceType;
          paramPreference = ad.cgP().fu(this.pyi, this.mDeviceType);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.eNo;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                ad.cgP().fw(paramPreference[i], this.mDeviceType);
                i += 1;
              }
            }
          }
          paramf = new x(paramf, 2);
          h(paramf);
          az.agi().a(537, this);
          az.agi().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.ao(getContext(), this.pGs);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          az.ayM();
          paramf = com.tencent.mm.model.c.awB().aNt(this.pyh);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.pyi);
          paramPreference.putExtra("device_type", this.mDeviceType);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.pEs);
          if (paramf != null) {
            if ((com.tencent.mm.n.b.ln(paramf.field_type)) && (paramf.fad()))
            {
              af.aCW().AE(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.pyh);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.pwi.d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.pyh);
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
    ac.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ac.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
      AppMethodBeat.o(24025);
      return;
    }
    ac.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if ((paramn instanceof com.tencent.mm.plugin.exdevice.model.l))
    {
      chw();
      az.agi().b(paramn.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        chD();
        AppMethodBeat.o(24025);
        return;
      }
      chE();
      f(ad.cgP().fu(this.pyi, this.mDeviceType));
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
    if ((paramn instanceof m))
    {
      chw();
      az.agi().b(paramn.getType(), this);
      com.tencent.mm.plugin.exdevice.i.b localb = ad.cgP().sP(com.tencent.mm.plugin.exdevice.k.b.Zs(this.cDv));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        ac.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        chD();
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
      chE();
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof y))
    {
      chw();
      az.agi().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        Toast.makeText(getContext(), getString(2131758536), 1).show();
        AppMethodBeat.o(24025);
        return;
      }
      this.pGt = ((y)paramn).eNf;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24019);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aPN("device_profile_header"));
          AppMethodBeat.o(24019);
        }
      });
      paramString = ad.cgP().fu(this.pyi, this.mDeviceType);
      if (paramString == null)
      {
        ac.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.pyi, this.mDeviceType });
        AppMethodBeat.o(24025);
        return;
      }
      paramString.qg(this.pGt);
      ad.cgP().update(paramString, new String[0]);
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof x))
    {
      chw();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
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