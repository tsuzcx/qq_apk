package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI
  extends MMActivity
  implements f
{
  private String HF;
  private Button jtd;
  private String mDeviceType;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private String mTitle;
  private String pMn;
  private String qir;
  private String qis;
  private String qnW;
  private String qoA;
  private String qoB;
  private String qoC;
  private long qoD;
  private ArrayList<String> qoE;
  private String qoF;
  private boolean qoG;
  private boolean qoH;
  private TextView qob;
  private LocationManager qoe;
  private boolean qof;
  private ExdeviceBindDeviceGuideUI.a qot;
  private Button qou;
  private TextView qov;
  private ScrollView qow;
  private ImageView qox;
  private TextView qoy;
  private String qoz;
  
  public ExdeviceBindDeviceGuideUI()
  {
    AppMethodBeat.i(23887);
    this.qoG = false;
    this.qoH = false;
    this.qof = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(23882);
        ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(23882);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ae.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[] { paramAnonymousContext });
        int i;
        if (("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramAnonymousContext)) && (ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
        {
          i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
          if (i == 12)
          {
            if ((!ExdeviceBindDeviceGuideUI.o(ExdeviceBindDeviceGuideUI.this)) || (ExdeviceBindDeviceGuideUI.p(ExdeviceBindDeviceGuideUI.this).isProviderEnabled("gps")))
            {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
              AppMethodBeat.o(23882);
            }
          }
          else
          {
            if (i == 10) {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
            }
            AppMethodBeat.o(23882);
          }
        }
        else
        {
          if (("android.net.wifi.WIFI_STATE_CHANGED".equals(paramAnonymousContext)) && (ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)))
          {
            i = paramAnonymousIntent.getIntExtra("wifi_state", -1);
            ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[] { Integer.valueOf(i) });
            if (i == 3)
            {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 1);
              AppMethodBeat.o(23882);
              return;
            }
            if (i == 1) {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 5);
            }
            AppMethodBeat.o(23882);
            return;
          }
          if ((!ExdeviceBindDeviceGuideUI.o(ExdeviceBindDeviceGuideUI.this)) || (!"android.location.MODE_CHANGED".equals(paramAnonymousContext))) {
            break label302;
          }
          if (ExdeviceBindDeviceGuideUI.p(ExdeviceBindDeviceGuideUI.this).isProviderEnabled("gps"))
          {
            if (!com.tencent.mm.plugin.d.a.e.a.bNP())
            {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
              AppMethodBeat.o(23882);
              return;
            }
            ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
            AppMethodBeat.o(23882);
            return;
          }
        }
        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 6);
        label302:
        AppMethodBeat.o(23882);
      }
    };
    AppMethodBeat.o(23887);
  }
  
  private void CP(int paramInt)
  {
    AppMethodBeat.i(23890);
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(23890);
      return;
      this.qou.setText(getContext().getString(2131758507));
      this.jtd.setVisibility(8);
      this.qov.setText(getContext().getString(2131758506));
      break;
      this.qou.setText(getContext().getString(2131758515));
      this.jtd.setText(getContext().getString(2131758474));
      this.qov.setText(getContext().getString(2131758516));
      break;
      this.qox.setImageResource(2131689789);
      this.qob.setText(2131758494);
      this.qoy.setText(2131758478);
      break;
      this.qox.setImageResource(2131689789);
      this.qob.setText(2131758492);
      this.qoy.setText("");
      break;
      this.qox.setImageResource(2131691457);
      this.qob.setText(2131758494);
      this.qoy.setText(2131758489);
      break;
      this.qox.setImageResource(2131689789);
      this.qob.setText(2131758494);
      this.qoy.setText(2131758542);
      break;
      this.qox.setVisibility(8);
      this.qob.setVisibility(8);
      this.qoy.setVisibility(8);
      this.mListView.setVisibility(0);
      this.qow.setVisibility(0);
      AppMethodBeat.o(23890);
      return;
      this.qox.setVisibility(0);
      this.qob.setVisibility(0);
      this.mListView.setVisibility(8);
      this.qow.setVisibility(8);
      if (paramInt == 4)
      {
        this.qoy.setVisibility(8);
        AppMethodBeat.o(23890);
        return;
      }
      this.qoy.setVisibility(0);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493856;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23888);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(23879);
        ExdeviceBindDeviceGuideUI.this.finish();
        AppMethodBeat.o(23879);
        return true;
      }
    });
    if ((com.tencent.mm.compatible.util.d.lA(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
    {
      ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[] { Build.VERSION.RELEASE });
      this.qof = true;
    }
    paramBundle = getIntent();
    this.qoz = paramBundle.getStringExtra("device_scan_mode");
    this.qoA = paramBundle.getStringExtra("device_scan_conn_proto");
    this.qis = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.qoB = paramBundle.getStringExtra("device_title");
    this.qnW = paramBundle.getStringExtra("device_desc");
    this.pMn = paramBundle.getStringExtra("device_icon_url");
    this.HF = paramBundle.getStringExtra("device_category_id");
    this.qir = paramBundle.getStringExtra("device_brand_name");
    this.qoC = paramBundle.getStringExtra("bind_ticket");
    this.qoD = paramBundle.getLongExtra("device_ble_simple_proto", -1L);
    this.qoE = paramBundle.getStringArrayListExtra("device_airkiss_steps");
    this.qoF = paramBundle.getStringExtra("device_airkiss_key");
    this.mTitle = paramBundle.getStringExtra("device_airkiss_title");
    ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[] { Integer.valueOf(this.qoE.size()) });
    this.qoe = ((LocationManager)getContext().getSystemService("location"));
    this.mListView = ((ListView)findViewById(2131298741));
    paramBundle = View.inflate(this, 2131493850, null);
    this.qov = ((TextView)paramBundle.findViewById(2131305905));
    this.qot = new ExdeviceBindDeviceGuideUI.a(this.qoE);
    this.mListView.addHeaderView(paramBundle);
    this.mListView.setDividerHeight(0);
    this.mListView.setClickable(false);
    this.mListView.setFooterDividersEnabled(false);
    this.mListView.setAdapter(this.qot);
    this.qox = ((ImageView)findViewById(2131301586));
    this.qow = ((ScrollView)findViewById(2131300668));
    this.qou = ((Button)findViewById(2131298575));
    this.jtd = ((Button)findViewById(2131302851));
    this.qob = ((TextView)findViewById(2131299511));
    this.qoy = ((TextView)findViewById(2131299512));
    paramBundle = "";
    if (this.qoz.compareTo("SCAN_CATALOG") == 0) {
      if (this.qoA.contains("wifi"))
      {
        this.qoG = true;
        paramBundle = getContext().getString(2131758515);
        setMMTitle(paramBundle);
        if ((!this.qoH) || (this.qoG)) {
          break label746;
        }
        if (com.tencent.mm.plugin.d.a.e.a.et(getContext())) {
          break label680;
        }
        ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        CP(4);
      }
    }
    for (;;)
    {
      this.qou.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23880);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.b(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_id", ExdeviceBindDeviceGuideUI.c(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_type", ExdeviceBindDeviceGuideUI.d(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_title", ExdeviceBindDeviceGuideUI.e(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_desc", ExdeviceBindDeviceGuideUI.f(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.g(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.h(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.i(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.j(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("device_ble_simple_proto", ExdeviceBindDeviceGuideUI.k(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("encryptKey", ExdeviceBindDeviceGuideUI.l(ExdeviceBindDeviceGuideUI.this));
          paramAnonymousView.putExtra("jumpToBindDevice", true);
          if ((ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this))) {
            com.tencent.mm.br.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(23880);
            return;
            if ((ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
            {
              paramAnonymousView.putExtra("exdevice_airkiss_open_type", 2);
              com.tencent.mm.br.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", paramAnonymousView);
            }
          }
        }
      });
      this.jtd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23881);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.b(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_id", ExdeviceBindDeviceGuideUI.c(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_type", ExdeviceBindDeviceGuideUI.d(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_title", ExdeviceBindDeviceGuideUI.e(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_desc", ExdeviceBindDeviceGuideUI.f(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.g(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.h(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.i(ExdeviceBindDeviceGuideUI.this));
            paramAnonymousView.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.j(ExdeviceBindDeviceGuideUI.this));
            com.tencent.mm.br.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(23881);
        }
      });
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramBundle.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      paramBundle.addAction("android.location.MODE_CHANGED");
      getContext().registerReceiver(this.mReceiver, paramBundle);
      AppMethodBeat.o(23888);
      return;
      if (this.qoA.contains("blue"))
      {
        this.qoH = true;
        paramBundle = getContext().getString(2131758482);
        break;
      }
      Assert.assertTrue(false);
      break;
      Assert.assertTrue(false);
      break;
      label680:
      if (!com.tencent.mm.plugin.d.a.e.a.bNP())
      {
        ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
        CP(3);
      }
      else if ((this.qoe != null) && (this.qof) && (!this.qoe.isProviderEnabled("gps")))
      {
        ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
        CP(6);
      }
      else
      {
        label746:
        if ((!this.qoH) && (this.qoG) && (!az.isWifi(getContext())))
        {
          ae.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
          CP(5);
        }
        else if ((this.qoG) && (!this.qoH))
        {
          CP(1);
        }
        else if ((this.qoH) && (!this.qoG))
        {
          CP(2);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23889);
    super.onDestroy();
    getContext().unregisterReceiver(this.mReceiver);
    AppMethodBeat.o(23889);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI
 * JD-Core Version:    0.7.0.1
 */