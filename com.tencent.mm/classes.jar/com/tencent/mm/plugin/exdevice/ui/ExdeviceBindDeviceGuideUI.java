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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI
  extends MMActivity
  implements f
{
  private String HF;
  private Button jqk;
  private String mDeviceType;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private String mTitle;
  private String pFJ;
  private String qbM;
  private String qbN;
  private boolean qhA;
  private ExdeviceBindDeviceGuideUI.a qhO;
  private Button qhP;
  private TextView qhQ;
  private ScrollView qhR;
  private ImageView qhS;
  private TextView qhT;
  private String qhU;
  private String qhV;
  private String qhW;
  private String qhX;
  private long qhY;
  private ArrayList<String> qhZ;
  private String qhr;
  private TextView qhw;
  private LocationManager qhz;
  private String qia;
  private boolean qib;
  private boolean qic;
  
  public ExdeviceBindDeviceGuideUI()
  {
    AppMethodBeat.i(23887);
    this.qib = false;
    this.qic = false;
    this.qhA = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(23882);
        ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(23882);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ad.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[] { paramAnonymousContext });
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
            ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[] { Integer.valueOf(i) });
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
            if (!com.tencent.mm.plugin.d.a.e.a.bMR())
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
  
  private void CD(int paramInt)
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
      this.qhP.setText(getContext().getString(2131758507));
      this.jqk.setVisibility(8);
      this.qhQ.setText(getContext().getString(2131758506));
      break;
      this.qhP.setText(getContext().getString(2131758515));
      this.jqk.setText(getContext().getString(2131758474));
      this.qhQ.setText(getContext().getString(2131758516));
      break;
      this.qhS.setImageResource(2131689789);
      this.qhw.setText(2131758494);
      this.qhT.setText(2131758478);
      break;
      this.qhS.setImageResource(2131689789);
      this.qhw.setText(2131758492);
      this.qhT.setText("");
      break;
      this.qhS.setImageResource(2131691457);
      this.qhw.setText(2131758494);
      this.qhT.setText(2131758489);
      break;
      this.qhS.setImageResource(2131689789);
      this.qhw.setText(2131758494);
      this.qhT.setText(2131758542);
      break;
      this.qhS.setVisibility(8);
      this.qhw.setVisibility(8);
      this.qhT.setVisibility(8);
      this.mListView.setVisibility(0);
      this.qhR.setVisibility(0);
      AppMethodBeat.o(23890);
      return;
      this.qhS.setVisibility(0);
      this.qhw.setVisibility(0);
      this.mListView.setVisibility(8);
      this.qhR.setVisibility(8);
      if (paramInt == 4)
      {
        this.qhT.setVisibility(8);
        AppMethodBeat.o(23890);
        return;
      }
      this.qhT.setVisibility(0);
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
    if ((com.tencent.mm.compatible.util.d.ly(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
    {
      ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[] { Build.VERSION.RELEASE });
      this.qhA = true;
    }
    paramBundle = getIntent();
    this.qhU = paramBundle.getStringExtra("device_scan_mode");
    this.qhV = paramBundle.getStringExtra("device_scan_conn_proto");
    this.qbN = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.qhW = paramBundle.getStringExtra("device_title");
    this.qhr = paramBundle.getStringExtra("device_desc");
    this.pFJ = paramBundle.getStringExtra("device_icon_url");
    this.HF = paramBundle.getStringExtra("device_category_id");
    this.qbM = paramBundle.getStringExtra("device_brand_name");
    this.qhX = paramBundle.getStringExtra("bind_ticket");
    this.qhY = paramBundle.getLongExtra("device_ble_simple_proto", -1L);
    this.qhZ = paramBundle.getStringArrayListExtra("device_airkiss_steps");
    this.qia = paramBundle.getStringExtra("device_airkiss_key");
    this.mTitle = paramBundle.getStringExtra("device_airkiss_title");
    ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[] { Integer.valueOf(this.qhZ.size()) });
    this.qhz = ((LocationManager)getContext().getSystemService("location"));
    this.mListView = ((ListView)findViewById(2131298741));
    paramBundle = View.inflate(this, 2131493850, null);
    this.qhQ = ((TextView)paramBundle.findViewById(2131305905));
    this.qhO = new ExdeviceBindDeviceGuideUI.a(this.qhZ);
    this.mListView.addHeaderView(paramBundle);
    this.mListView.setDividerHeight(0);
    this.mListView.setClickable(false);
    this.mListView.setFooterDividersEnabled(false);
    this.mListView.setAdapter(this.qhO);
    this.qhS = ((ImageView)findViewById(2131301586));
    this.qhR = ((ScrollView)findViewById(2131300668));
    this.qhP = ((Button)findViewById(2131298575));
    this.jqk = ((Button)findViewById(2131302851));
    this.qhw = ((TextView)findViewById(2131299511));
    this.qhT = ((TextView)findViewById(2131299512));
    paramBundle = "";
    if (this.qhU.compareTo("SCAN_CATALOG") == 0) {
      if (this.qhV.contains("wifi"))
      {
        this.qib = true;
        paramBundle = getContext().getString(2131758515);
        setMMTitle(paramBundle);
        if ((!this.qic) || (this.qib)) {
          break label746;
        }
        if (com.tencent.mm.plugin.d.a.e.a.ep(getContext())) {
          break label680;
        }
        ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        CD(4);
      }
    }
    for (;;)
    {
      this.qhP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23880);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
            com.tencent.mm.bs.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(23880);
            return;
            if ((ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
            {
              paramAnonymousView.putExtra("exdevice_airkiss_open_type", 2);
              com.tencent.mm.bs.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", paramAnonymousView);
            }
          }
        }
      });
      this.jqk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23881);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
            com.tencent.mm.bs.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
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
      if (this.qhV.contains("blue"))
      {
        this.qic = true;
        paramBundle = getContext().getString(2131758482);
        break;
      }
      Assert.assertTrue(false);
      break;
      Assert.assertTrue(false);
      break;
      label680:
      if (!com.tencent.mm.plugin.d.a.e.a.bMR())
      {
        ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
        CD(3);
      }
      else if ((this.qhz != null) && (this.qhA) && (!this.qhz.isProviderEnabled("gps")))
      {
        ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
        CD(6);
      }
      else
      {
        label746:
        if ((!this.qic) && (this.qib) && (!ay.isWifi(getContext())))
        {
          ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
          CD(5);
        }
        else if ((this.qib) && (!this.qic))
        {
          CD(1);
        }
        else if ((this.qic) && (!this.qib))
        {
          CD(2);
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