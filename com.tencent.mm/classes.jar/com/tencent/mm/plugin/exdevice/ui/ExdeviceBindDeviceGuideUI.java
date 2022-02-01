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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI
  extends MMActivity
  implements g
{
  private String FO;
  private Button iXb;
  private String mDeviceType;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private String mTitle;
  private String pDM;
  private TextView pDR;
  private LocationManager pDU;
  private boolean pDV;
  private ExdeviceBindDeviceGuideUI.a pEj;
  private Button pEk;
  private TextView pEl;
  private ScrollView pEm;
  private ImageView pEn;
  private TextView pEo;
  private String pEp;
  private String pEq;
  private String pEr;
  private String pEs;
  private long pEt;
  private ArrayList<String> pEu;
  private String pEv;
  private boolean pEw;
  private boolean pEx;
  private String pbZ;
  private String pyh;
  private String pyi;
  
  public ExdeviceBindDeviceGuideUI()
  {
    AppMethodBeat.i(23887);
    this.pEw = false;
    this.pEx = false;
    this.pDV = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(23882);
        ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(23882);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ac.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[] { paramAnonymousContext });
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
            ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[] { Integer.valueOf(i) });
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
            if (!a.bIE())
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
  
  private void BU(int paramInt)
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
      this.pEk.setText(getContext().getString(2131758507));
      this.iXb.setVisibility(8);
      this.pEl.setText(getContext().getString(2131758506));
      break;
      this.pEk.setText(getContext().getString(2131758515));
      this.iXb.setText(getContext().getString(2131758474));
      this.pEl.setText(getContext().getString(2131758516));
      break;
      this.pEn.setImageResource(2131689789);
      this.pDR.setText(2131758494);
      this.pEo.setText(2131758478);
      break;
      this.pEn.setImageResource(2131689789);
      this.pDR.setText(2131758492);
      this.pEo.setText("");
      break;
      this.pEn.setImageResource(2131691457);
      this.pDR.setText(2131758494);
      this.pEo.setText(2131758489);
      break;
      this.pEn.setImageResource(2131689789);
      this.pDR.setText(2131758494);
      this.pEo.setText(2131758542);
      break;
      this.pEn.setVisibility(8);
      this.pDR.setVisibility(8);
      this.pEo.setVisibility(8);
      this.mListView.setVisibility(0);
      this.pEm.setVisibility(0);
      AppMethodBeat.o(23890);
      return;
      this.pEn.setVisibility(0);
      this.pDR.setVisibility(0);
      this.mListView.setVisibility(8);
      this.pEm.setVisibility(8);
      if (paramInt == 4)
      {
        this.pEo.setVisibility(8);
        AppMethodBeat.o(23890);
        return;
      }
      this.pEo.setVisibility(0);
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
    if ((com.tencent.mm.compatible.util.d.kZ(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
    {
      ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[] { Build.VERSION.RELEASE });
      this.pDV = true;
    }
    paramBundle = getIntent();
    this.pEp = paramBundle.getStringExtra("device_scan_mode");
    this.pEq = paramBundle.getStringExtra("device_scan_conn_proto");
    this.pyi = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.pEr = paramBundle.getStringExtra("device_title");
    this.pDM = paramBundle.getStringExtra("device_desc");
    this.pbZ = paramBundle.getStringExtra("device_icon_url");
    this.FO = paramBundle.getStringExtra("device_category_id");
    this.pyh = paramBundle.getStringExtra("device_brand_name");
    this.pEs = paramBundle.getStringExtra("bind_ticket");
    this.pEt = paramBundle.getLongExtra("device_ble_simple_proto", -1L);
    this.pEu = paramBundle.getStringArrayListExtra("device_airkiss_steps");
    this.pEv = paramBundle.getStringExtra("device_airkiss_key");
    this.mTitle = paramBundle.getStringExtra("device_airkiss_title");
    ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[] { Integer.valueOf(this.pEu.size()) });
    this.pDU = ((LocationManager)getContext().getSystemService("location"));
    this.mListView = ((ListView)findViewById(2131298741));
    paramBundle = View.inflate(this, 2131493850, null);
    this.pEl = ((TextView)paramBundle.findViewById(2131305905));
    this.pEj = new ExdeviceBindDeviceGuideUI.a(this.pEu);
    this.mListView.addHeaderView(paramBundle);
    this.mListView.setDividerHeight(0);
    this.mListView.setClickable(false);
    this.mListView.setFooterDividersEnabled(false);
    this.mListView.setAdapter(this.pEj);
    this.pEn = ((ImageView)findViewById(2131301586));
    this.pEm = ((ScrollView)findViewById(2131300668));
    this.pEk = ((Button)findViewById(2131298575));
    this.iXb = ((Button)findViewById(2131302851));
    this.pDR = ((TextView)findViewById(2131299511));
    this.pEo = ((TextView)findViewById(2131299512));
    paramBundle = "";
    if (this.pEp.compareTo("SCAN_CATALOG") == 0) {
      if (this.pEq.contains("wifi"))
      {
        this.pEw = true;
        paramBundle = getContext().getString(2131758515);
        setMMTitle(paramBundle);
        if ((!this.pEx) || (this.pEw)) {
          break label746;
        }
        if (a.ep(getContext())) {
          break label680;
        }
        ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        BU(4);
      }
    }
    for (;;)
    {
      this.pEk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23880);
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
          if ((ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)))
          {
            com.tencent.mm.br.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
            AppMethodBeat.o(23880);
            return;
          }
          if ((ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
          {
            paramAnonymousView.putExtra("exdevice_airkiss_open_type", 2);
            com.tencent.mm.br.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", paramAnonymousView);
          }
          AppMethodBeat.o(23880);
        }
      });
      this.iXb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23881);
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
      if (this.pEq.contains("blue"))
      {
        this.pEx = true;
        paramBundle = getContext().getString(2131758482);
        break;
      }
      Assert.assertTrue(false);
      break;
      Assert.assertTrue(false);
      break;
      label680:
      if (!a.bIE())
      {
        ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
        BU(3);
      }
      else if ((this.pDU != null) && (this.pDV) && (!this.pDU.isProviderEnabled("gps")))
      {
        ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
        BU(6);
      }
      else
      {
        label746:
        if ((!this.pEx) && (this.pEw) && (!ax.isWifi(getContext())))
        {
          ac.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
          BU(5);
        }
        else if ((this.pEw) && (!this.pEx))
        {
          BU(1);
        }
        else if ((this.pEx) && (!this.pEw))
        {
          BU(2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI
 * JD-Core Version:    0.7.0.1
 */