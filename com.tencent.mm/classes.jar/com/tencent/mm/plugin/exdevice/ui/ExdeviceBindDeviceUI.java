package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.plugin.f.a.e.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI
  extends MMActivity
  implements f, e.b
{
  private ListView Nn;
  private ProgressDialog dnm;
  private ScrollView gqx;
  private TextView iuP;
  private String jAa;
  private TextView jAx;
  private TextView jAy;
  private ExdeviceBindDeviceUI.a jBk;
  private View jBl;
  private TextView jBm;
  private ImageView jBn;
  private View jBo;
  private ExdeviceBindDeviceUI.e jBp;
  private String jBq;
  private String jBr;
  private boolean jBs = false;
  private j.a jBt;
  private boolean jBu = false;
  private boolean jBv = false;
  private String juL;
  private j.a jvy;
  
  static
  {
    if (!ExdeviceBindDeviceUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private void qr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      label28:
      switch (paramInt)
      {
      }
      break;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
        String str = getString(R.l.exdevice_bind_device_help_help);
        Object localObject = new SpannableString(str);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(R.e.link_color), 0, str.length(), 33);
        ((SpannableString)localObject).setSpan(new ExdeviceBindDeviceUI.9(this), 0, str.length(), 33);
        this.jBm.setMovementMethod(LinkMovementMethod.getInstance());
        this.jBm.setText((CharSequence)localObject);
        break label28;
        str = getString(R.l.exdevice_bind_device_help_tips_blue);
        localObject = getString(R.l.exdevice_bind_device_help_prepare);
        SpannableString localSpannableString = new SpannableString(str + (String)localObject);
        localSpannableString.setSpan(new ForegroundColorSpan(R.e.link_color), str.length(), str.length() + ((String)localObject).length(), 33);
        localSpannableString.setSpan(new ExdeviceBindDeviceUI.10(this), str.length(), str.length() + ((String)localObject).length(), 33);
        this.jBm.setMovementMethod(LinkMovementMethod.getInstance());
        this.jBm.setText(localSpannableString);
        break label28;
        str = getString(R.l.exdevice_bind_device_help_tips_wifi);
        localObject = getString(R.l.exdevice_connect_wifi);
        localSpannableString = new SpannableString(str + (String)localObject);
        localSpannableString.setSpan(new ForegroundColorSpan(R.e.link_color), str.length(), str.length() + ((String)localObject).length(), 33);
        localSpannableString.setSpan(new ExdeviceBindDeviceUI.2(this), str.length(), str.length() + ((String)localObject).length(), 33);
        this.jBm.setMovementMethod(LinkMovementMethod.getInstance());
        this.jBm.setText(localSpannableString);
        break label28;
        this.jBn.setImageResource(R.k.bluetooth_logo);
        this.jAx.setText(R.l.exdevice_can_not_scan);
        this.jAy.setText(R.l.exdevice_bind_device_blue_no_open_detail);
        continue;
        this.jBn.setImageResource(R.k.bluetooth_logo);
        this.jAx.setText(R.l.exdevice_ble_version_below_4_0);
        this.jAy.setText("");
        continue;
        this.jBn.setImageResource(R.k.wifi_logo);
        this.jAx.setText(R.l.exdevice_can_not_scan);
        this.jAy.setText(R.l.exdevice_bind_device_wifi_no_open_detail);
      }
    }
    this.jBl.setVisibility(0);
    this.Nn.setVisibility(0);
    this.jBm.setVisibility(0);
    this.jBn.setVisibility(8);
    this.jAx.setVisibility(8);
    this.jAy.setVisibility(8);
    return;
    this.gqx.setVisibility(8);
    this.jBl.setVisibility(8);
    this.Nn.setVisibility(8);
    this.jBm.setVisibility(8);
    this.jBn.setVisibility(0);
    this.jAx.setVisibility(0);
    if (paramInt == 4)
    {
      this.jAy.setVisibility(8);
      return;
    }
    this.jAy.setVisibility(0);
  }
  
  final void a(ExdeviceBindDeviceUI.f paramf)
  {
    Object localObject = paramf.getKey();
    if (this.jBk.BM((String)localObject)) {
      return;
    }
    y.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.aMu());
    localObject = this.jBk;
    if ((paramf != null) && (!((ExdeviceBindDeviceUI.a)localObject).BM(paramf.getKey())))
    {
      paramf.jBP = ((ExdeviceBindDeviceUI.a)localObject).c(paramf);
      ((ExdeviceBindDeviceUI.a)localObject).jBD.add(paramf);
    }
    this.jBk.notifyDataSetChanged();
    if (paramf.jBQ == ExdeviceBindDeviceUI.b.jBI)
    {
      y.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.jBR.btt, this.juL, this.jBq });
      au.Dk().a(new t(paramf.jBR.btt, this.juL, this.jBq), 0);
      return;
    }
    if (paramf.jBQ == ExdeviceBindDeviceUI.b.jBH)
    {
      y.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.jBS.jAa, paramf.jBS.juM });
      au.Dk().a(new v(paramf.jBS.jAa, paramf.jBS.juM, paramf.jBX), 0);
      return;
    }
    Assert.assertTrue(false);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void d(String paramString, int paramInt, long paramLong) {}
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_bind_device_ui;
  }
  
  protected final void initView()
  {
    this.Nn = ((ListView)findViewById(R.h.listview));
    Object localObject = View.inflate(this, R.i.exdevice_bind_device_ui_header, null);
    this.jBo = View.inflate(this, R.i.exdevice_searching_device_tips_view, null);
    this.jBl = this.jBo.findViewById(R.h.searchingTipsV);
    this.iuP = ((TextView)this.jBo.findViewById(R.h.tipsTV));
    this.jBm = ((TextView)findViewById(R.h.scanHelpTV));
    this.jBn = ((ImageView)findViewById(R.h.logoTV));
    this.jAx = ((TextView)findViewById(R.h.errTips));
    this.jAy = ((TextView)findViewById(R.h.errTipsDetail));
    this.gqx = ((ScrollView)findViewById(R.h.devListScrollView));
    this.Nn.addHeaderView((View)localObject, null, false);
    this.Nn.addFooterView(this.jBo, null, false);
    this.jBk = new ExdeviceBindDeviceUI.a(this.juL, this.jBp, this.jBq);
    this.Nn.setAdapter(this.jBk);
    this.Nn.setOnItemClickListener(new ExdeviceBindDeviceUI.5(this));
    if ((this.jBv) && (!this.jBu)) {
      if (!a.cP(this.mController.uMN))
      {
        y.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        qr(4);
      }
    }
    do
    {
      return;
      if (!a.awB())
      {
        y.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        qr(3);
        return;
      }
      if ((!this.jBv) && (this.jBu) && (!aq.isWifi(this.mController.uMN)))
      {
        y.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
        qr(5);
        return;
      }
      if (this.jBp == ExdeviceBindDeviceUI.e.jBM)
      {
        qr(0);
        return;
      }
      if (this.jBp != ExdeviceBindDeviceUI.e.jBN) {
        break;
      }
      if ((this.jBv) && (this.jBu))
      {
        Assert.assertTrue(false);
        qr(1);
        return;
      }
      if (this.jBv)
      {
        qr(2);
        return;
      }
    } while (!this.jBu);
    qr(1);
    return;
    localObject = ExdeviceBindDeviceUI.e.jBL;
    Assert.assertTrue(false);
  }
  
  public final void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    y.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      return;
    }
    final ExdeviceBindDeviceUI.f localf = new ExdeviceBindDeviceUI.f(this, (byte)0);
    localf.jBQ = ExdeviceBindDeviceUI.b.jBI;
    localf.jBR = new ExdeviceBindDeviceUI.c(this, (byte)0);
    localf.jBR.jBK = paramString1;
    localf.jBR.btt = b.ef(b.BU(paramString2));
    ai.d(new Runnable()
    {
      public final void run()
      {
        ExdeviceBindDeviceUI.this.a(localf);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jBk.aMt();
    this.jBk.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceBindDeviceUI.1(this));
    Object localObject = getIntent();
    this.jBq = ((Intent)localObject).getStringExtra("device_category_id");
    this.juL = ((Intent)localObject).getStringExtra("device_brand_name");
    this.jAa = ((Intent)localObject).getStringExtra("device_type");
    if ((this.jAa == null) || (this.jAa.length() == 0)) {
      this.jAa = this.juL;
    }
    String str2 = ((Intent)localObject).getStringExtra("device_scan_conn_proto");
    String str3 = ((Intent)localObject).getStringExtra("device_scan_mode");
    paramBundle = "";
    String str1 = ((Intent)localObject).getStringExtra("device_title");
    localObject = str1;
    if (bk.bl(str1)) {
      localObject = this.mController.uMN.getString(R.l.exdevice_device_default_name);
    }
    if (str3.contains("SCAN_MY_DEVICE"))
    {
      this.jBp = ExdeviceBindDeviceUI.e.jBM;
      paramBundle = this.mController.uMN.getString(R.l.exdevice_add_device);
      setMMTitle(paramBundle);
      if (this.jBp != ExdeviceBindDeviceUI.e.jBN) {
        break label426;
      }
      this.jBu = str2.contains("wifi");
      this.jBv = str2.contains("blue");
      y.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.jBu), Boolean.valueOf(this.jBv) });
    }
    for (;;)
    {
      this.jvy = new ExdeviceBindDeviceUI.3(this);
      this.jBt = new ExdeviceBindDeviceUI.4(this);
      initView();
      this.iuP.setText(this.mController.uMN.getString(R.l.exdevice_search_catalog_device, new Object[] { localObject }));
      au.Dk().a(1264, this);
      au.Dk().a(1706, this);
      au.Dk().a(1270, this);
      au.Dk().a(1719, this);
      if (this.jBv) {
        ad.aLW().a(this);
      }
      if (this.jBu)
      {
        j.aLC().a(10, this.jvy);
        j.aLC().a(11, this.jBt);
        Java2CExDevice.initWCLanDeviceLib();
      }
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.jBp = ExdeviceBindDeviceUI.e.jBN;
        paramBundle = this.mController.uMN.getString(R.l.exdevice_add_catalog_device);
        break;
      }
      Assert.assertTrue(false);
      break;
      label426:
      if (this.jBp == ExdeviceBindDeviceUI.e.jBM)
      {
        this.jBv = true;
        this.jBu = true;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jBu)
    {
      au.DS().O(new ExdeviceBindDeviceUI.6(this));
      j.aLC().b(10, this.jvy);
      j.aLC().b(11, this.jBt);
    }
    if (this.jBv)
    {
      ad.aLW().b(this);
      ad.aLX().awl();
    }
    au.Dk().b(1264, this);
    au.Dk().b(1706, this);
    au.Dk().b(1270, this);
    au.Dk().b(1719, this);
  }
  
  protected void onPause()
  {
    super.onPause();
    y.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.jBu) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.jBv) {
      ad.aLX().awl();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    y.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.jBv)
    {
      ad.aLW();
      e.aLy();
    }
    if (this.jBu) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.jBk.aMt();
    this.jBk.notifyDataSetChanged();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      y.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
      return;
    }
    ai.d(new ExdeviceBindDeviceUI.8(this, paramInt1, paramInt2, paramString, paramm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */