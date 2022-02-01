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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.do;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.cat;
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
import java.util.Iterator;
import java.util.List;

public class ExdeviceDeviceProfileUI
  extends MMPreference
  implements i
{
  private String dfJ;
  private com.tencent.mm.ui.base.q gxX;
  private String mDeviceType;
  private long rAv;
  private String rFI;
  private String rFJ;
  private String rFd;
  private int rGG;
  private com.tencent.mm.ui.base.q rGN = null;
  private String rHJ;
  private String rHK;
  private boolean rHL;
  private String rHM;
  private boolean rHN;
  private String rHO;
  private h.b rHP;
  private String rzn;
  private String rzo;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(24023);
    String str;
    if (Util.isNullOrNil(this.rFI))
    {
      str = this.rzn;
      if (Util.isNullOrNil(this.rHK)) {
        break label98;
      }
      paramDeviceProfileHeaderPreference.setName(this.rHK);
      paramDeviceProfileHeaderPreference.anM(getString(2131758830, new Object[] { str }));
      paramDeviceProfileHeaderPreference.ai(3, true);
      paramDeviceProfileHeaderPreference.ai(4, true);
      paramDeviceProfileHeaderPreference.ai(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.Cs(this.rFd);
      AppMethodBeat.o(24023);
      return;
      str = this.rFI;
      break;
      label98:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.anM("");
      paramDeviceProfileHeaderPreference.ai(3, false);
      paramDeviceProfileHeaderPreference.ai(4, false);
      paramDeviceProfileHeaderPreference.ai(1, this.rHL);
    }
  }
  
  private void cLD()
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
  
  private void cLJ()
  {
    AppMethodBeat.i(24022);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.bmg("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758837), "", "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
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
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        h.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758837), ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this), "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24015);
      }
    });
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).setIconUrl(this.rHM);
    localObject = (KeyValuePreference)localf.bmg("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.bmg("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.bmg("user_list");
    ((KeyValuePreference)localObject).BC(true);
    localKeyValuePreference1.BC(true);
    localKeyValuePreference2.BC(true);
    localf.jdMethod_do("message_manage", true);
    localf.jdMethod_do("connect_setting", true);
    localf.jdMethod_do("user_list", true);
    if (this.rHN)
    {
      localf.jdMethod_do("sub_device_desc", false);
      localf.bmg("sub_device_desc").setTitle(getResources().getString(2131758917, new Object[] { this.rHO }));
      localf.jdMethod_do("bind_device", true);
      localf.jdMethod_do("unbind_device", true);
      if (Util.isNullOrNil(this.rHJ)) {
        localf.jdMethod_do("open_device_panel", true);
      }
      AppMethodBeat.o(24022);
      return;
    }
    localf.jdMethod_do("sub_device_desc", true);
    localf.jdMethod_do("bind_device", this.rHL);
    if (!this.rHL) {}
    for (boolean bool = true;; bool = false)
    {
      localf.jdMethod_do("unbind_device", bool);
      break;
    }
  }
  
  private void cLK()
  {
    AppMethodBeat.i(24029);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24005);
        h.c(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(2131758778), ExdeviceDeviceProfileUI.this.getString(2131755998), true);
        AppMethodBeat.o(24005);
      }
    });
    AppMethodBeat.o(24029);
  }
  
  private void cLL()
  {
    AppMethodBeat.i(24030);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24008);
        ExdeviceDeviceProfileUI localExdeviceDeviceProfileUI = ExdeviceDeviceProfileUI.this;
        ExdeviceDeviceProfileUI.this.getString(2131755998);
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
                ExdeviceDeviceProfileUI.4.1.this.rHR.dismiss();
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
      this.rzo = paramb.field_deviceID;
      this.mDeviceType = paramb.field_deviceType;
      this.rHK = Util.nullAsNil(paramb.fMb);
      this.rFI = Util.nullAsNil(paramb.fMc);
      this.rzn = Util.nullAsNil(paramb.field_brandName);
      this.rFd = Util.nullAsNil(paramb.fMd);
      this.rHM = Util.nullAsNil(paramb.iconUrl);
      this.rHJ = Util.nullAsNil(paramb.jumpUrl);
    }
    AppMethodBeat.o(24027);
  }
  
  private void h(final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(24031);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24010);
        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, h.a(ExdeviceDeviceProfileUI.this.getContext(), ExdeviceDeviceProfileUI.this.getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(24009);
            bg.azz().a(ExdeviceDeviceProfileUI.5.this.dAK);
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
    return 2132017208;
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
    setMMTitle(2131758786);
    setActionbarColor(getContext().getResources().getColor(2131101424));
    this.rHP = new h.b()
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
              ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().bmg("device_profile_header"));
              AppMethodBeat.o(24012);
            }
          });
          paramAnonymousCharSequence = ad.cKL().gb(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this));
          if (paramAnonymousCharSequence == null)
          {
            Log.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this) });
            AppMethodBeat.o(24013);
            return false;
          }
          paramAnonymousCharSequence.BC(ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this));
          ad.cKL().update(paramAnonymousCharSequence, new String[0]);
        }
        for (;;)
        {
          AppMethodBeat.o(24013);
          return true;
          paramAnonymousCharSequence = new y(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this), str);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, paramAnonymousCharSequence);
          bg.azz().a(1263, ExdeviceDeviceProfileUI.this);
          bg.azz().a(paramAnonymousCharSequence, 0);
        }
      }
    };
    paramBundle = getIntent();
    this.dfJ = paramBundle.getStringExtra("device_mac");
    this.rAv = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.rHJ = paramBundle.getStringExtra("device_jump_url");
    this.rzn = paramBundle.getStringExtra("device_brand_name");
    this.rzo = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.rFJ = paramBundle.getStringExtra("bind_ticket");
    this.rGG = paramBundle.getIntExtra("subscribe_flag", 0);
    this.rHL = paramBundle.getBooleanExtra("device_has_bound", false);
    this.rFI = paramBundle.getStringExtra("device_title");
    this.rHK = paramBundle.getStringExtra("device_alias");
    this.rFd = paramBundle.getStringExtra("device_desc");
    this.rHM = paramBundle.getStringExtra("device_icon_url");
    if ((Util.isNullOrNil(this.rzo)) || (Util.isNullOrNil(this.mDeviceType))) {
      Log.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.rzo, this.mDeviceType });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), 2131758845, 1).show();
      finish();
      AppMethodBeat.o(24021);
      return;
      paramBundle = ad.cKL().gb(this.rzo, this.mDeviceType);
      if (paramBundle != null)
      {
        this.rHL = true;
        if (Util.isNullOrNil(this.rHK)) {
          this.rHK = Util.nullAsNil(paramBundle.fMb);
        }
        if (Util.isNullOrNil(this.rFI)) {
          this.rFI = Util.nullAsNil(paramBundle.fMc);
        }
        if (Util.isNullOrNil(this.rzn)) {
          this.rzn = Util.nullAsNil(paramBundle.field_brandName);
        }
        if (Util.isNullOrNil(this.rFd)) {
          this.rFd = Util.nullAsNil(paramBundle.fMd);
        }
        if (Util.isNullOrNil(this.rHM)) {
          this.rHM = Util.nullAsNil(paramBundle.iconUrl);
        }
        if (Util.isNullOrNil(this.rHJ)) {
          this.rHJ = Util.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.fMf == 2)
        {
          this.rHN = true;
          this.rHO = this.rFI;
          paramBundle = ad.cKL().cLB().iterator();
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
            localObject = localb.fMk;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.rzo)) {
              if (!Util.isNullOrNil(localb.fMb)) {
                break label601;
              }
            }
          }
          label601:
          for (this.rHO = localb.fMc;; this.rHO = localb.fMb)
          {
            Log.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.rHO });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (Util.isNullOrNil(this.rFJ)) {
          continue;
        }
      }
      i = 1;
    }
    cLJ();
    AppMethodBeat.o(24021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24026);
    bg.azz().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(24026);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24024);
    Log.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (Util.isNullOrNil(this.rFJ))
      {
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new com.tencent.mm.plugin.exdevice.model.m(com.tencent.mm.plugin.exdevice.k.b.anY(this.dfJ), this.rzn, "3", this.rAv);
        h(paramf);
        bg.azz().a(1262, this);
        bg.azz().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(24024);
        return true;
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.rFJ;
        int i = this.rGG;
        bg.azz().a(536, this);
        paramPreference = new dr();
        paramPreference.dGF.dGH = paramf;
        paramPreference.dGF.opType = 1;
        paramPreference.dGF.dGI = i;
        EventCenter.instance.publish(paramPreference);
        paramf = paramPreference.dGG.dGJ;
        getString(2131755998);
        this.rGN = h.a(this, getString(2131758789), true, new ExdeviceDeviceProfileUI.10(this, paramf));
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new cat();
          paramf.oTH = this.rzo;
          paramf.KLO = this.mDeviceType;
          paramPreference = ad.cKL().gb(this.rzo, this.mDeviceType);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.fMk;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                ad.cKL().gd(paramPreference[i], this.mDeviceType);
                i += 1;
              }
            }
          }
          paramf = new x(paramf, 2);
          h(paramf);
          bg.azz().a(537, this);
          bg.azz().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.f.ay(getContext(), this.rHJ);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          bg.aVF();
          paramf = com.tencent.mm.model.c.aSN().Kn(this.rzn);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.rzo);
          paramPreference.putExtra("device_type", this.mDeviceType);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.rFJ);
          if (paramf != null) {
            if ((com.tencent.mm.contact.c.oR(paramf.field_type)) && (paramf.gBM()))
            {
              ag.bah().MT(paramf.field_username);
              paramPreference.putExtra("Chat_User", this.rzn);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.rxo.d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.rzn);
              paramPreference.putExtra("force_get_contact", true);
              com.tencent.mm.br.c.b(getContext(), "profile", ".ui.ContactInfoUI", paramPreference);
            }
          }
        }
      }
    } while (("message_manage".equals(paramPreference.mKey)) || ("connect_setting".equals(paramPreference.mKey)) || ("user_list".equals(paramPreference.mKey)));
    AppMethodBeat.o(24024);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      cLD();
      bg.azz().b(paramq.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        cLK();
        AppMethodBeat.o(24025);
        return;
      }
      cLL();
      f(ad.cKL().gb(this.rzo, this.mDeviceType));
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
      cLD();
      bg.azz().b(paramq.getType(), this);
      com.tencent.mm.plugin.exdevice.i.b localb = ad.cKL().Di(com.tencent.mm.plugin.exdevice.k.b.anY(this.dfJ));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        cLK();
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
      cLL();
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramq instanceof y))
    {
      cLD();
      bg.azz().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        Toast.makeText(getContext(), getString(2131758835), 1).show();
        AppMethodBeat.o(24025);
        return;
      }
      this.rHK = ((y)paramq).fMb;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24019);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().bmg("device_profile_header"));
          AppMethodBeat.o(24019);
        }
      });
      paramString = ad.cKL().gb(this.rzo, this.mDeviceType);
      if (paramString == null)
      {
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.rzo, this.mDeviceType });
        AppMethodBeat.o(24025);
        return;
      }
      paramString.BC(this.rHK);
      ad.cKL().update(paramString, new String[0]);
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramq instanceof x))
    {
      cLD();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramq.getType()) });
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24011);
            Toast.makeText(ExdeviceDeviceProfileUI.this.getContext(), 2131758922, 1).show();
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