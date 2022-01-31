package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.exdevice.d.a;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private TextWatcher ajS;
  private EditText fmq;
  private String iZs = "";
  private View jBY;
  private TextView jBZ;
  private View jCa;
  private View jCb;
  private p jCc;
  private WifiInfo jCd;
  private a jCe;
  private String jCf;
  private boolean jCg;
  private boolean jCh;
  private boolean jCi;
  private int jCj;
  private byte[] jCk;
  private int jCl;
  private int jCm;
  private int jCn;
  private String jCo = "";
  private int jCp;
  private long jCq;
  boolean jCr = false;
  private com.tencent.mm.plugin.exdevice.d.b jCs;
  private ExdeviceConnectWifiUI.b jCt;
  private n jCu;
  private j.a jCv;
  private WifiManager.MulticastLock jCw;
  private Runnable jCx = new ExdeviceConnectWifiUI.1(this);
  
  private void aMv()
  {
    if (this.jCd == null)
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null, delay to fill.");
      this.jCh = true;
    }
    Object localObject;
    do
    {
      return;
      this.jCe.jwZ = "";
      this.jCe.jwY = "";
      localObject = this.jCd.getSSID();
      localObject = ab(this.jCj, (String)localObject);
    } while (localObject == null);
    if (bk.bl(((a)localObject).jwZ))
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.jCs.jxa.remove(localObject);
      this.jCg = true;
      return;
    }
    this.jCe.jwZ = com.tencent.mm.plugin.base.model.b.cl(((a)localObject).jwZ, ExdeviceConnectWifiUI.a.ac(this.jCj, ((a)localObject).jwY));
    this.jCe.jwY = ((a)localObject).jwY;
    ai.d(this.jCx);
  }
  
  private a ab(int paramInt, String paramString)
  {
    if ((bk.bl(paramString)) || (this.jCs == null))
    {
      y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      return null;
    }
    int i = 0;
    if (i < this.jCs.jxa.size())
    {
      a locala = (a)this.jCs.jxa.get(i);
      int j;
      if (locala == null)
      {
        this.jCs.jxa.remove(i);
        this.jCg = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.jwX != paramInt);
        j = i;
      } while (!paramString.equals(locala.jwY));
      return locala;
    }
    return null;
  }
  
  private void fD(boolean paramBoolean)
  {
    this.jCd = aq.getWifiInfo(this);
    if (paramBoolean) {}
    ExdeviceConnectWifiUI.b localb2;
    for (ExdeviceConnectWifiUI.b localb1 = ExdeviceConnectWifiUI.b.jCI; this.jCd == null; localb1 = this.jCt)
    {
      localb2 = ExdeviceConnectWifiUI.b.jCJ;
      a(localb2);
      return;
    }
    String str = this.jCd.getSSID();
    y.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { str });
    if (!bk.bl(str)) {
      this.jBZ.setText(str.replaceAll("\"", ""));
    }
    for (;;)
    {
      localb2 = localb1;
      if (bk.bl(str)) {
        break;
      }
      localb2 = localb1;
      if (str.equals(this.jCf)) {
        break;
      }
      this.jCf = str;
      localb2 = localb1;
      break;
      this.jBZ.setText("");
    }
  }
  
  private void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    View localView = this.jBY;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label65;
      }
      runOnUiThread(new ExdeviceConnectWifiUI.5(this));
    }
    for (;;)
    {
      if (paramBoolean3) {
        Toast.makeText(this.mController.uMN, R.l.exdevice_connected, 0).show();
      }
      return;
      i = 8;
      break;
      label65:
      runOnUiThread(new ExdeviceConnectWifiUI.6(this));
      if (this.jCw.isHeld()) {
        this.jCw.release();
      }
    }
  }
  
  private String getPassword()
  {
    if (this.fmq.getText() != null) {
      return this.fmq.getText().toString();
    }
    return null;
  }
  
  private void qu(int paramInt)
  {
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.jCq;
    }
    h.nFQ.f(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jCn), Long.valueOf(l), this.jCo, this.iZs, Integer.valueOf(this.jCp) });
  }
  
  public final void a(ExdeviceConnectWifiUI.b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      try
      {
        y.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
        return;
      }
      finally {}
      this.jCt = paramb;
      switch (ExdeviceConnectWifiUI.7.jCE[paramb.ordinal()])
      {
      case 1: 
        if (paramb != ExdeviceConnectWifiUI.b.jCI)
        {
          this.fmq.clearFocus();
          XM();
          continue;
          g(true, false, false);
        }
        break;
      case 2: 
        g(true, true, false);
        break;
      case 3: 
        g(false, false, false);
        break;
      case 4: 
        qu(5);
        this.jCi = true;
        setResult(1);
      case 5: 
        for (;;)
        {
          finish();
          break;
          qu(4);
          g(true, false, true);
          this.jCi = true;
          setResult(-1);
          au.DS().O(new ExdeviceConnectWifiUI.4(this));
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
            d.b(this.mController.uMN, "exdevice", ".ui.ExdeviceBindDeviceUI", localIntent);
          }
        }
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_connect_wifi;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.exdevice_connect_wifi);
    setBackBtn(new ExdeviceConnectWifiUI.10(this));
    this.jBY = findViewById(R.h.setDeviceWifiPwPanel);
    this.jBZ = ((TextView)findViewById(R.h.nameTV));
    this.jCa = findViewById(R.h.alertView);
    this.fmq = ((EditText)findViewById(R.h.passwordET));
    this.jCb = findViewById(R.h.connetBtn);
    this.ajS = new ExdeviceConnectWifiUI.11(this);
    this.jBY.setOnTouchListener(new ExdeviceConnectWifiUI.12(this));
    this.jCb.setOnClickListener(new ExdeviceConnectWifiUI.13(this));
    this.fmq.setTransformationMethod(new PasswordTransformationMethod());
    this.fmq.addTextChangedListener(this.ajS);
    this.fmq.setOnEditorActionListener(new ExdeviceConnectWifiUI.14(this));
    this.fmq.setOnKeyListener(new ExdeviceConnectWifiUI.15(this));
    this.fmq.requestFocus();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jCu = new ExdeviceConnectWifiUI.8(this);
    this.jCt = ExdeviceConnectWifiUI.b.jCI;
    if (!au.DK())
    {
      finish();
      return;
    }
    this.jCs = new com.tencent.mm.plugin.exdevice.d.b();
    this.jCe = new a();
    au.Hx();
    this.jCj = c.CK();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.jCl = getIntent().getIntExtra("procInterval", 0);
    this.jCm = getIntent().getIntExtra("dataInterval", 0);
    y.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.jCl + " Data interval:" + this.jCm);
    if (!bk.bl(paramBundle))
    {
      this.jCk = Base64.decode(paramBundle, 0);
      this.jCp = 1;
    }
    this.jCr = false;
    this.jCn = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.jCn == 2)
    {
      this.jCo = getIntent().getStringExtra("device_brand_name");
      this.iZs = getIntent().getStringExtra("device_category_id");
    }
    this.jCv = new ExdeviceConnectWifiUI.9(this);
    j.aLC().a(0, this.jCv);
    initView();
    au.DS().O(new ExdeviceConnectWifiUI.3(this));
    qu(1);
    this.jCw = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!this.jCr) {
      qu(2);
    }
    j.aLC().b(0, this.jCv);
  }
  
  protected void onResume()
  {
    super.onResume();
    fD(false);
    au.a(this.jCu);
    if (this.jCh)
    {
      aMv();
      this.jCh = false;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    au.b(this.jCu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */