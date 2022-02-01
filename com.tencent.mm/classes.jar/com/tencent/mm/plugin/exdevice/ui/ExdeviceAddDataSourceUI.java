package com.tencent.mm.plugin.exdevice.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.fv;
import com.tencent.mm.autogen.a.zz;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.exdevice.model.g;
import com.tencent.mm.plugin.exdevice.model.g.b;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.n;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.euz;
import com.tencent.mm.protocal.protobuf.mt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI
  extends MMActivity
  implements com.tencent.mm.am.h, g.b
{
  private com.tencent.mm.ui.base.w lKp;
  private ListView mListView;
  private final BroadcastReceiver mReceiver;
  private View xRF;
  private a yxs;
  private List<b> yxt;
  private TextView yxu;
  private TextView yxv;
  private TextView yxw;
  private RelativeLayout yxx;
  private boolean yxy;
  private n yxz;
  
  public ExdeviceAddDataSourceUI()
  {
    AppMethodBeat.i(23866);
    this.yxy = false;
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
            break label157;
          }
          if (com.tencent.mm.plugin.g.a.e.a.dbb())
          {
            ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23841);
                if ((ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) && (!com.tencent.mm.modelgeo.d.bJm()))
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
            if ((!ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) || (com.tencent.mm.modelgeo.d.bJm()))
            {
              ah.dGc();
              g.dFA();
            }
          }
        }
        while ((ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this)) && ("android.location.MODE_CHANGED".equals(paramAnonymousContext))) {
          if (com.tencent.mm.modelgeo.d.bJm())
          {
            ExdeviceAddDataSourceUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23843);
                if (com.tencent.mm.plugin.g.a.e.a.dbb())
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
            if (com.tencent.mm.plugin.g.a.e.a.dbb())
            {
              ah.dGc();
              g.dFA();
              AppMethodBeat.o(23845);
              return;
              label157:
              if ((paramAnonymousIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648) == 10) && (!com.tencent.mm.plugin.g.a.e.a.dbb()))
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
                ah.dGd().daL();
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
            ah.dGd().daL();
          }
        }
        AppMethodBeat.o(23845);
      }
    };
    AppMethodBeat.o(23866);
  }
  
  private void Lh(int paramInt)
  {
    AppMethodBeat.i(23868);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23868);
      return;
      this.yxx.setVisibility(8);
      this.yxv.setText(R.l.gFJ);
      this.yxw.setText("");
      AppMethodBeat.o(23868);
      return;
      this.yxx.setVisibility(8);
      this.yxv.setText(R.l.gFL);
      this.yxw.setText(R.l.gFA);
      AppMethodBeat.o(23868);
      return;
      this.yxx.setVisibility(8);
      this.yxv.setText(R.l.gFL);
      this.yxw.setText(R.l.gGm);
      AppMethodBeat.o(23868);
      return;
      this.yxx.setVisibility(0);
      this.xRF.setVisibility(0);
    }
  }
  
  private static boolean bl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23874);
    fv localfv = new fv();
    localfv.hGf.mac = paramString;
    localfv.hGf.hEz = paramBoolean;
    if (!localfv.publish())
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[] { paramString });
      AppMethodBeat.o(23874);
      return false;
    }
    AppMethodBeat.o(23874);
    return true;
  }
  
  private void dGL()
  {
    AppMethodBeat.i(23875);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23838);
        if ((ExdeviceAddDataSourceUI.e(ExdeviceAddDataSourceUI.this) != null) && (ExdeviceAddDataSourceUI.e(ExdeviceAddDataSourceUI.this).isShowing())) {
          ExdeviceAddDataSourceUI.e(ExdeviceAddDataSourceUI.this).dismiss();
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
    final b localb = this.yxs.apN(paramString);
    if (localb == null)
    {
      Log.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[] { paramString });
      AppMethodBeat.o(23873);
      return;
    }
    if ((localb.yxH == c.yxJ) && (paramInt == 4))
    {
      localb.yxH = c.yxI;
      dGL();
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23854);
          k.a(ExdeviceAddDataSourceUI.this, R.l.gFT, R.l.gFR, R.l.gFS, R.l.gFU, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23852);
              ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this).remove(ExdeviceAddDataSourceUI.10.this.yxE);
              ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).bz(ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this));
              ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
              AppMethodBeat.o(23852);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(23853);
              com.tencent.mm.plugin.exdevice.model.h.az(ExdeviceAddDataSourceUI.this.getContext(), "https://" + WeChatHosts.domainString(R.l.host_hw_weixin_qq_com) + "/steprank/step/connect-help.html");
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
          ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
          AppMethodBeat.o(23855);
        }
      });
      AppMethodBeat.o(23873);
      return;
      if (paramInt == 2)
      {
        if (localb.yxH == c.yxJ)
        {
          localb.yxH = c.yxK;
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
          if (localb.hFb != null)
          {
            this.yxz = new n(localb.hFb, 0);
            bh.aZW().a(this.yxz, 0);
          }
        }
        else
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[] { paramString });
          bl(paramString, false);
        }
      }
      else
      {
        if ((paramInt == 1) || (paramInt == 2)) {
          break;
        }
        localb.yxH = c.yxI;
      }
    }
    AppMethodBeat.o(23873);
  }
  
  public int getLayoutId()
  {
    return R.i.giZ;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23869);
    this.mListView = ((ListView)findViewById(R.h.listview));
    View localView = View.inflate(this, R.i.gjb, null);
    this.yxx = ((RelativeLayout)findViewById(R.h.fVp));
    this.xRF = View.inflate(this, R.i.gja, null);
    this.yxu = ((TextView)findViewById(R.h.fVn));
    this.yxv = ((TextView)findViewById(R.h.fGM));
    this.yxw = ((TextView)findViewById(R.h.fGN));
    String str1 = getString(R.l.gGO);
    String str2 = getString(R.l.gFQ);
    SpannableString localSpannableString = new SpannableString(str1 + str2);
    localSpannableString.setSpan(new ForegroundColorSpan(R.e.link_color), str1.length(), str1.length() + str2.length(), 33);
    localSpannableString.setSpan(new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23846);
        com.tencent.mm.plugin.exdevice.model.h.az(ExdeviceAddDataSourceUI.this.getContext(), "https://" + WeChatHosts.domainString(R.l.host_hw_weixin_qq_com) + "/steprank/step/connect-help.html");
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
    this.yxu.setMovementMethod(LinkMovementMethod.getInstance());
    this.yxu.setText(localSpannableString);
    this.mListView.addHeaderView(localView, null, false);
    this.mListView.addFooterView(this.xRF, null, false);
    this.yxs = new a();
    this.mListView.setAdapter(this.yxs);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23848);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).Li(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.yxH != ExdeviceAddDataSourceUI.c.yxI)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        if (!ExdeviceAddDataSourceUI.apM(paramAnonymousAdapterView.mac))
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceAddDataSourceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23848);
          return;
        }
        ExdeviceAddDataSourceUI.a(ExdeviceAddDataSourceUI.this, paramAnonymousAdapterView.mac);
        paramAnonymousAdapterView.yxH = ExdeviceAddDataSourceUI.c.yxJ;
        ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
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
    setMMTitle(R.l.gFv);
    if ((com.tencent.mm.compatible.util.d.rb(23)) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0")) && (!Build.VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
      this.yxy = true;
    }
    this.yxt = new LinkedList();
    initView();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramBundle.addAction("android.location.MODE_CHANGED");
    getContext().registerReceiver(this.mReceiver, paramBundle);
    bh.aZW().a(536, this);
    bh.aZW().a(1706, this);
    ah.dGc().a(this);
    if (!com.tencent.mm.plugin.g.a.e.a.fL(getContext()))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      Lh(2);
      AppMethodBeat.o(23867);
      return;
    }
    if (!com.tencent.mm.plugin.g.a.e.a.dbb())
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
      Lh(1);
      AppMethodBeat.o(23867);
      return;
    }
    if ((this.yxy) && (!com.tencent.mm.modelgeo.d.bJm()))
    {
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
      Lh(4);
      AppMethodBeat.o(23867);
      return;
    }
    try
    {
      ah.dGc();
      g.dFA();
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
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23849);
        Log.d("MicroMsg.ExdeviceAddDataSourceUI", "stopAllChannelEvent! ");
        new zz().publish();
        AppMethodBeat.o(23849);
      }
    });
    bh.aZW().b(536, this);
    bh.aZW().b(1706, this);
    getContext().unregisterReceiver(this.mReceiver);
    ah.dGc().b(this);
    ah.dGd().daL();
    AppMethodBeat.o(23870);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23871);
    Log.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
    {
      Log.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
      AppMethodBeat.o(23871);
      return;
    }
    if (paramp.getType() == 536)
    {
      dGL();
      this.yxz = null;
      paramString = ((n)paramp).dFH();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = this.yxs.apN(com.tencent.mm.plugin.exdevice.k.b.apY(paramString.YNS.YNe));
        if (paramString != null)
        {
          paramString.yxH = c.yxI;
          bl(paramString.mac, false);
        }
        Log.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        AppMethodBeat.o(23871);
        return;
      }
      paramp = new Intent();
      paramp.putExtra("device_mac", com.tencent.mm.plugin.exdevice.k.b.apW(com.tencent.mm.plugin.exdevice.k.b.apY(paramString.YNS.YNe)));
      bl(com.tencent.mm.plugin.exdevice.k.b.apY(paramString.YNS.YNe), false);
      setResult(-1, paramp);
      finish();
      AppMethodBeat.o(23871);
      return;
    }
    b localb;
    if (paramp.getType() == 1706)
    {
      paramp = ((com.tencent.mm.plugin.exdevice.model.w)paramp).dFK();
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        AppMethodBeat.o(23871);
        return;
      }
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[] { Long.valueOf(paramp.YNS.kDi) });
      if (0L != (paramp.YNS.kDi & 1L))
      {
        if (ah.dFO().gU(paramp.YNR.vgV, paramp.YNR.YJY) != null)
        {
          Log.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[] { paramp.YNS.YNe });
          AppMethodBeat.o(23871);
          return;
        }
        localb = new b((byte)0);
        if (paramp.YNk.aaIz != null) {
          break label500;
        }
      }
    }
    label500:
    for (paramString = "";; paramString = com.tencent.mm.platformtools.w.a(paramp.YNk.aaIz))
    {
      localb.name = paramString;
      localb.mac = com.tencent.mm.plugin.exdevice.k.b.apY(paramp.YNS.YNe);
      localb.hFb = paramp.YNj;
      localb.iconUrl = paramp.YNS.IHo;
      this.yxt.add(localb);
      Log.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[] { localb.mac, localb.name });
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23850);
          ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).bz(ExdeviceAddDataSourceUI.c(ExdeviceAddDataSourceUI.this));
          ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
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
  
  public final void t(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23872);
    Log.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23851);
          ExdeviceAddDataSourceUI.d(ExdeviceAddDataSourceUI.this).setVisibility(8);
          ExdeviceAddDataSourceUI.b(ExdeviceAddDataSourceUI.this).notifyDataSetChanged();
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
    if (i < this.yxt.size())
    {
      paramString1 = (b)this.yxt.get(i);
      if ((paramString1 == null) || (Util.isNullOrNil(paramString1.mac)))
      {
        paramString1 = this.yxt;
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
        Log.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[] { Boolean.valueOf(bh.aZW().a(new com.tencent.mm.plugin.exdevice.model.w(paramString2.replaceAll(":", ""), null, null), 0)), paramString2 });
        AppMethodBeat.o(23872);
        return;
      }
    }
  }
  
  static final class a
    extends BaseAdapter
  {
    private com.tencent.mm.modelimage.loader.a.c yxG;
    private List<ExdeviceAddDataSourceUI.b> yxt;
    
    public a()
    {
      AppMethodBeat.i(23856);
      this.yxt = new LinkedList();
      c.a locala = new c.a();
      locala.oKB = R.g.fnI;
      this.yxG = locala.bKx();
      AppMethodBeat.o(23856);
    }
    
    public final ExdeviceAddDataSourceUI.b Li(int paramInt)
    {
      AppMethodBeat.i(23860);
      ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)this.yxt.get(paramInt);
      AppMethodBeat.o(23860);
      return localb;
    }
    
    public final ExdeviceAddDataSourceUI.b apN(String paramString)
    {
      AppMethodBeat.i(23858);
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.yxt.iterator();
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
    
    public final void bz(List<ExdeviceAddDataSourceUI.b> paramList)
    {
      AppMethodBeat.i(23857);
      this.yxt.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        AppMethodBeat.o(23857);
        return;
      }
      this.yxt.addAll(paramList);
      AppMethodBeat.o(23857);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(23859);
      int i = this.yxt.size();
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
      ExdeviceAddDataSourceUI.b localb = Li(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), R.i.giY, null);
        paramView.ttT = ((ImageView)localView.findViewById(R.h.iconIV));
        paramView.pUL = ((TextView)localView.findViewById(R.h.fOX));
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        Log.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
        paramViewGroup.pUL.setText(localb.name);
        r.bKe().a(localb.iconUrl, paramViewGroup.ttT, this.yxG);
        AppMethodBeat.o(23861);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    
    static final class a
    {
      TextView pUL;
      ImageView ttT;
    }
  }
  
  static final class b
  {
    String hFb;
    public String iconUrl;
    String mac;
    String name;
    ExdeviceAddDataSourceUI.c yxH = ExdeviceAddDataSourceUI.c.yxI;
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(23865);
      yxI = new c("NORMAL", 0);
      yxJ = new c("ADDING", 1);
      yxK = new c("ADDED", 2);
      yxL = new c[] { yxI, yxJ, yxK };
      AppMethodBeat.o(23865);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI
 * JD-Core Version:    0.7.0.1
 */