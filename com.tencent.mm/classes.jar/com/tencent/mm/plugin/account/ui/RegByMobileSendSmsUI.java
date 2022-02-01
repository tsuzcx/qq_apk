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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bb;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.o;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements f
{
  private String bVF;
  private int countDown;
  private String dqk;
  private String dyO;
  private gm jmP;
  private String jmq;
  private String jnj;
  private String jnk;
  private g jnr;
  private ProgressDialog jns;
  private int jnt;
  private Button jnu;
  private aw jnx;
  private String jpk;
  private String jqV;
  private int jqb;
  private int jqd;
  private boolean jrv;
  private SecurityImage jry;
  private Button jsi;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(128577);
    this.jnj = "";
    this.jmq = "";
    this.jnk = "";
    this.jpk = "";
    this.countDown = 15;
    this.jmP = new gm();
    AppMethodBeat.o(128577);
  }
  
  private l Kt(String paramString)
  {
    AppMethodBeat.i(128580);
    l locall = new l(paramString);
    ae.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    locall.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(2131165469)), i, paramString.length(), 33);
    locall.setSpan(new ForegroundColorSpan(getResources().getColor(2131100464)), i, paramString.length(), 33);
    AppMethodBeat.o(128580);
    return locall;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128585);
    com.tencent.mm.ui.base.h.a(this, getString(2131762332), "", new DialogInterface.OnClickListener()
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
    if (this.jnx != null) {
      this.jnx.stopTimer();
    }
    this.jsi.setText(2131762330);
    this.jsi.setEnabled(true);
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
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.jnj }));
    ((TextView)findViewById(2131304581)).setText(Kt(getString(2131762335, new Object[] { this.jmq })));
    ((TextView)findViewById(2131304585)).setText(Kt(getString(2131762338, new Object[] { this.jnk })));
    this.jnu = ((Button)findViewById(2131304580));
    this.jsi = ((Button)findViewById(2131302852));
    if (bu.V(new String[] { this.jnj, this.jnk, this.jmq }))
    {
      this.jnu.setEnabled(false);
      this.jsi.setEnabled(false);
      if (!bu.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso())) {
        break label248;
      }
      this.jnu.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(2131762337);
      setBackBtn(new RegByMobileSendSmsUI.10(this));
      AppMethodBeat.o(128579);
      return;
      this.jsi.setOnClickListener(new RegByMobileSendSmsUI.1(this));
      break;
      label248:
      this.jnu.setOnClickListener(new RegByMobileSendSmsUI.9(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128578);
    super.onCreate(paramBundle);
    this.jqb = getIntent().getIntExtra("key_reg_style", 1);
    this.jnj = bu.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.jnk = bu.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.jmq = bu.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.jpk = bu.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.jqV = bu.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.bVF = bu.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.dyO = bu.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.jrv = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.jqd = getIntent().getIntExtra("reg_3d_app_type", 0);
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
    com.tencent.mm.kernel.g.ajj().a(145, this);
    com.tencent.mm.kernel.g.ajj().a(701, this);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    AppMethodBeat.o(128581);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128583);
    ae.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.jns != null) {
      this.jns.dismiss();
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).KZ() == 15))
    {
      paramn = (com.tencent.mm.modelfriend.a)paramn;
      this.dqk = paramn.aHN();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.jqb == 1)
        {
          com.tencent.mm.kernel.g.ajj().a(126, this);
          paramString = new v("", this.dyO, this.bVF, 0, "", this.jnj, "", "", this.dqk, 1, "", "", "", true, this.jrv);
          paramString.GP(this.jpk);
          paramString.GQ(this.jqV);
          paramString.pW(1);
          com.tencent.mm.kernel.g.ajj().a(paramString, 0);
          getString(2131755906);
          this.jns = com.tencent.mm.ui.base.h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128572);
              com.tencent.mm.kernel.g.ajj().a(paramString);
              com.tencent.mm.kernel.g.ajj().b(126, RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128572);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.dqk);
        paramString.putExtra("regsetinfo_user", this.jnj);
        paramString.putExtra("regsession_id", this.jpk);
        paramString.putExtra("reg_3d_app_ticket", this.jqV);
        paramString.putExtra("reg_3d_app_type", this.jqd);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramn.aHU());
        paramString.putExtra("key_reg_style", this.jqb);
        paramString.setClass(this, RegSetInfoUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.h.a.uU(paramString);
        this.jmP.epA = this.jqd;
        this.jmP.dQB = 7L;
        this.jmP.aLH();
        if (paramString != null)
        {
          paramString.a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128573);
              com.tencent.mm.kernel.g.ajj().a(701, RegByMobileSendSmsUI.this);
              com.tencent.mm.kernel.g.ajj().a(252, RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.aHM());
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).epA = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dQB = 8L;
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aLH();
              AppMethodBeat.o(128573);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128583);
          return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(2131756444), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128574);
            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.aHM());
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).epA = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dQB = 8L;
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aLH();
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
        paramString.putExtra("ticket", this.dqk);
        paramString.putExtra("moble", this.jnj);
        paramString.putExtra("regsession_id", this.jpk);
        paramString.putExtra("reg_3d_app_ticket", this.jqV);
        paramString.putExtra("reg_3d_app_type", this.jqd);
        paramString.putExtra("next_controll", paramn.aHU());
        paramString.putExtra("username", paramn.getUsername());
        paramString.putExtra("password", paramn.aHM());
        paramString.putExtra("nickname", paramn.aIa());
        paramString.putExtra("avatar_url", paramn.aHZ());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.jrv);
        paramString.putExtra("kintent_nickname", this.bVF);
        paramString.putExtra("kintent_password", this.dyO);
        paramString.putExtra("key_reg_style", this.jqb);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if ((!bu.isNullOrNil(paramString)) && (this.jnt >= 4))
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
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
      final v localv = (v)paramn;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.jry == null)
        {
          this.jry = SecurityImage.a.a(this, 0, localv.aLj(), localv.aLi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128576);
              paramAnonymousDialogInterface = new v("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localv.aLi(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.GP(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.GQ(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.pW(1);
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              RegByMobileSendSmsUI localRegByMobileSendSmsUI = RegByMobileSendSmsUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileSendSmsUI.this.getContext();
              RegByMobileSendSmsUI.this.getString(2131755906);
              RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, com.tencent.mm.ui.base.h.b(localAppCompatActivity, RegByMobileSendSmsUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128575);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
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
            public final void aSU()
            {
              AppMethodBeat.i(128564);
              RegByMobileSendSmsUI.this.hideVKB();
              v localv = new v("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localv.aLi(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              localv.GP(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              localv.GQ(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              localv.pW(1);
              com.tencent.mm.kernel.g.ajj().a(localv, 0);
              AppMethodBeat.o(128564);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.jry.b(0, ((v)paramn).aLj(), ((v)paramn).aLi(), "");
        AppMethodBeat.o(128583);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.jnj;
        this.jmP.epA = this.jqd;
        this.jmP.dQB = 6L;
        this.jmP.aLH();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dC(true);
        if (this.jrv)
        {
          paramn = b.asr() + "temp.avatar";
          String str = b.asr() + "temp.avatar.hd";
          o.mG(paramn, str);
          o.deleteFile(paramn);
          com.tencent.mm.sdk.platformtools.h.c(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramn);
          new com.tencent.mm.aj.n(this, b.asr() + "temp.avatar").a(new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(128565);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localv.aLs());
              bb.hIK.aM("login_user_name", paramString);
              o.deleteFile(b.asr() + "temp.avatar");
              Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.ajP();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.ajP();
              com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128565);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128566);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localv.aLs());
              bb.hIK.aM("login_user_name", paramString);
              Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.ajP();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.ajP();
              com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128566);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.dqk = localv.aLs();
        bb.hIK.aM("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.KB("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        paramString = paramString.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R200_600") + ",4");
        AppMethodBeat.o(128583);
        return;
      }
      paramString = com.tencent.mm.h.a.uU(paramString);
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
    com.tencent.mm.kernel.g.ajj().b(145, this);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    AppMethodBeat.o(128582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */