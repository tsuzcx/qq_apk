package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.dd.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class ExdeviceDeviceProfileUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private String bUD;
  private com.tencent.mm.ui.base.p ehb;
  private String lEk;
  private String lEl;
  private long lFu;
  private String lJR;
  private String lJz;
  private String lKw;
  private String lKx;
  private com.tencent.mm.ui.base.p lLB = null;
  private int lLu;
  private boolean lMA;
  private String lMB;
  private h.b lMC;
  private String lMw;
  private String lMx;
  private boolean lMy;
  private String lMz;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(19954);
    String str;
    if (bo.isNullOrNil(this.lKw))
    {
      str = this.lEk;
      if (bo.isNullOrNil(this.lMx)) {
        break label98;
      }
      paramDeviceProfileHeaderPreference.setName(this.lMx);
      paramDeviceProfileHeaderPreference.LL(getString(2131299403, new Object[] { str }));
      paramDeviceProfileHeaderPreference.S(3, true);
      paramDeviceProfileHeaderPreference.S(4, true);
      paramDeviceProfileHeaderPreference.S(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.kd(this.lJR);
      AppMethodBeat.o(19954);
      return;
      str = this.lKw;
      break;
      label98:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.LL("");
      paramDeviceProfileHeaderPreference.S(3, false);
      paramDeviceProfileHeaderPreference.S(4, false);
      paramDeviceProfileHeaderPreference.S(1, this.lMy);
    }
  }
  
  private void bqF()
  {
    AppMethodBeat.i(19959);
    runOnUiThread(new ExdeviceDeviceProfileUI.2(this));
    AppMethodBeat.o(19959);
  }
  
  private void bqL()
  {
    AppMethodBeat.i(19953);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.atx("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new ExdeviceDeviceProfileUI.8(this));
    ((DeviceProfileHeaderPreference)localObject).a(4, new ExdeviceDeviceProfileUI.9(this));
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).ka(this.lMz);
    localObject = (KeyValuePreference)localf.atx("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.atx("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.atx("user_list");
    ((KeyValuePreference)localObject).qJ(true);
    localKeyValuePreference1.qJ(true);
    localKeyValuePreference2.qJ(true);
    localf.cl("message_manage", true);
    localf.cl("connect_setting", true);
    localf.cl("user_list", true);
    boolean bool;
    if (this.lMA)
    {
      localf.cl("sub_device_desc", false);
      localf.atx("sub_device_desc").setTitle(getResources().getString(2131299482, new Object[] { this.lMB }));
      localf.cl("bind_device", true);
      bool = true;
    }
    for (;;)
    {
      localf.cl("unbind_device", bool);
      if (bo.isNullOrNil(this.lMw)) {
        localf.cl("open_device_panel", true);
      }
      AppMethodBeat.o(19953);
      return;
      localf.cl("sub_device_desc", true);
      localf.cl("bind_device", this.lMy);
      if (!this.lMy) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void bqM()
  {
    AppMethodBeat.i(19960);
    runOnUiThread(new ExdeviceDeviceProfileUI.3(this));
    AppMethodBeat.o(19960);
  }
  
  private void bqN()
  {
    AppMethodBeat.i(19961);
    runOnUiThread(new ExdeviceDeviceProfileUI.4(this));
    AppMethodBeat.o(19961);
  }
  
  private void f(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    AppMethodBeat.i(19958);
    if (paramb != null)
    {
      this.lEl = paramb.field_deviceID;
      this.lJz = paramb.field_deviceType;
      this.lMx = bo.nullAsNil(paramb.dCJ);
      this.lKw = bo.nullAsNil(paramb.dCK);
      this.lEk = bo.nullAsNil(paramb.field_brandName);
      this.lJR = bo.nullAsNil(paramb.dCL);
      this.lMz = bo.nullAsNil(paramb.iconUrl);
      this.lMw = bo.nullAsNil(paramb.jumpUrl);
    }
    AppMethodBeat.o(19958);
  }
  
  private void i(com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(19962);
    runOnUiThread(new ExdeviceDeviceProfileUI.5(this, paramm));
    AppMethodBeat.o(19962);
  }
  
  public int getResourceId()
  {
    return 2131165234;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(19952);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceDeviceProfileUI.1(this));
    setMMTitle(2131299359);
    setActionbarColor(getContext().getResources().getColor(2131689615));
    this.lMC = new ExdeviceDeviceProfileUI.7(this);
    paramBundle = getIntent();
    this.bUD = paramBundle.getStringExtra("device_mac");
    this.lFu = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.lMw = paramBundle.getStringExtra("device_jump_url");
    this.lEk = paramBundle.getStringExtra("device_brand_name");
    this.lEl = paramBundle.getStringExtra("device_id");
    this.lJz = paramBundle.getStringExtra("device_type");
    this.lKx = paramBundle.getStringExtra("bind_ticket");
    this.lLu = paramBundle.getIntExtra("subscribe_flag", 0);
    this.lMy = paramBundle.getBooleanExtra("device_has_bound", false);
    this.lKw = paramBundle.getStringExtra("device_title");
    this.lMx = paramBundle.getStringExtra("device_alias");
    this.lJR = paramBundle.getStringExtra("device_desc");
    this.lMz = paramBundle.getStringExtra("device_icon_url");
    if ((bo.isNullOrNil(this.lEl)) || (bo.isNullOrNil(this.lJz))) {
      ab.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.lEl, this.lJz });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), 2131299418, 1).show();
      finish();
      AppMethodBeat.o(19952);
      return;
      paramBundle = com.tencent.mm.plugin.exdevice.model.ad.bpY().dU(this.lEl, this.lJz);
      if (paramBundle != null)
      {
        this.lMy = true;
        if (bo.isNullOrNil(this.lMx)) {
          this.lMx = bo.nullAsNil(paramBundle.dCJ);
        }
        if (bo.isNullOrNil(this.lKw)) {
          this.lKw = bo.nullAsNil(paramBundle.dCK);
        }
        if (bo.isNullOrNil(this.lEk)) {
          this.lEk = bo.nullAsNil(paramBundle.field_brandName);
        }
        if (bo.isNullOrNil(this.lJR)) {
          this.lJR = bo.nullAsNil(paramBundle.dCL);
        }
        if (bo.isNullOrNil(this.lMz)) {
          this.lMz = bo.nullAsNil(paramBundle.iconUrl);
        }
        if (bo.isNullOrNil(this.lMw)) {
          this.lMw = bo.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.dCN == 2)
        {
          this.lMA = true;
          this.lMB = this.lKw;
          paramBundle = com.tencent.mm.plugin.exdevice.model.ad.bpY().bqD().iterator();
          com.tencent.mm.plugin.exdevice.h.b localb;
          do
          {
            do
            {
              if (!paramBundle.hasNext()) {
                break;
              }
              localb = (com.tencent.mm.plugin.exdevice.h.b)paramBundle.next();
            } while (!localb.field_deviceType.equals(this.lJz));
            localObject = localb.dCS;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.lEl)) {
              if (!bo.isNullOrNil(localb.dCJ)) {
                break label601;
              }
            }
          }
          label601:
          for (this.lMB = localb.dCK;; this.lMB = localb.dCJ)
          {
            ab.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.lMB });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (bo.isNullOrNil(this.lKx)) {
          continue;
        }
      }
      i = 1;
    }
    bqL();
    AppMethodBeat.o(19952);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(19957);
    aw.Rc().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(19957);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(19955);
    ab.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (bo.isNullOrNil(this.lKx))
      {
        ab.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new com.tencent.mm.plugin.exdevice.model.m(com.tencent.mm.plugin.exdevice.j.b.LX(this.bUD), this.lEk, "3", this.lFu);
        i(paramf);
        aw.Rc().a(1262, this);
        aw.Rc().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(19955);
        return true;
        ab.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.lKx;
        int i = this.lLu;
        aw.Rc().a(536, this);
        paramPreference = new dd();
        paramPreference.cqA.cqC = paramf;
        paramPreference.cqA.opType = 1;
        paramPreference.cqA.cqD = i;
        com.tencent.mm.sdk.b.a.ymk.l(paramPreference);
        paramf = paramPreference.cqB.cqE;
        getString(2131297087);
        this.lLB = h.b(this, getString(2131299362), true, new ExdeviceDeviceProfileUI.10(this, paramf));
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new auh();
          paramf.jJD = this.lEl;
          paramf.wsq = this.lJz;
          paramPreference = com.tencent.mm.plugin.exdevice.model.ad.bpY().dU(this.lEl, this.lJz);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.dCS;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                com.tencent.mm.plugin.exdevice.model.ad.bpY().dW(paramPreference[i], this.lJz);
                i += 1;
              }
            }
          }
          paramf = new x(paramf, 2);
          i(paramf);
          aw.Rc().a(537, this);
          aw.Rc().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.an(getContext(), this.lMw);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          aw.aaz();
          paramf = com.tencent.mm.model.c.YA().arw(this.lEk);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.lEl);
          paramPreference.putExtra("device_type", this.lJz);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.lKx);
          if (paramf != null) {
            if ((com.tencent.mm.n.a.je(paramf.field_type)) && (paramf.dwz()))
            {
              z.afi().rK(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.lEk);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.lCn.d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.lEk);
              paramPreference.putExtra("force_get_contact", true);
              d.b(getContext(), "profile", ".ui.ContactInfoUI", paramPreference);
            }
          }
        }
      }
    } while (("message_manage".equals(paramPreference.mKey)) || ("connect_setting".equals(paramPreference.mKey)) || ("user_list".equals(paramPreference.mKey)));
    AppMethodBeat.o(19955);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(19956);
    ab.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      ab.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
      AppMethodBeat.o(19956);
      return;
    }
    ab.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    if ((paramm instanceof l))
    {
      bqF();
      aw.Rc().b(paramm.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
        bqM();
        AppMethodBeat.o(19956);
        return;
      }
      bqN();
      f(com.tencent.mm.plugin.exdevice.model.ad.bpY().dU(this.lEl, this.lJz));
      runOnUiThread(new ExdeviceDeviceProfileUI.11(this));
      AppMethodBeat.o(19956);
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.exdevice.model.m))
    {
      bqF();
      aw.Rc().b(paramm.getType(), this);
      com.tencent.mm.plugin.exdevice.h.b localb = com.tencent.mm.plugin.exdevice.model.ad.bpY().jv(com.tencent.mm.plugin.exdevice.j.b.LX(this.bUD));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
        bqM();
        AppMethodBeat.o(19956);
        return;
      }
      f(localb);
      runOnUiThread(new ExdeviceDeviceProfileUI.12(this));
      bqN();
      AppMethodBeat.o(19956);
      return;
    }
    if ((paramm instanceof y))
    {
      bqF();
      aw.Rc().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
        Toast.makeText(getContext(), getString(2131299408), 1).show();
        AppMethodBeat.o(19956);
        return;
      }
      this.lMx = ((y)paramm).dCJ;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19950);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().atx("device_profile_header"));
          AppMethodBeat.o(19950);
        }
      });
      paramString = com.tencent.mm.plugin.exdevice.model.ad.bpY().dU(this.lEl, this.lJz);
      if (paramString == null)
      {
        ab.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.lEl, this.lJz });
        AppMethodBeat.o(19956);
        return;
      }
      paramString.jm(this.lMx);
      com.tencent.mm.plugin.exdevice.model.ad.bpY().update(paramString, new String[0]);
      AppMethodBeat.o(19956);
      return;
    }
    if ((paramm instanceof x))
    {
      bqF();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramm.getType()) });
        runOnUiThread(new ExdeviceDeviceProfileUI.6(this));
        AppMethodBeat.o(19956);
        return;
      }
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(19951);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, null);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, false);
          ExdeviceDeviceProfileUI.f(ExdeviceDeviceProfileUI.this);
          ExdeviceDeviceProfileUI.this.getPreferenceScreen().notifyDataSetChanged();
          AppMethodBeat.o(19951);
        }
      });
      finish();
    }
    AppMethodBeat.o(19956);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */