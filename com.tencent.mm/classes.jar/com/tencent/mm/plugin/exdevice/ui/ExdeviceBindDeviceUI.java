package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.d.a.e.a;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI
  extends MMActivity
  implements g, e.b
{
  private ProgressDialog fpP;
  private ScrollView jPx;
  private String mDeviceType;
  private ListView mListView;
  private TextView nBm;
  private String oUW;
  private j.a oVJ;
  private TextView paG;
  private TextView paH;
  private String pbA;
  private boolean pbB = false;
  private j.a pbC;
  private boolean pbD = false;
  private boolean pbE = false;
  private ExdeviceBindDeviceUI.a pbt;
  private View pbu;
  private TextView pbv;
  private ImageView pbw;
  private View pbx;
  private ExdeviceBindDeviceUI.e pby;
  private String pbz;
  
  static
  {
    AppMethodBeat.i(23938);
    if (!ExdeviceBindDeviceUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(23938);
      return;
    }
  }
  
  private void Bc(int paramInt)
  {
    AppMethodBeat.i(23934);
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        label72:
        switch (paramInt)
        {
        }
        break;
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(23934);
      return;
      String str = getString(2131758481);
      Object localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(2131100547), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new ExdeviceBindDeviceUI.9(this), 0, str.length(), 33);
      this.pbv.setMovementMethod(LinkMovementMethod.getInstance());
      this.pbv.setText((CharSequence)localObject);
      break;
      str = getString(2131758485);
      localObject = getString(2131758482);
      SpannableString localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131100547), str.length(), str.length() + ((String)localObject).length(), 33);
      localSpannableString.setSpan(new ExdeviceBindDeviceUI.10(this), str.length(), str.length() + ((String)localObject).length(), 33);
      this.pbv.setMovementMethod(LinkMovementMethod.getInstance());
      this.pbv.setText(localSpannableString);
      break;
      str = getString(2131758486);
      localObject = getString(2131758515);
      localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131100547), str.length(), str.length() + ((String)localObject).length(), 33);
      localSpannableString.setSpan(new ExdeviceBindDeviceUI.2(this), str.length(), str.length() + ((String)localObject).length(), 33);
      this.pbv.setMovementMethod(LinkMovementMethod.getInstance());
      this.pbv.setText(localSpannableString);
      break;
      this.pbw.setImageResource(2131689789);
      this.paG.setText(2131758494);
      this.paH.setText(2131758478);
      break label72;
      this.pbw.setImageResource(2131689789);
      this.paG.setText(2131758492);
      this.paH.setText("");
      break label72;
      this.pbw.setImageResource(2131691457);
      this.paG.setText(2131758494);
      this.paH.setText(2131758489);
      break label72;
      this.pbu.setVisibility(0);
      this.mListView.setVisibility(0);
      this.pbv.setVisibility(0);
      this.pbw.setVisibility(8);
      this.paG.setVisibility(8);
      this.paH.setVisibility(8);
      AppMethodBeat.o(23934);
      return;
      this.jPx.setVisibility(8);
      this.pbu.setVisibility(8);
      this.mListView.setVisibility(8);
      this.pbv.setVisibility(8);
      this.pbw.setVisibility(0);
      this.paG.setVisibility(0);
      if (paramInt == 4)
      {
        this.paH.setVisibility(8);
        AppMethodBeat.o(23934);
        return;
      }
      this.paH.setVisibility(0);
    }
  }
  
  final void a(ExdeviceBindDeviceUI.f paramf)
  {
    AppMethodBeat.i(23932);
    Object localObject = paramf.getKey();
    if (this.pbt.UX((String)localObject))
    {
      AppMethodBeat.o(23932);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.cap());
    localObject = this.pbt;
    if ((paramf != null) && (!((ExdeviceBindDeviceUI.a)localObject).UX(paramf.getKey())))
    {
      paramf.pbY = ((ExdeviceBindDeviceUI.a)localObject).c(paramf);
      ((ExdeviceBindDeviceUI.a)localObject).pbM.add(paramf);
    }
    this.pbt.notifyDataSetChanged();
    if (paramf.pbZ == ExdeviceBindDeviceUI.b.pbR)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.pca.cGn, this.oUW, this.pbz });
      az.aeS().a(new t(paramf.pca.cGn, this.oUW, this.pbz), 0);
      AppMethodBeat.o(23932);
      return;
    }
    if (paramf.pbZ == ExdeviceBindDeviceUI.b.pbQ)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.pcb.mDeviceType, paramf.pcb.oUX });
      az.aeS().a(new v(paramf.pcb.mDeviceType, paramf.pcb.oUX, paramf.pcg), 0);
      AppMethodBeat.o(23932);
      return;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(23932);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void c(String paramString, int paramInt, long paramLong) {}
  
  public int getLayoutId()
  {
    return 2131493858;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23927);
    this.mListView = ((ListView)findViewById(2131301457));
    Object localObject = View.inflate(this, 2131493860, null);
    this.pbx = View.inflate(this, 2131493893, null);
    this.pbu = this.pbx.findViewById(2131304456);
    this.nBm = ((TextView)this.pbx.findViewById(2131305885));
    this.pbv = ((TextView)findViewById(2131304300));
    this.pbw = ((ImageView)findViewById(2131301586));
    this.paG = ((TextView)findViewById(2131299511));
    this.paH = ((TextView)findViewById(2131299512));
    this.jPx = ((ScrollView)findViewById(2131299066));
    this.mListView.addHeaderView((View)localObject, null, false);
    this.mListView.addFooterView(this.pbx, null, false);
    this.pbt = new ExdeviceBindDeviceUI.a(this.oUW, this.pby, this.pbz);
    this.mListView.setAdapter(this.pbt);
    this.mListView.setOnItemClickListener(new ExdeviceBindDeviceUI.5(this));
    if ((this.pbE) && (!this.pbD))
    {
      if (!a.eh(getContext()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        Bc(4);
        AppMethodBeat.o(23927);
        return;
      }
      if (!a.bBG())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        Bc(3);
        AppMethodBeat.o(23927);
        return;
      }
    }
    if ((!this.pbE) && (this.pbD) && (!ay.isWifi(getContext())))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
      Bc(5);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.pby == ExdeviceBindDeviceUI.e.pbV)
    {
      Bc(0);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.pby == ExdeviceBindDeviceUI.e.pbW)
    {
      if ((this.pbE) && (this.pbD))
      {
        Assert.assertTrue(false);
        Bc(1);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.pbE)
      {
        Bc(2);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.pbD)
      {
        Bc(1);
        AppMethodBeat.o(23927);
      }
    }
    else
    {
      localObject = ExdeviceBindDeviceUI.e.pbU;
      Assert.assertTrue(false);
    }
    AppMethodBeat.o(23927);
  }
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23930);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (bt.isNullOrNil(paramString2))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23930);
      return;
    }
    ExdeviceBindDeviceUI.f localf = new ExdeviceBindDeviceUI.f(this, (byte)0);
    localf.pbZ = ExdeviceBindDeviceUI.b.pbR;
    localf.pca = new ExdeviceBindDeviceUI.c(this, (byte)0);
    localf.pca.pbT = paramString1;
    localf.pca.cGn = b.pf(b.Vg(paramString2));
    aq.f(new ExdeviceBindDeviceUI.7(this, localf));
    AppMethodBeat.o(23930);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23933);
    this.pbt.cao();
    this.pbt.notifyDataSetChanged();
    AppMethodBeat.o(23933);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23925);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceBindDeviceUI.1(this));
    Object localObject = getIntent();
    this.pbz = ((Intent)localObject).getStringExtra("device_category_id");
    this.oUW = ((Intent)localObject).getStringExtra("device_brand_name");
    this.mDeviceType = ((Intent)localObject).getStringExtra("device_type");
    if ((this.mDeviceType == null) || (this.mDeviceType.length() == 0)) {
      this.mDeviceType = this.oUW;
    }
    String str2 = ((Intent)localObject).getStringExtra("device_scan_conn_proto");
    String str3 = ((Intent)localObject).getStringExtra("device_scan_mode");
    paramBundle = "";
    String str1 = ((Intent)localObject).getStringExtra("device_title");
    localObject = str1;
    if (bt.isNullOrNil(str1)) {
      localObject = getContext().getString(2131758530);
    }
    if (str3.contains("SCAN_MY_DEVICE"))
    {
      this.pby = ExdeviceBindDeviceUI.e.pbV;
      paramBundle = getContext().getString(2131758468);
      setMMTitle(paramBundle);
      if (this.pby != ExdeviceBindDeviceUI.e.pbW) {
        break label425;
      }
      this.pbD = str2.contains("wifi");
      this.pbE = str2.contains("blue");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.pbD), Boolean.valueOf(this.pbE) });
    }
    for (;;)
    {
      this.oVJ = new ExdeviceBindDeviceUI.3(this);
      this.pbC = new ExdeviceBindDeviceUI.4(this);
      initView();
      this.nBm.setText(getContext().getString(2131758598, new Object[] { localObject }));
      az.aeS().a(1264, this);
      az.aeS().a(1706, this);
      az.aeS().a(1270, this);
      az.aeS().a(1719, this);
      if (this.pbE) {
        com.tencent.mm.plugin.exdevice.model.ad.bZR().a(this);
      }
      if (this.pbD)
      {
        j.bZx().a(10, this.oVJ);
        j.bZx().a(11, this.pbC);
        Java2CExDevice.initWCLanDeviceLib();
      }
      AppMethodBeat.o(23925);
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.pby = ExdeviceBindDeviceUI.e.pbW;
        paramBundle = getContext().getString(2131758466);
        break;
      }
      Assert.assertTrue(false);
      break;
      label425:
      if (this.pby == ExdeviceBindDeviceUI.e.pbV)
      {
        this.pbE = true;
        this.pbD = true;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23929);
    super.onDestroy();
    if (this.pbD)
    {
      az.afE().ax(new ExdeviceBindDeviceUI.6(this));
      j.bZx().b(10, this.oVJ);
      j.bZx().b(11, this.pbC);
    }
    if (this.pbE)
    {
      com.tencent.mm.plugin.exdevice.model.ad.bZR().b(this);
      com.tencent.mm.plugin.exdevice.model.ad.bZS().stopScan();
    }
    az.aeS().b(1264, this);
    az.aeS().b(1706, this);
    az.aeS().b(1270, this);
    az.aeS().b(1719, this);
    AppMethodBeat.o(23929);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(23928);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.pbD) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.pbE) {
      com.tencent.mm.plugin.exdevice.model.ad.bZS().stopScan();
    }
    AppMethodBeat.o(23928);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23926);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.pbE)
    {
      com.tencent.mm.plugin.exdevice.model.ad.bZR();
      e.bZt();
    }
    if (this.pbD) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.pbt.cao();
    this.pbt.notifyDataSetChanged();
    AppMethodBeat.o(23926);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23931);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
      AppMethodBeat.o(23931);
      return;
    }
    aq.f(new ExdeviceBindDeviceUI.8(this, paramInt1, paramInt2, paramString, paramn));
    AppMethodBeat.o(23931);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */