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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI
  extends MMActivity
  implements com.tencent.mm.ak.f, e.b
{
  private ProgressDialog fOC;
  private ScrollView kOy;
  private String mDeviceType;
  private ListView mListView;
  private TextView oOi;
  private String qir;
  private j.a qje;
  private a qoO;
  private View qoP;
  private TextView qoQ;
  private ImageView qoR;
  private View qoS;
  private ExdeviceBindDeviceUI.e qoT;
  private String qoU;
  private String qoV;
  private boolean qoW = false;
  private j.a qoX;
  private boolean qoY = false;
  private boolean qoZ = false;
  private TextView qob;
  private TextView qoc;
  
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
  
  private void CP(int paramInt)
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
          com.tencent.mm.plugin.exdevice.model.f.ap(ExdeviceBindDeviceUI.this.getContext(), "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
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
      this.qoQ.setMovementMethod(LinkMovementMethod.getInstance());
      this.qoQ.setText((CharSequence)localObject);
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
      this.qoQ.setMovementMethod(LinkMovementMethod.getInstance());
      this.qoQ.setText(localSpannableString);
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
      this.qoQ.setMovementMethod(LinkMovementMethod.getInstance());
      this.qoQ.setText(localSpannableString);
      break;
      this.qoR.setImageResource(2131689789);
      this.qob.setText(2131758494);
      this.qoc.setText(2131758478);
      break label72;
      this.qoR.setImageResource(2131689789);
      this.qob.setText(2131758492);
      this.qoc.setText("");
      break label72;
      this.qoR.setImageResource(2131691457);
      this.qob.setText(2131758494);
      this.qoc.setText(2131758489);
      break label72;
      this.qoP.setVisibility(0);
      this.mListView.setVisibility(0);
      this.qoQ.setVisibility(0);
      this.qoR.setVisibility(8);
      this.qob.setVisibility(8);
      this.qoc.setVisibility(8);
      AppMethodBeat.o(23934);
      return;
      this.kOy.setVisibility(8);
      this.qoP.setVisibility(8);
      this.mListView.setVisibility(8);
      this.qoQ.setVisibility(8);
      this.qoR.setVisibility(0);
      this.qob.setVisibility(0);
      if (paramInt == 4)
      {
        this.qoc.setVisibility(8);
        AppMethodBeat.o(23934);
        return;
      }
      this.qoc.setVisibility(0);
    }
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(23932);
    Object localObject = paramf.getKey();
    if (this.qoO.adG((String)localObject))
    {
      AppMethodBeat.o(23932);
      return;
    }
    ae.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.cns());
    localObject = this.qoO;
    if ((paramf != null) && (!((a)localObject).adG(paramf.getKey())))
    {
      paramf.qpt = ((a)localObject).c(paramf);
      ((a)localObject).qph.add(paramf);
    }
    this.qoO.notifyDataSetChanged();
    if (paramf.qpu == ExdeviceBindDeviceUI.b.qpm)
    {
      ae.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.qpv.cPk, this.qir, this.qoU });
      bc.ajj().a(new t(paramf.qpv.cPk, this.qir, this.qoU), 0);
      AppMethodBeat.o(23932);
      return;
    }
    if (paramf.qpu == ExdeviceBindDeviceUI.b.qpl)
    {
      ae.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.qpw.mDeviceType, paramf.qpw.qis });
      bc.ajj().a(new v(paramf.qpw.mDeviceType, paramf.qpw.qis, paramf.qpB), 0);
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
    this.qoS = View.inflate(this, 2131493893, null);
    this.qoP = this.qoS.findViewById(2131304456);
    this.oOi = ((TextView)this.qoS.findViewById(2131305885));
    this.qoQ = ((TextView)findViewById(2131304300));
    this.qoR = ((ImageView)findViewById(2131301586));
    this.qob = ((TextView)findViewById(2131299511));
    this.qoc = ((TextView)findViewById(2131299512));
    this.kOy = ((ScrollView)findViewById(2131299066));
    this.mListView.addHeaderView((View)localObject, null, false);
    this.mListView.addFooterView(this.qoS, null, false);
    this.qoO = new a(this.qir, this.qoT, this.qoU);
    this.mListView.setAdapter(this.qoO);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this).CR(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.qpy.fhC != 0) {
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
    if ((this.qoZ) && (!this.qoY))
    {
      if (!com.tencent.mm.plugin.d.a.e.a.et(getContext()))
      {
        ae.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        CP(4);
        AppMethodBeat.o(23927);
        return;
      }
      if (!com.tencent.mm.plugin.d.a.e.a.bNP())
      {
        ae.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        CP(3);
        AppMethodBeat.o(23927);
        return;
      }
    }
    if ((!this.qoZ) && (this.qoY) && (!az.isWifi(getContext())))
    {
      ae.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
      CP(5);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.qoT == ExdeviceBindDeviceUI.e.qpq)
    {
      CP(0);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.qoT == ExdeviceBindDeviceUI.e.qpr)
    {
      if ((this.qoZ) && (this.qoY))
      {
        Assert.assertTrue(false);
        CP(1);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.qoZ)
      {
        CP(2);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.qoY)
      {
        CP(1);
        AppMethodBeat.o(23927);
      }
    }
    else
    {
      localObject = ExdeviceBindDeviceUI.e.qpp;
      Assert.assertTrue(false);
    }
    AppMethodBeat.o(23927);
  }
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23930);
    ae.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    if (bu.isNullOrNil(paramString2))
    {
      ae.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(23930);
      return;
    }
    final f localf = new f((byte)0);
    localf.qpu = ExdeviceBindDeviceUI.b.qpm;
    localf.qpv = new c((byte)0);
    localf.qpv.qpo = paramString1;
    localf.qpv.cPk = com.tencent.mm.plugin.exdevice.k.b.vg(com.tencent.mm.plugin.exdevice.k.b.adP(paramString2));
    ar.f(new Runnable()
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
    this.qoO.cnr();
    this.qoO.notifyDataSetChanged();
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
    this.qoU = ((Intent)localObject).getStringExtra("device_category_id");
    this.qir = ((Intent)localObject).getStringExtra("device_brand_name");
    this.mDeviceType = ((Intent)localObject).getStringExtra("device_type");
    if ((this.mDeviceType == null) || (this.mDeviceType.length() == 0)) {
      this.mDeviceType = this.qir;
    }
    String str2 = ((Intent)localObject).getStringExtra("device_scan_conn_proto");
    String str3 = ((Intent)localObject).getStringExtra("device_scan_mode");
    paramBundle = "";
    String str1 = ((Intent)localObject).getStringExtra("device_title");
    localObject = str1;
    if (bu.isNullOrNil(str1)) {
      localObject = getContext().getString(2131758530);
    }
    if (str3.contains("SCAN_MY_DEVICE"))
    {
      this.qoT = ExdeviceBindDeviceUI.e.qpq;
      paramBundle = getContext().getString(2131758468);
      setMMTitle(paramBundle);
      if (this.qoT != ExdeviceBindDeviceUI.e.qpr) {
        break label425;
      }
      this.qoY = str2.contains("wifi");
      this.qoZ = str2.contains("blue");
      ae.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.qoY), Boolean.valueOf(this.qoZ) });
    }
    for (;;)
    {
      this.qje = new j.a()
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
              ae.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", localException1, "", new Object[0]);
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
            ae.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
            arrayOfObject2 = paramAnonymousVarArgs;
            localObject2 = localObject1;
            label151:
            paramAnonymousVarArgs = null;
            localObject1 = localObject2;
          }
          localObject2 = new ExdeviceBindDeviceUI.f(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).qpu = ExdeviceBindDeviceUI.b.qpl;
          ((ExdeviceBindDeviceUI.f)localObject2).qpw = new ExdeviceBindDeviceUI.d(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).qpw.mDeviceType = arrayOfObject2;
          ((ExdeviceBindDeviceUI.f)localObject2).qpw.qis = ((String)localObject1);
          if (!bu.isNullOrNil(paramAnonymousVarArgs))
          {
            ((ExdeviceBindDeviceUI.f)localObject2).qpB = Base64.encodeToString(paramAnonymousVarArgs.getBytes(), 2);
            ae.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[] { ((ExdeviceBindDeviceUI.f)localObject2).qpB });
          }
          for (;;)
          {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23895);
                ExdeviceBindDeviceUI.this.a(this.qpb);
                AppMethodBeat.o(23895);
              }
            });
            AppMethodBeat.o(23896);
            return;
            ((ExdeviceBindDeviceUI.f)localObject2).qpB = null;
          }
        }
      };
      this.qoX = new j.a()
      {
        public final void g(int paramAnonymousInt, Object... paramAnonymousVarArgs) {}
      };
      initView();
      this.oOi.setText(getContext().getString(2131758598, new Object[] { localObject }));
      bc.ajj().a(1264, this);
      bc.ajj().a(1706, this);
      bc.ajj().a(1270, this);
      bc.ajj().a(1719, this);
      if (this.qoZ) {
        ad.cmU().a(this);
      }
      if (this.qoY)
      {
        j.cmA().a(10, this.qje);
        j.cmA().a(11, this.qoX);
        Java2CExDevice.initWCLanDeviceLib();
      }
      AppMethodBeat.o(23925);
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.qoT = ExdeviceBindDeviceUI.e.qpr;
        paramBundle = getContext().getString(2131758466);
        break;
      }
      Assert.assertTrue(false);
      break;
      label425:
      if (this.qoT == ExdeviceBindDeviceUI.e.qpq)
      {
        this.qoZ = true;
        this.qoY = true;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23929);
    super.onDestroy();
    if (this.qoY)
    {
      bc.ajU().aw(new ExdeviceBindDeviceUI.6(this));
      j.cmA().b(10, this.qje);
      j.cmA().b(11, this.qoX);
    }
    if (this.qoZ)
    {
      ad.cmU().b(this);
      ad.cmV().stopScan();
    }
    bc.ajj().b(1264, this);
    bc.ajj().b(1706, this);
    bc.ajj().b(1270, this);
    bc.ajj().b(1719, this);
    AppMethodBeat.o(23929);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(23928);
    super.onPause();
    ae.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.qoY) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.qoZ) {
      ad.cmV().stopScan();
    }
    AppMethodBeat.o(23928);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23926);
    super.onResume();
    ae.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.qoZ)
    {
      ad.cmU();
      e.cmw();
    }
    if (this.qoY) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.qoO.cnr();
    this.qoO.notifyDataSetChanged();
    AppMethodBeat.o(23926);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(23931);
    ae.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn == null)
    {
      ae.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
      AppMethodBeat.o(23931);
      return;
    }
    ar.f(new Runnable()
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
    private c qon;
    List<ExdeviceBindDeviceUI.f> qph;
    private String qpi;
    private ExdeviceBindDeviceUI.e qpj;
    private String qpk;
    
    public a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
    {
      AppMethodBeat.i(23905);
      this.qpi = paramString1;
      this.qpj = parame;
      this.qpk = paramString2;
      this.qph = new ArrayList();
      paramString1 = new c.a();
      paramString1.igy = 2131100860;
      this.qon = paramString1.aJu();
      AppMethodBeat.o(23905);
    }
    
    private int adI(String paramString)
    {
      AppMethodBeat.i(23913);
      int i = 0;
      while (i < this.qph.size())
      {
        if (((ExdeviceBindDeviceUI.f)this.qph.get(i)).getKey().compareTo(paramString) == 0)
        {
          AppMethodBeat.o(23913);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(23913);
      return -1;
    }
    
    private static boolean adJ(String paramString)
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
    
    public final ExdeviceBindDeviceUI.f CR(int paramInt)
    {
      AppMethodBeat.i(23911);
      int j = -1;
      int i = 0;
      while (i < this.qph.size())
      {
        int k = j;
        if (((ExdeviceBindDeviceUI.f)this.qph.get(i)).qpt) {
          k = j + 1;
        }
        if (k == paramInt)
        {
          ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.qph.get(i);
          AppMethodBeat.o(23911);
          return localf;
        }
        i += 1;
        j = k;
      }
      AppMethodBeat.o(23911);
      return null;
    }
    
    public final boolean adG(String paramString)
    {
      AppMethodBeat.i(23908);
      if (adI(paramString) >= 0)
      {
        AppMethodBeat.o(23908);
        return true;
      }
      AppMethodBeat.o(23908);
      return false;
    }
    
    public final ExdeviceBindDeviceUI.f adH(String paramString)
    {
      AppMethodBeat.i(23909);
      if ((paramString == null) || (paramString.length() == 0))
      {
        AppMethodBeat.o(23909);
        return null;
      }
      int i = 0;
      while (i < this.qph.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.qph.get(i);
        if ((!adJ(localf.cns())) && (paramString.equalsIgnoreCase(localf.cns())))
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
      if (adI(paramf.getKey()) < 0)
      {
        AppMethodBeat.o(23907);
        return false;
      }
      paramf.qpt = c(paramf);
      AppMethodBeat.o(23907);
      return true;
    }
    
    final boolean c(ExdeviceBindDeviceUI.f paramf)
    {
      AppMethodBeat.i(23915);
      if (paramf.qpy == null)
      {
        AppMethodBeat.o(23915);
        return false;
      }
      if (this.qpj == ExdeviceBindDeviceUI.e.qpr)
      {
        if ((paramf.qpy.HaX == null) || (paramf.qpy.HaX.compareTo(this.qpi) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
        if ((paramf.qpy.Hbg == null) || (paramf.qpy.Hbg.compareTo(this.qpk) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
      }
      else if (this.qpj == ExdeviceBindDeviceUI.e.qpq)
      {
        if (paramf.qpy.fhC == 0)
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
    
    final void cnr()
    {
      AppMethodBeat.i(23906);
      int i = 0;
      while (i < this.qph.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.qph.get(i);
        localf.qpt = c(localf);
        i += 1;
      }
      AppMethodBeat.o(23906);
    }
    
    final int fL(String paramString1, String paramString2)
    {
      AppMethodBeat.i(23914);
      int i = 0;
      while (i < this.qph.size())
      {
        Object localObject = (ExdeviceBindDeviceUI.f)this.qph.get(i);
        String str;
        if (((ExdeviceBindDeviceUI.f)localObject).qpx != null)
        {
          str = ((ExdeviceBindDeviceUI.f)localObject).qpx.FSh;
          if (((ExdeviceBindDeviceUI.f)localObject).qpx == null) {
            break label144;
          }
          localObject = ((ExdeviceBindDeviceUI.f)localObject).qpx.nIM;
        }
        for (;;)
        {
          if ((adJ(str)) || (adJ((String)localObject)) || (paramString1.compareTo(str) != 0) || (paramString2.compareTo((String)localObject) != 0)) {
            break label174;
          }
          AppMethodBeat.o(23914);
          return i;
          if (((ExdeviceBindDeviceUI.f)localObject).qpu == ExdeviceBindDeviceUI.b.qpl)
          {
            str = ((ExdeviceBindDeviceUI.f)localObject).qpw.mDeviceType;
            break;
          }
          str = null;
          break;
          label144:
          if (((ExdeviceBindDeviceUI.f)localObject).qpu == ExdeviceBindDeviceUI.b.qpl) {
            localObject = ((ExdeviceBindDeviceUI.f)localObject).qpw.qis;
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
      for (int j = 0; i < this.qph.size(); j = k)
      {
        k = j;
        if (((ExdeviceBindDeviceUI.f)this.qph.get(i)).qpt) {
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
      ExdeviceBindDeviceUI.f localf = CR(paramInt);
      a locala;
      View localView;
      if (paramView == null)
      {
        locala = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), 2131493857, null);
        locala.jiC = ((TextView)localView.findViewById(2131302656));
        locala.mdt = ((ImageView)localView.findViewById(2131300880));
        localView.setTag(locala);
      }
      while ((localf == null) || (localf.qpy == null))
      {
        Assert.assertTrue(false);
        AppMethodBeat.o(23912);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
      }
      Object localObject;
      if (localf.qpu == ExdeviceBindDeviceUI.b.qpm)
      {
        ae.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.qpv.qpo, localf.qpv.cPk, localf.qpy.Hbe });
        localObject = "";
        paramView = localf.qpy.fhG;
        if ((paramView != null) && (paramView.length() >= 4))
        {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
          paramView = localf.qpy.Hbe + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100490)), localf.qpy.Hbe.length() + 1, paramView.length(), 17);
          locala.jiC.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        paramView = localf.qpy.IconUrl;
        if (!adJ(paramView)) {
          com.tencent.mm.av.q.aJb().a(paramView, locala.mdt, this.qon);
        }
        AppMethodBeat.o(23912);
        return localView;
        paramView = (View)localObject;
        if (localf.qpv.cPk == null) {
          break;
        }
        paramView = (View)localObject;
        if (localf.qpv.cPk.length() < 4) {
          break;
        }
        paramView = localf.qpv.cPk;
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        break;
        if (localf.qpu == ExdeviceBindDeviceUI.b.qpl)
        {
          localObject = "";
          paramView = localf.qpy.fhG;
          if ((paramView != null) && (paramView.length() >= 4)) {
            paramView = paramView.substring(paramView.length() - 4, paramView.length());
          }
          for (;;)
          {
            paramView = localf.qpy.Hbe + " " + paramView;
            localObject = new SpannableString(paramView);
            ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(2131100490)), localf.qpy.Hbe.length() + 1, paramView.length(), 17);
            locala.jiC.setText((CharSequence)localObject);
            break;
            paramView = (View)localObject;
            if (localf.qpy.FVh != null)
            {
              paramView = (View)localObject;
              if (localf.qpy.FVh.length() >= 4)
              {
                paramView = localf.qpy.FVh;
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
      TextView jiC;
      ImageView mdt;
    }
  }
  
  final class c
  {
    public String cPk;
    public String qpo;
    
    private c() {}
  }
  
  final class d
  {
    public String mDeviceType;
    public String qis;
    
    private d() {}
  }
  
  final class f
  {
    public String qoC;
    public caj qpA;
    public String qpB;
    public boolean qpt = false;
    public ExdeviceBindDeviceUI.b qpu = ExdeviceBindDeviceUI.b.qpl;
    public ExdeviceBindDeviceUI.c qpv;
    public ExdeviceBindDeviceUI.d qpw;
    public bob qpx;
    public boc qpy;
    public int qpz;
    
    private f() {}
    
    public final String cns()
    {
      if (this.qpu == ExdeviceBindDeviceUI.b.qpl)
      {
        if (this.qpy == null) {
          return null;
        }
        return this.qpy.FVh;
      }
      return this.qpv.cPk;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(23924);
      if (this.qpu == ExdeviceBindDeviceUI.b.qpl)
      {
        str = this.qpw.mDeviceType + this.qpw.qis;
        AppMethodBeat.o(23924);
        return str;
      }
      String str = this.qpv.cPk;
      AppMethodBeat.o(23924);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */