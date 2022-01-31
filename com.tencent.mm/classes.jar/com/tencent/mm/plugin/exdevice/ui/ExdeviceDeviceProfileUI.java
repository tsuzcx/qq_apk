package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.da;
import com.tencent.mm.h.a.da.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.List;

public class ExdeviceDeviceProfileUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private String btt;
  private com.tencent.mm.ui.base.p dpF;
  private String jAX;
  private String jAY;
  private String jAa;
  private String jAs;
  private int jBV;
  private String jCY;
  private String jCZ;
  private com.tencent.mm.ui.base.p jCc = null;
  private boolean jDa;
  private String jDb;
  private boolean jDc;
  private String jDd;
  private h.b jDe;
  private String juL;
  private String juM;
  private long jvV;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    String str;
    if (bk.bl(this.jAX))
    {
      str = this.juL;
      if (bk.bl(this.jCZ)) {
        break label104;
      }
      paramDeviceProfileHeaderPreference.setName(this.jCZ);
      paramDeviceProfileHeaderPreference.BJ(getString(R.l.exdevice_device_name, new Object[] { str }));
      paramDeviceProfileHeaderPreference.K(3, true);
      paramDeviceProfileHeaderPreference.K(4, true);
      paramDeviceProfileHeaderPreference.K(1, false);
    }
    for (;;)
    {
      str = this.jAs;
      paramDeviceProfileHeaderPreference.jAs = str;
      if (paramDeviceProfileHeaderPreference.jAp != null) {
        paramDeviceProfileHeaderPreference.jAp.setText(str);
      }
      return;
      str = this.jAX;
      break;
      label104:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.BJ("");
      paramDeviceProfileHeaderPreference.K(3, false);
      paramDeviceProfileHeaderPreference.K(4, false);
      paramDeviceProfileHeaderPreference.K(1, this.jDa);
    }
  }
  
  private void aMs()
  {
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        if ((ExdeviceDeviceProfileUI.g(ExdeviceDeviceProfileUI.this) != null) && (ExdeviceDeviceProfileUI.g(ExdeviceDeviceProfileUI.this).isShowing())) {
          ExdeviceDeviceProfileUI.g(ExdeviceDeviceProfileUI.this).dismiss();
        }
        if ((ExdeviceDeviceProfileUI.h(ExdeviceDeviceProfileUI.this) != null) && (ExdeviceDeviceProfileUI.h(ExdeviceDeviceProfileUI.this).isShowing())) {
          ExdeviceDeviceProfileUI.h(ExdeviceDeviceProfileUI.this).dismiss();
        }
      }
    });
  }
  
  private void aMx()
  {
    com.tencent.mm.ui.base.preference.h localh = this.vdd;
    Object localObject = (DeviceProfileHeaderPreference)localh.add("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new ExdeviceDeviceProfileUI.8(this));
    ((DeviceProfileHeaderPreference)localObject).a(4, new ExdeviceDeviceProfileUI.9(this));
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).setIconUrl(this.jDb);
    localObject = (KeyValuePreference)localh.add("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localh.add("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localh.add("user_list");
    ((KeyValuePreference)localObject).nf(true);
    localKeyValuePreference1.nf(true);
    localKeyValuePreference2.nf(true);
    localh.bJ("message_manage", true);
    localh.bJ("connect_setting", true);
    localh.bJ("user_list", true);
    boolean bool;
    if (this.jDc)
    {
      localh.bJ("sub_device_desc", false);
      localh.add("sub_device_desc").setTitle(getResources().getString(R.l.exdevice_sub_device_desc, new Object[] { this.jDd }));
      localh.bJ("bind_device", true);
      bool = true;
    }
    for (;;)
    {
      localh.bJ("unbind_device", bool);
      if (bk.bl(this.jCY)) {
        localh.bJ("open_device_panel", true);
      }
      return;
      localh.bJ("sub_device_desc", true);
      localh.bJ("bind_device", this.jDa);
      if (!this.jDa) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void aMy()
  {
    runOnUiThread(new ExdeviceDeviceProfileUI.3(this));
  }
  
  private void aMz()
  {
    runOnUiThread(new ExdeviceDeviceProfileUI.4(this));
  }
  
  private void f(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    if (paramb != null)
    {
      this.juM = paramb.field_deviceID;
      this.jAa = paramb.field_deviceType;
      this.jCZ = bk.pm(paramb.cMT);
      this.jAX = bk.pm(paramb.cMU);
      this.juL = bk.pm(paramb.field_brandName);
      this.jAs = bk.pm(paramb.cMV);
      this.jDb = bk.pm(paramb.iconUrl);
      this.jCY = bk.pm(paramb.jumpUrl);
    }
  }
  
  private void j(com.tencent.mm.ah.m paramm)
  {
    runOnUiThread(new ExdeviceDeviceProfileUI.5(this, paramm));
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (bk.bl(this.jAY))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new com.tencent.mm.plugin.exdevice.model.m(com.tencent.mm.plugin.exdevice.j.b.BU(this.btt), this.juL, "3", this.jvV);
        j(paramf);
        au.Dk().a(1262, this);
        au.Dk().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        return true;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.jAY;
        int i = this.jBV;
        au.Dk().a(536, this);
        paramPreference = new da();
        paramPreference.bJg.bJi = paramf;
        paramPreference.bJg.opType = 1;
        paramPreference.bJg.bJj = i;
        com.tencent.mm.sdk.b.a.udP.m(paramPreference);
        paramf = paramPreference.bJh.bJk;
        getString(R.l.app_tip);
        this.jCc = com.tencent.mm.ui.base.h.b(this, getString(R.l.exdevice_binding), true, new ExdeviceDeviceProfileUI.10(this, paramf));
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new aop();
          paramf.hQb = this.juM;
          paramf.syI = this.jAa;
          paramPreference = com.tencent.mm.plugin.exdevice.model.ad.aLL().cQ(this.juM, this.jAa);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.cNc;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                com.tencent.mm.plugin.exdevice.model.ad.aLL().cS(paramPreference[i], this.jAa);
                i += 1;
              }
            }
          }
          paramf = new x(paramf, 2);
          j(paramf);
          au.Dk().a(537, this);
          au.Dk().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.af(this.mController.uMN, this.jCY);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          au.Hx();
          paramf = com.tencent.mm.model.c.Fw().abl(this.juL);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.juM);
          paramPreference.putExtra("device_type", this.jAa);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.jAY);
          if (paramf != null) {
            if ((com.tencent.mm.n.a.gR(paramf.field_type)) && (paramf.cua()))
            {
              z.My().kQ(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.juL);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.jsN.e(paramPreference, this.mController.uMN);
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.juL);
              paramPreference.putExtra("force_get_contact", true);
              d.b(this.mController.uMN, "profile", ".ui.ContactInfoUI", paramPreference);
            }
          }
        }
      }
    } while (("message_manage".equals(paramPreference.mKey)) || ("connect_setting".equals(paramPreference.mKey)) || ("user_list".equals(paramPreference.mKey)));
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceDeviceProfileUI.1(this));
    setMMTitle(R.l.exdevice_bind_device_profile_title);
    this.jDe = new ExdeviceDeviceProfileUI.7(this);
    paramBundle = getIntent();
    this.btt = paramBundle.getStringExtra("device_mac");
    this.jvV = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.jCY = paramBundle.getStringExtra("device_jump_url");
    this.juL = paramBundle.getStringExtra("device_brand_name");
    this.juM = paramBundle.getStringExtra("device_id");
    this.jAa = paramBundle.getStringExtra("device_type");
    this.jAY = paramBundle.getStringExtra("bind_ticket");
    this.jBV = paramBundle.getIntExtra("subscribe_flag", 0);
    this.jDa = paramBundle.getBooleanExtra("device_has_bound", false);
    this.jAX = paramBundle.getStringExtra("device_title");
    this.jCZ = paramBundle.getStringExtra("device_alias");
    this.jAs = paramBundle.getStringExtra("device_desc");
    this.jDb = paramBundle.getStringExtra("device_icon_url");
    if ((bk.bl(this.juM)) || (bk.bl(this.jAa))) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.juM, this.jAa });
    }
    while (i == 0)
    {
      Toast.makeText(this.mController.uMN, R.l.exdevice_jump_failed, 1).show();
      finish();
      return;
      paramBundle = com.tencent.mm.plugin.exdevice.model.ad.aLL().cQ(this.juM, this.jAa);
      if (paramBundle != null)
      {
        this.jDa = true;
        if (bk.bl(this.jCZ)) {
          this.jCZ = bk.pm(paramBundle.cMT);
        }
        if (bk.bl(this.jAX)) {
          this.jAX = bk.pm(paramBundle.cMU);
        }
        if (bk.bl(this.juL)) {
          this.juL = bk.pm(paramBundle.field_brandName);
        }
        if (bk.bl(this.jAs)) {
          this.jAs = bk.pm(paramBundle.cMV);
        }
        if (bk.bl(this.jDb)) {
          this.jDb = bk.pm(paramBundle.iconUrl);
        }
        if (bk.bl(this.jCY)) {
          this.jCY = bk.pm(paramBundle.jumpUrl);
        }
        if (paramBundle.cMX == 2)
        {
          this.jDc = true;
          this.jDd = this.jAX;
          paramBundle = com.tencent.mm.plugin.exdevice.model.ad.aLL().aMq().iterator();
          com.tencent.mm.plugin.exdevice.h.b localb;
          do
          {
            do
            {
              if (!paramBundle.hasNext()) {
                break;
              }
              localb = (com.tencent.mm.plugin.exdevice.h.b)paramBundle.next();
            } while (!localb.field_deviceType.equals(this.jAa));
            localObject = localb.cNc;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label509:
          if (i < localObject.length) {
            if (localObject[i].equals(this.juM)) {
              if (!bk.bl(localb.cMT)) {
                break label575;
              }
            }
          }
          label575:
          for (this.jDd = localb.cMU;; this.jDd = localb.cMT)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.jDd });
            i += 1;
            break label509;
            break;
          }
        }
      }
      else
      {
        if (bk.bl(this.jAY)) {
          continue;
        }
      }
      i = 1;
    }
    aMx();
  }
  
  protected void onDestroy()
  {
    au.Dk().b(537, this);
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
    }
    do
    {
      return;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
      if ((paramm instanceof l))
      {
        aMs();
        au.Dk().b(paramm.getType(), this);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
          aMy();
          return;
        }
        aMz();
        f(com.tencent.mm.plugin.exdevice.model.ad.aLL().cQ(this.juM, this.jAa));
        runOnUiThread(new ExdeviceDeviceProfileUI.11(this));
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.exdevice.model.m))
      {
        aMs();
        au.Dk().b(paramm.getType(), this);
        com.tencent.mm.plugin.exdevice.h.b localb = com.tencent.mm.plugin.exdevice.model.ad.aLL().ed(com.tencent.mm.plugin.exdevice.j.b.BU(this.btt));
        if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
          aMy();
          return;
        }
        f(localb);
        runOnUiThread(new ExdeviceDeviceProfileUI.12(this));
        aMz();
        return;
      }
      if ((paramm instanceof com.tencent.mm.plugin.exdevice.model.y))
      {
        aMs();
        au.Dk().b(1263, this);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
          Toast.makeText(this.mController.uMN, getString(R.l.exdevice_edit_alias_failed), 1).show();
          return;
        }
        this.jCZ = ((com.tencent.mm.plugin.exdevice.model.y)paramm).cMT;
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.vdd.add("device_profile_header"));
          }
        });
        paramString = com.tencent.mm.plugin.exdevice.model.ad.aLL().cQ(this.juM, this.jAa);
        if (paramString == null)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.juM, this.jAa });
          return;
        }
        paramString.cZ(this.jCZ);
        com.tencent.mm.plugin.exdevice.model.ad.aLL().c(paramString, new String[0]);
        return;
      }
    } while (!(paramm instanceof x));
    aMs();
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
      runOnUiThread(new ExdeviceDeviceProfileUI.6(this));
      return;
    }
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, null);
        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, false);
        ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
        ExdeviceDeviceProfileUI.this.vdd.notifyDataSetChanged();
      }
    });
    finish();
  }
  
  public final int xj()
  {
    return R.o.exdevice_device_profile_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */