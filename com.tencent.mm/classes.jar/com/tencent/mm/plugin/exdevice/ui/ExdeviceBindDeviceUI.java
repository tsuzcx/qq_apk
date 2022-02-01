package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI
  extends MMActivity
  implements com.tencent.mm.al.f, e.b
{
  private ProgressDialog fMu;
  private ScrollView kLj;
  private String mDeviceType;
  private ListView mListView;
  private TextView oHG;
  private String qbM;
  private j.a qcz;
  private TextView qhw;
  private TextView qhx;
  private a qij;
  private View qik;
  private TextView qil;
  private ImageView qim;
  private View qin;
  private ExdeviceBindDeviceUI.e qio;
  private String qip;
  private String qiq;
  private boolean qir = false;
  private j.a qis;
  private boolean qit = false;
  private boolean qiu = false;
  
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
  
  private void CD(int paramInt)
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
      ((SpannableString)localObject).setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23901);
          com.tencent.mm.plugin.exdevice.model.f.an(ExdeviceBindDeviceUI.this.getContext(), "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
          AppMethodBeat.o(23901);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(23902);
          paramAnonymousTextPaint.setColor(paramAnonymousTextPaint.linkColor);
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(23902);
        }
      }, 0, str.length(), 33);
      this.qil.setMovementMethod(LinkMovementMethod.getInstance());
      this.qil.setText((CharSequence)localObject);
      break;
      str = getString(2131758485);
      localObject = getString(2131758482);
      SpannableString localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131100547), str.length(), str.length() + ((String)localObject).length(), 33);
      localSpannableString.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23903);
          ExdeviceBindDeviceUI.this.finish();
          AppMethodBeat.o(23903);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(23904);
          paramAnonymousTextPaint.setColor(paramAnonymousTextPaint.linkColor);
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(23904);
        }
      }, str.length(), str.length() + ((String)localObject).length(), 33);
      this.qil.setMovementMethod(LinkMovementMethod.getInstance());
      this.qil.setText(localSpannableString);
      break;
      str = getString(2131758486);
      localObject = getString(2131758515);
      localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131100547), str.length(), str.length() + ((String)localObject).length(), 33);
      localSpannableString.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23893);
          ExdeviceBindDeviceUI.this.finish();
          AppMethodBeat.o(23893);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(23894);
          paramAnonymousTextPaint.setColor(paramAnonymousTextPaint.linkColor);
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(23894);
        }
      }, str.length(), str.length() + ((String)localObject).length(), 33);
      this.qil.setMovementMethod(LinkMovementMethod.getInstance());
      this.qil.setText(localSpannableString);
      break;
      this.qim.setImageResource(2131689789);
      this.qhw.setText(2131758494);
      this.qhx.setText(2131758478);
      break label72;
      this.qim.setImageResource(2131689789);
      this.qhw.setText(2131758492);
      this.qhx.setText("");
      break label72;
      this.qim.setImageResource(2131691457);
      this.qhw.setText(2131758494);
      this.qhx.setText(2131758489);
      break label72;
      this.qik.setVisibility(0);
      this.mListView.setVisibility(0);
      this.qil.setVisibility(0);
      this.qim.setVisibility(8);
      this.qhw.setVisibility(8);
      this.qhx.setVisibility(8);
      AppMethodBeat.o(23934);
      return;
      this.kLj.setVisibility(8);
      this.qik.setVisibility(8);
      this.mListView.setVisibility(8);
      this.qil.setVisibility(8);
      this.qim.setVisibility(0);
      this.qhw.setVisibility(0);
      if (paramInt == 4)
      {
        this.qhx.setVisibility(8);
        AppMethodBeat.o(23934);
        return;
      }
      this.qhx.setVisibility(0);
    }
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(23932);
    Object localObject = paramf.getKey();
    if (this.qij.acP((String)localObject))
    {
      AppMethodBeat.o(23932);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.cmc());
    localObject = this.qij;
    if ((paramf != null) && (!((a)localObject).acP(paramf.getKey())))
    {
      paramf.qiO = ((a)localObject).c(paramf);
      ((a)localObject).qiC.add(paramf);
    }
    this.qij.notifyDataSetChanged();
    if (paramf.qiP == ExdeviceBindDeviceUI.b.qiH)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.qiQ.cOA, this.qbM, this.qip });
      ba.aiU().a(new t(paramf.qiQ.cOA, this.qbM, this.qip), 0);
      AppMethodBeat.o(23932);
      return;
    }
    if (paramf.qiP == ExdeviceBindDeviceUI.b.qiG)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.qiR.mDeviceType, paramf.qiR.qbN });
      ba.aiU().a(new v(paramf.qiR.mDeviceType, paramf.qiR.qbN, paramf.qiW), 0);
      AppMethodBeat.o(23932);
      return;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(23932);
  }
  
  public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void d(String paramString, int paramInt, long paramLong) {}
  
  public int getLayoutId()
  {
    return 2131493858;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23927);
    this.mListView = ((ListView)findViewById(2131301457));
    Object localObject = View.inflate(this, 2131493860, null);
    this.qin = View.inflate(this, 2131493893, null);
    this.qik = this.qin.findViewById(2131304456);
    this.oHG = ((TextView)this.qin.findViewById(2131305885));
    this.qil = ((TextView)findViewById(2131304300));
    this.qim = ((ImageView)findViewById(2131301586));
    this.qhw = ((TextView)findViewById(2131299511));
    this.qhx = ((TextView)findViewById(2131299512));
    this.kLj = ((ScrollView)findViewById(2131299066));
    this.mListView.addHeaderView((View)localObject, null, false);
    this.mListView.addFooterView(this.qin, null, false);
    this.qij = new a(this.qbM, this.qio, this.qip);
    this.mListView.setAdapter(this.qij);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this).CF(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.qiT.ffF != 0) {
          ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, paramAnonymousAdapterView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(23897);
          return;
          ExdeviceBindDeviceUI.b(ExdeviceBindDeviceUI.this, paramAnonymousAdapterView);
        }
      }
    });
    if ((this.qiu) && (!this.qit))
    {
      if (!com.tencent.mm.plugin.d.a.e.a.ep(getContext()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        CD(4);
        AppMethodBeat.o(23927);
        return;
      }
      if (!com.tencent.mm.plugin.d.a.e.a.bMR())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        CD(3);
        AppMethodBeat.o(23927);
        return;
      }
    }
    if ((!this.qiu) && (this.qit) && (!ay.isWifi(getContext())))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
      CD(5);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.qio == ExdeviceBindDeviceUI.e.qiL)
    {
      CD(0);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.qio == ExdeviceBindDeviceUI.e.qiM)
    {
      if ((this.qiu) && (this.qit))
      {
        Assert.assertTrue(false);
        CD(1);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.qiu)
      {
        CD(2);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.qit)
      {
        CD(1);
        AppMethodBeat.o(23927);
      }
    }
    else
    {
      localObject = ExdeviceBindDeviceUI.e.qiK;
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
    final f localf = new f((byte)0);
    localf.qiP = ExdeviceBindDeviceUI.b.qiH;
    localf.qiQ = new c((byte)0);
    localf.qiQ.qiJ = paramString1;
    localf.qiQ.cOA = com.tencent.mm.plugin.exdevice.k.b.uP(com.tencent.mm.plugin.exdevice.k.b.acY(paramString2));
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23899);
        ExdeviceBindDeviceUI.this.a(localf);
        AppMethodBeat.o(23899);
      }
    });
    AppMethodBeat.o(23930);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23933);
    this.qij.cmb();
    this.qij.notifyDataSetChanged();
    AppMethodBeat.o(23933);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23925);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(23892);
        ExdeviceBindDeviceUI.this.finish();
        AppMethodBeat.o(23892);
        return true;
      }
    });
    Object localObject = getIntent();
    this.qip = ((Intent)localObject).getStringExtra("device_category_id");
    this.qbM = ((Intent)localObject).getStringExtra("device_brand_name");
    this.mDeviceType = ((Intent)localObject).getStringExtra("device_type");
    if ((this.mDeviceType == null) || (this.mDeviceType.length() == 0)) {
      this.mDeviceType = this.qbM;
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
      this.qio = ExdeviceBindDeviceUI.e.qiL;
      paramBundle = getContext().getString(2131758468);
      setMMTitle(paramBundle);
      if (this.qio != ExdeviceBindDeviceUI.e.qiM) {
        break label425;
      }
      this.qit = str2.contains("wifi");
      this.qiu = str2.contains("blue");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.qit), Boolean.valueOf(this.qiu) });
    }
    for (;;)
    {
      this.qcz = new j.a()
      {
        public final void g(int paramAnonymousInt, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(23896);
          if ((paramAnonymousInt != 10) || (paramAnonymousVarArgs == null))
          {
            AppMethodBeat.o(23896);
            return;
          }
          paramAnonymousVarArgs = (byte[])paramAnonymousVarArgs[0];
          for (;;)
          {
            try
            {
              JSONObject localJSONObject = new JSONObject(new String(paramAnonymousVarArgs));
              localObject1 = localJSONObject.getJSONObject("deviceInfo");
              paramAnonymousVarArgs = ((JSONObject)localObject1).getString("deviceType");
              Object[] arrayOfObject1;
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", localException1, "", new Object[0]);
            }
            catch (Exception localException1)
            {
              try
              {
                localObject1 = ((JSONObject)localObject1).getString("deviceId");
                localObject2 = localObject1;
                arrayOfObject1 = paramAnonymousVarArgs;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Object localObject2;
                  Object[] arrayOfObject2;
                  Object localObject1 = null;
                }
              }
              try
              {
                if (localJSONObject.isNull("manufacturerData")) {
                  break label151;
                }
                localObject2 = localJSONObject.getString("manufacturerData");
                arrayOfObject1 = paramAnonymousVarArgs;
                paramAnonymousVarArgs = (Object[])localObject2;
                if ((arrayOfObject1 != null) && (localObject1 != null)) {
                  break;
                }
                AppMethodBeat.o(23896);
                return;
              }
              catch (Exception localException3)
              {
                break label125;
              }
              localException1 = localException1;
              localObject1 = null;
              paramAnonymousVarArgs = null;
            }
            label125:
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
            arrayOfObject2 = paramAnonymousVarArgs;
            localObject2 = localObject1;
            label151:
            paramAnonymousVarArgs = null;
            localObject1 = localObject2;
          }
          localObject2 = new ExdeviceBindDeviceUI.f(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).qiP = ExdeviceBindDeviceUI.b.qiG;
          ((ExdeviceBindDeviceUI.f)localObject2).qiR = new ExdeviceBindDeviceUI.d(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).qiR.mDeviceType = arrayOfObject2;
          ((ExdeviceBindDeviceUI.f)localObject2).qiR.qbN = ((String)localObject1);
          if (!bt.isNullOrNil(paramAnonymousVarArgs))
          {
            ((ExdeviceBindDeviceUI.f)localObject2).qiW = Base64.encodeToString(paramAnonymousVarArgs.getBytes(), 2);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[] { ((ExdeviceBindDeviceUI.f)localObject2).qiW });
          }
          for (;;)
          {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23895);
                ExdeviceBindDeviceUI.this.a(this.qiw);
                AppMethodBeat.o(23895);
              }
            });
            AppMethodBeat.o(23896);
            return;
            ((ExdeviceBindDeviceUI.f)localObject2).qiW = null;
          }
        }
      };
      this.qis = new j.a()
      {
        public final void g(int paramAnonymousInt, Object... paramAnonymousVarArgs) {}
      };
      initView();
      this.oHG.setText(getContext().getString(2131758598, new Object[] { localObject }));
      ba.aiU().a(1264, this);
      ba.aiU().a(1706, this);
      ba.aiU().a(1270, this);
      ba.aiU().a(1719, this);
      if (this.qiu) {
        com.tencent.mm.plugin.exdevice.model.ad.clE().a(this);
      }
      if (this.qit)
      {
        j.clk().a(10, this.qcz);
        j.clk().a(11, this.qis);
        Java2CExDevice.initWCLanDeviceLib();
      }
      AppMethodBeat.o(23925);
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.qio = ExdeviceBindDeviceUI.e.qiM;
        paramBundle = getContext().getString(2131758466);
        break;
      }
      Assert.assertTrue(false);
      break;
      label425:
      if (this.qio == ExdeviceBindDeviceUI.e.qiL)
      {
        this.qiu = true;
        this.qit = true;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23929);
    super.onDestroy();
    if (this.qit)
    {
      ba.ajF().ay(new ExdeviceBindDeviceUI.6(this));
      j.clk().b(10, this.qcz);
      j.clk().b(11, this.qis);
    }
    if (this.qiu)
    {
      com.tencent.mm.plugin.exdevice.model.ad.clE().b(this);
      com.tencent.mm.plugin.exdevice.model.ad.clF().stopScan();
    }
    ba.aiU().b(1264, this);
    ba.aiU().b(1706, this);
    ba.aiU().b(1270, this);
    ba.aiU().b(1719, this);
    AppMethodBeat.o(23929);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(23928);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.qit) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.qiu) {
      com.tencent.mm.plugin.exdevice.model.ad.clF().stopScan();
    }
    AppMethodBeat.o(23928);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23926);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.qiu)
    {
      com.tencent.mm.plugin.exdevice.model.ad.clE();
      e.clg();
    }
    if (this.qit) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.qij.cmb();
    this.qij.notifyDataSetChanged();
    AppMethodBeat.o(23926);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(23931);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
      AppMethodBeat.o(23931);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23900);
        ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, paramInt1, paramInt2, paramString, paramn);
        AppMethodBeat.o(23900);
      }
    });
    AppMethodBeat.o(23931);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private c qhI;
    List<ExdeviceBindDeviceUI.f> qiC;
    private String qiD;
    private ExdeviceBindDeviceUI.e qiE;
    private String qiF;
    
    public a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
    {
      AppMethodBeat.i(23905);
      this.qiD = paramString1;
      this.qiE = parame;
      this.qiF = paramString2;
      this.qiC = new ArrayList();
      paramString1 = new c.a();
      paramString1.idG = 2131100860;
      this.qhI = paramString1.aJc();
      AppMethodBeat.o(23905);
    }
    
    private int acR(String paramString)
    {
      AppMethodBeat.i(23913);
      int i = 0;
      while (i < this.qiC.size())
      {
        if (((ExdeviceBindDeviceUI.f)this.qiC.get(i)).getKey().compareTo(paramString) == 0)
        {
          AppMethodBeat.o(23913);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(23913);
      return -1;
    }
    
    private static boolean acS(String paramString)
    {
      AppMethodBeat.i(23916);
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(23916);
        return true;
      }
      AppMethodBeat.o(23916);
      return false;
    }
    
    public final ExdeviceBindDeviceUI.f CF(int paramInt)
    {
      AppMethodBeat.i(23911);
      int j = -1;
      int i = 0;
      while (i < this.qiC.size())
      {
        int k = j;
        if (((ExdeviceBindDeviceUI.f)this.qiC.get(i)).qiO) {
          k = j + 1;
        }
        if (k == paramInt)
        {
          ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.qiC.get(i);
          AppMethodBeat.o(23911);
          return localf;
        }
        i += 1;
        j = k;
      }
      AppMethodBeat.o(23911);
      return null;
    }
    
    public final boolean acP(String paramString)
    {
      AppMethodBeat.i(23908);
      if (acR(paramString) >= 0)
      {
        AppMethodBeat.o(23908);
        return true;
      }
      AppMethodBeat.o(23908);
      return false;
    }
    
    public final ExdeviceBindDeviceUI.f acQ(String paramString)
    {
      AppMethodBeat.i(23909);
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(23909);
        return null;
      }
      int i = 0;
      while (i < this.qiC.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.qiC.get(i);
        if ((!acS(localf.cmc())) && (paramString.equalsIgnoreCase(localf.cmc())))
        {
          AppMethodBeat.o(23909);
          return localf;
        }
        i += 1;
      }
      AppMethodBeat.o(23909);
      return null;
    }
    
    public final boolean b(ExdeviceBindDeviceUI.f paramf)
    {
      AppMethodBeat.i(23907);
      if (acR(paramf.getKey()) < 0)
      {
        AppMethodBeat.o(23907);
        return false;
      }
      paramf.qiO = c(paramf);
      AppMethodBeat.o(23907);
      return true;
    }
    
    final boolean c(ExdeviceBindDeviceUI.f paramf)
    {
      AppMethodBeat.i(23915);
      if (paramf.qiT == null)
      {
        AppMethodBeat.o(23915);
        return false;
      }
      if (this.qiE == ExdeviceBindDeviceUI.e.qiM)
      {
        if ((paramf.qiT.GHv == null) || (paramf.qiT.GHv.compareTo(this.qiD) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
        if ((paramf.qiT.GHE == null) || (paramf.qiT.GHE.compareTo(this.qiF) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
      }
      else if (this.qiE == ExdeviceBindDeviceUI.e.qiL)
      {
        if (paramf.qiT.ffF == 0)
        {
          AppMethodBeat.o(23915);
          return false;
        }
      }
      else
      {
        Assert.assertTrue(false);
        AppMethodBeat.o(23915);
        return false;
      }
      AppMethodBeat.o(23915);
      return true;
    }
    
    final void cmb()
    {
      AppMethodBeat.i(23906);
      int i = 0;
      while (i < this.qiC.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.qiC.get(i);
        localf.qiO = c(localf);
        i += 1;
      }
      AppMethodBeat.o(23906);
    }
    
    final int fH(String paramString1, String paramString2)
    {
      AppMethodBeat.i(23914);
      int i = 0;
      while (i < this.qiC.size())
      {
        Object localObject = (ExdeviceBindDeviceUI.f)this.qiC.get(i);
        String str;
        if (((ExdeviceBindDeviceUI.f)localObject).qiS != null)
        {
          str = ((ExdeviceBindDeviceUI.f)localObject).qiS.FzJ;
          if (((ExdeviceBindDeviceUI.f)localObject).qiS == null) {
            break label144;
          }
          localObject = ((ExdeviceBindDeviceUI.f)localObject).qiS.nDr;
        }
        for (;;)
        {
          if ((acS(str)) || (acS((String)localObject)) || (paramString1.compareTo(str) != 0) || (paramString2.compareTo((String)localObject) != 0)) {
            break label174;
          }
          AppMethodBeat.o(23914);
          return i;
          if (((ExdeviceBindDeviceUI.f)localObject).qiP == ExdeviceBindDeviceUI.b.qiG)
          {
            str = ((ExdeviceBindDeviceUI.f)localObject).qiR.mDeviceType;
            break;
          }
          str = null;
          break;
          label144:
          if (((ExdeviceBindDeviceUI.f)localObject).qiP == ExdeviceBindDeviceUI.b.qiG) {
            localObject = ((ExdeviceBindDeviceUI.f)localObject).qiR.qbN;
          } else {
            localObject = null;
          }
        }
        label174:
        i += 1;
      }
      AppMethodBeat.o(23914);
      return -1;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(23910);
      int i = 0;
      int k;
      for (int j = 0; i < this.qiC.size(); j = k)
      {
        k = j;
        if (((ExdeviceBindDeviceUI.f)this.qiC.get(i)).qiO) {
          k = j + 1;
        }
        i += 1;
      }
      AppMethodBeat.o(23910);
      return j;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(23912);
      ExdeviceBindDeviceUI.f localf = CF(paramInt);
      a locala;
      View localView;
      if (paramView == null)
      {
        locala = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131493857, null);
        locala.jfJ = ((TextView)localView.findViewById(2131302656));
        locala.lZa = ((ImageView)localView.findViewById(2131300880));
        localView.setTag(locala);
      }
      while ((localf == null) || (localf.qiT == null))
      {
        Assert.assertTrue(false);
        AppMethodBeat.o(23912);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
      }
      Object localObject;
      if (localf.qiP == ExdeviceBindDeviceUI.b.qiH)
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.qiQ.qiJ, localf.qiQ.cOA, localf.qiT.GHC });
        localObject = "";
        paramView = localf.qiT.ffJ;
        if ((paramView != null) && (paramView.length() >= 4))
        {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
          paramView = localf.qiT.GHC + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100490)), localf.qiT.GHC.length() + 1, paramView.length(), 17);
          locala.jfJ.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        paramView = localf.qiT.IconUrl;
        if (!acS(paramView)) {
          com.tencent.mm.aw.q.aIJ().a(paramView, locala.lZa, this.qhI);
        }
        AppMethodBeat.o(23912);
        return localView;
        paramView = (View)localObject;
        if (localf.qiQ.cOA == null) {
          break;
        }
        paramView = (View)localObject;
        if (localf.qiQ.cOA.length() < 4) {
          break;
        }
        paramView = localf.qiQ.cOA;
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        break;
        if (localf.qiP == ExdeviceBindDeviceUI.b.qiG)
        {
          localObject = "";
          paramView = localf.qiT.ffJ;
          if ((paramView != null) && (paramView.length() >= 4)) {
            paramView = paramView.substring(paramView.length() - 4, paramView.length());
          }
          for (;;)
          {
            paramView = localf.qiT.GHC + " " + paramView;
            localObject = new SpannableString(paramView);
            ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100490)), localf.qiT.GHC.length() + 1, paramView.length(), 17);
            locala.jfJ.setText((CharSequence)localObject);
            break;
            paramView = (View)localObject;
            if (localf.qiT.FCM != null)
            {
              paramView = (View)localObject;
              if (localf.qiT.FCM.length() >= 4)
              {
                paramView = localf.qiT.FCM;
                paramView = paramView.substring(paramView.length() - 4, paramView.length());
              }
            }
          }
        }
        Assert.assertTrue(false);
      }
    }
    
    static final class a
    {
      TextView jfJ;
      ImageView lZa;
    }
  }
  
  final class c
  {
    public String cOA;
    public String qiJ;
    
    private c() {}
  }
  
  final class d
  {
    public String mDeviceType;
    public String qbN;
    
    private d() {}
  }
  
  final class f
  {
    public String qhX;
    public boolean qiO = false;
    public ExdeviceBindDeviceUI.b qiP = ExdeviceBindDeviceUI.b.qiG;
    public ExdeviceBindDeviceUI.c qiQ;
    public ExdeviceBindDeviceUI.d qiR;
    public bnj qiS;
    public bnk qiT;
    public int qiU;
    public bzp qiV;
    public String qiW;
    
    private f() {}
    
    public final String cmc()
    {
      if (this.qiP == ExdeviceBindDeviceUI.b.qiG)
      {
        if (this.qiT == null) {
          return null;
        }
        return this.qiT.FCM;
      }
      return this.qiQ.cOA;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(23924);
      if (this.qiP == ExdeviceBindDeviceUI.b.qiG)
      {
        str = this.qiR.mDeviceType + this.qiR.qbN;
        AppMethodBeat.o(23924);
        return str;
      }
      String str = this.qiQ.cOA;
      AppMethodBeat.o(23924);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */