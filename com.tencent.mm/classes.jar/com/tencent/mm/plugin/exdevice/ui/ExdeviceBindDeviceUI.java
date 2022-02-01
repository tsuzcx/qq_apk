package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.u;
import com.tencent.mm.plugin.exdevice.model.w;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cyb;
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
  private ProgressDialog iXX;
  private String mDeviceType;
  private ListView mListView;
  private ScrollView mPe;
  private TextView txU;
  private String veU;
  private j.a vfH;
  private TextView vkS;
  private TextView vkT;
  private a vlF;
  private View vlG;
  private TextView vlH;
  private ImageView vlI;
  private View vlJ;
  private e vlK;
  private String vlL;
  private boolean vlM = false;
  private j.a vlN;
  private boolean vlO = false;
  private boolean vlP = false;
  
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
  
  private void Ki(int paramInt)
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
      String str = getString(R.l.eCO);
      Object localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(R.e.link_color), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23901);
          f.ay(ExdeviceBindDeviceUI.this.getContext(), "http://" + WeChatHosts.domainString(R.l.host_o2o_gtimg_com) + "/mydevice/page/deviceHelp.html");
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
      this.vlH.setMovementMethod(LinkMovementMethod.getInstance());
      this.vlH.setText((CharSequence)localObject);
      break;
      str = getString(R.l.eCQ);
      localObject = getString(R.l.eCP);
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
      this.vlH.setMovementMethod(LinkMovementMethod.getInstance());
      this.vlH.setText(localSpannableString);
      break;
      str = getString(R.l.eCR);
      localObject = getString(R.l.egp);
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
      this.vlH.setMovementMethod(LinkMovementMethod.getInstance());
      this.vlH.setText(localSpannableString);
      break;
      this.vlI.setImageResource(R.k.bluetooth_logo);
      this.vkS.setText(R.l.eCX);
      this.vkT.setText(R.l.eCM);
      break label72;
      this.vlI.setImageResource(R.k.bluetooth_logo);
      this.vkS.setText(R.l.eCV);
      this.vkT.setText("");
      break label72;
      this.vlI.setImageResource(R.k.wifi_logo);
      this.vkS.setText(R.l.eCX);
      this.vkT.setText(R.l.eCT);
      break label72;
      this.vlG.setVisibility(0);
      this.mListView.setVisibility(0);
      this.vlH.setVisibility(0);
      this.vlI.setVisibility(8);
      this.vkS.setVisibility(8);
      this.vkT.setVisibility(8);
      AppMethodBeat.o(23934);
      return;
      this.mPe.setVisibility(8);
      this.vlG.setVisibility(8);
      this.mListView.setVisibility(8);
      this.vlH.setVisibility(8);
      this.vlI.setVisibility(0);
      this.vkS.setVisibility(0);
      if (paramInt == 4)
      {
        this.vkT.setVisibility(8);
        AppMethodBeat.o(23934);
        return;
      }
      this.vkT.setVisibility(0);
    }
  }
  
  final void a(f paramf)
  {
    AppMethodBeat.i(23932);
    Object localObject = paramf.getKey();
    if (this.vlF.avO((String)localObject))
    {
      AppMethodBeat.o(23932);
      return;
    }
    Log.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + paramf.das());
    localObject = this.vlF;
    if ((paramf != null) && (!((a)localObject).avO(paramf.getKey())))
    {
      paramf.vmj = ((a)localObject).c(paramf);
      ((a)localObject).vlX.add(paramf);
    }
    this.vlF.notifyDataSetChanged();
    if (paramf.vmk == ExdeviceBindDeviceUI.b.vmc)
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[] { paramf.vml.shW, this.veU, this.vlL });
      bh.aGY().a(new u(paramf.vml.shW, this.veU, this.vlL), 0);
      AppMethodBeat.o(23932);
      return;
    }
    if (paramf.vmk == ExdeviceBindDeviceUI.b.vmb)
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[] { paramf.vmm.mDeviceType, paramf.vmm.veV });
      bh.aGY().a(new w(paramf.vmm.mDeviceType, paramf.vmm.veV, paramf.vmr), 0);
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
    return R.i.egm;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23927);
    this.mListView = ((ListView)findViewById(R.h.listview));
    Object localObject = View.inflate(this, R.i.ego, null);
    this.vlJ = View.inflate(this, R.i.egR, null);
    this.vlG = this.vlJ.findViewById(R.h.dTt);
    this.txU = ((TextView)this.vlJ.findViewById(R.h.dXu));
    this.vlH = ((TextView)findViewById(R.h.dTf));
    this.vlI = ((ImageView)findViewById(R.h.dLP));
    this.vkS = ((TextView)findViewById(R.h.dFG));
    this.vkT = ((TextView)findViewById(R.h.dFH));
    this.mPe = ((ScrollView)findViewById(R.h.dEh));
    this.mListView.addHeaderView((View)localObject, null, false);
    this.mListView.addFooterView(this.vlJ, null, false);
    this.vlF = new a(this.veU, this.vlK, this.vlL);
    this.mListView.setAdapter(this.vlF);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(23897);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceBindDeviceUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        int i = ((ListView)paramAnonymousAdapterView).getHeaderViewsCount();
        paramAnonymousAdapterView = ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this).Kk(paramAnonymousInt - i);
        if (paramAnonymousAdapterView.vmo.idX != 0) {
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
    if ((this.vlP) && (!this.vlO))
    {
      if (!com.tencent.mm.plugin.f.a.e.a.eP(getContext()))
      {
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
        Ki(4);
        AppMethodBeat.o(23927);
        return;
      }
      if (!com.tencent.mm.plugin.f.a.e.a.cyk())
      {
        Log.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
        Ki(3);
        AppMethodBeat.o(23927);
        return;
      }
    }
    if ((!this.vlP) && (this.vlO) && (!NetStatusUtil.isWifi(getContext())))
    {
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
      Ki(5);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.vlK == e.vmg)
    {
      Ki(0);
      AppMethodBeat.o(23927);
      return;
    }
    if (this.vlK == e.vmh)
    {
      if ((this.vlP) && (this.vlO))
      {
        Assert.assertTrue(false);
        Ki(1);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.vlP)
      {
        Ki(2);
        AppMethodBeat.o(23927);
        return;
      }
      if (this.vlO)
      {
        Ki(1);
        AppMethodBeat.o(23927);
      }
    }
    else
    {
      localObject = e.vmf;
      Assert.assertTrue(false);
    }
    AppMethodBeat.o(23927);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23933);
    this.vlF.dar();
    this.vlF.notifyDataSetChanged();
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
    this.vlL = ((Intent)localObject).getStringExtra("device_category_id");
    this.veU = ((Intent)localObject).getStringExtra("device_brand_name");
    this.mDeviceType = ((Intent)localObject).getStringExtra("device_type");
    if ((this.mDeviceType == null) || (this.mDeviceType.length() == 0)) {
      this.mDeviceType = this.veU;
    }
    String str2 = ((Intent)localObject).getStringExtra("device_scan_conn_proto");
    String str3 = ((Intent)localObject).getStringExtra("device_scan_mode");
    paramBundle = "";
    String str1 = ((Intent)localObject).getStringExtra("device_title");
    localObject = str1;
    if (Util.isNullOrNil(str1)) {
      localObject = getContext().getString(R.l.eDr);
    }
    if (str3.contains("SCAN_MY_DEVICE"))
    {
      this.vlK = e.vmg;
      paramBundle = getContext().getString(R.l.eCI);
      setMMTitle(paramBundle);
      if (this.vlK != e.vmh) {
        break label426;
      }
      this.vlO = str2.contains("wifi");
      this.vlP = str2.contains("blue");
      Log.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[] { Boolean.valueOf(this.vlO), Boolean.valueOf(this.vlP) });
    }
    for (;;)
    {
      this.vfH = new j.a()
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
          ((ExdeviceBindDeviceUI.f)localObject2).vmk = ExdeviceBindDeviceUI.b.vmb;
          ((ExdeviceBindDeviceUI.f)localObject2).vmm = new ExdeviceBindDeviceUI.d(ExdeviceBindDeviceUI.this, (byte)0);
          ((ExdeviceBindDeviceUI.f)localObject2).vmm.mDeviceType = arrayOfObject2;
          ((ExdeviceBindDeviceUI.f)localObject2).vmm.veV = ((String)localObject1);
          if (!Util.isNullOrNil(paramAnonymousVarArgs))
          {
            ((ExdeviceBindDeviceUI.f)localObject2).vmr = Base64.encodeToString(paramAnonymousVarArgs.getBytes(), 2);
            Log.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[] { ((ExdeviceBindDeviceUI.f)localObject2).vmr });
          }
          for (;;)
          {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23895);
                ExdeviceBindDeviceUI.this.a(this.vlR);
                AppMethodBeat.o(23895);
              }
            });
            AppMethodBeat.o(23896);
            return;
            ((ExdeviceBindDeviceUI.f)localObject2).vmr = null;
          }
        }
      };
      this.vlN = new j.a()
      {
        public final void g(int paramAnonymousInt, Object... paramAnonymousVarArgs) {}
      };
      initView();
      this.txU.setText(getContext().getString(R.l.eEb, new Object[] { localObject }));
      bh.aGY().a(1264, this);
      bh.aGY().a(1706, this);
      bh.aGY().a(1270, this);
      bh.aGY().a(1719, this);
      if (this.vlP) {
        ae.cZJ().a(this);
      }
      if (this.vlO)
      {
        j.cZo().a(10, this.vfH);
        j.cZo().a(11, this.vlN);
        Java2CExDevice.initWCLanDeviceLib();
      }
      AppMethodBeat.o(23925);
      return;
      if (str3.compareTo("SCAN_CATALOG") == 0)
      {
        this.vlK = e.vmh;
        paramBundle = getContext().getString(R.l.eCG);
        break;
      }
      Assert.assertTrue(false);
      break;
      label426:
      if (this.vlK == e.vmg)
      {
        this.vlP = true;
        this.vlO = true;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23929);
    super.onDestroy();
    if (this.vlO)
    {
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23898);
          Java2CExDevice.stopScanWCLanDevice();
          Java2CExDevice.releaseWCLanDeviceLib();
          AppMethodBeat.o(23898);
        }
      });
      j.cZo().b(10, this.vfH);
      j.cZo().b(11, this.vlN);
    }
    if (this.vlP)
    {
      ae.cZJ().b(this);
      ae.cZK().cxT();
    }
    bh.aGY().b(1264, this);
    bh.aGY().b(1706, this);
    bh.aGY().b(1270, this);
    bh.aGY().b(1719, this);
    AppMethodBeat.o(23929);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(23928);
    super.onPause();
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
    if (this.vlO) {
      Java2CExDevice.stopScanWCLanDevice();
    }
    if (this.vlP) {
      ae.cZK().cxT();
    }
    AppMethodBeat.o(23928);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23926);
    super.onResume();
    Log.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
    if (this.vlP)
    {
      ae.cZJ();
      e.cZj();
    }
    if (this.vlO) {
      Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
    }
    this.vlF.dar();
    this.vlF.notifyDataSetChanged();
    AppMethodBeat.o(23926);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
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
  
  public final void q(String paramString1, String paramString2, boolean paramBoolean)
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
    localf.vmk = ExdeviceBindDeviceUI.b.vmc;
    localf.vml = new c((byte)0);
    localf.vml.vme = paramString1;
    localf.vml.shW = com.tencent.mm.plugin.exdevice.k.b.Jy(com.tencent.mm.plugin.exdevice.k.b.avW(paramString2));
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
    List<ExdeviceBindDeviceUI.f> vlX;
    private String vlY;
    private ExdeviceBindDeviceUI.e vlZ;
    private c vle;
    private String vma;
    
    public a(String paramString1, ExdeviceBindDeviceUI.e parame, String paramString2)
    {
      AppMethodBeat.i(23905);
      this.vlY = paramString1;
      this.vlZ = parame;
      this.vma = paramString2;
      this.vlX = new ArrayList();
      paramString1 = new c.a();
      paramString1.lRS = R.e.settings_bg;
      this.vle = paramString1.bmL();
      AppMethodBeat.o(23905);
    }
    
    private int avP(String paramString)
    {
      AppMethodBeat.i(23913);
      int i = 0;
      while (i < this.vlX.size())
      {
        if (((ExdeviceBindDeviceUI.f)this.vlX.get(i)).getKey().compareTo(paramString) == 0)
        {
          AppMethodBeat.o(23913);
          return i;
        }
        i += 1;
      }
      AppMethodBeat.o(23913);
      return -1;
    }
    
    static boolean avQ(String paramString)
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
    
    public final ExdeviceBindDeviceUI.f Kk(int paramInt)
    {
      AppMethodBeat.i(23911);
      int j = -1;
      int i = 0;
      while (i < this.vlX.size())
      {
        int k = j;
        if (((ExdeviceBindDeviceUI.f)this.vlX.get(i)).vmj) {
          k = j + 1;
        }
        if (k == paramInt)
        {
          ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.vlX.get(i);
          AppMethodBeat.o(23911);
          return localf;
        }
        i += 1;
        j = k;
      }
      AppMethodBeat.o(23911);
      return null;
    }
    
    public final boolean avO(String paramString)
    {
      AppMethodBeat.i(23908);
      if (avP(paramString) >= 0)
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
      if (avP(paramf.getKey()) < 0)
      {
        AppMethodBeat.o(23907);
        return false;
      }
      paramf.vmj = c(paramf);
      AppMethodBeat.o(23907);
      return true;
    }
    
    final boolean c(ExdeviceBindDeviceUI.f paramf)
    {
      AppMethodBeat.i(23915);
      if (paramf.vmo == null)
      {
        AppMethodBeat.o(23915);
        return false;
      }
      if (this.vlZ == ExdeviceBindDeviceUI.e.vmh)
      {
        if ((paramf.vmo.TpK == null) || (paramf.vmo.TpK.compareTo(this.vlY) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
        if ((paramf.vmo.TpT == null) || (paramf.vmo.TpT.compareTo(this.vma) != 0))
        {
          AppMethodBeat.o(23915);
          return false;
        }
      }
      else if (this.vlZ == ExdeviceBindDeviceUI.e.vmg)
      {
        if (paramf.vmo.idX == 0)
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
    
    final void dar()
    {
      AppMethodBeat.i(23906);
      int i = 0;
      while (i < this.vlX.size())
      {
        ExdeviceBindDeviceUI.f localf = (ExdeviceBindDeviceUI.f)this.vlX.get(i);
        localf.vmj = c(localf);
        i += 1;
      }
      AppMethodBeat.o(23906);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(23910);
      int i = 0;
      int k;
      for (int j = 0; i < this.vlX.size(); j = k)
      {
        k = j;
        if (((ExdeviceBindDeviceUI.f)this.vlX.get(i)).vmj) {
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
      ExdeviceBindDeviceUI.f localf = Kk(paramInt);
      a locala;
      View localView;
      if (paramView == null)
      {
        locala = new a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), R.i.egk, null);
        locala.mYd = ((TextView)localView.findViewById(R.h.dNd));
        locala.qps = ((ImageView)localView.findViewById(R.h.dIy));
        localView.setTag(locala);
      }
      while ((localf == null) || (localf.vmo == null))
      {
        Assert.assertTrue(false);
        AppMethodBeat.o(23912);
        return localView;
        locala = (a)paramView.getTag();
        localView = paramView;
      }
      Object localObject;
      if (localf.vmk == ExdeviceBindDeviceUI.b.vmc)
      {
        Log.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[] { Integer.valueOf(paramInt), localf.vml.vme, localf.vml.shW, localf.vmo.TpR });
        localObject = "";
        paramView = localf.vmo.ieb;
        if ((paramView != null) && (paramView.length() >= 4))
        {
          paramView = paramView.substring(paramView.length() - 4, paramView.length());
          paramView = localf.vmo.TpR + " " + paramView;
          localObject = new SpannableString(paramView);
          ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(R.e.hint_text_color)), localf.vmo.TpR.length() + 1, paramView.length(), 17);
          locala.mYd.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        paramView = localf.vmo.CNj;
        if (!avQ(paramView)) {
          com.tencent.mm.ay.q.bml().a(paramView, locala.qps, this.vle);
        }
        AppMethodBeat.o(23912);
        return localView;
        paramView = (View)localObject;
        if (localf.vml.shW == null) {
          break;
        }
        paramView = (View)localObject;
        if (localf.vml.shW.length() < 4) {
          break;
        }
        paramView = localf.vml.shW;
        paramView = paramView.substring(paramView.length() - 4, paramView.length());
        break;
        if (localf.vmk == ExdeviceBindDeviceUI.b.vmb)
        {
          localObject = "";
          paramView = localf.vmo.ieb;
          if ((paramView != null) && (paramView.length() >= 4)) {
            paramView = paramView.substring(paramView.length() - 4, paramView.length());
          }
          for (;;)
          {
            paramView = localf.vmo.TpR + " " + paramView;
            localObject = new SpannableString(paramView);
            ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramViewGroup.getContext().getResources().getColor(R.e.hint_text_color)), localf.vmo.TpR.length() + 1, paramView.length(), 17);
            locala.mYd.setText((CharSequence)localObject);
            break;
            paramView = (View)localObject;
            if (localf.vmo.RPQ != null)
            {
              paramView = (View)localObject;
              if (localf.vmo.RPQ.length() >= 4)
              {
                paramView = localf.vmo.RPQ;
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
      TextView mYd;
      ImageView qps;
    }
  }
  
  final class c
  {
    public String shW;
    public String vme;
    
    private c() {}
  }
  
  final class d
  {
    public String mDeviceType;
    public String veV;
    
    private d() {}
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(23923);
      vmf = new e("SCAN_ALL", 0);
      vmg = new e("SCAN_MY_DEVICE", 1);
      vmh = new e("SCAN_CATALOG", 2);
      vmi = new e[] { vmf, vmg, vmh };
      AppMethodBeat.o(23923);
    }
    
    private e() {}
  }
  
  final class f
  {
    public String vlt;
    public boolean vmj = false;
    public ExdeviceBindDeviceUI.b vmk = ExdeviceBindDeviceUI.b.vmb;
    public ExdeviceBindDeviceUI.c vml;
    public ExdeviceBindDeviceUI.d vmm;
    public ciu vmn;
    public civ vmo;
    public int vmp;
    public cyb vmq;
    public String vmr;
    
    private f() {}
    
    public final String das()
    {
      if (this.vmk == ExdeviceBindDeviceUI.b.vmb)
      {
        if (this.vmo == null) {
          return null;
        }
        return this.vmo.RPQ;
      }
      return this.vml.shW;
    }
    
    public final String getKey()
    {
      AppMethodBeat.i(23924);
      if (this.vmk == ExdeviceBindDeviceUI.b.vmb)
      {
        str = this.vmm.mDeviceType + this.vmm.veV;
        AppMethodBeat.o(23924);
        return str;
      }
      String str = this.vml.shW;
      AppMethodBeat.o(23924);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI
 * JD-Core Version:    0.7.0.1
 */