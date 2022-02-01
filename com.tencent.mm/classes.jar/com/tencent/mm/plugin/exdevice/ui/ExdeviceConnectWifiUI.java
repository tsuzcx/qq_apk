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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.exdevice.e.a;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private TextWatcher awu;
  private EditText jnE;
  private String pLX;
  private View qpC;
  private TextView qpD;
  private View qpE;
  private View qpF;
  private p qpG;
  private String qpH;
  private a qpI;
  private boolean qpJ;
  private boolean qpK;
  private boolean qpL;
  private int qpM;
  private byte[] qpN;
  private int qpO;
  private int qpP;
  private int qpQ;
  private String qpR;
  private int qpS;
  private long qpT;
  boolean qpU;
  private com.tencent.mm.plugin.exdevice.e.b qpV;
  private b qpW;
  private n qpX;
  private j.a qpY;
  private WifiManager.MulticastLock qpZ;
  private Runnable qqa;
  private boolean qqb;
  
  public ExdeviceConnectWifiUI()
  {
    AppMethodBeat.i(23964);
    this.qpR = "";
    this.pLX = "";
    this.qpU = false;
    this.qqa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23939);
        if (!bu.isNullOrNil(ExdeviceConnectWifiUI.a(ExdeviceConnectWifiUI.this)))
        {
          ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "User has input password.");
          AppMethodBeat.o(23939);
          return;
        }
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).setText(ExdeviceConnectWifiUI.b(ExdeviceConnectWifiUI.this).qkE);
        Editable localEditable = ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).getText();
        if (localEditable != null) {
          Selection.setSelection(localEditable, localEditable.length());
        }
        AppMethodBeat.o(23939);
      }
    };
    this.qqb = true;
    AppMethodBeat.o(23964);
  }
  
  private void CS(int paramInt)
  {
    AppMethodBeat.i(23970);
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.qpT;
    }
    g.yxI.f(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.qpQ), Long.valueOf(l), this.qpR, this.pLX, Integer.valueOf(this.qpS) });
    AppMethodBeat.o(23970);
  }
  
  private a aN(int paramInt, String paramString)
  {
    AppMethodBeat.i(23971);
    if ((bu.isNullOrNil(paramString)) || (this.qpV == null))
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      AppMethodBeat.o(23971);
      return null;
    }
    int i = 0;
    if (i < this.qpV.qkF.size())
    {
      a locala = (a)this.qpV.qkF.get(i);
      int j;
      if (locala == null)
      {
        this.qpV.qkF.remove(i);
        this.qpJ = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.qkC != paramInt);
        j = i;
      } while (!paramString.equals(locala.qkD));
      AppMethodBeat.o(23971);
      return locala;
    }
    AppMethodBeat.o(23971);
    return null;
  }
  
  private void cnq()
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
    if (this.qpZ.isHeld()) {
      this.qpZ.release();
    }
    AppMethodBeat.o(23977);
  }
  
  private void cnt()
  {
    AppMethodBeat.i(23972);
    this.qpI.qkE = "";
    this.qpI.qkD = "";
    String str = this.qpH;
    a locala = aN(this.qpM, str);
    if ((locala == null) || (bu.isNullOrNil(str)))
    {
      AppMethodBeat.o(23972);
      return;
    }
    if (bu.isNullOrNil(locala.qkE))
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.qpV.qkF.remove(locala);
      this.qpJ = true;
      AppMethodBeat.o(23972);
      return;
    }
    this.qpI.qkE = com.tencent.mm.plugin.base.model.b.eF(locala.qkE, ExdeviceConnectWifiUI.a.aO(this.qpM, locala.qkD));
    this.qpI.qkD = locala.qkD;
    ar.f(this.qqa);
    AppMethodBeat.o(23972);
  }
  
  private void cnu()
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
        ExdeviceConnectWifiUI.a(localExdeviceConnectWifiUI, h.b(localAppCompatActivity, ExdeviceConnectWifiUI.this.getString(2131758605), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(179590);
            ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
            if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.qqo) {
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
    if (this.jnE.getText() != null)
    {
      String str = this.jnE.getText().toString();
      AppMethodBeat.o(23973);
      return str;
    }
    AppMethodBeat.o(23973);
    return null;
  }
  
  private void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(23978);
    View localView = this.qpC;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label66;
      }
      cnu();
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
      cnq();
    }
  }
  
  private void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(23974);
    b localb;
    if (paramBoolean)
    {
      localb = b.qql;
      if (az.getNetType(this) == 0) {
        break label45;
      }
      localb = b.qqm;
    }
    for (;;)
    {
      a(localb);
      AppMethodBeat.o(23974);
      return;
      localb = this.qpW;
      break;
      label45:
      this.qpH = az.ja(ak.getContext());
      ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { this.qpH });
      if (!bu.isNullOrNil(this.qpH)) {
        this.qpD.setText(this.qpH);
      } else {
        this.qpD.setText("");
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
          ae.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
          AppMethodBeat.o(23975);
          return;
        }
        this.qpW = paramb;
        switch (10.qqh[paramb.ordinal()])
        {
        case 1: 
          if (paramb != b.qql)
          {
            this.jnE.clearFocus();
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
      CS(5);
      this.qpL = true;
      setResult(1);
      for (;;)
      {
        finish();
        break;
        CS(4);
        i(true, false, true);
        this.qpL = true;
        setResult(-1);
        bc.ajU().aw(new Runnable()
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
          if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) == ExdeviceConnectWifiUI.b.qqm) {
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
    this.qpC = findViewById(2131304600);
    this.qpD = ((TextView)findViewById(2131302656));
    this.qpE = findViewById(2131296632);
    this.jnE = ((EditText)findViewById(2131303145));
    this.qpF = findViewById(2131298578);
    this.awu = new ExdeviceConnectWifiUI.15(this);
    this.qpC.setOnTouchListener(new ExdeviceConnectWifiUI.16(this));
    this.qpF.setOnClickListener(new ExdeviceConnectWifiUI.17(this));
    this.jnE.setTransformationMethod(new PasswordTransformationMethod());
    this.jnE.addTextChangedListener(this.awu);
    this.jnE.setOnEditorActionListener(new ExdeviceConnectWifiUI.18(this));
    this.jnE.setOnKeyListener(new ExdeviceConnectWifiUI.2(this));
    this.jnE.requestFocus();
    AppMethodBeat.o(23969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23965);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.compatible.util.d.lC(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (this.qqb)
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
          ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
        else if ((com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION")) && (!com.tencent.mm.modelgeo.d.aIi()))
        {
          h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new ExdeviceConnectWifiUI.13(this), null);
        }
      }
      this.qpX = new n.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(23949);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23948);
              if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.qqo) {
                ExdeviceConnectWifiUI.e(ExdeviceConnectWifiUI.this);
              }
              AppMethodBeat.o(23948);
            }
          });
          AppMethodBeat.o(23949);
        }
      };
      this.qpW = b.qql;
      if (bc.ajM()) {
        break;
      }
      finish();
      AppMethodBeat.o(23965);
      return;
    }
    this.qpV = new com.tencent.mm.plugin.exdevice.e.b();
    this.qpI = new a();
    bc.aCg();
    this.qpM = c.getUin();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.qpO = getIntent().getIntExtra("procInterval", 0);
    this.qpP = getIntent().getIntExtra("dataInterval", 0);
    ae.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.qpO + " Data interval:" + this.qpP);
    if (!bu.isNullOrNil(paramBundle))
    {
      this.qpN = Base64.decode(paramBundle, 0);
      this.qpS = 1;
    }
    this.qpU = false;
    this.qpQ = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.qpQ == 2)
    {
      this.qpR = getIntent().getStringExtra("device_brand_name");
      this.pLX = getIntent().getStringExtra("device_category_id");
    }
    this.qpY = new j.a()
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
        ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "AirKiss jni callback (%d, %d)", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        if ((paramAnonymousInt == 0) && (i == 0))
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23950);
              ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.qqo);
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
            h.a(ExdeviceConnectWifiUI.this.getContext(), ExdeviceConnectWifiUI.this.getContext().getString(2131758463), "", ExdeviceConnectWifiUI.this.getContext().getString(2131758511), "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
              {
                AppMethodBeat.i(23951);
                ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.qqp);
                AppMethodBeat.o(23951);
              }
            }, null).show();
            AppMethodBeat.o(23952);
          }
        });
        AppMethodBeat.o(23953);
      }
    };
    j.cmA().a(0, this.qpY);
    initView();
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23943);
        try
        {
          Object localObject = new StringBuilder();
          bc.aCg();
          localObject = o.bb(c.getAccPath() + "exdevice_wifi_infos", 0, 2147483647);
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
            ae.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException.getMessage());
            ae.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", localException, "", new Object[0]);
          }
        }
        ar.o(new Runnable()
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
    CS(1);
    this.qpZ = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
    AppMethodBeat.o(23965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23967);
    super.onDestroy();
    if (!this.qpU) {
      CS(2);
    }
    j.cmA().b(0, this.qpY);
    AppMethodBeat.o(23967);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(179601);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(179601);
      return;
    }
    ae.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(179601);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.qqb = false;
        h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new ExdeviceConnectWifiUI.8(this), new ExdeviceConnectWifiUI.9(this));
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23966);
    super.onResume();
    refresh(false);
    bc.a(this.qpX);
    if (this.qpK)
    {
      cnt();
      this.qpK = false;
    }
    AppMethodBeat.o(23966);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23968);
    super.onStop();
    bc.b(this.qpX);
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
      qql = new b("NORMAL", 0);
      qqm = new b("NO_WIFI_CONNECTED", 1);
      qqn = new b("SETTING", 2);
      qqo = new b("FINISH", 3);
      qqp = new b("TIMEOUT", 4);
      qqq = new b[] { qql, qqm, qqn, qqo, qqp };
      AppMethodBeat.o(23963);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */