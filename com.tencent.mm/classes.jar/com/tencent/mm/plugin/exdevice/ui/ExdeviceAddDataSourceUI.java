package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.a.em;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.bnh;
import com.tencent.mm.protocal.c.hx;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI
  extends MMActivity
  implements f, e.b
{
  private ListView Nn;
  private com.tencent.mm.ui.base.p dpF;
  private final BroadcastReceiver hWU = new ExdeviceAddDataSourceUI.4(this);
  private LocationManager jAA;
  private boolean jAB = false;
  private l jAC;
  private ExdeviceAddDataSourceUI.a jAu;
  private List<ExdeviceAddDataSourceUI.b> jAv;
  private TextView jAw;
  private TextView jAx;
  private TextView jAy;
  private RelativeLayout jAz;
  private View jcy;
  
  private void aMs()
  {
    runOnUiThread(new ExdeviceAddDataSourceUI.2(this));
  }
  
  private static boolean aw(String paramString, boolean paramBoolean)
  {
    em localem = new em();
    localem.bLb.mac = paramString;
    localem.bLb.bJx = paramBoolean;
    if (!com.tencent.mm.sdk.b.a.udP.m(localem))
    {
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  private void qr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      this.jAz.setVisibility(8);
      this.jAx.setText(R.l.exdevice_ble_version_below_4_0);
      this.jAy.setText("");
      return;
    case 1: 
      this.jAz.setVisibility(8);
      this.jAx.setText(R.l.exdevice_can_not_scan);
      this.jAy.setText(R.l.exdevice_bind_device_blue_no_open_detail);
      return;
    case 4: 
      this.jAz.setVisibility(8);
      this.jAx.setText(R.l.exdevice_can_not_scan);
      this.jAy.setText(R.l.exdevice_gps_not_open);
      return;
    }
    this.jAz.setVisibility(0);
    this.jcy.setVisibility(0);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void d(String paramString, int paramInt, long paramLong)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
      return;
    }
    ExdeviceAddDataSourceUI.b localb = this.jAu.BL(paramString);
    if (localb == null)
    {
      y.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[] { paramString });
      return;
    }
    if ((localb.jAK == ExdeviceAddDataSourceUI.c.jAM) && (paramInt == 4))
    {
      localb.jAK = ExdeviceAddDataSourceUI.c.jAL;
      aMs();
      runOnUiThread(new ExdeviceAddDataSourceUI.10(this, localb));
    }
    for (;;)
    {
      runOnUiThread(new ExdeviceAddDataSourceUI.11(this));
      return;
      if (paramInt == 2)
      {
        if (localb.jAK == ExdeviceAddDataSourceUI.c.jAM)
        {
          localb.jAK = ExdeviceAddDataSourceUI.c.jAN;
          y.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
          if (localb.bJY != null)
          {
            this.jAC = new l(localb.bJY, 0);
            au.Dk().a(this.jAC, 0);
          }
        }
        else
        {
          y.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[] { paramString });
          aw(paramString, false);
        }
      }
      else
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          break;
        }
        localb.jAK = ExdeviceAddDataSourceUI.c.jAL;
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.exdevice_add_data_source_ui;
  }
  
  protected final void initView()
  {
    this.Nn = ((ListView)findViewById(R.h.listview));
    View localView = View.inflate(this, R.i.exdevice_add_data_source_ui_header, null);
    this.jAz = ((RelativeLayout)findViewById(R.h.searchLayout));
    this.jcy = View.inflate(this, R.i.exdevice_add_data_source_ui_footer, null);
    this.jAw = ((TextView)findViewById(R.h.scanHelpTV));
    this.jAx = ((TextView)findViewById(R.h.errTips));
    this.jAy = ((TextView)findViewById(R.h.errTipsDetail));
    String str1 = getString(R.l.exdevice_scan_device_help_tips);
    String str2 = getString(R.l.exdevice_connect_device_help);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ForegroundColorSpan(R.e.link_color), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ExdeviceAddDataSourceUI.5(this), str1.length(), str1.length() + str2.length(), 33);
    this.jAw.setMovementMethod(LinkMovementMethod.getInstance());
    this.jAw.setText(localSpannableString);
    this.Nn.addHeaderView(localView, null, false);
    this.Nn.addFooterView(this.jcy, null, false);
    this.jAu = new ExdeviceAddDataSourceUI.a();
    this.Nn.setAdapter(this.jAu);
    this.Nn.setOnItemClickListener(new ExdeviceAddDataSourceUI.6(this));
  }
  
  public final void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    y.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      runOnUiThread(new ExdeviceAddDataSourceUI.9(this));
    }
    if (bk.bl(paramString2))
    {
      y.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      return;
    }
    int i = 0;
    if (i < this.jAv.size())
    {
      paramString1 = (ExdeviceAddDataSourceUI.b)this.jAv.get(i);
      if ((paramString1 == null) || (bk.bl(paramString1.mac)))
      {
        paramString1 = this.jAv;
        int j = i - 1;
        paramString1.remove(i);
        i = j;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (paramString1.mac.equalsIgnoreCase(paramString2))
      {
        y.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[] { paramString2 });
        return;
        y.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[] { Boolean.valueOf(au.Dk().a(new t(paramString2.replaceAll(":", ""), null, null), 0)), paramString2 });
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceAddDataSourceUI.1(this));
    setMMTitle(R.l.exdevice_add_data_source);
    if ((d.gF(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
      this.jAB = true;
    }
    this.jAv = new LinkedList();
    this.jAA = ((LocationManager)this.mController.uMN.getSystemService("location"));
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramBundle.addAction("android.location.MODE_CHANGED");
    this.mController.uMN.registerReceiver(this.hWU, paramBundle);
    au.Dk().a(536, this);
    au.Dk().a(1706, this);
    ad.aLW().a(this);
    if (!com.tencent.mm.plugin.f.a.e.a.cP(this.mController.uMN))
    {
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      qr(2);
      return;
    }
    if (!com.tencent.mm.plugin.f.a.e.a.awB())
    {
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
      qr(1);
      return;
    }
    if ((this.jAA != null) && (this.jAB) && (!this.jAA.isProviderEnabled("gps")))
    {
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
      qr(4);
      return;
    }
    ad.aLW();
    e.aLy();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.DS().O(new ExdeviceAddDataSourceUI.7(this));
    au.Dk().b(536, this);
    au.Dk().b(1706, this);
    this.mController.uMN.unregisterReceiver(this.hWU);
    ad.aLW().b(this);
    ad.aLX().awl();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null) {
      y.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
    }
    do
    {
      do
      {
        return;
        if (paramm.getType() == 536)
        {
          aMs();
          this.jAC = null;
          paramString = ((l)paramm).aLE();
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            paramString = this.jAu.BL(b.BV(paramString.sBd.sAE));
            if (paramString != null)
            {
              paramString.jAK = ExdeviceAddDataSourceUI.c.jAL;
              aw(paramString.mac, false);
            }
            y.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
            return;
          }
          paramm = new Intent();
          paramm.putExtra("device_mac", b.BU(b.BV(paramString.sBd.sAE)));
          aw(b.BV(paramString.sBd.sAE), false);
          setResult(-1, paramm);
          finish();
          return;
        }
      } while (paramm.getType() != 1706);
      paramm = ((t)paramm).aLH();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        return;
      }
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[] { Long.valueOf(paramm.sBd.cMY) });
    } while (0L == (paramm.sBd.cMY & 1L));
    if (ad.aLL().cQ(paramm.sBc.hQb, paramm.sBc.syI) != null)
    {
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[] { paramm.sBd.sAE });
      return;
    }
    ExdeviceAddDataSourceUI.b localb = new ExdeviceAddDataSourceUI.b((byte)0);
    if (paramm.sAK.tmw == null) {}
    for (paramString = "";; paramString = aa.a(paramm.sAK.tmw))
    {
      localb.name = paramString;
      localb.mac = b.BV(paramm.sBd.sAE);
      localb.bJY = paramm.sAJ;
      localb.iconUrl = paramm.sBd.kSy;
      this.jAv.add(localb);
      y.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
      runOnUiThread(new ExdeviceAddDataSourceUI.8(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI
 * JD-Core Version:    0.7.0.1
 */