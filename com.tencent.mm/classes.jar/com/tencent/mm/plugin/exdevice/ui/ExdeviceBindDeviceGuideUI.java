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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI
  extends MMActivity
  implements i
{
  private String HP;
  private Button krs;
  private String mDeviceType;
  private ListView mListView;
  BroadcastReceiver mReceiver;
  private String mTitle;
  private ExdeviceBindDeviceGuideUI.a rFA;
  private Button rFB;
  private TextView rFC;
  private ScrollView rFD;
  private ImageView rFE;
  private TextView rFF;
  private String rFG;
  private String rFH;
  private String rFI;
  private String rFJ;
  private long rFK;
  private ArrayList<String> rFL;
  private String rFM;
  private boolean rFN;
  private boolean rFO;
  private String rFd;
  private TextView rFi;
  private LocationManager rFl;
  private boolean rFm;
  private String rcG;
  private String rzn;
  private String rzo;
  
  public ExdeviceBindDeviceGuideUI()
  {
    AppMethodBeat.i(23887);
    this.rFN = false;
    this.rFO = false;
    this.rFm = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(23882);
        Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(23882);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        Log.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[] { paramAnonymousContext });
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
            Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[] { Integer.valueOf(i) });
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
            if (!com.tencent.mm.plugin.d.a.e.a.ckP())
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
  
  private void GA(int paramInt)
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
      this.rFB.setText(getContext().getString(2131758806));
      this.krs.setVisibility(8);
      this.rFC.setText(getContext().getString(2131758805));
      break;
      this.rFB.setText(getContext().getString(2131758814));
      this.krs.setText(getContext().getString(2131758773));
      this.rFC.setText(getContext().getString(2131758815));
      break;
      this.rFE.setImageResource(2131689800);
      this.rFi.setText(2131758793);
      this.rFF.setText(2131758777);
      break;
      this.rFE.setImageResource(2131689800);
      this.rFi.setText(2131758791);
      this.rFF.setText("");
      break;
      this.rFE.setImageResource(2131691800);
      this.rFi.setText(2131758793);
      this.rFF.setText(2131758788);
      break;
      this.rFE.setImageResource(2131689800);
      this.rFi.setText(2131758793);
      this.rFF.setText(2131758841);
      break;
      this.rFE.setVisibility(8);
      this.rFi.setVisibility(8);
      this.rFF.setVisibility(8);
      this.mListView.setVisibility(0);
      this.rFD.setVisibility(0);
      AppMethodBeat.o(23890);
      return;
      this.rFE.setVisibility(0);
      this.rFi.setVisibility(0);
      this.mListView.setVisibility(8);
      this.rFD.setVisibility(8);
      if (paramInt == 4)
      {
        this.rFF.setVisibility(8);
        AppMethodBeat.o(23890);
        return;
      }
      this.rFF.setVisibility(0);
    }
  }
  
  public int getLayoutId()
  {
    return 2131494012;
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
    if ((d.oD(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
    {
      Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[] { Build.VERSION.RELEASE });
      this.rFm = true;
    }
    paramBundle = getIntent();
    this.rFG = paramBundle.getStringExtra("device_scan_mode");
    this.rFH = paramBundle.getStringExtra("device_scan_conn_proto");
    this.rzo = paramBundle.getStringExtra("device_id");
    this.mDeviceType = paramBundle.getStringExtra("device_type");
    this.rFI = paramBundle.getStringExtra("device_title");
    this.rFd = paramBundle.getStringExtra("device_desc");
    this.rcG = paramBundle.getStringExtra("device_icon_url");
    this.HP = paramBundle.getStringExtra("device_category_id");
    this.rzn = paramBundle.getStringExtra("device_brand_name");
    this.rFJ = paramBundle.getStringExtra("bind_ticket");
    this.rFK = paramBundle.getLongExtra("device_ble_simple_proto", -1L);
    this.rFL = paramBundle.getStringArrayListExtra("device_airkiss_steps");
    this.rFM = paramBundle.getStringExtra("device_airkiss_key");
    this.mTitle = paramBundle.getStringExtra("device_airkiss_title");
    Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[] { Integer.valueOf(this.rFL.size()) });
    this.rFl = ((LocationManager)getContext().getSystemService("location"));
    this.mListView = ((ListView)findViewById(2131299183));
    paramBundle = View.inflate(this, 2131494005, null);
    this.rFC = ((TextView)paramBundle.findViewById(2131309198));
    this.rFA = new ExdeviceBindDeviceGuideUI.a(this.rFL);
    this.mListView.addHeaderView(paramBundle);
    this.mListView.setDividerHeight(0);
    this.mListView.setClickable(false);
    this.mListView.setFooterDividersEnabled(false);
    this.mListView.setAdapter(this.rFA);
    this.rFE = ((ImageView)findViewById(2131303816));
    this.rFD = ((ScrollView)findViewById(2131302225));
    this.rFB = ((Button)findViewById(2131299012));
    this.krs = ((Button)findViewById(2131305422));
    this.rFi = ((TextView)findViewById(2131300148));
    this.rFF = ((TextView)findViewById(2131300149));
    paramBundle = "";
    if (this.rFG.compareTo("SCAN_CATALOG") == 0) {
      if (this.rFH.contains("wifi"))
      {
        this.rFN = true;
        paramBundle = getContext().getString(2131758814);
        setMMTitle(paramBundle);
        if ((!this.rFO) || (this.rFN)) {
          break label746;
        }
        if (com.tencent.mm.plugin.d.a.e.a.eL(getContext())) {
          break label680;
        }
        Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        GA(4);
      }
    }
    for (;;)
    {
      this.rFB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23880);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
            c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(23880);
            return;
            if ((ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)) && (!ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
            {
              paramAnonymousView.putExtra("exdevice_airkiss_open_type", 2);
              c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceConnectWifiUI", paramAnonymousView);
            }
          }
        }
      });
      this.krs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23881);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceGuideUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
            c.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
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
      if (this.rFH.contains("blue"))
      {
        this.rFO = true;
        paramBundle = getContext().getString(2131758781);
        break;
      }
      Assert.assertTrue(false);
      break;
      Assert.assertTrue(false);
      break;
      label680:
      if (!com.tencent.mm.plugin.d.a.e.a.ckP())
      {
        Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
        GA(3);
      }
      else if ((this.rFl != null) && (this.rFm) && (!this.rFl.isProviderEnabled("gps")))
      {
        Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
        GA(6);
      }
      else
      {
        label746:
        if ((!this.rFO) && (this.rFN) && (!NetStatusUtil.isWifi(getContext())))
        {
          Log.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
          GA(5);
        }
        else if ((this.rFN) && (!this.rFO))
        {
          GA(1);
        }
        else if ((this.rFO) && (!this.rFN))
        {
          GA(2);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
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