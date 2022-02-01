package com.tencent.mm.plugin.exdevice.ui;

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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public class ExdeviceConnectWifiUI
  extends MMActivity
{
  private EditText qaR;
  private TextWatcher vU;
  private String xNX;
  private View yyU;
  private TextView yyV;
  private View yyW;
  private View yyX;
  private w yyY;
  private String yyZ;
  private com.tencent.mm.plugin.exdevice.e.a yza;
  private boolean yzb;
  private boolean yzc;
  private boolean yzd;
  private int yze;
  private byte[] yzf;
  private int yzg;
  private int yzh;
  private int yzi;
  private String yzj;
  private int yzk;
  private long yzl;
  boolean yzm;
  private com.tencent.mm.plugin.exdevice.e.b yzn;
  private b yzo;
  private p yzp;
  private l.a yzq;
  private WifiManager.MulticastLock yzr;
  private Runnable yzs;
  private boolean yzt;
  
  public ExdeviceConnectWifiUI()
  {
    AppMethodBeat.i(23964);
    this.yzj = "";
    this.xNX = "";
    this.yzm = false;
    this.yzs = new Runnable()
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
        ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).setText(ExdeviceConnectWifiUI.b(ExdeviceConnectWifiUI.this).ytj);
        Editable localEditable = ExdeviceConnectWifiUI.c(ExdeviceConnectWifiUI.this).getText();
        if (localEditable != null) {
          Selection.setSelection(localEditable, localEditable.length());
        }
        AppMethodBeat.o(23939);
      }
    };
    this.yzt = true;
    AppMethodBeat.o(23964);
  }
  
  private void Lk(int paramInt)
  {
    AppMethodBeat.i(23970);
    long l = 0L;
    if (paramInt == 4) {
      l = System.currentTimeMillis() - this.yzl;
    }
    h.OAn.b(13503, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.yzi), Long.valueOf(l), this.yzj, this.xNX, Integer.valueOf(this.yzk) });
    AppMethodBeat.o(23970);
  }
  
  private com.tencent.mm.plugin.exdevice.e.a bk(int paramInt, String paramString)
  {
    AppMethodBeat.i(23971);
    if ((Util.isNullOrNil(paramString)) || (this.yzn == null))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
      AppMethodBeat.o(23971);
      return null;
    }
    int i = 0;
    if (i < this.yzn.ytk.size())
    {
      com.tencent.mm.plugin.exdevice.e.a locala = (com.tencent.mm.plugin.exdevice.e.a)this.yzn.ytk.get(i);
      int j;
      if (locala == null)
      {
        this.yzn.ytk.remove(i);
        this.yzb = true;
        j = i - 1;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (locala.yth != paramInt);
        j = i;
      } while (!paramString.equals(locala.yti));
      AppMethodBeat.o(23971);
      return locala;
    }
    AppMethodBeat.o(23971);
    return null;
  }
  
  private void dGL()
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
    if (this.yzr.isHeld()) {
      this.yzr.release();
    }
    AppMethodBeat.o(23977);
  }
  
  private void dGO()
  {
    AppMethodBeat.i(23972);
    this.yza.ytj = "";
    this.yza.yti = "";
    String str = this.yyZ;
    com.tencent.mm.plugin.exdevice.e.a locala = bk(this.yze, str);
    if ((locala == null) || (Util.isNullOrNil(str)))
    {
      AppMethodBeat.o(23972);
      return;
    }
    if (Util.isNullOrNil(locala.ytj))
    {
      Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
      this.yzn.ytk.remove(locala);
      this.yzb = true;
      AppMethodBeat.o(23972);
      return;
    }
    this.yza.ytj = com.tencent.mm.plugin.base.model.b.fB(locala.ytj, ExdeviceConnectWifiUI.a.bl(this.yze, locala.yti));
    this.yza.yti = locala.yti;
    MMHandlerThread.postToMainThread(this.yzs);
    AppMethodBeat.o(23972);
  }
  
  private void dGP()
  {
    AppMethodBeat.i(23976);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23946);
        ExdeviceConnectWifiUI localExdeviceConnectWifiUI = ExdeviceConnectWifiUI.this;
        AppCompatActivity localAppCompatActivity = ExdeviceConnectWifiUI.this.getContext();
        ExdeviceConnectWifiUI.this.getString(R.l.app_tip);
        ExdeviceConnectWifiUI.a(localExdeviceConnectWifiUI, k.a(localAppCompatActivity, ExdeviceConnectWifiUI.this.getString(R.l.gGS), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(179590);
            Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "On progress cancel, stop airkiss");
            if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.yzG) {
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
    if (this.qaR.getText() != null)
    {
      String str = this.qaR.getText().toString();
      AppMethodBeat.o(23973);
      return str;
    }
    AppMethodBeat.o(23973);
    return null;
  }
  
  private void h(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(23978);
    View localView = this.yyU;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      if (!paramBoolean2) {
        break label66;
      }
      dGP();
    }
    for (;;)
    {
      if (paramBoolean3) {
        Toast.makeText(getContext(), R.l.gFW, 0).show();
      }
      AppMethodBeat.o(23978);
      return;
      i = 8;
      break;
      label66:
      dGL();
    }
  }
  
  private void refresh(boolean paramBoolean)
  {
    AppMethodBeat.i(23974);
    b localb;
    if (paramBoolean)
    {
      localb = b.yzD;
      if (NetStatusUtil.getNetType(this) == 0) {
        break label45;
      }
      localb = b.yzE;
    }
    for (;;)
    {
      a(localb);
      AppMethodBeat.o(23974);
      return;
      localb = this.yzo;
      break;
      label45:
      this.yyZ = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[] { this.yyZ });
      if (!Util.isNullOrNil(this.yyZ)) {
        this.yyV.setText(this.yyZ);
      } else {
        this.yyV.setText("");
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
        this.yzo = paramb;
        switch (10.yzz[paramb.ordinal()])
        {
        case 1: 
          if (paramb != b.yzD)
          {
            this.qaR.clearFocus();
            hideVKB();
          }
          AppMethodBeat.o(23975);
          continue;
          h(true, false, false);
        }
      }
      finally {}
      continue;
      h(true, true, false);
      continue;
      h(false, false, false);
      continue;
      Lk(5);
      this.yzd = true;
      setResult(1);
      for (;;)
      {
        finish();
        break;
        Lk(4);
        h(true, false, true);
        this.yzd = true;
        setResult(-1);
        bh.baH().postToWorker(new Runnable()
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
    return R.i.gji;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23969);
    setMMTitle(R.l.gji);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(179596);
        if (!ExdeviceConnectWifiUI.h(ExdeviceConnectWifiUI.this))
        {
          paramAnonymousMenuItem = new Intent();
          if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) == ExdeviceConnectWifiUI.b.yzE) {
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
    this.yyU = findViewById(R.h.fVX);
    this.yyV = ((TextView)findViewById(R.h.fOX));
    this.yyW = findViewById(R.h.frc);
    this.qaR = ((EditText)findViewById(R.h.fTb));
    this.yyX = findViewById(R.h.fBz);
    this.vU = new TextWatcher()
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
    this.yyU.setOnTouchListener(new View.OnTouchListener()
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
    this.yyX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179599);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
        ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(179599);
      }
    });
    this.qaR.setTransformationMethod(new PasswordTransformationMethod());
    this.qaR.addTextChangedListener(this.vU);
    this.qaR.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(179600);
        if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "on next Key down.");
          ExdeviceConnectWifiUI.k(ExdeviceConnectWifiUI.this);
          AppMethodBeat.o(179600);
          return true;
        }
        AppMethodBeat.o(179600);
        return false;
      }
    });
    this.qaR.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(179588);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.cH(paramAnonymousKeyEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
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
    this.qaR.requestFocus();
    AppMethodBeat.o(23969);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23965);
    super.onCreate(paramBundle);
    if ((com.tencent.mm.compatible.util.d.rd(28)) || (Build.VERSION.CODENAME.equals("Q"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (this.yzt)
        {
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 77, null);
          Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
        else if ((com.tencent.mm.pluginsdk.permission.b.s(this, "android.permission.ACCESS_FINE_LOCATION")) && (!com.tencent.mm.modelgeo.d.bJm()))
        {
          k.a(this, getString(R.l.gps_disable_tip), getString(R.l.app_tip), getString(R.l.jump_to_settings), getString(R.l.app_cancel), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179595);
              com.tencent.mm.modelgeo.d.dP(ExdeviceConnectWifiUI.this);
              AppMethodBeat.o(179595);
            }
          }, null);
        }
      }
      this.yzp = new p.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(23949);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(23948);
              if (ExdeviceConnectWifiUI.d(ExdeviceConnectWifiUI.this) != ExdeviceConnectWifiUI.b.yzG) {
                ExdeviceConnectWifiUI.e(ExdeviceConnectWifiUI.this);
              }
              AppMethodBeat.o(23948);
            }
          });
          AppMethodBeat.o(23949);
        }
      };
      this.yzo = b.yzD;
      if (bh.baz()) {
        break;
      }
      finish();
      AppMethodBeat.o(23965);
      return;
    }
    this.yzn = new com.tencent.mm.plugin.exdevice.e.b();
    this.yza = new com.tencent.mm.plugin.exdevice.e.a();
    bh.bCz();
    this.yze = com.tencent.mm.model.c.getUin();
    paramBundle = getIntent().getStringExtra("encryptKey");
    this.yzg = getIntent().getIntExtra("procInterval", 0);
    this.yzh = getIntent().getIntExtra("dataInterval", 0);
    Log.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.yzg + " Data interval:" + this.yzh);
    if (!Util.isNullOrNil(paramBundle))
    {
      this.yzf = Base64.decode(paramBundle, 0);
      this.yzk = 1;
    }
    this.yzm = false;
    this.yzi = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
    if (this.yzi == 2)
    {
      this.yzj = getIntent().getStringExtra("device_brand_name");
      this.xNX = getIntent().getStringExtra("device_category_id");
    }
    this.yzq = new l.a()
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
              ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.yzG);
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
            k.a(ExdeviceConnectWifiUI.this.getContext(), ExdeviceConnectWifiUI.this.getContext().getString(R.l.gFt), "", ExdeviceConnectWifiUI.this.getContext().getString(R.l.gFS), "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
              {
                AppMethodBeat.i(23951);
                ExdeviceConnectWifiUI.this.a(ExdeviceConnectWifiUI.b.yzH);
                AppMethodBeat.o(23951);
              }
            }, null).show();
            AppMethodBeat.o(23952);
          }
        });
        AppMethodBeat.o(23953);
      }
    };
    l.dFF().a(0, this.yzq);
    initView();
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23943);
        try
        {
          Object localObject = new StringBuilder();
          bh.bCz();
          localObject = y.bi(com.tencent.mm.model.c.getAccPath() + "exdevice_wifi_infos", 0, 2147483647);
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
    Lk(1);
    this.yzr = ((WifiManager)getApplicationContext().getSystemService("wifi")).createMulticastLock("localWifi");
    AppMethodBeat.o(23965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23967);
    super.onDestroy();
    if (!this.yzm) {
      Lk(2);
    }
    l.dFF().b(0, this.yzq);
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
        this.yzt = false;
        k.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(179592);
            com.tencent.mm.pluginsdk.permission.b.lx(ExdeviceConnectWifiUI.this.getContext());
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
    bh.a(this.yzp);
    if (this.yzc)
    {
      dGO();
      this.yzc = false;
    }
    AppMethodBeat.o(23966);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23968);
    super.onStop();
    bh.b(this.yzp);
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
      yzD = new b("NORMAL", 0);
      yzE = new b("NO_WIFI_CONNECTED", 1);
      yzF = new b("SETTING", 2);
      yzG = new b("FINISH", 3);
      yzH = new b("TIMEOUT", 4);
      yzI = new b[] { yzD, yzE, yzF, yzG, yzH };
      AppMethodBeat.o(23963);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI
 * JD-Core Version:    0.7.0.1
 */