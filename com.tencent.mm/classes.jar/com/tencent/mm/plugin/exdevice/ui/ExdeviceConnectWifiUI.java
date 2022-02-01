package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.exdevice.e.a;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private TextWatcher aws;
  private EditText klM;
  private View rGJ;
  private TextView rGK;
  private View rGL;
  private View rGM;
  private q rGN;
  private String rGO;
  private a rGP;
  private boolean rGQ;
  private boolean rGR;
  private boolean rGS;
  private int rGT;
  private byte[] rGU;
  private int rGV;
  private int rGW;
  private int rGX;
  private String rGY;
  private int rGZ;
  private long rHa;
  boolean rHb;
  private com.tencent.mm.plugin.exdevice.e.b rHc;
  private b rHd;
  private p rHe;
  private j.a rHf;
  private WifiManager.MulticastLock rHg;
  private Runnable rHh;
  private boolean rHi;
  private String rcq;
  
  public ExdeviceConnectWifiUI()
  {
    AppMethodBeat.i(23964);
    this.rGY = "";
    this.rcq = "";
    this.rHb = false;
    this.rHh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23939);
        if (!Util.isNullOrNil(ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this)))
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
          AppMethodBeat.o(23939);
          return;
        }
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).setText(ExdeviceConnectWifiUI.b(ExdeviceConnectWifiUI.this).rBz);
        Editable localEditable = ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).getText();
        if (localEditable != null) {
          Selection.setSelection(localEditable, localEditable.length());
        }
        AppMethodBeat.o(23939);
      }
    };
    this.rHi = true;
    AppMethodBeat.o(23964);
  }
  
  private void GD(int paramInt)
  {
    AppMethodBeat.i(23970);
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.rHa;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rGX), Long.valueOf(l), this.rGY, this.rcq, Integer.valueOf(this.rGZ) });
    AppMethodBeat.o(23970);
  }
  
  private a aS(int paramInt, String paramString)
  {
    AppMethodBeat.i(23971);
    if ((Util.isNullOrNil(paramString)) || (this.rHc == null))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      AppMethodBeat.o(23971);
      return null;
    }
    int i = 0;
    if (i < this.rHc.rBA.size())
    {
      a locala = (a)this.rHc.rBA.get(i);
      int j;
      if (locala == null)
      {
        this.rHc.rBA.remove(i);
        this.rGQ = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.rBx != paramInt);
        j = i;
      } while (!paramString.equals(locala.rBy));
      AppMethodBeat.o(23971);
      return locala;
    }
    AppMethodBeat.o(23971);
    return null;
  }
  
  private void cLD()
  {
    AppMethodBeat.i(23977);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179591);
        if ((ExdeviceConnectWifiUI.g(ExdeviceConnectWifiUI.this) != null) && (ExdeviceConnectWifiUI.g(ExdeviceConnectWifiUI.this).isShowing())) {
          ExdeviceConnectWifiUI.g(ExdeviceConnectWifiUI.this).dismiss();
        }
        AppMethodBeat.o(179591);
      }
    });
    if (this.rHg.isHeld()) {
      this.rHg.release();
    }
    AppMethodBeat.o(23977);
  }
  
  private void cLG()
  {
    AppMethodBeat.i(23972);
    this.rGP.rBz = "";
    this.rGP.rBy = "";
    String str = this.rGO;
    a locala = aS(this.rGT, str);
    if ((locala == null) || (Util.isNullOrNil(str)))
    {
      AppMethodBeat.o(23972);
      return;
    }
    if (Util.isNullOrNil(locala.rBz))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.rHc.rBA.remove(locala);
      this.rGQ = true;
      AppMethodBeat.o(23972);
      return;
    }
    this.rGP.rBz = com.tencent.mm.plugin.base.model.b.eW(locala.rBz, ExdeviceConnectWifiUI.a.aT(this.rGT, locala.rBy));
    this.rGP.rBy = locala.rBy;
    MMHandlerThread.postToMainThread(this.rHh);
    AppMethodBeat.o(23972);
  }
  
  private void cLH()
  {
    AppMethodBeat.i(23976);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23946);
        ExdeviceConnectWifiUI localExdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
        AppCompatActivity localAppCompatActivity = ExdeviceConnectWifiUI.this.getContext();
        ExdeviceConnectWifiUI.this.getString(2131755998);
        ExdeviceConnectWifiUI.a(localExdeviceConnectWifiUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, ExdeviceConnectWifiUI.this.getString(2131758906), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(179590);
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
            if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.rHv) {
              ExdeviceConnectWifiUI.r(ExdeviceConnectWifiUI.this);
            }
            AppMethodBeat.o(179590);
          }
        }));
        AppMethodBeat.o(23946);
      }
    });
    AppMethodBeat.o(23976);
  }
  
  private String getPassword()
  {
    AppMethodBeat.i(23973);
    if (this.klM.getText() != null)
    {
      String str = this.klM.getText().toString();
      AppMethodBeat.o(23973);
      return str;
    }
    AppMethodBeat.o(23973);
    return null;
  }
  
  private void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(23978);
    View localView = this.rGJ;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label66;
      }
      cLH();
    }
    for (;;)
    {
      if (paramBoolean3) {
        Toast.makeText(getContext(), 2131758817, 0).show();
      }
      AppMethodBeat.o(23978);
      return;
      i = 8;
      break;
      label66:
      cLD();
    }
  }
  
  private void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(23974);
    b localb;
    if (paramBoolean)
    {
      localb = b.rHs;
      if (NetStatusUtil.getNetType(this) == 0) {
        break label45;
      }
      localb = b.rHt;
    }
    for (;;)
    {
      a(localb);
      AppMethodBeat.o(23974);
      return;
      localb = this.rHd;
      break;
      label45:
      this.rGO = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
      Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { this.rGO });
      if (!Util.isNullOrNil(this.rGO)) {
        this.rGK.setText(this.rGO);
      } else {
        this.rGK.setText("");
      }
    }
  }
  
  public final void a(b paramb)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(23975);
        if (paramb == null)
        {
          Log.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
          AppMethodBeat.o(23975);
          return;
        }
        this.rHd = paramb;
        switch (10.rHo[paramb.ordinal()])
        {
        case 1: 
          if (paramb != b.rHs)
          {
            this.klM.clearFocus();
            hideVKB();
          }
          AppMethodBeat.o(23975);
          continue;
          i(true, false, false);
        }
      }
      finally {}
      continue;
      i(true, true, false);
      continue;
      i(false, false, false);
      continue;
      GD(5);
      this.rGS = true;
      setResult(1);
      for (;;)
      {
        finish();
        break;
        GD(4);
        i(true, false, true);
        this.rGS = true;
        setResult(-1);
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23945);
            ExdeviceConnectWifiUI.q(ExdeviceConnectWifiUI.this);
            AppMethodBeat.o(23945);
          }
        });
        if (getIntent().getBooleanExtra("jumpToBindDevice", false))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
          localIntent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
          localIntent.putExtra("device_id", getIntent().getStringExtra("device_id"));
          localIntent.putExtra("device_type", getIntent().getStringExtra("device_type"));
          localIntent.putExtra("device_title", getIntent().getStringExtra("device_title"));
          localIntent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
          localIntent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
          localIntent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
          localIntent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
          localIntent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
          com.tencent.mm.br.c.b(getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", localIntent);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131494017;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23969);
    setMMTitle(2131758814);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179596);
        if (!ExdeviceConnectWifiUI.h(ExdeviceConnectWifiUI.this))
        {
          paramAnonymousMenuItem = new Intent();
          if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) == ExdeviceConnectWifiUI.b.rHt) {
            break label69;
          }
        }
        label69:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousMenuItem.putExtra("is_wifi_connected", bool);
          ExdeviceConnectWifiUI.this.setResult(0, paramAnonymousMenuItem);
          ExdeviceConnectWifiUI.this.finish();
          AppMethodBeat.o(179596);
          return false;
        }
      }
    });
    this.rGJ = findViewById(2131307647);
    this.rGK = ((TextView)findViewById(2131305210));
    this.rGL = findViewById(2131296709);
    this.klM = ((EditText)findViewById(2131305790));
    this.rGM = findViewById(2131299015);
    this.aws = new ExdeviceConnectWifiUI.15(this);
    this.rGJ.setOnTouchListener(new ExdeviceConnectWifiUI.16(this));
    this.rGM.setOnClickListener(new ExdeviceConnectWifiUI.17(this));
    this.klM.setTransformationMethod(new PasswordTransformationMethod());
    this.klM.addTextChangedListener(this.aws);
    this.klM.setOnEditorActionListener(new ExdeviceConnectWifiUI.18(this));
    this.klM.setOnKeyListener(new ExdeviceConnectWifiUI.2(this));
    this.klM.requestFocus();
    AppMethodBeat.o(23969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23965);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.compatible.util.d.oF(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (this.rHi)
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 77, null, null);
          Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
        else if ((com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION")) && (!com.tencent.mm.modelgeo.d.bcc()))
        {
          com.tencent.mm.ui.base.h.a(this, getString(2131761461), getString(2131755998), getString(2131762043), getString(2131755761), false, new ExdeviceConnectWifiUI.13(this), null);
        }
      }
      this.rHe = new p.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(23949);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23948);
              if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.rHv) {
                ExdeviceConnectWifiUI.e(ExdeviceConnectWifiUI.this);
              }
              AppMethodBeat.o(23948);
            }
          });
          AppMethodBeat.o(23949);
        }
      };
      this.rHd = b.rHs;
      if (bg.aAc()) {
        break;
      }
      finish();
      AppMethodBeat.o(23965);
      return;
    }
    this.rHc = new com.tencent.mm.plugin.exdevice.e.b();
    this.rGP = new a();
    bg.aVF();
    this.rGT = com.tencent.mm.model.c.getUin();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.rGV = getIntent().getIntExtra("procInterval", 0);
    this.rGW = getIntent().getIntExtra("dataInterval", 0);
    Log.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.rGV + " Data interval:" + this.rGW);
    if (!Util.isNullOrNil(paramBundle))
    {
      this.rGU = Base64.decode(paramBundle, 0);
      this.rGZ = 1;
    }
    this.rHb = false;
    this.rGX = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.rGX == 2)
    {
      this.rGY = getIntent().getStringExtra("device_brand_name");
      this.rcq = getIntent().getStringExtra("device_category_id");
    }
    this.rHf = new j.a()
    {
      public final void h(int paramAnonymousInt, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(23953);
        if ((paramAnonymousInt != 0) || (paramAnonymousVarArgs == null) || (paramAnonymousVarArgs.length < 2) || (!(paramAnonymousVarArgs[0] instanceof Integer)) || (!(paramAnonymousVarArgs[1] instanceof Integer)))
        {
          AppMethodBeat.o(23953);
          return;
        }
        paramAnonymousInt = ((Integer)paramAnonymousVarArgs[0]).intValue();
        int i = ((Integer)paramAnonymousVarArgs[1]).intValue();
        if (ExdeviceConnectWifiUI.f(ExdeviceConnectWifiUI.this).isHeld()) {
          ExdeviceConnectWifiUI.f(ExdeviceConnectWifiUI.this).release();
        }
        Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        if ((paramAnonymousInt == 0) && (i == 0))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23950);
              ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.rHv);
              AppMethodBeat.o(23950);
            }
          });
          AppMethodBeat.o(23953);
          return;
        }
        ExdeviceConnectWifiUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23952);
            if (ExdeviceConnectWifiUI.g(ExdeviceConnectWifiUI.this) != null) {
              ExdeviceConnectWifiUI.g(ExdeviceConnectWifiUI.this).dismiss();
            }
            com.tencent.mm.ui.base.h.a(ExdeviceConnectWifiUI.this.getContext(), ExdeviceConnectWifiUI.this.getContext().getString(2131758762), "", ExdeviceConnectWifiUI.this.getContext().getString(2131758810), "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
              {
                AppMethodBeat.i(23951);
                ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.rHw);
                AppMethodBeat.o(23951);
              }
            }, null).show();
            AppMethodBeat.o(23952);
          }
        });
        AppMethodBeat.o(23953);
      }
    };
    j.cKC().a(0, this.rHf);
    initView();
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23943);
        try
        {
          Object localObject = new StringBuilder();
          bg.aVF();
          localObject = s.aW(com.tencent.mm.model.c.getAccPath() + "exdevice_wifi_infos", 0, 2147483647);
          if (localObject != null)
          {
            ExdeviceConnectWifiUI.o(ExdeviceConnectWifiUI.this).parseFrom((byte[])localObject);
            ExdeviceConnectWifiUI.p(ExdeviceConnectWifiUI.this);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException, "", new Object[0]);
          }
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(179589);
            ExdeviceConnectWifiUI.this.showVKB();
            AppMethodBeat.o(179589);
          }
        }, 500L);
        AppMethodBeat.o(23943);
      }
    });
    GD(1);
    this.rHg = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
    AppMethodBeat.o(23965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23967);
    super.onDestroy();
    if (!this.rHb) {
      GD(2);
    }
    j.cKC().b(0, this.rHf);
    AppMethodBeat.o(23967);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(179601);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(179601);
      return;
    }
    Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(179601);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.rHi = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new ExdeviceConnectWifiUI.8(this), new ExdeviceConnectWifiUI.9(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23966);
    super.onResume();
    refresh(false);
    bg.a(this.rHe);
    if (this.rGR)
    {
      cLG();
      this.rGR = false;
    }
    AppMethodBeat.o(23966);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23968);
    super.onStop();
    bg.b(this.rHe);
    AppMethodBeat.o(23968);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(23963);
      rHs = new b("NORMAL", 0);
      rHt = new b("NO_WIFI_CONNECTED", 1);
      rHu = new b("SETTING", 2);
      rHv = new b("FINISH", 3);
      rHw = new b("TIMEOUT", 4);
      rHx = new b[] { rHs, rHt, rHu, rHv, rHw };
      AppMethodBeat.o(23963);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */