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
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private TextWatcher atH;
  private EditText irx;
  private String oyj;
  private com.tencent.mm.plugin.exdevice.e.b pcA;
  private b pcB;
  private n pcC;
  private j.a pcD;
  private WifiManager.MulticastLock pcE;
  private Runnable pcF;
  private boolean pcG;
  private View pch;
  private TextView pci;
  private View pcj;
  private View pck;
  private p pcl;
  private String pcm;
  private com.tencent.mm.plugin.exdevice.e.a pcn;
  private boolean pco;
  private boolean pcp;
  private boolean pcq;
  private int pcr;
  private byte[] pcs;
  private int pct;
  private int pcu;
  private int pcv;
  private String pcw;
  private int pcx;
  private long pcy;
  boolean pcz;
  
  public ExdeviceConnectWifiUI()
  {
    AppMethodBeat.i(23964);
    this.pcw = "";
    this.oyj = "";
    this.pcz = false;
    this.pcF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23939);
        if (!bt.isNullOrNil(ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this)))
        {
          ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
          AppMethodBeat.o(23939);
          return;
        }
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).setText(ExdeviceConnectWifiUI.b(ExdeviceConnectWifiUI.this).oXj);
        Editable localEditable = ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).getText();
        if (localEditable != null) {
          Selection.setSelection(localEditable, localEditable.length());
        }
        AppMethodBeat.o(23939);
      }
    };
    this.pcG = true;
    AppMethodBeat.o(23964);
  }
  
  private void Bf(int paramInt)
  {
    AppMethodBeat.i(23970);
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.pcy;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.pcv), Long.valueOf(l), this.pcw, this.oyj, Integer.valueOf(this.pcx) });
    AppMethodBeat.o(23970);
  }
  
  private com.tencent.mm.plugin.exdevice.e.a aJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(23971);
    if ((bt.isNullOrNil(paramString)) || (this.pcA == null))
    {
      ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      AppMethodBeat.o(23971);
      return null;
    }
    int i = 0;
    if (i < this.pcA.oXk.size())
    {
      com.tencent.mm.plugin.exdevice.e.a locala = (com.tencent.mm.plugin.exdevice.e.a)this.pcA.oXk.get(i);
      int j;
      if (locala == null)
      {
        this.pcA.oXk.remove(i);
        this.pco = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.oXh != paramInt);
        j = i;
      } while (!paramString.equals(locala.oXi));
      AppMethodBeat.o(23971);
      return locala;
    }
    AppMethodBeat.o(23971);
    return null;
  }
  
  private void can()
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
    if (this.pcE.isHeld()) {
      this.pcE.release();
    }
    AppMethodBeat.o(23977);
  }
  
  private void caq()
  {
    AppMethodBeat.i(23972);
    this.pcn.oXj = "";
    this.pcn.oXi = "";
    String str = this.pcm;
    com.tencent.mm.plugin.exdevice.e.a locala = aJ(this.pcr, str);
    if ((locala == null) || (bt.isNullOrNil(str)))
    {
      AppMethodBeat.o(23972);
      return;
    }
    if (bt.isNullOrNil(locala.oXj))
    {
      ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.pcA.oXk.remove(locala);
      this.pco = true;
      AppMethodBeat.o(23972);
      return;
    }
    this.pcn.oXj = com.tencent.mm.plugin.base.model.b.eh(locala.oXj, ExdeviceConnectWifiUI.a.aK(this.pcr, locala.oXi));
    this.pcn.oXi = locala.oXi;
    aq.f(this.pcF);
    AppMethodBeat.o(23972);
  }
  
  private void car()
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
            ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
            if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.pcT) {
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
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(23978);
    View localView = this.pch;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label66;
      }
      car();
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
      can();
    }
  }
  
  private String getPassword()
  {
    AppMethodBeat.i(23973);
    if (this.irx.getText() != null)
    {
      String str = this.irx.getText().toString();
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
      localb = b.pcQ;
      if (ay.getNetType(this) == 0) {
        break label45;
      }
      localb = b.pcR;
    }
    for (;;)
    {
      a(localb);
      AppMethodBeat.o(23974);
      return;
      localb = this.pcB;
      break;
      label45:
      this.pcm = ay.iA(aj.getContext());
      ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { this.pcm });
      if (!bt.isNullOrNil(this.pcm)) {
        this.pci.setText(this.pcm);
      } else {
        this.pci.setText("");
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
          ad.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
          AppMethodBeat.o(23975);
          return;
        }
        this.pcB = paramb;
        switch (10.pcM[paramb.ordinal()])
        {
        case 1: 
          if (paramb != b.pcQ)
          {
            this.irx.clearFocus();
            hideVKB();
          }
          AppMethodBeat.o(23975);
          continue;
          f(true, false, false);
        }
      }
      finally {}
      continue;
      f(true, true, false);
      continue;
      f(false, false, false);
      continue;
      Bf(5);
      this.pcq = true;
      setResult(1);
      for (;;)
      {
        finish();
        break;
        Bf(4);
        f(true, false, true);
        this.pcq = true;
        setResult(-1);
        az.afE().ax(new Runnable()
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
          com.tencent.mm.bs.d.b(getContext(), "exdevice", ".ui.ExdeviceBindDeviceUI", localIntent);
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
          if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) == ExdeviceConnectWifiUI.b.pcR) {
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
    this.pch = findViewById(2131304600);
    this.pci = ((TextView)findViewById(2131302656));
    this.pcj = findViewById(2131296632);
    this.irx = ((EditText)findViewById(2131303145));
    this.pck = findViewById(2131298578);
    this.atH = new TextWatcher()
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
    this.pch.setOnTouchListener(new View.OnTouchListener()
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
    this.pck.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179599);
        ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
        ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
        AppMethodBeat.o(179599);
      }
    });
    this.irx.setTransformationMethod(new PasswordTransformationMethod());
    this.irx.addTextChangedListener(this.atH);
    this.irx.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(179600);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
          ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
          AppMethodBeat.o(179600);
          return true;
        }
        AppMethodBeat.o(179600);
        return false;
      }
    });
    this.irx.setOnKeyListener(new View.OnKeyListener()
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
    this.irx.requestFocus();
    AppMethodBeat.o(23969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23965);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.compatible.util.d.lh(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (this.pcG)
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
          ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
        else if ((com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) && (!com.tencent.mm.modelgeo.d.axU()))
        {
          com.tencent.mm.ui.base.h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179595);
              com.tencent.mm.modelgeo.d.cv(ExdeviceConnectWifiUI.this);
              AppMethodBeat.o(179595);
            }
          }, null);
        }
      }
      this.pcC = new n.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(23949);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23948);
              if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.pcT) {
                ExdeviceConnectWifiUI.e(ExdeviceConnectWifiUI.this);
              }
              AppMethodBeat.o(23948);
            }
          });
          AppMethodBeat.o(23949);
        }
      };
      this.pcB = b.pcQ;
      if (az.afw()) {
        break;
      }
      finish();
      AppMethodBeat.o(23965);
      return;
    }
    this.pcA = new com.tencent.mm.plugin.exdevice.e.b();
    this.pcn = new com.tencent.mm.plugin.exdevice.e.a();
    az.arV();
    this.pcr = c.getUin();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.pct = getIntent().getIntExtra("procInterval", 0);
    this.pcu = getIntent().getIntExtra("dataInterval", 0);
    ad.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.pct + " Data interval:" + this.pcu);
    if (!bt.isNullOrNil(paramBundle))
    {
      this.pcs = Base64.decode(paramBundle, 0);
      this.pcx = 1;
    }
    this.pcz = false;
    this.pcv = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.pcv == 2)
    {
      this.pcw = getIntent().getStringExtra("device_brand_name");
      this.oyj = getIntent().getStringExtra("device_category_id");
    }
    this.pcD = new j.a()
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
        ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        if ((paramAnonymousInt == 0) && (i == 0))
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23950);
              ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.pcT);
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
                ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.pcU);
                AppMethodBeat.o(23951);
              }
            }, null).show();
            AppMethodBeat.o(23952);
          }
        });
        AppMethodBeat.o(23953);
      }
    };
    j.bZx().a(0, this.pcD);
    initView();
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23943);
        try
        {
          Object localObject = new StringBuilder();
          az.arV();
          localObject = i.aR(c.getAccPath() + "exdevice_wifi_infos", 0, 2147483647);
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
            ad.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException.getMessage());
            ad.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException, "", new Object[0]);
          }
        }
        aq.n(new Runnable()
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
    Bf(1);
    this.pcE = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
    AppMethodBeat.o(23965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23967);
    super.onDestroy();
    if (!this.pcz) {
      Bf(2);
    }
    j.bZx().b(0, this.pcD);
    AppMethodBeat.o(23967);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(179601);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(179601);
      return;
    }
    ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(179601);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.pcG = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179592);
            paramAnonymousDialogInterface = ExdeviceConnectWifiUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ExdeviceConnectWifiUI.this.finish();
            AppMethodBeat.o(179592);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179593);
            ExdeviceConnectWifiUI.this.finish();
            AppMethodBeat.o(179593);
          }
        });
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23966);
    super.onResume();
    refresh(false);
    az.a(this.pcC);
    if (this.pcp)
    {
      caq();
      this.pcp = false;
    }
    AppMethodBeat.o(23966);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23968);
    super.onStop();
    az.b(this.pcC);
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
      pcQ = new b("NORMAL", 0);
      pcR = new b("NO_WIFI_CONNECTED", 1);
      pcS = new b("SETTING", 2);
      pcT = new b("FINISH", 3);
      pcU = new b("TIMEOUT", 4);
      pcV = new b[] { pcQ, pcR, pcS, pcT, pcU };
      AppMethodBeat.o(23963);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */