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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI
  extends MMActivity
  implements g, e.b
{
  private p fxw;
  private ListView mListView;
  private final BroadcastReceiver mReceiver;
  private a pDO;
  private List<b> pDP;
  private TextView pDQ;
  private TextView pDR;
  private TextView pDS;
  private RelativeLayout pDT;
  private LocationManager pDU;
  private boolean pDV;
  private l pDW;
  private View pfa;
  
  public ExdeviceAddDataSourceUI()
  {
    AppMethodBeat.i(23866);
    this.pDV = false;
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(23845);
        if (paramAnonymousIntent == null)
        {
          ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
          AppMethodBeat.o(23845);
          return;
        }
        paramAnonymousContext = paramAnonymousIntent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramAnonymousContext))
        {
          if (paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) != 12) {
            break label175;
          }
          if (com.tencent.mm.plugin.d.a.e.a.bIE())
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
                ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                AppMethodBeat.o(23841);
              }
            });
            if ((!ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) || (ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).isProviderEnabled("gps")))
            {
              ad.cha();
              e.cgC();
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
                if (com.tencent.mm.plugin.d.a.e.a.bIE())
                {
                  ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 3);
                  ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                  AppMethodBeat.o(23843);
                  return;
                }
                ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                AppMethodBeat.o(23843);
              }
            });
            if (com.tencent.mm.plugin.d.a.e.a.bIE())
            {
              ad.cha();
              e.cgC();
              AppMethodBeat.o(23845);
              return;
              label175:
              if ((paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) == 10) && (!com.tencent.mm.plugin.d.a.e.a.bIE()))
              {
                ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(23842);
                    ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, 1);
                    ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                    AppMethodBeat.o(23842);
                  }
                });
                ad.chb().stopScan();
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
                ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                AppMethodBeat.o(23844);
              }
            });
            ad.chb().stopScan();
          }
        }
        AppMethodBeat.o(23845);
      }
    };
    AppMethodBeat.o(23866);
  }
  
  private void BU(int paramInt)
  {
    AppMethodBeat.i(23868);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23868);
      return;
      this.pDT.setVisibility(8);
      this.pDR.setText(2131758492);
      this.pDS.setText("");
      AppMethodBeat.o(23868);
      return;
      this.pDT.setVisibility(8);
      this.pDR.setText(2131758494);
      this.pDS.setText(2131758478);
      AppMethodBeat.o(23868);
      return;
      this.pDT.setVisibility(8);
      this.pDR.setText(2131758494);
      this.pDS.setText(2131758542);
      AppMethodBeat.o(23868);
      return;
      this.pDT.setVisibility(0);
      this.pfa.setVisibility(0);
    }
  }
  
  private static boolean aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23874);
    ew localew = new ew();
    localew.deM.mac = paramString;
    localew.deM.ddi = paramBoolean;
    if (!com.tencent.mm.sdk.b.a.GpY.l(localew))
    {
      ac.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[] { paramString });
      AppMethodBeat.o(23874);
      return false;
    }
    AppMethodBeat.o(23874);
    return true;
  }
  
  private void chw()
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
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
      AppMethodBeat.o(23873);
      return;
    }
    final b localb = this.pDO.Zi(paramString);
    if (localb == null)
    {
      ac.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[] { paramString });
      AppMethodBeat.o(23873);
      return;
    }
    if ((localb.pEe == ExdeviceAddDataSourceUI.c.pEg) && (paramInt == 4))
    {
      localb.pEe = ExdeviceAddDataSourceUI.c.pEf;
      chw();
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
              ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this).remove(ExdeviceAddDataSourceUI.10.this.pEb);
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).U(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
              AppMethodBeat.o(23852);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23853);
              f.ao(ExdeviceAddDataSourceUI.this.getContext(), "https://hw.weixin.qq.com/steprank/step/connect-help.html");
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
        if (localb.pEe == ExdeviceAddDataSourceUI.c.pEg)
        {
          localb.pEe = ExdeviceAddDataSourceUI.c.pEh;
          ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
          if (localb.ddJ != null)
          {
            this.pDW = new l(localb.ddJ, 0);
            az.agi().a(this.pDW, 0);
          }
        }
        else
        {
          ac.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[] { paramString });
          aQ(paramString, false);
        }
      }
      else
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          break;
        }
        localb.pEe = ExdeviceAddDataSourceUI.c.pEf;
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
    this.pDT = ((RelativeLayout)findViewById(2131304387));
    this.pfa = View.inflate(this, 2131493853, null);
    this.pDQ = ((TextView)findViewById(2131304300));
    this.pDR = ((TextView)findViewById(2131299511));
    this.pDS = ((TextView)findViewById(2131299512));
    String str1 = getString(2131758597);
    String str2 = getString(2131758509);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ForegroundColorSpan(2131100547), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23846);
        f.ao(ExdeviceAddDataSourceUI.this.getContext(), "https://hw.weixin.qq.com/steprank/step/connect-help.html");
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
    this.pDQ.setMovementMethod(LinkMovementMethod.getInstance());
    this.pDQ.setText(localSpannableString);
    this.mListView.addHeaderView(localView, null, false);
    this.mListView.addFooterView(this.pfa, null, false);
    this.pDO = new a();
    this.mListView.setAdapter(this.pDO);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23848);
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).BV(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.pEe != ExdeviceAddDataSourceUI.c.pEf)
        {
          AppMethodBeat.o(23848);
          return;
        }
        if (!ExdeviceAddDataSourceUI.Zh(paramAnonymousAdapterView.mac))
        {
          ac.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
          AppMethodBeat.o(23848);
          return;
        }
        ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, paramAnonymousAdapterView.mac);
        paramAnonymousAdapterView.pEe = ExdeviceAddDataSourceUI.c.pEg;
        ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
        AppMethodBeat.o(23848);
      }
    });
    AppMethodBeat.o(23869);
  }
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23872);
    ac.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
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
    if (bs.isNullOrNil(paramString2))
    {
      ac.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23872);
      return;
    }
    int i = 0;
    if (i < this.pDP.size())
    {
      paramString1 = (b)this.pDP.get(i);
      if ((paramString1 == null) || (bs.isNullOrNil(paramString1.mac)))
      {
        paramString1 = this.pDP;
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
        ac.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[] { paramString2 });
        AppMethodBeat.o(23872);
        return;
        ac.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[] { Boolean.valueOf(az.agi().a(new t(paramString2.replaceAll(":", ""), null, null), 0)), paramString2 });
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
    if ((d.kZ(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
      this.pDV = true;
    }
    this.pDP = new LinkedList();
    this.pDU = ((LocationManager)getContext().getSystemService("location"));
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramBundle.addAction("android.location.MODE_CHANGED");
    getContext().registerReceiver(this.mReceiver, paramBundle);
    az.agi().a(536, this);
    az.agi().a(1706, this);
    ad.cha().a(this);
    if (!com.tencent.mm.plugin.d.a.e.a.ep(getContext()))
    {
      ac.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      BU(2);
      AppMethodBeat.o(23867);
      return;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.bIE())
    {
      ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
      BU(1);
      AppMethodBeat.o(23867);
      return;
    }
    if ((this.pDU != null) && (this.pDV) && (!this.pDU.isProviderEnabled("gps")))
    {
      ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
      BU(4);
      AppMethodBeat.o(23867);
      return;
    }
    try
    {
      ad.cha();
      e.cgC();
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
    az.agU().az(new ExdeviceAddDataSourceUI.7(this));
    az.agi().b(536, this);
    az.agi().b(1706, this);
    getContext().unregisterReceiver(this.mReceiver);
    ad.cha().b(this);
    ad.chb().stopScan();
    AppMethodBeat.o(23870);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23871);
    ac.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ac.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
      AppMethodBeat.o(23871);
      return;
    }
    if (paramn.getType() == 536)
    {
      chw();
      this.pDW = null;
      paramString = ((l)paramn).cgI();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = this.pDO.Zi(b.Zt(paramString.DYc.DXq));
        if (paramString != null)
        {
          paramString.pEe = ExdeviceAddDataSourceUI.c.pEf;
          aQ(paramString.mac, false);
        }
        ac.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        AppMethodBeat.o(23871);
        return;
      }
      paramn = new Intent();
      paramn.putExtra("device_mac", b.Zs(b.Zt(paramString.DYc.DXq)));
      aQ(b.Zt(paramString.DYc.DXq), false);
      setResult(-1, paramn);
      finish();
      AppMethodBeat.o(23871);
      return;
    }
    b localb;
    if (paramn.getType() == 1706)
    {
      paramn = ((t)paramn).cgL();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(23871);
        return;
      }
      ac.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[] { Long.valueOf(paramn.DYc.eNk) });
      if (0L != (paramn.DYc.eNk & 1L))
      {
        if (ad.cgP().fu(paramn.DYb.ncU, paramn.DYb.DUp) != null)
        {
          ac.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[] { paramn.DYc.DXq });
          AppMethodBeat.o(23871);
          return;
        }
        localb = new b((byte)0);
        if (paramn.DXw.Fbd != null) {
          break label500;
        }
      }
    }
    label500:
    for (paramString = "";; paramString = z.a(paramn.DXw.Fbd))
    {
      localb.name = paramString;
      localb.mac = b.Zt(paramn.DYc.DXq);
      localb.ddJ = paramn.DXv;
      localb.iconUrl = paramn.DYc.IconUrl;
      this.pDP.add(localb);
      ac.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23850);
          ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).U(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
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
  
  static final class a
    extends BaseAdapter
  {
    private List<ExdeviceAddDataSourceUI.b> pDP;
    private com.tencent.mm.av.a.a.c pEd;
    
    public a()
    {
      AppMethodBeat.i(23856);
      this.pDP = new LinkedList();
      c.a locala = new c.a();
      locala.hKI = 2131232115;
      this.pEd = locala.aFT();
      AppMethodBeat.o(23856);
    }
    
    public final ExdeviceAddDataSourceUI.b BV(int paramInt)
    {
      AppMethodBeat.i(23860);
      ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)this.pDP.get(paramInt);
      AppMethodBeat.o(23860);
      return localb;
    }
    
    public final void U(List<ExdeviceAddDataSourceUI.b> paramList)
    {
      AppMethodBeat.i(23857);
      this.pDP.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(23857);
        return;
      }
      this.pDP.addAll(paramList);
      AppMethodBeat.o(23857);
    }
    
    public final ExdeviceAddDataSourceUI.b Zi(String paramString)
    {
      AppMethodBeat.i(23858);
      if (!bs.isNullOrNil(paramString))
      {
        Iterator localIterator = this.pDP.iterator();
        while (localIterator.hasNext())
        {
          ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)localIterator.next();
          if (paramString.equalsIgnoreCase(localb.mac))
          {
            AppMethodBeat.o(23858);
            return localb;
          }
        }
      }
      AppMethodBeat.o(23858);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(23859);
      int i = this.pDP.size();
      AppMethodBeat.o(23859);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(23861);
      ExdeviceAddDataSourceUI.b localb = BV(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131493851, null);
        paramView.lzC = ((ImageView)localView.findViewById(2131300880));
        paramView.iMz = ((TextView)localView.findViewById(2131302656));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        ac.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
        paramViewGroup.iMz.setText(localb.name);
        o.aFB().a(localb.iconUrl, paramViewGroup.lzC, this.pEd);
        AppMethodBeat.o(23861);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    
    static final class a
    {
      TextView iMz;
      ImageView lzC;
    }
  }
  
  static final class b
  {
    String ddJ;
    public String iconUrl;
    String mac;
    String name;
    ExdeviceAddDataSourceUI.c pEe = ExdeviceAddDataSourceUI.c.pEf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI
 * JD-Core Version:    0.7.0.1
 */