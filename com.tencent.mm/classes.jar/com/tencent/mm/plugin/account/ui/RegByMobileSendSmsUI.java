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
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String bNK;
  private int countDown;
  private String dgo;
  private String dom;
  private dv iqH;
  private String iqi;
  private String irb;
  private String irc;
  private g irj;
  private ProgressDialog irk;
  private int irl;
  private Button irm;
  private av irp;
  private int itU;
  private int itW;
  private String itd;
  private String iuO;
  private boolean ivp;
  private SecurityImage ivs;
  private Button iwc;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(128577);
    this.irb = "";
    this.iqi = "";
    this.irc = "";
    this.itd = "";
    this.countDown = 15;
    this.iqH = new dv();
    AppMethodBeat.o(128577);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.l CC(String paramString)
  {
    AppMethodBeat.i(128580);
    com.tencent.mm.pluginsdk.ui.span.l locall = new com.tencent.mm.pluginsdk.ui.span.l(paramString);
    ad.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
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
    if (this.irp != null) {
      this.irp.stopTimer();
    }
    this.iwc.setText(2131762330);
    this.iwc.setEnabled(true);
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
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.irb }));
    ((TextView)findViewById(2131304581)).setText(CC(getString(2131762335, new Object[] { this.iqi })));
    ((TextView)findViewById(2131304585)).setText(CC(getString(2131762338, new Object[] { this.irc })));
    this.irm = ((Button)findViewById(2131304580));
    this.iwc = ((Button)findViewById(2131302852));
    if (bt.T(new String[] { this.irb, this.irc, this.iqi }))
    {
      this.irm.setEnabled(false);
      this.iwc.setEnabled(false);
      if (!bt.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso())) {
        break label248;
      }
      this.irm.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(2131762337);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(128571);
          RegByMobileSendSmsUI.d(RegByMobileSendSmsUI.this);
          AppMethodBeat.o(128571);
          return true;
        }
      });
      AppMethodBeat.o(128579);
      return;
      this.iwc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128562);
          RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this);
          AppMethodBeat.o(128562);
        }
      });
      break;
      label248:
      this.irm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128570);
          Object localObject = new Intent();
          ((Intent)localObject).setAction("android.intent.action.SENDTO");
          ((Intent)localObject).setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.b(RegByMobileSendSmsUI.this)));
          ((Intent)localObject).putExtra("sms_body", RegByMobileSendSmsUI.c(RegByMobileSendSmsUI.this));
          try
          {
            paramAnonymousView = RegByMobileSendSmsUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            RegByMobileSendSmsUI.this.overridePendingTransition(2130772144, 2130772141);
            AppMethodBeat.o(128570);
            return;
          }
          catch (Exception paramAnonymousView)
          {
            ad.e("MicroMsg.RegByMobileSendSmsUI", paramAnonymousView.getMessage());
            AppMethodBeat.o(128570);
          }
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128578);
    super.onCreate(paramBundle);
    this.itU = getIntent().getIntExtra("key_reg_style", 1);
    this.irb = bt.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.irc = bt.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.iqi = bt.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.itd = bt.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.iuO = bt.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.bNK = bt.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.dom = bt.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.ivp = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.itW = getIntent().getIntExtra("reg_3d_app_type", 0);
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
    com.tencent.mm.kernel.g.aeS().a(145, this);
    com.tencent.mm.kernel.g.aeS().a(701, this);
    com.tencent.mm.kernel.g.aeS().a(252, this);
    AppMethodBeat.o(128581);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128583);
    ad.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.irk != null) {
      this.irk.dismiss();
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).JJ() == 15))
    {
      paramn = (com.tencent.mm.modelfriend.a)paramn;
      this.dgo = paramn.axz();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.itU == 1)
        {
          com.tencent.mm.kernel.g.aeS().a(126, this);
          paramString = new u("", this.dom, this.bNK, 0, "", this.irb, "", "", this.dgo, 1, "", "", "", true, this.ivp);
          paramString.zd(this.itd);
          paramString.ze(this.iuO);
          paramString.oC(1);
          com.tencent.mm.kernel.g.aeS().a(paramString, 0);
          getString(2131755906);
          this.irk = h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128572);
              com.tencent.mm.kernel.g.aeS().a(paramString);
              com.tencent.mm.kernel.g.aeS().b(126, RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128572);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.dgo);
        paramString.putExtra("regsetinfo_user", this.irb);
        paramString.putExtra("regsession_id", this.itd);
        paramString.putExtra("reg_3d_app_ticket", this.iuO);
        paramString.putExtra("reg_3d_app_type", this.itW);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramn.axG());
        paramString.putExtra("key_reg_style", this.itU);
        paramString.setClass(this, RegSetInfoUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.h.a.oG(paramString);
        this.iqH.dVG = this.itW;
        this.iqH.dFd = 7L;
        this.iqH.aBj();
        if (paramString != null)
        {
          paramString.a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128573);
              com.tencent.mm.kernel.g.aeS().a(701, RegByMobileSendSmsUI.this);
              com.tencent.mm.kernel.g.aeS().a(252, RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.axy());
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dVG = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dFd = 8L;
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aBj();
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
            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.axy());
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dVG = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dFd = 8L;
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aBj();
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
        paramString.putExtra("ticket", this.dgo);
        paramString.putExtra("moble", this.irb);
        paramString.putExtra("regsession_id", this.itd);
        paramString.putExtra("reg_3d_app_ticket", this.iuO);
        paramString.putExtra("reg_3d_app_type", this.itW);
        paramString.putExtra("next_controll", paramn.axG());
        paramString.putExtra("username", paramn.getUsername());
        paramString.putExtra("password", paramn.axy());
        paramString.putExtra("nickname", paramn.axM());
        paramString.putExtra("avatar_url", paramn.axL());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.ivp);
        paramString.putExtra("kintent_nickname", this.bNK);
        paramString.putExtra("kintent_password", this.dom);
        paramString.putExtra("key_reg_style", this.itU);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if ((!bt.isNullOrNil(paramString)) && (this.irl >= 4))
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
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
        if (this.ivs == null)
        {
          this.ivs = SecurityImage.a.a(this, 0, localu.aAL(), localu.aAK(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128576);
              paramAnonymousDialogInterface = new u("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localu.aAK(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.zd(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.ze(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.oC(1);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              RegByMobileSendSmsUI localRegByMobileSendSmsUI = RegByMobileSendSmsUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileSendSmsUI.this.getContext();
              RegByMobileSendSmsUI.this.getString(2131755906);
              RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, h.b(localAppCompatActivity, RegByMobileSendSmsUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128575);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
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
            public final void aIs()
            {
              AppMethodBeat.i(128564);
              RegByMobileSendSmsUI.this.hideVKB();
              u localu = new u("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localu.aAK(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              localu.zd(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              localu.ze(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              localu.oC(1);
              com.tencent.mm.kernel.g.aeS().a(localu, 0);
              AppMethodBeat.o(128564);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.ivs.b(0, ((u)paramn).aAL(), ((u)paramn).aAK(), "");
        AppMethodBeat.o(128583);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.irb;
        this.iqH.dVG = this.itW;
        this.iqH.dFd = 6L;
        this.iqH.aBj();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dz(true);
        if (this.ivp)
        {
          paramn = b.aio() + "temp.avatar";
          String str = b.aio() + "temp.avatar.hd";
          i.lD(paramn, str);
          i.deleteFile(paramn);
          f.c(str, 96, 96, Bitmap.CompressFormat.JPEG, 90, paramn);
          new com.tencent.mm.ak.n(this, b.aio() + "temp.avatar").a(new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(128565);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localu.aAU());
              ay.gNa.aD("login_user_name", paramString);
              i.deleteFile(b.aio() + "temp.avatar");
              Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.afz();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.afz();
              com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128565);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128566);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localu.aAU());
              ay.gNa.aD("login_user_name", paramString);
              Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.afz();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.afz();
              com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128566);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.dgo = localu.aAU();
        ay.gNa.aD("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.aUz("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        paramString = paramString.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R200_600") + ",4");
        AppMethodBeat.o(128583);
        return;
      }
      paramString = com.tencent.mm.h.a.oG(paramString);
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
    com.tencent.mm.kernel.g.aeS().b(145, this);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    AppMethodBeat.o(128582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */