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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.fk;
import com.tencent.mm.f.a.yg;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.u;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI
  extends MMActivity
  implements i, e.b
{
  private s jhZ;
  private ListView mListView;
  private final BroadcastReceiver mReceiver;
  private View uIP;
  private a vkP;
  private List<b> vkQ;
  private TextView vkR;
  private TextView vkS;
  private TextView vkT;
  private RelativeLayout vkU;
  private LocationManager vkV;
  private boolean vkW;
  private l vkX;
  
  public ExdeviceAddDataSourceUI()
  {
    AppMethodBeat.i(23866);
    this.vkW = false;
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
          if (com.tencent.mm.plugin.f.a.e.a.cyk())
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
              ae.cZJ();
              e.cZj();
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
                if (com.tencent.mm.plugin.f.a.e.a.cyk())
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
            if (com.tencent.mm.plugin.f.a.e.a.cyk())
            {
              ae.cZJ();
              e.cZj();
              AppMethodBeat.o(23845);
              return;
              label175:
              if ((paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) == 10) && (!com.tencent.mm.plugin.f.a.e.a.cyk()))
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
                ae.cZK().cxT();
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
            ae.cZK().cxT();
          }
        }
        AppMethodBeat.o(23845);
      }
    };
    AppMethodBeat.o(23866);
  }
  
  private void Ki(int paramInt)
  {
    AppMethodBeat.i(23868);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23868);
      return;
      this.vkU.setVisibility(8);
      this.vkS.setText(R.l.eCV);
      this.vkT.setText("");
      AppMethodBeat.o(23868);
      return;
      this.vkU.setVisibility(8);
      this.vkS.setText(R.l.eCX);
      this.vkT.setText(R.l.eCM);
      AppMethodBeat.o(23868);
      return;
      this.vkU.setVisibility(8);
      this.vkS.setText(R.l.eCX);
      this.vkT.setText(R.l.eDy);
      AppMethodBeat.o(23868);
      return;
      this.vkU.setVisibility(0);
      this.uIP.setVisibility(0);
    }
  }
  
  private static boolean aZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23874);
    fk localfk = new fk();
    localfk.fBq.mac = paramString;
    localfk.fBq.fzN = paramBoolean;
    if (!EventCenter.instance.publish(localfk))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[] { paramString });
      AppMethodBeat.o(23874);
      return false;
    }
    AppMethodBeat.o(23874);
    return true;
  }
  
  private void daq()
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
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
      AppMethodBeat.o(23873);
      return;
    }
    final b localb = this.vkP.avN(paramString);
    if (localb == null)
    {
      Log.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[] { paramString });
      AppMethodBeat.o(23873);
      return;
    }
    if ((localb.vlf == c.vlh) && (paramInt == 4))
    {
      localb.vlf = c.vlg;
      daq();
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23854);
          com.tencent.mm.ui.base.h.a(ExdeviceAddDataSourceUI.this, R.l.eDf, R.l.eDd, R.l.eDe, R.l.eDg, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23852);
              ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this).remove(ExdeviceAddDataSourceUI.10.this.vlc);
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).aa(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
              AppMethodBeat.o(23852);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23853);
              f.ay(ExdeviceAddDataSourceUI.this.getContext(), "https://" + WeChatHosts.domainString(R.l.host_hw_weixin_qq_com) + "/steprank/step/connect-help.html");
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
        if (localb.vlf == c.vlh)
        {
          localb.vlf = c.vli;
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
          if (localb.fAo != null)
          {
            this.vkX = new l(localb.fAo, 0);
            bh.aGY().a(this.vkX, 0);
          }
        }
        else
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[] { paramString });
          aZ(paramString, false);
        }
      }
      else
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          break;
        }
        localb.vlf = c.vlg;
      }
    }
    AppMethodBeat.o(23873);
  }
  
  public int getLayoutId()
  {
    return R.i.egf;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23869);
    this.mListView = ((ListView)findViewById(R.h.listview));
    View localView = View.inflate(this, R.i.egh, null);
    this.vkU = ((RelativeLayout)findViewById(R.h.dTh));
    this.uIP = View.inflate(this, R.i.egg, null);
    this.vkR = ((TextView)findViewById(R.h.dTf));
    this.vkS = ((TextView)findViewById(R.h.dFG));
    this.vkT = ((TextView)findViewById(R.h.dFH));
    String str1 = getString(R.l.eEa);
    String str2 = getString(R.l.eDc);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ForegroundColorSpan(R.e.link_color), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23846);
        f.ay(ExdeviceAddDataSourceUI.this.getContext(), "https://" + WeChatHosts.domainString(R.l.host_hw_weixin_qq_com) + "/steprank/step/connect-help.html");
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
    this.vkR.setMovementMethod(LinkMovementMethod.getInstance());
    this.vkR.setText(localSpannableString);
    this.mListView.addHeaderView(localView, null, false);
    this.mListView.addFooterView(this.uIP, null, false);
    this.vkP = new a();
    this.mListView.setAdapter(this.vkP);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23848);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).Kj(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.vlf != ExdeviceAddDataSourceUI.c.vlg)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        if (!ExdeviceAddDataSourceUI.avM(paramAnonymousAdapterView.mac))
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, paramAnonymousAdapterView.mac);
        paramAnonymousAdapterView.vlf = ExdeviceAddDataSourceUI.c.vlh;
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
    setMMTitle(R.l.eCH);
    if ((d.qV(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
      this.vkW = true;
    }
    this.vkQ = new LinkedList();
    this.vkV = ((LocationManager)getContext().getSystemService("location"));
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramBundle.addAction("android.location.MODE_CHANGED");
    getContext().registerReceiver(this.mReceiver, paramBundle);
    bh.aGY().a(536, this);
    bh.aGY().a(1706, this);
    ae.cZJ().a(this);
    if (!com.tencent.mm.plugin.f.a.e.a.eP(getContext()))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      Ki(2);
      AppMethodBeat.o(23867);
      return;
    }
    if (!com.tencent.mm.plugin.f.a.e.a.cyk())
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
      Ki(1);
      AppMethodBeat.o(23867);
      return;
    }
    if ((this.vkV != null) && (this.vkW) && (!this.vkV.isProviderEnabled("gps")))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
      Ki(4);
      AppMethodBeat.o(23867);
      return;
    }
    try
    {
      ae.cZJ();
      e.cZj();
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
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23849);
        Log.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
        yg localyg = new yg();
        EventCenter.instance.publish(localyg);
        AppMethodBeat.o(23849);
      }
    });
    bh.aGY().b(536, this);
    bh.aGY().b(1706, this);
    getContext().unregisterReceiver(this.mReceiver);
    ae.cZJ().b(this);
    ae.cZK().cxT();
    AppMethodBeat.o(23870);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
      daq();
      this.vkX = null;
      paramString = ((l)paramq).cZq();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = this.vkP.avN(com.tencent.mm.plugin.exdevice.k.b.avX(paramString.RQC.RPQ));
        if (paramString != null)
        {
          paramString.vlf = c.vlg;
          aZ(paramString.mac, false);
        }
        Log.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        AppMethodBeat.o(23871);
        return;
      }
      paramq = new Intent();
      paramq.putExtra("device_mac", com.tencent.mm.plugin.exdevice.k.b.avW(com.tencent.mm.plugin.exdevice.k.b.avX(paramString.RQC.RPQ)));
      aZ(com.tencent.mm.plugin.exdevice.k.b.avX(paramString.RQC.RPQ), false);
      setResult(-1, paramq);
      finish();
      AppMethodBeat.o(23871);
      return;
    }
    b localb;
    if (paramq.getType() == 1706)
    {
      paramq = ((u)paramq).cZt();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(23871);
        return;
      }
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[] { Long.valueOf(paramq.RQC.idY) });
      if (0L != (paramq.RQC.idY & 1L))
      {
        if (ae.cZx().gq(paramq.RQB.rVF, paramq.RQB.RMK) != null)
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[] { paramq.RQC.RPQ });
          AppMethodBeat.o(23871);
          return;
        }
        localb = new b((byte)0);
        if (paramq.RPW.TtX != null) {
          break label500;
        }
      }
    }
    label500:
    for (paramString = "";; paramString = z.a(paramq.RPW.TtX))
    {
      localb.name = paramString;
      localb.mac = com.tencent.mm.plugin.exdevice.k.b.avX(paramq.RQC.RPQ);
      localb.fAo = paramq.RPV;
      localb.iconUrl = paramq.RQC.CNj;
      this.vkQ.add(localb);
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23850);
          ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).aa(ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this));
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
  
  public final void q(String paramString1, String paramString2, boolean paramBoolean)
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
    if (i < this.vkQ.size())
    {
      paramString1 = (b)this.vkQ.get(i);
      if ((paramString1 == null) || (Util.isNullOrNil(paramString1.mac)))
      {
        paramString1 = this.vkQ;
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
        Log.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[] { Boolean.valueOf(bh.aGY().a(new u(paramString2.replaceAll(":", ""), null, null), 0)), paramString2 });
        AppMethodBeat.o(23872);
        return;
      }
    }
  }
  
  static final class a
    extends BaseAdapter
  {
    private List<ExdeviceAddDataSourceUI.b> vkQ;
    private com.tencent.mm.ay.a.a.c vle;
    
    public a()
    {
      AppMethodBeat.i(23856);
      this.vkQ = new LinkedList();
      c.a locala = new c.a();
      locala.lRP = R.g.dnu;
      this.vle = locala.bmL();
      AppMethodBeat.o(23856);
    }
    
    public final ExdeviceAddDataSourceUI.b Kj(int paramInt)
    {
      AppMethodBeat.i(23860);
      ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)this.vkQ.get(paramInt);
      AppMethodBeat.o(23860);
      return localb;
    }
    
    public final void aa(List<ExdeviceAddDataSourceUI.b> paramList)
    {
      AppMethodBeat.i(23857);
      this.vkQ.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(23857);
        return;
      }
      this.vkQ.addAll(paramList);
      AppMethodBeat.o(23857);
    }
    
    public final ExdeviceAddDataSourceUI.b avN(String paramString)
    {
      AppMethodBeat.i(23858);
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.vkQ.iterator();
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
      int i = this.vkQ.size();
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
      ExdeviceAddDataSourceUI.b localb = Kj(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), R.i.ege, null);
        paramView.qps = ((ImageView)localView.findViewById(R.h.dIy));
        paramView.mYd = ((TextView)localView.findViewById(R.h.dNd));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        Log.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
        paramViewGroup.mYd.setText(localb.name);
        com.tencent.mm.ay.q.bml().a(localb.iconUrl, paramViewGroup.qps, this.vle);
        AppMethodBeat.o(23861);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    
    static final class a
    {
      TextView mYd;
      ImageView qps;
    }
  }
  
  static final class b
  {
    String fAo;
    public String iconUrl;
    String mac;
    String name;
    ExdeviceAddDataSourceUI.c vlf = ExdeviceAddDataSourceUI.c.vlg;
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(23865);
      vlg = new c("NORMAL", 0);
      vlh = new c("ADDING", 1);
      vli = new c("ADDED", 2);
      vlj = new c[] { vlg, vlh, vli };
      AppMethodBeat.o(23865);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI
 * JD-Core Version:    0.7.0.1
 */