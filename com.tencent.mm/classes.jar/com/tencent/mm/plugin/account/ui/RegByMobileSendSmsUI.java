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
import com.tencent.mm.al.f;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements f
{
  private String bVF;
  private int countDown;
  private String dpf;
  private String dxJ;
  private gk jjW;
  private String jjx;
  private Button jkA;
  private av jkD;
  private String jkp;
  private String jkq;
  private g jkx;
  private ProgressDialog jky;
  private int jkz;
  private String jmq;
  private int jnh;
  private int jnk;
  private boolean joC;
  private SecurityImage joF;
  private String joc;
  private Button jpp;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(128577);
    this.jkp = "";
    this.jjx = "";
    this.jkq = "";
    this.jmq = "";
    this.countDown = 15;
    this.jjW = new gk();
    AppMethodBeat.o(128577);
  }
  
  private l JU(String paramString)
  {
    AppMethodBeat.i(128580);
    l locall = new l(paramString);
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
    if (this.jkD != null) {
      this.jkD.stopTimer();
    }
    this.jpp.setText(2131762330);
    this.jpp.setEnabled(true);
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
    ((TextView)findViewById(2131304584)).setText(getString(2131762336, new Object[] { this.jkp }));
    ((TextView)findViewById(2131304581)).setText(JU(getString(2131762335, new Object[] { this.jjx })));
    ((TextView)findViewById(2131304585)).setText(JU(getString(2131762338, new Object[] { this.jkq })));
    this.jkA = ((Button)findViewById(2131304580));
    this.jpp = ((Button)findViewById(2131302852));
    if (bt.V(new String[] { this.jkp, this.jkq, this.jjx }))
    {
      this.jkA.setEnabled(false);
      this.jpp.setEnabled(false);
      if (!bt.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso())) {
        break label248;
      }
      this.jkA.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(2131762337);
      setBackBtn(new RegByMobileSendSmsUI.10(this));
      AppMethodBeat.o(128579);
      return;
      this.jpp.setOnClickListener(new RegByMobileSendSmsUI.1(this));
      break;
      label248:
      this.jkA.setOnClickListener(new RegByMobileSendSmsUI.9(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128578);
    super.onCreate(paramBundle);
    this.jnh = getIntent().getIntExtra("key_reg_style", 1);
    this.jkp = bt.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.jkq = bt.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.jjx = bt.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.jmq = bt.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.joc = bt.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.bVF = bt.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.dxJ = bt.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.joC = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.jnk = getIntent().getIntExtra("reg_3d_app_type", 0);
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
    com.tencent.mm.kernel.g.aiU().a(145, this);
    com.tencent.mm.kernel.g.aiU().a(701, this);
    com.tencent.mm.kernel.g.aiU().a(252, this);
    AppMethodBeat.o(128581);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128583);
    ad.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.jky != null) {
      this.jky.dismiss();
    }
    if ((paramn.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramn).KR() == 15))
    {
      paramn = (com.tencent.mm.modelfriend.a)paramn;
      this.dpf = paramn.aHw();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.jnh == 1)
        {
          com.tencent.mm.kernel.g.aiU().a(126, this);
          paramString = new u("", this.dxJ, this.bVF, 0, "", this.jkp, "", "", this.dpf, 1, "", "", "", true, this.joC);
          paramString.Gn(this.jmq);
          paramString.Go(this.joc);
          paramString.pT(1);
          com.tencent.mm.kernel.g.aiU().a(paramString, 0);
          getString(2131755906);
          this.jky = h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(128572);
              com.tencent.mm.kernel.g.aiU().a(paramString);
              com.tencent.mm.kernel.g.aiU().b(126, RegByMobileSendSmsUI.this);
              AppMethodBeat.o(128572);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.dpf);
        paramString.putExtra("regsetinfo_user", this.jkp);
        paramString.putExtra("regsession_id", this.jmq);
        paramString.putExtra("reg_3d_app_ticket", this.joc);
        paramString.putExtra("reg_3d_app_type", this.jnk);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramn.aHD());
        paramString.putExtra("key_reg_style", this.jnh);
        paramString.setClass(this, RegSetInfoUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.h.a.uz(paramString);
        this.jjW.enS = this.jnk;
        this.jjW.dPl = 7L;
        this.jjW.aLk();
        if (paramString != null)
        {
          paramString.a(this, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128573);
              com.tencent.mm.kernel.g.aiU().a(701, RegByMobileSendSmsUI.this);
              com.tencent.mm.kernel.g.aiU().a(252, RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.aHv());
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).enS = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dPl = 8L;
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aLk();
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
            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramn.getUsername(), paramn.aHv());
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).enS = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).dPl = 8L;
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).aLk();
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
        paramString.putExtra("ticket", this.dpf);
        paramString.putExtra("moble", this.jkp);
        paramString.putExtra("regsession_id", this.jmq);
        paramString.putExtra("reg_3d_app_ticket", this.joc);
        paramString.putExtra("reg_3d_app_type", this.jnk);
        paramString.putExtra("next_controll", paramn.aHD());
        paramString.putExtra("username", paramn.getUsername());
        paramString.putExtra("password", paramn.aHv());
        paramString.putExtra("nickname", paramn.aHJ());
        paramString.putExtra("avatar_url", paramn.aHI());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.joC);
        paramString.putExtra("kintent_nickname", this.bVF);
        paramString.putExtra("kintent_password", this.dxJ);
        paramString.putExtra("key_reg_style", this.jnh);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if ((!bt.isNullOrNil(paramString)) && (this.jkz >= 4))
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
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
        if (this.joF == null)
        {
          this.joF = SecurityImage.a.a(this, 0, localu.aKM(), localu.aKL(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128576);
              paramAnonymousDialogInterface = new u("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localu.aKL(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.Gn(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.Go(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.pT(1);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              RegByMobileSendSmsUI localRegByMobileSendSmsUI = RegByMobileSendSmsUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileSendSmsUI.this.getContext();
              RegByMobileSendSmsUI.this.getString(2131755906);
              RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, h.b(localAppCompatActivity, RegByMobileSendSmsUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128575);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
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
            public final void aSv()
            {
              AppMethodBeat.i(128564);
              RegByMobileSendSmsUI.this.hideVKB();
              u localu = new u("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localu.aKL(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              localu.Gn(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              localu.Go(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              localu.pT(1);
              com.tencent.mm.kernel.g.aiU().a(localu, 0);
              AppMethodBeat.o(128564);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.joF.b(0, ((u)paramn).aKM(), ((u)paramn).aKL(), "");
        AppMethodBeat.o(128583);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.jkp;
        this.jjW.enS = this.jnk;
        this.jjW.dPl = 6L;
        this.jjW.aLk();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.dB(true);
        if (this.joC)
        {
          paramn = b.asc() + "temp.avatar";
          String str = b.asc() + "temp.avatar.hd";
          i.mA(paramn, str);
          i.deleteFile(paramn);
          com.tencent.mm.sdk.platformtools.g.c(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramn);
          new com.tencent.mm.ak.n(this, b.asc() + "temp.avatar").a(new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(128565);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localu.aKV());
              az.hFS.aM("login_user_name", paramString);
              i.deleteFile(b.asc() + "temp.avatar");
              Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.ajA();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.ajA();
              com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128565);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128566);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localu.aKV());
              az.hFS.aM("login_user_name", paramString);
              Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.g.ajA();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.g.ajA();
              com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128566);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.dpf = localu.aKV();
        az.hFS.aM("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.Ma("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        paramString = paramString.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_600") + ",4");
        AppMethodBeat.o(128583);
        return;
      }
      paramString = com.tencent.mm.h.a.uz(paramString);
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
    com.tencent.mm.kernel.g.aiU().b(145, this);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
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