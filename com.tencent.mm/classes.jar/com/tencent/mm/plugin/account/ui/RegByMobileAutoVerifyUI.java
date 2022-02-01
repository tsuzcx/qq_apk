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
import com.tencent.mm.al.f;
import com.tencent.mm.g.b.a.jw;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import com.tencent.mm.view.CheckBoxLicenseView;

public class RegByMobileAutoVerifyUI
  extends MMActivity
  implements f, a.a
{
  private String countryCode;
  private String dpf;
  private String dzn;
  private String gOx;
  private String jmq;
  private int jnh;
  private String joA;
  private String joB;
  private boolean joC;
  private int joD;
  private ProgressDialog joE;
  private SecurityImage joF;
  private jw joG;
  private String jox;
  private String joy;
  private String joz;
  
  public RegByMobileAutoVerifyUI()
  {
    AppMethodBeat.i(207132);
    this.joD = 2;
    this.joG = new jw();
    AppMethodBeat.o(207132);
  }
  
  private void aUp()
  {
    AppMethodBeat.i(207136);
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).getMobileToken(this.joz, this.gOx, this);
    this.joE = h.b(this, getString(2131756503), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(207126);
        ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this));
        RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
        AppMethodBeat.o(207126);
      }
    });
    AppMethodBeat.o(207136);
  }
  
  public int getLayoutId()
  {
    return 2131495236;
  }
  
  public void initView()
  {
    AppMethodBeat.i(207134);
    final Button localButton = (Button)findViewById(2131302852);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207123);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this) != 2) {
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207123);
          return;
          RegByMobileAutoVerifyUI.c(RegByMobileAutoVerifyUI.this);
        }
      }
    });
    CheckBoxLicenseView localCheckBoxLicenseView = (CheckBoxLicenseView)findViewById(2131303933);
    localCheckBoxLicenseView.setTermTip(getString(2131762325));
    localCheckBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(207124);
        if (paramAnonymousBoolean)
        {
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dPT = 1;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aLk();
        }
        localButton.setEnabled(paramAnonymousBoolean);
        AppMethodBeat.o(207124);
      }
    });
    ((TextView)findViewById(2131303934)).setText(getString(2131762322, new Object[] { this.jox }));
    ((TextView)findViewById(2131303941)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207125);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dPT = 2;
        RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aLk();
        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207125);
      }
    });
    AppMethodBeat.o(207134);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(207135);
    this.joG.dPT = 4;
    this.joG.aLk();
    super.onBackPressed();
    AppMethodBeat.o(207135);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(207133);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dzn = getIntent().getStringExtra("Key_Mobile");
    this.countryCode = getIntent().getStringExtra("Key_CountryCode");
    this.jox = (this.countryCode + this.dzn);
    this.joy = getIntent().getStringExtra("Key_Seq");
    this.gOx = getIntent().getStringExtra("Key_Url");
    this.jmq = getIntent().getStringExtra("Key_reg_sessionId");
    this.joz = (System.currentTimeMillis() + "_" + this.joy);
    this.joA = getIntent().getStringExtra("kintent_nickname");
    this.joB = getIntent().getStringExtra("kintent_password");
    this.jnh = getIntent().getIntExtra("key_reg_style", 1);
    this.joC = getIntent().getBooleanExtra("kintent_hasavatar", false);
    ad.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile (%s,%s), seq %s, verifyUrl %s, regNickname %s, hasSetAvatar %s", new Object[] { this.countryCode, this.dzn, this.joy, this.gOx, this.joA, Boolean.valueOf(this.joC) });
    initView();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(207114);
        RegByMobileAutoVerifyUI.this.onBackPressed();
        AppMethodBeat.o(207114);
        return true;
      }
    });
    this.joG.eeE = System.currentTimeMillis();
    paramBundle = this.joG;
    paramBundle.eCy = paramBundle.t("DeviceID", com.tencent.mm.compatible.deviceinfo.q.aaB(), true);
    paramBundle = this.joG;
    paramBundle.eCx = paramBundle.t("RegisterMobile", this.jox, true);
    com.tencent.mm.kernel.g.aiU().a(126, this);
    com.tencent.mm.kernel.g.aiU().a(145, this);
    AppMethodBeat.o(207133);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(207138);
    super.onDestroy();
    ((com.tencent.mm.plugin.mobile.verify.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.mobile.verify.a.a.class)).removeCallback(this.joz);
    com.tencent.mm.kernel.g.aiU().b(126, this);
    com.tencent.mm.kernel.g.aiU().b(145, this);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    AppMethodBeat.o(207138);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(207139);
    ad.i("MicroMsg.RegByMobileAutoVerifyUI", "scene %s, onSceneEnd: errType %d, errCode %d, errMsg %s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.joE != null)
    {
      this.joE.dismiss();
      this.joE = null;
    }
    int i;
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).KR();
      ad.i("MicroMsg.RegByMobileAutoVerifyUI", "BindMobileForReg OpCode %d", new Object[] { Integer.valueOf(i) });
      if (i == 14) {
        if (paramInt2 == 0)
        {
          this.joD = ((com.tencent.mm.modelfriend.a)paramn).aHz();
          ad.i("MicroMsg.RegByMobileAutoVerifyUI", "mobile check type %d", new Object[] { Integer.valueOf(this.joD) });
          if (this.joD == 2)
          {
            paramn = ((com.tencent.mm.modelfriend.a)paramn).aHC();
            this.joy = paramn.joy;
            this.gOx = paramn.url;
            this.joz = (System.currentTimeMillis() + "_" + this.joy);
            aUp();
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
          paramn = com.tencent.mm.h.a.uz(paramString);
          if ((paramn == null) || (!paramn.a(this, null, null))) {
            break;
          }
          AppMethodBeat.o(207139);
          return;
          if (this.joD == 1)
          {
            this.joG.dPT = 3;
            this.joG.emu = 2;
            this.joG.aLk();
            localObject1 = ((com.tencent.mm.modelfriend.a)paramn).aHB();
            paramn = ((com.tencent.mm.modelfriend.a)paramn).aHA();
            localObject2 = new Intent(this, RegByMobileSendSmsUI.class);
            ((Intent)localObject2).putExtra("regsession_id", this.jmq);
            ((Intent)localObject2).putExtra("key_reg_style", 1);
            ((Intent)localObject2).putExtra("from_mobile", this.jox);
            ((Intent)localObject2).putExtra("to_mobile", (String)localObject1);
            ((Intent)localObject2).putExtra("verify_code", paramn);
            ((Intent)localObject2).putExtra("kintent_nickname", this.joA);
            ((Intent)localObject2).putExtra("kintent_password", this.joB);
            ((Intent)localObject2).putExtra("kintent_hasavatar", this.joC);
            paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramn.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            this.joG.dPT = 3;
            this.joG.emu = 2;
            this.joG.aLk();
            i = ((com.tencent.mm.modelfriend.a)paramn).aHE();
            int j = ((com.tencent.mm.modelfriend.a)paramn).aHF();
            paramn = new Intent();
            paramn.putExtra("bindmcontact_mobile", this.jox);
            paramn.putExtra("bindmcontact_shortmobile", this.dzn);
            paramn.putExtra("couttry_code", this.countryCode);
            paramn.putExtra("mobileverify_countdownsec", i);
            paramn.putExtra("mobileverify_countdownstyle", j);
            paramn.putExtra("kintent_hasavatar", this.joC);
            paramn.putExtra("kintent_nickname", this.joA);
            paramn.putExtra("kintent_password", this.joB);
            paramn.putExtra("key_reg_style", this.jnh);
            paramn.putExtra("regsession_id", this.jmq);
            paramn.putExtra("mobile_verify_purpose", 2);
            startActivity(MobileVerifyUI.class, paramn);
            finish();
            continue;
            if (paramInt2 == -41)
            {
              h.l(this, 2131762328, 2131762329);
              AppMethodBeat.o(207139);
              return;
            }
            if (paramInt2 == -34)
            {
              h.c(this, getString(2131756462), "", true);
              AppMethodBeat.o(207139);
              return;
              if (i == 15)
              {
                paramn = (com.tencent.mm.modelfriend.a)paramn;
                this.dpf = paramn.aHw();
                if (paramInt2 == 0)
                {
                  this.joG.dPT = 3;
                  this.joG.emu = 1;
                  this.joG.aLk();
                  if (this.jnh == 1)
                  {
                    com.tencent.mm.kernel.g.aiU().a(126, this);
                    paramn = new u("", this.joB, this.joA, 0, "", this.jox, "", "", this.dpf, 1, "", "", "", true, this.joC);
                    paramn.Gn(this.jmq);
                    paramn.pT(this.joD);
                    com.tencent.mm.kernel.g.aiU().a(paramn, 0);
                    getString(2131755906);
                    this.joE = h.b(this, getString(2131762385), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                      {
                        AppMethodBeat.i(207130);
                        com.tencent.mm.kernel.g.aiU().a(paramn);
                        com.tencent.mm.kernel.g.aiU().b(126, RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(207130);
                      }
                    });
                  }
                  else
                  {
                    localObject1 = new Intent();
                    ((Intent)localObject1).putExtra("regsetinfo_ticket", this.dpf);
                    ((Intent)localObject1).putExtra("regsetinfo_user", this.jox);
                    ((Intent)localObject1).putExtra("regsession_id", this.jmq);
                    ((Intent)localObject1).putExtra("mobile_check_type", 1);
                    ((Intent)localObject1).putExtra("regsetinfo_ismobile", 4);
                    ((Intent)localObject1).putExtra("regsetinfo_NextControl", paramn.aHD());
                    ((Intent)localObject1).putExtra("key_reg_style", this.jnh);
                    ((Intent)localObject1).setClass(this, RegSetInfoUI.class);
                    paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)paramn.mq(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                }
                else if (paramInt2 == -35)
                {
                  this.joG.dPT = 3;
                  this.joG.emu = 2;
                  this.joG.aLk();
                  localObject1 = com.tencent.mm.h.a.uz(paramString);
                  if (localObject1 != null) {
                    ((com.tencent.mm.h.a)localObject1).a(this, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(207131);
                        com.tencent.mm.kernel.g.aiU().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.g.aiU().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.aHv());
                        AppMethodBeat.o(207131);
                      }
                    }, null);
                  } else {
                    h.a(this, getString(2131756444), null, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(207115);
                        com.tencent.mm.kernel.g.aiU().a(701, RegByMobileAutoVerifyUI.this);
                        com.tencent.mm.kernel.g.aiU().a(252, RegByMobileAutoVerifyUI.this);
                        RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, paramn.getUsername(), paramn.aHv());
                        AppMethodBeat.o(207115);
                      }
                    }, null);
                  }
                }
                else if (paramInt2 == -212)
                {
                  this.joG.dPT = 3;
                  this.joG.emu = 2;
                  this.joG.aLk();
                  localObject1 = new Intent(this, MobileLoginOrForceReg.class);
                  ((Intent)localObject1).putExtra("ticket", this.dpf);
                  ((Intent)localObject1).putExtra("moble", this.jox);
                  ((Intent)localObject1).putExtra("regsession_id", this.jmq);
                  ((Intent)localObject1).putExtra("next_controll", paramn.aHD());
                  ((Intent)localObject1).putExtra("username", paramn.getUsername());
                  ((Intent)localObject1).putExtra("password", paramn.aHv());
                  ((Intent)localObject1).putExtra("nickname", paramn.aHJ());
                  ((Intent)localObject1).putExtra("avatar_url", paramn.aHI());
                  ((Intent)localObject1).putExtra("mobile_check_type", this.joD);
                  ((Intent)localObject1).putExtra("kintent_hasavatar", this.joC);
                  ((Intent)localObject1).putExtra("kintent_nickname", this.joA);
                  ((Intent)localObject1).putExtra("kintent_password", this.joB);
                  ((Intent)localObject1).putExtra("key_reg_style", this.jnh);
                  paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  startActivity((Intent)paramn.mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else
                {
                  if ((paramInt2 == -449) || (paramInt2 == -450) || (paramInt2 == -451))
                  {
                    this.joG.dPT = 3;
                    this.joG.emu = 2;
                    this.joG.aLk();
                    h.a(this, getString(2131762320), "", getString(2131755792), false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                      {
                        AppMethodBeat.i(207116);
                        RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
                        AppMethodBeat.o(207116);
                      }
                    });
                    AppMethodBeat.o(207139);
                    return;
                  }
                  this.joG.dPT = 3;
                  this.joG.emu = 2;
                  this.joG.aLk();
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
        if (this.joF == null)
        {
          this.joF = SecurityImage.a.a(this, 0, ((u)localObject1).aKM(), ((u)localObject1).aKL(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(207118);
              paramAnonymousDialogInterface = new u("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.joJ.aKL(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.Gn(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              paramAnonymousDialogInterface.pT(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              RegByMobileAutoVerifyUI localRegByMobileAutoVerifyUI = RegByMobileAutoVerifyUI.this;
              AppCompatActivity localAppCompatActivity = RegByMobileAutoVerifyUI.this.getContext();
              RegByMobileAutoVerifyUI.this.getString(2131755906);
              RegByMobileAutoVerifyUI.a(localRegByMobileAutoVerifyUI, h.b(localAppCompatActivity, RegByMobileAutoVerifyUI.this.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(207117);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(207117);
                }
              }));
              AppMethodBeat.o(207118);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(207119);
              RegByMobileAutoVerifyUI.o(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(207119);
            }
          }, new SecurityImage.b()
          {
            public final void aSv()
            {
              AppMethodBeat.i(207120);
              RegByMobileAutoVerifyUI.this.hideVKB();
              u localu = new u("", RegByMobileAutoVerifyUI.h(RegByMobileAutoVerifyUI.this), RegByMobileAutoVerifyUI.i(RegByMobileAutoVerifyUI.this), 0, "", RegByMobileAutoVerifyUI.j(RegByMobileAutoVerifyUI.this), "", "", RegByMobileAutoVerifyUI.k(RegByMobileAutoVerifyUI.this), 1, "", this.joJ.aKL(), RegByMobileAutoVerifyUI.l(RegByMobileAutoVerifyUI.this).getSecImgCode(), true, RegByMobileAutoVerifyUI.m(RegByMobileAutoVerifyUI.this));
              localu.Gn(RegByMobileAutoVerifyUI.n(RegByMobileAutoVerifyUI.this));
              localu.pT(RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this));
              com.tencent.mm.kernel.g.aiU().a(localu, 0);
              AppMethodBeat.o(207120);
            }
          });
          AppMethodBeat.o(207139);
          return;
        }
        this.joF.b(0, ((u)paramn).aKM(), ((u)paramn).aKL(), "");
        AppMethodBeat.o(207139);
        return;
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = this.jox;
    com.tencent.mm.kernel.a.unhold();
    com.tencent.mm.kernel.a.dB(true);
    if (this.joC)
    {
      paramn = com.tencent.mm.loader.j.b.asc() + "temp.avatar";
      localObject2 = com.tencent.mm.loader.j.b.asc() + "temp.avatar.hd";
      i.mA(paramn, (String)localObject2);
      i.deleteFile(paramn);
      com.tencent.mm.sdk.platformtools.g.c((String)localObject2, 156, 156, Bitmap.CompressFormat.JPEG, 90, paramn);
      new com.tencent.mm.ak.n(this, com.tencent.mm.loader.j.b.asc() + "temp.avatar").a(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(207121);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.joJ.aKV());
          az.hFS.aM("login_user_name", paramString);
          i.deleteFile(com.tencent.mm.loader.j.b.asc() + "temp.avatar");
          Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$15", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(207121);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207122);
          RegByMobileAutoVerifyUI.b(RegByMobileAutoVerifyUI.this, this.joJ.aKV());
          az.hFS.aM("login_user_name", paramString);
          Object localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(RegByMobileAutoVerifyUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileAutoVerifyUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileAutoVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_600") + ",4");
          RegByMobileAutoVerifyUI.this.finish();
          AppMethodBeat.o(207122);
        }
      });
      AppMethodBeat.o(207139);
      return;
    }
    this.dpf = ((u)localObject1).aKV();
    az.hFS.aM("login_user_name", paramString);
    paramString = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
    paramString.addFlags(67108864);
    paramString.putExtra("LauncherUI.enter_from_reg", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileAutoVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    com.tencent.mm.plugin.b.a.Ma("RE900_100");
    paramString = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    paramString = paramString.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_600") + ",4");
    AppMethodBeat.o(207139);
    return;
    com.tencent.mm.plugin.account.a.a.iRH.a(this, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(207139);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void y(final Bundle paramBundle)
  {
    AppMethodBeat.i(207137);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207128);
        String str = paramBundle.getString("session", "");
        if ((!bt.isNullOrNil(str)) && (str.equals(RegByMobileAutoVerifyUI.f(RegByMobileAutoVerifyUI.this))))
        {
          str = paramBundle.getString("token", "");
          ad.i("MicroMsg.RegByMobileAutoVerifyUI", "reg, get mobile token %s", new Object[] { str });
          if (!bt.isNullOrNil(str))
          {
            RegByMobileAutoVerifyUI.a(RegByMobileAutoVerifyUI.this, str);
            AppMethodBeat.o(207128);
            return;
          }
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).dPT = 3;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).emu = 2;
          RegByMobileAutoVerifyUI.d(RegByMobileAutoVerifyUI.this).aLk();
          if (RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this) != null) {
            RegByMobileAutoVerifyUI.g(RegByMobileAutoVerifyUI.this).dismiss();
          }
          h.a(RegByMobileAutoVerifyUI.this, RegByMobileAutoVerifyUI.this.getString(2131762320), "", RegByMobileAutoVerifyUI.this.getString(2131755792), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(207127);
              RegByMobileAutoVerifyUI.e(RegByMobileAutoVerifyUI.this);
              AppMethodBeat.o(207127);
            }
          });
        }
        AppMethodBeat.o(207128);
      }
    });
    AppMethodBeat.o(207137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileAutoVerifyUI
 * JD-Core Version:    0.7.0.1
 */