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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gz;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import com.tencent.mm.view.CheckBoxLicenseView;

public class RegByMobileAutoVerifyUI
  extends MMActivity
  implements com.tencent.mm.al.g, a.a
{
  private String countryCode;
  private String dgo;
  private String dpO;
  private int itU;
  private String itd;
  private String ivj;
  private String ivk;
  private String ivl;
  private String ivm;
  private String ivn;
  private String ivo;
  private boolean ivp;
  private int ivq;
  private ProgressDialog ivr;
  private SecurityImage ivs;
  private gz ivt;
  
  public RegByMobileAutoVerifyUI()
  {
    AppMethodBeat.i(193642);
    this.ivq = 2;
    this.ivt = new gz();
    AppMethodBeat.o(193642);
  }
  
  private void aKm()
  {
    AppMethodBeat.i(193646);
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).getMobileToken(this.ivm, this.ivl, this);
    this.ivr = h.b(this, getString(2131756503), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(193636);
        ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this));
        RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
        AppMethodBeat.o(193636);
      }
    });
    AppMethodBeat.o(193646);
  }
  
  public int getLayoutId()
  {
    return 2131495236;
  }
  
  public void initView()
  {
    AppMethodBeat.i(193644);
    final Button localButton = (Button)findViewById(2131302852);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193633);
        if (RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this) != 2)
        {
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
          AppMethodBeat.o(193633);
          return;
        }
        RegByMobileAutoVerifyUI.c(RegByMobileAutoVerifyUI.this);
        AppMethodBeat.o(193633);
      }
    });
    CheckBoxLicenseView localCheckBoxLicenseView = (CheckBoxLicenseView)findViewById(2131303933);
    localCheckBoxLicenseView.setTermTip(getString(2131762325));
    localCheckBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193634);
        if (paramAnonymousBoolean)
        {
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dJp = 1;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aBj();
        }
        localButton.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(193634);
      }
    });
    ((TextView)findViewById(2131303934)).setText(getString(2131762322, new Object[] { this.ivj }));
    ((TextView)findViewById(2131303941)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193635);
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dJp = 2;
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aBj();
        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
        AppMethodBeat.o(193635);
      }
    });
    AppMethodBeat.o(193644);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(193645);
    this.ivt.dJp = 4;
    this.ivt.aBj();
    super.onBackPressed();
    AppMethodBeat.o(193645);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193643);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dpO = getIntent().getStringExtra("Key_Mobile");
    this.countryCode = getIntent().getStringExtra("Key_CountryCode");
    this.ivj = (this.countryCode + this.dpO);
    this.ivk = getIntent().getStringExtra("Key_Seq");
    this.ivl = getIntent().getStringExtra("Key_Url");
    this.itd = getIntent().getStringExtra("Key_reg_sessionId");
    this.ivm = (System.currentTimeMillis() + "_" + this.ivk);
    this.ivn = getIntent().getStringExtra("kintent_nickname");
    this.ivo = getIntent().getStringExtra("kintent_password");
    this.itU = getIntent().getIntExtra("key_reg_style", 1);
    this.ivp = getIntent().getBooleanExtra("kintent_hasavatar", false);
    ad.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", new Object[] { this.countryCode, this.dpO, this.ivk, this.ivl, this.ivn, Boolean.valueOf(this.ivp) });
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193624);
        RegByMobileAutoVerifyUI.this.onBackPressed();
        AppMethodBeat.o(193624);
        return true;
      }
    });
    this.ivt.dNO = System.currentTimeMillis();
    paramBundle = this.ivt;
    paramBundle.ejs = paramBundle.t("DeviceID", com.tencent.mm.compatible.deviceinfo.q.Xd(), true);
    paramBundle = this.ivt;
    paramBundle.ejr = paramBundle.t("RegisterMobile", this.ivj, true);
    com.tencent.mm.kernel.g.aeS().a(126, this);
    com.tencent.mm.kernel.g.aeS().a(145, this);
    AppMethodBeat.o(193643);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193648);
    super.onDestroy();
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(this.ivm);
    com.tencent.mm.kernel.g.aeS().b(126, this);
    com.tencent.mm.kernel.g.aeS().b(145, this);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    AppMethodBeat.o(193648);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(193649);
    ad.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.ivr != null)
    {
      this.ivr.dismiss();
      this.ivr = null;
    }
    int i;
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).JJ();
      ad.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", new Object[] { Integer.valueOf(i) });
      if (i == 14) {
        if (paramInt2 == 0)
        {
          this.ivq = ((com.tencent.mm.modelfriend.a)paramn).axC();
          ad.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", new Object[] { Integer.valueOf(this.ivq) });
          if (this.ivq == 2)
          {
            paramn = ((com.tencent.mm.modelfriend.a)paramn).axF();
            this.ivk = paramn.ivk;
            this.ivl = paramn.url;
            this.ivm = (System.currentTimeMillis() + "_" + this.ivk);
            aKm();
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
          paramn = com.tencent.mm.h.a.oG(paramString);
          if ((paramn == null) || (!paramn.a(this, null, null))) {
            break;
          }
          AppMethodBeat.o(193649);
          return;
          if (this.ivq == 1)
          {
            this.ivt.dJp = 3;
            this.ivt.dUs = 2;
            this.ivt.aBj();
            localObject1 = ((com.tencent.mm.modelfriend.a)paramn).axE();
            paramn = ((com.tencent.mm.modelfriend.a)paramn).axD();
            localObject2 = new Intent(this, RegByMobileSendSmsUI.class);
            ((Intent)localObject2).putExtra("regsession_id", this.itd);
            ((Intent)localObject2).putExtra("key_reg_style", 1);
            ((Intent)localObject2).putExtra("from_mobile", this.ivj);
            ((Intent)localObject2).putExtra("to_mobile", (String)localObject1);
            ((Intent)localObject2).putExtra("verify_code", paramn);
            ((Intent)localObject2).putExtra("kintent_nickname", this.ivn);
            ((Intent)localObject2).putExtra("kintent_password", this.ivo);
            ((Intent)localObject2).putExtra("kintent_hasavatar", this.ivp);
            paramn = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramn.adn(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramn.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            this.ivt.dJp = 3;
            this.ivt.dUs = 2;
            this.ivt.aBj();
            i = ((com.tencent.mm.modelfriend.a)paramn).axH();
            int j = ((com.tencent.mm.modelfriend.a)paramn).axI();
            paramn = new Intent();
            paramn.putExtra("bindmcontact_mobile", this.ivj);
            paramn.putExtra("bindmcontact_shortmobile", this.dpO);
            paramn.putExtra("couttry_code", this.countryCode);
            paramn.putExtra("mobileverify_countdownsec", i);
            paramn.putExtra("mobileverify_countdownstyle", j);
            paramn.putExtra("kintent_hasavatar", this.ivp);
            paramn.putExtra("kintent_nickname", this.ivn);
            paramn.putExtra("kintent_password", this.ivo);
            paramn.putExtra("key_reg_style", this.itU);
            paramn.putExtra("regsession_id", this.itd);
            paramn.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, paramn);
            finish();
            continue;
            if (paramInt2 == -41)
            {
              h.j(this, 2131762328, 2131762329);
              AppMethodBeat.o(193649);
              return;
            }
            if (paramInt2 == -34)
            {
              h.c(this, getString(2131756462), "", true);
              AppMethodBeat.o(193649);
              return;
              if (i == 15)
              {
                paramn = (com.tencent.mm.modelfriend.a)paramn;
                this.dgo = paramn.axz();
                if (paramInt2 == 0)
                {
                  this.ivt.dJp = 3;
                  this.ivt.dUs = 1;
                  this.ivt.aBj();
                  if (this.itU == 1)
                  {
                    com.tencent.mm.kernel.g.aeS().a(126, this);
                    paramn = new u("", this.ivo, this.ivn, 0, "", this.ivj, "", "", this.dgo, 1, "", "", "", true, this.ivp);
                    paramn.zd(this.itd);
                    paramn.oC(this.ivq);
                    com.tencent.mm.kernel.g.aeS().a(paramn, 0);
                    getString(2131755906);
                    this.ivr = h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                      {
                        AppMethodBeat.i(193640);
                        com.tencent.mm.kernel.g.aeS().a(paramn);
                        com.tencent.mm.kernel.g.aeS().b(126, RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(193640);
                      }
                    });
                  }
                  else
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("regsetinfo_ticket", this.dgo);
                    ((Intent)localObject1).putExtra("regsetinfo_user", this.ivj);
                    ((Intent)localObject1).putExtra("regsession_id", this.itd);
                    ((Intent)localObject1).putExtra("mobile_check_type", 1);
                    ((Intent)localObject1).putExtra("regsetinfo_ismobile", 4);
                    ((Intent)localObject1).putExtra("regsetinfo_NextControl", paramn.axG());
                    ((Intent)localObject1).putExtra("key_reg_style", this.itU);
                    ((Intent)localObject1).setClass(this, RegSetInfoUI.class);
                    paramn = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.adn(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramn.lS(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                }
                else if (paramInt2 == -35)
                {
                  this.ivt.dJp = 3;
                  this.ivt.dUs = 2;
                  this.ivt.aBj();
                  localObject1 = com.tencent.mm.h.a.oG(paramString);
                  if (localObject1 != null) {
                    ((com.tencent.mm.h.a)localObject1).a(this, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(193641);
                        com.tencent.mm.kernel.g.aeS().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.g.aeS().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.axy());
                        AppMethodBeat.o(193641);
                      }
                    }, null);
                  } else {
                    h.a(this, getString(2131756444), null, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(193625);
                        com.tencent.mm.kernel.g.aeS().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.g.aeS().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.axy());
                        AppMethodBeat.o(193625);
                      }
                    }, null);
                  }
                }
                else if (paramInt2 == -212)
                {
                  this.ivt.dJp = 3;
                  this.ivt.dUs = 2;
                  this.ivt.aBj();
                  localObject1 = new Intent(this, MobileLoginOrForceReg.class);
                  ((Intent)localObject1).putExtra("ticket", this.dgo);
                  ((Intent)localObject1).putExtra("moble", this.ivj);
                  ((Intent)localObject1).putExtra("regsession_id", this.itd);
                  ((Intent)localObject1).putExtra("next_controll", paramn.axG());
                  ((Intent)localObject1).putExtra("username", paramn.getUsername());
                  ((Intent)localObject1).putExtra("password", paramn.axy());
                  ((Intent)localObject1).putExtra("nickname", paramn.axM());
                  ((Intent)localObject1).putExtra("avatar_url", paramn.axL());
                  ((Intent)localObject1).putExtra("mobile_check_type", this.ivq);
                  ((Intent)localObject1).putExtra("kintent_hasavatar", this.ivp);
                  ((Intent)localObject1).putExtra("kintent_nickname", this.ivn);
                  ((Intent)localObject1).putExtra("kintent_password", this.ivo);
                  ((Intent)localObject1).putExtra("key_reg_style", this.itU);
                  paramn = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, paramn.adn(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  startActivity((Intent)paramn.lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  if ((paramInt2 == -449) || (paramInt2 == -450) || (paramInt2 == -451))
                  {
                    this.ivt.dJp = 3;
                    this.ivt.dUs = 2;
                    this.ivt.aBj();
                    h.a(this, getString(2131762320), "", getString(2131755792), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(193626);
                        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(193626);
                      }
                    });
                    AppMethodBeat.o(193649);
                    return;
                  }
                  this.ivt.dJp = 3;
                  this.ivt.dUs = 2;
                  this.ivt.aBj();
                  Toast.makeText(this, getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
                }
              }
            }
          }
        }
      } while (paramn.getType() != 126);
      localObject1 = (u)paramn;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.ivs == null)
        {
          this.ivs = SecurityImage.a.a(this, 0, ((u)localObject1).aAL(), ((u)localObject1).aAK(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(193628);
              paramAnonymousDialogInterface = new u("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.ivw.aAK(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.zd(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.oC(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              RegByMobileAutoVerifyUI localRegByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileAutoVerifyUI.this.getContext();
              RegByMobileAutoVerifyUI.this.getString(2131755906);
              RegByMobileAutoVerifyUI.a(localRegByMobileAutoVerifyUI, h.b(localAppCompatActivity, RegByMobileAutoVerifyUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(193627);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(193627);
                }
              }));
              AppMethodBeat.o(193628);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(193629);
              RegByMobileAutoVerifyUI.o(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(193629);
            }
          }, new SecurityImage.b()
          {
            public final void aIs()
            {
              AppMethodBeat.i(193630);
              RegByMobileAutoVerifyUI.this.hideVKB();
              u localu = new u("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.ivw.aAK(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              localu.zd(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              localu.oC(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.g.aeS().a(localu, 0);
              AppMethodBeat.o(193630);
            }
          });
          AppMethodBeat.o(193649);
          return;
        }
        this.ivs.b(0, ((u)paramn).aAL(), ((u)paramn).aAK(), "");
        AppMethodBeat.o(193649);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.ivj;
    com.tencent.mm.kernel.a.unhold();
    com.tencent.mm.kernel.a.dz(true);
    if (this.ivp)
    {
      paramn = b.aio() + "temp.avatar";
      localObject2 = b.aio() + "temp.avatar.hd";
      i.lD(paramn, (String)localObject2);
      i.deleteFile(paramn);
      f.c((String)localObject2, 96, 96, Bitmap.CompressFormat.JPEG, 90, paramn);
      new com.tencent.mm.ak.n(this, b.aio() + "temp.avatar").a(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(193631);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.ivw.aAU());
          ay.gNa.aD("login_user_name", paramString);
          i.deleteFile(b.aio() + "temp.avatar");
          Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(193631);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193632);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.ivw.aAU());
          ay.gNa.aD("login_user_name", paramString);
          Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(193632);
        }
      });
      AppMethodBeat.o(193649);
      return;
    }
    this.dgo = ((u)localObject1).aAU();
    ay.gNa.aD("login_user_name", paramString);
    paramString = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
    paramString.addFlags(67108864);
    paramString.putExtra("LauncherUI.enter_from_reg", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.plugin.b.a.aUz("RE900_100");
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    paramString = paramString.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R200_600") + ",4");
    AppMethodBeat.o(193649);
    return;
    com.tencent.mm.plugin.account.a.a.hYu.a(this, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(193649);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void x(final Bundle paramBundle)
  {
    AppMethodBeat.i(193647);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193638);
        String str = paramBundle.getString("session", "");
        if ((!bt.isNullOrNil(str)) && (str.equals(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this))))
        {
          str = paramBundle.getString("token", "");
          ad.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", new Object[] { str });
          if (!bt.isNullOrNil(str))
          {
            RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, str);
            AppMethodBeat.o(193638);
            return;
          }
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dJp = 3;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dUs = 2;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aBj();
          if (RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this) != null) {
            RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
          }
          h.a(RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(2131762320), "", RegByMobileAutoVerifyUI.this.getString(2131755792), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(193637);
              RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(193637);
            }
          });
        }
        AppMethodBeat.o(193638);
      }
    });
    AppMethodBeat.o(193647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI
 * JD-Core Version:    0.7.0.1
 */