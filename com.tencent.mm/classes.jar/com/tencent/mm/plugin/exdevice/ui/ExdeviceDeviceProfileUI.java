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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dj.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
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
  private String cGn;
  private p ftP;
  private String mDeviceType;
  private String oUW;
  private String oUX;
  private long oWf;
  private String paB;
  private String pbg;
  private String pbh;
  private int pce;
  private p pcl = null;
  private String pdh;
  private String pdi;
  private boolean pdj;
  private String pdk;
  private boolean pdl;
  private String pdm;
  private h.b pdn;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(24023);
    String str;
    if (bt.isNullOrNil(this.pbg))
    {
      str = this.oUW;
      if (bt.isNullOrNil(this.pdi)) {
        break label98;
      }
      paramDeviceProfileHeaderPreference.setName(this.pdi);
      paramDeviceProfileHeaderPreference.UU(getString(2131758531, new Object[] { str }));
      paramDeviceProfileHeaderPreference.aa(3, true);
      paramDeviceProfileHeaderPreference.aa(4, true);
      paramDeviceProfileHeaderPreference.aa(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.nS(this.paB);
      AppMethodBeat.o(24023);
      return;
      str = this.pbg;
      break;
      label98:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.UU("");
      paramDeviceProfileHeaderPreference.aa(3, false);
      paramDeviceProfileHeaderPreference.aa(4, false);
      paramDeviceProfileHeaderPreference.aa(1, this.pdj);
    }
  }
  
  private void can()
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
  
  private void cat()
  {
    AppMethodBeat.i(24022);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.aKk("device_profile_header");
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
    ((DeviceProfileHeaderPreference)localObject).nP(this.pdk);
    localObject = (KeyValuePreference)localf.aKk("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.aKk("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.aKk("user_list");
    ((KeyValuePreference)localObject).vR(true);
    localKeyValuePreference1.vR(true);
    localKeyValuePreference2.vR(true);
    localf.cE("message_manage", true);
    localf.cE("connect_setting", true);
    localf.cE("user_list", true);
    if (this.pdl)
    {
      localf.cE("sub_device_desc", false);
      localf.aKk("sub_device_desc").setTitle(getResources().getString(2131758613, new Object[] { this.pdm }));
      localf.cE("bind_device", true);
      localf.cE("unbind_device", true);
      if (bt.isNullOrNil(this.pdh)) {
        localf.cE("open_device_panel", true);
      }
      AppMethodBeat.o(24022);
      return;
    }
    localf.cE("sub_device_desc", true);
    localf.cE("bind_device", this.pdj);
    if (!this.pdj) {}
    for (boolean bool = true;; bool = false)
    {
      localf.cE("unbind_device", bool);
      break;
    }
  }
  
  private void cau()
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
  
  private void cav()
  {
    AppMethodBeat.i(24030);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24008);
        ExdeviceDeviceProfileUI localExdeviceDeviceProfileUI = ExdeviceDeviceProfileUI.this;
        ExdeviceDeviceProfileUI.this.getString(2131755906);
        new av(new av.a()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(24007);
            ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24006);
                ExdeviceDeviceProfileUI.4.1.this.pdp.dismiss();
                AppMethodBeat.o(24006);
              }
            });
            AppMethodBeat.o(24007);
            return true;
          }
        }, false).av(1000L, 1000L);
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
      this.oUX = paramb.field_deviceID;
      this.mDeviceType = paramb.field_deviceType;
      this.pdi = bt.nullAsNil(paramb.eKn);
      this.pbg = bt.nullAsNil(paramb.eKo);
      this.oUW = bt.nullAsNil(paramb.field_brandName);
      this.paB = bt.nullAsNil(paramb.eKp);
      this.pdk = bt.nullAsNil(paramb.iconUrl);
      this.pdh = bt.nullAsNil(paramb.jumpUrl);
    }
    AppMethodBeat.o(24027);
  }
  
  private void i(final n paramn)
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
            az.aeS().a(ExdeviceDeviceProfileUI.5.this.cZL);
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
    this.pdn = new h.b()
    {
      public final boolean onFinish(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(24013);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[] { paramAnonymousCharSequence });
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
              ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aKk("device_profile_header"));
              AppMethodBeat.o(24012);
            }
          });
          paramAnonymousCharSequence = com.tencent.mm.plugin.exdevice.model.ad.bZG().fh(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this));
          if (paramAnonymousCharSequence == null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this) });
            AppMethodBeat.o(24013);
            return false;
          }
          paramAnonymousCharSequence.na(ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this));
          com.tencent.mm.plugin.exdevice.model.ad.bZG().update(paramAnonymousCharSequence, new String[0]);
        }
        for (;;)
        {
          AppMethodBeat.o(24013);
          return true;
          paramAnonymousCharSequence = new y(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this), str);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, paramAnonymousCharSequence);
          az.aeS().a(1263, ExdeviceDeviceProfileUI.this);
          az.aeS().a(paramAnonymousCharSequence, 0);
        }
      }
    };
    paramBundle = getIntent();
    this.cGn = paramBundle.getStringExtra("device_mac");
    this.oWf = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.pdh = paramBundle.getStringExtra("device_jump_url");
    this.oUW = paramBundle.getStringExtra("device_brand_name");
    this.oUX = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.pbh = paramBundle.getStringExtra("bind_ticket");
    this.pce = paramBundle.getIntExtra("subscribe_flag", 0);
    this.pdj = paramBundle.getBooleanExtra("device_has_bound", false);
    this.pbg = paramBundle.getStringExtra("device_title");
    this.pdi = paramBundle.getStringExtra("device_alias");
    this.paB = paramBundle.getStringExtra("device_desc");
    this.pdk = paramBundle.getStringExtra("device_icon_url");
    if ((bt.isNullOrNil(this.oUX)) || (bt.isNullOrNil(this.mDeviceType))) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.oUX, this.mDeviceType });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), 2131758546, 1).show();
      finish();
      AppMethodBeat.o(24021);
      return;
      paramBundle = com.tencent.mm.plugin.exdevice.model.ad.bZG().fh(this.oUX, this.mDeviceType);
      if (paramBundle != null)
      {
        this.pdj = true;
        if (bt.isNullOrNil(this.pdi)) {
          this.pdi = bt.nullAsNil(paramBundle.eKn);
        }
        if (bt.isNullOrNil(this.pbg)) {
          this.pbg = bt.nullAsNil(paramBundle.eKo);
        }
        if (bt.isNullOrNil(this.oUW)) {
          this.oUW = bt.nullAsNil(paramBundle.field_brandName);
        }
        if (bt.isNullOrNil(this.paB)) {
          this.paB = bt.nullAsNil(paramBundle.eKp);
        }
        if (bt.isNullOrNil(this.pdk)) {
          this.pdk = bt.nullAsNil(paramBundle.iconUrl);
        }
        if (bt.isNullOrNil(this.pdh)) {
          this.pdh = bt.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.eKr == 2)
        {
          this.pdl = true;
          this.pdm = this.pbg;
          paramBundle = com.tencent.mm.plugin.exdevice.model.ad.bZG().cal().iterator();
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
            localObject = localb.eKw;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.oUX)) {
              if (!bt.isNullOrNil(localb.eKn)) {
                break label601;
              }
            }
          }
          label601:
          for (this.pdm = localb.eKo;; this.pdm = localb.eKn)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.pdm });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (bt.isNullOrNil(this.pbh)) {
          continue;
        }
      }
      i = 1;
    }
    cat();
    AppMethodBeat.o(24021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24026);
    az.aeS().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(24026);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24024);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (bt.isNullOrNil(this.pbh))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new m(com.tencent.mm.plugin.exdevice.k.b.Vg(this.cGn), this.oUW, "3", this.oWf);
        i(paramf);
        az.aeS().a(1262, this);
        az.aeS().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(24024);
        return true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.pbh;
        int i = this.pce;
        az.aeS().a(536, this);
        paramPreference = new dj();
        paramPreference.dfw.dfy = paramf;
        paramPreference.dfw.opType = 1;
        paramPreference.dfw.dfz = i;
        com.tencent.mm.sdk.b.a.ESL.l(paramPreference);
        paramf = paramPreference.dfx.dfA;
        getString(2131755906);
        this.pcl = h.b(this, getString(2131758490), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(24016);
            az.aeS().b(536, ExdeviceDeviceProfileUI.this);
            paramAnonymousDialogInterface = new dj();
            paramAnonymousDialogInterface.dfw.opType = 2;
            paramAnonymousDialogInterface.dfw.dfA = paramf;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousDialogInterface);
            AppMethodBeat.o(24016);
          }
        });
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new bfj();
          paramf.mAT = this.oUX;
          paramf.CBS = this.mDeviceType;
          paramPreference = com.tencent.mm.plugin.exdevice.model.ad.bZG().fh(this.oUX, this.mDeviceType);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.eKw;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                com.tencent.mm.plugin.exdevice.model.ad.bZG().fj(paramPreference[i], this.mDeviceType);
                i += 1;
              }
            }
          }
          paramf = new x(paramf, 2);
          i(paramf);
          az.aeS().a(537, this);
          az.aeS().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.an(getContext(), this.pdh);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          az.arV();
          paramf = com.tencent.mm.model.c.apM().aHY(this.oUW);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.oUX);
          paramPreference.putExtra("device_type", this.mDeviceType);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.pbh);
          if (paramf != null) {
            if ((com.tencent.mm.n.b.ls(paramf.field_type)) && (paramf.eKB()))
            {
              com.tencent.mm.am.af.awe().wy(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.oUW);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.oSX.d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.oUW);
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
      AppMethodBeat.o(24025);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if ((paramn instanceof com.tencent.mm.plugin.exdevice.model.l))
    {
      can();
      az.aeS().b(paramn.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        cau();
        AppMethodBeat.o(24025);
        return;
      }
      cav();
      f(com.tencent.mm.plugin.exdevice.model.ad.bZG().fh(this.oUX, this.mDeviceType));
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
      can();
      az.aeS().b(paramn.getType(), this);
      com.tencent.mm.plugin.exdevice.i.b localb = com.tencent.mm.plugin.exdevice.model.ad.bZG().pd(com.tencent.mm.plugin.exdevice.k.b.Vg(this.cGn));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        cau();
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
      cav();
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof y))
    {
      can();
      az.aeS().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        Toast.makeText(getContext(), getString(2131758536), 1).show();
        AppMethodBeat.o(24025);
        return;
      }
      this.pdi = ((y)paramn).eKn;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24019);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aKk("device_profile_header"));
          AppMethodBeat.o(24019);
        }
      });
      paramString = com.tencent.mm.plugin.exdevice.model.ad.bZG().fh(this.oUX, this.mDeviceType);
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.oUX, this.mDeviceType });
        AppMethodBeat.o(24025);
        return;
      }
      paramString.na(this.pdi);
      com.tencent.mm.plugin.exdevice.model.ad.bZG().update(paramString, new String[0]);
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof x))
    {
      can();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */