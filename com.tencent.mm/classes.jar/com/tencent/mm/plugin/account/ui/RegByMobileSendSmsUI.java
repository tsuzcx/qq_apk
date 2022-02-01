package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String bLs;
  private int countDown;
  private String ddJ;
  private String dlV;
  private fl iQO;
  private String iQp;
  private String iRh;
  private String iRi;
  private g iRp;
  private ProgressDialog iRq;
  private int iRr;
  private Button iRs;
  private au iRv;
  private int iTZ;
  private String iTi;
  private String iUT;
  private int iUb;
  private boolean iVt;
  private SecurityImage iVw;
  private Button iWg;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(128577);
    this.iRh = "";
    this.iQp = "";
    this.iRi = "";
    this.iTi = "";
    this.countDown = 15;
    this.iQO = new fl();
    AppMethodBeat.o(128577);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.l GF(String paramString)
  {
    AppMethodBeat.i(128580);
    com.tencent.mm.pluginsdk.ui.span.l locall = new com.tencent.mm.pluginsdk.ui.span.l(paramString);
    ac.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    locall.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(2131165469)), i, paramString.length(), 33);
    locall.setSpan(new ForegroundColorSpan(getResources().getColor(2131100464)), i, paramString.length(), 33);
    AppMethodBeat.o(128580);
    return locall;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128585);
    h.a(this, getString(2131762332), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(128569);
        RegByMobileSendSmsUI.t(RegByMobileSendSmsUI.this);
        RegByMobileSendSmsUI.this.finish();
        AppMethodBeat.o(128569);
      }
    }, null);
    AppMethodBeat.o(128585);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(128584);
    if (this.iRv != null) {
      this.iRv.stopTimer();
    }
    this.iWg.setText(2131762330);
    this.iWg.setEnabled(true);
    AppMethodBeat.o(128584);
  }
  
  public int getLayoutId()
  {
    return 2131494935;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128579);
    super.initView();
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.iRh }));
    ((TextView)findViewById(2131304581)).setText(GF(getString(2131762335, new Object[] { this.iQp })));
    ((TextView)findViewById(2131304585)).setText(GF(getString(2131762338, new Object[] { this.iRi })));
    this.iRs = ((Button)findViewById(2131304580));
    this.iWg = ((Button)findViewById(2131302852));
    if (bs.T(new String[] { this.iRh, this.iRi, this.iQp }))
    {
      this.iRs.setEnabled(false);
      this.iWg.setEnabled(false);
      if (!bs.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso())) {
        break label248;
      }
      this.iRs.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(2131762337);
      setBackBtn(new RegByMobileSendSmsUI.10(this));
      AppMethodBeat.o(128579);
      return;
      this.iWg.setOnClickListener(new RegByMobileSendSmsUI.1(this));
      break;
      label248:
      this.iRs.setOnClickListener(new RegByMobileSendSmsUI.9(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128578);
    super.onCreate(paramBundle);
    this.iTZ = getIntent().getIntExtra("key_reg_style", 1);
    this.iRh = bs.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.iRi = bs.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.iQp = bs.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.iTi = bs.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.iUT = bs.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.bLs = bs.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.dlV = bs.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.iVt = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.iUb = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(128578);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128586);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(128586);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128586);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128581);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(145, this);
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    AppMethodBeat.o(128581);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128583);
    ac.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.iRq != null) {
      this.iRq.dismiss();
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).Js() == 15))
    {
      paramn = (com.tencent.mm.modelfriend.a)paramn;
      this.ddJ = paramn.aEr();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.iTZ == 1)
        {
          com.tencent.mm.kernel.g.agi().a(126, this);
          paramString = new u("", this.dlV, this.bLs, 0, "", this.iRh, "", "", this.ddJ, 1, "", "", "", true, this.iVt);
          paramString.Di(this.iTi);
          paramString.Dj(this.iUT);
          paramString.pq(1);
          com.tencent.mm.kernel.g.agi().a(paramString, 0);
          getString(2131755906);
          this.iRq = h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128572);
              com.tencent.mm.kernel.g.agi().a(paramString);
              com.tencent.mm.kernel.g.agi().b(126, RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128572);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.ddJ);
        paramString.putExtra("regsetinfo_user", this.iRh);
        paramString.putExtra("regsession_id", this.iTi);
        paramString.putExtra("reg_3d_app_ticket", this.iUT);
        paramString.putExtra("reg_3d_app_type", this.iUb);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramn.aEy());
        paramString.putExtra("key_reg_style", this.iTZ);
        paramString.setClass(this, RegSetInfoUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.h.a.rM(paramString);
        this.iQO.dXB = this.iUb;
        this.iQO.dCQ = 7L;
        this.iQO.aHZ();
        if (paramString != null)
        {
          paramString.a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128573);
              com.tencent.mm.kernel.g.agi().a(701, RegByMobileSendSmsUI.this);
              com.tencent.mm.kernel.g.agi().a(252, RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.aEq());
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dXB = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dCQ = 8L;
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aHZ();
              AppMethodBeat.o(128573);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128583);
          return;
        }
        h.a(this, getString(2131756444), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128574);
            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.aEq());
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dXB = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dCQ = 8L;
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aHZ();
            AppMethodBeat.o(128574);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -212)
      {
        stopTimer();
        paramString = new Intent(this, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", this.ddJ);
        paramString.putExtra("moble", this.iRh);
        paramString.putExtra("regsession_id", this.iTi);
        paramString.putExtra("reg_3d_app_ticket", this.iUT);
        paramString.putExtra("reg_3d_app_type", this.iUb);
        paramString.putExtra("next_controll", paramn.aEy());
        paramString.putExtra("username", paramn.getUsername());
        paramString.putExtra("password", paramn.aEq());
        paramString.putExtra("nickname", paramn.aEE());
        paramString.putExtra("avatar_url", paramn.aED());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.iVt);
        paramString.putExtra("kintent_nickname", this.bLs);
        paramString.putExtra("kintent_password", this.dlV);
        paramString.putExtra("key_reg_style", this.iTZ);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if ((!bs.isNullOrNil(paramString)) && (this.iRr >= 4))
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128583);
          return;
        }
      }
      AppMethodBeat.o(128583);
      return;
    }
    if (paramn.getType() == 126)
    {
      final u localu = (u)paramn;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.iVw == null)
        {
          this.iVw = SecurityImage.a.a(this, 0, localu.aHB(), localu.aHA(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128576);
              paramAnonymousDialogInterface = new u("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localu.aHA(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.Di(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.Dj(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.pq(1);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              RegByMobileSendSmsUI localRegByMobileSendSmsUI = RegByMobileSendSmsUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileSendSmsUI.this.getContext();
              RegByMobileSendSmsUI.this.getString(2131755906);
              RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, h.b(localAppCompatActivity, RegByMobileSendSmsUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128575);
                  com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128575);
                }
              }));
              AppMethodBeat.o(128576);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128563);
              RegByMobileSendSmsUI.o(RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128563);
            }
          }, new SecurityImage.b()
          {
            public final void aPj()
            {
              AppMethodBeat.i(128564);
              RegByMobileSendSmsUI.this.hideVKB();
              u localu = new u("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localu.aHA(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              localu.Di(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              localu.Dj(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              localu.pq(1);
              com.tencent.mm.kernel.g.agi().a(localu, 0);
              AppMethodBeat.o(128564);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.iVw.b(0, ((u)paramn).aHB(), ((u)paramn).aHA(), "");
        AppMethodBeat.o(128583);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.iRh;
        this.iQO.dXB = this.iUb;
        this.iQO.dCQ = 6L;
        this.iQO.aHZ();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dz(true);
        if (this.iVt)
        {
          paramn = b.apo() + "temp.avatar";
          String str = b.apo() + "temp.avatar.hd";
          i.ma(paramn, str);
          i.deleteFile(paramn);
          f.c(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramn);
          new com.tencent.mm.aj.n(this, b.apo() + "temp.avatar").a(new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(128565);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localu.aHK());
              ay.hnA.aL("login_user_name", paramString);
              i.deleteFile(b.apo() + "temp.avatar");
              Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.agP();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.agP();
              com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128565);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128566);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localu.aHK());
              ay.hnA.aL("login_user_name", paramString);
              Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.agP();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.agP();
              com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128566);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.ddJ = localu.aHK();
        ay.hnA.aL("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.IL("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        paramString = paramString.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_600") + ",4");
        AppMethodBeat.o(128583);
        return;
      }
      paramString = com.tencent.mm.h.a.rM(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(128583);
        return;
      }
    }
    AppMethodBeat.o(128583);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(128582);
    super.onStop();
    stopTimer();
    com.tencent.mm.kernel.g.agi().b(145, this);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    AppMethodBeat.o(128582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */