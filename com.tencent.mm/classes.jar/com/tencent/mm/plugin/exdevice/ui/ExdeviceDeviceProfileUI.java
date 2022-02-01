package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.dy;
import com.tencent.mm.f.a.dy.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.ds;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.plugin.exdevice.model.z;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.List;

public class ExdeviceDeviceProfileUI
  extends MMPreference
  implements i
{
  private s jhZ;
  private String mDeviceType;
  private String shW;
  private String veU;
  private String veV;
  private long vgc;
  private String vkN;
  private String vls;
  private String vlt;
  private int vmp;
  private s vmw = null;
  private String vnr;
  private String vns;
  private boolean vnt;
  private String vnu;
  private boolean vnv;
  private String vnw;
  private h.b vnx;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(24023);
    String str;
    if (Util.isNullOrNil(this.vls))
    {
      str = this.veU;
      if (Util.isNullOrNil(this.vns)) {
        break label99;
      }
      paramDeviceProfileHeaderPreference.setName(this.vns);
      paramDeviceProfileHeaderPreference.avL(getString(R.l.eDs, new Object[] { str }));
      paramDeviceProfileHeaderPreference.ai(3, true);
      paramDeviceProfileHeaderPreference.ai(4, true);
      paramDeviceProfileHeaderPreference.ai(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.Jg(this.vkN);
      AppMethodBeat.o(24023);
      return;
      str = this.vls;
      break;
      label99:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.avL("");
      paramDeviceProfileHeaderPreference.ai(3, false);
      paramDeviceProfileHeaderPreference.ai(4, false);
      paramDeviceProfileHeaderPreference.ai(1, this.vnt);
    }
  }
  
  private void daq()
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
  
  private void daw()
  {
    AppMethodBeat.i(24022);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.byG("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.eDx), "", "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
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
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.eDx), ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this), "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24015);
      }
    });
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).setIconUrl(this.vnu);
    localObject = (KeyValuePreference)localf.byG("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.byG("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.byG("user_list");
    ((KeyValuePreference)localObject).FU(true);
    localKeyValuePreference1.FU(true);
    localKeyValuePreference2.FU(true);
    localf.dz("message_manage", true);
    localf.dz("connect_setting", true);
    localf.dz("user_list", true);
    if (this.vnv)
    {
      localf.dz("sub_device_desc", false);
      localf.byG("sub_device_desc").setTitle(getResources().getString(R.l.eEh, new Object[] { this.vnw }));
      localf.dz("bind_device", true);
      localf.dz("unbind_device", true);
      if (Util.isNullOrNil(this.vnr)) {
        localf.dz("open_device_panel", true);
      }
      AppMethodBeat.o(24022);
      return;
    }
    localf.dz("sub_device_desc", true);
    localf.dz("bind_device", this.vnt);
    if (!this.vnt) {}
    for (boolean bool = true;; bool = false)
    {
      localf.dz("unbind_device", bool);
      break;
    }
  }
  
  private void dax()
  {
    AppMethodBeat.i(24029);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24005);
        h.c(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.eCN), ExdeviceDeviceProfileUI.this.getString(R.l.app_tip), true);
        AppMethodBeat.o(24005);
      }
    });
    AppMethodBeat.o(24029);
  }
  
  private void day()
  {
    AppMethodBeat.i(24030);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24008);
        ExdeviceDeviceProfileUI localExdeviceDeviceProfileUI = ExdeviceDeviceProfileUI.this;
        ExdeviceDeviceProfileUI.this.getString(R.l.app_tip);
        new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(24007);
            ExdeviceDeviceProfileUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(24006);
                ExdeviceDeviceProfileUI.4.1.this.vnz.dismiss();
                AppMethodBeat.o(24006);
              }
            });
            AppMethodBeat.o(24007);
            return true;
          }
        }, false).startTimer(1000L);
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
      this.veV = paramb.field_deviceID;
      this.mDeviceType = paramb.field_deviceType;
      this.vns = Util.nullAsNil(paramb.idS);
      this.vls = Util.nullAsNil(paramb.idT);
      this.veU = Util.nullAsNil(paramb.field_brandName);
      this.vkN = Util.nullAsNil(paramb.idU);
      this.vnu = Util.nullAsNil(paramb.iconUrl);
      this.vnr = Util.nullAsNil(paramb.jumpUrl);
    }
    AppMethodBeat.o(24027);
  }
  
  private void h(final q paramq)
  {
    AppMethodBeat.i(24031);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24010);
        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, h.a(ExdeviceDeviceProfileUI.this.getContext(), ExdeviceDeviceProfileUI.this.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(24009);
            bh.aGY().a(ExdeviceDeviceProfileUI.5.this.ftz);
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
    return R.o.eXB;
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
    setMMTitle(R.l.eCS);
    setActionbarColor(getContext().getResources().getColor(R.e.white));
    this.vnx = new h.b()
    {
      public final boolean onFinish(CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(24013);
        Log.d("MicroMsg.ExdeviceDeviceProfileUI", "result : %s.", new Object[] { paramAnonymousCharSequence });
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
              ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().byG("device_profile_header"));
              AppMethodBeat.o(24012);
            }
          });
          paramAnonymousCharSequence = ae.cZx().gq(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this));
          if (paramAnonymousCharSequence == null)
          {
            Log.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this) });
            AppMethodBeat.o(24013);
            return false;
          }
          paramAnonymousCharSequence.Iq(ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this));
          ae.cZx().update(paramAnonymousCharSequence, new String[0]);
        }
        for (;;)
        {
          AppMethodBeat.o(24013);
          return true;
          paramAnonymousCharSequence = new z(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this), str);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, paramAnonymousCharSequence);
          bh.aGY().a(1263, ExdeviceDeviceProfileUI.this);
          bh.aGY().a(paramAnonymousCharSequence, 0);
        }
      }
    };
    paramBundle = getIntent();
    this.shW = paramBundle.getStringExtra("device_mac");
    this.vgc = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.vnr = paramBundle.getStringExtra("device_jump_url");
    this.veU = paramBundle.getStringExtra("device_brand_name");
    this.veV = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.vlt = paramBundle.getStringExtra("bind_ticket");
    this.vmp = paramBundle.getIntExtra("subscribe_flag", 0);
    this.vnt = paramBundle.getBooleanExtra("device_has_bound", false);
    this.vls = paramBundle.getStringExtra("device_title");
    this.vns = paramBundle.getStringExtra("device_alias");
    this.vkN = paramBundle.getStringExtra("device_desc");
    this.vnu = paramBundle.getStringExtra("device_icon_url");
    if ((Util.isNullOrNil(this.veV)) || (Util.isNullOrNil(this.mDeviceType))) {
      Log.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.veV, this.mDeviceType });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), R.l.eDz, 1).show();
      finish();
      AppMethodBeat.o(24021);
      return;
      paramBundle = ae.cZx().gq(this.veV, this.mDeviceType);
      if (paramBundle != null)
      {
        this.vnt = true;
        if (Util.isNullOrNil(this.vns)) {
          this.vns = Util.nullAsNil(paramBundle.idS);
        }
        if (Util.isNullOrNil(this.vls)) {
          this.vls = Util.nullAsNil(paramBundle.idT);
        }
        if (Util.isNullOrNil(this.veU)) {
          this.veU = Util.nullAsNil(paramBundle.field_brandName);
        }
        if (Util.isNullOrNil(this.vkN)) {
          this.vkN = Util.nullAsNil(paramBundle.idU);
        }
        if (Util.isNullOrNil(this.vnu)) {
          this.vnu = Util.nullAsNil(paramBundle.iconUrl);
        }
        if (Util.isNullOrNil(this.vnr)) {
          this.vnr = Util.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.idX == 2)
        {
          this.vnv = true;
          this.vnw = this.vls;
          paramBundle = ae.cZx().dao().iterator();
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
            localObject = localb.iec;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.veV)) {
              if (!Util.isNullOrNil(localb.idS)) {
                break label601;
              }
            }
          }
          label601:
          for (this.vnw = localb.idT;; this.vnw = localb.idS)
          {
            Log.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.vnw });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (Util.isNullOrNil(this.vlt)) {
          continue;
        }
      }
      i = 1;
    }
    daw();
    AppMethodBeat.o(24021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24026);
    bh.aGY().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(24026);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24024);
    Log.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (Util.isNullOrNil(this.vlt))
      {
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new com.tencent.mm.plugin.exdevice.model.m(com.tencent.mm.plugin.exdevice.k.b.avW(this.shW), this.veU, "3", this.vgc);
        h(paramf);
        bh.aGY().a(1262, this);
        bh.aGY().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(24024);
        return true;
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.vlt;
        int i = this.vmp;
        bh.aGY().a(536, this);
        paramPreference = new dy();
        paramPreference.fzv.fzx = paramf;
        paramPreference.fzv.opType = 1;
        paramPreference.fzv.fzy = i;
        EventCenter.instance.publish(paramPreference);
        paramf = paramPreference.fzw.fzz;
        getString(R.l.app_tip);
        this.vmw = h.a(this, getString(R.l.eCU), true, new ExdeviceDeviceProfileUI.10(this, paramf));
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new ciu();
          paramf.rVF = this.veV;
          paramf.RMK = this.mDeviceType;
          paramPreference = ae.cZx().gq(this.veV, this.mDeviceType);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.iec;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                ae.cZx().gs(paramPreference[i], this.mDeviceType);
                i += 1;
              }
            }
          }
          paramf = new y(paramf, 2);
          h(paramf);
          bh.aGY().a(537, this);
          bh.aGY().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.ay(getContext(), this.vnr);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          bh.beI();
          paramf = com.tencent.mm.model.c.bbL().RG(this.veU);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.veV);
          paramPreference.putExtra("device_type", this.mDeviceType);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.vlt);
          if (paramf != null) {
            if ((d.rk(paramf.field_type)) && (paramf.hxX()))
            {
              af.bjv().Uo(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.veU);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.cYL().d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.veU);
              paramPreference.putExtra("force_get_contact", true);
              com.tencent.mm.by.c.b(getContext(), "profile", ".ui.ContactInfoUI", paramPreference);
            }
          }
        }
      }
    } while (("message_manage".equals(paramPreference.mKey)) || ("connect_setting".equals(paramPreference.mKey)) || ("user_list".equals(paramPreference.mKey)));
    AppMethodBeat.o(24024);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(24025);
    Log.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq == null)
    {
      Log.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
      AppMethodBeat.o(24025);
      return;
    }
    Log.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if ((paramq instanceof l))
    {
      daq();
      bh.aGY().b(paramq.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        dax();
        AppMethodBeat.o(24025);
        return;
      }
      day();
      f(ae.cZx().gq(this.veV, this.mDeviceType));
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
    if ((paramq instanceof com.tencent.mm.plugin.exdevice.model.m))
    {
      daq();
      bh.aGY().b(paramq.getType(), this);
      com.tencent.mm.plugin.exdevice.i.b localb = ae.cZx().Jw(com.tencent.mm.plugin.exdevice.k.b.avW(this.shW));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        dax();
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
      day();
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramq instanceof z))
    {
      daq();
      bh.aGY().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        Toast.makeText(getContext(), getString(R.l.eDw), 1).show();
        AppMethodBeat.o(24025);
        return;
      }
      this.vns = ((z)paramq).idS;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24019);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().byG("device_profile_header"));
          AppMethodBeat.o(24019);
        }
      });
      paramString = ae.cZx().gq(this.veV, this.mDeviceType);
      if (paramString == null)
      {
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.veV, this.mDeviceType });
        AppMethodBeat.o(24025);
        return;
      }
      paramString.Iq(this.vns);
      ae.cZx().update(paramString, new String[0]);
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramq instanceof y))
    {
      daq();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24011);
            Toast.makeText(ExdeviceDeviceProfileUI.this.getContext(), R.l.eEj, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */