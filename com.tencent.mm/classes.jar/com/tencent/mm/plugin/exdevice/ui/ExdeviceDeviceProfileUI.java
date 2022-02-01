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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dn.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  implements com.tencent.mm.al.f
{
  private String cOA;
  private p fQJ;
  private String mDeviceType;
  private String qbM;
  private String qbN;
  private long qcV;
  private String qhW;
  private String qhX;
  private String qhr;
  private int qiU;
  private String qjX;
  private String qjY;
  private boolean qjZ;
  private p qjb = null;
  private String qka;
  private boolean qkb;
  private String qkc;
  private h.b qkd;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(24023);
    String str;
    if (bt.isNullOrNil(this.qhW))
    {
      str = this.qbM;
      if (bt.isNullOrNil(this.qjY)) {
        break label98;
      }
      paramDeviceProfileHeaderPreference.setName(this.qjY);
      paramDeviceProfileHeaderPreference.acM(getString(2131758531, new Object[] { str }));
      paramDeviceProfileHeaderPreference.aa(3, true);
      paramDeviceProfileHeaderPreference.aa(4, true);
      paramDeviceProfileHeaderPreference.aa(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.tH(this.qhr);
      AppMethodBeat.o(24023);
      return;
      str = this.qhW;
      break;
      label98:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.acM("");
      paramDeviceProfileHeaderPreference.aa(3, false);
      paramDeviceProfileHeaderPreference.aa(4, false);
      paramDeviceProfileHeaderPreference.aa(1, this.qjZ);
    }
  }
  
  private void cma()
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
  
  private void cmg()
  {
    AppMethodBeat.i(24022);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.aVD("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758538), ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this), "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24015);
      }
    });
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).setIconUrl(this.qka);
    localObject = (KeyValuePreference)localf.aVD("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.aVD("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.aVD("user_list");
    ((KeyValuePreference)localObject).xG(true);
    localKeyValuePreference1.xG(true);
    localKeyValuePreference2.xG(true);
    localf.cP("message_manage", true);
    localf.cP("connect_setting", true);
    localf.cP("user_list", true);
    if (this.qkb)
    {
      localf.cP("sub_device_desc", false);
      localf.aVD("sub_device_desc").setTitle(getResources().getString(2131758613, new Object[] { this.qkc }));
      localf.cP("bind_device", true);
      localf.cP("unbind_device", true);
      if (bt.isNullOrNil(this.qjX)) {
        localf.cP("open_device_panel", true);
      }
      AppMethodBeat.o(24022);
      return;
    }
    localf.cP("sub_device_desc", true);
    localf.cP("bind_device", this.qjZ);
    if (!this.qjZ) {}
    for (boolean bool = true;; bool = false)
    {
      localf.cP("unbind_device", bool);
      break;
    }
  }
  
  private void cmh()
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
  
  private void cmi()
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
                ExdeviceDeviceProfileUI.4.1.this.qkf.dismiss();
                AppMethodBeat.o(24006);
              }
            });
            AppMethodBeat.o(24007);
            return true;
          }
        }, false).az(1000L, 1000L);
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
      this.qbN = paramb.field_deviceID;
      this.mDeviceType = paramb.field_deviceType;
      this.qjY = bt.nullAsNil(paramb.ffB);
      this.qhW = bt.nullAsNil(paramb.ffC);
      this.qbM = bt.nullAsNil(paramb.field_brandName);
      this.qhr = bt.nullAsNil(paramb.ffD);
      this.qka = bt.nullAsNil(paramb.iconUrl);
      this.qjX = bt.nullAsNil(paramb.jumpUrl);
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
            ba.aiU().a(ExdeviceDeviceProfileUI.5.this.diy);
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
    this.qkd = new h.b()
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
              ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aVD("device_profile_header"));
              AppMethodBeat.o(24012);
            }
          });
          paramAnonymousCharSequence = com.tencent.mm.plugin.exdevice.model.ad.clt().fE(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this));
          if (paramAnonymousCharSequence == null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this) });
            AppMethodBeat.o(24013);
            return false;
          }
          paramAnonymousCharSequence.sQ(ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this));
          com.tencent.mm.plugin.exdevice.model.ad.clt().update(paramAnonymousCharSequence, new String[0]);
        }
        for (;;)
        {
          AppMethodBeat.o(24013);
          return true;
          paramAnonymousCharSequence = new y(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this), str);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, paramAnonymousCharSequence);
          ba.aiU().a(1263, ExdeviceDeviceProfileUI.this);
          ba.aiU().a(paramAnonymousCharSequence, 0);
        }
      }
    };
    paramBundle = getIntent();
    this.cOA = paramBundle.getStringExtra("device_mac");
    this.qcV = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.qjX = paramBundle.getStringExtra("device_jump_url");
    this.qbM = paramBundle.getStringExtra("device_brand_name");
    this.qbN = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.qhX = paramBundle.getStringExtra("bind_ticket");
    this.qiU = paramBundle.getIntExtra("subscribe_flag", 0);
    this.qjZ = paramBundle.getBooleanExtra("device_has_bound", false);
    this.qhW = paramBundle.getStringExtra("device_title");
    this.qjY = paramBundle.getStringExtra("device_alias");
    this.qhr = paramBundle.getStringExtra("device_desc");
    this.qka = paramBundle.getStringExtra("device_icon_url");
    if ((bt.isNullOrNil(this.qbN)) || (bt.isNullOrNil(this.mDeviceType))) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.qbN, this.mDeviceType });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), 2131758546, 1).show();
      finish();
      AppMethodBeat.o(24021);
      return;
      paramBundle = com.tencent.mm.plugin.exdevice.model.ad.clt().fE(this.qbN, this.mDeviceType);
      if (paramBundle != null)
      {
        this.qjZ = true;
        if (bt.isNullOrNil(this.qjY)) {
          this.qjY = bt.nullAsNil(paramBundle.ffB);
        }
        if (bt.isNullOrNil(this.qhW)) {
          this.qhW = bt.nullAsNil(paramBundle.ffC);
        }
        if (bt.isNullOrNil(this.qbM)) {
          this.qbM = bt.nullAsNil(paramBundle.field_brandName);
        }
        if (bt.isNullOrNil(this.qhr)) {
          this.qhr = bt.nullAsNil(paramBundle.ffD);
        }
        if (bt.isNullOrNil(this.qka)) {
          this.qka = bt.nullAsNil(paramBundle.iconUrl);
        }
        if (bt.isNullOrNil(this.qjX)) {
          this.qjX = bt.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.ffF == 2)
        {
          this.qkb = true;
          this.qkc = this.qhW;
          paramBundle = com.tencent.mm.plugin.exdevice.model.ad.clt().clY().iterator();
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
            localObject = localb.ffK;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.qbN)) {
              if (!bt.isNullOrNil(localb.ffB)) {
                break label601;
              }
            }
          }
          label601:
          for (this.qkc = localb.ffC;; this.qkc = localb.ffB)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.qkc });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (bt.isNullOrNil(this.qhX)) {
          continue;
        }
      }
      i = 1;
    }
    cmg();
    AppMethodBeat.o(24021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24026);
    ba.aiU().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(24026);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24024);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (bt.isNullOrNil(this.qhX))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new com.tencent.mm.plugin.exdevice.model.m(com.tencent.mm.plugin.exdevice.k.b.acY(this.cOA), this.qbM, "3", this.qcV);
        h(paramf);
        ba.aiU().a(1262, this);
        ba.aiU().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(24024);
        return true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.qhX;
        int i = this.qiU;
        ba.aiU().a(536, this);
        paramPreference = new dn();
        paramPreference.don.dop = paramf;
        paramPreference.don.opType = 1;
        paramPreference.don.doq = i;
        com.tencent.mm.sdk.b.a.IbL.l(paramPreference);
        paramf = paramPreference.doo.dor;
        getString(2131755906);
        this.qjb = h.b(this, getString(2131758490), true, new ExdeviceDeviceProfileUI.10(this, paramf));
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new bnj();
          paramf.nDr = this.qbN;
          paramf.FzJ = this.mDeviceType;
          paramPreference = com.tencent.mm.plugin.exdevice.model.ad.clt().fE(this.qbN, this.mDeviceType);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.ffK;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                com.tencent.mm.plugin.exdevice.model.ad.clt().fG(paramPreference[i], this.mDeviceType);
                i += 1;
              }
            }
          }
          paramf = new x(paramf, 2);
          h(paramf);
          ba.aiU().a(537, this);
          ba.aiU().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.an(getContext(), this.qjX);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          ba.aBQ();
          paramf = com.tencent.mm.model.c.azp().Bf(this.qbM);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.qbN);
          paramPreference.putExtra("device_type", this.mDeviceType);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.qhX);
          if (paramf != null) {
            if ((com.tencent.mm.o.b.lM(paramf.field_type)) && (paramf.fqg()))
            {
              ag.aFZ().DD(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.qbM);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.pZN.d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.qbM);
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
    if ((paramn instanceof l))
    {
      cma();
      ba.aiU().b(paramn.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        cmh();
        AppMethodBeat.o(24025);
        return;
      }
      cmi();
      f(com.tencent.mm.plugin.exdevice.model.ad.clt().fE(this.qbN, this.mDeviceType));
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
      cma();
      ba.aiU().b(paramn.getType(), this);
      com.tencent.mm.plugin.exdevice.i.b localb = com.tencent.mm.plugin.exdevice.model.ad.clt().uN(com.tencent.mm.plugin.exdevice.k.b.acY(this.cOA));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        cmh();
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
      cmi();
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof y))
    {
      cma();
      ba.aiU().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramn.getType()) });
        Toast.makeText(getContext(), getString(2131758536), 1).show();
        AppMethodBeat.o(24025);
        return;
      }
      this.qjY = ((y)paramn).ffB;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24019);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().aVD("device_profile_header"));
          AppMethodBeat.o(24019);
        }
      });
      paramString = com.tencent.mm.plugin.exdevice.model.ad.clt().fE(this.qbN, this.mDeviceType);
      if (paramString == null)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.qbN, this.mDeviceType });
        AppMethodBeat.o(24025);
        return;
      }
      paramString.sQ(this.qjY);
      com.tencent.mm.plugin.exdevice.model.ad.clt().update(paramString, new String[0]);
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramn instanceof x))
    {
      cma();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */