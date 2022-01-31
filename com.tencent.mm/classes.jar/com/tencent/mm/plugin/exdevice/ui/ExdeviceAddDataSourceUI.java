package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI
  extends MMActivity
  implements f, e.b
{
  private com.tencent.mm.ui.base.p ehb;
  private final BroadcastReceiver jQN;
  private ExdeviceAddDataSourceUI.a lJT;
  private List<ExdeviceAddDataSourceUI.b> lJU;
  private TextView lJV;
  private TextView lJW;
  private TextView lJX;
  private RelativeLayout lJY;
  private LocationManager lJZ;
  private boolean lKa;
  private l lKb;
  private View llk;
  private ListView mListView;
  
  public ExdeviceAddDataSourceUI()
  {
    AppMethodBeat.i(19798);
    this.lKa = false;
    this.jQN = new ExdeviceAddDataSourceUI.4(this);
    AppMethodBeat.o(19798);
  }
  
  private static boolean aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19806);
    ep localep = new ep();
    localep.csv.mac = paramString;
    localep.csv.cqR = paramBoolean;
    if (!com.tencent.mm.sdk.b.a.ymk.l(localep))
    {
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[] { paramString });
      AppMethodBeat.o(19806);
      return false;
    }
    AppMethodBeat.o(19806);
    return true;
  }
  
  private void bqF()
  {
    AppMethodBeat.i(19807);
    runOnUiThread(new ExdeviceAddDataSourceUI.2(this));
    AppMethodBeat.o(19807);
  }
  
  private void uY(int paramInt)
  {
    AppMethodBeat.i(19800);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19800);
      return;
      this.lJY.setVisibility(8);
      this.lJW.setText(2131299364);
      this.lJX.setText("");
      AppMethodBeat.o(19800);
      return;
      this.lJY.setVisibility(8);
      this.lJW.setText(2131299366);
      this.lJX.setText(2131299350);
      AppMethodBeat.o(19800);
      return;
      this.lJY.setVisibility(8);
      this.lJW.setText(2131299366);
      this.lJX.setText(2131299414);
      AppMethodBeat.o(19800);
      return;
      this.lJY.setVisibility(0);
      this.llk.setVisibility(0);
    }
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(19805);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
      AppMethodBeat.o(19805);
      return;
    }
    ExdeviceAddDataSourceUI.b localb = this.lJT.LN(paramString);
    if (localb == null)
    {
      ab.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[] { paramString });
      AppMethodBeat.o(19805);
      return;
    }
    if ((localb.lKj == ExdeviceAddDataSourceUI.c.lKl) && (paramInt == 4))
    {
      localb.lKj = ExdeviceAddDataSourceUI.c.lKk;
      bqF();
      runOnUiThread(new ExdeviceAddDataSourceUI.10(this, localb));
    }
    for (;;)
    {
      runOnUiThread(new ExdeviceAddDataSourceUI.11(this));
      AppMethodBeat.o(19805);
      return;
      if (paramInt == 2)
      {
        if (localb.lKj == ExdeviceAddDataSourceUI.c.lKl)
        {
          localb.lKj = ExdeviceAddDataSourceUI.c.lKm;
          ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
          if (localb.crs != null)
          {
            this.lKb = new l(localb.crs, 0);
            aw.Rc().a(this.lKb, 0);
          }
        }
        else
        {
          ab.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[] { paramString });
          aH(paramString, false);
        }
      }
      else
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          break;
        }
        localb.lKj = ExdeviceAddDataSourceUI.c.lKk;
      }
    }
    AppMethodBeat.o(19805);
  }
  
  public int getLayoutId()
  {
    return 2130969440;
  }
  
  public void initView()
  {
    AppMethodBeat.i(19801);
    this.mListView = ((ListView)findViewById(2131821736));
    View localView = View.inflate(this, 2130969442, null);
    this.lJY = ((RelativeLayout)findViewById(2131823745));
    this.llk = View.inflate(this, 2130969441, null);
    this.lJV = ((TextView)findViewById(2131823746));
    this.lJW = ((TextView)findViewById(2131823743));
    this.lJX = ((TextView)findViewById(2131823744));
    String str1 = getString(2131299466);
    String str2 = getString(2131299381);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ForegroundColorSpan(2131690214), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ExdeviceAddDataSourceUI.5(this), str1.length(), str1.length() + str2.length(), 33);
    this.lJV.setMovementMethod(LinkMovementMethod.getInstance());
    this.lJV.setText(localSpannableString);
    this.mListView.addHeaderView(localView, null, false);
    this.mListView.addFooterView(this.llk, null, false);
    this.lJT = new ExdeviceAddDataSourceUI.a();
    this.mListView.setAdapter(this.lJT);
    this.mListView.setOnItemClickListener(new ExdeviceAddDataSourceUI.6(this));
    AppMethodBeat.o(19801);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19799);
    super.onCreate(paramBundle);
    setBackBtn(new ExdeviceAddDataSourceUI.1(this));
    setMMTitle(2131299339);
    if ((d.fv(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
      this.lKa = true;
    }
    this.lJU = new LinkedList();
    this.lJZ = ((LocationManager)getContext().getSystemService("location"));
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramBundle.addAction("android.location.MODE_CHANGED");
    getContext().registerReceiver(this.jQN, paramBundle);
    aw.Rc().a(536, this);
    aw.Rc().a(1706, this);
    ad.bqj().a(this);
    if (!com.tencent.mm.plugin.d.a.e.a.dA(getContext()))
    {
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      uY(2);
      AppMethodBeat.o(19799);
      return;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.aWe())
    {
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
      uY(1);
      AppMethodBeat.o(19799);
      return;
    }
    if ((this.lJZ != null) && (this.lKa) && (!this.lJZ.isProviderEnabled("gps")))
    {
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
      uY(4);
      AppMethodBeat.o(19799);
      return;
    }
    ad.bqj();
    e.bpM();
    AppMethodBeat.o(19799);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(19802);
    super.onDestroy();
    aw.RO().ac(new ExdeviceAddDataSourceUI.7(this));
    aw.Rc().b(536, this);
    aw.Rc().b(1706, this);
    getContext().unregisterReceiver(this.jQN);
    ad.bqj().b(this);
    ad.bqk().stopScan();
    AppMethodBeat.o(19802);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19803);
    ab.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      ab.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
      AppMethodBeat.o(19803);
      return;
    }
    if (paramm.getType() == 536)
    {
      bqF();
      this.lKb = null;
      paramString = ((l)paramm).bpR();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = this.lJT.LN(b.LY(paramString.wvx.wuT));
        if (paramString != null)
        {
          paramString.lKj = ExdeviceAddDataSourceUI.c.lKk;
          aH(paramString.mac, false);
        }
        ab.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        AppMethodBeat.o(19803);
        return;
      }
      paramm = new Intent();
      paramm.putExtra("device_mac", b.LX(b.LY(paramString.wvx.wuT)));
      aH(b.LY(paramString.wvx.wuT), false);
      setResult(-1, paramm);
      finish();
      AppMethodBeat.o(19803);
      return;
    }
    ExdeviceAddDataSourceUI.b localb;
    if (paramm.getType() == 1706)
    {
      paramm = ((t)paramm).bpU();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(19803);
        return;
      }
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[] { Long.valueOf(paramm.wvx.dCO) });
      if (0L != (paramm.wvx.dCO & 1L))
      {
        if (ad.bpY().dU(paramm.wvw.jJD, paramm.wvw.wsq) != null)
        {
          ab.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[] { paramm.wvx.wuT });
          AppMethodBeat.o(19803);
          return;
        }
        localb = new ExdeviceAddDataSourceUI.b((byte)0);
        if (paramm.wuZ.xmi != null) {
          break label500;
        }
      }
    }
    label500:
    for (paramString = "";; paramString = aa.a(paramm.wuZ.xmi))
    {
      localb.name = paramString;
      localb.mac = b.LY(paramm.wvx.wuT);
      localb.crs = paramm.wuY;
      localb.iconUrl = paramm.wvx.IconUrl;
      this.lJU.add(localb);
      ab.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
      runOnUiThread(new ExdeviceAddDataSourceUI.8(this));
      AppMethodBeat.o(19803);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(19804);
    ab.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      runOnUiThread(new ExdeviceAddDataSourceUI.9(this));
    }
    if (bo.isNullOrNil(paramString2))
    {
      ab.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(19804);
      return;
    }
    int i = 0;
    if (i < this.lJU.size())
    {
      paramString1 = (ExdeviceAddDataSourceUI.b)this.lJU.get(i);
      if ((paramString1 == null) || (bo.isNullOrNil(paramString1.mac)))
      {
        paramString1 = this.lJU;
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
        ab.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[] { paramString2 });
        AppMethodBeat.o(19804);
        return;
        ab.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[] { Boolean.valueOf(aw.Rc().a(new t(paramString2.replaceAll(":", ""), null, null), 0)), paramString2 });
        AppMethodBeat.o(19804);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI
 * JD-Core Version:    0.7.0.1
 */