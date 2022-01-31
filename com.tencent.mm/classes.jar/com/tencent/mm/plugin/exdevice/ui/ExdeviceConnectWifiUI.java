package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.exdevice.d.a;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private TextWatcher ami;
  private EditText gDK;
  private View lLA;
  private p lLB;
  private String lLC;
  private a lLD;
  private boolean lLE;
  private boolean lLF;
  private boolean lLG;
  private int lLH;
  private byte[] lLI;
  private int lLJ;
  private int lLK;
  private int lLL;
  private String lLM;
  private int lLN;
  private long lLO;
  boolean lLP;
  private com.tencent.mm.plugin.exdevice.d.b lLQ;
  private ExdeviceConnectWifiUI.b lLR;
  private n lLS;
  private j.a lLT;
  private WifiManager.MulticastLock lLU;
  private Runnable lLV;
  private View lLx;
  private TextView lLy;
  private View lLz;
  private String lig;
  
  public ExdeviceConnectWifiUI()
  {
    AppMethodBeat.i(19896);
    this.lLM = "";
    this.lig = "";
    this.lLP = false;
    this.lLV = new ExdeviceConnectWifiUI.1(this);
    AppMethodBeat.o(19896);
  }
  
  private a au(int paramInt, String paramString)
  {
    AppMethodBeat.i(19903);
    if ((bo.isNullOrNil(paramString)) || (this.lLQ == null))
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      AppMethodBeat.o(19903);
      return null;
    }
    int i = 0;
    if (i < this.lLQ.lGz.size())
    {
      a locala = (a)this.lLQ.lGz.get(i);
      int j;
      if (locala == null)
      {
        this.lLQ.lGz.remove(i);
        this.lLE = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.lGw != paramInt);
        j = i;
      } while (!paramString.equals(locala.lGx));
      AppMethodBeat.o(19903);
      return locala;
    }
    AppMethodBeat.o(19903);
    return null;
  }
  
  private void bqF()
  {
    AppMethodBeat.i(19909);
    runOnUiThread(new ExdeviceConnectWifiUI.6(this));
    if (this.lLU.isHeld()) {
      this.lLU.release();
    }
    AppMethodBeat.o(19909);
  }
  
  private void bqI()
  {
    AppMethodBeat.i(19904);
    this.lLD.lGy = "";
    this.lLD.lGx = "";
    String str = this.lLC;
    a locala = au(this.lLH, str);
    if ((locala == null) || (bo.isNullOrNil(str)))
    {
      AppMethodBeat.o(19904);
      return;
    }
    if (bo.isNullOrNil(locala.lGy))
    {
      ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.lLQ.lGz.remove(locala);
      this.lLE = true;
      AppMethodBeat.o(19904);
      return;
    }
    this.lLD.lGy = com.tencent.mm.plugin.base.model.b.dc(locala.lGy, ExdeviceConnectWifiUI.a.av(this.lLH, locala.lGx));
    this.lLD.lGx = locala.lGx;
    al.d(this.lLV);
    AppMethodBeat.o(19904);
  }
  
  private void bqJ()
  {
    AppMethodBeat.i(19908);
    runOnUiThread(new ExdeviceConnectWifiUI.5(this));
    AppMethodBeat.o(19908);
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(19910);
    View localView = this.lLx;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label65;
      }
      bqJ();
    }
    for (;;)
    {
      if (paramBoolean3) {
        Toast.makeText(getContext(), 2131299390, 0).show();
      }
      AppMethodBeat.o(19910);
      return;
      i = 8;
      break;
      label65:
      bqF();
    }
  }
  
  private String getPassword()
  {
    AppMethodBeat.i(19905);
    if (this.gDK.getText() != null)
    {
      String str = this.gDK.getText().toString();
      AppMethodBeat.o(19905);
      return str;
    }
    AppMethodBeat.o(19905);
    return null;
  }
  
  private void hf(boolean paramBoolean)
  {
    AppMethodBeat.i(19906);
    ExdeviceConnectWifiUI.b localb;
    if (paramBoolean)
    {
      localb = ExdeviceConnectWifiUI.b.lMf;
      if (at.getNetType(this) == 0) {
        break label45;
      }
      localb = ExdeviceConnectWifiUI.b.lMg;
    }
    for (;;)
    {
      a(localb);
      AppMethodBeat.o(19906);
      return;
      localb = this.lLR;
      break;
      label45:
      this.lLC = at.gX(ah.getContext());
      ab.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { this.lLC });
      if (!bo.isNullOrNil(this.lLC)) {
        this.lLy.setText(this.lLC);
      } else {
        this.lLy.setText("");
      }
    }
  }
  
  private void vb(int paramInt)
  {
    AppMethodBeat.i(19902);
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.lLO;
    }
    h.qsU.e(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lLL), Long.valueOf(l), this.lLM, this.lig, Integer.valueOf(this.lLN) });
    AppMethodBeat.o(19902);
  }
  
  public final void a(ExdeviceConnectWifiUI.b paramb)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(19907);
        if (paramb == null)
        {
          ab.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
          AppMethodBeat.o(19907);
          return;
        }
        this.lLR = paramb;
        switch (ExdeviceConnectWifiUI.7.lMb[paramb.ordinal()])
        {
        case 1: 
          if (paramb != ExdeviceConnectWifiUI.b.lMf)
          {
            this.gDK.clearFocus();
            hideVKB();
          }
          AppMethodBeat.o(19907);
          continue;
          e(true, false, false);
        }
      }
      finally {}
      continue;
      e(true, true, false);
      continue;
      e(false, false, false);
      continue;
      vb(5);
      this.lLG = true;
      setResult(1);
      for (;;)
      {
        finish();
        break;
        vb(4);
        e(true, false, true);
        this.lLG = true;
        setResult(-1);
        aw.RO().ac(new ExdeviceConnectWifiUI.4(this));
        if (getIntent().getBooleanExtra("jumpToBindDevice", false))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
          localIntent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
          localIntent.putExtra("device_id", getIntent().getStringExtra("device_id"));
          localIntent.putExtra("device_type", getIntent().getStringExtra("device_type"));
          localIntent.putExtra("device_title", getIntent().getStringExtra("device_title"));
          localIntent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
          localIntent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
          localIntent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
          localIntent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
          localIntent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
          d.b(getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", localIntent);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130969449;
  }
  
  public void initView()
  {
    AppMethodBeat.i(19901);
    setMMTitle(2131299387);
    setBackBtn(new ExdeviceConnectWifiUI.10(this));
    this.lLx = findViewById(2131823759);
    this.lLy = ((TextView)findViewById(2131823741));
    this.lLz = findViewById(2131823761);
    this.gDK = ((EditText)findViewById(2131823760));
    this.lLA = findViewById(2131823764);
    this.ami = new ExdeviceConnectWifiUI.11(this);
    this.lLx.setOnTouchListener(new ExdeviceConnectWifiUI.12(this));
    this.lLA.setOnClickListener(new ExdeviceConnectWifiUI.13(this));
    this.gDK.setTransformationMethod(new PasswordTransformationMethod());
    this.gDK.addTextChangedListener(this.ami);
    this.gDK.setOnEditorActionListener(new ExdeviceConnectWifiUI.14(this));
    this.gDK.setOnKeyListener(new ExdeviceConnectWifiUI.15(this));
    this.gDK.requestFocus();
    AppMethodBeat.o(19901);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19897);
    super.onCreate(paramBundle);
    this.lLS = new ExdeviceConnectWifiUI.8(this);
    this.lLR = ExdeviceConnectWifiUI.b.lMf;
    if (!aw.RG())
    {
      finish();
      AppMethodBeat.o(19897);
      return;
    }
    this.lLQ = new com.tencent.mm.plugin.exdevice.d.b();
    this.lLD = new a();
    aw.aaz();
    this.lLH = c.getUin();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.lLJ = getIntent().getIntExtra("procInterval", 0);
    this.lLK = getIntent().getIntExtra("dataInterval", 0);
    ab.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.lLJ + " Data interval:" + this.lLK);
    if (!bo.isNullOrNil(paramBundle))
    {
      this.lLI = Base64.decode(paramBundle, 0);
      this.lLN = 1;
    }
    this.lLP = false;
    this.lLL = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.lLL == 2)
    {
      this.lLM = getIntent().getStringExtra("device_brand_name");
      this.lig = getIntent().getStringExtra("device_category_id");
    }
    this.lLT = new ExdeviceConnectWifiUI.9(this);
    j.bpP().a(0, this.lLT);
    initView();
    aw.RO().ac(new ExdeviceConnectWifiUI.3(this));
    vb(1);
    this.lLU = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
    AppMethodBeat.o(19897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(19899);
    super.onDestroy();
    if (!this.lLP) {
      vb(2);
    }
    j.bpP().b(0, this.lLT);
    AppMethodBeat.o(19899);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(19898);
    super.onResume();
    hf(false);
    aw.a(this.lLS);
    if (this.lLF)
    {
      bqI();
      this.lLF = false;
    }
    AppMethodBeat.o(19898);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(19900);
    super.onStop();
    aw.b(this.lLS);
    AppMethodBeat.o(19900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */