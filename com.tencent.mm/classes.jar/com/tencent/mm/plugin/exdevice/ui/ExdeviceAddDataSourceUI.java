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
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI
  extends MMActivity
  implements i, e.b
{
  private com.tencent.mm.ui.base.q gxX;
  private ListView mListView;
  private final BroadcastReceiver mReceiver;
  private ExdeviceAddDataSourceUI.a rFf;
  private List<b> rFg;
  private TextView rFh;
  private TextView rFi;
  private TextView rFj;
  private RelativeLayout rFk;
  private LocationManager rFl;
  private boolean rFm;
  private l rFn;
  private View rfF;
  
  public ExdeviceAddDataSourceUI()
  {
    AppMethodBeat.i(23866);
    this.rFm = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(23845);
        if (paramAnonymousIntent == null)
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
          AppMethodBeat.o(23845);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramAnonymousContext))
        {
          if (paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) != 12) {
            break label175;
          }
          if (com.tencent.mm.plugin.d.a.e.a.ckP())
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
                Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                AppMethodBeat.o(23841);
              }
            });
            if ((!ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) || (ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).isProviderEnabled("gps")))
            {
              ad.cKW();
              e.cKy();
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
                if (com.tencent.mm.plugin.d.a.e.a.ckP())
                {
                  ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                  Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                  AppMethodBeat.o(23843);
                  return;
                }
                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                AppMethodBeat.o(23843);
              }
            });
            if (com.tencent.mm.plugin.d.a.e.a.ckP())
            {
              ad.cKW();
              e.cKy();
              AppMethodBeat.o(23845);
              return;
              label175:
              if ((paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) == 10) && (!com.tencent.mm.plugin.d.a.e.a.ckP()))
              {
                ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(23842);
                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                    Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                    AppMethodBeat.o(23842);
                  }
                });
                ad.cKX().stopScan();
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
                Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                AppMethodBeat.o(23844);
              }
            });
            ad.cKX().stopScan();
          }
        }
        AppMethodBeat.o(23845);
      }
    };
    AppMethodBeat.o(23866);
  }
  
  private void GA(int paramInt)
  {
    AppMethodBeat.i(23868);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23868);
      return;
      this.rFk.setVisibility(8);
      this.rFi.setText(2131758791);
      this.rFj.setText("");
      AppMethodBeat.o(23868);
      return;
      this.rFk.setVisibility(8);
      this.rFi.setText(2131758793);
      this.rFj.setText(2131758777);
      AppMethodBeat.o(23868);
      return;
      this.rFk.setVisibility(8);
      this.rFi.setText(2131758793);
      this.rFj.setText(2131758841);
      AppMethodBeat.o(23868);
      return;
      this.rFk.setVisibility(0);
      this.rfF.setVisibility(0);
    }
  }
  
  private static boolean aW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23874);
    fd localfd = new fd();
    localfd.dIz.mac = paramString;
    localfd.dIz.dGW = paramBoolean;
    if (!EventCenter.instance.publish(localfd))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[] { paramString });
      AppMethodBeat.o(23874);
      return false;
    }
    AppMethodBeat.o(23874);
    return true;
  }
  
  private void cLD()
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
  
  public final void c(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(23873);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
      AppMethodBeat.o(23873);
      return;
    }
    final b localb = this.rFf.anO(paramString);
    if (localb == null)
    {
      Log.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[] { paramString });
      AppMethodBeat.o(23873);
      return;
    }
    if ((localb.rFv == c.rFx) && (paramInt == 4))
    {
      localb.rFv = c.rFw;
      cLD();
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23854);
          com.tencent.mm.ui.base.h.a(ExdeviceAddDataSourceUI.this, 2131758811, 2131758809, 2131758810, 2131758812, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23852);
              ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this).remove(ExdeviceAddDataSourceUI.10.this.rFs);
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).ad(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
              AppMethodBeat.o(23852);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23853);
              f.ay(ExdeviceAddDataSourceUI.this.getContext(), "https://" + WeChatHosts.domainString(2131761711) + "/steprank/step/connect-help.html");
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
        if (localb.rFv == c.rFx)
        {
          localb.rFv = c.rFy;
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
          if (localb.dHx != null)
          {
            this.rFn = new l(localb.dHx, 0);
            bg.azz().a(this.rFn, 0);
          }
        }
        else
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[] { paramString });
          aW(paramString, false);
        }
      }
      else
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          break;
        }
        localb.rFv = c.rFw;
      }
    }
    AppMethodBeat.o(23873);
  }
  
  public int getLayoutId()
  {
    return 2131494007;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23869);
    this.mListView = ((ListView)findViewById(2131303242));
    View localView = View.inflate(this, 2131494009, null);
    this.rFk = ((RelativeLayout)findViewById(2131307352));
    this.rfF = View.inflate(this, 2131494008, null);
    this.rFh = ((TextView)findViewById(2131307228));
    this.rFi = ((TextView)findViewById(2131300148));
    this.rFj = ((TextView)findViewById(2131300149));
    String str1 = getString(2131758898);
    String str2 = getString(2131758808);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ForegroundColorSpan(2131100685), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23846);
        f.ay(ExdeviceAddDataSourceUI.this.getContext(), "https://" + WeChatHosts.domainString(2131761711) + "/steprank/step/connect-help.html");
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
    this.rFh.setMovementMethod(LinkMovementMethod.getInstance());
    this.rFh.setText(localSpannableString);
    this.mListView.addHeaderView(localView, null, false);
    this.mListView.addFooterView(this.rfF, null, false);
    this.rFf = new ExdeviceAddDataSourceUI.a();
    this.mListView.setAdapter(this.rFf);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23848);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).GB(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.rFv != ExdeviceAddDataSourceUI.c.rFw)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        if (!ExdeviceAddDataSourceUI.anN(paramAnonymousAdapterView.mac))
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, paramAnonymousAdapterView.mac);
        paramAnonymousAdapterView.rFv = ExdeviceAddDataSourceUI.c.rFx;
        ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(23848);
      }
    });
    AppMethodBeat.o(23869);
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
    setMMTitle(2131758766);
    if ((d.oD(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
      this.rFm = true;
    }
    this.rFg = new LinkedList();
    this.rFl = ((LocationManager)getContext().getSystemService("location"));
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramBundle.addAction("android.location.MODE_CHANGED");
    getContext().registerReceiver(this.mReceiver, paramBundle);
    bg.azz().a(536, this);
    bg.azz().a(1706, this);
    ad.cKW().a(this);
    if (!com.tencent.mm.plugin.d.a.e.a.eL(getContext()))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      GA(2);
      AppMethodBeat.o(23867);
      return;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.ckP())
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
      GA(1);
      AppMethodBeat.o(23867);
      return;
    }
    if ((this.rFl != null) && (this.rFm) && (!this.rFl.isProviderEnabled("gps")))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
      GA(4);
      AppMethodBeat.o(23867);
      return;
    }
    try
    {
      ad.cKW();
      e.cKy();
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
    bg.aAk().postToWorker(new ExdeviceAddDataSourceUI.7(this));
    bg.azz().b(536, this);
    bg.azz().b(1706, this);
    getContext().unregisterReceiver(this.mReceiver);
    ad.cKW().b(this);
    ad.cKX().stopScan();
    AppMethodBeat.o(23870);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(23871);
    Log.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq == null)
    {
      Log.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
      AppMethodBeat.o(23871);
      return;
    }
    if (paramq.getType() == 536)
    {
      cLD();
      this.rFn = null;
      paramString = ((l)paramq).cKE();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = this.rFf.anO(com.tencent.mm.plugin.exdevice.k.b.anZ(paramString.KPE.KOS));
        if (paramString != null)
        {
          paramString.rFv = c.rFw;
          aW(paramString.mac, false);
        }
        Log.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        AppMethodBeat.o(23871);
        return;
      }
      paramq = new Intent();
      paramq.putExtra("device_mac", com.tencent.mm.plugin.exdevice.k.b.anY(com.tencent.mm.plugin.exdevice.k.b.anZ(paramString.KPE.KOS)));
      aW(com.tencent.mm.plugin.exdevice.k.b.anZ(paramString.KPE.KOS), false);
      setResult(-1, paramq);
      finish();
      AppMethodBeat.o(23871);
      return;
    }
    b localb;
    if (paramq.getType() == 1706)
    {
      paramq = ((com.tencent.mm.plugin.exdevice.model.t)paramq).cKH();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(23871);
        return;
      }
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[] { Long.valueOf(paramq.KPE.fMg) });
      if (0L != (paramq.KPE.fMg & 1L))
      {
        if (ad.cKL().gb(paramq.KPD.oTH, paramq.KPD.KLO) != null)
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[] { paramq.KPE.KOS });
          AppMethodBeat.o(23871);
          return;
        }
        localb = new b((byte)0);
        if (paramq.KOY.Mjj != null) {
          break label500;
        }
      }
    }
    label500:
    for (paramString = "";; paramString = z.a(paramq.KOY.Mjj))
    {
      localb.name = paramString;
      localb.mac = com.tencent.mm.plugin.exdevice.k.b.anZ(paramq.KPE.KOS);
      localb.dHx = paramq.KOX;
      localb.iconUrl = paramq.KPE.IconUrl;
      this.rFg.add(localb);
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23850);
          ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).ad(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
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
  
  public final void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23872);
    Log.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
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
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23872);
      return;
    }
    int i = 0;
    if (i < this.rFg.size())
    {
      paramString1 = (b)this.rFg.get(i);
      if ((paramString1 == null) || (Util.isNullOrNil(paramString1.mac)))
      {
        paramString1 = this.rFg;
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
        Log.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[] { paramString2 });
        AppMethodBeat.o(23872);
        return;
        Log.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[] { Boolean.valueOf(bg.azz().a(new com.tencent.mm.plugin.exdevice.model.t(paramString2.replaceAll(":", ""), null, null), 0)), paramString2 });
        AppMethodBeat.o(23872);
        return;
      }
    }
  }
  
  static final class b
  {
    String dHx;
    public String iconUrl;
    String mac;
    String name;
    ExdeviceAddDataSourceUI.c rFv = ExdeviceAddDataSourceUI.c.rFw;
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(23865);
      rFw = new c("NORMAL", 0);
      rFx = new c("ADDING", 1);
      rFy = new c("ADDED", 2);
      rFz = new c[] { rFw, rFx, rFy };
      AppMethodBeat.o(23865);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI
 * JD-Core Version:    0.7.0.1
 */