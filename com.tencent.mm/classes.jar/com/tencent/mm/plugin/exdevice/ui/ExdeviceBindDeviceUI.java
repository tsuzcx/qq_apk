package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ah;
import com.tencent.mm.plugin.exdevice.model.g;
import com.tencent.mm.plugin.exdevice.model.g.b;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.l.a;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.dph;
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

public class ExdeviceBindDeviceUI
  extends MMActivity
  implements com.tencent.mm.am.h, g.b
{
  private ProgressDialog lzP;
  private String mDeviceType;
  private ListView mListView;
  private ScrollView pLK;
  private TextView wCr;
  private String yqR;
  private l.a yrD;
  private TextView yxv;
  private TextView yxw;
  private a yyh;
  private View yyi;
  private TextView yyj;
  private ImageView yyk;
  private View yyl;
  private e yym;
  private String yyn;
  private boolean yyo = false;
  private l.a yyp;
  private boolean yyq = false;
  private boolean yyr = false;
  
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
  
  private void Lh(int paramInt)
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
      String str = getString(R.l.gFC);
      Object localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(R.e.link_color), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23901);
          com.tencent.mm.plugin.exdevice.model.h.az(ExdeviceBindDeviceUI.this.getContext(), "http://" + WeChatHosts.domainString(R.l.host_o2o_gtimg_com) + "/mydevice/page/deviceHelp.html");
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
      this.yyj.setMovementMethod(LinkMovementMethod.getInstance());
      this.yyj.setText((CharSequence)localObject);
      break;
      str = getString(R.l.gFE);
      localObject = getString(R.l.gFD);
      SpannableString localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(R.e.link_color), str.length(), str.length() + ((String)localObject).length(), 33);
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
      this.yyj.setMovementMethod(LinkMovementMethod.getInstance());
      this.yyj.setText(localSpannableString);
      break;
      str = getString(R.l.gFF);
      localObject = getString(R.l.gji);
      localSpannableString = new SpannableString(str + (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(R.e.link_color), str.length(), str.length() + ((String)localObject).length(), 33);
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
      this.yyj.setMovementMethod(LinkMovementMethod.getInstance());
      this.yyj.setText(localSpannableString);
      break;
      this.yyk.setImageResource(R.k.bluetooth_logo);
      this.yxv.setText(R.l.gFL);
      this.yxw.setText(R.l.gFA);
      break label72;
      this.yyk.setImageResource(R.k.bluetooth_logo);
      this.yxv.setText(R.l.gFJ);
      this.yxw.setText("");
      break label72;
      this.yyk.setImageResource(R.k.wifi_logo);
      this.yxv.setText(R.l.gFL);
      this.yxw.setText(R.l.gFH);
      break label72;
      this.yyi.setVisibility(0);
      this.mListView.setVisibility(0);
      this.yyj.setVisibility(0);
      this.yyk.setVisibility(8);
      this.yxv.setVisibility(8);
      this.yxw.setVisibility(8);
      AppMethodBeat.o(23934);
      return;
      this.pLK.setVisibility(8);
      this.yyi.setVisibility(8);
      this.mListView.setVisibility(8);
      this.yyj.setVisibility(8);
      this.yyk.setVisibility(0);
      this.yxv.setVisibility(0);
      if (paramInt == 4)
      {
        this.yxw.setVisibility(8);
        AppMethodBeat.o(23934);
        return;
      }
      this.yxw.setVisibility(0);
    }
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(23932);
    Object localObject = paramf.getKey();
    if (this.yyh.apO((String)localObject))
    {
      AppMethodBeat.o(23932);
      return;
    }
    Log.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.dGN());
    localObject = this.yyh;
    if ((paramf != null) && (!((a)localObject).apO(paramf.getKey())))
    {
      paramf.yyL = ((a)localObject).c(paramf);
      ((a)localObject).yyz.add(paramf);
    }
    this.yyh.notifyDataSetChanged();
    if (paramf.yyM == ExdeviceBindDeviceUI.b.yyE)
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.yyN.vtX, this.yqR, this.yyn });
      bh.aZW().a(new w(paramf.yyN.vtX, this.yqR, this.yyn), 0);
      AppMethodBeat.o(23932);
      return;
    }
    if (paramf.yyM == ExdeviceBindDeviceUI.b.yyD)
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.yyO.mDeviceType, paramf.yyO.yqS });
      bh.aZW().a(new y(paramf.yyO.mDeviceType, paramf.yyO.yqS, paramf.yyT), 0);
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
    return R.i.gjf;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23927);
    this.mListView = ((ListView)findViewById(R.h.listview));
    Object localObject = View.inflate(this, R.i.gjh, null);
    this.yyl = View.inflate(this, R.i.gjN, null);
    this.yyi = this.yyl.findViewById(R.h.fVA);
    this.wCr = ((TextView)this.yyl.findViewById(R.h.tipsTV));
    this.yyj = ((TextView)findViewById(R.h.fVn));
    this.yyk = ((ImageView)findViewById(R.h.fNx));
    this.yxv = ((TextView)findViewById(R.h.fGM));
    this.yxw = ((TextView)findViewById(R.h.fGN));
    this.pLK = ((ScrollView)findViewById(R.h.fFa));
    this.mListView.addHeaderView((View)localObject, null, false);
    this.mListView.addFooterView(this.yyl, null, false);
    this.yyh = new a(this.yqR, this.yym, this.yyn);
    this.mListView.setAdapter(this.yyh);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this).Lj(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.yyQ.kDh != 0) {
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
    if ((this.yyr) && (!this.yyq))
    {
      if (!com.tencent.mm.plugin.g.a.e.a.fL(getContext()))
      {
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        Lh(4);
        AppMethodBeat.o(23927);
        return;
      }
      if (!com.tencent.mm.plugin.g.a.e.a.dbb())
      {
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        Lh(3);
        AppMethodBeat.o(23927);
        return;
      }
    }
    if ((!this.yyr) && (this.yyq) && (!NetStatusUtil.isWifi(getContext())))
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
      Lh(5);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.yym == e.yyI)
    {
      Lh(0);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.yym == e.yyJ)
    {
      if ((this.yyr) && (this.yyq))
      {
        Assert.assertTrue(false);
        Lh(1);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.yyr)
      {
        Lh(2);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.yyq)
      {
        Lh(1);
        AppMethodBeat.o(23927);
      }
    }
    else
    {
      localObject = e.yyH;
      Assert.assertTrue(false);
    }
    AppMethodBeat.o(23927);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23933);
    this.yyh.dGM();
    this.yyh.notifyDataSetChanged();
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
    this.yyn = ((Intent)localObject).getStringExtra("device_category_id");
    this.yqR = ((Intent)localObject).getStringExtra("device_brand_name");
    this.mDeviceType = ((Intent)localObject).getStringExtra("device_type");
    if ((this.mDeviceType == null) || (this.mDeviceType.length() == 0)) {
      this.mDeviceType = this.yqR;
    }
    String str2 = ((Intent)localObject).getStringExtra("device_scan_conn_proto");
    String str3 = ((Intent)localObject).getStringExtra("device_scan_mode");
    paramBundle = "";
    String str1 = ((Intent)localObject).getStringExtra("device_title");
    localObject = str1;
    if (Util.isNullOrNil(str1)) {
      localObject = getContext().getString(R.l.gGf);
    }
    if (str3.contains("SCAN_MY_DEVICE"))
    {
      this.yym = e.yyI;
      paramBundle = getContext().getString(R.l.gFw);
      setMMTitle(paramBundle);
      if (this.yym != e.yyJ) {
        break label426;
      }
      this.yyq = str2.contains("wifi");
      this.yyr = str2.contains("blue");
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.yyq), Boolean.valueOf(this.yyr) });
    }
    for (;;)
    {
      this.yrD = new l.a()
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
                  break label148;
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
                break label122;
              }
              localException1 = localException1;
              localObject1 = null;
              paramAnonymousVarArgs = null;
            }
            label122:
            Log.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
            arrayOfObject2 = paramAnonymousVarArgs;
            localObject2 = localObject1;
            label148:
            paramAnonymousVarArgs = null;
            localObject1 = localObject2;
          }
          localObject2 = new ExdeviceBindDeviceUI.f(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).yyM = ExdeviceBindDeviceUI.b.yyD;
          ((ExdeviceBindDeviceUI.f)localObject2).yyO = new ExdeviceBindDeviceUI.d(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).yyO.mDeviceType = arrayOfObject2;
          ((ExdeviceBindDeviceUI.f)localObject2).yyO.yqS = ((String)localObject1);
          if (!Util.isNullOrNil(paramAnonymousVarArgs))
          {
            ((ExdeviceBindDeviceUI.f)localObject2).yyT = Base64.encodeToString(paramAnonymousVarArgs.getBytes(), 2);
            Log.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[] { ((ExdeviceBindDeviceUI.f)localObject2).yyT });
          }
          for (;;)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23895);
                ExdeviceBindDeviceUI.this.a(this.yyt);
                AppMethodBeat.o(23895);
              }
            });
            AppMethodBeat.o(23896);
            return;
            ((ExdeviceBindDeviceUI.f)localObject2).yyT = null;
          }
        }
      };
      this.yyp = new l.a()
      {
        public final void h(int paramAnonymousInt, Object... paramAnonymousVarArgs) {}
      };
      initView();
      this.wCr.setText(getContext().getString(R.l.gGP, new Object[] { localObject }));
      bh.aZW().a(1264, this);
      bh.aZW().a(1706, this);
      bh.aZW().a(1270, this);
      bh.aZW().a(1719, this);
      if (this.yyr) {
        ah.dGc().a(this);
      }
      if (this.yyq)
      {
        l.dFF().a(10, this.yrD);
        l.dFF().a(11, this.yyp);
        Java2CExDevice.initWCLanDeviceLib();
      }
      AppMethodBeat.o(23925);
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.yym = e.yyJ;
        paramBundle = getContext().getString(R.l.gFu);
        break;
      }
      Assert.assertTrue(false);
      break;
      label426:
      if (this.yym == e.yyI)
      {
        this.yyr = true;
        this.yyq = true;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23929);
    super.onDestroy();
    if (this.yyq)
    {
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23898);
          Java2CExDevice.stopScanWCLanDevice();
          Java2CExDevice.releaseWCLanDeviceLib();
          AppMethodBeat.o(23898);
        }
      });
      l.dFF().b(10, this.yrD);
      l.dFF().b(11, this.yyp);
    }
    if (this.yyr)
    {
      ah.dGc().b(this);
      ah.dGd().daL();
    }
    bh.aZW().b(1264, this);
    bh.aZW().b(1706, this);
    bh.aZW().b(1270, this);
    bh.aZW().b(1719, this);
    AppMethodBeat.o(23929);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(23928);
    super.onPause();
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.yyq) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.yyr) {
      ah.dGd().daL();
    }
    AppMethodBeat.o(23928);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23926);
    super.onResume();
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.yyr)
    {
      ah.dGc();
      g.dFA();
    }
    if (this.yyq) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.yyh.dGM();
    this.yyh.notifyDataSetChanged();
    AppMethodBeat.o(23926);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(23931);
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp == null)
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
        ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, paramInt1, paramInt2, paramString, paramp);
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
  
  public final void t(String paramString1, String paramString2, boolean paramBoolean)
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
    localf.yyM = ExdeviceBindDeviceUI.b.yyE;
    localf.yyN = new c((byte)0);
    localf.yyN.yyG = paramString1;
    localf.yyN.vtX = com.tencent.mm.plugin.exdevice.k.b.lP(com.tencent.mm.plugin.exdevice.k.b.apW(paramString2));
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
    private c yxG;
    private String yyA;
    private ExdeviceBindDeviceUI.e yyB;
    private String yyC;
    List<ExdeviceBindDeviceUI.f> yyz;
    
    public a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
    {
      AppMethodBeat.i(23905);
      this.yyA = paramString1;
      this.yyB = parame;
      this.yyC = paramString2;
      this.yyz = new ArrayList();
      paramString1 = new c.a();
      paramString1.oKE = R.e.settings_bg;
      this.yxG = paramString1.bKx();
      AppMethodBeat.o(23905);
    }
    
    private int apP(String paramString)
    {
      AppMethodBeat.i(23913);
      int i = 0;
      while (i < this.yyz.size())
      {
        if (((ExdeviceBindDeviceUI.f)this.yyz.get(i)).getKey().compareTo(paramString) == 0)
        {
          AppMethodBeat.o(23913);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(23913);
      return -1;
    }
    
    static boolean apQ(String paramString)
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
    
    public final ExdeviceBindDeviceUI.f Lj(int paramInt)
    {
      AppMethodBeat.i(23911);
      int j = -1;
      int i = 0;
      while (i < this.yyz.size())
      {
        int k = j;
        if (((ExdeviceBindDeviceUI.f)this.yyz.get(i)).yyL) {
          k = j + 1;
        }
        if (k == paramInt)
        {
          ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.yyz.get(i);
          AppMethodBeat.o(23911);
          return localf;
        }
        i += 1;
        j = k;
      }
      AppMethodBeat.o(23911);
      return null;
    }
    
    public final boolean apO(String paramString)
    {
      AppMethodBeat.i(23908);
      if (apP(paramString) >= 0)
      {
        AppMethodBeat.o(23908);
        return true;
      }
      AppMethodBeat.o(23908);
      return false;
    }
    
    public final boolean b(ExdeviceBindDeviceUI.f paramf)
    {
      AppMethodBeat.i(23907);
      if (apP(paramf.getKey()) < 0)
      {
        AppMethodBeat.o(23907);
        return false;
      }
      paramf.yyL = c(paramf);
      AppMethodBeat.o(23907);
      return true;
    }
    
    final boolean c(ExdeviceBindDeviceUI.f paramf)
    {
      AppMethodBeat.i(23915);
      if (paramf.yyQ == null)
      {
        AppMethodBeat.o(23915);
        return false;
      }
      if (this.yyB == ExdeviceBindDeviceUI.e.yyJ)
      {
        if ((paramf.yyQ.aaDM == null) || (paramf.yyQ.aaDM.compareTo(this.yyA) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
        if ((paramf.yyQ.aaDV == null) || (paramf.yyQ.aaDV.compareTo(this.yyC) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
      }
      else if (this.yyB == ExdeviceBindDeviceUI.e.yyI)
      {
        if (paramf.yyQ.kDh == 0)
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
    
    final void dGM()
    {
      AppMethodBeat.i(23906);
      int i = 0;
      while (i < this.yyz.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.yyz.get(i);
        localf.yyL = c(localf);
        i += 1;
      }
      AppMethodBeat.o(23906);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(23910);
      int i = 0;
      int k;
      for (int j = 0; i < this.yyz.size(); j = k)
      {
        k = j;
        if (((ExdeviceBindDeviceUI.f)this.yyz.get(i)).yyL) {
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
      ExdeviceBindDeviceUI.f localf = Lj(paramInt);
      a locala;
      View localView;
      if (paramView == null)
      {
        locala = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), R.i.gje, null);
        locala.pUL = ((TextView)localView.findViewById(R.h.fOX));
        locala.ttT = ((ImageView)localView.findViewById(R.h.iconIV));
        localView.setTag(locala);
      }
      while ((localf == null) || (localf.yyQ == null))
      {
        Assert.assertTrue(false);
        AppMethodBeat.o(23912);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
      }
      Object localObject;
      if (localf.yyM == ExdeviceBindDeviceUI.b.yyE)
      {
        Log.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.yyN.yyG, localf.yyN.vtX, localf.yyQ.aaDT });
        localObject = "";
        paramView = localf.yyQ.kDl;
        if ((paramView != null) && (paramView.length() >= 4))
        {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
          paramView = localf.yyQ.aaDT + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(R.e.hint_text_color)), localf.yyQ.aaDT.length() + 1, paramView.length(), 17);
          locala.pUL.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        paramView = localf.yyQ.IHo;
        if (!apQ(paramView)) {
          r.bKe().a(paramView, locala.ttT, this.yxG);
        }
        AppMethodBeat.o(23912);
        return localView;
        paramView = (View)localObject;
        if (localf.yyN.vtX == null) {
          break;
        }
        paramView = (View)localObject;
        if (localf.yyN.vtX.length() < 4) {
          break;
        }
        paramView = localf.yyN.vtX;
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        break;
        if (localf.yyM == ExdeviceBindDeviceUI.b.yyD)
        {
          localObject = "";
          paramView = localf.yyQ.kDl;
          if ((paramView != null) && (paramView.length() >= 4)) {
            paramView = paramView.substring(paramView.length() - 4, paramView.length());
          }
          for (;;)
          {
            paramView = localf.yyQ.aaDT + " " + paramView;
            localObject = new SpannableString(paramView);
            ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(R.e.hint_text_color)), localf.yyQ.aaDT.length() + 1, paramView.length(), 17);
            locala.pUL.setText((CharSequence)localObject);
            break;
            paramView = (View)localObject;
            if (localf.yyQ.YNe != null)
            {
              paramView = (View)localObject;
              if (localf.yyQ.YNe.length() >= 4)
              {
                paramView = localf.yyQ.YNe;
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
      TextView pUL;
      ImageView ttT;
    }
  }
  
  final class c
  {
    public String vtX;
    public String yyG;
    
    private c() {}
  }
  
  final class d
  {
    public String mDeviceType;
    public String yqS;
    
    private d() {}
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(23923);
      yyH = new e("SCAN_ALL", 0);
      yyI = new e("SCAN_MY_DEVICE", 1);
      yyJ = new e("SCAN_CATALOG", 2);
      yyK = new e[] { yyH, yyI, yyJ };
      AppMethodBeat.o(23923);
    }
    
    private e() {}
  }
  
  final class f
  {
    public String yxV;
    public boolean yyL = false;
    public ExdeviceBindDeviceUI.b yyM = ExdeviceBindDeviceUI.b.yyD;
    public ExdeviceBindDeviceUI.c yyN;
    public ExdeviceBindDeviceUI.d yyO;
    public cyx yyP;
    public cyy yyQ;
    public int yyR;
    public dph yyS;
    public String yyT;
    
    private f() {}
    
    public final String dGN()
    {
      if (this.yyM == ExdeviceBindDeviceUI.b.yyD)
      {
        if (this.yyQ == null) {
          return null;
        }
        return this.yyQ.YNe;
      }
      return this.yyN.vtX;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(23924);
      if (this.yyM == ExdeviceBindDeviceUI.b.yyD)
      {
        str = this.yyO.mDeviceType + this.yyO.yqS;
        AppMethodBeat.o(23924);
        return str;
      }
      String str = this.yyN.vtX;
      AppMethodBeat.o(23924);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */