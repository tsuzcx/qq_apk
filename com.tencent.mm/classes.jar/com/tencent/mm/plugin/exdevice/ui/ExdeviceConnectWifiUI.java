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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.exdevice.e.a;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private TextWatcher auC;
  private EditText iRC;
  private boolean pFA;
  private boolean pFB;
  private int pFC;
  private byte[] pFD;
  private int pFE;
  private int pFF;
  private int pFG;
  private String pFH;
  private int pFI;
  private long pFJ;
  boolean pFK;
  private com.tencent.mm.plugin.exdevice.e.b pFL;
  private b pFM;
  private n pFN;
  private j.a pFO;
  private WifiManager.MulticastLock pFP;
  private Runnable pFQ;
  private boolean pFR;
  private View pFs;
  private TextView pFt;
  private View pFu;
  private View pFv;
  private p pFw;
  private String pFx;
  private a pFy;
  private boolean pFz;
  private String pbJ;
  
  public ExdeviceConnectWifiUI()
  {
    AppMethodBeat.i(23964);
    this.pFH = "";
    this.pbJ = "";
    this.pFK = false;
    this.pFQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23939);
        if (!bs.isNullOrNil(ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this)))
        {
          ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
          AppMethodBeat.o(23939);
          return;
        }
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).setText(ExdeviceConnectWifiUI.b(ExdeviceConnectWifiUI.this).pAu);
        Editable localEditable = ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).getText();
        if (localEditable != null) {
          Selection.setSelection(localEditable, localEditable.length());
        }
        AppMethodBeat.o(23939);
      }
    };
    this.pFR = true;
    AppMethodBeat.o(23964);
  }
  
  private void BX(int paramInt)
  {
    AppMethodBeat.i(23970);
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.pFJ;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.pFG), Long.valueOf(l), this.pFH, this.pbJ, Integer.valueOf(this.pFI) });
    AppMethodBeat.o(23970);
  }
  
  private a aL(int paramInt, String paramString)
  {
    AppMethodBeat.i(23971);
    if ((bs.isNullOrNil(paramString)) || (this.pFL == null))
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      AppMethodBeat.o(23971);
      return null;
    }
    int i = 0;
    if (i < this.pFL.pAv.size())
    {
      a locala = (a)this.pFL.pAv.get(i);
      int j;
      if (locala == null)
      {
        this.pFL.pAv.remove(i);
        this.pFz = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.pAs != paramInt);
        j = i;
      } while (!paramString.equals(locala.pAt));
      AppMethodBeat.o(23971);
      return locala;
    }
    AppMethodBeat.o(23971);
    return null;
  }
  
  private void chA()
  {
    AppMethodBeat.i(23976);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23946);
        ExdeviceConnectWifiUI localExdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
        AppCompatActivity localAppCompatActivity = ExdeviceConnectWifiUI.this.getContext();
        ExdeviceConnectWifiUI.this.getString(2131755906);
        ExdeviceConnectWifiUI.a(localExdeviceConnectWifiUI, com.tencent.mm.ui.base.h.b(localAppCompatActivity, ExdeviceConnectWifiUI.this.getString(2131758605), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(179590);
            ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
            if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.pGe) {
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
  
  private void chw()
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
    if (this.pFP.isHeld()) {
      this.pFP.release();
    }
    AppMethodBeat.o(23977);
  }
  
  private void chz()
  {
    AppMethodBeat.i(23972);
    this.pFy.pAu = "";
    this.pFy.pAt = "";
    String str = this.pFx;
    a locala = aL(this.pFC, str);
    if ((locala == null) || (bs.isNullOrNil(str)))
    {
      AppMethodBeat.o(23972);
      return;
    }
    if (bs.isNullOrNil(locala.pAu))
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.pFL.pAv.remove(locala);
      this.pFz = true;
      AppMethodBeat.o(23972);
      return;
    }
    this.pFy.pAu = com.tencent.mm.plugin.base.model.b.et(locala.pAu, ExdeviceConnectWifiUI.a.aM(this.pFC, locala.pAt));
    this.pFy.pAt = locala.pAt;
    ap.f(this.pFQ);
    AppMethodBeat.o(23972);
  }
  
  private void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(23978);
    View localView = this.pFs;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label66;
      }
      chA();
    }
    for (;;)
    {
      if (paramBoolean3) {
        Toast.makeText(getContext(), 2131758518, 0).show();
      }
      AppMethodBeat.o(23978);
      return;
      i = 8;
      break;
      label66:
      chw();
    }
  }
  
  private String getPassword()
  {
    AppMethodBeat.i(23973);
    if (this.iRC.getText() != null)
    {
      String str = this.iRC.getText().toString();
      AppMethodBeat.o(23973);
      return str;
    }
    AppMethodBeat.o(23973);
    return null;
  }
  
  private void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(23974);
    b localb;
    if (paramBoolean)
    {
      localb = b.pGb;
      if (ax.getNetType(this) == 0) {
        break label45;
      }
      localb = b.pGc;
    }
    for (;;)
    {
      a(localb);
      AppMethodBeat.o(23974);
      return;
      localb = this.pFM;
      break;
      label45:
      this.pFx = ax.iL(ai.getContext());
      ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { this.pFx });
      if (!bs.isNullOrNil(this.pFx)) {
        this.pFt.setText(this.pFx);
      } else {
        this.pFt.setText("");
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
          ac.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
          AppMethodBeat.o(23975);
          return;
        }
        this.pFM = paramb;
        switch (10.pFX[paramb.ordinal()])
        {
        case 1: 
          if (paramb != b.pGb)
          {
            this.iRC.clearFocus();
            hideVKB();
          }
          AppMethodBeat.o(23975);
          continue;
          g(true, false, false);
        }
      }
      finally {}
      continue;
      g(true, true, false);
      continue;
      g(false, false, false);
      continue;
      BX(5);
      this.pFB = true;
      setResult(1);
      for (;;)
      {
        finish();
        break;
        BX(4);
        g(true, false, true);
        this.pFB = true;
        setResult(-1);
        az.agU().az(new Runnable()
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
          com.tencent.mm.br.d.b(getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", localIntent);
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131493861;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23969);
    setMMTitle(2131758515);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179596);
        if (!ExdeviceConnectWifiUI.h(ExdeviceConnectWifiUI.this))
        {
          paramAnonymousMenuItem = new Intent();
          if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) == ExdeviceConnectWifiUI.b.pGc) {
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
    this.pFs = findViewById(2131304600);
    this.pFt = ((TextView)findViewById(2131302656));
    this.pFu = findViewById(2131296632);
    this.iRC = ((EditText)findViewById(2131303145));
    this.pFv = findViewById(2131298578);
    this.auC = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(179597);
        if (paramAnonymousEditable.length() > 31)
        {
          ExdeviceConnectWifiUI.i(ExdeviceConnectWifiUI.this).setVisibility(0);
          ExdeviceConnectWifiUI.j(ExdeviceConnectWifiUI.this).setEnabled(false);
          AppMethodBeat.o(179597);
          return;
        }
        ExdeviceConnectWifiUI.i(ExdeviceConnectWifiUI.this).setVisibility(8);
        ExdeviceConnectWifiUI.j(ExdeviceConnectWifiUI.this).setEnabled(true);
        AppMethodBeat.o(179597);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.pFs.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179598);
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).clearFocus();
        ExdeviceConnectWifiUI.this.hideVKB();
        AppMethodBeat.o(179598);
        return false;
      }
    });
    this.pFv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179599);
        ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
        ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
        AppMethodBeat.o(179599);
      }
    });
    this.iRC.setTransformationMethod(new PasswordTransformationMethod());
    this.iRC.addTextChangedListener(this.auC);
    this.iRC.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(179600);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
          ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
          AppMethodBeat.o(179600);
          return true;
        }
        AppMethodBeat.o(179600);
        return false;
      }
    });
    this.iRC.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(179588);
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
          AppMethodBeat.o(179588);
          return true;
        }
        AppMethodBeat.o(179588);
        return false;
      }
    });
    this.iRC.requestFocus();
    AppMethodBeat.o(23969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23965);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.compatible.util.d.lb(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (this.pFR)
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
          ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
        else if ((com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) && (!com.tencent.mm.modelgeo.d.aEM()))
        {
          com.tencent.mm.ui.base.h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new ExdeviceConnectWifiUI.13(this), null);
        }
      }
      this.pFN = new n.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(23949);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23948);
              if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.pGe) {
                ExdeviceConnectWifiUI.e(ExdeviceConnectWifiUI.this);
              }
              AppMethodBeat.o(23948);
            }
          });
          AppMethodBeat.o(23949);
        }
      };
      this.pFM = b.pGb;
      if (az.agM()) {
        break;
      }
      finish();
      AppMethodBeat.o(23965);
      return;
    }
    this.pFL = new com.tencent.mm.plugin.exdevice.e.b();
    this.pFy = new a();
    az.ayM();
    this.pFC = c.getUin();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.pFE = getIntent().getIntExtra("procInterval", 0);
    this.pFF = getIntent().getIntExtra("dataInterval", 0);
    ac.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.pFE + " Data interval:" + this.pFF);
    if (!bs.isNullOrNil(paramBundle))
    {
      this.pFD = Base64.decode(paramBundle, 0);
      this.pFI = 1;
    }
    this.pFK = false;
    this.pFG = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.pFG == 2)
    {
      this.pFH = getIntent().getStringExtra("device_brand_name");
      this.pbJ = getIntent().getStringExtra("device_category_id");
    }
    this.pFO = new j.a()
    {
      public final void g(int paramAnonymousInt, Object... paramAnonymousVarArgs)
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
        ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        if ((paramAnonymousInt == 0) && (i == 0))
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23950);
              ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.pGe);
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
            com.tencent.mm.ui.base.h.a(ExdeviceConnectWifiUI.this.getContext(), ExdeviceConnectWifiUI.this.getContext().getString(2131758463), "", ExdeviceConnectWifiUI.this.getContext().getString(2131758511), "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
              {
                AppMethodBeat.i(23951);
                ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.pGf);
                AppMethodBeat.o(23951);
              }
            }, null).show();
            AppMethodBeat.o(23952);
          }
        });
        AppMethodBeat.o(23953);
      }
    };
    j.cgG().a(0, this.pFO);
    initView();
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23943);
        try
        {
          Object localObject = new StringBuilder();
          az.ayM();
          localObject = i.aU(c.getAccPath() + "exdevice_wifi_infos", 0, 2147483647);
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
            ac.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException.getMessage());
            ac.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException, "", new Object[0]);
          }
        }
        ap.n(new Runnable()
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
    BX(1);
    this.pFP = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
    AppMethodBeat.o(23965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23967);
    super.onDestroy();
    if (!this.pFK) {
      BX(2);
    }
    j.cgG().b(0, this.pFO);
    AppMethodBeat.o(23967);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(179601);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(179601);
      return;
    }
    ac.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(179601);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.pFR = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new ExdeviceConnectWifiUI.8(this), new ExdeviceConnectWifiUI.9(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23966);
    super.onResume();
    refresh(false);
    az.a(this.pFN);
    if (this.pFA)
    {
      chz();
      this.pFA = false;
    }
    AppMethodBeat.o(23966);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23968);
    super.onStop();
    az.b(this.pFN);
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
      pGb = new b("NORMAL", 0);
      pGc = new b("NO_WIFI_CONNECTED", 1);
      pGd = new b("SETTING", 2);
      pGe = new b("FINISH", 3);
      pGf = new b("TIMEOUT", 4);
      pGg = new b[] { pGb, pGc, pGd, pGe, pGf };
      AppMethodBeat.o(23963);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */