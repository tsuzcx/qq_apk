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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI
  extends MMActivity
  implements g
{
  private String EQ;
  private Button iwY;
  private String mDeviceType;
  private ListView mListView;
  BroadcastReceiver mPQ;
  private String mTitle;
  private String oUW;
  private String oUX;
  private String oyz;
  private String paB;
  private TextView paG;
  private LocationManager paJ;
  private boolean paK;
  private ExdeviceBindDeviceGuideUI.a paY;
  private Button paZ;
  private TextView pba;
  private ScrollView pbb;
  private ImageView pbc;
  private TextView pbd;
  private String pbe;
  private String pbf;
  private String pbg;
  private String pbh;
  private long pbi;
  private ArrayList<String> pbj;
  private String pbk;
  private boolean pbl;
  private boolean pbm;
  
  public ExdeviceBindDeviceGuideUI()
  {
    AppMethodBeat.i(23887);
    this.pbl = false;
    this.pbm = false;
    this.paK = false;
    this.mPQ = new BroadcastReceiver()
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
            if (!a.bBG())
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
  
  private void Bc(int paramInt)
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
      this.paZ.setText(getContext().getString(2131758507));
      this.iwY.setVisibility(8);
      this.pba.setText(getContext().getString(2131758506));
      break;
      this.paZ.setText(getContext().getString(2131758515));
      this.iwY.setText(getContext().getString(2131758474));
      this.pba.setText(getContext().getString(2131758516));
      break;
      this.pbc.setImageResource(2131689789);
      this.paG.setText(2131758494);
      this.pbd.setText(2131758478);
      break;
      this.pbc.setImageResource(2131689789);
      this.paG.setText(2131758492);
      this.pbd.setText("");
      break;
      this.pbc.setImageResource(2131691457);
      this.paG.setText(2131758494);
      this.pbd.setText(2131758489);
      break;
      this.pbc.setImageResource(2131689789);
      this.paG.setText(2131758494);
      this.pbd.setText(2131758542);
      break;
      this.pbc.setVisibility(8);
      this.paG.setVisibility(8);
      this.pbd.setVisibility(8);
      this.mListView.setVisibility(0);
      this.pbb.setVisibility(0);
      AppMethodBeat.o(23890);
      return;
      this.pbc.setVisibility(0);
      this.paG.setVisibility(0);
      this.mListView.setVisibility(8);
      this.pbb.setVisibility(8);
      if (paramInt == 4)
      {
        this.pbd.setVisibility(8);
        AppMethodBeat.o(23890);
        return;
      }
      this.pbd.setVisibility(0);
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
    if ((com.tencent.mm.compatible.util.d.lf(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
    {
      ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[] { Build.VERSION.RELEASE });
      this.paK = true;
    }
    paramBundle = getIntent();
    this.pbe = paramBundle.getStringExtra("device_scan_mode");
    this.pbf = paramBundle.getStringExtra("device_scan_conn_proto");
    this.oUX = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.pbg = paramBundle.getStringExtra("device_title");
    this.paB = paramBundle.getStringExtra("device_desc");
    this.oyz = paramBundle.getStringExtra("device_icon_url");
    this.EQ = paramBundle.getStringExtra("device_category_id");
    this.oUW = paramBundle.getStringExtra("device_brand_name");
    this.pbh = paramBundle.getStringExtra("bind_ticket");
    this.pbi = paramBundle.getLongExtra("device_ble_simple_proto", -1L);
    this.pbj = paramBundle.getStringArrayListExtra("device_airkiss_steps");
    this.pbk = paramBundle.getStringExtra("device_airkiss_key");
    this.mTitle = paramBundle.getStringExtra("device_airkiss_title");
    ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[] { Integer.valueOf(this.pbj.size()) });
    this.paJ = ((LocationManager)getContext().getSystemService("location"));
    this.mListView = ((ListView)findViewById(2131298741));
    paramBundle = View.inflate(this, 2131493850, null);
    this.pba = ((TextView)paramBundle.findViewById(2131305905));
    this.paY = new ExdeviceBindDeviceGuideUI.a(this.pbj);
    this.mListView.addHeaderView(paramBundle);
    this.mListView.setDividerHeight(0);
    this.mListView.setClickable(false);
    this.mListView.setFooterDividersEnabled(false);
    this.mListView.setAdapter(this.paY);
    this.pbc = ((ImageView)findViewById(2131301586));
    this.pbb = ((ScrollView)findViewById(2131300668));
    this.paZ = ((Button)findViewById(2131298575));
    this.iwY = ((Button)findViewById(2131302851));
    this.paG = ((TextView)findViewById(2131299511));
    this.pbd = ((TextView)findViewById(2131299512));
    paramBundle = "";
    if (this.pbe.compareTo("SCAN_CATALOG") == 0) {
      if (this.pbf.contains("wifi"))
      {
        this.pbl = true;
        paramBundle = getContext().getString(2131758515);
        setMMTitle(paramBundle);
        if ((!this.pbm) || (this.pbl)) {
          break label746;
        }
        if (a.eh(getContext())) {
          break label680;
        }
        ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        Bc(4);
      }
    }
    for (;;)
    {
      this.paZ.setOnClickListener(new View.OnClickListener()
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
            com.tencent.mm.bs.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
            AppMethodBeat.o(23880);
            return;
          }
          if ((ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
          {
            paramAnonymousView.putExtra("exdevice_airkiss_open_type", 2);
            com.tencent.mm.bs.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", paramAnonymousView);
          }
          AppMethodBeat.o(23880);
        }
      });
      this.iwY.setOnClickListener(new View.OnClickListener()
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
            com.tencent.mm.bs.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
          }
          AppMethodBeat.o(23881);
        }
      });
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramBundle.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      paramBundle.addAction("android.location.MODE_CHANGED");
      getContext().registerReceiver(this.mPQ, paramBundle);
      AppMethodBeat.o(23888);
      return;
      if (this.pbf.contains("blue"))
      {
        this.pbm = true;
        paramBundle = getContext().getString(2131758482);
        break;
      }
      Assert.assertTrue(false);
      break;
      Assert.assertTrue(false);
      break;
      label680:
      if (!a.bBG())
      {
        ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
        Bc(3);
      }
      else if ((this.paJ != null) && (this.paK) && (!this.paJ.isProviderEnabled("gps")))
      {
        ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
        Bc(6);
      }
      else
      {
        label746:
        if ((!this.pbm) && (this.pbl) && (!ay.isWifi(getContext())))
        {
          ad.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
          Bc(5);
        }
        else if ((this.pbl) && (!this.pbm))
        {
          Bc(1);
        }
        else if ((this.pbm) && (!this.pbl))
        {
          Bc(2);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23889);
    super.onDestroy();
    getContext().unregisterReceiver(this.mPQ);
    AppMethodBeat.o(23889);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI
 * JD-Core Version:    0.7.0.1
 */