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
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI
  extends MMActivity
  implements i, e.b
{
  private ProgressDialog gtM;
  private ScrollView lTw;
  private String mDeviceType;
  private ListView mListView;
  private TextView qbW;
  private j.a rAa;
  private a rFV;
  private View rFW;
  private TextView rFX;
  private ImageView rFY;
  private View rFZ;
  private TextView rFi;
  private TextView rFj;
  private e rGa;
  private String rGb;
  private String rGc;
  private boolean rGd = false;
  private j.a rGe;
  private boolean rGf = false;
  private boolean rGg = false;
  private String rzn;
  
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
  
  private void GA(int paramInt)
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
      String str = getString(2131758780);
      Object localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(2131100685), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23901);
          f.ay(ExdeviceBindDeviceUI.this.getContext(), "http://" + WeChatHosts.domainString(2131761727) + "/mydevice/page/deviceHelp.html");
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
      this.rFX.setMovementMethod(LinkMovementMethod.getInstance());
      this.rFX.setText((CharSequence)localObject);
      break;
      str = getString(2131758784);
      localObject = getString(2131758781);
      SpannableString localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131100685), str.length(), str.length() + ((String)localObject).length(), 33);
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
      this.rFX.setMovementMethod(LinkMovementMethod.getInstance());
      this.rFX.setText(localSpannableString);
      break;
      str = getString(2131758785);
      localObject = getString(2131758814);
      localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131100685), str.length(), str.length() + ((String)localObject).length(), 33);
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
      this.rFX.setMovementMethod(LinkMovementMethod.getInstance());
      this.rFX.setText(localSpannableString);
      break;
      this.rFY.setImageResource(2131689800);
      this.rFi.setText(2131758793);
      this.rFj.setText(2131758777);
      break label72;
      this.rFY.setImageResource(2131689800);
      this.rFi.setText(2131758791);
      this.rFj.setText("");
      break label72;
      this.rFY.setImageResource(2131691800);
      this.rFi.setText(2131758793);
      this.rFj.setText(2131758788);
      break label72;
      this.rFW.setVisibility(0);
      this.mListView.setVisibility(0);
      this.rFX.setVisibility(0);
      this.rFY.setVisibility(8);
      this.rFi.setVisibility(8);
      this.rFj.setVisibility(8);
      AppMethodBeat.o(23934);
      return;
      this.lTw.setVisibility(8);
      this.rFW.setVisibility(8);
      this.mListView.setVisibility(8);
      this.rFX.setVisibility(8);
      this.rFY.setVisibility(0);
      this.rFi.setVisibility(0);
      if (paramInt == 4)
      {
        this.rFj.setVisibility(8);
        AppMethodBeat.o(23934);
        return;
      }
      this.rFj.setVisibility(0);
    }
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(23932);
    Object localObject = paramf.getKey();
    if (this.rFV.anP((String)localObject))
    {
      AppMethodBeat.o(23932);
      return;
    }
    Log.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.cLF());
    localObject = this.rFV;
    if ((paramf != null) && (!((a)localObject).anP(paramf.getKey())))
    {
      paramf.rGA = ((a)localObject).c(paramf);
      ((a)localObject).rGo.add(paramf);
    }
    this.rFV.notifyDataSetChanged();
    if (paramf.rGB == ExdeviceBindDeviceUI.b.rGt)
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.rGC.dfJ, this.rzn, this.rGb });
      bg.azz().a(new com.tencent.mm.plugin.exdevice.model.t(paramf.rGC.dfJ, this.rzn, this.rGb), 0);
      AppMethodBeat.o(23932);
      return;
    }
    if (paramf.rGB == ExdeviceBindDeviceUI.b.rGs)
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.rGD.mDeviceType, paramf.rGD.rzo });
      bg.azz().a(new v(paramf.rGD.mDeviceType, paramf.rGD.rzo, paramf.rGI), 0);
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
    return 2131494014;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23927);
    this.mListView = ((ListView)findViewById(2131303242));
    Object localObject = View.inflate(this, 2131494016, null);
    this.rFZ = View.inflate(this, 2131494049, null);
    this.rFW = this.rFZ.findViewById(2131307432);
    this.qbW = ((TextView)this.rFZ.findViewById(2131309168));
    this.rFX = ((TextView)findViewById(2131307228));
    this.rFY = ((ImageView)findViewById(2131303816));
    this.rFi = ((TextView)findViewById(2131300148));
    this.rFj = ((TextView)findViewById(2131300149));
    this.lTw = ((ScrollView)findViewById(2131299572));
    this.mListView.addHeaderView((View)localObject, null, false);
    this.mListView.addFooterView(this.rFZ, null, false);
    this.rFV = new a(this.rzn, this.rGa, this.rGb);
    this.mListView.setAdapter(this.rFV);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this).GC(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.rGF.fMf != 0) {
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
    if ((this.rGg) && (!this.rGf))
    {
      if (!com.tencent.mm.plugin.d.a.e.a.eL(getContext()))
      {
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        GA(4);
        AppMethodBeat.o(23927);
        return;
      }
      if (!com.tencent.mm.plugin.d.a.e.a.ckP())
      {
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        GA(3);
        AppMethodBeat.o(23927);
        return;
      }
    }
    if ((!this.rGg) && (this.rGf) && (!NetStatusUtil.isWifi(getContext())))
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
      GA(5);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.rGa == e.rGx)
    {
      GA(0);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.rGa == e.rGy)
    {
      if ((this.rGg) && (this.rGf))
      {
        Assert.assertTrue(false);
        GA(1);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.rGg)
      {
        GA(2);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.rGf)
      {
        GA(1);
        AppMethodBeat.o(23927);
      }
    }
    else
    {
      localObject = e.rGw;
      Assert.assertTrue(false);
    }
    AppMethodBeat.o(23927);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23933);
    this.rFV.cLE();
    this.rFV.notifyDataSetChanged();
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
    this.rGb = ((Intent)localObject).getStringExtra("device_category_id");
    this.rzn = ((Intent)localObject).getStringExtra("device_brand_name");
    this.mDeviceType = ((Intent)localObject).getStringExtra("device_type");
    if ((this.mDeviceType == null) || (this.mDeviceType.length() == 0)) {
      this.mDeviceType = this.rzn;
    }
    String str2 = ((Intent)localObject).getStringExtra("device_scan_conn_proto");
    String str3 = ((Intent)localObject).getStringExtra("device_scan_mode");
    paramBundle = "";
    String str1 = ((Intent)localObject).getStringExtra("device_title");
    localObject = str1;
    if (Util.isNullOrNil(str1)) {
      localObject = getContext().getString(2131758829);
    }
    if (str3.contains("SCAN_MY_DEVICE"))
    {
      this.rGa = e.rGx;
      paramBundle = getContext().getString(2131758767);
      setMMTitle(paramBundle);
      if (this.rGa != e.rGy) {
        break label425;
      }
      this.rGf = str2.contains("wifi");
      this.rGg = str2.contains("blue");
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.rGf), Boolean.valueOf(this.rGg) });
    }
    for (;;)
    {
      this.rAa = new j.a()
      {
        public final void h(int paramAnonymousInt, Object... paramAnonymousVarArgs)
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
              Log.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", localException1, "", new Object[0]);
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
            Log.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
            arrayOfObject2 = paramAnonymousVarArgs;
            localObject2 = localObject1;
            label151:
            paramAnonymousVarArgs = null;
            localObject1 = localObject2;
          }
          localObject2 = new ExdeviceBindDeviceUI.f(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).rGB = ExdeviceBindDeviceUI.b.rGs;
          ((ExdeviceBindDeviceUI.f)localObject2).rGD = new ExdeviceBindDeviceUI.d(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).rGD.mDeviceType = arrayOfObject2;
          ((ExdeviceBindDeviceUI.f)localObject2).rGD.rzo = ((String)localObject1);
          if (!Util.isNullOrNil(paramAnonymousVarArgs))
          {
            ((ExdeviceBindDeviceUI.f)localObject2).rGI = Base64.encodeToString(paramAnonymousVarArgs.getBytes(), 2);
            Log.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[] { ((ExdeviceBindDeviceUI.f)localObject2).rGI });
          }
          for (;;)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23895);
                ExdeviceBindDeviceUI.this.a(this.rGi);
                AppMethodBeat.o(23895);
              }
            });
            AppMethodBeat.o(23896);
            return;
            ((ExdeviceBindDeviceUI.f)localObject2).rGI = null;
          }
        }
      };
      this.rGe = new j.a()
      {
        public final void h(int paramAnonymousInt, Object... paramAnonymousVarArgs) {}
      };
      initView();
      this.qbW.setText(getContext().getString(2131758899, new Object[] { localObject }));
      bg.azz().a(1264, this);
      bg.azz().a(1706, this);
      bg.azz().a(1270, this);
      bg.azz().a(1719, this);
      if (this.rGg) {
        ad.cKW().a(this);
      }
      if (this.rGf)
      {
        j.cKC().a(10, this.rAa);
        j.cKC().a(11, this.rGe);
        Java2CExDevice.initWCLanDeviceLib();
      }
      AppMethodBeat.o(23925);
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.rGa = e.rGy;
        paramBundle = getContext().getString(2131758765);
        break;
      }
      Assert.assertTrue(false);
      break;
      label425:
      if (this.rGa == e.rGx)
      {
        this.rGg = true;
        this.rGf = true;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23929);
    super.onDestroy();
    if (this.rGf)
    {
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23898);
          Java2CExDevice.stopScanWCLanDevice();
          Java2CExDevice.releaseWCLanDeviceLib();
          AppMethodBeat.o(23898);
        }
      });
      j.cKC().b(10, this.rAa);
      j.cKC().b(11, this.rGe);
    }
    if (this.rGg)
    {
      ad.cKW().b(this);
      ad.cKX().stopScan();
    }
    bg.azz().b(1264, this);
    bg.azz().b(1706, this);
    bg.azz().b(1270, this);
    bg.azz().b(1719, this);
    AppMethodBeat.o(23929);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(23928);
    super.onPause();
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.rGf) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.rGg) {
      ad.cKX().stopScan();
    }
    AppMethodBeat.o(23928);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23926);
    super.onResume();
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.rGg)
    {
      ad.cKW();
      e.cKy();
    }
    if (this.rGf) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.rFV.cLE();
    this.rFV.notifyDataSetChanged();
    AppMethodBeat.o(23926);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(23931);
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq == null)
    {
      Log.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
      AppMethodBeat.o(23931);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23900);
        ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, paramInt1, paramInt2, paramString, paramq);
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
  
  public final void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23930);
    Log.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23930);
      return;
    }
    final f localf = new f((byte)0);
    localf.rGB = ExdeviceBindDeviceUI.b.rGt;
    localf.rGC = new c((byte)0);
    localf.rGC.rGv = paramString1;
    localf.rGC.dfJ = com.tencent.mm.plugin.exdevice.k.b.Dk(com.tencent.mm.plugin.exdevice.k.b.anY(paramString2));
    MMHandlerThread.postToMainThread(new Runnable()
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
  
  static final class a
    extends BaseAdapter
  {
    private c rFu;
    List<ExdeviceBindDeviceUI.f> rGo;
    private String rGp;
    private ExdeviceBindDeviceUI.e rGq;
    private String rGr;
    
    public a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
    {
      AppMethodBeat.i(23905);
      this.rGp = paramString1;
      this.rGq = parame;
      this.rGr = paramString2;
      this.rGo = new ArrayList();
      paramString1 = new c.a();
      paramString1.jbt = 2131101059;
      this.rFu = paramString1.bdv();
      AppMethodBeat.o(23905);
    }
    
    private int anR(String paramString)
    {
      AppMethodBeat.i(23913);
      int i = 0;
      while (i < this.rGo.size())
      {
        if (((ExdeviceBindDeviceUI.f)this.rGo.get(i)).getKey().compareTo(paramString) == 0)
        {
          AppMethodBeat.o(23913);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(23913);
      return -1;
    }
    
    private static boolean anS(String paramString)
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
    
    public final ExdeviceBindDeviceUI.f GC(int paramInt)
    {
      AppMethodBeat.i(23911);
      int j = -1;
      int i = 0;
      while (i < this.rGo.size())
      {
        int k = j;
        if (((ExdeviceBindDeviceUI.f)this.rGo.get(i)).rGA) {
          k = j + 1;
        }
        if (k == paramInt)
        {
          ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.rGo.get(i);
          AppMethodBeat.o(23911);
          return localf;
        }
        i += 1;
        j = k;
      }
      AppMethodBeat.o(23911);
      return null;
    }
    
    public final boolean anP(String paramString)
    {
      AppMethodBeat.i(23908);
      if (anR(paramString) >= 0)
      {
        AppMethodBeat.o(23908);
        return true;
      }
      AppMethodBeat.o(23908);
      return false;
    }
    
    public final ExdeviceBindDeviceUI.f anQ(String paramString)
    {
      AppMethodBeat.i(23909);
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(23909);
        return null;
      }
      int i = 0;
      while (i < this.rGo.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.rGo.get(i);
        if ((!anS(localf.cLF())) && (paramString.equalsIgnoreCase(localf.cLF())))
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
      if (anR(paramf.getKey()) < 0)
      {
        AppMethodBeat.o(23907);
        return false;
      }
      paramf.rGA = c(paramf);
      AppMethodBeat.o(23907);
      return true;
    }
    
    final boolean c(ExdeviceBindDeviceUI.f paramf)
    {
      AppMethodBeat.i(23915);
      if (paramf.rGF == null)
      {
        AppMethodBeat.o(23915);
        return false;
      }
      if (this.rGq == ExdeviceBindDeviceUI.e.rGy)
      {
        if ((paramf.rGF.MfY == null) || (paramf.rGF.MfY.compareTo(this.rGp) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
        if ((paramf.rGF.Mgh == null) || (paramf.rGF.Mgh.compareTo(this.rGr) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
      }
      else if (this.rGq == ExdeviceBindDeviceUI.e.rGx)
      {
        if (paramf.rGF.fMf == 0)
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
    
    final void cLE()
    {
      AppMethodBeat.i(23906);
      int i = 0;
      while (i < this.rGo.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.rGo.get(i);
        localf.rGA = c(localf);
        i += 1;
      }
      AppMethodBeat.o(23906);
    }
    
    final int ge(String paramString1, String paramString2)
    {
      AppMethodBeat.i(23914);
      int i = 0;
      while (i < this.rGo.size())
      {
        Object localObject = (ExdeviceBindDeviceUI.f)this.rGo.get(i);
        String str;
        if (((ExdeviceBindDeviceUI.f)localObject).rGE != null)
        {
          str = ((ExdeviceBindDeviceUI.f)localObject).rGE.KLO;
          if (((ExdeviceBindDeviceUI.f)localObject).rGE == null) {
            break label144;
          }
          localObject = ((ExdeviceBindDeviceUI.f)localObject).rGE.oTH;
        }
        for (;;)
        {
          if ((anS(str)) || (anS((String)localObject)) || (paramString1.compareTo(str) != 0) || (paramString2.compareTo((String)localObject) != 0)) {
            break label174;
          }
          AppMethodBeat.o(23914);
          return i;
          if (((ExdeviceBindDeviceUI.f)localObject).rGB == ExdeviceBindDeviceUI.b.rGs)
          {
            str = ((ExdeviceBindDeviceUI.f)localObject).rGD.mDeviceType;
            break;
          }
          str = null;
          break;
          label144:
          if (((ExdeviceBindDeviceUI.f)localObject).rGB == ExdeviceBindDeviceUI.b.rGs) {
            localObject = ((ExdeviceBindDeviceUI.f)localObject).rGD.rzo;
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
      for (int j = 0; i < this.rGo.size(); j = k)
      {
        k = j;
        if (((ExdeviceBindDeviceUI.f)this.rGo.get(i)).rGA) {
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
      ExdeviceBindDeviceUI.f localf = GC(paramInt);
      a locala;
      View localView;
      if (paramView == null)
      {
        locala = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131494013, null);
        locala.kgE = ((TextView)localView.findViewById(2131305210));
        locala.nnL = ((ImageView)localView.findViewById(2131302475));
        localView.setTag(locala);
      }
      while ((localf == null) || (localf.rGF == null))
      {
        Assert.assertTrue(false);
        AppMethodBeat.o(23912);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
      }
      Object localObject;
      if (localf.rGB == ExdeviceBindDeviceUI.b.rGt)
      {
        Log.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.rGC.rGv, localf.rGC.dfJ, localf.rGF.Mgf });
        localObject = "";
        paramView = localf.rGF.fMj;
        if ((paramView != null) && (paramView.length() >= 4))
        {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
          paramView = localf.rGF.Mgf + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100594)), localf.rGF.Mgf.length() + 1, paramView.length(), 17);
          locala.kgE.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        paramView = localf.rGF.IconUrl;
        if (!anS(paramView)) {
          com.tencent.mm.av.q.bcV().a(paramView, locala.nnL, this.rFu);
        }
        AppMethodBeat.o(23912);
        return localView;
        paramView = (View)localObject;
        if (localf.rGC.dfJ == null) {
          break;
        }
        paramView = (View)localObject;
        if (localf.rGC.dfJ.length() < 4) {
          break;
        }
        paramView = localf.rGC.dfJ;
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        break;
        if (localf.rGB == ExdeviceBindDeviceUI.b.rGs)
        {
          localObject = "";
          paramView = localf.rGF.fMj;
          if ((paramView != null) && (paramView.length() >= 4)) {
            paramView = paramView.substring(paramView.length() - 4, paramView.length());
          }
          for (;;)
          {
            paramView = localf.rGF.Mgf + " " + paramView;
            localObject = new SpannableString(paramView);
            ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100594)), localf.rGF.Mgf.length() + 1, paramView.length(), 17);
            locala.kgE.setText((CharSequence)localObject);
            break;
            paramView = (View)localObject;
            if (localf.rGF.KOS != null)
            {
              paramView = (View)localObject;
              if (localf.rGF.KOS.length() >= 4)
              {
                paramView = localf.rGF.KOS;
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
      TextView kgE;
      ImageView nnL;
    }
  }
  
  final class c
  {
    public String dfJ;
    public String rGv;
    
    private c() {}
  }
  
  final class d
  {
    public String mDeviceType;
    public String rzo;
    
    private d() {}
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(23923);
      rGw = new e("SCAN_ALL", 0);
      rGx = new e("SCAN_MY_DEVICE", 1);
      rGy = new e("SCAN_CATALOG", 2);
      rGz = new e[] { rGw, rGx, rGy };
      AppMethodBeat.o(23923);
    }
    
    private e() {}
  }
  
  final class f
  {
    public String rFJ;
    public boolean rGA = false;
    public ExdeviceBindDeviceUI.b rGB = ExdeviceBindDeviceUI.b.rGs;
    public ExdeviceBindDeviceUI.c rGC;
    public ExdeviceBindDeviceUI.d rGD;
    public cat rGE;
    public cau rGF;
    public int rGG;
    public cpl rGH;
    public String rGI;
    
    private f() {}
    
    public final String cLF()
    {
      if (this.rGB == ExdeviceBindDeviceUI.b.rGs)
      {
        if (this.rGF == null) {
          return null;
        }
        return this.rGF.KOS;
      }
      return this.rGC.dfJ;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(23924);
      if (this.rGB == ExdeviceBindDeviceUI.b.rGs)
      {
        str = this.rGD.mDeviceType + this.rGD.rzo;
        AppMethodBeat.o(23924);
        return str;
      }
      String str = this.rGC.dfJ;
      AppMethodBeat.o(23924);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */