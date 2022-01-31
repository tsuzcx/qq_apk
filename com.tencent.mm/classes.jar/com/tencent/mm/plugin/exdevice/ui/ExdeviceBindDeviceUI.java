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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.d.a.e.a;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI
  extends MMActivity
  implements f, e.b
{
  private ProgressDialog eeN;
  private ScrollView hLr;
  private TextView kvT;
  private j.a lEX;
  private String lEk;
  private TextView lJW;
  private TextView lJX;
  private String lJz;
  private ExdeviceBindDeviceUI.a lKJ;
  private View lKK;
  private TextView lKL;
  private ImageView lKM;
  private View lKN;
  private ExdeviceBindDeviceUI.e lKO;
  private String lKP;
  private String lKQ;
  private boolean lKR = false;
  private j.a lKS;
  private boolean lKT = false;
  private boolean lKU = false;
  private ListView mListView;
  
  static
  {
    AppMethodBeat.i(19870);
    if (!ExdeviceBindDeviceUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(19870);
      return;
    }
  }
  
  private void uY(int paramInt)
  {
    AppMethodBeat.i(19866);
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
      AppMethodBeat.o(19866);
      return;
      String str = getString(2131299353);
      Object localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(2131690214), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new ExdeviceBindDeviceUI.9(this), 0, str.length(), 33);
      this.lKL.setMovementMethod(LinkMovementMethod.getInstance());
      this.lKL.setText((CharSequence)localObject);
      break;
      str = getString(2131299357);
      localObject = getString(2131299354);
      SpannableString localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131690214), str.length(), str.length() + ((String)localObject).length(), 33);
      localSpannableString.setSpan(new ExdeviceBindDeviceUI.10(this), str.length(), str.length() + ((String)localObject).length(), 33);
      this.lKL.setMovementMethod(LinkMovementMethod.getInstance());
      this.lKL.setText(localSpannableString);
      break;
      str = getString(2131299358);
      localObject = getString(2131299387);
      localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131690214), str.length(), str.length() + ((String)localObject).length(), 33);
      localSpannableString.setSpan(new ExdeviceBindDeviceUI.2(this), str.length(), str.length() + ((String)localObject).length(), 33);
      this.lKL.setMovementMethod(LinkMovementMethod.getInstance());
      this.lKL.setText(localSpannableString);
      break;
      this.lKM.setImageResource(2131230997);
      this.lJW.setText(2131299366);
      this.lJX.setText(2131299350);
      break label72;
      this.lKM.setImageResource(2131230997);
      this.lJW.setText(2131299364);
      this.lJX.setText("");
      break label72;
      this.lKM.setImageResource(2131232250);
      this.lJW.setText(2131299366);
      this.lJX.setText(2131299361);
      break label72;
      this.lKK.setVisibility(0);
      this.mListView.setVisibility(0);
      this.lKL.setVisibility(0);
      this.lKM.setVisibility(8);
      this.lJW.setVisibility(8);
      this.lJX.setVisibility(8);
      AppMethodBeat.o(19866);
      return;
      this.hLr.setVisibility(8);
      this.lKK.setVisibility(8);
      this.mListView.setVisibility(8);
      this.lKL.setVisibility(8);
      this.lKM.setVisibility(0);
      this.lJW.setVisibility(0);
      if (paramInt == 4)
      {
        this.lJX.setVisibility(8);
        AppMethodBeat.o(19866);
        return;
      }
      this.lJX.setVisibility(0);
    }
  }
  
  final void a(ExdeviceBindDeviceUI.f paramf)
  {
    AppMethodBeat.i(19864);
    Object localObject = paramf.getKey();
    if (this.lKJ.LO((String)localObject))
    {
      AppMethodBeat.o(19864);
      return;
    }
    ab.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.bqH());
    localObject = this.lKJ;
    if ((paramf != null) && (!((ExdeviceBindDeviceUI.a)localObject).LO(paramf.getKey())))
    {
      paramf.lLo = ((ExdeviceBindDeviceUI.a)localObject).c(paramf);
      ((ExdeviceBindDeviceUI.a)localObject).lLc.add(paramf);
    }
    this.lKJ.notifyDataSetChanged();
    if (paramf.lLp == ExdeviceBindDeviceUI.b.lLh)
    {
      ab.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.lLq.bUD, this.lEk, this.lKP });
      aw.Rc().a(new t(paramf.lLq.bUD, this.lEk, this.lKP), 0);
      AppMethodBeat.o(19864);
      return;
    }
    if (paramf.lLp == ExdeviceBindDeviceUI.b.lLg)
    {
      ab.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.lLr.lJz, paramf.lLr.lEl });
      aw.Rc().a(new v(paramf.lLr.lJz, paramf.lLr.lEl, paramf.lLw), 0);
      AppMethodBeat.o(19864);
      return;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(19864);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void c(String paramString, int paramInt, long paramLong) {}
  
  public int getLayoutId()
  {
    return 2130969446;
  }
  
  public void initView()
  {
    AppMethodBeat.i(19859);
    this.mListView = ((ListView)findViewById(2131821736));
    Object localObject = View.inflate(this, 2130969448, null);
    this.lKN = View.inflate(this, 2130969481, null);
    this.lKK = this.lKN.findViewById(2131823747);
    this.kvT = ((TextView)this.lKN.findViewById(2131823748));
    this.lKL = ((TextView)findViewById(2131823746));
    this.lKM = ((ImageView)findViewById(2131823742));
    this.lJW = ((TextView)findViewById(2131823743));
    this.lJX = ((TextView)findViewById(2131823744));
    this.hLr = ((ScrollView)findViewById(2131823758));
    this.mListView.addHeaderView((View)localObject, null, false);
    this.mListView.addFooterView(this.lKN, null, false);
    this.lKJ = new ExdeviceBindDeviceUI.a(this.lEk, this.lKO, this.lKP);
    this.mListView.setAdapter(this.lKJ);
    this.mListView.setOnItemClickListener(new ExdeviceBindDeviceUI.5(this));
    if ((this.lKU) && (!this.lKT))
    {
      if (!a.dA(getContext()))
      {
        ab.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        uY(4);
        AppMethodBeat.o(19859);
        return;
      }
      if (!a.aWe())
      {
        ab.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        uY(3);
        AppMethodBeat.o(19859);
        return;
      }
    }
    if ((!this.lKU) && (this.lKT) && (!at.isWifi(getContext())))
    {
      ab.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
      uY(5);
      AppMethodBeat.o(19859);
      return;
    }
    if (this.lKO == ExdeviceBindDeviceUI.e.lLl)
    {
      uY(0);
      AppMethodBeat.o(19859);
      return;
    }
    if (this.lKO == ExdeviceBindDeviceUI.e.lLm)
    {
      if ((this.lKU) && (this.lKT))
      {
        Assert.assertTrue(false);
        uY(1);
        AppMethodBeat.o(19859);
        return;
      }
      if (this.lKU)
      {
        uY(2);
        AppMethodBeat.o(19859);
        return;
      }
      if (this.lKT)
      {
        uY(1);
        AppMethodBeat.o(19859);
      }
    }
    else
    {
      localObject = ExdeviceBindDeviceUI.e.lLk;
      Assert.assertTrue(false);
    }
    AppMethodBeat.o(19859);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(19865);
    this.lKJ.bqG();
    this.lKJ.notifyDataSetChanged();
    AppMethodBeat.o(19865);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19857);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(19824);
        ExdeviceBindDeviceUI.this.finish();
        AppMethodBeat.o(19824);
        return true;
      }
    });
    Object localObject = getIntent();
    this.lKP = ((Intent)localObject).getStringExtra("device_category_id");
    this.lEk = ((Intent)localObject).getStringExtra("device_brand_name");
    this.lJz = ((Intent)localObject).getStringExtra("device_type");
    if ((this.lJz == null) || (this.lJz.length() == 0)) {
      this.lJz = this.lEk;
    }
    String str2 = ((Intent)localObject).getStringExtra("device_scan_conn_proto");
    String str3 = ((Intent)localObject).getStringExtra("device_scan_mode");
    paramBundle = "";
    String str1 = ((Intent)localObject).getStringExtra("device_title");
    localObject = str1;
    if (bo.isNullOrNil(str1)) {
      localObject = getContext().getString(2131299402);
    }
    if (str3.contains("SCAN_MY_DEVICE"))
    {
      this.lKO = ExdeviceBindDeviceUI.e.lLl;
      paramBundle = getContext().getString(2131299340);
      setMMTitle(paramBundle);
      if (this.lKO != ExdeviceBindDeviceUI.e.lLm) {
        break label426;
      }
      this.lKT = str2.contains("wifi");
      this.lKU = str2.contains("blue");
      ab.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.lKT), Boolean.valueOf(this.lKU) });
    }
    for (;;)
    {
      this.lEX = new ExdeviceBindDeviceUI.3(this);
      this.lKS = new ExdeviceBindDeviceUI.4(this);
      initView();
      this.kvT.setText(getContext().getString(2131299467, new Object[] { localObject }));
      aw.Rc().a(1264, this);
      aw.Rc().a(1706, this);
      aw.Rc().a(1270, this);
      aw.Rc().a(1719, this);
      if (this.lKU) {
        ad.bqj().a(this);
      }
      if (this.lKT)
      {
        j.bpP().a(10, this.lEX);
        j.bpP().a(11, this.lKS);
        Java2CExDevice.initWCLanDeviceLib();
      }
      AppMethodBeat.o(19857);
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.lKO = ExdeviceBindDeviceUI.e.lLm;
        paramBundle = getContext().getString(2131299338);
        break;
      }
      Assert.assertTrue(false);
      break;
      label426:
      if (this.lKO == ExdeviceBindDeviceUI.e.lLl)
      {
        this.lKU = true;
        this.lKT = true;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(19861);
    super.onDestroy();
    if (this.lKT)
    {
      aw.RO().ac(new ExdeviceBindDeviceUI.6(this));
      j.bpP().b(10, this.lEX);
      j.bpP().b(11, this.lKS);
    }
    if (this.lKU)
    {
      ad.bqj().b(this);
      ad.bqk().stopScan();
    }
    aw.Rc().b(1264, this);
    aw.Rc().b(1706, this);
    aw.Rc().b(1270, this);
    aw.Rc().b(1719, this);
    AppMethodBeat.o(19861);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(19860);
    super.onPause();
    ab.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.lKT) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.lKU) {
      ad.bqk().stopScan();
    }
    AppMethodBeat.o(19860);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(19858);
    super.onResume();
    ab.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.lKU)
    {
      ad.bqj();
      e.bpM();
    }
    if (this.lKT) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.lKJ.bqG();
    this.lKJ.notifyDataSetChanged();
    AppMethodBeat.o(19858);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19863);
    ab.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      ab.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
      AppMethodBeat.o(19863);
      return;
    }
    al.d(new ExdeviceBindDeviceUI.8(this, paramInt1, paramInt2, paramString, paramm));
    AppMethodBeat.o(19863);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(19862);
    ab.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(19862);
      return;
    }
    ExdeviceBindDeviceUI.f localf = new ExdeviceBindDeviceUI.f(this, (byte)0);
    localf.lLp = ExdeviceBindDeviceUI.b.lLh;
    localf.lLq = new ExdeviceBindDeviceUI.c(this, (byte)0);
    localf.lLq.lLj = paramString1;
    localf.lLq.bUD = b.jx(b.LX(paramString2));
    al.d(new ExdeviceBindDeviceUI.7(this, localf));
    AppMethodBeat.o(19862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */