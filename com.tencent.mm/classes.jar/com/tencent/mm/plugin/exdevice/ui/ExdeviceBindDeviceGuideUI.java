package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.f.a.e.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI
  extends MMActivity
  implements f
{
  private ListView Nn;
  private Button frP;
  BroadcastReceiver hWU = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
      if (paramAnonymousIntent == null) {}
      do
      {
        int i;
        do
        {
          do
          {
            return;
            paramAnonymousContext = paramAnonymousIntent.getAction();
            y.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[] { paramAnonymousContext });
            if ((!"android.bluetooth.adapter.action.STATE_CHANGED".equals(paramAnonymousContext)) || (!ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this))) {
              break;
            }
            i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            if (i == 12)
            {
              if ((ExdeviceBindDeviceGuideUI.o(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.p(ExdeviceBindDeviceGuideUI.this).isProviderEnabled("gps"))) {
                break label245;
              }
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
              return;
            }
          } while (i != 10);
          ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
          return;
          if ((!"android.net.wifi.WIFI_STATE_CHANGED".equals(paramAnonymousContext)) || (!ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this))) {
            break;
          }
          i = paramAnonymousIntent.getIntExtra("wifi_state", -1);
          y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[] { Integer.valueOf(i) });
          if (i == 3)
          {
            ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 1);
            return;
          }
        } while (i != 1);
        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 5);
        return;
      } while ((!ExdeviceBindDeviceGuideUI.o(ExdeviceBindDeviceGuideUI.this)) || (!"android.location.MODE_CHANGED".equals(paramAnonymousContext)));
      if (ExdeviceBindDeviceGuideUI.p(ExdeviceBindDeviceGuideUI.this).isProviderEnabled("gps"))
      {
        if (!a.awB())
        {
          ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
          return;
        }
        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
        return;
      }
      label245:
      ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 6);
    }
  };
  private String iZG;
  private LocationManager jAA;
  private boolean jAB = false;
  private ExdeviceBindDeviceGuideUI.a jAP;
  private Button jAQ;
  private TextView jAR;
  private ScrollView jAS;
  private ImageView jAT;
  private TextView jAU;
  private String jAV;
  private String jAW;
  private String jAX;
  private String jAY;
  private long jAZ;
  private String jAa;
  private String jAs;
  private TextView jAx;
  private ArrayList<String> jBa;
  private String jBb;
  private boolean jBc = false;
  private boolean jBd = false;
  private String juL;
  private String juM;
  private String mCategory;
  private String mTitle;
  
  private void qr(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
        this.jAQ.setText(this.mController.uMN.getString(R.l.exdevice_connect_bt_next));
        this.frP.setVisibility(8);
        this.jAR.setText(this.mController.uMN.getString(R.l.exdevice_connect_bt_guide));
        continue;
        this.jAQ.setText(this.mController.uMN.getString(R.l.exdevice_connect_wifi));
        this.frP.setText(this.mController.uMN.getString(R.l.exdevice_already_connect_wifi));
        this.jAR.setText(this.mController.uMN.getString(R.l.exdevice_connect_wifi_guide));
        continue;
        this.jAT.setImageResource(R.k.bluetooth_logo);
        this.jAx.setText(R.l.exdevice_can_not_scan);
        this.jAU.setText(R.l.exdevice_bind_device_blue_no_open_detail);
        continue;
        this.jAT.setImageResource(R.k.bluetooth_logo);
        this.jAx.setText(R.l.exdevice_ble_version_below_4_0);
        this.jAU.setText("");
        continue;
        this.jAT.setImageResource(R.k.wifi_logo);
        this.jAx.setText(R.l.exdevice_can_not_scan);
        this.jAU.setText(R.l.exdevice_bind_device_wifi_no_open_detail);
        continue;
        this.jAT.setImageResource(R.k.bluetooth_logo);
        this.jAx.setText(R.l.exdevice_can_not_scan);
        this.jAU.setText(R.l.exdevice_gps_not_open);
      }
    }
    this.jAT.setVisibility(8);
    this.jAx.setVisibility(8);
    this.jAU.setVisibility(8);
    this.Nn.setVisibility(0);
    this.jAS.setVisibility(0);
    return;
    this.jAT.setVisibility(0);
    this.jAx.setVisibility(0);
    this.Nn.setVisibility(8);
    this.jAS.setVisibility(8);
    if (paramInt == 4)
    {
      this.jAU.setVisibility(8);
      return;
    }
    this.jAU.setVisibility(0);
  }
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_bind_device_guide_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceBindDeviceGuideUI.1(this));
    if ((com.tencent.mm.compatible.util.d.gF(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
    {
      y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[] { Build.VERSION.RELEASE });
      this.jAB = true;
    }
    paramBundle = getIntent();
    this.jAV = paramBundle.getStringExtra("device_scan_mode");
    this.jAW = paramBundle.getStringExtra("device_scan_conn_proto");
    this.juM = paramBundle.getStringExtra("device_id");
    this.jAa = paramBundle.getStringExtra("device_type");
    this.jAX = paramBundle.getStringExtra("device_title");
    this.jAs = paramBundle.getStringExtra("device_desc");
    this.iZG = paramBundle.getStringExtra("device_icon_url");
    this.mCategory = paramBundle.getStringExtra("device_category_id");
    this.juL = paramBundle.getStringExtra("device_brand_name");
    this.jAY = paramBundle.getStringExtra("bind_ticket");
    this.jAZ = paramBundle.getLongExtra("device_ble_simple_proto", -1L);
    this.jBa = paramBundle.getStringArrayListExtra("device_airkiss_steps");
    this.jBb = paramBundle.getStringExtra("device_airkiss_key");
    this.mTitle = paramBundle.getStringExtra("device_airkiss_title");
    y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[] { Integer.valueOf(this.jBa.size()) });
    this.jAA = ((LocationManager)this.mController.uMN.getSystemService("location"));
    this.Nn = ((ListView)findViewById(R.h.contentList));
    paramBundle = View.inflate(this, R.i.exdeivce_bind_device_guide_ui_header, null);
    this.jAR = ((TextView)paramBundle.findViewById(R.h.titleTV));
    this.jAP = new ExdeviceBindDeviceGuideUI.a(this.jBa);
    this.Nn.addHeaderView(paramBundle);
    this.Nn.setDividerHeight(0);
    this.Nn.setClickable(false);
    this.Nn.setFooterDividersEnabled(false);
    this.Nn.setAdapter(this.jAP);
    this.jAT = ((ImageView)findViewById(R.h.logoTV));
    this.jAS = ((ScrollView)findViewById(R.h.guideListScrollView));
    this.jAQ = ((Button)findViewById(R.h.connectButton));
    this.frP = ((Button)findViewById(R.h.nextButton));
    this.jAx = ((TextView)findViewById(R.h.errTips));
    this.jAU = ((TextView)findViewById(R.h.errTipsDetail));
    paramBundle = "";
    if (this.jAV.compareTo("SCAN_CATALOG") == 0) {
      if (this.jAW.contains("wifi"))
      {
        this.jBc = true;
        paramBundle = this.mController.uMN.getString(R.l.exdevice_connect_wifi);
        setMMTitle(paramBundle);
        if ((!this.jBd) || (this.jBc)) {
          break label759;
        }
        if (a.cP(this.mController.uMN)) {
          break label691;
        }
        y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        qr(4);
      }
    }
    for (;;)
    {
      this.jAQ.setOnClickListener(new ExdeviceBindDeviceGuideUI.2(this));
      this.frP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
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
            com.tencent.mm.br.d.b(ExdeviceBindDeviceGuideUI.this.mController.uMN, "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
          }
        }
      });
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramBundle.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      paramBundle.addAction("android.location.MODE_CHANGED");
      this.mController.uMN.registerReceiver(this.hWU, paramBundle);
      return;
      if (this.jAW.contains("blue"))
      {
        this.jBd = true;
        paramBundle = this.mController.uMN.getString(R.l.exdevice_bind_device_help_prepare);
        break;
      }
      Assert.assertTrue(false);
      break;
      Assert.assertTrue(false);
      break;
      label691:
      if (!a.awB())
      {
        y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
        qr(3);
      }
      else if ((this.jAA != null) && (this.jAB) && (!this.jAA.isProviderEnabled("gps")))
      {
        y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
        qr(6);
      }
      else
      {
        label759:
        if ((!this.jBd) && (this.jBc) && (!aq.isWifi(this.mController.uMN)))
        {
          y.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
          qr(5);
        }
        else if ((this.jBc) && (!this.jBd))
        {
          qr(1);
        }
        else if ((this.jBd) && (!this.jBc))
        {
          qr(2);
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mController.uMN.unregisterReceiver(this.hWU);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI
 * JD-Core Version:    0.7.0.1
 */