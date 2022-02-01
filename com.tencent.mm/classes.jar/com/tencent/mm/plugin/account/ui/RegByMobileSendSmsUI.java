package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.u;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements i
{
  private String fAo;
  private String fJS;
  private ms ncO;
  private String ncp;
  private String ndh;
  private String ndi;
  private h ndp;
  private ProgressDialog ndq;
  private int ndr;
  private Button nds;
  private MTimerHandler ndv;
  private int ndw;
  private String nfm;
  private String ngY;
  private int ngf;
  private int ngh;
  private boolean nhv;
  private SecurityImage nhy;
  private String nickName;
  private Button nik;
  
  public RegByMobileSendSmsUI()
  {
    AppMethodBeat.i(128577);
    this.ndh = "";
    this.ncp = "";
    this.ndi = "";
    this.nfm = "";
    this.ndw = 15;
    this.ncO = new ms();
    AppMethodBeat.o(128577);
  }
  
  private com.tencent.mm.pluginsdk.ui.span.m aaX(String paramString)
  {
    AppMethodBeat.i(128580);
    com.tencent.mm.pluginsdk.ui.span.m localm = new com.tencent.mm.pluginsdk.ui.span.m(paramString);
    Log.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localm.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(r.d.HugersTextSize)), i, paramString.length(), 33);
    localm.setSpan(new ForegroundColorSpan(getResources().getColor(r.c.green_text_color)), i, paramString.length(), 33);
    AppMethodBeat.o(128580);
    return localm;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128585);
    com.tencent.mm.ui.base.h.a(this, getString(r.j.regbymobile_reg_quit_send_sms), "", new DialogInterface.OnClickListener()
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
    if (this.ndv != null) {
      this.ndv.stopTimer();
    }
    this.nik.setText(r.j.regbymobile_reg_no_sim_send_sms_btn_title);
    this.nik.setEnabled(true);
    AppMethodBeat.o(128584);
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_send_sms_up;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128579);
    super.initView();
    ((TextView)findViewById(r.f.send_sms_tip)).setText(getString(r.j.regbymobile_reg_send_sms_tip, new Object[] { this.ndh }));
    ((TextView)findViewById(r.f.send_sms_content)).setText(aaX(getString(r.j.regbymobile_reg_send_sms_content, new Object[] { this.ncp })));
    ((TextView)findViewById(r.f.send_sms_to)).setText(aaX(getString(r.j.regbymobile_reg_send_sms_to, new Object[] { this.ndi })));
    this.nds = ((Button)findViewById(r.f.send_sms_btn));
    this.nik = ((Button)findViewById(r.f.next_btn));
    if (Util.isNullOrNil(new String[] { this.ndh, this.ndi, this.ncp }))
    {
      this.nds.setEnabled(false);
      this.nik.setEnabled(false);
      if (!Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.auI())) {
        break label248;
      }
      this.nds.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(r.j.regbymobile_reg_send_sms_title);
      setBackBtn(new RegByMobileSendSmsUI.10(this));
      AppMethodBeat.o(128579);
      return;
      this.nik.setOnClickListener(new RegByMobileSendSmsUI.1(this));
      break;
      label248:
      this.nds.setOnClickListener(new RegByMobileSendSmsUI.9(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128578);
    super.onCreate(paramBundle);
    this.ngf = getIntent().getIntExtra("key_reg_style", 1);
    this.ndh = Util.nullAsNil(getIntent().getStringExtra("from_mobile"));
    this.ndi = Util.nullAsNil(getIntent().getStringExtra("to_mobile"));
    this.ncp = Util.nullAsNil(getIntent().getStringExtra("verify_code"));
    this.nfm = Util.nullAsNil(getIntent().getStringExtra("regsession_id"));
    this.ngY = Util.nullAsNil(getIntent().getStringExtra("reg_3d_app_ticket"));
    this.nickName = Util.nullAsNil(getIntent().getStringExtra("kintent_nickname"));
    this.fJS = Util.nullAsNil(getIntent().getStringExtra("kintent_password"));
    this.nhv = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.ngh = getIntent().getIntExtra("reg_3d_app_type", 0);
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
    com.tencent.mm.kernel.h.aGY().a(145, this);
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    AppMethodBeat.o(128581);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(128583);
    Log.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.ndq != null) {
      this.ndq.dismiss();
    }
    if ((paramq.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramq).ZB() == 15))
    {
      paramq = (com.tencent.mm.modelfriend.a)paramq;
      this.fAo = paramq.bkW();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.ngf == 1)
        {
          com.tencent.mm.kernel.h.aGY().a(126, this);
          paramString = new v("", this.fJS, this.nickName, 0, "", this.ndh, "", "", this.fAo, 1, "", "", "", true, this.nhv);
          paramString.WZ(this.nfm);
          paramString.Xa(this.ngY);
          paramString.wL(1);
          com.tencent.mm.kernel.h.aGY().a(paramString, 0);
          getString(r.j.app_tip);
          this.ndq = com.tencent.mm.ui.base.h.a(this, getString(r.j.regbyqq_reg_waiting), true, new RegByMobileSendSmsUI.11(this, paramString));
          AppMethodBeat.o(128583);
          return;
        }
        paramString = new Intent();
        paramString.putExtra("regsetinfo_ticket", this.fAo);
        paramString.putExtra("regsetinfo_user", this.ndh);
        paramString.putExtra("regsession_id", this.nfm);
        paramString.putExtra("reg_3d_app_ticket", this.ngY);
        paramString.putExtra("reg_3d_app_type", this.ngh);
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("regsetinfo_ismobile", 4);
        paramString.putExtra("regsetinfo_NextControl", paramq.bld());
        paramString.putExtra("key_reg_style", this.ngf);
        paramString.setClass(this, RegSetInfoUI.class);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -35)
      {
        stopTimer();
        paramString = com.tencent.mm.h.a.Kb(paramString);
        this.ncO.gVr = this.ngh;
        this.ncO.gef = 7L;
        this.ncO.bpa();
        if (paramString != null)
        {
          paramString.a(this, new DialogInterface.OnClickListener()new RegByMobileSendSmsUI.13
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128573);
              com.tencent.mm.kernel.h.aGY().a(701, RegByMobileSendSmsUI.this);
              com.tencent.mm.kernel.h.aGY().a(252, RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramq.getUsername(), paramq.bkV());
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).gVr = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).gef = 8L;
              RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).bpa();
              AppMethodBeat.o(128573);
            }
          }, new RegByMobileSendSmsUI.13(this));
          AppMethodBeat.o(128583);
          return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(r.j.bind_mcontact_already_bind_relogin), null, new DialogInterface.OnClickListener()new RegByMobileSendSmsUI.15
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128574);
            RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, paramq.getUsername(), paramq.bkV());
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).gVr = RegByMobileSendSmsUI.e(RegByMobileSendSmsUI.this);
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).gef = 8L;
            RegByMobileSendSmsUI.f(RegByMobileSendSmsUI.this).bpa();
            AppMethodBeat.o(128574);
          }
        }, new RegByMobileSendSmsUI.15(this));
        AppMethodBeat.o(128583);
        return;
      }
      if (paramInt2 == -212)
      {
        stopTimer();
        paramString = new Intent(this, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", this.fAo);
        paramString.putExtra("moble", this.ndh);
        paramString.putExtra("regsession_id", this.nfm);
        paramString.putExtra("reg_3d_app_ticket", this.ngY);
        paramString.putExtra("reg_3d_app_type", this.ngh);
        paramString.putExtra("next_controll", paramq.bld());
        paramString.putExtra("username", paramq.getUsername());
        paramString.putExtra("password", paramq.bkV());
        paramString.putExtra("nickname", paramq.blj());
        paramString.putExtra("avatar_url", paramq.bli());
        paramString.putExtra("mobile_check_type", 1);
        paramString.putExtra("kintent_hasavatar", this.nhv);
        paramString.putExtra("kintent_nickname", this.nickName);
        paramString.putExtra("kintent_password", this.fJS);
        paramString.putExtra("key_reg_style", this.ngf);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128583);
        return;
      }
      if ((!Util.isNullOrNil(paramString)) && (this.ndr >= 4))
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128583);
          return;
        }
      }
      AppMethodBeat.o(128583);
      return;
    }
    if (paramq.getType() == 126)
    {
      final v localv = (v)paramq;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.nhy == null)
        {
          this.nhy = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, localv.boC(), localv.boB(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128576);
              paramAnonymousDialogInterface = new v("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localv.boB(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.WZ(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.Xa(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              paramAnonymousDialogInterface.wL(1);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              RegByMobileSendSmsUI localRegByMobileSendSmsUI = RegByMobileSendSmsUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileSendSmsUI.this.getContext();
              RegByMobileSendSmsUI.this.getString(r.j.app_tip);
              RegByMobileSendSmsUI.a(localRegByMobileSendSmsUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, RegByMobileSendSmsUI.this.getString(r.j.regbyqq_reg_waiting), true, new RegByMobileSendSmsUI.16.1(this, paramAnonymousDialogInterface)));
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
            public final void bxQ()
            {
              AppMethodBeat.i(128564);
              RegByMobileSendSmsUI.this.hideVKB();
              v localv = new v("", RegByMobileSendSmsUI.g(RegByMobileSendSmsUI.this), RegByMobileSendSmsUI.h(RegByMobileSendSmsUI.this), 0, "", RegByMobileSendSmsUI.i(RegByMobileSendSmsUI.this), "", "", RegByMobileSendSmsUI.j(RegByMobileSendSmsUI.this), 1, "", localv.boB(), RegByMobileSendSmsUI.k(RegByMobileSendSmsUI.this).getSecImgCode(), true, RegByMobileSendSmsUI.l(RegByMobileSendSmsUI.this));
              localv.WZ(RegByMobileSendSmsUI.m(RegByMobileSendSmsUI.this));
              localv.Xa(RegByMobileSendSmsUI.n(RegByMobileSendSmsUI.this));
              localv.wL(1);
              com.tencent.mm.kernel.h.aGY().a(localv, 0);
              AppMethodBeat.o(128564);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.nhy.b(0, ((v)paramq).boC(), ((v)paramq).boB(), "");
        AppMethodBeat.o(128583);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.ndh;
        this.ncO.gVr = this.ngh;
        this.ncO.gef = 6L;
        this.ncO.bpa();
        com.tencent.mm.kernel.b.aGG();
        com.tencent.mm.kernel.b.eQ(true);
        if (this.nhv)
        {
          paramq = com.tencent.mm.loader.j.b.aST() + "temp.avatar";
          String str = com.tencent.mm.loader.j.b.aST() + "temp.avatar.hd";
          u.oo(paramq, str);
          u.deleteFile(paramq);
          BitmapUtil.createThumbNail(str, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramq, true);
          new o(this, com.tencent.mm.loader.j.b.aST() + "temp.avatar").a(new Runnable()new Runnable
          {
            public final void run()
            {
              AppMethodBeat.i(128565);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localv.boL());
              bg.ltv.aS("login_user_name", paramString);
              u.deleteFile(com.tencent.mm.loader.j.b.aST() + "temp.avatar");
              Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$12", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.h.aHE();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.h.aHE();
              com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128565);
            }
          }, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(128566);
              RegByMobileSendSmsUI.a(RegByMobileSendSmsUI.this, localv.boL());
              bg.ltv.aS("login_user_name", paramString);
              Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegByMobileSendSmsUI.this);
              ((Intent)localObject2).addFlags(67108864);
              Object localObject1 = RegByMobileSendSmsUI.this;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((RegByMobileSendSmsUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localObject1 = new StringBuilder();
              com.tencent.mm.kernel.h.aHE();
              localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
              com.tencent.mm.kernel.h.aHE();
              com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_600") + ",4");
              RegByMobileSendSmsUI.this.finish();
              AppMethodBeat.o(128566);
            }
          });
          AppMethodBeat.o(128583);
          return;
        }
        this.fAo = localv.boL();
        bg.ltv.aS("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.plugin.b.a.bkD("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        paramString = paramString.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R200_600") + ",4");
        AppMethodBeat.o(128583);
        return;
      }
      paramString = com.tencent.mm.h.a.Kb(paramString);
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
    com.tencent.mm.kernel.h.aGY().b(145, this);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    AppMethodBeat.o(128582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */