package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI
  extends MMActivity
  implements com.tencent.mm.ak.f, e.b
{
  private p fSP;
  private ListView mListView;
  private final BroadcastReceiver mReceiver;
  private View pPh;
  private ExdeviceAddDataSourceUI.a qnY;
  private List<b> qnZ;
  private TextView qoa;
  private TextView qob;
  private TextView qoc;
  private RelativeLayout qod;
  private LocationManager qoe;
  private boolean qof;
  private l qog;
  
  public ExdeviceAddDataSourceUI()
  {
    AppMethodBeat.i(23866);
    this.qof = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(23845);
        if (paramAnonymousIntent == null)
        {
          ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
          AppMethodBeat.o(23845);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramAnonymousContext))
        {
          if (paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) != 12) {
            break label175;
          }
          if (com.tencent.mm.plugin.d.a.e.a.bNP())
          {
            ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23841);
                if ((ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) && (!ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).isProviderEnabled("gps")))
                {
                  ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 4);
                  AppMethodBeat.o(23841);
                  return;
                }
                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                AppMethodBeat.o(23841);
              }
            });
            if ((!ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) || (ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).isProviderEnabled("gps")))
            {
              ad.cmU();
              e.cmw();
            }
          }
        }
        while ((ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) && ("android.location.MODE_CHANGED".equals(paramAnonymousContext))) {
          if (ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).isProviderEnabled("gps"))
          {
            ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23843);
                if (com.tencent.mm.plugin.d.a.e.a.bNP())
                {
                  ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                  ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                  AppMethodBeat.o(23843);
                  return;
                }
                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                AppMethodBeat.o(23843);
              }
            });
            if (com.tencent.mm.plugin.d.a.e.a.bNP())
            {
              ad.cmU();
              e.cmw();
              AppMethodBeat.o(23845);
              return;
              label175:
              if ((paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) == 10) && (!com.tencent.mm.plugin.d.a.e.a.bNP()))
              {
                ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(23842);
                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                    ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                    AppMethodBeat.o(23842);
                  }
                });
                ad.cmV().stopScan();
              }
            }
          }
          else
          {
            ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23844);
                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 4);
                ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                AppMethodBeat.o(23844);
              }
            });
            ad.cmV().stopScan();
          }
        }
        AppMethodBeat.o(23845);
      }
    };
    AppMethodBeat.o(23866);
  }
  
  private void CP(int paramInt)
  {
    AppMethodBeat.i(23868);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23868);
      return;
      this.qod.setVisibility(8);
      this.qob.setText(2131758492);
      this.qoc.setText("");
      AppMethodBeat.o(23868);
      return;
      this.qod.setVisibility(8);
      this.qob.setText(2131758494);
      this.qoc.setText(2131758478);
      AppMethodBeat.o(23868);
      return;
      this.qod.setVisibility(8);
      this.qob.setText(2131758494);
      this.qoc.setText(2131758542);
      AppMethodBeat.o(23868);
      return;
      this.qod.setVisibility(0);
      this.pPh.setVisibility(0);
    }
  }
  
  private static boolean aU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23874);
    fa localfa = new fa();
    localfa.drn.mac = paramString;
    localfa.drn.dpJ = paramBoolean;
    if (!com.tencent.mm.sdk.b.a.IvT.l(localfa))
    {
      ae.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[] { paramString });
      AppMethodBeat.o(23874);
      return false;
    }
    AppMethodBeat.o(23874);
    return true;
  }
  
  private void cnq()
  {
    AppMethodBeat.i(23875);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23838);
        if ((ExdeviceAddDataSourceUI.f(ExdeviceAddDataSourceUI.this) != null) && (ExdeviceAddDataSourceUI.f(ExdeviceAddDataSourceUI.this).isShowing())) {
          ExdeviceAddDataSourceUI.f(ExdeviceAddDataSourceUI.this).dismiss();
        }
        AppMethodBeat.o(23838);
      }
    });
    AppMethodBeat.o(23875);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void d(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23873);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
      AppMethodBeat.o(23873);
      return;
    }
    final b localb = this.qnY.adF(paramString);
    if (localb == null)
    {
      ae.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[] { paramString });
      AppMethodBeat.o(23873);
      return;
    }
    if ((localb.qoo == ExdeviceAddDataSourceUI.c.qoq) && (paramInt == 4))
    {
      localb.qoo = ExdeviceAddDataSourceUI.c.qop;
      cnq();
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23854);
          com.tencent.mm.ui.base.h.a(ExdeviceAddDataSourceUI.this, 2131758512, 2131758510, 2131758511, 2131758513, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23852);
              ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this).remove(ExdeviceAddDataSourceUI.10.this.qol);
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).V(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
              AppMethodBeat.o(23852);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23853);
              com.tencent.mm.plugin.exdevice.model.f.ap(ExdeviceAddDataSourceUI.this.getContext(), "https://hw.weixin.qq.com/steprank/step/connect-help.html");
              AppMethodBeat.o(23853);
            }
          }).show();
          AppMethodBeat.o(23854);
        }
      });
    }
    for (;;)
    {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23855);
          ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
          AppMethodBeat.o(23855);
        }
      });
      AppMethodBeat.o(23873);
      return;
      if (paramInt == 2)
      {
        if (localb.qoo == ExdeviceAddDataSourceUI.c.qoq)
        {
          localb.qoo = ExdeviceAddDataSourceUI.c.qor;
          ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
          if (localb.dqk != null)
          {
            this.qog = new l(localb.dqk, 0);
            bc.ajj().a(this.qog, 0);
          }
        }
        else
        {
          ae.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[] { paramString });
          aU(paramString, false);
        }
      }
      else
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          break;
        }
        localb.qoo = ExdeviceAddDataSourceUI.c.qop;
      }
    }
    AppMethodBeat.o(23873);
  }
  
  public int getLayoutId()
  {
    return 2131493852;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23869);
    this.mListView = ((ListView)findViewById(2131301457));
    View localView = View.inflate(this, 2131493854, null);
    this.qod = ((RelativeLayout)findViewById(2131304387));
    this.pPh = View.inflate(this, 2131493853, null);
    this.qoa = ((TextView)findViewById(2131304300));
    this.qob = ((TextView)findViewById(2131299511));
    this.qoc = ((TextView)findViewById(2131299512));
    String str1 = getString(2131758597);
    String str2 = getString(2131758509);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ForegroundColorSpan(2131100547), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23846);
        com.tencent.mm.plugin.exdevice.model.f.ap(ExdeviceAddDataSourceUI.this.getContext(), "https://hw.weixin.qq.com/steprank/step/connect-help.html");
        AppMethodBeat.o(23846);
      }
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        AppMethodBeat.i(23847);
        paramAnonymousTextPaint.setColor(paramAnonymousTextPaint.linkColor);
        paramAnonymousTextPaint.setUnderlineText(false);
        AppMethodBeat.o(23847);
      }
    }, str1.length(), str1.length() + str2.length(), 33);
    this.qoa.setMovementMethod(LinkMovementMethod.getInstance());
    this.qoa.setText(localSpannableString);
    this.mListView.addHeaderView(localView, null, false);
    this.mListView.addFooterView(this.pPh, null, false);
    this.qnY = new ExdeviceAddDataSourceUI.a();
    this.mListView.setAdapter(this.qnY);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23848);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).CQ(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.qoo != ExdeviceAddDataSourceUI.c.qop)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        if (!ExdeviceAddDataSourceUI.adE(paramAnonymousAdapterView.mac))
        {
          ae.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, paramAnonymousAdapterView.mac);
        paramAnonymousAdapterView.qoo = ExdeviceAddDataSourceUI.c.qoq;
        ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(23848);
      }
    });
    AppMethodBeat.o(23869);
  }
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23872);
    ae.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23851);
          ExdeviceAddDataSourceUI.e(ExdeviceAddDataSourceUI.this).setVisibility(8);
          ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
          AppMethodBeat.o(23851);
        }
      });
    }
    if (bu.isNullOrNil(paramString2))
    {
      ae.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23872);
      return;
    }
    int i = 0;
    if (i < this.qnZ.size())
    {
      paramString1 = (b)this.qnZ.get(i);
      if ((paramString1 == null) || (bu.isNullOrNil(paramString1.mac)))
      {
        paramString1 = this.qnZ;
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
        ae.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[] { paramString2 });
        AppMethodBeat.o(23872);
        return;
        ae.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[] { Boolean.valueOf(bc.ajj().a(new t(paramString2.replaceAll(":", ""), null, null), 0)), paramString2 });
        AppMethodBeat.o(23872);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23867);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(23837);
        ExdeviceAddDataSourceUI.this.finish();
        AppMethodBeat.o(23837);
        return true;
      }
    });
    setMMTitle(2131758467);
    if ((d.lA(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
      this.qof = true;
    }
    this.qnZ = new LinkedList();
    this.qoe = ((LocationManager)getContext().getSystemService("location"));
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramBundle.addAction("android.location.MODE_CHANGED");
    getContext().registerReceiver(this.mReceiver, paramBundle);
    bc.ajj().a(536, this);
    bc.ajj().a(1706, this);
    ad.cmU().a(this);
    if (!com.tencent.mm.plugin.d.a.e.a.et(getContext()))
    {
      ae.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      CP(2);
      AppMethodBeat.o(23867);
      return;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.bNP())
    {
      ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
      CP(1);
      AppMethodBeat.o(23867);
      return;
    }
    if ((this.qoe != null) && (this.qof) && (!this.qoe.isProviderEnabled("gps")))
    {
      ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
      CP(4);
      AppMethodBeat.o(23867);
      return;
    }
    try
    {
      ad.cmU();
      e.cmw();
      AppMethodBeat.o(23867);
      return;
    }
    catch (Exception paramBundle)
    {
      AppMethodBeat.o(23867);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23870);
    super.onDestroy();
    bc.ajU().aw(new ExdeviceAddDataSourceUI.7(this));
    bc.ajj().b(536, this);
    bc.ajj().b(1706, this);
    getContext().unregisterReceiver(this.mReceiver);
    ad.cmU().b(this);
    ad.cmV().stopScan();
    AppMethodBeat.o(23870);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23871);
    ae.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ae.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
      AppMethodBeat.o(23871);
      return;
    }
    if (paramn.getType() == 536)
    {
      cnq();
      this.qog = null;
      paramString = ((l)paramn).cmC();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = this.qnY.adF(com.tencent.mm.plugin.exdevice.k.b.adQ(paramString.FVT.FVh));
        if (paramString != null)
        {
          paramString.qoo = ExdeviceAddDataSourceUI.c.qop;
          aU(paramString.mac, false);
        }
        ae.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        AppMethodBeat.o(23871);
        return;
      }
      paramn = new Intent();
      paramn.putExtra("device_mac", com.tencent.mm.plugin.exdevice.k.b.adP(com.tencent.mm.plugin.exdevice.k.b.adQ(paramString.FVT.FVh)));
      aU(com.tencent.mm.plugin.exdevice.k.b.adQ(paramString.FVT.FVh), false);
      setResult(-1, paramn);
      finish();
      AppMethodBeat.o(23871);
      return;
    }
    b localb;
    if (paramn.getType() == 1706)
    {
      paramn = ((t)paramn).cmF();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(23871);
        return;
      }
      ae.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[] { Long.valueOf(paramn.FVT.fhD) });
      if (0L != (paramn.FVT.fhD & 1L))
      {
        if (ad.cmJ().fI(paramn.FVS.nIM, paramn.FVS.FSh) != null)
        {
          ae.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[] { paramn.FVT.FVh });
          AppMethodBeat.o(23871);
          return;
        }
        localb = new b((byte)0);
        if (paramn.FVn.Hed != null) {
          break label500;
        }
      }
    }
    label500:
    for (paramString = "";; paramString = z.a(paramn.FVn.Hed))
    {
      localb.name = paramString;
      localb.mac = com.tencent.mm.plugin.exdevice.k.b.adQ(paramn.FVT.FVh);
      localb.dqk = paramn.FVm;
      localb.iconUrl = paramn.FVT.IconUrl;
      this.qnZ.add(localb);
      ae.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23850);
          ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).V(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
          ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
          AppMethodBeat.o(23850);
        }
      });
      AppMethodBeat.o(23871);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class b
  {
    String dqk;
    public String iconUrl;
    String mac;
    String name;
    ExdeviceAddDataSourceUI.c qoo = ExdeviceAddDataSourceUI.c.qop;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI
 * JD-Core Version:    0.7.0.1
 */