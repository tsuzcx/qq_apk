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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private TextWatcher awu;
  private EditText jkK;
  private String pFt;
  private View qiX;
  private TextView qiY;
  private View qiZ;
  private View qja;
  private p qjb;
  private String qjc;
  private com.tencent.mm.plugin.exdevice.e.a qjd;
  private boolean qje;
  private boolean qjf;
  private boolean qjg;
  private int qjh;
  private byte[] qji;
  private int qjj;
  private int qjk;
  private int qjl;
  private String qjm;
  private int qjn;
  private long qjo;
  boolean qjp;
  private com.tencent.mm.plugin.exdevice.e.b qjq;
  private b qjr;
  private n qjs;
  private j.a qjt;
  private WifiManager.MulticastLock qju;
  private Runnable qjv;
  private boolean qjw;
  
  public ExdeviceConnectWifiUI()
  {
    AppMethodBeat.i(23964);
    this.qjm = "";
    this.pFt = "";
    this.qjp = false;
    this.qjv = new Runnable()
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
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).setText(ExdeviceConnectWifiUI.b(ExdeviceConnectWifiUI.this).qdZ);
        Editable localEditable = ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).getText();
        if (localEditable != null) {
          Selection.setSelection(localEditable, localEditable.length());
        }
        AppMethodBeat.o(23939);
      }
    };
    this.qjw = true;
    AppMethodBeat.o(23964);
  }
  
  private void CG(int paramInt)
  {
    AppMethodBeat.i(23970);
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.qjo;
    }
    g.yhR.f(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.qjl), Long.valueOf(l), this.qjm, this.pFt, Integer.valueOf(this.qjn) });
    AppMethodBeat.o(23970);
  }
  
  private com.tencent.mm.plugin.exdevice.e.a aO(int paramInt, String paramString)
  {
    AppMethodBeat.i(23971);
    if ((bt.isNullOrNil(paramString)) || (this.qjq == null))
    {
      ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      AppMethodBeat.o(23971);
      return null;
    }
    int i = 0;
    if (i < this.qjq.qea.size())
    {
      com.tencent.mm.plugin.exdevice.e.a locala = (com.tencent.mm.plugin.exdevice.e.a)this.qjq.qea.get(i);
      int j;
      if (locala == null)
      {
        this.qjq.qea.remove(i);
        this.qje = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.qdX != paramInt);
        j = i;
      } while (!paramString.equals(locala.qdY));
      AppMethodBeat.o(23971);
      return locala;
    }
    AppMethodBeat.o(23971);
    return null;
  }
  
  private void cma()
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
    if (this.qju.isHeld()) {
      this.qju.release();
    }
    AppMethodBeat.o(23977);
  }
  
  private void cmd()
  {
    AppMethodBeat.i(23972);
    this.qjd.qdZ = "";
    this.qjd.qdY = "";
    String str = this.qjc;
    com.tencent.mm.plugin.exdevice.e.a locala = aO(this.qjh, str);
    if ((locala == null) || (bt.isNullOrNil(str)))
    {
      AppMethodBeat.o(23972);
      return;
    }
    if (bt.isNullOrNil(locala.qdZ))
    {
      ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.qjq.qea.remove(locala);
      this.qje = true;
      AppMethodBeat.o(23972);
      return;
    }
    this.qjd.qdZ = com.tencent.mm.plugin.base.model.b.eC(locala.qdZ, ExdeviceConnectWifiUI.a.aP(this.qjh, locala.qdY));
    this.qjd.qdY = locala.qdY;
    aq.f(this.qjv);
    AppMethodBeat.o(23972);
  }
  
  private void cme()
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
            ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
            if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.qjJ) {
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
  
  private void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(23978);
    View localView = this.qiX;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label66;
      }
      cme();
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
      cma();
    }
  }
  
  private String getPassword()
  {
    AppMethodBeat.i(23973);
    if (this.jkK.getText() != null)
    {
      String str = this.jkK.getText().toString();
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
      localb = b.qjG;
      if (ay.getNetType(this) == 0) {
        break label45;
      }
      localb = b.qjH;
    }
    for (;;)
    {
      a(localb);
      AppMethodBeat.o(23974);
      return;
      localb = this.qjr;
      break;
      label45:
      this.qjc = ay.iV(aj.getContext());
      ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { this.qjc });
      if (!bt.isNullOrNil(this.qjc)) {
        this.qiY.setText(this.qjc);
      } else {
        this.qiY.setText("");
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
        this.qjr = paramb;
        switch (10.qjC[paramb.ordinal()])
        {
        case 1: 
          if (paramb != b.qjG)
          {
            this.jkK.clearFocus();
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
      CG(5);
      this.qjg = true;
      setResult(1);
      for (;;)
      {
        finish();
        break;
        CG(4);
        g(true, false, true);
        this.qjg = true;
        setResult(-1);
        ba.ajF().ay(new Runnable()
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
          if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) == ExdeviceConnectWifiUI.b.qjH) {
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
    this.qiX = findViewById(2131304600);
    this.qiY = ((TextView)findViewById(2131302656));
    this.qiZ = findViewById(2131296632);
    this.jkK = ((EditText)findViewById(2131303145));
    this.qja = findViewById(2131298578);
    this.awu = new TextWatcher()
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
    this.qiX.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179598);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).clearFocus();
        ExdeviceConnectWifiUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179598);
        return false;
      }
    });
    this.qja.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179599);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
        ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179599);
      }
    });
    this.jkK.setTransformationMethod(new PasswordTransformationMethod());
    this.jkK.addTextChangedListener(this.awu);
    this.jkK.setOnEditorActionListener(new TextView.OnEditorActionListener()
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
    this.jkK.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(179588);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.bd(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
        if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
        {
          ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(179588);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
        AppMethodBeat.o(179588);
        return false;
      }
    });
    this.jkK.requestFocus();
    AppMethodBeat.o(23969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23965);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.compatible.util.d.lA(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (this.qjw)
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null);
          ad.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
        else if ((com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION")) && (!com.tencent.mm.modelgeo.d.aHR()))
        {
          h.a(this, getString(2131760082), getString(2131755906), getString(2131760598), getString(2131755691), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179595);
              com.tencent.mm.modelgeo.d.cB(ExdeviceConnectWifiUI.this);
              AppMethodBeat.o(179595);
            }
          }, null);
        }
      }
      this.qjs = new n.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(23949);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23948);
              if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.qjJ) {
                ExdeviceConnectWifiUI.e(ExdeviceConnectWifiUI.this);
              }
              AppMethodBeat.o(23948);
            }
          });
          AppMethodBeat.o(23949);
        }
      };
      this.qjr = b.qjG;
      if (ba.ajx()) {
        break;
      }
      finish();
      AppMethodBeat.o(23965);
      return;
    }
    this.qjq = new com.tencent.mm.plugin.exdevice.e.b();
    this.qjd = new com.tencent.mm.plugin.exdevice.e.a();
    ba.aBQ();
    this.qjh = c.getUin();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.qjj = getIntent().getIntExtra("procInterval", 0);
    this.qjk = getIntent().getIntExtra("dataInterval", 0);
    ad.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.qjj + " Data interval:" + this.qjk);
    if (!bt.isNullOrNil(paramBundle))
    {
      this.qji = Base64.decode(paramBundle, 0);
      this.qjn = 1;
    }
    this.qjp = false;
    this.qjl = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.qjl == 2)
    {
      this.qjm = getIntent().getStringExtra("device_brand_name");
      this.pFt = getIntent().getStringExtra("device_category_id");
    }
    this.qjt = new j.a()
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
              ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.qjJ);
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
                ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.qjK);
                AppMethodBeat.o(23951);
              }
            }, null).show();
            AppMethodBeat.o(23952);
          }
        });
        AppMethodBeat.o(23953);
      }
    };
    j.clk().a(0, this.qjt);
    initView();
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23943);
        try
        {
          Object localObject = new StringBuilder();
          ba.aBQ();
          localObject = i.aY(c.getAccPath() + "exdevice_wifi_infos", 0, 2147483647);
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
        aq.o(new Runnable()
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
    CG(1);
    this.qju = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
    AppMethodBeat.o(23965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23967);
    super.onDestroy();
    if (!this.qjp) {
      CG(2);
    }
    j.clk().b(0, this.qjt);
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
        this.qjw = false;
        h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179592);
            paramAnonymousDialogInterface = ExdeviceConnectWifiUI.this;
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    ba.a(this.qjs);
    if (this.qjf)
    {
      cmd();
      this.qjf = false;
    }
    AppMethodBeat.o(23966);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23968);
    super.onStop();
    ba.b(this.qjs);
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
      qjG = new b("NORMAL", 0);
      qjH = new b("NO_WIFI_CONNECTED", 1);
      qjI = new b("SETTING", 2);
      qjJ = new b("FINISH", 3);
      qjK = new b("TIMEOUT", 4);
      qjL = new b[] { qjG, qjH, qjI, qjJ, qjK };
      AppMethodBeat.o(23963);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */