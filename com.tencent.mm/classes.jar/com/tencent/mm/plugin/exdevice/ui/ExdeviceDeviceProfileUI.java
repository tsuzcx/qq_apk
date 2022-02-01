package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.ei;
import com.tencent.mm.autogen.a.ei.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.model.ab;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.exdevice.model.n;
import com.tencent.mm.plugin.exdevice.model.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.List;

public class ExdeviceDeviceProfileUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private w lKp;
  private String mDeviceType;
  private String mJumpUrl;
  private String vtX;
  private String yqR;
  private String yqS;
  private long ysa;
  private String yxU;
  private String yxV;
  private String yxq;
  private int yyR;
  private w yyY = null;
  private String yzT;
  private boolean yzU;
  private String yzV;
  private boolean yzW;
  private String yzX;
  private k.b yzY;
  
  private void a(DeviceProfileHeaderPreference paramDeviceProfileHeaderPreference)
  {
    AppMethodBeat.i(24023);
    String str;
    if (Util.isNullOrNil(this.yxU))
    {
      str = this.yqR;
      if (Util.isNullOrNil(this.yzT)) {
        break label99;
      }
      paramDeviceProfileHeaderPreference.setName(this.yzT);
      paramDeviceProfileHeaderPreference.apL(getString(R.l.gGg, new Object[] { str }));
      paramDeviceProfileHeaderPreference.az(3, true);
      paramDeviceProfileHeaderPreference.az(4, true);
      paramDeviceProfileHeaderPreference.az(1, false);
    }
    for (;;)
    {
      paramDeviceProfileHeaderPreference.BL(this.yxq);
      AppMethodBeat.o(24023);
      return;
      str = this.yxU;
      break;
      label99:
      paramDeviceProfileHeaderPreference.setName(str);
      paramDeviceProfileHeaderPreference.apL("");
      paramDeviceProfileHeaderPreference.az(3, false);
      paramDeviceProfileHeaderPreference.az(4, false);
      paramDeviceProfileHeaderPreference.az(1, this.yzU);
    }
  }
  
  private void dGL()
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
  
  private void dGR()
  {
    AppMethodBeat.i(24022);
    com.tencent.mm.ui.base.preference.f localf = getPreferenceScreen();
    Object localObject = (DeviceProfileHeaderPreference)localf.bAi("device_profile_header");
    ((DeviceProfileHeaderPreference)localObject).a(1, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        k.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.gGl), "", "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
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
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        k.a(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.gGl), ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this), "", 50, ExdeviceDeviceProfileUI.e(ExdeviceDeviceProfileUI.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceDeviceProfileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24015);
      }
    });
    a((DeviceProfileHeaderPreference)localObject);
    ((DeviceProfileHeaderPreference)localObject).setIconUrl(this.yzV);
    localObject = (KeyValuePreference)localf.bAi("message_manage");
    KeyValuePreference localKeyValuePreference1 = (KeyValuePreference)localf.bAi("connect_setting");
    KeyValuePreference localKeyValuePreference2 = (KeyValuePreference)localf.bAi("user_list");
    ((KeyValuePreference)localObject).LG(true);
    localKeyValuePreference1.LG(true);
    localKeyValuePreference2.LG(true);
    localf.eh("message_manage", true);
    localf.eh("connect_setting", true);
    localf.eh("user_list", true);
    if (this.yzW)
    {
      localf.eh("sub_device_desc", false);
      localf.bAi("sub_device_desc").setTitle(getResources().getString(R.l.gGY, new Object[] { this.yzX }));
      localf.eh("bind_device", true);
      localf.eh("unbind_device", true);
      if (Util.isNullOrNil(this.mJumpUrl)) {
        localf.eh("open_device_panel", true);
      }
      AppMethodBeat.o(24022);
      return;
    }
    localf.eh("sub_device_desc", true);
    localf.eh("bind_device", this.yzU);
    if (!this.yzU) {}
    for (boolean bool = true;; bool = false)
    {
      localf.eh("unbind_device", bool);
      break;
    }
  }
  
  private void dGS()
  {
    AppMethodBeat.i(24029);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24005);
        k.c(ExdeviceDeviceProfileUI.this, ExdeviceDeviceProfileUI.this.getString(R.l.gFB), ExdeviceDeviceProfileUI.this.getString(R.l.app_tip), true);
        AppMethodBeat.o(24005);
      }
    });
    AppMethodBeat.o(24029);
  }
  
  private void dGT()
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
                ExdeviceDeviceProfileUI.4.1.this.yAa.dismiss();
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
      this.yqS = paramb.field_deviceID;
      this.mDeviceType = paramb.field_deviceType;
      this.yzT = Util.nullAsNil(paramb.kDc);
      this.yxU = Util.nullAsNil(paramb.kDd);
      this.yqR = Util.nullAsNil(paramb.field_brandName);
      this.yxq = Util.nullAsNil(paramb.kDe);
      this.yzV = Util.nullAsNil(paramb.iconUrl);
      this.mJumpUrl = Util.nullAsNil(paramb.jumpUrl);
    }
    AppMethodBeat.o(24027);
  }
  
  private void h(final p paramp)
  {
    AppMethodBeat.i(24031);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24010);
        ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, k.a(ExdeviceDeviceProfileUI.this.getContext(), ExdeviceDeviceProfileUI.this.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(24009);
            bh.aZW().a(ExdeviceDeviceProfileUI.5.this.hxO);
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
    return R.o.hbc;
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
    setMMTitle(R.l.gFG);
    setActionbarColor(getContext().getResources().getColor(R.e.white));
    this.yzY = new k.b()
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
              ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().bAi("device_profile_header"));
              AppMethodBeat.o(24012);
            }
          });
          paramAnonymousCharSequence = ah.dFO().gU(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this));
          if (paramAnonymousCharSequence == null)
          {
            Log.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this) });
            AppMethodBeat.o(24013);
            return false;
          }
          paramAnonymousCharSequence.AV(ExdeviceDeviceProfileUI.d(ExdeviceDeviceProfileUI.this));
          ah.dFO().update(paramAnonymousCharSequence, new String[0]);
        }
        for (;;)
        {
          AppMethodBeat.o(24013);
          return true;
          paramAnonymousCharSequence = new ac(ExdeviceDeviceProfileUI.b(ExdeviceDeviceProfileUI.this), ExdeviceDeviceProfileUI.c(ExdeviceDeviceProfileUI.this), str);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, paramAnonymousCharSequence);
          bh.aZW().a(1263, ExdeviceDeviceProfileUI.this);
          bh.aZW().a(paramAnonymousCharSequence, 0);
        }
      }
    };
    paramBundle = getIntent();
    this.vtX = paramBundle.getStringExtra("device_mac");
    this.ysa = paramBundle.getLongExtra("device_ble_simple_proto", 0L);
    this.mJumpUrl = paramBundle.getStringExtra("device_jump_url");
    this.yqR = paramBundle.getStringExtra("device_brand_name");
    this.yqS = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.yxV = paramBundle.getStringExtra("bind_ticket");
    this.yyR = paramBundle.getIntExtra("subscribe_flag", 0);
    this.yzU = paramBundle.getBooleanExtra("device_has_bound", false);
    this.yxU = paramBundle.getStringExtra("device_title");
    this.yzT = paramBundle.getStringExtra("device_alias");
    this.yxq = paramBundle.getStringExtra("device_desc");
    this.yzV = paramBundle.getStringExtra("device_icon_url");
    if ((Util.isNullOrNil(this.yqS)) || (Util.isNullOrNil(this.mDeviceType))) {
      Log.e("MicroMsg.ExdeviceDeviceProfileUI", "deviceId or deviceType is null.", new Object[] { this.yqS, this.mDeviceType });
    }
    while (i == 0)
    {
      Toast.makeText(getContext(), R.l.gGn, 1).show();
      finish();
      AppMethodBeat.o(24021);
      return;
      paramBundle = ah.dFO().gU(this.yqS, this.mDeviceType);
      if (paramBundle != null)
      {
        this.yzU = true;
        if (Util.isNullOrNil(this.yzT)) {
          this.yzT = Util.nullAsNil(paramBundle.kDc);
        }
        if (Util.isNullOrNil(this.yxU)) {
          this.yxU = Util.nullAsNil(paramBundle.kDd);
        }
        if (Util.isNullOrNil(this.yqR)) {
          this.yqR = Util.nullAsNil(paramBundle.field_brandName);
        }
        if (Util.isNullOrNil(this.yxq)) {
          this.yxq = Util.nullAsNil(paramBundle.kDe);
        }
        if (Util.isNullOrNil(this.yzV)) {
          this.yzV = Util.nullAsNil(paramBundle.iconUrl);
        }
        if (Util.isNullOrNil(this.mJumpUrl)) {
          this.mJumpUrl = Util.nullAsNil(paramBundle.jumpUrl);
        }
        if (paramBundle.kDh == 2)
        {
          this.yzW = true;
          this.yzX = this.yxU;
          paramBundle = ah.dFO().dGH().iterator();
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
            localObject = localb.kDm;
          } while ((localObject == null) || (((String)localObject).length() <= 0));
          Object localObject = ((String)localObject).split(",");
          i = 0;
          label535:
          if (i < localObject.length) {
            if (localObject[i].equals(this.yqS)) {
              if (!Util.isNullOrNil(localb.kDc)) {
                break label601;
              }
            }
          }
          label601:
          for (this.yzX = localb.kDd;; this.yzX = localb.kDc)
          {
            Log.i("MicroMsg.ExdeviceDeviceProfileUI", "mGateWayTitle %s", new Object[] { this.yzX });
            i += 1;
            break label535;
            break;
          }
        }
      }
      else
      {
        if (Util.isNullOrNil(this.yxV)) {
          continue;
        }
      }
      i = 1;
    }
    dGR();
    AppMethodBeat.o(24021);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24026);
    bh.aZW().b(537, this);
    super.onDestroy();
    AppMethodBeat.o(24026);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(24024);
    Log.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[] { paramPreference.mKey });
    if ("bind_device".equals(paramPreference.mKey)) {
      if (Util.isNullOrNil(this.yxV))
      {
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
        paramf = new o(com.tencent.mm.plugin.exdevice.k.b.apW(this.vtX), this.yqR, "3", this.ysa);
        h(paramf);
        bh.aZW().a(1262, this);
        bh.aZW().a(paramf, 0);
      }
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(24024);
        return true;
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
        paramf = this.yxV;
        int i = this.yyR;
        bh.aZW().a(536, this);
        paramPreference = new ei();
        paramPreference.hEe.hEg = paramf;
        paramPreference.hEe.opType = 1;
        paramPreference.hEe.hEh = i;
        paramPreference.publish();
        paramf = paramPreference.hEf.hEi;
        getString(R.l.app_tip);
        this.yyY = k.a(this, getString(R.l.gFI), true, new ExdeviceDeviceProfileUI.10(this, paramf));
        continue;
        if ("unbind_device".equals(paramPreference.mKey))
        {
          paramf = new cyx();
          paramf.vgV = this.yqS;
          paramf.YJY = this.mDeviceType;
          paramPreference = ah.dFO().gU(this.yqS, this.mDeviceType);
          if (paramPreference != null)
          {
            paramPreference = paramPreference.kDm;
            if ((paramPreference != null) && (paramPreference.length() > 0))
            {
              paramPreference = paramPreference.split(",");
              i = 0;
              while (i < paramPreference.length)
              {
                ah.dFO().gW(paramPreference[i], this.mDeviceType);
                i += 1;
              }
            }
          }
          paramf = new ab(paramf, 2);
          h(paramf);
          bh.aZW().a(537, this);
          bh.aZW().a(paramf, 0);
        }
        else if ("open_device_panel".equals(paramPreference.mKey))
        {
          com.tencent.mm.plugin.exdevice.model.h.az(getContext(), this.mJumpUrl);
        }
        else
        {
          if (!"contact_info_biz_go_chatting".equals(paramPreference.mKey)) {
            break;
          }
          bh.bCz();
          paramf = com.tencent.mm.model.c.bzA().JE(this.yqR);
          paramPreference = new Intent();
          paramPreference.putExtra("device_id", this.yqS);
          paramPreference.putExtra("device_type", this.mDeviceType);
          paramPreference.putExtra("KIsHardDevice", true);
          paramPreference.putExtra("KHardDeviceBindTicket", this.yxV);
          if (paramf != null) {
            if ((d.rs(paramf.field_type)) && (paramf.iZC()) && (af.bHf().Mn(paramf.field_username) != null))
            {
              paramPreference.putExtra("Chat_User", this.yqR);
              paramPreference.putExtra("finish_direct", true);
              com.tencent.mm.plugin.exdevice.a.dFc().d(paramPreference, getContext());
            }
            else
            {
              paramPreference.putExtra("Contact_User", this.yqR);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(24025);
    Log.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      Log.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
      AppMethodBeat.o(24025);
      return;
    }
    Log.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[] { Integer.valueOf(paramp.getType()) });
    if ((paramp instanceof n))
    {
      dGL();
      bh.aZW().b(paramp.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramp.getType()) });
        dGS();
        AppMethodBeat.o(24025);
        return;
      }
      dGT();
      f(ah.dFO().gU(this.yqS, this.mDeviceType));
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
    if ((paramp instanceof o))
    {
      dGL();
      bh.aZW().b(paramp.getType(), this);
      com.tencent.mm.plugin.exdevice.i.b localb = ah.dFO().lM(com.tencent.mm.plugin.exdevice.k.b.apW(this.vtX));
      if ((paramInt1 != 0) || (paramInt2 != 0) || (localb == null))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramp.getType()) });
        dGS();
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
      dGT();
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramp instanceof ac))
    {
      dGL();
      bh.aZW().b(1263, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramp.getType()) });
        Toast.makeText(getContext(), getString(R.l.gGk), 1).show();
        AppMethodBeat.o(24025);
        return;
      }
      this.yzT = ((ac)paramp).kDc;
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(24019);
          ExdeviceDeviceProfileUI.a(ExdeviceDeviceProfileUI.this, (DeviceProfileHeaderPreference)ExdeviceDeviceProfileUI.this.getPreferenceScreen().bAi("device_profile_header"));
          AppMethodBeat.o(24019);
        }
      });
      paramString = ah.dFO().gU(this.yqS, this.mDeviceType);
      if (paramString == null)
      {
        Log.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[] { this.yqS, this.mDeviceType });
        AppMethodBeat.o(24025);
        return;
      }
      paramString.AV(this.yzT);
      ah.dFO().update(paramString, new String[0]);
      AppMethodBeat.o(24025);
      return;
    }
    if ((paramp instanceof ab))
    {
      dGL();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramp.getType()) });
        runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(24011);
            Toast.makeText(ExdeviceDeviceProfileUI.this.getContext(), R.l.gHa, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI
 * JD-Core Version:    0.7.0.1
 */