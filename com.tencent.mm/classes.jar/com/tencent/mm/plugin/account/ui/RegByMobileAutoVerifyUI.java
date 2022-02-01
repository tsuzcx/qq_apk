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
import com.tencent.mm.am.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.qx;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.view.CheckBoxLicenseView;

public class RegByMobileAutoVerifyUI
  extends MMActivity
  implements i, a.a
{
  private String countryCode;
  private String fAo;
  private String fLC;
  private String kwF;
  private String nfm;
  private int ngf;
  private String nhr;
  private String nhs;
  private String nht;
  private String nhu;
  private boolean nhv;
  private int nhw;
  private ProgressDialog nhx;
  private SecurityImage nhy;
  private qx nhz;
  private String seq;
  
  public RegByMobileAutoVerifyUI()
  {
    AppMethodBeat.i(220162);
    this.nhw = 2;
    this.nhz = new qx();
    AppMethodBeat.o(220162);
  }
  
  private void bzN()
  {
    AppMethodBeat.i(220195);
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.mobile.verify.a.a.class)).getMobileToken(this.nhs, this.kwF, this);
    this.nhx = com.tencent.mm.ui.base.h.a(this, getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(219085);
        ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this));
        RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
        AppMethodBeat.o(219085);
      }
    });
    AppMethodBeat.o(220195);
  }
  
  public final void L(final Bundle paramBundle)
  {
    AppMethodBeat.i(220197);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215533);
        String str = paramBundle.getString("session", "");
        if ((!Util.isNullOrNil(str)) && (str.equals(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this))))
        {
          str = paramBundle.getString("token", "");
          Log.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", new Object[] { str });
          if (!Util.isNullOrNil(str))
          {
            RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, str);
            AppMethodBeat.o(215533);
            return;
          }
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).geN = 3;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).gSe = 2;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bpa();
          if (RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this) != null) {
            RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
          }
          com.tencent.mm.ui.base.h.a(RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(r.j.regbymobile_auto_verify_failed), "", RegByMobileAutoVerifyUI.this.getString(r.j.app_i_know), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(218658);
              RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(218658);
            }
          });
        }
        AppMethodBeat.o(215533);
      }
    });
    AppMethodBeat.o(220197);
  }
  
  public int getLayoutId()
  {
    return r.g.reg_by_mobile_autho_verify;
  }
  
  public void initView()
  {
    AppMethodBeat.i(220190);
    final Button localButton = (Button)findViewById(r.f.next_btn);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221434);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this) != 2) {
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(221434);
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
        AppMethodBeat.i(220454);
        if (paramAnonymousBoolean)
        {
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).geN = 1;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bpa();
        }
        localButton.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(220454);
      }
    });
    ((TextView)findViewById(r.f.reg_auto_mobile_tip)).setText(getString(r.j.regbymobile_auto_verify_mobile_tip, new Object[] { this.nhr }));
    ((TextView)findViewById(r.f.reg_not_my_mobile)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220156);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).geN = 2;
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).bpa();
        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220156);
      }
    });
    AppMethodBeat.o(220190);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(220193);
    this.nhz.geN = 4;
    this.nhz.bpa();
    super.onBackPressed();
    AppMethodBeat.o(220193);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(220180);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(r.c.white));
    hideActionbarLine();
    this.fLC = getIntent().getStringExtra("Key_Mobile");
    this.countryCode = getIntent().getStringExtra("Key_CountryCode");
    this.nhr = (this.countryCode + this.fLC);
    this.seq = getIntent().getStringExtra("Key_Seq");
    this.kwF = getIntent().getStringExtra("Key_Url");
    this.nfm = getIntent().getStringExtra("Key_reg_sessionId");
    this.nhs = (System.currentTimeMillis() + "_" + this.seq);
    this.nht = getIntent().getStringExtra("kintent_nickname");
    this.nhu = getIntent().getStringExtra("kintent_password");
    this.ngf = getIntent().getIntExtra("key_reg_style", 1);
    this.nhv = getIntent().getBooleanExtra("kintent_hasavatar", false);
    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", new Object[] { this.countryCode, this.fLC, this.seq, this.kwF, this.nht, Boolean.valueOf(this.nhv) });
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(213939);
        RegByMobileAutoVerifyUI.this.onBackPressed();
        AppMethodBeat.o(213939);
        return true;
      }
    });
    this.nhz.gto = System.currentTimeMillis();
    paramBundle = this.nhz;
    paramBundle.hlQ = paramBundle.z("DeviceID", com.tencent.mm.compatible.deviceinfo.q.auP(), true);
    paramBundle = this.nhz;
    paramBundle.hlP = paramBundle.z("RegisterMobile", this.nhr, true);
    com.tencent.mm.kernel.h.aGY().a(126, this);
    com.tencent.mm.kernel.h.aGY().a(145, this);
    AppMethodBeat.o(220180);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(220200);
    super.onDestroy();
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(this.nhs);
    com.tencent.mm.kernel.h.aGY().b(126, this);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    AppMethodBeat.o(220200);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(220242);
    Log.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", new Object[] { paramq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.nhx != null)
    {
      this.nhx.dismiss();
      this.nhx = null;
    }
    int i;
    if (paramq.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      Log.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", new Object[] { Integer.valueOf(i) });
      if (i == 14) {
        if (paramInt2 == 0)
        {
          this.nhw = ((com.tencent.mm.modelfriend.a)paramq).bkZ();
          Log.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", new Object[] { Integer.valueOf(this.nhw) });
          if (this.nhw == 2)
          {
            paramq = ((com.tencent.mm.modelfriend.a)paramq).blc();
            this.seq = paramq.seq;
            this.kwF = paramq.url;
            this.nhs = (System.currentTimeMillis() + "_" + this.seq);
            bzN();
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
          paramq = com.tencent.mm.h.a.Kb(paramString);
          if ((paramq == null) || (!paramq.a(this, null, null))) {
            break;
          }
          AppMethodBeat.o(220242);
          return;
          if (this.nhw == 1)
          {
            this.nhz.geN = 3;
            this.nhz.gSe = 2;
            this.nhz.bpa();
            localObject1 = ((com.tencent.mm.modelfriend.a)paramq).blb();
            paramq = ((com.tencent.mm.modelfriend.a)paramq).bla();
            localObject2 = new Intent(this, RegByMobileSendSmsUI.class);
            ((Intent)localObject2).putExtra("regsession_id", this.nfm);
            ((Intent)localObject2).putExtra("key_reg_style", 1);
            ((Intent)localObject2).putExtra("from_mobile", this.nhr);
            ((Intent)localObject2).putExtra("to_mobile", (String)localObject1);
            ((Intent)localObject2).putExtra("verify_code", paramq);
            ((Intent)localObject2).putExtra("kintent_nickname", this.nht);
            ((Intent)localObject2).putExtra("kintent_password", this.nhu);
            ((Intent)localObject2).putExtra("kintent_hasavatar", this.nhv);
            paramq = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramq.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramq.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            this.nhz.geN = 3;
            this.nhz.gSe = 2;
            this.nhz.bpa();
            i = ((com.tencent.mm.modelfriend.a)paramq).ble();
            int j = ((com.tencent.mm.modelfriend.a)paramq).blf();
            paramq = new Intent();
            paramq.putExtra("bindmcontact_mobile", this.nhr);
            paramq.putExtra("bindmcontact_shortmobile", this.fLC);
            paramq.putExtra("couttry_code", this.countryCode);
            paramq.putExtra("mobileverify_countdownsec", i);
            paramq.putExtra("mobileverify_countdownstyle", j);
            paramq.putExtra("kintent_hasavatar", this.nhv);
            paramq.putExtra("kintent_nickname", this.nht);
            paramq.putExtra("kintent_password", this.nhu);
            paramq.putExtra("key_reg_style", this.ngf);
            paramq.putExtra("regsession_id", this.nfm);
            paramq.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, paramq);
            finish();
            continue;
            if (paramInt2 == -41)
            {
              com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
              AppMethodBeat.o(220242);
              return;
            }
            if (paramInt2 == -34)
            {
              com.tencent.mm.ui.base.h.c(this, getString(r.j.bind_mcontact_err_freq_limit), "", true);
              AppMethodBeat.o(220242);
              return;
              if (i == 15)
              {
                paramq = (com.tencent.mm.modelfriend.a)paramq;
                this.fAo = paramq.bkW();
                if (paramInt2 == 0)
                {
                  this.nhz.geN = 3;
                  this.nhz.gSe = 1;
                  this.nhz.bpa();
                  if (this.ngf == 1)
                  {
                    com.tencent.mm.kernel.h.aGY().a(126, this);
                    paramq = new v("", this.nhu, this.nht, 0, "", this.nhr, "", "", this.fAo, 1, "", "", "", true, this.nhv);
                    paramq.WZ(this.nfm);
                    paramq.wL(this.nhw);
                    com.tencent.mm.kernel.h.aGY().a(paramq, 0);
                    getString(r.j.app_tip);
                    this.nhx = com.tencent.mm.ui.base.h.a(this, getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                      {
                        AppMethodBeat.i(214248);
                        com.tencent.mm.kernel.h.aGY().a(paramq);
                        com.tencent.mm.kernel.h.aGY().b(126, RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(214248);
                      }
                    });
                  }
                  else
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fAo);
                    ((Intent)localObject1).putExtra("regsetinfo_user", this.nhr);
                    ((Intent)localObject1).putExtra("regsession_id", this.nfm);
                    ((Intent)localObject1).putExtra("mobile_check_type", 1);
                    ((Intent)localObject1).putExtra("regsetinfo_ismobile", 4);
                    ((Intent)localObject1).putExtra("regsetinfo_NextControl", paramq.bld());
                    ((Intent)localObject1).putExtra("key_reg_style", this.ngf);
                    ((Intent)localObject1).setClass(this, RegSetInfoUI.class);
                    paramq = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.b(this, paramq.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramq.sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                }
                else if (paramInt2 == -35)
                {
                  this.nhz.geN = 3;
                  this.nhz.gSe = 2;
                  this.nhz.bpa();
                  localObject1 = com.tencent.mm.h.a.Kb(paramString);
                  if (localObject1 != null) {
                    ((com.tencent.mm.h.a)localObject1).a(this, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(216501);
                        com.tencent.mm.kernel.h.aGY().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.h.aGY().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramq.getUsername(), paramq.bkV());
                        AppMethodBeat.o(216501);
                      }
                    }, null);
                  } else {
                    com.tencent.mm.ui.base.h.a(this, getString(r.j.bind_mcontact_already_bind_relogin), null, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(216711);
                        com.tencent.mm.kernel.h.aGY().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.h.aGY().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramq.getUsername(), paramq.bkV());
                        AppMethodBeat.o(216711);
                      }
                    }, null);
                  }
                }
                else if (paramInt2 == -212)
                {
                  this.nhz.geN = 3;
                  this.nhz.gSe = 2;
                  this.nhz.bpa();
                  localObject1 = new Intent(this, MobileLoginOrForceReg.class);
                  ((Intent)localObject1).putExtra("ticket", this.fAo);
                  ((Intent)localObject1).putExtra("moble", this.nhr);
                  ((Intent)localObject1).putExtra("regsession_id", this.nfm);
                  ((Intent)localObject1).putExtra("next_controll", paramq.bld());
                  ((Intent)localObject1).putExtra("username", paramq.getUsername());
                  ((Intent)localObject1).putExtra("password", paramq.bkV());
                  ((Intent)localObject1).putExtra("nickname", paramq.blj());
                  ((Intent)localObject1).putExtra("avatar_url", paramq.bli());
                  ((Intent)localObject1).putExtra("mobile_check_type", this.nhw);
                  ((Intent)localObject1).putExtra("kintent_hasavatar", this.nhv);
                  ((Intent)localObject1).putExtra("kintent_nickname", this.nht);
                  ((Intent)localObject1).putExtra("kintent_password", this.nhu);
                  ((Intent)localObject1).putExtra("key_reg_style", this.ngf);
                  paramq = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.b(this, paramq.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  startActivity((Intent)paramq.sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  if ((paramInt2 == -449) || (paramInt2 == -450) || (paramInt2 == -451))
                  {
                    this.nhz.geN = 3;
                    this.nhz.gSe = 2;
                    this.nhz.bpa();
                    com.tencent.mm.ui.base.h.a(this, getString(r.j.regbymobile_auto_verify_failed), "", getString(r.j.app_i_know), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(216009);
                        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(216009);
                      }
                    });
                    AppMethodBeat.o(220242);
                    return;
                  }
                  this.nhz.geN = 3;
                  this.nhz.gSe = 2;
                  this.nhz.bpa();
                  Toast.makeText(this, getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
                }
              }
            }
          }
        }
      } while (paramq.getType() != 126);
      localObject1 = (v)paramq;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.nhy == null)
        {
          this.nhy = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, ((v)localObject1).boC(), ((v)localObject1).boB(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(215964);
              paramAnonymousDialogInterface = new v("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.nhC.boB(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.WZ(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.wL(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              RegByMobileAutoVerifyUI localRegByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileAutoVerifyUI.this.getContext();
              RegByMobileAutoVerifyUI.this.getString(r.j.app_tip);
              RegByMobileAutoVerifyUI.a(localRegByMobileAutoVerifyUI, com.tencent.mm.ui.base.h.a(localAppCompatActivity, RegByMobileAutoVerifyUI.this.getString(r.j.regbyqq_reg_waiting), true, new RegByMobileAutoVerifyUI.4.1(this, paramAnonymousDialogInterface)));
              AppMethodBeat.o(215964);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(219500);
              RegByMobileAutoVerifyUI.o(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(219500);
            }
          }, new SecurityImage.b()
          {
            public final void bxQ()
            {
              AppMethodBeat.i(215154);
              RegByMobileAutoVerifyUI.this.hideVKB();
              v localv = new v("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.nhC.boB(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              localv.WZ(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              localv.wL(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.h.aGY().a(localv, 0);
              AppMethodBeat.o(215154);
            }
          });
          AppMethodBeat.o(220242);
          return;
        }
        this.nhy.b(0, ((v)paramq).boC(), ((v)paramq).boB(), "");
        AppMethodBeat.o(220242);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.nhr;
    com.tencent.mm.kernel.b.aGG();
    com.tencent.mm.kernel.b.eQ(true);
    if (this.nhv)
    {
      paramq = com.tencent.mm.loader.j.b.aST() + "temp.avatar";
      localObject2 = com.tencent.mm.loader.j.b.aST() + "temp.avatar.hd";
      u.oo(paramq, (String)localObject2);
      u.deleteFile(paramq);
      BitmapUtil.createThumbNail((String)localObject2, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramq, true);
      new o(this, com.tencent.mm.loader.j.b.aST() + "temp.avatar").a(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(219806);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.nhC.boL());
          bg.ltv.aS("login_user_name", paramString);
          u.deleteFile(com.tencent.mm.loader.j.b.aST() + "temp.avatar");
          Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(219806);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214228);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.nhC.boL());
          bg.ltv.aS("login_user_name", paramString);
          Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(214228);
        }
      });
      AppMethodBeat.o(220242);
      return;
    }
    this.fAo = ((v)localObject1).boL();
    bg.ltv.aS("login_user_name", paramString);
    paramString = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
    paramString.addFlags(67108864);
    paramString.putExtra("LauncherUI.enter_from_reg", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.plugin.b.a.bkD("RE900_100");
    paramString = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    paramString = paramString.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R200_600") + ",4");
    AppMethodBeat.o(220242);
    return;
    com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(220242);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI
 * JD-Core Version:    0.7.0.1
 */