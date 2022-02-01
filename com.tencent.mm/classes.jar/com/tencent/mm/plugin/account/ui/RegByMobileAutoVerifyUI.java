package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.us;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.CheckBoxLicenseView;

public class RegByMobileAutoVerifyUI
  extends MMActivity
  implements com.tencent.mm.am.h, a.a
{
  private String countryCode;
  private String hFb;
  private String hRk;
  private String nag;
  private String qcu;
  private int qdn;
  private String qeM;
  private String qeN;
  private String qeO;
  private String qeP;
  private boolean qeQ;
  private int qeR;
  private ProgressDialog qeS;
  private SecurityImage qeT;
  private us qeU;
  private String seq;
  
  public RegByMobileAutoVerifyUI()
  {
    AppMethodBeat.i(304974);
    this.qeR = 2;
    this.qeU = new us();
    AppMethodBeat.o(304974);
  }
  
  private void bYC()
  {
    AppMethodBeat.i(304975);
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.mobile.verify.a.a.class)).getMobileToken(this.qeN, this.nag, this);
    this.qeS = k.a(this, getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(305033);
        ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this));
        RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
        AppMethodBeat.o(305033);
      }
    });
    AppMethodBeat.o(304975);
  }
  
  private static void bYr()
  {
    AppMethodBeat.i(304977);
    if (cj.onp)
    {
      cj.ono.Kc(z.bAM());
      cj.ono.g(z.bAM(), z.bBM());
      cj.onp = false;
    }
    AppMethodBeat.o(304977);
  }
  
  public final void U(final Bundle paramBundle)
  {
    AppMethodBeat.i(305012);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305031);
        String str = paramBundle.getString("session", "");
        if ((!Util.isNullOrNil(str)) && (str.equals(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this))))
        {
          str = paramBundle.getString("token", "");
          Log.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", new Object[] { str });
          if (!Util.isNullOrNil(str))
          {
            RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, str);
            AppMethodBeat.o(305031);
            return;
          }
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).ilm = 3;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).jkA = 2;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bMH();
          if (RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this) != null) {
            RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
          }
          k.a(RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(r.j.regbymobile_auto_verify_failed), "", RegByMobileAutoVerifyUI.this.getString(r.j.app_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(305248);
              RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(305248);
            }
          });
        }
        AppMethodBeat.o(305031);
      }
    });
    AppMethodBeat.o(305012);
  }
  
  public int getLayoutId()
  {
    return r.g.reg_by_mobile_autho_verify;
  }
  
  public void initView()
  {
    AppMethodBeat.i(305010);
    final Button localButton = (Button)findViewById(r.f.next_btn);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(304930);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this) != 2) {
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(304930);
          return;
          RegByMobileAutoVerifyUI.c(RegByMobileAutoVerifyUI.this);
        }
      }
    });
    CheckBoxLicenseView localCheckBoxLicenseView = (CheckBoxLicenseView)findViewById(r.f.reg_auto_get_mobile);
    localCheckBoxLicenseView.setTermTip(getString(r.j.regbymobile_auto_verify_term_tip));
    localCheckBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(305020);
        if (paramAnonymousBoolean)
        {
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).ilm = 1;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bMH();
        }
        localButton.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(305020);
      }
    });
    ((TextView)findViewById(r.f.reg_auto_mobile_tip)).setText(getString(r.j.regbymobile_auto_verify_mobile_tip, new Object[] { this.qeM }));
    ((TextView)findViewById(r.f.reg_not_my_mobile)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305019);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).ilm = 2;
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bMH();
        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305019);
      }
    });
    AppMethodBeat.o(305010);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(305011);
    this.qeU.ilm = 4;
    this.qeU.bMH();
    super.onBackPressed();
    AppMethodBeat.o(305011);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305008);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(r.c.white));
    hideActionbarLine();
    this.hRk = getIntent().getStringExtra("Key_Mobile");
    this.countryCode = getIntent().getStringExtra("Key_CountryCode");
    this.qeM = (this.countryCode + this.hRk);
    this.seq = getIntent().getStringExtra("Key_Seq");
    this.nag = getIntent().getStringExtra("Key_Url");
    this.qcu = getIntent().getStringExtra("Key_reg_sessionId");
    this.qeN = (System.currentTimeMillis() + "_" + this.seq);
    this.qeO = getIntent().getStringExtra("kintent_nickname");
    this.qeP = getIntent().getStringExtra("kintent_password");
    this.qdn = getIntent().getIntExtra("key_reg_style", 1);
    this.qeQ = getIntent().getBooleanExtra("kintent_hasavatar", false);
    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", new Object[] { this.countryCode, this.hRk, this.seq, this.nag, this.qeO, Boolean.valueOf(this.qeQ) });
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(304958);
        RegByMobileAutoVerifyUI.this.onBackPressed();
        AppMethodBeat.o(304958);
        return true;
      }
    });
    this.qeU.iEj = System.currentTimeMillis();
    paramBundle = this.qeU;
    paramBundle.jlW = paramBundle.F("DeviceID", q.aPj(), true);
    paramBundle = this.qeU;
    paramBundle.jHP = paramBundle.F("RegisterMobile", this.qeM, true);
    com.tencent.mm.kernel.h.aZW().a(126, this);
    com.tencent.mm.kernel.h.aZW().a(145, this);
    AppMethodBeat.o(305008);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305013);
    super.onDestroy();
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(this.qeN);
    com.tencent.mm.kernel.h.aZW().b(126, this);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    AppMethodBeat.o(305013);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final p paramp)
  {
    AppMethodBeat.i(305024);
    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", new Object[] { paramp, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.qeS != null)
    {
      this.qeS.dismiss();
      this.qeS = null;
    }
    int i;
    if (paramp.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      Log.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", new Object[] { Integer.valueOf(i) });
      if (i == 14) {
        if (paramInt2 == 0)
        {
          this.qeR = ((com.tencent.mm.modelfriend.a)paramp).bIT();
          Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", new Object[] { Integer.valueOf(this.qeR) });
          if (this.qeR == 2)
          {
            paramp = ((com.tencent.mm.modelfriend.a)paramp).bIW();
            this.seq = paramp.seq;
            this.nag = paramp.url;
            this.qeN = (System.currentTimeMillis() + "_" + this.seq);
            bYC();
          }
        }
      }
    }
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        for (;;)
        {
          paramp = com.tencent.mm.broadcast.a.CH(paramString);
          if ((paramp == null) || (!paramp.a(this, null, null))) {
            break;
          }
          AppMethodBeat.o(305024);
          return;
          if (this.qeR == 1)
          {
            this.qeU.ilm = 3;
            this.qeU.jkA = 2;
            this.qeU.bMH();
            localObject1 = ((com.tencent.mm.modelfriend.a)paramp).bIV();
            paramp = ((com.tencent.mm.modelfriend.a)paramp).bIU();
            localObject2 = new Intent(this, RegByMobileSendSmsUI.class);
            ((Intent)localObject2).putExtra("regsession_id", this.qcu);
            ((Intent)localObject2).putExtra("key_reg_style", 1);
            ((Intent)localObject2).putExtra("from_mobile", this.qeM);
            ((Intent)localObject2).putExtra("to_mobile", (String)localObject1);
            ((Intent)localObject2).putExtra("verify_code", paramp);
            ((Intent)localObject2).putExtra("kintent_nickname", this.qeO);
            ((Intent)localObject2).putExtra("kintent_password", this.qeP);
            ((Intent)localObject2).putExtra("kintent_hasavatar", this.qeQ);
            paramp = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramp.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramp.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            this.qeU.ilm = 3;
            this.qeU.jkA = 2;
            this.qeU.bMH();
            i = ((com.tencent.mm.modelfriend.a)paramp).bIY();
            int j = ((com.tencent.mm.modelfriend.a)paramp).bIZ();
            paramp = new Intent();
            paramp.putExtra("bindmcontact_mobile", this.qeM);
            paramp.putExtra("bindmcontact_shortmobile", this.hRk);
            paramp.putExtra("couttry_code", this.countryCode);
            paramp.putExtra("mobileverify_countdownsec", i);
            paramp.putExtra("mobileverify_countdownstyle", j);
            paramp.putExtra("kintent_hasavatar", this.qeQ);
            paramp.putExtra("kintent_nickname", this.qeO);
            paramp.putExtra("kintent_password", this.qeP);
            paramp.putExtra("key_reg_style", this.qdn);
            paramp.putExtra("regsession_id", this.qcu);
            paramp.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, paramp);
            finish();
            continue;
            if (paramInt2 == -41)
            {
              k.s(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
              AppMethodBeat.o(305024);
              return;
            }
            if (paramInt2 == -34)
            {
              k.c(this, getString(r.j.bind_mcontact_err_freq_limit), "", true);
              AppMethodBeat.o(305024);
              return;
              if (i == 15)
              {
                paramp = (com.tencent.mm.modelfriend.a)paramp;
                this.hFb = paramp.bIQ();
                if (paramInt2 == 0)
                {
                  this.qeU.ilm = 3;
                  this.qeU.jkA = 1;
                  this.qeU.bMH();
                  if (this.qdn == 1)
                  {
                    com.tencent.mm.kernel.h.aZW().a(126, this);
                    paramp = new w("", this.qeP, this.qeO, 0, "", this.qeM, "", "", this.hFb, 1, "", "", "", true, this.qeQ);
                    paramp.OZ(this.qcu);
                    paramp.wL(this.qeR);
                    com.tencent.mm.kernel.h.aZW().a(paramp, 0);
                    getString(r.j.app_tip);
                    this.qeS = k.a(this, getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                      {
                        AppMethodBeat.i(305036);
                        com.tencent.mm.kernel.h.aZW().a(paramp);
                        com.tencent.mm.kernel.h.aZW().b(126, RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(305036);
                      }
                    });
                  }
                  else
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("regsetinfo_ticket", this.hFb);
                    ((Intent)localObject1).putExtra("regsetinfo_user", this.qeM);
                    ((Intent)localObject1).putExtra("regsession_id", this.qcu);
                    ((Intent)localObject1).putExtra("mobile_check_type", 1);
                    ((Intent)localObject1).putExtra("regsetinfo_ismobile", 4);
                    ((Intent)localObject1).putExtra("regsetinfo_NextControl", paramp.bIX());
                    ((Intent)localObject1).putExtra("key_reg_style", this.qdn);
                    ((Intent)localObject1).setClass(this, RegSetInfoUI.class);
                    paramp = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.b(this, paramp.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramp.sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                }
                else if (paramInt2 == -35)
                {
                  this.qeU.ilm = 3;
                  this.qeU.jkA = 2;
                  this.qeU.bMH();
                  localObject1 = com.tencent.mm.broadcast.a.CH(paramString);
                  if (localObject1 != null) {
                    ((com.tencent.mm.broadcast.a)localObject1).a(this, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(305026);
                        com.tencent.mm.kernel.h.aZW().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.h.aZW().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramp.getUsername(), paramp.bIP());
                        AppMethodBeat.o(305026);
                      }
                    }, null);
                  } else {
                    k.a(this, getString(r.j.bind_mcontact_already_bind_relogin), null, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(304954);
                        com.tencent.mm.kernel.h.aZW().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.h.aZW().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramp.getUsername(), paramp.bIP());
                        AppMethodBeat.o(304954);
                      }
                    }, null);
                  }
                }
                else if (paramInt2 == -212)
                {
                  this.qeU.ilm = 3;
                  this.qeU.jkA = 2;
                  this.qeU.bMH();
                  localObject1 = new Intent(this, MobileLoginOrForceReg.class);
                  ((Intent)localObject1).putExtra("ticket", this.hFb);
                  ((Intent)localObject1).putExtra("moble", this.qeM);
                  ((Intent)localObject1).putExtra("regsession_id", this.qcu);
                  ((Intent)localObject1).putExtra("next_controll", paramp.bIX());
                  ((Intent)localObject1).putExtra("username", paramp.getUsername());
                  ((Intent)localObject1).putExtra("password", paramp.bIP());
                  ((Intent)localObject1).putExtra("nickname", paramp.bJd());
                  ((Intent)localObject1).putExtra("avatar_url", paramp.bJc());
                  ((Intent)localObject1).putExtra("mobile_check_type", this.qeR);
                  ((Intent)localObject1).putExtra("kintent_hasavatar", this.qeQ);
                  ((Intent)localObject1).putExtra("kintent_nickname", this.qeO);
                  ((Intent)localObject1).putExtra("kintent_password", this.qeP);
                  ((Intent)localObject1).putExtra("key_reg_style", this.qdn);
                  paramp = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.b(this, paramp.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  startActivity((Intent)paramp.sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  if ((paramInt2 == -449) || (paramInt2 == -450) || (paramInt2 == -451))
                  {
                    this.qeU.ilm = 3;
                    this.qeU.jkA = 2;
                    this.qeU.bMH();
                    k.a(this, getString(r.j.regbymobile_auto_verify_failed), "", getString(r.j.app_i_know), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(304955);
                        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(304955);
                      }
                    });
                    AppMethodBeat.o(305024);
                    return;
                  }
                  this.qeU.ilm = 3;
                  this.qeU.jkA = 2;
                  this.qeU.bMH();
                  Toast.makeText(this, getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
                }
              }
            }
          }
        }
      } while (paramp.getType() != 126);
      localObject1 = (w)paramp;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.qeT == null)
        {
          this.qeT = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, ((w)localObject1).bMj(), ((w)localObject1).bMi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(304949);
              paramAnonymousDialogInterface = new w("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.qeX.bMi(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.OZ(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.wL(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              RegByMobileAutoVerifyUI localRegByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileAutoVerifyUI.this.getContext();
              RegByMobileAutoVerifyUI.this.getString(r.j.app_tip);
              RegByMobileAutoVerifyUI.a(localRegByMobileAutoVerifyUI, k.a(localAppCompatActivity, RegByMobileAutoVerifyUI.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(305080);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(305080);
                }
              }));
              AppMethodBeat.o(304949);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(304948);
              RegByMobileAutoVerifyUI.o(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(304948);
            }
          }, new SecurityImage.b()
          {
            public final void bWF()
            {
              AppMethodBeat.i(304938);
              RegByMobileAutoVerifyUI.this.hideVKB();
              w localw = new w("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.qeX.bMi(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              localw.OZ(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              localw.wL(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.h.aZW().a(localw, 0);
              AppMethodBeat.o(304938);
            }
          });
          AppMethodBeat.o(305024);
          return;
        }
        this.qeT.b(0, ((w)paramp).bMj(), ((w)paramp).bMi(), "");
        AppMethodBeat.o(305024);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.qeM;
    com.tencent.mm.kernel.b.aZI();
    com.tencent.mm.kernel.b.fA(true);
    com.tencent.mm.plugin.report.service.l.kK(1, 8);
    com.tencent.mm.plugin.report.service.l.kK(1, 3);
    com.tencent.mm.plugin.report.service.l.kK(1, 1);
    if (this.qeQ)
    {
      paramp = com.tencent.mm.loader.i.b.bmH() + "temp.avatar";
      localObject2 = com.tencent.mm.loader.i.b.bmH() + "temp.avatar.hd";
      y.qn(paramp, (String)localObject2);
      y.deleteFile(paramp);
      BitmapUtil.createThumbNail((String)localObject2, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramp, true);
      new o(this, com.tencent.mm.loader.i.b.bmH() + "temp.avatar", true).a(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(304942);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.qeX.bMs());
          bg.okT.bc("login_user_name", paramString);
          y.deleteFile(com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
          Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
          RegByMobileAutoVerifyUI.bYD();
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(304942);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(304933);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.qeX.bMs());
          bg.okT.bc("login_user_name", paramString);
          Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
          RegByMobileAutoVerifyUI.bYD();
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(304933);
        }
      });
      AppMethodBeat.o(305024);
      return;
    }
    this.hFb = ((w)localObject1).bMs();
    bg.okT.bc("login_user_name", paramString);
    paramString = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
    paramString.addFlags(67108864);
    paramString.putExtra("LauncherUI.enter_from_reg", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    bYr();
    finish();
    com.tencent.mm.plugin.b.a.TA("RE900_100");
    paramString = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    paramString = paramString.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("R200_600") + ",4");
    AppMethodBeat.o(305024);
    return;
    com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(305024);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI
 * JD-Core Version:    0.7.0.1
 */