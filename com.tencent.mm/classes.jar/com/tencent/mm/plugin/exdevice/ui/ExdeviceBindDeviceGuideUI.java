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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI
  extends MMActivity
  implements f
{
  private Button gJr;
  BroadcastReceiver jQN;
  private String lEk;
  private String lEl;
  private String lJR;
  private TextView lJW;
  private LocationManager lJZ;
  private String lJz;
  private String lKA;
  private boolean lKB;
  private boolean lKC;
  private boolean lKa;
  private a lKo;
  private Button lKp;
  private TextView lKq;
  private ScrollView lKr;
  private ImageView lKs;
  private TextView lKt;
  private String lKu;
  private String lKv;
  private String lKw;
  private String lKx;
  private long lKy;
  private ArrayList<String> lKz;
  private String lix;
  private ListView mListView;
  private String mTitle;
  private String yu;
  
  public ExdeviceBindDeviceGuideUI()
  {
    AppMethodBeat.i(19819);
    this.lKB = false;
    this.lKC = false;
    this.lKa = false;
    this.jQN = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(19814);
        ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(19814);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        ab.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[] { paramAnonymousContext });
        int i;
        if (("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramAnonymousContext)) && (ExdeviceBindDeviceGuideUI.m(ExdeviceBindDeviceGuideUI.this)))
        {
          i = paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
          if (i == 12)
          {
            if ((!ExdeviceBindDeviceGuideUI.o(ExdeviceBindDeviceGuideUI.this)) || (ExdeviceBindDeviceGuideUI.p(ExdeviceBindDeviceGuideUI.this).isProviderEnabled("gps")))
            {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
              AppMethodBeat.o(19814);
            }
          }
          else
          {
            if (i == 10) {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
            }
            AppMethodBeat.o(19814);
          }
        }
        else
        {
          if (("android.net.wifi.WIFI_STATE_CHANGED".equals(paramAnonymousContext)) && (ExdeviceBindDeviceGuideUI.n(ExdeviceBindDeviceGuideUI.this)))
          {
            i = paramAnonymousIntent.getIntExtra("wifi_state", -1);
            ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[] { Integer.valueOf(i) });
            if (i == 3)
            {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 1);
              AppMethodBeat.o(19814);
              return;
            }
            if (i == 1) {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 5);
            }
            AppMethodBeat.o(19814);
            return;
          }
          if ((!ExdeviceBindDeviceGuideUI.o(ExdeviceBindDeviceGuideUI.this)) || (!"android.location.MODE_CHANGED".equals(paramAnonymousContext))) {
            break label302;
          }
          if (ExdeviceBindDeviceGuideUI.p(ExdeviceBindDeviceGuideUI.this).isProviderEnabled("gps"))
          {
            if (!a.aWe())
            {
              ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 3);
              AppMethodBeat.o(19814);
              return;
            }
            ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 2);
            AppMethodBeat.o(19814);
            return;
          }
        }
        ExdeviceBindDeviceGuideUI.a(ExdeviceBindDeviceGuideUI.this, 6);
        label302:
        AppMethodBeat.o(19814);
      }
    };
    AppMethodBeat.o(19819);
  }
  
  private void uY(int paramInt)
  {
    AppMethodBeat.i(19822);
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
      AppMethodBeat.o(19822);
      return;
      this.lKp.setText(getContext().getString(2131299379));
      this.gJr.setVisibility(8);
      this.lKq.setText(getContext().getString(2131299378));
      break;
      this.lKp.setText(getContext().getString(2131299387));
      this.gJr.setText(getContext().getString(2131299346));
      this.lKq.setText(getContext().getString(2131299388));
      break;
      this.lKs.setImageResource(2131230997);
      this.lJW.setText(2131299366);
      this.lKt.setText(2131299350);
      break;
      this.lKs.setImageResource(2131230997);
      this.lJW.setText(2131299364);
      this.lKt.setText("");
      break;
      this.lKs.setImageResource(2131232250);
      this.lJW.setText(2131299366);
      this.lKt.setText(2131299361);
      break;
      this.lKs.setImageResource(2131230997);
      this.lJW.setText(2131299366);
      this.lKt.setText(2131299414);
      break;
      this.lKs.setVisibility(8);
      this.lJW.setVisibility(8);
      this.lKt.setVisibility(8);
      this.mListView.setVisibility(0);
      this.lKr.setVisibility(0);
      AppMethodBeat.o(19822);
      return;
      this.lKs.setVisibility(0);
      this.lJW.setVisibility(0);
      this.mListView.setVisibility(8);
      this.lKr.setVisibility(8);
      if (paramInt == 4)
      {
        this.lKt.setVisibility(8);
        AppMethodBeat.o(19822);
        return;
      }
      this.lKt.setVisibility(0);
    }
  }
  
  public int getLayoutId()
  {
    return 2130969444;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19820);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceBindDeviceGuideUI.1(this));
    if ((com.tencent.mm.compatible.util.d.fv(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0")))
    {
      ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[] { Build.VERSION.RELEASE });
      this.lKa = true;
    }
    paramBundle = getIntent();
    this.lKu = paramBundle.getStringExtra("device_scan_mode");
    this.lKv = paramBundle.getStringExtra("device_scan_conn_proto");
    this.lEl = paramBundle.getStringExtra("device_id");
    this.lJz = paramBundle.getStringExtra("device_type");
    this.lKw = paramBundle.getStringExtra("device_title");
    this.lJR = paramBundle.getStringExtra("device_desc");
    this.lix = paramBundle.getStringExtra("device_icon_url");
    this.yu = paramBundle.getStringExtra("device_category_id");
    this.lEk = paramBundle.getStringExtra("device_brand_name");
    this.lKx = paramBundle.getStringExtra("bind_ticket");
    this.lKy = paramBundle.getLongExtra("device_ble_simple_proto", -1L);
    this.lKz = paramBundle.getStringArrayListExtra("device_airkiss_steps");
    this.lKA = paramBundle.getStringExtra("device_airkiss_key");
    this.mTitle = paramBundle.getStringExtra("device_airkiss_title");
    ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[] { Integer.valueOf(this.lKz.size()) });
    this.lJZ = ((LocationManager)getContext().getSystemService("location"));
    this.mListView = ((ListView)findViewById(2131823754));
    paramBundle = View.inflate(this, 2130969438, null);
    this.lKq = ((TextView)paramBundle.findViewById(2131823739));
    this.lKo = new a(this.lKz);
    this.mListView.addHeaderView(paramBundle);
    this.mListView.setDividerHeight(0);
    this.mListView.setClickable(false);
    this.mListView.setFooterDividersEnabled(false);
    this.mListView.setAdapter(this.lKo);
    this.lKs = ((ImageView)findViewById(2131823742));
    this.lKr = ((ScrollView)findViewById(2131823753));
    this.lKp = ((Button)findViewById(2131823755));
    this.gJr = ((Button)findViewById(2131823756));
    this.lJW = ((TextView)findViewById(2131823743));
    this.lKt = ((TextView)findViewById(2131823744));
    paramBundle = "";
    if (this.lKu.compareTo("SCAN_CATALOG") == 0) {
      if (this.lKv.contains("wifi"))
      {
        this.lKB = true;
        paramBundle = getContext().getString(2131299387);
        setMMTitle(paramBundle);
        if ((!this.lKC) || (this.lKB)) {
          break label746;
        }
        if (a.dA(getContext())) {
          break label680;
        }
        ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        uY(4);
      }
    }
    for (;;)
    {
      this.lKp.setOnClickListener(new ExdeviceBindDeviceGuideUI.2(this));
      this.gJr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(19813);
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
            com.tencent.mm.bq.d.b(ExdeviceBindDeviceGuideUI.this.getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", paramAnonymousView);
          }
          AppMethodBeat.o(19813);
        }
      });
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramBundle.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      paramBundle.addAction("android.location.MODE_CHANGED");
      getContext().registerReceiver(this.jQN, paramBundle);
      AppMethodBeat.o(19820);
      return;
      if (this.lKv.contains("blue"))
      {
        this.lKC = true;
        paramBundle = getContext().getString(2131299354);
        break;
      }
      Assert.assertTrue(false);
      break;
      Assert.assertTrue(false);
      break;
      label680:
      if (!a.aWe())
      {
        ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
        uY(3);
      }
      else if ((this.lJZ != null) && (this.lKa) && (!this.lJZ.isProviderEnabled("gps")))
      {
        ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
        uY(6);
      }
      else
      {
        label746:
        if ((!this.lKC) && (this.lKB) && (!at.isWifi(getContext())))
        {
          ab.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
          uY(5);
        }
        else if ((this.lKB) && (!this.lKC))
        {
          uY(1);
        }
        else if ((this.lKC) && (!this.lKB))
        {
          uY(2);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(19821);
    super.onDestroy();
    getContext().unregisterReceiver(this.jQN);
    AppMethodBeat.o(19821);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private ArrayList<String> lKE;
    
    public a(ArrayList<String> paramArrayList)
    {
      this.lKE = paramArrayList;
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(19816);
      if ((this.lKE != null) && (this.lKE.size() > 0))
      {
        String str = (String)this.lKE.get(paramInt);
        AppMethodBeat.o(19816);
        return str;
      }
      AppMethodBeat.o(19816);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(19815);
      if (this.lKE != null)
      {
        int i = this.lKE.size();
        AppMethodBeat.o(19815);
        return i;
      }
      AppMethodBeat.o(19815);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(19817);
      if ((this.lKE == null) || (this.lKE.size() <= 0))
      {
        AppMethodBeat.o(19817);
        return null;
      }
      String str = getItem(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new ExdeviceBindDeviceGuideUI.a.a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2130969443, null);
        paramView.lKG = ((TextView)localView.findViewById(2131823752));
        paramView.lKF = ((TextView)localView.findViewById(2131823750));
        paramView.lKH = localView.findViewById(2131823749);
        paramView.lKI = localView.findViewById(2131823751);
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.lKF.setText(Integer.toString(paramInt + 1));
        paramViewGroup.lKG.setText(str);
        if ((paramInt != 0) || (this.lKE.size() != 1)) {
          break label197;
        }
        paramViewGroup.lKH.setVisibility(4);
        paramViewGroup.lKI.setVisibility(4);
      }
      for (;;)
      {
        AppMethodBeat.o(19817);
        return localView;
        paramViewGroup = (ExdeviceBindDeviceGuideUI.a.a)paramView.getTag();
        localView = paramView;
        break;
        label197:
        if (paramInt == 0)
        {
          paramViewGroup.lKH.setVisibility(4);
          paramViewGroup.lKI.setVisibility(0);
        }
        else if (paramInt == this.lKE.size() - 1)
        {
          paramViewGroup.lKI.setVisibility(4);
          paramViewGroup.lKH.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI
 * JD-Core Version:    0.7.0.1
 */